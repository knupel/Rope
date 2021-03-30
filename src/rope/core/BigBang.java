/**
* ROPE > ROmanesco Processing Environment
* Copyleft (c) 2014-2021
* Processing 3.5.4
* @author @stanlepunk
* @see https://github.com/StanLepunK/Rope
*/

/**
 * BIG BANG ROPE
 * is the main class of library
 * 2018-2021
 * v 2.0.1
 * 
 * WARNING : Here it's PROCESSING BIG BANG
 * BigBang is used to use directly the Processing method, to keep Rope with only Java Stuff
 
 */
package rope.core;
import processing.core.PApplet;
import processing.core.PGraphics;
import processing.core.PImage;


public abstract class BigBang extends Rope {
	public PApplet pa;
	
	public BigBang() {
	}
	

	public BigBang(PApplet pa) {
		if(pa == null) {
			print_err("Papplet pa is null, maybe your forget to use function State.papplet(PApplet pa)");
			System.exit(0);
		}
		this.pa = pa;
	}


	/**
	 * MISC IMPORTANT
	 */

	 /**
		* must be used for the class child who don't pass the PApplet via the constructor and for any reason must be use few function from BigBang who need the Processing method or function.
		* @param pa pass PApplet Processing
	  */
	public void pass_processing(PApplet pa) {
		this.pa = pa;
	}
	
	
	public String get_renderer() {
	  return get_renderer(this.pa.g);
	}
	
	/**
	 * Return the current render in your processing Sketch
	 * @param graph
	 * @return
	 */
	public String get_renderer(final PGraphics graph) {
	  try {
	    if (Class.forName(JAVA2D).isInstance(graph)) return JAVA2D;
	    if (Class.forName(FX2D).isInstance(graph)) return FX2D;
	    if (Class.forName(P2D).isInstance(graph)) return P2D;
	    if (Class.forName(P3D).isInstance(graph)) return P3D;
	    if (Class.forName(PDF).isInstance(graph)) return PDF;
	    if (Class.forName(DXF).isInstance(graph)) return DXF;
	  }

	  catch (ClassNotFoundException ex) {
	  }
	  return "Unknown";
	}
  
	 /**
		* 
		* @param filename
		* @return
	  */
	public PImage loadImage(String filename) {
    return pa.loadImage(filename, null);
  }
	


	/**
	 * 
	 * @param value
	 */
	public void noiseSeed(int value) {
		this.pa.noiseSeed(value);
	}

	/**
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public float noise(float x, float y) {
		return this.pa.noise(x,y);
	}






	/**
	 * 
	 * Color Method to catch information
	 */

	 /**
	 * This Processing clone method, add check if any PGraphics is active, and if it's a case work ont it
	 * @param gray
	 * @return
	 */
	public int color(float gray) {
		return this.pa.color(gray);
	}
	
	/**
	 * This Processing clone method, add check if any PGraphics is active, and if it's a case work ont it
	 * @param gray
	 * @param alpha
	 * @return
	 */
	public int color(float gray, float alpha) {
		return this.pa.color(gray, alpha);	
	}

	/**
	 * This Processing clone method, add check if any PGraphics is active, and if it's a case work ont it
	 * @param v1
	 * @param v2
	 * @param v3
	 * @return
	 */
	public int color(float v1, float v2, float v3) {
		return this.pa.color(v1, v2, v3);
	}

	/**
	 * This Processing clone method, add check if any PGraphics is active, and if it's a case work ont it
	 * @param v1
	 * @param v2
	 * @param v3
	 * @param alpha
	 * @return
	 */
	public int color(float v1, float v2, float v3, float alpha) {
		return this.pa.color(v1, v2, v3, alpha);
	}

	/**
	 * This Processing clone method, add check if any PGraphics is active, and if it's a case work ont it
	 * @param value
	 * @return
	 */
	public float alpha(int value) {
		return this.pa.alpha(value);
	}

	/**
	 * This Processing clone method, add check if any PGraphics is active, and if it's a case work ont it
	 * @param value
	 * @return
	 */
	public float hue(int value) {
		return this.pa.hue(value);
	}

	/**
	 * This Processing clone method, add check if any PGraphics is active, and if it's a case work ont it
	 * @param value
	 * @return
	 */
	public float saturation(int value) {
		return this.pa.saturation(value);
	}

	/**
	 * This Processing clone method, add check if any PGraphics is active, and if it's a case work ont it
	 * @param value
	 * @return
	 */
	public float brightness(int value) {
		return this.pa.brightness(value);
	}

	/**
	 * This Processing clone method, add check if any PGraphics is active, and if it's a case work ont it
	 * @param value
	 * @return
	 */
	public float red(int value) {
		return this.pa.red(value);
	}

	/**
	 * This Processing clone method, add check if any PGraphics is active, and if it's a case work ont it
	 * @param value
	 * @return
	 */
	public float green(int value) {
		return this.pa.green(value);
	}

	/**
	 * This Processing clone method, add check if any PGraphics is active, and if it's a case work ont it
	 * @param value
	 * @return
	 */
	public float blue(int value) {
		return this.pa.blue(value);
	}

	
	
}
