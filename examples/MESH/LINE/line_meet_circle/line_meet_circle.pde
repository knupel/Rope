/**
* R_Line2D circle meet the segment line
*
* Copyleft(c) 2026-2026
* v 0.1.0
* @author @knupel
* @see https://github.com/knupel/Rope
*
* algorithm meed_is based from
* https://stackoverflow.com/questions/1073336/circle-line-segment-collision-detection-algorithm
*/


import rope.mesh.R_Line2D;
import rope.vector.vec;
import rope.vector.vec2;

R_Line2D line;
vec2 pos = new vec2();
void setup() {
  float marge = 100;
  size(600,600);
  line = new R_Line2D(this, width - marge, height - marge, marge, marge);
}

void draw() {
  float radius = 25;
  background(0);
  stroke(255);
  line.show();
  pos.set(mouseX,mouseY);
  
  if(line.meet_is(pos, radius)) {
    fill(255,0,0);
  } else {
    fill(255,255,0);
  }
  circle(pos.x(), pos.y(), radius*2);
  
}
