/**
* R_Icosahedron class
* v 0.0.2
* 2021-2021
* @author @stanlepunk
* @see https://github.com/StanLepunK/Rope
* @see https://processing.org/examples/icosahedra.html
* @see https://en.wikipedia.org/wiki/Icosahedron
*/

package rope.costume;

import rope.mesh.R_Face;

import java.util.ArrayList;

import processing.core.PApplet;
import rope.vector.vec3;

public class R_Icosahedron extends R_Shape {

	private vec3 top_point;
	private vec3[] top_pent = new vec3[5];
	private vec3[] bottom_pent = new vec3[5];
	private vec3 bottom_point;

	private vec3 ref_top_point;
	private vec3[] ref_top_pent = new vec3[5];
	private vec3[] ref_bottom_pent = new vec3[5];
	private vec3 ref_bottom_point;

	private float ref_radius;

	private int type = VERTEX;

  // constructor
  public R_Icosahedron(PApplet pa, float radius) {
		super(pa);
		set_summits(12);
		this.ref_radius = radius;
    size(radius);
    init();
		set_final_point(this.size.x());
  }

	/**
	 * update your shape, very importante in case you change the size of shape.
	 */
	public void update() {
		if(this.ref_radius != this.size.x()) {
			this.ref_radius = this.size.x();
			set_final_point(this.ref_radius);
		}
	}


	/**
	 * 
	 * @param type
	 * 
	 * Choice the type of display VERTEX, POINT or LINE
	 */
	public void type(int type) {
		this.type = type;
	}

	private void init_final_point() {
		top_point = ref_top_point.copy();
		bottom_point = ref_bottom_point.copy();
		for(int i = 0 ; i < top_pent.length ; i++) {
			top_pent[i] = ref_top_pent[i].copy();
			bottom_pent[i] = ref_bottom_pent[i].copy();
		}
	}

	private void set_final_point(float radius) {
		reset_final_point();
		top_point.mult(radius);
		bottom_point.mult(radius);
		for(int i = 0 ; i < top_pent.length ; i++) {
			top_pent[i].mult(radius);
			bottom_pent[i].mult(radius);
		}
	}

	private void reset_final_point() {
		top_point.set(ref_top_point);
		bottom_point.set(ref_bottom_point);
		for(int i = 0 ; i < top_pent.length ; i++) {
			top_pent[i].set(ref_top_pent[i]);
			bottom_pent[i].set(ref_bottom_pent[i]);
		}
	}

	private void init() {
		float step = 2*PI/5;
		float angle = 0;
    float dist = dist((float)Math.cos(0), (float)Math.sin(0), (float)Math.cos(step), (float)Math.sin(step));
		float a = (float)(Math.sqrt(((dist*dist) -1.0)));

    float tri_ht = (float)(Math.sqrt((dist*dist)-((dist/2)*(dist/2))));

    for (int i = 0; i < top_pent.length; i++){
			ref_top_pent[i] = new vec3((float)Math.cos(angle), (float)Math.sin(angle), tri_ht/2.0f);
      angle +=step;
    }
    ref_top_point = new vec3(0, 0, tri_ht/2.0f+a);
		// why this one must be converte in degrees ?????
    angle = 72.0f/2.0f;
    for (int i = 0; i < bottom_pent.length; i++){
			ref_bottom_pent[i] = new vec3((float)Math.cos(angle), (float)Math.sin(angle), -tri_ht/2.0f);
      angle +=step;
    }
		ref_bottom_point = new vec3(0, 0, -(tri_ht/2.0f+a));
		//
		init_final_point();
  }




  // draws icosahedron 
	public void show() {
		if(this.pos != null && this.pos.sum() != 0) {
			pushMatrix();
			
			translate(this.pos);
			rotateXYZ(this.angle);
		}
		// set_final_point(size.x());
		show_imp();
		// reset_final_point();
		if(this.pos != null && this.pos.sum() != 0) {
			popMatrix();
		}
	}

	private void show_imp() {
		if(type == POINT) {
			point(top_point);
			point(bottom_point);
			for(int i = 0 ; i < top_pent.length ; i++) {
				point(top_pent[i]);
				point(bottom_pent[i]);
			}
		} else {
			render_triangle();
		}
	}

  private void render_triangle() {
    for (int i=0; i < top_pent.length; i++){
      // icosahedron top
      if (i < top_pent.length-1){
				triangle_imp(top_pent[i], top_point, top_pent[i+1]);
      } else {
				triangle_imp(top_pent[i], top_point, top_pent[0]);
      }
      // icosahedron bottom   
      if (i< bottom_pent.length-1) {
				triangle_imp(bottom_pent[i], bottom_point, bottom_pent[i+1]);
      } else {
				triangle_imp(bottom_pent[i], bottom_point, bottom_pent[0]);
      }
    }
    // icosahedron body
    for (int i = 0; i < top_pent.length; i++){
      if (i < top_pent.length-2) {
				triangle_imp(top_pent[i], bottom_pent[i+1], bottom_pent[i+2]);
				triangle_imp(bottom_pent[i+2], top_pent[i], top_pent[i+1]);
      } else if (i == top_pent.length-2) {
				triangle_imp(top_pent[i], bottom_pent[i+1], bottom_pent[0]);
				triangle_imp(bottom_pent[0], top_pent[i], top_pent[i+1]);
      } else if (i == top_pent.length-1) {
				triangle_imp(top_pent[i], bottom_pent[0], bottom_pent[1]);
				triangle_imp(bottom_pent[1], top_pent[i], top_pent[0]);
      }
    }
  }

