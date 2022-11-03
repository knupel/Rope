package rope.utils;

/**
 * 
 * Class R_Pair to store quicly a coucple objects
 * 

 */


public class R_Pair {
	private Object a;
	private Object b;
	
	public R_Pair(Object a, Object b) {
		this.a = a;
		this.b = b;
	}

	public Object a() {
		return this.a;
	}

	public Object b() {
		return this.b;
	}
}
