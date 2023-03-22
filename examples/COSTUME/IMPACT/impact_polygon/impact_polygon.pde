/**
 * 
 * impact example to create polygon from the patternimpact
 * v 0.0.2
 * 2022-2022
 * 
 * */

import rope.costume.R_Impact;
import rope.mesh.R_Shape;
import rope.core.Rope;
import rope.vector.vec2;
import rope.vector.vec3;
R_Impact imp;
Rope r = new Rope();

void setup() {
	size(600,600);
	set_impact();
	imp.build();
	imp.build_polygon();
}

void draw() {
	background(r.BLOOD);
	fill(r.MAGENTA);
	// fill(r.GRIS[1]);
	stroke(r.GRIS[5]);
	imp.show_polygons();
	// imp.show_lines();
	fill(r.BLACK);
	if(keyPressed && imp.heart_is()) {
		imp.show_polygon_heart();
	}

	fill(r.WHITE);
	String str = "[ " + mouseX + " " + mouseY + " ]";
	text(str, mouseX + 10, mouseY);
}

void mousePressed() {
	println("mouse position >",mouseX,mouseY);
	for(R_Shape shape : imp.get_all_polygons()) {
		if(r.in_polygon(shape, new vec2(mouseX,mouseY))) {
			vec3 [] arr = shape.get_points();
			int id_branch = shape.id().b();
			println("shape ", shape.id().a(), id_branch);
			printArray(arr);
			println("barycenter", shape.barycenter());
		}
	}
 
}


void keyPressed() {
	if(key == 'n') {
		println("<<<<<<<<<<<<<------|||| NEW SORT ||||--------->>>>>>>>");
		imp.build();
		imp.build_polygon();
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