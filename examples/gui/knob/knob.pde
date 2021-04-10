/**
* GUI CROPE EXAMPLE
* dependancies
* Processing 3.5.4
* Rope Library 0.12.0.40
* 2016-2021
*
* Knob example
* v 1.2.0
*/

import rope.gui.button.R_Knob;
import rope.R_State.State;
import rope.vector.vec2;
import rope.core.Rope;


int x = 100;
int y = 100;
Rope r = new Rope();
void setup() {
  size(200,200);
  State.init(this);
  set_knob(x,y); 
}


void draw() {
	background(255);
	State.pointer(mouseX,mouseY);
	State.event(mousePressed);
	draw_knob();
	State.reset_bang();
}

R_Knob knob ;
void set_knob(int x, int y) {
	knob = new R_Knob(new vec2(x,y),50);
	knob.set_rollover_type(RECT);
	knob.set_molette(RECT);
	knob.set_size_molette(20,10);
	// knob.set_size_limit(-10,5);
	knob.set_value(0.5);

	// limit the range knob
	// knob.limit(); // use default value range
	knob.set_range(PI,HALF_PI);

	// colour button
	knob.set_colour_in_on(r.GREEN);
	knob.set_colour_out_on(r.SAPIN);
	knob.set_colour_in_off(r.RED);
	knob.set_colour_out_off(r.BLOOD);
	// colour molette
	knob.set_align_label_name(LEFT);
	knob.set_align_label_value(RIGHT);
	knob.set_label("Turn me please");
	float pos_info = 25;
	// knob.set_pos_label(pos_info-5,20);
	// knob.set_pos_value(pos_info+5,20);
	knob.set_distance_molette(knob.size().x()*.5);
	knob.set_drag(r.CIRCULAR); // by default
	//knob.set_drag(r.VERTICAL);
	// knob.set_drag(r.HORIZONTAL);
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
	knob.show_structure();
	knob.show_molette();
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