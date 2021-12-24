/**
* GUI CROPE EXAMPLE
* dependancies
* 2021-2021
*
* Knob example
* v 0.2.0
*/

import rope.gui.button.R_Knob;
import rope.R_State.State;
import rope.core.Rope;
import rope.gui.R_Mol;

Rope r = new Rope();
R_Knob knob;

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


void set_knob() {
	knob = new R_Knob();
	knob.pos(50,50);
	knob.size(100);
	knob.set_label("Turn me please");
	use_case(knob);
	knob.set_rollover_type(RECT);
	knob.set_value(0, 0.5); // must be set with normal value from 0 to 1

	knob.set_size_mol(10);
	knob.set_dist_mol(knob.size().x() * 0.5);
	knob.set_type_mol(RECT);
	knob.set_dist_guide(knob.size().x() * 0.65);

	// limit the range knob
	// knob.use_limit(true); // use default value range

	// colour molette
	knob.set_align_label_name(LEFT);
	knob.set_align_label_value(LEFT);

	knob.set_drag_force(0.05);

	// R_Mol [] list = knob.get_mol();
	// for(int i = 0 ; i < list.length ; i++) {
	// 	println("mol pos",list[i].pos());
	// }
}


void draw_knob() {
	knob.update();
	/**
	 * knob.update(mouseX,mouseY);
	 * knob.select(mousePressed);
	 * knob.select(keyPressed); // by default is mousePressed
	 * knob.update(mouseX,mouseY,keyPressed);
	 * knob.update(mouseX,mouseY,mousePressed,keyPressed);
	 * */
	knob.rollover(true);
	knob.show_struc();
	knob.show_struc_pie();
	knob.show_mol();
	knob.show_limit();
	knob.show_guide();
	knob.show_label();
	knob.show_value();
  
  // printArray(knob.get_all());
  // println("value", r.truncate(knob.get(0)), r.truncate(knob.get(1)));
  // println("guide", r.truncate(knob.get_guide()));
}


void use_case(R_Knob knob) {
	// work when the sum of the offset + get_stop() is upper to TAU
	// case 0 // little bug
	knob.set_fov(0, TAU);

	// case 1 // og
  // knob.set_fov(0, PI/2);

	// case 2  // ok
  // knob.set_fov(0, PI/2);
  // knob.set_offset(PI/2);

	// case 3 // little bug
  // knob.set_fov(0, PI);
  // knob.set_offset(PI);

  // case 4 // little bug if the start is not good
	// knob.set_fov(0, PI);
 //  knob.set_offset(PI/2);

	// case 5 // ok
	// knob.set_fov(0, PI + (PI/2));

	// case 10 // ok
	// knob.set_fov(0, PI + (PI/2));
	// knob.set_offset(PI);

}

