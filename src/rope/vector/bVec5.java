package rope.vector;
/**
 * bvec5 class
 * v 1.0.0
* 2015-2019
* Processing 3.5.3
* Vector class with a float precision
 * @author Stan le Punk
 * @see http://stanlepunk.xyz/
 * @see https://github.com/StanLepunK/Rope
*/
public class bvec5 extends bvec {

	public bvec5(boolean a,boolean b,boolean c, boolean d, boolean e) {
		super(5);
		set(a,b,c,d,e);
	}
	
	public bvec5(boolean arg) {
		super(5);	
		set(arg);
	}
	
	public bvec5(bvec b) {
		super(5);	
		set(b);
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
  public bvec5 set(boolean a, boolean b, boolean c, boolean d, boolean e) {
  	this.a = a;
  	this.b = b;
  	this.c = c;
  	this.d = d;
  	this.e = e;
  	return this;
  }
  
  public bvec5 set(boolean arg){
    set(arg,arg,arg,arg,arg);
    return this;
  }

  public bvec5 set(bvec v) {
    if(v == null) {
      this.a = this.b = this.c = this.d = this.e = false;
      return this;
    } else if(v instanceof bvec5 || v instanceof bvec6) {
      set(v.a,v.b,v.c,v.d,v.e);
      return this;
    } else {
      set(v.x,v.y,v.z,v.w,false);
      return this;
    }
  }


  // abcde
  public bvec5 set_a(boolean a) {
    return set(a,this.b,this.c,this.d,this.e);
  }

  public bvec5 set_b(boolean b) {
    return set(this.a,b,this.c,this.d,this.e);
  }

  public bvec5 set_c(boolean c) {
    return set(this.a,this.b,c,this.d,this.e);
  }

  public bvec5 set_d(boolean d) {
    return set(this.a,this.b,this.c,d,this.e);
  }

  public bvec5 set_e(boolean e) {
    return set(this.a,this.b,this.c,this.d,e);
  }
	
	@Override 
	public String toString() {
		return "[ " + a + ", " + b + ", " + c + ", " + d + ", " + e + " ]";
	}
}
