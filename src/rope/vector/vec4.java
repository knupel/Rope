/**
* vec4 class
* v 1.4.0
* 2015-2021
* Vector class with a float precision
* @author @stanlepunk
* @see https://github.com/StanLepunK/Rope
*/
package rope.vector;


public class vec4 extends vec {
	public vec4() {
		super(4);
		set(0,0,0,0);
	}
	
	public vec4(float v) {
		super(4);
		set(v,v,v,v);
	}
	
	public vec4(float x, float y, float z, float w) {
		super(4) ;
		set(x,y,z,w);
	}

	public vec4(vec v) {
		super(4);
		set(v);
	}

	public vec4(ivec v) {
		super(4);
		set(v.x,v.y,v.z,v.w);
	}

	public vec4(float [] source) {
		super(4);
		set(source);
	}

	public vec4(int [] source) {
		super(4);
		set(source);
	}
	
	
	/**
	 * set vec
	 * @param x
	 * @param y
	 * @param z
	 * @param w
	 * @return
	 */
	public vec4 set(float x, float y, float z, float w) {
		this.x = x ;
		this.y = y ;
		this.z = z ;
		this.w = w ;
		return this ;
	}
	
	public vec4 set(float v) {
		set(v,v,v,v);
		return this ;
	}
	
	public vec4 set(vec v) {
		if ( v == null) {
			set(0,0,0,0);
			return this ;
		} else {
			set(v.x,v.y,v.z,v.w);
			return this ;
		}
	}

	public vec4 set(ivec v) {
		if ( v == null) {
			set(0,0,0,0);
		} else {
			set(v.x,v.y,v.z,v.w);
		}
		return this;
	}
	
	public vec4 set(float[] source) {
		if(source.length == 1) {
			set(source[0],this.y,this.z,this.w);
		} else if(source.length == 2) {
			set(source[0],source[1],this.z,this.w);
		} else if(source.length == 3) {
			set(source[0],source[1],source[2],this.w);
		} else if(source.length == 4) {
			set(source[0],source[1],source[2],source[3]);
		} else if(source.length > 4) {
			set(source[0],source[1],source[2],source[3]);
		}
		return this;
	}

	public vec4 set(int[] source) {
		if(source.length == 1) {
			set(source[0],this.y,this.z,this.w);
		} else if(source.length == 2) {
			set(source[0],source[1],this.z,this.w);
		} else if(source.length == 3) {
			set(source[0],source[1],source[2],this.w);
		} else if(source.length == 4) {
			set(source[0],source[1],source[2],source[3]);
		} else if(source.length > 4) {
			set(source[0],source[1],source[2],source[3]);
		}
		return this;
	}
	
  public vec4 set_to(int index, float arg) {
  	if(index == 0) x(arg);
  	if(index == 1) y(arg);
  	if(index == 2) z(arg);
  	if(index == 3) w(arg);
  	return this;
  }
	
	// x
	public vec4 x(float x) {
		return set(x,this.y,this.z,this.w);
	}
	
	public vec4 add_x(float x) {
		this.x += x;
		return set(this.x,this.y,this.z,this.w);
	}
	
	public vec4 sub_x(float x) {
		this.x -= x;
		return set(this.x,this.y,this.z,this.w);
	}
	
	public vec4 mult_x(float x) {
		this.x *= x;
		return set(this.x,this.y,this.z,this.w);
	}
	
	public vec4 div_x(float x) {
		this.x /= x;
		return set(this.x,this.y,this.z,this.w);
	}
	
	// y
	public vec4 y(float y) {
		return set(this.x,y,this.z,this.w);
	}
	
	public vec4 add_y(float y) {
		this.y += y;
		return set(this.x,this.y,this.z,this.w);
	}
	
	public vec4 sub_y(float y) {
		this.y -= y;
		return set(this.x,this.y,this.z,this.w);
	}
	
	public vec4 mult_y(float y) {
		this.y *= y;
		return set(this.x,this.y,this.z,this.w);
	}
	
	public vec4 div_y(float y) {
		this.y /= y;
		return set(this.x,this.y,this.z,this.w);
	}
	
	// z
	public vec4 z(float z) {
		return set(this.x,this.y,z,this.w);
	}
	
