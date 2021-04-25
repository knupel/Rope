/**
* R_Knob
* Processing 3.5.4
* @author @stanlepunk
* @see https://github.com/StanLepunK/Rope
* v 1.3.0
* 2019-2021
*/
package rope.gui.button;

import java.util.Arrays;

import rope.R_State.State;
import rope.gui.R_Mol;
import rope.vector.bvec2;
import rope.vector.vec2;

public class R_Knob extends R_Button {
  protected R_Mol [] molette;
  private boolean init_molette_is = false;
  private bvec2 mol_limit_is;
  private float previous_angle_ref;
  private float next_angle_ref;

  private float angle_min = PI -(PI/4);
  private float angle_max = PI/4;

  private boolean open_knob = true;
  private boolean out_is = false;



  private int drag_direction = CIRCULAR;
  private float drag_force = 0.1f;
  private vec2 size_limit = new vec2(-3,3);
  
  public R_Knob(vec2 pos, float size) {
    
    super("Knob", pos, new vec2(size));
    set_value(0.5f); // default > one molette > half position
  }
  
  public R_Knob(String type, vec2 pos, float size) {
    super(type, pos, new vec2(size));
    set_value(0.5f); // default > one molette > half position
  }


  public R_Knob set_mol(int molette_type) {
    for(int i = 0 ; i < molette.length ; i++) {
      this.molette[i].set_shape_type(molette_type);
    }
    return this;
  }


  // set size

  public R_Knob set_value(float pos_norm) {
    float [] arr = { pos_norm };
    set_value(arr);
    return this;
  }
  
  public R_Knob set_value(float... pos_norm) {
    set_value_calc(pos_norm);
    mol_limit_is = new bvec2(false);
    init_molette_is = false;
    return this;
  }

  protected void set_value_calc(float... pos_norm) {
    Arrays.sort(pos_norm);
		init_molette(pos_norm.length);
    for(int i = 0 ; i < molette.length ; i++) {
      float v = map(pos_norm[i],0,1,0,TAU);
      v = constrain_value(v);
      molette[i].angle(v);
    }
  }

  protected void init_molette(int len) {
		if(molette == null || len != molette.length) {
			molette = new R_Mol[len];
      for(int i = 0 ; i < len ; i++) {
        molette[i] = new R_Mol();
        this.molette[i].size(this.size.x()/4);
        molette[i].id = 0;
        molette[i].used_is = false;
        molette[i].inside_is = false;
      }
		}
	}

  public R_Knob set_size_limit(float min, float max) {
    this.size_limit.set(min,max);
    return this;
  }

  
  public R_Knob set_size_mol(vec2 size) {
    return set_size_mol(size.x(),size.y());
  }

  public R_Knob set_size_mol(float s) {
    return set_size_mol(s,s);
  }

  public R_Knob set_size_mol(float w, float h) {
    for(int i = 0 ; i < molette.length ; i++) {
      this.molette[i].size(w,h);
    }
    return this;
  }


