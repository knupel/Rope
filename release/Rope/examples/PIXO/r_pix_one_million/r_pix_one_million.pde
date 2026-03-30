/**
* R_Pix exemple with 10_000 particles
* 2023-2023
* v 0.0.1
*/

import rope.core.Rope;
import rope.pixo.R_Pix;
Rope r = new Rope();

R_Pix [] pixies = new R_Pix[1_000_000];


void setup() {
	size(800,800);
	for(int i = 0 ; i < pixies.length ; i++) {
		int x = (int)random(width);
		int y = (int)random(height);
		pixies[i] = new R_Pix(x,y, width, height);
		int c = color(random(255));
		pixies[i].fill(c);
	}
}


void draw() {
	println("frameRate", r.truncate(frameRate,1));
	for(int i = 0; i < pixies.length ; i++) {
		int x = (int)pixies[i].x() + (int)random(-3,3);
		int y = (int)pixies[i].y() + (int)random(-3,3);
		int c = pixies[i].fill();
		set(x,y,c);

	}
}