	public vec4 add_z(float z) {
		this.z += z;
		return set(this.x,this.y,this.z,this.w);
	}
	
	public vec4 sub_z(float z) {
		this.z -= z;
		return set(this.x,this.y,this.z,this.w);
	}
	
	public vec4 mult_z(float z) {
		this.z *= z;
		return set(this.x,this.y,this.z,this.w);
	}
	
	public vec4 div_z(float z) {
		this.z /= z;
		return set(this.x,this.y,this.z,this.w);
	}
	
	// w
	public vec4 w(float w) {
		return set(this.x,this.y,this.z,w);
	}
	
	
	public vec4 add_w(float w) {
		this.w += w;
		return set(this.x,this.y,this.z,this.w);
	}
	
	public vec4 sub_w(float w) {
		this.w -= w;
		return set(this.x,this.y,this.z,this.w);
	}
	
	public vec4 mult_w(float w) {
		this.w *= w;
		return set(this.x,this.y,this.z,this.w);
	}
	
	public vec4 div_w(float w) {
		this.w /= w;
		return set(this.x,this.y,this.z,this.w);
	}

	// rgb
	public vec4 red(float x) {
		return set(x,this.y,this.z,this.w);
	}

	public vec4 gre(float y) {
		return set(this.x,y,this.z,this.w);
	}

	public vec4 blu(float z) {
		return set(this.x,this.y,z,this.w);
	}

	// hsb
	public vec4 hue(float x) {
		return set(x,this.y,this.z,this.w);
	}

	public vec4 sat(float y) {
		return set(this.x,y,this.z,this.w);
	}

	public vec4 bri(float z) {
		return set(this.x,this.y,z,this.w);
	}
	
	// alpha
	public vec4 alp(float w) {
		return set(this.x,this.y,this.z,w);
	}

	// stpq
	public vec4 s(float x) {
		return set(x,this.y,this.z,this.w);
	}

	public vec4 t(float y) {
		return set(this.x,y,this.z,this.w);
	}

	public vec4 p(float z) {
		return set(this.x,this.y,z,this.w);
	}

	public vec4 q(float w) {
		return set(this.x,this.y,this.z,w);
	}
	

	
	/**
	 * mult
	 * @param mx
	 * @param my
	 * @param mz
	 * @param mw
	 * @return
	 */
	public vec4 mult(float mx, float my, float mz, float mw) {
		x *= mx ; 
		y *= my ; 
		z *= mz ; 
		w *= mw ;
		set(x,y,z,w) ;
		return this ;
	}

	public vec4 mult(float m) {
		return mult(m,m,m,m);
	}

	public vec4 mult(vec v) {
		if(v != null) {
			return mult(v.x,v.y,v.z,v.w);
		} else return null ;
	}

	public vec4 mult(ivec v) {
		if(v != null) {
			return mult(v.x,v.y,v.z,v.w);
		} else return null ;
	}
	
	/**
	 * div
	 * @param dx
	 * @param dy
	 * @param dz
	 * @param dw
	 * @return
	 */
	public vec4 div(float dx, float dy, float dz, float dw) {
		if(dx != 0) x /= dx; 
		if(dy != 0) y /= dy; 
		if(dz != 0) z /= dz; 
		if(dw != 0) w /= dw;
		set(x,y,z,w);
		return this;
	}
	
	public vec4 div(float d) {
		return div(d,d,d,d);
	}
	
	public vec4 div(vec v) {
		if(v != null) {
			return div(v.x,v.y,v.z,v.w);
		} else return null;
	}

	public vec4 div(ivec v) {
		if(v != null) {
			return div(v.x,v.y,v.z,v.w);
		} else return null;
	}
	
	
	/**
	 * add
	 * @param ax
	 * @param ay
	 * @param az
	 * @param aw
	 * @return
	 */
	public vec4 add(float ax,float ay,float az,float aw) {
		x += ax;
		y += ay;
		z += az;
		w += aw;
		set(x,y,z,w);
		return this;
	}

	public vec4 add(float a) {
		return add(a,a,a,a);
	}

	public vec4 add(vec v) {
		if(v != null) {
			return add(v.x,v.y,v.z,v.w);
		} else return null;
	}

