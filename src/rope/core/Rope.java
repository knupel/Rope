/**
 * Rope
 * @author stan
 * 2018-2021
 * v 0.2.1
 * 
 */

package rope.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import rope.vector.bvec2;
import rope.vector.bvec3;
import rope.vector.bvec4;
import rope.vector.bvec5;
import rope.vector.bvec6;
import rope.vector.ivec2;
import rope.vector.ivec3;
import rope.vector.ivec4;
import rope.vector.vec;
import rope.vector.vec2;
import rope.vector.vec3;
import rope.vector.vec4;

public class Rope implements R_Constants, R_Constants_Colour {
	public Rope() {}
	
	
	/**
	 * OPERATION
	 */
	
	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	protected vec2 add(vec2 a, vec2 b) {
	  if(a == null || b == null) {
	    return null ;
	  } else {
	    float x = a.x() + b.x();
	    float y = a.y() + b.y();
	    return new vec2(x,y);
	  }
	}

	protected vec3 add(vec3 a, vec3 b) {
	  if(a == null || b == null) {
	    return null ;
	  } else {
	    float x = a.x() + b.x();
	    float y = a.y() + b.y();
	    float z = a.z() + b.z();
	    return new vec3(x,y,z);
	  }
	}

	protected vec4 add(vec4 a, vec4 b) {  
	  if(a == null || b == null) {
	    return null ;
	  } else {
	    float x = a.x() + b.x();
	    float y = a.y() + b.y();
	    float z = a.z() + b.z();
	    float w = a.w() + b.w();
	    return new vec4(x,y,z,w);
	  }
	}
	
	protected vec2 add(vec2 a, float arg) {
	  return add(a, new vec2(arg,arg));
	}

	protected vec3 add(vec3 a, float arg) {
	  return add(a,new vec3(arg,arg,arg));
	}

	protected vec4 add(vec4 a, float arg) {  
	  return add(a, new vec4(arg,arg,arg,arg));
	}
	
	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	protected vec2 sub(vec2 a, vec2 b) {
		if (a == null || b == null) {
			return null;
		} else {
			float x = a.x - b.x;
			float y = a.y - b.y;
			return new vec2(x, y);
		}
	}

	protected vec3 sub(vec3 a, vec3 b) {
		if (a == null || b == null) {
			return null;
		} else {
			float x = a.x - b.x;
			float y = a.y - b.y;
			float z = a.z - b.z;
			return new vec3(x, y, z);
		}
	}

	protected vec4 sub(vec4 a, vec4 b) {
		if (a == null || b == null) {
			return null;
		} else {
			float x = a.x - b.x;
			float y = a.y - b.y;
			float z = a.z - b.z;
			float w = a.w - b.w;
			return new vec4(x, y, z, w);
		}
	}
	
	protected vec2 sub(vec2 a, float arg) {
	  return sub(a, new vec2(arg,arg));
	}

	protected vec3 sub(vec3 a, float arg) {
	  return sub(a, new vec3(arg,arg,arg));
	}

	protected vec4 sub(vec4 a, float arg) {  
	  return sub(a, new vec4(arg,arg,arg,arg));
	}

	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	protected vec2 mult(vec2 a, vec2 b) {
		if(a == null || b == null) {
			return null ;
		} else {
			float x = a.x() * b.x();
			float y = a.y() * b.y();
			return new vec2(x,y);
		}
	}

	protected vec3 mult(vec3 a, vec3 b) {
		if(a == null || b == null) {
			return null ;
		} else {
			float x = a.x() * b.x();
			float y = a.y() * b.y();
			float z = a.z() * b.z();
			return new vec3(x,y,z);
		}
	}

	protected vec4 mult(vec4 a, vec4 b) {
		if(a == null || b == null) {
			return null ;
		} else {
			float x = a.x() * b.x();
			float y = a.y() * b.y();
			float z = a.z() * b.z();
			float w = a.w() * b.w();
			return new vec4(x,y,z,w);
		}
	}
	
	protected vec2 mult(vec2 a, float arg) {
	  return mult(a, new vec2(arg,arg));
	}

	protected vec3 mult(vec3 a, float arg) {
	  return mult(a, new vec3(arg,arg,arg));
	}

	protected vec4 mult(vec4 a, float arg) {  
	  return mult(a, new vec4(arg,arg,arg,arg));
	}
	
	
	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	protected vec2 div(vec2 a, vec2 b) {
	  if(a == null || b == null) {
	    return null;
	  } else {
	    float x = a.x() /b.x();
	    float y = a.y() /b.y();
	    return new vec2(x,y);
	  }
	}

	protected vec3 div(vec3 a, vec3 b) {
	  if(a == null || b == null) {
	    return null;
	  } else {
	    float x = a.x() /b.x();
	    float y = a.y() /b.y();
	    float z = a.z() /b.z();
	    return new vec3(x,y,z);
	  }
	}

	protected vec4 div(vec4 a, vec4 b) {
	  if(a == null || b == null) {
	    return null ;
	  } else {
	    float x = a.x() /b.x();
	    float y = a.y() /b.y();
	    float z = a.z() /b.z();
	    float w = a.w() /b.w();
	    return new vec4(x,y,z,w);
	  }
	}
	
	protected vec2 div(vec2 a, float arg) {
	  return div(a, new vec2(arg,arg));
	}

	protected vec3 div(vec3 a, float arg) {
	  return div(a, new vec3(arg,arg,arg));
	}

	protected vec4 div(vec4 a, float arg) {  
	  return div(a, new vec4(arg,arg,arg,arg));
	}

	/**
	 * Cross product of vec3
	 * 
	 * @param v1
	 * @param v2
	 * @return
	 */
	protected vec3 cross(vec3 v1, vec3 v2) {
		if (v1 == null || v2 == null) {
			return null;
		} else {
			float crossX = v1.y * v2.z - v2.y * v1.z;
			float crossY = v1.z * v2.x - v2.z * v1.x;
			float crossZ = v1.x * v2.y - v2.x * v1.y;
			return new vec3(crossX, crossY, crossZ);
		}
	}
	
	
	/**
  *
  * Constrains a value to not exceed a maximum and minimum value.
  *
  * @webref math:calculation
  * @webBrief Constrains a value to not exceed a maximum and minimum value.
  * @param amt the value to constrain
  * @param low minimum limit
  * @param high maximum limit
  * @see PApplet#max(float, float, float)
  * @see PApplet#min(float, float, float)
  */
	protected int constrain(int amt, int low, int high) {
    return (amt < low) ? low : ((amt > high) ? high : amt);
  }


