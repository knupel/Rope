/**
* Constrain*
 v 0.1.0
* 2018-2021
* You must know with constrain you can also use only one value
* In this case all min values is considere for '0'
*
*/
import rope.vector.*;

vec2 classic = new vec2(-1, 2);
vec2 test_min = new vec2(-1);
vec2 test_max = new vec2(10);
void setup() {
  println("start",classic);
  println("constrain min max",1);
  println("result", classic.constrain(1));
  println("");
  println("contrain with vec");
  vec2 min = new vec2(0,2);
  vec2 max = new vec2(3,5);
  println("start test_min",test_min);
  println("constrain min",min);
  println("result test_min",test_min.constrain(min,max));
  println("");
  println("start test_max",test_max);
  println("constrain max",max);
  println("result test_max",test_max.constrain(min,max));
}
