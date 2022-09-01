/**
* Line2D offset
*
* Copyleft(c) 2022-2022
* v 0.1.0
* @author @stanlepunk
* @see https://github.com/StanLepunK/Rope
* 
*/

import rope.costume.R_Line2D;
import rope.vector.vec2;
import rope.core.Rope;

R_Line2D line;
Rope r = new Rope();

void setup() {
  size(600,600);
  line = new R_Line2D(this);
  line.set(random(width),random(height),random(width),random(height));
}

void draw() {
  background(0);
  stroke(255);
  line.offset(new vec2(mouseX,mouseY));
  println("before",line); // the value is change
  line.show();
  println("after",line); // the value is back to origin after showing or updated.
}