	protected float constrain(float amt, float low, float high) {
    return (amt < low) ? low : ((amt > high) ? high : amt);
  }
  
  
	/**
	 * map method
	 * 
	 * @param value
	 * @param start1
	 * @param stop1
	 * @param start2
	 * @param stop2
	 * @return Processing map() method
	 */
	protected float map(float value, float start1, float stop1, float start2, float stop2) {
		// return PApplet.map(value, start1, stop1, start2, stop2); // don't do that cause crash
		float output = start2 + (stop2 - start2) * ((value - start1) / (stop1 - start1));
		String badness = null;
		if (output != output) {
			badness = "NaN (not a number)";

		} else if (output == Float.NEGATIVE_INFINITY || output == Float.POSITIVE_INFINITY) {
			badness = "infinity";
		}
		if (badness != null) {
			final String msg = String.format("map(%s, %s, %s, %s, %s) called, which returns %s", value, start1, stop1, start2,
					stop2, badness);
			System.out.println(msg);
		}
		return output;
	}
	
	
	
	/**
	 * MATH
	 * v 0.1.1
	 * */

	/**
	 * 
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @return
	 */
	protected float dist(float x1, float y1, float x2, float y2) {
		float dx = x1 - x2;
		float dy = y1 - y2;
		return (float) Math.sqrt(dx*dx + dy*dy);
	}

	/**
	 * 
	 * @param x1
	 * @param y1
	 * @param z1
	 * @param x2
	 * @param y2
	 * @param z2
	 * @return
	 */
	protected float dist(float x1, float y1, float z1, float x2, float y2, float z2) {
		float dx = x1 - x2;
		float dy = y1 - y2;
		float dz = z1 - z2;
		return (float) Math.sqrt(dx*dx + dy*dy + dz*dz);
	}

	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	protected float dist(vec2 a, vec2 b) {
		if(a != null && b != null) {
			float dx = a.x() - b.x();
			float dy = a.y() - b.y();
			return (float) Math.sqrt(dx*dx + dy*dy);
		} else return Float.NaN ;	
	}

	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	protected float dist(vec3 a, vec3 b) {
		if(a != null && b != null) {
			float dx = a.x() - b.x();
			float dy = a.y() - b.y();
			float dz = a.z() - b.z();
			return (float) Math.sqrt(dx*dx + dy*dy + dz*dz);
		} else return Float.NaN ;
	}

	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	protected float dist(vec4 a, vec4 b) {
		if(a != null && b != null) {
			float dx = a.x() - b.x();
			float dy = a.y() - b.y();
			float dz = a.z() - b.z();
			float dw = a.w() - b.w();
			return (float) Math.sqrt(dx*dx + dy*dy + dz*dz + dw*dw);
		} else return Float.NaN ;
	}
	
	
	/**
	 * @link https://forum.processing.org/two/discussion/90/point-and-line-intersection-detection
	* refactoring from Quark Algorithm
	 * 
	 * @param start
	 * @param end
	 * @param point
	 * @param range
	 * @return
	 */
	protected boolean is_on_line(vec2 start, vec2 end, vec2 point, float range) {
		vec2 vp = new vec2();
		vec2 line = sub(end,start);
		float l2 = line.magSq();
		if (l2 == 0.0) {
			vp.set(start);
			return false;
		}
		vec2 pv0_line = sub(point, start);
		float t = pv0_line.dot(line)/l2;
		pv0_line.normalize();
		vp.set(line);
		vp.mult(t);
		vp.add(start);
		float d = dist(point, vp);
		if (t >= 0 && t <= 1 && d <= range) {
			return true;
		} else {
			return false;
		}
	}

	/**
	* @link https://forum.processing.org/one/topic/how-do-i-find-if-a-point-is-inside-a-complex-polygon.html
	* @link http://paulbourke.net/geometry/
	* thks to Moggach and Paul Brook
	 * @param points
	 * @param pos
	 * @return
	 */
	protected boolean in_polygon(vec [] points, vec2 pos) {
		int i, j;
		boolean is = false;
		int sides = points.length;
		for(i = 0, j = sides - 1 ; i < sides ; j = i++) {
			if (( ((points[i].y() <= pos.y()) && (pos.y() < points[j].y())) || ((points[j].y() <= pos.y()) && (pos.y() < points[i].y()))) &&
						(pos.x() < (points[j].x() - points[i].x()) * (pos.y() - points[i].y()) / (points[j].y() - points[i].y()) + points[i].x())) {
				is = !is;
			}
		}
		return is;
	}




	/**
	 * 
	 * @param pos
	 * @param range
	 * @param size
	 * @return
	 */
	protected vec3 to_cartesian_3D(vec2 pos, vec2 range, float size) {
		// vertical plan position
		float vertical_y = to_cartesian_2D(pos.y, new vec2(0, range.y), new vec2(0, TAU), size).x;
		float vertical_z = to_cartesian_2D(pos.y, new vec2(0, range.y), new vec2(0, TAU), size).y;
		vec3 pos_vertical = new vec3(0, vertical_y, vertical_z);
		// horizontal plan position
		float horizontal_x = to_cartesian_2D(pos.x, new vec2(0, range.x), new vec2(0, TAU), size).x;
		float horizontal_z = to_cartesian_2D(pos.x, new vec2(0, range.x), new vec2(0, TAU), size).y;
		vec3 pos_horizontal = new vec3(horizontal_x, 0, horizontal_z);

		return projection(barycenter(pos_vertical, pos_horizontal), size);
	}
  
	/**
	 * 
	 * @param latitude
	 * @param longitude
	 * @return
	 */
	protected vec3 to_cartesian_3D(float latitude, float longitude) {
		float radius_normal = 1;
		return to_cartesian_3D(latitude, longitude, radius_normal);
	}

	/**
	 * main method to_cartesian_3D
	 * @param latitude
	 * @param longitude
	 * @param radius
	 * @return
	 */
	protected vec3 to_cartesian_3D(float latitude, float longitude, float radius) {
		float theta = longitude % TAU;
		float phi = latitude % PI;

		float x = (float) (radius * Math.sin(theta) * Math.cos(phi));
		float y = (float) (radius * Math.sin(theta) * Math.sin(phi));
		float z = (float) (radius * Math.cos(theta));
		return new vec3(x, y, z);
	}
  
