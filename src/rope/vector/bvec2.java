/**
* bvec2 class
* v 1.5.0
* 2015-2021
* Vector class with a boolean precision
* @author @stanlepunk
* @see https://github.com/StanLepunK/Rope
*/
package rope.vector;
public class bvec2 extends bvec {
	
	public bvec2() {
		super(2);
		set(false);
	}
	
	public bvec2(boolean x, boolean y) {
		super(2);
		set(x,y);
	}
	
	public bvec2(boolean arg) {
		super(2);
		set(arg);
	}
	
	public bvec2(bvec b) {
		super(2);
		set(b);	
	}

  public bvec2(boolean [] source) {
    super(2);
    set(source); 
  }


	/**
   * set
   * @param x
   * @param y
   * @return
   */
  public bvec2 set(boolean x, boolean y) {
  	this.x = x;
  	this.y = y;
  	return this;
  }
  
  public bvec2 set(boolean arg){
    set(arg,arg);
    return this;
  }
  
  public bvec2 set(bvec v) {
    if(v == null) {
      this.x = this.y = false;
    } else {
      set(v.x,v.y);
    }
    return this;
  }


  public bvec2 set(boolean[] source) {
    if(source.length == 1) {
      set(source[0],this.y);
    } else if(source.length == 2) {
      set(source[0],source[1]);
    } else if(source.length > 2) {
      set(source[0],source[1]);
    }
    return this;
  }


  
  public bvec2 set_to(int index, boolean arg) {
  	if(index == 0) x(arg);
  	if(index == 1) y(arg);
  	return this;
  }


  /**
	 * 
	 * @return inverse all argument like swap()
	 */
	public bvec2 inv() {
		inv_impl();
		return this;
	}
  
  /**
	 * 
	 * @return inverse all argument like inv()
	 */
  public bvec2 swap() {
		this.x = !this.x;
		this.y = !this.y;
  	return set(this.x,this.y);
  }
  
  
  public bvec2 swap(int index) {
  	if(index >= 0 && index < 4) {
  		if(index == 0) this.x = !this.x;
  		if(index == 1) this.y = !this.y;
  	}
  	return set(this.x,this.y);
  }

  
  public bvec2 swap_x() {
  	this.x = !this.x;
    return set(this.x,this.y);
  }

  public bvec2 swap_y() {
  	this.y = !this.y;
    return set(this.x,this.y);
  }


  /**
	 * 
	 * @return true if all arguments in the range of the concerned bvec is same
	 */
	public boolean equals(bvec2 bv) {
		return equals_impl(bv);
	}
  

  
  // xy
  public bvec2 x(boolean x) {
    return set(x,this.y);
  }

  public bvec2 y(boolean y) {
    return set(this.x,y);
  }


  /**
	 * copy
	 * @return
	 */
	public bvec2 copy() {
		return new bvec2(x,y) ;
	}
	
	
	
	@Override 
	public String toString() {
		return "[ " + x + ", " + y + " ]";
	}

}
