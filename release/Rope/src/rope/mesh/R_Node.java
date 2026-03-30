/**
* R_Node
* v 0.3.3
* 2019-2022
* @author @knupel
* @see https://github.com/knupel/Rope
*/
package rope.mesh;

import java.util.ArrayList;

import rope.core.Rope;
import rope.vector.vec;
import rope.vector.vec3;
import rope.vector.ivec6;

public class R_Node extends Rope {
	private vec3 pos = new vec3();
	private ArrayList<vec3> dest_list;
	private int branch = 4;
	private ivec6 id = new ivec6(Integer.MIN_VALUE);

	public R_Node() {}


	public R_Node(vec3 pos) {
		this.pos.set(pos);
	}

	public R_Node(vec3 pos, vec3 from) {
		this.pos.set(pos);
		dest_list = new ArrayList<vec3>();
		dest_list.add(from);
	}

	

	////////////////
	// ID
	////////////////////////

	public ivec6 id() {
		return this.id;
	}

	public R_Node id(ivec6 id) {
		this.id = id.copy();
		return this;
	}

	public R_Node id(int a, int b, int c, int d, int e, int f) {
		this.id.set(a,b,c,d,e,f);
		return this;
	}

	public R_Node id_a(int id) {
		this.id.a(id);
		return this;
	}

	public R_Node id_b(int id) {
		this.id.b(id);
		return this;
	}

	public R_Node id_c(int id) {
		this.id.c(id);
		return this;
	}

	public R_Node id_d(int id) {
		this.id.d(id);
		return this;
	}

	public R_Node id_e(int id) {
		this.id.e(id);
		return this;
	}

	public R_Node id_f(int id) {
		this.id.f(id);
		return this;
	}

	
	////////////////////////////
	// COORD
	////////////////////////////

	/**
	 * use with precaution because it's a direct access to memory position
	 * @return
	 */
	public vec3 pointer() {
		return this.pos;
	}

	/**
	 * use with precaution because it's a direct access to memory position
	 * @param pos
	 */
	public void pointer(vec3 pos) {
		this.pos = pos;
	}

	public void pos(vec pos) {
		this.pos.set(pos);
	}

	public vec3 pos() {
		return this.pos.copy();
	}

	public void x(float x) {
		this.pos.x(x);
	}

	public float x() {
		return pos.x();
	}

	public void y(float y) {
		this.pos.y(y);
	}

	public float y() {
		return pos.y();
	}

	public void z(float z) {
		this.pos.z(z);
	}

	public float z() {
		return pos.z();
	}

	/////////////////////////
	// BRANCH
	//////////////////////////

	public void set_branch(int branch) {
		this.branch = branch;
	}


	public int get_branch() {
		return branch;
	}

	public int get_branch_available() {
		return branch - dest_list.size();
	}

	//////////////////
	// DESTINATION
	////////////////////

	public vec3 [] get_destination() {
		return dest_list.toArray(new vec3[dest_list.size()]);
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
	

	@Deprecated public void set_destination(vec3 dst) {
		if(dest_list.size() < branch) {
			dest_list.add(dst);
		} 
	}





	public R_Node copy() {
		R_Node node = new R_Node();
		if(dest_list != null) {
			node.dest_list = new ArrayList<vec3>(dest_list);
		}
		node.pos(this.pos);
		node.set_branch(this.branch);
		node.id(this.id);
		return node;
	}

	@Override
	public String toString() {
		return "POS [ " + this.pos.x() + ", " + this.pos.y() + ", " + this.pos.z() + " ] BRANCH(ES) ["+ this.branch +"]";
	}
}
