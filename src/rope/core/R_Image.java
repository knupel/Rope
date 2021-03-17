/**
* R_Image class
* v 0.2.2
* 2019-2019
* @author @stanlepunk
* @see http://stanlepunk.xyz
* @see https://github.com/StanLepunK/Rope
* Class with Image utilities for Rope Library
*/
package rope.core;

import processing.core.*;
import rope.vector.*;

public class R_Image extends BigBang {
	protected processing.core.PGraphics other;
	
	
	// public PGraphics pg;
	public R_Image(PApplet pa) {
		super(pa);
	}
	
	public R_Image(PApplet pa, PGraphics other) {
		super(pa);
		this.other = other;
	}
	
  private boolean render_checked_is = false ;
  private boolean render_p3d_is = false;
  
  /**
   * 
   * @return true if the graphic constext is is P3D, else return fase
   */
	public boolean renderer_P3D() {
    if(!render_checked_is) {
      render_checked_is = true;
      if(get_renderer(pa.g).equals(processing.core.PConstants.P3D)) {
        render_p3d_is = true ; 
      } else {
        render_p3d_is = false ;
      }
    }
    return render_p3d_is;  
	}

	/**
	 * 
	 * @return String of the the graphic context
	 */
	public String get_renderer() {
	  return get_renderer(pa.g);
	}
  
	/**
	 * 
	 * @param graph pass the graphics context like P3D, P2D...
	 * @return return the String name of the graphic context
	 */
	public String get_renderer(final PGraphics graph) {
	  try {
	    if (Class.forName(processing.core.PConstants.JAVA2D).isInstance(graph)) return processing.core.PConstants.JAVA2D;
	    // if (Class.forName(processing.core.PConstants.FX2D).isInstance(graph)) return processing.core.PConstants.FX2D;
	    if (Class.forName(processing.core.PConstants.P2D).isInstance(graph)) return processing.core.PConstants.P2D;
	    if (Class.forName(processing.core.PConstants.P3D).isInstance(graph)) return processing.core.PConstants.P3D;
	    if (Class.forName(processing.core.PConstants.PDF).isInstance(graph)) return processing.core.PConstants.PDF;
	    // if (Class.forName(processing.core.PConstants.SVG).isInstance(graph)) return processing.core.PConstants.SVG;
	    //  if (Class.forName(processing.core.PConstants.DXF).isInstance(graph)) return processing.core.PConstants.DXF;
	  }

	  catch (ClassNotFoundException ex) {
	  }
	  return "Unknown";
	}
	
	
	
	
	
	/**
	 * METHODES for child classes
	 */
	
  /**
   * 
   * @param other
   */
  public void pass_graphic(PGraphics other) {
  	if(other != null) {
  		this.other = other;	
  	}
  }
  
  
  /**
   * improve Processing method
   */
  /**
   * Set 
   */
  /**
   * 
   * @param pos
   * @param c
   * @param other
   */
  public void set(vec2 pos, int c, PGraphics other) {
    set((int)pos.x(),(int)pos.y(),c,other);
  }
  
  /**
   * 
   * @param pos
   * @param c
   * @param other
   */
  public void set(ivec2 pos, int c, PGraphics other) {
  	set(pos.x(),pos.y(),c,other);
  }
  /**
   * 
   * @param pos
   * @param c
   */
  public void set(vec2 pos, int c) {
  	pa.g.set((int)pos.x(),(int)pos.y(),c);
  }
  
  /**
   * 
   * @param pos
   * @param c
   */
  public void set(ivec2 pos, int c) {
  	pa.g.set(pos.x(),pos.y(),c);
  }
  
  /**
   * 
   * @param x
   * @param y
   * @param c
   * @param other
   */
  public void set(int x, int y, int c, PGraphics other) {
    if(other != null) {
      other.set(x,y,c);
    } else {
      pa.g.set(x,y,c);
    }
  }
  
  
  
  
  
  
  /**
   * IMPROVE PROCESSING METHODS
   */
  
