/**
* R_Segment
* v 0.1.1
* 2019-2021
* @author Knupel / Stanislas Marçais
* @see https://github.com/StanLepunK/Rope
*/

package rope.mesh;

import rope.vector.vec;
import rope.vector.vec2;
import rope.vector.vec3;

public class R_Segment {
	private vec3 start;
	private vec3 stop;
	private int capacity;
	private boolean direction;

	public R_Segment() {
		this.start = new vec3();
		this.stop = new vec3();
	}


	public R_Segment(vec start, vec stop) {
		this.start = new vec3(start.x(),start.y(),start.z());
		this.stop = new vec3(stop.x(),stop.y(),stop.z());
	}

	// start
	public vec3 set_start(float x, float y, float z) {
		return this.start.set(x,y,z);
	}

	public vec3 set_start(float x, float y) {
		return this.start.set(x,y,0);
	}

	public vec3 set_start(float x) {
		return this.start.set(x,0,0);
	}

	public vec3 set_start(vec start) {
		return this.start.set(start.x(),start.y(),start.z());
	}

	public vec3 get_start() {
		return this.start;
	}

	// stop
	public vec3 set_stop(float x, float y, float z) {
		return this.stop.set(x,y,z);
	}

	public vec3 set_stop(float x, float y) {
		return this.stop.set(x,y,0);
	}

	public vec3 set_stop(float x) {
		return this.stop.set(x,0,0);
	}

	public vec3 set_stop(vec stop) {
		return this.stop.set(stop.x(),stop.y(),stop.z());
	}

	public vec3 get_stop() {
		return this.stop;
	}

	/**
	 * @deprecated instead use get_stop()
	 * @return vec3 coord
	 */
	@Deprecated vec3 get_end() {
		return this.stop;
	}

	// angle
	public float get_angle() {
		return start.xy().angle(stop.xy());
	}

	public float get_length() {
		return start.dist(stop);
	}

	// capacity
	public void set_capacity(int capacity) {
		this.capacity = capacity;
	}

	public int get_capacity() {
		return this.capacity;
	}

	// direction
	public void set_direction(boolean direction) {
		this.direction = direction;
	}

	public boolean get_direction() {
		return this.direction;
	}

	



	private vec2 line_intersection(R_Segment one, R_Segment two) {
		float x1 = one.get_start().x;
		float y1 = one.get_start().y;
		float x2 = one.get_end().x;
		float y2 = one.get_end().y;
		
		float x3 = two.get_start().x;
		float y3 = two.get_start().y;
		float x4 = two.get_end().x;
		float y4 = two.get_end().y;
		
		float bx = x2 - x1;
		float by = y2 - y1;
		float dx = x4 - x3;
		float dy = y4 - y3;
	 
		float b_dot_d_perp = bx * dy - by * dx;
	 
		if(b_dot_d_perp == 0) {
			return null;
		}
	 
		float cx = x3 - x1;
		float cy = y3 - y1;
	 
		float t = (cx * dy - cy * dx) / b_dot_d_perp;
		if(t < 0 || t > 1) return null;
	 
		float u = (cx * by - cy * bx) / b_dot_d_perp;
		if(u < 0 || u > 1) return null;
	 
		return new vec2(x1+t*bx, y1+t*by);
	}
	
	public vec2 meet_at(R_Segment target) {
		return line_intersection(this,target);
	}

	public boolean meet_is(R_Segment target) {
		if(meet_at(target) == null) {
			return false;
		} else {
			return true;
		}
	}


		/**
	 * copy() return all the component of vec
	 * 
	 * @return Vec2
	 */
	public R_Segment copy() {
		R_Segment segment = new R_Segment();
		segment.set_start(get_start());
		segment.set_stop(get_stop());
		segment.set_direction(get_direction());
		return segment;
	}

	@Override
	public String toString() {
		return "start: " + get_start() + ", stop:" + get_start() + ", direction:" + get_direction() + ", capacity:" + get_capacity();
	}
}