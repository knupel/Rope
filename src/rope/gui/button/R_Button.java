/**
* CLASS BUTTON 
* @author Knupel / Stanislas Marçais
* @see https://github.com/StanLepunK/Rope
* v 2.7.0
* 2013-2021
*/
package rope.gui.button;

import processing.core.PImage;
import rope.gui.Crope;
import rope.utils.R_State.State;
import rope.vector.bvec2;
import rope.vector.vec2;

public class R_Button extends Crope {
  // protected int color_on_off = State.env().gui_but_fill_in_on;

  protected int fill_in_ON = State.env().gui_but_fill_in_on;
  protected int fill_out_ON = State.env().gui_but_fill_out_on;

  protected int fill_in_OFF = State.env().gui_but_fill_in_off;
  protected int fill_out_OFF = State.env().gui_but_fill_out_off;

  protected int stroke_in_ON = State.env().gui_but_stroke_in_on;
  protected int stroke_out_ON = State.env().gui_but_stroke_out_on;

  protected int stroke_in_OFF = State.env().gui_but_stroke_in_off;
  protected int stroke_out_OFF = State.env().gui_but_stroke_out_off;



  protected PImage [] pic;

  protected int kind = ELLIPSE;
  protected bvec2 bangbang = new bvec2(false);
  protected boolean auth_rollover;
  protected boolean is = false;  
  protected float value;

  public vec2 offset;

  public R_Button() {
    super("Button");
  }

  public R_Button(vec2 pos, vec2 size) {
    super("Button", pos, size);
    set_thickness(State.env().gui_but_thickness);
  }

  public R_Button(float x, float y, float sx, float sy) {
    super("Button", x, y, sx, sy);
    set_thickness(State.env().gui_but_thickness);
  }

  protected R_Button(String type) {
    super(type);
  }

  protected R_Button(String type, vec2 pos, vec2 size) {
    super(type, pos, size); 
  }

  protected R_Button(String type, float x, float y, float sx, float sy) {
    super(type, x, y, sx, sy);
    set_thickness(State.env().gui_but_thickness);
  }


  public void set_kind(int kind) {
    this.kind = kind;
  }

  /**
   * SET VALUE
   */

  /**
   * 
   * @param is
   * @return
   */
  public R_Button set_value(boolean is) {
    this.value = is ? 1 : 0;
    this.is = is;
    return this;
  }

  public R_Button set_value(float value) {
    this.value = value;
    if(value == 0) {
      this.is = false;
    } else {
      this.is = true;
    }
    return this;
  }


  public void is(boolean is) {
    if(is) {
      this.value = 1;
    } else {
      this.value = 0;
    }
    this.is = is;
  }

  public void switch_is() {
    this.is = !this.is;
    if(this.is) {
      this.value = 1;
    } else {
      this.value = 0;
    }
  }
  
  /**
   * GET VALUE
   * 
   */

  public boolean is() {
    return this.is;
  }

  public float get() {
    return this.value;
  }
  
  // fill
    /**
   * set fill color of your gui
   * @param colour
   * @return
   */
  public R_Button set_fill(int colour) {
    set_fill_in_on(colour);
    set_fill_out_on(colour);
    set_fill_in_off(colour);
    set_fill_out_off(colour);
    return this;
  }

  /**
   * set fill color of your gui
   * @param colour_in
   * @param colour_out
   * @return
   */
  public R_Button set_fill(int colour_in, int colour_out) {
    set_fill_in_on(colour_in);
    set_fill_out_on(colour_out);
    set_fill_in_off(colour_in);
    set_fill_out_off(colour_out);
    return this;
  }

  // fill on

  public R_Button set_fill_in_on(int c) {
    this.fill_in_ON = c;
    return this;
  }

  public R_Button set_fill_out_on(int c) {
    this.fill_out_ON = c;
    return this;
  }

  // fill off

  public R_Button set_fill_in_off(int c) {
    this.fill_in_OFF = c;
    return this;
  }


  public R_Button set_fill_out_off(int c) {
    this.fill_out_OFF = c;
    return this;
  }

  // STROKE
    /**
   * set stroke color of your gui
   * @param colour
   * @return
   */
  public R_Button set_stroke(int colour) {
    set_stroke_in_on(colour);
    set_stroke_out_on(colour);
    set_stroke_in_off(colour);
    set_stroke_out_off(colour);
    return this;
  }

  /**
   * set fill color of your gui
   * @param colour_in
   * @param colour_out
   * @return
   */
  public R_Button set_stroke(int colour_in, int colour_out) {
    set_stroke_in_on(colour_in);
    set_stroke_out_on(colour_out);
    set_stroke_in_off(colour_in);
    set_stroke_out_off(colour_out);
    return this;
  }

  // stroke on

  public R_Button set_stroke_in_on(int c) {
    this.stroke_in_ON = c;
    return this;
  }

  public R_Button set_stroke_out_on(int c) {
    this.stroke_out_ON = c;
    return this;
  }

  // stroke off

  public R_Button set_stroke_in_off(int c) {
    this.stroke_in_OFF = c;
    return this;
  }


  public R_Button set_stroke_out_off(int c) {
    this.stroke_out_OFF = c;
    return this;
  }

  




