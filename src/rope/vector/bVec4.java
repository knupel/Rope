/**
* bvec4 class
* v 1.1.0
* 2015-2019
* Vector class with a boolean precision
* @author Stan le Punk
* @see http://stanlepunk.xyz/
* @see https://github.com/StanLepunK/Rope
*/
package rope.vector;
public class bvec4 extends bvec {
	
	public bvec4(boolean x,boolean y,boolean z, boolean w) {
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

	
	@Override 
	public String toString() {
	    return "[ " + x + ", " + y + ", " + z + ", " + w + " ]" ;
	}
}
