/**
 * 
 * simple impact example
 * v 0.1.1
 * 2022-2023
 * 

 * */
import rope.costume.R_Impact;
import rope.mesh.R_Line2D;

R_Impact imp;
int num_circle = 30;
int num_branch = 5;
int which_branch = 0;
int which_circle = 0;


void setup() {
	size(600,600);
	imp = new R_Impact(this, width/2, height/2);
	imp.heart_is(true);
	
	imp.set_num_main(num_branch); // num of main branch
	imp.set_growth_main(25); // approximative pixel step between each node of the main
	imp.set_angle_main(0.1); // max angle to change the direction of the main branch

	imp.set_num_circle(num_circle); // num of branch circle start from the main branch
	imp.set_iter_circle(num_branch); // num of node on the circle branch / where the max for normal mode is the num of main branches
	imp.set_growth_circle(10);

	imp.build();
}


void draw() {
	background(255);
	text("click on mouse left to change branche",10,20);
	text("press \"n\" for new sort",10,40);
	text("press \"space\" to show all circles",10,60);
	fill(0);
	if(!keyPressed) {
		imp.show_lines_heart();
		imp.show_lines_main();
		imp.show_lines_branch(which_branch);
		// imp.show_lines_circle(which_circle);
	} else {
		imp.show_lines();
	}

	String str = "[ " + mouseX + " " + mouseY + " ]";
	text(str, mouseX, mouseY);
}



void mousePressed() {
	which_circle++;
	which_branch++;
	if(which_circle >= imp.get_num_circle()) {
		which_circle = 0;
	}
	if(which_branch >= imp.get_num_main()) {
		which_branch = 0;
	}
}

void info() {
	for(int i = 0 ; i < imp.get_num_circle() ;i++) {
		for(R_Line2D line : imp.get_lines_circle(i)) {
			if(line.id().f() == Integer.MIN_VALUE) {
				println("line", line.id(), line);
			}
		}
	}
}

void keyPressed() {
	if(key == 'n') {
		println("nouveau tirage");
		imp.build();
		info();
		
	}
}