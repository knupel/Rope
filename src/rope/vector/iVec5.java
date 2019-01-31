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
  	this.a = a;
  	this.b = b;
  	this.c = c;
  	this.d = d;
  	this.e = e;
  	return this;
  }
  
  public ivec5 set(int arg){
    set(arg,arg,arg,arg,arg);
    return this;
  }

  public ivec5 set(ivec v) {
    if(v == null) {
      this.a = this.b = this.c = this.d = this.e = 0;
      return this;
    } else if(v instanceof ivec5 || v instanceof ivec6) {
      set(v.a,v.b,v.c,v.d,v.e);
      return this;
    } else {
      set(v.x,v.y,v.z,v.w,0);
      return this;
    }
  }


  // abcde
  public ivec5 set_a(int a) {
    return set(a,this.b,this.c,this.d,this.e);
  }

  public ivec5 set_b(int b) {
    return set(this.a,b,this.c,this.d,this.e);
  }

  public ivec5 set_c(int c) {
    return set(this.a,this.b,c,this.d,this.e);
  }

  public ivec5 set_d(int d) {
    return set(this.a,this.b,this.c,d,this.e);
  }

  public ivec5 set_e(int e) {
    return set(this.a,this.b,this.c,this.d,e);
  }
  
  /**
   * get array component
   */
  public int [] get_array() {
    int array [] = {a,b,c,d,e};
    return array ;
  }
  
  /**
   * copy
   * @return
   */
  public ivec5 copy() {
    return new ivec5(a,b,c,d,e);
  }
  
  @Override 
  public String toString() {
    return "[ " + a + ", " + b + ", " + c + ", " + d + ", " + e + " ]";
  }

}
