/**
 *   ___      ___   ____   _______
 *  | -  \   /   \  |    \ |  ___/
 *  | |/  | |   \ | | |\ | |  |__
 *  |    /  | | | | | |  / |  __/
 *  | |  \  \ \   / |  |/  |  |____
 *  |_| \_\  \___/  |_ |   |______/
 * 
 * Copyleft(l) 2019-2022
* R_Shape class
* v 0.6.1
* 
* @author @stanlepunk
* @see https://github.com/StanLepunK/Rope
* Class RShape store the utilities to draw shape and costume
*/
package rope.mesh;

import java.util.ArrayList;

import rope.core.*;
import rope.vector.*;
import processing.core.*;


public class R_Shape extends R_Graphic {
	protected ivec6 id = new ivec6(Integer.MIN_VALUE);
	protected vec3 pos;
	protected vec3 size;
	protected vec3 angle;
	
	protected int summits;
	protected ArrayList<vec3> ref_pts = new ArrayList<vec3>();
	protected ArrayList<vec3> pts = new ArrayList<vec3>();

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
	@Deprecated public R_Shape(PApplet pa, int summits) {
		super(pa);
		this.summits = summits;
	}
	
	/**
	 * 
	 * @param pa
	 * @param summits
	 * @param other
	 */
	@Deprecated public R_Shape(PApplet pa, int summits, PGraphics other) {
		super(pa,other);
		this.summits = summits; 
	}
	

  //////////////////////////
  // ID
  ///////////////////////////
  public R_Shape id(int a, int b, int c, int d, int e, int f) {
		this.id.set(a,b,c,d,e,f);
		return this;
	}

	public R_Shape id(ivec6 id) {
		this.id = id.copy();
		return this;
	}

	public R_Shape id(int id) {
		this.id.set(id);
		return this;
	}

	public R_Shape id_a(int id) {
		this.id.a(id);
		return this;
	}

	public R_Shape id_b(int id) {
		this.id.b(id);
		return this;
	}

	public R_Shape id_c(int id) {
		this.id.c(id);
		return this;
	}

	public R_Shape id_d(int id) {
		this.id.d(id);
		return this;
	}

	public R_Shape id_e(int id) {
		this.id.e(id);
		return this;
	}

	public R_Shape id_f(int id) {
		this.id.f(id);
		return this;
	}

	// GET ID
	///////////////////////

	public ivec6 id() {
		return this.id;
	}
  
//////////////////////////////////////  
// POS
/////////////////////////////////////

/**
 * 
 * @return vec3 pos of your P_Shape
 */
	public vec3 pos() {
		return this.pos;
	}
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
	
	////////////////////////////////////
	// SIZE
	//////////////////////////////////

		/**
	 * 
	 * @return
	 */
	public vec3 size() {
		return size;
	}
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
	
	
	//////////////////////////////////
	// ANGLE
	//////////////////////////////////

