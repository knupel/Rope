/**
* detect if a vec2 is on line or not
* v 0.0.1
* 2021-2021
*/
import rope.vector.vec2;
import rope.core.Rope;


vec2 a, b, point;
Rope r;
void setup() {
	size(500,500,P2D);
	r = new Rope();
	r.print_out(r.VERSION);
	point = new vec2(0);
	a = new vec2().rand(new vec2(0), new vec2(width,height));
	b = new vec2().rand(new vec2(0), new vec2(width,height));
}

void draw() {
	background(r.BLANC);
	stroke(r.ORANGE);
	point.set(mouseX, mouseY);
	circle(point.x(), point.y(),20);
	strokeWeight(1);
	float range = 1.0;
	if(point.in_line(a, b, range)) {
		strokeWeight(5);
		stroke(r.ROUGE);
	} else {
		stroke(r.NOIR);
	}
	line(a.x(), a.y(),b.x(), b.y());
}

void mousePressed() {
	a.rand(new vec2(0), new vec2(width,height));
	b.rand(new vec2(0), new vec2(width,height));
}