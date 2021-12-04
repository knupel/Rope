/**
* detect if a vec2 is on line or not
* v 0.0.1
* 2021-2021
*/
import rope.vector.vec2;
import rope.core.Rope;


vec2 pos;
vec2 [] poly;
Rope r;
void setup() {
	size(500,500,P2D);
	r = new Rope();
	r.print_out(r.VERSION);
	pos = new vec2(0);
	int num = (int)random(5,10);
	poly = new vec2[num];
	for(int i = 0 ; i < poly.length ; i++) {
		poly[i] = new vec2().rand(0,width);
	}
}

void draw() {
	background(r.BLANC);
	stroke(r.ORANGE);
	pos.set(mouseX, mouseY);
	noStroke();
	if(pos.in_polygon(poly)) {
		fill(r.ROUGE);
	} else {
		fill(r.NOIR);
	}
	beginShape();
	for(int i = 0 ; i < poly.length ; i++) {
		vertex(poly[i].x(),poly[i].y());
	}
	endShape(CLOSE);
}

void mousePressed() {
	for(int i = 0 ; i < poly.length ; i++) {
		poly[i] = new vec2().rand(0,width);
	}
}