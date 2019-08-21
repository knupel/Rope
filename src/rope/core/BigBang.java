/**
* ROPE > ROmanesco Processing Environment
* Copyleft (c) 2014-2019
* Processing 3.5.3
* @author @stanlepunk
* @see http://stanlepunk.xyz/
* @see https://github.com/StanLepunK/Rope
*/

/**
 * BIG BANG ROPE
 * is the main class of library
 * 2018-2019
 * v 1.0.0
 */
package rope.core;

import java.util.Random;
import rope.vector.*;
import processing.core.*;

/**
 * I try to catch Processing method but my knowledge is to low to pass this
 * Static problem, so I rewrite the method from processing core
 * processing.core.PApplet.random(high);
 * processing.core.PApplet.random(low,high); processing.core.PApplet.min(float
 * [] arg); processing.core.PApplet.min(int [] arg);
 * processing.core.PApplet.max(float [] arg); processing.core.PApplet.max(int []
 * arg); processing.core.PApplet.map(float value, float start1, float stop1,
 * float start2, float stop2); Cannot make a static reference to the non-static
 * method random(float) from the type PApplet
 */

public abstract class BigBang implements R_Constants,R_Constants_Colour {
	public PApplet pa;
	
	public BigBang() {
	}
	
	public BigBang(PApplet pa) {
		this.pa = pa;
	}

	private String VERSION = "0.8.5.30";

	public String version() {
		return VERSION;
	}
  
	
	/**
	 * OPERATION
	 */
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

	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
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

	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
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
	 * To cartesian coord
	 */
	
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
	Random internalRandom;
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
	 * MIN MAX method
	 */
	private String ERROR_MIN_MAX = "Cannot use min() or max() on an empty array.";
	/**
	 * 
	 * @param arg
	 * @return from Processing max() method
	 */
	protected float max(float[] list) {
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

	protected int max(int[] list) {
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

	/**
	 * 
	 * @param arg
	 * @return Processing min() method
	 */
	protected float min(float[] list) {
		// return PApplet.min(list); // don't do that cause crash
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

	protected int min(int[] list) {
		// return PApplet.min(list); // don't do that cause crash
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
	 * Next Gaussian randomize v 0.0.2
	 */
	/**
	 * return value from -1 to 1
	 * 
	 * @return float
	 */
	Random random = new Random();
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

}
