/**
* GUI CROPE EXAMPLE
* slider classic set progression curve
*
* For the moment there is only POW to set curve
*
* 2021-2021
* v 0.0.1
*/
import rope.gui.slider.R_Slider;
import rope.R_State.State;
import rope.core.Rope;

R_Slider slider;

Rope r = new Rope();
void setup() {
  size(400,200);
  State.init(this);
  setup_slider();
}

void draw() {
  background(255);
  State.pointer(mouseX,mouseY);
  State.event(mousePressed);
  draw_slider();
  
  float alt = height - slider.get_final();
  stroke(r.BLACK);
  line(0,alt,width,alt);
  State.reset_event();
}

void setup_slider() {
  slider = new R_Slider();
  slider.pos(10,10);
  slider.size(200,20);
  slider.set_range(0,height);
  int color_label = color(255,0,0);
  slider.set_fill_label(color_label);
  // curve setting
  //  For the moment there is only POW to set curve
  int type_of_curve = r.POW;
  float power_of_curve = 2.0f;
  // beyond one the result is slow at the begining
  // under 1.0 the result is increase at the beginning.
  slider.set_curve(type_of_curve,power_of_curve);
}

void draw_slider() {
  slider.update();
  slider.show_struc();
  slider.show_mol();
  r.print_tempo(30,"get():", slider.get(), slider.get_final());
}
