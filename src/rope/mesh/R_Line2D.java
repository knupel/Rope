/**
 *   ___      ___   ____   _______
 *  | -  \   /   \  |    \ |  ___/
 *  | |/  | |   \ | | |\ | |  |__
 *  |    /  | | | | | |  / |  __/
 *  | |  \  \ \   / |  |/  |  |____
 *  |_| \_\  \___/  |_ |   |______/
 * 
 * R_Line2D class
 * v 1.0.0
 * 2019-2023
 * @author @knupel
 * @see https://github.com/knupel/Rope
*/

package rope.mesh;

import rope.core.*;
import processing.core.PApplet;
import processing.core.PGraphics;
import rope.vector.vec2;
import rope.vector.vec3;
import rope.vector.ivec6;
import rope.vector.bvec2;
import rope.pixo.R_Pix;
import rope.pixo.R_Pixies;
import rope.utils.R_Pair;
import rope.colour.R_Colour;


public class R_Line2D extends R_Graphic {
  protected vec3 a;
  protected vec3 b;
  protected vec3 ref_a;
  protected vec3 ref_b;
  private boolean mute_is = false;
  protected R_Pixies pixies;
  protected R_Pixies pixies_growth;
  private int growth_type = NORMAL;
  private bvec2 use_gradient_is;
  private ivec6 id = new ivec6(Integer.MIN_VALUE);
  private R_Colour palette;
  
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
    this.use_gradient_is = new bvec2(false);
    this.palette = new R_Colour(this.pa, BLACK);
  }
  

  ///////////////////////////
  // SET DEFINITIVE POSITION
  //////////////////////////

  /**
   * use for definitive changement
   * @param a
   * @param b
   */
  public R_Line2D set(vec2 a, vec2 b) {
    this.set(a.x(),a.y(),b.x(),b.y());
    return this;
  }

  /**
   * use for definitive changement
   * @param line
   * @return
   */
  public R_Line2D set(R_Line2D line) {
    this.set(line.a().x(),line.a().y(),line.b().x(),line.b().y());
    return this;
  }
  
  /**
   * use for definitive changement
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

  ////////////////////////
  // SET A

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
   * @param a
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

  ////////////////////////
  // SET B

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
   * @param b
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





  /////////////////////////////
  // SET POS TEMPORARLY
  ///////////////////////

  //////////////////////
  // A
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

  //////////////////////
  // B

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





  //////////////////////////////
  // POINTER
  ///////////////////////

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
   * projected point on the line, the distance is calculated by multiplication the distance line by the normal argument
   *  where the starting point is the first point.
   * @param normal_abscissa where 0 is the starting point and 1 is the end point
   * @return a coordinate of the point 
   */
  public vec2 get_point(float normal_abscissa) {
    return add(a.xy(),projection(angle(), dist()*normal_abscissa));
  }

  /**
   * 
   * @param normal_abscissa
   * @param normal_ordinate
   * @return
   */
  public vec2 get_point(float normal_abscissa, float normal_ordinate) {
    vec2 pos = get_point(normal_abscissa);
    float dist_y = abs(dist()*normal_ordinate);
    float ang_y = PI/2;
    if(normal_ordinate < 0) {
      ang_y *= -1;;
    }
    float angle = angle() + ang_y;
    return add(pos,projection(angle, dist_y));
  }

  /**
   * 
   * @param len_abscissa the position on the line can be upper or lower or the segment
   * @return a coordinate of the point 
   */
  public vec2 get_point(int len_abscissa) {
    return get_point(len_abscissa / this.dist());
  }

  /**
   * 
   * @param len_abscissa
   * @param len_ordinate
   * @return
   */
  public vec2 get_point(int len_abscissa, int len_ordinate) {
    return get_point(len_abscissa / this.dist(), len_ordinate / this.dist());
  }


  /**
   * Return the angle of the line from "a" to "b"
   * @return
   */
  public float angle() {
    return a.xy().angle(b.xy());
  }

  public float angle(R_Line2D line) {
    float ang_a = a.xy().angle(b.xy());
    float ang_b = line.angle();
    float res = ang_a - ang_b;
    if(abs(res) > PI) {
      if(res < 0) {
        res += TAU;
      } else {
        res = (TAU -res) * -1;
      }
    }
    return res;
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

  // @Deprecated public Float normal(vec2 vec, float marge) {
  //   return normal(vec, marge, false);
  // }
  /**
   * Check if a vec point is on the line, if it's true return ne normal position on it '0' to '1' where '0' represent a and 'b' for '1'.
   * if the point is not on the segment the value return NaN.
   * @param p coordinate of the point must be checked
   * @param marge range in pixel around the point must be checked
   * @return
   */
  public Float normal(vec2 p, float marge) {
    float dist = this.dist();
    float dist_ap = dist(this.a(), p);
    float dist_bp = dist(this.b(), p);
    // in line
    if(in_segment(this, p, marge)) {
      return normal_impl(dist, dist_ap, dist_bp);
		}
    // the other case where p is not on the segment, but may be on the line
    R_Line2D line = new R_Line2D(this.pa, this.a(), p);
    line.change(0.1f, 0.1f);
    if(in_segment(line, p, marge)) {
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



  //////////////////////////
  // ID
  ///////////////////////////
  public R_Line2D id(int a, int b, int c, int d, int e, int f) {
		this.id.set(a,b,c,d,e,f);
		return this;
	}

  public R_Line2D id(ivec6 id) {
		this.id.set(id);
		return this;
	}

  public R_Line2D id(int id) {
		this.id.set(id);
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
    vec2 axe = this.get_point(normal_pos);
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




  /////////////////////////////////
  // PIXEL
  /////////////////////////////////
  private int type_abscissa = NORMAL;
  private int type_ordinate = NORMAL;
  private int level_abscissa = 1;
  private int level_ordinate = 1;
  /**
   * 
   * @param type value to set the random on abscissa NORMAL, START, END, CENTER and SIDE is available
   */
  public void mode_abscissa(int type) {
    this.type_abscissa = type;
  }

  /**
   * 
   * @param type value to set the random on abscissa NORMAL, START, END, CENTER and SIDE is available
   * @param level from 1 to 13, but for CENTER and SIDE after 6 or 7 is not really interesting
   */
  public void mode_abscissa(int type, int level) {
    this.mode_abscissa(type);
    this.level_abscissa = abs(level);
  }
  /**
   * 
   * @param type value to set the random on abscissa NORMAL, START, END, CENTER and SIDE is available
   */
  public void mode_ordinate(int type) {
    // Special case for swith because the treatment is not exacly a same
    if(type == CENTER || type == SIDE || type == START || type == END) {
      type *= 2;
    }
    this.type_ordinate = type;
  }

  /**
   * 
   * @param type  value to set the random on abscissa NORMAL, START, END, CENTER and SIDE is available
   * @param level from 1 to 13, but for CENTER and SIDE after 6 or 7 is not really interesting
   */
  public void mode_ordinate(int type, int level) {
    this.mode_ordinate(type);
    this.level_ordinate = abs(level);
  }

  private float get_distribution(int type, int level) {
    float absolute_pos = Float.NaN;;
    float buf_pos = 0;
    float resultat = 0;
    float is = 0;
    float bell_detection = 0.18f;
    switch(type) {
      case NORMAL:
        absolute_pos = random(1);
        break;
      // case for the abscissa
      case CENTER:
        buf_pos = random(1);
        resultat = d_bell_raw(buf_pos, level);
        is = random(bell_detection);
        if(resultat > is) {
          absolute_pos = buf_pos;
        }
        break;
      case SIDE:
        absolute_pos = distri_pos(level, true);
        if(!Float.isNaN(absolute_pos)) {
          absolute_pos = map(absolute_pos, 0.0f, 1.0f, 0f, 0.5f);
          if(random(1) < 0.5f) {
            absolute_pos += (2*(0.5f -absolute_pos));
          }
        }
        break;
      case START:
        absolute_pos = distri_pos(level, false);
        break;

      case END:
        absolute_pos = 1 - distri_pos(level, false);
        break;

      // special case for the ordinate
      case START*2:
        absolute_pos = distri_pos(level, false);
        break;

      case END*2:
        absolute_pos = distri_pos(level, false);
        if(!Float.isNaN(absolute_pos)) {
          absolute_pos = 1 -absolute_pos;
        }
        break;
      case SIDE *2:
        absolute_pos = distri_pos(level, true);
        if(!Float.isNaN(absolute_pos)) {
          absolute_pos = pow(absolute_pos,map(level, 1,13,1,2));
          absolute_pos = map(absolute_pos, 0.0f, 1.0f, 0f, 0.5f);
          if(random(1) < 0.5f) {
            absolute_pos += (2*(0.5f -absolute_pos));
          }
        }
        break;
      case CENTER *2:
        absolute_pos = distri_pos(level, true);
        if(!Float.isNaN(absolute_pos)) {
          absolute_pos = pow(absolute_pos,map(level, 1,13,1,2));
          absolute_pos = map(absolute_pos, 0.0f, 1.0f, 0.5f, 0);
          if(random(1) < 0.5f) {
            absolute_pos += (2*(0.5f -absolute_pos));
          }
        }
        break;
      default:
        absolute_pos = random(1);
        break;
    }
    return absolute_pos;
  }

  private float distri_pos(int level, boolean reflect_is) {
    float buf_pos = random(1);
    float resultat = 0;
    if(!reflect_is) {
      resultat = d_spray(buf_pos, level);
    } else {
      resultat = d_reflect(buf_pos, level);
    }
    float is = random(1);
    if(resultat < is) {
      return buf_pos;
    }
    return Float.NaN;
  }

  private float d_reflect(float value , int level) {
    float power = 1.0f;
    switch (level) {
      case 1: power = 0.05f; break;
      case 2: power = 0.12f; break;
      case 3: power = 0.24f; break;
      case 4: power = 0.38f; break;
      case 5: power = 0.54f; break;
      case 6: power = 0.7f; break;
      case 7: power = 0.85f; break;
      case 8: power = 1.0f; break;
      case 9: power = 1.2f; break;
      case 10: power = 1.4f; break;
      case 11: power = 1.6f; break;
      case 12: power = 1.8f; break;
      case 13: power = 2.0f; break;
      default: power = 0.7f; break;
    }
    float range = 1.0f;
    return d_sigmoid(value, range, power);
  }

  private float d_spray(float value , int level) {
    float power = 1.0f;
    switch (level) {
      case 1: power = 0.5f; break;
      case 2: power = 0.6f; break;
      case 3: power = 0.7f; break;
      case 4: power = 0.8f; break;
      case 5: power = 0.9f; break;
      case 6: power = 1.0f; break;
      case 7: power = 1.3f; break;
      case 8: power = 1.6f; break;
      case 9: power = 2.1f; break;
      case 10: power = 2.4f; break;
      case 11: power = 2.7f; break;
      case 12: power = 3.0f; break;
      case 13: power = 3.3f; break;
      default: power = 1.0f; break;
    }
    float range = 1.0f;
    return d_pow(value, range, power);
  }

  private float d_bell_raw(float value, int level) {
    float variance = 3.0f;
    switch (level) {
      case 1: variance = 7.0f; break;
      case 2: variance = 6.0f; break;
      case 3: variance = 5.0f; break;
      case 4: variance = 4.0f; break;
      case 5: variance = 3.0f; break;
      case 6: variance = 2.5f; break;
      case 7: variance = 2.1f; break;
      case 8: variance = 1.8f; break;
      case 9: variance = 1.5f; break;
      case 10: variance = 1.2f; break;
      case 11: variance = 0.9f; break;
      case 12: variance = 0.6f; break;
      case 13: variance = 0.3f; break;
      default: variance = 3.0f; break;
    }
    float range = dist(this.a, this.b);
    float offset = 0;
    return d_bell(value *range, range, variance, offset);
  }


  private vec2 absolute_pos(float range_ordinate) {
    float abscissa = get_distribution(type_abscissa, level_abscissa);
    if(abscissa < 0 || Float.isNaN(abscissa)) {
      return null;
    }
    float buf_ordinate = get_distribution(type_ordinate, level_ordinate);
    if(buf_ordinate < 0 || Float.isNaN(buf_ordinate)) {
      return null;
    }
    float ordinate = map(buf_ordinate, 0,1, -range_ordinate, range_ordinate);
    return new vec2(abscissa, ordinate);
    
  }

  /**
 * 
 * @param density the ratio abscissa of pixels along the line from 0 to 1
 * @param colour list of int color to create the pixel line
 */
  // @Deprecated public void set_pixels(float density, int... colour) {
  //   float thickness = 0;
  //   set_pixels(density, thickness, colour);
  // }

  /**
  * @param density the ratio abscissa of pixels along the line from 0 to 1 usualy
   */
  public void set_pixels(float density) {
    set_pixels(density, 0.0f, this.palette);
  }

    /**
   * 
   * @param density the ratio abscissa of pixels along the line from 0 to 1
   * @param thickness is the strokeWeight / ordinate of your line in pixel point
   */
  public void set_pixels(float density, float thickness) {
    set_pixels(density, thickness, this.palette);
  }



  /**
   * 
   * @param density the ratio abscissa of pixels along the line from 0 to 1
   * @param thickness is the strokeWeight / ordinate of your line in pixel point
   * @param colour list of int color to create the pixel line
   */
  public void set_pixels(float density, float thickness, R_Colour palette) {
    int num_pixel = (int)(dist() * density);
    if(thickness <= 0) {
      thickness = 0.1f;
    }
    float range_ordinate = thickness / dist() * 0.5f;
    if(pixies == null) {
      pixies = new R_Pixies();
    } else {
      pixies.clear();
    }
    for(int i = 0 ; i < num_pixel ; i++) {
      R_Pair<vec3, Integer> pair = pixel_impl(range_ordinate, palette.get());
      if(pair != null) {
        set_pixel(pair.a(), pair.b());
      }
    }
  }

  private R_Pair<vec3, Integer> pixel_impl(float range_ordinate, int... colours) {
    R_Pair<vec3, Integer> pair = null;
    // abs.x() is the position on the line
    vec2 abs = absolute_pos(range_ordinate);
    if(abs != null) {
      pair = new R_Pair<vec3, Integer>();
      vec2 pos = this.get_point(abs.x(), abs.y());
      int c = BLACK;
      int len = colours.length;
      if(len > 0) {
        int which = 0;
        if(use_gradient_is.y() && len > 1) {
          which = floor(random(len));
          if(which%2 != 0) {
            which--;
          }
        }
        c = colours[which];
      }
      pair.a(new vec3(pos.x(), pos.y(), abs.x()));
      pair.b(c);
    }
    return pair;
  }

  public void set_palette(int... colours) {
    this.palette.clear();
    this.palette.add(colours);
  }


  ///////////////////////////////////
  // GROWTH
////////////////////////
public void growth_option(int type, boolean use_gradient) {
  this.growth_type = type;
  this.use_gradient_is.y(use_gradient);
}
  public void growth_option(int type) {
    this.growth_type = type;
  }

  public int get_growth_type() {
    return this.growth_type;
  }

  public void growth(int level, int step) {
    growth(level, step, Float.NaN, Float.NaN);
  }

    /**
   * The direction is based on start_fov angle
   * @param level from 1 to n
   * @param step from 1 to n
   * @param direction from 0 to 2PI / TAU
   * @param start_fov from 0 to PI
   * @param end_fov from 0 to PI
   */
  public void growth(int level, int step, float direction, float start_fov, float end_fov) {
    if(level < 1) {
      return;
    }

    float start_angle = 0;
    float half_fov = PI;
    float step_fov = 0;
    if(all(!Float.isNaN(direction),!Float.isNaN(start_fov), !Float.isNaN(end_fov))) {
      float fov = end_fov - start_fov;
      half_fov = abs(fov * 0.5f);
      start_angle = direction;  
      step_fov = fov / pixies.size();
    }  

    if(pixies_growth == null) {
      pixies_growth = new R_Pixies();
    } else {
      pixies_growth.clear();
    }

    float variance_angle = 0;
    float dir = 0;
    // How to konw the position of the pixel in the line ?????
    for(R_Pix p : pixies.get()) {
      float abs_x = p.z();
      // set root direction
      if(this.growth_type == CHAOS) {
        variance_angle += step_fov;
        dir = start_angle + variance_angle + start_fov;
      } else {
        variance_angle = map(abs_x, 0, 1, start_fov, end_fov);
        dir = start_angle + variance_angle;
      }
      growth_impl(p, level, step, half_fov, dir, abs_x);
    }
  }



  /**
   * The direction is based on the bissector of the fov
   * @param level from 1 to n
   * @param step from 1 to n
   * @param direction from 0 to 2PI / TAU
   * @param fov from 0 to 2PI / TAU
   */
  public void growth(int level, int step, float direction, float fov) {
    if(level < 1) {
      return;
    }

    float start_angle = 0;
    float half_fov = PI;
    float step_fov = 0;
    if(all(!Float.isNaN(direction),!Float.isNaN(fov))) {
      half_fov = fov * 0.5f;
      start_angle = direction - half_fov;  
      step_fov = fov / pixies.size();
    }  

    if(pixies_growth == null) {
      pixies_growth = new R_Pixies();
    } else {
      pixies_growth.clear();
    }

    float variance_angle = 0;
    float dir = 0;
    for(R_Pix p : pixies.get()) {
      float abs_x = p.z();
      if(this.growth_type == CHAOS) {
        variance_angle += step_fov;
        dir = start_angle + variance_angle;
      } else {
        variance_angle = map(abs_x, 0, 1, 0, fov);
        dir = start_angle + variance_angle;
      }
      growth_impl(p, level, step, half_fov, dir, abs_x);
    }
  }



  private void growth_impl(R_Pix p, int level, int step, float half_fov, float dir, float abs_pos) {
    int [] col = new int[level];
    if(!use_gradient_is.y()) {
      for(int i = 0 ; i < level ; i++) {
        col[i] = p.fill();
      }
    } else {
      int first = p.fill();
      int second = p.fill();
      int [] arr = palette.get("palette");
      // int len = palette.get("palette").length;
      if(arr.length > 1) {
        for(int i = 0 ; i < arr.length ; i++) {
          if(first == arr[i]) {
            // first = palette.get("palette", 0);
            
            int next = i+1;
            // print_out("NEXT", next);
            if(next >= arr.length) {
              // print_out("PAS BON", next);
              next = 0;
            }
            second = palette.get("palette", next);
            break;
          }
        }
        
      }

      col = palette.gradient(first, second, level);
    }
    
    
    
    R_Pix [] buf_growth = new R_Pix[level];
    buf_growth[0] = p.copy();
    buf_growth[0].w(dir);
    buf_growth[0].fill(col[0]);


    float x = buf_growth[0].x();
    float y = buf_growth[0].y();
    for(int i = 1 ; i < level ; i++) {
      float angle = buf_growth[0].w();
      if(this.growth_type == MAD || this.growth_type == CHAOS) {
        angle += random(-half_fov,half_fov);
      }
      float dx = sin(angle);
      float dy = cos(angle);
      int prev = i - 1;
      x += (dx * step);
      y += (dy * step);
      buf_growth[i] = new R_Pix();
      set_pixel_impl(buf_growth[i], new vec3(x,y, abs_pos), col[i]);
      pixies_growth.add(buf_growth[i]);
    }
  }




  private void set_pixel(vec3 pos, int c) {
    R_Pix pix = new R_Pix();
    set_pixel_impl(pix, pos, c);
    pixies.add(pix);
  }

  private void set_pixel_impl(R_Pix p, vec3 pos, int c) {
    // the problem is from the round, the problem is by the buffering of x, y values
    if(this.other != null) {
      p.set_entry(round(pos.x()),round(pos.y()), this.other.width, this.other.height);
    } else {
      p.set_entry(round(pos.x()),round(pos.y()), pa.g.width, pa.g.height);
    }
    p.z(pos.z());
    p.fill(c);
  }

  /**
   * 
   * @return the array of pixels a long the line if it's possible.
   */
  public R_Pix [] get_pixies() {
    if(this.pixies != null) {
      return this.pixies.array();
    }
    return null;
  }

  public R_Pix [] get_pixies_growth() {
    if(this.pixies_growth != null) {
      return this.pixies_growth.array();
    }
    return null;
  }

  public boolean pixels_is() {
    if(this.pixies == null || this.pixies.size() == 0) {
      return false;
    }
    return true;
  }







  ////////////////////////////////
  // SHOW
  /////////////////////////////////

  /**
   * Show the result of all previous work on line
   */
  public void show() {
    line(a.xy(),b.xy());
    reset();
  }

  public void show_pixels() {
    if(pixies != null) {
      show_pixels_impl(pixies);
    }
    if(pixies_growth != null) {
      show_pixels_impl(pixies_growth);
    }
  }
  
  private void show_pixels_impl(R_Pixies list) {
    // with pixel density
    if(pixel_density_is()) {
      loadPixels();
      for(int index = 0 ; index < list.size(); index++) {
        int x = (int)(list.get(index).x() *pa.displayDensity());
        int y = (int)(list.get(index).y() *pa.displayDensity());
        int c = list.get(index).fill();
        plot(x,y,c);
      }
      updatePixels();
      return;
    }
    // without pixel density
    loadPixels();
    for(int index = 0 ; index < list.size(); index++) {
      int entry = list.get(index).get_entry();
      int c = list.get(index).fill();
      plot(entry,c);
    }
    updatePixels();
  }

  public void show_pixels_x2() {
    show_pixels_x2_impl(pixies);
    if(pixies_growth != null) {
      show_pixels_x2_impl(pixies_growth);
    }
  }

  private void show_pixels_x2_impl(R_Pixies list) {
    // with pixel density
    if(pixel_density_is()) {
      loadPixels();
      for(int index = 0 ; index < list.size(); index++) {
      int x = (int)(list.get(index).x() * pa.displayDensity());
      int y = (int)(list.get(index).y() * pa.displayDensity());
        int c = list.get(index).fill();
        plot_x2(x,y,c);
      }
      updatePixels();
      return;
    }
    // without pixel density
    loadPixels();
    for(int index = 0 ; index < list.size(); index++) {
      int x = (int)list.get(index).x();
      int y = (int)list.get(index).y();
      int c = list.get(index).fill();
      plot_x2(x,y,c);
    }
    updatePixels();
  }



  public void show_pixels(float density) {
    show_pixels(density, 1);
  }


    /**
   * 
   * @param density
   * @param thickness
   * @param palette
   */
  public void show_pixels(float density, float thickness) {
    int num_pixel = (int)(dist() * density);
    float range_ordinate = thickness / dist() * 0.5f;
    // with pixel density
    if(pixel_density_is()) {
      loadPixels();
      for(int i = 0 ; i < num_pixel ; i++) {
        R_Pair<vec3, Integer> pair = pixel_impl(range_ordinate, this.palette.get());
        if(pair != null) {
          plot(pair.a().xy().mult(pa.displayDensity()), pair.b());
        }
      }
      updatePixels();
      return;
    }
    // without pixel density
    loadPixels();
    for(int i = 0 ; i < num_pixel ; i++) {
      R_Pair<vec3, Integer> pair = pixel_impl(range_ordinate, palette.get());
      if(pair != null) {
        plot(pair.a().xy(), pair.b());
      }
    }
    updatePixels();
  }




  /**
   * 
   * @param density
   * @param colour
   */
  public void show_pixels_x2(float density) {
    show_pixels_x2(density, 1);
  }

  /**
   * 
   * @param density
   * @param thickness
   * @param colour
   */

   public void show_pixels_x2(float density, float thickness) {
    int num_pixel = (int)(dist() * density);
    float range_ordinate = thickness / dist() * 0.5f;
    // with pixel density
    if(pixel_density_is()) {
      loadPixels();
      for(int i = 0 ; i < num_pixel ; i++) {
        R_Pair<vec3, Integer> pair = pixel_impl(range_ordinate, this.palette.get());
        if(pair != null) {
          plot_x2(pair.a().xy().mult(pa.displayDensity()), pair.b());
        }
      }
      updatePixels();
      return;
    }
    // without pixel density
    loadPixels();
    for(int i = 0 ; i < num_pixel ; i++) {
      R_Pair<vec3, Integer> pair = pixel_impl(range_ordinate, palette.get());
      if(pair != null) {
        plot_x2(pair.a().xy(), pair.b());
      }
    }
    updatePixels();
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
   * @return copy of herself
   */
  public R_Line2D copy() {
    R_Line2D line = new R_Line2D(this.pa);
    copy_impl(line);
    return line;
  }

  protected void copy_impl(R_Line2D line) {
    line.set(this.a.x(), this.a.y(), this.b.x(), this.b.y());
    line.mute(this.mute_is());
    line.pixel_density_is(this.pixel_density_is());
    if(pixies != null && pixies.size() > 0) {
      line.pixies = new R_Pixies();
      for(R_Pix pix : pixies.get()) {
        line.pixies.add(pix);
      }
    }
    if(pixies_growth != null && pixies_growth.size() > 0) {
      line.pixies_growth = new R_Pixies();
      for(R_Pix pix : pixies_growth.get()) {
        line.pixies_growth.add(pix);
      }
    }
  }
  
  @Override
	public String toString() {
		return "[ " + this.a.x() + ", " + this.a.y() + " ] [ "+ this.b.x() + ", " + this.b.y() +" ]";
	}
}



