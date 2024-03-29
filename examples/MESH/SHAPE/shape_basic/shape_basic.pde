/**
* Rope R_Shape
* v 0.0.4
* 2019-2022
* @author @knupel
* @see https://github.com/knupel/Rope
*
*/
import rope.mesh.R_Shape;

R_Shape shape;

void setup() {
  size(400,400);
  shape = new R_Shape(this);
  shape.id_a(color(255,0,0)); // from shape.id_a(int value) to shape.id_f(int value);
  for(int i = 0 ; i < 5 ; i++) {
    float x = random(width);
    float y = random(height);
    shape.add_point(x,y);
  }
  
}

void draw() {
  background(0);
  beginShape();
  fill(shape.id().a());
  for(int i = 0 ; i < shape.get_summits() ; i++) {
    vertex(shape.get_x(i), shape.get_y(i));
  }
  endShape();
}

