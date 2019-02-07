package rope.vector;
/**
* Vec2
* v 1.0.0
* 2015-2018
* Processing 3.4 compatible
* Vector class with a float precision
* @author Stan le Punk
* @see http://stanlepunk.xyz/
* @see https://github.com/StanLepunK/Rope
*/

public class vec2 extends vec {
  public vec2() {
  	super(2);
  	set(0,0);
  }
  
  public vec2(float v) {
  	super(2);
  	set(v,v);
  }
  
  public vec2(float x, float y) {
    super(2);
    set(x,y);
  }

  private String warning = "Contructor class Vec2() cannot use the String key_random: ";
  public vec2(String key_random, float r1) {
    super(2) ;
    if(key_random.equals(RANDOM)) {
      set(random(-r1,r1),random(-r1,r1));
    } else if(key_random.equals(RANDOM_ZERO)) {
      set(random(0,r1),random(0,r1));
    } else {
      this.x = this.y = this.s = this.t = this.u = this.v = 0;
      System.err.println(warning+key_random);
    }
  }
  
  public vec2(String key_random, float r1, float r2) {
    super(2) ;
    if(key_random.equals(RANDOM)) {
      set(random(-r1,r1),random(-r2,r2));
    } else if(key_random.equals(RANDOM_ZERO)) {
      set(random(0,r1),random(0,r2));
    } else if(key_random.equals(RANDOM_RANGE)) {
      set(random(r1,r2),random(r1,r2));
    } else {
      this.x = this.y = this.s = this.t = this.u = this.v = 0;
      System.err.println(warning+key_random);
    }
  }

  public vec2(String key_random, float a1, float a2, float b1, float b2) {
    super(2) ;
    if(key_random.equals(RANDOM_RANGE)) {
      set(random(a1,a2),random(b1,b2));
    } else {
      this.x = this.y = this.s = this.t = this.u = this.v = 0;
      System.err.println(warning+key_random);
    }
  }

  /**
   * 
   * @param x
   * @param y
   * @return
   */
  public vec2 set(float x, float y) {
    this.x = this.s = this.u = x;
    this.y = this.t = this.v = y;
    return this;
  }
  
  public vec2 set(float v) {
    set(v,v);
    return this;
  }

  public vec2 set(vec v) {
    if(v == null) {
      set(0,0);
      return this;
    } else if(v instanceof vec5 || v instanceof vec6) {
      set(v.a,v.b);
      return this;
    } else {
      set(v.x,v.y);
      return this;
    }
  }

  public vec2 set(ivec v) {
    if(v == null) {
      set(0,0);
      return this;
    } else if(v instanceof ivec5 || v instanceof ivec6) {
      set(v.a,v.b);
      return this;
    } else {
      set(v.x,v.y);
      return this;
    }
  }


  public vec2 set(float[] source) {
    set(source[0],source[1]);
    return this;
  }

  // xy
  public vec2 set_x(float x) {
    return set(x,this.y);
  }

  public vec2 set_y(float y) {
    return set(this.x,y);
  }

  // st
  public vec2 set_s(float x) {
    return set(x,this.y);
  }

  public vec2 set_t(float y) {
    return set(this.x,y);
  }

  // uv
  public vec2 set_u(float x) {
    return set(x,this.y);
  }

  public vec2 set_v(float y) {
    return set(this.x,y);
  }
  



  /**
  sum
  */
  /**
  * sum return the sum of all components
  * @return float
  */
  public float sum() {
    return x+y;
  } 
   
  /**
  multiplication
  */
  /**
  * multiply Vector by different float value 
  */
  public vec2 mult(float m_x, float m_y) {
    x *= m_x ; 
    y *= m_y ;
    set(x,y) ;
    return this;
  }

  public vec2 mult(float m) {
    return mult(m,m);
  }

  public vec2 mult(vec v) {
    if(v != null) {
      return mult(v.x,v.y);
    } else return null ;
  }

  public vec2 mult(ivec v) {
    if(v != null) {
      return mult(v.x,v.y);
    } else return null ;
  }
  

  
  /**
  division
  */
  /**
  * divide Vector by a float value 
  */
  public vec2 div(float d_x, float d_y) {
    if(d_x != 0) x /= d_x; 
    if(d_y != 0) y /= d_y; 
    set(x,y) ;
    return this;   
  }

