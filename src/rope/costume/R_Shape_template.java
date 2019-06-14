/**
* R_Shape_template
* v 0.0.1
* 2019-2019
* @author @stanlepunk
* @see https://github.com/StanLepunK/Rope
* Class R_Shape_template
* the minimum to code your own shape and profite of Parent class P_Shape
* this super class assume 
* void pos(T... arg); 
* void size(T... arg);
* vec3 pos();
* vec3 size();
*/
package rope.costume;

import processing.core.PApplet;
import rope.core.R_Constants;
import rope.vector.*;

public class R_Shape_template extends R_Shape implements R_Constants, R_Shape_contract {

	public R_Shape_template(PApplet pa) {
		super(pa);
		pos(0);
		size(1);

	}
	
	/*
	 * Is good to compute the shape between -0.5 > 0.5
	 * and pass the computing size and position to method show
	 */
	public void build() {
		
	}
	
  /*
   * show
   * useful to keep all Shape with the same range of size, 
   * this thing is due because the first shape coded is a primitive calculte on a circle shape
   */
	public void show() {
		vec3 radius = new vec3(size).mult((float).5);  
	}

}

