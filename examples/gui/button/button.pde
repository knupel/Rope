/**
* GUI CROPE EXAMPLE
*
* Simple button
* 2016-2021
* v 1.0.4
*/

import rope.gui.button.R_Button;
import rope.R_State.State;
import rope.vector.vec2;
import rope.core.Rope;

Rope r = new Rope();
R_Button button;

void setup() {
  size(160,160);
  State.init(this);
  button_setup();
}

void draw() {
	background(r.BLANC);
	State.pointer(mouseX,mouseY);
	State.event(mousePressed, !keyPressed);
	button_draw();
	State.reset_event();
}

void button_setup() {
	// button = new R_Button(new vec2(x,y), new vec2(50));
	button = new R_Button();
	button.pos(60,60);
	button.size(50);
	button.set_label("Hello World");
	button.is(true);
	// button.set_colour_in_on(r.GREEN);
	// button.set_colour_out_on(r.SAPIN);
	// button.set_colour_in_off(r.RED);
	// button.set_colour_out_off(r.BLOOD);
}


void button_draw() {
	button.update();
	button.rollover(true);

	button.show_label();
	button.show_value();
	
	button.show(ELLIPSE,true);
	//button.show(RECT,true);

	r.print_tempo(60,"button is",button.is());
	r.print_tempo(60,"button get",button.get());
}

