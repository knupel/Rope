/**
* vector set value
* 2021-2021
* v 0.0.1
*/

import rope.vector.vec6;
import rope.vector.vec4;

vec4 vec_4 = new vec4(42);
vec6 vec_6 = new vec6(1,2,3,4,5,6);

println(vec_4);
println(vec_6);
vec_6.set(10);
println(vec_6);
vec_6.set_to(0,35.9);
println(vec_6);
// in vec5 and vec6 case you cannot use method x(float arg)... 
// only  ... to f(T arg);
vec_6.a(1234.56789);
println(vec_6);

vec_4.x(21);
vec_4.z(84);
vec_4.w(168);
println(vec_4);


println(vec_4);


