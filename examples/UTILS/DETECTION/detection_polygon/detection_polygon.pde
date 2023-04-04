/**
 * 
 * Detection polygone with border
 * 2023-2023
 * v 0.0.2
 * 
 */

import rope.core.Rope;
import rope.vector.vec;
import rope.vector.vec2;
import rope.mesh.R_Shape;

Rope r = new Rope();

R_Shape polygon_a;
R_Shape polygon_b;

void setup() {
	size(800,400);
	polygon_a = new R_Shape(this);
	polygon_b = new R_Shape(this);
	build_polygon(polygon_a, width/4, height/2);
	build_polygon(polygon_b, width - width/4, height/2);
}


void draw() {
	background(r.WHITE);
	noStroke();

	vec2 pointer = new vec2(mouseX,mouseY);
	float marge = 10.0;

	// boolean detection 
	if(r.in_polygon(polygon_a, pointer)) {
		fill(r.CYAN);
	} else {
		fill(r.MAGENTA);
	}
	polygon_a.show();

	// advanced detection with three states
	// 1 for in polygon
	// 0 for in the marge / border of polygon
	// - 1 is out of polygon and the border
	int state = r.in_polygon(polygon_b, pointer, marge);
	if(state == -1) fill(r.MAGENTA);
	else if(state == 0) fill(r.CYAN);
	else if(state == 1) fill(r.YELLOW);
	polygon_b.show();
}



void keyPressed() {
	build_polygon(polygon_a, width/4, height/2);
	build_polygon(polygon_b, width - width/4, height/2);
}

void build_polygon(R_Shape shape, int pos_x, int pos_y) {
	int summits = (int)random(3,10);
	float step = TAU / summits;
	float angle = 0;
	for(int i = 0 ; i < summits ; i++) {
		float dist = random(0, width/4);
		angle += step;

		float x = cos(angle) * dist;;
		float y = sin(angle) * dist;;
		shape.add_points(new vec2(x,y).add(pos_x,pos_y));
	}
}