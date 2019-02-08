/**
* ivec5 class
* v 1.0.0
* 2015-2019
* Processing 3.5.3
* Vector class with a float precision
* @author Stan le Punk
* @see http://stanlepunk.xyz/
* @see https://github.com/StanLepunK/Rope
*/
package rope.vector;
public class ivec5 extends ivec {
  public ivec5() {
  	super(5);
  	set(0,0,0,0,0); 
  }

  public ivec5(int v) {
  	super(5);
  	set(v,v,v,v,v); 
  }

  public ivec5(int a, int b, int c, int d, int e) {
    super(5) ;
    set(a,b,c,d,e);
  }

  public ivec5(ivec v) {
    super(5) ;
    set(v);
  }
  
  /**
   * set
   * @param a
   * @param b
   * @param c
   * @param d
   * @param e
   * @return
   */
  public ivec5 set(int a, int b, int c, int d, int e) {
  	this.a = a;
  	this.b = b;
  	this.c = c;
  	this.d = d;
  	this.e = e;
  	return this;
  }
  
  public ivec5 set(int arg){
    set(arg,arg,arg,arg,arg);
    return this;
  }

  public ivec5 set(ivec v) {
    if(v == null) {
      this.a = this.b = this.c = this.d = this.e = 0;
      return this;
    } else if(v instanceof ivec5 || v instanceof ivec6) {
      set(v.a,v.b,v.c,v.d,v.e);
      return this;
    } else {
      set(v.x,v.y,v.z,v.w,0);
      return this;
    }
  }

  public ivec5 set(vec v) {
    if(v == null) {
      this.a = this.b = this.c = this.d = this.e = 0;
      return this;
    } else if(v instanceof vec5 || v instanceof vec6) {
      set((int)v.a,(int)v.b,(int)v.c,(int)v.d,(int)v.e);
      return this;
    } else {
      set((int)v.x,(int)v.y,(int)v.z,(int)v.w,0);
      return this;
    }
  }


  // abcde
  public ivec5 a(int a) {
    return set(a,this.b,this.c,this.d,this.e);
  }

  public ivec5 b(int b) {
    return set(this.a,b,this.c,this.d,this.e);
  }

  public ivec5 c(int c) {
    return set(this.a,this.b,c,this.d,this.e);
  }

  public ivec5 d(int d) {
    return set(this.a,this.b,this.c,d,this.e);
  }

  public ivec5 e(int e) {
    return set(this.a,this.b,this.c,this.d,e);
  }
  

  
  /**
   * copy
   * @return
   */
  public ivec5 copy() {
    return new ivec5(a,b,c,d,e);
  }
  
  @Override 
  public String toString() {
    return "[ " + a + ", " + b + ", " + c + ", " + d + ", " + e + " ]";
  }

}
