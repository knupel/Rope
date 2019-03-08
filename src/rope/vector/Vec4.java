/**
* vec4 class
* v 1.0.0
* 2015-2019
* Processing 3.5.3
* Vector class with a float precision
* @author Stan le Punk
* @see http://stanlepunk.xyz/
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
  
  
  /**
   * set vec
   * @param x
   * @param y
   * @param z
   * @param w
   * @return
   */
  public vec4 set(float x, float y, float z, float w) {
    this.x = this.r = this.s = x ;
    this.y = this.g = this.t = y ;
    this.z = this.b = this.p = z ;
    this.w = this.a = this.q = w ;
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
    }  else if(v instanceof vec5 || v instanceof vec6) {
      set(v.a,v.b,v.c,v.d);
      return this ;
    } else {
      set(v.x,v.y,v.z,v.w);
      return this ;
    }
  }

  public vec4 set(ivec v) {
    if ( v == null) {
      set(0,0,0,0);
      return this ;
    } else if(v instanceof ivec5 || v instanceof ivec6) {
      set(v.a,v.b,v.c,v.d);
      return this ;
    } else {
      set(v.x,v.y,v.z,v.w);
      return this ;
    }
  }
  
  public vec4 set(float[] source) {
    set(source[0],source[1],source[2],source[3]);
    return this ;
  }
  
  public vec4 x(float x) {
    return set(x,this.y,this.z,this.w);
  }

  public vec4 y(float y) {
    return set(this.x,y,this.z,this.w);
  }

  public vec4 z(float z) {
    return set(this.x,this.y,z,this.w);
  }

  public vec4 w(float w) {
    return set(this.x,this.y,this.z,w);
  }

  // rgba
  public vec4 r(float x) {
    return set(x,this.y,this.z,this.w);
  }

  public vec4 g(float y) {
    return set(this.x,y,this.z,this.w);
  }

  public vec4 b(float z) {
    return set(this.x,this.y,z,this.w);
  }

  public vec4 a(float w) {
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
   * sum
   * @return
   */
  public float sum() {
    return x+y+z+w;
  }
  
  /**
   * mult
   * @param m_x
   * @param m_y
   * @param m_z
   * @param m_w
   * @return
   */
  public vec4 mult(float m_x, float m_y, float m_z, float m_w) {
    x *= m_x ; 
    y *= m_y ; 
    z *= m_z ; 
    w *= m_w ;
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
   * @param d_x
   * @param d_y
   * @param d_z
   * @param d_w
   * @return
   */
  public vec4 div(float d_x, float d_y, float d_z, float d_w) {
    if(d_x != 0) x /= d_x; 
    if(d_y != 0) y /= d_y; 
    if(d_z != 0) z /= d_z; 
    if(d_w != 0) w /= d_w;
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
   * @param a_x
   * @param a_y
   * @param a_z
   * @param a_w
   * @return
   */
  public vec4 add(float a_x,float a_y,float a_z,float a_w) {
    x += a_x;
    y += a_y;
    z += a_z;
    w += a_w;
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
   * @param a_x
   * @param a_y
   * @param a_z
   * @param a_w
   * @return
   */
  public vec4 sub(float a_x,float a_y,float a_z, float a_w) {
    x -= a_x;
    y -= a_y;
    z -= a_z;
    w -= a_w; 
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
   * average
   * @return float average of sum components
   */
  public float average() {
    return (this.x + this.y +this.z +this.w) *.25f;
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
   * 
   * @param v_target
   * @return
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
   * direction normal
   * @return
   */
  public vec4 dir() {
    return dir(new vec4(0)) ;
  }
  public vec4 dir(float a_x, float a_y, float a_z, float a_w) {
    return dir(new vec4(a_x,a_y,a_z,a_w));
  }
  
  public vec4 dir(vec4 origin) {
    if(origin != null) {
      float dist = dist(origin);
      sub(origin);
      div(dist);
    }
    set(x,y,z,w);
    return this;
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
   * @param minIn
   * @param maxIn
   * @param minOut
   * @param maxOut
   * @return Vec4 where each target is Vec component
   */
  public vec4 map(float minIn, float maxIn, float minOut, float maxOut) {
    x = map(x,minIn,maxIn,minOut,maxOut);
    y = map(y,minIn,maxIn,minOut,maxOut);
    z = map(z,minIn,maxIn,minOut,maxOut);
    w = map(w,minIn,maxIn,minOut,maxOut);
    set(x,y,z,w);
    return this;
  }

  public vec4 map(vec4 minIn, vec4 maxIn, vec4 minOut, vec4 maxOut) {
    x = map(x,minIn.x,maxIn.x,minOut.x,maxOut.x);
    y = map(y,minIn.y,maxIn.y,minOut.y,maxOut.y);   
    z = map(z,minIn.z,maxIn.z,minOut.z,maxOut.z);   
    w = map(w,minIn.w,maxIn.w,minOut.w,maxOut.w);
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
    return rand(new vec2(0,max),new vec2(0,max),new vec2(0,max),new vec2(0,max));
  }
  /**
   * random
   * @param min float
   * @param max float
   * @return
   */
  public vec4 rand(float min, float max) {
    return rand(new vec2(min,max),new vec2(min,max),new vec2(min,max),new vec2(min,max));
  }
    /**
   * random
   * @param x vec2
   * @param y vec2
   * @param z vec2
   * @param w vec2
   * @return
   */
  public vec4 rand(vec2 mx, vec2 my, vec2 mz, vec2 mw) {
    x = random(mx.x,mx.y);
    y = random(my.x,my.y);
    z = random(mz.x,mz.y);
    w = random(mw.x,mw.y);
    set(x,y,z,w);
    return this;
  }








  /**
  * WAVE COSINUS
  * @param value int
  * @param s float speed for all vec arg
  * @param sx float speed for all vec arg x
  * @param sy float speed for all vec arg y
  * @param sz float speed for all vec arg z
  * @param sw float speed for all vec arg w
  * @return vec4 cosinus of the value
  */
  public vec4 cos_wave(int value, float s) {
    return cos_wave(value,s,s,s,s);
  }

  public vec4 cos_wave(int value, float sx, float sy, float sz, float sw) {
    float x = (float)Math.cos(value *sx);
    float y = (float)Math.cos(value *sy);
    float z = (float)Math.cos(value *sz);
    float w = (float)Math.cos(value *sw);
    set(x,y,z,w);
    return this;
  }

  /**
  * WAVE SINUS
  * @param value int
  * @param s float speed for all vec arg
  * @param sx float speed for all vec arg x
  * @param sy float speed for all vec arg y
  * @param sz float speed for all vec arg z
  * @param sw float speed for all vec arg w
  * @return vec4 sinus of the value
  */
  public vec4 sin_wave(int value, float s) {
    return sin_wave(value,s,s,s,s);
  }

  public vec4 sin_wave(int value, float sx, float sy, float sz, float sw) {
    float x = (float)Math.sin(value *sx);
    float y = (float)Math.sin(value *sy);
    float z = (float)Math.sin(value *sz);
    float w = (float)Math.sin(value *sw);
    set(x,y,z,w);
    return this;
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
  
  public boolean equals(float target) {
    if((x == target) && (y == target) && (z == target) && (w == target)) 
    return true; 
    else return false;
  }
  
  public boolean equals(float t_x,float t_y,float t_z,float t_w) {
    if((x == t_x) && (y == t_y) && (z == t_z)&& (w == t_w)) 
    return true; 
    else return false;
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
