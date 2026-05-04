/**
* detect if a vec2 is on line or not
* v 0.1.0
* 2021-2026
*/
import rope.vector.vec2;
import rope.core.Rope;
import rope.core.R_Graphic;

R_Graphic rg;
vec2 pos;
vec2 [] poly;
Rope r = new Rope();
vec2 rect_pos = new vec2();
vec2 rect_size = new vec2();
void setup() {
	size(500,500,P2D);
	rg = new R_Graphic(this);
	r.print_out(r.VERSION);
	pos = new vec2(0);
	// polygon
	int num = (int)random(5,10);
	poly = new vec2[num];
	for(int i = 0 ; i < poly.length ; i++) {
		poly[i] = new vec2().rand(0,width);
	}
	// rect
	rect_pos.rand(0, width);
	rect_size.rand(0, width);
}

void draw() {
	background(r.BLANC);
	stroke(r.ORANGE);
	pos.set(mouseX, mouseY);
	noStroke();
	// in polygon
	if(pos.in_polygon(poly)) {
		fill(r.ROUGE);
		show_polygon();
	} else {
		fill(r.NOIR);
		show_polygon();
	}
	// in rect
	if(pos.in_rect(rect_pos.x(),rect_pos.y(), rect_size.x(),rect_size.y())) {
		fill(r.ROUGE);
		rg.rect(rect_pos, rect_size);
	} else {
		fill(r.NOIR);
		rg.rect(rect_pos, rect_size);
	}

	
}


void show_polygon() {
	beginShape();
	for(int i = 0 ; i < poly.length ; i++) {
		vertex(poly[i].x(),poly[i].y());
	}
	endShape(CLOSE);

}




void mousePressed() {
	for(int i = 0 ; i < poly.length ; i++) {
		poly[i] = new vec2().rand(0,width);
	}
	rect_pos.rand(0, width);
	rect_size.rand(0, width);
	println("rect_pos", rect_pos);
	println("rect_size", rect_size);
}