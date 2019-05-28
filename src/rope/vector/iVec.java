/**
* ivec class
* v 2.0.0
* 2015-2018
* Vector with a integer precision
* @author @stanlepunk
* @see http://stanlepunk.xyz
* @see https://github.com/StanLepunK/Rope
*/
package rope.vector;
import rope.core.BigBang;
public abstract class ivec extends BigBang {
	private int num;
	public int x,y,z,w;
	public int e,f; // for ivec5 and ivec6
	public int s,t,p,q;
	public int u,v;
	

	public ivec(int num) {
		this.num = num;
	}
	
	/**
	 * @return the number of component
	 */
	public int get_num() {
		return num;
	}


    /**
  * return the list of component
  * @return int []
  */
  public int [] array() {
    if(num == 2) {
      int array [] = {x,y};
      return array;
    } else if(num == 3) {
      int array [] = {x,y,z};
      return array;
    } else if(num == 4) {
      int array [] = {x,y,z,w};
      return array;
    } else if(num == 5) {
      int array [] = {x,y,z,w,e};
      return array;
    } else if(num == 6) {
      int array [] = {x,y,z,w,e,f};
      return array;
    } else return null ;
  }

  /**
  * max
  * find the min and the max value in the vector list
  * @return int
  */
  public int max() {
    int [] list = new int[num];
    if(num == 2) {
      list[0] = x;
      list[1] = y;
    } else if(num == 3) {
      list[0] = x;
      list[1] = y;
      list[2] = z;
    } else if(num == 4) {
      list[0] = x;
      list[1] = y;
      list[2] = z;
      list[3] = w;
    } else if(num == 5) {
      list[0] = x;
      list[1] = y;
      list[2] = z;
      list[3] = w;
      list[4] = e;
    } else if(num == 6) {
      list[0] = x;
      list[1] = y;
      list[2] = z;
      list[3] = w;
      list[4] = e;
      list[5] = f;
    } 
    return max(list);
  }
  /**
  * min
  * find the min and the max value in the vector list
  * @return int
  */
  public int min() {
    int [] list = new int[num];
    if(num == 2) {
      list[0] = x;
      list[1] = y;
    } else if(num == 3) {
      list[0] = x;
      list[1] = y;
      list[2] = z;
    } else if(num == 4) {
      list[0] = x;
      list[1] = y;
      list[2] = z;
      list[3] = w;
    } else if(num == 5) {
      list[0] = x;
      list[1] = y;
      list[2] = z;
      list[3] = w;
      list[4] = e;
    } else if(num == 6) {
      list[0] = x;
      list[1] = y;
      list[2] = z;
      list[3] = w;
      list[4] = e;
      list[5] = e;
    } 
    return min(list);
  }


	
	/**
	 * return single int component
	 * @return int
	 */
	public int x() {
		return x;
	}

	public int y() {
		return y;
	}

	public int z() {
		return z;
	}

	public int w() {
		return w;
	}
	  
	public int a() {
		return x;
	}
	  
	public int b() {
		return y;
	}

	public int c() {
		return z;
	}

	public int d() {
		return w;
	}

	public int e() {
		return e;
	}

	public int f() {
		return f;
	}

	public int s() {
		return s;
	}

	public int t() {
		return t;
	}

	public int p() {
		return p;
	}

	public int q() {
		return q;
	}

	public int u() {
		return u;
	}

	public int v() {
		return v;
	}

  // rgb
  public int red() {
    return x;
  }

  public int gre() {
    return y;
  }

  public int blu() {
    return z;
  }

  // hsb
  public int hue() {
    return x;
  }

  public int sat() {
    return y;
  }

  public int bri() {
    return z;
  }
  
  // alpha
  public int alp() {
    return w;
  }


	/**
   * return multi float component
   * @return float
   */

  // special
  public ivec2 uv() {
    return new ivec2(x,y);
  }

  public ivec2 st() {
    return new ivec2(x,y);
  }

  public ivec2 pq() {
    return new ivec2(z,w);
  }

  public ivec3 rgb() {
    return new ivec3(x,y,z);
  }

  public ivec3 hsb() {
    return new ivec3(x,y,z);
  }

  public ivec4 stpq() {
    return new ivec4(x,y,z,w);
  }

