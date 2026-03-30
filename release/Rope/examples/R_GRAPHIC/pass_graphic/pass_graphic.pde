/**
 * 
 * passGraphic() manipulation
 * v 0.0.1
 * 2023-2023
 *
 * */

import rope.core.R_Graphic;
import rope.core.Rope;

Rope r = new Rope();

R_Graphic rg;
PGraphics pga;
PGraphics pgb;
void setup() {
	size(400,400,P2D);
	println(g.colorModeX);
	rg = new R_Graphic(this);
	pga = createGraphics(width/2,height,P2D);
	pgb = createGraphics(width/2,height,P2D);


	
}


void draw() {
	rg.pass_graphic(pga);
	rg.beginDraw();
	rg.background(r.YELLOW);
	rg.circle(mouseX,mouseY,30);
	if(mousePressed) {
		rg.clear();
	}
	rg.endDraw();
	
	rg.pass_graphic(pgb);
	rg.beginDraw();
	rg.background(r.MAGENTA);
	rg.circle(mouseY,mouseX,30);
	rg.endDraw();

	image(pga,0,0);
	image(pgb,width/2,0);

}