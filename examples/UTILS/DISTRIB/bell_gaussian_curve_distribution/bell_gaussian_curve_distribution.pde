/**
* normal distribution of the gaussian curve
* 2023-2023
* v 0.0.2
*/

import rope.core.Rope;
Rope r = new Rope();

void setup() {
	size(900,300);
	background(255);
	show();
}

void draw() {
	background(255);
	show();
}

void show() {
	int c = color(0);
	float range = width/8;
	float variance = 5; // from 0 to 5 usualy
	// float offset = -(width /4); // is set in proportion of your range
	float offset = 0;
	for(int i = 0; i < range ; i++) {
		// curve
		float value = i;
		float resultat = r.d_bell(value, range, variance, offset);
		
		int final_x = i;
		int final_y = int(resultat * range);
		// println("res", resultat, "y", final_y);
		set(final_x, final_y, c);
		// distribution
		float is = random(0.18);
		if(mousePressed) {
			if(is < resultat) {
				set(final_x, height/2, c);
			}
		} else {
			if(is > resultat) {
				set(final_x, height/2, c);
			}
		}
	}
}
