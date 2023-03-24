/**
 * example to use R_Image_Manager and R_Image
 * v 0.0.3
 * 2021-2023
 * 
 * 
 */

import rope.image.R_Image_Manager;
import rope.image.R_Image;

R_Image_Manager lib;
void setup() {
	
	size(600,375,P2D);
	// add PGraphics
	lib = new R_Image_Manager(this);
	PGraphics pg = createGraphics(width,height);

	pg.beginDraw();
	pg.background(255,0,255);
	pg.endDraw();
	lib.add(pg, "pgraphics");

	// add PImage
	PImage p_img = loadImage("petite_puros_girl.jpg");
	lib.add(p_img, "image");

	// add R_Image
	R_Image r_img = new R_Image(this,loadImage("small_dame_hermine.jpg"), "hermine", 1488);
	lib.add(r_img);
}

/**
* there is two ways to acces to PImage from the collection.
 */
void draw() {
	if(mousePressed) {
		image(lib.get_PImage(1),0,0);
		// image(lib.get(1).get_PImage(),0,0);
		println(lib.get_name(1), lib.get_id(1));
	} 

	if(!mousePressed && !keyPressed){
		image(lib.get_PImage(0),0,0);
		// image(lib.get(0).get_PImage(),0,0);
		println(lib.get_name(0), lib.get_id(0));
	}

	if(keyPressed) {
		image(lib.get_PImage(2),0,0);
		// image(lib.get(2).get_PImage(),0,0);
		println(lib.get_name(2), lib.get_id(2));
	}

	text("click mouse or click keyboard to see image", 20, 20);
}