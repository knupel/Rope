/**
 * vec3 class
 * v 1.5.3
* 2015-2021
* Vector class with a float precision
 * @author @stanlepunk
 * @see https://github.com/StanLepunK/Rope
*/
package rope.vector;

public class vec3 extends vec {
	// CONSTRUCTOR
	public vec3() {
		super(3);
		set(0,0,0);
	}
	
	public vec3(float v) {
		super(3);
		set(v,v,v);
	}
	
	public vec3(float x, float y, float z) {
		super(3) ;
		set(x,y,z);
	}

	public vec3(vec v) {
		super(3);
		set(v);
	}

	public vec3(ivec v) {
		super(3);
		set(v.x,v.y,v.z);
	}

	public vec3(float [] source) {
		super(3);
		set(source);
	}

	public vec3(int [] source) {
		super(3);
		set(source);
	}
	
	
	
	/**
	 * set component main method
	 * @param x
	 * @param y
	 * @param z
	 * @return
	 */
	public vec3 set(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
		return this;
	}
	
	
	public vec3 set(float v) {
		set(v,v,v);
		return this;
	}
	
	
	public vec3 set(vec v) {
		if(v == null) {
			set(0,0,0);
		} else {
			set(v.x,v.y,v.z);
		}
		return this;
	}
	
	public vec3 set(ivec v) {
		if(v == null) {
			set(0,0,0);
		} else {
			set(v.x,v.y,v.z);
		}
		return this;
	}
	
	public vec3 set(float[] source) {
		if(source.length == 1) {
			set(source[0],this.y,this.z);
		} else if(source.length == 2) {
			set(source[0],source[1],this.z);
		} else if(source.length == 3) {
			set(source[0],source[1],source[2]);
		} else if(source.length > 3) {
			set(source[0],source[1],source[2]);
		}
		return this;
	}
	
	public vec3 set(int[] source) {
		if(source.length == 1) {
			set(source[0],this.y,this.z);
		} else if(source.length == 2) {
			set(source[0],source[1],this.z);
		} else if(source.length == 3) {
			set(source[0],source[1],source[2]);
		} else if(source.length > 3) {
			set(source[0],source[1],source[2]);
		}
		return this;
	}
	
  public vec3 set_to(int index, float arg) {
  	if(index == 0) x(arg);
  	if(index == 1) y(arg);
  	if(index == 2) z(arg);
  	return this;
  }


	/**
	 * 
	 * @return inverse all argument
	 */
	public vec3 inv() {
		inv_impl();
		return this;
	}
	
	
	// x
	public vec3 x(float x) {
		return set(x,this.y,this.z);
	}
	
	public vec3 add_x(float x) {
		this.x += x;
		return set(this.x,this.y,this.z);
	}
	
	public vec3 sub_x(float x) {
		this.x -= x;
		return set(this.x,this.y,this.z);
	}
	
	public vec3 mult_x(float x) {
		this.x *= x;
		return set(this.x,this.y,this.z);
	}
	
	public vec3 div_x(float x) {
		this.x /= x;
		return set(this.x,this.y,this.z);
	}
	
	// y
	public vec3 y(float y) {
	 return set(this.x,y,this.z);
	}
	
	public vec3 add_y(float y) {
		this.y += y;
		return set(this.x,this.y,this.z);
	}
	
	public vec3 sub_y(float y) {
		this.y -= y;
		return set(this.x,this.y,this.z);
	}
	
	public vec3 mult_y(float y) {
		this.y *= y;
		return set(this.x,this.y,this.z);
	}
	
	public vec3 div_y(float y) {
		this.y /= y;
		return set(this.x,this.y,this.z);
	}
	
	// z
	public vec3 z(float z) {
	 return set(this.x,this.y,z);
	}
	
	public vec3 add_z(float z) {
		this.z += z;
		return set(this.x,this.y,this.z);
	}
	
	public vec3 sub_z(float z) {
		this.z -= z;
		return set(this.x,this.y,this.z);
	}
	
	public vec3 mult_z(float z) {
		this.z *= z;
		return set(this.x,this.y,this.z);
	}
	
