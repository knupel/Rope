/**
 * R_Colour
 * add colour to palette from image
 * V 0.0.1
 * 2023-2023
*/

import rope.core.Rope;
import rope.colour.R_Colour;
import rope.image.R_Image;
import rope.tool.file.R_Input;


Rope r = new Rope();
// input
PImage img;
R_Input input;
boolean img_is = false;
String type = "image";

// palette
R_Colour rc;
int num = 20; // num of color add to the root color;
boolean palette_is = false;
String palette_name = "palette";


void setup() {
  size(800,600);
  input = new R_Input(this);
  input.select_input(type);
  // palette
  rc = new R_Colour(this, palette_name);
}

void draw() {
  if(input.input_path(type) != null && !img_is && type.equals(type)) {
		img_is = true;
		img = loadImage(input.input_path(type));
	} 
  // display image
	if(img_is) {
		image(img,0,0);
	}

  // create palette from image
  if(img_is && !palette_is) {
    palette_is = rc.create(palette_name, img, num);
  }

  //show palette
  if(palette_is) {
    int [] arr = rc.get(palette_name);
    int step = width / arr.length;
    stroke(r.BLACK);
    strokeWeight(3);
    for(int i = 0 ; i < arr.length ; i++) {
      fill(arr[i]);
      rect(step * i, height/2, step, height/4);
    }
    fill(rc.get_master(palette_name));
    circle(width/2, height/4, height/6);
  }
}

void mousePressed() {
  if(img_is) {
    palette_is = rc.create(palette_name, img, num);
  }
}
