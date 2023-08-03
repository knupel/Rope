package rope.utils;

import java.util.Arrays;

/**
 * Rope Static Utils
 * v 0.4.0
 * 2019-2023
 */

import java.util.Random;

import rope.vector.ivec2;
import rope.vector.ivec3;
import rope.vector.ivec4;
import rope.vector.vec;
import rope.vector.vec2;
import rope.vector.vec3;
import rope.vector.vec4;

public class R_Utils {
	public static class Ru {


		/////////////////////////////
		// DISTRIBUTION
		// where d is for distribution
		/////////////////////////////

		public static float d_pow(float value, float threshold, float power) {
			return (float)Math.pow(value, power) / (float)Math.pow(threshold, power);
		}

		public static float d_sqrt(float value, float threshold) {
			double ret = Math.sqrt(value) / Math.sqrt(threshold);
			return (float)ret;
		}

		public static float d_cbrt(float value, float threshold) {
			double ret = Math.cbrt(value) / Math.cbrt(threshold);
			return (float)ret;
		}

		public static float d_normal(float value,  float threshold, float variance, float offset) {
			float range = 5.0f; // this range is link to exponential exp() ?
			offset *= 0.02f;
			float mx = map(value, 0, threshold, -range, range);
			double sigma = Math.sqrt(variance);
			double mu = offset;
			double a = 1 / (sigma*(Math.sqrt(2*Math.PI)));
			double exp = (-1 * Math.pow((mx - mu),2)) / (2 * Math.pow(sigma,2));
			double ret = a * Math.exp(exp);
			return (float)ret;
		}

		public static float d_sin(float value, float threshold, float ratio) {
			value /= threshold;
			return map((float)Math.sin(value / ratio * 3 * Math.PI), -1, 1, 0, 1); 
		}

		public static float d_cos(float value, float threshold, float ratio) {
			value /= threshold;
			return map((float)Math.cos(value / ratio * 3 * Math.PI), -1, 1, 0, 1); 
		}


		public static float d_sigmoid(float value, float threshold, float variance) {
			float range = 5.0f; // this range is ling to exponential exp() ?
			value = map(value, 0,threshold, -range, range);
			double ret =  variance / (variance + Math.exp(-value));
			return (float)ret;
		}
		///////////////////////////////
		// DETECTION
		///////////////////////////
		/**
		 * @param points cloud of points shape the polygon
		 * @param pos of the point must be detected
		 * @param marge distance of the point around the border
		 * @return -1 is out / 0 on border / 1 in polygon
		 */
		public static byte in_polygon(vec [] points, vec pos, float marge) {
			// -1 out of the polygon
			// 0 is on the border
			// 1 is fully inside
			int sides = points.length;
			boolean polygon_is = in_polygon(points, pos);
			boolean border_is = false;
			// check the border
			for(int i = 1; i < sides ; i++) {
				vec2 a = points[i].xy();
				vec2 b = points[i-1].xy();
				if(in_segment(a,b, pos.xy(), marge)) {
					border_is = true;
				}
			}
			// to close the segment
			vec2 a = points[0].xy();
			vec2 b = points[sides -1].xy();
			if(in_segment(a,b, pos.xy(), marge)) {
				border_is = true;
			}
		
			if(!polygon_is && !border_is) return -1;
			if(border_is) return 0;
			return 1;
		}

		public static boolean in_polygon(vec [] points, vec pos) {
			int i, j;
			boolean is = false;
			for(i = 0, j =  points.length - 1 ; i <  points.length ; j = i++) {
				vec a = points[i];
				vec b = points[j];
				if (( ((a.y() <= pos.y()) && (pos.y() < b.y())) || ((b.y() <= pos.y()) && (pos.y() < a.y()))) &&
								(pos.x() < (b.x() - a.x()) * (pos.y() - a.y()) / (b.y() - a.y()) + a.x())) {
					is = !is;
				}
			}
			return is;
		}


