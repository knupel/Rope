/**
* PALETTE
* Processing 3.5.4
* v 1.1.0
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
  private int radius_picker = 10;
	private int new_nolor;
	
	
	public R_Palette(vec2 pos, vec2 size) {
		super("Palette", pos, size);		

		this.target_pos = new vec2(size.x() * 0.5f + pos.x(), size.y() * 0.5f + pos.y());
	}

  public R_Palette set_root(float root) {
    this.root = root;
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
	 		render_palette_pixel();
	 	} else {
	 		render_palette_opengl();
	 	}	
		picker(this.radius_picker);
	}
	
	public void render_palette_opengl() {
		shader.set("value",this.root);
		shader.set("mode",mode);
	  
		int sx = round(this.size.x());
		int sy = round(this.size.y());
	  this.pg.shader(shader);
	  this.pg.beginDraw();
	  this.pg.rect(0,0,sx,sy,this.rounded);
	  this.pg.endDraw();
	  image(this.pg,this.pos);
	}
	
	
	public void render_palette_pixel() {
		if(mode == 0) gradient_hue(this.root, pos,size);
		else if(mode == 10) gradient_spectrum(pos, size, false);
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
