/**
* GUI CROPE EXAMPLE
* Processing 3.5.4
* Rope Library 0.12.1.41
*
* 2021-2021
* v 0.0.1
* slider classic with setting
*/
import rope.gui.slider.R_Slider;
import rope.vector.vec2;
import rope.R_State.State;
import rope.core.Rope;

int x = 50;
int y = 50;
Rope r = new Rope();
void setup() {
  size(400,200);
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
  slider_draw();

  State.reset_event();
}

R_Slider slider ;
void slider_setup(int x, int y) {
  slider = new R_Slider(new vec2(x,y), new vec2(200,20));
  int color_label = color(255,0,0);
  slider.set_fill_label(color_label);
  int lab_x = 5;
  int lab_y = 30;
  slider.set_label("position et couleur du label et de sa valeur", lab_x, lab_y);
  slider.set_pos_value(lab_x, lab_y + 20);

  slider.set_mol(ELLIPSE);
  slider.set_rounded(20);

  slider.set_value(0.75);
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

  // for the simple slider the index is "zero"
  r.print_tempo(30,"get():", slider.get());
}
  