	public vec3 div_z(float z) {
		this.z /= z;
		return set(this.x,this.y,this.z);
	}

	// rgb
	public vec3 red(float x) {
	 return set(x,this.y,this.z);
	}

	public vec3 gre(float y) {
	 return set(this.x,y,this.z);
	}

	public vec3 blu(float z) {
	 return set(this.x,this.y,z);
	}

	// hsb
	public vec3 hue(float x) {
	 return set(x,this.y,this.z);
	}

	public vec3 sat(float y) {
	 return set(this.x,y,this.z);
	}

	public vec3 bri(float z) {
	 return set(this.x,this.y,z);
	}

	// stp
	public vec3 s(float x) {
	 return set(x,this.y,this.z);
	}

	public vec3 t(float y) {
	 return set(this.x,y,this.z);
	}

	public vec3 p(float z) {
	 return set(this.x,this.y,z);
	}
 
	

	
	/**
	 * mult
	 * @param mx
	 * @param my
	 * @param mz
	 * @return
	 */
	public vec3 mult(float mx, float my, float mz) {
		x *= mx;
		y *= my; 
		z *= mz; 
		set(x,y,z);
		return this;
	}

	public vec3 mult(float m) {
		return mult(m,m,m);
	}
	
	public vec3 mult(vec v) {
		if(v != null) {
			return mult(v.x,v.y,v.z);
		} else return null;   
	}

	public vec3 mult(ivec v) {
		if(v != null) {
			return mult(v.x,v.y,v.z);
		} else return null;   
	}
	
	/**
	 * div
	 * @param dx
	 * @param dy
	 * @param dz
	 * @return
	 */
	public vec3 div(float dx, float dy, float dz) {
		if(dx != 0) x /= dx; 
		if(dy != 0) y /= dy; 
		if(dz != 0) z /= dz; 
		set(x,y,z);
		return this;
	}

	public vec3 div(float d) {
		return div(d,d,d);
	}
	
	public vec3 div(vec v) {
		if(v != null) {
			return div(v.x,v.y,v.z);
		} else return null;   
	}
	
	public vec3 div(ivec v) {
		if(v != null) {
			return div(v.x,v.y,v.z);
		} else return null;   
	}
	
	
	/**
	 * add main method
	 * @param ax
	 * @param ay
	 * @param az
	 * @return
	 */
	public vec3 add(float ax,float ay,float az) {
		x += ax;
		y += ay;
		z += az;
		set(x,y,z);
		return this;
	}
	
	public vec3 add(float a) {
		return add(a,a,a);
	}

	public vec3 add(vec v) {
		if(v != null) {
			return add(v.x,v.y,v.z);
		} return null;
	}

	public vec3 add(ivec v) {
		if(v != null) {
			return add(v.x,v.y,v.z);
		} return null;
	}
	
	
	/**
	 * sub main method
	 * @param sx
	 * @param sy
	 * @param sz
	 * @return
	 */
	public vec3 sub(float sx,float sy,float sz) {
		x -= sx;
		y -= sy;
		z -= sz;
		set(x,y,z);
		return this;
	}

	public vec3 sub(float s) {
		return sub(s,s,s);
	}

	public vec3 sub(vec v) {
		if(v != null) {
			return sub(v.x,v.y,v.z);
		} return null;
	}

	public vec3 sub(ivec v) {
		if(v != null) {
			return sub(v.x,v.y,v.z);
		} return null;
	}
	
	

	
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @param z
	 * @return the doc product between the vec and the target
	 */
	public float dot(float x, float y, float z) {
		return this.x*x + this.y*y + this.z*z;
	}
	
	public float dot(vec3 v) {
		if(v != null) {
			return x*v.x + y*v.y + z*v.z;
		} else {
			System.out.println("Your Vec arg is "+null) ;
			return 0 ;
		}
		
	}
	
	
	/**
	 * each component of the vec is power push
	 * 
	 * @param pow
	 * @return vec3 
	 */
	public vec3 pow(float pow) {
		this.pow(pow,pow,pow);
		return this;
	}
	
