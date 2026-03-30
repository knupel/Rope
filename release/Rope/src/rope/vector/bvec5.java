/**
* bvec5 class
* v 1.3.0
* 2015-2021
* Vector class with a boolean precision
* @author @stanlepunk
* @see https://github.com/StanLepunK/Rope
*/
package rope.vector;
public class bvec5 extends bvec {

	public bvec5() {
		super(5);
		set(false);
	}
	
	public bvec5(boolean a, boolean b, boolean c, boolean d, boolean e) {
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

  public bvec5(boolean [] source) {
    super(5);
    set(source); 
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
  	this.x = a;
  	this.y = b;
  	this.z = c;
  	this.w = d;
  	this.e = e;
  	return this;
  }
  
  public bvec5 set(boolean arg){
    set(arg,arg,arg,arg,arg);
    return this;
  }

  public bvec5 set(bvec v) {
    if(v == null) {
      this.x = this.y = this.z = this.w = this.e = false;
    } else if(v instanceof bvec5 || v instanceof bvec6) {
      set(v.x,v.y,v.z,v.w,v.e);
    } else {
      set(v.x,v.y,v.z,v.w,false);
    }
  	return this;
  }
  
  public bvec5 set(boolean[] source) {
    if(source.length == 1) {
      set(source[0],this.y,this.z,this.w,this.e);
    } else if(source.length == 2) {
      set(source[0],source[1],this.z,this.w,this.e);
    } else if(source.length == 3) {
      set(source[0],source[1],source[2],this.w,this.e);
    } else if(source.length == 4) {
      set(source[0],source[1],source[2],source[3],this.e);
    } else if(source.length == 5) {
      set(source[0],source[1],source[2],source[3],source[4]);
    } else if(source.length > 5) {
      set(source[0],source[1],source[2],source[3],source[4]);
    }
    return this;
  }
  
  public bvec5 set_to(int index, boolean arg) {
  	if(index == 0) a(arg);
  	if(index == 1) b(arg);
  	if(index == 2) c(arg);
  	if(index == 3) d(arg);
  	if(index == 4) e(arg);
  	return this;
  }


  // abcde
  public bvec5 a(boolean a) {
    return set(a,this.y,this.z,this.w,this.e);
  }

  public bvec5 b(boolean b) {
    return set(this.x,b,this.z,this.w,this.e);
  }

  public bvec5 c(boolean c) {
    return set(this.x,this.y,c,this.w,this.e);
  }

  public bvec5 d(boolean d) {
    return set(this.x,this.y,this.z,d,this.e);
  }

  public bvec5 e(boolean e) {
    return set(this.x,this.y,this.z,this.w,e);
  }
  
  
  /**
	 * 
	 * @return inverse all argument like swap()
	 */
	public bvec5 inv() {
		inv_impl();
		return set(this.x,this.y, this.z, this.w, this.e);
	}
  
  /**
	 * 
	 * @return inverse all argument like inv()
	 */
  public bvec5 swap() {
		this.x = !this.x;
		this.y = !this.y;
		this.z = !this.z;
		this.w = !this.w;
		this.e = !this.e;
  	return this;
  }
  
  
  public bvec5 swap(int index) {
  	if(index >= 0 && index < 5) {
  		if(index == 0) this.x = !this.x;
  		if(index == 1) this.y = !this.y;
  		if(index == 2) this.z = !this.z;
  		if(index == 3) this.w = !this.w;
  		if(index == 4) this.e = !this.e;
  	}
  	return set(this.x,this.y,this.z,this.w,this.e);
  }
  
  
  public bvec5 swap_a() {
  	this.x = !this.x;
    return set(this.x,this.y,this.z,this.w,this.e);
  }

  public bvec5 swap_b() {
  	this.y = !this.y;
    return set(this.x,this.y,this.z,this.w,this.e);
  }

  public bvec5 swap_c() {
  	this.z = !this.z;
    return set(this.x,this.y,this.z,this.w,this.e);
  }

  public bvec5 swap_d() {
  	this.w = !this.w;
    return set(this.x,this.y,this.z,this.w,this.e);
  }

  public bvec5 swap_e() {
  	this.e = !this.e;
    return set(this.x,this.y,this.z,this.w,this.e);
  }


  /**
	 * 
	 * @return true if all arguments in the range of the concerned bvec is same
	 */
	public boolean equals(bvec5 bv) {
		return equals_impl(bv);
	}

  /**
	 * copy
	 * @return
	 */
	public bvec5 copy() {
		return new bvec5(x,y,z,w,e) ;
	}

	
	@Override 
	public String toString() {
		return "[ " + x + ", " + y + ", " + z + ", " + w + ", " + e + " ]";
	}
}
