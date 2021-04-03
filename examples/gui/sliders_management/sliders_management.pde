/**
* GUI CROPE EXAMPLE 
* Processing 3.5.4
* Rope Library 0.12.2.42
*
* Multiple slider
* 2021-2021
* v 1.0.3
*/
import rope.gui.slider.R_Slider;
import rope.vector.vec2;
import rope.R_State.State;

int x = 20;
int y = 50;
void setup() {
  size(400,270);
  State.init(this);
  slider_setup(x,y);
}

void draw() {
  background(255);
  // instead update(mouseX,mouseY) by this way all Crope gui pointer is update with those pointers 
  // and can be change in one place.
  State.pointer(mouseX,mouseY);
  State.event(mousePressed);
  // if press anykey you pass in multiselection mode
  State.keep_selection_is(keyPressed);
  println("current crope dna", State.get_dna_current_crope());
  for(int i = 0 ; i < slider.length ; i++) {
    println("slider[i].get_rank()",slider[i].get_rank());
  }

  // slider
  slider_draw();
}

R_Slider [] slider = new R_Slider[5];
void slider_setup(int x, int y) {
  for(int i = 0 ; i < slider.length ; i++) {
    slider[i] = new R_Slider(new vec2(x , y*i + (y / 2)), new vec2(width -(x *2),20));
    slider[i].set_molette(ELLIPSE);
    slider[i].set_value(0.75);
    slider[i].set_rank(i);
  }
}

void slider_draw() {
  for(int i = 0 ; i < slider.length ; i++) {
    slider[i].update();
    slider[i].show_structure();
    slider[i].show_molette();
  }
}
  
