/**
* GUI CROPE EXAMPLE
* dependancies
* Processing 3.5.4
* 2016-2021
*
* Knob example
* v 1.3.2
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
	knob = new R_Knob(new vec2(20),100);
	knob.set_rollover_type(RECT);

	// knob.set_drag(r.CIRCULAR); // by default
	//knob.set_drag(r.VERTICAL);
	// knob.set_drag(r.HORIZONTAL); 

	
	knob.set_value(0.5);
	knob.set_mol(RECT);
	knob.set_size_mol(20,10);
	knob.set_dist_mol(knob.size().x()*.5);

	// limit the range knob
	knob.set_size_limit(-20,20); // use to show limit
	knob.set_limit(0.4,TAU - 0.4); // use to set the angle range of limit
	// knob.set_limit(0.4,HALF_PI); // use to set the angle range of limit
	knob.limit(true); // use default value lilit angle
	

	// colour molette
	knob.set_align_label_name(LEFT);
	knob.set_align_label_value(LEFT);
	knob.set_label("Turn me please");
	float pos_info = 25;
	// knob.set_pos_label(pos_info-5,20);
	// knob.set_pos_value(pos_info+5,20);
	

	knob.set_drag_force(0.05);

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
  
  // println("knob value", knob.get());
	// println("knob value", knob.get()%TAU);
}




void keyPressed() {
	if(key == 'r') {
		knob.set_value(random(1));
	}
}