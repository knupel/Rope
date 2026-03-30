/**
 * 
 * line growth with complexe shape
 * 2023-2023
 * v 0.0.2
 * 
*/
import rope.mesh.R_Line2D;
import rope.vector.vec2;
import rope.core.Rope;

Rope r = new Rope();
float density = 1;
float thickness = 3.0f;
R_Line2D [] lines;

void setup() {
	size(700, 700);
	background(r.SANG);
	stroke(r.BLACK);
	strokeWeight(5);
	noFill();
	build_shape(width/2, height/2, width /2);
	set_shape();
	show_shape();
}


void draw() {}

void keyPressed() {
	background(r.SANG);
	if(key == 'n') {
		println("new sort");
		build_shape(width/2, height/2, width /2);
		set_shape();
	}
	show_shape();
}

void build_shape(int x, int y, float radius) {
	boolean regular_is = true;
	if(random(1) < 0.5) {
		regular_is = false;
	}
	int num = (int)random(3,19);
	lines = new R_Line2D[num];
	float step = TAU / lines.length;
	float angle = 0;
	float buf_radius = random(radius * 0.5,radius);
	float first_radius = buf_radius;
	for(int i = 0 ; i < lines.length ; i++) {
		float ax = sin(angle) * buf_radius + x;
		float ay = cos(angle) * buf_radius + y;
		angle += step;
		if(i < lines.length - 1) {
			if(!regular_is) {
				buf_radius = random(10,radius);
			}	
		} else {
			buf_radius = first_radius;
		}
		float bx = sin(angle) * buf_radius + x;
		float by = cos(angle) * buf_radius + y;
		lines[i] = new R_Line2D(this,ax, ay, bx, by);
	}
}

void set_shape() {
	int len = lines.length;
	for(int i = 0 ; i < len ; i++) {
		R_Line2D line_prev;
		if(i == 0) {
			line_prev = lines[len -1];
		} else {
			line_prev = lines[i-1];
		}
		R_Line2D line_next;
		if(i == len -1) {
			line_next = lines[0];
		} else {
			line_next = lines[i+1];
		}
		R_Line2D line = lines[i];

		line.set_palette(r.LUNE);
		line.set_pixels(1.0, 1.0);
		int level = 20;
		int step = 2;
		float dir = line.angle() * -1 + PI;
		// if(i%2== 0) {
		// 	dir = line.angle() * -1;
		// }
		
		float start_fov = line.angle(line_prev) * 0.5;
		float end_fov = line.angle(line_next) * 0.5;
		boolean use_field = true;
		line.growth_option(use_field, r.CHAOS);
		line.growth(level,step, dir, start_fov, end_fov);
	}
}


void show_shape() {
	for(R_Line2D line : lines) {
		line.show_pixels();
		line.show();
	}
}