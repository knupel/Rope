/**
 * 
 * manage stroke, fill by an other than noStroke() and noFill()
 * v 0.2.0
 * 2018-2023
 *
 * */

import rope.core.R_Graphic;
import rope.core.Rope;
boolean use_fill_is = true;
boolean use_stroke_is = false;

Rope r = new Rope();

R_Graphic g;
// PGraphics pg;
void setup() {
	size(600,600,P2D);
	g = new R_Graphic(this);
	g.background(r.YELLOW);
	g.strokeWeight(10);
}


void draw() {
	g.background(r.YELLOW);

	g.fill_is(use_fill_is);
	g.fill(r.MAGENTA);
	g.stroke_is(use_stroke_is);
	g.stroke(r.CYAN);
	g.circle(mouseX,mouseY, 50);

	g.fill_is(!use_fill_is); // reverse the boolean value
	g.fill(r.MAGENTA);
	g.stroke_is(!use_stroke_is); // reverse the boolean value
	g.stroke(r.CYAN);
	g.circle(mouseY,mouseX, 50);
}


void keyPressed() {
	if(key == 'f') {
		use_fill_is = (use_fill_is) ? false : true;
	}

	if(key == 's') {
		use_stroke_is = (use_stroke_is) ? false : true;
	}
}