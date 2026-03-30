/**
 *   ___      ___   ____   _______
 *  | -  \   /   \  |    \ |  ___/
 *  | |/  | |   \ | | |\ | |  |__
 *  |    /  | | | | | |  / |  __/
 *  | |  \  \ \   / |  |/  |  |____
 *  |_| \_\  \___/  |_ |   |______/
 * 
 * 
 * @author @knupel
 * @see https://github.com/knupel/Rope
 * 
 * BIG BANG ROPE
 * is the main class of library
 * 2018-2023
 * v 2.2.0
 * 
 * WARNING : Here it's PROCESSING BIG BANG
 * BigBang is used to acces directly to Processing method, to keep Rope with only Java Stuff
 
 */
package rope.core;
import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PGraphics;
import processing.core.PImage;
import rope.utils.R_State.State;

import java.awt.Font; 
import java.awt.image.BufferedImage ;

import java.io.IOException;
import java.io.OutputStream;
import java.io.File;


import java.io.FileOutputStream;

// import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import javax.imageio.ImageWriter;
import javax.imageio.ImageWriteParam;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.ImageIO;
import javax.imageio.IIOImage;
import java.util.Iterator;

import java.awt.Graphics;
import java.awt.FontMetrics;




public class BigBang extends Rope {
	public PApplet pa;
	protected boolean pixel_density_is = false; 


	public BigBang(PApplet pa) {
		if(pa == null) {
			print_err("Papplet pa is null, maybe your forget to use function State.init(PApplet pa)\nor you try to try to create new Object() Crope outside the setup(), draw() or setting()");
			System.exit(0);
		}
		this.pa = pa;
		State.init(pa);
	}


	/**
	 * MISC IMPORTANT
	 */

	public void pixel_density_is(boolean is) {
		this.pixel_density_is = is;
	}

	public boolean pixel_density_is() {
		return this.pixel_density_is;
	}

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
	 * 
	 * @param print_info_is if it's false there is no information print in the console
	 * @return array float data color set
	 */
	public float [] getColorMode(boolean print_info_is) {
		return getColorMode(this.pa.g, print_info_is);
	}

	public float [] getColorMode() {
		return getColorMode(false);
	}
  
	 /**
		* 
		* @param filename, it's String path of your image, by default the app search in in data folder at the root of your code.
		* @return PImage result
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
	 * @param value int to set seed noise
	 */
	public void noiseSeed(int value) {
		this.pa.noiseSeed(value);
	}

	/**
	 * 
	 * @param x float argument
	 * @param y float argument
	 * @return float noise value
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
	 * @param gray argument for X, Y, Z component
	 * @return int color argument
	 */
	public int color(float gray) {
		return this.pa.color(gray);
	}
	
	/**
	 * This Processing clone method, add check if any PGraphics is active, and if it's a case work ont it
	 * @param gray argument for X, Y, Z component
	 * @param alpha argument for A component
	 * @return int color argument
	 */
	public int color(float gray, float alpha) {
		return this.pa.color(gray, alpha);	
	}

	/**
	 * This Processing clone method, add check if any PGraphics is active, and if it's a case work ont it
	 * @param v1 float argument for X component
	 * @param v2 float argument for Y component
	 * @param v3 float argument for Z component
	 * @return int color argument
	 */
	public int color(float v1, float v2, float v3) {
		return this.pa.color(v1, v2, v3);
	}

	/**
	 * This Processing clone method, add check if any PGraphics is active, and if it's a case work ont it
	 * @param v1 float argument for X component
	 * @param v2 float argument for Y component
	 * @param v3 float argument for Z component
	 * @param alpha float argument for Alpha component
	 * @return int color argument
	 */
	public int color(float v1, float v2, float v3, float alpha) {
		return this.pa.color(v1, v2, v3, alpha);
	}

	/**
	 * This Processing clone method, add check if any PGraphics is active, and if it's a case work ont it
	 * @param value to set component
	 * @return int value of alpha
	 */
	public float alpha(int value) {
		return this.pa.alpha(value);
	}

