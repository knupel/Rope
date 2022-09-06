/**
* Line2D 
* use angle() for rotation
* use point() to show the axe
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
  line.set(width/2,height/2,width/4,height/4);
}

void draw() {
  background(0);
  noFill();
  stroke(r.BLOOD);
  repere(4);
  fill(r.WHITE);
  stroke(r.WHITE);


  // float normal_pos = -0.1;
  float normal_pos = 0.5;
  float ang = map(mouseX,0,width,-PI,PI);
  // line.angle(ang);
  vec2 p = line.point(normal_pos);
  circle(p.x(), p.y(), 10);
  line.angle(ang, normal_pos);
  // line.angle(ang);
  line.show();
}


void repere(int num) {
  int step_x = width / num;
  int step_y = height / num;
  for(int x = 1; x < num; x++) {
    for(int y = 1 ; y < num ; y++) {
      line(0, x*step_x, width, x*step_x);
      line(y*step_y, 0, y*step_y, height);
    }
  }
  circle(width/2,height/2,r.dist(width/2,height/2,0,0));
}