  /**
  * shape
  * v 0.2.0
  */
  
  /**
   * 
   * @param other
   */
  public void beginShape(PGraphics other) {
    if(other != null) {
      other.beginShape();
    } else {
      pa.beginShape();
    }
  }
  
  /**
   * 
   * @param kind
   * @param other
   */
  public void beginShape(int kind, PGraphics other) {
    if(other != null) {
      other.beginShape(kind);
    } else {
    	pa.beginShape(kind);
    }
  }

  /**
   * 
   * @param other
   */
  public void endShape(PGraphics other) {
    if(other != null) {
      other.endShape();
    } else {
    	pa.endShape();
    }
  }
  
  /**
   * 
   * @param mode
   * @param other
   */
  public void endShape(int mode, PGraphics other) {
    if(other != null) {
      other.endShape(mode);
    } else {
    	pa.endShape(mode);
    }
  }
  
  

  /**
  * vertex
  * v 0.2.0
  */
  
  /**
   * 
   * @param x
   * @param y
   * @param other
   */
  public void vertex(float x, float y, PGraphics other) {
  	this.other = other;
  	vertex(x,y);
  }
  
  /**
   * 
   * @param x
   * @param y
   * @param z
   * @param other
   */
  public void vertex(float x, float y, float z, PGraphics other) {
  	this.other = other;
  	vertex(x,y,z);
  }

  /**
   * 
   * @param v
   * @param other
   */
  public void vertex(float [] v, PGraphics other) {
  	this.other = other;
  	vertex(v);
  }

  /**
   * 
   * @param x
   * @param y
   * @param u
   * @param v
   * @param other
   */
  public void vertex(float x, float y, float u, float v, PGraphics other) {
  	this.other = other;
  	vertex(x,y,u,v);
  }
  
  /**
   * 
   * @param x
   * @param y
   * @param z
   * @param u
   * @param v
   * @param other
   */
  public void vertex(float x, float y, float z, float u, float v, PGraphics other) {
  	this.other = other;
  	vertex(x,y,z,u,v);
  }

  /**
   * 
   * @param coord
   * @param other
   */
  public void vertex(vec coord, PGraphics other) {
  	this.other = other;
  	vertex(coord);
  }

  /**
   * 
   * @param coord
   * @param uv
   * @param other
   */
  public void vertex(vec2 coord, vec2 uv, PGraphics other) {
  	this.other = other;
  	vertex(coord,uv);
  }

  /**
   * 
   * @param coord
   * @param uv
   * @param other
   */
  public void vertex(vec3 coord, vec2 uv, PGraphics other) {
  	this.other = other;
  	vertex(coord.x(),coord.y(),coord.z(),uv.u(),uv.v());
  }
 
  
	/**
	 * 
	 * @param v 
	 */
	public void vertex(vec v) {
		if(renderer_P3D() && v instanceof vec3) {
			vertex(v.x(),v.y(),v.z());
		} else {
			vertex(v.x(),v.y());
		}
	}
  
	/**
	 * 
	 * @param v
	 * @param uv
	 */
	public void vertex(vec2 v, vec2 uv) {
		if(renderer_P3D()) {
			vertex(v.x(),v.y(),v.z(),uv.x(),uv.y());
		} else {
			vertex(v.x(),v.y(),uv.x(),uv.y());
		}
	}
	
	/**
	 * 
	 * @param v
	 * @param uv
	 */
	public void vertex(vec3 v, vec2 uv) {
		if(renderer_P3D()) {
			vertex(v.x(),v.y(),v.z(),uv.x(),uv.y());
		} else {
			vertex(v.x(),v.y(),uv.x(),uv.y());
		}
	}
	

	
	
	
	
	
	/**
	 * BEZIER VERTEX
	 */
	public void bezierVertex(float x2, float y2, float x3, float y3,  float x4, float y4, PGraphics other) {
		this.other = other;
		bezierVertex(x2,y2, x3,y3, x4,y4);
	}

