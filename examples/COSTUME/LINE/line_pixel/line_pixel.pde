/**
* Line2D pixel
*
* Copyleft(c) 2022-2022
* v 0.1.0
* @author @stanlepunk
* @see https://github.com/StanLepunK/Rope
* 
*/

import rope.costume.R_Line2D;
import rope.vector.vec2;
import rope.core.Rope;
import rope.pixo.R_Pix;

R_Line2D line;
// Line line;
Rope r = new Rope();

void setup() {
  size(600,600);
  line = new R_Line2D(this);
  line.set(width/2,height/2,random(width),random(height));
  line.set_pixels(0.3, r.MAGENTA, r.CYAN);
}

void draw() {
  background(0);
  stroke(255);
  line.show_pixels(); // static, before use it, it's necessry to use function set_pixels(float normal_position, int ... colour_arg) 
  // line.show_pixels(0.3, r.MAGENTA, r.CYAN); // dynamic
}

void keyPressed() {
  if(key == 'n') {
    line.set(width/2,height/2,random(width),random(height));
    line.set_pixels(0.3, r.MAGENTA, r.CYAN);
  }
}