	/**
	 * each component of the vec is power push
	 * 
	 * @param pow_x
	 * @param pow_y
	 * @param pow_z
	 * @return
	 */
	public vec3 pow(float pow_x, float pow_y, float pow_z) {
		x = (float)Math.pow(x,pow_x);
		y = (float)Math.pow(y,pow_y);
		z = (float)Math.pow(z,pow_z);
		set(x,y,z);
		return this;
	}
	
	
	/**
	 * 
	 * @param v
	 * @param target
	 * @return vec3
	 */
	public vec3 cross(vec3 v, vec3 target) {
		if(v != null) {
			float crossX = y*v.z - v.y*z;
			float crossY = z*v.x - v.z*x;
			float crossZ = x*v.y - v.x*y;
			if (target == null) {
				target = new vec3(crossX, crossY, crossZ);
			} else {
				target.set(crossX, crossY, crossZ);
			}
			return target;
		} else return null;
	}
	
	/**
	 * 
	 * @param v
	 * @return vec3
	 */
	public vec3 cross(vec3 v) {
		if(v != null) {
			return cross(v, null);
		} else return null ;
		
	}
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @param z
	 * @return vec3
	 */
	public vec3 cross(float x, float y, float z) {
		vec3 v = new vec3(x,y,z) ;
		return cross(v, null);
	}
	
	
	
	/**
	 * 
	 * @param target
	 * @return
	 */
	public vec3 normalize(vec3 target) {
		if (target == null) {
			target = new vec3();
		}
		float m = mag();
		if (m > 0) {
			target.set(x/m, y/m, z/m);
		} else {
			target.set(x, y, z);
		}
		return target;
	}

	public vec3 normalize() {
		float m = mag();
		if (m != 0 && m != 1) {
			div(m);
		}
		return this;
	}
	
	
	public vec3 map(float minIn, float maxIn, float minOut, float maxOut) {
		x = map(x,minIn,maxIn,minOut,maxOut);
		y = map(y,minIn,maxIn,minOut,maxOut);
		z = map(z,minIn,maxIn,minOut,maxOut);
		set(x,y,z) ;
		return this ;
	}
	
	public vec3 map(vec3 minIn, vec3 maxIn, vec3 minOut, vec3 maxOut) {
		x = map(x,minIn.x,maxIn.x,minOut.x,maxOut.x);
		y = map(y,minIn.y,maxIn.y,minOut.y,maxOut.y);   
		z = map(z,minIn.z,maxIn.z,minOut.z,maxOut.z);   
		set(x,y,z) ;
		return this ;
	}
	
	/**
	 * limit
	 * @param max
	 * @return
	 */
	public vec3 limit(float max) {
		if (magSq() > max*max) {
			normalize();
			mult(max);
		}
		return this;
	}
	
	
	
	
	public vec3 constrain(float min, float max) {
		return constrain(new vec3(min), new vec3(max));
	}

	public vec3 constrain(float max) {
		return constrain(new vec3(0), new vec3(max));
	}

	public vec3 constrain(vec3 max) {
		return constrain(new vec3(0), max);
	}
	
	/**
	 * Constrains a value to not exceed a maximum and minimum value. 
	 * @param min
	 * @param max
	 * @return
	 */
	public vec3 constrain(vec3 min, vec3 max) {
		if(x < min.x()) {
			x = min.x();
		}

		if(y < min.y()) {
			y = min.y();
		}
		
		if(z < min.z()) {
			z = min.z();
		}

		if(x > max.x()) {
			x = max.x();
		}

		if(y > max.y()) {
			y = max.y();
		}
		
		if(z > max.z()) {
			z = max.z();
		}
		set(x,y,z);
		return this;
	}
	
	/**
	 * jitter
	 * @param range_x
	 * @param range_y
	 * @param range_z
	 * @return
	 */
	public vec3 jitter(int range_x,int range_y, int range_z) {
		x += random_next_gaussian(range_x,3);
		y += random_next_gaussian(range_y,3);
		z += random_next_gaussian(range_z,3);
		set(x,y,z);
		return this;
	}
	
	public vec3 jitter(int range) {
		return jitter(range,range,range) ;
	}
	
