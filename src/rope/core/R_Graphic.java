/**
* R_Graphic class
* v 0.6.0
* 2019-2021
* @author @stanlepunk
* @see https://github.com/StanLepunK/Rope
* Class with Image utilities for Rope Library
*/
package rope.core;

import processing.core.*;
import processing.opengl.PShader;
import rope.R_State.State;
import rope.vector.*;

public class R_Graphic extends BigBang {
	protected processing.core.PGraphics other;
	
	public R_Graphic(PApplet pa) {
		super(pa);
	}
	
	public R_Graphic(PApplet pa, PGraphics other) {
		super(pa);
		this.other = other;
	}
	
  // private boolean render_checked_is = false;
  // private boolean render_p3d_is = false;



	/**
	 * 
	 * @param x
	 * @param y
	 * @param width is the width of your image
	 * @return the rank of your pixel coordonate in the array pixel
	 */
	public int index_pixel_array(int x, int y, int width) {
		return (x + y * width);
	}
  
  /**
   * 
   * @return true if the graphic constext is is P3D, else return fase
   */
	public boolean renderer_P3D() {
		if(State.get_renderer().equals(P3D)) {
			return true;
		}
		return false;
	}
	
	public boolean renderer_P2D() {
		if(State.get_renderer().equals(P2D)) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @return String of the the graphic contexts
	 */
	public String get_renderer() {
	  return State.get_renderer();
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
  
  
  public PGraphics createGraphics(float x, float y, String type) {
  	return pa.createGraphics((int)x,(int)y,type);
  }
  
  
	/**
	 * 
	 * @param mode
	 * @param max_x
	 * @param max_y
	 * @param max_z
	 * @param max_a
	 */
	public void colorMode(int mode,  float max_x, float max_y, float max_z, float max_a){
		if(other != null) {
			other.colorMode(mode, max_x, max_y, max_z, max_a);
		} else {
			this.pa.g.colorMode(mode, max_x, max_y, max_z, max_a);
		}	
	}
  
	public void colorMode(int mode, vec3 arg) {
		colorMode(mode,arg.x(),arg.y(),arg.z());
	}

	public void colorMode(int mode, vec2 arg) {
	  colorMode(mode, arg.x(), arg.x(), arg.x(), arg.y());
	}
	
	public void colorMode(int mode, vec4 arg) {
	  colorMode(mode,arg.x(),arg.y(),arg.z(),arg.w());
	}
	
	public void colorMode(int mode) {
		if(other != null) {
			other.colorMode(mode);
		} else {
			this.pa.g.colorMode(mode);
		}
	}
	public void colorMode(int mode, float max){
		if(other != null) {
			other.colorMode(mode, max);
		} else {
			this.pa.g.colorMode(mode, max);
		}	
	}
	
	public void colorMode(int mode, float max_x, float max_y, float max_z){
		if(other != null) {
			other.colorMode(mode, max_x, max_y, max_z);
		} else {
			this.pa.g.colorMode(mode, max_x, max_y, max_z);
		}	
	}
	
	
	/**
	 * SHADER
	 */
  public void shader(PShader shader) {
  	if(other != null) {
			other.shader(shader);
		} else {
			this.pa.g.shader(shader);
		}
  }
  
  public PShader loadShader(String path) {
  	return this.pa.loadShader(path);
  }
	
	
  
  /**
   * 
   * IMAGE
   */

  void image(PImage img) {
    if(img != null) {
    	image(img, 0, 0);
    } else {
    	print_err_tempo(100,"void image(PImage img): PImage img pass to method image() is null");
    }
  }
  
  public void image(PImage img, vec pos) {
  	image(img,pos.x(),pos.y());
  }
  
  public void image(PImage img, float a, float b) {
  	if(other != null) {
			other.image(img, a, b);
		} else {
			this.pa.g.image(img, a, b);
		}
  }
  
  public void image(PImage img, float a, float b, float c, float d) {
  	if(other != null) {
			other.image(img, a, b, c, d);
		} else {
			this.pa.g.image(img, a, b, c, d);
		}
  }
  
  public void image(PImage img,
      							float a, float b, float c, float d,
      							int u1, int v1, int u2, int v2) {
  	if(other != null) {
			other.image(img, a, b, c, d, u1, v1, u2, v2);
		} else {
			this.pa.g.image(img, a, b, c, d, u1, v1, u2, v2);
		}
  }
  
  
  public int get(int x, int y) {
  	if(other != null) {
  		int index =  index_pixel_array(x,y, other.width);
  		other.loadPixels();
			return other.pixels[index];
		} else {
			int index =  index_pixel_array(x,y, this.pa.g.width);
			this.pa.g.loadPixels();
			return this.pa.g.pixels[index];
		}
  }
  
  /**
   * This Processing clone method, add check if any PGraphics is active, and if it's a case work ont it
   * @param x
   * @param y
   * @param c
   */
	  public void set(int x, int y, int c) {
			if(other != null) {
				other.set(x,y,c);
			} else {
				this.pa.g.set(x,y,c);
			}
		}

		  /**
   * 
   * @param pos
   * @param c
   */
  public void set(vec2 pos, int c) {
  	set((int)pos.x(),(int)pos.y(),c);
  }
  
  /**
   * 
   * @param pos
   * @param c
   */
  public void set(ivec2 pos, int c) {
  	set(pos.x(),pos.y(),c);
  }

  
  
  /**
	 * This Processing clone method, add check if any PGraphics is active, and if it's a case work ont it
   * @param x x-coordinate of the point
   * @param y y-coordinate of the point
   */
  public void point(float x, float y) {
  	if(other != null) {
			other.point(x,y);
		} else {
			this.pa.g.point(x,y);
		}
  }
  
  /**
	 * This Processing clone method, add check if any PGraphics is active, and if it's a case work ont it
   * @param x x-coordinate of the point
   * @param y y-coordinate of the point
   * @param z z-coordinate of the point
   */
  public void point(float x, float y, float z) {
  	if(other != null) {
			other.point(x,y,z);
		} else {
			this.pa.g.point(x,y,z);
		}
  }

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
   * This Processing clone method, add check if any PGraphics is active, and if it's a case work ont it
   * @param x1 x-coordinate of the first point
   * @param y1 y-coordinate of the first point
   * @param x2 x-coordinate of the second point
   * @param y2 y-coordinate of the second point
   */
  public void line(float x1, float y1, float x2, float y2) {
  	if(other != null) {
			other.line(x1,y1, x2,y2);
		} else {
			this.pa.g.line(x1,y1, x2,y2);
		}
  }


  /**
	 * This Processing clone method, add check if any PGraphics is active, and if it's a case work ont it
   * @param z1 z-coordinate of the first point
   * @param z2 z-coordinate of the second point
   */
  public void line(float x1, float y1, float z1,
                   float x2, float y2, float z2) {
  	if(other != null) {
			other.line(x1,y1,z1, x2,y2,z2);
		} else {
			this.pa.g.line(x1,y1,z1, x2,y2,z2);
		}
  }
  
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
   * SHAPE PART
   */

  /**
	 * This Processing clone method, add check if any PGraphics is active, and if it's a case work ont it
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
			this.pa.g.triangle(x1,y1, x2,y2, x3,y3);
		}
  }
  

  
 
  

	
  /**
	 * This Processing clone method, add check if any PGraphics is active, and if it's a case work ont it
   * @param mode either CORNER, CORNERS, CENTER, or RADIUS
   */
  public void rectMode(int mode) {
  	if(other != null) {
			other.rectMode(mode);
		} else {
			this.pa.g.rectMode(mode);
		}
  }
  
  public int rectMode() {
  	if(other != null) {
			return other.rectMode;
		} else {
			return this.pa.g.rectMode;
		}
  }


	/** anc
	 * 
	 */

	public void arc(vec2 pos, vec2 size, float start, float stop) {
		arc(pos.x(), pos.y(), size.x(), size.y(), start, stop);
	}

	public void arc(vec2 pos, vec2 size, float start, float stop, int mode) {
		arc(pos.x(), pos.y(), size.x(), size.y(), start, stop, mode);
	}

	public void arc(float px, float py, float sx, float sy, float start, float stop) {
		if(other != null) {
			other.arc(px,py, sx,sy, start,stop);
		} else {
			this.pa.g.arc(px,py, sx,sy, start,stop);
		}
	}

	public void arc(float px, float py, float sx, float sy, float start, float stop, int mode) {
		if(other != null) {
			other.arc(px,py, sx,sy, start,stop, mode);
		} else {
			this.pa.g.arc(px,py, sx,sy, start,stop, mode);
		}
	}
	/**
	 * This Processing clone method, add check if any PGraphics is active, and if it's a case work ont it
	 * @param px
	 * @param py
	 * @param sx
	 * @param sy
	 */
	public void ellipse(float px, float py, float sx, float sy) {
		if(other != null) {
			other.ellipse(px,py,sx,sy);
		} else {
			this.pa.g.ellipse(px,py,sx,sy);
		}
	}

	public void ellipse(vec p, float x, float y) {
		ellipse(p, new vec2(x,y));
	}

	public void ellipse(vec p, float x) {
		ellipse(p,new vec2(x));
	}

	public void ellipse(vec p, vec s) {
		if(renderer_P3D() && p instanceof vec3) {
			push() ;
			translate(p.x(), p.y(), p.z());
			ellipse(0,0, s.x(), s.y());
			pop() ;
		} else {
			ellipse(p.x(),p.y(),s.x(),s.y());
		}
	}
	
	public void ellipseMode(int mode) {
		if(other != null) {
			other.ellipseMode(mode);
		} else {
			this.pa.g.ellipseMode(mode);
		}
	}
	
  public int ellipseMode() {
  	if(other != null) {
			return other.ellipseMode;
		} else {
			return this.pa.g.ellipseMode;
		}
  }





  /**
	 * This Processing clone method, add check if any PGraphics is active, and if it's a case work ont it
   * @param x x-coordinate of the rectangle by default
   * @param y y-coordinate of the rectangle by default
   * @param extent width and height of the rectangle by default
   */
	public void square(float x, float y, float extent) {
  	if(other != null) {
			other.square(x,y,extent);
		} else {
			pa.g.square(x,y,extent);
		}
  }

	/**
	 * 
	 * @param p
	 * @param extent
	 */
	public void square(vec p, float extent) {
		if(renderer_P3D() && p instanceof vec3) {
			push();
			translate(p.x(),p.y(),p.z());
			square(0,0,extent);
			pop();
		} else {
			square(p.x(),p.y(),extent);
		}
	}





	/**
	 * This Processing clone method, add check if any PGraphics is active, and if it's a case work ont it
	 * @param px
	 * @param py
	 * @param sx
	 * @param sy
	 */
	public void rect(float px, float py, float sx, float sy) {
		if(other != null) {
			other.rect(px,py,sx,sy);
		} else {
			this.pa.g.rect(px,py,sx,sy);
		}
	}
	
	public void rect(float px, float py, float sx, float sy, float r) {
		if(other != null) {
			other.rect(px,py,sx,sy,r);
		} else {
			this.pa.g.rect(px,py,sx,sy,r);
		}
	}
	
	public void rect(float px, float py, float sx, float sy, float tl, float tr, float br, float bl) {
		if(other != null) {
			other.rect(px,py,sx,sy,tl, tr, br, bl);
		} else {
			this.pa.g.rect(px,py,sx,sy,tl, tr, br, bl);
		}
	}

	public void rect(vec p, vec s) {
		if(renderer_P3D() && p instanceof vec3) {
			push();
			translate(p.x(),p.y(),p.z());
			rect(0,0,s.x(),s.y());
			pop();
		} else {
			rect(p.x(),p.y(),s.x(),s.y());
		}
	}

	public void rect(vec p, vec s, float rounded) {
		if(renderer_P3D() && p instanceof vec3) {
			push();
			translate(p.x(),p.y(),p.z());
			rect(0,0,s.x(),s.y(),rounded);
			pop();
		} else {
			rect(p.x(),p.y(),s.x(),s.y(),rounded);
		}
	}

	public void rect(vec p, vec s, vec4 rounded) {
		if(renderer_P3D() && p instanceof vec3) {
			push();
			translate(p.x(),p.y(),p.z());
			rect(0,0,s.x(),s.y(), rounded.x(), rounded.y(), rounded.z(), rounded.w());
			pop();
		} else {
			rect(p.x(),p.y(),s.x(),s.y(), rounded.x(), rounded.y(), rounded.z(), rounded.w());
		}
	}


	/**
	 * This Processing clone method, add check if any PGraphics is active, and if it's a case work ont it
	 * @param x
	 * @param y
	 * @param z
	 */
	public void box(float x, float y, float z) {
		if(other != null) {
			other.box(x,y,z);
		} else {
			this.pa.g.box(x,y,z);
		}
	}

	public void box(float size) {
		box(size,size,size);
	}


	public void box(vec3 p) {
		box(p.x(),p.y(),p.z());
	}



	/**
	 * This Processing clone method, add check if any PGraphics is active, and if it's a case work ont it
	 * @param radius
	 */
	public void sphere(float radius) {
		if(other != null) {
			other.sphere(radius);
		} else {
			this.pa.g.sphere(radius);
		}
	}

	/**
	 * This Processing clone method, add check if any PGraphics is active, and if it's a case work ont it
	 * @param res
	 */
	public void sphereDetail(int res) {
		if(other != null) {
			other.sphereDetail(res);
		} else {
			this.pa.g.sphereDetail(res);
		}
	}

	/**
	 * This Processing clone method, add check if any PGraphics is active, and if it's a case work ont it
	 * @param ures
	 * @param vres
	 */
	public void sphereDetail(int ures, int vres) {
		if(other != null) {
			other.sphereDetail(ures, vres);
		} else {
			this.pa.g.sphereDetail(ures, vres);
		}
	}











  
  

	// ASPECT

	/**
	 * This Processing clone method, add check if any PGraphics is active, and if it's a case work ont it
	 * @param arg
	 */
	public void fill(int rgb) {
		if(other != null) {
			other.fill(rgb);
		} else {
			pa.g.fill(rgb);
		}
	}

  public void fill(int rgb, float alpha) {
    if(other != null) {
			other.fill(rgb, alpha);
		} else {
			pa.g.fill(rgb, alpha);
		}
  }

  public void fill(float gray) {
		if(other != null) {
			other.fill(gray);
		} else {
			pa.g.fill(gray);
		}
  }

  public void fill(float gray, float alpha) {
    if(other != null) {
			other.fill(gray, alpha);
		} else {
			pa.g.fill(gray, alpha);
		}
  }

  public void fill(float x, float y, float z) {
    if(other != null) {
			other.fill(x, y, z);
		} else {
			pa.g.fill(x, y, z);
		}
  }

  public void fill(float x, float y, float z, float a) {
    if(other != null) {
			other.fill(x, y, z, a);
		} else {
			pa.g.fill(x, y, z, a);
		}
  }

	/**
	 * This Processing clone method, add check if any PGraphics is active, and if it's a case work ont it
	 */
	public void noFill() {
		if(other != null) {
			other.noFill();
		} else {
			pa.g.noFill();
		}
	}

	/**
	 * This Processing clone method, add check if any PGraphics is active, and if it's a case work ont it
	 * @param arg
	 */
	public void stroke(int arg) {
		if(other != null) {
			other.stroke(arg);
		} else {
			pa.g.stroke(arg);
		}
	}

	public void stroke(int rgb, float alpha) {
    if(other != null) {
			other.stroke(rgb, alpha);
		} else {
			pa.g.stroke(rgb, alpha);
		}
  }

  public void stroke(float gray) {
		if(other != null) {
			other.stroke(gray);
		} else {
			pa.g.stroke(gray);
		}
  }

  public void stroke(float gray, float alpha) {
    if(other != null) {
			other.stroke(gray, alpha);
		} else {
			pa.g.stroke(gray, alpha);
		}
  }

  public void stroke(float x, float y, float z) {
    if(other != null) {
			other.stroke(x, y, z);
		} else {
			pa.g.stroke(x, y, z);
		}
  }

  public void stroke(float x, float y, float z, float a) {
    if(other != null) {
			other.stroke(x, y, z, a);
		} else {
			pa.g.stroke(x, y, z, a);
		}
  }

	/**
	 * This Processing clone method, add check if any PGraphics is active, and if it's a case work ont it
	 */
	public void noStroke() {
		if(other != null) {
			other.noStroke();
		} else {
			pa.g.noStroke();
		}
	}

	/**
	 * This Processing clone method, add check if any PGraphics is active, and if it's a case work ont it
	 * @param thickness
	 */
	public void strokeWeight(float thickness) {
		if(other != null) {
			other.strokeWeight(thickness);
		} else {
			pa.g.strokeWeight(thickness);
		}
	}

	/**
	 * This method is like strokeWeight of Processing
	 * @param thickness
	 */
	public void thickness(float thickness) {
		if(other != null) {
			other.strokeWeight(thickness);
		} else {
			pa.g.strokeWeight(thickness);
		}
	}


	public void aspect(int fill, int stroke, float thickness) {
		aspect(fill, stroke, thickness, pa.g);
	}

	/**
	 * check if any PGraphics is active, and if it's a case work ont it
	 * @param fill
	 * @param stroke
	 * @param thickness
	 * @param other
	 */
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
	
	
	
	
	
	
	
	
	/**
	 * PUSH, PUSH_MATRIX, POP, POP_MATRIX
	 */
	/**
	 * This Processing clone method, add check if any PGraphics is active, and if it's a case work ont it
	 */
	public void push() {
		if(other != null) {
			other.push();
		} else {
			pa.g.push();
		}
  }

	/**
	 * This Processing clone method, add check if any PGraphics is active, and if it's a case work ont it
	 */
	public void pushMatrix() {
		if(other != null) {
			other.pushMatrix();
		} else {
			pa.g.pushMatrix();
		}
  }


	/**
	 * This Processing clone method, add check if any PGraphics is active, and if it's a case work ont it
	 */
	public void pop() {
		if(other != null) {
			other.pop();
		} else {
			pa.g.pop();
		}
  }

	/**
	 * This Processing clone method, add check if any PGraphics is active, and if it's a case work ont it
	 */
	public void popMatrix() {
		if(other != null) {
			other.popMatrix();
		} else {
			pa.g.popMatrix();
		}
  }
	
	
	/**
	 * This Processing clone method, add check if any PGraphics is active, and if it's a case work ont it
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
	 * This Processing clone method, add check if any PGraphics is active, and if it's a case work ont it
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
		if(renderer_P3D() && v instanceof vec3) {
			translate(v.x(),v.y(),v.z());	
		} else {
			translate(v.x(),v.y());
		}
  }
	

	/**
	 * This Processing clone method, add check if any PGraphics is active, and if it's a case work ont it
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
	 * This Processing clone method, add check if any PGraphics is active, and if it's a case work ont it
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
	 * This Processing clone method, add check if any PGraphics is active, and if it's a case work ont it
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
	 * This Processing clone method, add check if any PGraphics is active, and if it's a case work ont it
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
	 * 
	 * @param rot
	 * @param other
	 */
	public void rotateXY(vec2 rot) {
  	rotateX(rot.x);
  	rotateY(rot.y);
	}

	/**
	 * 
	 * @param rot
	 * @param other
	 */
	public void rotateXZ(vec2 rot) {
  	rotateX(rot.x);
  	rotateZ(rot.y);
	}

	/**
	 * 
	 * @param rot
	 * @param other
	 */
	public void rotateYZ(vec2 rot) {
  	rotateY(rot.x);
  	rotateZ(rot.y);
	}


	/**
	 * 
	 * @param rot
	 * @param other
	 */
	public void rotateXYZ(vec3 rot) {
  	rotateX(rot.x);
  	rotateY(rot.y);
  	rotateZ(rot.z);
	}


	/**
   * Increases or decreases the size of a shape by expanding and contracting
   * vertices. Objects always scale from their relative origin to the coordinate
   * system. Scale values are specified as decimal percentages. For example, the
   * function call <b>scale(2.0)</b> increases the dimension of a shape by
   * 200%.<br />
   * <br />
   * Transformations apply to everything that happens after and subsequent calls
   * to the function multiply the effect. For example, calling <b>scale(2.0)</b>
   * and then <b>scale(1.5)</b> is the same as <b>scale(3.0)</b>. If
   * <b>scale()</b> is called within <b>draw()</b>, the transformation is reset
   * when the loop begins again. Using this function with the <b>z</b> parameter
   * requires using P3D as a parameter for <b>size()</b>, as shown in the third
   * example above. This function can be further controlled with
	* <b>pushMatrix()</b> and <b>popMatrix()</b>.
	 * @param s
	 */
	public void scale(float s) {
    if(other != null) {
			other.scale(s);
		} else {
			pa.g.scale(s);
		}
  }


  /**
   * Not recommended for use in 3D, because the z-dimension is just
   * scaled by 1, since there's no way to know what else to scale it by.
   *
   * @param x percentage to scale the object in the x-axis
   * @param y percentage to scale the object in the y-axis
   */
  public void scale(float x, float y) {
    if(other != null) {
			other.scale(x, y);
		} else {
			pa.g.scale(x, y);
		}
  }


  /**
   * @param z percentage to scale the object in the z-axis
   */
  public void scale(float x, float y, float z) {
    if(other != null) {
			other.scale(x, y, z);
		} else {
			pa.g.scale(x, y, z);
		}
  }


  /**
   *
   * see Processing documention
	 * @param angle
   */
	public void shearX(float angle) {
    if(other != null) {
			other.shearX(angle);
		} else {
			pa.g.shearX(angle);
		}
  }

	/**
	 * see Processing documention
	 * @param angle
	 */
	public void shearY(float angle) {
    if(other != null) {
			other.shearY(angle);
		} else {
			pa.g.shearY(angle);
		}
  }


	/**
	 * BEGIN_CONTOUR / END_CONTOUR
	 */

	public void beginContour() {
		if(other != null) {
			other.beginContour();
		} else {
			pa.g.beginContour();
		}
	}


	public void endContour() {
		if(other != null) {
			other.endContour();
		} else {
			pa.g.endContour();
		}
	}

  


	/**
	 * This Processing clone method, add check if any PGraphics is active, and if it's a case work ont it
	 *  */	
	public void beginShape() {
		if(other != null) {
			other.beginShape();
		} else {
			pa.g.beginShape();
		}
	}

	/**
	 * This Processing clone method, add check if any PGraphics is active, and if it's a case work ont it
	 * @param kind
	 */
	public void beginShape(int kind) {
		if(other != null) {
			other.beginShape(kind);
		} else {
			pa.g.beginShape(kind);
		}
	}
	
	/**
	 * END_SHAPE
	 */


	/**
	 * This Processing clone method, add check if any PGraphics is active, and if it's a case work ont it
	*/
	public void endShape() {
		if(other != null) {
			other.endShape();
		} else {
			pa.g.endShape();
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
			pa.g.endShape(mode);
		}
	}
	
	
	/**
	 * VERTEX PART
	 */
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
		if(other == null) {
			if(renderer_P3D() && v instanceof vec3) {
				pa.g.vertex(v.x(),v.y(),v.z());
			} else {
				pa.g.vertex(v.x(),v.y());
			}
		} else {
			if(renderer_P3D() && v instanceof vec3) {
				other.vertex(v.x(),v.y(),v.z());
			} else {
				other.vertex(v.x(),v.y());
			}
		}
	}
  
	/**
	 * 
	 * @param v
	 * @param uv
	 */
	public void vertex(vec2 v, vec2 uv) {
		if(other == null) {
			if(renderer_P3D()) {
				pa.g.vertex(v.x(),v.y(),0,uv.x(),uv.y());
			} else {
				pa.g.vertex(v.x(),v.y(),uv.x(),uv.y());
			}
		} else {
			if(renderer_P3D()) {
				other.vertex(v.x(),v.y(),0,uv.x(),uv.y());
			} else {
				other.vertex(v.x(),v.y(),uv.x(),uv.y());
			}
		}
	}
	
	/**
	 * 
	 * @param v
	 * @param uv
	 */
	public void vertex(vec3 v, vec2 uv) {
		if(other == null) {
			if(renderer_P3D()) {
				pa.g.vertex(v.x(),v.y(),v.z(),uv.x(),uv.y());
			} else {
				pa.g.vertex(v.x(),v.y(),uv.x(),uv.y());
			}
		} else {
			if(renderer_P3D()) {
				other.vertex(v.x(),v.y(),v.z(),uv.x(),uv.y());
			} else {
				other.vertex(v.x(),v.y(),uv.x(),uv.y());
			}
		}
	}
	/**
	 * @param x x-coordinate of the vertex
	 * @param y y-coordinate of the vertex
	 */
	public void vertex(float x, float y) {
		if(other == null) {
			pa.g.vertex(x,y);
		} else {
			other.vertex(x,y);
		}
	}
	
	/**
	 * @param x x-coordinate of the vertex
	 * @param y y-coordinate of the vertex
	 * @param z z-coordinate of the vertex
	 */
	public void vertex(float x, float y, float z) {	
		if(other == null) {
			if(renderer_P3D()) {
				pa.g.vertex(x,y,z);	
			} else {
				pa.g.vertex(x,y);
			}
		} else {
			if(renderer_P3D()) {
				other.vertex(x,y,z);	
			} else {
				other.vertex(x,y);	
			}
		}
	}
	
	/**
	 * 
	 * @param v
	 */
	public void vertex(float [] v) {
		if(other == null) {
			pa.g.vertex(v);
		} else {
			other.vertex(v);
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
		if(other == null) {
			pa.g.vertex(x,y, u,v);
		} else {
			other.vertex(x,y, u,v);
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
		if(other == null) {
			if(renderer_P3D()) {
				pa.g.vertex(x,y,z, u,v);	
			} else {
				pa.g.vertex(x,y, u,v);
			}
		} else {
			if(renderer_P3D()) {
				other.vertex(x,y,z, u,v);	
			} else {
				other.vertex(x,y, u,v);
			}
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
			this.pa.g.quadraticVertex(cx,cy,x3,y3);
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
			this.pa.g.quadraticVertex(cx,cy,cz,x3,y3,z3);
		}
  }

  
  
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
   * @param x the x-coordinate of the vertex
   * @param y the y-coordinate of the vertex
   */
  public void curveVertex(float x, float y) {
  	if(other != null) {
			other.curveVertex(x,y);
		} else {
			this.pa.g.curveVertex(x,y);
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
			this.pa.g.curveVertex(x,y,z);
		}
  }








	/**
	 * TEXT
	 */

	public void textAlign(int alignX) {
		if(other != null) {
			other.textAlign(alignX);
		} else {
			this.pa.g.textAlign(alignX);
		}
  }


  /**
   * @webref typography:attributes
   * @webBrief Sets the current alignment for drawing text.
   * @param alignX horizontal alignment, either LEFT, CENTER, or RIGHT
   * @param alignY vertical alignment, either TOP, BOTTOM, CENTER, or BASELINE
   */
  public void textAlign(int alignX, int alignY) {
		if(other != null) {
			other.textAlign(alignX, alignY);
		} else {
			this.pa.g.textAlign(alignX, alignY);
		}
  }




	public void textFont(PFont which) {
		if(other != null) {
			other.textFont(which);
		} else {
			this.pa.g.textFont(which);
		}
  }
  /**
   * @param size the size of the letters in units of pixels
   */
  public void textFont(PFont which, float size) {
		if(other != null) {
			other.textFont(which, size);
		} else {
			this.pa.g.textFont(which, size);
		}
  }


	public void textSize(float size) {
		if(other != null) {
			other.textSize(size);
		} else {
			this.pa.g.textSize(size);
		}
  }


	public void text(char c, float x, float y) {
		if(other != null) {
			other.text(c, x, y);
		} else {
			this.pa.g.text(c, x, y);
		}
  }

  public void text(char c, float x, float y, float z) {
		if(other != null) {
			other.text(c, x, y, z);
		} else {
			this.pa.g.text(c, x, y, z);
		}
  }


  public void text(String str, float x, float y) {
		if(other != null) {
			other.text(str, x, y);
		} else {
			this.pa.g.text(str, x, y);
		}
  }

  public void text(char[] chars, int start, int stop, float x, float y) {
		if(other != null) {
			other.text(chars, start, stop, x, y);
		} else {
			this.pa.g.text(chars, start, stop, x, y);
		}
  }

  /**
   * Same as above but with a z coordinate.
   */
  public void text(String str, float x, float y, float z) {
	 if(other != null) {
			other.text(str, x, y, z);
		} else {
			this.pa.g.text(str, x, y, z);
		}
  }

  public void text(char[] chars, int start, int stop,
                   float x, float y, float z) {
		if(other != null) {
			other.text(chars, start, stop, x, y, z);
		} else {
			this.pa.g.text(chars, start, stop, x, y, z);
		}
  }

	public void text(String str, float x1, float y1, float x2, float y2) {
		if(other != null) {
			other.text(str, x1, y1, x2, y2);
		} else {
			this.pa.g.text(str, x1, y1, x2, y2);
		}
  }

  public void text(int i_num, float x, float y) {
		if(other != null) {
			other.text(i_num, x, y);
		} else {
			this.pa.g.text(i_num, x, y);
		}
  }

  public void text(int i_num, float x, float y, float z) {
		if(other != null) {
			other.text(i_num, x, y, z);
		} else {
			this.pa.g.text(i_num, x, y, z);
		}
  }

  public void text(float f_num, float x, float y) {
		if(other != null) {
			other.text(f_num, x, y);
		} else {
			this.pa.g.text(f_num, x, y);
		}
  }

  public void text(float f_num, float x, float y, float z) {
		if(other != null) {
			other.text(f_num, x, y, z);
		} else {
			this.pa.g.text(f_num, x, y, z);
		}
  }

	public void text(String s, vec2 pos, vec2 size) {
		if(other != null) {
			other.text(s, pos.x(),pos.y(), size.x(),size.y());
		} else {
			pa.g.text(s, pos.x(),pos.y(), size.x(),size.y());
		}
	}


  public void text(String s, vec pos) {
		if(pos instanceof vec2 && s != null) {
			vec2 p = (vec2)pos;
			text(s, p.x(),p.y());
		} else if(pos instanceof vec3 && s != null) {
			vec3 p = (vec3)pos;
			text(s, p.x(),p.y(),p.z());
		} else {
			//printErrTempo(60,"method text(): String message is null or vec is not an instance of vec3 or vec2");
		}
	}

  public void text(char c, vec pos) {
		if(pos instanceof vec2) {
			vec2 p = (vec2)pos;
			text(c, p.x(),p.y());
		} else if(pos instanceof vec3) {
			vec3 p = (vec3)pos;
			text(c, p.x(),p.y(),p.z());
		}
	}

  public void text(int i, vec pos) {
		if(pos instanceof vec2) {
			vec2 p = (vec2)pos;
			text(i, p.x(),p.y());
		} else if(pos instanceof vec3) {
			vec3 p = (vec3)pos;
			text(i, p.x(),p.y(),p.z());
		} 
	}

  public void text(float f, vec pos) {
		if(pos instanceof vec2) {
			vec2 p = (vec2) pos;
			text(f, p.x(),p.y());
		} else if(pos instanceof vec3) {
			vec3 p = (vec3) pos;
			text(f,p.x(),p.y(),p.z());
		} 
	}




}
