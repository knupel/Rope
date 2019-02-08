package rope.vector;
import rope.core.BigBangRope;
/**
 * ivec class
 * v 1.0.1
 * 2015-2018
 * Processing 3.5.3
 * Vector with a integer precision
 * @author Stan le Punk
 * @see http://stanlepunk.xyz/
 * @see https://github.com/StanLepunK/Rope
*/
public abstract class ivec extends BigBangRope {
	private int num;
	public int x,y,z,w;
	public int a,b,c,d,e,f;
	public int r,g;
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
	* @return float []
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
			int array [] = {a,b,c,d,e};
			return array;
		} else if(num == 6) {
			int array [] = {a,b,c,d,e,f};
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