	public vec4 add(ivec v) {
		if(v != null) {
			return add(v.x,v.y,v.z,v.w);
		} else return null;
	}
	
	
	/**
	 * sub
	 * @param ax
	 * @param ay
	 * @param az
	 * @param aw
	 * @return
	 */
	public vec4 sub(float ax,float ay,float az, float aw) {
		x -= ax;
		y -= ay;
		z -= az;
		w -= aw; 
		set(x,y,z,w);
		return this;
	}

	public vec4 sub(float a) {
		return sub(a,a,a,a);
	}

	public vec4 sub(vec v) {
		if(v != null) {
			return sub(v.x,v.y,v.z,v.w);
		} else return null;
	}

	public vec4 sub(ivec v) {
		if(v != null) {
			return sub(v.x,v.y,v.z,v.w);
		} else return null;
	}
	

	
	/**
	 * 
	 * @param v
	 * @return
	 */
	public float dot(vec4 v) {
		if(v != null) {
			return x*v.x + y*v.y + z*v.z + w*this.w;
		} else {
			System.out.println("Your Vec arg is"+null) ;
			return 0 ;
		}
	}
	
	public float dot(float x, float y, float z, float w) {
		return this.x*x + this.y*y + this.z*z + this.w*w;
	}
	
	
	/**
	 * 
	 * @param pow
	 * @return Vec4 component powering by each value
	 */
	public vec4 pow(int pow) {
		this.pow(pow,pow,pow,pow);
		return this;
	}
	
	public vec4 pow(int pow_x, int pow_y, int pow_z, int pow_w) {
		x = (float)Math.pow(x,pow_x);
		y = (float)Math.pow(y,pow_y);
		z = (float)Math.pow(z,pow_z);
		w = (float)Math.pow(w,pow_w);
		set(x,y,z,w);
		return this;
	}
	
	
	
	/**
	 * normalize
	 * @param target
	 * @return
	 */
	public vec4 normalize(vec4 target) {
		if (target == null) {
			target = new vec4();
		}
		float m = mag();
		if (m > 0) {
			target.set(x/m, y/m, z/m, w/m);
		} else {
			target.set(x,y,z,w);
		}
		return target;
	}

	public vec4 normalize() {
		float m = mag();
		if (m != 0 && m != 1) {
			div(m);
		}
		return this;
	}
	
	
	/**
	 * map
	 * @param min_in
	 * @param max_in
	 * @param min_out
	 * @param max_out
	 * @return Vec4 where each target is Vec component
	 */
	public vec4 map(float min_in, float max_in, float min_out, float max_out) {
		x = map(x,min_in,max_in,min_out,max_out);
		y = map(y,min_in,max_in,min_out,max_out);
		z = map(z,min_in,max_in,min_out,max_out);
		w = map(w,min_in,max_in,min_out,max_out);
		set(x,y,z,w);
		return this;
	}

	public vec4 map(vec4 min_in, vec4 max_in, vec4 min_out, vec4 max_out) {
		x = map(x,min_in.x,max_in.x,min_out.x,max_out.x);
		y = map(y,min_in.y,max_in.y,min_out.y,max_out.y);   
		z = map(z,min_in.z,max_in.z,min_out.z,max_out.z);   
		w = map(w,min_in.w,max_in.w,min_out.w,max_out.w);
		set(x,y,z,w);
		return this;
	}
	
	
	
	/**
	 * limit
	 * @param max
	 * @return
	 */
	public vec4 limit(float max) {
		if (magSq() > max*max) {
			normalize();
			mult(max);
		}
		return this;
	}
	
	
	public vec4 constrain(float min, float max) {
		return constrain(new vec4(min), new vec4(max));
	}

	public vec4 constrain(float max) {
		return constrain(new vec4(0), new vec4(max));
	}

	public vec4 constrain(vec4 max) {
		return constrain(new vec4(0), max);
	}

