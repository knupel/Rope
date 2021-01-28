/**
* R_Primitive class
* v 0.3.1
* 2019-2019
* @author @stanlepunk
* @see https://github.com/StanLepunK/Rope
* Class RPrimitive store the utilities to draw shape and costume
*/
package rope.costume;

import rope.vector.*;
import rope.core.*;
import processing.core.*;

public class R_Primitive extends R_Shape implements R_Constants, R_Shape_contract  {
	private boolean init;
	private vec2 dir;
	private float angle_ref_x;
	/**
	 * 
	 * @param pa
	 */
	public R_Primitive(PApplet pa) {
		super(pa);
		pos(0);
		size(1);
	}
	
	/**
	 * 
	 * @param pa
	 * @param summits
	 */
	public R_Primitive(PApplet pa, int summits) {
		super(pa);
		this.summits = summits;
		pos(0);
		size(1);
		calc();
	}
	
	/**
	 * 
	 * @param pa
	 * @param summits
	 * @param angle
	 */
	public R_Primitive(PApplet pa, int summits, float angle) {
		super(pa);
		angle_x(angle);
		this.summits = summits;
		pos(0);
		size(1);
		calc();
	}
	
	/**
	 * 
	 * @param pa
	 * @param summits
	 * @param angle
	 * @param dir
	 */
	public R_Primitive(PApplet pa, int summits, float angle, vec2 dir) {
		super(pa);
		angle_x(angle);
		this.summits = summits;
		if (this.dir == null) {
			this.dir = new vec2(dir);
		} else {
			this.dir.set(dir);
		}
		pos(0);
		size(1);
		calc();
	}
	
	/**
	 * 
	 * @param pa
	 * @param summits
	 * @param other
	 */
	public R_Primitive(PApplet pa, int summits, PGraphics other) {
		super(pa, other);
		this.summits = summits;
		pos(0);
		size(1);
		calc();
	}
	
	/**
	 * 
	 * @param pa
	 * @param summits
	 * @param angle
	 * @param other
	 */
	public R_Primitive(PApplet pa, int summits, float angle, PGraphics other) {
		super(pa, other);
		angle_x(angle);
		this.summits = summits;
		pos(0);
		size(1);
		calc();
	}
	
	/**
	 * 
	 * @param pa
	 * @param summits
	 * @param angle
	 * @param dir
	 * @param other
	 */
	public R_Primitive(PApplet pa, int summits, float angle, vec2 dir, PGraphics other) {
		super(pa, other);
		angle_x(angle);
		this.summits = summits;
		if (this.dir == null) {
			this.dir = new vec2(dir);
		} else {
			this.dir.set(dir);
		}
		pos(0);
		size(1);
		calc();
	}
	
	/**
	 * 
	 * @return
	 */
	public vec3[] get_normal() {
		return pts;
	}
	
	/**
	 * 
	 * @return
	 */
	public vec3[] get() {
		vec3[] temp = new vec3[pts.length];
		vec3 radius = size.mult((float).5);
		for (int i = 0; i < temp.length; i++) {
			temp[i] = pts[i].copy();
			if (temp.length == 2) {
				temp[i].mult(radius).add(pos);
			} else {
				temp[i].mult(radius).add(pos);
			}
		}
		return temp;
	}

	/**
	 * 
	 * @return
	 */
	public vec2 get_dir() {
		return dir;
	}
	
	





	// Primitive with vec method and angle to display
	/**
	 * 
	 */
	private void calc() {
		if (!init || this.summits != summits || angle_x() != angle_ref_x) {
			this.summits = summits;
			angle_ref_x = angle_x();
			build();
			init = true;
		}
	}

	/**
	 * build all the point if necessary, that increase the speed rendering
	 */
	public void build() {
		// security for the sinple, null or negative point quantity
		if (this.summits < 2) {
			this.summits = 2;
		}

		pts = new vec3[this.summits];
		// create coord of the shape
		if (this.summits == 2 && angle_x() == 0) {
			pts[0] = new vec3((float) -.5, 0, 0);
			pts[1] = new vec3((float) .5, 0, 0);
		} else {
			for (int i = 0; i < this.summits; i++) {
				pts[i] = polygon_2D(this.summits, angle_x())[i].copy();
			}
		}
	}

