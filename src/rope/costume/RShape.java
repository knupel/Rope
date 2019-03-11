/**
* RShape class
* v 0.0.1
* 2019-2019
* @author @stanlepunk
* @see https://github.com/StanLepunK/Rope
* Class RShape store the utilities to draw shape and costume
*/
package rope.costume;

import rope.core.RConstants;
import rope.core.RImage;
import rope.vector.*;
import processing.core.*;


public class RShape extends RImage implements RConstants {
	processing.core.PGraphics other;
	/**
	 * 
	 * @param pa
	 */
	public RShape(PApplet pa) {
		super(pa);
	}
	
	/**
	 * 
	 * @param pa
	 * @param other
	 */
	public RShape(PApplet pa, PGraphics other) {
		super(pa);
		this.other = other;
	}
	
	/**
	 * ghost method
	 */
	public void beginShape() {
		if(other != null) {
			other.beginShape();
		} else {
			pg.beginShape();
		}
	}
	
	/**
	 * ghost method
	 */
	public void endShape() {
		if(other != null) {
			other.endShape();
		} else {
			pg.endShape();
		}
	}
	
	
	/**
	 * VERTEX PART
	 */
	
	/**
	 * ghost method
	 * @param x x-coordinate of the vertex
	 * @param y y-coordinate of the vertex
	 */
	public void vertex(float x, float y) {
		// pg.vertex(x,y);
		if(other != null) {
			other.vertex(x,y);
		} else {
			pg.vertex(x,y);
		}
	}
	
	/**
	 * ( begin auto-generated from vertex.xml )
	 * ghost method
   * All shapes are constructed by connecting a series of vertices.
   * <b>vertex()</b> is used to specify the vertex coordinates for points,
   * lines, triangles, quads, and polygons and is used exclusively within the
   * <b>beginShape()</b> and <b>endShape()</b> function.<br />
   * <br />
   * Drawing a vertex in 3D using the <b>z</b> parameter requires the P3D
   * parameter in combination with size as shown in the above example.<br />
   * <br />
   *    *
   * ( end auto-generated )
	 * @param x x-coordinate of the vertex
	 * @param y y-coordinate of the vertex
	 * @param z z-coordinate of the vertex
	 */
	public void vertex(float x, float y, float z) {	
		if(other != null) {
			if(renderer_P3D()) {
				other.vertex(x,y,z);	
			}
		} else {
			if(renderer_P3D()) {
				pg.vertex(x,y,z);	
			}
		}
	}
	
	/**
	 * 
	 * @param v 
	 */
	public void vertex(vec v) {
		if(other != null) {
			if(renderer_P3D()) {
				other.vertex(v.x,v.y,v.z);	
			} else {
				other.vertex(v.x,v.y);	
			}
		} else {
			if(renderer_P3D()) {
				pg.vertex(v.x,v.y,v.z);	
			} else {
				pg.vertex(v.x,v.y);	
			}
		}
	}
	
	
	/**
	 * BEZIER VERTEX PART
	 */
	/**
	 * ( begin auto-generated from bezierVertex.xml )
   *
   * Specifies vertex coordinates for Bezier curves. Each call to
   * <b>bezierVertex()</b> defines the position of two control points and one
   * anchor point of a Bezier curve, adding a new segment to a line or shape.
   * The first time <b>bezierVertex()</b> is used within a
   * <b>beginShape()</b> call, it must be prefaced with a call to
   * <b>vertex()</b> to set the first anchor point. This function must be
   * used between <b>beginShape()</b> and <b>endShape()</b> and only when
   * there is no MODE parameter specified to <b>beginShape()</b>. Using the
   * 3D version requires rendering with P3D (see the Environment reference
   * for more information).
   *
   * ( end auto-generated )
	 * ghost method
	 * @param x2 the x-coordinate of the 1st control point
	 * @param y2 the y-coordinate of the 1st control point
	 * @param x3 the x-coordinate of the 2nd control point
	 * @param y3 the y-coordinate of the 2nd control point
	 * @param x4 the x-coordinate of the anchor point
	 * @param y4 the y-coordinate of the anchor point
	 */
	public void bezierVertex(	float x2, float y2,
      											float x3, float y3,
      											float x4, float y4) {
		if(other != null) {
			other.bezierVertex(x2,y2,x3,y3,x4,y4);
		} else {
			pg.bezierVertex(x2,y2,x3,y3,x4,y4);
		}
	}
	
