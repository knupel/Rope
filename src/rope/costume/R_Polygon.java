/**
* R_Polygon
* v 0.1.0
* 2019-2019
* @author @stanlepunk
* @see https://github.com/StanLepunK/Rope
*/
package rope.costume;

import rope.vector.*;
import rope.core.*;
import processing.core.*;

public class R_Polygon extends R_Shape implements R_Constants, R_Shape_contract {
  public R_Polygon(PApplet pa, int summits) {
    super(pa,summits);
    build();
  }

  public R_Polygon(PApplet pa, int summits, PGraphics other) {
    super(pa,summits,other);
    build();
  }
  
  public void build() {
  	build(0);
  }

  public void build(float angle_offset) {
    float angle_step = (2*PI)/summits;
    float angle = 0;
    if(summits == 4) {
      angle = PI/4;
    } else if(summits%2 != 0) {
      angle = PI;
    }

    if(angle_offset != 0) {
      angle += angle_offset;
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
    if(final_pts == null || reset_is()) {
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


  // set
  public void set_angle(float angle_offset) {
    build(angle_offset);
  }

  public void radius(int radius) {
    size(radius*2);
  }

  // get
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