/**
 * R_Colour
 * add colour to palette
 * V 0.0.2
 * 2023-2026
*/

import rope.colour.R_Colour;
import rope.core.Rope;

Rope r = new Rope();
R_Colour rc;

void setup() {
  println(r.VERSION);
  size(400,400);
  rc = new R_Colour(this, "palette", r.MAGENTA, r.YELLOW, r.CYAN);
  println("palette length", rc.get("palette").length);
  rc.print_palette();
  rc.add("palette", r.MAGENTA);
  println("palette length", rc.get("palette").length);
  rc.print_palette();
  rc.remove("palette", 0);
  int c = color(random(255), random(255), random(255));
  rc.add("autre palette", c);
  rc.print_palette();
  
  background(rc.get("palette", 0));

}

void draw() { }



void keyPressed() {
  if(key == 'n') {
    int c = rc.rand();
    println("color", c);
    background(c);
  }

  if(key == 'd') {
    // the palette is clear, stay only one colour : Black
    rc.clear();
    rc.print_palette();
    rc.print_palette(); // nothing
  }

  if(key == 'k') {
    // no more list of palettes availlable
    // take a care that's can be lead to a null pointer exception if you try to acced to palette
    rc.kill();
  }
}
