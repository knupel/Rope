/**
* Rope Primitive Polygon
* v 0.0.2
* 2019-2021
* @author @stanlepunk
* @see https://github.com/StanLepunK/Rope
*
*/
import rope.costume.R_Primitive;
import rope.vector.*;
R_Primitive [] prim;

void setup() {
  background(125);
  size(300,300,P2D);
  int num_prim = 10000; 
  int num_summit = 3; // stay faster with 3 and 4 summits, after it's a classic rendering is very slow :)
  int diameter = width/4;
  set_primitive(num_prim,num_summit,diameter);
  for(int i = 0 ; i < prim.length ; i++) {
    prim[i].show(); // need to init the final position
    println(i,prim[i].get_summits());
    println("normal vector");
    printArray(prim[i].get_points());
    println("final vector");
    printArray(prim[i].get_points());
    println("dir is not implemented, you can use just for store data for now");
    printArray(prim[i].get_dir());
  }
}

void draw() {
  println("frameRate",(int)frameRate);
  background(125);
  draw_prim();
}


void set_primitive(int num, int summits, int size) {
  prim = new R_Primitive[num];
  float angle = PI/num;
  float rot_x = .3;
  float rot_y = .5;
  
  for(int i = 0 ; i < prim.length ; i++) {
    vec2 dir = new vec2(rot_x,rot_y).mult(i); // dir is not implemented, you can use just for store data for now");
    prim[i] = new R_Primitive(this,summits,angle*i,dir);
    prim[i].size(size);
    if(i == 0) {
      prim[i].pos(width/2,height/2);
    } else {
      prim[i].pos(random(width),random(height));
    } 
  }
}

void draw_prim() {  
  for(R_Primitive p : prim) {
    p.show();
  }
}
