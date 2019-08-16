/**
* vec class
* v 2.0.0
* 2015-2019
* Processing 3.5.3
* Vector class with a float precision
* @author @stanlepunk
* @see https://github.com/StanLepunK/Rope
*/
package rope.vector;
import rope.core.BigBang;
public abstract class vec extends BigBang {
	public int num;
	public float x,y,z,w = Float.NaN;
	public float e,f = Float.NaN; // for vec5 and vec6 
	public float s,t,p,q = Float.NaN;
	public float u,v = Float.NaN;
	
  public vec(int num) {
  	super();
    this.num = num;
  }
  
  /**
  * @return the number of components
  */
  public int get_num() {
    return num;
  }
  


  /**
  array
  */
  /**
  * return the list of component
  * @return float []
  */
  public float [] array() {
    if(num == 2) {
      float array [] = {x,y};
      return array;
    } else if(num == 3) {
      float array [] = {x,y,z};
      return array;
    } else if(num == 4) {
      float array [] = {x,y,z,w};
      return array;
    } else if(num == 5) {
      float array [] = {x,y,z,w,e};
      return array;
    } else if(num == 6) {
      float array [] = {x,y,z,w,e,f};
      return array;
    } else return null ;
  }


  /**
  * max
  * find the min and the max value in the vector list
  * @return float
  */
  public float max() {
    float [] list = new float[num];
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
    return max(list);
  }
  /**
  * min
  * find the min and the max value in the vector list
  * @return float
  */
  public float min() {
    float [] list = new float[num];
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
    return min(list);
  }
  
  /**
   * return single float component
   * @return float
   */
  public float x() {
    return x;
  }

  public float y() {
    return y;
  }

  public float z() {
    return z;
  }

  public float w() {
    return w;
  }
    
  public float a() {
    return x;
  }
    
  public float b() {
    return y;
  }

  public float c() {
    return z;
  }

  public float d() {
    return w;
  }

  public float e() {
    return e;
  }

  public float f() {
    return f;
  }

  public float s() {
    return s;
  }

  public float t() {
    return t;
  }

  public float p() {
    return p;
  }

  public float q() {
    return q;
  }

  public float u() {
    return u;
  }

  public float v() {
    return v;
  }
  
  // rgb
  public float red() {
    return x;
  }

  public float gre() {
    return y;
  }

  public float blu() {
    return z;
  }

  // hsb
  public float hue() {
    return x;
  }

  public float sat() {
    return y;
  }

  public float bri() {
    return z;
  }
  
  // alpha
  public float alp() {
    return w;
  }


  /**
   * return multi float component
   * @return float
   */

  // special
  public vec2 uv() {
    return new vec2(x,y);
  }

  public vec2 st() {
    return new vec2(x,y);
  }

  public vec2 pq() {
    return new vec2(z,w);
  }

  public vec3 rgb() {
    return new vec3(x,y,z);
  }

  public vec3 hsb() {
    return new vec3(x,y,z);
  }

  public vec4 stpq() {
    return new vec4(x,y,z,w);
  }

  public vec4 rgba() {
    return new vec4(x,y,z,w);
  }

  public vec4 hsba() {
    return new vec4(x,y,z,w);
  }

  public vec2 ab() {
    return new vec2(x,y);
  }

  public vec3 abc() {
    return new vec3(x,y,z);
  }

  public vec4 abcd() {
    return new vec4(x,y,z,w);
  }

  public vec5 abcde() {
    return new vec5(x,y,z,w,e);
  }

  public vec6 abcdef() {
    return new vec6(x,y,z,w,e,f);
  }


  // XYZW
  public vec2 ww() { 
    return new vec2(w,w); 
  }
  
  public vec2 wx() {
    return new vec2(w,x);
  }
  
  public vec2 wy() {
  	return new vec2(w,y);
  }
  
  public vec2 wz() {
  	return new vec2(w,z);
  }
  