  public ivec4 rgba() {
    return new ivec4(x,y,z,w);
  }

  public ivec4 hsba() {
    return new ivec4(x,y,z,w);
  }

  public ivec2 ab() {
    return new ivec2(x,y);
  }

  public ivec3 abc() {
    return new ivec3(x,y,z);
  }

  public ivec4 abcd() {
    return new ivec4(x,y,z,w);
  }

  public ivec5 abcde() {
    return new ivec5(x,y,z,w,e);
  }

  public ivec6 abcdef() {
    return new ivec6(x,y,z,w,e,f);
  }



  // XYZW
  public ivec2 ww() {
    return new ivec2(w,w);
  }
  
  public ivec2 wx() {
    return new ivec2(w,x);
  }
  
  public ivec2 wy() {
  	return new ivec2(w,y);
  }
  
  public ivec2 wz() {
  	return new ivec2(w,z);
  }
  
  public ivec2 xw() {
    return new ivec2(x,w);
  }
  
  public ivec2 xx() {
    return new ivec2(x,x);
  }

  public ivec2 xy() {
    return new ivec2(x,y);
  }
  
  public ivec2 xz() {
    return new ivec2(x,z);
  }
  
  public ivec2 yw() {
    return new ivec2(y,w);
  }
  
  public ivec2 yx() {
    return new ivec2(y,x);
  }

  public ivec2 yy() {
    return new ivec2(y,y);
  }
  
  public ivec2 yz() {
    return new ivec2(y,z);
  }
  
  public ivec2 zw() {
    return new ivec2(z,w);
  }
  
  public ivec2 zx() {
    return new ivec2(z,x);
  }
  
  public ivec2 zy() {
    return new ivec2(z,y);
  }

  public ivec2 zz() {
    return new ivec2(z,z);
  }
  
  // w3
  public ivec3 www() {
    return new ivec3(w,w,w);
  }
  
  public ivec3 wwx() {
    return new ivec3(w,w,x);
  }
  
  public ivec3 wwy() {
    return new ivec3(w,w,y);
  }
  
  public ivec3 wwz() {
    return new ivec3(w,w,z);
  }
  
  public ivec3 wxw() {
    return new ivec3(w,x,w);
  }
  
  public ivec3 wxx() {
    return new ivec3(w,x,x);
  }
  
  public ivec3 wxy() {
    return new ivec3(w,x,y);
  }
  
  public ivec3 wxz() {
    return new ivec3(w,x,z);
  }
  
  public ivec3 wyw() {
    return new ivec3(w,y,w);
  }
  
  public ivec3 wyx() {
    return new ivec3(w,y,x);
  }
  
  public ivec3 wyy() {
    return new ivec3(w,y,y);
  }
  
  public ivec3 wyz() {
    return new ivec3(w,y,z);
  }
  
  public ivec3 wzw() {
    return new ivec3(w,z,w);
  }
  
  public ivec3 wzx() {
    return new ivec3(w,z,x);
  }
  
  public ivec3 wzy() {
    return new ivec3(w,z,y);
  }
  
  public ivec3 wzz() {
    return new ivec3(w,z,z);
  }
  
  // x3
  public ivec3 xww() {
    return new ivec3(x,w,w);
  }
  
  public ivec3 xwx() {
    return new ivec3(x,w,x);
  }
  
  public ivec3 xwy() {
    return new ivec3(x,w,y);
  }
  
  public ivec3 xwz() {
    return new ivec3(x,w,z);
  }
  
  public ivec3 xxw() {
    return new ivec3(x,x,w);
  }
  
  public ivec3 xxx() {
    return new ivec3(x,x,x);
  }
  
  public ivec3 xxy() {
    return new ivec3(x,x,y);
  }
  
  public ivec3 xxz() {
    return new ivec3(x,x,z);
  }
  
  public ivec3 xyw() {
    return new ivec3(x,y,w);
  }
  
  public ivec3 xyx() {
    return new ivec3(x,y,x);
  }
  
  public ivec3 xyy() {
    return new ivec3(x,y,y);
  }
  
  public ivec3 xyz() {
    return new ivec3(x,y,z);
  }
  
  public ivec3 xzw() {
    return new ivec3(x,z,w);
  }
  
