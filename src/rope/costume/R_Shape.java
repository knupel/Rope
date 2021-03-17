/**
* RShape class
* v 0.3.2
* 2019-2021
* @author @stanlepunk
* @see https://github.com/StanLepunK/Rope
* Class RShape store the utilities to draw shape and costume
*/
package rope.costume;

import rope.core.*;
import rope.vector.*;
import processing.core.*;


public class R_Shape extends R_Image implements R_Constants {
	protected vec3 pos;
	protected vec3 size;
	protected vec3 angle;
	
	protected int summits;
	protected vec3 [] ref_pts;
	protected vec3 [] pts;


	private boolean use_pos_is = true;
  private boolean reset_is = false;
  

	/**
	 * 
	 * @param pa
	 */
	public R_Shape(PApplet pa) {
		super(pa);
	}

	/**
	 * 
	 * @param pa
	 * @param other
	 */
	public R_Shape(PApplet pa, PGraphics other) {
		super(pa,other);
	}
  
	/**
	 * 
	 * @param pa
	 * @param summits
	 */
	public R_Shape(PApplet pa, int summits) {
		super(pa);
		this.summits = summits;
    ref_pts = new vec3[summits];  
	}
	
	/**
	 * 
	 * @param pa
	 * @param summits
	 * @param other
	 */
	public R_Shape(PApplet pa, int summits, PGraphics other) {
		super(pa,other);
		this.summits = summits;
    ref_pts = new vec3[summits];  
	}
	
	
	
	
	



	// SET
	/**
   * 
   * @param summits
   */
  public void set_summits(int summits) {
  	if(summits < 3) {
      System.err.println("class R_Shape: the construtor need minimum 3 points to build Curve,\nsorry the class add the minimum require points to make your desire real");
    } else {
    	this.summits = summits; 	
    }	
  }


	/**
   * 
   * @param is
   */
  public void use_pos_is(boolean is) {
    use_pos_is = is;
  }
  
  /**
   * 
   * @param is
   */
  public void reset_is(boolean is) {
    this.reset_is = is;
  }
  
  
  /**
   * POS
   */
  /**
   * 
   * @param p
   */
	public void pos(float p) {
		pos(new vec3(p));
	}
	
	/**
	 * 
	 * @param x
	 * @param y
	 */
	public void pos(float x, float y) {
		pos(new vec2(x,y));
	}
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @param z
	 */
	public void pos(float x, float y, float z) {
		pos(new vec3(x,y,z));
	}
	
	/**
	 * 
	 * @param pos
	 */
	public void pos(ivec pos) {
		pos(new vec3(pos));
	}
	
	/**
	 * 
	 * @param pos
	 */
	public void pos(vec pos) {
		if(this.pos == null) {
			this.pos = new vec3(pos);
		} else {
			this.pos.set(pos);
		}
	}
	
	/**
	 * SIZE
	 */
	/**
	 * 
	 * @param s
	 */
	public void size(float s) {
		size(new vec3(s,s,s));
	}
	
	/**
	 * 
	 * @param w
	 * @param h
	 */
	public void size(float w, float h) {
		size(new vec2(w,h));
	}
	
	/**
	 * 
	 * @param w
	 * @param h
	 * @param d
	 */
	public void size(float w, float h, float d) {
		size(new vec3(w,h,d));
	}
	
	/**
	 * 
	 * @param size
	 */
	public void size(ivec size) {
		size(new vec3(size));
	}
	
	/**
	 * 
	 * @param size
	 */
	public void size(vec size) {
		if(this.size == null) {
			this.size = new vec3(size);
		} else {
			this.size.set(size);
		}
	}
	
	
	/**
	 * ANGLE
	 */
	public void angle_x(float value) {
		if(angle == null) {
			angle = new vec3(value,0,0);
		} else {
			angle.x(value);
		}	
	}
	
	public void angle_y(float value) {
		if(angle == null) {
			angle = new vec3(0,value,0);
		} else {
			angle.y(value);
		}	
	}
	
	public void angle_z(float value) {
		if(angle == null) {
			angle = new vec3(0,0,value);
		} else {
			angle.z(value);
		}	
	}



	/**
	 * 
	 * @param x
	 * @param y
	 * @param z
	 */
	public void angle(float x, float y, float z) {
		angle(new vec3(x,y,z));
	}
	

	
	/**
	 * 
	 * @param angle
	 */
	public void angle(vec angle) {
		if(this.angle == null) {
			this.angle = new vec3(angle);
		} else {
			this.angle.set(angle);
		}
	}
	
	// GET
	/**
	 * 
	 * @return
	 */
	public vec3 angle() {
  	return this.angle;
  }
	
	
	public float angle_x() {
		if(angle != null) {
			return angle.x();
		} else {
			return (float)0.0;
		}
  }
	
	public float angle_y() {
		if(angle != null) {
			return angle.y();
		} else {
			return (float)0.0;
		}
  }
	
	public float angle_z() {
		if(angle != null) {
			return angle.z();
		} else {
			return (float)0.0;
		}
  }
	
	
	/**
   * 
   * @return
   */
  public boolean use_pos_is() {
    return use_pos_is;
  }

    /**
   * 
   * @return
   */
  public boolean reset_is() {
    return reset_is;
  }

  /**
   * 
   * @return
   */
	public vec3 pos() {
		return pos;
	}
	
	/**
	 * 
	 * @return
	 */
	public vec3 size() {
		return size;
	}
	
	/**
	 * 
	 * @return
	 */
	public int get_summits() {
    return summits;
  }

  public vec3 [] get_ref_points() {
    return ref_pts;
  }
  
  /**
   * 
   * @param target
   * @return
   */
  public vec3 get_ref_point(int target) {
  	if(ref_pts != null && target >= 0 && target < ref_pts.length) {
  		return ref_pts[target];
  	} else {
  		return null;
  	}  
  }
  
  /**
   * 
   * @return
   */
  public vec3 [] get_points() {
    return pts;
  }
  
  /**
   * 
   * @param target
   * @return
   */
  public vec3 get_point(int target) {
  	if(pts != null && target >= 0 && target < pts.length) {
  		return pts[target];
  	} else {
  		return null;
  	}  
  }

}
