/**
* GUI CROPE EXAMPLE
* Processing 3.5.4

* 2021-2021
* v 0.01
*/

import rope.gui.slider.R_Slider;
import rope.R_State.State;
import rope.gui.R_Board;
import rope.core.Rope;
import rope.vector.vec2;

R_Board b1,b2;
Rope r = new Rope();

void setup() {
  r.print_out(r.VERSION);
  size(800,800);
  State.init(this);
  vec2 pos = new vec2(10);
  vec2 size = new vec2(200,200);
  int marge = 20;
  boolean vert_is = true;
  b1 = new R_Board(pos, size, vert_is);
  b1.set_marge(marge);
  b1.set_rounded(20);

  b2 = new R_Board(pos.add_x(size.x() + marge), size, vert_is);
  b2.set_marge(marge);

  
  float step = 3;
  vec2 size_button = new vec2(20);
  b1.add_button(size_button, step, "machin", "truc", "bidule", "bidule");
  vec2 size_slider = new vec2(100,10);
  step = 5;
  b1.add_slider(size_slider, step,  "surf", "ski", "planche");
  b2.add_slider(size_slider, step,  "choucroute", "moule frite", "paëla");

  b1.print_pairs();
  println("board.get_name(3)",b1.get_name(3));
  
}


void draw() {
  background(255);
  State.pointer(mouseX,mouseY);
  State.event(mousePressed, !keyPressed);
  b1.update();
  b1.show_board();
  b1.show_structure();
  b1.show_label();
  b1.show_molette();
  b1.show_value();

  b2.update();
  b2.show_board();
  b2.show_structure();
  b2.show_label();
  b2.show_molette();
  b2.show_value();
  
  get_values();
  
  State.reset_event();

}

/**
* get values function
*
* float get(int index_crope);
* float get(String name);
* float get(String name, int index_value);
* float get(int index_crope, String name, int index_value);
* float get(int index_crope, String name);
* float float [] get_all(int index_crope);
* float [] get_all(int index, String name);
*/
void get_values() {
  // loop in the list until find the first occurrence that matches with the string wish
  int index_value = 0;
  String controller_name = "surf";
  r.print_tempo(30,
                "b1.get(\"surf\")",
                b1.get(controller_name));
  r.print_tempo(30,
                "b1.get(\"surf\")",
                b1.get(controller_name,index_value));
  
  // get value from board with index and name of controller that's can be faster than previous method because that's don't loop a long the list of controller
  int index_controler = 0;
  r.print_tempo(30,
                "b1.get_all(index_controler, \"surf\")",
                b1.get_all(index_controler, controller_name),
                "Bad index of controller");
  // here we put 
  index_controler = 4;
  r.print_tempo(30,
                "b1.get_all(index_controler, \"surf\")",
                b1.get_all(index_controler, controller_name)[index_value],
                "Good index of controller return an array of value");
  r.print_tempo(30,
                "b1.get(4, \"surf\",index_value)",
                b1.get(4, controller_name,index_value),
                "Good index of controller return the index value if this one exist");

}