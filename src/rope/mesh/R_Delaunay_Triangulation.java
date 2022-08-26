package rope.mesh;

/*
 * Copyright (c) 2005, 2007 by L. Paul Chew.
 *
 * Permission is hereby granted, without written agreement and without
 * license or royalty fees, to use, copy, modify, and distribute this
 * software and its documentation for any purpose, subject to the following
 * conditions:
 *
 * The above copyright notice and this permission notice shall be included
 * in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */

import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import rope.utils.R_Undirected_Graph;



/**
 * A 2D Delaunay DelaunayTriangulation (DT) with incremental site insertion.
 * 
 * This is not the fastest way to build a DT, but it's a reasonable way to build
 * a DT incrementally and it makes a nice interactive display. There are several
 * O(n log n) methods, but they require that the sites are all known initially.
 * 
 * A DelaunayTriangulation is a Set of Triangles. A DelaunayTriangulation is
 * unmodifiable as a Set; the only way to change it is to add sites (via
 * delaunayPlace).
 * 
 * @author Paul Chew
 * Created July 2005. Derived from an earlier, messier version.
 *	Modified November 2007. Rewrote to use AbstractSet as parent class
 *	and to use the UndirectedGraph class internally. Tried to make the DT
 *	algorithm clearer by explicitly creating a cavity. Added code needed
 *	to find a Voronoi cell.
 * 
 * 	@author Karsten Schmidt
 *	Ported to use toxiclibs classes (June 2010).
 *  @author Stanislas Marçais
 *	Ported to use rope classes (August 2022).
 */
public class R_Delaunay_Triangulation extends AbstractSet<R_Delaunay_Triangle> {

	private R_Delaunay_Triangle mostRecent = null;
	private R_Undirected_Graph<R_Delaunay_Triangle> triGraph;

	/**
	* All sites must fall within the initial triangle.
	* @param triangle the initial triangle
	*/
	public R_Delaunay_Triangulation(R_Delaunay_Triangle triangle) {
		triGraph = new R_Undirected_Graph<R_Delaunay_Triangle>();
		triGraph.add(triangle);
		mostRecent = triangle;
	}

	/**
		* True iff triangle is a member of this triangulation. This method isn't
		* required by AbstractSet, but it improves efficiency.
		* 
		* @param triangle the object to check for membership
		*/
	public boolean contains(Object triangle) {
		return triGraph.getNodes().contains(triangle);
	}

	/**
		* Place a new site into the DT. Nothing happens if the site matches an
		* existing DT vertex.
		* 
		* @param site the new R_Delaunay_Vertex
		* @throws IllegalArgumentException if site does not lie in any triangle
		*/
	public void delaunay_area(R_Delaunay_Vertex site) {
		// Uses straightforward scheme rather than best asymptotic time
		// Locate containing triangle
		R_Delaunay_Triangle triangle = locate(site);
		// Give up if no containing triangle or if site is already in DT
		if (triangle == null) {
			throw new IllegalArgumentException("No containing triangle");
		}
		if (triangle.contains(site)) {
			return;
		}
		// Determine the cavity and update the triangulation
		Set<R_Delaunay_Triangle> cavity = getCavity(site, triangle);
		mostRecent = update(site, cavity);
	}

	/**
		* Determine the cavity caused by site.
		* 
		* @param site the site causing the cavity
		* @param triangle the triangle containing site
		* @return set of all triangles that have site in their circumcircle
		*/
	private Set<R_Delaunay_Triangle> getCavity(R_Delaunay_Vertex site, R_Delaunay_Triangle triangle) {
		Set<R_Delaunay_Triangle> encroached = new HashSet<R_Delaunay_Triangle>();
		Queue<R_Delaunay_Triangle> toBeChecked = new LinkedList<R_Delaunay_Triangle>();
		Set<R_Delaunay_Triangle> marked = new HashSet<R_Delaunay_Triangle>();
		toBeChecked.add(triangle);
		marked.add(triangle);
		while (!toBeChecked.isEmpty()) {
			triangle = toBeChecked.remove();
			if (site.vsCircumcircle(triangle.toArray(new R_Delaunay_Vertex[0])) == 1) {
				// Site outside triangle => triangle not in cavity
				continue;
			}
			encroached.add(triangle);
			// Check the neighbors
			for (R_Delaunay_Triangle neighbor : triGraph.getConnectedNodesFor(triangle)) {
				if (marked.contains(neighbor)) {
					continue;
				}
				marked.add(neighbor);
				toBeChecked.add(neighbor);
			}
		}
		return encroached;
	}

	@Override
	public Iterator<R_Delaunay_Triangle> iterator() {
		return triGraph.getNodes().iterator();
	}

