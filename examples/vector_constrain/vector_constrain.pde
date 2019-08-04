import rope.vector.*;

vec2 value = new vec2(-1, 2);
void setup() {
  println(value.constrain(0,1));
  println(value);
  value.set(-1,2);
  vec2 min = new vec2(0,1);
  vec2 max = new vec2(0,3);
  println(value.constrain(min,max));
}
