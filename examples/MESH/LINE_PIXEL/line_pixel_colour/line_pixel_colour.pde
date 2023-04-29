/**
 * 
 * color example
 * 2023-2023
 * v 0.1.0
 * 
*/

import rope.mesh.R_Line2D;
import rope.core.Rope;

Rope r = new Rope();


R_Line2D a;
R_Line2D b;

void setup() {
  size(500,500);
  a = new R_Line2D(this);
  b = new R_Line2D(this);
  int ax = width/4;
  int bx = width - width/4;
  int ay = height/3;
  int by = height - height/3;
  a.set(ax, ay, bx, ay);
  b.set(ax, by, bx, by);
  a.set_palette(r.MAGENTA, r.BLACK);
  a.set_pixels(0.5);
  a.show_pixels();
  b.show();
}
