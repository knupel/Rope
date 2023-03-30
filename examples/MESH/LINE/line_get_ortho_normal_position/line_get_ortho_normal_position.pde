/**
* R_Line2D find the othographic projection on the line and find the normal value too 
* Copyleft(c) 2022-2022
* v 0.0.1
* @author @knupel
* @see https://github.com/knupel/Rope/blob/master/src/rope/mesh/R_Line2D.java
*
* 
*/

import rope.mesh.R_Line2D;
import rope.vector.vec2;
import rope.core.Rope;

R_Line2D line;
vec2 p = new vec2();
Rope r = new Rope();

void setup() {
  size(400,400,P2D);
  line = new R_Line2D(this);
  init();
}


void draw() {
  background(0);
  noFill();
  stroke(255);
  line.show();
  noFill();
  fill(r.YELLOW);
  circle(line.a().x(), line.a().y(),10);
  circle(line.b().x(), line.b().y(),10);
  
  vec2 o = line.ortho(p);
  line(p.x(), p.y(), o.x(), o.y());
  fill(r.CYAN);
  circle(p.x(), p.y(),20);
  fill(r.MAGENTA);
  circle(o.x(), o.y(),20);
  println("o normal", line.normal(o));
}

void keyPressed() {
  if(key =='n') {
    init();
  }
}

void init() {
  vec2 a = new vec2().rand(new vec2(), new vec2(width,height));
  vec2 b = new vec2().rand(new vec2(), new vec2(width,height));
  p.set(new vec2().rand(new vec2(), new vec2(width,height)));
  line.set(a,b);
}



