/**
* power distribution
* 2023-2023
* v 0.0.2
*/

import rope.core.Rope;
Rope r = new Rope();
float power = 2;

void setup() {
	size(400,400);
	background(255);
	distribution(2);
}


void draw() {
	
}

void keyPressed() {
	if(key == 'n') {
		power += 0.1;
		if(power > 6) {
			power = 0.1;
		}
		println("power", power);
		background(255);
		distribution(power);
	}
}


void distribution(float power) {
	int c = color(0);
	float range = width;
	for(int i = 0; i < range ; i++) {
		// curve
		float value = i;
		float resultat = r.d_pow(value, range, power);
		int final_x = i;
		int final_y = int(resultat * range);
		// println("res", resultat, "y", final_y);
		set(final_x, final_y, c);
		// distribution
		if(random(1) < resultat) {
			set(final_x, height/2, c);
		}
	}
}