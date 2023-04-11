import rope.mesh.R_Line2D;
import rope.mesh.R_Shape;
import rope.vector.vec3;
import rope.vector.vec2;
import rope.core.Rope;

R_Line2D [] lines = new R_Line2D[4];
R_Shape shape;
Rope r = new Rope();

vec3 puppet = new vec3();
float normal_pos = 0.5;

void setup() {
	size(800,600);
	float marge = 100;
	vec2 a = new vec2(marge,marge);
	vec2 b = new vec2(width-marge, height-marge);
	vec2 c = new vec2(width-marge, marge);

	lines[0] = new R_Line2D(this,a,b);

	puppet.set(lines[0].point(0.5));

	lines[1] = new R_Line2D(this);
	lines[1].pointer(c.xyz(),puppet);
}


void draw() {
	background(r.YELLOW);
	if(mousePressed) {
		lines[0].set_a(mouseX,mouseY);
		normal_pos = map(sin(frameCount * 0.01), -1,1, -0.4, 1.4);
		puppet.set(lines[0].point(normal_pos)); // this function bug ///  that bug instead use coord
	}


	lines[0].show();
	lines[1].show();
	circle(puppet.x(),puppet.y(), 10);
	// check for normal position
	// if(r.in_segment(lines[0], puppet.xy(), 3)) {
		println("original dist", normal_pos);
		float dist = lines[0].dist();
		float dist_ac = r.dist(lines[0].a(), puppet.xy());
		float dist_bc = r.dist(lines[0].b(), puppet.xy());

		float normal_dist = dist_ac / dist;
		if(dist_bc > dist_ac && dist_bc > dist) {
			normal_dist *= -1;
		}
		println("calc dist", normal_dist);
	// }
	
	
}

