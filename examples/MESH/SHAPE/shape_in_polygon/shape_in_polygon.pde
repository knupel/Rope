/**
* R_Shape polygon detection
* v 0.0.1
* 2026-2026
*
* WARNING
* There is a bug when the shape overlap itself
*
*/
import rope.mesh.R_Shape;
import rope.vector.vec2;
import rope.core.Rope;
import rope.core.R_Graphic;

R_Shape shape_a;
R_Shape shape_b;
R_Shape shape_c;
Rope r = new Rope();
R_Graphic rg;

void setup() {
  size(700,700);
  rg = new R_Graphic(this);
  rg.fill_is(true);
  shape_a = new R_Shape(this);
  shape_b = new R_Shape(this);
  shape_c = new R_Shape(this);
  create_polygon(shape_a);
  create_polygon(shape_b);
  create_polygon(shape_c);
}


void draw() {
  background(0);
  if(shape_a.in_polygon(new vec2(mouseX,mouseY))) {
    rg.fill(r.BLOOD);
    shape_a.show();
  } else {
    rg.fill(r.GOLD);
    shape_a.show();
  }

  int marge = 10;
  if(shape_b.in_perimeter(new vec2(mouseX,mouseY), marge)) {
    rg.fill(r.BLUE);
    shape_b.show();
  } else {
    rg.fill(r.ORANGE);
    shape_b.show();
  }

  marge = 20;
  if(shape_c.in_polygon(new vec2(mouseX,mouseY), marge)) {
    rg.fill(r.PINK);
    shape_c.show();
  } else {
    rg.fill(r.PURPLE);
    shape_c.show();
  }

  
  
}

void keyPressed() {
  create_polygon(shape_a);
  create_polygon(shape_b);
  create_polygon(shape_c);
}

void create_polygon(R_Shape s) {
  vec2 [] pts = new vec2[7];
  for(int i = 0; i < pts.length ; i++) {
    pts[i] = new vec2(random(width), random(height));
  }
  s.clear();
  s.add_points(pts);

}