	/**
	 * Constrains a value to not exceed a maximum and minimum value. 
	 * @param min
	 * @param max
	 * @return
	 */
	public vec4 constrain(vec4 min, vec4 max) {
		if(x < min.x()) {
			x = min.x();
		}

		if(y < min.y()) {
			y = min.y();
		}
		
		if(z < min.z()) {
			z = min.z();
		}
		
		if(w < min.w()) {
			w = min.w();
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
		
		if(w > max.w()) {
			w = max.w();
		}
		
		set(x,y,z,w);
		return this;
	}
	
	
	/**
	 * jitter
	 * @param range
	 * @return
	 */
	public vec4 jitter(int range) {
		return jitter(range,range,range,range) ;
	}
	
	public vec4 jitter(vec4 range) {
		if(range != null) {
			return jitter((int)range.x,(int)range.y,(int)range.z,(int)range.w) ;
		} else return jitter(0) ;
	}

	public vec4 jitter(int range_x,int range_y, int range_z, int range_w) {
		x += random_next_gaussian(range_x,3);
		y += random_next_gaussian(range_y,3);
		z += random_next_gaussian(range_z,3);
		w += random_next_gaussian(range_w,3);
		set(x,y,z,w);
		return this;
	}


	/**
	 * random
	 * @param max float
	 * @return
	 */
	public vec4 rand(float max) {
		return rand(0,max);
	}
	/**
	 * random
	 * @param min float
	 * @param max float
	 * @return
	 */
	public vec4 rand(float min, float max) {
		x = random(min,max);
		y = random(min,max);
		z = random(min,max);
		w = random(min,max);
		set(x,y,z,w);
		return this;
	}
		/**
	 * random
	 * @param mx vec2
	 * @param my vec2
	 * @param mz vec2
	 * @param mw vec2
	 * @return
	 */
	public vec4 rand(vec4 min, vec4 max) {
		x = random(min.x(),max.x());
		y = random(min.y(),max.y());
		z = random(min.z(),max.z());
		w = random(min.w(),max.w());
		set(x,y,z,w);
		return this;
	}







	/**
	 * 
	 * @param timeline
	 * @param s
	 * @return vec4 cosinus of each argument
	 */
	public vec4 wave(int timeline, float s) {
			return cos_wave(timeline, s, s, s, s);
	}

	/**
	 * 
	 * @param timeline
	 * @param sx
	 * @param sy
	 * @param sz
	 * @param sw
	 * @return vec4 cosinus of each argument
	 */
	public vec4 wave(int timeline, float sx, float sy, float sz, float sw) {
		return cos_wave(timeline, sx, sy, sz, sw);
	}
	/**
	* WAVE COSINUS
	* @param timeline int
	* @param s float speed for all vec arg
	* @return vec4 cosinus of each argument
	*/
	public vec4 cos_wave(int timeline, float s) {
		return cos_wave(timeline,s,s,s,s);
	}
	
	/**
	 * 
	 * @param timeline
	 * @param sx float speed for all vec arg x
	 * @param sy float speed for all vec arg y
	 * @param sz float speed for all vec arg z
	 * @param sw float speed for all vec arg w
	 * @return
	 */
	public vec4 cos_wave(int timeline, float sx, float sy, float sz, float sw) {
		float x = (float)Math.cos(timeline *sx);
		float y = (float)Math.cos(timeline *sy);
		float z = (float)Math.cos(timeline *sz);
		float w = (float)Math.cos(timeline *sw);
		set(x,y,z,w);
		return this;
	}

	/**
	* WAVE SINUS
	* @param timeline int
	* @param s float speed for all vec arg
	* @return vec4 sinus of the value
	*/
	public vec4 sin_wave(int timeline, float s) {
		return sin_wave(timeline,s,s,s,s);
	}
	
	/**
	 * 
	 * @param timeline
	 * @param sx float speed for all vec arg x
	 * @param sy float speed for all vec arg y
	 * @param sz float speed for all vec arg z
	 * @param sw float speed for all vec arg w
	 * @return
	 */
	public vec4 sin_wave(int timeline, float sx, float sy, float sz, float sw) {
		float x = (float)Math.sin(timeline *sx);
		float y = (float)Math.sin(timeline *sy);
		float z = (float)Math.sin(timeline *sz);
		float w = (float)Math.sin(timeline *sw);
		set(x,y,z,w);
		return this;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * GET PART
	 * 
	 */
	
	/**
	 * addition of all components
	 * @return float
	 */
	public float sum() {
		return x+y+z+w;
	}
	
	
	/**
	 * average of all components
	 * @return float average of sum components
	 */
	public float average() {
		return (this.x + this.y +this.z +this.w) *.25f;
	}
	
	
	/**
	 * return distance of the vector or length
	 * 
	 * @return float
	 */
	float dist() {
		return dist(new vec4());
	}
	
	/**
	 * 
	 * @param v_target
	 * @return float
	 */
	float dist(vec4 v_target) {
		if(v_target != null) {
			float dx = x - v_target.x;
			float dy = y - v_target.y;
			float dz = z - v_target.z;
			float dw = w - v_target.w;
			return (float) Math.sqrt(dx*dx + dy*dy + dz*dz + dw*dw);
		} else {
			System.out.println("Your Vec arg is"+null);
			return 0 ;
		}
	}
	
	
	
	/**
	 * return normal cartesian angle coord
	 * @return vec4
	 */
	public vec4 dir() {
		return dir(new vec4(0)) ;
	}
	
	/**
	 * return normal cartesian angle coord
	 * 
	 * @param a_x float
	 * @param a_y float 
	 * @param a_z float
	 * @param a_w float
	 * @return vec4 
	 */
	public vec4 dir(float a_x, float a_y, float a_z, float a_w) {
		return dir(new vec4(a_x,a_y,a_z,a_w));
	}
	
	/**
	 * return normal cartesian angle coord
	 * 
	 * @param origin vec4
	 * @return vec4
	 */
	public vec4 dir(vec4 origin) {
		vec4 temp = this.copy();
		if(origin != null) {
			float dist = dist(origin);
			temp.sub(origin);
			temp.div(dist);
		}
		return temp;
	}
	

	
	
	/**
	 * magSq
	 * @return
	 */
	public float magSq() {
		return (x*x + y*y + z*z +w*w) ;
	}

	/**
	 * mag
	 * @return
	 */
	public float mag() {
		return (float) Math.sqrt(x*x + y*y + z*z + w*w);
	}

	float mag(vec4 v_target) {
		if(v_target != null) {
			float new_x = (v_target.x -x) *(v_target.x -x);
			float new_y = (v_target.y -y) *(v_target.y -y);
			float new_z = (v_target.z -z) *(v_target.z -z);
			float new_w = (v_target.w -w) *(v_target.w -w);
			return (float)Math.sqrt(new_x +new_y +new_z +new_w);
		} else {
			System.out.println("Your Vec arg is"+null);
			return 0 ;
		}
	}
	
	
	




	
	/**
	 * equals
	 * @param target
	 * @return true if the target components is equals to Vec
	 */
	public boolean equals(vec4 target) {
		if(target != null ) {
			if((x == target.x) && (y == target.y) && (z == target.z) && (w == target.w)) {
				return true; 
			} else return false;
		} else return false;
	}
	
	/**
	 * * return true if the vector this is equals to float target
	 * @param target
	 * @return
	 */
	public boolean equals(float target) {
		if((x == target) && (y == target) && (z == target) && (w == target)) 
		return true; 
		else return false;
	}
	
	
	/**
	 * return true if the vector this is equals to float arguments
	 * @param t_x
	 * @param t_y
	 * @param t_z
	 * @param t_w
	 * @return
	 */
	public boolean equals(float t_x,float t_y,float t_z,float t_w) {
		if((x == t_x) && (y == t_y) && (z == t_z)&& (w == t_w)) 
		return true; 
		else return false;
	}
	
	
	/**
	 * return true if the vector this and vector target are in the same vector area
	 * @param target
	 * @param area
	 * @return
	 */
	public boolean compare(vec4 target, vec4 area) {
		if(this != null && target != null && area != null ) {
			if(    (this.x() >= target.x() -area.x() && this.x() <= target.x() +area.x()) 
					&& (this.y() >= target.y() -area.y() && this.y() <= target.y() +area.y()) 
					&& (this.z() >= target.z() -area.z() && this.z() <= target.z() +area.z()) 
					&& (this.w() >= target.w() -area.w() && this.w() <= target.w() +area.w())) {
							return true ; 
			} else {
				return false ;
			}
		} else {
			return false ;
		}
	}
	
	
	
	/**
	 * copy
	 * @return
	 */
	public vec4 copy() {
		return new vec4(x,y,z,w);
	}
	
	
	@Override 
	public String toString() {
		return "[ " + x + ", " + y + ", " + z + ", " + w + " ]";
	} 
}
