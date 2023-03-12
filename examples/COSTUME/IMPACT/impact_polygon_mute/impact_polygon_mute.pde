/**
 * 
 * impact example to create polygon 
 * from the pattern impact `
 * and mute few line before build all polygons
 * v 0.1.0
 * 2022-2023
 * 

 * */
import rope.costume.R_Impact;
import rope.mesh.R_Line2D;
import rope.core.Rope;
import rope.mesh.R_Shape;
R_Impact impact;
Rope r = new Rope();


void setup() {
	size(600,600);
	set_impact();

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
	impact.show_polygons();
	fill(r.BLACK);
	impact.show_polygon_heart();
}

void show_polygond_by_id() {
	
	int len = impact.get_polygons().size();
	for(int i = 0 ; i < len ; i++) {
		R_Shape shape = impact.get_polygons().get(i);
		if(shape.id().c() == 0 ) {
			fill(r.GRIS[4]);
			noStroke();
		} else {
			fill(r.GRIS[2]);
			stroke(r.GRIS[7]);
		}
		impact.show_polygon(impact.get_polygons().get(i));
	}
}


void set_impact() {
	impact = new R_Impact(this, width/2, height/2);
	
	impact.set_heart(1); // from 1 to max main iteration, if it's upper the value is cap to max.
	int num = 8;
	impact.set_num_main(num); // num of main branch
	impact.set_iter_main(15); // num of node on each branch
	impact.set_growth_main(10); // approximative pixel step between each node of the main
	impact.set_angle_main(0.1); // max angle to change the direction of the main branch

	impact.set_num_circle(20); // num of branch circle start from the main branch
	impact.set_iter_circle(num); // num of node on the circle branch / where the max for normal mode is the num of main branches
	impact.set_growth_circle(10);

	impact.build();
	set_mute();
	impact.build_polygon();

}



void set_mute() {
	for(int i = 0 ; i < impact.get_num_circle() ; i++) {
		for(R_Line2D line : impact.get_lines_circle(i)) {
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
		impact.build();
		set_mute();
		impact.build_polygon();
	}
}