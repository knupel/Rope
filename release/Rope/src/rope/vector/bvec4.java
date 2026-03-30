/**
* bvec4 class
* v 1.4.0
* 2015-2021
* Vector class with a boolean precision
* @author @stanlepunk
* @see https://github.com/StanLepunK/Rope
*/
package rope.vector;
public class bvec4 extends bvec {
	
	public bvec4() {
		super(4);
		set(false);
	}
	
	public bvec4(boolean x, boolean y, boolean z, boolean w) {
		super(4);
		set(x,y,z,w);	
	}
	
	public bvec4(boolean arg) {
		super(4);
		set(arg);
		
	}
	
	public bvec4(bvec b) {
		super(4);
		set(b);
	}

  public bvec4(boolean [] source) {
    super(4);
    set(source); 
  }


	/**
   * set
   * @param x
   * @param y
   * @param z
   * @param w
   * @return
   */
  public bvec4 set(boolean x, boolean y, boolean z, boolean w) {
  	this.x = x;
  	this.y = y;
  	this.z = z;
  	this.w = w;
  	return this;
  }
  
  public bvec4 set(boolean arg){
    set(arg,arg,arg,arg);
    return this;
  }

  public bvec4 set(bvec v) {
    if(v == null) {
      this.x = this.y = this.z = this.w = false;
    } else {
      set(v.x,v.y,v.z,v.w);
    }
  	return this;
  }
  
  public bvec4 set(boolean[] source) {
    if(source.length == 1) {
      set(source[0],this.y,this.z,this.w);
    } else if(source.length == 2) {
      set(source[0],source[1],this.z,this.w);
    } else if(source.length == 3) {
      set(source[0],source[1],source[2],this.w);
    } else if(source.length == 4) {
      set(source[0],source[1],source[2],source[3]);
    } else if(source.length > 4) {
      set(source[0],source[1],source[2],source[3]);
    }
    return this;
  }
  
  public bvec4 set_to(int index, boolean arg) {
  	if(index == 0) x(arg);
  	if(index == 1) y(arg);
  	if(index == 2) z(arg);
  	if(index == 3) w(arg);
  	return this;
  }

  // xyzw
  public bvec4 x(boolean x) {
    return set(x,this.y,this.z,this.w);
  }

  public bvec4 y(boolean y) {
    return set(this.x,y,this.z,this.w);
  }

  public bvec4 z(boolean z) {
    return set(this.x,this.y,z,this.w);
  }

  public bvec4 w(boolean w) {
    return set(this.x,this.y,this.z,w);
  }
  
  /**
	 * 
	 * @return inverse all argument like swap()
	 */
	public bvec4 inv() {
		inv_impl();
		return this;
	}
  
  /**
	 * 
	 * @return inverse all argument like inv()
	 */
  public bvec4 swap() {
		this.x = !this.x;
		this.y = !this.y;
		this.z = !this.z;
		this.w = !this.w;
  	return set(this.x,this.y,this.z,this.w);
  }
  
  
  public bvec4 swap(int index) {
  	if(index >= 0 && index < 4) {
  		if(index == 0) this.x = !this.x;
  		if(index == 1) this.y = !this.y;
  		if(index == 2) this.z = !this.z;
  		if(index == 3) this.w = !this.w;
  	}
  	return set(this.x,this.y,this.z,this.w);
  }
  
  public bvec4 swap_x() {
  	this.x = !this.x;
    return set(this.x,this.y,this.z,this.w);
  }

  public bvec4 swap_y() {
  	this.y = !this.y;
    return set(this.x,this.y,this.z,this.w);
  }

  public bvec4 swap_z() {
  	this.z = !this.z;
    return set(this.x,this.y,this.z,this.w);
  }

  public bvec4 swap_w() {
  	this.w = !this.w;
    return set(this.x,this.y,this.z,this.w);
  }


  /**
	 * 
	 * @return true if all arguments in the range of the concerned bvec is same
	 */
	public boolean equals(bvec4 bv) {
		return equals_impl(bv);
	}

  /**
	 * copy
	 * @return
	 */
	public bvec4 copy() {
		return new bvec4(x,y,z,w) ;
	}

	
	@Override 
	public String toString() {
	    return "[ " + x + ", " + y + ", " + z + ", " + w + " ]" ;
	}
}
