/**
* R_Virus class
* v 0.1.0
* 2019-2019
* @author @stanlepunk
* @see https://github.com/StanLepunK/Rope
* Class R_Virus is strange stuff with angle broken !!!!
*/
package rope.costume;

import rope.core.R_Constants;
import rope.vector.*;
import processing.core.PApplet;

public class R_Virus extends R_Shape implements R_Constants, R_Shape_contract  {
	vec3 [][] branch;
	int node = 4;
	int num = 4;
	int mutation = 4;

	float angle = 0 ;
	public R_Virus(PApplet pa) {
		super(pa);
		pos(0);
		size(1);
		build();
	}

  // set
	public void build() {
		branch = new vec3 [node][num] ;
		for(int i = 0 ; i < node ; i++) {
			for(int k = 0 ; k < num ; k++) {
				vec3 dir = new vec3().rand(-1,1);
				branch[i][k] = projection(dir) ;
			}
		}
	}


	public void set_node(int node) {
		this.node = node;
		build();
	}

	public void set_summits(int num) {
		this.num = num;
		build();
	}

	public void set_mutation(int mutation) {
		this.mutation = mutation;
	}
  

  // get
	public int get_mutation() {
		return this.mutation;
	}

	public int get_node() {
		return this.node;
	}

	public int get_summits() {
		return this.num;
	}


  // method
	public void reset() {
		for(int i = 0 ; i < node ; i++) {
			for(int k = 0 ; k < num ; k++) {
				vec3 dir = new vec3().rand(-1,1);
				branch[i][k].set(projection(dir));
			}
		}
	}
  
  // set
  public void rotation(float angle) {
  	this.angle = angle ;
  	// System.err.println("Virus rotation() don't work must be coded for the future") ;
  }

	public vec2 angle(float angle) {
		return to_cartesian_2D(angle);
	}
	
  // SHOW
	public void show() {
		vec3 radius = size.mult((float).5);
		if(angle != 0) {
			pushMatrix();
			translate(pos);
			rotate(angle);
		}
		for(int k = 0 ; k < num ; k++) {
			if(node == 2) {
				vec3 final_pos_a = branch[0][k].copy();
				final_pos_a.add(angle(angle));
				final_pos_a.mult(radius);
				if(angle == 0) final_pos_a.add(pos);

				vec3 final_pos_b = branch[1][k].copy();
				final_pos_b.mult(radius) ;
				if(angle == 0) final_pos_b.add(pos);
				line(final_pos_a, final_pos_b);
			} else if( node > 2) {
				beginShape();
				vec3 first_point = branch[0][k].copy().mult(radius);
				if(angle == 0) first_point.add(pos);
				vertex(first_point);
				for(int m = 1 ; m < node ; m++) {
					vec3 final_pos = branch[m][k].copy();
					final_pos.mult(radius);
					if(angle == 0) final_pos.add(pos);
					vertex(final_pos);
				}
				vertex(first_point);
				endShape();
			} else {
				vec3 final_pos = branch[0][k].copy();
				//final_pos.add(angle(angle));
				final_pos.mult(radius);
				if(angle == 0) final_pos.add(pos);
				point(final_pos);
			}
		}
		if(angle != 0) popMatrix();
	}
  
  // get
	public vec3 [][] get() {
		return branch;
	}
}
