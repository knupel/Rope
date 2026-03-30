/**
* R_Plane
* v 0.1.1
* 2019-2022
* @author @knupel
* @see https://github.com/knupel/Rope
*/
package rope.mesh;

import java.util.ArrayList;
import rope.core.Rope;
import rope.vector.vec3;

public class R_Plane extends Rope {
  private vec3 plane;
	private vec3 a;
	private float range = 1;
	private boolean debug = false;
	private ArrayList<R_Node> nodes;

	public R_Plane() {}

	public R_Plane(vec3 a, vec3 b, vec3 c) {
		this.a = a;
		this.plane = get_plane_normal(a,b,c);
	}

	public void set(vec3 a, vec3 b, vec3 c) {
		this.a = a;
		this.plane = get_plane_normal(a,b,c);
	}

	public void set_range(float range) {
		this.range = range;
	}

	public vec3 get_plane_normal(vec3 a, vec3 b, vec3 c) {
		return (sub(a,c).cross(sub(b,c))).normalize();
	}

	public float get_range() {
		return range;
	}

	public ArrayList<R_Node> get_nodes() {
		if(nodes != null) {
			return nodes;
		} else {
			return null;
		}
	}

	private boolean in_plane(vec3 any, float range) {
		// Calculate nearest distance between the plane represented by the vectors
		// a,b and c, and the point any
		float d = plane.x()*any.x() + plane.y()*any.y() + plane.z()*any.z() - plane.x()*a.x() - plane.y()*a.y() - plane.z()*a.z();
		// A perfect result would be d == 0 but this will not hapen with realistic
		// float data so the smaller d the closer the point. 
		// Here I have decided the point is on the plane if the distance is less than 
		// range unit.
		return Math.abs(d) < range; 
	}

	public void debug(boolean debug) {
		this.debug = debug;
	}

  public boolean debug_is() {
    return this.debug;
  }

	public void clear() {
		if(nodes != null) {
			nodes.clear();
		}
	}

	public int size() {
		if(nodes != null) {
			return nodes.size();
		} else {
			return -1;
		}
	}

	public void add(R_Node any) {
		if(in_plane(any.pos(),range)) {
			if(nodes == null) {
				nodes = new ArrayList<R_Node>();
			} 
			nodes.add(any);
		} else if(debug) {
			System.err.println("class R_Plane method add(): argument (R_Node any) not in the plane");
		}
	}

}
