/**
* R_Sladj
* Control ROmanesco Processing Environment
* v 1.0.1
* Copyleft (c) 2018-2021

* dependencies
* Processing 3.5.4
* @author @stanlepunk
* @see https://github.com/StanLepunK/Rope
*/
package rope.gui.slider;

import processing.core.PApplet;
import rope.vector.vec2;
import rope.R_State.State;

public class R_Sladj extends R_Slider {
	// size
	protected vec2 size_min_max;
	protected vec2 size_molette_min_max;
	// pos  
	protected vec2 new_pos_min;
	protected vec2 new_pos_max;


	private vec2 pos_norm_adj = new vec2(1,0.5f);
	private vec2 size_norm_adj = new vec2(1,0.2f);

	protected int fill_adj_in = color(State.env().cx()/2);
	protected int fill_adj_out = color(State.env().cx() /4);
	protected int stroke_adj_in = color(State.env().cx()/2);
	protected int stroke_adj_out = color(State.env().cx()/4);
	protected float thickness_adj = 0;

	private boolean locked_min, locked_max;
		
	public R_Sladj(vec2 pos, vec2 size) {
		super("Sladj", pos, size);
		this.new_pos_max = new vec2();
		this.new_pos_min = pos.copy();
		this.size_min_max = size.copy();

		if (size.x() >= size.y()) {
			this.size_molette_min_max = new vec2(size.y()); 
		} else {
			this.size_molette_min_max = new vec2(size.x());
		}
	}

	public R_Sladj set_fill_adj(int c) {
		set_fill_adj(c,c);
		return this;
	}

	public R_Sladj set_fill_adj(int c_in, int c_out) {
		this.fill_adj_in = c_in;
		this.fill_adj_out = c_out;
		return this;
	}
	
	public R_Sladj set_stroke_adj(int c) {
		set_stroke_adj(c,c);
		return this;
	}

	public R_Sladj set_stroke_adj(int c_in, int c_out) {
		this.stroke_adj_in = c_in;
		this.stroke_adj_out = c_out;
		return this;
	}

	public R_Sladj set_thickness_adj(float thickness) {
		this.thickness_adj = thickness;
		return this;
	}


	
	
	
	/**
	METHOD
	*/
	public void update_min_max() {
		float new_norm_size = max_norm -min_norm;
		
		if (size.x() >= size.y()) {
			size_min_max = new vec2(round(size.x() *new_norm_size), size.y()); 
		} else {
			size_min_max = new vec2(round(size.y() *new_norm_size), size.x());
		}
		
		pos_min = new vec2(round(pos.x() +(size.x() * min_norm)), pos.y()) ;
		// in this case the detection is translate on to and left of the size of molette
		// we use the molette[0] to set the max. there is at least one molette by slider :)
		pos_max = new vec2(round(pos.x() -molette[0].size.x() +(size.x * max_norm)), pos.y()); 
	}
	


	public boolean locked_min_is() {
		return locked_min;
	}

	public boolean locked_max_is() {
		return locked_max;
	}
	
	// update min
	public void select_min(boolean authorization) {
		locked_min = select(locked_min(), locked_min, authorization) ;
	}
	public void update_min() {
		// we use the molette[0] to set the max. there is at least one molette by slider :)
		float arbitrary_value = 1.5f;
		float range = molette[0].size.x() * arbitrary_value;
		
		if (locked_min) {
			if (size.x() >= size.y()) {
				// security
				if (new_pos_min.x() < pos_min.x()) {
					new_pos_min.x(pos_min.x());
				} else if (new_pos_min.x() > pos_max.x() -range) {
					new_pos_min.x(round(pos_max.x() -range));
				}
				
				new_pos_min.x = round(constrain(cursor.x(), pos.x(), pos.x() + size.x() -range)); 
				// norm the value to return to method minMaxSliderUpdate
				min_norm = map(new_pos_min.x(), pos_min.x(), pos_max.x(), min_norm, max_norm) ;
			} else {
				new_pos_min.y(round(constrain(cursor.y() -size_min_max.y(), pos_min.y(), pos_max.y())));
			}// this line is not reworking for the vertical slider
		}
	}
	
	// update max
	public void select_max(boolean authorization) {
		locked_max = select(-1,locked_max(), locked_max, authorization);
	}
	// update maxvalue
	public void update_max() {
		float arbitrary_value = 1.5f;
		float range = molette[0].size.x() * arbitrary_value;
		
		if (locked_max) {  // this line is not reworking for the vertical slider
			if (size.x() >= size.y()) {
				// security
				if (new_pos_max.x() < pos_min.x() +range)  {
					new_pos_max.x(round(pos_min.x() +range));
				} else if (new_pos_max.x() > pos_max.x()) {
					new_pos_max.x(pos_max.x());
				}
				new_pos_max.x(round(constrain(cursor.x() -(size.y() * 0.5f) , pos.x() +range, pos.x() +size.x() -(size.y() *0.5f)))); 
				 // norm the value to return to method minMaxSliderUpdate
				pos_max = new vec2(round(pos.x() -molette[0].size.x() +(size.x() *max_norm)), pos.y());
				// we use a temporary position for a good display of the max slider 
				vec2 temp_pos_max = new vec2(pos.x() -(size.y() * 0.5f) +(size.x() *max_norm), pos_max.y());
				max_norm = map(new_pos_max.x(), pos_min.x(), temp_pos_max.x(), min_norm, max_norm) ;
			} else {
				new_pos_max.y(round(constrain(cursor.y() -size_min_max.y(), pos_min.y, pos_max.y()))); // this line is not reworking for the vertical slider
			}
		}
		
	}

	public R_Sladj set_min(float min) {
		this.min_norm = min;
		return this;
	}

	public R_Sladj set_max(float max) {
		this.max_norm = max;
		return this;
	}
	
	
	
	
	
	
	
	
	
	// Display classic
	public void show_adj() {
		strokeWeight(thickness_adj) ;
		if(locked_min || locked_max || inside_max() || inside_min()) {
			aspect(fill_adj_in,stroke_adj_in,thickness_adj);
		} else {
			aspect(fill_adj_out,stroke_adj_out,thickness_adj);
		}

		vec2 pos = new vec2(pos_min.x(), pos_min.y() +size_min_max.y() *pos_norm_adj.y());
		vec2 size = new vec2(size_min_max.x(), size_min_max.y() *size_norm_adj.y());
		rect(pos,size);
	}
	
	

	// INSIDE
	public boolean inside_min() {
		int x = round(pos_min.x());
		int y = round(pos_min.y() +size_min_max.y() *pos_norm_adj.y()) ;
		vec2 temp_pos_min = new vec2(x,y);
		if(inside(temp_pos_min,size_molette_min_max,RECT)) {
			return true; 
		} else {
			return false;
		}
	}
	
	public boolean inside_max() {
		int x = round(pos_max.x());
		int y = round(pos_max.y() +size_min_max.y() *pos_norm_adj.y()) ;
		vec2 temp_pos_max =  new vec2(x,y);
		if(inside(temp_pos_max, size_molette_min_max,RECT)) {
			return true; 
		} else {
			return false;
		}
	}
	
	//LOCKED
	private boolean locked_min() {
		if (inside_min() && State.select_adj_is()) {
			return true; 
		} else {
			return false;
		}
	}
	
	private boolean locked_max() {
		if (inside_max() && State.select_adj_is()) {
			return true; 
		} else {
			return false;
		}
	}
}