  public vec2 xw() {
    return new vec2(x,w);
  }
  
  public vec2 xx() {
    return new vec2(x,x);
  }

  public vec2 xy() {
    return new vec2(x,y);
  }
  
  public vec2 xz() {
    return new vec2(x,z);
  }
  
  public vec2 yw() {
    return new vec2(y,w);
  }
  
  public vec2 yx() {
    return new vec2(y,x);
  }

  public vec2 yy() {
    return new vec2(y,y);
  }
  
  public vec2 yz() {
    return new vec2(y,z);
  }
  
  public vec2 zw() {
    return new vec2(z,w);
  }
  
  public vec2 zx() {
    return new vec2(z,x);
  }
  
  public vec2 zy() {
    return new vec2(z,y);
  }

  public vec2 zz() {
    return new vec2(z,z);
  }
  
  // w3
  public vec3 www() {
    return new vec3(w,w,w);
  }
  
  public vec3 wwx() {
    return new vec3(w,w,x);
  }
  
  public vec3 wwy() {
    return new vec3(w,w,y);
  }
  
  public vec3 wwz() {
    return new vec3(w,w,z);
  }
  
  public vec3 wxw() {
    return new vec3(w,x,w);
  }
  
  public vec3 wxx() {
    return new vec3(w,x,x);
  }
  
  public vec3 wxy() {
    return new vec3(w,x,y);
  }
  
  public vec3 wxz() {
    return new vec3(w,x,z);
  }
  
  public vec3 wyw() {
    return new vec3(w,y,w);
  }
  
  public vec3 wyx() {
    return new vec3(w,y,x);
  }
  
  public vec3 wyy() {
    return new vec3(w,y,y);
  }
  
  public vec3 wyz() {
    return new vec3(w,y,z);
  }
  
  public vec3 wzw() {
    return new vec3(w,z,w);
  }
  
  public vec3 wzx() {
    return new vec3(w,z,x);
  }
  
  public vec3 wzy() {
    return new vec3(w,z,y);
  }
  
  public vec3 wzz() {
    return new vec3(w,z,z);
  }
  
  // x3
  public vec3 xww() {
    return new vec3(x,w,w);
  }
  
  public vec3 xwx() {
    return new vec3(x,w,x);
  }
  
  public vec3 xwy() {
    return new vec3(x,w,y);
  }
  
  public vec3 xwz() {
    return new vec3(x,w,z);
  }
  
  public vec3 xxw() {
    return new vec3(x,x,w);
  }
  
  public vec3 xxx() {
    return new vec3(x,x,x);
  }
  
  public vec3 xxy() {
    return new vec3(x,x,y);
  }
  
  public vec3 xxz() {
    return new vec3(x,x,z);
  }
  
  public vec3 xyw() {
    return new vec3(x,y,w);
  }
  
  public vec3 xyx() {
    return new vec3(x,y,x);
  }
  
  public vec3 xyy() {
    return new vec3(x,y,y);
  }
  
  public vec3 xyz() {
    return new vec3(x,y,z);
  }
  
  public vec3 xzw() {
    return new vec3(x,z,w);
  }
  
  public vec3 xzx() {
    return new vec3(x,z,x);
  }
  
  public vec3 xzy() {
    return new vec3(x,z,y);
  }
  
  // y3
  public vec3 yww() {
    return new vec3(y,w,w);
  }
  
  public vec3 ywx() {
    return new vec3(y,w,x);
  }
  
  public vec3 ywy() {
    return new vec3(y,w,y);
  }
  
  public vec3 ywz() {
    return new vec3(y,w,z);
  }
  
  public vec3 yxw() {
    return new vec3(y,x,w);
  }
  
  public vec3 yxx() {
    return new vec3(y,x,x);
  }
  
  public vec3 yxy() {
    return new vec3(y,x,y);
  }
  