	/**
	 * 
	 * @param pos
	 * @param range
	 * @param target_rad
	 * @param distance
	 * @return
	 */
	protected vec2 to_cartesian_2D(float pos, vec2 range, vec2 target_rad, float distance) {
		float rotation_plan = map(pos, range.x, range.y, target_rad.x, target_rad.y);
		return to_cartesian_2D(rotation_plan, distance);
	}
  
	/**
	 * 
	 * @param angle
	 * @param radius
	 * @return
	 */
	protected vec2 to_cartesian_2D(float angle, float radius) {
		return to_cartesian_2D(angle).mult(radius);
	}

	/**
	 * main method to_cartesian_2D
	 * @param angle
	 * @return
	 */
	protected vec2 to_cartesian_2D(float angle) {
		float x = (float) Math.cos(angle);
		float y = (float) Math.sin(angle);
		return new vec2(x, y);
	}
  



	/**
	 * 
	 * @param v
	 * @return
	 */
	protected vec2 barycenter(vec2... v) {
		int div_num = v.length;
		vec2 sum = new vec2();
		for (int i = 0; i < div_num; i++) {
			sum.add(v[i]);
		}
		return sum.div(div_num);
	}
  
	/**
	 * 
	 * @param v
	 * @return
	 */
	protected vec3 barycenter(vec3... v) {
		int div_num = v.length;
		vec3 sum = new vec3();
		for (int i = 0; i < div_num; i++) {
			sum.add(v[i]);
		}
		return sum.div(div_num);
	}
  
	/**
	 * 
	 * @param v
	 * @return
	 */
	protected vec4 barycenter(vec4... v) {
		int div_num = v.length;
		vec4 sum = new vec4();
		for (int i = 0; i < div_num; i++) {
			sum.add(v[i]);
		}
		return sum.div(div_num);
	}
	
	



	/**
	 * Projection
	 * @param direction
	 * @return
	 */
	protected vec2 projection(vec2 direction) {
	  return projection(direction, new vec2(), (float)1.) ;
	}
  /**
   * 
   * @param direction
   * @param radius
   * @return
   */
	protected vec2 projection(vec2 direction, float radius) {
	  return projection(direction, new vec2(), radius) ;
	}
	
	/**
	 * 
	 * @param direction
	 * @param origin
	 * @param radius
	 * @return
	 */
	protected vec2 projection(vec2 direction, vec2 origin, float radius) {
	  // vec3 p = point_to_project.normalize(origin) ;
	  vec2 ref = direction.copy() ;
	  vec2 p = ref.dir(origin) ;
	  p.mult(radius) ;
	  p.add(origin) ;
	  return p ;
	}
	
	/**
	 * polar projection 2D
	 * @param angle
	 * @return
	 */
	protected vec2 projection(float angle) {
	  return projection(angle, 1) ;
	}
	
	/**
	 * 
	 * @param angle
	 * @param radius
	 * @return
	 */
	protected vec2 projection(float angle, float radius) {
	  return new vec2((float)Math.cos(angle) *radius, (float)Math.sin(angle) *radius) ;
	}
	/**
	 * cartesian projection 3D
	 * @param direction
	 * @return
	 */
	protected vec3 projection(vec3 direction) {
	  return projection(direction, new vec3(), (float)1.) ;
	}
  
	/**
	 * 
	 * @param direction
	 * @param radius
	 * @return
	 */
	protected vec3 projection(vec3 direction, float radius) {
	  return projection(direction, new vec3(), radius) ;
	}
  
	/**
	 * 
	 * @param direction
	 * @param origin
	 * @param radius
	 * @return
	 */
	protected vec3 projection(vec3 direction, vec3 origin, float radius) {
	  vec3 ref = direction.copy() ;
	  vec3 p = ref.dir(origin) ;
	  p.mult(radius) ;
	  p.add(origin) ;
	  return p ;
	}
	
	
	/**
	 * 
	 * @param high
	 * @return random number, this method is a copy of Processing one
	 */
	private Random internalRandom;
	protected float random(float high) {	
		// return pa.random(high); // don't do that because that's create a Processing dependency and need to pass this: PApplet in the sketch
		// avoid an infinite loop when 0 or NaN are passed in
		if (high == 0 || high != high) {
			return 0;
		}

		if (internalRandom == null) {
			internalRandom = new Random();
		}

		// for some reason (rounding error?) Math.random() * 3
		// can sometimes return '3' (once in ~30 million tries)
		// so a check was added to avoid the inclusion of 'howbig'
		float value = 0;
		do {
			value = internalRandom.nextFloat() * high;
		} while (value == high);
		return value;
	}

	/**
	 * 
	 * @param low
	 * @param high
	 * @return random number, this method is a copy of Processing one
	 */
	protected float random(float low, float high) {
		// return pa.random(low,high); // don't do that because that's create a Processing dependency and need to pass this: PApplet in the sketch
		if (low >= high)
			return low;
		float diff = high - low;
		float value = 0;
		// because of rounding error, can't just add low, otherwise it may hit high
		// https://github.com/processing/processing/issues/4551
		do {
			value = random(diff) + low;
		} while (value == high);
		return value;
	}

		/**
	 * Next Gaussian randomize v 0.0.2
	 */
	/**
	 * return value from -1 to 1
	 * 
	 * @return float
	 */
	private Random random = new Random();
	public float random_next_gaussian() {
		return random_next_gaussian(1, 1);
	}
  
	/**
	 * 
	 * @param n
	 * @return
	 */
	public float random_next_gaussian(int n) {
		return random_next_gaussian(1, n);
	}
  
	/**
	 * 
	 * @param range
	 * @return
	 */
	public float random_next_gaussian(float range) {
		return random_next_gaussian(range, 1);
	}
	
	/**
	 * 
	 * @param range
	 * @param n
	 * @return
	 */
	public float random_next_gaussian(float range, int n) {
		float roots = (float) random.nextGaussian();
		float var = map(roots, -2.5f, 2.5f, -1, 1);
		if (n > 1) {
			if (n % 2 == 0 && var < 0) {
				var = -1 * (float) Math.pow(var, n);
			} else {
				var = (float) Math.pow(var, n);
			}
			return var * range;
		} else {
			return var * range;
		}
	}

	
	
	/**
	 * MIN MAX method
	 */
	private String ERROR_MIN_MAX = "Cannot use min() or max() on an empty array.";
	/**
	 * 
	 * @param arg
	 * @return from Processing max() method
	 */
	protected float max(float... list) {
		// return PApplet.max(list); // don't do that cause crash
		if (list.length == 0) {
			throw new ArrayIndexOutOfBoundsException(ERROR_MIN_MAX);
		}
		float max = list[0];
		for (int i = 1; i < list.length; i++) {
			if (list[i] > max)
				max = list[i];
		}
		return max;
	}

