/**
* A none exhaustive list of function to catch vector values
* 2021-2021
*/
import rope.vector.vec6;
import rope.vector.ivec6;
import rope.vector.vec4;
import rope.vector.bvec4;
import rope.vector.ivec4;

bvec4 bvec_4 = new bvec4(true,false,true,false);
ivec4 ivec_4 = new ivec4(10,11,12,13);
ivec6 ivec_6 = new ivec6(10,11,12,13,14,15);
vec4 vec_4 = new vec4(1,2,3,4);
vec6 vec_6 = new vec6(1,2,3,4,5,6);
// get arguments > problem
println("");
println(vec_6);
println(vec_6.abc());
println(vec_6.xyz());
println(vec_6.xxx());
println(vec_6.wwxx());
println(vec_6.array());
println(vec_6.copy());

println(vec_6.get());
println(vec_4.get());

println(vec_6.get(5));
println(ivec_6.get(5));

println(vec_4.get(5));
println(ivec_4.get(5));
println(ivec_4.get(6));

println(vec_6.x());
println(vec_6.z());
println(vec_6.a());
println(vec_6.s());
println(vec_6.t());
println(vec_6.u());
println(vec_6.v());
println(vec_6.f());

println(vec_4.s());
println(vec_4.t());
println(vec_4.u());
println(vec_4.v());

println("vec_4.min()", vec_4.min());
println("vec_4.max()", vec_4.max());

println(vec_4.red());
println(vec_4.gre());
println(vec_4.blu());
println(vec_4.alp());

println(vec_4.hue());
println(vec_4.sat());
println(vec_4.bri());
println(vec_4.alp());


