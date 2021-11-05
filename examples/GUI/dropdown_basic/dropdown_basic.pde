/**
* GUI CROPE EXAMPLE
* Processing 3.5.4
*
* 2021-2021
* v 0.1.0
* dropdown basic
*/

import rope.gui.R_Dropdown;
import rope.R_State.State;
import rope.core.Rope;

Rope r = new Rope();
R_Dropdown dropdown;


void setup() {
  size(400,200);
  println(r.VERSION);
  State.init(this);
  dropdown = new R_Dropdown();
  dropdown.wheel(true);
  dropdown.set_label("Animal");
  dropdown.set_content("chat", "chien", "souris");

  int num_box_display = 4;
  int rank_box_position = 1;
  dropdown.set_box(num_box_display, rank_box_position);
}

void draw() {
	background(r.BLACK);
  State.pointer(mouseX,mouseY);
  State.event(mousePressed);

  dropdown.update();
  dropdown.show_struc();
  dropdown.show_value();
  
  State.reset_event();
}

void mouseWheel(MouseEvent e) {
  State.scroll(e);
}

