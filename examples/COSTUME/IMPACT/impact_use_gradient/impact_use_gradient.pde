/**
 * 
 * impact example to create polygon 
 * from the pattern impact `
 * and mute few line before build all polygons
 * v 0.1.2
 * 2022-2023
 * 

 * */
import rope.costume.R_Impact;
import rope.mesh.R_Line2D;
import rope.core.Rope;
import rope.mesh.R_Shape;
R_Impact imp;
Rope r = new Rope();


void setup() {
	size(600,600);
	set_impact();
	imp.build();
	set_mute();
	imp.build_polygon();
}

void draw() {
	background(r.BLOOD);
	int color_a = r.CYAN;
	int color_b = r.MAGENTA;
	// noStroke();
	if(keyPressed) {
		imp.set_fill(r.RED, r.YELLOW);
		imp.set_stroke(r.YELLOW, r.RED);
		imp.set_thickness(2, 0.1);
	}
	if(!mousePressed) {
		// use the default setting
		imp.use_gradient_fill(true);
		imp.use_gradient_stroke(true);
		imp.use_gradient_thickness(true);
	} else {
		// reset the argument fill, stroke, thickness and density
		// so after that you to back you need to set aspect again or rebuild
		imp.use_gradient_fill(true, color_b, color_a);
		imp.use_gradient_stroke(true, color_a, color_b);
		imp.use_gradient_thickness(true, 0.1, 2);
	}

	imp.show_polygons();


	fill(r.WHITE);
	String str = "[ " + mouseX + " " + mouseY + " ]";
	text(str, mouseX + 10, mouseY);
	text("press \"N\" for new impact",20,30);
	text("click mouse to reverse the aspect setting",20,45);
	text("press any key to back to orinals colours",20,60);
}


void set_impact() {
	imp = new R_Impact(this, width/2, height/2, 500);
	imp.heart_is(true); // from 1 to max main iteration, if it's upper the value is cap to max.
	int num = 8;
	imp.set_num_main(num); // num of main branch
	imp.set_iter_main(10); // num of node on each branch
	imp.set_angle_main(0.1); // max angle to change the direction of the main branch

	imp.set_num_circle(25); // num of branch circle start from the main branch
	imp.set_iter_circle(num); // num of node on the circle branch / where the max for normal mode is the num of main branches


	imp.set_fill(r.RED, r.YELLOW);
	imp.set_stroke(r.YELLOW, r.RED);
	imp.set_thickness(2, 0.1);
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


void keyPressed() {
	if(key == 'n') {
		println("<<<<<<<<<<<<<------|||| NEW SORT ||||--------->>>>>>>>");
		set_impact();
		imp.build();
		set_mute();
		imp.build_polygon();
	}
}