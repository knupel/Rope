void setup() {
  size(200,200);
  colorMode(HSB,1,1,1,1);
  
  int c = color(-12177919);
  println(c);
  println(hue(c),",",saturation(c),",",brightness(c));
  background(c);
  
}
