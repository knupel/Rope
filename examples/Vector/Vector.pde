import rope.vector.Vec2;
import rope.vector.Vec3;
import rope.vector.Vec4;


void setup() {
  Vec2 v2 = new Vec2(4,5);
  v2.pow(2,3);
  println(v2);
  
  Vec3 v3 = new Vec3(4.5);
  v3.add(3.);
  println(v3);
  
  Vec4 a4 = new Vec4(3);
  Vec4 b4 = new Vec4(3,3,3,3);
  println(a4.equals(b4));
}
