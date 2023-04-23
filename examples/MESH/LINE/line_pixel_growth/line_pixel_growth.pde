/**
 * 
 * growth example
 * 2023-2023
 * v 0.0.3
 * 
 */


 import rope.mesh.R_Line2D;
import rope.vector.vec2;
import rope.core.Rope;

Rope r = new Rope();
int num = 10;
int bell_level_abscissa = 3;
int bell_level_ordinate = 1;
float density = 3;
float thickness = 3.0f;
R_Line2D [] line = new R_Line2D[num];



void setup() {
	size(400,800);
	float step_y = height / (num + 1);
	float step_x = width / (num + 1);
	for(int i = 0 ; i < num ; i++) {
		int ratio = i + 1;
		line[i] = new R_Line2D(this);
		float pos_y = step_y * ratio;
		float ref_x = width / 2;
		float len = (step_x * i) + step_x ;
		line[i].set(ref_x -(len/2), pos_y, ref_x +(len/2), pos_y);		
		line[i].set_pixels(density, thickness);
	}
}


void draw() {
	background(255);
	stroke(r.ROUGE);
	for(R_Line2D l : line) {
		l.show_pixels();
		line(l.a().x(), l.a().y(),l.b().x(),l.b().y());
	}
}

float  dir = 0;
void mousePressed() {
	println(">>>>>>> NEW SORT >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
	int count = 0;
	dir = random(-PI,PI);
	for(R_Line2D l : line) {
		count++;
		l.set_pixels(density, thickness);
		int level = (int)random(10,50);
		int step = ceil(random(1,3));
		if(count%2 == 0) {
			// l.growth(level,step);
		} else {
			// float dir = random(TAU);
			float fov = random(PI);
			println("dir", dir, "fov", fov);
			l.growth(level,step, dir, fov);
		}
	}
}


