/**
* RShape class
* v 0.3.0
* 2019-2019
* @author @stanlepunk
* @see https://github.com/StanLepunK/Rope
* Class RShape store the utilities to draw shape and costume
*/
package rope.costume;

import rope.core.*;
import rope.vector.*;
import processing.core.*;


public class R_Shape extends R_Image implements R_Constants {
	processing.core.PGraphics other;
	public vec3 pos;
	public vec3 size;
	public int summits;
	public vec3 [] pts;
	public vec3 [] final_pts;

	protected float angle_offset = 0;

	private boolean use_pos_is = true;
  private boolean reset_is = false;
	/**
	 * 
	 * @param pa
	 */
	public R_Shape(PApplet pa) {
		super(pa);
	}

	/**
	 * 
	 * @param pa
	 * @param other
	 */
	public R_Shape(PApplet pa, PGraphics other) {
		super(pa);
		this.other = other;
	}
  
	/**
	 * 
	 * @param pa
	 * @param summits
	 */
	public R_Shape(PApplet pa, int summits) {
		super(pa);
		this.summits = summits;
    pts = new vec3[summits];  
	}
	
	/**
	 * 
	 * @param pa
	 * @param summits
	 * @param other
	 */
	public R_Shape(PApplet pa, int summits, PGraphics other) {
		super(pa);
		this.other = other;
		this.summits = summits;
    pts = new vec3[summits];  
	}
	
	
	/**
	 * METHODES for child classes
	 */
	// SET
  /**
   * 
   * @param angle_offset
   */
	public void angle(float angle_offset) {
		this.angle_offset = angle_offset;
	}
	
	/**
   * 
   * @param is
   */
  public void use_pos_is(boolean is) {
    use_pos_is = is;
  }
  
  /**
   * 
   * @param is
   */
  public void reset_is(boolean is) {
    this.reset_is = is;
  }
  
  /**
   * 
   * @param p
   */
	public void pos(float p) {
		pos(new vec3(p));
	}
	
	/**
	 * 
	 * @param x
	 * @param y
	 */
	public void pos(float x, float y) {
		pos(new vec2(x,y));
	}
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @param z
	 */
	public void pos(float x, float y, float z) {
		pos(new vec3(x,y,z));
	}
	
	/**
	 * 
	 * @param pos
	 */
	public void pos(ivec pos) {
		pos(new vec3(pos));
	}
	
	/**
	 * 
	 * @param pos
	 */
	public void pos(vec pos) {
		if(this.pos == null) {
			this.pos = new vec3(pos);
		} else {
			this.pos.set(pos);
		}
	}
	
	/**
	 * 
	 * @param s
	 */
	public void size(int s) {
		size(new vec3(s,s,s));
	}
	
	/**
	 * 
	 * @param w
	 * @param h
	 */
	public void size(int w, int h) {
		size(new vec2(w,h));
	}
	
	/**
	 * 
	 * @param w
	 * @param h
	 * @param d
	 */
	public void size(int w, int h, int d) {
		size(new vec3(w,h,d));
	}
	
	/**
	 * 
	 * @param size
	 */
	public void size(ivec size) {
		size(new vec3(size));
	}
	
	/**
	 * 
	 * @param size
	 */
	public void size(vec size) {
		if(this.size == null) {
			this.size = new vec3(size);
		} else {
			this.size.set(size);
		}
	}
	
	
	// GET
	/**
	 * 
	 * @return
	 */
	public float get_angle() {
  	return this.angle_offset;
  }
	
	/**
   * 
   * @return
   */
  public boolean use_pos_is() {
    return use_pos_is;
  }

    /**
   * 
   * @return
   */
  public boolean reset_is() {
    return reset_is;
  }

  /**
   * 
   * @return
   */
	public vec3 pos() {
		return pos;
	}
	
	/**
	 * 
	 * @return
	 */
	public vec3 size() {
		return size;
	}
	
	/**
	 * 
	 * @return
	 */
	public int get_summits() {
    return summits;
  }

  public vec3 [] get_points() {
    return pts;
  }
  
  /**
   * 
   * @param target
   * @return
   */
  public vec3 get_point(int target) {
  	if(pts != null && target >= 0 && target < pts.length) {
  		return pts[target];
  	} else {
  		return null;
  	}  
  }
  
  /**
   * 
   * @return
   */
  public vec3 [] get_final_points() {
    return final_pts;
  }
  
  /**
   * 
   * @param target
   * @return
   */
  public vec3 get_final_point(int target) {
  	if(final_pts != null && target >= 0 && target < final_pts.length) {
  		return final_pts[target];
  	} else {
  		return null;
  	}  
  }

	
	
	
	
	
	/**
	 * ghost method
	 */
	public void pushMatrix() {
		if(other != null) {
			other.pushMatrix();
		} else {
			pa.g.pushMatrix();
		}
  }

