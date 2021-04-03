/**
* PALETTE
* Processing 3.5.4
* v 1.0.0
* 2021-2021
*/
package rope.gui.palette;

import rope.gui.Crope;
import rope.gui.R_GUI;
import rope.vector.vec2;
import rope.vector.vec4;
import rope.R_State.State;
import processing.core.PGraphics;
import processing.opengl.PShader;

public class R_Palette extends Crope implements R_GUI {
	private vec2 target_pos;
  private float root;
  private int radius_picker = 10;
	private int new_nolor;
	boolean opengl_is = false;
	PShader palette_shader;
	PGraphics pg;
	int mode = 3;
	
	public R_Palette(vec2 pos, vec2 size) {
		super("Palette", pos, size);		
		if(any(renderer_P3D(), renderer_P2D())) {
			palette_shader = loadShader("shader/fx_palette/palette.glsl");
			pg = createGraphics(size.x(),size.y(),get_renderer());
			opengl_is = true;
		}
		this.target_pos = new vec2(size.x() * 0.5f + pos.x(), size.y() * 0.5f + pos.y());
	}

  public R_Palette set_root(float root) {
    this.root = root;
    return this;
  }
  
  /**
   * You can select different palette mode, with Processing classic renderer only mode 3 is available.
   * @param mode
   * @return
   */
  public R_Palette set_mode(int mode) {
  	if(!opengl_is && mode != 3) {
  		print_err("R_Palette set_mode(",mode,") is only available in P2D or P3D renderer");
  		System.exit(0);
  		return this;
  	}
  	this.mode = mode;
  	return this;
  }

  public R_Palette set_radius_picker(int radius) {
    this.radius_picker = radius;
    return this;
  }
	/**
	* show palette and set the picker size
	*/
  public void update() {
    cursor(State.env().pointer);
  }

  public void show_value() {
    // from Interface
  }


	
	public void show_structure() {	 	
	 	if(!opengl_is) {
			int ref_colorMode = State.env().cm();
			vec4 ref_colorMode_xyza = State.env().cxyza();
	 		colorMode(HSB,1);
	 		render_palette_pixel();
	 		colorMode(ref_colorMode,ref_colorMode_xyza);
	 	} else {
	 		render_palette_opengl();
	 	}	
		picker(this.radius_picker);
	}
	
	public void render_palette_opengl() {
		palette_shader.set("hue",root);
	  palette_shader.set("mode",mode);
	  
		int sx = round(this.size.x());
		int sy = round(this.size.y());
	  this.pg.shader(palette_shader);
	  this.pg.beginDraw();
	  this.pg.beginShape();

	  this.pg.beginShape();
	  this.pg.vertex(0,0); // top left
	  this.pg.vertex(sx, 0); // top right
	  this.pg.vertex(sx, sy); // bottom left
	  this.pg.vertex(0, sy); // bottom right
	  this.pg.endShape();
	  this.pg.endDraw();
	  image(this.pg,this.pos);
	}
	
	
	public void render_palette_pixel() {
		int px = round(this.pos.x());
		int py = round(this.pos.y());
		int sx = round(this.size.x());
		int sy = round(this.size.y());

		float step_x = 1.0f / this.size.x();
		float step_y = 1.0f / this.size.y();
		for (float x = 0 ; x < 1.0 ; x += step_x) {
			for (float y = 0 ; y < 1.0 ; y += step_y) {
				int c = color(this.root, x ,y);
				set((int)(x * size.x() + px), (int)(y * size.y() + py), c);
			}
		}	
		
	}
	
	// Pipette
	private void picker(int radius) {
		picker_is(); // look if the pipette are in the area or not
		new_nolor = get_color(); // give the value of new color selected by pipette
		
		strokeWeight(1) ;
		stroke(color_ring(new_nolor));
		fill(new_nolor);
		int temp = ellipseMode();
		ellipseMode(CENTER);
		ellipse(target_pos.x(), target_pos.y(), radius, radius);
		ellipseMode(temp);
	}
	
	private void picker_is() {
    cursor(State.env().pointer);
    if(inside(RECT) && State.env().event.a()) {
      this.target_pos.set(cursor);
    }
	}
	
	private int color_ring(int color_arg) {
		if(brightness(color_arg) < 170) {
			return color(185);
		}
		return color(10);
	}

	public int get_color() {
		return get(round(target_pos.x()), round(target_pos.y()));
	}

}