	/**
	 * This Processing clone method, add check if any PGraphics is active, and if it's a case work ont it
	 * @param value to set component
	 * @return float value of component color
	 */
	public float hue(int value) {
		return this.pa.hue(value);
	}

	/**
	 * This Processing clone method, add check if any PGraphics is active, and if it's a case work ont it
	 * @param value to set component
	 * @return float value of component color
	 */
	public float saturation(int value) {
		return this.pa.saturation(value);
	}

	/**
	 * This Processing clone method, add check if any PGraphics is active, and if it's a case work ont it
	 * @param value to set component
	 * @return float value of component color
	 */
	public float brightness(int value) {
		return this.pa.brightness(value);
	}

	/**
	 * This Processing clone method, add check if any PGraphics is active, and if it's a case work on it
	 * @param value to set component
	 * @return float value of component color
	 */
	public float red(int value) {
		return this.pa.red(value);
	}

	/**
	 * This Processing clone method, add check if any PGraphics is active, and if it's a case work on it
	 * @param value to set component
	 * @return float value of component color
	 */
	public float green(int value) {
		return this.pa.green(value);
	}

	/**
	 * This Processing clone method, add check if any PGraphics is active, and if it's a case work on it
	 * @param value to set component
	 * @return float value of component color
	 */
	public float blue(int value) {
		return this.pa.blue(value);
	}



	/**
	 * 
	 * @param start_color
	 * @param end_color
	 * @param amt value from 0 to 1
	 * @param mode choice between RGB or HSB, that can be usefull when you're in HSB mode because the rendering is not really good
	 * @return an int color value compute from the amt value
	 */
	public int lerpColor(int start_color, int end_color, float amt, int mode) {
		return this.pa.lerpColor(start_color, end_color, amt, mode);
	}






	public int longest_String(String[] string_list) {
		int finish = 0;
		if(string_list != null) finish = string_list.length;
		return longest_String(string_list, 0, finish);
	}

	//with starting and end key point in the String must be sort
	
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
	* Longest String with PFont
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
	* Longest String with String name Font
	*/
	
	public int longest_String_pixel(String font_name, String[] string_list, int... size_font) {
		int finish = 0;
		if(string_list != null) finish = string_list.length;
		return longest_String_pixel(font_name, string_list, size_font, 0, finish);
	}

	// different size by line
	
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
	* width String
	*/
	
	/**
	 * 
	 * @param target String must be compute
	 * @param size of font to make the approximation;
	 * @return
	 */
	public int width_String(String target, int size) {
		return width_String("defaultFont", target, size) ;
	}
	
	/**
	 * 
	 * @param pfont font to make the approximation computing
	 * @param target String must be compute
	 * @param size of font to make the approximation;
	 * @return
	 */
	public int width_String(PFont pfont, String target, int size) {
		return width_String(pfont.getName(), target, size);
	}

	/**
	 * 
	 * @param font_name font to make the approximation computing
	 * @param target String must be compute
	 * @param size of font to make the approximation;
	 * @return
	 */
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




	public String sketchPath(int minus) {
		minus = abs(minus);
		String [] element = split(sketchPath(),"/");
		String new_path ="" ;
		if(minus < element.length ) {
			for(int i = 0 ; i < element.length -minus ; i++) {
				new_path +="/";
				new_path +=element[i];
			}
			return new_path; 
		} else {
			print_err("The number of path elements is lower that elements must be remove, instead a data folder is used");
			return sketchPath()+"/data";
		}  
	}


	public String sketchPath() {
		return this.pa.sketchPath();
	}


	// SAVE FILE and IMAGE
	//////////////////////

	/**
	* Save Frame
	*/
	public void save_frame(String where, String filename, PImage img) {
		float compression = 1.0f;
		save_frame(where, filename, compression, img);
	}

	public void save_frame(String where, String filename) {
		float compression = 1.0f ;
		save_frame(where, filename, compression, this.pa.g);
	}

	public void save_frame(String where, String filename, float compression) {
		save_frame(where, filename, compression, this.pa.g);
	}

