/**
* R_Chose
* 2019-2021
* v 0.3.2
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
   * @param pa Processing App
   * @param summits num of summits of the shape
   */
  public R_Chose(PApplet pa, int summits) {
    super(pa,summits);
    build();
  }
  
  /**
   * 
   * @param pa Processing App
   * @param summits num of summits of the shape
   * @param other PGraphics rendering target
   */
  public R_Chose(PApplet pa, int summits, PGraphics other) {
    super(pa,summits,other);
    build();
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
  
  
  /**
   * calculate the summits.
   */
  public void calc() {
    calc(false);
  }
  

  private boolean ref_symmetria;
  protected void calc(boolean render) {
    boolean new_calc_is = false;
    if(ref_symmetria != symmetric_is()) {
      ref_symmetria = symmetric_is();
      new_calc_is = true;
    }
    if(pts == null || reset_is() || new_calc_is || angle_modified_is()) {
      calc_final_points(render);
    }
  }
  
  /**
   * 
   */
  public void is_pair() {
    if(ref_pts.length%2 != 0) {
    	this.summits = ref_pts.length+1;
    	ref_pts = new vec3[this.summits];
    	build();
    }
  }
  
  /**
   * set the reading radius list to set the summits, true reade from 0 to length and after from length to zero ;
   * if it's false read from 0 to length and after from 0 to length etc...
   * @param is set if the shape must be reflective and symetric
   */
  public void symmetric_is(boolean is) {
    symmetric_is = is;
  }
  
  /**
   * 
   * @return true if it's symetric
   */
  public boolean symmetric_is() {
    return symmetric_is;
  }

  
  // set 
  /**
   * set the number of radius you want, this one cannot exceed the number of summits.
   * @param radius list of the radisu of each summits
   */
  public void radius(float... radius) {
    if(radius.length  == 0) {
      System.err.println("class R_Chose > method radius(float... radius) radius cannot be equal to zero");
    }
    this.radius = radius;
  }

  /**
   * return the radius list
   * @return the radius value of each summit.
   */
  public float [] get_radius() {
    return radius;
  }

  /**
   * return the targeting radius, is this one is not in the list list return NaN
   * @param index of the summits
   * @return radius of target summit
   */
  public float get_radius(int index) {
    if(index >= 0 && index < radius.length) {
      return radius[index];
    } else {
      return Float.NaN;
    }
  }

  /**
   * 
   * @param render set if the render must be renderer
   * @returnlist of coordinate
   */
  private vec3 [] calc_final_points(boolean render) {
    if(pts == null || pts.length != ref_pts.length) {
      pts = new vec3[ref_pts.length];
    }
    
    int count = 0;
    int inc = 1;
    if(render) beginShape();
    for(int i = 0 ; i < ref_pts.length ; i++) {
      if(pts[i] == null) {
        pts[i] = new vec3(ref_pts[i].x,ref_pts[i].y,ref_pts[i].z);
      } else {
        pts[i].set(ref_pts[i]);
      }
      
      if(radius != null){
      	if(count < 0) count = 0;
        pts[i].mult(radius[count]);
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
        pts[i].mult(size.x*(float).5);
      }

      if(use_pos_is()) {
        pts[i].add(pos);
      }
      if(render) vertex(pts[i]);
    }
    if(render) {
      vertex(pts[0]);
      endShape();
    }
    return pts;
  }
}
