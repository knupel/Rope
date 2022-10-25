/**
 * vec2 class 
 * v 1.6.2
 * 2015-2022
 * Vector class with a float precision
 * @author @stanlepunk
 * @see https://github.com/StanLepunK/Rope
 */
package rope.vector;

public class vec2 extends vec {
	public vec2() {
		super(2);
		set(0, 0);
	}

	public vec2(float v) {
		super(2);
		set(v,v);
	}

	public vec2(float x, float y) {
		super(2);
		set(x,y);
	}

	public vec2(vec v) {
    super(2);
    set(v);
  }

  public vec2(ivec v) {
    super(2);
    set(v.x(),v.y());
  }


	public vec2(float [] source) {
    super(3);
    set(source);
  }

  public vec2(int [] source) {
    super(3);
    set(source);
  }

	/**
	 * 
	 * @param x
	 * @param y
	 * @return this
	 */
	public vec2 set(float x, float y) {
		this.x = x;
		this.y = y;
		return this;
	}

	public vec2 set(float v) {
		set(v, v);
		return this;
	}

	public vec2 set(vec v) {
		if (v == null) {
			set(0,0);
		} else {
			set(v.x(), v.y());
		}
		return this;
	}

	public vec2 set(ivec v) {
		if (v == null) {
			set(0,0);
		} else {
			set(v.x(), v.y());	
		}
		return this;
	}

	
	public vec2 set(float[] source) {
    if(source.length == 1) {
      set(source[0],this.y());
    } else if(source.length == 2) {
      set(source[0],source[1]);
    } else if(source.length > 2) {
      set(source[0],source[1]);
    } 
    return this;
  }

  public vec2 set(int[] source) {
    if(source.length == 1) {
      set(source[0],this.y());
    } else if(source.length == 2) {
      set(source[0],source[1]);
    } else if(source.length > 2) {
      set(source[0],source[1]);
    } 
    return this;
  }
  
  public vec2 set_to(int index, float arg) {
  	if(index == 0) x(arg);
  	if(index == 1) y(arg);
  	return this;
  }

	/**
	 * 
	 * @return inverse all argument
	 */
	public vec2 inv() {
		inv_impl();
		return this;
	}
  
  // operation on simplest argument
	// x

	public vec2 x(float x) {
		return set(x, this.y());
	}
	
	public vec2 add_x(float x) {
  	this.x += x;
  	return set(this.x(),this.y());
  }
  
  public vec2 sub_x(float x) {
  	this.x -= x;
  	return set(this.x(),this.y());
  }
  
  public vec2 mult_x(float x) {
  	this.x *= x;
  	return set(this.x(),this.y());
  }
  
  public vec2 div_x(float x) {
  	this.x /= x;
  	return set(this.x(),this.y());
  }
  
	// y

	public vec2 y(float y) {
		return set(this.x(), y);
	}
	
	public vec2 add_y(float y) {
  	this.y += y;
  	return set(this.x(),this.y());
  }
  
  public vec2 sub_y(float y) {
  	this.y -= y;
  	return set(this.x(),this.y());
  }
  
  public vec2 mult_y(float y) {
  	this.y *= y;
  	return set(this.x(),this.y());
  }
  
  public vec2 div_y(float y) {
  	this.y /= y;
  	return set(this.x(),this.y());
  }

	// st

	public vec2 s(float x) {
		return set(x, this.y());
	}
	
	public vec2 t(float y) {
		return set(this.x(), y);
	}

	// uv

	public vec2 u(float x) {
		return set(x, this.y());
	}
	
	public vec2 v(float y) {
		return set(this.x(), y);
	}

	


	/**
 * multiply Vector by different float value
 * @param mx
 * @param my
 * @return this vec2 mult by the arguments
 */
	public vec2 mult(float mx, float my) {
		x *= mx;
		y *= my;
		set(x, y);
		return this;
	}
  
	public vec2 mult(float m) {
		return mult(m,m);
	}

