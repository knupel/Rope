/**
* R_Mol
* Control ROmanesco Processing Environment
* v 1.1.0
* Copyleft (c) 2018-2021

* dependencies
* Processing 3.5.4
* @author @stanlepunk
* @see https://github.com/StanLepunK/Rope
*/
package rope.gui;

// import processing.core.PApplet;
import rope.core.R_Graphic;
import rope.vector.vec2;
import rope.R_State.State;

public class R_Mol extends R_Graphic {
  public vec2 size = new vec2();
  public vec2 pos = new vec2();
  private vec2 offset;

  private float angle = 0;
  private float dist = 0;

  private float value = 0;
  public int id = 0;

  public int id_midi = -2;

  private int shape_type = ELLIPSE;

  public boolean select_is;
  public boolean used_is;
  public boolean inside_is;

  protected int fill_in = color(State.env().cx() * 0.4f);
  protected int fill_out = color(State.env().cx() * 0.2f);
  protected int stroke_in = fill_in;
  protected int stroke_out = fill_out;

  protected int fill_in_ON = color(State.env().cx() * 0.4f);
  protected int fill_out_ON = color(State.env().cx() * 0.2f);
  protected int stroke_in_ON = fill_in;
  protected int stroke_out_ON = fill_out;

  protected float thickness = 0;

  public R_Mol() {
  	super(State.pa());
  }
  

  public R_Mol set(float value) {
    this.value = value;
    return this;
  }

  public R_Mol size(float size) {
    return size(size, size);
  }

  public R_Mol size(float w, float h) {
    this.size.set(w,h);
    return this;
  }

  public R_Mol pos(float x, float y) {
    this.pos.set(x,y);
    return this;
  }

  public R_Mol pos(vec2 pos) {
    this.pos.set(pos);
    return this;
  }

  public R_Mol angle(float angle) {
    this.angle = angle;
    return this;
  }

  public R_Mol set_dist(float dist) {
    this.dist = dist;
    return this;
  }

  public R_Mol set_distance(float dist) {
    this.dist = dist;
    return this;
  }

  public R_Mol set_offset(vec2 offset) {
    if(this.offset == null) {
      this.offset = new vec2(offset);
    } else {
      this.offset.set(offset);
    }
    return this;
  }

  public R_Mol set_shape_type(int shape_type) {
    this.shape_type = shape_type;
    return this;
  }

  public R_Mol set_id_midi(int id_midi) {
    this.id_midi = id_midi;
    return this;
  }

  public R_Mol set_id(int id) {
    this.id = id;
    return this;
  }
  
  
  public R_Mol set_fill_in(int c) {
    this.fill_in = c;
    return this;
  }

  public R_Mol set_fill_out(int c) {
    this.fill_out = c;
    return this;   
  }

  public R_Mol set_stroke_in(int c) {
    this.stroke_in = c;
    return this;   
  }

  public R_Mol set_stroke_out(int c) {
    this.stroke_out = c;
    return this; 
  }

  public R_Mol set_thickness(float thickness){
    this.thickness = thickness;
    return this;
  }


  



  public void select(boolean state) {
    select_is = state;
  }

  public void used(boolean state) {
    used_is = state;
  }

  



  /**
  * get
  */
  public float get() {
    return value;
  }

  public vec2 pos() {
    return this.pos;
  }

  public vec2 size() {
    return this.size;
  }

  public float angle() {
    return this.angle;
  }

  public float get_dist() {
    return dist;
  }


  public float get_distance() {
    return dist;
  }

  public int get_shape_type() {
    return this.shape_type;
  }

  public int get_id() {
    return id;
  }

  public int get_midi() {
    return id_midi;
  }

  public boolean select_is() {
    return select_is;
  }

  public boolean used_is() {
    return used_is;
  }

  public boolean inside_is() {
    return inside_is;
  }


  //show
  public void show() {
    aspect(true);
    push();
    if(offset != null ) {
      translate(add(offset,pos));
    } else {
      translate(pos);
    }
    if(shape_type == ELLIPSE) {
      ellipse(new vec2(),size);
    } else if(shape_type == RECT) {
      rotate(angle);
      rect(size.copy().mult(0.5f).mult(-1),size);
    } else {
      ellipse(new vec2(),size);
    }
    pop();
  }
  private void aspect(boolean on_off) {
    if(thickness <= 0) {
      aspect_fill(on_off);
      noStroke();
    } else {
      aspect_stroke(on_off);
      aspect_fill(on_off);
    }
  }

  private void aspect_fill(boolean on_off) {
    if(on_off) {
      if(inside_is()) {
        if(select_is()) {
          fill(fill_in_ON);
        } else {
          fill(fill_in);
        }
      } else {
        if(select_is()) {
          fill(fill_out_ON);
        } else {
          fill(fill_out);
        }
      }
    } else {
      fill(fill_in);
    }
  }

  private void aspect_stroke(boolean on_off) {
    strokeWeight(thickness);
    if(on_off) {
      if(inside_is()) {
        if(select_is()) {
          stroke(stroke_in_ON);
        } else {
          stroke(stroke_in);
        }
      } else {
        if(select_is()) {
          stroke(stroke_out_ON);
        } else {
          stroke(stroke_out);
        }
      }
    } else {
      stroke(stroke_in);
    }
  }


  public void inside_is(boolean state) {
    inside_is = state;
  }

  public boolean inside(vec2 cursor) {
    vec2 temp_pos = pos;
    // if offset is use to catch the crope position
    if(offset != null) {
      temp_pos = pos.copy().add(offset);
    }

    if(shape_type == ELLIPSE) {
      if(temp_pos.dist(cursor) < size.x() * 0.5f) return true; 
      else return false ;
    } else {
      temp_pos.sub(size.copy().mult(0.5f));
      if(cursor.x() > temp_pos.x() && cursor.x() < temp_pos.x() +size.x() && 
         cursor.y() > temp_pos.y() && cursor.y() < temp_pos.y() +size.y()) return true; 
        else return false ;
    }
  }
}