  public vec3 yxz() {
    return new vec3(y,x,z);
  }
  
  public vec3 yyw() {
    return new vec3(y,y,w);
  }
  
  public vec3 yyx() {
    return new vec3(y,y,x);
  }
  
  public vec3 yyy() {
    return new vec3(y,y,y);
  }
  
  public vec3 yyz() {
    return new vec3(y,y,z);
  }
  
  
  public vec3 yzw() {
    return new vec3(y,z,w);
  }
  
  public vec3 yzx() {
    return new vec3(y,z,x);
  }
  
  public vec3 yzy() {
    return new vec3(y,z,y);
  }
  
  // z3
  public vec3 zww() {
    return new vec3(z,w,w);
  }
  
  public vec3 zwx() {
    return new vec3(z,w,x);
  }
  
  public vec3 zwy() {
    return new vec3(z,w,y);
  }
  
  public vec3 zwz() {
    return new vec3(z,w,z);
  }
  
  public vec3 zxw() {
    return new vec3(z,x,w);
  }
  
  public vec3 zxx() {
    return new vec3(z,x,x);
  }
  
  public vec3 zxy() {
    return new vec3(z,x,y);
  }
  
  public vec3 zxz() {
    return new vec3(z,x,z);
  }
  
  public vec3 zyw() {
    return new vec3(z,y,w);
  }
  
  public vec3 zyx() {
    return new vec3(z,y,x);
  }
  
  public vec3 zyy() {
    return new vec3(z,y,y);
  }
  
  public vec3 zyz() {
    return new vec3(z,y,z);
  }
  
  public vec3 zzw() {
    return new vec3(z,z,w);
  }
  
  public vec3 zzx() {
    return new vec3(z,z,x);
  }
  
  public vec3 zzy() {
    return new vec3(z,z,y);
  }
  public vec3 zzz() {
    return new vec3(z,z,z);
  }
  
  
  
  // W4
  // w3
  public vec4 wwww() {
    return new vec4(w,w,w,w);
  }
  
  public vec4 wwwx() {
    return new vec4(w,w,w,x);
  }
  
  public vec4 wwwy() {
    return new vec4(w,w,w,y);
  }
  
  public vec4 wwwz() {
    return new vec4(w,w,w,z);
  }
  
  public vec4 wwxw() {
    return new vec4(w,w,x,w);
  }
  
  public vec4 wwxx() {
    return new vec4(w,w,x,x);
  }
  
  public vec4 wwxy() {
    return new vec4(w,w,x,y);
  }
  
  public vec4 wwxz() {
    return new vec4(w,w,x,z);
  }
  
  public vec4 wwyw() {
    return new vec4(w,w,y,w);
  }
  
  public vec4 wwyx() {
    return new vec4(w,w,y,x);
  }
  
  public vec4 wwyy() {
    return new vec4(w,w,y,y);
  }
  
  public vec4 wwyz() {
    return new vec4(w,w,y,z);
  }
  
  public vec4 wwzw() {
    return new vec4(w,w,z,w);
  }
  
  public vec4 wwzx() {
    return new vec4(w,w,z,x);
  }
  
  public vec4 wwzy() {
    return new vec4(w,w,z,y);
  }
  
  public vec4 wwzz() {
    return new vec4(w,w,z,z);
  }
  
  // x3
  public vec4 wxww() {
    return new vec4(w,x,w,w);
  }
  
  public vec4 wxwx() {
    return new vec4(w,x,w,x);
  }
  
  public vec4 wxwy() {
    return new vec4(w,x,w,y);
  }
  
  public vec4 wxwz() {
    return new vec4(w,x,w,z);
  }
  
  public vec4 wxxw() {
    return new vec4(w,x,x,w);
  }
  
  public vec4 wxxx() {
    return new vec4(w,x,x,x);
  }
  
  public vec4 wxxy() {
    return new vec4(w,x,x,y);
  }
  