	/**
	 * main SHOW primitive the line rendering is awful, very very low when there is
	 * a lot of shape, may be the compute on polygon_2D() is guilty
	 */
	public void show() {
		vec3 radius = this.size.copy().mult((float).5);
		// boolean check_line = false;

		vec3[] temp_pos = new vec3[pts.length];
		for (int i = 0; i < temp_pos.length; i++) {
			temp_pos[i] = pts[i].copy();
		}

		if (temp_pos.length == 2) {
			for (int i = 0; i < temp_pos.length; i++) {
				temp_pos[i].mult(radius).add(this.pos);
			}
			line(temp_pos[0], temp_pos[1]);
		} else if (temp_pos.length == 3) {
			// faster method to display a lot of triangle
			for (int i = 0; i < temp_pos.length; i++) {
				temp_pos[i].mult(radius).add(this.pos);
			}
			triangle(temp_pos[0], temp_pos[1], temp_pos[2]);
		} else if (temp_pos.length == 4) {
			// faster method to display a lot of rect
			rectMode(CENTER);
			float side = radius.x() * ROOT2;
			square(this.pos.x, this.pos.y, side);
		} else {
			beginShape();
			for (int i = 0; i < temp_pos.length; i++) {
				if (temp_pos[i] != null) {
					vertex(temp_pos[i].xyz().mult(radius).add(this.pos));
				}
			}
			// to close the shape without method endShape(CLOSE);
			if (temp_pos[0] != null) {
				vertex(temp_pos[0].xyz().mult(radius).add(this.pos));
			}
			endShape();
		}
	}

	/**
	 * POLYGON 2D v 0.1.0
	 */
	/**
	 * 
	 * @param num
	 * @return
	 */
	public vec3[] polygon_2D(int num) {
		float new_orientation = 0;
		return polygon_2D(num, new_orientation);
	}

	/**
	 * main method
	 * @param num
	 * @param new_orientation
	 * @return
	 */
	public vec3[] polygon_2D(int num, float new_orientation) {
		vec3[] p = new vec3[num];
		// choice your starting point
		float start_angle = (float)(PI * .5 + new_orientation);
		if (num == 4) {
			start_angle = (float)(PI * .25 + new_orientation);
		}
		// calcul the position of each summit, step by step
		for (int i = 0; i < num; i++) {
			p[i] = compute_coord_polygon_2D(i, num, start_angle).copy();
		}
		return p;
	}

	public vec3 compute_coord_polygon_2D(int target, int num, float start_angle) {
		float step_angle = map(target, 0, num, 0, TAU);
		float orientation = TAU - step_angle - start_angle;
		vec2 temp_orientation_xy = to_cartesian_2D(orientation);
		float x = temp_orientation_xy.x;
		float y = temp_orientation_xy.y;
		float z = 0;
		return new vec3(x,y,z);
	}

	/**
	 * POLYGON 3D but must be refactoring because the metod is a little shitty !!!!!
	 */
	// polygon with 3D direction in cartesian world
	/**
	 * 
	 * @param num
	 * @param new_orientation
	 * @param dir
	 * @return
	 */
	public vec3[] polygon_3D(int num, float new_orientation, vec3 dir) {
		vec3 pos = new vec3();
		int radius = 1;
		return polygon_3D(pos, radius, num, new_orientation, dir);
	}

	/**
	 * Inspirated by : Creating a polygon perpendicular to a line segment Written by
	 * Paul Bourke February 1997
	 * 
	 * @see http://paulbourke.net/geometry/circlesphere/
	 */
	/**
	 * 
	 * @param pos
	 * @param radius
	 * @param num
	 * @param new_orientation
	 * @param dir
	 * @return
	 */
	public vec3[] polygon_3D(vec3 pos, float radius, int num, float new_orientation, vec3 dir) {

		vec3 p1 = dir.copy();
		vec3 p2 = to_cartesian_3D(PI, PI);
		vec3 support = to_cartesian_3D(PI, PI);
		/*
		 * vec3 p2 = vec3(0,0,1) ; vec3 support = vec3 (1,0,0) ;
		 */
		// prepare the vector direction
		vec3 r = new vec3();
		vec3 s = new vec3();
		vec3 p2_sub_p1 = sub(p1,p2);

		r = cross(p2_sub_p1,support);
		s = cross(p2_sub_p1,r);
		r.dir();
		s.dir();

		// prepare polygone in 3D world
		vec3 plane = new vec3();
		int num_temp = num + 1;
		vec3[] p;
		p = new vec3[num_temp];

		// init vec3 p
		for (int i = 0; i < num_temp; i++)
			p[i] = new vec3();

		// create normal direction for the point
		float theta, delta;
		delta = TAU / num;
		int step = 0;
		for (theta = 0; theta < TAU; theta += delta) {
			plane.x = (float) (p1.x + r.x * Math.cos(theta + delta) + s.x * Math.sin(theta + delta));
			plane.y = (float) (p1.y + r.y * Math.cos(theta + delta) + s.y * Math.sin(theta + delta));
			plane.z = (float) (p1.z + r.z * Math.cos(theta + delta) + s.z * Math.sin(theta + delta));
			/**
			 * plane is not a normal value, it's big problem :(((((((
			 */
			plane.mult(radius);
			plane.add(pos);
			// write summits
			p[step] = plane.copy();
			step++;
		}
		return p;
	}

}
