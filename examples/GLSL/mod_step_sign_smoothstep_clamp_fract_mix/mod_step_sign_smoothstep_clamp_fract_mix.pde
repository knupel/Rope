/**
* GLSL method
* 2021-2021
* v 0.0.1
* 
* All function work with float, vec2, vec3 or vec4
* 
*/

import rope.core.Rope;
import rope.vector.vec2;

vec2 x = new vec2(1.2);
vec2 y = new vec2(3.5);
vec2 z = new vec2(3.5, -1.5);
vec2 a = new vec2(0.5, 2.0);
vec2 edge_a = new vec2(0.75, -0.5);
vec2 edge_b = new vec2(1.33, 7.1);
vec2 min = new vec2(0.75, -0.5);
vec2 max = new vec2(1.33, 7.1);

Rope r = new Rope();

r.print_out("mix()", r.mix(1.2, 3.5, 0.5));
r.print_out("mix()", r.mix(x, y, a));

r.print_out("fract()", r.fract(1.2));
r.print_out("fract()", r.fract(x));

r.print_out("sign()", r.sign(-1.2));
r.print_out("sign()", r.sign(z));

r.print_out("step()", r.step(0.75, 3.2));
r.print_out("step()", r.step(edge_a, x));

r.print_out("smoothstep()", r.smoothstep(0.75, 1.33, 1.2));
r.print_out("smoothstep()", r.smoothstep(edge_a, edge_b, x));

r.print_out("mod()", r.mod(1.2, 0.5));
r.print_out("mod()", r.mod(x, a));

r.print_out("clamp()", r.clamp(1.2, 0.5, 1.0));
r.print_out("clamp()", r.clamp(a, min, max));