  public vec4 wxxz() {
    return new vec4(w,x,x,z);
  }
  
  public vec4 wxyw() {
    return new vec4(w,x,y,w);
  }
  
  public vec4 wxyx() {
    return new vec4(w,x,y,x);
  }
  
  public vec4 wxyy() {
    return new vec4(w,x,y,y);
  }
  
  public vec4 wxyz() {
    return new vec4(w,x,y,z);
  }
  
  public vec4 wxzw() {
    return new vec4(w,x,z,w);
  }
  
  public vec4 wxzx() {
    return new vec4(w,x,z,x);
  }
  
  public vec4 wxzy() {
    return new vec4(w,x,z,y);
  }
  
  // y3
  public vec4 wyww() {
    return new vec4(w,y,w,w);
  }
  
  public vec4 wywx() {
    return new vec4(w,y,w,x);
  }
  
  public vec4 wywy() {
    return new vec4(w,y,w,y);
  }
  
  public vec4 wywz() {
    return new vec4(w,y,w,z);
  }
  
  public vec4 wyxw() {
    return new vec4(w,y,x,w);
  }
  
  public vec4 wyxx() {
    return new vec4(w,y,x,x);
  }
  
  public vec4 wyxy() {
    return new vec4(w,y,x,y);
  }
  
  public vec4 wyxz() {
    return new vec4(w,y,x,z);
  }
  
  public vec4 wyyw() {
    return new vec4(w,y,y,w);
  }
  
  public vec4 wyyx() {
    return new vec4(w,y,y,x);
  }
  
  public vec4 wyyy() {
    return new vec4(w,y,y,y);
  }
  
  public vec4 wyyz() {
    return new vec4(w,y,y,z);
  }
  
  
  public vec4 wyzw() {
    return new vec4(w,y,z,w);
  }
  
  public vec4 wyzx() {
    return new vec4(w,y,z,x);
  }
  
  public vec4 wyzy() {
    return new vec4(w,y,z,y);
  }
  
  // z3
  public vec4 wzww() {
    return new vec4(w,z,w,w);
  }
  
  public vec4 wzwx() {
    return new vec4(w,z,w,x);
  }
  
  public vec4 wzwy() {
    return new vec4(w,z,w,y);
  }
  
  public vec4 wzwz() {
    return new vec4(w,z,w,z);
  }
  
  public vec4 wzxw() {
    return new vec4(w,z,x,w);
  }
  
  public vec4 wzxx() {
    return new vec4(w,z,x,x);
  }
  
  public vec4 wzxy() {
    return new vec4(w,z,x,y);
  }
  
  public vec4 wzxz() {
    return new vec4(w,z,x,z);
  }
  
  public vec4 wzyw() {
    return new vec4(w,z,y,w);
  }
  
  public vec4 wzyx() {
    return new vec4(w,z,y,x);
  }
  
  public vec4 wzyy() {
    return new vec4(w,z,y,y);
  }
  
  public vec4 wzyz() {
    return new vec4(w,z,y,z);
  }
  
  public vec4 wzzw() {
    return new vec4(w,z,z,w);
  }
  
  public vec4 wzzx() {
    return new vec4(w,z,z,x);
  }
  
  public vec4 wzzy() {
    return new vec4(w,z,z,y);
  }
  public vec4 wzzz() {
    return new vec4(w,z,z,z);
  }





  // X4
  // w3
  public vec4 xwww() {
    return new vec4(x,w,w,w);
  }
  
  public vec4 xwwx() {
    return new vec4(x,w,w,x);
  }
  
  public vec4 xwwy() {
    return new vec4(x,w,w,y);
  }
  
  public vec4 xwwz() {
    return new vec4(x,w,w,z);
  }
  
  public vec4 xwxw() {
    return new vec4(x,w,x,w);
  }
  
  public vec4 xwxx() {
    return new vec4(x,w,x,x);
  }
  
