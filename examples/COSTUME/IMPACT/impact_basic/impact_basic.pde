/**
 * 
 * simple impact example
 * v 0.2.0
 * 2022-2023
 * 

 * */
import rope.costume.R_Impact;

R_Impact imp;

void setup() {
	size(600,600);
	set_impact();
	imp.build();
}

void draw() {
	background(255);
	fill(0);
	imp.show_lines();
	// imp.show_lines_main();
	// imp.show_lines_circle();
	// imp.show_lines_heart();

	String str = "[ " + mouseX + " " + mouseY + " ]";
	text(str, mouseX, mouseY);
	  text("press N for new sort", 20, 20);
}

void keyPressed() {
	
	if(key == 'n') {
		println("nouveau tirage");
		int diam = (int)(random(width/4, width));
		imp.set_diam(diam);
		imp.build();
		println("imp.diam()", imp.diam());
		println("radius", imp.radius());
	}
}


void set_impact() {
	imp = new R_Impact(this, width/2, height/2, 300);
	
	// imp.normal();
	imp.heart_is(true); // from 1 to max main iteration

	// SET THE MAIN BRANCHES
	int num = 12;
	imp.set_num_main(num); // num of main branch
	imp.set_iter_main(10); // num of node on each branch
	imp.set_angle_main(0.1); // max angle to change the direction of the main branch

	// SET THE LINES WHO CONNECT THE MAIN BRANCHES
	imp.set_num_circle(num); // num of branch circle start from the main branch
	imp.set_iter_circle(num); // num of node on the circle branch / where the max for normal mode is the num of main branches
}