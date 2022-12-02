/**
 * 
 * simple impact example
 * v 0.0.1
 * 2022-2022
 * 

 * */
import rope.costume.R_Impact;
import rope.mesh.R_Line2D;

R_Impact imp;
int num_circle = 30;
int num_branch = 5;


void setup() {
	size(600,600);
	imp = new R_Impact(this, width/2, height/2);
	imp.set_heart(1);
	
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
	fill(0);
	if(!keyPressed) {
		imp.show_lines_heart();
		imp.show_lines_main();
		imp.show_lines_branch(num_branch);
		// imp.show_lines_circle(num_circle);
	} else {
		imp.show_lines();
	}

	String str = "[ " + mouseX + " " + mouseY + " ]";
	text(str, mouseX, mouseY);
}



void mousePressed() {
	num_circle++;
	num_branch++;
	if(num_circle >= imp.get_num_circle()) {
		num_circle = 0;
	}
	if(num_branch >= imp.get_num_main()) {
		num_branch = 0;
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
		// for(int i = 0 ; i < imp.get_num_main() ; i++) {
		// 	println("index branch", i);
		// 	for(R_Line2D line : imp.get_lines_branch(i)) {
		// 		println(line.id(), line);

		// 	}
		// 	// printArray(imp.get_lines_branch(i));
		// 	// imp.get_lines_branch(i);

		// }

		// println("MISSING FOR PAPA");
		// for(int i = 0 ; i < imp.get_num_circle() ; i++) {
		// 	for(R_Line2D line : imp.get_lines_circle(i)) {
		// 		if(line.id().f() == Integer.MAX_VALUE) {
		// 			println(line.id(), line);
		// 		}
		// 	}
		// }
		
	}
}