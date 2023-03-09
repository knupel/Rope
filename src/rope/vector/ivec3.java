/**
* ivec3 class
* v 1.6.0
* 2015-2023
* Vector class with a int precision
* @author @knupel
* @see https://github.com/knupel/Rope
*/
package rope.vector;
public class ivec3 extends ivec {
	public ivec3() {
  	super(3);
  	set(0,0,0);
  }
  
  public ivec3(int v) {
  	super(3);
  	set(v,v,v);
  }
  
  public ivec3(int x, int y, int z) {
    super(3);
    set(x,y,z);
  }

  public ivec3(ivec v) {
    super(3);
    set(v);
  }

  public ivec3(int [] source) {
    super(3);
    set(source); 
  }
  
  /**
   * set
   * @param x
   * @param y
   * @param z
   * @return
   */
  public ivec3 set(int x, int y, int z) {
  	this.x = x;
  	this.y = y;
  	this.z = z;
  	return this;
  }
  
  public ivec3 set(int arg){
    set(arg,arg,arg);
    return this;
  }

  public ivec3 set(ivec v) {
    if(v == null) {
      this.x = this.y = this.z = 0;
    } else {
      set(v.x,v.y,v.z);
    }
  	return this;
  }

  public ivec3 set(vec v) {
    if(v == null) {
      this.x = this.y = this.z = 0;
    } else {
      set((int)v.x,(int)v.y,(int)v.z);
    }
  	return this;
  }
  
