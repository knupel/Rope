/**
* GUI CROPE EXAMPLE 
*
* slider notch is slotch
* 2021-2021
* v 2.0.0
*/

import rope.gui.slider.R_Slotch;
import rope.R_State.State;
import rope.core.Rope;
import rope.vector.vec2;

void setup() {
  size(800,200);
  State.init(this);
  setting(); 
}


void draw() {
  background(0);
  // instead update(mouseX,mouseY) by this way all Crope gui pointer is update with those pointers 
  // and can be change in one place.
  State.pointer(mouseX,mouseY);
  State.event(mousePressed);

  update();
  State.reset_event();
}

R_Slotch slotch;
void setting() {
  int num_notch = 9;
  int sy = 20;
  // int sx = sy *num_notch + sy;
  int sx = sy * num_notch;

  slotch = new R_Slotch();
  slotch.pos(20,20);
  slotch.size(sx,sy);
  slotch.set_notch(num_notch);

  // other setting
  // slotch.set_value(0.5f); // use normal position from [0.0, 1.0] with float value
  slotch.set_value(5); // use position from [num_of_notch] with int-eger value
  slotch.set_mol(ELLIPSE);
  slotch.set_rounded(20);
  println("slotch.get_type():", slotch.get_type());
}


void update() {
  slotch.update();
  slotch.show_struc();
  slotch.show_mol();
  
  // notch is separator
  slotch.show_notch(5,5);
  if(slotch.is_done()) {
    println("value",slotch.get(), frameCount);
  }
}
