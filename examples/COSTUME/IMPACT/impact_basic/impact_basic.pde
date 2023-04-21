/**
 * 
 * simple impact example
 * v 0.2.1
 * 2022-2023
 * 

 * */
import rope.costume.R_Impact;

R_Impact imp;
int which_display = 0;
boolean heart_is = true;

void setup() {
	size(600,600,P2D);
	pixelDensity(2);
	set_impact();
	imp.build();
}

void draw() {
	background(255);
	fill(0);
	stroke(0);
	println(imp.stroke_is());
	switch(which_display) {
		case 0 :
			imp.show_lines();
			break;
		case 1 :
			imp.show_lines_main();
			break;
		case 2 :
			imp.show_lines_circle();
			break;
		case 3 :
			imp.show_lines_heart();
			break;
		default :
			imp.show_lines();
			break;
	}

	String str = "[ " + mouseX + " " + mouseY + " ]";
	text(str, mouseX, mouseY);
	text("press N for new sort", 20, 20);
	text("press D to change display", 20, 35);
	text("press H enable or disable heart", 20, 50);
}

void keyPressed() {
	if(key == 'n') {
		println("nouveau tirage");
		int diam = (int)(random(width/4, width));
		imp.set_diam(diam);
		imp.build();
		println("imp.diam()", imp.diam());
		println("radius", imp.radius());
		println("type display", which_display);
	}

	if(key == 'd') {
		which_display++;
		if(which_display > 3) {
			which_display = 0;
		}
	}

	if(key == 'h') {
		if(heart_is) {
			heart_is = false;
		} else {
			heart_is = true;
		}
		imp.heart_is(heart_is);
		imp.build();
	}
}


void set_impact() {
	imp = new R_Impact(this, width/2, height/2, 300);
	
	// imp.normal();
	imp.heart_is(heart_is); // from 1 to max main iteration

	// SET THE MAIN BRANCHES
	int num = 12;
	imp.set_num_main(num); // num of main branch
	imp.set_iter_main(10); // num of node on each branch
	imp.set_angle_main(0.1); // max angle to change the direction of the main branch

	// SET THE LINES WHO CONNECT THE MAIN BRANCHES
	imp.set_num_circle(num); // num of branch circle start from the main branch
	imp.set_iter_circle(num); // num of node on the circle branch / where the max for normal mode is the num of main branches
}