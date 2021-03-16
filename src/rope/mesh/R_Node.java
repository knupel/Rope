/**
* R_Node
* v 0.1.0
* 2019-2021
* @author @stanlepunk
* @see https://github.com/StanLepunK/Rope
*/
package rope.mesh;

import java.util.ArrayList;

import rope.core.BigBang;
import rope.vector.vec3;

public class R_Node extends BigBang {
	private vec3 pos;
	private ArrayList<vec3> dest_list;
	private int branch = 4;
	private int id;

	public R_Node() {}


	public R_Node(vec3 pos) {
		this.id = (int)random(MAX_INT);
		this.pos = pos;
	}

	public R_Node(vec3 pos, vec3 from) {
		this.id = (int)random(MAX_INT);
		this.pos = pos;
		dest_list = new ArrayList<vec3>();
		dest_list.add(from);
	}

	
	public R_Node copy() {
		R_Node node = new R_Node();
		if(dest_list != null) {
			node.dest_list = new ArrayList<vec3>(dest_list);
		}
		node.pos(this.pos);
		node.set_branch(branch);
		node.set_id(id);
		return node;
	}




	public boolean add_destination(vec3 dst) {
		if(dest_list.size() < branch && !all(equal(pos(), new vec3(dst)))) {
			boolean equal_is = false;
			vec3 [] list = get_destination();
			for(int i = 0 ; i < list.length ; i++) {
				if(all(equal(list[i], new vec3(dst)))) {
					equal_is = true;
				}
			}
			if(!equal_is) {
				dest_list.add(new vec3(dst));
			}
			return !equal_is;
		} else {
			return false;
		}
	}
	
	// set
	public void set_destination(vec3 pos) {
		if(dest_list.size() < branch) {
			dest_list.add(pos);
		} 
	}

	public void set_id(int id) {
		this.id = id;
	}
	
	public void set_branch(int branch) {
		this.branch = branch;
	}

	public void pos(vec3 pos) {
		if(pos == null) {
			this.pos = new vec3();
		}	else {
			this.pos = pos;
		}
	}

	public void x(float x) {
		if(this.pos != null) {
			this.pos.x(x);
		} else {
			this.pos = new vec3(x,0,0);
		}
	}

	public void y(float y) {
		if(this.pos != null) {
			this.pos.y(y);
		} else {
			this.pos = new vec3(0,y,0);
		}
	}

	public void z(float z) {
		if(this.pos != null) {
			this.pos.z(z);
		} else {
			this.pos = new vec3(0,0,z);
		}
	}

	// get
	public int get_id() {
		return id;
	}

	public int get_branch() {
		return branch;
	}

	public int get_branch_available() {
		return branch - dest_list.size();
	}

	public vec3 [] get_destination() {
		return dest_list.toArray(new vec3[dest_list.size()]);
	}

	public vec3 pos() {
		return pos.xyz();
	}

	public vec3 pointer() {
		return pos;
	}

	public float x() {
		return pos.x();
	}

	public float y() {
		return pos.y();
	}

	public float z() {
		return pos.z();
	}
}
