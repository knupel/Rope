/**
* GUI CROPE EXAMPLE 
* Processing 3.5.4
* Rope Library 0.12.1.41
*
* slider notch
* 2021-2021
* v 1.2.0
*/

import rope.gui.slider.R_Slotch;
import rope.R_State.State;

int x = 30;
int y = 40 ;
void setup() {
  size(800,200);
  State.init(this);
  slotch_setup(x,y); 
}


void draw() {
  background(0);
  // instead update(mouseX,mouseY) by this way all Crope gui pointer is update with those pointers 
  // and can be change in one place.
  State.pointer(mouseX,mouseY);
  State.event(mousePressed);

  slotch_draw();
  State.reset_bang();
}

R_Slotch slotch;
void slotch_setup(int x, int y) {
  int num_notch = 10;
  int size_y = 20;
  // bbasic setting via construor or via method
  int len = size_y *num_notch + size_y;
  // slotch = new Slotch(vec2(x,y),vec2(len,size_y),num_notch);
  // slotch = new Slotch("Bad slotch", vec2(x,y),vec2(len,size_y),num_notch);
  slotch = new R_Slotch();
  slotch.pos(x,y);
  slotch.size(len,size_y);
  slotch.set_notch(num_notch);

  // other setting
  // slotch.set_value(0.5); // use normal position from [0.0, 1.0]
  slotch.set_value(2); // use position from [0, int num_of_notch]
  slotch.set_molette(ELLIPSE);
  slotch.set_rounded(20);
  println("slotch.get_type():", slotch.get_type());
}


void slotch_draw() {
  slotch.update();
  // slotch.update(mouseX,mouseY);

  slotch.show_structure();
  slotch.show_molette();
  // stroke(255);
  // slotch.show_notch();
  // slotch.set_colour_notch(230);
  
  // slotch.set_aspect_notch(230,1); // What is it ????
  
  // notch is separator
  slotch.show_notch(-5,10);
  println("value",slotch.get(0));
}
