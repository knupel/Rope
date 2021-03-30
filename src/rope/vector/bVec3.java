/**
* bvec3 class
* v 1.2.0
* 2015-2019
* Vector class with a boolean precision
* @author @stanlepunk
* @see http://stanlepunk.xyz/
* @see https://github.com/StanLepunK/Rope
*/
package rope.vector;
public class bvec3 extends bvec {
	
	public bvec3() {
		super(3);
		set(false);
	}
	
	public bvec3(boolean x, boolean y, boolean z) {
		super(3);
		set(x,y,z);
		
	}
	
	public bvec3(boolean arg) {
		super(3);
		set(arg);
	}
	
	public bvec3(bvec b) {
		super(3);	
		set(b);
	}

  public bvec3(boolean [] source) {
    super(3);
    set(source); 
  }

	/**
   * set
   * @param x
   * @param y
   * @param z
   * @return
   */
  public bvec3 set(boolean x, boolean y, boolean z) {
  	this.x = x;
  	this.y = y;
  	this.z = z;
  	return this;
  }
  
  public bvec3 set(boolean arg){
    set(arg,arg,arg);
    return this;
  }

  public bvec3 set(bvec v) {
    if(v == null) {
      this.x = this.y = this.z = false;
    } else {
      set(v.x,v.y,v.z);
    }
    return this;
  }
  
  public bvec3 set(boolean[] source) {
    if(source.length == 1) {
      set(source[0],this.y,this.z);
    } else if(source.length == 2) {
      set(source[0],source[1],this.z);
    } else if(source.length == 3) {
      set(source[0],source[1],source[2]);
    } else if(source.length > 3) {
      set(source[0],source[1],source[2]);
    }
    return this;
  }

  // xyz
  public bvec3 x(boolean x) {
    return set(x,this.y,this.z);
  }

  public bvec3 y(boolean y) {
    return set(this.x,y,this.z);
  }

  public bvec3 z(boolean z) {
    return set(this.x,this.y,z);
  }
	
	@Override 
	public String toString() {
		return "[ " + x + ", " + y + ", " + z + " ]";
	}

}
