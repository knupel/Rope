/**
* R_Line2D class
* v 0.4.5
* 2019-2022
* @author @stanlepunk
* @see https://github.com/StanLepunK/Rope
*/
package rope.mesh;

import rope.core.*;
import processing.core.PApplet;
import processing.core.PGraphics;
import rope.vector.vec2;
import rope.vector.vec3;
import rope.vector.ivec6;
import rope.pixo.R_Pix;





public class R_Line2D extends R_Graphic implements R_Constants {
  protected vec3 a;
  protected vec3 b;
  protected vec3 ref_a;
  protected vec3 ref_b;
  private boolean mute_is = false;
  protected R_Pix [] pixies;
  private ivec6 id = new ivec6(Integer.MIN_VALUE);
  
  /**
   * 
   * @param pa
   */
  public R_Line2D(PApplet pa) {
  	super(pa);
    init();
  }

  /**
   * 
   * @param pa
   * @param a
   * @param b
   */
  public R_Line2D(PApplet pa, vec2 a, vec2 b) {
  	super(pa);
    init();
    this.a.set(a.x(),a.y(),0);
    this.b.set(b.x(),b.y(),0);
    this.ref_a.set(a.x(),a.y(),0);
    this.ref_b.set(b.x(),b.y(),0);
  }
  
  /**
   * 
   * @param pa
   * @param ax
   * @param ay
   * @param bx
   * @param by
   */
  public R_Line2D(PApplet pa, float ax, float ay, float bx, float by) {
  	super(pa);
    init();
    this.a.set(ax,ay,0);
    this.b.set(bx,by,0);
    this.ref_a.set(ax,ay,0);
    this.ref_b.set(bx,by,0);
  }

  private void init() {
    this.a = new vec3();
    this.b = new vec3();
    this.ref_a = new vec3();
    this.ref_b = new vec3();
  }
  

  ///////////////////////////
  // POSITION SETTING
  //////////////////////////

  /**
   * 
   * @param a
   * @param b
   */
  public R_Line2D set(vec2 a, vec2 b) {
    this.set(a.x(),a.y(),b.x(),b.y());
    return this;
  }

  /**
   * 
   * @param line
   * @return
   */
  public R_Line2D set(R_Line2D line) {
    this.set(line.a().x(),line.a().y(),line.b().x(),line.b().y());
    return this;
  }
  
  /**
   * 
   * @param ax
   * @param ay
   * @param bx
   * @param by
   */
  public R_Line2D set(float ax, float ay, float bx, float by) {
    this.set_a(ax, ay);
    this.set_b(bx, by);
    return this;
  }


  /**
   * This function must be use with precaution because that's can break few function of the class
   * like : offset(), change()... because the reference and the main point point on the same address
   * So use in very specific cases.
   * @param pointer_a give the same memory adress of the vec for the reference and the mane point
   * @param pointer_b give the same memory adress of the vec for the reference and the mane point
   * @return
   */
  public R_Line2D pointer(vec3 pointer_a, vec3 pointer_b) {
    this.a = pointer_a;
    this.b = pointer_b;
    this.ref_a = pointer_a;
    this.ref_b = pointer_b;
    return this;
  }


  //////////////////////
  // A
  //////////////////////

  /**
   * 
   * @return the final value for a
   */
  public vec2 a() {
    return this.a.xy();
  }

  /**
   * use for temporary change
   * @param a
   */
  public void a(vec2 a) {
    this.a(a.x(),a.y());
  }


  /**
   * use for temporary change
   * @param x
   * @param y
   */
  public void a(float x, float y) {
    this.a.set(x,y,0);
  }
  
  /**
   * use with precaution because the vec who is returned pointer on real address 
   * in the memory so any modification can modify all value who ppoint on this one
   * @return the final value for "a" and the original coord in the memory
   */
  public vec3 pointer_a() {
    return this.a;
  }

