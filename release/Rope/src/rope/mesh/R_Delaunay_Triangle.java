package rope.mesh;



/*
 * Copyright (c) 2007 by L. Paul Chew.
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

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

import rope.utils.R_ArraySet;

/**
 * A DelaunayTriangle is an immutable Set of exactly three Pnts.
 * 
 * All Set operations are available. Individual vertices can be accessed via
 * iterator() and also via triangle.get(index).
 * 
 * Note that, even if two triangles have the same vertex set, they are
 * *different* triangles. Methods equals() and hashCode() are consistent with
 * this rule.
 * 
 * @author Paul Chew
 * Created December 2007. Replaced general simplices with geometric triangle.
 * 
 */
public class R_Delaunay_Triangle extends R_ArraySet<R_Delaunay_Vertex> {

    private int idNumber; // The id number
    private R_Delaunay_Vertex circumcenter = null; // The triangle's circumcenter

    private static int idGenerator = 0; // Used to create id numbers
    public static boolean moreInfo = false; // True if more info in toString

    /**
     * @param collection a Collection holding the Simplex vertices
     * @throws IllegalArgumentException if there are not three distinct vertices
     */
    public R_Delaunay_Triangle(Collection<? extends R_Delaunay_Vertex> collection) {
        super(collection);
        idNumber = idGenerator++;
        if (this.size() != 3) {
            throw new IllegalArgumentException(
                    "DelaunayTriangle must have 3 vertices");
        }
    }

    /**
     * @param vertices the vertices of the DelaunayTriangle.
     * @throws IllegalArgumentException if there are not three distinct vertices
     */
    public R_Delaunay_Triangle(R_Delaunay_Vertex... vertices) {
        this(Arrays.asList(vertices));
    }

    @Override
    public boolean add(R_Delaunay_Vertex vertex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean equals(Object o) {
        return (this == o);
    }

    /**
     * Report the facet opposite vertex.
     * 
     * @param vertex a vertex of this DelaunayTriangle
     * @return the facet opposite vertex
     * @throws IllegalArgumentException
     *             if the vertex is not in triangle
     */
    public R_ArraySet<R_Delaunay_Vertex> facetOpposite(R_Delaunay_Vertex vertex) {
        R_ArraySet<R_Delaunay_Vertex> facet = new R_ArraySet<R_Delaunay_Vertex>(this);
        if (!facet.remove(vertex)) {
            throw new IllegalArgumentException("Vertex not in triangle");
        }
        return facet;
    }

    /**
     * @return the triangle's circumcenter
     */
    public R_Delaunay_Vertex getCircumcenter() {
        if (circumcenter == null) {
            circumcenter = R_Delaunay_Vertex.circumcenter(this.toArray(new R_Delaunay_Vertex[0]));
        }
        return circumcenter;
    }

    /**
     * Get arbitrary vertex of this triangle, but not any of the bad vertices.
     * 
     * @param badVertices one or more bad vertices
     * @return a vertex of this triangle, but not one of the bad vertices
     * @throws NoSuchElementException
     *             if no vertex found
     */
    public R_Delaunay_Vertex getVertexButNot(R_Delaunay_Vertex... badVertices) {
        Collection<R_Delaunay_Vertex> bad = Arrays.asList(badVertices);
        for (R_Delaunay_Vertex v : this) {
            if (!bad.contains(v)) {
                return v;
            }
        }
        throw new NoSuchElementException("No vertex found");
    }

    /* The following two methods ensure that a DelaunayTriangle is immutable */

    @Override
    public int hashCode() {
        return (idNumber ^ (idNumber >>> 32));
    }

    /**
     * True iff triangles are neighbors. Two triangles are neighbors if they
     * share a facet.
     * 
     * @param triangle
     *            the other DelaunayTriangle
     * @return true iff this DelaunayTriangle is a neighbor of triangle
     */
    public boolean isNeighbor(R_Delaunay_Triangle triangle) {
        int count = 0;
        for (R_Delaunay_Vertex vertex : this) {
            if (!triangle.contains(vertex)) {
                count++;
            }
        }
        return count == 1;
    }

    /* The following two methods ensure that all triangles are different. */

    @Override
    public Iterator<R_Delaunay_Vertex> iterator() {
        return new Iterator<R_Delaunay_Vertex>() {
            private Iterator<R_Delaunay_Vertex> it = R_Delaunay_Triangle.super.iterator();

            public boolean hasNext() {
                return it.hasNext();
            }

            public R_Delaunay_Vertex next() {
                return it.next();
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override
    public String toString() {
        if (!moreInfo) {
            return "R_Delaunay_Triangle" + idNumber;
        }
        return "R_Delaunay_Triangle" + idNumber + super.toString();
    }

}