  public ivec3 xzx() {
    return new ivec3(x,z,x);
  }
  
  public ivec3 xzy() {
    return new ivec3(x,z,y);
  }
  
  // y3
  public ivec3 yww() {
    return new ivec3(y,w,w);
  }
  
  public ivec3 ywx() {
    return new ivec3(y,w,x);
  }
  
  public ivec3 ywy() {
    return new ivec3(y,w,y);
  }
  
  public ivec3 ywz() {
    return new ivec3(y,w,z);
  }
  
  public ivec3 yxw() {
    return new ivec3(y,x,w);
  }
  
  public ivec3 yxx() {
    return new ivec3(y,x,x);
  }
  
  public ivec3 yxy() {
    return new ivec3(y,x,y);
  }
  
  public ivec3 yxz() {
    return new ivec3(y,x,z);
  }
  
  public ivec3 yyw() {
    return new ivec3(y,y,w);
  }
  
  public ivec3 yyx() {
    return new ivec3(y,y,x);
  }
  
  public ivec3 yyy() {
    return new ivec3(y,y,y);
  }
  
  public ivec3 yyz() {
    return new ivec3(y,y,z);
  }
  
  
  public ivec3 yzw() {
    return new ivec3(y,z,w);
  }
  
  public ivec3 yzx() {
    return new ivec3(y,z,x);
  }
  
  public ivec3 yzy() {
    return new ivec3(y,z,y);
  }
  
  // z3
  public ivec3 zww() {
    return new ivec3(z,w,w);
  }
  
  public ivec3 zwx() {
    return new ivec3(z,w,x);
  }
  
  public ivec3 zwy() {
    return new ivec3(z,w,y);
  }
  
  public ivec3 zwz() {
    return new ivec3(z,w,z);
  }
  
  public ivec3 zxw() {
    return new ivec3(z,x,w);
  }
  
  public ivec3 zxx() {
    return new ivec3(z,x,x);
  }
  
  public ivec3 zxy() {
    return new ivec3(z,x,y);
  }
  
  public ivec3 zxz() {
    return new ivec3(z,x,z);
  }
  
  public ivec3 zyw() {
    return new ivec3(z,y,w);
  }
  
  public ivec3 zyx() {
    return new ivec3(z,y,x);
  }
  
  public ivec3 zyy() {
    return new ivec3(z,y,y);
  }
  
  public ivec3 zyz() {
    return new ivec3(z,y,z);
  }
  
  public ivec3 zzw() {
    return new ivec3(z,z,w);
  }
  
  public ivec3 zzx() {
    return new ivec3(z,z,x);
  }
  
  public ivec3 zzy() {
    return new ivec3(z,z,y);
  }
  public ivec3 zzz() {
    return new ivec3(z,z,z);
  }
  
  
  
  // W4
  // w3
  public ivec4 wwww() {
    return new ivec4(w,w,w,w);
  }
  
  public ivec4 wwwx() {
    return new ivec4(w,w,w,x);
  }
  
  public ivec4 wwwy() {
    return new ivec4(w,w,w,y);
  }
  
  public ivec4 wwwz() {
    return new ivec4(w,w,w,z);
  }
  
  public ivec4 wwxw() {
    return new ivec4(w,w,x,w);
  }
  
  public ivec4 wwxx() {
    return new ivec4(w,w,x,x);
  }
  
  public ivec4 wwxy() {
    return new ivec4(w,w,x,y);
  }
  
  public ivec4 wwxz() {
    return new ivec4(w,w,x,z);
  }
  
  public ivec4 wwyw() {
    return new ivec4(w,w,y,w);
  }
  
  public ivec4 wwyx() {
    return new ivec4(w,w,y,x);
  }
  
  public ivec4 wwyy() {
    return new ivec4(w,w,y,y);
  }
  
  public ivec4 wwyz() {
    return new ivec4(w,w,y,z);
  }
  
  public ivec4 wwzw() {
    return new ivec4(w,w,z,w);
  }
  
  public ivec4 wwzx() {
    return new ivec4(w,w,z,x);
  }
  
  public ivec4 wwzy() {
    return new ivec4(w,w,z,y);
  }
  
  public ivec4 wwzz() {
    return new ivec4(w,w,z,z);
  }
  