  public vec2 div(float d) {
    return div(d,d);
  }

  public vec2 div(vec v) {
    if(v != null) {
      return div(v.x,v.y);
    } else return null ;
  }

  public vec2 div(ivec v) {
    if(v != null) {
      return div(v.x,v.y);
    } else return null ;
  }
  
  
  /** 
  Addition
  */
  /** 
  * add float value 
  */
  public vec2 add(float a_a, float a_b) {
    x += a_a ;
    y += a_b ; 
    set(x,y) ;
    return this ;
  }

  public vec2 add(float a) {
    return add(a,a);
  }

  public vec2 add(vec v) {
    if(v != null) {
      return add(v.x,v.y);
    } else return null ;
  }

  public vec2 add(ivec v) {
    if(v != null) {
      return add(v.x,v.y);
    } else return null ;
  }





  /**
  Substraction
  */
  /* add float value */
  public vec2 sub(float s_a,float s_b) {
    x -= s_a;
    y -= s_b; 
    set(x,y);
    return this ;
  }

  public vec2 sub(float s) {
    return sub(s,s);
  }

  public vec2 sub(vec v) {
    if(v != null) {
      return sub(v.x,v.y);
    } else return null;
  }

  public vec2 sub(ivec v) {
    if(v != null) {
      return sub(v.x,v.y);
    } else return null;
  }
  


  /**
  Average
  */
  public float average() {
    return (this.x +this.y) *(float).5;
  }


  /**
  Dot
  v 0.0.1.1
  */
  public float dot(vec v) {
    if(v != null) {
      return x*v.x + y*v.y;
    } else {
      System.out.println("Your Vec arg is "+null);
      return x*0 + y*0;
    }
  }
  public float dot(float x, float y) {
    return this.x*x + this.y*y;
  }



  /**
  POW
  */
  public vec2 pow(int pow) {
    this.pow(pow,pow);
    return this;
  }
  public vec2 pow(int pow_x, int pow_y) {
    x = (float)Math.pow(x,pow_x);
    y = (float)Math.pow(y,pow_y);
    set(x,y);
    return this;
  }

  
  
  /**
  Direction
  */
  /**
  * return mapping vector
  * @return Vec2
  */
  public vec2 dir() {
    return dir(new vec2(0,0));
  }
  public vec2 dir(float a_x, float a_y) {
    return dir(new vec2(a_x,a_y));
  }
  public vec2 dir(vec2 origin) {
    if(origin != null) {
      float dist = dist(origin);
      sub(origin);
      div(dist);
    }
    set(x,y);
    return this;
  }


  /**
  Tangent
  */
  public vec2 tan() {
    return tan(new vec2(x,y));
  }
  public vec2 tan(float a_x, float a_y) {
    return tan(new vec2(a_x,a_y)) ;
  }

  public vec2 tan(vec2 target) {
    if(target != null) {
      float mag = mag() ;
      target.div(mag);
      x = -target.y;
      y = target.x;
    }
    set(x,y);
    return this;
  }

  /**
  Angle
  Heading for PVector 
  */
  /**
  *
  * Calculate the angle of rotation for this vector (only 2D vectors)
  *
  * @webref vec:method
  * @usage web_application
  * @return the angle of rotation
  * @brief Calculate the angle of rotation for this vector
  */
  public float angle() {
    float angle = (float)Math.atan2(y, x);
    return angle;
  }
  /**
  * heading is a similar method of PVector
  */
  public float heading() {
    return angle();
  }
  

  /**
  Min Max
  */
  /**
  * find the min and the max value in the vector list
  * @return float
  */
  public float max_vec() {
    float [] list = {x,y};
    return max(list);
  }
  public float min_vec() {
    float [] list = {x,y};
    return min(list);
  }

