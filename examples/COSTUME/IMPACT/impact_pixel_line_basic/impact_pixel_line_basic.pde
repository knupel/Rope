/**
* 
* simple impact to show the pixel line
* with pixelDensity(2) or not
* basic use
* v 0.2.0
* 2023-2023
* @author @knupel
* @see https://github.com/knupel/Rope/blob/master/src/rope/mesh/R_Line2D.java
*
* */

import rope.costume.R_Impact;
import rope.core.Rope;
import rope.mesh.R_Line2D;

R_Impact imp;
Rope r = new Rope();
boolean use_pixel_density = false;

void setup() {
	// faster in P2D render, the speed is increase by 3.5
	size(600,600, P2D);

	// to have rendering with pixelDensity option
	pixelDensity(2);
	use_pixel_density = true;

	set_impact();
	imp.build();
	imp.set_density(0.7);
	imp.set_thickness(4);
	imp.set_stroke(r.MAGENTA);
	// imp.stroke_is(true); // need to enable for the classic Line rendering
}

void draw() {
	println("FPS", (int)frameRate);
	background(r.BLACK);
	// imp.update_pixels(mousePressed);
	if(mousePressed) {
		imp.set_density(map(sin(frameCount * 0.03), -1, 1, 0.1, 0.6));
	}
	if(imp.pixel_density_is()) {
		imp.set_line_mode(2); // better with pixelDensity(2)
	} else {
		imp.set_line_mode(1); // 0 is classic one, 1 and 2 is for pixel x1 and x2
	}
	

	imp.show_lines();

	String str = "[ " + mouseX + " " + mouseY + " ]";
	text(str, mouseX, mouseY);
	text("press N for new sort", 20, 20);
	text("click mouse to switch dynamic / static", 20, 35);
}

void keyPressed() {
	if(key == 'n') {
		println("nouveau tirage");
		imp.build();
		imp.set_density(random(1.2));
	}
}


void set_impact() {
	imp = new R_Impact(this, width/2, height/2, 500);
	imp.pixel_density_is(use_pixel_density); // to use PixelDensity from Processing, for Retina and other HD screen
	imp.heart_is(true); // from 1 to max main iteration

	// SET THE MAIN BRANCHES
	int num = 12;
	imp.set_num_main(num); // num of main branch
	imp.set_iter_main(20); // num of node on each branch
	imp.set_angle_main(0.1); // max angle to change the direction of the main branch

	// SET THE LINES WHO CONNECT THE MAIN BRANCHES
	imp.set_num_circle(10); // num of branch circle start from the main branch
	imp.set_iter_circle(num); // num of node on the circle branch / where the max for normal mode is the num of main branches
}