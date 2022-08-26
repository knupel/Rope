package rope.mesh;

/**
 *   ___      ___   ____   _______
 *  | -  \   /   \  |    \ |  ___/
 *  | |/  | |   \ | | |\ | |  |__
 *  |    /  | | | | | |  / |  __/
 *  | |  \  \ \   / |  |/  |  |____
 *  |_| \_\  \___/  |_ |   |______/
 * 
 * Copyleft(l) Adaptation from Toxiclib by Stan le Punk 
 * v 0.1.0
 * 2022-2022
 * 
 * 
 * https://www.cs.cornell.edu/info/people/chew/Delaunay.html
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
//ROPE
import rope.costume.R_Shape;
import rope.vector.vec2;
import rope.vector.vec3;
import rope.core.BigBang;
import processing.core.*;



public class R_Voronoi extends BigBang {
	private static float DEFAULT_SIZE = 10000.0f;

	protected R_Delaunay_Triangulation delaunay;
	protected R_Delaunay_Triangle init_DT;
	protected List<vec2> seeds_list = new ArrayList<vec2>();


	private List<R_Shape> regions = new LinkedList<R_Shape>();
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
	 * 
	 * @return the num of seeds
	 */
	public int size() {
		return seeds_list.size();
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
	 * Is use to update the list of coordonate for areas and triangles
	 * the refresh happen when a point is added or remove.
	 */
	public void update() {
		update(true);
	}

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
		}
	}


	/**
	 * Add new seed to populate the voronoi diagram
	 * @param x
	 * @param y
	 */
	public void add_seed(float x, float y) {
		seeds_list.add(new vec2(x,y));
	}

	public void add_seed(vec2 seed) {
		add_seed(seed.x(), seed.y());
	}

	public void add_seeds(vec2... seeds) {
		for (vec2 seed : seeds) {
			add_seed(seed.x(), seed.y());
		}
	}

	public List<vec2> get_seeds() {
		return seeds_list;
	}


	public void remove_seed(int index) {
		if(index >= 0 && index < size()) {
			seeds_list.remove(index);
		}
	}


	/**
	 * 
	 * @return the list voronoi area, the area is discribe by cloud of vec2 points
	 */
	public List<R_Shape> get_areas() {
		return regions;
	}





	/**
	 * 
	 * @return
	 */
	public List<R_Shape> get_triangles() {
		return triangles_list;
	}


	// BUILD
	private void build_delaunay() {
		// init();
		this.delaunay = new R_Delaunay_Triangulation(this.init_DT);
		for(vec2 seed : seeds_list) {
			delaunay.delaunay_area(new R_Delaunay_Vertex(seed.x(),seed.y()));
		}
	}

	private void build_areas() {
		regions.clear();
		HashSet<R_Delaunay_Vertex> done = new HashSet<R_Delaunay_Vertex>(this.init_DT);
		for (R_Delaunay_Triangle triangle : delaunay) {
			for (R_Delaunay_Vertex site : triangle) {
				if (done.contains(site)) {
					continue;
				}
				done.add(site);
				List<R_Delaunay_Triangle> list = delaunay.surroundingTriangles(site, triangle);
				R_Shape poly = new R_Shape(this.pa);
				for (R_Delaunay_Triangle tri : list) {
					R_Delaunay_Vertex circumeter = tri.getCircumcenter();
					float x = (float) circumeter.coord(0);
					float y = (float) circumeter.coord(1);
					poly.add(new vec2(x,y));
				}
				regions.add(poly);
			}
		}
	}

	private void build_triangles() {
		triangles_list.clear();
		for (R_Delaunay_Triangle t : delaunay) {
			R_Shape triangle = new R_Shape(this.pa);
			vec3 a = t.get(0).to_vec2().xyz();
			vec3 b = t.get(1).to_vec2().xyz();
			vec3 c = t.get(2).to_vec2().xyz();
			triangle.add(a,b,c);
			triangles_list.add(triangle);
		}
	}
}