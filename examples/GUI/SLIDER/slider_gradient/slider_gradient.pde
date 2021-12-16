/**
* GUI CROPE EXAMPLE
* Processing 3.5.4
* Rope Library 0.12.1.41
*
* 2016-2021
* v 1.2.1
* slider classic
*/
import rope.gui.slider.R_Slider;
import rope.vector.vec2;
import rope.R_State.State;
import rope.core.Rope;

int x = 50;
int y = 50;
Rope r;
void setup() {
  size(400,200, P2D);
  r = new Rope();
  State.init(this);
  slider_setup(x,y);
}

void draw() {
  background(255);
  // instead update(mouseX,mouseY) by this way all Crope gui pointer is update with those pointers 
  // and can be change in one place.
  State.pointer(mouseX,mouseY);
  State.event(mousePressed);

  // slider
  fill(r.BLOOD);
  stroke(r.BLACK);
  strokeWeight(2);
  ellipse(mouseX,mouseY, 50,50);
  
  slider_draw();
  State.reset_event();
}

R_Slider slider ;
void slider_setup(int x, int y) {
  slider = new R_Slider(new vec2(x,y), new vec2(200,20));
  slider.set_label("Paye ton slide");
  slider.set_mol(ELLIPSE);
  slider.set_stroke(r.BLACK);
  slider.set_thickness(2);
  slider.set_rounded(20);
  slider.set_value(0.75);
  slider.opengl(true);
  slider.set_mode(0); // spectrum
}


void slider_draw() {
  slider.update();
  slider.show_struc();
  slider.show_mol();
  slider.show_label();

  if(keyPressed) {
    // add array value display under the label, useful when the slider value has mapped
    float new_value = 100 * slider.get(0);
    slider.show_value(new_value);
  } else {
    // display the normal array value return by the slider
    slider.show_value(); 
  }
}
  
