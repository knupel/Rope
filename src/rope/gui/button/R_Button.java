/**
* CLASS BUTTON 
* v 2.0.0
* 2013-2021
*/
package rope.gui.button;

import rope.R_State.State;
import processing.core.PImage;
import rope.gui.Crope;
import rope.vector.vec2;

public class R_Button extends Crope {
  protected int color_bg = GRAY[2];

  protected int color_on_off = GRAY[10];

  protected int color_in_ON = GRAY[10];
  protected int color_out_ON = GRAY[18];

  protected int color_in_OFF = fill_in;
  protected int color_out_OFF = fill_out;

  protected PImage [] pic;

  protected boolean authorization;
  protected boolean is = false;  

  public vec2 offset;

  protected R_Button() {
    super("Button");
  }

  private R_Button(String type) {
    super(type);
  }

  private R_Button(String type, vec2 pos, vec2 size) {
    super(type);
    this.pos(pos);
    this.size(size); 
  }


  public R_Button(vec2 pos, vec2 size) {
    super("Button");
    this.pos(pos);
    this.size(size);
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
  
  
  /*
  @Deprecated
  public R_Button set_aspect_on_off(int color_in_ON, int color_out_ON, int color_in_OFF, int color_out_OFF) {
    set_colour_in_on(color_in_ON);
    set_colour_in_off(color_in_OFF);
    set_colour_out_on(color_out_ON);
    set_colour_out_off(color_out_OFF);
    return this;
  }
  */





  public float get() {
    if(is) return 1;
    else return 0;
  }

  
  // misc
  public void update() {
    update(State.pointer().x(),State.pointer().y());
  }
  
  
  private void update(float x, float y) {
    cursor(x,y);
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




  

  public void rollover(boolean authorization) {
    this.authorization = authorization;
  }
  



  // SHOW
  public void show() {
    show(ELLIPSE,true);
  }

  public void show(int kind, boolean on_off_is) {
    if(kind == RECT) {
      aspect(on_off_is);
      rect(new vec2(pos), new vec2(size));
    } else if(kind == ELLIPSE) {
      aspect(on_off_is);
      vec2 final_size = new vec2(size);
      vec2 final_pos = new vec2(pos).add(final_size.copy().mult(0.5f));
      ellipse(final_pos,final_size);
    }
  }


  public void show(PImage [] pic) {
    int offset_x = -1 ;
    if(pic.length == 4) {
      if (is) {
        if (inside() && authorization) {
          // inside
          image(pic[0],pos.x() +offset_x, pos.y()); 
        } else {
          // outside
          image(pic[1],pos.x() +offset_x, pos.y());
        }
      } else {
        if (inside() && authorization) {
          // inside
          image(pic[2],pos.x() +offset_x, pos.y()); 
        } else {
          // outside
          image(pic[3],pos.x() +offset_x, pos.y());
        }
      }
    }
  }


  public void show_label() {
    if(this.name != null) {
      if (is) {
        if (inside() && authorization) {
          color_on_off = color_in_ON; 
        } else {
          color_on_off = color_out_ON;
        }
      } else {
        if (inside() && authorization) {
          color_on_off = color_in_OFF; 
        } else {
          color_on_off = color_out_OFF;
        }
      }
      
      if(pos_label == null) {
        pos_label = new vec2();
      }
      // display text
      if(font != null) textFont(font);
      if(font_size > 0) textSize(font_size);
      textAlign(align_label_name);
      fill(color_on_off);
      text(this.name,add(pos,pos_label));
    }  
  }

  public void show_value(float value) {
    if(this.name != null) {
       textAlign(align_label_value);
       if(font != null) textFont(font);
       if(font_size > 0) textSize(font_size);
       if(inside(RECT)) {
        fill(color_label_in);
      } else {
        fill(color_label_out);
      }

      String message = "[ ";
      float f = truncate(value,2);
      message += f;
      message += " ]";
      text(message,add(pos,pos_value));
    }
  }

  public void show_value() {
    show_value(get());
  }





  private void aspect(boolean on_off_is) {
    noStroke();
    if(on_off_is) {
      if (is) {
        if (inside() && authorization) {
          color_on_off = color_in_ON; 
        } else {
          color_on_off = color_out_ON;
        }
      } else {
        if (inside() && authorization) {
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




