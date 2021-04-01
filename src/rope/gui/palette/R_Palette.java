package rope.gui.palette;

import rope.gui.Crope;
import rope.gui.R_GUI;
import rope.vector.vec2;
import rope.vector.vec4;
import rope.R_State.State;
import processing.core.PApplet;

public class R_Palette extends Crope implements R_GUI {
	private vec2 target_pos;
  private float root;
  private int radius_picker = 10;
	private int new_nolor;
	
	public R_Palette(vec2 pos, vec2 size) {
		super("Palette", pos, size);
		this.target_pos = new vec2(size.x() * 0.5f + pos.x(), size.y() * 0.5f + pos.y());
	}

  public void set_root(float root) {
    this.root = root;
  }

  public void set_radius_picker(int radius) {
    this.radius_picker = radius;
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
		int px = round(this.pos.x());
		int py = round(this.pos.y());
		int sx = round(this.size.x());
		int sy = round(this.size.y());

		float step_x = 1.0f / this.size.x();
		float step_y = 1.0f / this.size.y();
		int ref_colorMode = State.env().cm();
		vec4 ref_colorMode_xyza = State.env().cxyza();

	 	colorMode(HSB,1);

		for (float x = 0 ; x < 1.0 ; x += step_x) {
			for (float y = 0 ; y < 1.0 ; y += step_y) {
				int c = color(this.root, x ,y);
				set((int)(x * size.x() + px), (int)(y * size.y() + py), c);
			}
		}	
		colorMode(ref_colorMode,ref_colorMode_xyza);
		picker(this.radius_picker);
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
		} else {
			return color(10);
		}
	}

	public int get_color() {
		return get(round(target_pos.x()), round(target_pos.y()));
	}

}
