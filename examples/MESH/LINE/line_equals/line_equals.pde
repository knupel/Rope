/**
* Compare R_Line2D together
* 2026-2026
* 0.0.1
*/
import rope.mesh.R_Line2D;

R_Line2D a, b, c, d;

void setup() {
  a = new R_Line2D(this, 10,10, 50,50);
  b = a.copy();
  c = new R_Line2D(this, a.b(), a.a());
  d = new R_Line2D(this, 10,11, 50,50);
  println("strict a b", a.equals(b, true));
  println("normal a b", a.equals(b, false));
  println("strict a c", a.equals(c, true));
  println("normal a c", a.equals(c, false));
  println("strict a d", a.equals(d, true));
  println("normal a d", a.equals(d, false));
  println("a", a);
  println("b", b);
  println("c", c);
  println("d", d);
}