  public vec4 xwxy() {
    return new vec4(x,w,x,y);
  }
  
  public vec4 xwxz() {
    return new vec4(x,w,x,z);
  }
  
  public vec4 xwyw() {
    return new vec4(x,w,y,w);
  }
  
  public vec4 xwyx() {
    return new vec4(x,w,y,x);
  }
  
  public vec4 xwyy() {
    return new vec4(x,w,y,y);
  }
  
  public vec4 xwyz() {
    return new vec4(x,w,y,z);
  }
  
  public vec4 xwzw() {
    return new vec4(x,w,z,w);
  }
  
  public vec4 xwzx() {
    return new vec4(x,w,z,x);
  }
  
  public vec4 xwzy() {
    return new vec4(x,w,z,y);
  }
  
  public vec4 xwzz() {
    return new vec4(x,w,z,z);
  }
  
  // x3
  public vec4 xxww() {
    return new vec4(x,x,w,w);
  }
  
  public vec4 xxwx() {
    return new vec4(x,x,w,x);
  }
  
  public vec4 xxwy() {
    return new vec4(x,x,w,y);
  }
  
  public vec4 xxwz() {
    return new vec4(x,x,w,z);
  }
  
  public vec4 xxxw() {
    return new vec4(x,x,x,w);
  }
  
  public vec4 xxxx() {
    return new vec4(x,x,x,x);
  }
  
  public vec4 xxxy() {
    return new vec4(x,x,x,y);
  }
  
  public vec4 xxxz() {
    return new vec4(x,x,x,z);
  }
  
  public vec4 xxyw() {
    return new vec4(x,x,y,w);
  }
  
  public vec4 xxyx() {
    return new vec4(x,x,y,x);
  }
  
  public vec4 xxyy() {
    return new vec4(x,x,y,y);
  }
  
  public vec4 xxyz() {
    return new vec4(x,x,y,z);
  }
  
  public vec4 xxzw() {
    return new vec4(x,x,z,w);
  }
  
  public vec4 xxzx() {
    return new vec4(x,x,z,x);
  }
  
  public vec4 xxzy() {
    return new vec4(x,x,z,y);
  }
  
  // y3
  public vec4 xyww() {
    return new vec4(x,y,w,w);
  }
  
  public vec4 xywx() {
    return new vec4(x,y,w,x);
  }
  
  public vec4 xywy() {
    return new vec4(x,y,w,y);
  }
  
  public vec4 xywz() {
    return new vec4(x,y,w,z);
  }
  
  public vec4 xyxw() {
    return new vec4(x,y,x,w);
  }
  
  public vec4 xyxx() {
    return new vec4(x,y,x,x);
  }
  
  public vec4 xyxy() {
    return new vec4(x,y,x,y);
  }
  
  public vec4 xyxz() {
    return new vec4(x,y,x,z);
  }
  
  public vec4 xyyw() {
    return new vec4(x,y,y,w);
  }
  
  public vec4 xyyx() {
    return new vec4(x,y,y,x);
  }
  
  public vec4 xyyy() {
    return new vec4(x,y,y,y);
  }
  
  public vec4 xyyz() {
    return new vec4(x,y,y,z);
  }
  
  public vec4 xyzw() {
    return new vec4(x,y,z,w);
  }
  
  public vec4 xyzx() {
    return new vec4(x,y,z,x);
  }
  
  public vec4 xyzy() {
    return new vec4(x,y,z,y);
  }
  
  // z3
  public vec4 xzww() {
    return new vec4(x,z,w,w);
  }
  
  public vec4 xzwx() {
    return new vec4(x,z,w,x);
  }
  
  public vec4 xzwy() {
    return new vec4(x,z,w,y);
  }
  
  public vec4 xzwz() {
    return new vec4(x,z,w,z);
  }
  
  public vec4 xzxw() {
    return new vec4(x,z,x,w);
  }
  
