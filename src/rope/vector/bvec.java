/**
* bvec class
* v 2.1.1
* 2015-2021
* Vector with a boolean precision
* @author @stanlepunk
* @see https://github.com/StanLepunK/Rope
*/
package rope.vector;
import rope.core.R_Constants;

public abstract class bvec implements R_Constants  {
	private int size;
	public boolean x,y,z,w;
	public boolean e,f; // for bvec5 and bvec6
	
	public bvec(int size) {
		this.size = size;
	}
	
  /**
  * @return the number of components
  */
	@Deprecated public int get_size() {
		return this.size;
	}

  /**
  * @return the number of components
  */
  public int size() {
		return this.size;
	}

  public bvec get() {
    return this;
  }

  public Boolean get(int index) {
    if(index >= size)
      return null;
    switch(index) {
      case 0: return x;
      case 1: return y;
      case 2: return z;
      case 3: return w;
      case 4: return e;
      case 5: return f;
      default : return null;
    }
  }


  protected void inv_impl() {
    x = !x;
    y = !y;
    if(this.size == 2) return;
    z = !z;
    if(this.size == 3) return;
    w = !w;
    if(this.size == 4) return;
    e = !e;
    if(this.size == 5) return;
    f = !f;
  }


	protected boolean equals_impl(bvec bv) {
    if(x != bv.x()) return false;
    if(y != bv.y()) return false;
    if(this.size == 2) return true;
    if(z != bv.z()) return false;
    if(this.size == 3) return true;
    if(w != bv.w()) return false;
    if(this.size == 4) return true;
    if(e != bv.e()) return false;
    if(this.size == 5) return true;
    if(f != bv.f()) return false;
    return true;
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
    if(size == 2) {
      boolean array [] = {x,y};
      return array;
    } else if(size == 3) {
      boolean array [] = {x,y,z};
      return array;
    } else if(size == 4) {
      boolean array [] = {x,y,z,w};
      return array;
    } else if(size == 5) {
      boolean array [] = {x,y,z,w,e};
      return array;
    } else if(size == 6) {
      boolean array [] = {x,y,z,w,e,f};
      return array;
    } else return null ;
  }
  // 
}