	public vec3 jitter(vec3 range) {
		if(range != null) {
			return jitter((int)range.x,(int)range.y,(int)range.z);
		} else return jitter(0,0,0) ;
	}



	/**
	 * random
	 * @param max float
	 * @return
	 */
	public vec3 rand(float max) {
		return rand(0,max);
	}
	/**
	 * random
	 * @param min float
	 * @param max float
	 * @return
	 */
	public vec3 rand(float min, float max) {
		x = random(min,max);
		y = random(min,max);
		z = random(min,max);
		set(x,y,z);
		return this;
	}
		/**
	 * random
	 * @param min
	 * @param max
	 * @return
	 */
	public vec3 rand(vec3 min, vec3 max) {
		x = random(min.x(),max.x());
		y = random(min.y(),max.y());
		z = random(min.z(),max.z());
		set(x,y,z);
		return this;
	}




	/**
	 * 
	 * @param timeline
	 * @param s
	 * @return vec3 cosinus of each argument
	 */
	public vec3 wave(int timeline, float s) {
			return cos_wave(timeline, s, s, s);
	}

	/**
	 * 
	 * @param timeline
	 * @param sx
	 * @param sy
	 * @param sz
	 * @return vec3 cosinus of each argument
	 */
	public vec3 wave(int timeline, float sx, float sy, float sz) {
		return cos_wave(timeline, sx, sy, sz);
	}


	/**
	* WAVE COSINUS
	* @param timeline int
	* @param s float speed for all vec arg
	* @return vec3 cosinus of each argument
	*/
	public vec3 cos_wave(int timeline, float s) {
		return cos_wave(timeline,s,s,s);
	}

	
	/**
	 * 
	 * @param timeline
	 * @param sx float speed for all vec arg x
	 * @param sy float speed for all vec arg y
	 * @param sz float speed for all vec arg z
	 * @return vec3 cosinus of each argument
	 */
	public vec3 cos_wave(int timeline, float sx, float sy, float sz) {
		float x = (float)Math.cos(timeline *sx);
		float y = (float)Math.cos(timeline *sy);
		float z = (float)Math.cos(timeline *sz);
		set(x,y,z);
		return this;
	}

	/**
	* WAVE SINUS
	* @param timeline int
	* @param s float speed for all vec arg
	* @return vec3 sinus of the value
	*/
	public vec3 sin_wave(int timeline, float s) {
		return sin_wave(timeline,s,s,s);
	}
	
	/**
	 * 
	 * @param timeline
	 * @param sx float speed for all vec arg x
	 * @param sy float speed for all vec arg y
	 * @param sz float speed for all vec arg z
	 * @return
	 */
	public vec3 sin_wave(int timeline, float sx, float sy, float sz) {
		float x = (float)Math.sin(timeline *sx);
		float y = (float)Math.sin(timeline *sy);
		float z = (float)Math.sin(timeline *sz);
		set(x,y,z);
		return this;
	}


		/**
	 * 
	 * @param mod_x
	 * @param mod_y
	 * @param mod_z
	 * @return return the modulo of each element in the same order
	 */
	public vec3 mod(float mod_x, float mod_y, float mod_z) {
		x = x%mod_x;
		y = y%mod_y;
		z = z%mod_z;
		set(x,y,z);
		return this;
	}

	public vec3 mod(float mod) {
		return mod(mod, mod, mod);
	}

