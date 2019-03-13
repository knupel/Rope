/**
* vec5 class
* v 1.2.0
* 2015-2019
* Processing 3.5.3
* Vector class with a float precision
* @author @stanlepunk
* @see http://stanlepunk.xyz/
* @see https://github.com/StanLepunK/Rope
*/
package rope.vector;
public class vec5 extends vec {
  public vec5() {
  	super(5);
  	set(0,0,0,0,0);
  }
  
  public vec5(float v) {
  	super(5);
  	set(v,v,v,v,v);
  }

  public vec5(float a, float b, float c, float d, float e) {
    super(5) ;
    set(a,b,c,d,e);
  }

  public vec5(vec v) {
    super(5);
    set(v);
  }

  public vec5(ivec v) {
    super(5);
    set(v.x,v.y,v.z,v.w,v.e);
  }

  public vec5(float [] source) {
    super(5);
    set(source);
  }

  public vec5(int [] source) {
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
  public vec5 set(float a,float b, float c, float d, float e) {
  	this.x = a;
  	this.y = b;
  	this.z = c;
  	this.w = d;
  	this.e = e;
  	return this;
  }
  
  public vec5 set(float v) {
    set(v,v,v,v,v);
    return this;
  }
  
  public vec5 set(vec v) {
    if( v == null) {
      this.x = this.y = this.z = this.w = this.e = 0;
    } else if(v instanceof vec5 || v instanceof vec6) {
      set(v.x,v.y,v.z,v.w,v.e);
    } else {
      set(v.x,v.y,v.z,v.w,0);   
    }
    return this;
  }

  public vec5 set(ivec v) {
    if( v == null) {
      this.x = this.y = this.z = this.w = this.e = 0 ;
    } else if(v instanceof ivec5 || v instanceof ivec6) {
      set(v.x,v.y,v.z,v.w,v.e);
    } else {
      set(v.x,v.y,v.z,v.w,0);
    }
    return this;
  }
  
  public vec5 set(float[] source) {
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

  public vec5 set(int[] source) {
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
  public vec5 a(float a) {
    return set(a,this.y,this.z,this.w,this.e);
  }

  public vec5 b(float b) {
    return set(this.x,b,this.z,this.w,this.e);
  }

  public vec5 c(float c) {
    return set(this.x,this.y,c,this.w,this.e);
  }

  public vec5 d(float d) {
    return set(this.x,this.y,this.z,d,this.e);
  }

  public vec5 e(float e) {
    return set(this.x,this.y,this.z,this.w,e);
  }
  
  
  
  
  /**
   * copy
   * @return
   */
  public vec5 copy() {
    return new vec5(x,y,z,w,e) ;
  }
  
  @Override 
  public String toString() {
    return "[ " + x + ", " + y + ", " + z + ", " + w + ", " + e + " ]";
  }
}
