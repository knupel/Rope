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
import rope.vector.vec;
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




  public ArrayList <R_Line2D> intersection(vec2 pos, int radius, boolean check_segment_is) {
    // https://stackoverflow.com/questions/481144/equation-for-testing-if-a-point-is-inside-a-circle
    ArrayList <R_Line2D> lines = new ArrayList();
    R_Line2D line_0 = line.intersection(pos, radius);

    boolean a_is = false;
    boolean b_is = false;

    if(check_segment_is) {
      a_is = in_circle(line.a(), pos, radius);
      b_is = in_circle(line.b(), pos, radius);

    }

    if(r.all(a_is, b_is)) {
      line.id_a(1); // EN COURS
      lines.add(line);
    } else {
      line_0.id_a(0); // EN COURS
      lines.add(line_0);
    }

    return lines;
  }



  public boolean in_circle(vec point, vec pos, int radius) {
    float dx = abs(point.x()-pos.x());
    if(dx > radius) return false;
    float dy = abs(point.y()-pos.y());
    if(dy > radius) return false;
    if ( dx+dy <= radius ) {
      return true;
    }
    return (dx*dx + dy*dy <= radius*radius);
  }