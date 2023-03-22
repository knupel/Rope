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
	fill(r.GRIS[2]);
	if(!keyPressed) {
		show_polygons_classic();
	} else {
		show_polygond_by_id();
	}

	fill(r.WHITE);
	String str = "[ " + mouseX + " " + mouseY + " ]";
	text(str, mouseX + 10, mouseY);
	text("press any key to show polygon classic", 10, 50);
}

void show_polygons_classic() {
	stroke(r.GRIS[7]);
	imp.show_polygons();
	fill(r.BLACK);
	imp.show_polygon_heart();
}

void show_polygond_by_id() {
	
	int len = imp.get_polygons().size();
	for(int i = 0 ; i < len ; i++) {
		R_Shape shape = imp.get_polygons().get(i);
		if(shape.id().c() == 0 ) {
			fill(r.GRIS[4]);
			noStroke();
		} else {
			fill(r.GRIS[2]);
			stroke(r.GRIS[7]);
		}
		imp.show_polygon(imp.get_polygons().get(i));
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