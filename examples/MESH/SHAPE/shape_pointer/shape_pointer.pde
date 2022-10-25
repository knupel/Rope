/**
* Rope R_Shape
* v 0.0.1
* 2022-2022
* @author @stanlepunk
* @see https://github.com/StanLepunK/Rope
* 
* An example how to use R_Shape in a pointer context
* only update the vec point, to update R_Line2D and R_Shape in a same time
*
*/

import rope.mesh.R_Line2D;
import rope.mesh.R_Shape;
import rope.vector.vec3;
import rope.core.Rope;

vec3 [] points = new vec3[6];
R_Line2D [] lines = new R_Line2D[3];
R_Shape [] shapes = new R_Shape[2];
Rope r = new Rope();

void setup() {
	size(800,600);
	float marge = 30;
	points[0] = new vec3(marge, marge, 0);
	points[1] = new vec3(marge, height -marge, 0);
	points[2] = new vec3(width/2, marge, 0);
	points[3] = new vec3(width/2, height -marge, 0);
	points[4] = new vec3(width -marge, marge, 0);
	points[5] = new vec3(width -marge, height -marge, 0);

	lines[0] = new R_Line2D(this);
	lines[0].pointer(points[0],points[1]);

	lines[1] = new R_Line2D(this);
	lines[1].pointer(points[2],points[3]);

	lines[2] = new R_Line2D(this);
	lines[2].pointer(points[4],points[5]);

	shapes[0] = new R_Shape(this);
	shapes[0].pointer(lines[0].pointer_a(), lines[0].pointer_b(), lines[1].pointer_b(), lines[1].pointer_a());
	shapes[1] = new R_Shape(this);
	shapes[1].pointer(lines[1].pointer_a(), lines[1].pointer_b(), lines[2].pointer_b(), lines[2].pointer_a());
}


void draw() {
	background(r.YELLOW);

	points[2].set(mouseX,mouseY,0);

	stroke(r.BLACK);
	fill(r.WHITE);
	strokeWeight(1);
	for(R_Shape s : shapes) {
		s.show();
	}

	stroke(r.MAGENTA);
	strokeWeight(4);
	for(R_Line2D l : lines) {
		l.show();
	}

	fill(r.GRIS[10]);
	stroke(r.BLACK);
	strokeWeight(1);
	for(vec3 p : points) {
		circle(p.x(), p.y(), 10);
	}
}

