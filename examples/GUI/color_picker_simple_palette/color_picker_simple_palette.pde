/**
* Rope framework
* Copyleft (c) 2014-2021
* @author @stanlepunk
* @see https://github.com/StanLepunK/Rope_framework
* @see https://github.com/StanLepunK/Rope/tree/master/Guide
*
*/


/**
* Crope Palette exemple
* Processing 3.5.4
* Rope library 0.12.1.41
* v 0.1.0
* 2021-2021
*/
import rope.gui.palette.R_Palette;
import rope.gui.palette.R_Palette_Selector;
import rope.gui.slider.R_Slider;
import rope.R_State.State;
import rope.vector.vec2;
import rope.core.Rope;
// IN PROGRESS
R_Palette palette;
R_Palette_Selector selector;
R_Slider slider;
Rope r = new Rope();

int x = 30;
int y = 40 ;
void setup() {
	size(600,600);
	// colorMode (HSB, 255 );
	State.papplet(this);
	slider_setup(x, y);
	palette_setup(x, y +40, width/2, height/2);
	selector_setup(x, palette.bottom() + y, width/4, 50);
}


void draw() {
	background(0);
	State.pointer(mouseX,mouseY);
	State.event(mousePressed);
	float hue = slider_draw();
	palette_draw(hue);
	selector_draw();
}



// palette
void palette_setup(int px, int py, int sx, int sy) {
  palette = new R_Palette(new vec2(px,py), new vec2(sx, sy));
	palette.set_label("ma belle palette");
  palette.set_stroke(r.BLANC);
	palette.set_radius_picker(50);
}

void palette_draw(float hue) {
	palette.set_root(hue);
	palette.show_label();
	palette.update();
	palette.show_structure();
}

// selector
void selector_setup(int px, int py, int sx, int sy) {
	selector = new R_Palette_Selector(new vec2(px,py), new vec2(sx, sy));
	selector.set_label("couleur");

	selector.set_fill(r.NOIR);
	selector.set_stroke(r.BLANC);
	selector.set_thickness(1.0);
}

void selector_draw() {
	selector.set_color_picker(palette.get_color());
  selector.update();
  selector.show_structure();
	selector.show_label();
	selector.show_value();
}


// slider
void slider_setup(int x, int y) {
	slider = new R_Slider(new vec2(x,y), new vec2(200,20));
	slider.set_label("choisis ta couleur de racine");
	slider.set_molette(ELLIPSE);
	slider.set_rounded(20);
	slider.set_value(0.75);
}

float slider_draw() {
	slider.update();
	slider.show_structure();
	slider.show_molette();
	slider.show_label();
	return slider.get(0);
}