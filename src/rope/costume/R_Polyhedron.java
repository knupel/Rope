/**
* R_Polyhedron
* v 0.1.0
* 2019-2021
* @author @stanlepunk
* @see https://github.com/StanLepunK/Rope
*/
package rope.costume;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PGraphics;
import rope.core.R_Image;
import rope.vector.vec3;

public class R_Polyhedron extends R_Image {
	
	R_Polyhedron(PApplet pa) {
		super(pa);
	}

	R_Polyhedron(PApplet pa, PGraphics other) {
		super(pa, other);
	}

	void polyhedron(String type, int style, int size) {
		polyhedron(type,style,size,null);
	}

	void polyhedron(String type, int style, int size, PGraphics other) {
		//This is where the actual defining of the polyhedrons takes place
		if(vec_polyhedron_list != null) {
			//clear out whatever verts are currently defined
			vec_polyhedron_list.clear();
		} else {
			vec_polyhedron_list = new ArrayList<vec3>();
		}
		
		if(type.equals("TETRAHEDRON")) tetrahedron_poly(size);
		if(type.equals("CUBE")) cube(size);
		if(type.equals("OCTOHEDRON")) octohedron(size);
		if(type.equals("DODECAHEDRON"))dodecahedron(size);
		if(type.equals("ICOSAHEDRON")) icosahedron(size);
		if(type.equals("CUBOCTAHEDRON")) cuboctahedron(size);
		if(type.equals("ICOSI DODECAHEDRON")) icosi_dodecahedron(size);

		if(type.equals("TRUNCATED CUBE")) truncated_cube(size);
		if(type.equals("TRUNCATED OCTAHEDRON")) truncated_octahedron(size);
		if(type.equals("TRUNCATED DODECAHEDRON")) truncated_dodecahedron(size);
		if(type.equals("TRUNCATED ICOSAHEDRON")) truncated_icosahedron(size);
		if(type.equals("TRUNCATED CUBOCTAHEDRON")) truncated_cuboctahedron(size);
		
		if(type.equals("RHOMBIC CUBOCTAHEDRON")) rhombic_cuboctahedron(size);
		if(type.equals("RHOMBIC DODECAHEDRON")) rhombic_dodecahedron(size);
		if(type.equals("RHOMBIC TRIACONTAHEDRON")) rhombic_triacontahedron(size);
		if(type.equals("RHOMBIC COSI DODECAHEDRON SMALL")) rhombic_cosi_dodecahedron_small(size);
		if(type.equals("RHOMBIC COSI DODECAHEDRON GREAT")) rhombic_cosi_dodecahedron_great(size);
		
		if(style == LINE) {
			polyhedron_draw_line(type);
		} else if(style == POINT) {
			polyhedron_draw_point(type);
		} else if(style == VERTEX) { 
			polyhedron_draw_vertex(type);
		} else {
			polyhedron_draw_line(type);
		}
	}




	// POLYHEDRON DETAIL 
	//set up initial polyhedron
	float factor_size_polyhedron ;
	//some variables to hold the current polyhedron...
	ArrayList<vec3>vec_polyhedron_list;
	float edge_polyhedron_length;

	// FEW POLYHEDRON
	// BASIC
	void tetrahedron_poly(int size) {
		if(vec_polyhedron_list == null) vec_polyhedron_list = new ArrayList<vec3>();
		vec_polyhedron_list.add(new vec3(1,1,1));
		vec_polyhedron_list.add(new vec3(-1,-1,1));
		vec_polyhedron_list.add(new vec3(-1,1,-1));
		vec_polyhedron_list.add(new vec3(1,-1,-1));
		edge_polyhedron_length = 0 ;
		factor_size_polyhedron = size /2;
	}

	void cube(int size) {
		add_vertices(1, 1, 1);
		edge_polyhedron_length = 2;
		factor_size_polyhedron = size /2;
	}

	void octohedron(int size) {
		add_permutations(1, 0, 0);
		edge_polyhedron_length = ROOT2;
		factor_size_polyhedron = size *0.8f;
	}

	void dodecahedron(int size) {
		add_vertices(1, 1, 1);
		add_permutations(0, 1/PHI, PHI);
		edge_polyhedron_length = 2/PHI;
		factor_size_polyhedron = size /2.5f;
	}


	// SPECIAL
	void icosahedron(int size) {
		add_permutations(0,1,PHI);
		edge_polyhedron_length = 2.0f;
		factor_size_polyhedron = size /2.7f;
	}

