/**
* GUI CROPE EXAMPLE
* dependancies
* Processing 3.5.4
* 2021-2021
*
* Knob example
* v 0.1.0
*/

import rope.gui.button.R_Knob;
import rope.R_State.State;
import rope.vector.vec2;
import rope.core.Rope;
import rope.gui.R_Mol;


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
	knob = new R_Knob(new vec2(20),100);
	knob.set_rollover_type(RECT);
	
	knob.set_value(0.45, 0.3);

	knob.set_size_mol(10);
	knob.set_dist_mol(knob.size().x() * 0.5);
	knob.set_type_mol(RECT);

	knob.set_dist_guide(knob.size().x() * 0.65);

	// limit the range knob
	knob.limit(true); // use default value range
	knob.set_limit(PI,0);
	// knob.set_limit(HALF_PI,PI);

	// colour molette
	knob.set_align_label_name(LEFT);
	knob.set_align_label_value(LEFT);
	knob.set_label("Turn me please");
	float pos_info = 25;

	knob.set_drag_force(0.05);

	R_Mol [] list = knob.get_mol();
	for(int i = 0 ; i < list.length ; i++) {
		println("mol pos",list[i].pos());
	}

}


void draw_knob() {
	knob.update();
	// knob.update(mouseX,mouseY);
	// knob.select(mousePressed);
	// knob.select(keyPressed); // by default is mousePressed
	// knob.update(mouseX,mouseY,keyPressed);
	//knob.update(mouseX,mouseY,mousePressed,keyPressed);
	knob.rollover(true);


	knob.show_label();
	knob.show_struc();
	knob.show_struc_pie();
	knob.show_mol();
	knob.show_value();
	knob.show_limit();
	knob.show_guide();
  
  // println("knob value", knob.get());
	// println("knob value", knob.get()%TAU);
}




void keyPressed() {
	if(key == 'r') {
		knob.set_value(random(1));
	}
}