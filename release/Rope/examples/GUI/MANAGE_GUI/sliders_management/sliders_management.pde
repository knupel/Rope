/**
* GUI CROPE EXAMPLE 
* @author Knupel / Stanislas Marçais
* @see https://github.com/StanLepunK/Rope
* Multiple sliders selection
* 2021-2021
* v 1.4.0
*/
import rope.gui.slider.R_Slider;
import rope.vector.vec2;
import rope.R_State.State;
import rope.core.Rope;

int x = 20;
int y = 50;
Rope r = new Rope();
void setup() {
  size(400,270);
  State.init(this);
  setting(x,y);
}

void draw() {
  background(255);
  // instead update(mouseX,mouseY) by this way all Crope gui pointer is update with those pointers 
  // and can be change in one place.
  State.pointer(mouseX,mouseY);
  State.event(mousePressed);
  // if press anykey you pass in multiselection mode
  State.keep_selection_is(keyPressed);
  // println("current crope dna", State.get_dna_current_crope());
  // for(int i = 0 ; i < slider.length ; i++) {
  //   println("slider[i].get_rank()",slider[i].get_rank());
  //   println("slider[i].get()",slider[i].get());
  // }

  // slider
  update();
  State.reset_event();
}

R_Slider [] slider = new R_Slider[5];
void setting(int x, int y) {
  for(int i = 0 ; i < slider.length ; i++) {
    slider[i] = new R_Slider();
    slider[i].pos(x, y*i + (y / 2));
    slider[i].size(width -(x *2),20);
    slider[i].set_value(0.75);
    slider[i].set_rank(i);
  }
}

void update() {
  for(int i = 0 ; i < slider.length ; i++) {
    slider[i].update();
    slider[i].show_struc();
    slider[i].show_mol();  
  }
}
  
