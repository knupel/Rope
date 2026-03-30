/**
* Line2D pixel
* with pixelDensity(2) or not
*
* Copyleft(c) 2022-2023
* v 0.5.0
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
R_Line2D c;
Rope r = new Rope();
// where 1 is the maximum, 
// but not sure because it's a random operation to distribute the point
float density_a = 0.8;

float thickness_b = 8.0f;
float density_b = density_a * thickness_b;
float thickness_c = thickness_b * 3;
float density_c = density_b;

boolean use_pixel_density = false;

void setup() {
  size(600,600, P2D);
  // for the case you use pixelDensity, it's better to use show_pixels_x2() after
  use_pixel_density = true;
  pixelDensity(2);
  set_lines();

}

void draw() {
  println("FPS", (int)frameRate);
  background(r.ELEPHANT);
  stroke(255);
  if(!mousePressed) {
    a.show_pixels(); // static, before use it, it's necessry to use function set_pixels(float normal_position, int ... colour_arg) 
    b.show_pixels();
    c.show_pixels();
    // a.show_pixels_x2(); // static, before use it, it's necessry to use function set_pixels(float normal_position, int ... colour_arg) 
    // b.show_pixels_x2();
    // c.show_pixels_x2();
  } else {
    // a.show_pixels(density_a, r.MAGENTA, r.CYAN); // dynamic
    // b.show_pixels(density_b, thickness_b, r.RED); // dynamic
    // c.show_pixels(density_c, thickness_c, r.MAGENTA, r.YELLOW); // dynamic
    a.set_palette(r.MAGENTA, r.CYAN);
    a.show_pixels_x2(density_a); // dynamic
    b.set_palette(r.RED);
    b.show_pixels_x2(density_b, thickness_b); // dynamic
    c.set_palette(r.MAGENTA, r.YELLOW);
    c.show_pixels_x2(density_c, thickness_c); // dynamic
  }
}

void keyPressed() {
  if(key == 'n') {
    println(">>>>>>>> new sort");
    set_lines();
  }
}

void set_lines() {
  // simple pixel line
  a = new R_Line2D(this);
  b = new R_Line2D(this);
  c = new R_Line2D(this);
  a.pixel_density_is(use_pixel_density);
  b.pixel_density_is(use_pixel_density);
  c.pixel_density_is(use_pixel_density);


  a.set(width/2,height/2,random(width),random(height));
  a.set_palette(r.MAGENTA, r.CYAN);
  a.set_pixels(density_a, 1.0);
  // pixel thickness
  
  b.set(width/2,height/2,random(width),random(height));
  b.set_palette(r.RED);
  b.set_pixels(density_b, thickness_b);
  // pixel variation on thickness and density

  // c.mode_abscissa(r.NORMAL);
  // c.mode_abscissa(r.CENTER, 3);
  c.mode_abscissa(r.SIDE, 3);
  c.mode_ordinate(r.CENTER, 1);
  c.set(width/2,height/2,random(width),random(height));
  c.set_palette(r.MAGENTA, r.YELLOW);
  c.set_pixels(density_c, thickness_c *4);
  c.growth(10, 3);
}


