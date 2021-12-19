/**
* R_Knob
* @author Knupel / Stanislas Marçais
* @see https://github.com/StanLepunK/Rope
* v 2.0.0
* 2019-2021
*/
package rope.gui.button;
import java.util.Arrays;

import rope.R_State.State;
import rope.gui.R_Mol;
import rope.vector.vec2;
import rope.tool.R_Fov;

public class R_Knob extends R_Button {
  protected R_Mol [] molette;
  protected R_Mol guide;
  // angle start and end for the limit knob
  protected R_Fov limit;
  protected float limit_offset_ang = 0;
  private boolean use_limit_is = true;
  // private float threshold = 0.1f;

  private boolean init_molette_is;
  private boolean mol_used_is;

  // private float constrain_angle;
  private float previous_angle_ref;
  private float next_angle_ref;

  private boolean cross_border = false;

  private int drag_direction = CIRCULAR;
  private float drag_force = 0.1f;
  private vec2 size_limit = new vec2(-3,3);

  public R_Knob() {
    super("Knob");
    init();
  }

  public R_Knob(String type) {
    super(type);
    init();
  }
  
  public R_Knob(vec2 pos, float size) {  
    super("Knob", pos, new vec2(size));
    init();
  }
  
  public R_Knob(String type, vec2 pos, float size) {
    super(type, pos, new vec2(size));
    init();
  }


  private void init() {
    set_value(0.5f); // default > one molette > half position
    set_limit(0,TAU);
    init_guide();
  }

  /**
   * overwrite the Parent method, to set the guide
   * @param size set the diameter of knob
   * @return this
   */
  public R_Knob size(float size) {
    size(new vec2(size));
    init_guide();
    return this;
  }


  /**
   * @param pos_norm must be a normal position from 0 to 1, where 1 is like 2PI
   * @return this
   * */
  public R_Knob set_value(float pos_norm) {
    float [] arr = { pos_norm };
    set_value(arr);
    return this;
  }
  
  /**
  * @param pos_norm must be an array of normal positions from 0 to 1, where 1 is like 2PI
  * @return this
  */
  public R_Knob set_value(float... pos_norm) {
    set_value_calc(pos_norm);
    init_molette_is = false;
    return this;
  }

  protected void set_value_calc(float... pos_norm) {
    Arrays.sort(pos_norm);
		init_molette(pos_norm.length);
    for(int i = 0 ; i < molette.length ; i++) {
      float ang = map(pos_norm[i],0,1,0,TAU);
      if(!use_limit_is) {
        ang = constrain_angle(i, ang);
      }
      molette[i].angle(ang);
    }
  }

  /**
   * Work with set_fov()
   * @param offset_angle define the direction in radiant of your knob
   * @return this
   */
  public R_Knob set_offset(float offset_angle) {
    this.limit_offset_ang = offset_angle;
    return this;
  }

  private float get_offset() {
    return this.limit_offset_ang;
  }




  private float get_start() {
    return this.limit.get_start() + get_offset();
  }

  private float get_stop() {
    return this.limit.get_stop() + get_offset();
  }

    /**
   * Function to set the opening angle of your knob, by default the angle if from 0 to 2PI (TAU)
   * @param min angle in radian, must be lower than max, if not the value is reversed
   * @param max angle in radian, must be upper than min, if not the value is reversed
   * @return this
   */
  public R_Knob set_fov(float min, float max) {
    min = to_2pi(min);
    max = to_2pi(max);

    if(this.limit == null) {
      this.limit = new R_Fov(min, max);
      return this;
    }
    this.limit.set(min, max);
    return this;
  }


  /**
   * @deprecated instead used set_fov()
   * @param angle_a start angle
   * @param angle_b stop angle
   * @return this
   */
  @Deprecated public R_Knob set_limit(float angle_a, float angle_b) {
    return set_fov(angle_a, angle_b);
  }

  /**
   * @deprecated instead used set_fov()
   * @param angle_a
   * @param angle_b
   * @return
   */
  @Deprecated public R_Knob set_range(float angle_a, float angle_b) {
    return set_fov(angle_a, angle_b);
  }



    /**
   * 
   * @param use_limit_is
   * @return
   */
  public R_Knob use_limit(boolean use_limit_is) {
    this.use_limit_is = !use_limit_is;
    return this;
  }

