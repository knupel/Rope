/**
* R_Line2D touch an area
*
* Copyleft(c) 2026-2026
* v 0.1.0
* @author @knupel
* @see https://github.com/knupel/Rope
*
* The order of operation is important, check the println to understand
* the reason is all the values are reset to reference value after the show() function
*
* https://stackoverflow.com/questions/13053061/circle-line-intersection-points
*/

import rope.mesh.R_Line2D;
import rope.vector.vec2;
import rope.core.Rope;
import rope.core.R_Graphic;

Rope r = new Rope();
R_Graphic rg;
R_Line2D line;
vec2 pos_circle;
int radius = 0;

void setup() {
  size(300,300);
  rg = new R_Graphic(this);
  vec2 a = new vec2(width/2, height/2);
  vec2 b = new vec2();
  radius = (int)random(25,50);
  pos_circle = new vec2(random(width), random(height));
  b.rand(new vec2(0,width), new vec2(0,height));
  line = new R_Line2D(this,a,b);
}


void draw() {
  background(r.LIN);
  line.stroke_is(true);
  line.thickness(1);
  line.stroke(r.BLACK);
  line.b(mouseX,mouseY);
  // put the function intersection here, because after the function show() the data is refresh
  R_Line2D buf = line.intersection(pos_circle, radius);
  line.show();

  // circle
  rg.ellipse(pos_circle, radius*2);
  // show intersection
  if(buf != null) {
        buf.stroke_is(true);
    buf.thickness(5);
    buf.stroke(r.BLOOD);

    buf.show();

  }
}

void keyPressed() {
  radius = (int)random(25,50);
  pos_circle = new vec2(random(width), random(height));

}
 



R_Line2D intersection(R_Line2D line, vec2 pos, int radius) {
  float ba_x = line.b().x() - line.a().x();
  float ba_y = line.b().y() - line.a().y();
  float ca_x = pos.x() - line.a().x();
  float ca_y = pos.y() - line.a().y();

  float a = ba_x * ba_x + ba_y * ba_y;
  float b_by_2 = ba_x * ca_x + ba_y * ca_y;
  float c = ca_x * ca_x + ca_y * ca_y - radius * radius;

  float p_by_2 = b_by_2 / a;
  float q = c / a;

  float disc = p_by_2 * p_by_2 - q;
  if (disc < 0) {
    return null;
  }

  // if disc == 0 ... dealt with later
  float buf_sqrt = sqrt(disc);
  float ab_scaling_factor_1 = -p_by_2 + buf_sqrt;
  float ab_scaling_factor_2 = -p_by_2 - buf_sqrt;

  vec2 p1 = new vec2(line.a().x() - ba_x * ab_scaling_factor_1, line.a().y() - ba_y * ab_scaling_factor_1);
  if (disc == 0) { // abScalingFactor1 == abScalingFactor2
    return new R_Line2D(this, p1, p1);
  }
  vec2 p2 = new vec2(line.a().x() - ba_x * ab_scaling_factor_2, line.a().y() - ba_y * ab_scaling_factor_2);
  return new R_Line2D(this, p1, p2);
}