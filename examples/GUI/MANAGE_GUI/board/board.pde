/**
* GUI CROPE EXAMPLE

* 2021-2021
* v 0.0.3
*/

import rope.gui.slider.R_Slider;
import rope.R_State.State;
import rope.gui.R_Board;
import rope.core.Rope;
import rope.vector.vec2;

R_Board board_1;
R_Board board_2;
Rope r = new Rope();

void setup() {
  size(800,800);
  State.init(this);
  vec2 pos = new vec2(10,10);
  vec2 size = new vec2(200,400);
  int marge = 20;
  boolean vert_is = true;
  board_1 = new R_Board(pos, size, vert_is);
  board_1.set_marge(marge);
  board_1.set_rounded(20);
  float step = 3;
  vec2 size_button = new vec2(20);
  board_1.add_button(size_button, step, "machin", "truc", "bidule", "bidule");
  board_1.set_value(0, "machin", 1);
  vec2 size_slider = new vec2(100,10);
  step = 5;
  board_1.add_slider(size_slider, step,  "surf", "ski", "planche");
  board_1.set_value(5, "ski", 0.5);


  pos.set(250,300);
  size.set(200,250);
  board_2 = new R_Board(pos, size, vert_is);
  board_2.set_marge(marge);
  board_2.add_slider(size_slider, step,  "choucroute", "moule frite", "paëla");
  step = 1.3;
  board_2.add_knob(size_button.x()*3, step,  "potar");

  board_2.print();
  println("board.get_name(3)",board_1.get_name(3));
  
}


void draw() {
  colorMode(HSB,TAU,1,1,1);
  background(board_2.get(3,"potar"),1,1);
  State.pointer(mouseX,mouseY);
  State.event(mousePressed, !keyPressed);
  board_1.update();
  board_1.show_board();
  board_1.show_struc();
  board_1.show_label();
  board_1.show_mol();
  board_1.show_value();

  board_2.update();
  board_2.show_board();
  board_2.show_struc();
  board_2.show_label();
  board_2.show_mol();
  board_2.show_value();
  
  // get_values();

  
  State.reset_event();

}

/**
*
* set value of your controller
* 
* R_Board set_value(String name, float... pos_norm);
* R_Board set_value(int index_crope, String name, float... pos_norm); // faster, no loop checking
*/

/**
* get values function
*
* float get(int index_crope); // faster, no loop checking, return the first value of your targeting controller
* float get(String name);
* float get(String name, int index_value);
* float get(int index_crope, String name, int index_value); // faster, no loop checking
* float get(int index_crope, String name); // faster, no loop checking
*
* float [] get_all(String name); // stop to the first occurence match with this name
* float float [] get_all(int index_crope); // faster, no loop checking
* float [] get_all(int index_crope, String name); // faster, no loop checking
*
* boolean is(int index_crope); // faster, no loop checking
* boolean is(String name);
* boolean is(int index_crope, String name); // faster, no loop checking
*/

void get_values() {
  // loop in the list until find the first occurrence that matches with the string wish
  int index_value = 0;
  String controller_name = "surf";
  r.print_tempo(30,
                "board_1.get(\"surf\")",
                board_1.get(controller_name));
  r.print_tempo(30,
                "board_1.get(\"surf\")",
                board_1.get(controller_name,index_value));
  
  // get value from board with index and name of controller that's can be faster than previous method because that's don't loop a long the list of controller
  int index_controler = 0;
  r.print_tempo(30,
                "board_1.get_all(index_controler, \"surf\")",
                board_1.get_all(index_controler, controller_name),
                "Bad index of controller");
  // here we put 
  index_controler = 4;
  r.print_tempo(30,
                "board_1.get_all(index_controler, \"surf\")",
                board_1.get_all(index_controler, controller_name)[index_value],
                "Good index of controller return an array of value");
  r.print_tempo(30,
                "board_1.get(4, \"surf\",index_value)",
                board_1.get(4, controller_name,index_value),
                "Good index of controller return the index value if this one exist");

}