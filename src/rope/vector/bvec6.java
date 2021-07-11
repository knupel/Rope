/**
* bvec6 class
* v 1.3.0
* 2015-2021
* Vector class with a float precision
* @author @stanlepunk
* @see https://github.com/StanLepunK/Rope
*/
package rope.vector;
public class bvec6 extends bvec {
	public bvec6() {
		super(6);
		set(false);
	}
	
	public bvec6(boolean a, boolean b, boolean c, boolean d, boolean e, boolean f) {
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

  public bvec6(boolean [] source) {
    super(6);
    set(source); 
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
  	this.x = a;
  	this.y = b;
  	this.z = c;
  	this.w = d;
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
      this.x = this.y = this.z = this.w = this.e = this.f = false;
    } else if(v instanceof bvec5 || v instanceof bvec6) {
      set(v.x,v.y,v.z,v.w,v.e,v.f);
    } else {
      set(v.x,v.y,v.z,v.w,false,false);
    }
  	return this;
  }
  
  public bvec6 set(boolean[] source) {
    if(source.length == 1) {
      set(source[0],this.y,this.z,this.w,this.e,this.f);
    } else if(source.length == 2) {
      set(source[0],source[1],this.z,this.w,this.e,this.f);
    } else if(source.length == 3) {
      set(source[0],source[1],source[2],this.w,this.e,this.f);
    } else if(source.length == 4) {
      set(source[0],source[1],source[2],source[3],this.e,this.f);
    } else if(source.length == 5) {
      set(source[0],source[1],source[2],source[3],source[4],this.f);
    } else if(source.length == 6) {
      set(source[0],source[1],source[2],source[3],source[4],source[5]);
    } else if(source.length > 6) {
      set(source[0],source[1],source[2],source[3],source[4],source[5]);
    }
    return this;
  }
  
  public bvec6 set_to(int index, boolean arg) {
  	if(index == 0) a(arg);
  	if(index == 1) b(arg);
  	if(index == 2) c(arg);
  	if(index == 3) d(arg);
  	if(index == 4) e(arg);
  	if(index == 5) f(arg);
  	return this;
  }

  // abcdef
  public bvec6 a(boolean a) {
    return set(a,this.y,this.z,this.w,this.e,this.f);
  }

  public bvec6 b(boolean b) {
    return set(this.x,b,this.z,this.w,this.e,this.f);
  }

  public bvec6 c(boolean c) {
    return set(this.x,this.y,c,this.w,this.e,this.f);
  }

  public bvec6 d(boolean d) {
    return set(this.x,this.y,this.z,d,this.e,this.f);
  }

  public bvec6 e(boolean e) {
    return set(this.x,this.y,this.z,this.w,e,this.f);
  }

  public bvec6 f(boolean f) {
    return set(this.x,this.y,this.z,this.w,this.e,f);
  }
  
  /**
	 * 
	 * @return inverse all argument like swap()
	 */
	public bvec6 inv() {
		inv_impl();
		return this;
	}
  
  /**
	 * 
	 * @return inverse all argument like inv()
	 */
  public bvec6 swap() {
		this.x = !this.x;
		this.y = !this.y;
		this.z = !this.z;
		this.w = !this.w;
		this.e = !this.e;
		this.f = !this.f;
  	return set(this.x,this.y,this.z,this.w,this.e,this.f);
  }
  
  
  public bvec6 swap(int index) {
  	if(index >= 0 && index < 6) {
  		if(index == 0) this.x = !this.x;
  		if(index == 1) this.y = !this.y;
  		if(index == 2) this.z = !this.z;
  		if(index == 3) this.w = !this.w;
  		if(index == 4) this.e = !this.e;
  		if(index == 5) this.f = !this.f;
  	}
  	return set(this.x,this.y,this.z,this.w,this.e,this.f);
  }
  
  public bvec6 swap_a() {
  	this.x = !this.x;
    return set(this.x,this.y,this.z,this.w,this.e,this.f);
  }

  public bvec6 swap_b() {
  	this.y = !this.y;
    return set(this.x,this.y,this.z,this.w,this.e,this.f);
  }

  public bvec6 swap_c() {
  	this.z = !this.z;
    return set(this.x,this.y,this.z,this.w,this.e,this.f);
  }

  public bvec6 swap_d() {
  	this.w = !this.w;
    return set(this.x,this.y,this.z,this.w,this.e,this.f);
  }

  public bvec6 swap_e() {
  	this.e = !this.e;
    return set(this.x,this.y,this.z,this.w,this.e,this.f);
  }

  public bvec6 swap_f() {
  	this.f = !this.f;
    return set(this.x,this.y,this.z,this.w,this.e,this.f);
  }

    /**
	 * 
	 * @return true if all arguments in the range of the concerned bvec is same
	 */
	public boolean equals(bvec6 bv) {
		return equals_impl(bv);
	}


  /**
	 * copy
	 * @return
	 */
	public bvec6 copy() {
		return new bvec6(x,y,z,w,e,f) ;
	}

	
	@Override 
	public String toString() {
		return "[ " + x + ", " + y + ", " + z + ", " + w + ", " + e + ", " + f + " ]";
	}
}