	protected int max(int... list) {
		// return PApplet.max(list); // don't do that cause crash
		if (list.length == 0) {
			throw new ArrayIndexOutOfBoundsException(ERROR_MIN_MAX);
		}
		int max = list[0];
		for (int i = 1; i < list.length; i++) {
			if (list[i] > max)
				max = list[i];
		}
		return max;
	}

	protected vec2 max(vec2 a, vec2 b) {
  	return new vec2(max(a.x(),b.x()),max(a.y(),b.y()));
	}

	protected vec3 max(vec3 a, vec3 b) {
  	return new vec3(max(a.x(),b.x()),max(a.y(),b.y()),max(a.z(),b.z()));
	}

	protected vec4 max(vec4 a, vec4 b) {
  	return new vec4(max(a.x(),b.x()),max(a.y(),b.y()),max(a.z(),b.z()),max(a.w(),b.w()));
	}

	protected ivec2 max(ivec2 a, ivec2 b) {
  	return new ivec2(max(a.x(),b.x()),max(a.y(),b.y()));
	}

	protected ivec3 max(ivec3 a, ivec3 b) {
  	return new ivec3(max(a.x(),b.x()),max(a.y(),b.y()),max(a.z(),b.z()));
	}

	protected ivec4 max(ivec4 a, ivec4 b) {
  	return new ivec4(max(a.x(),b.x()),max(a.y(),b.y()),max(a.z(),b.z()),max(a.w(),b.w()));
	}





	/**
	 * 
	 * @param arg
	 * @return Processing min() method
	 */
	protected float min(float... list) {
		if (list.length == 0) {
			throw new ArrayIndexOutOfBoundsException(ERROR_MIN_MAX);
		}
		float min = list[0];
		for (int i = 1; i < list.length; i++) {
			if (list[i] < min)
				min = list[i];
		}
		return min;
	}
	protected int min(int... list) {
		if (list.length == 0) {
			throw new ArrayIndexOutOfBoundsException(ERROR_MIN_MAX);
		}
		int min = list[0];
		for (int i = 1; i < list.length; i++) {
			if (list[i] < min)
				min = list[i];
		}
		return min;
	}

	protected vec2 min(vec2 a, vec2 b) {
		return new vec2(min(a.x(),b.x()),min(a.y(),b.y()));
	}

	protected vec3 min(vec3 a, vec3 b) {
		return new vec3(min(a.x(),b.x()),min(a.y(),b.y()),min(a.z(),b.z()));
	}

	protected vec4 min(vec4 a, vec4 b) {
		return new vec4(min(a.x(),b.x()),min(a.y(),b.y()),min(a.z(),b.z()),min(a.w(),b.w()));
	}

	protected ivec2 min(ivec2 a, ivec2 b) {
		return new ivec2(min(a.x(),b.x()),min(a.y(),b.y()));
	}

	protected ivec3 min(ivec3 a, ivec3 b) {
		return new ivec3(min(a.x(),b.x()),min(a.y(),b.y()),min(a.z(),b.z()));
	}

	protected ivec4 min(ivec4 a, ivec4 b) {
		return new ivec4(min(a.x(),b.x()),min(a.y(),b.y()),min(a.z(),b.z()),min(a.w(),b.w()));
	}





	/**
	abs
	*/
	protected float abs(float arg) {
		return Math.abs(arg);
	}

	protected int abs(int arg) {
		return Math.abs(arg);
	}

	protected vec2 abs(vec2 arg) {
		return new vec2(Math.abs(arg.x()),Math.abs(arg.y()));
	}

	protected vec3 abs(vec3 arg) {
		return new vec3(Math.abs(arg.x()),Math.abs(arg.y()),Math.abs(arg.z()));
	}

	protected vec4 abs(vec4 arg) {
		return new vec4(Math.abs(arg.x()),Math.abs(arg.y()),Math.abs(arg.z()),Math.abs(arg.w()));
	}

	protected ivec2 abs(ivec2 arg) {
		return new ivec2(Math.abs(arg.x()),Math.abs(arg.y()));
	}

	protected ivec3 abs(ivec3 arg) {
		return new ivec3(Math.abs(arg.x()),Math.abs(arg.y()),Math.abs(arg.z()));
	}

	protected ivec4 abs(ivec4 arg) {
		return new ivec4(Math.abs(arg.x()),Math.abs(arg.y()),Math.abs(arg.z()),Math.abs(arg.w()));
	}


	/**
	 * 
	 * @param value
	 * @return
	 */
	protected int floor(float value) {
		return (int)Math.floor(value);
	}
	
	protected vec2 floor(vec2 arg) {
	  return new vec2(floor(arg.x()),floor(arg.y()));
	}

	protected vec3 floor(vec3 arg) {
	  return new vec3(floor(arg.x()),floor(arg.y()),floor(arg.z()));
	}

	protected vec4 floor(vec4 arg) {
	  return new vec4(floor(arg.x()),floor(arg.y()),floor(arg.z()),floor(arg.w()));
	}

	/**
	 * 
	 * @param value
	 * @return
	 */
	protected int ceil(float value) {
		return (int)Math.ceil(value);
	}
	
	protected vec2 ceil(vec2 arg) {
	  return new vec2(ceil(arg.x()),ceil(arg.y()));
	}

	protected vec3 ceil(vec3 arg) {
	  return new vec3(ceil(arg.x()),ceil(arg.y()),ceil(arg.z()));
	}

	protected vec4 ceil(vec4 arg) {
	  return new vec4(ceil(arg.x()),ceil(arg.y()),ceil(arg.z()),ceil(arg.w()));
	}

	/**
	 * 
	 * @param value
	 * @return
	 */
	protected int round(float value) {
		return Math.round(value);
	}
	
	protected vec2 round(vec2 arg) {
	  return new vec2(round(arg.x()),round(arg.y()));
	}

	protected vec3 round(vec3 arg) {
	  return new vec3(round(arg.x()),round(arg.y()),round(arg.z()));
	}

	protected vec4 round(vec4 arg) {
	  return new vec4(round(arg.x()),round(arg.y()),round(arg.z()),round(arg.w()));
	}

	/**
	 * 
	 * @param value
	 * @return
	 */
	protected float sq(float value) {
		return value * value;
	}
	
	/**
	 * 
	 * @param value
	 * @return
	 */
	protected float sqrt(float value) {
		return (float)Math.sqrt(value);
	}

