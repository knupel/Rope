package rope.vector;

public class Vec5 extends Vec {
  public Vec5() {
  	super(5);
  	set(0,0,0,0,0);
  }
  
  
  public Vec5 set(float a,float b, float c, float d, float e) {
  	this.a = a;
  	this.b = b;
  	this.c = c;
  	this.d = d;
  	this.e = e;
  	return this;
  }
}
