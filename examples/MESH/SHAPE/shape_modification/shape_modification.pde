/**
* Rope R_Shape
* v 0.0.1
* 2019-2022
* @author @stanlepunk
* @see https://github.com/StanLepunK/Rope
*
*/
import rope.mesh.R_Shape;

R_Shape shape;

void setup() {
  size(400,400);
  shape = new R_Shape(this);
  for(int i = 0 ; i < 5 ; i++) {
    float x = random(width);
    float y = random(height);
    shape.add_point(x,y);
  }
  
}

void draw() {
  // change the second point on the list of point
  shape.set_point(1,mouseX,mouseY);
  background(0);
  beginShape();
  for(int i = 0 ; i < shape.get_summits() ; i++) {
    vertex(shape.get_x(i), shape.get_y(i));
  }
  endShape();
}

