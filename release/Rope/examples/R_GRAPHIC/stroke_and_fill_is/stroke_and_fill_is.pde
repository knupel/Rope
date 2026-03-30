/**
 * 
 * manage stroke, fill by an other than noStroke() and noFill()
 * v 0.0.2
 * 2023-2023
 *
 * */

import rope.core.R_Graphic;
import rope.core.Rope;
boolean use_fill_is = true;
boolean use_stroke_is = false;

Rope r = new Rope();

R_Graphic rg; // we cannot use g because is Processing rendering
void setup() {
	size(600,600,P2D);
	rg = new R_Graphic(this);
	rg.background(r.YELLOW);
	rg.strokeWeight(10);
}


void draw() {
	rg.background(r.YELLOW);

	rg.fill_is(use_fill_is);
	rg.fill(r.MAGENTA);
	rg.stroke_is(use_stroke_is);
	rg.stroke(r.CYAN);
	rg.circle(mouseX,mouseY, 50);

	rg.fill_is(!use_fill_is); // reverse the boolean value
	rg.fill(r.MAGENTA);
	rg.stroke_is(!use_stroke_is); // reverse the boolean value
	rg.stroke(r.CYAN);
	rg.circle(mouseY,mouseX, 50);
}


void keyPressed() {
	if(key == 'f') {
		use_fill_is = (use_fill_is) ? false : true;
	}

	if(key == 's') {
		use_stroke_is = (use_stroke_is) ? false : true;
	}
}