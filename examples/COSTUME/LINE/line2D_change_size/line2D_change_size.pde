/**
 * * R_Line2D change size dynamicly
 * 
 * 
* Copyleft(c) 2022-2022
* v 0.0.1
* @author @stanlepunk
* https://github.com/StanLepunK/Rope/
*
* 
*/

import rope.costume.R_Line2D;
import rope.vector.vec2;

R_Line2D line;
vec2 a = new vec2();
vec2 b = new vec2();

void setup() {

  size(400,400,P2D);
  line = new R_Line2D(this);
  a = new vec2(width/4,height/2);
  b = new vec2(width-(width/4), height/2);
  line.set(a,b);

}


void draw() {
  background(0);
  noFill();
  stroke(255);
  // note the start and end value is normal from 0 to 1, to have a change mapped on the original size of your line
  float start = map(mouseX,0,width,-1,1);
  float end = map(mouseY,0,height,-1,1);
  println("start", start, "end",end);
  line.change(start,end);
  line.show();
  circle(a.x(), a.y(),10);
  circle(b.x(), b.y(),10);

}