	/**
	 * Ghost method
	 * @param x2 the x-coordinate of the 1st control point
	 * @param y2 the y-coordinate of the 1st control point
	 * @param z2 the z-coordinate of the 1st control point
	 * @param x3 the x-coordinate of the 2nd control point
	 * @param y3 the y-coordinate of the 2nd control point
	 * @param z3 the z-coordinate of the 2nd control point
	 * @param x4 the x-coordinate of the anchor point
	 * @param y4 the y-coordinate of the anchor point
	 * @param z4 the z-coordinate of the anchor point
	 */
  public void bezierVertex(	float x2, float y2, float z2,
  													float x3, float y3, float z3,
  													float x4, float y4, float z4) {
  	if(other != null) {
			other.bezierVertex(x2,y2,z2,x3,y3,z3,x4,y4,z4);
		} else {
			pg.bezierVertex(x2,y2,z2,x3,y3,z3,x4,y4,z4);
		}
  }
  /**
   * 
   * @param a x,y,z coordinate of the 1st control point
   * @param b x,y,z coordinate of the 2st control point
   * @param pos x,y,z coordinate of the anchor point
   */
  public void bezierVertex(vec a, vec b, vec pos){
  	if(other != null) {
			if(renderer_P3D()) {
				other.bezierVertex(a.x,a.y,a.z, b.x,b.y,b.z, pos.x,pos.y,pos.z);	
			} else {
				other.bezierVertex(a.x,a.y ,b.x,b.y, pos.x,pos.y);	
			}
		} else {
			if(renderer_P3D()) {
				pg.bezierVertex(a.x,a.y,a.z, b.x,b.y,b.z, pos.x,pos.y,pos.z);	
			} else {
				pg.bezierVertex(a.x,a.y ,b.x,b.y, pos.x,pos.y);	
			}
		}
}
  
  
  /**
   * Ghost method
   * @param cx the x-coordinate of the control point
   * @param cy the y-coordinate of the control point
   * @param x3 the x-coordinate of the anchor point
   * @param y3 the y-coordinate of the anchor point
   */
  
  /*
  public void quadraticVertex(float cx, float cy,
                              float x3, float y3) {
  	if(other != null) {
			other.quadraticVertex(cx,cy,x3,y3);
		} else {
			pg.quadraticVertex(cx,cy,x3,y3);
		}
  }
  */
  
  
  /**
   * Ghost method
   * @param cx the x-coordinate of the control point
   * @param cy the y-coordinate of the control point
   * @param cz the z-coordinate of the control point
   * @param x3 the x-coordinate of the anchor point
   * @param y3 the y-coordinate of the anchor point
   * @param z3 the z-coordinate of the anchor point
   */
  /*
  public void quadraticVertex(float cx, float cy, float cz,
                              float x3, float y3, float z3) {
  	if(other != null) {
			other.quadraticVertex(cx,cy,cz,x3,y3,z3);
		} else {
			pg.quadraticVertex(cx,cy,cz,x3,y3,z3);
		}
  }
  */
  
  
  /**
   * ( begin auto-generated from curveVertex.xml )
   *
   * Specifies vertex coordinates for curves. This function may only be used
   * between <b>beginShape()</b> and <b>endShape()</b> and only when there is
   * no MODE parameter specified to <b>beginShape()</b>. The first and last
   * points in a series of <b>curveVertex()</b> lines will be used to guide
   * the beginning and end of a the curve. A minimum of four points is
   * required to draw a tiny curve between the second and third points.
   * Adding a fifth point with <b>curveVertex()</b> will draw the curve
   * between the second, third, and fourth points. The <b>curveVertex()</b>
   * function is an implementation of Catmull-Rom splines. Using the 3D
   * version requires rendering with P3D (see the Environment reference for
   * more information).
   *
   * ( end auto-generated )
   *
   * @param x the x-coordinate of the vertex
   * @param y the y-coordinate of the vertex
   */
  public void curveVertex(float x, float y) {
  	if(other != null) {
			other.curveVertex(x,y);
		} else {
			pg.curveVertex(x,y);
		}
  }


  /**
   * @param x the x-coordinate of the vertex
   * @param y the y-coordinate of the vertex
   * @param z the z-coordinate of the vertex
   */
  public void curveVertex(float x, float y, float z) {
  	if(other != null) {
			other.curveVertex(x,y,z);
		} else {
			pg.curveVertex(x,y,z);
		}
  }
  
  /**
   * 
   * @param pos the x,y,z ccordinate of the vertex
   */
  public void curveVertex(vec pos){
  	if(other != null) {
			if(renderer_P3D()) {
				other.curveVertex(pos.x,pos.y,pos.z);	
			} else {
				other.curveVertex(pos.x,pos.y);	
			}
		} else {
			if(renderer_P3D()) {
				pg.curveVertex(pos.x,pos.y,pos.z);	
			} else {
				pg.curveVertex(pos.x,pos.y);	
			}
		}
  }
	

}
