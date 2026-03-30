/**
 * R_Colour
 * add colour to palette
 * V 0.0.1
 * 2023-2023
*/

import rope.colour.R_Colour;
import rope.core.Rope;

Rope r = new Rope();
R_Colour rc;

void setup() {
  println(r.VERSION);
  size(400,400);
  rc = new R_Colour(this, "palette", r.MAGENTA, r.YELLOW, r.CYAN);
  rc.print_palette();
  rc.add("palette", r.MAGENTA);
  rc.print_palette();
  rc.remove("palette", 0);
  int c = color(random(255), random(255), random(255));
  rc.add("autre palette", c);
  rc.print_palette();
  background(rc.get_colour("palette", 0));
  rc.clear();
  rc.print_palette();
  rc.kill();
  rc.print_palette(); // nothing
  
}