	/**
	 * 
	 * @param n
	 * @param e
	 * @return
	 */
	protected float pow(float n, float e) {
    return (float)Math.pow(n, e);
  }

	/**
	 * 
	 * @param value
	 * @return
	 */
	protected float atan(float value) {
		return (float)Math.atan(value);
	}

	/**
	 * 
	 * @param value
	 * @return
	 */
	protected float cos(float value) {
		return (float)Math.cos(value);
	}

	/**
	 * 
	 * @param value
	 * @return
	 */
	protected float sin(float value) {
		return (float)Math.sin(value);
	}
	
	
	
	
	
	
	
	
	/*
	 * GLSL METHOD TO COMPARE
	 *
	 */

	/**
	mix
	*/
	public float mix(float x, float y, float a) {
		return x*(1-a)+y*a;
	}

	public vec2 mix(vec2 x, vec2 y, vec2 a) {
		return new vec2(mix(x.x,y.x,a.x),mix(x.y,y.y,a.y));
	}

	public vec3 mix(vec3 x, vec3 y, vec3 a) {
		return new vec3(mix(x.x,y.x,a.x),mix(x.y,y.y,a.y),mix(x.z,y.z,a.z));
	}

	public vec4 mix(vec4 x, vec4 y, vec4 a) {
		return new vec4(mix(x.x,y.x,a.x),mix(x.y,y.y,a.y),mix(x.z,y.z,a.z),mix(x.w,y.w,a.w));
	}

	/**
	fract
	*/
	public float fract(float x) {
		return x - (float)Math.floor(x);
	}

	public vec2 fract(vec2 v) {
		return new vec2(fract(v.x),fract(v.y));
	}

	public vec3 fract(vec3 v) {
		return new vec3(fract(v.x),fract(v.y),fract(v.z));
	}

	public vec4 fract(vec4 v) {
		return new vec4(fract(v.x),fract(v.y),fract(v.z),fract(v.w));
	}

	/**
	sign
	*/
	public float sign(float x) {
		if(x < 0 ) {
			return -1.0f;
		} else if(x > 0) {
			return 1.0f;
		} else return 0.0f;
	}

	public vec2 sign(vec2 x) {
		return new vec2(sign(x.x),sign(x.y));
	}

	public vec3 sign(vec3 x) {
		return new vec3(sign(x.x),sign(x.y),sign(x.z));
	}

	public vec4 sign(vec4 x) {
		return new vec4(sign(x.x),sign(x.y),sign(x.z),sign(x.w));
	}


	public int sign(int x) {
		return (int)sign((float)x);
	}

	public ivec2 sign(ivec2 x) {
		return new ivec2(sign(x.x()),sign(x.y()));
	}

	public ivec3 sign(ivec3 x) {
		return new ivec3(sign(x.x()),sign(x.y()),sign(x.z()));
	}

	public ivec4 sign(ivec4 x) {
		return new ivec4(sign(x.x()),sign(x.y()),sign(x.z()),sign(x.w()));
	}


	/**
	step
	*/
	public float step(float edge, float x) {
		if(x < edge) return 0; else return 1;
	}

	public vec2 step(vec2 edge, vec2 x) {
		return new vec2(step(edge.x(),x.x()),step(edge.y(),x.y()));
	}

	public vec3 step(vec3 edge, vec3 x) {
		return new vec3(step(edge.x(),x.x()),step(edge.y(),x.y()),step(edge.z(),x.z()));
	}

	public vec4 step(vec4 edge, vec4 x) {
		return new vec4(step(edge.x(),x.x()),step(edge.y(),x.y()),step(edge.z(),x.z()),step(edge.w(),x.w()));
	}


	/**
	smoothstep
	*/
	public float smoothstep(float edge0, float edge1, float x) {
		if(x <= edge0) {
			return 0; 
		} else if(x >= edge1) {
			return 1;
		} else {
			float t = clamp((x-edge0)/(edge1-edge0),0.0f,1.0f);
			return t*t*(3.0f-2.0f*t);
		}
	}

	public vec2 smoothstep(vec2 edge0, vec2 edge1, vec2 x) {
		return new vec2(smoothstep(edge0.x(),edge1.x(),x.x()),smoothstep(edge0.y(),edge1.y(),x.y()));
	}

	public vec3 smoothstep(vec3 edge0, vec3 edge1, vec3 x) {
		return new vec3(smoothstep(edge0.x(),edge1.x(),x.x()),smoothstep(edge0.y(),edge1.y(),x.y()),smoothstep(edge0.z(),edge1.z(),x.z()));
	}

	public vec4 smoothstep(vec4 edge0, vec4 edge1, vec4 x) {
		return new vec4(smoothstep(edge0.x(),edge1.x(),x.x()),smoothstep(edge0.y(),edge1.y(),x.y()),smoothstep(edge0.z(),edge1.z(),x.z()),smoothstep(edge0.w(),edge1.w(),x.w()));
	}



	/*
	mod
	*/
	public float mod(float x, float y) {
		return x-y*(float)Math.floor(x/y);
	}

	public vec2 mod(vec2 x, vec2 y) {
		return new vec2(mod(x.x(),y.x()),mod(x.y(),y.y()));
	}

	public vec3 mod(vec3 x, vec3 y) {
		return new vec3(mod(x.x(),y.x()),mod(x.y(),y.y()),mod(x.z(),y.z()));
	}

	public vec4 mod(vec4 x, vec4 y) {
		return new vec4(mod(x.x(),y.x()),mod(x.y(),y.y()),mod(x.z(),y.z()),mod(x.w(),y.w()));
	}

	public ivec2 mod(ivec2 x, ivec2 y) {
		return new ivec2((int)mod(x.x(),y.x()), (int)mod(x.y(),y.y()));
	}

	public ivec3 mod(ivec3 x, ivec3 y) {
		return new ivec3((int)mod(x.x(),y.x()),(int)mod(x.y(),y.y()),(int)mod(x.z(),y.z()));
	}

	public ivec4 mod(ivec4 x, ivec4 y) {
		return new ivec4((int)mod(x.x(),y.x()),(int)mod(x.y(),y.y()),(int)mod(x.z(),y.z()),(int)mod(x.w(),y.w()));
	}

	/**
	clamp
	*/
	public float clamp(float x, float min, float max) {
		return Math.min(Math.max(x,min),max);
	}

	public vec2 clamp(vec2 x, vec2 min, vec2 max) {
		return min(max(x,min),max);
	}

