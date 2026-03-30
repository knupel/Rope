/**
* R_Line2D intersection
*
* Copyleft(c) 2019-2022
* v 0.2.0
* @author @stanlepunk
* @see https://github.com/StanLepunK/Rope
*
* The order of operation is important, check the println to understand
* the reason is all the values are reset to reference value after the show() function
* 
*/

import rope.mesh.R_Line2D;
import rope.vector.vec2;
import rope.core.Rope;

Rope r = new Rope();
R_Line2D line_a,line_b;

void setup() {
  size(300,300);
  vec2 a = new vec2(0,0);
  vec2 b = new vec2(width,height);
  line_a = new R_Line2D(this,a, b);
  a.rand(new vec2(0,width), new vec2(0,height));
  b.rand(new vec2(0,width), new vec2(0,height));
  line_b = new R_Line2D(this,a,b);
}


void draw() {
  background(r.LIN);
  println("B0",line_b);
  line_b.b(mouseX,mouseY);
  println("B 1",line_b);
  vec2 node = line_a.intersection(line_b);
  println("B 2",line_b);
  float dist = line_b.dist();
  println("B 3",line_b);
  vec2 middle = line_b.coord((int)dist/2);
   println("B 4",line_b);
  vec2 coord_norm = line_b.coord(0.25);
   println("B 5",line_b);
  
  strokeWeight(10);
  stroke(r.GREEN);
  point(middle.x(),middle.y());
  stroke(r.LAPIS_LAZULI);
  point(coord_norm.x(),coord_norm.y());
  stroke(r.RED);
  if(node != null) {
    point(node.x(),node.y());
  }
  
  strokeWeight(1);
  stroke(0);
  line_a.show();
  line_b.show();
  println("B 6",line_b);
}
