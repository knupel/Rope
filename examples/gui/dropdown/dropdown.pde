/**
* GUI CROPE EXAMPLE
* Processing 3.5.4
* Rope Library 0.12.1.41
*
* 2016-2021
* v 1.2.0
* dropdown
*/

import rope.gui.R_Dropdown;
import rope.R_State.State;
import rope.vector.vec2;
import rope.core.Rope;

int x = 20 ;
int y = 20 ;
void setup() {
  size(400,200);
  State.init(this);
  dropdown_setup(x,y);
  
}


void draw() {
	background(30);
  State.pointer(mouseX,mouseY);
  State.event(mousePressed, keyPressed);
	dropdown_draw();
  State.reset_bang();
}




/**
dropdown
*/
R_Dropdown [] dropdown;
void dropdown_setup(int x, int y) {
	String [] content_0 = {"chien","chat"};
	//String [] content_0 = {"chien","chat", "poisson rouge","hamster","rat","souris"};
	String [] content_1 = {"tigre","lynx","puma","chat","panthère","lion","guepard","chat sauvage","chien"};
	// String [] content_1 = {"tigre","lynx", "puma","chat","panthère"};
	//String [] content_0 = {"chien","chat"};
	// String [] content_1 = {"tigre","lynx"};
	int num = 2;
	dropdown = new R_Dropdown[num];
	dropdown[0] = new R_Dropdown(new vec2(x,y), new vec2(60,20));
	dropdown[1] = new R_Dropdown(new vec2(x*8,y), new vec2(60,20));
	int num_box_display = 7;
	int rank_box_position = 1;

  dropdown[0].set_label("Menu de chat");
  dropdown[0].set_content(content_0);
  dropdown[0].wheel(true);
  dropdown[0].set_box(num_box_display, rank_box_position);
  float pos_val_x = dropdown[0].pos().x() + dropdown[0].get_header_text_pos().x();
  float pos_val_y = dropdown[0].pos().y() + dropdown[0].size().y() + dropdown[0].get_header_text_pos().y();
  dropdown[0].set_pos_value(pos_val_x,pos_val_y);
  
  rank_box_position = 2;
  dropdown[1].set_label("Menu de chien");
  dropdown[1].set_content(content_1);
  dropdown[1].wheel(true);
  dropdown[1].set_box(num_box_display, rank_box_position);
  pos_val_x = dropdown[1].pos().x() + dropdown[1].get_header_text_pos().x();
  pos_val_y = dropdown[1].pos().y() + dropdown[1].size().y() + dropdown[1].get_header_text_pos().y();
  dropdown[1].set_pos_value(pos_val_x,pos_val_y);

}


void dropdown_draw() {
  dropdown[0].update();
  dropdown[0].show_structure();
  // dropdown[0].show_value();
  
  dropdown[1].update();
  dropdown[1].show_structure();
  dropdown[1].show_value();
}





/**
Processing and Rope event
*/
void mouseWheel(MouseEvent e) {
  State.scroll(e);
}