  // x3
  public ivec4 wxww() {
    return new ivec4(w,x,w,w);
  }
  
  public ivec4 wxwx() {
    return new ivec4(w,x,w,x);
  }
  
  public ivec4 wxwy() {
    return new ivec4(w,x,w,y);
  }
  
  public ivec4 wxwz() {
    return new ivec4(w,x,w,z);
  }
  
  public ivec4 wxxw() {
    return new ivec4(w,x,x,w);
  }
  
  public ivec4 wxxx() {
    return new ivec4(w,x,x,x);
  }
  
  public ivec4 wxxy() {
    return new ivec4(w,x,x,y);
  }
  
  public ivec4 wxxz() {
    return new ivec4(w,x,x,z);
  }
  
  public ivec4 wxyw() {
    return new ivec4(w,x,y,w);
  }
  
  public ivec4 wxyx() {
    return new ivec4(w,x,y,x);
  }
  
  public ivec4 wxyy() {
    return new ivec4(w,x,y,y);
  }
  
  public ivec4 wxyz() {
    return new ivec4(w,x,y,z);
  }
  
  public ivec4 wxzw() {
    return new ivec4(w,x,z,w);
  }
  
  public ivec4 wxzx() {
    return new ivec4(w,x,z,x);
  }
  
  public ivec4 wxzy() {
    return new ivec4(w,x,z,y);
  }
  
  // y3
  public ivec4 wyww() {
    return new ivec4(w,y,w,w);
  }
  
  public ivec4 wywx() {
    return new ivec4(w,y,w,x);
  }
  
  public ivec4 wywy() {
    return new ivec4(w,y,w,y);
  }
  
  public ivec4 wywz() {
    return new ivec4(w,y,w,z);
  }
  
  public ivec4 wyxw() {
    return new ivec4(w,y,x,w);
  }
  
  public ivec4 wyxx() {
    return new ivec4(w,y,x,x);
  }
  
  public ivec4 wyxy() {
    return new ivec4(w,y,x,y);
  }
  
  public ivec4 wyxz() {
    return new ivec4(w,y,x,z);
  }
  
  public ivec4 wyyw() {
    return new ivec4(w,y,y,w);
  }
  
  public ivec4 wyyx() {
    return new ivec4(w,y,y,x);
  }
  
  public ivec4 wyyy() {
    return new ivec4(w,y,y,y);
  }
  
  public ivec4 wyyz() {
    return new ivec4(w,y,y,z);
  }
  
  
  public ivec4 wyzw() {
    return new ivec4(w,y,z,w);
  }
  
  public ivec4 wyzx() {
    return new ivec4(w,y,z,x);
  }
  
  public ivec4 wyzy() {
    return new ivec4(w,y,z,y);
  }
  
  // z3
  public ivec4 wzww() {
    return new ivec4(w,z,w,w);
  }
  
  public ivec4 wzwx() {
    return new ivec4(w,z,w,x);
  }
  
  public ivec4 wzwy() {
    return new ivec4(w,z,w,y);
  }
  
  public ivec4 wzwz() {
    return new ivec4(w,z,w,z);
  }
  
  public ivec4 wzxw() {
    return new ivec4(w,z,x,w);
  }
  
  public ivec4 wzxx() {
    return new ivec4(w,z,x,x);
  }
  
  public ivec4 wzxy() {
    return new ivec4(w,z,x,y);
  }
  
  public ivec4 wzxz() {
    return new ivec4(w,z,x,z);
  }
  
  public ivec4 wzyw() {
    return new ivec4(w,z,y,w);
  }
  
  public ivec4 wzyx() {
    return new ivec4(w,z,y,x);
  }
  
  public ivec4 wzyy() {
    return new ivec4(w,z,y,y);
  }
  
  public ivec4 wzyz() {
    return new ivec4(w,z,y,z);
  }
  
  public ivec4 wzzw() {
    return new ivec4(w,z,z,w);
  }
  
  public ivec4 wzzx() {
    return new ivec4(w,z,z,x);
  }
  
  public ivec4 wzzy() {
    return new ivec4(w,z,z,y);
  }
  public ivec4 wzzz() {
    return new ivec4(w,z,z,z);
  }





