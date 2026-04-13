/**
* R_Puppet2D test with many hundred thousand of elements versus R_Line2D
* v 0.0.2
* 2022-2026
*/
import rope.tool.R_Puppet2D;
import rope.mesh.R_Line2D;
import rope.vector.vec2;

int num = 200_000;
R_Puppet2D [] puppets = new R_Puppet2D[num];
R_Line2D [] lines = new R_Line2D[num];
void setup() {
  size(1200,1200,P2D);
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
