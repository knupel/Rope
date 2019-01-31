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
  public ivec6(int a, int b, int c, int d, int e, int f) {
    super(6);
    set(a,b,c,d,e,f);
  }

  public ivec6(ivec v) {
    super(6);
    set(v);
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
  public ivec6 set(int a, int b, int c, int d, int e, int f) {
  	this.a = a;
  	this.b = b;
  	this.c = c;
  	this.d = d;
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
      this.a = this.b = this.c = this.d = this.e = this.f = 0;
      return this;
    } else if(v instanceof ivec5 || v instanceof ivec6) {
      set(v.a,v.b,v.c,v.d,v.e,v.f);
      return this;
    } else {
      set(v.x,v.y,v.z,v.w,0,0);
      return this;
    }
  }

  // abcdef
  public ivec6 set_a(int a) {
    return set(a,this.b,this.c,this.d,this.e,this.f);
  }

  public ivec6 set_b(int b) {
    return set(this.a,b,this.c,this.d,this.e,this.f);
  }

  public ivec6 set_c(int c) {
    return set(this.a,this.b,c,this.d,this.e,this.f);
  }

  public ivec6 set_d(int d) {
    return set(this.a,this.b,this.c,d,this.e,this.f);
  }

  public ivec6 set_e(int e) {
    return set(this.a,this.b,this.c,this.d,e,this.f);
  }

  public ivec6 set_f(int f) {
    return set(this.a,this.b,this.c,this.d,this.e,f);
  }
  
  /**
   * get array component
   */
  public int [] get_array() {
    int array [] = {a,b,c,d,e,f};
    return array ;
  }
  
  /**
   * copy
   * @return
   */
  public ivec6 copy() {
    return new ivec6(a,b,c,d,e,f);
  }
  
  
  @Override 
  public String toString() {
    return "[ " + a + ", " + b + ", " + c + ", " + d + ", " + e + ", " + f + " ]";
  }

}
