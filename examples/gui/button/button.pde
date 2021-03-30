/**
* GUI CROPE EXAMPLE
* Processing 3.5.4
* Rope Library 0.12.1.41
*
* 2016-2021
* v 1.0.0
*/

import rope.gui.button.R_Button;
import rope.R_State.State;
import rope.vector.vec2;
import rope.core.Rope;


/**
* Simple button
*/
Rope r;
int x = 60;
int y = 60 ;
void setup() {
	r = new Rope();
  size(160,160);
  State.papplet(this);
  button_simple_setup(x,y);
}

void draw() {
	background(125);
	State.pointer(mouseX,mouseY);
	State.event(mousePressed);
	button_simple_draw();
}

R_Button button ;
void button_simple_setup(int x, int y) {
	button = new R_Button(new vec2(x,y), new vec2(50));
	button.is(true);
	button.set_colour_in_on(r.GREEN);
	button.set_colour_out_on(r.SAPIN);
	button.set_colour_in_off(r.RED);
	button.set_colour_out_off(r.BLOOD);
	button.set_pos_label(20,20);
	button.set_label("Hello World");
}


void button_simple_draw() {
	button.update();
	button.rollover(true);

	button.show_label();
	
	button.show(ELLIPSE,true);
	//button.show(RECT,true);

	println("button is",button.is());
	println("button get",button.get());
}

