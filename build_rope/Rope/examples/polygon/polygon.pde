/**
* Rope Polygon
* v 0.0.1
* 2019-2019
* @author @stanlepunk
* @see https://github.com/StanLepunK/Rope
*
*/
import rope.costume.R_Polygon;
R_Polygon [] poly;

void setup() {
  background(125);
  size(300,300);
  int num_poly = 10;
  int num_summit = 6;
  int diameter = 40;
  set_polygon(num_poly,num_summit,diameter);
  for(int i = 0 ; i < poly.length ; i++) {
    poly[i].show(); // need to init the final position
    println(i,poly[i].get_summits());
    println("normal vector");
    printArray(poly[i].get_points());
    println("final vector");
    printArray(poly[i].get_final_points());
  }
}

void draw() {
  background(125);
  draw_poly();
}

void set_polygon(int num, int summits, int size) {
  poly = new R_Polygon[num];
  for(int i = 0 ; i < poly.length ; i++) {
    poly[i] = new R_Polygon(this,summits);
    poly[i].size(size);
    // poly[i].radius(size/2);
    if(i == 0) {
      poly[i].pos(width/2,height/2);
    } else {
      poly[i].pos(random(width),random(height));
    } 
  }
}

void draw_poly() {  
  for(R_Polygon p : poly) {
    p.angle_x(map(mouseX,0,width,-TAU,TAU));
    p.reset_is(true); // give the possibility to refresh the vector position
    p.show();
  }
}