	public void bezierVertex(float x2, float y2, float z2, float x3, float y3, float z3, float x4, float y4, float z4, PGraphics other) {
		this.other = other;
		bezierVertex(x2,y2,z2, x3,y3,z3, x4,y4,z4);
	}
	


	public void bezierVertex(vec a, vec b, vec pos, PGraphics other) {
		this.other = other;
	  bezierVertex(a,b,pos);
	}
	
	
  public void bezierVertex(vec a, vec b, vec pos){
  	if(renderer_P3D() && a instanceof vec3 && b instanceof vec3 && pos instanceof vec3) {
  		bezierVertex(a.x(),a.y(),a.z(), b.x(),b.y(),b.z(), pos.x(),pos.y(),pos.z());	
  	} else {
  		bezierVertex(a.x(),a.y() ,b.x(),b.y(), pos.x(),pos.y());	
  	}	
	}
	
	
	/**
	 * QUADRATIC VERTEX
	 */
	public void quadraticVertex(float cx, float cy, float x3, float y3, PGraphics other) {
		this.other = other;
	  quadraticVertex(cx,cy, x3,y3);
	}

	public void quadraticVertex(float cx, float cy, float cz, float x3, float y3, float z3, PGraphics other) {
		this.other = other;
	  quadraticVertex(cx,cy,cz, x3,y3,z3);
	}

	public void quadraticVertex(vec a, vec b, PGraphics other) {
		this.other = other;
		quadraticVertex(a,b);
	}
	
	
	public void quadraticVertex(vec a, vec b) {
		if(renderer_P3D() && a instanceof vec3 && b instanceof vec3) {
			quadraticVertex(a.x(), a.y(), a.z(), b.x(), b.y(), b.z());
		} else {
			quadraticVertex(a.x(), a.y(), b.x(), b.y());
		}
	}



	
	
	
	/**
	 * CURVE VERTEX
	 */
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @param z
	 * @param other
	 */
	public void curveVertex(float x, float y, float z, PGraphics other) {
		this.other = other;
	  curveVertex(x,y,z);
	}

	public void curveVertex(float x, float y, PGraphics other) {
		this.other = other;
	  curveVertex(x,y);
	}

	//

	public void curveVertex(vec pos, PGraphics other) {
  	this.other = other;
  	curveVertex(pos);
	}
	
	
	public void curveVertex(vec pos){
  	if(renderer_P3D() && pos instanceof vec3) {
  		curveVertex(pos.x(),pos.y(),pos.z());	
  	} else {
  		curveVertex(pos.x(),pos.y());	
  	}
  }
  
  
  
  /**
   * POINT
   */
  /**
   * @param pos x,y,z-coordinate of the point
   */
  public void point(vec pos){
    if(renderer_P3D() && pos instanceof vec3) {
    	point(pos.x(),pos.y(),pos.z()); 
    } else {
    	point(pos.x(),pos.y());
    }
  }
  
  /**
   * @param pos x,y,z-coordinate of the point
   */
  public void point(ivec pos){
    if(renderer_P3D() && pos instanceof ivec3) {
    	point(pos.x(),pos.y(),pos.z()); 
    } else {
    	point(pos.x(),pos.y());
    }
  }
  
  
  /**
   * LINE
   */
	
  /**
   * 
   * @param a
   * @param b
   */
  public void line(vec a, vec b){
    if(renderer_P3D() && a instanceof vec3 && b instanceof vec3) {
    	line(a.x(),a.y(),a.z(),b.x(),b.y(),b.z()); 
    } else {
    	line(a.x(),a.y(),b.x(),b.y());
    }
  }

  /**
   * 
   * @param a
   * @param b
   */
  public void line(ivec a, ivec b) {
    if(renderer_P3D() && a instanceof ivec3 && b instanceof ivec3) {
    	line(a.x(),a.y(),a.z(),b.x(),b.y(),b.z()); 
    } else {
    	line(a.x(),a.y(),b.x(),b.y());
    }
  }
  
  
  /**
   * TRIANGLE
   */
	
