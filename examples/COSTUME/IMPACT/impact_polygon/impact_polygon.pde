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
	// imp.set_heart(0.7); // from 0 to 1

	imp.set_num_main(12); // num of main branch
	imp.set_iter_main(20); // num of node on each branch
	imp.set_growth_main(10); // approximative pixel step between each node of the main
	imp.set_angle_main(0.1); // max angle to change the direction of the main branch

	imp.set_num_circle(10); // num of branch circle start from the main branch
	imp.set_iter_circle(12); // num of node on the circle branch / where the max for normal mode is the num of main branches
	imp.set_growth_circle(60);
	// imp.set_iter_circle(4);

	imp.build();
	imp.build_polygon();
	// imp.show_polygons();
	// imp.show_lines();
	// imp.show_lines_main();
	// imp.show_lines_heart();
	// int index = imp.get_num_main() -1;

	// ArrayList<R_Line2D> list =  imp.get_branch_lines(index);
	// ArrayList<R_Line2D> list =  imp.get_branch_lines(4);
	// println("index", index, list.size());
	// for(int i = 0 ; i < imp.get_num_main() ; i++) {
	// 	for(R_Line2D line : imp.get_branch_lines(i)) {
	// 		println("id", line.id());
	// 	}
	// }
	
}

void draw() {
	background(r.BLOOD);
	fill(r.BLACK, 50);
	stroke(r.GRIS[5]);

	imp.show_polygons();
	// imp.show_lines();

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