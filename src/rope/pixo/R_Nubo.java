package rope.pixo;
import processing.core.PApplet;
/**
* R_Nubo
* v 0.2.3
* 2021-2021
*
* R_Nubo is a collection of 2D algorithms to distribute point from center with an opening angle.
*
*/

import rope.vector.vec;
import rope.vector.vec2;
import rope.vector.ivec2;
import rope.vector.bvec2;
import rope.costume.R_Line2D;
import rope.tool.R_Focus;
import rope.core.Rope;


public class R_Nubo extends Rope {
	private vec2 ref_pos;
	private vec2 pos;
  private vec2 offset_pos;
  private vec2 buffer_pos;

  private R_Focus focus;

  private vec2 range_angle;
  private float fov = 0;
  private float bissector = 0;
  private float offset_angle = 0;

  private vec2 range_dist;

  private int algo = CHAOS;
  private int mode = 0;

  private boolean in = false;

  private float step = 1.0f;
  private int iter = 1;
  private int index = 0;

  private ivec2 grid;
  private boolean pixel_is = true;
  private boolean use_grid_is = false;

  private PApplet pa;


  public R_Nubo(PApplet pa) {
    this.pa = pa;
    this.focus = new R_Focus();
  	this.pos = new vec2(0);
    this.range_angle = new vec2(-PI, PI);
    this.fov = calc_fov(this.range_angle.x(),this.range_angle.y());
    this.range_dist = new vec2(0,1);
    this.buffer_pos = new vec2();
    this.offset_pos = new vec2();
    set_ref();
  }

  // iteration & index

  /**
   * 
   * @param iter define the num of iteration of ths cloud, so it's like the size of it.
   * @return this to give the opportunity to make train of function on the same line
   */
  public R_Nubo set_iter(int iter) {
  	this.iter = iter;
    return this;
  }

  /**
   * 
   * @param index target which particle of cloud is affected, must be between 0 and and the size of cloud
   * @return this to give the opportunity to make train of function on the same line
   */
  // private void set_index(int index) {
  // 	this.index = index;
  // }

  // reference
  private void set_ref() {
  	if(this.ref_pos == null) {
  		this.ref_pos = this.pos.copy();
  	} else {
  		this.ref_pos.set(this.pos);
  	}
    bissector = (this.range_angle.x() + this.range_angle.y()) * 0.5f;
  }

  // type
    /**
   * 
   * @param algo define the algotithm do diffuse pixel
   * @return this to give the opportunity to make train of function on the same line
   */
  public R_Nubo set_algo(int algo) {
  	this.algo = algo;
  	return this;
  }

  public int get_algo() {
    return this.algo;
  }

  /**
   * 
   * @param mode define the variation of the type (algorithm)
   * @return this to give the opportunity to make train of function on the same line
   */
  public R_Nubo set_mode(int mode) {
  	this.mode = mode;
  	return this;
  }

  public int get_mode() {
    return this.mode;
  }

  // step

  /**
   * 
   * @param step if value to divid the cloud, that's can take a different way depending on the type chosen.
   * @return this to give the opportunity to make train of function on the same line
   */
  public R_Nubo set_step(float step) {
  	this.step = step;
  	return this;
  }

  public float get_step() {
  	return this.step;
  }

  // focus
  public R_Focus get_focus() {
    return this.focus;
  }

  /**
   * It's a focus point in the cloud area
   * @param angle is the target angle, the angle must be between the start and end angle
   * @param dist is the target distance, the angle must be the begin and the end field.
   * @return this to give the opportunity to make train of function on the same line
   */
  public R_Nubo set_focus(float angle, float dist) {
    set_focus_angle(angle);
    set_focus_dist(dist);
    return this;
  }

  public R_Nubo set_focus_angle(float angle) {
     boolean is = false;
    if(angle >= get_start_fov() && angle <= get_stop_fov()) {
      is = true;
    }
    if(is) {
      this.focus.set_angle(angle);
      return this;
    }
    print_err("public R_Nubo set_focus_angle(float angle)", angle, "is out of the range fov", get_start_fov(), get_stop_fov());
    pa.exit();
    return this;
  }

  public R_Nubo set_focus_dist(float dist) {
     boolean is = false;
    if(dist >= get_dist_min() && dist <= get_dist_max()) {
      is = true;
    }
    if(is) {
      this.focus.set_dist(dist);
      return this;
    }
    print_err("public R_Nubo set_focus_dist(float dist)", dist, "is out of the range fov", get_dist_min(), get_dist_max());
    pa.exit();
    return this;
  }


  // angle

  /**
   * 
   * @param fov set the angle where the pixels is display. The first argument is the start angle and the last close the viewd, like in photography
   * @return this to give the opportunity to make train of function on the same line
   */
  public R_Nubo set_fov(vec2 fov) {
    this.set_fov(fov.x(), fov.y());
    return this;
  }

	public R_Nubo set_fov(float ang_min, float ang_max) {
  	this.range_angle.set(ang_min, ang_max);
    this.fov = calc_fov(ang_min, ang_max);
  	return this;
  }

