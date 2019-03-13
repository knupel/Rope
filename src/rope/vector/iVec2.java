/**
* ivec2 class
* v 1.2.0
* 2015-2019
* Vector class with a float precision
* @author @stanlepunk
* @see http://stanlepunk.xyz/
* @see https://github.com/StanLepunK/Rope
*/
package rope.vector;
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

  public ivec2(int [] source) {
    super(2);
    set(source); 
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
    } else {
      set(v.x,v.y);
    }
  	return this;
  }

  public ivec2 set(vec v) {
    if(v == null) {
      this.x = this.y = 0;
    } else {
      set((int)v.x,(int)v.y);
    }
  	return this;
  }
  
  public ivec2 set(int[] source) {
    if(source.length == 1) {
      set(source[0],this.y);
    } else if(source.length == 2) {
      set(source[0],source[1]);
    } else if(source.length > 2) {
      set(source[0],source[1]);
    }
    return this;
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
   * @param mx
   * @param my
   * @return
   */
  public ivec2 mult(int mx, int my) {
    x *= mx; 
    y *= my; 
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
   * @param dx
   * @param dy
   * @return
   */
  public ivec2 div(int dx, int dy) {
    if(dx != 0) x /= dx; 
    if(dy != 0) y /= dy; 
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
   * @param ax
   * @param ay
   * @return
   */
  public ivec2 add(int ax,int ay) {
    x += ax;
    y += ay;
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
   * @param sx
   * @param sy
   * @return
   */
  public ivec2 sub(int sx,int sy) {
    x -= sx;
    y -= sy;
    set(x,y);
    return this;
  }

  public ivec2 sub(int s) {
    return sub(s,s);
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