	/**
	 * 
	 * @return an ArrayList<vec3> of the normal direction of each faces of the shape
	 */
	public ArrayList<vec3> get_normals() {
		ArrayList<vec3> list = new ArrayList<vec3>();
		ArrayList<R_Face> list_faces = this.get_faces();
		for(R_Face face : list_faces) {
			vec3 center = face.barycenter();
			list.add(center);
		}
		return list;
	}

	/**
	 * 
	 * @return an ArrayList<R_Face> of the shape
	 */
	public ArrayList<R_Face> get_faces() {
		return get_faces(false);
	}

	/**
	 * 
	 * @return an ArrayList<R_Face> of the shape with normalize size aounr -1,1
	 */
	public ArrayList<R_Face> get_faces_normal() {
		return get_faces(true);
	}

	private ArrayList<R_Face> get_faces(boolean normal_is) {
		if(normal_is) {
			reset_final_point();
		}
		ArrayList<R_Face> list = new ArrayList<R_Face>();
		R_Face face = new R_Face(this.pa);
		for (int i = 0; i < top_pent.length; i++){
      // icosahedron top
      if (i < top_pent.length-1){
				face.set(top_pent[i], top_point, top_pent[i+1]);
				list.add(face.copy());
      } else {
				face.set(top_pent[i], top_point, top_pent[0]);
				list.add(face.copy());
      }
      // icosahedron bottom   
      if (i< bottom_pent.length-1) {
				face.set(bottom_pent[i], bottom_point, bottom_pent[i+1]);
				list.add(face.copy());
      } else {
				face.set(bottom_pent[i], bottom_point, bottom_pent[0]);
				list.add(face.copy());
      }
    }
    // icosahedron body
    for (int i = 0; i < top_pent.length; i++){
      if (i < top_pent.length-2) {
				face.set(top_pent[i], bottom_pent[i+1], bottom_pent[i+2]);
				list.add(face.copy());
				face.set(bottom_pent[i+2], top_pent[i], top_pent[i+1]);
				list.add(face.copy());
      } else if (i == top_pent.length-2) {
				face.set(top_pent[i], bottom_pent[i+1], bottom_pent[0]);
				list.add(face.copy());
				face.set(bottom_pent[0], top_pent[i], top_pent[i+1]);
				list.add(face.copy());
      } else if (i == top_pent.length-1) {
				face.set(top_pent[i], bottom_pent[0], bottom_pent[1]);
				list.add(face.copy());
				face.set(bottom_pent[1], top_pent[i], top_pent[0]);
				list.add(face.copy());
      }
    }
		if(normal_is) {
			set_final_point(size.x());
		}
		return list;
	}

	private void triangle_imp(vec3 a, vec3 b, vec3 c) {
		if(type == VERTEX) {
			triangle_vertex(a, b, c);
		} else if (type == LINE) {
			triangle_line(a, b, c);
		} else triangle_vertex(a, b, c);
	}

	private void triangle_line(vec3 a, vec3 b, vec3 c) {
		noFill();
		triangle(a, b, c);
	}

	private void triangle_vertex(vec3 a, vec3 b, vec3 c) {
		triangle(a, b, c);
	}

	// OVERWRITE METHOD P_SHAPE
	/**
	 * @return an Array of points in vec3 coord, it's a normalize point
	 */
	public vec3 [] get_ref_points() {
		if(this.ref_pts == null) {
			this.ref_pts = new vec3[summits];
			this.ref_pts[0] = new vec3(ref_top_point);
			this.ref_pts[1] = new vec3(ref_top_pent[0]);
			this.ref_pts[2] = new vec3(ref_top_pent[1]);
			this.ref_pts[3] = new vec3(ref_top_pent[2]);
			this.ref_pts[4] = new vec3(ref_top_pent[3]);
			this.ref_pts[5] = new vec3(ref_top_pent[4]);
			this.ref_pts[6] = new vec3(ref_bottom_pent[0]);
			this.ref_pts[7] = new vec3(ref_bottom_pent[1]);
			this.ref_pts[8] = new vec3(ref_bottom_pent[2]);
			this.ref_pts[9] = new vec3(ref_bottom_pent[3]);
			this.ref_pts[10] = new vec3(ref_bottom_pent[4]);
			this.ref_pts[11] = new vec3(ref_bottom_point);
		}
    return ref_pts;
  }

	/**
	 * @return an Array of points in vec3 coord
	 */
	public vec3 [] get_points() {
		if(this.pts == null) {
			this.pts = new vec3[summits];
			this.pts[0] = new vec3(top_point);
			this.pts[1] = new vec3(top_pent[0]);
			this.pts[2] = new vec3(top_pent[1]);
			this.pts[3] = new vec3(top_pent[2]);
			this.pts[4] = new vec3(top_pent[3]);
			this.pts[5] = new vec3(top_pent[4]);
			this.pts[6] = new vec3(bottom_pent[0]);
			this.pts[7] = new vec3(bottom_pent[1]);
			this.pts[8] = new vec3(bottom_pent[2]);
			this.pts[9] = new vec3(bottom_pent[3]);
			this.pts[10] = new vec3(bottom_pent[4]);
			this.pts[11] = new vec3(bottom_point);
		} else {
			this.pts[0].set(top_point);
			this.pts[1].set(top_pent[0]);
			this.pts[2].set(top_pent[1]);
			this.pts[3].set(top_pent[2]);
			this.pts[4].set(top_pent[3]);
			this.pts[5].set(top_pent[4]);
			this.pts[6].set(bottom_pent[0]);
			this.pts[7].set(bottom_pent[1]);
			this.pts[8].set(bottom_pent[2]);
			this.pts[9].set(bottom_pent[3]);
			this.pts[10].set(bottom_pent[4]);
			this.pts[11].set(bottom_point);
		}
    return pts;
  }

}
