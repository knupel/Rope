package rope.mesh;

/**
 *   ___      ___   ____   _______
 *  | -  \   /   \  |    \ |  ___/
 *  | |/  | |   \ | | |\ | |  |__
 *  |    /  | | | | | |  / |  __/
 *  | |  \  \ \   / |  |/  |  |____
 *  |_| \_\  \___/  |_ |   |______/
 * 
 * Copyleft(l) 2022-2022 
 * Adaptation from Toxiclib by Stan le Punk / Stanislas Marçais
 * v 0.1.1
 * 
 * 
 *   __               .__       .__  ._____.           
 * _/  |_  _______  __|__| ____ |  | |__\_ |__   ______
 * \   __\/  _ \  \/  /  |/ ___\|  | |  || __ \ /  ___/
 *  |  | (  <_> >    <|  \  \___|  |_|  || \_\ \\___ \ 
 *  |__|  \____/__/\_ \__|\___  >____/__||___  /____  >
 *                   \/       \/             \/     \/ 
 *
 * Copyright (c) 2006-2011 Karsten Schmidt
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * http://creativecommons.org/licenses/LGPL/2.1/
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301, USA
 */

// JAVA
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import rope.vector.vec2;
// import rope.vector.ivec3;
import rope.vector.vec3;
import rope.core.BigBang;
import processing.core.*;



public class R_Voronoi extends BigBang {
	private static float DEFAULT_SIZE = 10000.0f;

	private R_Delaunay_Triangulation delaunay;
	private R_Delaunay_Triangle init_DT;

	private List<vec3> seeds_list = new ArrayList<vec3>();
	private List<R_Shape> areas_list = new LinkedList<R_Shape>();
	private List<R_Shape> triangles_list = new ArrayList<R_Shape>();

	private int ref_seeds = 0;
	private float size = 0;

	/**
	 * Constructor
	 * @param pa
	 */
	public R_Voronoi(PApplet pa) {
		this(pa, DEFAULT_SIZE);
	}

	/**
	 * Constructor
	 * @param pa
	 * @param size
	 */
	public R_Voronoi(PApplet pa, float size) {
		super(pa);
		this.size = size;
		init();
	}


	private void init() {
		this.init_DT = new R_Delaunay_Triangle(	new R_Delaunay_Vertex(-this.size, -this.size), 
																						new R_Delaunay_Vertex(this.size,	-this.size), 
																						new R_Delaunay_Vertex(0, this.size));
	}



		/**
	 * 
	 * @return the num of seeds
	 */
	public int size() {
		return seeds_list.size();
	}

	/**
	 * Is use to update the list of coordonate for areas and triangles
	 * the refresh happen when a point is added or remove.
	 */
	public void update() {
		update(true);
	}




	/**
	 * Add new seed to populate the voronoi diagram
	 * @param x coordinate
	 * @param y coordinate
	 * @param arg as int information, like color for example
	 */
	public void add_seed(float x, float y, int arg) {
		seeds_list.add(new vec3(x, y, arg));
	}

	public void add_seed(float x, float y) {
		seeds_list.add(new vec3(x,y,0));
	}

	public void add_seed(vec2 seed, int arg) {
		add_seed(seed.x(), seed.y(), arg);
	}

	public void add_seed(vec2 seed) {
		add_seed(seed.x(), seed.y());
	}

	/**
	 * it's important to figure the z information will be casted to int.
	 * see public void add_seed(float x, float y, int arg)
	 * @param seeds is vec3 the first and second argument of the vec3 (x,y) is for coordinate, and z is for information, you must figure this value shoulb be cast to int
	 * 
	 */
	public void add_seeds(vec3... seeds) {
		for (vec3 seed : seeds) {
			add_seed(seed.x(), seed.y(), (int)seed.z());
		}
	}

	public vec3 get_seed(int index) {
		if(index >= 0 && index < seeds_list.size()) {
			return seeds_list.get(index);
		}
		return null;
	}

	public List<vec3> get_seeds() {
		return seeds_list;
	}

	public void remove_seed(int index) {
		if(index >= 0 && index < size()) {
			seeds_list.remove(index);
		}
	}



	public R_Shape get_area(int index) {
		if(index >= 0 && index < areas_list.size()) {
			return areas_list.get(index);
		}
		return null;
	}

	/**
	 * 
	 * @return the list voronoi area, the area is discribe by cloud of vec2 points
	 */
	public List<R_Shape> get_areas() {
		return areas_list;
	}






	public R_Shape get_triangle(int index) {
		if(index >= 0 && index < triangles_list.size()) {
			return triangles_list.get(index);
		}
		return null;
	}
	/**
	 * 
	 * @return
	 */
	public List<R_Shape> get_triangles() {
		return triangles_list;
	}


	// BUILD
	/**
	 * 
	 * @param refresh_is is an other condition to refresh the list.
	 */
	public void update(boolean refresh_is) {
		if(ref_seeds != size() && refresh_is) {
			ref_seeds = size();
			build_delaunay();
			build_areas();
			build_triangles();
			// attribute id to area
			for(int i = 0 ; i < areas_list.size() ;i++) {
				for(int k = 0 ; k < seeds_list.size(); k++) {
					boolean is = in_polygon(areas_list.get(i).get_points(), seeds_list.get(k));
					if(is) {
						areas_list.get(i).id(k);
						break;
					}
				}
			}
		}
	}

	private void build_delaunay() {
		this.delaunay = new R_Delaunay_Triangulation(this.init_DT);
		int state = 0;
		int index = 0;
		for(vec3 seed : seeds_list) {
			state = delaunay.delaunay_area(new R_Delaunay_Vertex(seed.x(),seed.y()));
			if(state == -1) {
				remove_seed(index);
				break;
			}
			index++;
		}
	}

	private void build_areas() {
		areas_list.clear();
		int index = 0;
		HashSet<R_Delaunay_Vertex> done = new HashSet<R_Delaunay_Vertex>(this.init_DT);
		for(R_Delaunay_Triangle triangle : delaunay) {
			for(R_Delaunay_Vertex site : triangle) {
				if(done.contains(site)) {
					continue;
				}
				done.add(site);
				List<R_Delaunay_Triangle> list = delaunay.surroundingTriangles(site, triangle);
				R_Shape poly = new R_Shape(this.pa);
				for(R_Delaunay_Triangle tri : list) {
					R_Delaunay_Vertex circumeter = tri.getCircumcenter();
					float x = (float) circumeter.coord(0);
					float y = (float) circumeter.coord(1);
					poly.add_points(new vec2(x,y));
				}
				areas_list.add(poly);
			}
		}
	}

	private void build_triangles() {
		triangles_list.clear();
		for(R_Delaunay_Triangle t : delaunay) {
			R_Shape triangle = new R_Shape(this.pa);
			vec3 a = t.get(0).to_vec2().xyz();
			vec3 b = t.get(1).to_vec2().xyz();
			vec3 c = t.get(2).to_vec2().xyz();
			triangle.add_points(a,b,c);
			triangles_list.add(triangle);
		}
	}
}