  public R_Nubo offset_angle(float angle) {
    this.offset_angle = angle;
    return this;
  }

  public R_Nubo offset_pos(vec offset_pos) {
    offset_pos(offset_pos.x(), offset_pos.y());
    return this;
  }


  public R_Nubo offset_pos(float x, float y) {
    this.offset_pos.set(x,y);
    return this;
  }

  public float get_start_fov() {
    return this.range_angle.x();
  }

  public float get_stop_fov() {
    return this.range_angle.y();
  }

  public float get_fov() {
    return this.fov;
  }

  public float get_angle() {
    return this.focus.get_angle();
  }

  public float get_bissector() {
    return this.bissector;
  }

  private float calc_fov(float min, float max) {
    if(max <= min) {
      print_err("WARNING: calc_fov(",min,max,") float calc_fov( float min, float max) 'min' must be < to 'max'");
      pa.exit();
    }
    if(min < 0 && max >= 0) {
      return abs(min) + abs(max);
    }

    if(min < 0 && max < 0) {
      return abs(min) - abs(max);
    }
    return max - min;
  }

  // range & dist

  /**
   * 
   * @param range set the distance where the picture is net. The first argument is the start position and the last is the end, like in photography
   * @return this to give the opportunity to make train of function on the same line
   */
  public R_Nubo set_field(vec2 range) {
    set_range_dist(range.x(), range.y());
    return this;
  }

  public R_Nubo set_field(float min, float max) {
    set_range_dist(min, max);
    return this;
  }


  private void set_range_dist(float min, float max) {
  	this.range_dist.set(min,max);
  }

  public float get_dist() {
    return this.focus.get_dist();
  }

	public vec2 get_range_dist() {
    return this.range_dist;
  }

  public float get_dist_min() {
    return this.range_dist.x();
  }

  public float get_dist_max() {
    return this.range_dist.y();
  }


  // pos

  public float x() {
  	return pos.x() + offset_pos.x();
  }

  public float y() {
  	return pos.y() + offset_pos.y();
  }

  public vec2 pos() {
    buffer_pos.set(this.x(), this.y());
  	return buffer_pos;
  }

  // set pos
  /**
   * 
   * @param pos is vec position of the center of your pixel cloud
   * @return this to give the opportunity to make train of function on the same line
   */
  public R_Nubo pos(vec pos) {
  	this.pos(pos.x(),pos.y());
  	return this;
  }

	public R_Nubo pos(float x, float y) {
  	this.pos.set(x,y);
    set_ref();
    return this;
  }


  // grid

  /**
   * 
   * @param grid if the step in x anf y to display or not the pixels
   * @return this to give the opportunity to make train of function on the same line
   */
  public R_Nubo set_grid(ivec2 grid) {
    set_grid(grid.x(), grid.y());
    return this;
  }

  public R_Nubo set_grid(int x, int y) {
    if(this.grid == null) {
      this.grid = new ivec2(x,y);
    } else {
      this.grid.set(x,y);
    }
    return this;
  }

  public R_Nubo use_grid(boolean is) {
    this.use_grid_is = is;
    return this;
  }

  // pixel

  /**
   * 
   * @param width_graphic is the with of your 2D image
   * @return the position of the pixel in the pixel array of your image.
   */
  public int get_pixel_index(int width_graphic) {
  	return this.index_pixel_array((int)x(),(int)y(),width_graphic);
  }

  public boolean pixel_is() {
    return this.pixel_is;
  }



  // UPDATE

  private void update_focus() {
    float angle = random(get_start_fov(),get_stop_fov());
    float dist = 1;
    switch(this.algo) {
      case CIRCULAR:
      dist = get_dist_max();
      break;

      case POLYGON:
      dist = get_dist_max();
      break;

			case MAD:
      dist = random(get_dist_min(), get_dist_max());
      break;

      case SPIRAL:
      dist = random(get_dist_min(), get_dist_max());
      break;

      case CHAOS:
      dist = random(get_dist_min(), get_dist_max());
      break;

      case IMAGE:
      dist = random(get_dist_min(), get_dist_max());
      break;

      default:
      dist = random(get_dist_min(), get_dist_max());
      break;
    }
    set_focus(angle, dist);
  }

