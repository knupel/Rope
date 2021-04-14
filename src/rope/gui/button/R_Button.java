/**
* CLASS BUTTON 
* Processing 3.5.4
* @author @stanlepunk
* @see https://github.com/StanLepunK/Rope
* v 2.2.1
* 2013-2021
*/
package rope.gui.button;

import rope.R_State.State;
import processing.core.PImage;
import rope.gui.Crope;
import rope.vector.bvec2;
import rope.vector.vec2;

public class R_Button extends Crope {
  protected int color_bg = GRAY[2];

  protected int color_on_off = GRAY[10];

  protected int color_in_ON = GRAY[10];
  protected int color_out_ON = GRAY[18];

  protected int color_in_OFF = fill_in;
  protected int color_out_OFF = fill_out;

  protected PImage [] pic;

  protected int kind = ELLIPSE;
  protected bvec2 bangbang = new bvec2(false);
  protected boolean auth_rollover;
  protected boolean is = false;  

  public vec2 offset;

  public R_Button(String type, vec2 pos, vec2 size) {
    super(type, pos, size); 
  }


  public R_Button(vec2 pos, vec2 size) {
    super("Button", pos, size);
  }

  public R_Button(String type, float x, float y, float sx, float sy) {
    super(type, x, y, sx, sy);
  }


  public R_Button(float x, float y, float sx, float sy) {
    super("Button", x, y, sx, sy);
  }

  public void set_kind(int kind) {
    this.kind = kind;
  }


  public void is(boolean is) {
    this.is = is;
  }

  public void switch_is() {
    this.is = !this.is;
  }
  
  public boolean is() {
    return this.is;
  }
  

  public R_Button set_colour_in_on(int c) {
    this.color_in_ON = c;
    return this;
  }

  public R_Button set_colour_out_on(int c) {
    this.color_out_ON = c;
    return this;
  }


  public R_Button set_colour_in_off(int c) {
    this.color_in_OFF = c;
    return this;
  }


  public R_Button set_colour_out_off(int c) {
    this.color_out_OFF = c;
    return this;
  }
  

  public float get() {
    if(is) return 1;
    else return 0;
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
    boolean event = button_event_is();
    update(State.pointer().x(),State.pointer().y(),event);
  }
  

  private void update(float x, float y, boolean event) {
    cursor(x,y);
    if(event) {
      switch_is();
      bangbang.set(false);
    }
  }

  
  protected boolean button_event_is() {
    boolean event = all(State.env().event.a(), State.env().event.b(), State.env().event.c());
    boolean event_bang = any(State.env().bangbang.a(), State.env().bangbang.b(), State.env().bangbang.c());
    return all(inside(),all(event_bang,event));
	}

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
  public void show_structure() {
    show(true);
  }

  public void show(boolean on_off_is) {
    if(this.kind == RECT) {
      aspect(on_off_is);
      rect(new vec2(pos), new vec2(size));
    } else if(this.kind == ELLIPSE) {
      aspect(on_off_is);
      vec2 final_size = new vec2(size);
      vec2 final_pos = new vec2(pos).add(final_size.copy().mult(0.5f));
      ellipse(final_pos,final_size);
    }
  }

  public void show_structure(PImage [] pic) {
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

  @Deprecated public void show() {
    show(ELLIPSE,true);
  }

  @Deprecated public void show(int kind, boolean on_off_is) {
    this.kind = kind;
    if(this.kind == RECT) {
      aspect(on_off_is);
      rect(new vec2(pos), new vec2(size));
    } else if(this.kind == ELLIPSE) {
      aspect(on_off_is);
      vec2 final_size = new vec2(size);
      vec2 final_pos = new vec2(pos).add(final_size.copy().mult(0.5f));
      ellipse(final_pos,final_size);
    }
  }


  public void show_value(float value) {
    String message = "[ ";
    float f = truncate(value,2);
    message += f;
    message += " ]";
    show_value_impl(message);
  }

  public void show_value() {
    show_value(get());
  }

  private void aspect(boolean on_off_is) {
    noStroke();
    if(on_off_is) {
      if (is) {
        if (inside() && auth_rollover) {
          color_on_off = color_in_ON; 
        } else {
          color_on_off = color_out_ON;
        }
      } else {
        if (inside() && auth_rollover) {
          color_on_off = color_in_OFF; 
        } else {
          color_on_off = color_out_OFF;
        }
      }
      fill(color_on_off);
    } else {
      fill(color_bg);
    }  
  }
}