  public R_Knob set_dist_mol(float dist) {
    for(int i = 0 ; i < molette.length ; i++) {
      this.molette[i].set_distance(dist);
    }
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



  public R_Knob set_fill_mol(int c) {
    set_fill_mol(c,c);
    return this;
  }

  public R_Knob set_fill_mol(int c_in, int c_out) {
    for(int i = 0 ; i < molette.length ; i++) {
      this.molette[i].set_fill_in(c_in);
      this.molette[i].set_fill_out(c_out);
    }
    return this;
  }
  
  public R_Knob set_stroke_mol(int c) {
    set_stroke_mol(c,c);
    return this;
  }

  public R_Knob set_stroke_mol(int c_in, int c_out) {
    for(int i = 0 ; i < molette.length ; i++) {
      this.molette[i].set_stroke_in(c_in);
      this.molette[i].set_stroke_out(c_out);
    }
    return this;
  }

  public R_Knob set_thickness_mol(float thickness) {
    for(int i = 0 ; i < molette.length ; i++) {
      this.molette[i].set_thickness(thickness);
    }
    return this;
  }






  /**
   * 
   * @param open_knob
   * @return
   */
  public R_Knob limit(boolean open_knob) {
    this.open_knob = !open_knob;
    return this;
  }


  /**
   * 
   * @param angle_min
   * @param angle_max
   * @return
   */
  public R_Knob set_limit(float angle_min, float angle_max) {
    this.angle_min = angle_min;
    this.angle_max = angle_max;
    return this;
  }

  @Deprecated public R_Knob set_range(float min, float max) {
    this.angle_min = min;
    this.angle_max = max;
    return this;
  }




  // get
  /**
   * for the future when there is more molette
   */
  public float get(int index) {
    if(index >= 0 && index < molette.length)
      return this.molette[index].angle();
    return Float.NaN;
  }

  public float get() {
    return get(0);
  }

  public float [] get_all() {
    float [] value_array = new float[this.molette.length];
    for(int i = 0 ; i < value_array.length ; i++) {
			value_array[i] = get(i);
		}
    return value_array;
  }



  
  // show
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


  public void show_mol() {
    for(int i = 0 ; i < molette.length ; i++) {
      if(!init_molette_is) {
        this.molette[i].pos(projection(this.molette[i].angle(), this.molette[i].get_distance()));
      }
      this.molette[i].show();
    }
    init_molette_is = true;
  }

  public void show_struc_pie() {
    aspect_impl(true);
    vec2 buf_pos = pos.copy().add(size.x() /2, size.y() / 2);
    float ang_a = this.molette[0].angle();
    if(molette.length > 1) {
      float ang_b = this.molette[molette.length -1].angle();
      if(ang_a < ang_b) {
        arc(buf_pos,size,ang_a, ang_b, PIE);
      } else {
        arc(buf_pos,size,ang_b, ang_a, PIE);
      }
    } else {
      arc(buf_pos,size,0,ang_a,PIE);      
    }
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
    mol_update(event);
  }
  

  // molette
  private void mol_update(boolean event) {
    this.event = event;

    for(int i = 0 ; i < molette.length ; i++) {
      this.molette[i].set_offset(pos.copy().add(size.copy().mult(0.5f)));
      boolean bang_is = any(State.env().bang.a(), State.env().bang.b(), State.env().bang.c());
      boolean inside_is = this.molette[i].inside(cursor);
      boolean used_is = all(inside_is,bang_is);

      this.molette[i].inside_is(inside_is);
      if(used_is && this.event) {
        this.molette[i].used(true);
      }
      if(!this.event) {
        this.molette[i].used(false);
        previous_angle_ref = this.molette[i].angle();
        ref_angle_is = false;
        out_is = false;
      }

      if(this.molette[i].used_is()) {
        mol_update_position(i);
      } else {
        mol_limit_is.set(false);
      }

      if(this.molette[i].angle() < angle_min) {
        this.molette[i].angle(angle_min);
      }

      if(this.molette[i].angle() > angle_max) {
        this.molette[i].angle(angle_max);
      }
    }
  }




  private boolean ref_angle_is = false;

  private void mol_update_position(int index) {
    float angle = this.molette[index].angle();
    float buf_angle = calc_angle(angle);
    float dif = abs(angle-buf_angle);
    if(any(mol_limit_is) && dif < 0.1) {
      angle = buf_angle;
    } else if(!all(mol_limit_is)) {
      angle = buf_angle;
    }
    
    if(!out_is) {
      render_molette(index, angle);
    }
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

    if(!this.open_knob) {
      if(angle < angle_min) {
        mol_limit_is.x(true);
        return angle_min;
      }
      if(angle > angle_max) {
        mol_limit_is.y(true);
        return angle_max;
      }
    }
    return angle;
  }

  private void render_molette(int index, float angle) {
    if(drag_direction != CIRCULAR) {
      if(!ref_angle_is) {
        next_angle_ref = angle;
        ref_angle_is = true;
      }
      float new_angle = previous_angle_ref + (angle -next_angle_ref);
      new_angle = constrain_value(new_angle);
      this.molette[index].angle(new_angle);
      this.molette[index].pos(projection(new_angle, this.molette[index].get_distance()));
    } else if(drag_direction == CIRCULAR) {
      angle = constrain_value(angle);
      this.molette[index].angle(angle);
      this.molette[index].pos(projection(angle, this.molette[index].get_distance()));
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