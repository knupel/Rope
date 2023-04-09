/**
 * 
 * simple impact to show the pixel line
 * v 0.1.2
 * 2023-2023
 * 

 * */
import rope.costume.R_Impact;
import rope.core.Rope;
import rope.mesh.R_Line2D;

R_Impact imp;
Rope r = new Rope();

float min_thickness = 0.1;
float max_thickness = 8;
// 
float min_density = 0.01;
float max_density = 4;


void setup() {
	// faster in P2D render, the speed is increase by 3.5
	size(600,600, P2D);
	set_impact();
	imp.build();
	// when the pixels_colour is used, 
	// this color is used instead the stroke paramater
	imp.set_pixels_colour(r.CYAN, r.YELLOW, r.MAGENTA);
}

void draw() {
	background(r.BLACK);
	imp.update_pixels_is(keyPressed && key=='u');
	if(mousePressed && mouseButton == LEFT) {
		imp.use_gradient_thickness(true, max_thickness, min_thickness);
		imp.use_gradient_density(true, max_density, min_density);
		// that kill the impact palette, after that you need to set this one again
		imp.use_gradient_stroke(true, r.YELLOW, r.RED);
	} else if(mousePressed && mouseButton == RIGHT) {
		imp.use_gradient_thickness(true, min_thickness, max_thickness);
		imp.use_gradient_density(true, min_density, max_density);
		// that kill the impact palette, after that you need to set this one again
		imp.use_gradient_stroke(true, r.YELLOW, r.CYAN);
	} 

	imp.use_gradient_thickness(true);
	imp.use_gradient_density(true);

	println("thickness", imp.get_thickness());
	println("density", imp.get_density());

	imp.set_line_mode(1);
	// imp.show_lines();
	imp.show_lines_main(); // bug color on the fist alement 
	imp.show_lines_circle(); // bug color on the fist alement 
	// imp.show_lines_heart();

	String str = "[ " + mouseX + " " + mouseY + " ]";
	text(str, mouseX, mouseY);
	text("press N for new sort", 20, 20);
	text("press U to update pixels", 20, 35);
  text("click mouse to reverse the thickness", 20, 50);
}

void keyPressed() {
	if(key == 'n') {
    println("nouveau tirage");
    imp.use_gradient(false);
    imp.set_pixels_colour(r.CYAN, r.YELLOW, r.MAGENTA);
		imp.build();
	}
}


void set_impact() {
	imp = new R_Impact(this, width/2, height/2, 500);
	
	imp.heart_is(true);

	// SET THE MAIN BRANCHES
	int num = 12;
	imp.set_num_main(num); // num of main branch
	imp.set_iter_main(20); // num of node on each branch
	imp.set_angle_main(0.1); // max angle to change the direction of the main branch

	// SET THE LINES WHO CONNECT THE MAIN BRANCHES
	imp.set_num_circle(9); // num of branch circle start from the main branch
	imp.set_iter_circle(num); // num of node on the circle branch / where the max for normal mode is the num of main branches
}