	public vec2 mult(vec v) {
		if (v != null) {
			return mult(v.x(),v.y());
		} else
			return null;
	}

	public vec2 mult(ivec v) {
		if (v != null) {
			return mult(v.x(),v.y());
		} else
			return null;
	}


	/**
	 * divide Vector by a float value
	 * @param dx
	 * @param dy
	 * @return this vec2 divide by the argument 
	 */
	public vec2 div(float dx, float dy) {
		if (dx != 0)
			x /= dx;
		if (dy != 0)
			y /= dy;
		set(x, y);
		return this;
	}

	public vec2 div(float d) {
		return div(d, d);
	}

	public vec2 div(vec v) {
		if (v != null) {
			return div(v.x(), v.y());
		} else
			return null;
	}

	public vec2 div(ivec v) {
		if (v != null) {
			return div(v.x(), v.y());
		} else
			return null;
	}

	/**
  * add float value
  * @param ax float
  * @param ay float
  * @return this vec2 result of addition
  */
	public vec2 add(float ax, float ay) {
		x += ax;
		y += ay;
		set(x, y);
		return this;
	}

	public vec2 add(float a) {
		return add(a, a);
	}

	public vec2 add(vec v) {
		if (v != null) {
			return add(v.x(), v.y());
		} else
			return null;
	}

	public vec2 add(ivec v) {
		if (v != null) {
			return add(v.x(), v.y());
		} else
			return null;
	}

	/**
	 * sub float value
	 * @param sx float
	 * @param sy float
	 * @return this vec2 result of substration
	 */
	public vec2 sub(float sx, float sy) {
		x -= sx;
		y -= sy;
		set(x, y);
		return this;
	}

	public vec2 sub(float s) {
		return sub(s, s);
	}

	public vec2 sub(vec v) {
		if (v != null) {
			return sub(v.x(), v.y());
		} else
			return null;
	}

	public vec2 sub(ivec v) {
		if (v != null) {
			return sub(v.x(), v.y());
		} else
			return null;
	}

	

	/**
	 * 
	 * @param v vec
	 * @return the dot product between this and the target vec
	 */
	public float dot(vec v) {
		if (v != null) {
			return x * v.x() + y * v.y();
		} else {
			System.out.println("Your Vec arg is " + null);
			return x * 0 + y * 0;
		}
	}

	public float dot(float x, float y) {
		return this.x() * x + this.y() * y;
	}

/**
 * 
 * @param pow 
 * @return this vec2 by the power of argument.
 */
	public vec2 pow(float pow) {
		this.pow(pow, pow);
		return this;
	}
  /**
   * return the power result of this vector
   * @param pow_x
   * @param pow_y
   * @return
   */
	public vec2 pow(float pow_x, float pow_y) {
		x = (float) Math.pow(x, pow_x);
		y = (float) Math.pow(y, pow_y);
		set(x, y);
		return this;
	}




/**
 * Normalize vector
 * @param target
 * @return
 */
	public vec2 normalize(vec2 target) {
		if (target == null) {
			target = new vec2();
		}
		float m = mag();
		if (m > 0) {
			target.set(x / m, y / m);
		} else {
			target.set(x, y);
		}
		return target;
	}

	public vec2 normalize() {
		float m = mag();
		if (m != 0 && m != 1) {
			div(m);
		}
		return this;
	}

	/**
	 * 
	 * @param minIn
	 * @param maxIn
	 * @param minOut
	 * @param maxOut
	 * @return Vec2
	 */
	public vec2 map(float minIn, float maxIn, float minOut, float maxOut) {
		x = map(x, minIn, maxIn, minOut, maxOut);
		y = map(y, minIn, maxIn, minOut, maxOut);
		set(x, y);
		return this;
	}
 /**
  * 
  * @param minIn
  * @param maxIn
  * @param minOut
  * @param maxOut
  * @return
  */
	public vec2 map(vec2 minIn, vec2 maxIn, vec2 minOut, vec2 maxOut) {
		x = map(x, minIn.x(), maxIn.x(), minOut.x(), maxOut.x());
		y = map(y, minIn.y(), maxIn.y(), minOut.y(), maxOut.y());
		set(x, y);
		return this;
	}


