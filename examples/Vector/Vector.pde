
/**
* Rope vector
* 2018-2019
* v 0.2.0
* fews examples to use Rope vector : vec, ivec and bvec
* a lot of example is here
* @see https://github.com/StanLepunK/Rope_framework
* you will find all the method vec apply 
* to Processing method, GLSL method and rope method indeed.
*/
import rope.vector.*;
import rope.core.Rope;
Rope r = new Rope();
void setup() {
  vec2 v2 = new vec2(4,5);
  v2.pow(2,3);
  println(v2);
  
  vec3 v3 = new vec3(4.5);
  v3.add(3.);
  println("add",v3);
  v3.add_x(1);
  println("add x",v3);
  v3.div_y(2);
  println("div y",v3);
  v3.rand(2);
  println("simple rand",v3);
  v3.rand(10,11);
  println("doubre rand",v3);
  v3.rand(new vec2(0,1),new vec2(10,12),new vec2(-1,-3));
  println("doubre rand",v3);

  
  vec4 a4 = new vec4(3);
  vec4 b4 = new vec4(3,3,3,3);

  println(a4.equals(b4));
  b4.map(0,1,10,30);
  println(a4.equals(b4));
  
  vec5 v5 = new vec5(3,-1,4.5,PI,234);
  println(v5.max(),v5.min());
  

  // get arguments > problem
  println("");
  println("v3 classic",v3);
  println("v3 abc",v3.abc());
  println("v3 xyz",v3.xyz());
  println("v3 xxx",v3.xxx());
  println(" ");
  println("v5 classic",v5);
  println("v5 abc",v5.abc());
  println("v5 xxx",v5.xxx());
  println("v5 zzw",v5.zzw());

  

  
  vec6 v6 = new vec6(2);
  v6.set(65.45);
  println(v6);
  
  ivec3 iv3 = new ivec3(1,2,3);
  println(iv3.sum());
  
  ivec4 ia4 = new ivec4(1,2,3,4);
  ivec4 ib4 = new ivec4(4,3,2,1);
  println(ia4.add(ib4));
  
  ivec6 iv6 = new ivec6(1,2,3,4,5,6);
  printArray(iv6.array());
  
  


  bvec2 bv2 = new bvec2(true,false);
  println(bv2);
  

  println(r.version());
  println("MAGENTA constant",r.MAGENTA);
  println("Fluid constant",r.FLUID);
  println("Euler constant",r.EULER);
}