  /**
   * @param a
   * @param b
   * @param c
   */
  public void triangle(ivec a, ivec b, ivec c) {
    triangle(new vec3(a.x(),a.y(),a.z()), new vec3(b.x(),b.y(),b.z()), new vec3(c.x(),c.y(),c.z()));
  }
  
  /**
   * @param a
   * @param b
   * @param c
   */
  public void triangle(vec a, vec b, vec c) {
    if(a.z == 0 && b.z == 0 && c.z == 0) {
      triangle(a.x(),a.y(),b.x(),b.y(),c.x(),c.y());
    } else {
      if(renderer_P3D() && a instanceof vec3 && b instanceof vec3 && c instanceof vec3) {
        beginShape();
        vertex(a.x(),a.y(),a.z());
        vertex(b.x(),b.y(),b.z());
        vertex(c.x(),c.y(),c.z());
        vertex(a.x(),a.y(),a.z()); // close
        endShape();
      } else {
        triangle(a.x(),a.y(),b.x(),b.y(),c.x(),c.y());
      }
    }
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
	
	/**
	 * GHOST METHOD
	 */
	/**
	 * push + pop
	 */
	public void push() {
		if(other != null) {
			other.push();
		} else {
			pa.push();
		}
  }

	public void pushMatrix() {
		if(other != null) {
			other.pushMatrix();
		} else {
			pa.pushMatrix();
		}
  }



	public void pop() {
		if(other != null) {
			other.pop();
		} else {
			pa.pop();
		}
  }

	public void popMatrix() {
		if(other != null) {
			other.popMatrix();
		} else {
			pa.popMatrix();
		}
  }
	
	
	/**
	 * translate
	 */
	/**
	 * @param x
	 * @param y
	 * @param z
	 */
	public void translate(float x, float y, float z) {
		if(other != null) {
			other.translate(x,y,z);
		} else {
			pa.translate(x,y,z);
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
			pa.translate(x,y);
		}
  }
	
	/**
	 *
	 * @param v
	 */
	public void translate(vec v) {
		if(renderer_P3D() && v instanceof vec3) {
			translate(v.x(),v.y(),v.z());	
		} else {
			translate(v.x(),v.y());
		}
  }
	

	/**
	 * @param angle
	 */
	public void rotate(float angle) {
		if(other != null) {
			other.rotate(angle);
		} else {
			pa.rotate(angle);
		}
  }
	
	/**
	 * @param angle
	 */
	public void rotateX(float angle) {
		if(other != null) {
			other.rotateX(angle);
		} else {
			pa.rotateX(angle);
		}
  }
	
	/**
	 * @param angle
	 */
	public void rotateY(float angle) {
		if(other != null) {
			other.rotateY(angle);
		} else {
			pa.rotateY(angle);
		}
  }
	
	/**
	 * @param angle
	 */
	public void rotateZ(float angle) {
		if(other != null) {
			other.rotateZ(angle);
		} else {
			pa.rotateZ(angle);
		}
  }
	/**
	 * 
	 * @param rot
	 */
	public void rotateXY(vec2 rot) {
  	rotateXY(rot,null);
	}

	/**
	 * 
	 * @param rot
	 * @param other
	 */
	public void rotateXY(vec2 rot, PGraphics other) {
  	rotateX(rot.x);
  	rotateY(rot.y);
	}

	/**
	 * 
	 * @param rot
	 */
	public void rotateXZ(vec2 rot) {
  	rotateXZ(rot,null);
	}

	/**
	 * 
	 * @param rot
	 * @param other
	 */
	public void rotateXZ(vec2 rot, PGraphics other) {
  	rotateX(rot.x);
  	rotateZ(rot.y);
	}

	/**
	 * 
	 * @param rot
	 */
	public void rotateYZ(vec2 rot) {
  	rotateYZ(rot,null);
	}

	/**
	 * 
	 * @param rot
	 * @param other
	 */
	public void rotateYZ(vec2 rot, PGraphics other) {
  	rotateY(rot.x);
  	rotateZ(rot.y);
	}

	/**
	 * 
	 * @param rot
	 */
	public void rotateXYZ(vec3 rot) {
  	rotateXYZ(rot,null);
	}

	/**
	 * 
	 * @param rot
	 * @param other
	 */
	public void rotateXYZ(vec3 rot, PGraphics other) {
  	rotateX(rot.x);
  	rotateY(rot.y);
  	rotateZ(rot.z);
	}
	

	// ASPECT AND COLOR
	public int color(float gray) {
		return pa.color(gray);
	}
	
	public int color(float gray, float alpha) {
		return pa.color(gray, alpha);	
	}

	public int color(float v1, float v2, float v3) {
		return pa.color(v1, v2, v3);
	}

	public int color(float v1, float v2, float v3, float alpha) {
		return pa.color(v1, v2, v3, alpha);
	}
	/**
	 * 
	 * @param arg
	 */
	public void fill(int arg) {
		if(other != null) {
			other.fill(arg);
		} else {
			pa.fill(arg);
		}
	}

	public void noFill() {
		if(other != null) {
			other.noFill();
		} else {
			pa.noFill();
		}
	}

	/**
	 * 
	 * @param arg
	 */
	public void stroke(int arg) {
		if(other != null) {
			other.stroke(arg);
		} else {
			pa.stroke(arg);
		}
	}


	public void noStroke() {
		if(other != null) {
			other.noStroke();
		} else {
			pa.noStroke();
		}
	}

	/**
	 * 
	 * @param thickness
	 */
	public void strokeWeight(float thickness) {
		if(other != null) {
			other.strokeWeight(thickness);
		} else {
			pa.strokeWeight(thickness);
		}
	}

	/**
	 * 
	 * @param thickness
	 */
	public void thickness(float thickness) {
		if(other != null) {
			other.strokeWeight(thickness);
		} else {
			pa.strokeWeight(thickness);
		}
	}
	
	
	
	
	
	
	
	

	/**
	 * beginShape + endShape
	 */
	public void beginShape() {
		if(other != null) {
			other.beginShape();
		} else {
			pa.beginShape();
		}
	}
	
	public void endShape() {
		if(other != null) {
			other.endShape();
		} else {
			pa.endShape();
		}
	}
	
	/**
	 * 
	 * @param mode
	 */
	public void endShape(int mode) {
		if(other != null) {
			other.endShape(mode);
		} else {
			pa.endShape(mode);
		}
	}
	
	
	/**
	 * VERTEX PART
	 */
	
	/**
	 * @param x x-coordinate of the vertex
	 * @param y y-coordinate of the vertex
	 */
	public void vertex(float x, float y) {
		if(other != null) {
			other.vertex(x,y);
		} else {
			pa.vertex(x,y);
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
				pa.vertex(x,y,z);	
			}
		}
	}
	