		public static boolean in_segment(vec2 start, vec2 end, vec2 point, float range) {
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

		///////////////////////////
		// DISCTANCE
		/////////////////////////////
		/**
		 * 
		 * @param x1 value x of the first point
		 * @param y1 value y of the first point
		 * @param x2 value x of the second point
		 * @param y2 value y of the second point
		 * @return float distance beween the two points
		 */
		public static float dist(float x1, float y1, float x2, float y2) {
			float dx = x1 - x2;
			float dy = y1 - y2;
			return (float) Math.sqrt(dx*dx + dy*dy);
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
		public static float dist(float x1, float y1, float z1, float x2, float y2, float z2) {
			float dx = x1 - x2;
			float dy = y1 - y2;
			float dz = z1 - z2;
			return (float) Math.sqrt(dx*dx + dy*dy + dz*dz);
		}

		/**
		 * @param a coordinate of the first point
		 * @param b coordinate of the second point
		 * @return float distance beween the two points
		 */
		public static float dist(vec2 a, vec2 b) {
			if(a != null && b != null) {
				float dx = a.x() - b.x();
				float dy = a.y() - b.y();
				return (float) Math.sqrt(dx*dx + dy*dy);
			} else return Float.NaN ;	
		}

		/**
		 * @param a coordinate of the first point
		 * @param b coordinate of the second point
		 * @return float distance beween the two points
		 */
		public static float dist(vec3 a, vec3 b) {
			if(a != null && b != null) {
				float dx = a.x() - b.x();
				float dy = a.y() - b.y();
				float dz = a.z() - b.z();
				return (float) Math.sqrt(dx*dx + dy*dy + dz*dz);
			} else return Float.NaN ;
		}

		/**
		 * @param a coordinate of the first point
		 * @param b coordinate of the second point
		 * @return float distance beween the two points
		 */
		public static float dist(vec4 a, vec4 b) {
			if(a != null && b != null) {
				float dx = a.x() - b.x();
				float dy = a.y() - b.y();
				float dz = a.z() - b.z();
				float dw = a.w() - b.w();
				return (float) Math.sqrt(dx*dx + dy*dy + dz*dz + dw*dw);
			} else return Float.NaN ;
		}







		//////////////////////////////////
		// OPERATION
		///////////////////////////

		// SUB
		//////////////////////

			/**
		 * each element add of each vector mult each one in the order
		 * @param a vector be added
		 * @param b vector added
		 * @return result of the operation
		 */
		public static vec2 add(vec2 a, vec2 b) {
			if(a == null || b == null) {
				return null ;
			} else {
				float x = a.x() + b.x();
				float y = a.y() + b.y();
				return new vec2(x,y);
			}
		}

		public static vec3 add(vec3 a, vec3 b) {
			if(a == null || b == null) {
				return null ;
			} else {
				float x = a.x() + b.x();
				float y = a.y() + b.y();
				float z = a.z() + b.z();
				return new vec3(x,y,z);
			}
		}

		public static vec4 add(vec4 a, vec4 b) {  
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


			/**
		 * each element substract of each vector mult each one in the order
		 * @param a vector target
		 * @param b vector must be sub
		 * @return result of the operation
		 */
		public static vec2 sub(vec2 a, vec2 b) {
			if (a == null || b == null) {
				return null;
			} else {
				float x = a.x - b.x;
				float y = a.y - b.y;
				return new vec2(x, y);
			}
		}

		public static vec3 sub(vec3 a, vec3 b) {
			if (a == null || b == null) {
				return null;
			} else {
				float x = a.x - b.x;
				float y = a.y - b.y;
				float z = a.z - b.z;
				return new vec3(x, y, z);
			}
		}

		public static vec4 sub(vec4 a, vec4 b) {
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

		// MULT
		//////////

		public static vec2 mult(vec2 a, vec2 b) {
			if(a == null || b == null) {
				return null ;
			} else {
				float x = a.x() * b.x();
				float y = a.y() * b.y();
				return new vec2(x,y);
			}
		}
	
		public static vec3 mult(vec3 a, vec3 b) {
			if(a == null || b == null) {
				return null ;
			} else {
				float x = a.x() * b.x();
				float y = a.y() * b.y();
				float z = a.z() * b.z();
				return new vec3(x,y,z);
			}
		}
	
		public static vec4 mult(vec4 a, vec4 b) {
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

		// DIV
		//////////////////
			/**
	 * 
	 * @param a vector must be divide by b
	 * @param b vector must divide a
	 * @return result of the operation
	 */
	public static vec2 div(vec2 a, vec2 b) {
	  if(a == null || b == null) {
	    return null;
	  } else {
	    float x = a.x() /b.x();
	    float y = a.y() /b.y();
	    return new vec2(x,y);
	  }
	}

	public static vec3 div(vec3 a, vec3 b) {
	  if(a == null || b == null) {
	    return null;
	  } else {
	    float x = a.x() /b.x();
	    float y = a.y() /b.y();
	    float z = a.z() /b.z();
	    return new vec3(x,y,z);
	  }
	}

	public static vec4 div(vec4 a, vec4 b) {
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

		/////////////////////////
		// MAP
		//////////////////////////
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
		public static float map(float value, float start1, float stop1, float start2, float stop2) {
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

		//////////////////////////
		// RANDOM
		//////////////////////////

		/**
		 * 
		 * @param high
		 * @return random number, this method is a copy of Processing one
		 */
		private static Random internalRandom;
		public static float random(float high) {
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
		public static float random(float low, float high) {
			// System.err.print("je suis ici");
			if (low >= high)
				return low;
			float diff = high - low;
			float value = 0;
			// because of rounding error, can't just add low, otherwise it may hit high
			// https://github.com/processing/processing/issues/4551
			do {
				value = random(diff) + low;
			} while (value == high);
			// System.err.print("je suis là");
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
		private static Random random = new Random();
		public float random_next_gaussian() {
			return random_next_gaussian(1, 1);
		}
		
		/**
		 * 
		 * @param n
		 * @return
		 */
		public static float random_next_gaussian(int n) {
			return random_next_gaussian(1, n);
		}
		
		/**
		 * 
		 * @param range
		 * @return
		 */
		public static float random_next_gaussian(float range) {
			return random_next_gaussian(range, 1);
		}
		
		/**
		 * 
		 * @param range
		 * @param n
		 * @return
		 */
		public static float random_next_gaussian(float range, int n) {
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




		//////////////////////////////////
		// ARRAY UTILS
		///////////////////////////////


		/**
		 * 
		 * @param arr list of any type elements
		 * @return a reverse a copy list of elements
		 */
		public static <T> T [] reverse_copy(T [] arr) {
			int len = arr.length;
			T[] arr_buf = Arrays.copyOf(arr, len);
			for(int i = 0 ; i < arr_buf.length / 2; i++) {
				T buf = arr_buf[i];
				arr_buf[i] = arr_buf[arr_buf.length - i - 1];
				arr_buf[arr_buf.length - i - 1] = buf;
			}
			return arr_buf;
		}

		public static boolean [] reverse_copy(boolean [] arr) {
			int len = arr.length;
			boolean[] arr_buf = Arrays.copyOf(arr, len);
			// System.arraycopy(arr, 0, arr_buf, 0, len);
			for(int i = 0 ; i < arr_buf.length / 2; i++) {
				boolean buf = arr_buf[i];
				arr_buf[i] = arr_buf[arr_buf.length - i - 1];
				arr_buf[arr_buf.length - i - 1] = buf;
			}
			return arr_buf;
		}


		public static byte [] reverse_copy(byte [] arr) {
			int len = arr.length;
			byte[] arr_buf = Arrays.copyOf(arr, len);
			for(int i = 0 ; i < arr_buf.length / 2; i++) {
				byte buf = arr_buf[i];
				arr_buf[i] = arr_buf[arr_buf.length - i - 1];
				arr_buf[arr_buf.length - i - 1] = buf;
			}
			return arr_buf;
		}

		public static char [] reverse_copy(char [] arr) {
			int len = arr.length;
			char[] arr_buf = Arrays.copyOf(arr, len);
			for(int i = 0 ; i < arr_buf.length / 2; i++) {
				char buf = arr_buf[i];
				arr_buf[i] = arr_buf[arr_buf.length - i - 1];
				arr_buf[arr_buf.length - i - 1] = buf;
			}
			return arr_buf;
		}

		public static int [] reverse_copy(int [] arr) {
			int len = arr.length;
			int[] arr_buf = Arrays.copyOf(arr, len);
			for(int i = 0 ; i < arr_buf.length / 2; i++) {
				int buf = arr_buf[i];
				arr_buf[i] = arr_buf[arr_buf.length - i - 1];
				arr_buf[arr_buf.length - i - 1] = buf;
			}
			return arr_buf;
		}

		public static long [] reverse_copy(long [] arr) {
			int len = arr.length;
			long[] arr_buf = Arrays.copyOf(arr, len);
			for(int i = 0 ; i < arr_buf.length / 2; i++) {
				long buf = arr_buf[i];
				arr[i] = arr_buf[arr_buf.length - i - 1];
				arr_buf[arr_buf.length - i - 1] = buf;
			}
			return arr_buf;
		}

		public static float [] reverse_copy(float [] arr) {
			int len = arr.length;
			float[] arr_buf = Arrays.copyOf(arr, len);
			for(int i = 0 ; i < arr.length / 2; i++) {
				float buf = arr_buf[i];
				arr_buf[i] = arr_buf[arr_buf.length - i - 1];
				arr_buf[arr_buf.length - i - 1] = buf;
			}
			return arr_buf;
		}

		public static double [] reverse_copy(double [] arr) {
			int len = arr.length;
			double[] arr_buf = Arrays.copyOf(arr, len);
			for(int i = 0 ; i < arr_buf.length / 2; i++) {
				double buf = arr_buf[i];
				arr_buf[i] = arr_buf[arr_buf.length - i - 1];
				arr_buf[arr_buf.length - i - 1] = buf;
			}
			return arr_buf;
		}

		public static String [] reverse_copy(String [] arr) {
			int len = arr.length;
			String[] arr_buf = Arrays.copyOf(arr, len);
			for(int i = 0 ; i < arr_buf.length / 2; i++) {
				String buf = arr_buf[i];
				arr_buf[i] = arr_buf[arr_buf.length - i - 1];
				arr_buf[arr_buf.length - i - 1] = buf;
			}
			return arr_buf;
		}




		/**
		 * 
		 * @param arr list of any type elements
		 * @return a reverse list of elements
		 */
		public static <T> T [] reverse(T [] arr) {
			for(int i = 0 ; i < arr.length / 2; i++) {
				T buf = arr[i];
				arr[i] = arr[arr.length - i - 1];
				arr[arr.length - i - 1] = buf;
			}
			return arr;
		}

		public static boolean [] reverse(boolean [] arr) {
			for(int i = 0 ; i < arr.length / 2; i++) {
				boolean buf = arr[i];
				arr[i] = arr[arr.length - i - 1];
				arr[arr.length - i - 1] = buf;
			}
			return arr;
		}

		public static byte [] reverse(byte [] arr) {
			for(int i = 0 ; i < arr.length / 2; i++) {
				byte buf = arr[i];
				arr[i] = arr[arr.length - i - 1];
				arr[arr.length - i - 1] = buf;
			}
			return arr;
		}

		public static char [] reverse(char [] arr) {
			for(int i = 0 ; i < arr.length / 2; i++) {
				char buf = arr[i];
				arr[i] = arr[arr.length - i - 1];
				arr[arr.length - i - 1] = buf;
			}
			return arr;
		}

		public static int [] reverse(int [] arr) {
			for(int i = 0 ; i < arr.length / 2; i++) {
				int buf = arr[i];
				arr[i] = arr[arr.length - i - 1];
				arr[arr.length - i - 1] = buf;
			}
			return arr;
		}

		public static long [] reverse(long [] arr) {
			for(int i = 0 ; i < arr.length / 2; i++) {
				long buf = arr[i];
				arr[i] = arr[arr.length - i - 1];
				arr[arr.length - i - 1] = buf;
			}
			return arr;
		}

		public static float [] reverse(float [] arr) {
			for(int i = 0 ; i < arr.length / 2; i++) {
				float buf = arr[i];
				arr[i] = arr[arr.length - i - 1];
				arr[arr.length - i - 1] = buf;
			}
			return arr;
		}

		public static double [] reverse(double [] arr) {
			for(int i = 0 ; i < arr.length / 2; i++) {
				double buf = arr[i];
				arr[i] = arr[arr.length - i - 1];
				arr[arr.length - i - 1] = buf;
			}
			return arr;
		}

		public static String [] reverse(String [] arr) {
			for(int i = 0 ; i < arr.length / 2; i++) {
				String buf = arr[i];
				arr[i] = arr[arr.length - i - 1];
				arr[arr.length - i - 1] = buf;
			}
			return arr;
		}








		/////////////////////////////////
		// MIN / MAX
		////////////////////////////////


		private static String ERROR_MIN_MAX = "Cannot use min() or max() on an empty array.";

		public static float max(float... list) {
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

		public static int max(int... list) {
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

		public static vec2 max(vec2 a, vec2 b) {
			return new vec2(max(a.x(),b.x()),max(a.y(),b.y()));
		}

		public static vec3 max(vec3 a, vec3 b) {
			return new vec3(max(a.x(),b.x()),max(a.y(),b.y()),max(a.z(),b.z()));
		}

		public static vec4 max(vec4 a, vec4 b) {
			return new vec4(max(a.x(),b.x()),max(a.y(),b.y()),max(a.z(),b.z()),max(a.w(),b.w()));
		}

		public static ivec2 max(ivec2 a, ivec2 b) {
			return new ivec2(max(a.x(),b.x()),max(a.y(),b.y()));
		}

		public static ivec3 max(ivec3 a, ivec3 b) {
			return new ivec3(max(a.x(),b.x()),max(a.y(),b.y()),max(a.z(),b.z()));
		}

		public static ivec4 max(ivec4 a, ivec4 b) {
			return new ivec4(max(a.x(),b.x()),max(a.y(),b.y()),max(a.z(),b.z()),max(a.w(),b.w()));
		}





		/**
		 * 
		 * @param list
		 * @return Processing min() method
		 */
		public static float min(float... list) {
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
		public static int min(int... list) {
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

		public static vec2 min(vec2 a, vec2 b) {
			return new vec2(min(a.x(),b.x()),min(a.y(),b.y()));
		}

		public static vec3 min(vec3 a, vec3 b) {
			return new vec3(min(a.x(),b.x()),min(a.y(),b.y()),min(a.z(),b.z()));
		}

		public static vec4 min(vec4 a, vec4 b) {
			return new vec4(min(a.x(),b.x()),min(a.y(),b.y()),min(a.z(),b.z()),min(a.w(),b.w()));
		}

		public static ivec2 min(ivec2 a, ivec2 b) {
			return new ivec2(min(a.x(),b.x()),min(a.y(),b.y()));
		}

		public static ivec3 min(ivec3 a, ivec3 b) {
			return new ivec3(min(a.x(),b.x()),min(a.y(),b.y()),min(a.z(),b.z()));
		}

		public static ivec4 min(ivec4 a, ivec4 b) {
			return new ivec4(min(a.x(),b.x()),min(a.y(),b.y()),min(a.z(),b.z()),min(a.w(),b.w()));
		}
	}



}

