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
vec2 pointer = new vec2();

void setup() {
	size(400,400);
	a.rand(0,width);
	b.rand(0,width);
	// c.rand(0,width);
}


void draw() {
	background(r.WHITE);
	pointer.set(mouseX,mouseY);
	stroke(r.BLACK);
	strokeWeight(1);
	circle(pointer.x(), pointer.y(), 10);
	float marge = 20;

	fill(r.BLOOD);
		if(r.in_line(a,b,pointer,marge)) {
		strokeWeight(marge * 0.5);
		text("in line", 20, 35);
	}
	if(r.in_segment(a,b,pointer,marge)) {
		strokeWeight(marge*2);
		text("in segment", 20,20);
	}



	line(a.x(),a.y(),b.x(),b.y());
	
}

void keyPressed() {
	if(key == 'n') {
		println("New sort");
		a.rand(0,width);
		b.rand(0,width);
	}
}