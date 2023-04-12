import rope.core.Rope;
Rope r = new Rope();

void setup() {
  size(800,800);
  int c = color(11,1,18);
  // int c = r.AMARANTE;
  println(c);
  background(c);
  colorMode(HSB,1,1,1,1);
  println("HSB", hue(c),saturation(c), brightness(c));
  println("RGB", red(c),green(c), blue(c));
}
