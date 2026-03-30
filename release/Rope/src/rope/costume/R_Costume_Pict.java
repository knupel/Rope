/**
* R_Costume_Pict
* v 0.2.0
* 2019-2021
* @author @stanlepunk
* @see https://github.com/StanLepunK/Rope
*/

package rope.costume;

import processing.core.PApplet;
import processing.core.PImage;
import rope.core.R_Graphic;
import rope.svg.R_SVG;

public class R_Costume_Pict extends R_Graphic {
	PImage img;
	R_SVG svg;
	int type = -1; 
	String name;
	int id;

	public R_Costume_Pict(PApplet pa, String path, int id) {
		super(pa);
		if(path.endsWith("png") || path.endsWith("PNG")) {
			img = this.pa.loadImage(path);
			type = 1;
		}

		// add svg
		if(path.endsWith("svg") || path.endsWith("SVG")) {
			svg = new R_SVG(this.pa,path);
			svg.mode(CENTER) ;
			svg.build() ;
			type = 2 ;
		}
		
		String [] split = path.split("/") ;
		name = split[split.length -1] ;
		name = name.substring(0,name.lastIndexOf(".")) ;
		this.id = id;
	}
  
  // get
	public int get_id() {
		return id;
	}

	public int get_type() {
		return type;
	}

	public R_SVG get_svg() {
		return svg;
	}

	public PImage get_img() {
		return img;
	}

	public String get_name() {
		return name;
	}

}
