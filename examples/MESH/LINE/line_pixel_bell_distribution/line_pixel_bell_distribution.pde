import rope.mesh.R_Line2D;
import rope.vector.vec2;
import rope.core.Rope;

Rope r = new Rope();
int num = 10;
int bell_level_abscissa = 3;
int bell_level_ordinate = 1;
float density = 3;
float thickness = 20.0f;
R_Line2D [] line = new R_Line2D[num];



void setup() {

	size(400,800);
	float step_y = height / (num + 1);
	float step_x = width / (num + 1);
	for(int i = 0 ; i < num ; i++) {
		int ratio = i + 1;
		line[i] = new R_Line2D(this);
		float pos_y = step_y * ratio;
		float len = (step_x * i) + step_x ;
		line[i].set(0, pos_y, len, pos_y);
		if(i%2 != 0) {
			line[i].abscissa(r.CENTER, bell_level_abscissa);
			line[i].ordinate(r.SIDE, bell_level_ordinate);
		} else {
			line[i].abscissa(r.SIDE, bell_level_abscissa);
			line[i].ordinate(r.CENTER, bell_level_ordinate);
		}
		
		line[i].set_pixels(density, thickness);
	}
}


void draw() {
	background(255);
	for(R_Line2D l : line) {
		if(mousePressed) {
			l.set_pixels(density, thickness);
		}
		l.show_pixels();
	}
}