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
	private vec3 home;
	private boolean home_is = true;
	private boolean migration_is = false;
	private vec3 canvas;
	private vec3 speed;

	private vec3 size;

	private float alpha = 255.0f;


	public R_Pixo() {
    super();
		this.size = new vec3(1);
		this.colour = BLACK;
	}





	// migration
	public void migration_is(boolean is) {
		this.migration_is = is;
	}

	public boolean migration_is() {
		return this.migration_is;
	}

	// home
	public void home_is(boolean is) {
		this.home_is = is;
	}

	public boolean home_is() {
		return this.home_is;
	}


	public void home(float x, float y, float z) {
		if(this.home != null) {
			this.home.set(x,y,z);
		} else {
			this.home = new vec3(x,y,z);
		}
	}

	public vec3 home() {
		return this.home;
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

	// speed
	public void speed(float speed) {
		this.speed(speed,speed,speed);
	}

	public void speed(float x, float y) {
		speed(x,y,0);
	}

	public void speed(float x, float y, float z) {
		if(this.speed == null) {
				this.speed = new vec3(x,y,z);
		} else {
			this.speed.set(x,y,z);
		}
	}

	public vec3 speed() {
		return this.speed;
	}



	// alpha
	public void alpha(int alpha) {
		this.alpha = alpha;
	}

	public float alpha() {
		return this.alpha;
	}
}
