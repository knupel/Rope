/**
* Rope Circle
* v 0.0.3
* 2019-2023
* @author @knupel
* https://github.com/knupel/Rope
*
* In this example two application of class RCurve and RBezier
*/
import rope.vector.*;
import rope.costume.R_Circle;
import rope.utils.R_Bezier;
R_Circle exotic_circle;
void setup() {
  colorMode(HSB,1,1,1,1);
  background(0);
  size(300,300);
  circle_setup(); 
  // circle_setup_on_pg();
}

void draw() {
  // println((int)frameRate);
  background(0);
  float hue = abs(sin(frameCount *.005));
  fill(hue,1,1);
  noStroke();
  
  draw_circle();
  // draw_circle_on_pg();
}

// example 1
void circle_setup() {
  exotic_circle = new R_Circle(this,4);
}

void draw_circle() {
  for(R_Bezier b :exotic_circle.get_bezier()) {
    vec2 trouble = new vec2().sin_wave(frameCount,.01,.1);
    b.set_a(trouble);
    trouble = new vec2().cos_wave(frameCount,.1,.01);
    b.set_b(trouble);
  }
  vec2 pos = new vec2(width/2,height/2);
  int diam = height;
  exotic_circle.pos(pos);
  exotic_circle.size(diam);
  exotic_circle.show();
}


// example 2
PGraphics pg;
void circle_setup_on_pg() {
  pg = createGraphics(width/2,height/2);
  exotic_circle = new R_Circle(this,64,pg);
}

void draw_circle_on_pg() {
  // start begin draw on your PGraphics
  pg.beginDraw();
  // the library assume to draw on pg after you pass it in the constructor.
  for(R_Bezier b : exotic_circle.get_bezier()) {
    vec2 trouble = new vec2().sin_wave(frameCount,.01,.02);
    b.set_a(trouble);
    trouble = new vec2().cos_wave(frameCount,.02,.01);
    b.set_b(trouble);
  }
  vec2 pos = new vec2(pg.width/2,pg.height/2);
  int diam = int(10 + abs(sin(frameCount *.01))*(pg.height *.66));
  exotic_circle.pos(pos);
  exotic_circle.size(diam);
  exotic_circle.show();

  // end begin draw on your PGraphics
  pg.endDraw();
  image(pg,0,0);
}
