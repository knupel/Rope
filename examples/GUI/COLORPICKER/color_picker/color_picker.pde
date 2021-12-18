/**
 * ROPE Library
 * Copyleft (c) 2014-2021
 * @see https://github.com/StanLepunK/Rope
 * 
 * Color Picker without openGL
 * v 0.2.2
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
	State.init(this);
	slider_setup(x, y);
	palette_setup(x, y +40, width/2, height/2);
	selector_setup(x, palette.bottom() + y, width/4, 50);
	println("renderer:",State.get_renderer());
}


void draw() {
	background(0);
	State.pointer(mouseX,mouseY);
	State.event(mousePressed);
	float hue = slider_draw();
	palette_draw(hue);
	selector_draw();
	State.reset_event();
}



// palette
void palette_setup(int px, int py, int sx, int sy) {
  palette = new R_Palette(new vec2(px,py), new vec2(sx, sy));
	palette.set_label("ma belle palette");
  palette.set_stroke(r.BLANC);
  palette.set_rounded(30); // only in P2D and P3D mode
	palette.set_radius_picker(50);
	palette.set_mode(0); // gradient
	// palette.set_mode(10); // spectrum
}

void palette_draw(float hue) {
	palette.set_root(hue);
	palette.show_label();
	palette.update();
	palette.show_struc();
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
  selector.show_struc();
	selector.show_label();
	selector.show_value();
	slider.set_mode(10); // spectrum
}


// slider
void slider_setup(int x, int y) {
	slider = new R_Slider(new vec2(x,y), new vec2(200,20));
	slider.set_label("choisis ta couleur de racine");
	slider.set_mol(ELLIPSE);
	slider.set_rounded(20);
	slider.set_value(0.75);
}

float slider_draw() {
	slider.update();
	slider.show_struc();
	slider.show_mol();
	slider.show_label();
	return slider.get();
}