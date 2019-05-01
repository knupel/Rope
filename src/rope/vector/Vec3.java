/**
 * vec3 class
 * v 1.2.1
* 2015-2019
* Vector class with a float precision
 * @author @stanlepunk
 * @see http://stanlepunk.xyz/
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
  	this.x = this.s = x;
  	this.y = this.t = y;
  	this.z = this.p = z;
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
  
	public vec3 x(float x) {
		return set(x,this.y,this.z);
	}

	public vec3 y(float y) {
   return set(this.x,y,this.z);
	}

	public vec3 z(float z) {
   return set(this.x,this.y,z);
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
   * sum
   * @return float component sum
   */
  public float sum() {
    return x+y+z;
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
   * @param d_x
   * @param d_y
   * @param d_z
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
   * average
   * @return float average of the sum component
   */
  public float average() {
    return (this.x + this.y +this.z) *.333f;
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
   * 
   * @param pow
   * @return each component of the vec is power push
   */
  public vec3 pow(int pow) {
    this.pow(pow,pow,pow);
    return this;
  }
  public vec3 pow(int pow_x, int pow_y, int pow_z) {
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
   * @return
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
    } else return null ;
  }
  
  public vec3 cross(vec3 v) {
    if(v != null) {
      return cross(v, null);
    } else return null ;
    
  }
  
  public vec3 cross(float x, float y, float z) {
    vec3 v = new vec3(x,y,z) ;
    return cross(v, null);
  }
  
  /**
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
   * 
   * @param origin
   * @return
   */
  public vec3 dir(vec3 origin) {
    if(origin != null) {
      float dist = dist(origin) ;
      sub(origin) ;
      div(dist) ;
    }
    set(x,y,z) ;
    return this ;
  }
  
  public vec3 dir() {
    return dir(new vec3(0)) ;
  }
  
  public vec3 dir(float a_x, float a_y, float a_z) {
    return dir(new vec3(a_x,a_y,a_z)) ;
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
  
  public vec3 tan(float float_to_make_plane_ref_x, float float_to_make_plane_ref_y, float float_to_make_plane_ref_z) {
    return tan(new vec3(float_to_make_plane_ref_x, float_to_make_plane_ref_y, float_to_make_plane_ref_z)) ;
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
  float mag(vec3 v_target) {
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
    return this ;
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
    return rand(new vec2(0,max),new vec2(0,max),new vec2(0,max));
  }
  /**
   * random
   * @param min float
   * @param max float
   * @return
   */
  public vec3 rand(float min, float max) {
    return rand(new vec2(min,max),new vec2(min,max),new vec2(min,max));
  }
    /**
   * random
   * @param x vec2
   * @param y vec2
   * @param z vec2
   * @return
   */
  public vec3 rand(vec2 mx, vec2 my, vec2 mz) {
    x = random(mx.x,mx.y);
    y = random(my.x,my.y);
    z = random(mz.x,mz.y);
    set(x,y,z);
    return this;
  }





  /**
  * WAVE COSINUS
  * @param value int
  * @param s float speed for all vec arg
  * @param sx float speed for all vec arg x
  * @param sy float speed for all vec arg y
  * @param sz float speed for all vec arg z
  * @return vec3 cosinus of the value
  */
  public vec3 cos_wave(int value, float s) {
    return cos_wave(value,s,s,s);
  }

  public vec3 cos_wave(int value, float sx, float sy, float sz) {
    float x = (float)Math.cos(value *sx);
    float y = (float)Math.cos(value *sy);
    float z = (float)Math.cos(value *sz);
    set(x,y,z);
    return this;
  }

  /**
  * WAVE SINUS
  * @param value int
  * @param s float speed for all vec arg
  * @param sx float speed for all vec arg x
  * @param sy float speed for all vec arg y
  * @param sz float speed for all vec arg z
  * @return vec3 sinus of the value
  */
  public vec3 sin_wave(int value, float s) {
    return sin_wave(value,s,s,s);
  }

  public vec3 sin_wave(int value, float sx, float sy, float sz) {
    float x = (float)Math.sin(value *sx);
    float y = (float)Math.sin(value *sy);
    float z = (float)Math.sin(value *sz);
    set(x,y,z);
    return this;
  }





  
  
  /**
   * equals
   * @param target
   * @return true if the target is equals to vec, you can pass one argument to compare with all vec components 
   */
  public boolean equals(vec3 target) {
    if(target != null) {
      if((x == target.x) && (y == target.y) && (z == target.z)) {
        return true ; 
      } else return false ;
    } else return false ;
  }
  
  public boolean equals(float target) {
    if((x == target) && (y == target) && (z == target)) 
    return true ; 
    else return false ;
  }
  
  public boolean equals(float t_x,float t_y,float t_z) {
    if((x == t_x) && (y == t_y) && (z == t_z)) 
    return true ; 
    else return false ;
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