	 	/**
	 * 
	 * @return angle
	 */
	public vec3 angle() {
  	return this.angle;
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



	/**
	 * set angle x to rotate
	 * @param value
	 */
	public void angle_x(float value) {
		if(angle == null) {
			angle = new vec3(value,0,0);
		} else {
			angle.x(value);
		}	
	}

	/**
	* @return angle x
	 */
	public float angle_x() {
		if(angle != null) {
			return angle.x();
		} else {
			return (float)0.0;
		}
  }
	

	/**
	 * set angle y to rotate
	 * @param value
	 */
	public void angle_y(float value) {
		if(angle == null) {
			angle = new vec3(0,value,0);
		} else {
			angle.y(value);
		}	
	}

	/**
	* @return angle y
	 */
	public float angle_y() {
		if(angle != null) {
			return angle.y();
		} else {
			return (float)0.0;
		}
  }
	

	/**
	 * set angle z to rotate
	 * @param value
	 */
	public void angle_z(float value) {
		if(angle == null) {
			angle = new vec3(0,0,value);
		} else {
			angle.z(value);
		}	
	}

	/**
	* @return angle z
	 */
	public float angle_z() {
		if(angle != null) {
			return angle.z();
		} else {
			return (float)0.0;
		}
  }



	/////////////////////////
	// AREA
	///////////////

	/**
	 * area of the shape, but this one need to be a classical one, the line dont must cross each other and the shape must be close
	 * @return area in pixel
	 */
	public float area() {
		float sum = 0;
		vec3 [] vertices = get_points();
		for (int i = 0; i < vertices.length ; i++) {
			if (i == 0) {
				sum += vertices[i].x() * (vertices[i + 1].y() - vertices[vertices.length - 1].y());
			} else if (i == vertices.length - 1) {
				sum += vertices[i].x() * (vertices[0].y() - vertices[i - 1].y());
			} else {
				sum += vertices[i].x() * (vertices[i + 1].y() - vertices[i - 1].y());
			}
		}
		float area = 0.5f * Math.abs(sum);
		return area;
	}



	/////////////////////////////////
	// CONTAIN POINT
	////////////////////////

		/**
		 * @param marge
	 * @param max
	 * @param points
	 * @return true if the num of common point is minimum equal to max and in the marge of error
	 */
	public boolean compare(int max, float marge, vec... points) {
		int count = 0;
		for(int i = 0 ; i < points.length ; i++) {
			for(vec3 v : get_points()) {
				if(points[i].xyz().compare(v, marge)) {
					count++;
					if(count == max) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	
	/**
	 * @param marge
	 * @param points
	 * @return the list of points contain in R_Shape and in the marge of error
	 */
	public ArrayList<vec3> compare(float marge, vec... points) {
		ArrayList<vec3> res = new ArrayList<vec3>();
		for(int i = 0 ; i < points.length ; i++) {
			for(vec3 v : get_points()) {
				if(points[i].xyz().compare(v, marge)) {
					res.add(v);
					break;
				}
			}
		}
		return res;
	}


	/**
	 * @param max
	 * @param points
	 * @return true if the num of common point is minimum equal to max
	 */
	public boolean equals(int max, vec... points) {
		int count = 0;
		for(int i = 0 ; i < points.length ; i++) {
			for(vec3 v : get_points()) {
				if(points[i].xyz().equals(v)) {
					count++;
					if(count == max) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	
	/**
	 * 
	 * @param points
	 * @return the list of points contain in R_Shape
	 */
	public ArrayList<vec3> equals(vec... points) {
		ArrayList<vec3> res = new ArrayList<vec3>();
		for(int i = 0 ; i < points.length ; i++) {
			for(vec3 v : get_points()) {
				if(points[i].xyz().equals(v)) {
					res.add(v);
					break;
				}
			}
		}
		return res;
	}

	////////////////////////////////
	// MISC
	//////////////////////////////////
		/**
   * 
   * @return
   */
  public boolean use_pos_is() {
    return use_pos_is;
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
   * 
   * @return
   */
  public boolean reset_is() {
    return reset_is;
  }

	public void clear() {
		this.ref_pts.clear();
		this.pts.clear();
		this.summits = 0;
	}


	/**
	 * 
	 * @return the vec3 barycenter of the shape
	 */
	public vec3 barycenter() {
		return barycenter(get_points());
	}


	///////////////////////
	// SUMMITS
	////////////////////////

	/**
	 * 
	 * @return the num of summits
	 */
	public int get_summits() {
    return summits;
  }

	/**
   * @param summits
   */
  public void set_summits(int summits) {
  	if(summits < 3) {
      System.err.println("class R_Shape: the construtor need minimum 3 points to build Curve,\nsorry the class add the minimum require points to make your desire real");
    } else {
    	this.summits = summits; 	
    }	
  }

	////////////////////////
	// POINTER
	//////////////////////
			/**
	 * 
	 * @param coord a list of vec must be a pointer
	 */
	public void add_pointers(vec3... coord) {
		for(vec3 v : coord) {
			pts.add(v);
			ref_pts.add(v);
		}
		this.summits = this.ref_pts.size();
	}

	/**
	 * @param index
	 * @param coord a list of vec must be a pointer
	 */
	public void add_pointers(int index, vec3... coord) {
		for(vec3 v : coord) {
			pts.add(index, v);
			ref_pts.add(index, v);
			index++;
		}
		this.summits = this.ref_pts.size();
	}

	////////////////////////////
	// ADD DEPREACTED
	////////////////////////////
	/**
	 * 
	 * @param x
	 * @param y
	 * @deprecated instead use void add_vec(float x, float y)
	 */
	@Deprecated public void add(float x, float y) {
		add_point(x, y, 0);
	}

	/**
	 * 
	 * @param x
	 * @param y
	 * @param z
	 * @deprecated instead use void add_point(float x, float y, float z)
	 */
	@Deprecated public void add(float x, float y, float z) {
		add_point(x,y,z);
	}



	/**
	 * 
	 * @param coord a list of vec
	 * @deprecated instead use void add_vecs(vec... coord)
	 */
	@Deprecated public void add(vec... coord) {
		add_points(coord);
	}


	/////////////////////
	// POINT
	////////////////////////

	/**
	 * 
	 * @param x
	 * @param y
	 */
	public void add_point(float x, float y) {
		add_point(x,y,0);
	}

		/**
	 * @param index
	 * @param x
	 * @param y
	 */
	public void add_point(int index, float x, float y) {
		add_point(index, x,y,0);
	}


	/**
	 * 
	 * @param x
	 * @param y
	 * @param z
	 */
	public void add_point(float x, float y, float z) {
		ref_pts.add(new vec3(x,y,z));
		pts.add(new vec3(x,y,z));
		this.summits = this.ref_pts.size();
	}

		/**
	 * @param index
	 * @param x
	 * @param y
	 * @param z
	 */
	public void add_point(int index, float x, float y, float z) {
		pts.add(index, new vec3(x,y,z));
		ref_pts.add(index, new vec3(x,y,z));
		this.summits = this.ref_pts.size();
	}

	
	/**
	 * 
	 * @param coord a list of vec
	 */
	public void add_points(vec... coord) {
		for(vec v : coord) {
			pts.add(new vec3(v.x(),v.y(),v.z()));
			ref_pts.add(new vec3(v.x(),v.y(),v.z()));
		}
		this.summits = this.ref_pts.size();
	}

	/**
	 * @param index
	 * @param coord a list of vec
	 */
	public void add_points(int index, vec... coord) {
		for(vec v : coord) {
			pts.add(index, new vec3(v.x(),v.y(),v.z()));
			ref_pts.add(index, new vec3(v.x(),v.y(),v.z()));
			index++;
		}
		this.summits = this.ref_pts.size();
	}



	/**
	 * replace point at the specific index, if this one exist
	 * @param index
	 * @param x
	 * @param y
	 * @param z
	 */
	public void set_point(int index, float x, float y, float z) {
		ref_pts.set(index, new vec3(x,y,z));
		pts.set(index, new vec3(x,y,z));
	}

	public void set_point(int index, float x, float y) {
		this.set_point(index, x, y, 0);
	}

	public void set_point(int index, vec point) {
		this.set_point(index, point.x(), point.y(), point.z());
	}




	///////////////////////////////
	// GET COORD
	///////////////////////////////

	/**
	 * 
	 * @return all the normal points of your Shape
	 */
  public vec3 [] get_ref_points() {
		vec3 [] arr = ref_pts.toArray(new vec3[ref_pts.size()]);
		return arr;
  }
  
  /**
   * 
   * @param target
   * @return a specific point normal of the array
   */
  public vec3 get_ref_point(int target) {
		if(ref_pts.size() > 0 && target >= 0 && target < ref_pts.size()) {
  		return ref_pts.get(target);
  	} else {
  		return null;
  	}  
  }
  
  /**
   * ***WARNING***
	 * sometime it's can be necessary to use the function calc() from the Class is used
	 * we do that to avoid a problem if the shape is too complex. Because that's can make a huge memory using for nothing
   * @return all the points of your Shape
   */

	public vec3 [] get_points() {
		vec3 [] arr = pts.toArray(new vec3[pts.size()]);
		return arr;
  }
  
  /**
   * ***WARNING***
	 * sometime it's can be necessary to use the function calc() from the Class is used
	 * we do that to avoid a problem if the shape is too complex. Because that's can make a huge memory using for nothing
   * @param target
   * @return a specific point of the array
   */
  public vec3 get_point(int target) {
		if(pts.size() > 0 && target >= 0 && target < pts.size()) {
  		return pts.get(target);
  	} else {
  		return null;
  	}    
  }

	public float get_ref_x(int index) {
		return get_ref_point(index).x();
	}

	public float get_ref_y(int index) {
		return get_ref_point(index).y();
	}

	public float get_ref_z(int index) {
		return get_ref_point(index).z();
	}

	public float get_x(int index) {
		return get_point(index).x();
	}

	public float get_y(int index) {
		return get_point(index).y();
	}

	public float get_z(int index) {
		return get_point(index).z();
	}

	//////////////
	// SHOW
	////////////

	public void show() {
    if(pts != null && pts.size() > 0) {
      beginShape();
      for(int i = 0 ; i < pts.size() ; i++) {
        vertex(pts.get(i));
      }
      vertex(pts.get(0));
      endShape();
    } 
  }
}