  /**
   * This function must be use with precaution because that's can break few function of the class
   * like : offset(), change()... because the reference and the main point point on the same address
   * So use in very specific cases.
   * @param pointer_a
   */
  public void pointer_a(vec3 pointer_a) {
    this.a = pointer_a;
    this.ref_a = pointer_a;
  }

  /**
   * use for definitive changement
   * @param x
   * @param y
   */
  public void set_a(float x, float y) {
    this.a(x,y);
    this.ref_a(x,y);
  }

  /**
   * use for definitive changement
   * @param x
   * @param y
   */
  public void set_a(vec2 a) {
    this.set_a(a.x(),a.y());
  }



  protected void ref_a(vec2 ref_a) {
    this.ref_a(ref_a.x(),ref_a.y());
  }
  
  protected void ref_a(float x, float y) {
    this.ref_a.set(x,y,0);
  }



  //////////////////////
  // B
  //////////////////////

  /**
   * 
   * @return the final value for b
   */
  public vec2 b() {
    return this.b.xy();
  }

  /**
   * use for temporary change
   * @param b
   */
  public void b(vec2 b) {
    this.b(b.x(),b.y());
  }
  
  /**
   * use for temporary change
   * @param x
   * @param y
   */
  public void b(float x, float y) {
    this.b.set(x,y,0);
  }


  /**
   * use with precaution because the vec who is returned pointer on real address 
   * in the memory so any modification can modify all value who ppoint on this one
   * @return the final value for "b" and the original coord in the memory
   */
  public vec3 pointer_b() {
    return this.b;
  }

  /**
   * This function must be use with precaution because that's can break few function of the class
   * like : offset(), change()... because the reference and the main point point on the same address
   * So use in very specific cases.
   * @param pointer_b
   */
  public void pointer_b(vec3 pointer_b) {
    this.b = pointer_b;
    this.ref_b = pointer_b;
  }


  /**
   * use for definitive changement
   * @param x
   * @param y
   */
  public void set_b(float x, float y) {
    this.b(x,y);
    this.ref_b(x,y);
  }

    /**
   * use for definitive changement
   * @param x
   * @param y
   */
  public void set_b(vec2 b) {
    this.set_b(b.x(),b.y());
  }



  
  protected void ref_b(vec2 ref_b) {
    this.ref_b(ref_b.x(),ref_b.y());
  }
  
  protected void ref_b(float x, float y) {
    this.ref_b.set(x,y,0);
  }











    /**
   * make a displacement of the line
   * @param offset
   * @return
   */
  public R_Line2D offset(vec2 offset) {
    this.offset(offset.x(), offset.y());
    return this;
  }

  public R_Line2D offset(float offset_x, float offset_y) {
    this.a.add(offset_x, offset_y,0);
    this.b.add(offset_x, offset_y,0);
    return this;
  }


    /**
   * If you don't use show() function for any reason, and in parralelele you change point
   * with function offset(), function change() or any futur method yo must use
   * function reset() to come back to references points setting
   */
  public void reset() {
    this.a.set(ref_a);
    this.b.set(ref_b);
  }

  /**
   * return the projection of the point on the line
   * @param p is point must projected on the line
   * @return
   */
  public vec2 ortho(vec2 p) {
		vec2 proj = b.xy().ortho(a.xy(), p);
		return new vec2(proj.x(), proj.y());
	}





  /**
   * projected point on the line, the distance is calculated by multiplication the distance line by the normal argument
   *  where the starting point is the first point.
   * @param normal_pos where 0 is the starting point and 1 is the end point
   * @return a coordinate of the point 
   */
  public vec2 point(float normal_pos) {
    // return add(ref_a.xy(),projection(angle(), dist_ref()*normal_pos));
    return add(a.xy(),projection(angle(), dist()*normal_pos));
  }

  /**
   * 
   * @param len the position on the line can be upper or lower or the segment
   * @return a coordinate of the point 
   */
  public vec2 point(int len) {
    return point(len / this.dist());
  }