  public void update() {
    if(State.env().pointer == null) {
			print_err("Static State.env().pointer is null, maybe you forget to use: State.pointer(float x, float y)");
			System.exit(0);
		}
    if(State.env().event_mut == null) {
			print_err("Static State.env().event_mut is null, maybe you forget to use: State.event(boolean... event)");
			System.exit(0);
		}
    this.update(State.pointer().x(),State.pointer().y());
    if(!label_is) {
      init_pos_label();
      label_is = true;
    }
  }

  private void update(float x, float y) {
    cursor(x,y);
    boolean other_event = any(State.env().bangbang.a(), State.env().bangbang.b(), State.env().bangbang.c());
    event_impl(other_event);
    // this.event = button_event_is();
    if(this.event) {
      // print_out("button this.event",State.get_dna_current_crope(), "bang", other_event, this.event, pa.frameCount);
      switch_is();
      bangbang.set(false);
    }
  }

  
  // protected boolean button_event_is() {
  //   boolean event = all(State.env().event.a(), State.env().event.b(), State.env().event.c());
  //   boolean event_bang = any(State.env().bangbang.a(), State.env().bangbang.b(), State.env().bangbang.c());
  //   return all(inside(),all(event_bang,event));
	// }

  /**
  * offset
  */
  public void offset(float x, float y) {
    if(offset == null) {
      this.offset = new vec2(x,y);
    } else {
      this.offset.set(x,y);
    }
  }

  public void offset_is(boolean display_button) {
    if(!display_button) {
      pos.set(-100) ; 
    } else {
      pos.set(pos_ref);
      pos.add(offset);
    }
  }


  public void rollover(boolean auth_rollover) {
    this.auth_rollover = auth_rollover;
  }
  
  // SHOW
  public void show_struc() {
    show();
  }

  public void show() {
    if(this.kind == RECT) {
      aspect_impl(false);
      rect(new vec2(pos), new vec2(size));
    } else if(this.kind == ELLIPSE) {
      aspect_impl(false);
      vec2 final_size = new vec2(size);
      vec2 final_pos = new vec2(pos).add(final_size.copy().mult(0.5f));
      ellipse(final_pos,final_size);
    }
  }

  public void show_struc(PImage [] pic) {
    int offset_x = -1 ;
    if(pic.length == 4) {
      if (is) {
        if (inside() && auth_rollover) {
          image(pic[0],pos.x() +offset_x, pos.y()); 
        } else {
          image(pic[1],pos.x() +offset_x, pos.y());
        }
      } else {
        if (inside() && auth_rollover) {
          image(pic[2],pos.x() +offset_x, pos.y()); 
        } else {
          image(pic[3],pos.x() +offset_x, pos.y());
        }
      }
    }
  }

  @Deprecated public void show(PImage [] pic) {
    int offset_x = -1 ;
    if(pic.length == 4) {
      if (is) {
        if (inside() && auth_rollover) {
          image(pic[0],pos.x() +offset_x, pos.y()); 
        } else {
          image(pic[1],pos.x() +offset_x, pos.y());
        }
      } else {
        if (inside() && auth_rollover) {
          image(pic[2],pos.x() +offset_x, pos.y()); 
        } else {
          image(pic[3],pos.x() +offset_x, pos.y());
        }
      }
    }
  }

  @Deprecated public void show(int kind, boolean on_off_is) {
    this.kind = kind;
    if(this.kind == RECT) {
      aspect_impl(false);
      rect(new vec2(pos), new vec2(size));
    } else if(this.kind == ELLIPSE) {
      aspect_impl(false);
      vec2 final_size = new vec2(size);
      vec2 final_pos = new vec2(pos).add(final_size.copy().mult(0.5f));
      ellipse(final_pos,final_size);
    }
  }


  public void show_value(float... value) {
    String message = "[ ";
    for(int i = 0 ; i < value.length ; i++) {
      float f = truncate(value[i],2);
      if(i == value.length -1) {
        message += (f + " ]");
      } else {
        message += (f + ", ");
      }
    }
    show_value_impl(message);
  }

  public void show_value() {
    show_value(get());
  }


  protected void aspect_impl(boolean reverse_is) {
    int f_in_on = fill_in_ON;
    int f_out_on =fill_out_ON;
    int s_in_on = stroke_in_ON;
    int s_out_on =stroke_out_ON;

    int f_in_off = fill_in_OFF;
    int f_out_off = fill_out_OFF;
    int s_in_off = stroke_in_OFF;
    int s_out_off = stroke_out_OFF;

    if(reverse_is) {
      f_in_off = fill_in_ON;
      f_out_off = fill_out_ON;
      s_in_off = stroke_in_ON;
      s_out_off =stroke_out_ON;

      f_in_on = fill_in_OFF;
      f_out_on = fill_out_OFF;
      s_in_on = stroke_in_OFF;
      s_out_on = stroke_out_OFF;
    }

    if(thickness <= 0) {
      noStroke();
      if (is) {
        if (inside() && auth_rollover) {
          fill(f_in_on); 
        } else {
          fill(f_out_on);
        }
      } else {
        if (inside() && auth_rollover) {
          fill(f_in_off); 
        } else {
          fill(f_out_off);
        }
      }
    } else {
      if (is) {
        if (inside() && auth_rollover) {
          fill(f_in_on);
          stroke(s_in_on); 
        } else {
          fill(f_out_on);
          stroke(s_out_on); 
        }
      } else {
        if (inside() && auth_rollover) {
          fill(f_in_off);
          stroke(s_in_off); 
        } else {
          fill(f_out_off);
          stroke(s_out_off);
        }
      }
    }
  }
}