	public vec3 mod(vec3 mod) {
		return mod(mod.x(), mod.y(), mod.z());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * GET PART
	 * 
	 */
	
	/**
	 * sum of all components
	 * @return float
	 */
	public float sum() {
		return x+y+z;
	}
	
	/**
	 * average of all components
	 * @return float
	 */
	public float average() {
		return (this.x + this.y +this.z) *.333f;
	}
	
	/**
	 * return distance of the vector or length
	 * 
	 * @return float
	 */
	float dist() {
		return dist(new vec3());
	}
	
	/**
	 * * return distance between vector
	 * 
	 * @param target
	 * @return
	 */
	public float dist(vec target) {
		if(target != null) {
			float dx = x -target.x;
			float dy = y -target.y;
			return (float) Math.sqrt(dx*dx + dy*dy);
		} else {
			System.out.println("Your Vec arg is "+null);
			return 0 ;
		}
	}
	

	
	/**
	 * return normal cartesian angle coord
	 * 
	 * @return vec3
	 */
	public vec3 dir() {
		return dir(new vec3(0)) ;
	}
	
	/**
	 * return normal cartesian angle coord
	 * 
	 * @param a_x
	 * @param a_y
	 * @param a_z
	 * @return vec3
	 */
	public vec3 dir(float a_x, float a_y, float a_z) {
		return dir(new vec3(a_x,a_y,a_z)) ;
	}
	
	
	
	/**
	 * return normal cartesian angle coord
	 * 
	 * @param origin
	 * @return
	 */
	public vec3 dir(vec3 origin) {
		vec3 temp = this.copy();
		if(origin != null) {
			float dist = dist(origin) ;
			temp.sub(origin) ;
			temp.div(dist) ;
		}
		return temp;
	}
	
	

	
	public vec3 tan(float float_to_make_plane_ref_x, float float_to_make_plane_ref_y, float float_to_make_plane_ref_z) {
		return tan(new vec3(float_to_make_plane_ref_x, float_to_make_plane_ref_y, float_to_make_plane_ref_z)) ;
	}
	
	
	/**
	 * 
	 * @param vector_to_make_plane_ref
	 * @return
	 */
	public vec3 tan(vec3 vector_to_make_plane_ref) {
		if(vector_to_make_plane_ref != null) {
			vec3 tangent = cross(vector_to_make_plane_ref) ;
			return tangent ;
		} else return null ;
	}
	
	
	
	/**
	 * 
	 * @return
	 */
	public float magSq() {
		return (x*x + y*y + z*z) ;
	}




	/**
	 * 
	 * @param v_target
	 * @return
	 */
	public float mag(vec3 v_target) {
		if(v_target != null) {
			float new_x = (v_target.x -x) *(v_target.x -x);
			float new_y = (v_target.y -y) *(v_target.y -y);
			float new_z = (v_target.z -z) *(v_target.z -z);
			return (float)Math.sqrt(new_x +new_y +new_z);
		} else {
			System.out.println("Your Vec arg is "+null) ;
			return 0 ;
		}
	}
	
	public float mag() {
		return (float) Math.sqrt(x*x + y*y + z*z) ;
	}
	
	
	





	
	
	/**
	 * return true if the vector this is equals to vector target
	 * @param target
	 * @return 
	 */
	public boolean equals(vec3 target) {
		if(target != null) {
			if((x == target.x) && (y == target.y) && (z == target.z)) {
				return true ; 
			} else return false ;
		} else return false ;
	}
	
	/**
	 * return true if the vector this is equals to float target
	 * @param target
	 * @return
	 */
	public boolean equals(float target) {
		if((x == target) && (y == target) && (z == target)) 
		return true ; 
		else return false ;
	}
	
	/**
	 * return true if the vector this is equals to float arguments
	 * @param t_x
	 * @param t_y
	 * @param t_z
	 * @return
	 */
	public boolean equals(float t_x,float t_y,float t_z) {
		if((x == t_x) && (y == t_y) && (z == t_z)) 
		return true ; 
		else return false ;
	}
	
	
	
	
	/**
	 * return true if the vector this and vector target are in the same vector area
	 * @param target
	 * @param area
	 * @return
	 */
	public boolean compare(vec3 target, vec3 area) {
		if(this != null && target != null && area != null ) {
			if(    (this.x() >= target.x() -area.x() && this.x() <= target.x() +area.x()) 
					&& (this.y() >= target.y() -area.y() && this.y() <= target.y() +area.y()) 
					&& (this.z() >= target.z() -area.z() && this.z() <= target.z() +area.z())) { 
							return true ; 
			} else {
				return false ;
			}
		} else {
			return false ;
		}
	}
	
	
	/**
	 * 
	 * @return
	 * 
	 */
	public vec3 copy() {
		return new vec3(x,y,z);
	}
	
	
	@Override 
	public String toString() {
		return "[ " + x + ", " + y + ", " + z + " ]";
	}

}