	/**
		* Locate the triangle with point inside it or on its boundary.
		* 
		* @param point the point to locate
		* @return the triangle that holds point; null if no such triangle
		*/
	public R_Delaunay_Triangle locate(R_Delaunay_Vertex point) {
		R_Delaunay_Triangle triangle = mostRecent;
		if (!this.contains(triangle)) {
				triangle = null;
		}

		// Try a directed walk (this works fine in 2D, but can fail in 3D)
		Set<R_Delaunay_Triangle> visited = new HashSet<R_Delaunay_Triangle>();
		while (triangle != null) {
			if (visited.contains(triangle)) { // This should never happen
				System.out.println("Warning: Caught in a locate loop");
				break;
			}
			visited.add(triangle);
			// Corner opposite point
			R_Delaunay_Vertex corner = point.isOutside(triangle.toArray(new R_Delaunay_Vertex[0]));
			if (corner == null) {
				return triangle;
			}
			triangle = this.neighborOpposite(corner, triangle);
		}
		// No luck; try brute force
		System.out.println("Warning: Checking all triangles for " + point);
		for (R_Delaunay_Triangle tri : this) {
			if (point.isOutside(tri.toArray(new R_Delaunay_Vertex[0])) == null) {
				return tri;
			}
		}
		// No such triangle
		System.out.println("Warning: No triangle holds " + point);
		return null;
	}

	/**
		* Report neighbor opposite the given vertex of triangle.
		* 
		* @param site a vertex of triangle
		* @param triangle we want the neighbor of this triangle
		* @return the neighbor opposite site in triangle; null if none
		* @throws IllegalArgumentException if site is not in this triangle
		*/
	public R_Delaunay_Triangle neighborOpposite(R_Delaunay_Vertex site, R_Delaunay_Triangle triangle) {
		if (!triangle.contains(site)) {
			throw new IllegalArgumentException("Bad vertex; not in triangle");
		}
		for (R_Delaunay_Triangle neighbor : triGraph.getConnectedNodesFor(triangle)) {
			if (!neighbor.contains(site)) {
				return neighbor;
			}
		}
		return null;
	}

	/**
		* Return the set of triangles adjacent to triangle.
		* 
		* @param triangle the triangle to check
		* @return the neighbors of triangle
		*/
	public Set<R_Delaunay_Triangle> neighbors(R_Delaunay_Triangle triangle) {
		return triGraph.getConnectedNodesFor(triangle);
	}

	@Override
	public int size() {
		return triGraph.getNodes().size();
	}

	/**
		* Report triangles surrounding site in order (cw or ccw).
		* 
		* @param site we want the surrounding triangles for this site
		* @param triangle a "starting" triangle that has site as a vertex
		* @return all triangles surrounding site in order (cw or ccw)
		* @throws IllegalArgumentException if site is not in triangle
		*/
	public List<R_Delaunay_Triangle> surroundingTriangles(R_Delaunay_Vertex site, R_Delaunay_Triangle triangle) {
		if (!triangle.contains(site)) {
			throw new IllegalArgumentException("Site not in triangle");
		}
		List<R_Delaunay_Triangle> list = new ArrayList<R_Delaunay_Triangle>();
		R_Delaunay_Triangle start = triangle;
		R_Delaunay_Vertex guide = triangle.getVertexButNot(site); // Affects cw or
		// ccw
		while (true) {
			list.add(triangle);
			R_Delaunay_Triangle previous = triangle;
			triangle = this.neighborOpposite(guide, triangle); // Next triangle
			guide = previous.getVertexButNot(site, guide); // Update guide
			if (triangle == start) {
				break;
			}
		}
		return list;
	}

	@Override
	public String toString() {
		return "DelaunayTriangulation with " + size() + " triangles";
	}

	/**
		* Update the triangulation by removing the cavity triangles and then
		* filling the cavity with new triangles.
		* 
		* @param site the site that created the cavity
		* @param cavity the triangles with site in their circumcircle
		* @return one of the new triangles
		*/
	private R_Delaunay_Triangle update(R_Delaunay_Vertex site, Set<R_Delaunay_Triangle> cavity) {
		Set<Set<R_Delaunay_Vertex>> boundary = new HashSet<Set<R_Delaunay_Vertex>>();
		Set<R_Delaunay_Triangle> theTriangles = new HashSet<R_Delaunay_Triangle>();

		// Find boundary facets and adjacent triangles
		for (R_Delaunay_Triangle triangle : cavity) { 
			theTriangles.addAll(neighbors(triangle));
			for (R_Delaunay_Vertex vertex : triangle) {
				Set<R_Delaunay_Vertex> facet = triangle.facetOpposite(vertex);
				if (boundary.contains(facet)) {
					boundary.remove(facet);
				} else {
					boundary.add(facet);
				}
			}
		}
		theTriangles.removeAll(cavity); // Adj triangles only

		// Remove the cavity triangles from the triangulation
		for (R_Delaunay_Triangle triangle : cavity) {
			triGraph.remove(triangle);
		}

		// Build each new triangle and add it to the triangulation
		Set<R_Delaunay_Triangle> newTriangles = new HashSet<R_Delaunay_Triangle>();
		for (Set<R_Delaunay_Vertex> vertices : boundary) {
			vertices.add(site);
			R_Delaunay_Triangle tri = new R_Delaunay_Triangle(vertices);
			triGraph.add(tri);
			newTriangles.add(tri);
		}

		// Update the graph links for each new triangle
		theTriangles.addAll(newTriangles); // Adj triangle + new triangles
		for (R_Delaunay_Triangle triangle : newTriangles) {
			for (R_Delaunay_Triangle other : theTriangles) {
				if (triangle.isNeighbor(other)) {
					triGraph.connect(triangle, other);	
				}
			}
		}

		// Return one of the new triangles
		return newTriangles.iterator().next();
	}
}