	/**
	 * JITTER
	 * 
	 * @param range int
	 * @return Vec2 altered with a random gaussian effect
	 */
	@Deprecated public vec2 jitter(int range) {
		return jitter(range, range);
	}

	@Deprecated public vec2 jitter(vec2 range) {
		if (range != null) {
			return jitter((int) range.x(), (int) range.y());
		} else {
			return jitter(0, 0);
		}
	}

	/**
	 * 
	 * @param range_x int
	 * @param range_y int
	 * @return Vec2 altered with a random gaussian effect
	 */
	@Deprecated public vec2 jitter(int range_x, int range_y) {
		x += random_next_gaussian(range_x, 3);
		y += random_next_gaussian(range_y, 3);
		set(x, y);
		return this;
	}

	/**
	 * random
	 * 
	 * @param max float
	 * @return random value from 0 to float max for each argument
	 */
	public vec2 rand(float max) {
		return rand(0,max);
	}

	/**
	 * random
	 * 
	 * @param min float
	 * @param max float
	 * @return random value from float min to float max for each argument
	 */
	public vec2 rand(float min, float max) {
		x = random(min, max);
		y = random(min, max);
		set(x, y);
		return this;
	}

	/**
	 * random
	 * 
	 * @param min
	 * @param max
	 * @return random value from vec min to vec max for each argument
	 */
	public vec2 rand(vec2 min, vec2 max) {
		x = random(min.x(), max.x());
		y = random(min.y(), max.y());
		set(x, y);
		return this;
	}



	/**
	 * 
	 * @param max
	 * @return
	 */
	public vec2 limit(float max) {
		if (magSq() > max * max) {
			normalize();
			mult(max);
		}
		return this;
	}




	public vec2 constrain(float min, float max) {
		return constrain(new vec2(min), new vec2(max));
	}

	public vec2 constrain(float max) {
		return constrain(new vec2(0), new vec2(max));
	}

	public vec2 constrain(vec2 max) {
		return constrain(new vec2(0), max);
	}
  
	/**
	 * Constrains a value to not exceed a maximum and minimum value. 
	 * @param min
	 * @param max
	 * @return
	 */
	public vec2 constrain(vec2 min, vec2 max) {
		if(x < min.x()) {
			x = min.x();
		}

		if(y < min.y()) {
			y = min.y();
		}

		if(x > max.x()) {
			x = max.x();
		}

		if(y > max.y()) {
			y = max.y();
		}
		set(x,y);
		return this;
	}



	/**
	 * WAVE
	 * 
	 * @param timeline int
	 * @param s     float speed for all vec arg
	 * @return vec2 cosinus of the value
	 */
	public vec2 wave(int timeline, float s) {
			return cos_wave(timeline, s, s);
	}

		/**
	 * 
	 * @param timeline
	 * @param sx
	 * @param sy
	 * @return
	 */
	public vec2 wave(int timeline, float sx, float sy) {
		return cos_wave(timeline, sx, sy);
	}

	/**
	 * 
	 * @param timeline int
	 * @param s     float speed for all vec arg
	 * @return vec2 cosinus of the value
	 */
	public vec2 cos_wave(int timeline, float s) {
		return cos_wave(timeline, s, s);
	}
	/**
	 * 
	 * @param timeline
	 * @param sx
	 * @param sy
	 * @return
	 */
	public vec2 cos_wave(int timeline, float sx, float sy) {
		float x = (float) Math.cos(timeline * sx);
		float y = (float) Math.cos(timeline * sy);
		set(x, y);
		return this;
	}

