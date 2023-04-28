/**
 *   ___      ___   ____   _______
 *  | -  \   /   \  |    \ |  ___/
 *  | |/  | |   \ | | |\ | |  |__
 *  |    /  | | | | | |  / |  __/
 *  | |  \  \ \   / |  |/  |  |____
 *  |_| \_\  \___/  |_ |   |______/
 * 
* R_Puppet2D class
* v 0.0.4
* 2022-2023
* @author @knupel
* @see https://github.com/knupel/Rope/blob/master/src/rope/tool/R_Puppet2D.java
*/


package rope.tool;

import processing.core.*;

import java.util.ArrayList;

import rope.mesh.R_Line2D;
import rope.utils.R_Pair;
import rope.vector.bvec2;
import rope.vector.vec2;
import rope.vector.vec3;
import rope.vector.vec5;

public class R_Puppet2D extends R_Line2D {
	private ArrayList<R_Pair<vec3,vec5>> pair_list = new ArrayList<R_Pair<vec3,vec5>>();
	private ArrayList<vec3> list = new ArrayList<vec3>();
	private ArrayList<vec3> ref_list = new ArrayList<vec3>();

	private vec2 start_a;
	private vec2 start_b;
	public R_Puppet2D(PApplet pa) {
		super(pa);
		this.start_a = new vec2();
    this.start_b = new vec2();	
	}

	public R_Puppet2D(PApplet pa, vec2 a, vec2 b) {
		super(pa, a, b);
		this.start_a = new vec2();
    this.start_b = new vec2();	
	}

	public R_Puppet2D(PApplet pa, float ax, float ay, float bx, float by) {
		super(pa, ax, ay, bx, by);
		this.start_a = new vec2();
    this.start_b = new vec2();	
	}

	public void update() {
		bvec2 is = new bvec2(!a.equals(ref_a), !b.equals(ref_b));
		if(is.a()) {
			this.update_list_a();
			ref_a(a.xy());
		}
		if(is.b()) {
			this.update_list_b();
			ref_b(b.xy());
		}
	}

	private void update_list_a() {
		vec2 buf_start = start_a.xy().sub(start_b.xy());
		vec2 buf = a.xy().sub(b.xy());
		vec2 buf_ref = ref_a.xy().sub(ref_b.xy());
		float ang_buf = buf.angle();
		float ang_ref_buf = buf_ref.angle();
		float dif_ang = ang_ref_buf - ang_buf;
		R_Pair <vec3, vec3>pair = new R_Pair<vec3, vec3>(b, a);
		update_list_impl(pair, dif_ang, ang_buf, buf_start.angle());
	}

	private void update_list_b() {
		vec2 buf_start = start_b.xy().sub(start_a.xy());
		vec2 buf = b.xy().sub(a.xy());
		vec2 buf_ref = ref_b.xy().sub(ref_a.xy());
		float ang_buf = buf.angle();
		float ang_ref_buf = buf_ref.angle();
		float dif_ang = ang_ref_buf - ang_buf;
		R_Pair <vec3, vec3>pair = new R_Pair<vec3, vec3>(a, b);
		update_list_impl(pair, dif_ang, ang_buf, buf_start.angle());
	}
	
	private void update_list_impl(R_Pair <vec3, vec3>pair, float dif_ang, float ang_buf, float ang_buf_start) {
		vec3 first = pair.a();
		vec3 second = pair.b();
		for(int i = 0 ; i < list.size() ; i++) {
			vec3 p = list.get(i);
			vec3 ref_p = ref_list.get(i);
			vec2 buf_p = ref_p.xy().sub(first.xy());
			float ang_buf_p = buf_p.angle();
			float new_ang = ang_buf_p + dif_ang + ang_buf - ang_buf_start;
			float dist_p = dist(ref_p,second);
			vec2 new_pos = new vec2(projection(new_ang, dist_p));
			new_pos = add(new_pos, first.xy());
			p.set(new_pos.xyz());
		}
	}

	public int size() {
		return pair_list.size();
	}

	public void clear() {
		list.clear();
		ref_list.clear();
		pair_list.clear();
	}



	//////////////////////////
	// OVERWRITE METHOD
	/////////////////////////

  public void set_a(float x, float y) {
    this.a(x,y);
    this.ref_a(x,y);
    this.start_a(x,y);;
  }

	public void set_b(float x, float y) {
    this.b(x,y);
    this.ref_b(x,y);
    this.start_b(x,y);
  }

	private void start_a(float x, float y) {
    this.start_a.set(x,y);
  }
  
  private void start_b(float x, float y) {
    this.start_b.set(x,y);
  }




  //////////////////////////////
  // PUPPET
  /////////////////////////////////

	public void add_puppets(vec3... children) {
		for(int i = 0 ; i < children.length ; i++) {
			vec5 data = new vec5();
			set_data_puppet(children[i], data);
			R_Pair<vec3,vec5> pair = new R_Pair<vec3,vec5>(children[i], data);
			vec2 vp = projection_impl(pair);
			if(!pair.a().xy().compare(vp,0.1f)) {
				pair.b().e(-1);
			}
			pair_list.add(pair);
		}
	}

