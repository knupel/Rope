/**
* Exemple to print frame
* in the classic context and the Retina or HD screen context
* For those function we use BigBang class wgho is a extend of Rope class with Processing Option
* v 0.0.1
* 2023-2023
* 
* 

* 
* 
*/

import rope.core.Rope;
import rope.core.BigBang;
import rope.core.R_Graphic;

Rope r = new Rope();
R_Graphic rg;
PFont font;
BigBang bb;
String path;
boolean use_pixel_density;

void setup() {
	bb = new BigBang(this);
	size(500,500,P2D);
	pixelDensity(2);
	usePixelDensity();
	font = createFont("DIN-Medium", 20);

	path = bb.sketchPath(0)+"/impression/";
	artwork();
}

void draw() {}


void keyPressed() {
	artwork();
	if(key == 'r') {
		print_retina(frameCount);

	}
	if(key == 'p') {
		print_classic(frameCount);
	}
}


void print_retina(int id) {
	String name = "retina_"+id + ".jpg";
	bb.save_frame(path,name);
}


void print_classic(int id) {
	String name = "classic_"+id + ".jpg";
	bb.save_frame(path,name);
}

void usePixelDensity() {
	use_pixel_density = true;
	rg = new R_Graphic(this);
	rg.pixel_density_is(use_pixel_density);
	bb.pixel_density_is(use_pixel_density);
}

void artwork() {
	background(r.BLOOD);
	int ca = r.WHITE;
	noStroke();
	fill(r.BLACK);
	int diam = 10;
 	int w = width;
 	int h = height;
 	// int w = pixelWidth;
 	// int h = pixelHeight;
 	loadPixels();
	for(int i = 0 ; i < 2000; i++) {
		int x = (int)random(w);
		int y = (int)random(h);
		if(i%10 == 0) {
			circle(x,y,diam);		
		} else {
			if(use_pixel_density) {
				// need to multiply the coord of each pixel because the resolution of screen
				// the other solution is use the arg pixelWidth & pixelHeight for the x and y
				// set(x*displayDensity(),y*displayDensity(),ca);
				rg.plot_x2(x*displayDensity(),y*displayDensity(),ca);
			} else {
				set(x,y,ca);
			}
		}
	}
	updatePixels();
	fill(r.WHITE);
	textFont(font);
	textSize(20);
	textAlign(CENTER);
	text("ARTWORK", width/2, height/2);
}