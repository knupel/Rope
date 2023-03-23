/**
 * 
 * simple impact example
 * v 0.1.0
 * 2022-2023
 * 

 * */
import rope.costume.R_Impact;
import rope.mesh.R_Line2D;

R_Impact imp;

void setup() {
	size(600,600);
	set_impact();
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
	text("press N for new sort", 20, 20);
}

void keyPressed() {
	println("nouveau tirage");
	if(key == 'n') {
		imp.build();
		set_mute();
	}
}

void set_impact() {
	imp = new R_Impact(this, width/2, height/2, 500);
	imp.heart_is(true); // from 1 to max main iteration

	// SET THE MAIN BRANCHES
	//////////////////////////////////////////////
	int num = 12;
	imp.set_num_main(num); // num of main branch
	imp.set_iter_main(15); // num of node on each branch
	imp.set_angle_main(0.1); // max angle to change the direction of the main branch

	// SET THE LINES WHO CONNECT THE MAIN BRANCHES
	//////////////////////////////////////////////
	imp.set_num_circle(15); // num of branch circle start from the main branch
	imp.set_iter_circle(num); // num of node on the circle branch / where the max for normal mode is the num of main branches
}