	public vec3 clamp(vec3 x, vec3 min, vec3 max) {
		return min(max(x,min),max);
	}

	public vec4 clamp(vec4 x, vec4 min, vec4 max) {
		return min(max(x,min),max);
	}




	/**
	equal
	*/
	public boolean equal(float x, float y) {
		return x==y?true:false;
	}

	public boolean equal(int x, int y) {
		return equal((float)x,(float)y);
	}

	// with vec
	public bvec2 equal(vec2 x, vec2 y) {
		if(x != null && y != null) {
			return new bvec2(equal(x.x(),y.x()),equal(x.y(),y.y()));
		} else return null;
	}

	public bvec3 equal(vec3 x, vec3 y) {
		if(x != null && y != null) {
			return new bvec3(equal(x.x(),y.x()),equal(x.y(),y.y()),equal(x.z(),y.z()));
		} else return null;
	}

	public bvec4 equal(vec4 x, vec4 y) {
		if(x != null && y != null) {
			return new bvec4(equal(x.x(),y.x()),equal(x.y(),y.y()),equal(x.z(),y.z()),equal(x.w(),y.w()));
		} else return null;
	}

	// width ivec
	public bvec2 equal(ivec2 x, ivec2 y) {
		if(x != null && y != null) {
			return new bvec2(equal(x.x(),y.x()),equal(x.y(),y.y()));
		} else return null;
	}

	public bvec3 equal(ivec3 x, ivec3 y) {
		if(x != null && y != null) {
			return new bvec3(equal(x.x(),y.x()),equal(x.y(),y.y()),equal(x.z(),y.z()));
		} else return null;
	}

	public bvec4 equal(ivec4 x, ivec4 y) {
		if(x != null && y != null) {
			return new bvec4(equal(x.x(),y.x()),equal(x.y(),y.y()),equal(x.z(),y.z()),equal(x.w(),y.w()));
		} else return null;
	}




	/**
	lessThan
	*/
	public boolean lessThan(float x, float y) {
		return x<y?true:false;
	}

	public boolean lessThan(int x, int y) {
		return lessThan((float)x,(float)y);
	}

	// with vec
	public bvec2 lessThan(vec2 x, vec2 y) {
		if(x != null && y != null) {
			return new bvec2(lessThan(x.x(),y.x()),lessThan(x.y(),y.y()));
		} else return null;
	}

	public bvec3 lessThan(vec3 x, vec3 y) {
		if(x != null && y != null) {
			return new bvec3(lessThan(x.x(),y.x()),lessThan(x.y(),y.y()),lessThan(x.z(),y.z()));
		} else return null;
	}

	public bvec4 lessThan(vec4 x, vec4 y) {
		if(x != null && y != null) {
			return new bvec4(lessThan(x.x(),y.x()),lessThan(x.y(),y.y()),lessThan(x.z(),y.z()),lessThan(x.w(),y.w()));
		} else return null;
	}

	// width ivec
	public bvec2 lessThan(ivec2 x, ivec2 y) {
		if(x != null && y != null) {
			return new bvec2(lessThan(x.x(),y.x()),lessThan(x.y(),y.y()));
		} else return null;
	}

	public bvec3 lessThan(ivec3 x, ivec3 y) {
		if(x != null && y != null) {
			return new bvec3(lessThan(x.x(),y.x()),lessThan(x.y(),y.y()),lessThan(x.z(),y.z()));
		} else return null;
	}

	public bvec4 lessThan(ivec4 x, ivec4 y) {
		if(x != null && y != null) {
			return new bvec4(lessThan(x.x(),y.x()),lessThan(x.y(),y.y()),lessThan(x.z(),y.z()),lessThan(x.w(),y.w()));
		} else return null;
	}





	/**
	greaterThan
	*/
	public boolean greaterThan(float x, float y) {
		return x>y?true:false;
	}

	public boolean greaterThan(int x, int y) {
		return greaterThan((float)x,(float)y);
	}

	// with vec
	public bvec2 greaterThan(vec2 x, vec2 y) {
		if(x != null && y != null) {
			return new bvec2(greaterThan(x.x(),y.x()),greaterThan(x.y(),y.y()));
		} else return null; 
	}

	public bvec3 greaterThan(vec3 x, vec3 y) {
		if(x != null && y != null) {
			return new bvec3(greaterThan(x.x(),y.x()),greaterThan(x.y(),y.y()),greaterThan(x.z(),y.z()));
		} else return null; 
	}

	public bvec4 greaterThan(vec4 x, vec4 y) {
		if(x != null && y != null) {
			return new bvec4(greaterThan(x.x(),y.x()),greaterThan(x.y(),y.y()),greaterThan(x.z(),y.z()),greaterThan(x.w(),y.w()));
		} else return null; 
	}

	// width ivec
	public bvec2 greaterThan(ivec2 x, ivec2 y) {
		if(x != null && y != null) {
			return new bvec2(greaterThan(x.x(),y.x()),greaterThan(x.y(),y.y()));
		} else return null; 
	}

	public bvec3 greaterThan(ivec3 x, ivec3 y) {
		if(x != null && y != null) {
			return new bvec3(greaterThan(x.x(),y.x()),greaterThan(x.y(),y.y()),greaterThan(x.z(),y.z()));
		} else return null; 
	}

	public bvec4 greaterThan(ivec4 x, ivec4 y) {
		if(x != null && y != null) {
			return new bvec4(greaterThan(x.x(),y.x()),greaterThan(x.y(),y.y()),greaterThan(x.z(),y.z()),greaterThan(x.w(),y.w()));
		} else return null; 
	}


	/**
	greaterThanEqual
	*/
	public boolean greaterThanEqual(float x, float y) {
		return x>=y?true:false;
	}

	public boolean greaterThanEqual(int x, int y) {
		return greaterThanEqual((float)x,(float)y);
	}

	// with vec
	public bvec2 greaterThanEqual(vec2 x, vec2 y) {
		if(x != null && y != null) {
			return new bvec2(greaterThanEqual(x.x(),y.x()),greaterThanEqual(x.y(),y.y()));
		} else return null; 
	}

	public bvec3 greaterThanEqual(vec3 x, vec3 y) {
		if(x != null && y != null) {
			return new bvec3(greaterThanEqual(x.x(),y.x()),greaterThanEqual(x.y(),y.y()),greaterThanEqual(x.z(),y.z()));
		} else return null; 
	}

