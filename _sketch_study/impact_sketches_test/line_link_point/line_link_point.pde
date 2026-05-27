import rope.mesh.R_Line2D;
import rope.vector.vec2;
import rope.core.Rope;


// R_Line2DX line;
R_Line2D line;

void setup() {
	size(800,600);
	line = new R_Line2D(this);
	line.set(10,10, width -10, height-10);


}

void draw() {
	line.show();
	float val = line.normal(new vec2(mouseX,mouseY),3);
	if(!Float.isNaN(val)) {
		println("value", val);
	} else {
		println("T'es trop un NaN");
	}
}


