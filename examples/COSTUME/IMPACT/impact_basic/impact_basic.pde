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
	set_impact();

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
}

void keyPressed() {
	println("nouveau tirage");
	if(key == 'n') {
		// int size_heart = (int)map(random(1),0,1,0,imp.get_iter_main()/2);
		// imp.set_heart(size_heart);
		imp.build();
	}
}


void set_impact() {
	imp = new R_Impact(this, width/2, height/2);
	
	// imp.normal();
	imp.heart_is(true); // from 1 to max main iteration

	// SET THE MAIN BRANCHES
	//////////////////////////////////////////////
	int num = 12;
	imp.set_num_main(num); // num of main branch
	imp.set_iter_main(20); // num of node on each branch
	imp.set_growth_main(25); // approximative pixel step between each node of the main
	imp.set_angle_main(0.1); // max angle to change the direction of the main branch

	// SET THE LINES WHO CONNECT THE MAIN BRANCHES
	//////////////////////////////////////////////
	imp.set_num_circle(30); // num of branch circle start from the main branch
	imp.set_iter_circle(num); // num of node on the circle branch / where the max for normal mode is the num of main branches
	imp.set_growth_circle(10);

	imp.build();
}