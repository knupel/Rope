/**
* Rope framework
* Copyleft (c) 2014-2021
* @author @stanlepunk
* @see https://github.com/StanLepunK/Rope
*
* R_Face
* v 0.0.2
* 2021-2021
*/
import rope.mesh.R_Face;
import rope.vector.vec2;
import rope.vector.vec3;

import rope.core.Rope;

R_Face [] faces;
Rope r = new Rope();




void setup() {
	size(800,800,P3D);
	// can work in P2D too !!!!
	// size(800,800,P2D);
	println(r.VERSION);
	int num = 10000;
	faces = new R_Face[num];
	for(int i = 0 ; i < num ; i++) {
		vec3 a = new vec3().rand(-1,1).mult(random(20,width/2));
		vec3 b = new vec3().rand(-1,1).mult(random(20,width/2));
		vec3 c = new vec3().rand(-1,1).mult(random(20,width/2));
		faces[i] = new R_Face(this,a,b,c);
		if(i%2 == 0) {
			faces[i].set_fill(r.BLOOD);
		} else {
			faces[i].set_fill(r.YELLOW);
		}
	}
	
}


void draw() {
	background(r.NOIR);
	for(R_Face f : faces) {
		fill(f.get_fill());
		f.offset(new vec2(mouseX,mouseY));
		f.show();
	}	
}










