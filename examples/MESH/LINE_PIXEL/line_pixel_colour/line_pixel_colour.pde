/**
 * 
 * color example
 * 2023-2023
 * v 0.1.1
 * 
*/

import rope.mesh.R_Line2D;
import rope.core.Rope;

Rope r = new Rope();


R_Line2D a;
R_Line2D b;

void setup() {
  size(500,500);
  background(r.TENEBRE);
  stroke(r.MOON);
  strokeWeight(2);
  noFill();
  show();

}

void draw() {}

void keyPressed() {
  background(r.TENEBRE);
  if(key == 'n') {
    show();
  }
}

void show() {
    a = new R_Line2D(this);
  b = new R_Line2D(this);
  int ax = width/4;
  int bx = width - width/4;
  int ay = height/3;
  int by = height - height/3;
  a.set(ax, ay, bx, ay);
  int type = r.CHAOS;
  float density = 1.0f;
  int len = 50;
  int step = 2;
  boolean use_gradient = true;
  boolean use_field = true;
  // if you use gradient the color palette work by pair
  // the first is the line and the second is the top of the growth.
  a.growth_option(use_field, type, use_gradient);
  a.set_palette(r.MAGENTA, r.CYAN);
  a.set_pixels(density);
  a.growth(len,step, 0, PI);
  a.show_pixels();

  b.set(ax, by, bx, by);
  use_field = true;
  b.growth_option(use_field, type, use_gradient);
  b.set_palette(r.MAGENTA, r.CYAN, r.MAGENTA, r.YELLOW);
  b.set_pixels(density);
  b.growth(len,step, 0, -PI/4, PI/4);
  b.show_pixels();

}
