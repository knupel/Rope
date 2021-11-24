/**
* PALETTE SELECTOR
* * Processing 3.5.4
* v 1.1.0
* 2021-2021
*/
package rope.gui.palette;

import rope.R_State.State;
import rope.gui.Crope;
import rope.vector.vec2;

public class R_Palette_Selector extends Crope {
	private boolean inside;
	private boolean locked;
	// private boolean validate;
	private int current_color;
	private int new_color;
	private vec2 pos_next;
	

	public R_Palette_Selector(vec2 pos, vec2 size) {
		super("Palette Selector", pos, size);
		set_name(get_type());
		pos_next = this.pos.copy().add_x(size.x());
    current_color = color(State.env().cx() * 0.5f, State.env().cy() * 0.5f, State.env().cz() * 0.5f);
	}

	public void set_boxes(vec2 pos_a, vec2 pos_b) {
		this.pos.set(pos_a);
		this.pos_next.set(pos_b);
	}


	public void update() {
    cursor(State.env().pointer);
    if(inside(RECT)) {
			this.inside = true;
			fill(this.fill_in);
			stroke(this.stroke_in);
		} else {
			this.inside = false;
			fill(this.fill_out);
			stroke(this.stroke_in);
		}
		strokeWeight(this.thickness);
    event = State.env().event.a();
    if(event && this.inside) {
			this.locked = true ;
		}
    if(!event){ 
			this.locked = false;
		}
		
		if(this.locked) {
			this.current_color = this.new_color;
		}
		rect(this.pos, this.size);
		text(this.name, this.pos.x() +5, this.pos.y() +5 +(this.size.y() /2.0f));
	}

	public void show_struc() {
		box_current_color();
		box_new_color();
	}


	public void show_label() {
		this.show_label_impl();
		vec2 buf_pos = this.pos_label.copy();
		this.set_pos_label(this.pos_label.copy().add_x(this.size.x()));
		this.show_label_impl();
		this.set_pos_label(buf_pos);
		// fill(this.color_label_in);
		// vec2 pos = pos.copy().add_y(this.size.y());
		// show_label_current_color();
		// show_label_new_color();
	}

	public void show_value() {
		this.show_value_impl(hex(this.current_color));
		vec2 buf_pos = this.pos_value.copy();
		this.set_pos_value(this.pos_value.copy().add_x(this.size.x()));
		this.show_value_impl(hex(this.new_color));
		this.set_pos_value(buf_pos);
	}

	private void box_current_color() {
		strokeWeight(this.thickness);
		stroke(this.stroke_in);
		fill(this.current_color);
		rect(this.pos, this.size);
	}

	private void box_new_color() {
    strokeWeight(this.thickness);
		stroke(this.stroke_in);
		fill(this.new_color);
		rect(pos_next, this.size);
	}

	public void set_color_picker(int new_color) {
		this.new_color = new_color;
	}

	public int get_new_color() {
		return new_color;
	}

	public int get_current_color() {
		return current_color;
	}

}