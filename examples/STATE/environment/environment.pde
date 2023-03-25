/**
* State environment
* Processing 4.2
* 
* v 0.0.1
* Copyleft (c) 2023-2023
* 
* @author @knupel
* @see https://github.com/knupel/Rope 
* 
*
*/

import rope.utils.R_State.State;
import rope.core.Rope;
Rope r = new Rope();

void setup() {
	size(400,400, P3D);
	colorMode(HSB,360,100,100,100);
	State.init(this);
	println("renderer", State.env().get_renderer());
	println("colorMode, mode", State.cm());
	println("colorMode, x, y, z, alpha", State.cxyza());
	println("colorMode, x, y, z", State.cxyz());
}
