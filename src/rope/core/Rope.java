/**
 *   ___      ___   ____   _______
 *  | -  \   /   \  |    \ |  ___/
 *  | |/  | |   \ | | |\ | |  |__
 *  |    /  | | | | | |  / |  __/
 *  | |  \  \ \   / |  |/  |  |____
 *  |_| \_\  \___/  |_ |   |______/
 * 
 * collection of function can be use with out Processing.
 * 
 * 
 * WITHOUT PROCESSING ONLY JAVA
 * 
 * 
 * @author @knupel
 * @see https://github.com/knupel/Rope
 * 2014-2023
 * v 0.5.3
 * 
 */


package rope.core;

import java.util.ArrayList;
import java.util.List;

import rope.utils.R_Utils.Ru;

import rope.vector.bvec;
import rope.vector.bvec2;
import rope.vector.bvec3;
import rope.vector.bvec4;
import rope.vector.ivec2;
import rope.vector.ivec3;
import rope.vector.ivec4;
import rope.vector.vec;
import rope.vector.vec2;
import rope.vector.vec3;
import rope.vector.vec4;

import rope.mesh.R_Line2D;
import rope.mesh.R_Shape;

import processing.core.*;

public class Rope implements R_Constants, R_Constants_Colour {
	
	public Rope() {}

	public String get_renderer(final PGraphics graph) {
		try {
			if (Class.forName(JAVA2D).isInstance(graph)) return JAVA2D;
			if (Class.forName(P2D).isInstance(graph)) return P2D;
			if (Class.forName(P3D).isInstance(graph)) return P3D;
			if (Class.forName(PDF).isInstance(graph)) return PDF;
			if (Class.forName(DXF).isInstance(graph)) return DXF;
		}
	
		catch (ClassNotFoundException ex) {
		}
		return "Unknown";
	}


	public float [] getColorMode(PGraphics pg) {
		// see rope.R_Graphic.getColorMode(boolean print_info_is);
		return getColorMode(pg, false);
	}
	
	public float [] getColorMode(PGraphics pg, boolean print_info_is) {
		float colorMode = pg.colorMode ;
		float x = pg.colorModeX;
		float y = pg.colorModeY;
		float z = pg.colorModeZ;
		float a = pg.colorModeA;
		float array[] = {colorMode,x,y,z,a};
		if (print_info_is && pg.colorMode == HSB) {
			print_err("HSB",x,y,z,a);
		} else if(print_info_is && pg.colorMode == RGB) {
			print_err("RGB",x,y,z,a);
		}
		return array;
	}
	
	/////////////////////////////
	// DISTRIBUTION
	/////////////////////////////

	public float d_pow(float value, float threshold, float power) {
		return Ru.d_pow(value, threshold, power);
	}

	public float d_sqrt(float value, float threshold) {
		return Ru.d_sqrt(value, threshold);
	}

	public float d_cbrt(float value, float threshold) {
		return Ru.d_cbrt(value, threshold);
	}

	/**
	 * 
	 * @param value
	 * @param threshold
	 * @param ratio good value from 0 to 2
	 * @return
	 */
	public float d_sin(float value, float threshold, float ratio) {
		return Ru.d_sin(value, threshold, ratio);
	}

		/**
	 * 
	 * @param value
	 * @param threshold
	 * @param ratio good value from 0 to 2
	 * @return
	 */
	public float d_cos(float value, float threshold, float ratio) {
		return Ru.d_cos(value, threshold, ratio);
	}

	/**
	 * 
	 * @param value in the range of threshold
	 * @param variance usualy from 0 to 10 
	 * @param offset the value can be negative and she relative to the threshold
	 * @param threshold this value is used to calculate the normal value
	 * @return
	 */
	public float d_bell(float value, float threshold, float variance, float offset) {
		return Ru.d_normal(value, threshold, variance, offset);
	}

	public float d_normal(float value, float threshold, float variance, float offset) {
		return Ru.d_normal(value, threshold, variance, offset);
	}

	/**
	 * 
	 * @param value
	 * @param threshold
	 * @param variance value from 0.000001 to more, but the value between 0 to 1 is important. 1 is a average value.
	 * @return
	 */
	public float d_sigmoid(float value, float threshold, float variance) {
		return Ru.d_sigmoid(value, threshold, variance);
	}

	////////////////////////
	// OPERATION
	///////////////////////////
	
	/**
	 * each element add of each vector mult each one in the order
	 * @param a vector be added
	 * @param b vector added
	 * @return result of the operation
	 */
	public vec2 add(vec2 a, vec2 b) {
		return Ru.add(a,b);
	}

	public vec3 add(vec3 a, vec3 b) {
		return Ru.add(a,b);
	}

	public vec4 add(vec4 a, vec4 b) {  
		return Ru.add(a,b);
	}
	
	public vec2 add(vec2 a, float arg) {
	  return add(a, new vec2(arg,arg));
	}

	public vec3 add(vec3 a, float arg) {
	  return add(a,new vec3(arg,arg,arg));
	}

	public vec4 add(vec4 a, float arg) {  
	  return add(a, new vec4(arg,arg,arg,arg));
	}
	
