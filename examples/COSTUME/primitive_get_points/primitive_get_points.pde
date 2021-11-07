/**
* Rope Primitive Polygon
* v 0.0.1
* 2021-2021
* @author @stanlepunk
* @see https://github.com/StanLepunK/Rope
*
* In this example we catch the point and redraw with vertex.
*/
import rope.costume.R_Primitive;
import rope.vector.*;
vec3 [] list;
R_Primitive prim;
int size;

void setup() {
  background(125);
  size(300,300,P2D);
  int num = 10000;
  set_info_list(num);
}

void draw() {
  println("frameRate",(int)frameRate);
  // println("list length",list.length);
  background(125);
  draw_prim();
}


void set_info_list(int num) {
  size = width/4;
  list = new vec3[num];
  float angle = PI/num;
  for(int i = 0 ; i < list.length ; i++) {
    list[i] = new vec3(random(width),random(height),angle*i);
    println("info", list[i]);
  }

  prim = new R_Primitive(this,5);
  prim.size(size);
  printArray(prim.get());
  println("prim size", prim.size());
}

void draw_prim() {
  for(vec3 elem : list) {
    fill(color(random(g.colorModeX)));
    noStroke();
    pushMatrix();
    translate(elem.x(),elem.y());
    rotate(elem.z());

    fill(color(random(g.colorModeX)));
    beginShape();
    for(int i = 0 ; i < prim.get_summits() ; i++) {
      vertex(prim.get(i).x(),prim.get(i).y());
    }
    endShape(CLOSE);
    popMatrix();
  }
}
