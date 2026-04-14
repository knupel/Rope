/**
 * 
 * pixel evolution
 * v 0.1.1
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
	size(800,800, P2D);
	set_impact();
	imp.build();
}

void draw() {
	// println("FPS", r.truncate(frameRate,2));
	background(r.BLACK);
	imp.stroke_is(true);
	// here we set the mode to pixel x1
	// 0 is for line
	// 1 is for pixel of size 1
	// 1 is for pixel of size 2
	imp.set_line_mode(1);
	imp.show_lines();
	imp.update_pixels_is(mousePressed);
	String str = "[ " + mouseX + " " + mouseY + " ]";
	text(str, mouseX, mouseY);
	text("press N for new sort", 20, 20);
}

void keyPressed() {
	if(key == 'n') {
		println("nouveau tirage");
		imp.build();
	}
}




void set_impact() {
	imp = new R_Impact(this, width/2, height/2, width - 100);
	
	imp.heart_is(true); // from 1 to max main iteration

	// SET THE MAIN BRANCHES
	int num = 12;
	imp.set_num_main(num); // num of main branch
	imp.set_iter_main(20); // num of node on each branch
	imp.set_angle_main(0.1); // max angle to change the direction of the main branch

	// SET THE LINES WHO CONNECT THE MAIN BRANCHES
	imp.set_num_circle(5); // num of branch circle start from the main branch
	imp.set_iter_circle(num); // num of node on the circle branch / where the max for normal mode is the num of main branches

	// SET ASPECT
	imp.set_stroke(r.WHITE);
	imp.set_density(0.5);
	imp.set_thickness(3);

	int g_level = 2; // num of iteration
	int g_step = 1; // space between the pixel
	int g_type = r.CHAOS;
	if(frameCount%2 == 0) {
		imp.set_pixel_evolution(g_type, g_level, g_level *10 , g_step, g_step *5);
	} else {
		imp.set_pixel_evolution(g_type, g_level, g_step);
	}

}