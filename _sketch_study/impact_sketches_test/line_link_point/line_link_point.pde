import rope.mesh.R_Line2D;
import rope.mesh.R_Shape;
import rope.vector.vec3;
import rope.vector.vec2;
import rope.vector.vec;
import rope.core.Rope;


// R_Line2DX line;
R_Line2D line;

void setup() {
	size(800,600);
	line = new R_Line2DX(this);
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



class R_Line2DX extends R_Line2D {
	ArrayList <Float> list_link = new ArrayList<Float>();
	R_Line2DX(PApplet pa) {
		super(pa);
	}
}

