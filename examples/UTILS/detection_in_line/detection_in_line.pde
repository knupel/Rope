/**
 * 
 * 
 * Detection in_line / in_segment
 * 2022-2022
 * v 0.0.1
 * 
 */

import rope.core.Rope;
import rope.vector.vec2;


Rope r = new Rope();



vec2 a = new vec2();
vec2 b = new vec2();
vec2 c = new vec2();

void setup() {
	size(400,400);
	a.rand(0,width);
	b.rand(0,width);
	c.rand(0,width);
}


void draw() {
	background(r.WHITE);
	c.set(mouseX,mouseY);
	stroke(r.BLACK);
	line(a.x(),a.y(),b.x(),b.y());
	circle(c.x(), c.y(), 10);
	float marge = 1;

	fill(r.BLOOD);
	if(r.in_segment(a,b,c,marge)) {
		text("in segment", width/2,height/2 - 10);
	}

	if(r.in_line(a,b,c,marge)) {
		text("in line", width/2,height/2 + 10);
	}
}

void keyPressed() {
	if(key == 'n') {
		println("New sort");
		a.rand(0,width);
		b.rand(0,width);
	}
}