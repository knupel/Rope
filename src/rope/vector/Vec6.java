package rope.vector;
/**
 * Vec6 class
 * v 1.0.0
* 2015-2019
* Processing 3.5.3
* Vector class with a float precision
 * @author Stan le Punk
 * @see http://stanlepunk.xyz/
 * @see https://github.com/StanLepunK/Rope
*/
public class vec6 extends vec {
  public vec6() {
  	super(6);
  	set(0,0,0,0,0,0); 
  }

  public vec6(float v) {
  	super(6);
  	set(v,v,v,v,v,v); 
  }

  public vec6(float a, float b, float c, float d, float e, float f) {
    super(6) ;
    set(a,b,c,d,e,f);
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
  public vec6 set(float a, float b, float c, float d, float e, float f) {
  	this.a = a;
  	this.b = b;
  	this.c = c;
  	this.d = d;
  	this.e = e;
  	this.f = f;
  	return this;
  }
  
  public vec6 set(float[] source) {
    set(source[0],source[1],source[2],source[3],source[4],source[5]);
    return this ;
  }
  
  public vec6 set(float v) {
    set(v,v,v,v,v,v);
    return this;
  }

  
  public vec6 set(vec v) {
    if ( v == null) {    
      a = b = c = d = e = f = 0;
      return this;
    } else if(v instanceof vec5 || v instanceof vec6) {
      set(v.a,v.b,v.c,v.d,v.e,v.f);
      return this;
    } else {
      set(v.x,v.y,v.z,v.w,0,0);
      return this;
    }
  }

  public vec6 set(ivec v) {
    if ( v == null) {    
      a = b = c = d = e = f = 0;
      return this;
    } else if(v instanceof ivec5 || v instanceof ivec6) {
      set(v.a ,v.b,v.c,v.d,v.e,v.f);
      return this;
    } else {
      set(v.x,v.y,v.z,v.w,0,0);
      return this;
    }
  }
  
  public vec6 a(float a) {
    return set(a,this.b,this.c,this.d,this.e,this.f);
  }

  public vec6 b(float b) {
    return set(this.a,b,this.c,this.d,this.e,this.f);
  }

  public vec6 c(float c) {
    return set(this.a,this.b,c,this.d,this.e,this.f);
  }

  public vec6 d(float d) {
    return set(this.a,this.b,this.c,d,this.e,this.f);
  }

  public vec6 e(float e) {
    return set(this.a,this.b,this.c,this.d,e,this.f);
  }

  public vec6 f(float f) {
    return set(this.a,this.b,this.c,this.d,this.e,f);
  }
  
  
  /**
   * copy
   * @return
   */
  public vec6 copy() {
    return new vec6(a,b,c,d,e,f) ;
  }
  
  @Override 
  public String toString() {
    return "[ " + a + ", " + b + ", " + c + ", " + d + ", " + e + ", " + f + " ]" ;
  }
  
  
}
