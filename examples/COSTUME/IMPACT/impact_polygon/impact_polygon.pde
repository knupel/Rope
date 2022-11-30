/**
 * 
 * simple impact example
 * v 0.0.1
 * 2022-2022
 * 

 * */
import rope.costume.R_Impact;
import rope.mesh.R_Line2D;
import rope.mesh.R_Shape;
import rope.core.Rope;
import rope.vector.vec2;
import rope.vector.vec3;
R_Impact imp;
Rope r = new Rope();


void setup() {
	size(600,600);
	imp = new R_Impact(this, width/2, height/2);
	
	// imp.normal();
	imp.set_heart(1); // from 1 to max main iteration, if it's upper the value is cap to max.
	int num = 5;
	imp.set_num_main(num); // num of main branch
	imp.set_iter_main(15); // num of node on each branch
	imp.set_growth_main(30); // approximative pixel step between each node of the main
	imp.set_angle_main(0.1); // max angle to change the direction of the main branch

	imp.set_num_circle(5); // num of branch circle start from the main branch
	imp.set_iter_circle(num); // num of node on the circle branch / where the max for normal mode is the num of main branches
	imp.set_growth_circle(25);
	// imp.set_iter_circle(4);

	imp.build();
	imp.build_polygon();
}

void draw() {
	background(r.BLOOD);
	fill(r.GRIS[1]);
	stroke(r.GRIS[5]);
	imp.show_polygons();
	fill(r.BLACK);
	imp.show_polygon_heart();
	if(mousePressed) {
		stroke(r.WHITE);
		imp.show_lines();
	}


	fill(r.WHITE);
	String str = "[ " + mouseX + " " + mouseY + " ]";
	text(str, mouseX + 10, mouseY);
}

void mousePressed() {
	println("souris >",mouseX,mouseY);
	for(R_Shape shape : imp.get_all_polygons()) {
		if(r.in_polygon(shape, new vec2(mouseX,mouseY))) {
			vec3 [] arr = shape.get_points();
			int id_branch = shape.id().b();
			println("shape ", shape.id().a(), id_branch);
			printArray(arr);

		}
	}
}


void keyPressed() {
	println("nouveau tirage");
	if(key == 'n') {
		imp.build();
		imp.build_polygon();
	}
}