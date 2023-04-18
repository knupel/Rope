import rope.core.Rope;
Rope r = new Rope();

void setup() {
  size(800,800);
  colorMode(HSB,360,100,100);
  int c = color(28,10,41);
  // int c = r.AMARANTE;
  println(c);
  background(c);
  // compare_color(r.SOURIS, c);
  // compare_color(r.SOURIS, r.ELEPHANT);
  compare_color(r.ARGENT, r.SOURIS);
  colorMode(HSB,1,1,1,1);
  println("HSB", hue(c),saturation(c), brightness(c));
  println("RGB", red(c),green(c), blue(c));
}

void compare_color(int a, int b) {
  noStroke();
  fill(a);
  rect(0,0, width/2, height);
  fill(b);
  rect(width/2,0, width/2, height);

}