  public vec4 xzxx() {
    return new vec4(x,z,x,x);
  }
  
  public vec4 xzxy() {
    return new vec4(x,z,x,y);
  }
  
  public vec4 xzxz() {
    return new vec4(x,z,x,z);
  }
  
  public vec4 xzyw() {
    return new vec4(x,z,y,w);
  }
  
  public vec4 xzyx() {
    return new vec4(x,z,y,x);
  }
  
  public vec4 xzyy() {
    return new vec4(x,z,y,y);
  }
  
  public vec4 xzyz() {
    return new vec4(x,z,y,z);
  }
  
  public vec4 xzzw() {
    return new vec4(x,z,z,w);
  }
  
  public vec4 xzzx() {
    return new vec4(x,z,z,x);
  }
  
  public vec4 xzzy() {
    return new vec4(x,z,z,y);
  }
  public vec4 xzzz() {
    return new vec4(x,z,z,z);
  }





  // Y4
  // w3
  public vec4 ywww() {
    return new vec4(y,w,w,w);
  }
  
  public vec4 ywwx() {
    return new vec4(y,w,w,x);
  }
  
  public vec4 ywwy() {
    return new vec4(y,w,w,y);
  }
  
  public vec4 ywwz() {
    return new vec4(y,w,w,z);
  }
  
  public vec4 ywxw() {
    return new vec4(y,w,x,w);
  }
  
  public vec4 ywxx() {
    return new vec4(y,w,x,x);
  }
  
  public vec4 ywxy() {
    return new vec4(y,w,x,y);
  }
  
  public vec4 ywxz() {
    return new vec4(y,w,x,z);
  }
  
  public vec4 ywyw() {
    return new vec4(y,w,y,w);
  }
  
  public vec4 ywyx() {
    return new vec4(y,w,y,x);
  }
  
  public vec4 ywyy() {
    return new vec4(y,w,y,y);
  }
  
  public vec4 ywyz() {
    return new vec4(y,w,y,z);
  }
  
  public vec4 ywzw() {
    return new vec4(y,w,z,w);
  }
  
  public vec4 ywzx() {
    return new vec4(y,w,z,x);
  }
  
  public vec4 ywzy() {
    return new vec4(y,w,z,y);
  }
  
  public vec4 ywzz() {
    return new vec4(y,w,z,z);
  }
  
  // x3
  public vec4 yxww() {
    return new vec4(y,x,w,w);
  }
  
  public vec4 yxwx() {
    return new vec4(y,x,w,x);
  }
  
  public vec4 yxwy() {
    return new vec4(y,x,w,y);
  }
  
  public vec4 yxwz() {
    return new vec4(y,x,w,z);
  }
  
  public vec4 yxxw() {
    return new vec4(y,x,x,w);
  }
  
  public vec4 yxxx() {
    return new vec4(y,x,x,x);
  }
  
  public vec4 yxxy() {
    return new vec4(y,x,x,y);
  }
  
  public vec4 yxxz() {
    return new vec4(y,x,x,z);
  }
  
  public vec4 yxyw() {
    return new vec4(y,x,y,w);
  }
  
  public vec4 yxyx() {
    return new vec4(y,x,y,x);
  }
  
  public vec4 yxyy() {
    return new vec4(y,x,y,y);
  }
  
  public vec4 yxyz() {
    return new vec4(y,x,y,z);
  }
  
  public vec4 yxzw() {
    return new vec4(y,x,z,w);
  }
  
  public vec4 yxzx() {
    return new vec4(y,x,z,x);
  }
  
  public vec4 yxzy() {
    return new vec4(y,x,z,y);
  }
  
  // y3
  public vec4 yyww() {
    return new vec4(y,y,w,w);
  }
  
  public vec4 yywx() {
    return new vec4(y,y,w,x);
  }
  
  public vec4 yywy() {
    return new vec4(y,y,w,y);
  }
  
