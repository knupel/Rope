/**
* Line2D 
* pointer() function
*
* Copyleft(c) 2022-2022
* v 0.0.1
* @author @stanlepunk
* @see https://github.com/StanLepunK/Rope
* 
*/
import rope.core.Rope;
import rope.vector.vec3;
import rope.mesh.R_Line2D;

Rope r = new Rope();
R_Line2D line;
vec3 a, b;

void setup() {
	size(400,400);
	a = new vec3(10,10,0);
	b = new vec3(width/2,height/2,0);
	line = new R_Line2D(this);
	// we don't pass by the classic way to set the point
	// that give the orpunity to only update the the vec3 coordinate to update the line too !
	// but unfortunatly we lost the other smart function of R_Line2D like change()
	line.pointer(a,b);
}

void draw() {
	background(r.OUTREMER);
	noFill();
	stroke(r.CYAN);
	circle(a.x(), a.y(), 10);
	circle(b.x(), b.y(),10);
	stroke(r.YELLOW);
	line.show();
	// update
	a.x(mouseX);
	b.y(mouseY);
}