  // X4
  // w3
  public ivec4 xwww() {
    return new ivec4(x,w,w,w);
  }
  
  public ivec4 xwwx() {
    return new ivec4(x,w,w,x);
  }
  
  public ivec4 xwwy() {
    return new ivec4(x,w,w,y);
  }
  
  public ivec4 xwwz() {
    return new ivec4(x,w,w,z);
  }
  
  public ivec4 xwxw() {
    return new ivec4(x,w,x,w);
  }
  
  public ivec4 xwxx() {
    return new ivec4(x,w,x,x);
  }
  
  public ivec4 xwxy() {
    return new ivec4(x,w,x,y);
  }
  
  public ivec4 xwxz() {
    return new ivec4(x,w,x,z);
  }
  
  public ivec4 xwyw() {
    return new ivec4(x,w,y,w);
  }
  
  public ivec4 xwyx() {
    return new ivec4(x,w,y,x);
  }
  
  public ivec4 xwyy() {
    return new ivec4(x,w,y,y);
  }
  
  public ivec4 xwyz() {
    return new ivec4(x,w,y,z);
  }
  
  public ivec4 xwzw() {
    return new ivec4(x,w,z,w);
  }
  
  public ivec4 xwzx() {
    return new ivec4(x,w,z,x);
  }
  
  public ivec4 xwzy() {
    return new ivec4(x,w,z,y);
  }
  
  public ivec4 xwzz() {
    return new ivec4(x,w,z,z);
  }
  
  // x3
  public ivec4 xxww() {
    return new ivec4(x,x,w,w);
  }
  
  public ivec4 xxwx() {
    return new ivec4(x,x,w,x);
  }
  
  public ivec4 xxwy() {
    return new ivec4(x,x,w,y);
  }
  
  public ivec4 xxwz() {
    return new ivec4(x,x,w,z);
  }
  
  public ivec4 xxxw() {
    return new ivec4(x,x,x,w);
  }
  
  public ivec4 xxxx() {
    return new ivec4(x,x,x,x);
  }
  
  public ivec4 xxxy() {
    return new ivec4(x,x,x,y);
  }
  
  public ivec4 xxxz() {
    return new ivec4(x,x,x,z);
  }
  
  public ivec4 xxyw() {
    return new ivec4(x,x,y,w);
  }
  
  public ivec4 xxyx() {
    return new ivec4(x,x,y,x);
  }
  
  public ivec4 xxyy() {
    return new ivec4(x,x,y,y);
  }
  
  public ivec4 xxyz() {
    return new ivec4(x,x,y,z);
  }
  
  public ivec4 xxzw() {
    return new ivec4(x,x,z,w);
  }
  
  public ivec4 xxzx() {
    return new ivec4(x,x,z,x);
  }
  
  public ivec4 xxzy() {
    return new ivec4(x,x,z,y);
  }
  
  // y3
  public ivec4 xyww() {
    return new ivec4(x,y,w,w);
  }
  
  public ivec4 xywx() {
    return new ivec4(x,y,w,x);
  }
  
  public ivec4 xywy() {
    return new ivec4(x,y,w,y);
  }
  
  public ivec4 xywz() {
    return new ivec4(x,y,w,z);
  }
  
  public ivec4 xyxw() {
    return new ivec4(x,y,x,w);
  }
  
  public ivec4 xyxx() {
    return new ivec4(x,y,x,x);
  }
  
  public ivec4 xyxy() {
    return new ivec4(x,y,x,y);
  }
  
  public ivec4 xyxz() {
    return new ivec4(x,y,x,z);
  }
  
  public ivec4 xyyw() {
    return new ivec4(x,y,y,w);
  }
  
  public ivec4 xyyx() {
    return new ivec4(x,y,y,x);
  }
  
  public ivec4 xyyy() {
    return new ivec4(x,y,y,y);
  }
  
  public ivec4 xyyz() {
    return new ivec4(x,y,y,z);
  }
  
  public ivec4 xyzw() {
    return new ivec4(x,y,z,w);
  }
  
  public ivec4 xyzx() {
    return new ivec4(x,y,z,x);
  }
  
  public ivec4 xyzy() {
    return new ivec4(x,y,z,y);
  }
  
  // z3
  public ivec4 xzww() {
    return new ivec4(x,z,w,w);
  }
  
