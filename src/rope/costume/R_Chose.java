/**
* R_Chose
* 2019-2019
* v 0.3.0
* @author @stanlepunk
* @see https://github.com/StanLepunK/Rope
*/
package rope.costume;

import rope.vector.*;
import processing.core.*;

public class R_Chose extends R_Polygon {
  private float [] radius;
  private boolean symmetric_is;
  
  /**
   * 
   * @param pa
   * @param summits
   */
  public R_Chose(PApplet pa, int summits) {
    super(pa,summits);
    build();
  }
  
  /**
   * 
   * @param pa
   * @param summits
   * @param other
   */
  public R_Chose(PApplet pa, int summits, PGraphics other) {
    super(pa,summits,other);
    build();
  }

  
  public void calc() {
    calc(false);
  }
  /**
   * 
   */
  private boolean ref_symmetria;
  protected void calc(boolean render) {
    boolean new_calc_is = false;
    if(ref_symmetria != symmetric_is()) {
      ref_symmetria = symmetric_is();
      new_calc_is = true;
    }
    if(final_pts == null || reset_is() || new_calc_is || angle_modified_is()) {
      calc_final_points(render);
    }
  }
  
  /**
   * 
   */
  public void is_pair() {
    if(pts.length%2 != 0) {
    	this.summits = pts.length+1;
    	pts = new vec3[this.summits];
    	build();
    }
  }
  
  /**
   * 
   * @param is
   */
  public void symmetric_is(boolean is) {
    symmetric_is = is;
  }
  
  /**
   * 
   * @return
   */
  public boolean symmetric_is() {
    return symmetric_is;
  }

  
  // set 
  /**
   * 
   * @param radius
   */
  public void radius(float... radius) {
    if(radius.length  == 0) {
      System.err.println("class R_Chose > method radius(float... radius) radius cannot be equal to zero");
    }
    this.radius = radius;
  }

  /**
   * 
   * @param render
   * @return
   */
  private vec3 [] calc_final_points(boolean render) {

    if(final_pts == null || final_pts.length != pts.length) {
      final_pts = new vec3[pts.length];
    }
    
    int count = 0;
    int inc = 1;
    if(render) beginShape();
    for(int i = 0 ; i < pts.length ; i++) {
      if(final_pts[i] == null) {
        final_pts[i] = new vec3(pts[i].x,pts[i].y,pts[i].z);
      } else {
        final_pts[i].set(pts[i]);
      }
      
      if(radius != null){
      	if(count < 0) count = 0;
        final_pts[i].mult(radius[count]);
        count += inc;
        if(symmetric_is() && count%radius.length == 0) {
          inc *= -1;
          // for the first reverse count
          if(count >= radius.length) {
            count--;
          }
        } else if(!symmetric_is() && count >= radius.length) {
          count = 0;
        }
      } else {
        final_pts[i].mult(size.x*(float).5);
      }

      if(use_pos_is()) {
        final_pts[i].add(pos);
      }
      if(render) vertex(final_pts[i]);
    }
    if(render) {
      vertex(final_pts[0]);
      endShape();
    }
    return final_pts;
  }
}
