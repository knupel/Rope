/**
* ivec6 class
* v 1.1.3
* 2015-2022
* Vector class with a int precision
* @author @stanlepunk
* @see https://github.com/StanLepunK/Rope
*/
package rope.vector;
public class ivec6 extends ivec {
	public ivec6() {
  	super(6);
  	set(0,0,0,0,0,0); 
  }

  public ivec6(int v) {
  	super(6);
  	set(v,v,v,v,v,v); 
  }

  public ivec6(Integer a, Integer b, Integer c, Integer d, Integer e, Integer f) {
    super(6);
    set(a,b,c,d,e,f);
  }

  public ivec6(ivec v) {
    super(6);
    set(v);
  }

  public ivec6(int [] source) {
    super(6);
    set(source); 
  }
  
  /**
   * set
   * @param a
   * @param b
   * @param c
   * @param d
   * @param e
   * @param f
   * @return
   */
  public ivec6 set(Integer a, Integer b, Integer c, Integer d, Integer e, Integer f) {
  	this.x = a;
  	this.y = b;
  	this.z = c;
  	this.w = d;
  	this.e = e;
  	this.f = f;
  	return this;
  }
  
  public ivec6 set(int arg){
    set(arg,arg,arg,arg,arg,arg);
    return this;
  }

  public ivec6 set(ivec v) {
    if(v == null) {
      this.x = this.y = this.z = this.w = this.e = this.f = 0;
    } else if(v instanceof ivec5 || v instanceof ivec6) {
      set(v.x,v.y,v.z,v.w,v.e,v.f);
    } else {
      set(v.x,v.y,v.z,v.w,0,0);
    }
    return this;
  }

  public ivec6 set(vec v) {
    if(v == null) {
      this.x = this.y = this.z = this.w = this.e = this.f = 0;
    } else if(v instanceof vec5 || v instanceof vec6) {
      set((int)v.x,(int)v.y,(int)v.z,(int)v.w,(int)v.e,(int)v.f);
    } else {
      set((int)v.x,(int)v.y,(int)v.z,(int)v.w,0,0);
    }
    return this;
  }
  
  public ivec6 set(int[] source) {
    if(source.length == 1) {
      set(source[0],this.y,this.z,this.w,this.e,this.f);
    } else if(source.length == 2) {
      set(source[0],source[1],this.z,this.w,this.e,this.f);
    } else if(source.length == 3) {
      set(source[0],source[1],source[2],this.w,this.e,this.f);
    } else if(source.length == 4) {
      set(source[0],source[1],source[2],source[3],this.e,this.f);
    } else if(source.length == 5) {
      set(source[0],source[1],source[2],source[3],source[4],this.f);
    } else if(source.length == 6) {
      set(source[0],source[1],source[2],source[3],source[4],source[5]);
    } else if(source.length > 6) {
      set(source[0],source[1],source[2],source[3],source[4],source[5]);
    }
    return this;
  }
  
  public ivec6 set_to(int index, int arg) {
  	if(index == 0) a(arg);
  	if(index == 1) b(arg);
  	if(index == 2) c(arg);
  	if(index == 3) d(arg);
  	if(index == 4) e(arg);
  	if(index == 5) f(arg);
  	return this;
  }

  /**
	 * 
	 * @return inverse all argument
	 */
	public ivec6 inv() {
		inv_impl();
		return this;
	}
  

  // abcdef
  public ivec6 a(int a) {
    return set(a,this.y,this.z,this.w,this.e,this.f);
  }

  public ivec6 b(int b) {
    return set(this.x,b,this.z,this.w,this.e,this.f);
  }

  public ivec6 c(int c) {
    return set(this.x,this.y,c,this.w,this.e,this.f);
  }

  public ivec6 d(int d) {
    return set(this.x,this.y,this.z,d,this.e,this.f);
  }

  public ivec6 e(int e) {
    return set(this.x,this.y,this.z,this.w,e,this.f);
  }

  public ivec6 f(int f) {
    return set(this.x,this.y,this.z,this.w,this.e,f);
  }
  
  
  /**
   * copy
   * @return
   */
  public ivec6 copy() {
    return new ivec6(x,y,z,w,e,f);
  }
  
  
  @Override 
  public String toString() {
    return "[ " + x + ", " + y + ", " + z + ", " + w + ", " + e + ", " + f + " ]";
  }

}
