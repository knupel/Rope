/**
* line test fps one hundred thousand iteration
* is 10 FPS on mac book pro 2018
* 2023-2023
* v 0.0.1
*/

import rope.core.Rope;
import rope.mesh.R_Line2D;

Rope r = new Rope();
int num = 100_000;
R_Line2D [] lines = new R_Line2D[num];
void setup() {
	// don't use classical renderer is too slow, use P2D or P3D instead
	size(800,800,P2D);
	for(int i = 0 ; i < num ; i++) {
		float ax = random(width);
		float ay = random(height);
		float bx = random(width);
		float by = random(height);
		lines[i] = new R_Line2D(this,ax,ay,bx,by);
	}
}

void draw() {
	println("FPS", r.truncate(frameRate,2));
	background(r.BLOOD);
	for(R_Line2D l : lines) {
		int gray = (int)random(255);
		l.stroke_is(true);
		l.stroke(color(gray,gray,gray,gray));
		l.show();
	}
}