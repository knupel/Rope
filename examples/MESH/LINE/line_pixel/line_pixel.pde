/**
* Line2D pixel
*
* Copyleft(c) 2022-2023
* v 0.2.0
* @author @knupel
* @see https://github.com/knupel/Rope/blob/master/src/rope/mesh/R_Line2D.java
* 
*/

import rope.mesh.R_Line2D;
import rope.vector.vec2;
import rope.core.Rope;
import rope.pixo.R_Pix;

R_Line2D a;
R_Line2D b;
Rope r = new Rope();
// where 1 is the maximum, 
// but not sure because it's a random operation to distribute the point
float density_a = 0.3;

float thickness = 8.0f;
float density_b = density_a * thickness; 

void setup() {
  size(600,600);
  set_lines();

}

void draw() {
  background(0);
  stroke(255);
  if(mousePressed) {
    a.show_pixels(); // static, before use it, it's necessry to use function set_pixels(float normal_position, int ... colour_arg) 
    b.show_pixels();
    } else {
    a.show_pixels(density_a, r.MAGENTA, r.CYAN); // dynamic
    b.show_pixels(density_b, thickness, r.RED, r.YELLOW); // dynamic
  }
}

void keyPressed() {
  if(key == 'n') {
    set_lines();
  }
}

void set_lines() {
  // simple pixel line
  a = new R_Line2D(this);
  a.set(width/2,height/2,random(width),random(height));
  a.set_pixels(density_a, r.MAGENTA, r.CYAN);
  // advance pixel line
  b = new R_Line2D(this);
  b.set(width/2,height/2,random(width),random(height));
  b.set_pixels(density_b, thickness, r.RED, r.YELLOW);
}