	void icosi_dodecahedron(int size) {
		add_permutations(0,0,2*PHI);
		add_permutations(1,PHI,sq(PHI));
		edge_polyhedron_length = 2;
		factor_size_polyhedron = size/5;
	}

	void cuboctahedron(int size) {
		add_permutations(1,0,1);
		edge_polyhedron_length = ROOT2;
		factor_size_polyhedron = size /1.9f;
	}


// TRUNCATED
	void truncated_cube(int size) {
		add_permutations(ROOT2-1,1,1);
		edge_polyhedron_length = 2*(ROOT2-1);     
		factor_size_polyhedron = size /2.1f;
	}

	void truncated_octahedron(int size) {
		add_permutations(0,1,2);
		add_permutations(2,1,0);
		edge_polyhedron_length = ROOT2;
		factor_size_polyhedron = size/3.4f;
	}

	void truncated_cuboctahedron(int size) {
		add_permutations(ROOT2+1,2*ROOT2 + 1, 1);
		add_permutations(ROOT2+1,1,2*ROOT2 + 1);
		edge_polyhedron_length = 2;
		factor_size_polyhedron = size/6.9f;
	}

	void truncated_dodecahedron(int size) {
		add_permutations(0,1/PHI,PHI+2);
		add_permutations(1/PHI,PHI,2*PHI);
		add_permutations(PHI,2,sq(PHI));
		edge_polyhedron_length = 2*(PHI - 1);
		factor_size_polyhedron = size/6;
	}

	void truncated_icosahedron(int size) {
		add_permutations(0,1,3*PHI);
		add_permutations(2,2*PHI+1,PHI);
		add_permutations(1,PHI+2,2*PHI);
		edge_polyhedron_length = 2;
		factor_size_polyhedron = size/8;
	}

// RHOMBIC
	void rhombic_dodecahedron(int size) {
		add_vertices(1,1,1);
		add_permutations(0,0,2);
		edge_polyhedron_length = sqrt(3);
		factor_size_polyhedron = size /2.8f;
	}

	void rhombic_triacontahedron(int size) {
		add_vertices(sq(PHI), sq(PHI), sq(PHI));
		add_permutations(sq(PHI), 0, pow(PHI, 3));
		add_permutations(0,PHI, pow(PHI,3));
		edge_polyhedron_length = PHI*sqrt(PHI+2);
		factor_size_polyhedron = size /7.2f;
	}

	void rhombic_cuboctahedron(int size) {
		add_permutations(ROOT2 + 1, 1, 1);
		edge_polyhedron_length = 2;
		factor_size_polyhedron = size/4.2f;
	}

	void rhombic_cosi_dodecahedron_small(int size) {
		add_permutations(1, 1, pow(PHI,3));
		add_permutations(sq(PHI),PHI,2*PHI);
		add_permutations(PHI+2,0,sq(PHI));
		edge_polyhedron_length = 2;
		factor_size_polyhedron = size/7.4f;
	}

	void rhombic_cosi_dodecahedron_great(int size) {
		add_permutations(1/PHI,1/PHI,PHI+3);
		add_permutations(2/PHI,PHI,2*PHI+1);
		add_permutations(1/PHI, sq(PHI),3*PHI-1);
		add_permutations(2*PHI-1,2,PHI+2);
		add_permutations(PHI,3,2*PHI);
		edge_polyhedron_length = 2*PHI-2;
		factor_size_polyhedron = size/7.8f;
	}



//Built Tetrahedron
// EASY METHOD, for direct and single drawing
// classic and easy method
	// void polyhedron_draw_point(String name) {
	// 	polyhedron_draw_point(name,null);
	// }

	void polyhedron_draw_point(String name) {
		for (int i = 0 ; i < vec_polyhedron_list.size() ; i++) {
			vec3 point = vec_polyhedron_list.get(i);
			if(name.equals("TETRAHEDRON")) {
				tetrahedron_draw_point(point);
			} else {
				point(point.mult(factor_size_polyhedron));
			}
		}
	}


	// void polyhedron_draw_line(String name) {
	// 	polyhedron_draw_line(name,null);
	// }

	void polyhedron_draw_line(String name) {
		for (int i=0; i < vec_polyhedron_list.size(); i++) {
			for (int j = i+1; j < vec_polyhedron_list.size(); j++) {
				if (edge_is(i, j, vec_polyhedron_list) || edge_polyhedron_length == 0) {
					vec3 v1 = vec_polyhedron_list.get(i).copy();
					vec3 v2 = vec_polyhedron_list.get(j).copy();
					if(name.equals("TETRAHEDRON")) {
						tetrahedron_draw_line(v1, v2);
					} else {
						line(v1.mult(factor_size_polyhedron), v2.mult(factor_size_polyhedron));
					}
				}
			}
		}
	}



