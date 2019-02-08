/**
* bvec6 class
* v 1.0.0
* 2015-2019
* Processing 3.5.3
* Vector class with a float precision
* @author Stan le Punk
* @see http://stanlepunk.xyz/
* @see https://github.com/StanLepunK/Rope
*/
package rope.vector;
public class bvec6 extends bvec {
	
	public bvec6(boolean a,boolean b,boolean c, boolean d, boolean e, boolean f) {
		super(6);
		set(a,b,c,d,e,f);
	}
	
	public bvec6(boolean arg) {
		super(6);
		set(arg);
	}
	
	public bvec6(bvec b) {
		super(6);	
		set(b);
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
  public bvec6 set(boolean a, boolean b, boolean c, boolean d, boolean e, boolean f) {
  	this.a = a;
  	this.b = b;
  	this.c = c;
  	this.d = d;
  	this.e = e;
  	this.f = f;
  	return this;
  }
  
  public bvec6 set(boolean arg){
    set(arg,arg,arg,arg,arg,arg);
    return this;
  }

  public bvec6 set(bvec v) {
    if(v == null) {
      this.a = this.b = this.c = this.d = this.e = this.f = false;
      return this;
    } else if(v instanceof bvec5 || v instanceof bvec6) {
      set(v.a,v.b,v.c,v.d,v.e,v.f);
      return this;
    } else {
      set(v.x,v.y,v.z,v.w,false,false);
      return this;
    }
  }

  // abcdef
  public bvec6 set_a(boolean a) {
    return set(a,this.b,this.c,this.d,this.e,this.f);
  }

  public bvec6 set_b(boolean b) {
    return set(this.a,b,this.c,this.d,this.e,this.f);
  }

  public bvec6 set_c(boolean c) {
    return set(this.a,this.b,c,this.d,this.e,this.f);
  }

  public bvec6 set_d(boolean d) {
    return set(this.a,this.b,this.c,d,this.e,this.f);
  }

  public bvec6 set_e(boolean e) {
    return set(this.a,this.b,this.c,this.d,e,this.f);
  }

  public bvec6 set_f(boolean f) {
    return set(this.a,this.b,this.c,this.d,this.e,f);
  }
	
	@Override 
	public String toString() {
		return "[ " + a + ", " + b + ", " + c + ", " + d + ", " + e + ", " + f + " ]";
	}
}