	/**
	 * ghost method
	 */
	public void popMatrix() {
		if(other != null) {
			other.popMatrix();
		} else {
			pa.g.popMatrix();
		}
  }
	/**
	 * ghost method
	 */
	
	/*
	public void push() {
		if(other != null) {
			other.push();
		} else {
			pa.g.push();
		}
  }
  */

	/**
	 * ghost method
	 */
	/*
	public void pop() {
		if(other != null) {
			other.pop();
		} else {
			pa.g.pop();
		}
  }*/
	
	/**
	 * ghost method
	 * @param x
	 * @param y
	 * @param z
	 */
	public void translate(float x, float y, float z) {
		if(other != null) {
			other.translate(x,y,z);
		} else {
			pa.g.translate(x,y,z);
		}
  }
	
	/**
	 * 
	 * @param x
	 * @param y
	 */
	public void translate(float x, float y) {
		if(other != null) {
			other.translate(x,y);
		} else {
			pa.g.translate(x,y);
		}
  }
	
	/**
	 *
	 * @param v
	 */
	public void translate(vec v) {
		if(renderer_P3D()) {
			translate(v.x,v.y,v.z);	
		} else {
			translate(v.x,v.y);
		}
  }
	
	/**
	 *
	 * @param v
	 */
	public void translate(ivec v) {
		if(renderer_P3D()) {
			translate(v.x,v.y,v.z);	
		} else {
			translate(v.x,v.y);
		}
	}
	
	
	
	/**
	 * ghost method
	 * @param angle
	 */
	public void rotate(float angle) {
		if(other != null) {
			other.rotate(angle);
		} else {
			pa.g.rotate(angle);
		}
  }
	
	/**
	 * ghost method
	 * @param angle
	 */
	public void rotateX(float angle) {
		if(other != null) {
			other.rotateX(angle);
		} else {
			pa.g.rotateX(angle);
		}
  }
	
	/**
	 * ghost method
	 * @param angle
	 */
	public void rotateY(float angle) {
		if(other != null) {
			other.rotateY(angle);
		} else {
			pa.g.rotateY(angle);
		}
  }
	
	/**
	 * ghost method
	 * @param angle
	 */
	public void rotateZ(float angle) {
		if(other != null) {
			other.rotateZ(angle);
		} else {
			pa.g.rotateZ(angle);
		}
  }
	
	
	
	
	
	
	
	
	

	/**
	 * ghost method
	 */
	public void beginShape() {
		if(other != null) {
			other.beginShape();
		} else {
			pa.g.beginShape();
		}
	}
	
	/**
	 * ghost method
	 */
	public void endShape() {
		if(other != null) {
			other.endShape();
		} else {
			pa.g.endShape();
		}
	}
	
