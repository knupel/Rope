/**
 * 
 * create a cloud, nubo in Esperanto
 * 
 * 
 * 
 * 
 * 
 * */


import rope.core.Rope;
import rope.pixo.R_Nubo;

R_Nubo nuage;
Rope r = new Rope();


void setup() {
	size(400,400, P2D);
	background(r.BLACK);
	nuage = new R_Nubo(this);
	// position
	nuage.pos(width/2, height/2);
	// open angle
	float angle_start = -PI;
	float angle_stop = PI;
	// nuage.set_fov(angle_start, angle_stop);

	// projection
	float dist_min = 0; // work with Chaos for the other the value stay 0
	float dist_max = 10;
	nuage.set_field(dist_min, dist_max);

	// type of algorithm for the rendering
	int type = r.MAD; // MAD, CHAOS, SPIRAL, LINE, POLYGON
	nuage.set_algo(type);
	nuage.set_step(2);
	nuage.set_mode(1);

	// iteration or num of point
	int num = 50;
	nuage.set_iter(num);
	nuage.info();
}


void draw() {
	if(mousePressed) {
		background(r.BLACK);
	}

	for(int i = 0 ; i < nuage.get_iter() ; i++) {
		nuage.update(i);
		if(nuage.pixel_is()) {
			set((int)nuage.x(),(int)nuage.y(),r.RED);
		}
	}
}