/**
 * 
 * growth example
 * 2023-2023
 * v 0.1.0
 * 
*/

import rope.mesh.R_Line2D;
import rope.vector.vec2;
import rope.core.Rope;

Rope r = new Rope();
int num = 8;
float density = 1;
float thickness = 3.0f;
R_Line2D [] line = new R_Line2D[num];

void setup() {
	size(400,800);
	background(r.MOON);
	stroke(r.SANG);
	strokeWeight(3);
	init_lines(true, false);
	update_lines();
	show_lines();
}

void draw() {}

float  dir = 0;
void mousePressed() {
	background(r.MOON);
	println(">>>>>>> NEW SORT >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
	if(keyPressed) {
		init_lines(false, true);
	} else {
		init_lines(true, false);
	}
	update_lines();
	show_lines();
}


void show_lines() {
	for(R_Line2D l : line) {
		l.show_pixels();
		line(l.a().x(), l.a().y(),l.b().x(),l.b().y());
	}
}

void update_lines() {
	int count = 0;
	float ang_step = TAU / line.length;
	for(R_Line2D l : line) {
		count++;
		l.set_pixels(density, thickness);
		int level = (int)random(10,100);
		// int step = ceil(random(1,3));
		int step = 1;
		float fov = PI/2;
				float start_fov = -PI/4;
		float end_fov = PI/4;
		// float start_fov = PI/4;
		// float end_fov = -PI/4;
		// float direction = dir - (l.angle() * -1);
		float direction = dir - l.angle();

		boolean use_field = true;
		l.growth_option(use_field, r.CHAOS);
		l.growth(level,step, direction, start_fov, end_fov);
		// l.growth(level,step, direction, fov);
		// if(count%2 == 0) {
		// 	l.growth(level,step, direction, fov);
		// } else {
		// 	l.growth(level,step, direction, start_fov, end_fov);
		// }
	}
}

void init_lines(boolean flat_is, boolean len_is) {
	float step_y = height / (num + 1);
	float variance = 0;
	if(!flat_is) {
		variance = step_y;
	}
	float step_x = width / (num + 1);

	
	for(int i = 0 ; i < num ; i++) {
		int ratio = i + 1;
		line[i] = new R_Line2D(this);
		float pos_y = step_y * ratio;
		float ref_x = width / 2;
		float len = step_x;
		if(len_is) {
			len = (step_x * i) + step_x;
		}
		float ax = ref_x -(len/2);
		float ay = pos_y + random(-variance, variance);
		float bx = ref_x +(len/2);
		float by = pos_y + random(-variance, variance);
		line[i].set(ax, ay, bx, by);		
		line[i].set_pixels(density, thickness);
	}
}


