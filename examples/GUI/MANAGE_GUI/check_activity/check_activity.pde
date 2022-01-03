/**
* GUI CROPE EXAMPLE 
*
* Check activity of gui elements
* 2021-2021
* v 0.0.1
*/
import rope.R_State.State;

import rope.gui.slider.R_Slider;
import rope.gui.button.R_Button;
import rope.gui.R_Dropdown;


import rope.core.Rope;

Rope r = new Rope();

R_Slider slider_a;
R_Slider slider_b;
R_Button button;
R_Dropdown dropdown;
boolean slider_a_is, slider_b_is, button_is, dropdown_is;

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
  slider_a = new R_Slider();
  slider_b = new R_Slider();
  button = new R_Button();
  dropdown = new R_Dropdown();

  slider_a.pos(50,25).size(100,20);
  slider_b.pos(50,50).size(100,20);

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

  button.update();
  button.show_struc();

  slider_a.update();
  slider_a.show_struc();
  slider_a.show_mol();

  slider_b.update();
  slider_b.show_struc();
  slider_b.show_mol();
  

  slider_a_is = slider_a.is_done();
  slider_b_is = slider_b.is_done();
  button_is = button.is_done();

  // dropdown.update();
  // dropdown.show_struc();
  // dropdown.set_label(dropdown.get_name() + " " + dropdown.get_value());
  // dropdown.show_value();
  // dropdown_is = dropdown.is_done();

  if(slider_a_is || slider_b_is || button_is || dropdown_is) {
    println("frameCount", frameCount);
    println("slider_a.is_done()",slider_a_is);
    println("slider_b.is_done()",slider_b_is);
    println("button.is_done()",button_is);
    println("dropdown.is_done()",dropdown_is);
  }
}
  
