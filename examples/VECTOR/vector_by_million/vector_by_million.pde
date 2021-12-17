/**
 * Rope vector by million of iteration
 * 2021-2021
 * v 0.0.1
 * @see https://github.com/StanLepunK
 * 
 * Here we test also the possibility to catch value of bigger vec to a smaller vec
 * */
import rope.core.Rope;
import rope.vector.vec2;
import rope.vector.vec3;
Rope r = new Rope();
int num = 2_000_000;
vec3 [] list_3 = new vec3[num];
vec2 [] list_2 = new vec2[num];

void setup() {
	println(r.VERSION);
	size(800,600,P2D);
	for(int i = 0 ; i < num ; i++) {
		list_3[i] = new vec3(random(width),random(height), 0);
		list_2[i] = new vec2(random(width),random(height));
	}
}

void draw() {
	background(0);
	if(mousePressed) {
		int colour = color(255,0,0);
		println("frameRate list vec3",frameRate);
		for(int i = 0 ; i < num ; i++) {
			/**
			 * when we use function like zz(), xx() etc with a lot vec
			 * we lost frameRate... that's not possible to avoid that
			 * because a vec is create to return the new value in vector template of your choice.
			*/
			set((int)list_3[i].xy().x(),(int)list_3[i].xy().y(),colour);
		}
	} else {
		int colour = color(255,255,255);
		println("frameRate list vec2",frameRate);
		for(int i = 0 ; i < num ; i++) {
			set((int)list_2[i].x(),(int)list_2[i].y(),colour);
		}
	}
}