import rope.vector.*;
vec3 [] v = new vec3[8];
/*v[0] = new vec2(420.68594, 428.10464);
v[1] = new vec2(420.20755, 428.73413);
v[2] = new vec2(419.8834, 428.27322);
*/
v[0] = new vec3(316.9884, 389.726, 0.0);
v[1] = new vec3(314.56198, 401.00296, 0.0); // 
v[2] = new vec3(315.62418, 400.99048, 0.0); // 
v[3] = new vec3(315.62418, 400.9903, 0.0); //
v[4] = new vec3(315.62418, 400.99053, 0.0); //
v[5] = new vec3(203.62418, 400.99053, 0.0);
v[6] = new vec3(203.62418, 400.99053, 0.0);
v[7] = new vec3(315.62418, 400.99048, 0.0); //

int same_same = 1; // start from one, because we are always equal to ourself

// for(int i = 0 ; i < v.length ; i++) {
//   for(int k = i+1 ; k < v.length ; k++) {
//      if(v[i].compare(v[k], 2)) {
//        same_same++;
//        break;
//      }
//   }
// }


vec3 prev = new vec3();
for(vec3 p : v) {
  if(prev.compare(p, 2)) same_same++;
  prev = p;
}


println(same_same);