	/**
	 * for an unknown reason this method from Processing cause an error compilation
	 * ghost method
	 */
	/*
	public void endShape(int mode) {
		if(other != null) {
			other.endShape(mode);
		} else {
			pa.g.endShape(mode);
		}
	}
	*/
	
	
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
			pa.g.vertex(x,y);
		}
	}
	
	/**
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
				pa.g.vertex(x,y,z);	
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
				pa.g.vertex(v.x,v.y,v.z);	
			} else {
				pa.g.vertex(v.x,v.y);	
			}
		}
	}
	
	
	/**
	 * BEZIER VERTEX PART
	 */
	/**
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
			pa.g.bezierVertex(x2,y2,x3,y3,x4,y4);
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
			pa.g.bezierVertex(x2,y2,z2,x3,y3,z3,x4,y4,z4);
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
				pa.g.bezierVertex(a.x,a.y,a.z, b.x,b.y,b.z, pos.x,pos.y,pos.z);	
			} else {
				pa.g.bezierVertex(a.x,a.y ,b.x,b.y, pos.x,pos.y);	
			}
		}
}
  
  
  /**
   * for an unknown reason this method from Processing cause an error compilation
   * 
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
   * for an unknown reason this method from Processing cause an error compilation
   * 
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
   * @param x the x-coordinate of the vertex
   * @param y the y-coordinate of the vertex
   */
  public void curveVertex(float x, float y) {
  	if(other != null) {
			other.curveVertex(x,y);
		} else {
			pa.g.curveVertex(x,y);
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
			pa.g.curveVertex(x,y,z);
		}
  }
  
  /**
   * 
   * @param pos the x,y,z coordinate of the vertex
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
				pa.g.curveVertex(pos.x,pos.y,pos.z);	
			} else {
				pa.g.curveVertex(pos.x,pos.y);	
			}
		}
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  /**
   * SHAPE PART
   */
  
  /**
   * ghost method
   * @param x x-coordinate of the point
   * @param y y-coordinate of the point
   */
  public void point(float x, float y) {
  	if(other != null) {
			other.point(x,y);
		} else {
			pa.g.point(x,y);
		}
  }
  
  /**
   * ghost method
   * @param x x-coordinate of the point
   * @param y y-coordinate of the point
   * @param z z-coordinate of the point
   */
  public void point(float x, float y, float z) {
  	if(other != null) {
			other.point(x,y,z);
		} else {
			pa.g.point(x,y,z);
		}
  }
  
  /**
   * @param pos x,y,z-coordinate of the point
   */
  public void point(vec pos){
    if(renderer_P3D()) point(pos.x,pos.y,pos.z); 
    else point(pos.x,pos.y);
  }
  
  /**
   * @param pos x,y,z-coordinate of the point
   */
  public void point(ivec pos){
    if(renderer_P3D()) point(pos.x,pos.y,pos.z); 
    else point(pos.x,pos.y);
  }
  
  
  /**
   * ghost method
   * @param x1 x-coordinate of the first point
   * @param y1 y-coordinate of the first point
   * @param x2 x-coordinate of the second point
   * @param y2 y-coordinate of the second point
   */
  public void line(float x1, float y1, float x2, float y2) {
  	if(other != null) {
			other.line(x1,y1, x2,y2);
		} else {
			pa.g.line(x1,y1, x2,y2);
		}
  }


  /**
   * ghost method
   * @param z1 z-coordinate of the first point
   * @param z2 z-coordinate of the second point
   */
  public void line(float x1, float y1, float z1,
                   float x2, float y2, float z2) {
  	if(other != null) {
			other.line(x1,y1,z1, x2,y2,z2);
		} else {
			pa.g.line(x1,y1,z1, x2,y2,z2);
		}
  }
  
  /**
   * 
   * @param a
   * @param b
   */
  public void line(vec2 a, vec2 b){
    line(a.x,a.y,b.x,b.y);
  }
  
  /**
   * 
   * @param a
   * @param b
   */
  public void line(vec a, vec b){
    if(renderer_P3D()) line(a.x,a.y,a.z,b.x,b.y,b.z); 
    else line(a.x,a.y,b.x,b.y);
  }

  /**
   * 
   * @param a
   * @param b
   */
  public void line(ivec a, ivec b) {
    if(renderer_P3D()) line(a.x,a.y,a.z,b.x,b.y,b.z); 
    else line(a.x,a.y,b.x,b.y);
  }
  
  
  /**
   * @param x1 x-coordinate of the first point
   * @param y1 y-coordinate of the first point
   * @param x2 x-coordinate of the second point
   * @param y2 y-coordinate of the second point
   * @param x3 x-coordinate of the third point
   * @param y3 y-coordinate of the third point
   * @see PApplet#beginShape()
   */
  public void triangle(	float x1, float y1, 
  											float x2, float y2,
  											float x3, float y3) {
  	if(other != null) {
			other.triangle(x1,y1, x2,y2, x3,y3);
		} else {
			pa.g.triangle(x1,y1, x2,y2, x3,y3);
		}
  }
  
  /**
   * Triangle Rope
   * @param a
   * @param b
   * @param c
   */
  public void triangle(ivec a, ivec b, ivec c) {
    triangle(new vec3(a.x,a.y,a.z), new vec3(b.x,b.y,b.z), new vec3(c.x,c.y,c.z));
  }
  
  /**
   * Triangle Rope
   * @param a
   * @param b
   * @param c
   */
  public void triangle(vec a, vec b, vec c) {
    if(a.z == 0 && b.z == 0 && c.z == 0) {
      triangle(a.x,a.y,b.x,b.y,c.x,c.y);
    } else {
      if(renderer_P3D()) {
        beginShape();
        vertex(a.x,a.y,a.z);
        vertex(b.x,b.y,b.z);
        vertex(c.x,c.y,c.z);
        vertex(a.x,a.y,a.z); // close
        endShape();
      } else {
        triangle(a.x,a.y,b.x,b.y,c.x,c.y);
      }
    }
  }
  
 
  
  /**
   * @param x x-coordinate of the rectangle by default
   * @param y y-coordinate of the rectangle by default
   * @param extent width and height of the rectangle by default
   */
	public void square(float x, float y, float extent) {
  	if(other != null) {
			other.rect(x,y,extent,extent);
		} else {
			pa.g.rect(x,y,extent,extent);
		}
  	/*
  	 * for some unknown reason this method from Processing cause an error compilation
  	if(other != null) {
			other.square(x,y,extent);
		} else {
			pg.square(x,y,extent);
		}
		*/
  }
	
  /**
   * @webref shape:attributes
   * @param mode either CORNER, CORNERS, CENTER, or RADIUS
   */
  public void rectMode(int mode) {
  	if(other != null) {
			other.rectMode(mode);
		} else {
			pa.g.rectMode(mode);
		}
  }

}
