/**
 * R_Colour
 * add colour to palette
 * V 0.0.1
 * 2023-2023
*/

import rope.colour.R_Colour;
import rope.core.Rope;

Rope r = new Rope();
R_Colour palette;

void setup() {
  println(r.VERSION);
  size(400,400);
  palette = new R_Colour(this);
  int [] list_colour = palette.gradient(r.YELLOW, r.BLOOD, 20);
  printArray(list_colour);
  palette.add(list_colour);

  int len = palette.get().length;
  float step = (float)width / len;
  int x = 0;
  noStroke();
  for(int i = 0 ; i < palette.get().length ; i++) {
    fill(palette.get("palette", i));
    rect(x, 0, step, height);
    x += step;
  }
}