  // @Deprecated public Float normal(vec2 vec, float marge) {
  //   return normal(vec, marge, false);
  // }
  /**
   * Check if a vec point is on the line, if it's true return ne normal position on it '0' to '1' where '0' represent a and 'b' for '1'.
   * if the point is not on the segment the value return NaN.
   * @param point coordinate of the point must be checked
   * @param marge range in pixel around the point must be checked
   * @return
   */
  public Float normal(vec2 p, float marge) {
    float dist = this.dist();
    float dist_ap = dist(this.a(), p);
    float dist_bp = dist(this.b(), p);
    // in line
    if(in_line(this, p, marge)) {
      return normal_impl(dist, dist_ap, dist_bp);
		}
    // the other case where p is not on the segment, but may be on the line
    R_Line2D line = new R_Line2D(this.pa, this.a(), p);
    line.change(0.1f, 0.1f);
    if(in_line(line, p, marge)) {
      return normal_impl(dist, dist_ap, dist_bp);
    }
    // nothing match
		return Float.NaN;
	}

  /**
   * @see Float normal(vec2 vec, float marge)
   * @param vec
   * @return
   */
  public Float normal(vec2 vec) {
    return normal(vec, 0.05f);
  }

  private float normal_impl(float dist, float dist_ap, float dist_bp) {
    float normal_dist = dist_ap / dist;
    if(dist_bp > dist_ap && dist_bp > dist) {
      normal_dist *= -1;
    }
    return normal_dist;
  }





    /**
   * Return the angle of the line from "a" to "b"
   * @return
   */
  public float angle() {
    return a.xy().angle(b.xy());
  }
  
  /**
   * return coordinate of the normal position on the line from the first point
   * the distance use is calculte with the length of the line.
   * @param normal_pos is the normal distance from the first point
   * @return
   * @deprecated instead use vec2 point(float normal_pos)
   */
  @Deprecated public vec2 coord(float normal_pos) {
  	if(normal_pos >= 0 && normal_pos <= 1) {
  		float dx = (float)Math.cos(angle());
			float dy = (float)Math.sin(angle());
			return new vec2(dx,dy).mult(normal_pos*dist()).add(this.a);
  	} else {
  		return null;
  	}
  }
  
  /**
   * return coordinate of distance from the first point of the line
   * @param len is the distance from the first point
   * @return
   * @deprecated instead use vec2 point(int len)
   */
  @Deprecated public vec2 coord(int len) {
  	if(len >= 0 && len <= dist()) {
  		float dx = (float)Math.cos(angle());
			float dy = (float)Math.sin(angle());
			return new vec2(dx,dy).mult(len).add(this.a);
  	} else {
  		return null;
  	}
  }


  //////////////////////////
  // ID
  ///////////////////////////
  public R_Line2D id(int a, int b, int c, int d, int e, int f) {
		this.id.set(a,b,c,d,e,f);
		return this;
	}

  public R_Line2D id(ivec6 id) {
		this.id = id.copy();
		return this;
	}

	public R_Line2D id_a(int id) {
		this.id.a(id);
		return this;
	}

	public R_Line2D id_b(int id) {
		this.id.b(id);
		return this;
	}

	public R_Line2D id_c(int id) {
		this.id.c(id);
		return this;
	}

	public R_Line2D id_d(int id) {
		this.id.d(id);
		return this;
	}

	public R_Line2D id_e(int id) {
		this.id.e(id);
		return this;
	}

	public R_Line2D id_f(int id) {
		this.id.f(id);
		return this;
	}

	// GET ID
	///////////////////////

	public ivec6 id() {
		return this.id;
	}




  






  //////////////////////////////////////////
  // MUTE
  /////////////////////////////////////////
    /**
   * change the state of the line, can be helpful to show or not the line and set behavior
   * @param is
   * @return
   */
  public R_Line2D mute(boolean is) {
    this.mute_is = is;
    return this;
  }


  public boolean mute_is() {
    return mute_is;
  }
  



