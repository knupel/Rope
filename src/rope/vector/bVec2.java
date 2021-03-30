/**
* bvec2 class
* v 1.3.0
* 2015-2021
* Vector class with a float precision
* @author @stanlepunk
* @see http://stanlepunk.xyz/
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
  
  // xy
  public bvec2 x(boolean x) {
    return set(x,this.y);
  }

  public bvec2 y(boolean y) {
    return set(this.x,y);
  }
	
	
	
	@Override 
	public String toString() {
		return "[ " + x + ", " + y + " ]";
	}

}
