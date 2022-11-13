package rope.utils;


// import org.apache.commons.lang.SerializationUtils;
/**
 * 
 * Class R_Pair to store quicly a coucple objects
 * v 0.0.2
 * 

 */


public class R_Pair<A,B>  {
	private A a;
	private B b;
	
	public R_Pair(A a, B b) {
		this.a = a;
		this.b = b;
	}

	// type A
	//////////////

	public A a(){ 
		return this.a;
	}

	public A a(A a) {
		return this.a = a;
	}

	// public A pointer_a() {
	// 	return this.a;
	// }

	// public A pointer_a(A a) {
	// 	return this.a = a;
	// }

	// type B
	//////////////

	public B b() {
		return this.b;
	}

	public B b(B b) {
		return this.b = b;
	}

	// public B pointer_b() {
	// 	return this.b;
	// }

	// public B pointer_b(B b) {
	// 	return this.b = b;
	// }
}