	public bvec4 greaterThanEqual(vec4 x, vec4 y) {
		if(x != null && y != null) {
			return new bvec4(greaterThanEqual(x.x(),y.x()),greaterThanEqual(x.y(),y.y()),greaterThanEqual(x.z(),y.z()),greaterThanEqual(x.w(),y.w()));
		} else return null; 
	}

	// width ivec
	public bvec2 greaterThanEqual(ivec2 x, ivec2 y) {
		if(x != null && y != null) {
			return new bvec2(greaterThanEqual(x.x(),y.x()),greaterThanEqual(x.y(),y.y()));
		} else return null; 
	}

	public bvec3 greaterThanEqual(ivec3 x, ivec3 y) {
		if(x != null && y != null) {
			return new bvec3(greaterThanEqual(x.x(),y.x()),greaterThanEqual(x.y(),y.y()),greaterThanEqual(x.z(),y.z()));
		} else return null; 
	}

	public bvec4 greaterThanEqual(ivec4 x, ivec4 y) {
		if(x != null && y != null) {
			return new bvec4(greaterThanEqual(x.x(),y.x()),greaterThanEqual(x.y(),y.y()),greaterThanEqual(x.z(),y.z()),greaterThanEqual(x.w(),y.w()));
		} else return null; 
	}


	/**
	lessThanEqual
	*/
	public boolean lessThanEqual(float x, float y) {
		return x<=y?true:false;
	}

	public boolean lessThanEqual(int x, int y) {
		return lessThanEqual((float)x,(float)y);
	}

	// with vec
	public bvec2 lessThanEqual(vec2 x, vec2 y) {
		if(x != null && y != null) {
			return new bvec2(lessThanEqual(x.x(),y.x()),lessThanEqual(x.y(),y.y()));
		} else return null; 
	}

	public bvec3 lessThanEqual(vec3 x, vec3 y) {
		if(x != null && y != null) {
			return new bvec3(lessThanEqual(x.x(),y.x()),lessThanEqual(x.y(),y.y()),lessThanEqual(x.z(),y.z()));
		} else return null; 
	}

	public bvec4 lessThanEqual(vec4 x, vec4 y) {
		if(x != null && y != null) {
			return new bvec4(lessThanEqual(x.x(),y.x()),lessThanEqual(x.y(),y.y()),lessThanEqual(x.z(),y.z()),lessThanEqual(x.w(),y.w()));
		} else return null; 
	}

	// width ivec
	public bvec2 lessThanEqual(ivec2 x, ivec2 y) {
		if(x != null && y != null) {
			return new bvec2(lessThanEqual(x.x(),y.x()),lessThanEqual(x.y(),y.y()));
		} else return null; 
	}

	public bvec3 lessThanEqual(ivec3 x, ivec3 y) {
		if(x != null && y != null) {
			return new bvec3(lessThanEqual(x.x(),y.x()),lessThanEqual(x.y(),y.y()),lessThanEqual(x.z(),y.z()));
		} else return null; 
	}

	public bvec4 lessThanEqual(ivec4 x, ivec4 y) {
		if(x != null && y != null) {
			return new bvec4(lessThanEqual(x.x(),y.x()),lessThanEqual(x.y(),y.y()),lessThanEqual(x.z(),y.z()),lessThanEqual(x.w(),y.w()));
		} else return null; 
	}



	/**
	all
	v 0.0.2
	*/
	public boolean all(bvec2 b) {
		if(b != null) {
			boolean [] list = b.array();
			boolean result = true;
			for(int i = 0 ; i < list.length ; i++) {
				if(list[i] == false) {
					result = false;
					break;
				}
			}
			return result;
		} else {
			System.err.println("method all(bvec2 b) return false bvec2 b is null");
			return false;
		}
	}

	public boolean all(bvec3 b) {
		if(b != null) {
			boolean [] list = b.array();
			boolean result = true;
			for(int i = 0 ; i < list.length ; i++) {
				if(list[i] == false) {
					result = false;
					break;
				}
			}
			return result;
		} else {
			System.err.println("method all(bvec3 b) return false because bvec3 b is null");
			return false;
		}
	}

	public boolean all(bvec4 b) {
		if(b != null) {
			boolean [] list = b.array();
			boolean result = true;
			for(int i = 0 ; i < list.length ; i++) {
				if(list[i] == false) {
					result = false;
					break;
				}
			}
			return result;
		} else {
			System.err.println("method all(bvec4 b) return false because bvec4 b is null");
			return false;
		}
	}

	public boolean all(bvec5 b) {
		if(b != null) {
			boolean [] list = b.array();
			boolean result = true;
			for(int i = 0 ; i < list.length ; i++) {
				if(list[i] == false) {
					result = false;
					break;
				}
			}
			return result;
		} else {
			System.err.println("method all(bvec5 b) return false because bvec5 b is null");
			return false;
		}
	}

	public boolean all(bvec6 b) {
		if(b != null) {
			boolean [] list = b.array();
			boolean result = true;
			for(int i = 0 ; i < list.length ; i++) {
				if(list[i] == false) {
					result = false;
					break;
				}
			}
			return result;
		} else {
			System.err.println("method all(bvec6 b) return false because bvec6 b is null");
			return false;
		}
	}
	
	/**
	 * 
	 * @param list
	 * @return true if all elments of the list is true
	 */
	public boolean all(boolean ...list) {
		boolean result = true;
		for(int i = 0 ; i < list.length ; i++) {
			if(list[i] == false) {
				result = false;
				break;
			}
		}
		return result;
	}

	/**
	any
	*/
	public boolean any(bvec2 b) {
		if(b != null) {
			boolean [] list = b.array();
			boolean result = false;
			for(int i = 0 ; i < list.length ; i++) {
				if(list[i] == true) {
					result = true;
					break;
				}
			}
			return result;
		} else {
			System.err.println("method any() return false because argument bvec2 b is null");
			return false;
		}
	}

	public boolean any(bvec3 b) {
		if(b != null) {
			boolean [] list = b.array();
			boolean result = false;
			for(int i = 0 ; i < list.length ; i++) {
				if(list[i] == true) {
					result = true;
					break;
				}
			}
			return result;
		} else {
			System.err.println("method any() return false because argument bvec3 b is null");
			return false;
		}
	}

	public boolean any(bvec4 b) {
		if(b != null) {
			boolean [] list = b.array();
			boolean result = false;
			for(int i = 0 ; i < list.length ; i++) {
				if(list[i] == true) {
					result = true;
					break;
				}
			}
			return result;
		} else {
			System.err.println("method any() return false because argument bvec4 b is null");
			return false;
		}
	}

