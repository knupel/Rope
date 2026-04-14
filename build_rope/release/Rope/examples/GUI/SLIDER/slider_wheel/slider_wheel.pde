/**
* GUI CROPE EXAMPLE
* @author Knupel / Stanislas Marçais
* @see https://github.com/StanLepunK/Rope
* 2016-2021
* v 1.2.2
* slider wheel
*/
import rope.gui.slider.R_Slider;
import rope.vector.vec2;
import rope.R_State.State;

int x = 50;
int y = 50;
void setup() {
  size(400,200);
  State.init(this);
  slider_setup(x,y);
}

void draw() {
  background(255);
  State.pointer(mouseX,mouseY);
  State.event(mousePressed);
  slider_draw();
  State.reset_event();
}

R_Slider slider ;
void slider_setup(int x, int y) {
  slider = new R_Slider(new vec2(x,y), new vec2(200,20));
  slider.set_label("Wheel well well");
  slider.wheel(true);
}

void slider_draw() {
  slider.update();
  slider.show_struc();
  slider.show_mol();
  slider.show_label();
  slider.show_value();
}

void mouseWheel(MouseEvent e) {
  State.scroll(e);
}
