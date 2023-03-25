/**
* Load input
* Copyleft (c) 2023-2023
* @author @knupel
* @see https://github.com/knupel/Rope
*
*/

import rope.tool.file.R_Input;
import rope.core.Rope;

Rope r = new Rope();
PImage img;
R_Input input;
/** 
* type can be : "image", "movie", "shape", "sound", "text"
* to see more about type go to 
* @see https://github.com/knupel/Rope/blob/master/src/rope/tool/file/R_Input.java
*/
String type = "image";
boolean img_is = false;

void setup() {
	size(800,600, P2D);
	input = new R_Input(this);
	input.select_input(type);
}

void draw() {
	println("input.input_path(type)",input.input_path(type));
	if(input.input_path(type) != null && !img_is && type.equals("image")) {
		img_is = true;
		img = loadImage(input.input_path(type));
	} 
	if(img_is) {
		image(img,0,0);
	}
}


