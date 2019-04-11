/**
* R_Chose
* 2019-2019
* v 0.1.1
* @author @stanlepunk
* @see https://github.com/StanLepunK/Rope
*/
package rope.costume;

import rope.vector.*;
import processing.core.*;

public class R_Chose extends R_Polygon {
  private float [] radius;
  private boolean symmetric_is;

  public R_Chose(PApplet pa, int summits) {
    super(pa,summits);
    build();
  }
  
  public R_Chose(PApplet pa, int summits, PGraphics other) {
    super(pa,summits,other);
    build();
  }

  private boolean ref_symmetria;
  public void show() {
    boolean new_calc_is = false;
    if(ref_symmetria != symmetric_is()) {
      ref_symmetria = symmetric_is();
      new_calc_is = true;
    }
    if(final_pts == null || reset_is() || new_calc_is) {
      calc_final_points(true);
    } else {
      beginShape();
      for(int i = 0 ; i < final_pts.length ; i++) {
        vertex(final_pts[i]);
      }
      vertex(final_pts[0]);
      endShape();
    }
  }



  public void is_pair() {
    if(pts.length%2 != 0) {
    	this.summits = pts.length+1;
    	pts = new vec3[this.summits];
    	build(0);
    }
  }

  public void symmetric_is(boolean is) {
    symmetric_is = is;
  }

  public boolean symmetric_is() {
    return symmetric_is;
  }

  
  // set 
  public void set_radius(float... radius) {
    this.radius = radius;
  }


  // get
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
