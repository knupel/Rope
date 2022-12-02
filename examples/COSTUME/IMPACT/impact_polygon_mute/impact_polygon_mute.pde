/**
 * 
 * impact example to create polygon 
 * from the pattern impact `
 * and mute few line before build all polygons
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
	
	imp.set_heart(1); // from 1 to max main iteration, if it's upper the value is cap to max.
	int num = 8;
	imp.set_num_main(num); // num of main branch
	imp.set_iter_main(15); // num of node on each branch
	imp.set_growth_main(30); // approximative pixel step between each node of the main
	imp.set_angle_main(0.1); // max angle to change the direction of the main branch

	imp.set_num_circle(20); // num of branch circle start from the main branch
	imp.set_iter_circle(num); // num of node on the circle branch / where the max for normal mode is the num of main branches
	imp.set_growth_circle(10);

	imp.build();
	set_mute();
	imp.build_polygon();
}

void draw() {
	background(r.BLOOD);
	fill(r.GRIS[2]);
	stroke(r.GRIS[7]);
	imp.show_polygons();
	fill(r.BLACK);
	imp.show_polygon_heart();

	fill(r.WHITE);
	String str = "[ " + mouseX + " " + mouseY + " ]";
	text(str, mouseX + 10, mouseY);
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