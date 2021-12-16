/**
* GUI CROPE EXAMPLE
* Processing 3.5.4
* Rope Library 0.12.1.41
* 2016-2021
* v 1.2.1
* slider adjustable
*/

import rope.R_State.State;
import rope.gui.slider.R_Sladj;
import rope.vector.vec2;


int x = 20 ;
int y = 20 ;
void setup() {
  size(400,200);
  State.init(this);
  
  slider_adjustable_setup(x,y);

}

/**
* adjute the min and max of your slider by click and move 
* the handle of the average line that you see in the middle of the slider
*/
void draw() {
	background(0);
    // instead update(mouseX,mouseY) by this way all Crope gui pointer is update with those pointers 
  // and can be change in one place.
  State.pointer(mouseX,mouseY); 
  State.event(mousePressed);
  State.select_adj_is(mousePressed);

	slider_adjustable_draw();
  State.reset_event();
}




/**
ADJUTABLE
*/
R_Sladj sladj ;
void slider_adjustable_setup(int x, int y) {
	sladj = new R_Sladj(new vec2(x,y), new vec2(200,20));
  sladj.set_mol(ELLIPSE);
  sladj.set_rounded(20);
  sladj.set_value(.25);
  // slider.wheel(true);
}


void slider_adjustable_draw() {
	sladj.update();
	if(!sladj.inside_max() && !sladj.locked_max_is()) {
    sladj.inside_min();
    sladj.select_min(keyPressed);
    sladj.update_min();
  }
  // max molette
  if(!sladj.inside_min() && !sladj.locked_min_is()) {
    sladj.inside_max();
    sladj.select_max(keyPressed);
    sladj.update_max();
  }
  sladj.update_min_max();

	sladj.show_struc();
	sladj.show_adj();
	sladj.show_mol();
}
