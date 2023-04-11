import rope.mesh.R_Line2D;
import rope.vector.vec3;
import rope.core.Rope;

Rope r = new Rope();

R_Line2D [] chain = new R_Line2D[5];

void setup() {
	size(500,500);
	vec3 a = new vec3().rand(0,width);
	// vec3 b = new vec3().rand(0,width);
	for(int i = 0; i < chain.length ; i++) {
		// vec3 next = new vec3().rand(0,width);
		// vec3 a = new vec3().rand(0,width);
		vec3 b = new vec3().rand(0,width);
		chain[i] = new R_Line2D(this);
		// chain[i].set(a.xy(),b.xy());
		// chain[i].pointer(a,b);
		chain[i].pointer_a(a);
		chain[i].pointer_b(b);
		a = b.copy();
	}

	float diam = 15;
	for(int i = 0; i < chain.length ; i++) {

		chain[i].show();
		fill(r.BLOOD);
		circle(chain[i].a().x(),chain[i].a().y(), diam);
		fill(r.GREEN);
		circle(chain[i].b().x(),chain[i].b().y(), diam);
	}
}