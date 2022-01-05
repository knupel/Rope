/**
* GUI CROPE EXAMPLE 
*
* Check activity of gui elements
* 2021-2021
* v 0.0.1
*/
import rope.R_State.State;

import rope.gui.slider.R_Slider;
import rope.gui.slider.R_Slotch;
import rope.gui.button.R_Button;
import rope.gui.R_Dropdown;


import rope.core.Rope;

Rope r = new Rope();

R_Slider slider;
R_Slotch slotch;
R_Button button;
R_Dropdown dropdown;
boolean slider_is_active, slotch_is_active, button_is_active, dropdown_is_active;
boolean slider_is_done, slotch_is_done, button_is_done, dropdown_is_done;

void setup() {
  size(400,270);
  State.init(this);
  setting();
}

void draw() {
  background(255);
  State.pointer(mouseX,mouseY);
  State.event(mousePressed);
  // if press anykey you pass in multiselection mode
  State.keep_selection_is(keyPressed);
  // State.keep_selection_is(false);
  update();
  State.reset_event();
}




void setting() {
  slider = new R_Slider();
  slotch = new R_Slotch();
  button = new R_Button();
  dropdown = new R_Dropdown();

  slider.pos(50,25).size(100,20);

  int num_notch = 5;
  int sy = 20;
  int sx = sy *num_notch;
  slotch.pos(50,50).size(sx,sy);
  slotch.set_notch(5);

  button.pos(50,100).size(30);
  
  dropdown.pos(50,150).size(150,20);
  dropdown.set_name("Animal");
  dropdown.set_label("Animal");
  dropdown.set_content("chat", "chien", "souris");
  int num_box_display = 4;
  int rank_box_position = 1;
  dropdown.set_box(num_box_display, rank_box_position);
}


void update() {
  slider.update();
  slider.show_struc();
  slider.show_mol();

  slotch.update();
  slotch.show_struc();
  slotch.show_mol();
  slotch.show_notch();

  button.update();
  button.show_struc();

  dropdown.update();
  dropdown.show_struc();
  dropdown.set_label(dropdown.get_name() + " " + dropdown.get_value());
  dropdown.show_value();
  
  slider_is_active = slider.is_active();
  slotch_is_active = slotch.is_active();
  button_is_active = button.is_active();
  dropdown_is_active = dropdown.is_active();

  slider_is_done = slider.is_done();
  slotch_is_done = slotch.is_done();
  button_is_done = button.is_done();
  dropdown_is_done = dropdown.is_done();

  if(slider_is_active || slotch_is_active || button_is_active || dropdown_is_active) {
    println("ACTIVE");
    println("frameCount", frameCount);
    if(slider_is_active) println("slider.is_active()",slider_is_active);
    if(slotch_is_active) println("slotch.is_active()",slotch_is_active);
    if(button_is_active) println("button.is_active()",button_is_active);
    if(dropdown_is_active) println("dropdown.is_active()",dropdown_is_active);
  }

  if(slider_is_done || slotch_is_done || button_is_done || dropdown_is_done) {
    println("DONE");
    println("frameCount", frameCount);
    if(slider_is_done) println("slider.is_done()",slider_is_done);
    if(slotch_is_done) println("slotch.is_done()",slotch_is_done);
    if(button_is_done) println("button.is_done()",button_is_done);
    if(dropdown_is_done) println("dropdown.is_done()",dropdown_is_done);
  }

}
  
