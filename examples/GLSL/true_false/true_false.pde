/**
* GLSL method
* 2021-2021
* v 0.0.1
*/
import rope.core.Rope;
import rope.vector.bvec6;
import rope.vector.bvec3;

Rope r = new Rope();

bvec6 bv6 = new bvec6(false);
bvec3 bv3 = new bvec3(false);
println("r.only(true, false, false):",r.only(true, false, false));
println("r.only(true, true, false):",r.only(true, true, false));
println("r.only(bv6):",r.only(bv6));
println("r.only(bv3):",r.only(bv3));
bv6.a(true);
println("r.only(bv6):",r.only(bv6));
println("r.any(bv6):",r.any(bv6));
bv6.b(true);
println("r.any(bv6):",r.any(bv6));
bv6.set(false);
println("r.any(bv6):",r.any(bv6));
bv6.set(true);
println("r.all(bv6):",r.all(bv6));



