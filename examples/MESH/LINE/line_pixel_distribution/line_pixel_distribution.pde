/**
 * Exemple de distribution de pixel sur une ligne
 * 2023-2023
 * v 0.0.3
 */
import rope.mesh.R_Line2D;
import rope.vector.vec2;
import rope.core.Rope;
import rope.core.R_Constants;

Rope r = new Rope();
int num = 13;
int level_abscissa = 1;
int level_ordinate = 1;
float density = 40;
float thickness = 40.0f;
R_Line2D [] line = new R_Line2D[num];



void setup() {
	size(400,800);
	set();
}


void keyPressed() {
	if(key == 'n') {
		set();
	}

	if(key == 'a') {
		level_abscissa++;
		if(level_abscissa > 13) {
			level_abscissa = 1;
		}
		set();
	}

	if(key == 'o') {
		level_ordinate++;
		if(level_ordinate > 13) {
			level_ordinate = 1;
		}
		set();
	}
}


void draw() {
	background(255);
	stroke(r.ROUGE);
	for(R_Line2D l : line) {
		
		if(mousePressed) {
			l.set_pixels(density, thickness);
		}
		l.show_pixels();
		line(l.a().x(), l.a().y(),l.b().x(),l.b().y());
	}

	fill(r.BLACK);
	int x = width/2;
	text("press N for new sort", x, 20);
  text("press O increase level ordinate", x, 35);
  text("press A increase level abscissa", x, 50);
}

void set() {
	float step_y = height / (num + 1);
	float step_x = width / (num + 1);
	for(int i = 0 ; i < num ; i++) {
		int ratio = i + 1;
		line[i] = new R_Line2D(this);
		float pos_y = step_y * ratio;
		float len = (step_x * i) + step_x ;
		line[i].set(0, pos_y, len, pos_y);
		//line[i].mode_abscissa(r.NORMAL, l_abs);
		int type_abs = select_type();
		int type_ord = select_type();
		// int type_abs = r.NORMAL;
		// int type_ord = r.SIDE;
		print_type(type_abs, "abscissa", level_abscissa);
		print_type(type_ord, "ordinate", level_ordinate);
		// if(i%2 == 0) {
		// 	line[i].mode_ordinate(type_ord, level_ordinate);
		// 	// line[i].mode_abscissa(type_abs, level_abscissa);
		// } else {
		// 	line[i].mode_ordinate(r.CENTER, level_ordinate);
		// 	// line[i].mode_abscissa(r.CENTER, level_abscissa);
		// }
		line[i].mode_abscissa(type_abs, level_abscissa);
		line[i].mode_ordinate(type_ord, level_ordinate);


		line[i].set_pixels(density, thickness);
	}
}

void print_type(int type, String str, int level) {
	switch(type) {
		case rope.core.R_Constants.START: 
			r.print_out(str, "START", level);
			break;
		case rope.core.R_Constants.END:
			r.print_out(str, "END", level);
			break;
		case rope.core.R_Constants.CENTER:
			r.print_out(str, "CENTER", level);
			break;
		case rope.core.R_Constants.SIDE:
			r.print_out(str, "SIDE", level);
			break;
		case rope.core.R_Constants.NORMAL:
			r.print_out(str, "NORMAL", level);
			break;
		default:
			r.print_out(str, "NORMAL", level);
			break;
	}
}



int select_type() {
	int choice = floor(random(5));
	switch(choice) {
		case 0: return r.START;
		case 1: return r.END;
		case 2: return r.CENTER;
		case 3: return r.SIDE;
		case 4: return r.NORMAL;
		default: return r.NORMAL;
	}
}