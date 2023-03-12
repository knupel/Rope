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
R_Impact impact;
Rope r = new Rope();

void setup() {
	size(600,600);
	set_impact();
}

void draw() {
	background(r.BLOOD);
	fill(r.MAGENTA);
	// fill(r.GRIS[1]);
	stroke(r.GRIS[5]);
	impact.show_polygons();
	fill(r.BLACK);
	if(keyPressed) {
		impact.show_polygon_heart();
	}

	fill(r.WHITE);
	String str = "[ " + mouseX + " " + mouseY + " ]";
	text(str, mouseX + 10, mouseY);
}

void mousePressed() {
	println("mouse position >",mouseX,mouseY);
	for(R_Shape shape : impact.get_all_polygons()) {
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
	println("<<<<<<<<<<<<<------|||| NEW SORT ||||--------->>>>>>>>");
	if(key == 'n') {
		impact.build();
		impact.build_polygon();
	}
}


void set_impact() {
	impact = new R_Impact(this, width/2, height/2);
	
	impact.set_heart(2); // from 1 to max main iteration, if it's upper the value is cap to max.
	int num = 8;
	impact.set_num_main(num); // num of main branch
	impact.set_iter_main(20); // num of node on each branch
	impact.set_growth_main(30); // approximative pixel step between each node of the main
	impact.set_angle_main(0.1); // max angle to change the direction of the main branch

	impact.set_num_circle(20); // num of branch circle start from the main branch
	impact.set_iter_circle(num); // num of node on the circle branch / where the max for normal mode is the num of main branches
	impact.set_growth_circle(10);

	impact.build();

	// this part is the most important, without that... 
	// there is no polygons available
	impact.build_polygon();

}