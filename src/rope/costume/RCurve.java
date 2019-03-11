/**
* RCurve class
* v 0.0.3
* 2019-2019
* @author @stanlepunk
* @see https://github.com/StanLepunK/Rope
* Class RShape store the utilities to draw shape and costume
*/
package rope.costume;

import rope.vector.*;
import rope.core.*;
import processing.core.*;

public class RCurve extends RShape implements RConstants{
  RBezier[] bezier;

  public RCurve(PApplet pa,int num) {
  	super(pa);
    float offset_angle = 0;
    build(num,offset_angle);
  }
  
  public RCurve(PApplet pa,int num, PGraphics other) {
  	super(pa,other);
    float offset_angle = 0;
    build(num,offset_angle);
  }

  private void build(int num, float offset_angle) {
  	if(num < 2) {
      num = 2;
      System.err.println("class Curve: the construtor need minimum 2 points to build Curve,\nsorry the class add the minimum require points to make your desire real");
    }
    bezier = new RBezier[num];
    float step = (float)(1. /num);
    float to_angle = TWO_PI *step;
    float mag = (float)( (4. /3.) *Math.tan(PI*.5 *step));
    for (int i = 0; i < num; ++i) {
      float angle = offset_angle +i *to_angle;
      bezier[i] = new RBezier();
      bezier[i].from_angle(angle,mag);
    }
  }

  public void show(vec pos, float radius) {
    RBezier previous_knot = bezier[0];
    RBezier current_knot;

    beginShape();

    vec3 temp_pos = previous_knot.get_pos().xyz().mult(radius).add(pos);
    vec3 closing_pos = temp_pos.copy();
    vertex(temp_pos);

    for (int i = 1 ; i <= bezier.length; i++) {
      current_knot = bezier[i%bezier.length];
      vec3 a = previous_knot.get_a().xyz().mult(radius).add(pos);
      temp_pos = current_knot.get_pos().xyz().mult(radius).add(pos);
      vec3 b = current_knot.get_b().xyz().mult(radius).add(pos);
      bezierVertex(a,b,temp_pos);
      previous_knot = current_knot;
    }
    // close
    vertex(closing_pos);
    endShape();
  }

  public RBezier [] get_bezier() {
    return bezier;
  }

  public RBezier get_bezier(int which) {
    if(which >= 0 && which < bezier.length) {
      return bezier[which];
    } else {
      return null;
    }
  }
}
