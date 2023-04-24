/**
 * 
 * growth example
 * 2023-2023
 * v 0.0.4
 * 
*/

import rope.mesh.R_Line2D;
import rope.vector.vec2;
import rope.core.Rope;

Rope r = new Rope();
int num = 10;
float density = 1;
float thickness = 3.0f;
R_Line2D [] line = new R_Line2D[num];



void setup() {
	size(400,800);
	init_pos();
}


void draw() {
	background(255);
	stroke(r.SANG);
	strokeWeight(5);
	for(R_Line2D l : line) {
		l.show_pixels();
		line(l.a().x(), l.a().y(),l.b().x(),l.b().y());
	}
}

float  dir = 0;
void mousePressed() {
	println(">>>>>>> NEW SORT >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
	init_pos();
	int count = 0;
	// dir = random(TAU);
	dir += 0.1;
	println("direction", dir);
	// dir = random(-PI,PI);
	for(R_Line2D l : line) {
		count++;
		l.set_pixels(density, thickness);
		int level = (int)random(10,1000);
		int step = ceil(random(1,1));
		// float fov = TAU - (PI/2);
		float fov = PI/6;
		// println("dir", dir, "fov", fov);
		l.growth(level,step, dir, fov);

	}
}

void init_pos() {
	float step_y = height / (num + 1);
	float step_x = width / (num + 1);
	for(int i = 0 ; i < num ; i++) {
		int ratio = i + 1;
		line[i] = new R_Line2D(this);
		float pos_y = step_y * ratio;
		float ref_x = width / 2;
		float len = (step_x * i) + step_x;
		float ax = ref_x -(len/2);
		float ay = pos_y + random(-step_y, step_y);
		float bx = ref_x +(len/2);
		float by = pos_y + random(-step_y, step_y);
		line[i].set(ax, ay, bx, by);		
		line[i].set_pixels(density, thickness);
	}

}


