/**
* bvec class
* v 1.1.0
* 2015-2019
* Processing 3.5.3
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
	public boolean a,b,c,d,e,f;
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
    return a;
  }
    
  public boolean b() {
    return b;
  }

  public boolean c() {
    return c;
  }

  public boolean d() {
    return d;
  }

  public boolean e() {
    return e;
  }

  public boolean f() {
    return f;
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
      boolean array [] = {a,b,c,d,e};
      return array;
    } else if(num == 6) {
      boolean array [] = {a,b,c,d,e,f};
      return array;
    } else return null ;
  }

}
