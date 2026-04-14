/**
 * 
 * Comparaison
 * 
 * 
 * */
import rope.core.Rope;
import rope.vector.vec2;

Rope r = new Rope();


void setup() {
	float a = 1;
	float b = 2;
	vec2 va = new vec2(a);
	vec2 vb = new vec2(b);
	float marge = 2;
	println("float", r.compare(a,b,marge));
	println("vec2", va.compare(vb,marge));
	b = 10;
	vb.set(b);
	println("float",r.compare(a,b,marge));
	println("vec2", va.compare(vb,marge));
}

