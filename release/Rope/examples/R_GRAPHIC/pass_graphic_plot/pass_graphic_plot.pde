/**
 * 
 * passGraphic() and plot() to set pixel in the R_Graphic
 * v 0.2.0
 * 2018-2023
 *
 * */

 import rope.core.R_Graphic;
import rope.core.Rope;

Rope r = new Rope();

R_Graphic r_g;
PGraphics pg;
void setup() {
	size(1200,1200,P2D);
	r_g = new R_Graphic(this);
	pg = createGraphics(width,height,P2D);
	r_g.pass_graphic(pg);
}


void draw() {
	println("frameRate", (int)frameRate);
	r_g.beginDraw();
	r_g.background(r.BLACK);
	r_g.loadPixels();
	int num = width*height;
	for(int i = 0 ; i < num ; i++) {
		int rank = (int)random(width*height);
		r_g.plot(rank, r.BLOOD);
	}
	r_g.updatePixels();
	r_g.endDraw();

	image(pg,0,0);

}