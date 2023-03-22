/**
 * 
 * R_Impact used with pass_graphic to set a other PGraphics rendering
 * v 0.0.2
 * 2022-2023
 * 

 * */
import rope.costume.R_Impact;
import rope.core.Rope;

Rope r = new Rope();

R_Impact imp;
PGraphics pg;

void setup() {
	size(600,600);
	
	pg = createGraphics(width, height);
	set_impact();
	imp.build();
	imp.build_polygon();
}

void draw() {
	background(0);
	imp.pass_graphic(pg);
	imp.beginDraw();
	imp.clear();

	imp.set_fill(r.YELLOW);
	imp.set_stroke(r.MAGENTA);
	imp.stroke_is(true);
	imp.fill_is(true);

	// if(mousePressed) {
		imp.show_polygons();
	// } else {
	// 	imp.show_lines();
	// }

	imp.endDraw();

	image(pg,0,0);
	String str = "[ " + mouseX + " " + mouseY + " ]";
	text(str, mouseX, mouseY);
}

void keyPressed() {
	println("nouveau tirage");
	if(key == 'n') {
		int size_heart = (int)map(random(1),0,1,0,imp.get_iter_main()/2);
		imp.build();
		imp.build_polygon();
	}
}



void set_impact() {
	imp = new R_Impact(this, width/2, height/2, 300);
	int num = 12;
	// SET THE MAIN BRANCHES
		//////////////////////////////////////////////
	imp.set_num_main(num); // num of main branch
	imp.set_iter_main(20); // num of node on each branch
	imp.set_angle_main(0.1); // max angle to change the direction of the main branch

	// SET THE LINES WHO CONNECT THE MAIN BRANCHES
	//////////////////////////////////////////////
	imp.set_num_circle(30); // num of branch circle start from the main branch
	imp.set_iter_circle(num); // num of node on the circle branch / where the max for normal mode is the num of main branches



}