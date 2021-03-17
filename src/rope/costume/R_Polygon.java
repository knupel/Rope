/**
* R_Polygon
* v 0.3.2
* 2019-2021
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

    if(angle_x() != 0) {
      angle = angle_x();
    }

    for(int i = 0 ; i < summits ; i++) {
      float x = (float)Math.sin(angle_step*i +angle);
      float y = (float)Math.cos(angle_step*i +angle);
      float z = 0;
      if(ref_pts[i] == null) {
        ref_pts[i] = new vec3(x,y,z);
      } else {
        ref_pts[i].set(x,y,z);
      }
    }
  }

  
  /**
   * 
   */
  public void show() {
    calc(true);
    if(pts != null && pts.length > 0) {
      beginShape();
      for(int i = 0 ; i < pts.length ; i++) {
        vertex(pts[i]);
      }
      vertex(pts[0]);
      endShape();
    } 
  }
  

  public void calc() {
    calc(false);
  }

  protected void calc(boolean render) {
    if(pts == null || reset_is() || angle_modified_is()) {
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
    if(ref_angle != angle_x()) {
      angle_modified_is = true;
      build();
      ref_angle = angle_x();
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
    if(pts == null || pts.length != ref_pts.length) {
      pts = new vec3[ref_pts.length];
    }
    if(render) beginShape();
    for(int i = 0 ; i < ref_pts.length ; i++) {
      if(pts[i] == null) {
        pts[i] = new vec3(ref_pts[i].x,ref_pts[i].y,ref_pts[i].z);
      } else {
        pts[i].set(ref_pts[i]);
      }

      pts[i].mult(size.x*(float)0.5);
      if(use_pos_is()) pts[i].add(pos);
      if(render) vertex(pts[i]);
    }
    if(render) {
      vertex(pts[0]);
      endShape();
    }
    return pts;
  }
}