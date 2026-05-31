/**
* cut segment with normal key point
* 2026-2026
*/

import rope.mesh.R_Line2D;
import rope.vector.vec2;
import rope.core.Rope;

Rope r = new Rope();
R_Line2D a;
R_Line2D [] a_cut;
vec2 [] arr = new vec2[5];


void setup() {
  size(800,800);
  background(255);
  create_keys();
  a_cut = a.cut();
}

void draw() {
  background(255);
  a.show();
  float val = frameCount * 0.01;
  for(R_Line2D l : a_cut) {
    l.rotation(val, 0.5);
    l.show();
  }
}

void keyPressed() {
  create_keys();
  a_cut = a.cut();
}


void create_keys() {
  // add normal float argument array
  a = new R_Line2D(this, new vec2().rand(0, width), new vec2().rand(0, height));
  a.add_keys(random(1),random(1),random(1),random(1),random(1),random(1),random(1));
}