	/**
	 * each element substract of each vector mult each one in the order
	 * @param a vector target
	 * @param b vector must be sub
	 * @return result of the operation
	 */
	public vec2 sub(vec2 a, vec2 b) {
		return Ru.sub(a, b);
	}

	public vec3 sub(vec3 a, vec3 b) {
		return Ru.sub(a,b);
	}

	public vec4 sub(vec4 a, vec4 b) {
		return Ru.sub(a,b);
	}
	
	public vec2 sub(vec2 a, float arg) {
	  return sub(a, new vec2(arg,arg));
	}

	public vec3 sub(vec3 a, float arg) {
	  return sub(a, new vec3(arg,arg,arg));
	}

	public vec4 sub(vec4 a, float arg) {  
	  return sub(a, new vec4(arg,arg,arg,arg));
	}

	/**
	 * each element multipry of each vector mult each one in the order
	 * @param a vector multiplicator
	 * @param b vector multiplicator
	 * @return result of the operation
	 */
	public vec2 mult(vec2 a, vec2 b) {
		return Ru.mult(a,b);
	}

	public vec3 mult(vec3 a, vec3 b) {
		return Ru.mult(a,b);
	}

	public vec4 mult(vec4 a, vec4 b) {
		return Ru.mult(a,b);
	}
	
	public vec2 mult(vec2 a, float arg) {
	  return mult(a, new vec2(arg,arg));
	}

	public vec3 mult(vec3 a, float arg) {
	  return mult(a, new vec3(arg,arg,arg));
	}

	public vec4 mult(vec4 a, float arg) {  
	  return mult(a, new vec4(arg,arg,arg,arg));
	}
	
	
	/**
	 * 
	 * @param a vector must be divide by b
	 * @param b vector must divide a
	 * @return result of the operation
	 */
	public vec2 div(vec2 a, vec2 b) {
		return Ru.div(a,b);
	}

	public vec3 div(vec3 a, vec3 b) {
		return Ru.div(a,b);
	}

	public vec4 div(vec4 a, vec4 b) {
		return Ru.div(a,b);
	}
	
	public vec2 div(vec2 a, float arg) {
	  return div(a, new vec2(arg,arg));
	}

	public vec3 div(vec3 a, float arg) {
	  return div(a, new vec3(arg,arg,arg));
	}

	public vec4 div(vec4 a, float arg) {  
	  return div(a, new vec4(arg,arg,arg,arg));
	}

