import rope.core.Rope;
import rope.mesh.R_Line2D;

Rope r = new Rope();

R_Line2D a, b, c;

void setup() {
  size(600,600);
  println(r.VERSION);
  a = new R_Line2D(this);
  b = new R_Line2D(this);
  c = new R_Line2D(this);
}

void draw() {
  background(r.WHITE);
  a.stroke_is(true);
  b.stroke_is(true);
  c.stroke_is(true);
  a.palette(r.BLOOD);
  b.palette(r.GOLD);
  c.palette(r.GREEN);

  a.show(0);
  b.show(10);
  c.show(0);
}


void keyPressed() {
  a.rand();
}
