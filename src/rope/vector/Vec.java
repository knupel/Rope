package rope.vector;
import rope.core.BigBangRope;
/**
 * Vec class
 * v 1.18.0
* 2015-2019
* Processing 3.5.3
* Vector class with a float precision
 * @author Stan le Punk
 * @see http://stanlepunk.xyz/
 * @see https://github.com/StanLepunK/Rope
*/
public abstract class vec extends BigBangRope {
	public int num;
	public float x,y,z,w = Float.NaN;
	public float a,b,c,d,e,f = Float.NaN;
	public float r,g = Float.NaN;
	public float s,t,p,q = Float.NaN;
	public float u,v = Float.NaN;
	
  public vec(int num) {
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
      float array [] = {a,b,c,d,e};
      return array;
    } else if(num == 6) {
      float array [] = {a,b,c,d,e,f};
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
      list[0] = a;
      list[1] = b;
      list[2] = c;
      list[3] = d;
      list[4] = e;
    } else if(num == 6) {
      list[0] = a;
      list[1] = b;
      list[2] = c;
      list[3] = d;
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
      list[0] = a;
      list[1] = b;
      list[2] = c;
      list[3] = d;
      list[4] = e;
    } else if(num == 6) {
      list[0] = a;
      list[1] = b;
      list[2] = c;
      list[3] = d;
      list[4] = e;
      list[5] = e;
    } 
    return min(list);
  }
}