  public ivec3 set(int[] source) {
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
  
  public ivec3 set_to(int index, int arg) {
  	if(index == 0) x(arg);
  	if(index == 1) y(arg);
  	if(index == 2) z(arg);
  	return this;
  }


  	/**
	 * 
	 * @return inverse all argument
	 */
	public ivec3 inv() {
		inv_impl();
		return this;
	}


  // xyz
  public ivec3 x(int x) {
    return set(x,this.y,this.z);
  }

  public ivec3 add_x(int x) {
		this.x += x;
		return set(this.x,this.y,this.z);
	}
	
	public ivec3 sub_x(int x) {
		this.x -= x;
		return set(this.x,this.y,this.z);
	}
	
	public ivec3 mult_x(int x) {
		this.x *= x;
		return set(this.x,this.y,this.z);
	}
	
	public ivec3 div_x(int x) {
		this.x /= x;
		return set(this.x,this.y,this.z);
	}


  public ivec3 y(int y) {
    return set(this.x,y,this.z);
  }

  public ivec3 add_y(int y) {
		this.y += y;
		return set(this.x,this.y,this.z);
	}
	
	public ivec3 sub_y(int y) {
		this.y -= y;
		return set(this.x,this.y,this.z);
	}
	
	public ivec3 mult_y(int y) {
		this.y *= y;
		return set(this.x,this.y,this.z);
	}
	
	public ivec3 div_y(int y) {
		this.y /= y;
		return set(this.x,this.y,this.z);
	}

  public ivec3 z(int z) {
    return set(this.x,this.y,z);
  }

  public ivec3 add_z(int z) {
		this.z += z;
		return set(this.x,this.y,this.z);
	}
	
	public ivec3 sub_z(int z) {
		this.z -= z;
		return set(this.x,this.y,this.z);
	}
	
	public ivec3 mult_z(int z) {
		this.z *= z;
		return set(this.x,this.y,this.z);
	}
	
	public ivec3 div_z(int z) {
		this.z /= z;
		return set(this.x,this.y,this.z);
	}

  // rgb
  public ivec3 red(int x) {
    return set(x,this.y,this.z);
  }

  public ivec3 gre(int y) {
    return set(this.x,y,this.z);
  }

  public ivec3 blu(int z) {
    return set(this.x,this.y,z);
  }

  // hsb
  public ivec3 hue(int x) {
    return set(x,this.y,this.z);
  }

  public ivec3 sat(int y) {
    return set(this.x,y,this.z);
  }

  public ivec3 bri(int z) {
    return set(this.x,this.y,z);
  }

  // stp
  public ivec3 s(int x) {
    return set(x,this.y,this.z);
  }

  public ivec3 t(int y) {
    return set(this.x,y,this.z);
  }

  public ivec3 p(int z) {
    return set(this.x,this.y,z);
  }
  
  /**
   * sum
   * @return
   */
  public int sum() {
    return x+y+z;
  }
  
  
  /**
   * mult
   * @param mx
   * @param my
   * @param mz
   * @return
   */
  public ivec3 mult(int mx, int my, int mz) {
    x *= mx; 
    y *= my; 
    z *= mz;
    set(x,y,z) ;
    return this ;
  }

  public ivec3 mult(int m) {
    return mult(m,m,m);
  }

  public ivec3 mult(ivec v) {
    if(v != null) {
      return mult(v.x,v.y,v.z);
    } else return null ;
  }
  
  /**
   * div
   * @param dx
   * @param dy
   * @param dz
   * @return
   */
  public ivec3 div(int dx, int dy, int dz) {
    if(dx != 0) x /= dx; 
    if(dy != 0) y /= dy; 
    if(dz != 0) z /= dz; 
    set(x,y,z);
    return this;
  }
  
  public ivec3 div(int d) {
    return div(d,d,d);
  }
  
  public ivec3 div(ivec v) {
    if(v != null) {
      return div(v.x,v.y,v.z);
    } else return null;
  }
  
  /**
   * add
   * @param ax
   * @param ay
   * @param az
   * @return
   */
  public ivec3 add(int ax,int ay,int az) {
    x += ax;
    y += ay;
    z += az;
    set(x,y,z);
    return this;
  }

  public ivec3 add(int a) {
    return add(a,a,a);
  }

  public ivec3 add(ivec v) {
    if(v != null) {
      return add(v.x,v.y,v.z);
    } else return null;
  }
  
  /**
   * sub
   * @param sx
   * @param sy
   * @param sz
   * @return
   */
  public ivec3 sub(int sx,int sy,int sz) {
    x -= sx;
    y -= sy;
    z -= sz;
    set(x,y,z);
    return this;
  }

  public ivec3 sub(int a) {
    return sub(a,a,a);
  }

  public ivec3 sub(ivec v) {
    if(v != null) {
      return sub(v.x,v.y,v.z);
    } else return null;
  }


  	/**
	* @return the absolute value of the vector
	*/
	public ivec3 abs() {
		x = (int)Math.abs(x);
		y = (int)Math.abs(y);
		z = (int)Math.abs(z);
		set(x,y,z);
		return this;
	}
  
  
  

	public ivec3 constrain(int min, int max) {
		return constrain(new ivec3(min), new ivec3(max));
	}

  public ivec3 constrain(int max) {
		return constrain(new ivec3(0), new ivec3(max));
	}

	public ivec3 constrain(ivec3 max) {
		return constrain(new ivec3(0), max);
	}
  
	/**
	 * Constrains a value to not exceed a maximum and minimum value. 
	 * @param min
	 * @param max
	 * @return
	 */
	public ivec3 constrain(ivec3 min, ivec3 max) {
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
   * random
   * @param max int
   * @return random value from 0 to int max for each argument
   */
  public ivec3 rand(int max) {
    return rand(0,max);
  }
  /**
   * random
   * @param min int
   * @param max int
   * @return random value from int min to int max for each argument
   */
  public ivec3 rand(int min, int max) {
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
   * @return random value from ivec min to ivec max for each argument
   */
  public ivec3 rand(ivec3 min, ivec3 max) {
    x = random(min.x(),max.x());
    y = random(min.y(),max.y());
    z = random(min.z(),max.z());
    set(x,y,z);
    return this;
  }

  
  
  /**
   * equals
   * @param target
   * @return
   */
  public boolean equals(ivec3 target) {
    if(target != null ) {
      if((x == target.x) && (y == target.y) && (z == target.z)) {
        return true; 
      } else return false;
    } else return false;
  }

  public boolean equals(int target) {
    if((x == target) && (y == target) && (z == target)) 
    return true; 
    else return false;
  }
  
  public boolean equals(int tx, int ty, int tz) {
    if((x == tx) && (y == ty) && (z == tz)) 
    return true; 
    else return false;
  }



  	/**
	 * return true if the vector this and vector target are in the same vector area
	 * @param target
	 * @param area
	 * @return
	 */
	public boolean compare(ivec3 target, ivec3 area) {
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
	 * @param target
	 * @param area
	 * @return
	 */
	public boolean compare(ivec3 target, int area) {
		return compare(target, new ivec3(area));
	}








  
  /**
   * copy
   * @return
   */
  public ivec3 copy() {
    return new ivec3(x,y,z) ;
  }
  
  
  @Override 
  public String toString() {
    return "[ " + x + ", " + y + ", " + z + " ]" ;
  }
}