	/**
	 * 
	 * @param v
	 */
	public void vertex(float [] v) {
		if(other != null) {
			other.vertex(v);
		} else {
			pa.vertex(v);
		}
	}
	
	
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @param u
	 * @param v
	 */
	public void vertex(float x, float y, float u, float v) {
		if(other != null) {
			other.vertex(x,y, u,v);
		} else {
			pa.vertex(x,y, u,v);
		}
	}
	
/**
 * 
 * @param x
 * @param y
 * @param z
 * @param u
 * @param v
 */
	public void vertex(float x, float y, float z, float u, float v) {	
		if(other != null) {
			if(renderer_P3D()) {
				other.vertex(x,y,z, u,v);	
			}
		} else {
			if(renderer_P3D()) {
				pa.vertex(x,y,z, u,v);	
			}
		}
	}
	
	
	
	
	/**
	 * BEZIER VERTEX PART
	 */
	/**
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
			pa.bezierVertex(x2,y2,x3,y3,x4,y4);
		}
	}
	
	/**
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
			pa.bezierVertex(x2,y2,z2,x3,y3,z3,x4,y4,z4);
		}
  }
  

  
  
  /**
   * 
   * @param cx the x-coordinate of the control point
   * @param cy the y-coordinate of the control point
   * @param x3 the x-coordinate of the anchor point
   * @param y3 the y-coordinate of the anchor point
   */
  

