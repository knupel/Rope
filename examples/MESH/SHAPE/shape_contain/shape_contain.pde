/**
* Rope R_Shape
* v 0.0.3
* 2019-2022
* @author @stanlepunk
* @see https://github.com/StanLepunK/Rope
*
* 
* Check if a list of point is contained in the R_Shape
*/

import rope.mesh.R_Shape;
import rope.vector.*;

R_Shape shape;

void setup() {
  vec2 [] v = new vec2[10];
  for(int i = 0 ; i < v.length ; i++) {
    v[i] = new vec2().rand(0,width/2);
  }
  shape = new R_Shape(this);
  shape.add_points(v);

  vec2 other = new vec2(width/2, height/2);
  println("other", other); 
  printArray(shape.equals(v[0], v[2], other));
  // int max = 2;
  // shape.equals(max, v[0], v[2], other);
  // float marge = 1.5;
  // shape.compare(max, marge, v[0], v[2], other);
  // shape.compare(marge, v[0], v[2], other);
}

  







