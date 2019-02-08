package rope.vector;
/**
 * ivec6 class
 * v 1.0.0
* 2015-2019
* Processing 3.5.3
* Vector class with a float precision
 * @author Stan le Punk
 * @see http://stanlepunk.xyz/
 * @see https://github.com/StanLepunK/Rope
*/
public class ivec6 extends ivec {
	public ivec6() {
  	super(6);
  	set(0,0,0,0,0,0); 
  }

  public ivec6(int v) {
  	super(6);
  	set(v,v,v,v,v,v); 
  }
  public ivec6(int a, int b, int c, int d, int e, int f) {
    super(6);
    set(a,b,c,d,e,f);
  }

  public ivec6(ivec v) {
    super(6);
    set(v);
  }
  
  /**
   * set
   * @param a
   * @param b
   * @param c
   * @param d
   * @param e
   * @param f
   * @return
   */
  public ivec6 set(int a, int b, int c, int d, int e, int f) {
  	this.a = a;
  	this.b = b;
  	this.c = c;
  	this.d = d;
  	this.e = e;
  	this.f = f;
  	return this;
  }
  
  public ivec6 set(int arg){
    set(arg,arg,arg,arg,arg,arg);
    return this;
  }

  public ivec6 set(ivec v) {
    if(v == null) {
      this.a = this.b = this.c = this.d = this.e = this.f = 0;
      return this;
    } else if(v instanceof ivec5 || v instanceof ivec6) {
      set(v.a,v.b,v.c,v.d,v.e,v.f);
      return this;
    } else {
      set(v.x,v.y,v.z,v.w,0,0);
      return this;
    }
  }

  public ivec6 set(vec v) {
    if(v == null) {
      this.a = this.b = this.c = this.d = this.e = this.f = 0;
      return this;
    } else if(v instanceof vec5 || v instanceof vec6) {
      set((int)v.a,(int)v.b,(int)v.c,(int)v.d,(int)v.e,(int)v.f);
      return this;
    } else {
      set((int)v.x,(int)v.y,(int)v.z,(int)v.w,0,0);
      return this;
    }
  }

  // abcdef
  public ivec6 a(int a) {
    return set(a,this.b,this.c,this.d,this.e,this.f);
  }

  public ivec6 b(int b) {
    return set(this.a,b,this.c,this.d,this.e,this.f);
  }

  public ivec6 c(int c) {
    return set(this.a,this.b,c,this.d,this.e,this.f);
  }

  public ivec6 d(int d) {
    return set(this.a,this.b,this.c,d,this.e,this.f);
  }

  public ivec6 e(int e) {
    return set(this.a,this.b,this.c,this.d,e,this.f);
  }

  public ivec6 f(int f) {
    return set(this.a,this.b,this.c,this.d,this.e,f);
  }
  
  
  /**
   * copy
   * @return
   */
  public ivec6 copy() {
    return new ivec6(a,b,c,d,e,f);
  }
  
  
  @Override 
  public String toString() {
    return "[ " + a + ", " + b + ", " + c + ", " + d + ", " + e + ", " + f + " ]";
  }

}
