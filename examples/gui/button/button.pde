/**
* GUI CROPE EXAMPLE
* Processing 3.5.4
* Rope Library 0.12.1.41
*
* 2016-2021
* v 1.0.2
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
  State.init(this);
  button_simple_setup(x,y);
}

void draw() {
	background(125);
	State.pointer(mouseX,mouseY);
	State.event(mousePressed, !keyPressed);
	button_simple_draw();
	State.reset_event();
}

R_Button button ;
void button_simple_setup(int x, int y) {
	button = new R_Button(new vec2(x,y), new vec2(50));
	button.is(true);
	button.set_colour_in_on(r.GREEN);
	button.set_colour_out_on(r.SAPIN);
	button.set_colour_in_off(r.RED);
	button.set_colour_out_off(r.BLOOD);
	button.set_label("Hello World");
}


void button_simple_draw() {
	button.update();
	button.rollover(true);

	button.show_label();
	button.show_value();
	
	button.show(ELLIPSE,true);
	//button.show(RECT,true);

	r.print_tempo(60,"button is",button.is());
	r.print_tempo(60,"button get",button.get());
}

