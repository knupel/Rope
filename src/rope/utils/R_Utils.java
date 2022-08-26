package rope.utils;

/**
 * Rope Static Utils
 * v 0.2.0
 * 2019-2022
 */

import java.util.Random;

import rope.vector.ivec2;
import rope.vector.ivec3;
import rope.vector.ivec4;
import rope.vector.vec2;
import rope.vector.vec3;
import rope.vector.vec4;

public class R_Utils {
	public static class Ru {
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

		private static String ERROR_MIN_MAX = "Cannot use min() or max() on an empty array.";

		public static float max(float... list) {
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

		public static int max(int... list) {
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

