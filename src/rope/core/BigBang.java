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
import processing.core.PFont;
import processing.core.PGraphics;
import processing.core.PImage;
import rope.R_State.State;

import java.awt.Font; 
import java.awt.image.BufferedImage ;
import java.awt.FontMetrics;


public abstract class BigBang extends Rope {
	public PApplet pa;
	
	public BigBang() {
	}
	

	public BigBang(PApplet pa) {
		if(pa == null) {
			print_err("Papplet pa is null, maybe your forget to use function State.init(PApplet pa)");
			System.exit(0);
		}
		this.pa = pa;
		State.init(pa);
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
	 * @param print_info_is if it's false there is no information print in the console
	 * @return
	 */
	public float [] getColorMode(boolean print_info_is) {
		float colorMode = this.pa.g.colorMode ;
		float x = this.pa.g.colorModeX;
		float y = this.pa.g.colorModeY;
		float z = this.pa.g.colorModeZ;
		float a = this.pa.g.colorModeA;
		float array[] = {colorMode,x,y,z,a};
		if (print_info_is && this.pa.g.colorMode == HSB) {
			String mess = "HSB: "+x+", "+y+", "+z+", "+a;
			System.out.println(mess);
		} else if(print_info_is && this.pa.g.colorMode == RGB) {
			String mess = "RGB: "+x+", "+y+", "+z+", "+a;
			System.out.println(mess);
		}
		return array;
	}

	public float [] getColorMode() {
		return getColorMode(false);
	}
  
	 /**
		* 
		* @param filename
		* @return
	  */
	public PImage loadImage(String filename) {
    return this.pa.loadImage(filename, null);
  }



	public PFont createFont(String name, float size) {
		return this.pa.createFont(name, size);
	}

	public PFont createFont(String name, float size, boolean smooth) {
		return this.pa.createFont(name, size, smooth);
	}

	public PFont createFont(String name, float size, boolean smooth, char[] charset) {
		return this.pa.createFont(name, size, smooth, charset);
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






	public int longest_String(String[] string_list) {
		int finish = 0;
		if(string_list != null) finish = string_list.length;
		return longest_String(string_list, 0, finish);
	}

	//with starting and end keypoint in the String must be sort
	public int longest_String(String[] string_list, int start, int finish) {
		int length = 0;
		if(string_list != null) {
			for ( int i = start ; i < finish ; i++) {
				if (string_list[i].length() > length ) length = string_list[i].length() ;
			}
		}
		return length;
	}

	/**
	Longuest String with PFont
	*/
	public int longest_String_pixel(PFont font, String[] string_list) {
		int [] size_font = new int[1];
		size_font[0] = font.getSize();
		int finish = 0;
		if(string_list != null) finish = string_list.length;
		return longest_String_pixel(font.getName(), string_list, size_font, 0, finish);
	}

	public int longest_String_pixel(PFont font, String[] string_list, int... size_font) {
		int finish = 0;
		if(string_list != null) finish = string_list.length;
		return longest_String_pixel(font.getName(), string_list, size_font, 0, finish);
	}

	public int longest_String_pixel(PFont font, String[] string_list, int [] size_font, int start, int finish) {
		return longest_String_pixel(font.getName(), string_list, size_font, start, finish);
	}

	/**
	Longuest String with String name Font
	*/
	public int longest_String_pixel(String font_name, String[] string_list, int... size_font) {
		int finish = 0;
		if(string_list != null) finish = string_list.length;
		return longest_String_pixel(font_name, string_list, size_font, 0, finish);
	}

	// diferrent size by line
	public int longest_String_pixel(String font_name, String[] string_list, int size_font, int start, int finish) {
		int [] s_font = new int[1];
		s_font[0] = size_font;
		return longest_String_pixel(font_name, string_list, s_font, start, finish);
	}

	public int longest_String_pixel(String font_name, String[] string_list, int [] size_font, int start, int finish) {
		int width_pix = 0 ;
		if(string_list != null) {
			int target_size_font = 0;
			for (int i = start ; i < finish && i < string_list.length; i++) {
				if(i >= size_font.length) target_size_font = 0 ;
				if (width_String(font_name, string_list[i], size_font[target_size_font]) > width_pix) {
					width_pix = width_String(string_list[i],size_font[target_size_font]);
				}
				target_size_font++;
			}
		}
		return width_pix;
	}




	/**
	width String
	*/
	public int width_String(String target, int size) {
		return width_String("defaultFont", target, size) ;
	}

	public int width_String(PFont pfont, String target, int size) {
		return width_String(pfont.getName(), target, size);
	}

	public int width_String(String font_name, String target, int size) {
		Font font = new Font(font_name, Font.BOLD, size) ;
		BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
		FontMetrics fm = img.getGraphics().getFontMetrics(font);
		if(target == null) {
			target = "";
		}
		return fm.stringWidth(target);
	}




	public int width_char(char target, int size) {
		return width_char("defaultFont", target, size) ;
	}

	public int width_char(PFont pfont, char target, int size) {
		return width_char(pfont.getName(), target, size);
	}

	public int width_char(String font_name, char target, int size) {
		Font font = new Font(font_name, Font.BOLD, size) ;
		BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
		FontMetrics fm = img.getGraphics().getFontMetrics(font);
		return fm.charWidth(target);
	}

	
	
}
