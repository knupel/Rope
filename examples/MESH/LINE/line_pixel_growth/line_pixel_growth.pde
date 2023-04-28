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
float density = 0.2;
float thickness = 3.0f;
R_Line2D [] line = new R_Line2D[num];


void setup() {
	size(400,800);
	init_lines(true, false);
	update_lines();
}


void draw() {
	background(255);
	show_lines();
}

// float  dir = (PI/2) + (PI/4);
// float  dir = PI + PI * 0.75;
float  dir = 0;
void mousePressed() {
	println(">>>>>>> NEW SORT >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
	if(keyPressed) {
		init_lines(false, true);
	} else {
		init_lines(true, false);
	}
	update_lines();
}


void show_lines() {
	stroke(r.SANG);
	strokeWeight(5);
	for(R_Line2D l : line) {
		l.show_pixels();
		line(l.a().x(), l.a().y(),l.b().x(),l.b().y());
	}

}

void update_lines() {
	int count = 0;
	// dir = random(TAU);
	// dir += 0.1;
	println("direction", dir);
	float ang_step = TAU / line.length;
	// dir = random(-PI,PI);
	for(R_Line2D l : line) {
		count++;
		l.set_pixels(density, thickness);
		int level = (int)random(10,100);
		int step = ceil(random(1,1));
		// float fov = TAU - (PI/2);
		float fov = PI/2;
		// float start_fov = PI/2;
		// float end_fov = PI/2;
		// float start_fov = PI * 0.65;
		// float end_fov = PI * 0.75;
				float start_fov = -PI/4;
		float end_fov = PI/4;
		// println("dir", dir, "fov", fov);
		// dir = (PI*0.75) - l.angle(); // PAS TRES BON
		 // ça devrait être bon, mais non ????
		// println("dir", dir%TAU, "angle step", ang_step, "line angle", l.angle(), " half fov", fov /2.0f);
		// println("line angle", l.angle());
		// float direction = dir - (l.angle() * -1);
		float direction = dir - l.angle();
		println("line angle", l.angle());

		if(count%2 == 0) {
			l.growth(level,step, direction, fov);
		} else {
			l.set_growth_type(r.CHAOS);
			l.growth(level,step, direction, start_fov, end_fov);
		}
		
		// l.growth(level,step);
		// l.growth(level,step, dir, fov);
		// dir += ang_step;

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


