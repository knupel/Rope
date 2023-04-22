/**
* Rope costume
* v 0.0.2
* 2019-2023
* @author @knupel
* https://github.com/knupel/Rope
*
* In this example two application of class RCurve and RBezier
*/
import rope.costume.R_Primitive;
import rope.costume.R_Star;
import rope.costume.R_Virus;
import rope.vector.*;
R_Primitive prim;
R_Star star;
R_Virus virus;
void setup() {
  size(300,300);
  prim = new R_Primitive(this,4);
  star = new R_Star(this);
  virus = new R_Virus(this);
}

void draw() {
  background(0);
  vec2 pos = new vec2(mouseX,mouseY);
  prim.pos(pos.xy().mult(.5));
  prim.size(80);
  prim.show();
  push();
  translate(pos.x(),pos.y());
  star.size(300);
  star.show();
  pop();
  //star.show(new vec2(mouseY,mouseX));
  virus.size(80);
  virus.pos(pos.yx());
  virus.show();
}
