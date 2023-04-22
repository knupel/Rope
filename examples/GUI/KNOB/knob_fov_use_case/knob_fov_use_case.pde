/**
* GUI CROPE EXAMPLE
* 
* 2021-2021
* Knob example
* Knob use case for fov mode
* v 0.0.2
*/

import rope.gui.button.R_Knob;
import rope.utils.R_State.State;
import rope.core.Rope;

Rope r = new Rope();
R_Knob knob;

void setup() {
  size(800,800);
  State.init(this);
  set_knob(); 
}

void draw() {
	background(255);
	State.pointer(mouseX,mouseY);
	State.event(mousePressed);
	draw_knob();

	use_case();
	State.reset_event();
}


void set_knob() {
	knob = new R_Knob();
	knob.pos(50,50);
	knob.size(100);
	knob.set_label("Turn me please");
	knob.set_fov(0, TAU);
	knob.set_rollover_type(RECT);
	knob.set_value(0, 0.5);
	knob.set_size_mol(10);
	knob.set_dist_mol(knob.size().x() * 0.5);
	knob.set_type_mol(RECT);
	knob.set_dist_guide(knob.size().x() * 0.65);
	knob.set_align_label_name(LEFT);
	knob.set_align_label_value(LEFT);
	knob.set_drag_force(0.05);
}


void draw_knob() {
	knob.update();
	knob.rollover(true);
	knob.show_struc();
	knob.show_struc_pie();
	knob.show_mol();
	knob.show_limit();
	knob.show_guide();
	knob.show_label();
	knob.show_value();
}


void use_case() {
	float pos_x = width/2;
	float pos_y = height/2;
	float size_x = width/2;
	float size_y = height/2;

	float start = knob.get_start();
	float stop = knob.get_stop();

	/**
	 * get_start() and get_stop() is close to get(int first) and get(int last) - usualy 0 and 1... 
	 * but the values is corrected for the special case... to long to explaine so look the println to understand
	 * */
	println("start", r.truncate(knob.get(0)), r.truncate(knob.get_start()), r.truncate(knob.get_start_limit()));
	println("stop", r.truncate(knob.get(1)), r.truncate(knob.get_stop()), r.truncate(knob.get_stop_limit()));


	arc(pos_x,pos_y, size_x, size_y, start, stop, PIE);
}

