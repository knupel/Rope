/**
 * 
 * line growth with complexe shape
 * 2023-2023
 * v 0.0.1
 * 
*/

import rope.mesh.R_Line2D;
import rope.vector.vec2;
import rope.core.Rope;

Rope r = new Rope();
int num = 12;
float density = 1;
float thickness = 3.0f;
R_Line2D [] lines = new R_Line2D[num];


void setup() {
	size(700, 700);
	build_shape(width/2, height/2, width /3);
	set_shape();

}


void draw() {
	background(r.SANG);
	show_shape();
}

void keyPressed() {
	if(key == 'n') {
		println("new sort");
		build_shape(width/2, height/2, width /3);
		set_shape();
	}
}



void build_shape(int x, int y, float radius) {
	float step = TAU / lines.length;
	float angle = 0;
	float buf_radius = random(10,radius);
	float first_radius = buf_radius;
	for(int i = 0 ; i < lines.length ; i++) {
		float ax = sin(angle) * buf_radius + x;
		float ay = cos(angle) * buf_radius + y;
		angle += step;
		if(i < lines.length - 1) {
			buf_radius = random(10,radius);
		} else {
			buf_radius = first_radius;
		}
		
		float bx = sin(angle)  * buf_radius + x;
		float by = cos(angle)  * buf_radius + y;
		lines[i] = new R_Line2D(this,ax, ay, bx, by);
	}
}

void set_shape() {
	int count = 0;
	for(R_Line2D line : lines) {
		count++;
		line.set_pixels(1.0, 3.0, r.LUNE);
		int level = 35;
		int step = 2;
		float dir = line.angle() * -1 + PI;
		float fov = PI/2;
		line.growth(level,step, dir, fov);	
	}

}


void show_shape() {
	int count = 0;
	stroke(r.BLACK);
	strokeWeight(5);
	for(R_Line2D line : lines) {
		// stroke(r.GRIS[count++]);
		line.show_pixels();
		line.show();
	}
}