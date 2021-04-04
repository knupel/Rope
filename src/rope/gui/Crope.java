/**
* CROPE
* Control ROmanesco Processing Environment
* v 1.1.0
* Copyleft (c) 2018-2021

* dependencies
* Processing 3.5.4
* @author @stanlepunk
* @see https://github.com/StanLepunK/Rope
*/

package rope.gui;


import processing.core.PFont;
import processing.core.PGraphics;
import processing.opengl.PShader;
import rope.core.R_Graphic;
import rope.vector.vec;
import rope.vector.vec2;
import rope.vector.vec4;
import rope.R_State.State;

abstract public class Crope extends R_Graphic  {
  protected vec2 pos;
  protected vec2 size;
  protected vec2 pos_ref;
  protected vec2 cursor = new vec2();
  
  // var use to create the background of gui in opengl
  protected float root;
  protected boolean opengl_is = false;
  protected PShader shader;
  protected PGraphics pg;
  protected int mode = 0;
  // event
  protected boolean event;
  protected boolean use_event_is = false;
  // color
  protected int fill_in = GRAY[4];
  protected int fill_out = GRAY[10];
  protected int stroke_in = fill_in;
  protected int stroke_out = fill_out;
  protected float thickness = 0;
  
  protected int color_label_in = fill_in;
  protected int color_label_out = fill_out;

  protected float rounded = 0;
  // label + info
  protected int align_label_name = LEFT;
  protected int align_label_value = LEFT;
  protected String name = null;
  protected vec2 pos_label;
  protected vec2 pos_value;
  // font
  protected PFont font;
  protected int font_size;
  // id + dna
  protected int midi_value;
  protected int id_midi = -2 ;
  protected int id = -1;
  protected int dna = Integer.MIN_VALUE;

  private int rank;

  private String type = "Crope";
  protected int rollover_type = RECT;

  protected boolean crope_build_is = false;

  public Crope(String type, vec2 pos, vec2 size) {
  	super(State.pa());
    this.type = type;
    this.pos(pos);
		this.size(size);
		// opengl
		/*
		if(any(renderer_P3D(), renderer_P2D())) {
			shader = loadShader("shader/fx_color/palette.glsl");
			pg = createGraphics(size.x(),size.y(),get_renderer());
			opengl_is = true;
		}
		*/
		// font
		font_size = (int)State.pa().g.textSize;
		// id + dna
    dna = floor(random(Integer.MIN_VALUE,Integer.MAX_VALUE));
    if(dna == 0) dna = 1;
    // info label + info
    pos_label = new vec2(pos.x(),bottom() + font_size);
    pos_value = pos_label.copy().add_y(font_size);
  }







  /**
  set structure
  */
  public Crope pos(float x, float y) {
    pos(new vec2(x,y));
    return this;
  }

  public Crope pos(vec2 pos) {
    if(this.pos == null || !this.pos.equals(pos)) {
      if(this.pos == null) {
        this.pos = pos.copy();
        this.pos_ref = pos.copy();
      } else {
        this.pos.set(pos);
        this.pos_ref.set(pos);
      }
    }
    return this;
  }

  public Crope size(float size) {
    size(new vec2(size));
    return this;
  }
  
  public Crope size(float w, float h) {
    size(new vec2(w,h));
    return this;
  }

  public Crope size(vec2 size) {
    if(this.size == null || !this.size.equals(size)) {
      if(this.size == null) {
        this.size = size.copy();
      } else {
        this.size.set(size);
      }
    }
    return this;
  }


  /**
  private
  */
  protected void cursor(vec cursor) {
    cursor(cursor.x(),cursor.y());
  }

  protected void cursor(float x, float y) {
    if(cursor == null) {
      cursor = new vec2(x,y);
    } else {
      cursor.set(x,y);
    }
  }

  
  /**
  set colour
  */
  public Crope opengl(boolean is) {
  	opengl_is = is;
  	if(all(any(renderer_P3D(), renderer_P2D()),is)) {
			shader = loadShader("shader/fx_color/palette.glsl");
			pg = createGraphics(size.x(),size.y(),get_renderer());
			opengl_is = true;
		} else {
			opengl_is = false;
		}
  	return this;
  }
  

