/**
* R_Polygon
* v 0.3.0
* 2019-2019
* @author @stanlepunk
* @see https://github.com/StanLepunK/Rope
*/
package rope.costume;

import rope.vector.*;
import rope.core.*;
import processing.core.*;

public class R_Polygon extends R_Shape implements R_Constants, R_Shape_contract {
	/**
	 * 
	 * @param pa
	 * @param summits
	 */
  public R_Polygon(PApplet pa, int summits) {
    super(pa,summits);
    build();
  }
  
  /**
   * 
   * @param pa
   * @param summits
   * @param other
   */
  public R_Polygon(PApplet pa, int summits, PGraphics other) {
    super(pa,summits,other);
    build();
  }
  
  /**
   * 
   */
  public void build() {
    float angle_step = (2*PI)/summits;
    float angle = 0;
    if(summits == 4) {
      angle = PI/4;
    } else if(summits%2 != 0) {
      angle = PI;
    }

    if(get_angle() != 0) {
      angle = get_angle();
    }

    for(int i = 0 ; i < summits ; i++) {
      float x = (float)Math.sin(angle_step*i +angle);
      float y = (float)Math.cos(angle_step*i +angle);
      float z = 0;
      if(pts[i] == null) {
        pts[i] = new vec3(x,y,z);
      } else {
        pts[i].set(x,y,z);
      }
    }
  }

  
  /**
   * 
   */
  public void show() {
    calc(true);
    if(final_pts != null && final_pts.length > 0) {
      beginShape();
      for(int i = 0 ; i < final_pts.length ; i++) {
        vertex(final_pts[i]);
      }
      vertex(final_pts[0]);
      endShape();
    } 
  }
  

  public void calc() {
    calc(false);
  }

  protected void calc(boolean render) {
    if(final_pts == null || reset_is() || angle_modified_is()) {
      calc_final_points(render);
    }
  }
  
  
  /**
   * 
   * @return
   */
  float ref_angle;
  boolean angle_modified_is() {
    boolean angle_modified_is = false;
    if(ref_angle != get_angle()) {
      angle_modified_is = true;
      build();
      ref_angle = get_angle();
    }
    return angle_modified_is;
  }



  // set
  /**
   * 
   * @param radius
   */
  public void radius(int radius) {
    size(radius*2);
  }

  // get
  /**
   * 
   * @param render
   * @return
   */
  private vec3 [] calc_final_points(boolean render) {
    if(final_pts == null || final_pts.length != pts.length) {
      final_pts = new vec3[pts.length];
    }
    if(render) beginShape();
    for(int i = 0 ; i < pts.length ; i++) {
      if(final_pts[i] == null) {
        final_pts[i] = new vec3(pts[i].x,pts[i].y,pts[i].z);
      } else {
        final_pts[i].set(pts[i]);
      }

      final_pts[i].mult(size.x*(float)0.5);
      if(use_pos_is()) final_pts[i].add(pos);
      if(render) vertex(final_pts[i]);
    }
    if(render) {
      vertex(final_pts[0]);
      endShape();
    }
    return final_pts;
  }
}