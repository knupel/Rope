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
      return this;
    } else if(v instanceof bvec5 || v instanceof bvec6) {
      set(v.a,v.b,v.c,v.d);
      return this;
    } else {
      set(v.x,v.y,v.z,v.w);
      return this;
    }
  }

  // xyzw
  public bvec4 set_x(boolean x) {
    return set(x,this.y,this.z,this.w);
  }

  public bvec4 set_y(boolean y) {
    return set(this.x,y,this.z,this.w);
  }

  public bvec4 set_z(boolean z) {
    return set(this.x,this.y,z,this.w);
  }

  public bvec4 set_w(boolean w) {
    return set(this.x,this.y,this.z,w);
  }

	
	@Override 
	public String toString() {
	    return "[ " + x + ", " + y + ", " + z + ", " + w + " ]" ;
	}
}
