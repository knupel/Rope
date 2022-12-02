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

void setup() {
	size(600,600);
	imp = new R_Impact(this, width/2, height/2);
	
	// SET THE MAIN BRANCHES
		//////////////////////////////////////////////
	imp.set_num_main(12); // num of main branch
	imp.set_iter_main(20); // num of node on each branch
	imp.set_growth_main(25); // approximative pixel step between each node of the main
	imp.set_angle_main(0.1); // max angle to change the direction of the main branch

	// SET THE LINES WHO CONNECT THE MAIN BRANCHES
	//////////////////////////////////////////////
	imp.set_num_circle(30); // num of branch circle start from the main branch
	imp.set_iter_circle(12); // num of node on the circle branch / where the max for normal mode is the num of main branches
	imp.set_growth_circle(10);
	
	imp.build();
	set_mute();
}

void set_mute() {
	for(int i = 0 ; i < imp.get_num_circle() ; i++) {
		for(R_Line2D line : imp.get_lines_circle(i)) {
			float chance_to_mute = 0.3;
			if(random(1) < chance_to_mute) {
				line.mute(true);
			}
		}
	}
}

void draw() {
	background(255);
	fill(0);
	imp.use_mute(true);
	imp.show_lines();

	String str = "[ " + mouseX + " " + mouseY + " ]";
	text(str, mouseX, mouseY);
}

void keyPressed() {
	println("nouveau tirage");
	if(key == 'n') {
		imp.build();
		set_mute();
	}
}