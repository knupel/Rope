/**
* boolean vector
* 2022-2022
* v 0.0.1
*/

import rope.vector.bvec4;

bvec4 bool_vec = new bvec4();


println("bool_vec",bool_vec);
println("!bool_vec.all():",!bool_vec.all(), "data",bool_vec);
println("bool_vec.all():",bool_vec.all(), "data",bool_vec);
bool_vec.x(true);
println("bool_vec.all():",bool_vec.all(), "data",bool_vec);
println("bool_vec.any():",bool_vec.any(), "data",bool_vec);
println("bool_vec.only():",bool_vec.only(), "data",bool_vec);
println("bool_vec.only(0):",bool_vec.only(0), "data",bool_vec);
println("bool_vec.only(1):",bool_vec.only(1), "data",bool_vec);
bool_vec.y(true);
bool_vec.z(true);
println("bool_vec.only():",bool_vec.only(), "data",bool_vec); 
println("!bool_vec.only():",!bool_vec.only(), "data",bool_vec);


