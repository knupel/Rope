/**
* ivec4 class
* v 1.0.0
* 2015-2019
* Processing 3.5.3
* Vector class with a float precision
* @author Stan le Punk
* @see http://stanlepunk.xyz/
* @see https://github.com/StanLepunK/Rope
*/
package rope.vector;
public class ivec4 extends ivec {
  public ivec4() {
  	super(4);
  	set(0,0,0,0);
  }
  
  public ivec4(int v) {
  	super(4);
  	set(v,v,v,v);
  }
  
  public ivec4(int x, int y, int z, int w) {
    super(4);
    set(x,y,z,w);
  }

  public ivec4(ivec v) {
    super(4);
    set(v);
  }
  
  
  /**
   * set
   * @param x
   * @param y
   * @param z
   * @param w
   * @return
   */
  public ivec4 set(int x, int y, int z, int w) {
  	this.x = this.r = this.s = x;
  	this.y = this.g = this.t = y;
  	this.z = this.b = this.p = z;
  	this.w = this.a = this.q = w;
  	return this;
  }
  
  public ivec4 set(int arg){
    set(arg,arg,arg,arg);
    return this;
  }

  public ivec4 set(ivec v) {
    if(v == null) {
      this.x  = this.y = this.z = this.w = 0 ;
      return this;
    } else if(v instanceof ivec5 || v instanceof ivec6) {
      set(v.a,v.b,v.c,v.d);
      return this;
    } else {
      set(v.x,v.y,v.z,v.w);
      return this;
    }
  }

  public ivec4 set(vec v) {
    if(v == null) {
      this.x  = this.y = this.z = this.w = 0 ;
      return this;
    } else if(v instanceof vec5 || v instanceof vec6) {
      set((int)v.a,(int)v.b,(int)v.c,(int)v.d);
      return this;
    } else {
      set((int)v.x,(int)v.y,(int)v.z,(int)v.w);
      return this;
    }
  }

  // xyzw
  public ivec4 x(int x) {
    return set(x,this.y,this.z,this.w);
  }

  public ivec4 y(int y) {
    return set(this.x,y,this.z,this.w);
  }

  public ivec4 z(int z) {
    return set(this.x,this.y,z,this.w);
  }

  public ivec4 w(int w) {
    return set(this.x,this.y,this.z,w);
  }

  // rgba
  public ivec4 r(int x) {
    return set(x,this.y,this.z,this.w);
  }

  public ivec4 g(int y) {
    return set(this.x,y,this.z,this.w);
  }

  public ivec4 b(int z) {
    return set(this.x,this.y,z,this.w);
  }

  public ivec4 a(int w) {
    return set(this.x,this.y,this.z,w);
  }

  // stpq
  public ivec4 s(int x) {
    return set(x,this.y,this.z,this.w);
  }

  public ivec4 t(int y) {
    return set(this.x,y,this.z,this.w);
  }

  public ivec4 p(int z) {
    return set(this.x,this.y,z,this.w);
  }

  public ivec4 q(int w) {
    return set(this.x,this.y,this.z,w);
  }
  
  /**
   * sum
   * @return
   */
  public int sum() {
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
  public ivec4 mult(int m_x, int m_y, int m_z, int m_w) {
    x *= m_x ; y *= m_y ; z *= m_z ; w *= m_w ;
    set(x,y,z,w) ;
    return this ;
  }

  public ivec4 mult(int m) {
    return mult(m,m,m,m);
  }

  public ivec4 mult(ivec v) {
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
  public ivec4 div(int d_x, int d_y, int d_z, int d_w) {
    if(d_x != 0) x /= d_x; 
    if(d_y != 0) y /= d_y; 
    if(d_z != 0) z /= d_z; 
    if(d_w != 0) w /= d_w;
    set(x,y,z,w);
    return this;
  }
  
  public ivec4 div(int d) {
    return div(d,d,d,d);
  }
  
  public ivec4 div(ivec v) {
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
  public ivec4 add(int a_x,int a_y,int a_z,int a_w) {
    x += a_x;
    y += a_y;
    z += a_z;
    w += a_w;
    set(x,y,z,w);
    return this;
  }

  public ivec4 add(int a) {
    return add(a,a,a,a);
  }

  public ivec4 add(ivec v) {
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
  public ivec4 sub(int a_x,int a_y,int a_z, int a_w) {
    x -= a_x;
    y -= a_y;
    z -= a_z;
    w -= a_w; 
    set(x,y,z,w);
    return this;
  }

  public ivec4 sub(int a) {
    return sub(a,a,a,a);
  }

  public ivec4 sub(ivec v) {
    if(v != null) {
      return sub(v.x,v.y,v.z,v.w);
    } else return null;
  }
  
  
  /**
   * equals
   * @param target
   * @return
   */
  public boolean equals(ivec4 target) {
    if(target != null ) {
      if((x == target.x) && (y == target.y) && (z == target.z) && (w == target.w)) {
        return true; 
      } else return false;
    } else return false;
  }

  public boolean equals(int target) {
    if((x == target) && (y == target) && (z == target) && (w == target)) 
    return true; 
    else return false;
  }
  
  public boolean equals(int tx, int ty, int tz, int tw) {
    if((x == tx) && (y == ty) && (z == tz) && (w == tw)) 
    return true; 
    else return false;
  }



  /**
   * random
   * @param max int
   * @return
   */
  public ivec4 rand(int max) {
    return rand(new ivec2(0,max),new ivec2(0,max),new ivec2(0,max),new ivec2(0,max));
  }
  /**
   * random
   * @param min int
   * @param max int
   * @return
   */
  public ivec4 rand(int min, int max) {
    return rand(new ivec2(min,max),new ivec2(min,max),new ivec2(min,max),new ivec2(min,max));
  }
    /**
   * random
   * @param x vec2
   * @param y vec2
   * @param z vec2
   * @param w vec2
   * @return
   */
  public ivec4 rand(ivec2 mx, ivec2 my, ivec2 mz, ivec2 mw) {
    x = (int)random(mx.x,mx.y);
    y = (int)random(my.x,my.y);
    z = (int)random(mz.x,mz.y);
    w = (int)random(mw.x,mw.y);
    set(x,y,z,w);
    return this;
  }

  
  /**
   * copy
   * @return
   */
  public ivec4 copy() {
    return new ivec4(x,y,z,w) ;
  }
  
  
  @Override 
  public String toString() {
    return "[ " + x + ", " + y + ", " + z + ", " + w + " ]" ;
  }

}
