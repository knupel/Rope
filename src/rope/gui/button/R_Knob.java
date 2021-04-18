/**
* R_Knob
* Processing 3.5.4
* @author @stanlepunk
* @see https://github.com/StanLepunK/Rope
* v 1.1.2
* 2019-2021
*/
package rope.gui.button;

import rope.R_State.State;
import rope.gui.R_Mol;
import rope.vector.vec2;

public class R_Knob extends R_Button {
  private R_Mol molette;
  private boolean init_molette_is = false;

  private boolean open_knob = true;
  private boolean out_is = false;

  private float angle_min = PI -(PI/4);
  private float angle_max = PI/4;
  private int drag_direction = CIRCULAR;
  private float drag_force = 0.1f;
  private vec2 size_limit = new vec2(-3,3);
  
  public R_Knob(vec2 pos, float size) {
    super("Knob", pos, new vec2(size));
    this.molette = new R_Mol();
  }
  
  public R_Knob(String type, vec2 pos, float size) {
    super(type, pos, new vec2(size));
    this.molette = new R_Mol();
  }


  public R_Knob set_molette(int molette_type) {
    this.molette.set_shape_type(molette_type);
    return this;
  }


  // set size
  public R_Knob set_value(float pos_norm) {
    float v = map(pos_norm,0,1,0,TAU);
    v = constrain_value(v);
    molette.angle(v);
    init_molette_is = false;
    return this;
  }

  public R_Knob set_size_limit(float min, float max) {
    this.size_limit.set(min,max);
    return this;
  }

  
  public R_Knob set_size_molette(vec2 size) {
    set_size_molette(size.x(),size.y());
    return this;
  }

  public R_Knob set_size_molette(float s) {
    set_size_molette(s,s);
    return this;
  }

  public R_Knob set_size_molette(float w, float h) {
    molette.size(w,h);
    return this;
  }


  public R_Knob set_distance_molette(float dist) {
    molette.set_distance(dist);
    return this;
  }

  public R_Knob set_drag(int direction) {
    if(direction == VERTICAL) {
      drag_direction = VERTICAL;
    } else if(direction == CIRCULAR) {
      drag_direction = CIRCULAR;
    } else {
      drag_direction = HORIZONTAL;
    }
    return this;
  }

  public R_Knob set_drag_force(float force) {
    this.drag_force = force;
    return this;
  }



  public R_Knob set_fill_molette(int c) {
    set_fill_molette(c,c);
    return this;
  }

  public R_Knob set_fill_molette(int c_in, int c_out) {
    this.molette.set_fill_in(c_in);
    this.molette.set_fill_out(c_out);
    return this;
  }
  
  public R_Knob set_stroke_molette(int c) {
    set_stroke_molette(c,c);
    return this;
  }

  public R_Knob set_stroke_molette(int c_in, int c_out) {
    this.molette.set_stroke_in(c_in);
    this.molette.set_stroke_out(c_out);
    return this;
  }

  public R_Knob set_thickness_molette(float thickness) {
    this.molette.set_thickness(thickness);
    return this;
  }


  public R_Knob set_range(float min, float max) {
    this.angle_min = min;
    this.angle_max = max;
    return this;
  }

  public R_Knob limit(boolean open_knob) {
    this.open_knob = !open_knob;
    return this;
  }


  // get
  /**
   * for the future when there is more molette
   */
  public float get(int index) {
    return molette.angle();
  }

  public float get() {
    return molette.angle();
  }




  
  // show
  // public void show_structure() {
  //   show();
  // }

  public void show_limit() {
    boolean on_off_is = true;
    if(!open_knob) {
      strokeWeight(1);
      int c = 0;
      if(on_off_is) {
        if (is) {
          if (inside() && auth_rollover) {
            c = stroke_out_ON; 
          } else {
            c = stroke_in_ON;
          }
        } else {
          if (inside() && auth_rollover) {
            c = stroke_out_OFF; 
          } else {
            c = stroke_in_OFF;
          }
        }
        stroke(c);
      } else {
        stroke(c);
      }
      vec2 final_pos = pos.copy().add(size.copy().mult(0.5f));
      float radius = size.x()*0.5f;
      vec2 a_min = projection(angle_min,radius+size_limit.min()).add(final_pos);
      vec2 b_min = projection(angle_min,radius+size_limit.max()).add(final_pos);
      line(a_min,b_min);

      vec2 a_max = projection(angle_max,radius+size_limit.min()).add(final_pos);
      vec2 b_max = projection(angle_max,radius+size_limit.max()).add(final_pos);
      line(a_max,b_max);
    }
  }


