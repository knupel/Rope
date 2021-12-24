/**
 * ROPE Library
 * Copyleft (c) 2014-2021
 * @see https://github.com/StanLepunK/Rope
 * Knob example
 * 2020-2021
 * v 1.4.0
 */

import rope.gui.button.R_Knob;
import rope.R_State.State;
import rope.vector.vec2;
import rope.core.Rope;

Rope r = new Rope();
void setup() {
  size(200,200);
  State.init(this);
  set_knob(); 
}

void draw() {
	background(255);
	State.pointer(mouseX,mouseY);
	State.event(mousePressed);
	draw_knob();
	State.reset_event();
}

R_Knob knob ;
void set_knob() {
	// knob = new R_Knob(new vec2(20),100);
	knob = new R_Knob();
	knob.size(100);
	knob.pos(new vec2(20));
	knob.set_label("Turn me please");

	knob.set_rollover_type(RECT);
	knob.set_value(0.5);
	knob.set_type_mol(RECT);
	knob.set_size_mol(20,10);
	knob.set_dist_mol(knob.size().x()*.5);
	knob.set_size_limit(-20,20); // use to show limit
	knob.set_align_label_name(LEFT);
	knob.set_align_label_value(LEFT);
	knob.set_drag_force(0.05);
}

void draw_knob() {
	knob.update();
	knob.rollover(true);
	knob.show_struc();
	knob.show_mol();
	knob.show_limit();

	knob.show_label();
	knob.show_value();
}

void keyPressed() {
	if(key == 'r') {
		knob.set_value(random(1));
	}
}