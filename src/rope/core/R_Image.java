/**
* R_Image class
* v 0.0.1
* 2019-2019
* @author @stanlepunk
* @see http://stanlepunk.xyz
* @see https://github.com/StanLepunK/Rope
* Class with Image utilities for Rope Library
*/
package rope.core;

import processing.core.*;

public class R_Image extends BigBangRope {
	// public PGraphics pg;
	public R_Image(PApplet pa) {
		super(pa);
		//this.pg = pa.g;
	}
	
	/**
	 * 
	 * @return true if the graphic constext is is P3D, else return fase
	 */
	public boolean renderer_P3D() {
		// System.err.println(processing.core.PConstants.P3D);;
	  if(get_renderer(pa.g).equals(processing.core.PConstants.P3D)) return true ; else return false ;
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

}