  public ivec4 xzwx() {
    return new ivec4(x,z,w,x);
  }
  
  public ivec4 xzwy() {
    return new ivec4(x,z,w,y);
  }
  
  public ivec4 xzwz() {
    return new ivec4(x,z,w,z);
  }
  
  public ivec4 xzxw() {
    return new ivec4(x,z,x,w);
  }
  
  public ivec4 xzxx() {
    return new ivec4(x,z,x,x);
  }
  
  public ivec4 xzxy() {
    return new ivec4(x,z,x,y);
  }
  
  public ivec4 xzxz() {
    return new ivec4(x,z,x,z);
  }
  
  public ivec4 xzyw() {
    return new ivec4(x,z,y,w);
  }
  
  public ivec4 xzyx() {
    return new ivec4(x,z,y,x);
  }
  
  public ivec4 xzyy() {
    return new ivec4(x,z,y,y);
  }
  
  public ivec4 xzyz() {
    return new ivec4(x,z,y,z);
  }
  
  public ivec4 xzzw() {
    return new ivec4(x,z,z,w);
  }
  
  public ivec4 xzzx() {
    return new ivec4(x,z,z,x);
  }
  
  public ivec4 xzzy() {
    return new ivec4(x,z,z,y);
  }
  public ivec4 xzzz() {
    return new ivec4(x,z,z,z);
  }





  // Y4
  // w3
  public ivec4 ywww() {
    return new ivec4(y,w,w,w);
  }
  
  public ivec4 ywwx() {
    return new ivec4(y,w,w,x);
  }
  
  public ivec4 ywwy() {
    return new ivec4(y,w,w,y);
  }
  
  public ivec4 ywwz() {
    return new ivec4(y,w,w,z);
  }
  
  public ivec4 ywxw() {
    return new ivec4(y,w,x,w);
  }
  
  public ivec4 ywxx() {
    return new ivec4(y,w,x,x);
  }
  
  public ivec4 ywxy() {
    return new ivec4(y,w,x,y);
  }
  
  public ivec4 ywxz() {
    return new ivec4(y,w,x,z);
  }
  
  public ivec4 ywyw() {
    return new ivec4(y,w,y,w);
  }
  
  public ivec4 ywyx() {
    return new ivec4(y,w,y,x);
  }
  
  public ivec4 ywyy() {
    return new ivec4(y,w,y,y);
  }
  
  public ivec4 ywyz() {
    return new ivec4(y,w,y,z);
  }
  
  public ivec4 ywzw() {
    return new ivec4(y,w,z,w);
  }
  
  public ivec4 ywzx() {
    return new ivec4(y,w,z,x);
  }
  
  public ivec4 ywzy() {
    return new ivec4(y,w,z,y);
  }
  
  public ivec4 ywzz() {
    return new ivec4(y,w,z,z);
  }
  
  // x3
  public ivec4 yxww() {
    return new ivec4(y,x,w,w);
  }
  
  public ivec4 yxwx() {
    return new ivec4(y,x,w,x);
  }
  
  public ivec4 yxwy() {
    return new ivec4(y,x,w,y);
  }
  
  public ivec4 yxwz() {
    return new ivec4(y,x,w,z);
  }
  
  public ivec4 yxxw() {
    return new ivec4(y,x,x,w);
  }
  
  public ivec4 yxxx() {
    return new ivec4(y,x,x,x);
  }
  
  public ivec4 yxxy() {
    return new ivec4(y,x,x,y);
  }
  
  public ivec4 yxxz() {
    return new ivec4(y,x,x,z);
  }
  
  public ivec4 yxyw() {
    return new ivec4(y,x,y,w);
  }
  
  public ivec4 yxyx() {
    return new ivec4(y,x,y,x);
  }
  
  public ivec4 yxyy() {
    return new ivec4(y,x,y,y);
  }
  
  public ivec4 yxyz() {
    return new ivec4(y,x,y,z);
  }
  
  public ivec4 yxzw() {
    return new ivec4(y,x,z,w);
  }
  
  public ivec4 yxzx() {
    return new ivec4(y,x,z,x);
  }
  
  public ivec4 yxzy() {
    return new ivec4(y,x,z,y);
  }
  
