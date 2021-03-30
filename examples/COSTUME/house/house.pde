/**
* R_House
* v 0.0.2
* 2019-2021
* @author @stanlepunk
* @see https://github.com/StanLepunK/Rope
*
*/

import rope.core.*;
import rope.costume.R_House;
import rope.vector.vec3;
R_House house;
Rope r;
void setup() {
  colorMode(HSB,360,100,100,100);
  size(700,700,P3D);
  house = new R_House(this);
}

float rot_x = 0;
float rot_y = 0;
void draw() {
  background(0);
  float min = width/12;
  float max = width *.4;
  
  // house size
  float rx = abs(sin(frameCount *.002));
  float ry = abs(sin(frameCount *.004));
  float rz = abs(sin(frameCount *.006));
  float sx = map(rx,0,1,min,max);
  float sy = map(ry,0,1,min,max);
  float sz = map(rz,0,1,min,max);
  vec3 size = new vec3(sx,sy,sz);
  house.size(size);

  // house peak
  float peak_a = abs(sin(frameCount *.005)) *.5;
  float peak_b = abs(sin(frameCount *.005)) *.5;
  house.set_peak(peak_a,peak_b);

  // house colour roof
   house.fill_wall(r.GRAY[6]);
   house.fill_roof(r.BLOOD);
   house.fill_ground(r.BLACK);
   house.stroke(r.GRAY[2]);
   house.thickness(2);
   house.mode(BOTTOM);

  
  
  pushMatrix();
  translate(width/2,height/2);
  if(mousePressed) {
    rot_y = map(mouseY,0,height,-PI,PI);
    rot_x = map(mouseX,0,width,-PI,PI);
  }
  rotateX(rot_y);
  rotateY(rot_x);
  house.show();
  popMatrix();
}
