/**
* R_Puppet2D test with thousant of elements versur R_Line2D
* v 0.0.1
* 2022-2022
*/
import rope.tool.R_Puppet2D;
import rope.mesh.R_Line2D;
import rope.vector.vec2;

int num = 10_000;
R_Puppet2D [] puppets = new R_Puppet2D[num];
R_Line2D [] lines = new R_Line2D[num];
void setup() {
  size(800,800,P2D);
  for(int i = 0 ; i < num ; i++) {
    vec2 a = new vec2().rand(0,width);
    vec2 b = new vec2().rand(0,width);
    puppets[i] = new R_Puppet2D(this,a,b);
    lines[i] = new R_Line2D(this,a,b);
  }
}

void draw() {
  println("frameRate", (int)frameRate);
  background(255);
  if(mousePressed) {
    println("puppets");
  } else {
    println("lines");
  }
  
  for(int i = 0 ; i < num ; i++) {
    if(mousePressed) {
      puppets[i].show();
    } else {
      lines[i].show();
    }
  }
}
