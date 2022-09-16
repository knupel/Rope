/**
 * * R_Line2D change size dynamicly
 * 
 * 
* Copyleft(c) 2022-2022
* v 0.0.1
* @author @stanlepunk
* https://github.com/StanLepunK/Rope/
*
* 
*/

import rope.mesh.R_Line2D;

R_Line2D [] list;
int num = 5000;

void setup() {
  list = new R_Line2D[num];
  size(400,400,P2D);
  for(int i = 0 ; i < list.length ; i++) {
    list[i] = new R_Line2D(this);
  }
  distribution(width/2, height/2, 40);
}


void draw() {
  background(0);
  stroke(255);
  println("frameRate",(int)frameRate, "that's very cool frameRate with",num,"lines");
  for(R_Line2D line : list) {
    // note the start and end value is normal from 0 to 1, to have a change mapped on the original size of your line
    float start = map(mouseX,0,width,0,1);
    float end = map(mouseY,0,height,0,1);
    line.change(start,end);
    line.show();
  }
}

void distribution(int x, int y, float range) {
  for(R_Line2D line : list) {
    float x1 = random(-range, range) + x;
    float x2 = random(-range, range) + x;
    float y1 = random(-range, range) + y;
    float y2 = random(-range, range) + y;
    line.set(x1,y1,x2,y2);
  }
}

void mousePressed() {
  distribution(width/2, height/2, 40);
}
