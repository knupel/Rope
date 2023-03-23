/**
 * 
 * impact example to create polygon 
 * from the pattern impact `
 * and mute few line before build all polygons
 * v 0.1.3
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
	// When you use gradient it's necessary to complete
	// this pattern design by using set function
	// set_fill() and set_stroke() to avoid few graphics problems.
	background(r.BLOOD);
	imp.set_fill(r.GRIS[2]);
	imp.set_stroke(r.WHITE);

	if(mousePressed) {
		imp.use_gradient_thickness(true, 2, 0.1);
	} else {
		imp.use_gradient_thickness(true, 0.1, 2);
	}

	if(keyPressed) {
		imp.show_polygons();
	} else {
		imp.show_lines();
	}

	fill(r.WHITE);
	String str = "[ " + mouseX + " " + mouseY + " ]";
	text(str, mouseX + 10, mouseY);
	text("press \"N\" for new sort", 20,30);
	text("press any to show polygon line", 20,45);
	text("press mouse to reverse gradient", 20,60);
}


void set_impact() {
	imp = new R_Impact(this, width/2, height/2, 300);
	
	imp.heart_is(true); // from 1 to max main iteration, if it's upper the value is cap to max.
	int num = 8;
	imp.set_num_main(num); // num of main branch
	imp.set_iter_main(15); // num of node on each branch
	imp.set_angle_main(0.1); // max angle to change the direction of the main branch

	imp.set_num_circle(20); // num of branch circle start from the main branch
	imp.set_iter_circle(num); // num of node on the circle branch / where the max for normal mode is the num of main branches
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
	println("<<<<<<<<<<<<<------|||| NEW SORT ||||--------->>>>>>>>");
	if(key == 'n') {
		imp.build();
		set_mute();
		imp.build_polygon();
	}
}