	/**
	 * 
	 * @param timeline int
	 * @param s     float speed for all vec arg
	 * @return vec2 sinus of the value
	 */
	public vec2 sin_wave(int timeline, float s) {
		return sin_wave(timeline, s, s);
	}

	public vec2 sin_wave(int timeline, float sx, float sy) {
		float x = (float) Math.sin(timeline * sx);
		float y = (float) Math.sin(timeline * sy);
		set(x, y);
		return this;
	}
	
	/**
	 * 
	 * @param mod_x
	 * @param mod_y
	 * @return return the modulo of each element in the same order
	 */
	public vec2 mod(float mod_x, float mod_y) {
		x = x%mod_x;
		y = y%mod_y;
		set(x,y);
		return this;
	}

	public vec2 mod(float mod) {
		return mod(mod,mod);
	}

	public vec2 mod(vec2 mod) {
		return mod(mod.x(), mod.y());
	}


















  /**
  * GET STUF
  */

	/**
	 * sum of all components
	 * @return float
	 */
	public float sum() {
		return x+y;
	}



	/**
	 * average of all componentsb
	 * @return float
	 */
	public float average() {
		return (this.x()+this.y())*0.5f;
	}


	/**
   * return distance of the vector or length
   * 
   * @return float
   */
  float dist() {
  	return dist(new vec2());
  }
  
/**
 * return distance of the vector or length
 * 
 * @param target
 * @return float
 */
	public float dist(vec target) {
		if (target != null) {
			float dx = x - target.x();
			float dy = y - target.y();
			return (float) Math.sqrt(dx * dx + dy * dy);
		} else {
			System.out.println("Your vec arg is " + null);
			return 0;
		}
	}

	/**
	 * return normal cartesian angle coord
	 * 
	 * @return vec2
	 */
	public vec2 dir() {
		return dir(new vec2(0, 0));
	}
  
  /**
   * return normal cartesian angle coord
   * 
   * @param a_x
   * @param a_y
   * @return vec2
   */
	public vec2 dir(float a_x, float a_y) {
		return dir(new vec2(a_x, a_y));
	}
  
	
	/**
	 * return normal cartesian angle coord
	 * 
	 * @param origin
	 * @return vec2
	 */
	public vec2 dir(vec2 origin) {
		vec2 temp = this.copy();
		if (origin != null) {
			float dist = dist(origin);
			temp.sub(origin);
			temp.div(dist);
		}
		return temp;
	}

	/**
	 * return tangent of the vector direction
	 * 
	 * @return vec2
	 */
	public vec2 tan() {
		return tan(new vec2(x, y));
	}
  
	/**
	 * return tangent of the vector direction
	 * 
	 * @param a_x
	 * @param a_y
	 * @return vec2
	 */
	public vec2 tan(float a_x, float a_y) {
		return tan(new vec2(a_x, a_y));
	}
  
	/**
	 * return tangent of the vector direction
	 * 
	 * @param target
	 * @return vec2
	 */
	public vec2 tan(vec2 target) {
		vec2 temp = this.copy();
		if (target != null) {
			float mag = mag();
			target.div(mag);
			temp.x = -target.y();
			temp.y = target.x();
		}
		return temp;
	}

	/**
	 * return heading angle
	 */
	/**
	 *
	 * Calculate the angle of rotation for this vector (only 2D vectors)
	 * @return the float angle of rotation
	 */
	public float angle() {
		float angle = (float) Math.atan2(y,x);
		return angle;
	}
	
	/**
	 * return heading angle
	 * @param target
	 * @return the float angle between this and the target vector
	 */
	public float angle(vec2 target) {
		double temp = Math.atan2(target.y()-this.y(),target.x()-this.x());
		return (float)temp;
	}

	/**
	 * Angle heading
	 */
	/**
	 *
	 * Calculate the angle of rotation for this vector (only 2D vectors)
	 * @return the float angle of rotation
	 */
	public float heading() {
		return angle();
	}

	

	/**
	 * return square of vec
	 * 
	 * @return float
	 */
	public float magSq() {
		return (x * x + y * y);
	}

