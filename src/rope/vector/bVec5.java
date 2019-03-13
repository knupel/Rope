/**
* bvec5 class
* v 1.1.0
* 2015-2019
* Vector class with a boolean precision
* @author @stanlepunk
* @see http://stanlepunk.xyz/
* @see https://github.com/StanLepunK/Rope
*/
package rope.vector;
public class bvec5 extends bvec {

	public bvec5(boolean a,boolean b,boolean c, boolean d, boolean e) {
		super(5);
		set(a,b,c,d,e);
	}
	
	public bvec5(boolean arg) {
		super(5);	
		set(arg);
	}
	
	public bvec5(bvec b) {
		super(5);	
		set(b);
	}


	/**
   * set
   * @param a
   * @param b
   * @param c
   * @param d
   * @param e
   * @return
   */
  public bvec5 set(boolean a, boolean b, boolean c, boolean d, boolean e) {
  	this.x = a;
  	this.y = b;
  	this.z = c;
  	this.w = d;
  	this.e = e;
  	return this;
  }
  
  public bvec5 set(boolean arg){
    set(arg,arg,arg,arg,arg);
    return this;
  }

  public bvec5 set(bvec v) {
    if(v == null) {
      this.x = this.y = this.z = this.w = this.e = false;
    } else if(v instanceof bvec5 || v instanceof bvec6) {
      set(v.x,v.y,v.z,v.w,v.e);
    } else {
      set(v.x,v.y,v.z,v.w,false);
    }
  	return this;
  }
  
  public bvec5 set(boolean[] source) {
    if(source.length == 1) {
      set(source[0],this.y,this.z,this.w,this.e);
    } else if(source.length == 2) {
      set(source[0],source[1],this.z,this.w,this.e);
    } else if(source.length == 3) {
      set(source[0],source[1],source[2],this.w,this.e);
    } else if(source.length == 4) {
      set(source[0],source[1],source[2],source[3],this.e);
    } else if(source.length == 5) {
      set(source[0],source[1],source[2],source[3],source[4]);
    } else if(source.length > 5) {
      set(source[0],source[1],source[2],source[3],source[4]);
    }
    return this;
  }


  // abcde
  public bvec5 a(boolean a) {
    return set(a,this.y,this.z,this.w,this.e);
  }

  public bvec5 b(boolean b) {
    return set(this.x,b,this.z,this.w,this.e);
  }

  public bvec5 c(boolean c) {
    return set(this.x,this.y,c,this.w,this.e);
  }

  public bvec5 d(boolean d) {
    return set(this.x,this.y,this.z,d,this.e);
  }

  public bvec5 e(boolean e) {
    return set(this.x,this.y,this.z,this.w,e);
  }
	
	@Override 
	public String toString() {
		return "[ " + x + ", " + y + ", " + z + ", " + w + ", " + e + " ]";
	}
}
