/**
* CROPE
* Control ROmanesco Processing Environment
* v 1.5.1
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

abstract public class Crope extends R_Graphic {
  protected vec2 pos;
  protected vec2 size;
  protected vec2 pos_ref;
  protected vec2 cursor = new vec2();
  
  // var use to create the background of gui in opengl
  protected float root;
  protected float hue, sat, bri;
  protected boolean opengl_is = false;
  protected PShader shader;
  protected PGraphics pg;
  protected int mode = -1;
  // event
  protected boolean event;
  // color
  protected int fill_in = State.env().gui_fill_in;
  protected int fill_out = State.env().gui_fill_out;
  protected int stroke_in = State.env().gui_stroke_in;
  protected int stroke_out = State.env().gui_stroke_out;
  protected float thickness = State.env().gui_thickness;
  
  protected int color_label_in = State.env().gui_color_label_in;
  protected int color_label_out = State.env().gui_color_label_out;

  protected float rounded = State.env().gui_rounded.x();

  // label + info
  protected int align_label_name = LEFT;
  protected int align_label_value = LEFT;
  protected String name = null;
  protected String label = null;

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
  protected boolean label_is = false;

  public Crope(String type) {
  	super(State.pa());
    this.type = type;
    init(-1, -1, -1, -1);
    
  }

  public Crope(String type, vec2 pos, vec2 size) {
  	super(State.pa());
    this.type = type;
    init(pos.x(), pos.y(), size.x(), size.y());
    label_is = true;
  }

  public Crope(String type, float x, float y, float sx, float sy) {
  	super(State.pa());
    this.type = type;
    init(x, y, sx, sy);
    label_is = true;
  }

  /**
   * INIT
   */
  private void init(float x, float y, float sx, float sy) {
    this.font_size = (int)State.pa().g.textSize;
    this.pos(x,y);
		this.size(sx,sy);
    dna = floor(random(Integer.MIN_VALUE,Integer.MAX_VALUE));
    if(dna == 0) dna = 1;
    init_pos_label();
  }

  protected void init_pos_label() {
    if(pos_label == null) {
      pos_label = new vec2(this.pos.x(),bottom() + this.font_size);
      pos_value = pos_label.copy().add_y(this.font_size);
    } else if(!label_is) {
      pos_label.set(this.pos.x(),bottom() + this.font_size);
      pos_value = pos_label.copy().add_y(this.font_size);
    }
  }


  // method ghost who must be overide by the child
  // need to do that that for the future class R_Board
  public void update() {}
  public void show_struc() {}

  public float get() {
    return Float.NaN;
  }

  public float get(int index) {
    return Float.NaN;
  }

  public float [] get_all() {
    return null;
  }

  // public void show_value() {}
  // public void show_label() {}