  /**
  Normalize
  */
  public vec2 normalize(vec2 target) {
    if (target == null) {
      target = new vec2();
    }
    float m = mag();
    if (m > 0) {
      target.set(x/m, y/m);
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
    return this ;
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
    x = map(x,minIn, maxIn, minOut, maxOut);
    y = map(y,minIn, maxIn, minOut, maxOut);  
    set(x,y) ;
    return this ;
  }

  public vec2 map(vec2 minIn, vec2 maxIn, vec2 minOut, vec2 maxOut) {
    x = map(x,minIn.x, maxIn.x, minOut.x, maxOut.x);
    y = map(y,minIn.y, maxIn.y, minOut.y, maxOut.y);   
    set(x,y) ;
    return this ;
  }
  

  /**
  * magnitude or length of Vec2
  * @return float
  */
  public float magSq() {
    return (x*x + y*y);
  }

  /**
   * 
   * @return float
   */
  public float mag() {
    return (float) Math.sqrt(x*x + y*y) ;
  }
  /**
   * 
   * @param v_target
   * @return float
   */
  public float mag(vec target) {
    if(target != null) {
      float new_x = (target.x -x) *(target.x -x);
      float new_y = (target.y -y) *(target.y -y);
      return (float)Math.sqrt(new_x +new_y) ;
    } else {
      System.out.println("Your Vec arg is "+ null);
      return 0 ;
    }
  }


  /**
   * 
   * @param max
   * @return
   */
  public vec2 limit(float max) {
    if (magSq() > max*max) {
      normalize();
      mult(max);
    }
    return this;
  }
  
  

  /** 
   * DIST
   * @param target
   * distance between himself and an other vector
   * @return float distance between the Vec and the target
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
  * JITTER
	* @param range int
	* @return Vec2 altered with a random gaussian effect
	*/
  public vec2 jitter(int range) {
    return jitter(range,range);
  }
  public vec2 jitter(vec2 range) {
    if(range != null) {
      return jitter((int)range.x,(int)range.y) ;
    } else {
      return jitter(0,0);
    }
    
  }
  /** 
   * 
   * @param range_x int
   * @param range_y int
   * @return Vec2 altered with a random gaussian effect
   */
  public vec2 jitter(int range_x, int range_y) {
    x += random_next_gaussian(range_x,3);
    y += random_next_gaussian(range_y,3);
    set(x,y);
    return this;
  }


  /**
  * WAVE COSINUS
  * @param value int
  * @param s float speed for all vec arg
  * @param sx float speed for all vec arg x
  * @param sy float speed for all vec arg y
  * @return vec2 cosinus of the value
  */
  public vec2 wave_cos(int value, float s) {
    return wave_cos(value,s,s);
  }


  public vec2 wave_cos(int value, float sx, float sy) {
    float x = (float)Math.cos(value *sx);
    float y = (float)Math.cos(value *sy);
    set(x,y);
    return this;
  }

  /**
  * WAVE SINUS
  * @param value int
  * @param s float speed for all vec arg
  * @param sx float speed for all vec arg x
  * @param sy float speed for all vec arg y
  * @return vec2 sinus of the value
  */
  public vec2 wave_sin(int value, float s) {
    return wave_sin(value,s,s);
  }


  public vec2 wave_sin(int value, float sx, float sy) {
    float x = (float)Math.sin(value *sx);
    float y = (float)Math.sin(value *sy);
    set(x,y);
    return this;
  }
  
  


  /**
   * 
   * @param target Vec2
   * @return true if Vec is equals
   */
  public boolean equals(vec2 target) {
    if(target != null ) {
      if((x == target.x) && (y == target.y)) {
        return true; 
      } else return false;
    } else return false;
  }
  /**
   * 
   * @param target float
   * @return true if float param is equals to all component of vec
   */
  public boolean equals(float target) {
    if((x == target) && (y == target)) 
    return true; 
    else return false;
  }
  /**
   * 
   * @param t_x float
   * @param t_y float
   * @return true if float param t_x and t_y is equals to all component of vec
   */
  public boolean equals(float t_x,float t_y) {
    if((x == t_x) && (y == t_y)) 
    return true; 
    else return false;
  }


  
  /**
  * copy()
  * return all the component of vec
  * @return Vec2
  */
  public vec2 copy() {
    return new vec2(x,y);
  }



  @Override 
  public String toString() {
    return "[ " + x + ", " + y + " ]";
  }

}
