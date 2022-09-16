/**
* R_Circle class
* v 0.2.1
* 2019-2021
* @author @stanlepunk
* @see https://github.com/StanLepunK/Rope
* Class RShape store the utilities to draw shape and costume
*/
package rope.costume;

import rope.vector.*;
import rope.core.*;
import rope.mesh.R_Shape;
import processing.core.*;

public class R_Circle extends R_Shape implements R_Constants, R_Shape_contract {
  private R_Bezier[] bezier;
  private float offset_angle = 0;

  /**
   * 
   * @param pa
   * @param summits
   */
  public R_Circle(PApplet pa, int summits) {
  	super(pa);
		pos(0);
		size(1);
		set_summits(summits);
		set_angle(offset_angle);
    build();
  }
  
  /**
   * 
   * @param pa
   * @param summits
   * @param other
   */
  public R_Circle(PApplet pa, int summits, PGraphics other) {
  	super(pa,other);
		pos(0);
		size(1);
		set_summits(summits);
    build();
  }
  /**
   * 
   * @param pa
   * @param summits
   * @param offset_angle
   */
  public R_Circle(PApplet pa, int summits, float offset_angle) {
    super(pa);
		pos(0);
		size(1);
		set_summits(summits);
		angle_x(offset_angle);
    build();
  }
  
  /**
   * 
   * @param pa
   * @param summits
   * @param offset_angle
   * @param other
   */
  public R_Circle(PApplet pa, int summits, float offset_angle, PGraphics other) {
    super(pa,other);
		pos(0);
		size(1);
		set_summits(summits);
		angle_x(offset_angle);
    build();
  }
  
  
  /**
   * 
   * @param offset_angle
   */
  public void set_angle(float offset_angle) {
  	angle_x(offset_angle);
  }
  
  /**
   * 
   */
  public void build() {
    bezier = new R_Bezier[summits];
    float step = (float)(1. /summits);
    float to_angle = TWO_PI *step;
    float mag = (float)( (4. /3.) *Math.tan(PI*.5 *step));
    for (int i = 0; i < summits; ++i) {
      float angle = angle_x() +i *to_angle;
      bezier[i] = new R_Bezier();
      bezier[i].from_angle(angle,mag);
    }
  }


	
	/**
	 * 
	 */
  public void show() {
  	vec3 radius = size.mult((float).5);
    R_Bezier previous_knot = bezier[0];
    R_Bezier current_knot;

    beginShape();
    vec3 temp_pos = previous_knot.pos().xyz().mult(radius).add(pos);
    vec3 closing_pos = temp_pos.copy();
    vertex(temp_pos);

    for (int i = 1 ; i <= bezier.length; i++) {
      current_knot = bezier[i%bezier.length];
      vec3 a = previous_knot.get_a().xyz().mult(radius).add(pos);
      temp_pos = current_knot.pos().xyz().mult(radius).add(pos);
      vec3 b = current_knot.get_b().xyz().mult(radius).add(pos);
      bezierVertex(a,b,temp_pos);
      previous_knot = current_knot;
    }
    // close
    vertex(closing_pos);
    endShape();
  }
  
  // GET  
  /**
   * 
   * @return
   */
  public R_Bezier [] get_bezier() {
    return bezier;
  }
  
  /**
   * 
   * @param which
   * @return
   */
  public R_Bezier get_bezier(int which) {
    if(which >= 0 && which < bezier.length) {
      return bezier[which];
    } else {
      return null;
    }
  }
}