  // y3
  public ivec4 yyww() {
    return new ivec4(y,y,w,w);
  }
  
  public ivec4 yywx() {
    return new ivec4(y,y,w,x);
  }
  
  public ivec4 yywy() {
    return new ivec4(y,y,w,y);
  }
  
  public ivec4 yywz() {
    return new ivec4(y,y,w,z);
  }
  
  public ivec4 yyxw() {
    return new ivec4(y,y,x,w);
  }
  
  public ivec4 yyxx() {
    return new ivec4(y,y,x,x);
  }
  
  public ivec4 yyxy() {
    return new ivec4(y,y,x,y);
  }
  
  public ivec4 yyxz() {
    return new ivec4(y,y,x,z);
  }
  
  public ivec4 yyyw() {
    return new ivec4(y,y,y,w);
  }
  
  public ivec4 yyyx() {
    return new ivec4(y,y,y,x);
  }
  
  public ivec4 yyyy() {
    return new ivec4(y,y,y,y);
  }
  
  public ivec4 yyyz() {
    return new ivec4(y,y,y,z);
  }
  
  public ivec4 yyzw() {
    return new ivec4(y,y,z,w);
  }
  
  public ivec4 yyzx() {
    return new ivec4(y,y,z,x);
  }
  
  public ivec4 yyzy() {
    return new ivec4(y,y,z,y);
  }
  
  // z3
  public ivec4 yzww() {
    return new ivec4(y,z,w,w);
  }
  
  public ivec4 yzwx() {
    return new ivec4(y,z,w,x);
  }
  
  public ivec4 yzwy() {
    return new ivec4(y,z,w,y);
  }
  
  public ivec4 yzwz() {
    return new ivec4(y,z,w,z);
  }
  
  public ivec4 yzxw() {
    return new ivec4(y,z,x,w);
  }
  
  public ivec4 yzxx() {
    return new ivec4(y,z,x,x);
  }
  
  public ivec4 yzxy() {
    return new ivec4(y,z,x,y);
  }
  
  public ivec4 yzxz() {
    return new ivec4(y,z,x,z);
  }
  
  public ivec4 yzyw() {
    return new ivec4(y,z,y,w);
  }
  
  public ivec4 yzyx() {
    return new ivec4(y,z,y,x);
  }
  
  public ivec4 yzyy() {
    return new ivec4(y,z,y,y);
  }
  
  public ivec4 yzyz() {
    return new ivec4(y,z,y,z);
  }
  
  public ivec4 yzzw() {
    return new ivec4(y,z,z,w);
  }
  
  public ivec4 yzzx() {
    return new ivec4(y,z,z,x);
  }
  
  public ivec4 yzzy() {
    return new ivec4(y,z,z,y);
  }
  public ivec4 yzzz() {
    return new ivec4(y,z,z,z);
  }






  // Z4
  // w3
  public ivec4 zwww() {
    return new ivec4(z,w,w,w);
  }
  
  public ivec4 zwwx() {
    return new ivec4(z,w,w,x);
  }
  
  public ivec4 zwwy() {
    return new ivec4(z,w,w,y);
  }
  
  public ivec4 zwwz() {
    return new ivec4(z,w,w,z);
  }
  
  public ivec4 zwxw() {
    return new ivec4(z,w,x,w);
  }
  
  public ivec4 zwxx() {
    return new ivec4(z,w,x,x);
  }
  
  public ivec4 zwxy() {
    return new ivec4(z,w,x,y);
  }
  
  public ivec4 zwxz() {
    return new ivec4(z,w,x,z);
  }
  
  public ivec4 zwyw() {
    return new ivec4(z,w,y,w);
  }
  
  public ivec4 zwyx() {
    return new ivec4(z,w,y,x);
  }
  
  public ivec4 zwyy() {
    return new ivec4(z,w,y,y);
  }
  
  public ivec4 zwyz() {
    return new ivec4(z,w,y,z);
  }
  
  public ivec4 zwzw() {
    return new ivec4(z,w,z,w);
  }
  
  public ivec4 zwzx() {
    return new ivec4(z,w,z,x);
  }
  
  public ivec4 zwzy() {
    return new ivec4(z,w,z,y);
  }
  
  public ivec4 zwzz() {
    return new ivec4(z,w,z,z);
  }
  