    /**
   * You can select different palette mode, with Processing classic renderer only mode 0 is available.
   * mode 0 : hue range
   * mode 3,4,5 RGB range
   * mode 10, 11,12, 13 all color hsb range.
   * @param mode give the opportunity to change the color randering
   * @return
   */
  public Crope set_mode(int mode) {
  	if(!opengl_is && mode != 0 && mode != 10) {
  		print_err("R_Palette set_mode(",mode,") is only available in P2D or P3D renderer\n"
  				+ "for the classic renderer only mode 0 and 10 is available");
  		System.exit(0);
  		return this;
  	}
  	this.mode = mode;
  	return this;
  }


  public Crope set_fill(int c) {
    set_fill(c,c);
    return this;
  }

  public Crope set_fill(int c_in, int c_out) {
    this.fill_in = c_in;
    this.fill_out = c_out;
    return this;
  }
  
  public Crope set_stroke(int c) {
    set_stroke(c,c);
    return this;
  }

  public Crope set_stroke(int c_in, int c_out) {
    this.stroke_in = c_in;
    this.stroke_out = c_out;
    return this;
  }

  public Crope set_thickness(float thickness) {
    this.thickness = thickness;
    return this;
  }


  public Crope set_aspect(int f_c, int s_c, float thickness) {
    set_fill(f_c,f_c);
    set_stroke(s_c,s_c);
    set_thickness(thickness);
    return this;
  }

  public Crope set_aspect(int f_c_in, int f_c_out, int s_c_in,  int s_c_out, float thickness) {
    set_fill(f_c_in,f_c_out);
    set_stroke(s_c_in,s_c_out);
    set_thickness(thickness);
    return this;
  }
  
  
	protected void gradient_spectrum(vec2 pos, vec2 size, boolean vert_is) {
		int ref_colorMode = State.env().cm();
		vec4 ref_colorMode_xyza = State.env().cxyza();
 		colorMode(HSB,1);
 		float step_x = 1.0f / this.size.x();
		float step_y = 1.0f / this.size.y();
 		for (float x = 0 ; x < 1.0 ; x += step_x) {
			for (float y = 0 ; y < 1.0 ; y += step_y) {
				int c = 0;
				if(!vert_is) {
					c = color(x, 1.0f , 1.0f);
				} else {
					c = color(y, 1.0f , 1.0f);
				}
				set((int)(x * size.x() + pos.x()), (int)(y * size.y() + pos.y()), c);
			}
		}
 		colorMode(ref_colorMode,ref_colorMode_xyza);	
	}
	
	protected void gradient_hue(float hue, vec2 pos, vec2 size) {
		int ref_colorMode = State.env().cm();
		vec4 ref_colorMode_xyza = State.env().cxyza();
 		colorMode(HSB,1);
 		float step_x = 1.0f / this.size.x();
		float step_y = 1.0f / this.size.y();
		for (float x = 0 ; x < 1.0 ; x += step_x) {
			for (float y = 0 ; y < 1.0 ; y += step_y) {
				int c = color(hue, x ,y);
				set((int)(x * size.x() + pos.x()), (int)(y * size.y() + pos.y()), c);
			}
		}	
 		colorMode(ref_colorMode,ref_colorMode_xyza);
	}







  public Crope set_rounded(float rounded) {
    this.rounded = rounded;
    return this;
  }

  /**
   * 
   *  LABEL
   * 
   * 
   */
  
  
   public Crope set_fill_label(int c) {
    set_fill_label(c,c);
    return this;
  }

  public Crope set_fill_label(int c_in, int c_out) {
    this.color_label_in = c_in;
    this.color_label_out = c_out;
    return this;
  }

  public Crope set_align_label_name(int align) {
    this.align_label_name = align;
    return this;
  }

  public Crope set_align_label_value(int align) {
    this.align_label_value = align;
    return this;
  }


  public Crope set_name(String name) {
    this.name = name;
    return this;
  }

  public Crope set_label(String name) {
    this.name = name;
    return this;
  }

  public Crope set_label(String name, float x, float y) {
    this.name = name;
    if(this.pos_label == null) {
      this.pos_label = new vec2(x,y);
    } else {
      this.pos_label.set(x,y);
    }
    return this;
  }
  