	public void save_frame(String where, String filename, float compression, PImage img) {
		// check if the directory or folder exist, if it's not create the path
		File dir = new File(where);
		dir.mkdir() ;
		// final path with file name adding
		String path = where+"/"+filename;
		try {
			OutputStream os = new FileOutputStream(new File(path));
			BufferedImage buff_img;
			if(img == null) {
			} else {
				img.loadPixels();
				int w = img.width;
				int h = img.height;
				if(pixel_density_is()) {
					w = img.pixelWidth;
					h = img.pixelHeight;
				}
				buff_img = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
				buff_img.setRGB(0, 0, w, h, img.pixels, 0, w);
				print_out("save_frame():",filename, "is saved");

				if(extension_is(path, "bmp")) {
					save_BMP(os, buff_img);
				} else if(extension_is(path, "jpg", "jpeg")) {
					save_JPG(os, compression, buff_img);
				} else {
					print_err("save_frame(): no save match with this path "+path);
				}
			} 
		} catch (FileNotFoundException e) {
			print_err("fail to save", e);
			print_err("save_frame(): Maybe too much folders need to be create only one more is possible");
		}
	}

	/**
	* SAVE PNG
	*/
	boolean record_PNG;
	void save_PNG() {
		save_PNG("data", "shot_"+ranking_shot);
	}

	void save_PNG(String path, String name_file) {
		if(record_PNG) {
			this.pa.saveFrame(path + "/" + name_file + ".png");
			record_PNG = false;
		}
	}

	void event_PNG() {
		record_PNG = true;
	}
	/**
	SAVE JPG
	v 0.0.1
	*/
	// classic one
	boolean save_JPG(OutputStream output, float compression,  BufferedImage buff_img) {
		compression = truncate(compression, 1);
		if(compression < 0) compression = 0.0f;
		else if(compression > 1) compression = 1.0f;

		try {
			ImageWriter writer = null;
			ImageWriteParam param = null;
			IIOMetadata metadata = null;

			if ((writer = image_io_writer("jpeg")) != null) {
				param = writer.getDefaultWriteParam();
				param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
				param.setCompressionQuality(compression);

				writer.setOutput(ImageIO.createImageOutputStream(output));
				writer.write(metadata, new IIOImage(buff_img, null, metadata), param);
				writer.dispose();
				output.flush();
				javax.imageio.ImageIO.write(buff_img, "jpg", output);
			}
			return true;
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	ImageWriter image_io_writer(String extension) {
		// code from Processing PImage.java
		Iterator<ImageWriter> iter = ImageIO.getImageWritersByFormatName(extension);
		if (iter.hasNext()) {
			return iter.next();
		}
		return null;
	}
	/**
	SAVE BMP
	v 0.3.0.1
	*/
	// SAVE
	public boolean save_BMP(OutputStream output, BufferedImage buff_img) {
		try {
			Graphics g = buff_img.getGraphics();
			g.dispose();
			output.flush();
			
			ImageIO.write(buff_img, "bmp", output);
			return true;
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return false;
	}


	private String ranking_shot = "_######" ;
// PDF
	boolean record_PDF;
	public void start_PDF() {
		start_PDF(null,null) ;
	}

	public void start_PDF(String name_file) {
		start_PDF(null, name_file) ;
	}

	public void start_PDF(String path_folder, String name_file) {
		if(path_folder == null) path_folder = "pdf_folder";
		if(name_file == null) name_file = "pdf_file_"+ranking_shot;

		if (record_PDF && !record_PNG) {
			if(get_renderer() == "P3D") {
				this.pa.beginRaw(PDF, path_folder+"/"+name_file+".pdf"); 
			} else {
				this.pa.beginRecord(PDF, path_folder+"/"+name_file+".pdf");
			}
		}
	}

	void save_PDF() {
		if (record_PDF && !record_PNG) {
			if(get_renderer() == "P3D") {
				this.pa.endRaw(); 
			} else {
				this.pa.endRecord() ;
			}
			print_err("PDF");
			record_PDF = false;
		}
	}

	void event_PDF() {
		record_PDF = true;
	}
}
