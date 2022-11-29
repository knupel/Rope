/**
 * 
 * simple impact example
 * v 0.0.1
 * 2022-2022
 * 

 * */
import rope.costume.R_Impact;

R_Impact imp;


void setup() {
	size(600,600);
	imp = new R_Impact(this, width/2, height/2);
	
	// imp.normal();
	imp.set_heart(1); // from 1 to max main iteration

	imp.set_num_main(12); // num of main branch
	imp.set_iter_main(20); // num of node on each branch
	imp.set_growth_main(25); // approximative pixel step between each node of the main
	imp.set_angle_main(0.02); // max angle to change the direction of the main branch

	imp.set_num_circle(30); // num of branch circle start from the main branch
	imp.set_iter_circle(12); // num of node on the circle branch / where the max for normal mode is the num of main branches
	imp.set_growth_circle(10);

	imp.build();
}

void draw() {
	background(255);
	fill(0);
	// imp.show_lines();
	imp.show_lines_main();
	if(mousePressed) {
		imp.show_lines_circle();
		imp.show_lines_heart();

	}
	
	String str = "[ " + mouseX + " " + mouseY + " ]";
	text(str, mouseX, mouseY);
}

void keyPressed() {
	println("nouveau tirage");
	if(key == 'n') {
		imp.build();
	}
}