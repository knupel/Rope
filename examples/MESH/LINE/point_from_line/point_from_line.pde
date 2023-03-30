/**
 * * R_Line2D create a point from the line, on the line
 * 
* Copyleft(c) 2022-2023
* v 0.2.0
* @author @knupel
* @see https://github.com/knupel/Rope/blob/master/src/rope/mesh/R_Line2D.java
*
* 
*/

import rope.mesh.R_Line2D;
import rope.vector.vec2;

R_Line2D line;
vec2 a = new vec2();
vec2 b = new vec2();
vec2 c = new vec2();
vec2 d = new vec2();
float marge = 100;
float abscissa = 0.5;
float ordinate = 0.5;

void setup() {
  size(400,400,P2D);
  set();

}


void draw() {
  background(255);
  
  if(mousePressed) {
    line.set_a(mouseX,mouseY); // the change is defitive
    abscissa = map(sin(frameCount * 0.01), -1,1, -0.4, 1.4);
    ordinate = map(sin(frameCount * 0.01), -1,1, -0.5, 0.5);
    c = line.get_point(abscissa);
    d = line.get_point(abscissa, ordinate);
  }
  line.show();
  circle(c.x(), c.y(), 10);
  circle(d.x(), d.y(), 10);
}

void keyPressed() {
  if(key == 'n') {
    set();
  }
}

void set() {
    float pos = random(marge, width - marge);
  a = new vec2(marge,pos);
  pos = random(marge, width - marge);
  b = new vec2(width - marge, pos);
  line = new R_Line2D(this, a, b);
  c = line.get_point(abscissa);
  d = line.get_point(abscissa, ordinate);

}



