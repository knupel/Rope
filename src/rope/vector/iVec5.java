/**
* ivec5 class
* v 1.2.0
* 2015-2019
* Vector class with a float precision
* @author @stanlepunk
* @see http://stanlepunk.xyz/
* @see https://github.com/StanLepunK/Rope
*/
package rope.vector;
public class ivec5 extends ivec {
  public ivec5() {
  	super(5);
  	set(0,0,0,0,0); 
  }

  public ivec5(int v) {
  	super(5);
  	set(v,v,v,v,v); 
  }

  public ivec5(int a, int b, int c, int d, int e) {
    super(5) ;
    set(a,b,c,d,e);
  }

  public ivec5(ivec v) {
    super(5) ;
    set(v);
  }

  public ivec5(int [] source) {
    super(5);
    set(source); 
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
  public ivec5 set(int a, int b, int c, int d, int e) {
  	this.x = a;
  	this.y = b;
  	this.z = c;
  	this.w = d;
  	this.e = e;
  	return this;
  }
  
  public ivec5 set(int arg){
    set(arg,arg,arg,arg,arg);
    return this;
  }

  public ivec5 set(ivec v) {
    if(v == null) {
      this.x = this.y = this.z = this.w = this.e = 0;
    } else if(v instanceof ivec5 || v instanceof ivec6) {
      set(v.x,v.y,v.z,v.w,v.e);
    } else {
      set(v.x,v.y,v.z,v.w,0);
    }
    return this;
  }

  public ivec5 set(vec v) {
    if(v == null) {
      this.x = this.y = this.z = this.w = this.e = 0;
    } else if(v instanceof vec5 || v instanceof vec6) {
      set((int)v.x,(int)v.y,(int)v.z,(int)v.w,(int)v.e);
    } else {
      set((int)v.x,(int)v.y,(int)v.z,(int)v.w,0);
    }
    return this;
  }
  
  public ivec5 set(int[] source) {
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
  public ivec5 a(int a) {
    return set(a,this.y,this.z,this.w,this.e);
  }

  public ivec5 b(int b) {
    return set(this.x,b,this.z,this.w,this.e);
  }

  public ivec5 c(int c) {
    return set(this.x,this.y,c,this.w,this.e);
  }

  public ivec5 d(int d) {
    return set(this.x,this.y,this.z,d,this.e);
  }

  public ivec5 e(int e) {
    return set(this.x,this.y,this.z,this.w,e);
  }
  

  
  /**
   * copy
   * @return
   */
  public ivec5 copy() {
    return new ivec5(x,y,z,w,e);
  }
  
  @Override 
  public String toString() {
    return "[ " + x + ", " + y + ", " + z + ", " + w + ", " + e + " ]";
  }

}