	private void set_data_puppet(vec3 src, vec5 data) {
		float norm = 0;
		float dist = 0;
		float ang = 0;
		vec2 clock = new vec2(1);
		vec2 proj = this.ortho(src.xy());
		norm = this.normal(proj);
		dist = proj.dist(src.xy());
		ang = data_impl(src.xy(), proj, clock).a();
		data.set(norm, dist, ang, clock.a(), clock.b());
	}

	public void update_puppets() {
		for(int i = 0 ; i < pair_list.size() ; i++) {
			R_Pair<vec3,vec5> pair = pair_list.get(i);
			vec2 clock = get_puppet_clock(i);
			vec2 src = get_puppet_origin(i);
			vec2 proj = this.ortho(src);
			R_Pair <Float,vec2> ret = data_impl(src, proj, clock);
			float ang = ret.a();
			clock.set(ret.b());
			pair.b().c(ang);
			pair.b().d(clock.x());
		}
	}

	private R_Pair<Float,vec2> data_impl(vec2 point, vec2 proj, vec2 clock) {
		float ang = 0.0f;
		float ang_proj_point = proj.angle(point);
		float ang_a_b = this.a().angle(this.b());
		float ang_pts_a = point.angle(this.a());
		float border_value = ang_a_b - ang_pts_a;
		bvec2 zero_is = new bvec2();
		bvec2 pi_is = new bvec2();
		zero_is.x(border_value >= 0);
		zero_is.y(border_value < 0);
		pi_is.x(border_value <= PI);
		pi_is.y(border_value <= -PI);

		if(all(zero_is.x(),pi_is.x()) || pi_is.y()) {
			clock.x(-1 * clock.y());
		} else {
			clock.x(1 * clock.y());
		}

		ang = (ang_proj_point - ang_a_b) + ang_a_b;
		if(clock.x() == -1) {
			ang += PI;
		}
		R_Pair <Float, vec2> buf = new R_Pair<Float, vec2>(ang,clock);
		return buf;
	}

	/////////////////////////:
	// GETTER
	/////////////////////////

	public ArrayList<R_Pair<vec3,vec5>> get_puppets() {
		return pair_list;
	}

	public R_Pair<vec3,vec5> get_puppet(int index) {
		if(index >= 0 && index < pair_list.size()) {
			return pair_list.get(index);
		}
		return null;
	}

	public Float get_puppet_normal(int index) {
		if(index >= 0 && index < pair_list.size()) {
			R_Pair<vec3,vec5> pair = this.get_puppet(index);
			return pair.b().a();
		}
		return Float.NaN;
	}

	public Float get_puppet_distance(int index) {
		if(index >= 0 && index < pair_list.size()) {
			R_Pair<vec3,vec5> pair = this.get_puppet(index);
			return pair.b().b();
		}
		return Float.NaN;
	}

	public Float get_puppet_angle(int index) {
		if(index >= 0 && index < pair_list.size()) {
			R_Pair<vec3,vec5> pair = this.get_puppet(index);
			return pair.b().c();
		}
		return Float.NaN;
	}

	public vec2 get_puppet_clock(int index) {
		if(index >= 0 && index < pair_list.size()) {
			R_Pair<vec3,vec5> pair = this.get_puppet(index);
			float clock = pair.b().d();
			float clock_ref = pair.b().e();
			return new vec2(clock, clock_ref);
		}
		return null;
	}

	public vec2 get_puppet_online(int index) {
		if(index >= 0 && index < pair_list.size()) {
			R_Pair<vec3,vec5> pair = this.get_puppet(index);
			float normal_pos = pair.b().x();
			return this.get_point(normal_pos);
		}
		return null;
	}

	public vec2 get_puppet_origin(int index) {
		if(index >= 0 && index < pair_list.size()) {
			R_Pair<vec3,vec5> pair = this.get_puppet(index);
			return pair.a().xy();
		}
		return null;
	}

	public vec2 get_puppet_projection(int index) {
		if(index >= 0 && index < pair_list.size()) {
			R_Pair<vec3,vec5> pair = this.get_puppet(index);
			return projection_impl(pair);
		}
		return null;
	}

	private vec2 projection_impl(R_Pair<vec3,vec5> pair) {
		vec5 data = pair.b();
		float vpx = cos(data.z())* data.y();
		float vpy = sin(data.z())* data.y();
		vec2 vp = new vec2(vpx,vpy);
		return vp.add(this.get_point(data.x()));
	}


	  /**
   * 
   * @return copy of herself, maybe this one can be bugged because the ref is not copy
   */
  public R_Puppet2D copy() {
    R_Puppet2D puppet = new R_Puppet2D(this.pa);
    copy_impl(puppet);
		// maybe need copy this part too in the future ??????
		// ???????????????????
		// private ArrayList<R_Pair<vec3,vec5>> pair_list = new ArrayList<R_Pair<vec3,vec5>>();
		// private ArrayList<vec3> list = new ArrayList<vec3>();
		// private ArrayList<vec3> ref_list = new ArrayList<vec3>();
		// private vec2 start_a;
		// private vec2 start_b;
    return puppet;
  }
}
