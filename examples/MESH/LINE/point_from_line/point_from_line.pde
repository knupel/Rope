/**
 * * R_Line2D create a point from the line, on the line
 * 
* Copyleft(c) 2022-2022
* v 0.0.1
* @author @stanlepunk
* https://github.com/StanLepunK/Rope/
*
* 
*/

import rope.mesh.R_Line2D;
import rope.vector.vec2;

R_Line2D line;
vec2 a = new vec2();
vec2 b = new vec2();
vec2 c = new vec2();
float marge = 100;

void setup() {
  size(400,400,P2D);
  float pos = random(marge, width - marge);
  a = new vec2(marge,pos);
  pos = random(marge, width - marge);
  b = new vec2(width - marge, pos);
  line = new R_Line2D(this, a, b);
  c = line.point(0.5);

}


void draw() {
  background(255);
  
  if(mousePressed) {
    line.set_a(mouseX,mouseY); // the change is defitive
    //line.a(mouseX,mouseY); // only temporary changement
    float pos = map(sin(frameCount * 0.01), -1,1, -0.4, 1.4);
    c = line.point(pos);
  }
  line.show();
  circle(c.x(), c.y(), 10);
}

void keyPressed() {
  if(key == 'n') {
    float pos = random(marge, width - marge);
    a.y(pos);
    pos = random(marge, width - marge);
    b.y(pos);
    line.set(a,b);
    pos = map(random(1), 0, 1, -0.4, 1.4);
    c = line.point(pos);
  }
}