	/**
	 * Cross product of vec3
	 * 
	 * @param v1 coordinate
	 * @param v2 coordinate
	 * @return result of the croos operation
	 */
	public vec3 cross(vec3 v1, vec3 v2) {
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
  * math:calculation
  * Constrains a value to not exceed a maximum and minimum value.
  * @param amt the value to constrain
  * @param low minimum limit
  * @param high maximum limit
  */
	public int constrain(int amt, int low, int high) {
    return (amt < low) ? low : ((amt > high) ? high : amt);
  }


	public float constrain(float amt, float low, float high) {
    return (amt < low) ? low : ((amt > high) ? high : amt);
  }
  
  
	/**
	 * map method
	 * 
	 * @param value value must be compute
	 * @param start1 min range value of the starting field
	 * @param stop1 max range value of the starting field
	 * @param start2 min range value of the final field
	 * @param stop2 max range value of the final field
	 * @return result of the scale map operation
	 */
	public float map(float value, float start1, float stop1, float start2, float stop2) {
		return Ru.map(value, start1, stop1, start2, stop2);
	}


	public vec2 map(vec2 value,float minIn, float maxIn, float minOut, float maxOut) {
		if(value != null) {
			float x = Ru.map(value.x(), minIn, maxIn, minOut, maxOut) ;
			float y = Ru.map(value.y(), minIn, maxIn, minOut, maxOut) ;
			return new vec2(x,y);
		} else return null;
	}
	
	public vec3 map(vec3 value,float minIn, float maxIn, float minOut, float maxOut) {
		if(value != null) {
			float x = Ru.map(value.x(), minIn, maxIn, minOut, maxOut) ;
			float y = Ru.map(value.y(), minIn, maxIn, minOut, maxOut) ;
			float z = Ru.map(value.z(), minIn, maxIn, minOut, maxOut) ;
			return new vec3(x,y,z);
		} else return null;
	}
	
	
	public vec4 map(vec4 value,float minIn, float maxIn, float minOut, float maxOut) {
		if(value != null) {
			float x = Ru.map(value.x(), minIn, maxIn, minOut, maxOut) ;
			float y = Ru.map(value.y(), minIn, maxIn, minOut, maxOut) ;
			float z = Ru.map(value.z(), minIn, maxIn, minOut, maxOut) ;
			float w = Ru.map(value.w(), minIn, maxIn, minOut, maxOut) ;
			return new vec4(x,y,z,w);
		} else return null;
	}
	
	
	
	/**
	 * MATH
	 * v 0.1.1
	 * */

	/**
	 * 
	 * @param x1 value x of the first point
	 * @param y1 value y of the first point
	 * @param x2 value x of the second point
	 * @param y2 value y of the second point
	 * @return float distance beween the two points
	 */
	public float dist(float x1, float y1, float x2, float y2) {
		return Ru.dist(x1, y1, x2, y2);
	}

	/**
	 * @param x1 value x of the first point
	 * @param y1 value y of the first point
	 * @param z1 value z of the first point
	 * @param x2 value x of the second point
	 * @param y2 value y of the second point
	 * @param z2 value z of the second point
	 * @return float distance beween the two points
	 */
	public float dist(float x1, float y1, float z1, float x2, float y2, float z2) {
		return Ru.dist(x1, y1, z1, x2, y2, z2);
	}

	/**
	 * @param a coordinate of the first point
	 * @param b coordinate of the second point
	 * @return float distance beween the two points
	 */
	public float dist(vec2 a, vec2 b) {
		return Ru.dist(a,b);
	}

	/**
	 * @param a coordinate of the first point
	 * @param b coordinate of the second point
	 * @return float distance beween the two points
	 */
	public float dist(vec3 a, vec3 b) {
		return Ru.dist(a,b);
	}

	/**
	 * @param a coordinate of the first point
	 * @param b coordinate of the second point
	 * @return float distance beween the two points
	 */
	public float dist(vec4 a, vec4 b) {
		return Ru.dist(a,b);
	}
	
	
	/**
	 * @deprecated use in_segment(vec2 start, vec2 end, vec2 point, float range) instead
	 */
	@Deprecated
	protected boolean is_on_line(vec2 start, vec2 end, vec2 point, float range) {
		return in_segment(start, end, point, range);
	}

	/**
	* @see <a href="https://forum.processing.org/two/discussion/90/point-and-line-intersection-detection">Processing discussion topic</a>
	* refactoring from Quark Algorithm
	 * 
	 * @param start
	 * @param end
	 * @param point
	 * @param range
	 * @return
	 */
	public boolean in_segment(vec2 start, vec2 end, vec2 point, float range) {
		return Ru.in_segment(start, end, point, range);
	}

	/**
	 * 
	 * @param line
	 * @param point
	 * @param marge
	 * @return
	 */
	public boolean in_segment(R_Line2D line, vec2 point, float marge) {
		return in_segment(line.a(), line.b(), point, marge);
	}



	/**
	 * Check if the three points is aligned
	 * @param a point must be checked
	 * @param b point must be checked
	 * @param c point must be checked
	 * @param marge pixel around the line to test is the points are aligned
	 * @return
	 */
	public boolean in_line(vec2 a, vec2 b, vec2 c, float marge) {
		if(in_segment(a, b, c, marge)) return true;
		if(in_segment(c, b, a, marge)) return true;
		if(in_segment(c, a, b, marge)) return true;	
		return false;
	}

	/**
	 * check if the point is aligned with the line
	 * @param line
	 * @param point
	 * @param marge
	 * @return
	 */
	public boolean in_line(R_Line2D line, vec2 point, float marge) {
		return in_line(line.a(), line.b(), point, marge);
	}



	/**
	* @see <a href="https://forum.processing.org/one/topic/how-do-i-find-if-a-point-is-inside-a-complex-polygon.html">Forum processing topic</a>
	* @see <a href="http://paulbourke.net/geometry/">Paul Bourke  topic</a>
	* thanks to Moggach and Paul Brook
	 * @param points list of coordinate of the shape
	 * @param pos coordinate of value must be tested
	 * @return true is the position is in the shape
	 */
	public boolean in_polygon(vec [] points, vec pos) {
		return Ru.in_polygon(points, pos);
	}

	public boolean in_polygon(R_Shape shape, vec pos) {
		return in_polygon(shape.get_points(), pos);
	}

	/**
	 * @param points cloud of points shape the polygon
	 * @param pos of the point must be detected
	 * @param marge distance of the point around the border
	 * @return -1 is out / 0 on border / 1 in polygon
	 */
	public byte in_polygon(vec [] points, vec pos, float marge) {
		return Ru.in_polygon(points, pos, marge);
	}

	public byte in_polygon(R_Shape shape, vec pos, float marge) {
		return in_polygon(shape.get_points(), pos, marge);
	}




	/**
	 * *** ACHTUNG ***
	 * It's not clear must find time to work on explanation of this function
	 * If I remember is to compare to vec but not sure...
	 * 
	 * @param pos ??? may be the angle
	 * @param range ??? may be be the range of the vec ????
	 * @param size ??? may be the distance to center ???
	 * @return
	 */
	public vec3 to_cartesian_3D(vec2 pos, vec2 range, float size) {
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
	 * @param latitude latitude in radiant
	 * @param longitude longitude in radiant
	 * @return the cartesian angle coordinate
	 */
	public vec3 to_cartesian_3D(float latitude, float longitude) {
		float radius_normal = 1;
		return to_cartesian_3D(latitude, longitude, radius_normal);
	}

	/**
	 * main method to_cartesian_3D
	 * @param latitude latitude in radiant
	 * @param longitude longitude in radiant
	 * @param radius distance to center
	 * @return the cartesian angle coordinate
	 */
	public vec3 to_cartesian_3D(float latitude, float longitude, float radius) {
		float theta = longitude % TAU;
		float phi = latitude % PI;

		float x = (float) (radius * Math.sin(theta) * Math.cos(phi));
		float y = (float) (radius * Math.sin(theta) * Math.sin(phi));
		float z = (float) (radius * Math.cos(theta));
		return new vec3(x, y, z);
	}
  
	/**
	 * *** ACHTUNG ***
	 * It's not clear must find time to work on explanation of this function
	 * If I remember is to compare to vec but not sure...
	 * 
	 * @param pos ??? may be the angle
	 * @param range ??? may be be the range of the first vec ????
	 * @param target_rad ??? may be be the range of the last vec ????
	 * @param distance distance to center
	 * @return the cartesian angle coordinate
	 */
	public vec2 to_cartesian_2D(float pos, vec2 range, vec2 target_rad, float distance) {
		float rotation_plan = map(pos, range.x, range.y, target_rad.x, target_rad.y);
		return to_cartesian_2D(rotation_plan, distance);
	}
  
	/**
	 * 
	 * @param angle radiant value
	 * @param radius distance to center
	 * @return the cartesian angle coordinate
	 */
	public vec2 to_cartesian_2D(float angle, float radius) {
		return to_cartesian_2D(angle).mult(radius);
	}

	/**
	 * main method to_cartesian_2D
	 * @param angle radiant value
	 * @return the cartesian angle coordinate
	 */
	public vec2 to_cartesian_2D(float angle) {
		float x = (float) Math.cos(angle);
		float y = (float) Math.sin(angle);
		return new vec2(x, y);
	}
  



	/**
	 * 
	 * @param v list coordinate to compute the barycenter
	 * @return coordinate of the barycenter
	 */
	public vec2 barycenter(vec2... v) {
		int div_num = v.length;
		vec2 sum = new vec2();
		for (int i = 0; i < div_num; i++) {
			sum.add(v[i]);
		}
		return sum.div(div_num);
	}
  
	/**
	 * 
	 * @param v list coordinate to compute the barycenter
	 * @return coordinate of the barycenter
	 */
	public vec3 barycenter(vec3... v) {
		int div_num = v.length;
		vec3 sum = new vec3();
		for (int i = 0; i < div_num; i++) {
			sum.add(v[i]);
		}
		return sum.div(div_num);
	}
  
	/**
	 * 
	 * @param vector array coordinates to calculate the barycenter
	 * @return vec4 result
	 */
	public vec4 barycenter(vec4... vector) {
		int div_num = vector.length;
		vec4 sum = new vec4();
		for (int i = 0; i < div_num; i++) {
			sum.add(vector[i]);
		}
		return sum.div(div_num);
	}
	
	



	/**
	 * Projection
	 * @param direction vec2 radiant direction
	 * @return coordinate of the point
	 */
	public vec2 projection(vec2 direction) {
	  return projection(direction, new vec2(), (float)1.) ;
	}
  /**
   * 
   * @param direction vec2 radiant direction
   * @param radius distance for the projection
   * @return coordinate of the point
   */
	public vec2 projection(vec2 direction, float radius) {
	  return projection(direction, new vec2(), radius) ;
	}
	
	/**
	 * 
	 * @param direction vec2 radiant direction
	 * @param origin position
	 * @param radius distance for the projection
	 * @return coordinate of the point
	 */
	public vec2 projection(vec2 direction, vec2 origin, float radius) {
	  vec2 ref = direction.copy() ;
	  vec2 p = ref.dir(origin) ;
	  p.mult(radius) ;
	  p.add(origin) ;
	  return p ;
	}
	
	/**
	 * polar projection 2D
	 * @param angle float radiant direction
	 * @return coordinate of the point
	 */
	public vec2 projection(float angle) {
	  return projection(angle, 1) ;
	}
	
	/**
	 * 
	 * @param angle float radiant direction
	 * @param radius distance for the projection
	 * @return coordinate of the point
	 */
	public vec2 projection(float angle, float radius) {
	  return new vec2((float)Math.cos(angle) *radius, (float)Math.sin(angle) *radius) ;
	}
	/**
	 * Cartesian projection 3D
	 * @param direction vec2 radiant direction
	 * @return coordinate of the point
	 */
	public vec3 projection(vec3 direction) {
	  return projection(direction, new vec3(), (float)1.) ;
	}
  
	/**
	 * 
	 * @param direction vec2 radiant direction
	 * @param radius distance for the projection
	 * @return coordinate of the point
	 */
	public vec3 projection(vec3 direction, float radius) {
	  return projection(direction, new vec3(), radius) ;
	}
  
	/**
	 * 
	 * @param direction vec2 radiant direction
	 * @param origin position
	 * @param radius distance for the projection
	 * @return coordinate of the point
	 */
	public vec3 projection(vec3 direction, vec3 origin, float radius) {
	  vec3 ref = direction.copy() ;
	  vec3 p = ref.dir(origin) ;
	  p.mult(radius) ;
	  p.add(origin) ;
	  return p ;
	}
	
	
	/**
	 * 
	 * @param high define value max for the random
	 * @return random number, this method is a copy of Processing one
	 */
	public float random(float high) {	
		return Ru.random(high);
	}

	/**
	 * 
	 * @param low define value min for the random
	 * @param high define value max for the random
	 * @return random number, this method is a copy of Processing one
	 */
	public float random(float low, float high) {
		return Ru.random(low, high);
	}


	/**
	 * 
	 * @param n the num of operation must iterate each operation is mult by the previous result
	 * @return random value
	 */
	public float random_next_gaussian(int n) {
		return random_next_gaussian(1, n);
	}
  
	/**
	 * 
	 * @param range define value max for the random
	 * @return random value
	 */
	public float random_next_gaussian(float range) {
		return random_next_gaussian(range, 1);
	}
	
	/**
	 * 
	 * @param range represente the max value possible from 0 to this value.
	 * @param n the num of operation must iterate each operation is mult by the previous result
	 * @return random value
	 */
	public float random_next_gaussian(float range, int n) {
		return Ru.random_next_gaussian(range, n);
	}


	//////////////////////////////////
	// ARRAY UTILS
	///////////////////////////////
	public <T> T [] reverse(T [] arr) {
		return Ru.reverse(arr);
	}

	public boolean [] reverse(boolean [] arr) {
		return Ru.reverse(arr);
	}

	public byte [] reverse(byte [] arr) {
		return Ru.reverse(arr);
	}

	public char [] reverse(char [] arr) {
		return Ru.reverse(arr);
	}

	public int [] reverse(int [] arr) {
		return Ru.reverse(arr);
	}

	public long [] reverse(long [] arr) {
		return Ru.reverse(arr);
	}

	public float [] reverse(float [] arr) {
		return Ru.reverse(arr);
	}

	public double [] reverse(double [] arr) {
		return Ru.reverse(arr);
	}

	public String [] reverse(String [] arr) {
		return Ru.reverse(arr);
	}







	////////////////////////////////
	// MIN / MAX
	/////////////////////////////

	
	/**
	 * 
	 * @param list list of arguments must be sorted
	 * @return the max value of the list
	 */
	public float max(float... list) {
		return Ru.max(list);
	}

	public int max(int... list) {
		return Ru.max(list);
	}
	public vec2 max(vec2 a, vec2 b) {
  	return Ru.max(a,b);
	}

	public vec3 max(vec3 a, vec3 b) {
  	return Ru.max(a,b);
	}

	public vec4 max(vec4 a, vec4 b) {
  	return Ru.max(a,b);
	}

	public ivec2 max(ivec2 a, ivec2 b) {
  	return Ru.max(a,b);
	}

	public ivec3 max(ivec3 a, ivec3 b) {
  	return Ru.max(a,b);
	}

	public ivec4 max(ivec4 a, ivec4 b) {
  	return Ru.max(a,b);
	}






	/**
	 * 
	 * @param list list of arguments must be sorted
	 * @return the min value of the list
	 */
	public float min(float... list) {
		return Ru.min(list);
	}
	public int min(int... list) {
		return Ru.min(list);
	}
	public vec2 min(vec2 a, vec2 b) {
		return Ru.min(a,b);
	}

	public vec3 min(vec3 a, vec3 b) {
		return Ru.min(a,b);
	}

	public vec4 min(vec4 a, vec4 b) {
		return Ru.min(a,b);
	}

	public ivec2 min(ivec2 a, ivec2 b) {
		return Ru.min(a,b);
	}

	public ivec3 min(ivec3 a, ivec3 b) {
		return Ru.min(a,b);
	}

	public ivec4 min(ivec4 a, ivec4 b) {
		return Ru.min(a,b);
	}





/**
 * 
 * @param arg passed to be transform
 * @return absolute value
 */
public float abs(float arg) {
		return Math.abs(arg);
	}

	public int abs(int arg) {
		return Math.abs(arg);
	}

	public vec2 abs(vec2 arg) {
		return new vec2(Math.abs(arg.x()),Math.abs(arg.y()));
	}

	public vec3 abs(vec3 arg) {
		return new vec3(Math.abs(arg.x()),Math.abs(arg.y()),Math.abs(arg.z()));
	}

	public vec4 abs(vec4 arg) {
		return new vec4(Math.abs(arg.x()),Math.abs(arg.y()),Math.abs(arg.z()),Math.abs(arg.w()));
	}

	public ivec2 abs(ivec2 arg) {
		return new ivec2(Math.abs(arg.x()),Math.abs(arg.y()));
	}

	public ivec3 abs(ivec3 arg) {
		return new ivec3(Math.abs(arg.x()),Math.abs(arg.y()),Math.abs(arg.z()));
	}

	public ivec4 abs(ivec4 arg) {
		return new ivec4(Math.abs(arg.x()),Math.abs(arg.y()),Math.abs(arg.z()),Math.abs(arg.w()));
	}


	/**
	 * 
	 * @param value must be transform
	 * @return return int rounded to down
	 */
	public int floor(float value) {
		return (int)Math.floor(value);
	}
	
	public vec2 floor(vec2 arg) {
	  return new vec2(floor(arg.x()),floor(arg.y()));
	}

	public vec3 floor(vec3 arg) {
	  return new vec3(floor(arg.x()),floor(arg.y()),floor(arg.z()));
	}

	public vec4 floor(vec4 arg) {
	  return new vec4(floor(arg.x()),floor(arg.y()),floor(arg.z()),floor(arg.w()));
	}

	/**
	 * 
	 * @param value must be transform
	 * @return int rounded to up
	 */
	public int ceil(float value) {
		return (int)Math.ceil(value);
	}
	
	public vec2 ceil(vec2 arg) {
	  return new vec2(ceil(arg.x()),ceil(arg.y()));
	}

	public vec3 ceil(vec3 arg) {
	  return new vec3(ceil(arg.x()),ceil(arg.y()),ceil(arg.z()));
	}

	public vec4 ceil(vec4 arg) {
	  return new vec4(ceil(arg.x()),ceil(arg.y()),ceil(arg.z()),ceil(arg.w()));
	}

	/**
	 * 
	 * @param value must be transform
	 * @return value average rounded value to int.
	 */
	public int round(float value) {
		return Math.round(value);
	}
	
	public vec2 round(vec2 arg) {
	  return new vec2(round(arg.x()),round(arg.y()));
	}

	public vec3 round(vec3 arg) {
	  return new vec3(round(arg.x()),round(arg.y()),round(arg.z()));
	}

	public vec4 round(vec4 arg) {
	  return new vec4(round(arg.x()),round(arg.y()),round(arg.z()),round(arg.w()));
	}

	/**
	 * 
	 * @param value must be squared
	 * @return the result of the operation
	 */
	public float sq(float value) {
		return value * value;
	}
	
	/**
	 * 
	 * @param value value to compute the squareroot
	 * @return the result of the operation
	 */
	public float sqrt(float value) {
		return (float)Math.sqrt(value);
	}

	/**
	 * 
	 * @param arg value must be transform by the exp
	 * @param exp it's the exponent value to powered
	 * @return value powered by n
	 */
	public float pow(float arg, float exp) {
    return (float)Math.pow(arg, exp);
  }

	/**
	 * 
	 * @param value value to compute
	 * @return the result of the operation
	 */
	public float atan(float value) {
		return (float)Math.atan(value);
	}

	/**
	 * 
	 * @param value to compute
	 * @return the result of the operation
	 */
	public float cos(float value) {
		return (float)Math.cos(value);
	}

	/**
	 * 
	 * @param value to compute
	 * @return the result of the operation
	 */
	public float sin(float value) {
		return (float)Math.sin(value);
	}
	
	
	
	
	
	
	
	
	/*
	 * GLSL METHOD and derivative method on a same spirit !
	 *
	 */

	// MIX
	/**
	 * @see <a href="https://www.khronos.org/registry/OpenGL/specs/gl/">https://www.khronos.org/registry/OpenGL/specs/gl</a>
	 * @param x elem to mix
	 * @param y elem to mix
	 * @param a mixer element
	 * @return the mix result
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

	// FRACT
	/**
	 * @see <a href="https://www.khronos.org/registry/OpenGL/specs/gl/">https://www.khronos.org/registry/OpenGL/specs/gl</a>
	 * @param x value to fract
	 * @return fract result
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

	// SIGN
	/**
	 * @see <a href="https://www.khronos.org/registry/OpenGL/specs/gl/">https://www.khronos.org/registry/OpenGL/specs/gl</a>
	 * @param x value who find sign
	 * @return value -1, 0 or 1
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


	// STEP
	/**
	 * @see <a href="https://www.khronos.org/registry/OpenGL/specs/gl/">https://www.khronos.org/registry/OpenGL/specs/gl</a>
	 * @param x value to smooth
	 * @param edge the smooth edge 
	 * @return the result of the operation
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


	// SMOOTH STEP
	/**
	* @see <a href="https://www.khronos.org/registry/OpenGL/specs/gl/">https://www.khronos.org/registry/OpenGL/specs/gl</a>
	 * @param x value to smooth
	 * @param edge0 the smooth first edge 
	 * @param edge1 the smooth second edge 
	 * @return the result of the operation
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



	// MOD
	/**
	* @see <a href="https://www.khronos.org/registry/OpenGL/specs/gl/">https://www.khronos.org/registry/OpenGL/specs/gl</a>
	 * @param x value to mod
	 * @param y value to mod
	 * @return result of operation
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

	// CLAMP
	/**
	* @see <a href="https://www.khronos.org/registry/OpenGL/specs/gl/">https://www.khronos.org/registry/OpenGL/specs/gl</a>
	 * @param x value to clamp
	 * @param min the min value available
	 * @param max the max value available
	 * @return reslut of operation
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



	// COMPARE

	public boolean compare(float x, float y, float area) {
		if (x >= y -area && x <= y +area) return true;
		return false;
	}

	public boolean compare(vec2 x, vec2 y, vec2 area) {
		return x.compare(y, area);
	}

	public boolean compare(vec3 x, vec3 y, vec3 area) {
		return x.compare(y, area);
	}

	public boolean compare(vec4 x, vec4 y, vec4 area) {
		return x.compare(y, area);
	}

	public boolean compare(int x, int y, int area) {
		if (x >= y -area && x <= y +area) return true;
		return false;
	}

	public boolean compare(ivec2 x, ivec2 y, ivec2 area) {
		return x.compare(y, area);
	}

	public boolean compare(ivec3 x, ivec3 y, ivec3 area) {
		return x.compare(y, area);
	}

	public boolean compare(ivec4 x, ivec4 y, ivec4 area) {
		return x.compare(y, area);
	}



	// EQUAL
	/**
	* @see <a href="https://www.khronos.org/registry/OpenGL/specs/gl/">https://www.khronos.org/registry/OpenGL/specs/gl</a>
	* @param x float value to test
	* @param y float value to test
	* @return true if x equal to y
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




	// LESS THAN
	/**
	* @see <a href="https://www.khronos.org/registry/OpenGL/specs/gl/">https://www.khronos.org/registry/OpenGL/specs/gl</a>
	* @param x float value to test
	* @param y float value to test
	* @return true if x inferior to y
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




	// GREATER THAN
	/**
	* <a href="https://www.khronos.org/registry/OpenGL/specs/gl/">https://www.khronos.org/registry/OpenGL/specs/gl</a>
	* @param x float value to test
	* @param y float value to test
	* @return true if x superior to y
	 */
	public boolean greaterThan(float x, float y) {
		return x>y?true:false;
	}

	public boolean greaterThan(int x, int y) {
		return greaterThan((float)x,(float)y);
	}

	// with vec
	
	public bvec2 greaterThan(vec2 x, vec2 y) {
		print_err("x",x,"y",y);
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

	// GREATER THAN EQUAL
	/**
	* @param x float value to test
	* @param y float value to test
	* @see <a href="https://www.khronos.org/registry/OpenGL/specs/gl/">https://www.khronos.org/registry/OpenGL/specs/gl</a>
	* @return true if x superior or equal to y
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


	// LESS THAN EQUAL
	/**
	* @param x float value to test
	* @param y float value to test
	* @see <a href="https://www.khronos.org/registry/OpenGL/specs/gl/">https://www.khronos.org/registry/OpenGL/specs/gl</a>
	* @return true if x inferior or equal to y
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


	// ALL
	/**
	 * @param b bvec value to test
	* @see <a href="https://www.khronos.org/registry/OpenGL/specs/gl/">https://www.khronos.org/registry/OpenGL/specs/gl</a>
	* @return true only if all components of x are true.
	*/
	public boolean all(bvec b) {
		if(b != null) {
			return all(b.array());
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

	// ANY
	/**
	* @param b bvec value to test
	* <a href="https://www.khronos.org/registry/OpenGL/specs/gl/">https://www.khronos.org/registry/OpenGL/specs/gl</a>
	* @return true if any component of x is true. 
	*/
	public boolean any(bvec b) {
		if(b != null) {
			return any(b.array());
		} else {
			System.err.println("method any() return false because argument bvec5 b is null");
			return false;
		}
	}
	
	/**
	 * 
	 * @param list boolean list value to test
	 * @return return true if any element of the list is true
	 * @return true if any component of x is true. 
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

		// ONLY
	/**
	 * only is an inspiration of opengl function, is not a part of it
	* <a href="https://www.khronos.org/registry/OpenGL/specs/gl/">https://www.khronos.org/registry/OpenGL/specs/gl</a>
	* @return true if only one component of x is true. 
	*/
	/**
	 * @param b bvec value to test
	 * @return true is only one elements of the list is true
	 */
	public boolean only(bvec b) {
		if(b != null) {
			return only(b.array());
		} else {
			System.err.println("method any() return false because argument bvec6 b is null");
			return false;
		}
	}


	public boolean only(boolean ...list) {
		int count = 0;
		for(int i = 0 ; i < list.length ; i++) {
			if(list[i] == true) {
				count++;
			}
		}
		if(count == 1)
			return true;
		return false;
	}
	
	
	
	
	
	/**
	 * 
	 * @param x coordinate x 
	 * @param y coordinate y 
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
	 * @param x value to work
	 * @param num after coma to display
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

	
	public String hex(byte value) {
    return hex(value, 2);
  }

	public String hex(char value) {
    return hex(value, 4);
  }

	public String hex(int value) {
    return hex(value, 8);
  }
/**
 * @param value value to convert
 * @param digits the number of digits (maximum 8)
 * @return String hexadecimal value
 */
	public String hex(int value, int digits) {
    String stuff = Integer.toHexString(value).toUpperCase();
    if (digits > 8) {
      digits = 8;
    }

    int length = stuff.length();
    if (length > digits) {
      return stuff.substring(length - digits);

    } else if (length < digits) {
      return "00000000".substring(8 - (digits-length)) + stuff;
    }
    return stuff;
  }
	 /**
  *
  * Converts a Stringrepresentation of a hexadecimal number to its
  * equivalent integer value.
  * @param value value to convert
  * @return unhexadecimal int value
	*/
	public int unhex(String value) {
    // has to parse as a Long so that it'll work for numbers bigger than 2^31
    return (int) (Long.parseLong(value, 16));
  }
	
	
	public String binary(byte value) {
    return binary(value, 8);
  }

	public String binary(char value) {
    return binary(value, 16);
  }

  public String binary(int value) {
    return binary(value, 32);
  }

  /*
   * Returns a String that contains the binary value of an int.
   * The digits parameter determines how many digits will be used.
   */

 /**
  *
  * Converts an int, byte, char, or color to a
  * String containing the equivalent binary notation. For example, the
  * color value produced by color(0, 102, 153, 255) will convert
  * to the String value "11111111000000000110011010011001". This
  * function can help make your geeky debugging sessions much happier.
  * Note that the maximum number of digits is 32, because an int value
  * can only represent up to 32 bits. Specifying more than 32 digits will have
  * no effect.
  *.
  * @param value value to convert
  * @param digits number of digits to return
  * @return String binary
  */
  public String binary(int value, int digits) {
    String stuff = Integer.toBinaryString(value);
    if (digits > 32) {
      digits = 32;
    }

    int length = stuff.length();
    if (length > digits) {
      return stuff.substring(length - digits);

    } else if (length < digits) {
      int offset = 32 - (digits-length);
      return "00000000000000000000000000000000".substring(offset) + stuff;
    }
    return stuff;
  }
  
  public int unbinary(String value) {
    return Integer.parseInt(value, 2);
  }

	/**
	 * 
	 * @param value
	 * @param delim
	 * @return
	 */
	public String[] split(String value, char delim) {
    if (value == null) return null;

    char[] chars = value.toCharArray();
    int split_count = 0; //1;
    for (char ch : chars) {
      if (ch == delim) split_count++;
    }

    if (split_count == 0) {
      String[] splits = new String[1];
      splits[0] = value;
      return splits;
    }
    String[] splits = new String[split_count + 1];
    int split_index = 0;
    int start_index = 0;
    for (int i = 0; i < chars.length; i++) {
      if (chars[i] == delim) {
        splits[split_index++] =
          new String(chars, start_index, i -start_index);
        start_index = i + 1;
      }
    }
		splits[split_index] = new String(chars, start_index, chars.length -start_index);

    return splits;
  }

	/**
	 * 
	 * @param value is the sentence must be spited
	 * @param delim is a separator
	 * @return array String of the String argument sentence
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
	public void print_out(Object... obj) {
		System.out.println(write_message(obj));
		System.out.flush();
	}
	
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

	public void print_array(Object what) {
    if (what == null) {
      // special case since this does fugly things on > 1.1
      System.out.println("null");

    } else {
      String name = what.getClass().getName();
      if (name.charAt(0) == '[') {
        switch (name.charAt(1)) {
          case '[' :
            // don't even mess with multi-dimensional arrays (case '[')
            // or anything else that's not int, float, boolean, char
            System.out.println(what); 
						break;
          case 'L' :
            // print a 1D array of objects as individual elements
            Object[] poo = (Object[]) what;
            for (int i = 0; i < poo.length; i++) {
              if (poo[i] instanceof String) {
                System.out.println("[" + i + "] \"" + poo[i] + "\"");
              } else {
                System.out.println("[" + i + "] " + poo[i]);
              }
            }
						break;
          case 'Z' :  // boolean
            boolean[] zz = (boolean[]) what;
            for (int i = 0; i < zz.length; i++) {
              System.out.println("[" + i + "] " + zz[i]);
            }
          	break;
          case 'B' :  // byte
            byte[] bb = (byte[]) what;
            for (int i = 0; i < bb.length; i++) {
              System.out.println("[" + i + "] " + bb[i]);
            }
          	break;
          case 'C' :  // char
            char[] cc = (char[]) what;
            for (int i = 0; i < cc.length; i++) {
              System.out.println("[" + i + "] '" + cc[i] + "'");
            }
         		break;
          case 'I' :  // int
            int[] ii = (int[]) what;
            for (int i = 0; i < ii.length; i++) {
              System.out.println("[" + i + "] " + ii[i]);
            }
          	break;
          case 'J' :  // int
            long[] jj = (long[]) what;
            for (int i = 0; i < jj.length; i++) {
              System.out.println("[" + i + "] " + jj[i]);
            }
          	break;
          case 'F' :  // float
            float[] ff = (float[]) what;
            for (int i = 0; i < ff.length; i++) {
              System.out.println("[" + i + "] " + ff[i]);
            }
          	break;
          case 'D' : // double
            double[] dd = (double[]) what;
            for (int i = 0; i < dd.length; i++) {
              System.out.println("[" + i + "] " + dd[i]);
            }
          break;
          default :
						System.out.println(what);
						break;
        }
      } else {  // not an array
        System.out.println(what);
      }
    }
    System.out.flush();
  }
	
	
	/**
	* 
	* @return the current os
	*/
	public String get_os() {
		return System.getProperty("os.name").toLowerCase();
	}

	/**
	 * 
	 * @return the current os family
	 */
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

	/**
	 * 
	 * @param filename check the last part of String path to return the extension if there is one
	 * @return the extension of the file
	 */
	public String extension(String filename) {
		if(filename != null) {
			filename = filename.toLowerCase();
			if(filename.contains(".")) {
				return filename.substring(filename.lastIndexOf(".") + 1, filename.length());
			} else {
				return null;
			} 
		} else {
			return null;
		}
	}
	
	/**
	 * 
	 * @param filename check the last part of String path return true at the first extension who match
	 * @param extension list of extension must be check;
	 * @return
	 */
	public boolean extension_is(String filename, String... extension) {
		boolean is = false;
		if(extension.length >= 1) {
			String extension_to_compare = extension(filename.toLowerCase());
			if(extension_to_compare != null) {
				for(int i = 0 ; i < extension.length ; i++) {
					if(extension_to_compare.equals(extension[i].toLowerCase())) {
						is = true;
						break;
					} else {
						is = false;
					}
				}
			} else {
				print_err("method extension_is(): [",filename.toLowerCase(),"] this path don't have any extension");
			}
		} else {
			print_err("method extension_is() need almost two components, the first is the path and the next is extension");
		}
		return is;
	}
	
}
