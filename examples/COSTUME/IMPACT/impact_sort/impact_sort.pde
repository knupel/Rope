/**
 * 
 * simple impact example
 * v 0.0.1
 * 2022-2022
 * 

 * */
import rope.costume.R_Impact;

R_Impact imp;
int num_circle = 30;
int num_branch = 12;


void setup() {
	size(600,600);
	imp = new R_Impact(this, width/2, height/2);
	
	imp.set_num_main(num_branch); // num of main branch
	imp.set_growth_main(25); // approximative pixel step between each node of the main
	imp.set_angle_main(0.1); // max angle to change the direction of the main branch

	imp.set_num_circle(num_circle); // num of branch circle start from the main branch
	imp.set_iter_circle(num_branch); // num of node on the circle branch / where the max for normal mode is the num of main branches
	imp.set_growth_circle(10);

	imp.build();
}


void draw() {
	evolution();
	background(255);
	fill(0);
	if(!keyPressed) {
		imp.show_lines_main();
		imp.show_lines_branch(num_branch);
		imp.show_lines_circle(num_circle);
	} else {
		imp.show_lines();
	}

	String str = "[ " + mouseX + " " + mouseY + " ]";
	text(str, mouseX, mouseY);
}

void evolution() {
	if(frameCount%30 == 0) {
		println("circle",num_circle);
		println("main",num_branch);
		num_circle++;
		num_branch++;
		if(num_circle >= imp.get_num_circle()) {
			num_circle = 0;
		}
		if(num_branch >= imp.get_num_main()) {
			num_branch = 0;
		}
	}
}

void keyPressed() {
	println("nouveau tirage");
	if(key == 'n') {
		imp.build();
	}
}