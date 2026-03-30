package rope.pixo;

import rope.vector.vec3;

public class R_Moxo extends R_Pixo {
	private vec3 home;
	private boolean home_is = true;
	private boolean migration_is = false;

	private vec3 speed;
	
	public R_Moxo() {
		super();
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


}
