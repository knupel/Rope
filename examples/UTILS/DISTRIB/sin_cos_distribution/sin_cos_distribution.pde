/**
* trigonometric distribution
* 2023-2023
* v 0.0.1
*/

import rope.core.Rope;
Rope r = new Rope();

void setup() {
	size(400,400);
}

void draw() {
	background(255);
	int c = color(0);
	float range = width;
	float ratio = 0.8;
	for(int i = 0; i < range ; i++) {
		// curve
		float value = i;
		
		float resultat = 0;
		if(mousePressed) {
			resultat = r.d_sin(value, range, ratio);
		} else {
			resultat = r.d_cos(value, range, ratio);
		}
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