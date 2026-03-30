/**
* vector set value
* 2022-2022
* v 0.0.1
*/

import rope.vector.vec2;
import rope.vector.vec3;

vec2 a2 = new vec2(2);
vec3 b3 = new vec3(3);



void setup() {
  frameRate(1);
  println(b3);
  b3.set(a2);
  println(b3);
}

void draw() {
  println(frameCount);
  println(b3);
  b3.set(a2);
  println(b3);
}
