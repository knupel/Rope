/**
* State event
* Processing 3.5.4
*/

import rope.R_State.State;
import rope.core.Rope;


Rope r = new Rope();

void setup() {
  println(r.VERSION);
  size(400,400);
  State.init(this);

}

void draw() {
  State.pointer(mouseX,mouseY);
  State.event(mousePressed, keyPressed);

  if(r.all(State.event().array())) {
    println("all event is TRUE", frameCount);
  }

  if(r.any(State.bang().array())) {
    println("any BANG BANG is true", frameCount);
    printArray(State.bang().array());
  }

  // println("pointer", State.pointer());
  State.reset_bang();
}