  public Crope set_label(String name, vec2 pos_label) {
    set_label(name, pos_label.x(), pos_label.y());
    return this;
  }

  public Crope set_pos_label(vec2 pos) {
    set_pos_label(pos.x(),pos.y());
    return this;
  }

  public Crope set_pos_label(float x, float y) {
    if(this.pos_label == null) {
      this.pos_label = new vec2(x,y);
    } else {
       this.pos_label.set(x,y);
    }
    return this;
  }
  
  public void show_label() {
  	 show_label_impl();
  }
  
  
  protected void show_label_impl() {
		if(this.name != null) {
			textAlign(align_label_name);
			if(font != null) textFont(font);
			if(font_size > 0) textSize(font_size);
			if(inside(RECT)) {
				fill(color_label_in);
			} else {
				fill(color_label_out);
			}
			text(this.name, pos_label);
		}  
	}

  /**
   * 
   * VALUE
   */

  public Crope set_pos_value(vec2 pos) {
    set_pos_value(pos.x(),pos.y());
    return this;
  }

  public Crope set_pos_value(float x, float y) {
    if(this.pos_value == null) {
      this.pos_value = new vec2(x,y);
    } else {
       this.pos_value.set(x,y);
    }
    return this;
  }


  public void show_value() {
    String message = "no values available";
		show_value_impl(message);
	}

	protected void show_value_impl(String mess) {
		 textAlign(align_label_value);
		 if(font != null) textFont(font);
		 if(font_size > 0) textSize(font_size);
		 if(inside(RECT)) {
			fill(color_label_in);
		} else {
			fill(color_label_out);
		}
		text(mess, pos_value);
	}





  /**
  font
  */
  public Crope set_font(PFont font) {
    this.font = font;
    return this;
  }

  public Crope set_font(String font_name, int size) {
    this.font = createFont(font_name,size);
    return this;
  }

  public Crope set_font_size(int font_size) {
    this.font_size = font_size;
    return this; 
  }
  





  // set midi
  public Crope set_id_midi(int id_midi) {
    this.id_midi = id_midi;
    return this;
  }

  public Crope set_id(int id) {
    this.id = id;
    return this;
  }

  public Crope set_rank(int rank) {
    this.rank = rank;
    return this;
  }


  // set misc
  public Crope set_rollover_type(int rollover_type) {
    this.rollover_type = rollover_type;
    return this;
  }



  /**
  get
  */
  public vec2 pos() {
    return pos;
  }
  
  public int top() {
  	return (int)pos.y();
  }
  
  public int bottom() {
  	return (int)(pos.y() + size.y());
  }
  
  public int left() {
  	return (int)pos.x();
  }
  
  public int right() {
  	return (int)(pos.x() + size.x());
  }

  public vec2 size() {
    return size;
  }

  public int get_rollover_type() {
    return this.rollover_type;
  }

  public int get_dna() {
    return dna;
  }

  public String get_name() {
    return name;
  }

  public String get_label() {
    return get_name();
  }

  //give the IDmidi 
  public int get_id_midi() { 
    return this.id_midi ; 
  }

  public int get_id() {
    return this.id;
  }


  public PFont get_font() {
    return font;
  }

  public int get_rank() {
    return rank;
  }


  public String get_type() {
    return type;
  }



  // inside crope
  public boolean inside() {
    return inside(pos, size, rollover_type);
  }

  public boolean inside(int shape_type) {
    return inside(pos,size,shape_type);
  }

  public boolean inside(vec2 pos, vec2 size, int shape_type) {
  	if(shape_type == ELLIPSE) {
  		// this part can be improve to check the 'x' and the 'y'
  		vec2 offset = pos.copy().add(size().copy().mult(0.5f));
  		if (offset.dist(cursor) < size.x() * 0.5f) {
  			return true; 
      } else {
      	return false;
      }
    } else {
    	if(cursor.x() > pos.x() && 
    			cursor.x() < pos.x() + size.x() && 
    			cursor.y() > pos.y() && 
    			cursor.y() < pos.y() + size.y()) {
    		  return true; 
    		} else {
      		return false ;
      	}
    	}
    }
  	//
  }
