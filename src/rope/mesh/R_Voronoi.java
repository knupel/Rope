package rope.mesh;

/**
 * Adaptation from Toxiclib by Stan le Punk 2022
  */



/*
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


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

// import toxi.geom.Polygon2D;
import rope.costume.R_Shape;
// import rope.mesh.R_Delaunay_Vertex;
// import rope.mesh.R_Delaunay_Triangle;
// import toxi.geom.Triangle2D;
// import toxi.geom.Vec2D;
import rope.vector.vec2;
import rope.core.BigBang;
import processing.core.*;

public class R_Voronoi extends BigBang {
	public static float DEFAULT_SIZE = 10000;
	// PApplet pa;

	protected R_Delaunay_Triangulation delaunay;
	protected R_Delaunay_Triangle initialTriangle;
	protected List<vec2> sites = new ArrayList<vec2>();

	public R_Voronoi (PApplet pa) {
		// this(DEFAULT_SIZE);
		super(pa);
	}

	public R_Voronoi(float size) {
		initialTriangle = new R_Delaunay_Triangle(
						new R_Delaunay_Vertex(-size, -size), new R_Delaunay_Vertex(size,
										-size), new R_Delaunay_Vertex(0, size));
		this.delaunay = new R_Delaunay_Triangulation(initialTriangle);
	}

	public void addPoint(vec2 p) {
		sites.add(p.copy());
		delaunay.delaunayPlace(new R_Delaunay_Vertex(p.x, p.y));
	}

	public void addPoints(Collection<? extends vec2> points) {
		for (vec2 p : points) {
			addPoint(p);
		}
	}

	public List<R_Shape> getRegions() {
		List<R_Shape> regions = new LinkedList<R_Shape>();
		HashSet<R_Delaunay_Vertex> done = new HashSet<R_Delaunay_Vertex>(initialTriangle);
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
		return regions;
	}

	public List<vec2> getSites() {
			return sites;
	}

	// public List<Triangle2D> getTriangles() {
	//     List<Triangle2D> tris = new ArrayList<Triangle2D>();
	//     for (DelaunayTriangle t : delaunay) {
	//         tris.add(new Triangle2D(t.get(0).to_vec2(), t.get(1).to_vec2(), t
	//                 .get(2).to_vec2()));
	//     }
	//     return tris;
	// }
}