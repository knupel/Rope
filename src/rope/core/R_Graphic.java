
/**
 *   ___      ___   ____   _______
 *  | -  \   /   \  |    \ |  ___/
 *  | |/  | |   \ | | |\ | |  |__
 *  |    /  | | | | | |  / |  __/
 *  | |  \  \ \   / |  |/  |  |____
 *  |_| \_\  \___/  |_ |   |______/
 * 
 * R_Graphic class
 * v 0.7.5
 * 2019-2023
 * @author @knupel
 * @see https://github.com/knupel/Rope
 * Class with Image utilities for Rope Library
*/
package rope.core;

import java.util.ArrayList;

import processing.core.*;
import processing.opengl.PShader;
import rope.utils.R_State.State;
import rope.vector.*;

public class R_Graphic extends BigBang {
	protected processing.core.PGraphics other;
	private boolean fill_is = false;
	private boolean stroke_is = false;
	
	public R_Graphic(PApplet pa) {
		super(pa);
	}
	
	public R_Graphic(PApplet pa, PGraphics other) {
		super(pa);
		if(other != null) {
			this.other = other;
		}
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
   * @param other PGraphics rendering art work
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
	 * clone Processing function() clear
	 */
	public void clear() {
		if(this.other != null) {
			this.other.clear();
		} else {
			this.pa.g.clear();
		}
	}


  
	/**
	 * 
	 * @param mode type color environment RGB or HSB
	 * @param max_x float max value for X component
	 * @param max_y float max value for Y component
	 * @param max_z float max value for Z component
	 * @param max_a float max value for alpha component
	 */
	public void colorMode(int mode, float max_x, float max_y, float max_z, float max_a){
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

  public void image(PImage img) {
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

	///////////////////////////////////
	// BACKGROUND
	////////////////////////////////////
  public void background(int colour) {
		if(this.other != null) {
  		this.other.background(colour);
		} else {
			this.pa.g.background(colour);
		}
	}

	public void background(int colour, float alpha) {
		if(this.other != null) {
  		this.other.background(colour, alpha);
		} else {
			this.pa.g.background(colour, alpha);
		}
	}

	public void background(float gray) {
		if(this.other != null) {
  		this.other.background(gray);
		} else {
			this.pa.g.background(gray);
		}
	}

	public void background(float gray, float alpha) {
		if(this.other != null) {
  		this.other.background(gray, alpha);
		} else {
			this.pa.g.background(gray, alpha);
		}
	}

	public void background(float x, float y , float z) {
		if(this.other != null) {
  		this.other.background(x, y, z);
		} else {
			this.pa.g.background(x, y, z);
		}
	}

	public void background(float x, float y , float z, float a) {
		if(this.other != null) {
  		this.other.background(x, y, z, a);
		} else {
			this.pa.g.background(x, y, z, a);
		}
	}

	////////////////////////////////////
	// PIXEL
	////////////////////////////////////
  
  public int get(int x, int y) {
  	if(this.other != null) {
  		int index = index_pixel_array(x,y, this.other.width);
  		this.other.loadPixels();
			return other.pixels[index];
		} else {
			int index = index_pixel_array(x,y, this.pa.g.width);
			this.pa.g.loadPixels();
			return this.pa.g.pixels[index];
		}
  }



  
  /**
   * This Processing clone method, add check if any PGraphics is active, and if it's a case work ont it
   * @param x position to set pixel
   * @param y position to set pixel
   * @param c int color pixel
   */
	public void set(int x, int y, int c) {
		if(this.other != null) {
			this.other.set(x,y,c);
		} else {
			this.pa.g.set(x,y,c);
		}
	}

	/**
   * 
   * @param pos vec2 position to set pixel
   * @param c int color pixel
   */
  public void set(vec2 pos, int c) {
  	set((int)pos.x(),(int)pos.y(),c);
  }
  
  /**
   * 
   * @param pos ivec2 position to set pixel
   * @param c int color pixel
   */
  public void set(ivec2 pos, int c) {
  	set(pos.x(),pos.y(),c);
  }

	/**
	 * close from Processing function set()
	 * @param index
	 * @param c
	 */


	////////////////////////////////////////
	// PLOT
	// is like set() processing function
	////////////////////////////////////////

	/**
	 * close to Processing function set()
	 * @param pos
	 * @param c
	 */
	public void plot(ivec2 pos, int c) {
		plot(pos.x(),pos.y(),c);
	}

	/**
	 * close to Processing function set()
	 * @param pos
	 * @param c
	 */
	public void plot(vec2 pos, int c) {
  	plot((int)pos.x(),(int)pos.y(),c);
  }

	public void plot(int x, int y, int c) {
		if(this.other != null) {
			plot_impl(x, y, c, this.other);
		} else {
			plot_impl(x, y, c, this.pa.g);
		}
	}

	private void plot_impl(int x, int y, int c, PGraphics pg) {
		int w = pg.width;
		int h = pg.height;
		if(pixel_density_is()) {
			w = pg.pixelWidth;
			h = pg.pixelHeight;
		}

		if(lessThan(x,w) && lessThan(y,h) && greaterThanEqual(x,0) && greaterThanEqual(y, 0)) {
			int index = index_pixel_array(x, y, w);
			pg.pixels[index] = c;
		}
	}

	public void plot(int index, int c) {
		if(this.other != null) {
			plot_impl(index, c, this.other);
		} else {
			plot_impl(index, c, this.pa.g);
		}
	}

	private void plot_impl(int index, int colour, PGraphics pg) {
		pg.pixels[index] = colour;
	}

	//////////////////////////////
	// PLOT X2


		/**
   * This Processing clone method, add check if any PGraphics is active, and if it's a case work ont it
   * @param pos position to set pixel
   * @param colour int color pixel
   */
	public void plot_x2(vec2 pos, int colour) {
		if(this.other != null) {
			plot_x2_impl((int)pos.x(), (int)pos.y(), colour, this.other);
		} else {
			plot_x2_impl((int)pos.x(), (int)pos.y(), colour, this.pa.g);
		}
	}


	/**
   * This Processing clone method, add check if any PGraphics is active, and if it's a case work ont it
   * @param x position to set pixel
   * @param y position to set pixel
   * @param colour int color pixel
   */
	public void plot_x2(int x, int y, int colour) {
		if(this.other != null) {
			plot_x2_impl(x, y, colour, this.other);
		} else {
			plot_x2_impl(x, y, colour, this.pa.g);
		}
	}


	private void plot_x2_impl(int x, int y, int colour, PGraphics pg) {
		int w = pg.width;
		int h = pg.height;
		if(pixel_density_is()) {
			w = pg.pixelWidth;
			h = pg.pixelHeight;
		}
		if(lessThan(x,w) && lessThan(y,h) && greaterThanEqual(x,0) && greaterThanEqual(y, 0)) {
			int index = index_pixel_array(x, y, w);
			pg.pixels[index] = colour;
			Integer [] arr = new Integer[calc_plot_neighbourhood(index, x, y, w, h).size()];
			arr = calc_plot_neighbourhood(index, x, y, w, h).toArray(arr);
			for(int which_one : arr) {
				pg.pixels[which_one] = colour;
			}
		}
	}


	private ArrayList<Integer> calc_plot_neighbourhood(int index_base, int x, int y, int w, int h) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		int index, tx, ty = 0;
	
		if(x < w -1) {
			index = index_base + 1;
			arr.add(index);
		}
		if(x > 0) {
			index = index_base - 1;
			arr.add(index);
		}
		if(y < h -1) {
			index = index_base + w;
			arr.add(index);
		}
		if(y > 0) {
			index = index_base - w;
			arr.add(index);
		}
		return arr;
	}








	public void loadPixels() {
		if(this.other != null) {
			this.other.loadPixels();
		} else {
			this.pa.g.loadPixels();
		}
	}

	public void updatePixels() {
		if(this.other != null) {
			this.other.updatePixels();
		} else {
			this.pa.g.updatePixels();
		}
	}


	/////////////////////////
	// DRAW
	//////////////////////////

	public void beginDraw() {
		if(this.other != null) {
			this.other.beginDraw();
		}
	}

		public void endDraw() {
		if(this.other != null) {
			this.other.endDraw();
		}
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
   * @param a vec position of a point
   * @param b vec position of b point
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
   * @param a ivec position of a point
   * @param b ivec position of b point
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
   * @param a ivec position of a summit
   * @param b ivec position of b summit
   * @param c ivec position of c summit
   */
  public void triangle(ivec a, ivec b, ivec c) {
    triangle(new vec3(a.x(),a.y(),a.z()), new vec3(b.x(),b.y(),b.z()), new vec3(c.x(),c.y(),c.z()));
  }
  
  /**
   * @param a vec position of a summit
   * @param b vec position of b summit
   * @param c vec position of c summit
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
	 * @param px float value for the ellipse position
	 * @param py float value for the ellipse position
	 * @param sx float value for the ellipse size
	 * @param sy float value for the ellipse size
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
	 * @param px float value for the ellipse position
	 * @param py float value for the ellipse position
	 * @param diam float value for the ellipse size
	 */
	public void circle(float px, float py, float diam) {
		if(other != null) {
			other.circle(px,py,diam);
		} else {
			this.pa.g.circle(px,py,diam);
		}
	}

	public void circle(vec p, float diam) {
		if(renderer_P3D() && p instanceof vec3) {
			push() ;
			translate(p.x(), p.y(), p.z());
			circle(0,0, diam);
			pop() ;
		} else {
			circle(p.x(),p.y(),diam);
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
	 * @param pos vec value for position, vec2 or vec3 is accepted for x,y and z coordinate
	 * @param extent float value for side size of the rect / square
	 */
	public void square(vec pos, float extent) {
		if(renderer_P3D() && pos instanceof vec3) {
			push();
			translate(pos.x(),pos.y(),pos.z());
			square(0,0,extent);
			pop();
		} else {
			square(pos.x(),pos.y(),extent);
		}
	}





	/**
	 * This Processing clone method, add check if any PGraphics is active, and if it's a case work ont it
	 * @param px float value for position
	 * @param py float value for position
	 * @param sx float value for size
	 * @param sy float value for size
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
	 * @param x float value for size
	 * @param y float value for size
	 * @param z float value for size
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
	 * @param radius float value for sphere radius
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
	 * @param res int value for details sphere rendering
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
	 * @param ures int value for sphere details  rendering
	 * @param vres int value for sphere details  rendering
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
	 * @param rgb in value for the stroke color
	 */
	public void fill(int rgb) {
		if(fill_is()) {
			if(other != null) {
				other.fill(rgb);
			} else {
				pa.g.fill(rgb);
			}
		} else {
			this.noFill();
		}
	}

  public void fill(int rgb, float alpha) {
		if(fill_is()) {
			if(other != null) {
				other.fill(rgb, alpha);
			} else {
				pa.g.fill(rgb, alpha);
			}
		} else {
			this.noFill();
		}
  }

  public void fill(float gray) {
		if(fill_is()) {
			if(other != null) {
				other.fill(gray);
			} else {
				pa.g.fill(gray);
			}
		} else {
			this.noFill();
		} 
  }

  public void fill(float gray, float alpha) {
    if(fill_is()) {
			if(other != null) {
				other.fill(gray, alpha);
			} else {
				pa.g.fill(gray, alpha);
			}
		} else {
			this.noFill();
		}
  }

  public void fill(float x, float y, float z) {
    if(fill_is()) {
			if(other != null) {
				other.fill(x, y, z);
			} else {
				pa.g.fill(x, y, z);
			}
		} else {
			this.noFill();
		}
  }

  public void fill(float x, float y, float z, float a) {
    if(fill_is()) {
			if(other != null) {
				other.fill(x, y, z, a);
			} else {
				pa.g.fill(x, y, z, a);
			}
		} else {
			this.noFill();
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

	public void fill_is(boolean is) {
		this.fill_is = is;
	}

	public boolean fill_is() {
		return this.fill_is;
	}

	/**
	 * This Processing clone method, add check if any PGraphics is active, and if it's a case work on it
	 * @param rgb in value for the stroke color
	 */
	public void stroke(int rgb) {
		if(stroke_is()) {
			if(other != null) {
				other.stroke(rgb);
			} else {
				pa.g.stroke(rgb);
			}
		} else {
			this.noStroke();
		}
	}

	public void stroke(int rgb, float alpha) {
    if(stroke_is()) {
			if(other != null) {
				other.stroke(rgb, alpha);
			} else {
				pa.g.stroke(rgb, alpha);
			}
		} else {
			this.noStroke();
		}
  }

  public void stroke(float gray) {
		if(stroke_is()) {
			if(other != null) {
				other.stroke(gray);
			} else {
				pa.g.stroke(gray);
			}
		} else {
			this.noStroke();
		}
  }

  public void stroke(float gray, float alpha) {
    if(stroke_is()) {
			if(other != null) {
				other.stroke(gray, alpha);
			} else {
				pa.g.stroke(gray, alpha);
			}
		} else {
			this.noStroke();
		}
  }

  public void stroke(float x, float y, float z) {
		if(stroke_is()) {
			if(other != null) {
				other.stroke(x, y, z);
			} else {
				pa.g.stroke(x, y, z);
			}
		} else {
			this.noStroke();
		}
  }

  public void stroke(float x, float y, float z, float a) {
    if(stroke_is()) {
			if(other != null) {
				other.stroke(x, y, z, a);
			} else {
				pa.g.stroke(x, y, z, a);
			}
		} else {
			this.noStroke();
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


	public void stroke_is(boolean is) {
		this.stroke_is = is;
	}

	public boolean stroke_is() {
		return this.stroke_is;
	}

	/**
	 * This Processing clone method, add check if any PGraphics is active, and if it's a case work ont it
	 * @param thickness float value for the strokeWeight
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
	 * @param thickness float value for the strokeWeight
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
	 * @param fill int value for color fill
	 * @param stroke int value for color stroke
	 * @param thickness float value for the strokeWeight
	 * @param other is your PGRaphics to render your art work
	 */
	public void aspect(int fill, int stroke, float thickness, PGraphics other) {
		if(other.alpha(fill) <= 0 || !fill_is()) {
			other.noFill(); 
		} else {
			other.fill(fill);
		}

		if(other.alpha(stroke) <= 0  || thickness <= 0 || !stroke_is()) {
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
	 * @param x float value to translate in x
	 * @param y float value to translate in y
	 * @param z float value to translate in z
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
	 * @param x float value to translate in x
	 * @param y float value to translate in y
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
	 * @param v vec value for translation in x,y or x,y, z
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
	 * @param angle float value in radiant for rotation
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
	 * @param angle float value in radiant for rotation
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
	 * @param angle float value in radiant for rotation
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
	 * @param angle float value in radiant for rotation
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
	 * @param rot vec2 radiant value for the rotation
	 */
	public void rotateXY(vec2 rot) {
  	rotateX(rot.x);
  	rotateY(rot.y);
	}

	/**
	 * 
	 * @param rot vec2 radiant value for the rotation
	 */
	public void rotateXZ(vec2 rot) {
  	rotateX(rot.x);
  	rotateZ(rot.y);
	}

	/**
	 * 
	 * @param rot vec2 radiant value for the rotation
	 */
	public void rotateYZ(vec2 rot) {
  	rotateY(rot.x);
  	rotateZ(rot.y);
	}


	/**
	 * 
	 * @param rot vec3 radiant value for the rotation
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
   * function call scale(2.0) increases the dimension of a shape by
   * 200%.
   * Transformations apply to everything that happens after and subsequent calls
   * to the function multiply the effect. For example, calling scale(2.0)
   * and then scale(1.5) is the same as scale(3.0). If
   * scale() is called within draw(), the transformation is reset
   * when the loop begins again. Using this function with the z parameter
   * requires using P3D as a parameter for size(), as shown in the third
   * example above. This function can be further controlled with
   * pushMatrix( and popMatrix(.
	 * @param s float value to scale
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
   * @param x percentage to scale the object in the x-axis
   * @param y percentage to scale the object in the y-axis
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
   * see Processing information
	 * @param angle float radiant value for shear
   */
	public void shearX(float angle) {
    if(other != null) {
			other.shearX(angle);
		} else {
			pa.g.shearX(angle);
		}
  }

	/**
	 * see Processing information
	 * @param angle float radiant value for shear
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
	 * @param kind type of rendering
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
	 * @param mode type of rendering
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
   * @param x float value for coordinate
   * @param y float value for coordinate
   * @param other PGraphics rendering
   */
  public void vertex(float x, float y, PGraphics other) {
  	this.other = other;
  	vertex(x,y);
  }
  
  /**
   * 
   * @param x float value for coordinate
   * @param y float value for coordinate
   * @param z float value for coordinate
   * @param other PGraphics rendering
   */
  public void vertex(float x, float y, float z, PGraphics other) {
  	this.other = other;
  	vertex(x,y,z);
  }

  /**
   * 
   * @param v array value for coordinate
   * @param other PGraphics rendering
   */
  public void vertex(float [] v, PGraphics other) {
  	this.other = other;
  	vertex(v);
  }

  /**
   * 
   * @param x float value for coordinate
   * @param y float value for coordinate
   * @param u float value for uv
   * @param v float value for uv
   * @param other PGraphics rendering
   */
  public void vertex(float x, float y, float u, float v, PGraphics other) {
  	this.other = other;
  	vertex(x,y,u,v);
  }
  
  /**
   * 
   * @param x float value for coordinate
   * @param y float value for coordinate
   * @param z float value for coordinate
   * @param u float value for uv
   * @param v float value for uv
   * @param other PGraphics rendering
   */
  public void vertex(float x, float y, float z, float u, float v, PGraphics other) {
  	this.other = other;
  	vertex(x,y,z,u,v);
  }

  /**
   * 
   * @param coord vec position for the vertex
   * @param other PGraphics rendering
   */
  public void vertex(vec coord, PGraphics other) {
  	this.other = other;
  	vertex(coord);
  }

  /**
   * 
   * @param coord vec2 position for the vertex
   * @param uv vec uv for the vertex
   * @param other PGraphics rendering
   */
  public void vertex(vec2 coord, vec2 uv, PGraphics other) {
  	this.other = other;
  	vertex(coord,uv);
  }

  /**
   * 
   * @param coord vec3 position for the vertex
   * @param uv vec uv for the vertex
   * @param other PGraphics rendering
   */
  public void vertex(vec3 coord, vec2 uv, PGraphics other) {
  	this.other = other;
  	vertex(coord.x(),coord.y(),coord.z(),uv.u(),uv.v());
  }
 
  
	/**
	 * 
	 * @param v vec position for the vertex
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
	 * @param v array value for coordinate
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
	 * @param x float value for coordinate
	 * @param y float value for coordinate
	 * @param u float value for uv
	 * @param v float value for uv
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
 * @param x float value for coordinate
 * @param y float value for coordinate
 * @param z float value for coordinate
 * @param u float value for uv
 * @param v float value for uv
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