	void polyhedron_draw_vertex(String name) {
		// TETRAHEDRON
		if(name.equals("TETRAHEDRON")) {
			tetrahedron_draw_vertex();
		// OTHER POLYHEDRON
		} else {
			beginShape() ;
			for (int i= 0; i <vec_polyhedron_list.size(); i++) {
				for (int j= i +1; j <vec_polyhedron_list.size(); j++) {
					if (edge_is(i, j, vec_polyhedron_list) || edge_polyhedron_length == 0 ) {
						// vLine((PVector)vec_polyhedron_list.get(i), (PVector)vec_polyhedron_list.get(j));
						vec3 v1 = vec_polyhedron_list.get(i).copy();
						vec3 v2 = vec_polyhedron_list.get(j).copy();
						v1.mult(factor_size_polyhedron);
						v2.mult(factor_size_polyhedron);;
						vertex(v1);
						vertex(v2);
					}
				}
			}
			endShape(CLOSE);
		}
	}
// END of EASY METHOD and DIRECT METHOD





/**
annexe draw polyhedron
*/
	boolean edge_is(int vID1, int vID2, ArrayList<vec3> array_points) {
		//had some rounding errors that were messing things up, so I had to make it a bit more forgiving...
		int pres = 1000;
		vec3 v1 = array_points.get(vID1).copy();
		vec3 v2 = array_points.get(vID2).copy();
		float d = sqrt(sq(v1.x - v2.x) + sq(v1.y - v2.y) + sq(v1.z - v2.z)) + 0.00001f;
		return ((int)(d *pres)==(int)(edge_polyhedron_length *pres));
	}






// ADD POINTS for built POLYHEDRON
/////////////////////////////////
	void add_permutations(float x, float y, float z) {
		//adds vertices for all three permutations of x, y, and z
		add_vertices(x, y, z);
		add_vertices(z, x, y);
		add_vertices(y, z, x);
	}


 
	void add_vertices(float x, float y, float z) {
		//adds the requested vert and all "mirrored" verts
		vec_polyhedron_list.add (new vec3(x,y,z));
		// z
		if (z != 0.0) vec_polyhedron_list.add (new vec3(x,y,-z)); 
		// y
		if (y != 0.0) {
			vec_polyhedron_list.add (new vec3(x, -y, z));
			if (z != 0.0) vec_polyhedron_list.add(new vec3(x,-y,-z));
		} 
		// x
		if (x != 0.0) {
			vec_polyhedron_list.add (new vec3(-x, y, z));
			if (z != 0.0) vec_polyhedron_list.add(new vec3(-x,y,-z));
			if (y != 0.0) {
				vec_polyhedron_list.add(new vec3(-x, -y, z));
				if (z != 0.0) vec_polyhedron_list.add(new vec3(-x,-y,-z));
			}
		}
	}


/**
* tetrahedron
*/
	void tetrahedron_draw_point(vec3 point) {
		push();
		rotateX(TAU -1);
		rotateY(PI/4);
		point(point.mult(factor_size_polyhedron));
		pop();
	}


	void tetrahedron_draw_line(vec3 v1, vec3 v2) {
		push() ;
		rotateX(TAU -1);
		rotateY(PI/4);
		line(v1.mult(factor_size_polyhedron), v2.mult(factor_size_polyhedron));
		pop();
	}


	void tetrahedron_draw_vertex() {
  	push();
  	rotateX(TAU -1);
  	rotateY(PI/4) ;
  	int n = 4 ; // quantity of face of Tetrahedron
  	for(int i = 0 ; i < n ; i++) {
      // choice of each point
      int a = i ;
      int b = i+1 ;
      int c = i+2 ;
      if(i == n-2 ) c = 0 ;
      if(i == n-1 ) {
        b = 0 ;
        c = 1 ;
      }
      vec3 v1 = vec_polyhedron_list.get(a).copy();
      vec3 v2 = vec_polyhedron_list.get(b).copy();
      vec3 v3 = vec_polyhedron_list.get(c).copy();
      // scale the position of the points
      v1.mult(factor_size_polyhedron);
      v2.mult(factor_size_polyhedron);
      v3.mult(factor_size_polyhedron);
      
      // drawing
      beginShape();
      vertex(v1);
      vertex(v2);
      vertex(v3);
      endShape(CLOSE);
    }
    pop();
	}

}