  public vec4 yywz() {
    return new vec4(y,y,w,z);
  }
  
  public vec4 yyxw() {
    return new vec4(y,y,x,w);
  }
  
  public vec4 yyxx() {
    return new vec4(y,y,x,x);
  }
  
  public vec4 yyxy() {
    return new vec4(y,y,x,y);
  }
  
  public vec4 yyxz() {
    return new vec4(y,y,x,z);
  }
  
  public vec4 yyyw() {
    return new vec4(y,y,y,w);
  }
  
  public vec4 yyyx() {
    return new vec4(y,y,y,x);
  }
  
  public vec4 yyyy() {
    return new vec4(y,y,y,y);
  }
  
  public vec4 yyyz() {
    return new vec4(y,y,y,z);
  }
  
  public vec4 yyzw() {
    return new vec4(y,y,z,w);
  }
  
  public vec4 yyzx() {
    return new vec4(y,y,z,x);
  }
  
  public vec4 yyzy() {
    return new vec4(y,y,z,y);
  }
  
  // z3
  public vec4 yzww() {
    return new vec4(y,z,w,w);
  }
  
  public vec4 yzwx() {
    return new vec4(y,z,w,x);
  }
  
  public vec4 yzwy() {
    return new vec4(y,z,w,y);
  }
  
  public vec4 yzwz() {
    return new vec4(y,z,w,z);
  }
  
  public vec4 yzxw() {
    return new vec4(y,z,x,w);
  }
  
  public vec4 yzxx() {
    return new vec4(y,z,x,x);
  }
  
  public vec4 yzxy() {
    return new vec4(y,z,x,y);
  }
  
  public vec4 yzxz() {
    return new vec4(y,z,x,z);
  }
  
  public vec4 yzyw() {
    return new vec4(y,z,y,w);
  }
  
  public vec4 yzyx() {
    return new vec4(y,z,y,x);
  }
  
  public vec4 yzyy() {
    return new vec4(y,z,y,y);
  }
  
  public vec4 yzyz() {
    return new vec4(y,z,y,z);
  }
  
  public vec4 yzzw() {
    return new vec4(y,z,z,w);
  }
  
  public vec4 yzzx() {
    return new vec4(y,z,z,x);
  }
  
  public vec4 yzzy() {
    return new vec4(y,z,z,y);
  }
  public vec4 yzzz() {
    return new vec4(y,z,z,z);
  }






  // Z4
  // w3
  public vec4 zwww() {
    return new vec4(z,w,w,w);
  }
  
  public vec4 zwwx() {
    return new vec4(z,w,w,x);
  }
  
  public vec4 zwwy() {
    return new vec4(z,w,w,y);
  }
  
  public vec4 zwwz() {
    return new vec4(z,w,w,z);
  }
  
  public vec4 zwxw() {
    return new vec4(z,w,x,w);
  }
  
  public vec4 zwxx() {
    return new vec4(z,w,x,x);
  }
  
  public vec4 zwxy() {
    return new vec4(z,w,x,y);
  }
  
  public vec4 zwxz() {
    return new vec4(z,w,x,z);
  }
  
  public vec4 zwyw() {
    return new vec4(z,w,y,w);
  }
  
  public vec4 zwyx() {
    return new vec4(z,w,y,x);
  }
  
  public vec4 zwyy() {
    return new vec4(z,w,y,y);
  }
  
  public vec4 zwyz() {
    return new vec4(z,w,y,z);
  }
  
  public vec4 zwzw() {
    return new vec4(z,w,z,w);
  }
  
  public vec4 zwzx() {
    return new vec4(z,w,z,x);
  }
  
  public vec4 zwzy() {
    return new vec4(z,w,z,y);
  }
  
  public vec4 zwzz() {
    return new vec4(z,w,z,z);
  }
  
  // x3
  public vec4 zxww() {
    return new vec4(z,x,w,w);
  }
  
