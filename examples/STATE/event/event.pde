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

  // if(r.all(State.event().array())) {
  //   println("all event is TRUE", frameCount);
  // }

  // if(r.any(State.bang().array())) {
  //   println("ANY bang is TRUUUUUEEEEEEEEEEEE", frameCount);
  // }
  
  // if(!r.all(State.bang().array())) {
  //   println("ALL bang is FALSE", frameCount);
  // }

  // if(r.any(State.bangbang().array())) {
  //   println("any BANG BANG is true", frameCount);
  //   println(State.bangbang());
  // }

  if(r.any(State.event_mut().array())) {
    println("any MUTATION is true", frameCount);
    println(State.event_mut());
  }

  // println("pointer", State.pointer());
  State.reset_event();
}