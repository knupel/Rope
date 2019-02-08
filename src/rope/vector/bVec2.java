/**
* bvec2 class
* v 1.0.0
* 2015-2019
* Processing 3.5.3
* Vector class with a float precision
* @author Stan le Punk
* @see http://stanlepunk.xyz/
* @see https://github.com/StanLepunK/Rope
*/
package rope.vector;
public class bvec2 extends bvec {
	
	public bvec2(boolean x,boolean y) {
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
      return this;
    } else if(v instanceof bvec5 || v instanceof bvec6) {
      set(v.a,v.b);
      return this;
    } else {
      set(v.x,v.y);
      return this;
    }
  }
  
  // xy
  public bvec2 set_x(boolean x) {
    return set(x,this.y);
  }

  public bvec2 set_y(boolean y) {
    return set(this.x,y);
  }
	
	
	
	@Override 
	public String toString() {
		return "[ " + x + ", " + y + " ]";
	}

}
