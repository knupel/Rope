/**
 * 
 * 
 * Detection polygon and line
 * 2018-2023
 * v 0.1.0
 * 
 */

 import rope.core.Rope;
import rope.vector.vec2;
import rope.mesh.R_Line2D;

Rope r = new Rope();



vec2 [] polygon;
R_Line2D line;

void setup() {
	line = new R_Line2D(this);
	size(400,400);
	build();
}


void draw() {
	background(r.WHITE);
	noStroke();

	vec2 pointer = new vec2(mouseX,mouseY);
	float marge = 10.0;

	beginShape();
	for(vec2 p : polygon) {
		vertex(p.x(), p.y());
	}
	endShape(CLOSE);

	// r.in_polygon(polygon, pointer, marge)
	// return -1 for out
	// return 0 for the border
	// return 1 when it's full inside...that's depend of border thickness
	int what = r.in_polygon(polygon, pointer, marge);

	boolean is = r.in_line(line.a(), line.b(), pointer, marge);
	if(is) {
		stroke(r.CYAN);
	} else {
		stroke(r.MAGENTA);
	}
	line.show();

	switch(what) {
		case -1: fill(r.BLACK); break;
		case 0: fill(r.RED); break;
		case 1: fill(r.GREEN); break;
	}
}

void keyPressed() {
	build();
}

void build() {
	polygon = new vec2[(int)random(3,10)];
	float step = TAU / polygon.length;
	float angle = 0;
	for(int i = 0 ; i < polygon.length ; i++) {
		float dist = random(0, width/2);
		angle += step;

		float x = cos(angle) * dist;;
		float y = sin(angle) * dist;;
		polygon[i] = new vec2(x,y).add(width/2,height/2);
	}
	line.set(new vec2().rand(0,width), new vec2().rand(0,width));
}