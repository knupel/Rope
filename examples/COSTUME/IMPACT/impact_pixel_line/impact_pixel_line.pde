/**
 * 
 * simple impact to show the pixel line
 * v 0.0.2
 * 2023-2023
 * 

 * */
import rope.costume.R_Impact;
import rope.core.Rope;
import rope.mesh.R_Line2D;

R_Impact imp;
Rope r = new Rope();

void setup() {
	// faster in P2D render, the speed is increase by 3.5
	size(600,600, P2D);
	set_impact();
	imp.build();
	set_color_static_pixel_line();
}

void draw() {
	// println("FPS", (int)frameRate);
	background(r.BLACK);
	show_pixel_line();
	String str = "[ " + mouseX + " " + mouseY + " ]";
	text(str, mouseX, mouseY);
}

void keyPressed() {
	println("nouveau tirage");
	if(key == 'n') {
		imp.build();
		set_color_static_pixel_line();
	}
}

void set_color_static_pixel_line() {
	for(R_Line2D line : imp.get_lines()) {
		float dist = r.dist(imp.pos(), line.a());
		float ratio = 1- (dist / imp.radius());
		line.set_pixels(ratio, r.YELLOW, r.CYAN, r.MAGENTA);
	}
}

void show_pixel_line() {
	for(R_Line2D line : imp.get_lines()) {
		if(mousePressed) {
			line.show_pixels(); // static
		} else {
			float dist = r.dist(imp.pos(), line.a());
			// float ratio = 1 - (dist / imp.radius());
			float ratio = 1 - (dist / width);
			println("dist", dist);
			println("radius", imp.radius());
			println("ratio", ratio);
			line.show_pixels(ratio, r.MAGENTA, r.CYAN, r.YELLOW); // dynamic
		}
	}
}


void set_impact() {
	imp = new R_Impact(this, width/2, height/2, 300);
	
	// imp.normal();
	imp.heart_is(true); // from 1 to max main iteration

	// SET THE MAIN BRANCHES
	int num = 12;
	imp.set_num_main(num); // num of main branch
	imp.set_iter_main(20); // num of node on each branch
	imp.set_angle_main(0.1); // max angle to change the direction of the main branch

	// SET THE LINES WHO CONNECT THE MAIN BRANCHES
	imp.set_num_circle(20); // num of branch circle start from the main branch
	imp.set_iter_circle(num); // num of node on the circle branch / where the max for normal mode is the num of main branches
}