	/**
	 * return square root of magnitude or length of vec2
	 * 
	 * @return float
	 */
	public float mag() {
		return (float) Math.sqrt(x * x + y * y);
	}

	/**
	 * return mag between this vector and the target
	 * 
	 * @param target
	 * @return float
	 */
	public float mag(vec target) {
		if (target != null) {
			float new_x = (target.x() - x) * (target.x() - x);
			float new_y = (target.y() - y) * (target.y() - y);
			return (float) Math.sqrt(new_x + new_y);
		} else {
			System.out.println("Your vec arg is " + null);
			return 0;
		}
	}

	



	

	

	/**
	 * return true if the vector this is equals to vector target
	 * @param target Vec2
	 * @return
	 */
	public boolean equals(vec2 target) {
		if (target != null) {
			if ((x == target.x()) && (y == target.y())) {
				return true;
			} else
				return false;
		} else
			return false;
	}

	/**
	 * return true if the vector this is equals to float target
	 * @param target float
	 * @return
	 */
	public boolean equals(float target) {
		if ((x == target) && (y == target))
			return true;
		else
			return false;
	}

	/**
	 * * return true if the vector this is equals to float arguments
	 * @param t_x float
	 * @param t_y float
	 * @return
	 */
	public boolean equals(float t_x, float t_y) {
		if ((x == t_x) && (y == t_y))
			return true;
		else
			return false;
	}
	
	
	
	/**
   * return true if the vector this and vector target are in the same vector area
   * @param target
   * @param area
   * @return
   */
  public boolean compare(vec2 target, vec2 area) {
    if(this != null && target != null && area != null ) {
      if(    (this.x() >= target.x() -area.x() && this.x() <= target.x() +area.x()) 
          && (this.y() >= target.y() -area.y() && this.y() <= target.y() +area.y())) { 
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
	 * @param target
	 * @param area
	 * @return
	 */
	public boolean compare(vec2 target, float area) {
		return compare(target, new vec2(area));
	}

	// detection
	/**

	*/

	/**
	* https://forum.processing.org/one/topic/how-do-i-find-if-a-point-is-inside-a-complex-polygon.html
	* http://paulbourke.net/geometry/
	* thks to Moggach and Paul Brook
	 * @param points array of point who define the polygon.
	 * @return true if the vec2 is in the polygon, false in the other case
	 */
	public boolean in_polygon(vec [] points) {
		int i, j;
		boolean is = false;
		int sides = points.length;
		for(i = 0, j = sides - 1 ; i < sides ; j = i++) {
			if (( ((points[i].y() <= this.y()) && (this.y() < points[j].y())) || ((points[j].y() <= this.y()) && (this.y() < points[i].y()))) &&
						(this.x() < (points[j].x() - points[i].x()) * (this.y() - points[i].y()) / (points[j].y() - points[i].y()) + points[i].x())) {
				is = !is;
			}
		}
		return is;
	}

	/**
	* https://forum.processing.org/two/discussion/90/point-and-line-intersection-detection
	* refactoring from Quark Algorithm
	*/
	public boolean in_line(vec2 start, vec2 end, float range) {
		vec2 vp = new vec2();
		vec2 line = end.copy().sub(start);
		// vec2 line = sub(end,start);
		float l2 = line.magSq();
		if (l2 == 0.0) {
			vp.set(start);
			return false;
		}
		vec2 pv0_line = this.copy().sub(start);
		float t = pv0_line.dot(line)/l2;
		pv0_line.normalize();
		vp.set(line);
		vp.mult(t);
		vp.add(start);
		float d = this.dist(vp);
		if (t >= 0 && t <= 1 && d <= range) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * copy() return all the component of vec
	 * 
	 * @return Vec2
	 */
	public vec2 copy() {
		return new vec2(x, y);
	}

	@Override
	public String toString() {
		return "[ " + x + ", " + y + " ]";
	}

}
