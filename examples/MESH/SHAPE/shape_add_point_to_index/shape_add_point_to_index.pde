/**
* Rope R_Shape
* v 0.0.3
* 2019-2022
* @author @stanlepunk
* @see https://github.com/StanLepunK/Rope
*
*/
import rope.mesh.R_Shape;
import rope.vector.vec2;

R_Shape shape;
float marge = 40;

void setup() {
  size(400,400); 
  shape = new R_Shape(this);
  vec2 a = new vec2(marge);
  vec2 b = new vec2(width - marge, marge);
  vec2 c = new vec2(width - marge, height -marge);
  vec2 d = new vec2(marge, height -marge);
  shape.add_points(a,b,c,d);
}

void draw() {
  background(0);
  beginShape();
  for(int i = 0 ; i < shape.get_summits() ; i++) {
    vertex(shape.get_x(i), shape.get_y(i));
  }
  endShape();
}

void keyPressed() {
  vec2 new_1 = new vec2().rand(marge, width- marge);
  vec2 new_2 = new vec2().rand(marge, width- marge);
  vec2 new_3 = new vec2().rand(marge, width- marge);
  vec2 new_4 = new vec2().rand(marge, width- marge);
  if(key == '1') {
    shape.add_points(1,new_1);
  }

  if(key == '2') {
    shape.add_points(2,new_1, new_2);
  }

  if(key == '3') {
    shape.add_points(3,new_1, new_2, new_3);
  }
  if(key == '4') {
    shape.add_points(4,new_1, new_2, new_3, new_4);
  }

  if(key == 'n') {
    shape.clear();
    vec2 a = new vec2(marge);
    vec2 b = new vec2(width - marge, marge);
    vec2 c = new vec2(width - marge, height -marge);
    vec2 d = new vec2(marge, height -marge);
    shape.add_points(a,b,c,d);
  }
}

