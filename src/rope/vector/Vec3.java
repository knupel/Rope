package rope.vector;

public class Vec3 extends Vec {
	// CONSTRUCTOR
  public Vec3() {
  	super(3);
  	set(0,0,0);
  }
  
  public Vec3(float v) {
  	super(3);
  	set(v,v,v);
  }
	
	public Vec3(float x, float y, float z) {
    super(3) ;
    set(x,y,z);
  }
	
	public Vec3(String key_random, float r1) {
		super(3);
		if(key_random.equals(RANDOM)) {
			set(random(-r1,r1),random(-r1,r1),random(-r1,r1));
		} else if(key_random.equals(RANDOM_ZERO)) {
			set(random(0,r1),random(0,r1),random(0,r1));
		} else {
      this.x = this.y = this.z  = this.r = this.g = this.b =this.s = this.t = this.p = 0;
      System.out.println("Contructor class Vec3() cannot use the String key_random: "+key_random);
		}
	}
	
	
	
	// SET
  public Vec3 set(float v) {
  	set(v,v,v);
  	return this;
  }
  
  
  public Vec3 set(Vec v) {
    if(v == null) {
      set(0,0,0);
      return this ;
    } else if(v instanceof Vec5 || v instanceof Vec6) {
      set(v.a,v.b,v.c);
      return this ;
    } else {
      set(v.x,v.y,v.z);
      return this ;
    }
  }
  
  public Vec3 set(iVec v) {
    if(v == null) {
      set(0,0,0);
      return this ;
    } else if(v instanceof iVec5 || v instanceof iVec6) {
      set(v.a,v.b,v.c);
      return this ;
    } else {
      set(v.x,v.y,v.z);
      return this ;
    }
  }
  
	public Vec3 set_x(float x) {
		return set(x,this.y,this.z);
	}

	public Vec3 set_y(float y) {
   return set(this.x,y,this.z);
	}

	public Vec3 set_z(float z) {
   return set(this.x,this.y,z);
	}

	// rgb
	public Vec3 set_r(float x) {
   return set(x,this.y,this.z);
	}

	public Vec3 set_g(float y) {
   return set(this.x,y,this.z);
	}

	public Vec3 set_b(float z) {
   return set(this.x,this.y,z);
	}

	// stp
	public Vec3 set_s(float x) {
   return set(x,this.y,this.z);
	}

	public Vec3 set_t(float y) {
   return set(this.x,y,this.z);
	}

	public Vec3 set_p(float z) {
   return set(this.x,this.y,z);
	}
 
  public Vec3 set(float x, float y, float z) {
  	this.x = this.r = this.s = x;
  	this.y = this.g = this.t = y;
  	this.z = this.b = this.p = z;
  	return this;
  }

  
  public Vec3 set(float[] source) {
    set(source[0],source[1],source[2]);
    return this ;
  }
}
