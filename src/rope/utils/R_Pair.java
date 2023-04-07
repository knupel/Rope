package rope.utils;


// import org.apache.commons.lang.SerializationUtils;
/**
 * 
 * Class R_Pair to store quickly a couple objects
 * v 0.0.3
 * 

 */


public class R_Pair<A,B>  {
	private A a;
	private B b;

	public R_Pair() {}
	
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

	// type B
	//////////////

	public B b() {
		return this.b;
	}

	public B b(B b) {
		return this.b = b;
	}
}
