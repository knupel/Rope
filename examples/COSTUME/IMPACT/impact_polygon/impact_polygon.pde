/**
 * 
 * simple impact example
 * v 0.0.1
 * 2022-2022
 * 

 * */
import rope.costume.R_Impact;
import rope.mesh.R_Line2D;
import rope.core.Rope;
R_Impact imp;
Rope r = new Rope();


void setup() {
	size(600,600);
	imp = new R_Impact(this, width/2, height/2);
	
	// imp.normal();
	imp.set_heart(0.7); // from 0 to 1
	int num = 20;
	imp.set_num_main(num); // num of main branch
	imp.set_iter_main(30); // num of node on each branch
	imp.set_growth_main(5); // approximative pixel step between each node of the main
	imp.set_angle_main(0.1); // max angle to change the direction of the main branch

	imp.set_num_circle(20); // num of branch circle start from the main branch
	imp.set_iter_circle(num); // num of node on the circle branch / where the max for normal mode is the num of main branches
	imp.set_growth_circle(10);
	// imp.set_iter_circle(4);

	imp.build();
	imp.build_polygon();
}

void draw() {
	background(r.BLOOD);
	fill(r.BLACK);
	stroke(r.GRIS[8]);
	imp.show_polygons();

	fill(r.WHITE);
	String str = "[ " + mouseX + " " + mouseY + " ]";
	text(str, mouseX, mouseY);
}

void keyPressed() {
	println("nouveau tirage");
	if(key == 'n') {
		imp.build();
		imp.build_polygon();
	}
}