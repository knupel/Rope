/**
* Line2D intersection
*
* Copyleft (c) 2014-2019
* @author @stanlepunk
* @see https://github.com/StanLepunK/Rope
* 
* dependancies
* Processing 3.5.3
* Rope library 0.8.5.30
*/

import rope.costume.R_Line2D;
import rope.vector.*;

R_Line2D line_a,line_b;

void setup() {
  size(300,300);
  line_a = new R_Line2D(this,new vec2(0,0), new vec2(width,height));
  line_b = new R_Line2D(this,new vec2().rand(new vec2(0,width), new vec2(0,height)), new vec2().rand(new vec2(0,width), new vec2(0,height)));
}


void draw() {
  background(255);
  vec2 node = line_a.intersection(line_b);
  line_b.b(mouseX,mouseY);
  float dist = line_b.dist();
  vec2 middle = line_b.coord((int)dist/2);
  vec2 coord_norm = line_b.coord(0.25);
  
  strokeWeight(10);
  stroke(0,255,0);
  point(middle.x(),middle.y());
  stroke(0,0,255);
  point(coord_norm.x(),coord_norm.y());
  stroke(255,0,0);
  if(node != null) point(node.x(),node.y());
  
  strokeWeight(1);
  stroke(0);
  line_a.show();
  line_b.show();
}
