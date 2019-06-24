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
		//this.pg = pa.g;
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

}
