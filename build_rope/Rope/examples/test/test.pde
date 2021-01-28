/**
* Rope test
* 2019-2019
* v 0.0.1
* @author @stanlepunk
* @see https://github.com/StanLepunK/Rope
*/
import rope.vector.*;
vec4 [] list = new vec4[1000000];
void setup() {
  size(1500,800);
  println("start",millis());
  for(int i = 0 ; i < list.length ; i++) {
    list[i] = new vec4().rand(0,width);
  }
  println("end",millis());
  
}

void draw() {
  background(0);
  fill(255);
  stroke(255);
  println((int)frameRate);
  int c = color(255,0,0);
  for(int i = 0 ; i < list.length ; i++) {
    
    if(frameCount%2 == 0) {
      set((int)list[i].x(),(int)list[i].y(),c);
    } else {
      set((int)list[i].y(),(int)list[i].x(),c);
    }
  }
  
 
}