/**
 * 
 * @param x
 * @param y
 * @return
 */
  public Crope pos(float x, float y) {
    pos(new vec2(x,y));
    return this;
  }

  /**
   * 
   * @param pos
   * @return
   */
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

  /**
   * 
   * @param size
   * @return
   */
  public Crope size(float size) {
    size(new vec2(size));
    return this;
  }
  
  /**
   * 
   * @param w
   * @param h
   * @return
   */
  public Crope size(float w, float h) {
    size(new vec2(w,h));
    return this;
  }

  /**
   * 
   * @param size
   * @return
   */
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

  /**
   * this function is used when you want create a gui color to set it at the specific start, to use with a color wheel
   * @param root
   * @return
   */
  public Crope set_root(float root) {
    this.root = root;
    return this;
  }

  public Crope set_hue(float hue) {
    this.hue = hue;
    return this;
  }

  public Crope set_sat(float sat) {
    this.sat = sat;
    return this;
  }

  public Crope set_bri(float bri) {
    this.bri = bri;
    return this;
  }
  
  /**
   * Use this option when you create a faster color slider, very usefull with big GUI or with gradient one.
   * ACHTUNG: This option can be only use in P2D or P3D Processing context.
   * @param is
   * @return
   */
  public Crope opengl(boolean is) {
  	opengl_is = is;
  	if(all(any(renderer_P3D(), renderer_P2D()),is)) {
      shader = loadShader("shader/fx_color/palette_gui.glsl");	
			pg = createGraphics(size.x(),size.y(),get_renderer());
			opengl_is = true;
		} else {
			opengl_is = false;
		}
    return this;
  }
  

    /**
   * You can select different palette mode, with Processing classic renderer only mode 0 is available.
   * mode 0, GRADIENT : hue range
   * mode 3,4,5 RGB range
   * mode 10, RAINDOW, HUE, SPECTRUM;
   * mode 10, 11,12, 13 all color hsb range.
   * @param mode give the opportunity to change the color randering
   * @return
   */
  public Crope set_mode(int mode) {
  	
  	if(any(mode == HUE)) {
  		this.mode = 10;
  	} else if(mode == BRIGHTNESS) {
  		this.mode = 11;
  	} else if(mode == SATURATION) {
  		this.mode = 12;
  	} else if(mode == PALETTE) {
  		this.mode = 0;
  	} else if(mode == RAINBOW) {
  		this.mode = RAINBOW;
  	} else if(mode == SPECTRUM) {
  		this.mode = SPECTRUM;
  	} else if(mode == GRADIENT_SATURATION) {
  		this.mode = GRADIENT_SATURATION;
  	} else if(mode == GRADIENT_BRIGHTNESS) {
  		this.mode = GRADIENT_BRIGHTNESS;
  	} else {
  		this.mode = mode;
  	}
  	
  	// NEED TO USE THE MODEL 13 but it's veru sophisticated...so nned to sllep before do that !!!!
  	if(all( !opengl_is, 
            this.mode != 0, 
            this.mode != 10, 
            this.mode != 11, 
            this.mode != 12,
            this.mode != RAINBOW,
            this.mode != SPECTRUM,
            this.mode != GRADIENT,
            this.mode != GRADIENT_SATURATION,
            this.mode != GRADIENT_BRIGHTNESS)) {
  		print_err("Crope set_mode(",this.mode,") is only available in P2D or P3D renderer\n"
  				+ "for the classic renderer only mode 0 and 10 is available");
  		System.exit(0);
  		return this;
  	}
  	return this;
  }


  /**
   * set fill color of your gui
   * @param colour
   * @return
   */
  public Crope set_fill(int colour) {
    set_fill(colour,colour);
    return this;
  }

  /**
   * set fill color of your gui
   * @param colour_in
   * @param colour_out
   * @return
   */
  public Crope set_fill(int colour_in, int colour_out) {
    this.fill_in = colour_in;
    this.fill_out = colour_out;
    return this;
  }



	protected void render_solid_color() {
		render_solid_stroke();
		if(inside(RECT)) {
			fill(fill_in);
		} else {
			fill(fill_out);
		}
		rect(pos,size,rounded);
	}
  

  /**
    * set stroke color of your gui
   * @param colour
   * @return
   */
  public Crope set_stroke(int colour) {
    set_stroke(colour,colour);
    return this;
  }

  /**
    * set stroke color in and out of your gui
   * @param colour_in
   * @param colour_out
   * @return
   */
  public Crope set_stroke(int colour_in, int colour_out) {
    this.stroke_in = colour_in;
    this.stroke_out = colour_out;
    return this;
  }


  /**
   * set_thickness() is like strokeWeight
   * @param thickness
   * @return
   */
  public Crope set_thickness(float thickness) {
    this.thickness = thickness;
    return this;
  }


  protected void render_solid_stroke() {
		if(all(thickness > 0,alpha(stroke_in) > 0, alpha(stroke_out) > 0)) {
			strokeWeight(thickness);
			if(inside(RECT)) {
				stroke(stroke_in);
			} else {
				stroke(stroke_out);
			}
		} else {
			noStroke();
		}
	}

  /**
   * 
   * ASPECT
   */

  public Crope set_rounded(float rounded) {
    this.rounded = rounded;
    return this;
  }


  public Crope set_aspect(int fill_colour, int stroke_colour, float thickness) {
    set_fill(fill_colour,fill_colour);
    set_stroke(stroke_colour,stroke_colour);
    set_thickness(thickness);
    return this;
  }

  public Crope set_aspect(int fill_colour_in, int fill_colour_out, int stroke_colour_in,  int stroke_colour_out, float thickness) {
    set_fill(fill_colour_in,fill_colour_out);
    set_stroke(stroke_colour_in,stroke_colour_out);
    set_thickness(thickness);
    return this;
  }
  

    /**
   * 
   * GRADIENT
   */

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









  /**
   * 
   *  LABEL
   * 
   * 
   */
  
  
   public Crope set_fill_label(int colour) {
    set_fill_label(colour,colour);
    return this;
  }

  public Crope set_fill_label(int colour_in, int colour_out) {
    this.color_label_in = colour_in;
    this.color_label_out = colour_out;
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

  public Crope set_label(String label) {
    this.label = label;
    return this;
  }

  public Crope set_label(String label, float x, float y) {
    this.label = label;
    if(this.pos_label == null) {
      this.pos_label = new vec2(x,y);
    } else {
      this.pos_label.set(x,y);
    }
    label_is = true;
    return this;
  }
  
  public Crope set_label(String label, vec2 pos_label) {
    set_label(label, pos_label.x(), pos_label.y());
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
    label_is = true;
    return this;
  }
  
  public void show_label() {
    show_label_impl();
  }
  
  
  protected void show_label_impl() {
		if(this.label != null) {
			textAlign(align_label_name);
			if(font != null) textFont(font);
			if(font_size > 0) textSize(font_size);
			if(inside(RECT)) {
				fill(color_label_in);
			} else {
				fill(color_label_out);
			}
			text(this.label, pos_label);
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
    return this.name;
  }

  public String get_label() {
    return this.label;
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

  public int get_font_size() {
    return this.font_size;
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
  }
