package rope.vector;

import rope.core.BigBangRope;

/**
 * ivec2 class
 * v 1.0.0
* 2015-2019
* Processing 3.5.3
* Vector class with a float precision
 * @author Stan le Punk
 * @see http://stanlepunk.xyz/
 * @see https://github.com/StanLepunK/Rope
*/
public class ivec2 extends ivec {
	public ivec2() {
  	super(2);
  	set(0,0);
  }
  
  public ivec2(int v) {
  	super(2);
  	set(v,v);
  }
  
  public ivec2(int x, int y) {
    super(2);
    set(x,y);
  }

  public ivec2(ivec v) {
    super(2);
    set(v);
  }
  
  /**
   * set
   * @param x
   * @param y
   * @return
   */
  public ivec2 set(int x, int y) {
  	this.x = this.s = this.u = x;
  	this.y = this.t = this.v = y;
  	return this;
  }
  
  public ivec2 set(int arg){
    set(arg,arg);
    return this;
  }
  
  public ivec2 set(ivec v) {
    if(v == null) {
      this.x = this.y = 0;
      return this;
    } else if(v instanceof ivec5 || v instanceof ivec6) {
      set(v.a,v.b);
      return this;
    } else {
      set(v.x,v.y);
      return this;
    }
  }

  public ivec2 set(vec v) {
    if(v == null) {
      this.x = this.y = 0;
      return this;
    } else if(v instanceof vec5 || v instanceof vec6) {
      set((int)v.a,(int)v.b);
      return this;
    } else {
      set((int)v.x,(int)v.y);
      return this;
    }
  }
  
  // xy
  public ivec2 x(int x) {
    return set(x,this.y);
  }

  public ivec2 y(int y) {
    return set(this.x,y);
  }

  // st
  public ivec2 s(int x) {
    return set(x,this.y);
  }

  public ivec2 t(int y) {
    return set(this.x,y);
  }

  // uv
  public ivec2 u(int x) {
    return set(x,this.y);
  }

  public ivec2 v(int y) {
    return set(this.x,y);
  }
  
  
  /**
   * sum
   * @return
   */
  public int sum() {
    return x+y;
  }
  
  /**
   * mult
   * @param m_x
   * @param m_y
   * @return
   */
  public ivec2 mult(int m_x, int m_y) {
    x *= m_x; 
    y *= m_y; 
    set(x,y);
    return this;
  }

  public ivec2 mult(int m) {
    return mult(m,m);
  }

  public ivec2 mult(ivec v) {
    if(v != null) {
      return mult(v.x,v.y);
    } else return null;
  }
  
  
  /**
   * div
   * @param d_x
   * @param d_y
   * @return
   */
  public ivec2 div(int d_x, int d_y) {
    if(d_x != 0) x /= d_x; 
    if(d_y != 0) y /= d_y; 
    set(x,y);
    return this;
  }
  
  public ivec2 div(int d) {
    return div(d,d);
  }
  

  public ivec2 div(ivec v) {
    if(v != null) {
      return div(v.x,v.y);
    } else return null;
  }
  
  /**
   * add
   * @param a_x
   * @param a_y
   * @return
   */
  public ivec2 add(int a_x,int a_y) {
    x += a_x;
    y += a_y;
    set(x,y);
    return this;
  }

  public ivec2 add(int a) {
    return add(a,a);
  }


  public ivec2 add(ivec v) {
    if(v != null) {
      return add(v.x,v.y);
    } else return null;
  }
  
  /**
   * sub
   * @param a_x
   * @param a_y
   * @return
   */
  public ivec2 sub(int a_x,int a_y) {
    x -= a_x;
    y -= a_y;
    set(x,y);
    return this;
  }

  public ivec2 sub(int a) {
    return sub(a,a);
  }


  public ivec2 sub(ivec v) {
    if(v != null) {
      return sub(v.x,v.y);
    } else return null;
  }
  
  /**
   * equals
   * @param target
   * @return
   */
  public boolean equals(ivec2 target) {
    if(target != null ) {
      if((x == target.x) && (y == target.y)) {
        return true; 
      } else return false;
    } else return false;
  }

  public boolean equals(int target) {
    if((x == target) && (y == target)) 
    return true; 
    else return false;
  }
  
  public boolean equals(int tx, int ty) {
    if((x == tx) && (y == ty)) 
    return true; 
    else return false;
  }


    /**
   * random
   * @param max int
   * @return
   */
  public ivec2 rand(int max) {
    return rand(new ivec2(0,max),new ivec2(0,max));
  }
  /**
   * random
   * @param min int
   * @param max int
   * @return
   */
  public ivec2 rand(int min, int max) {
    return rand(new ivec2(min,max),new ivec2(min,max));
  }
    /**
   * random
   * @param x vec2
   * @param y vec2
   * @param z vec2
   * @return
   */
  public ivec2 rand(ivec2 mx, ivec2 my) {
    x = (int)random(mx.x,mx.y);
    y = (int)random(my.x,my.y);
    set(x,y);
    return this;
  }




  
  /**
   * copy
   * @return
   */
  public ivec2 copy() {
    return new ivec2(x,y) ;
  }
  
  @Override 
  public String toString() {
    return "[ " + x + ", " + y + " ]" ;
  }

}