	public boolean any(bvec5 b) {
		if(b != null) {
			boolean [] list = b.array();
			boolean result = false;
			for(int i = 0 ; i < list.length ; i++) {
				if(list[i] == true) {
					result = true;
					break;
				}
			}
			return result;
		} else {
			System.err.println("method any() return false because argument bvec5 b is null");
			return false;
		}
	}

	public boolean any(bvec6 b) {
		if(b != null) {
			boolean [] list = b.array();
			boolean result = false;
			for(int i = 0 ; i < list.length ; i++) {
				if(list[i] == true) {
					result = true;
					break;
				}
			}
			return result;
		} else {
			System.err.println("method any() return false because argument bvec6 b is null");
			return false;
		}
	}
	
	/**
	 * 
	 * @param list
	 * @return return true if any element of the list is true
	 */
	public boolean any(boolean ...list) {
		boolean result = false;
		for(int i = 0 ; i < list.length ; i++) {
			if(list[i] == true) {
				result = true;
				break;
			}
		}
		return result;
	}
	
	
	
	
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @param width the width of you 2D array pixel
	 * @return a linear position from a 2D array tab
	 */
	public int index_pixel_array(int x, int y, int width) {
		return (x + y * width);
	}
	
	
	
	
	
	
	public float truncate(float x) {
		return round(x * 100.0f) /100.0f;
	}
	
	/**
	 * 
	 * @param x
	 * @param num
	 * @return a float number with a number after comma equal to the num arg
	 */
	public float truncate(float x, int num) {
		float result = 0.0f;
		switch(num) {
			case 0:
				result = round(x * 1.0f) /1.0f;
				break;
			case 1:
				result = round(x * 10.0f) /10.0f;
				break;
			case 2:
				result = round(x * 100.0f) /100.0f;
				break;
			case 3:
				result = round(x * 1000.0f) /1000.0f;
				break;
			case 4:
				result = round(x * 10000.0f) /10000.0f;
				break;
			case 5:
				result = round(x * 100000.0f) /100000.0f;
				break;
			default:
				result = x;
				break;
		}
		return result;
	}


	 /**
  *
  * Converts a <b>String</b> representation of a hexadecimal number to its
  * equivalent integer value.
  *
  *
	*/
	public int unhex(String value) {
    // has to parse as a Long so that it'll work for numbers bigger than 2^31
    return (int) (Long.parseLong(value, 16));
  }

	/**
	 * 
	 * @param value
	 * @param delim
	 * @return
	 */
	public String[] split(String value, char delim) {
    // do this so that the exception occurs inside the user's
    // program, rather than appearing to be a bug inside split()
    if (value == null) return null;
    //return split(what, String.valueOf(delim));  // huh

    char[] chars = value.toCharArray();
    int splitCount = 0; //1;
    for (char ch : chars) {
      if (ch == delim) splitCount++;
    }
    // make sure that there is something in the input string
    //if (chars.length > 0) {
      // if the last char is a delimeter, get rid of it..
      //if (chars[chars.length-1] == delim) splitCount--;
      // on second thought, i don't agree with this, will disable
    //}
    if (splitCount == 0) {
      String[] splits = new String[1];
      splits[0] = value;
      return splits;
    }
    //int pieceCount = splitCount + 1;
    String[] splits = new String[splitCount + 1];
    int splitIndex = 0;
    int startIndex = 0;
    for (int i = 0; i < chars.length; i++) {
      if (chars[i] == delim) {
        splits[splitIndex++] =
          new String(chars, startIndex, i-startIndex);
        startIndex = i + 1;
      }
    }
    //if (startIndex != chars.length) {
      splits[splitIndex] =
        new String(chars, startIndex, chars.length-startIndex);
    //}
    return splits;
  }

	/**
	 * 
	 * @param value
	 * @param delim
	 * @return
	 */
	public String[] split(String value, String delim) {
    List<String> items = new ArrayList<>();
    int index;
    int offset = 0;
    while ((index = value.indexOf(delim, offset)) != -1) {
      items.add(value.substring(offset, index));
      offset = index + delim.length();
    }
    items.add(value.substring(offset));
    String[] outgoing = new String[items.size()];
    items.toArray(outgoing);
    return outgoing;
  }



	





	/**
	 * remove the path of your String to return the file name of it.
	 * @param file_path
	 * @return
	 */
	public String file_name(String file_path) {
		String file_name = "" ;
		String [] split_path = file_path.split("/") ;
		file_name = split_path[split_path.length -1] ;
		return file_name ;
	}
	/**
	 * 
	 * @param obj
	 */
	
	private String write_message(Object... obj) {
		String mark = " ";
		return write_message_sep(mark,obj);
	}
	private String write_message_sep(String separator, Object... obj) {
		String m = "";
		for(int i = 0 ; i < obj.length ; i++) {
			m += write_message(obj[i], obj.length,i,separator);
		}
		return m;
	}

	// local method
	private String write_message(Object obj, int length, int i, String separator) {
		String message = "";
		String add = "";
		if(i == length -1) { 
			if(obj == null) {
				add = "null";
			} else {
				add = obj.toString();
			}
			return message += add;
		} else {
			if(obj == null) {
				add = "null";
			} else {
				add = obj.toString();
			}
			return message += add + separator;
		}
	}
	
	
	

	/**
	 * 
	 * @param obj
	 */
	public void print_err(Object... obj) {
		System.err.println(write_message(obj));
		System.err.flush();
	}
	
	
	public void print_err_tempo(int tempo, Object... obj) {
		if(System.currentTimeMillis()/10%tempo == 0) {
			String message = write_message(obj);
			System.err.println(message);
			System.err.flush();
		}
	}

	public void print_tempo(int tempo, Object... obj) {
		if(System.currentTimeMillis()/10%tempo == 0) {
			String message = write_message(obj);
			System.out.println(message);
		}
	}
	
	
	/**
	* Check OS
	* v 0.0.2
	*/
	public String get_os() {
		return System.getProperty("os.name").toLowerCase();
	}

	public String get_os_family() {
		String os = System.getProperty("os.name").toLowerCase();
		String family = "";
		if(os.indexOf("win") >= 0) {
			family = "win";
		} else if(os.indexOf("mac") >= 0) {
			family = "mac";
		} else if(os.indexOf("nix") >= 0 || os.indexOf("nux") >= 0 || os.indexOf("aix") >= 0) {
			family = "unix";
		} else if(os.indexOf("solaris") >= 0) {
			family = "solaris";
		}
		return family;
	}
	
	

	
	
	
}