  // x3
  public ivec4 zxww() {
    return new ivec4(z,x,w,w);
  }
  
  public ivec4 zxwx() {
    return new ivec4(z,x,w,x);
  }
  
  public ivec4 zxwy() {
    return new ivec4(z,x,w,y);
  }
  
  public ivec4 zxwz() {
    return new ivec4(z,x,w,z);
  }
  
  public ivec4 zxxw() {
    return new ivec4(z,x,x,w);
  }
  
  public ivec4 zxxx() {
    return new ivec4(z,x,x,x);
  }
  
  public ivec4 zxxy() {
    return new ivec4(z,x,x,y);
  }
  
  public ivec4 zxxz() {
    return new ivec4(z,x,x,z);
  }
  
  public ivec4 zxyw() {
    return new ivec4(z,x,y,w);
  }
  
  public ivec4 zxyx() {
    return new ivec4(z,x,y,x);
  }
  
  public ivec4 zxyy() {
    return new ivec4(z,x,y,y);
  }
  
  public ivec4 zxyz() {
    return new ivec4(z,x,y,z);
  }
  
  public ivec4 zxzw() {
    return new ivec4(z,x,z,w);
  }
  
  public ivec4 zxzx() {
    return new ivec4(z,x,z,x);
  }
  
  public ivec4 zxzy() {
    return new ivec4(z,x,z,y);
  }
  
  // y3
  public ivec4 zyww() {
    return new ivec4(z,y,w,w);
  }
  
  public ivec4 zywx() {
    return new ivec4(z,y,w,x);
  }
  
  public ivec4 zywy() {
    return new ivec4(z,y,w,y);
  }
  
  public ivec4 zywz() {
    return new ivec4(z,y,w,z);
  }
  
  public ivec4 zyxw() {
    return new ivec4(z,y,x,w);
  }
  
  public ivec4 zyxx() {
    return new ivec4(z,y,x,x);
  }
  
  public ivec4 zyxy() {
    return new ivec4(z,y,x,y);
  }
  
  public ivec4 zyxz() {
    return new ivec4(z,y,x,z);
  }
  
  public ivec4 zyyw() {
    return new ivec4(z,y,y,w);
  }
  
  public ivec4 zyyx() {
    return new ivec4(z,y,y,x);
  }
  
  public ivec4 zyyy() {
    return new ivec4(z,y,y,y);
  }
  
  public ivec4 zyyz() {
    return new ivec4(z,y,y,z);
  }
  
  public ivec4 zyzw() {
    return new ivec4(z,y,z,w);
  }
  
  public ivec4 zyzx() {
    return new ivec4(z,y,z,x);
  }
  
  public ivec4 zyzy() {
    return new ivec4(z,y,z,y);
  }
  
  // z3
  public ivec4 zzww() {
    return new ivec4(z,z,w,w);
  }
  
  public ivec4 zzwx() {
    return new ivec4(z,z,w,x);
  }
  
  public ivec4 zzwy() {
    return new ivec4(z,z,w,y);
  }
  
  public ivec4 zzwz() {
    return new ivec4(z,z,w,z);
  }
  
  public ivec4 zzxw() {
    return new ivec4(z,z,x,w);
  }
  
  public ivec4 zzxx() {
    return new ivec4(z,z,x,x);
  }
  
  public ivec4 zzxy() {
    return new ivec4(z,z,x,y);
  }
  
  public ivec4 zzxz() {
    return new ivec4(z,z,x,z);
  }
  
  public ivec4 zzyw() {
    return new ivec4(z,z,y,w);
  }
  
  public ivec4 zzyx() {
    return new ivec4(z,z,y,x);
  }
  
  public ivec4 zzyy() {
    return new ivec4(z,z,y,y);
  }
  
  public ivec4 zzyz() {
    return new ivec4(z,z,y,z);
  }
  
  public ivec4 zzzw() {
    return new ivec4(z,z,z,w);
  }
  
  public ivec4 zzzx() {
    return new ivec4(z,z,z,x);
  }
  
  public ivec4 zzzy() {
    return new ivec4(z,z,z,y);
  }
  public ivec4 zzzz() {
    return new ivec4(z,z,z,z);
  }
  // 
}