  public vec4 zxwx() {
    return new vec4(z,x,w,x);
  }
  
  public vec4 zxwy() {
    return new vec4(z,x,w,y);
  }
  
  public vec4 zxwz() {
    return new vec4(z,x,w,z);
  }
  
  public vec4 zxxw() {
    return new vec4(z,x,x,w);
  }
  
  public vec4 zxxx() {
    return new vec4(z,x,x,x);
  }
  
  public vec4 zxxy() {
    return new vec4(z,x,x,y);
  }
  
  public vec4 zxxz() {
    return new vec4(z,x,x,z);
  }
  
  public vec4 zxyw() {
    return new vec4(z,x,y,w);
  }
  
  public vec4 zxyx() {
    return new vec4(z,x,y,x);
  }
  
  public vec4 zxyy() {
    return new vec4(z,x,y,y);
  }
  
  public vec4 zxyz() {
    return new vec4(z,x,y,z);
  }
  
  public vec4 zxzw() {
    return new vec4(z,x,z,w);
  }
  
  public vec4 zxzx() {
    return new vec4(z,x,z,x);
  }
  
  public vec4 zxzy() {
    return new vec4(z,x,z,y);
  }
  
  // y3
  public vec4 zyww() {
    return new vec4(z,y,w,w);
  }
  
  public vec4 zywx() {
    return new vec4(z,y,w,x);
  }
  
  public vec4 zywy() {
    return new vec4(z,y,w,y);
  }
  
  public vec4 zywz() {
    return new vec4(z,y,w,z);
  }
  
  public vec4 zyxw() {
    return new vec4(z,y,x,w);
  }
  
  public vec4 zyxx() {
    return new vec4(z,y,x,x);
  }
  
  public vec4 zyxy() {
    return new vec4(z,y,x,y);
  }
  
  public vec4 zyxz() {
    return new vec4(z,y,x,z);
  }
  
  public vec4 zyyw() {
    return new vec4(z,y,y,w);
  }
  
  public vec4 zyyx() {
    return new vec4(z,y,y,x);
  }
  
  public vec4 zyyy() {
    return new vec4(z,y,y,y);
  }
  
  public vec4 zyyz() {
    return new vec4(z,y,y,z);
  }
  
  public vec4 zyzw() {
    return new vec4(z,y,z,w);
  }
  
  public vec4 zyzx() {
    return new vec4(z,y,z,x);
  }
  
  public vec4 zyzy() {
    return new vec4(z,y,z,y);
  }
  
  // z3
  public vec4 zzww() {
    return new vec4(z,z,w,w);
  }
  
  public vec4 zzwx() {
    return new vec4(z,z,w,x);
  }
  
  public vec4 zzwy() {
    return new vec4(z,z,w,y);
  }
  
  public vec4 zzwz() {
    return new vec4(z,z,w,z);
  }
  
  public vec4 zzxw() {
    return new vec4(z,z,x,w);
  }
  
  public vec4 zzxx() {
    return new vec4(z,z,x,x);
  }
  
  public vec4 zzxy() {
    return new vec4(z,z,x,y);
  }
  
  public vec4 zzxz() {
    return new vec4(z,z,x,z);
  }
  
  public vec4 zzyw() {
    return new vec4(z,z,y,w);
  }
  
  public vec4 zzyx() {
    return new vec4(z,z,y,x);
  }
  
  public vec4 zzyy() {
    return new vec4(z,z,y,y);
  }
  
  public vec4 zzyz() {
    return new vec4(z,z,y,z);
  }
  
  public vec4 zzzw() {
    return new vec4(z,z,z,w);
  }
  
  public vec4 zzzx() {
    return new vec4(z,z,z,x);
  }
  
  public vec4 zzzy() {
    return new vec4(z,z,z,y);
  }
  public vec4 zzzz() {
    return new vec4(z,z,z,z);
  }
  //  
}
