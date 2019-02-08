/**
* bvec3 class
* v 1.0.0
* 2015-2019
* Processing 3.5.3
* Vector class with a float precision
* @author Stan le Punk
* @see http://stanlepunk.xyz/
* @see https://github.com/StanLepunK/Rope
*/
package rope.vector;
public class bvec3 extends bvec {
	
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
      return this;
    } else if(v instanceof bvec5 || v instanceof bvec6) {
      set(v.a,v.b,v.c);
      return this;
    } else {
      set(v.x,v.y,v.z);
      return this;
    }
  }

  // xyz
  public bvec3 set_x(boolean x) {
    return set(x,this.y,this.z);
  }

  public bvec3 set_y(boolean y) {
    return set(this.x,y,this.z);
  }

  public bvec3 set_z(boolean z) {
    return set(this.x,this.y,z);
  }
	
	@Override 
	public String toString() {
		return "[ " + x + ", " + y + ", " + z + " ]";
	}

}
