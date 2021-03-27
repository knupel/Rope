/**
* R_Pixo class
* v 0.2.0
* 2021-2021
* @author @stanlepunk
* @see https://github.com/StanLepunK/Rope
*/

package rope.pixo;

import processing.core.PApplet;
import rope.pixo.R_Pix;
import rope.vector.vec3;


public class R_Pixo extends R_Pix {

	private vec3 canvas;
	private vec3 size;

	private float alpha = 255.0f;


	public R_Pixo() {
    super();
		this.size = new vec3(1);
	}




	// canvas
	public void canvas(float x, float y, float z) {
		if(this.canvas != null) {
			this.canvas.set(x,y,z);
		} else {
			this.canvas = new vec3(x,y,z);
		}
	}

	public void canvas(float size) {
		this.canvas(size,size,size);
	}

	public vec3 canvas() {
		return this.canvas;
	}

	// size
	public void size(float size) {
		this.size(size,size,size);
	}

	public void size(float x, float y) {
		this.size.set(x,y,0);
	}

	public void size(float x, float y, float z) {
		this.size.set(x,y,z);
	}

	public vec3 size() {
		return this.size;
	}





	// alpha
	public void set_alpha(int alpha) {
		this.alpha = alpha;
	}

	public float get_alpha() {
		return this.alpha;
	}
}