  public void quadraticVertex(float cx, float cy,
                              float x3, float y3) {
  	if(other != null) {
			other.quadraticVertex(cx,cy,x3,y3);
		} else {
			pa.quadraticVertex(cx,cy,x3,y3);
		}
  }

  
  
  /**
   * 
   * @param cx the x-coordinate of the control point
   * @param cy the y-coordinate of the control point
   * @param cz the z-coordinate of the control point
   * @param x3 the x-coordinate of the anchor point
   * @param y3 the y-coordinate of the anchor point
   * @param z3 the z-coordinate of the anchor point
   */

  public void quadraticVertex(float cx, float cy, float cz,
                              float x3, float y3, float z3) {
  	if(other != null) {
			other.quadraticVertex(cx,cy,cz,x3,y3,z3);
		} else {
			pa.quadraticVertex(cx,cy,cz,x3,y3,z3);
		}
  }

  
  
  /**
   * @param x the x-coordinate of the vertex
   * @param y the y-coordinate of the vertex
   */
  public void curveVertex(float x, float y) {
  	if(other != null) {
			other.curveVertex(x,y);
		} else {
			pa.curveVertex(x,y);
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
			pa.curveVertex(x,y,z);
		}
  }
  

  

  
  
  
  
  /**
   * SHAPE PART
   */
  
  /**
   * @param x x-coordinate of the point
   * @param y y-coordinate of the point
   */
  public void point(float x, float y) {
  	if(other != null) {
			other.point(x,y);
		} else {
			pa.point(x,y);
		}
  }
  
  /**
   * @param x x-coordinate of the point
   * @param y y-coordinate of the point
   * @param z z-coordinate of the point
   */
  public void point(float x, float y, float z) {
  	if(other != null) {
			other.point(x,y,z);
		} else {
			pa.point(x,y,z);
		}
  }
  

  
  
  /** 
   * @param x1 x-coordinate of the first point
   * @param y1 y-coordinate of the first point
   * @param x2 x-coordinate of the second point
   * @param y2 y-coordinate of the second point
   */
  public void line(float x1, float y1, float x2, float y2) {
  	if(other != null) {
			other.line(x1,y1, x2,y2);
		} else {
			pa.line(x1,y1, x2,y2);
		}
  }


  /**
   * @param z1 z-coordinate of the first point
   * @param z2 z-coordinate of the second point
   */
  public void line(float x1, float y1, float z1,
                   float x2, float y2, float z2) {
  	if(other != null) {
			other.line(x1,y1,z1, x2,y2,z2);
		} else {
			pa.line(x1,y1,z1, x2,y2,z2);
		}
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
			pa.triangle(x1,y1, x2,y2, x3,y3);
		}
  }
  

  
 
  
  /**
   * @param x x-coordinate of the rectangle by default
   * @param y y-coordinate of the rectangle by default
   * @param extent width and height of the rectangle by default
   */
	public void square(float x, float y, float extent) {
  	if(other != null) {
			other.square(x,y,extent);
		} else {
			pa.square(x,y,extent);
		}
  }
	
  /**
   * @param mode either CORNER, CORNERS, CENTER, or RADIUS
   */
  public void rectMode(int mode) {
  	if(other != null) {
			other.rectMode(mode);
		} else {
			pa.rectMode(mode);
		}
  }


	public void aspect(int fill, int stroke, float thickness) {
		aspect(fill, stroke, thickness, pa.g);
	}

	public void aspect(int fill, int stroke, float thickness, PGraphics other) {
		if(other.alpha(fill) <= 0) {
			other.noFill(); 
		} else {
			other.fill(fill);
		}

		if(other.alpha(stroke) <= 0  || thickness <= 0) {
			other.noStroke(); 
		} else {
			other.stroke(stroke);
			other.strokeWeight(thickness);
		}
	}  
}
