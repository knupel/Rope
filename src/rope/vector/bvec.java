/**
* bvec class
* v 2.0.0
* 2015-2019
* Vector with a boolean precision
* @author @stanlepunk
* @see http://stanlepunk.xyz
* @see https://github.com/StanLepunK/Rope
*/
package rope.vector;
import rope.core.BigBangRope;
public abstract class bvec extends BigBangRope {
	private int num ;
	public boolean x,y,z,w;
	public boolean e,f; // for bvec5 and bvec6
	
	public bvec(int num) {
		this.num = num;
	}
	
  /**
  * @return the number of components
  */
	public int get_num() {
		return this.num;
	}

  /**
   * return single boolean component
   * @return boolean
   */
  public boolean x() {
    return x;
  }

  public boolean y() {
    return y;
  }

  public boolean z() {
    return z;
  }

  public boolean w() {
    return w;
  }
    
  public boolean a() {
    return x;
  }
    
  public boolean b() {
    return y;
  }

  public boolean c() {
    return z;
  }

  public boolean d() {
    return w;
  }

  public boolean e() {
    return e;
  }

  public boolean f() {
    return f;
  }


  /**
   * return multi float component
   * @return float
   */

  public bvec2 xy() {
    return new bvec2(x,y);
  }

  public bvec3 xyz() {
    return new bvec3(x,y,z);
  }

  public bvec4 xyzw() {
    return new bvec4(x,y,z,w);
  }

  public bvec2 ab() {
    return new bvec2(x,y);
  }

  public bvec3 abc() {
    return new bvec3(x,y,z);
  }

  public bvec4 abcd() {
    return new bvec4(x,y,z,w);
  }

  public bvec5 abcde() {
    return new bvec5(x,y,z,w,e);
  }

  public bvec6 abcdef() {
    return new bvec6(x,y,z,w,e,f);
  }

  
	
	/**
  * return the list of component
  * @return boolean []
  */
	public boolean [] array() {
    if(num == 2) {
      boolean array [] = {x,y};
      return array;
    } else if(num == 3) {
      boolean array [] = {x,y,z};
      return array;
    } else if(num == 4) {
      boolean array [] = {x,y,z,w};
      return array;
    } else if(num == 5) {
      boolean array [] = {x,y,z,w,e};
      return array;
    } else if(num == 6) {
      boolean array [] = {x,y,z,w,e,f};
      return array;
    } else return null ;
  }
  // 
}
