/**
 * R_Colour
 * add colour to palette
 * V 0.0.1
 * 2023-2023
*/

import rope.colour.R_Colour;
import rope.core.Rope;

Rope r = new Rope();
R_Colour rc;
int colour = r.LILAS;
int num = 10; // num of color add to the root color;
int type = r.RED;
float range = 0.3;
float range_x = 0.3;
float range_y = 0.3;
float range_z = 0.3;

void setup() {
  println(r.VERSION);
  size(400,400);
  rc = new R_Colour(this);
  rc.add("palette", colour, num, type, range);
  rc.print_palette();
}

void draw() {
  int [] arr = rc.get("palette");
  int step = width / arr.length;
  stroke(r.BLACK);
  strokeWeight(3);
  for(int i = 0 ; i < arr.length ; i++) {
    fill(arr[i]);
    rect(step * i, 0, step, height);
  } 
}

int type_ref = 0;
void mousePressed() {
  type_ref++;
  if(type_ref > 7) {
    type_ref = 0;
  }
  range = random(1);
  range_x = random(1);
  range_y = random(1);
  range_z = random(1);
  switch(type_ref) {
    case 0: type = r.HSB; println("HSB range", range_x, range_y, range_z);break;
    case 1: type = r.HUE;  println("HUE range", range);break;
    case 2: type = r.SATURATION;  println("SATURATION range", range);break;
    case 3: type = r.BRIGHTNESS;  println("BRIGHTNESS range", range);break;
    case 4: type = r.RGB;  println("RGB range", range_x, range_y, range_z);break;
    case 5: type = r.RED;  println("RED range", range);break;
    case 6: type = r.GREEN;  println("GREEN range", range);break;
    case 7: type = r.BLUE;  println("BLUE range", range);break;
    default: type = r.HUE; println("HUE range", range);break;
  }

  rc.clear();
  if(type == r.RGB || type == r.HSB) {
    rc.add("palette", colour, num, type, range_x, range_y, range_z);
  } else {
    rc.add("palette", colour, num, type, range);
  }
  

}