  /**
   * @deprecated instead use use_limit(boolean is)
   * @param open_knob
   * @return
   */
  @Deprecated public R_Knob limit(boolean open_knob) {
    use_limit(open_knob);
    return this;
  }

  public R_Knob set_size_limit(float min, float max) {
    if(min > max) {
      this.size_limit.set(max,min);
      return this;
    }
    this.size_limit.set(min,max);
    return this;
  }







  /**
   * MOLETTE
   */
  protected void init_guide() {
    if(this.guide == null) {
      this.guide = new R_Mol();
      this.guide.inside_is = false;
      this.guide.size(this.size.x()/4);
      this.guide.used_is = false;
    } else {
      this.guide.inside_is = false;
      this.guide.size(this.size.x()/4);
      this.guide.used_is = false;
    }
  }

  protected void init_molette(int len) {
		if(molette == null || len != molette.length) {
			molette = new R_Mol[len];
      for(int i = 0 ; i < len ; i++) {
        this.molette[i] = new R_Mol();
        this.molette[i].size(this.size.x()/4);
        this.molette[i].id = 0;
        this.molette[i].used_is = false;
        this.molette[i].inside_is = false;
      }
		}
	}


  public R_Knob set_type_mol(int molette_type) {
    for(int i = 0 ; i < molette.length ; i++) {
      this.molette[i].set_shape_type(molette_type);
    }
    return this;
  }
  
  public R_Knob set_size_mol(vec2 size) {
    return set_size_mol(size.x(),size.y());
  }

  public R_Knob set_size_mol(float size) {
    return set_size_mol(size,size);
  }

  public R_Knob set_size_mol(float w, float h) {
    for(int i = 0 ; i < molette.length ; i++) {
      this.molette[i].size(w,h);
    }
    return this;
  }

  public R_Knob set_dist_mol(float dist) {
    for(int i = 0 ; i < molette.length ; i++) {
      this.molette[i].set_dist(dist);
    }
    return this;
  }


  /**
   * GUIDE
   */

  public R_Knob set_dist_guide(float dist) {
    this.guide.set_dist(dist);
    return this;
  }

  public R_Knob set_size_guide(float size) {
    return set_size_guide(size,size);
  }