  ////////////////////////////////////
  // MODIFY LINE
  ////////////////////////////////////////
  /**
   * the idea is pass a normal value 0 to 1, where 1 is the size of your segment. The size is mult by the value
   * @param begin add the distance of the beginning of the segment, where the value is a normal value.
   * @param end add the distance of the end of the segment, where the value is a normal value.
   */
  public R_Line2D change(float begin, float end) {
    float ang = angle();
    float dist = dist_ref();
    // change begin
    vec2 proj_a = projection(ang,dist*begin);
    vec2 proj_b = projection(ang,dist*end);
    a(sub(ref_a.xy(),proj_a));
    b(add(ref_b.xy(),proj_b));
    return this;
  }


    /**
   * Change the angle from the starting point "a"
   * @param angle
   * @return  himself
   */
  public R_Line2D rotation(float angle) {
    this.rotation(angle,0);
    return this;
  }

  /**
   * Create a rotation angle with the axe. 
   * The axe is calculated with a normal position where 0 is the start point and 1 the end point
   * see point()
   * @param angle in radian
   * @param normal_pos
   * @return himself
   */
  public R_Line2D rotation(float angle, float normal_pos) {
    vec2 axe = point(normal_pos);
    float dist_to_a = axe.dist(a());
    float dist_to_b = axe.dist(b());
    if(normal_pos >=0 && normal_pos <= 1) {
      vec2 new_a = sub(axe, projection(angle, dist_to_a));
      vec2 new_b = add(axe, projection(angle, dist_to_b));
      this.a(new_a);
      this.b(new_b);
    } else {
      vec2 new_a = sub(axe, projection(angle, dist_to_a));
      vec2 new_b = sub(axe, projection(angle, dist_to_b));
      this.a(new_a);
      this.b(new_b);
    }
    return this;
  }

  @Deprecated public R_Line2D angle(float angle) {
    return this.rotation(angle,0);
  }

  @Deprecated public R_Line2D angle(float angle, float normal_pos) {
    return rotation(angle, normal_pos);
  }



  /////////////////////////////////
  // PIXEL
  /////////////////////////////////

  public void set_pixels(float density, int... colour) {
    int num_pixel = (int)(dist() * density);
    pixies = new R_Pix[num_pixel];
    if(colour.length > 1) {
      for(int i = 0 ; i < num_pixel ; i++) {
        pixies[i] = new R_Pix();
        vec2 pos = point(random(1));
        int which = floor(random(colour.length));
        set_pixel(pixies[i], pos, colour[which]);
      }
    } else {
      for(int i = 0 ; i < num_pixel ; i++) {
        pixies[i] = new R_Pix();
        vec2 pos = point(random(1));
        set_pixel(pixies[i], pos, colour[0]);
      }
    }
  }

  private void set_pixel(R_Pix p, vec2 pos, int c) {
    if(this.other != null) {
      p.set_entry((int)pos.x(),(int)pos.y(), this.other.width, this.other.height);
    } else {
      p.set_entry((int)pos.x(),(int)pos.y(), pa.g.width, pa.g.height);
    }
    p.fill(c);
  }

    /**
   * 
   * @return the array of pixels a long the line if it's possible.
   */
  public R_Pix [] get_pixels() {
    return this.pixies;
  }







  ////////////////////////////////
  // SHOW
  /////////////////////////////////

  /**
   * Show the result of all previous work on line
   */
  public void show() {
    // line(a,b);
    line(a.xy(),b.xy());
    reset();
  }
  
  /**
   * Show the result of all previous work on line
   * 
   * @param other is the PGraphics where the result will be showing
   */
  @Deprecated public void show(PGraphics other) {
  	this.other = other;
    line(a.xy(),b.xy());
    reset();
  }

  public void show_pixels() {
    loadPixels();
    for(int index = 0 ; index < pixies.length; index++) {
      int entry = pixies[index].get_entry();
      int c = pixies[index].fill();
      plot(entry,c);
    }
    updatePixels();
  }