  private void update_pattern() {
    float ang = get_focus().get_angle() + this.offset_angle;
    float dx = sin(ang);
		float dy = cos(ang);
    float ratio = ceil(random(this.step));
    float dist = dist_impl();
    float seg_dist = get_dist() / this.step;

  	switch(this.algo) {
  		case MAD:
      pos.add(dx * this.step, dy * this.step);
			if(ref_pos.dist(pos) > get_dist_max()) {
      	pos.set(ref_pos);
      }
      break;

      case CIRCULAR:
      dist = seg_dist * ratio;
      pos.set(ref_pos.x() + (dx * dist), ref_pos.y() + (dy * dist));
      break;

      case POLYGON:
      // we add 3, because the fist polygon is a triangle from the begining to the end of human geometry HiStory... may be
      int summits = this.mode + 3;
      float [] summits_ang = new float[summits];
      float seg_ang = TAU / summits;
      for(int i = 0 ; i < summits_ang.length ; i++) {
        summits_ang[i] = seg_ang * i + this.offset_angle;
      }
      // where point must be project
      dist = seg_dist * ratio;
      int len = summits_ang.length;
      float ang_stop = 0;
      for(int i = 0; i < len ; i++) {
        float ang_start = summits_ang[i];
        int i2 = i + 1;
        if(i2 != len) ang_stop = summits_ang[i2];
        else ang_stop = TAU + this.offset_angle;
        if(ang >= ang_start && ang < ang_stop) {
          polygon_point(dx, dy, dist, ang_start, ang_stop);
          break;
        }
      }
      break;

      case LINE:
      float ang_line = get_bissector() + this.offset_angle;
      if(this.mode > 0) {
        float seg_fov = get_fov() / (this.mode + 1);
        seg_fov *= ratio;
        ang_line += seg_fov;
      }
      dx = sin(ang_line);
      dy = cos(ang_line);
      pos.set(ref_pos.x() + (dx * dist), ref_pos.y() + (dy * dist));
      break;

      case SPIRAL:
      float variance = random(this.iter/this.step, this.iter);
      float segment_fov = this.fov / variance;
      segment_fov *= (this.index * this.step);
      
      switch(this.mode) {
        case 0: 
        segment_fov = spiral_regular(segment_fov);
        break;

        case 1: 
        segment_fov = spiral_z(segment_fov);
        break;

        default:
        segment_fov = spiral_regular(segment_fov);
        break;
      }
      
      segment_fov += this.offset_angle;
      dx = sin(segment_fov);
      dy = cos(segment_fov);
      float buf_dist = get_dist_max();
      float segment = buf_dist / variance;
      segment *= this.index;
      segment /= this.step;
      pos.set(ref_pos.x() + (dx * segment), ref_pos.y() + (dy * segment));
      break;

			case CHAOS:
      pos.set(ref_pos.x() + (dx * dist), ref_pos.y() + (dy * dist));
      break;

      default:
      pos.set(ref_pos.x() + (dx * dist), ref_pos.y() + (dy * dist));
      break;
  	}
  }

  public void update_grid() {
    if(this.grid != null && !this.grid.equals(1) && use_grid_is) {
      int x = (int)x();
      int y = (int)y();
      if(x%this.grid.x() == 0 && y%this.grid.y() == 0) {
        pixel_is = true;
      } else {
        pixel_is = false;
      }
    } else {
      pixel_is = true;
    }
  }

  public void update(int index) {
    this.index = index;
    update_focus();  
    update_pattern();
    update_grid(); 
  }

  public void info() {
    print_out("MAD: mode : 0 > 0");
    print_out("CIRCULAR: mode : 0 > 0");
    print_out("POLYGON: mode : 0 > n, where the mode zero is the triangle");
    print_out("LINE: mode : 0 > n, where zero in first line. No step() available for the moment");
    print_out("SPIRAL: mode : 0 > 1");
    print_out("CHAOS: no mode() for the moment");
  }


  // algo
  private void polygon_point(float dx, float dy, float dist, float ang_start, float ang_stop) {
    // point on the circle
    vec2 a = new vec2(dx * dist, dy * dist);
    vec2 b = new vec2(0);
    R_Line2D l0 = new R_Line2D(pa,a,b);
    // first summit of polygon
    dx = sin(ang_start);
    dy = cos(ang_start);
    a.set(dx * dist, dy * dist);
    // second summit of polygon
    dx = sin(ang_stop);
    dy = cos(ang_stop);
    b.set(dx * dist, dy * dist);

    R_Line2D l1 = new R_Line2D(pa,a,b);
    if(l0 != null && l1 != null) {
      vec2 intersection = l0.intersection(l1);
      if(intersection != null) {
        pos.set(intersection);
      }
    }
    vec2 intersection = new vec2(l0.intersection(l1));
    pos.set(intersection.add(ref_pos));
  }

  private float spiral_z(float segment_fov) {
    int count = floor(segment_fov/this.fov);
    float div = TAU / this.fov + 0.001f;
    float mod = count%div;
    if(mod == 0) {
      in = true; 
    } else in = false;
    if(!in) {
      if(count%2 != 0) {
        segment_fov = this.fov - (segment_fov%this.fov);
      } else {
        segment_fov = segment_fov%this.fov;
      }
    }
    return segment_fov;
  }

  private float spiral_regular(float segment_fov) {
    int count = floor(segment_fov/this.fov);
    float div = TAU / this.fov;
    float mod = count%div;
    if(mod == 0) {
      in = true; 
    } else in = false;
    if(!in) {
      segment_fov = segment_fov%this.fov;
    }
    return segment_fov;
  }



  private float dist_impl() {
    float dist = this.focus.get_dist();
    if(step > 1) {
      float k = random(1);
      k = pow(k,get_step());
      dist *= k;
    }
    return dist;
  }
}