/**
* Rope R_Shape
* v 0.0.3
* 2019-2022
* @author @stanlepunk
* @see https://github.com/StanLepunK/Rope
*
*/
import rope.mesh.R_Shape;
import rope.vector.*;

R_Shape shape_a;
R_Shape shape_b;

void setup() {
  vec2 a = new vec2(10,10);
  vec2 b = new vec2(10,20);
  vec2 c = new vec2(20,20);
  vec2 d = new vec2(20,10);
  shape_a = new R_Shape(this);
  shape_a.add_points(a,b,c,d);
  shape_b = new R_Shape(this);
  shape_b.add_points(a,c,b,d);
  
    
  println("shape a", shape_a.area());

  // area work only with classical polygons
  println("shape b", shape_b.area());


	background(0);
	draw_polygon(shape_b);
  
}

void draw_polygon(R_Shape shape) {
	beginShape();
  for(int i = 0 ; i < shape.get_summits() ; i++) {
    vertex(shape.get_x(i), shape.get_y(i));
  }
  endShape();
}






