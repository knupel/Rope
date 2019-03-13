/**
* Rope Circle
* @author @stanlepunk
* @see https://github.com/StanLepunK/Rope
*
* In this example two application of class RCurve and RBezier
*/
import rope.vector.*;
import rope.costume.RCurve;
import rope.costume.RBezier;
RCurve exotic_circle;
void setup() {
  colorMode(HSB,1,1,1,1);
  background(0);
  size(300,300);
  // circle_setup(); 
  circle_setup_on_pg();
}

void draw() {
  // println((int)frameRate);
  background(0);
  float hue = abs(sin(frameCount *.005));
  fill(hue,1,1);
  noStroke();
  
  // draw_circle();
  draw_circle_on_pg();
}

// example 1
void circle_setup() {
  exotic_circle = new RCurve(this,4);
}

void draw_circle() {
  for(RBezier b :exotic_circle.get_bezier()) {
    vec2 trouble = new vec2().sin_wave(frameCount,.01,.1);
    b.set_a(trouble);
    trouble = new vec2().cos_wave(frameCount,.1,.01);
    b.set_b(trouble);
  }
  vec2 pos = new vec2(width/2,height/2);
  float radius = height /3;
  exotic_circle.show(pos,radius);
}


// example 2
PGraphics pg;
void circle_setup_on_pg() {
  pg = createGraphics(width/2,height/2);
  exotic_circle = new RCurve(this,64,pg);
}

void draw_circle_on_pg() {
  // start begin draw on your PGraphics
  pg.beginDraw();
  // the library assume to draw on pg after you pass it in the constructor.
  for(RBezier b : exotic_circle.get_bezier()) {
    vec2 trouble = new vec2().sin_wave(frameCount,.01,.02);
    b.set_a(trouble);
    trouble = new vec2().cos_wave(frameCount,.02,.01);
    b.set_b(trouble);
  }
  vec2 pos = new vec2(pg.width/2,pg.height/2);
  float radius = 10 + abs(sin(frameCount *.01))*(pg.height *.66);
  exotic_circle.show(pos,radius);

  // end begin draw on your PGraphics
  pg.endDraw();
  image(pg,0,0);
}