  public R_Knob set_size_guide(float w, float h) {
    this.guide.size(w,h);
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




  // ASPECT MOLETTE and GUIDE

  public R_Knob set_fill_mol(int c) {
    set_fill_mol(c,c);
    return this;
  }

  public R_Knob set_fill_mol(int c_in, int c_out) {
    for(int i = 0 ; i < molette.length ; i++) {
      this.molette[i].set_fill_in(c_in);
      this.molette[i].set_fill_out(c_out);
    }
    this.guide.set_fill_in(c_in);
    this.guide.set_fill_out(c_out);
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
    this.guide.set_stroke_in(c_in);
    this.guide.set_stroke_out(c_out);
    return this;
  }

  public R_Knob set_thickness_mol(float thickness) {
    for(int i = 0 ; i < molette.length ; i++) {
      this.molette[i].set_thickness(thickness);
    }
    this.guide.set_thickness(thickness);
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

  public R_Mol [] get_mol() {
    R_Mol [] arr_mol = new R_Mol[this.molette.length + 1];
    int index = 0;
    while(index < this.molette.length) {
      arr_mol[index] = this.molette[index];
      index++;
    }
    arr_mol[index] = this.guide;
    return arr_mol;
  }

  public R_Mol get_mol(int index) {
    R_Mol [] arr = get_mol();
    if(index > 0 && index < arr.length) {
      return arr[index];
    }
    return null;
  }



  
  // show
  public void show_limit() {
    boolean on_off_is = true;
    if(use_limit_is) {
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
      vec2 a_min = projection(this.get_start(),radius+size_limit.min()).add(final_pos);
      vec2 b_min = projection(this.get_start(),radius+size_limit.max()).add(final_pos);
      line(a_min,b_min);
      vec2 a_max = projection(this.get_stop(),radius+size_limit.min()).add(final_pos);
      vec2 b_max = projection(this.get_stop(),radius+size_limit.max()).add(final_pos);    
      line(a_max,b_max);
    }
  }


  public void show_mol() {
    for(int i = 0 ; i < molette.length ; i++) {
      if(!init_molette_is) {
       this.molette[i].pos(projection(this.molette[i].angle(), this.molette[i].get_dist()));
      }
      this.molette[i].show();
    }
    init_molette_is = true;
  }

  public void show_guide() {
    if(molette.length > 1) {
      vec2 offset = add(this.pos, this.size().copy().div(2));
      this.guide.pos(projection(this.guide.angle(), this.guide.get_dist()).add(offset));
      this.guide.show();
    }
  }

    public void show_struc_pie() {
    aspect_impl(true);
    vec2 buf_pos = pos.copy().add(size.x() /2, size.y() / 2);
    int index_a = 0;
    int index_b = molette.length -1;
    
    if(molette.length > 1 && show_struc_pie_impl(buf_pos, index_a, index_b)) {
      return;
    }
    arc(buf_pos,size,0,this.molette[index_a].angle(),PIE);
    return; 
  }

  private boolean show_struc_pie_impl(vec2 buf_pos, int index_a, int index_b) {
    float ang_a = this.molette[index_a].angle();
    float ang_b = this.molette[index_b].angle();
    float comp_a = ang_a - get_offset();
    float comp_b = ang_b - get_offset();
    if(comp_a < 0) comp_a += TAU;
    if(comp_b < 0) comp_b += TAU;
    // compute
    if(comp_a > comp_b) {
      if(ang_a > ang_b) {
        arc(buf_pos, this.size, ang_b, ang_a, PIE);
      } else {
        arc(buf_pos, this.size, ang_b, ang_a + TAU, PIE);
      }
    } else {
      if(ang_a > ang_b) {
        arc(buf_pos, this.size, ang_a, ang_b + TAU, PIE);
      } else {
        arc(buf_pos, this.size, ang_a, ang_b, PIE);
      }
    }
    return true;
  }
  



  // update
  public void update() {
    boolean new_event = all(State.env().event.a(),State.env().event.b(), State.env().event.c());
    update(State.env().pointer.x(),State.env().pointer.y(),new_event);
  }
  
  /**
   * @deprecated instead use void updae()
   * @param x pos x
   * @param y pos y
   */
  @Deprecated public void update(float x, float y) {
    boolean new_event = all(State.env().event.a(),State.env().event.b(), State.env().event.c());
    update(x,y,new_event);
  }

  /**
   * 
   * @param x
   * @param y
   * @param event
   */
  private void update(float x, float y, boolean event) {
    cursor(x,y);
    this.event = event;
    boolean bang_is = any(State.env().bang.a(), State.env().bang.b(), State.env().bang.c());
    guide_update(bang_is);
    molette_update(bang_is);
  }




  // guide molette update
  private void guide_update(boolean bang_is) {
    boolean inside_is = this.guide.inside(cursor);
    boolean used_is = all(inside_is, bang_is, !mol_used_is);
    this.guide.inside_is(inside_is);
    if(this.event) {
      if(used_is) {
        this.guide.used(true);
        mol_used_is = true;
      }
    } else {
      this.guide.used(false);
    }

    if(this.guide.used_is()) {
      float angle = calc_angle_imp(this.guide.angle());
      float dif = angle - this.guide.angle();
      molette_update_from_guide(dif);
      render_mol(this.guide, angle);
    } else {
      guide_update_from_molette();
      mol_used_is = false;
    }
  }

  private void guide_update_from_molette() {
    float angle = 0;
    boolean [] beyond_list = beyond_limit(this.get_start());
    boolean beyond = only(beyond_list);
    
    for(int i = 0 ; i < molette.length ; i++) {
      float ang_mol = this.molette[i].angle();
      if(all(beyond,beyond_list[i])) {
        ang_mol += TAU; 
      }
      angle += ang_mol;
    }
    angle /= molette.length;
    this.guide.angle(angle);
  }

  private void molette_update_from_guide(float dif_angle) {
    for(int i = 0; i < molette.length ; i++) {
      float ref_angle = molette[i].angle();
      float new_angle = ref_angle + dif_angle;
      if(this.use_limit_is) {
        new_angle = constrain_angle(i, new_angle);
      }
      this.render_mol(this.molette[i], new_angle);
    }
  }



  // molette update
  private void molette_update(boolean bang_is) {
    for(int i = 0 ; i < molette.length ; i++) {
      this.molette[i].set_offset(pos.copy().add(size.copy().mult(0.5f)));
      boolean inside_is = this.molette[i].inside(cursor);
      boolean used_is = all(inside_is, bang_is, !mol_used_is);

      this.molette[i].inside_is(inside_is);
      if(used_is && this.event) {
        this.molette[i].used(true);
        mol_used_is = true;
      }
      if(!this.event) {
        this.molette[i].used(false);
        previous_angle_ref = this.molette[i].angle();
      }

      if(this.molette[i].used_is()) {
        float buf_angle = calc_angle(i, this.molette[i].angle());
        render_mol(this.molette[i], buf_angle);
      } else {
        mol_used_is = false;
      }
      // finalize
      float angle = constrain_angle(i, molette[i].angle());
      molette[i].angle(angle);
    }
  }





  private void render_mol(R_Mol mol, float angle) {
    if(drag_direction != CIRCULAR) {
      float new_angle = previous_angle_ref + (angle -next_angle_ref);
      mol.angle(new_angle);
      mol.pos(projection(new_angle, mol.get_distance()));
    } else if(drag_direction == CIRCULAR) {
      mol.angle(angle);
      mol.pos(projection(angle, mol.get_distance()));
    }
  }



  /**
  * MISC
  */
  private boolean [] beyond_limit(float limit) {
    boolean [] beyond_limit_is = new boolean[molette.length];
    for(int i = 0 ; i < molette.length ; i++) {
      beyond_limit_is[i] = molette[i].angle() >= limit;
    }
    return beyond_limit_is;
  }



  private float calc_angle(int index, float angle) {
    angle = calc_angle_imp(angle);
    if(this.use_limit_is) {
      angle = constrain_angle(index, angle);
    }
    return angle;
  }


  private float calc_angle_imp(float angle) {
    if(drag_direction == HORIZONTAL) {
      angle = cursor.x() * drag_force;
    } else if(drag_direction == CIRCULAR) {
      vec2 temp = pos.copy().add(size.copy().mult(0.5f));

      angle = temp.angle(cursor); // return value from -PI to PI
      if(angle < 0) {
        angle+= TAU;
      }
    } else if(drag_direction == VERTICAL) {
      angle = cursor.y() * drag_force;
    }
    return angle;
  }

  // PROBLEM when the sum of the Offset and the get_stop() is inferior to TAU



  private float constrain_angle(int index, float angle) {
    float buf = angle + this.get_offset();
    check_cross_border(this.molette[index].prev_angle(), angle, 0.5f);

    if(cross_border_is()) {
      print_out("BANG BANG BANG BANG BANG");
      cross_border_is(false);
    }


    if(buf < this.get_start() || buf > this.get_stop() ) {
      return this.molette[index].prev_angle();
    } else {
      this.molette[index].prev_angle(angle);
      return angle;
    }
    
    // float buf = angle + this.get_offset();
    // if(buf < this.get_start()) {
    //   return this.get_start();
    // }
    // if(after_zero_after_stop(angle)) {
    //   return closer_value(angle, to_2pi(this.get_stop()), this.get_start());
    // }

    // if(buf > this.get_stop() && this.get_offset() <= 0) {
    //   return closer_value(angle, to_2pi(this.get_stop()), this.get_start());
    // }
    // return angle;
  }

  // utils
  private void check_cross_border(float ang_prev, float ang, float threshold) {
    if(abs(ang - ang_prev) > threshold) {
      cross_border_is(true);
    }
  }

  private void cross_border_is(boolean cross_border) {
    this.cross_border = cross_border;
  }

  private boolean cross_border_is() {
    return this.cross_border;
  }


  private float to_2pi(float angle) {
    if(angle < 0) angle += TAU;  
		if(angle > TAU) angle -= TAU;
		return angle;
  }


  private boolean after_zero_after_stop(float angle) {
    return (angle >= to_2pi(this.get_stop()) && angle < this.get_offset());
  }


  private float closer_value(float angle, float a, float b) {
    float res = 0;
    float dif_a = abs(angle - a);
    float dif_b = abs(angle - b);

    if(dif_b > dif_a) {
      res = a;
    } else {
      res = b;
    }

    print_out("--------ANGLE",angle);
    print_out("AAAAA",a);
    print_out("DIF A",dif_a);
    print_out("BBBBB",b);
    print_out("DIF B",dif_b);
    print_out("-----RESULTAT",res,"\n");
    return res;


    // return dif_b > dif_a ? a : b;
  }

}