  public void show_pixels_x2() {
    loadPixels();
    for(int index = 0 ; index < pixies.length; index++) {
      int x = (int)pixies[index].x();
      int y = (int)pixies[index].y();
      int c = pixies[index].fill();
      plot_x2(x,y,c);
    }
    updatePixels();
  }

  public void show_pixels(float density, int... colour) {
    int num_pixel = (int)(dist() * density);
    if(colour.length > 1) {
      loadPixels();
      for(int i = 0 ; i < num_pixel ; i++) {
        int which = floor(random(colour.length));
        plot(point(random(1)),colour[which]);
      }
      updatePixels();
    } else {
      loadPixels();
      for(int i = 0 ; i < num_pixel ; i++) {
        plot(point(random(1)),colour[0]);
      }
      updatePixels();
    }
  }


  public void show_pixels_x2(float density, int... colour) {
    int num_pixel = (int)(dist() * density);
    if(colour.length > 1) {
      loadPixels();
      for(int i = 0 ; i < num_pixel ; i++) {
        int which = floor(random(colour.length));
        plot_x2(point(random(1)),colour[which]);
      }
      updatePixels();
    } else {
      loadPixels();
      for(int i = 0 ; i < num_pixel ; i++) {
        plot(point(random(1)),colour[0]);
      }
      updatePixels();
    }
  }




  
  ///////////////////////////////////////
  // UTILS
  //////////////////////////////////////
  
  /**
   * 
   * @return the barycenter of the two points
   */
  public vec2 barycenter() {
    return barycenter(a,b).xy();
  }

  /**
   * Return the length of the line
   * @return
   */
  public float dist() {
    return abs(a.dist(b));
  }

  protected float dist_ref() {
    return abs(ref_a.dist(ref_b));
  }

  /**
   * Return the intersection point between this line and an other one.
   * @param target
   * @return
   */
  public vec2 intersection(R_Line2D target) {
    vec2 [] arr = null; 
    return intersection(target, arr);
  }

  /**
   * Return the intersection point between this line and an other one.
   * @param target
   * @param exception, list of vec2 point make an exception node, helpful when you don't want a specific node point
   * @return
   */
  public vec2 intersection(R_Line2D target, vec2... exception) {
    float x1 = this.a.x();
    float y1 = this.a.y();
    float x2 = this.b.x();
    float y2 = this.b.y();
    
    float x3 = target.a.x();
    float y3 = target.a.y();
    float x4 = target.b.x();
    float y4 = target.b.y();
    
    float bx = x2 - x1;
    float by = y2 - y1;
    float dx = x4 - x3;
    float dy = y4 - y3;
   
    float b_dot_d_perp = bx*dy - by*dx;
    if(b_dot_d_perp == 0) return null;
   
    float cx = x3 -x1;
    float cy = y3 -y1;
    
    // with dx and dy
    float t = (cx*dy - cy*dx) /b_dot_d_perp;
    if(t < 0 || t > 1) return null;
   
   // with bx and by
    float u = (cx*by - cy*bx) /b_dot_d_perp;
    if(u < 0 || u > 1) return null;

    vec2 result = new vec2(x1 +t *bx, y1 +t *by);

    if(exception != null) {
      for(int i = 0 ; i < exception.length ; i++) {
        if(exception[i].compare(result,new vec2(1))) {
          result = null;
        }
      }
    }
    return result;
  }







  /**
   * 
   * @return
   */
  public R_Line2D copy() {
    R_Line2D line = new R_Line2D(this.pa);
    line.set(this.a.x(), this.a.y(), this.b.x(), this.b.y());
    line.mute(this.mute_is());
    if(pixies != null && pixies.length > 0) {
      line.pixies = new R_Pix[pixies.length];
      for(int i = 0 ; i < pixies.length ; i++) {
        line.pixies[i] = pixies[i];
      }
    }
    return line;
  }
  
  @Override
	public String toString() {
		return "[ " + this.a.x() + ", " + this.a.y() + " ] [ "+ this.b.x() + ", " + this.b.y() +" ]";
	}
}



