/**
* vector swap and inverse value
* in this example it's apply to bvec and vec but you also make it with ivec
* 2021-2021
* v 0.0.1
*/

import rope.vector.vec6;
import rope.vector.vec4;
import rope.vector.bvec3;

vec4 vec_4 = new vec4(42);
bvec3 bvec3 = new bvec3(true);


println(vec_4.inv());
println(vec_4.x());
println(bvec3.inv());
println(bvec3.x());
println(bvec3.swap());
bvec3.swap_y();
println(bvec3);
exit();