  public void show_molette() {
    if(!init_molette_is) {
      molette.pos(projection(molette.angle(),molette.get_distance()));
      init_molette_is = true;
    }
    molette.show();
  }

  public void show_struct_pie() {
    aspect_impl(true);
    vec2 buf_pos = pos.copy().add(size.x() /2, size.y() / 2);
    arc(buf_pos,size,0,molette.angle(),PIE);
  }




  // misc
  public void update() {
    boolean new_event = all(State.env().event.a(),State.env().event.b(), State.env().event.c());
    update(State.env().pointer.x(),State.env().pointer.y(),new_event);
  }
  
  @Deprecated public void update(float x, float y) {
    boolean new_event = all(State.env().event.a(),State.env().event.b(), State.env().event.c());
    update(x,y,new_event);
  }


  public void update(float x, float y, boolean event) {
    cursor(x,y);
    molette_update(event);
    use_event_is = false;
  }
  

  // molette
  void molette_update(boolean event) {
    if(!use_event_is) {
      use_event_is = true;
      this.event = event;
    }

    molette.set_offset(pos.copy().add(size.copy().mult(0.5f)));
    boolean bang_is = any(State.env().bang.a(), State.env().bang.b(), State.env().bang.c());
    boolean inside_is = molette.inside(cursor);
    boolean used_is = all(inside_is,bang_is);

    molette.inside_is(inside_is);
    if(used_is && this.event) {
      molette.used(true);
    }
    if(!this.event) {
      molette.used(false);
      previous_angle_ref = molette.angle();
      ref_angle_is = false;
      out_is = false;
    }
    if(molette.used_is()) {
      molette_update_position();
    }

  }



  float previous_angle_ref;
  float next_angle_ref;
  boolean ref_angle_is = false;
  private void molette_update_position() {
    float angle = 0;
    // calc angle
    angle = calc_angle(angle);
    if(!out_is) render_molette(angle);
  }

  private float calc_angle(float angle) {
    if(drag_direction == HORIZONTAL) {
      angle = cursor.x() * drag_force;
    } else if(drag_direction == CIRCULAR) {
      vec2 temp = pos.copy().add(size.copy().mult(0.5f));
      angle = temp.angle(cursor);
      if(angle < 0) {
        angle+= TAU;
      }
    } else if(drag_direction == VERTICAL) {
      angle = cursor.y() * drag_force;
    }
    return angle;
  }

  private void render_molette(float angle) {
    if(drag_direction != CIRCULAR) {
      if(!ref_angle_is) {
        next_angle_ref = angle;
        ref_angle_is = true;
      }
      float new_angle = previous_angle_ref + (angle -next_angle_ref);
      new_angle = constrain_value(new_angle);
      molette.angle(new_angle);
      molette.pos(projection(new_angle,molette.get_distance()));
    } else if(drag_direction == CIRCULAR) {
      angle = constrain_value(angle);
      molette.angle(angle);
      molette.pos(projection(angle,molette.get_distance()));
    }
  }

  private float constrain_value(float angle) {
    if(!open_knob) {
      angle = abs(angle)%TAU;
      if(angle_min > angle_max) {
        if(angle < angle_min && angle > angle_max) {
          out_is = true;
          angle = closer(angle, angle_min, angle_max);
        } else {
          out_is = false;
        }
      } else {
        if(angle < angle_min) {
          out_is = true;
          angle = angle_min;
        } else {
          out_is = false;
        }
        if(angle > angle_max) {
          out_is = true;
          angle = angle_max;
        } else {
          out_is = false;
        }
      }
    }
    return angle;
  }

  private float closer(float val, float a, float b) {
    float diff_a = abs(val-a);
    float diff_b = abs(val-b);
    if(diff_a > diff_b) {
      return b;
    } else {
      return a;
    }
  }

}