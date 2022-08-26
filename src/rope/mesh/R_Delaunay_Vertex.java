package rope.mesh;




/**
* Adaptation from Toxiclib 
 */


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




/**
* Points in Euclidean space, implemented as double[].
* 
* Includes simple geometric operations. Uses matrices; a matrix is represented
* as an array of Pnts. Uses simplices; a simplex is represented as an array of
* points.
* 
* @author Paul Chew Created July 2005. Derived from an earlier, messier version. 
					Modified Novemeber 2007. Minor clean up by Toxilib
					Modified Novemeber 2022. Minor clean up by Stan le Punk
*/


import rope.vector.vec2;


public class R_Delaunay_Vertex {

	/**
	* Circumcenter of a simplex.
	* 
	* @param simplex the simplex (as an array of points)
	* @return the circumcenter (a R_Delaunay_Vertex) of simplex
	*/
	public static R_Delaunay_Vertex circumcenter(R_Delaunay_Vertex[] simplex) {
		int dim = simplex[0].dimension();
		if (simplex.length - 1 != dim) {
			throw new IllegalArgumentException("Dimension mismatch");
		}
		R_Delaunay_Vertex[] matrix = new R_Delaunay_Vertex[dim];
		for (int i = 0; i < dim; i++) {
			matrix[i] = simplex[i].bisector(simplex[i + 1]);
		}
		R_Delaunay_Vertex hCenter = cross(matrix); // Center in homogeneous
																						// coordinates
		double last = hCenter.coordinates[dim];
		double[] result = new double[dim];
		for (int i = 0; i < dim; i++) {
			result[i] = hCenter.coordinates[i] / last;
		}
		return new R_Delaunay_Vertex(result);
	}

	/**
	* Determine the signed content (i.e., area or volume, etc.) of a simplex.
	* 
	* @param simplex the simplex (as an array of Pnts)
	* @return the signed content of the simplex
	*/
	public static double content(R_Delaunay_Vertex[] simplex) {
		R_Delaunay_Vertex[] matrix = new R_Delaunay_Vertex[simplex.length];
		for (int i = 0; i < matrix.length; i++) {
			matrix[i] = simplex[i].extend(1);
		}
		int fact = 1;
		for (int i = 1; i < matrix.length; i++) {
			fact = fact * i;
		}
		return determinant(matrix) / fact;
	}

	/**
	* Compute generalized cross-product of the rows of a matrix. The result is
	* a DelaunayVertex perpendicular (as a vector) to each row of the matrix.
	* This is not an efficient implementation, but should be adequate for low
	* dimension.
	* 
	* @param matrix the matrix of Pnts (one less row than the DelaunayVertex dimension)
	* @return a DelaunayVertex perpendicular to each row DelaunayVertex
	* @throws IllegalArgumentException if matrix is wrong shape
	*/
	public static R_Delaunay_Vertex cross(R_Delaunay_Vertex[] matrix) {
		int len = matrix.length + 1;
		if (len != matrix[0].dimension()) {
			throw new IllegalArgumentException("Dimension mismatch");
		}
		boolean[] columns = new boolean[len];
		for (int i = 0; i < len; i++) {
			columns[i] = true;
		}
		double[] result = new double[len];
		int sign = 1;
		try {
			for (int i = 0; i < len; i++) {
				columns[i] = false;
				result[i] = sign * determinant(matrix, 0, columns);
				columns[i] = true;
				sign = -sign;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new IllegalArgumentException("Matrix is wrong shape");
		}
		return new R_Delaunay_Vertex(result);
	}

	/**
	* Compute the determinant of a matrix (array of Pnts). This is not an
	* efficient implementation, but should be adequate for low dimension.
	* 
	* @param matrix the matrix as an array of Pnts
	* @return the determinnant of the input matrix
	* @throws IllegalArgumentException if dimensions are wrong
	*/
	public static double determinant(R_Delaunay_Vertex[] matrix) {
		if (matrix.length != matrix[0].dimension()) {
			throw new IllegalArgumentException("Matrix is not square");
		}
		boolean[] columns = new boolean[matrix.length];
		for (int i = 0; i < matrix.length; i++) {
			columns[i] = true;
		}
		try {
			return determinant(matrix, 0, columns);
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new IllegalArgumentException("Matrix is wrong shape");
		}
	}

	/**
	* Compute the determinant of a submatrix specified by starting row and by
	* "active" columns.
	* 
	* @param matrix the matrix as an array of points
	* @param row the starting row
	* @param columns a boolean array indicating the "active" columns
	* @return the determinant of the specified submatrix
	* @throws ArrayIndexOutOfBoundsException if dimensions are wrong
	*/
	private static double determinant(R_Delaunay_Vertex[] matrix, int row, boolean[] columns) {
		if (row == matrix.length) {
			return 1;
		}
		double sum = 0;
		int sign = 1;
		for (int col = 0; col < columns.length; col++) {
			if (!columns[col]) {
				continue;
			}
			columns[col] = false;
			sum += sign * matrix[row].coordinates[col] * determinant(matrix, row + 1, columns);
			columns[col] = true;
			sign = -sign;
		}
		return sum;
	}

	/**
	* Create a String for a matrix.
	* 
	* @param matrix the matrix (an array of Pnts)
	* @return a String represenation of the matrix
	*/
	public static String toString(R_Delaunay_Vertex[] matrix) {
		StringBuilder buf = new StringBuilder("{");
		for (R_Delaunay_Vertex row : matrix) {
			buf.append(" " + row);
		}
		buf.append(" }");
		return buf.toString();
	}

	private double[] coordinates; // The point's coordinates

   /**
    * Constructor.
    * @param coords the coordinates
    */
	public R_Delaunay_Vertex(double... coords) {
		// Copying is done here to ensure that R_Delaunay_Vertex's coords cannot be altered.
		// This is necessary because the double... notation actually creates a
		// constructor with double[] as its argument.
		coordinates = new double[coords.length];
		System.arraycopy(coords, 0, coordinates, 0, coords.length);
	}

	/**
	* Add
	* @param p the other R_Delaunay_Vertex
	* @return a new R_Delaunay_Vertex = this + p
	*/
	public R_Delaunay_Vertex add(R_Delaunay_Vertex p) {
		int len = dimCheck(p);
		double[] coords = new double[len];
		for (int i = 0; i < len; i++) {
			coords[i] = this.coordinates[i] + p.coordinates[i];
		}
		return new R_Delaunay_Vertex(coords);
	}

	/**
	* Angle (in radians) between two Pnts (treated as vectors).
	* @param p the other DelaunayVertex
	* @return the angle (in radians) between the two Pnts
	*/
	public double angle(R_Delaunay_Vertex p) {
		return Math.acos(this.dot(p) / (this.magnitude() * p.magnitude()));
	}

	/**
	* Perpendicular bisector of two Pnts. Works in any dimension. The
	* coefficients are returned as a R_Delaunay_Vertex of one higher dimension
	* (e.g., (A,B,C,D) for an equation of the form Ax + By + Cz + D = 0).
	* 
	* @param point the other point
	* @return the coefficients of the perpendicular bisector
	*/
	public R_Delaunay_Vertex bisector(R_Delaunay_Vertex point) {
		dimCheck(point);
		R_Delaunay_Vertex diff = this.subtract(point);
		R_Delaunay_Vertex sum = this.add(point);
		double dot = diff.dot(sum);
		return diff.extend(-dot / 2);
	}

	/**
	* @return the specified coordinate of this R_Delaunay_Vertex
	* @throws ArrayIndexOutOfBoundsException for bad coordinate
	*/
	public double coord(int i) {
		return this.coordinates[i];
	}

	/**
	* Check that dimensions match.
	* 
	* @param p the DelaunayVertex to check (against this DelaunayVertex)
	* @return the dimension of the Pnts
	* @throws IllegalArgumentException if dimension fail to match
	*/
	public int dimCheck(R_Delaunay_Vertex p) {
		int len = this.coordinates.length;
		if (len != p.coordinates.length) {
			throw new IllegalArgumentException("Dimension mismatch");
		}
		return len;
	}

	/**
	* @return this R_Delaunay_Vertex's dimension.
	*/
	public int dimension() {
		return coordinates.length;
	}

	/* Points as matrices */

	/**
	* Dot product.
	* @param p the other R_Delaunay_Vertex
	* @return dot product of this R_Delaunay_Vertex and p
	*/
	public double dot(R_Delaunay_Vertex p) {
		int len = dimCheck(p);
		double sum = 0;
		for (int i = 0; i < len; i++) {
			sum += this.coordinates[i] * p.coordinates[i];
		}
		return sum;
	}

	@Override
	public boolean equals(Object other) {
		if (!(other instanceof R_Delaunay_Vertex)) {
			return false;
		}
		R_Delaunay_Vertex p = (R_Delaunay_Vertex) other;
		if (this.coordinates.length != p.coordinates.length) {
			return false;
		}
		for (int i = 0; i < this.coordinates.length; i++) {
			if (this.coordinates[i] != p.coordinates[i]) {
				return false;
			}
		}
		return true;
	}

	/**
	* Create a new R_Delaunay_Vertex by adding additional coordinates to this
	* R_Delaunay_Vertex.
	* 
	* @param coords the new coordinates (added on the right end)
	* @return a new R_Delaunay_Vertex with the additional coordinates
	*/
	public R_Delaunay_Vertex extend(double... coords) {
		double[] result = new double[coordinates.length + coords.length];
		System.arraycopy(coordinates, 0, result, 0, coordinates.length);
		System.arraycopy(coords, 0, result, coordinates.length, coords.length);
		return new R_Delaunay_Vertex(result);
	}

	@Override
	public int hashCode() {
		int hash = 0;
		for (double c : this.coordinates) {
			long bits = Double.doubleToLongBits(c);
			hash = (31 * hash) ^ (int) (bits ^ (bits >> 32));
		}
		return hash;
	}

   /* Pnts as simplices */

	/**
	* Test if this R_Delaunay_Vertex is inside a simplex.
	* 
	* @param simplex the simplex (an arary of Pnts)
	* @return true iff this R_Delaunay_Vertex is inside simplex.
	*/
	public boolean isInside(R_Delaunay_Vertex[] simplex) {
		int[] result = this.relation(simplex);
		for (int r : result) {
			if (r >= 0) {
				return false;
			}
		}
		return true;
	}

	/**
	* Test if this R_Delaunay_Vertex is on a simplex.
	* 
	* @param simplex the simplex (an array of Pnts)
	* @return the simplex R_Delaunay_Vertex that "witnesses" on-ness (or null if not on)
	*/
	public R_Delaunay_Vertex isOn(R_Delaunay_Vertex[] simplex) {
		int[] result = this.relation(simplex);
		R_Delaunay_Vertex witness = null;
		for (int i = 0; i < result.length; i++) {
			if (result[i] == 0) {
				witness = simplex[i];
			} else if (result[i] > 0) {
				return null;
			}
		}
		return witness;
	}

	/**
	* Test if this R_Delaunay_Vertex is outside of simplex.
	* 
	* @param simplex the simplex (an array of Pnts)
	* @return simplex DelaunayVertex that "witnesses" outsideness (or null if not outside)
	*/
	public R_Delaunay_Vertex isOutside(R_Delaunay_Vertex[] simplex) {
		int[] result = this.relation(simplex);
		for (int i = 0; i < result.length; i++) {
			if (result[i] > 0) {
				return simplex[i];
			}
		}
		return null;
	}

	/**
	* Magnitude (as a vector).
	* 
	* @return the Euclidean length of this vector
	*/
	public double magnitude() {
		return Math.sqrt(this.dot(this));
	}

   /**
    * Relation between this DelaunayVertex and a simplex (represented as an
    * array of Pnts). Result is an array of signs, one for each vertex of the
    * simplex, indicating the relation between the vertex, the vertex's
    * opposite facet, and this DelaunayVertex.
    * 
    * <pre>
    *   -1 means R_Delaunay_Vertex is on same side of facet
    *    0 means R_Delaunay_Vertex is on the facet
    *   +1 means R_Delaunay_Vertex is on opposite side of facet
    * </pre>
    * 
    * @param simplex an array of Pnts representing a simplex
    * @return an array of signs showing relation between this R_Delaunay_Vertex and simplex
    * @throws IllegalArgumentExcpetion if the simplex is degenerate
    */
	public int[] relation(R_Delaunay_Vertex[] simplex) {
		/*
		* In 2D, we compute the cross of this matrix: 1 1 1 1 p0 a0 b0 c0 p1 a1
		* b1 c1 where (a, b, c) is the simplex and p is this R_Delaunay_Vertex.
		* The result is a vector in which the first coordinate is the signed
		* area (all signed areas are off by the same constant factor) of the
		* simplex and the remaining coordinates are the *negated* signed areas
		* for the simplices in which p is substituted for each of the vertices.
		* Analogous results occur in higher dimensions.
		*/
		int dim = simplex.length - 1;
		if (this.dimension() != dim) {
			throw new IllegalArgumentException("Dimension mismatch");
		}

		/* Create and load the matrix */
		R_Delaunay_Vertex[] matrix = new R_Delaunay_Vertex[dim + 1];
		/* First row */
		double[] coords = new double[dim + 2];
		for (int j = 0; j < coords.length; j++) {
			coords[j] = 1;
		}
		matrix[0] = new R_Delaunay_Vertex(coords);
		/* Other rows */
		for (int i = 0; i < dim; i++) {
			coords[0] = this.coordinates[i];
			for (int j = 0; j < simplex.length; j++) {
					coords[j + 1] = simplex[j].coordinates[i];
			}
			matrix[i + 1] = new R_Delaunay_Vertex(coords);
		}

		/* Compute and analyze the vector of areas/volumes/contents */
		R_Delaunay_Vertex vector = cross(matrix);
		double content = vector.coordinates[0];
		int[] result = new int[dim + 1];
		for (int i = 0; i < result.length; i++) {
			double value = vector.coordinates[i + 1];
			if (Math.abs(value) <= 1.0e-6 * Math.abs(content)) {
				result[i] = 0;
			} else if (value < 0) {
				result[i] = -1;
			} else {
				result[i] = 1;
			}
		}
		if (content < 0) {
			for (int i = 0; i < result.length; i++) {
				result[i] = -result[i];
			}
		}
		if (content == 0) {
			for (int i = 0; i < result.length; i++) {
				result[i] = Math.abs(result[i]);
			}
		}
		return result;
	}

	/**
	* Subtract.
	* @param p the other R_Delaunay_Vertex
	* @return a new R_Delaunay_Vertex = this - p
	*/
	public R_Delaunay_Vertex subtract(R_Delaunay_Vertex p) {
		int len = dimCheck(p);
		double[] coords = new double[len];
		for (int i = 0; i < len; i++) {
			coords[i] = this.coordinates[i] - p.coordinates[i];
		}
		return new R_Delaunay_Vertex(coords);
	}

	@Override
	public String toString() {
		if (coordinates.length == 0) {
			return "R_Delaunay_Vertex()";
		}
		String result = "R_Delaunay_Vertex(" + coordinates[0];
		for (int i = 1; i < coordinates.length; i++) {
			result = result + "," + coordinates[i];
		}
		result = result + ")";
		return result;
	}

	public vec2 to_vec2() {
		return new vec2((float) coordinates[0], (float) coordinates[1]);
	}

	/**
	* Test relation between this R_Delaunay_Vertex and circumcircle of a simplex.
	* 
	* @param simplex the simplex (as an array of Pnts)
	* @return -1, 0, or +1 for inside, on, or outside of circumcircle
	*/
	public int vsCircumcircle(R_Delaunay_Vertex[] simplex) {
		R_Delaunay_Vertex[] matrix = new R_Delaunay_Vertex[simplex.length + 1];
		for (int i = 0; i < simplex.length; i++) {
			matrix[i] = simplex[i].extend(1, simplex[i].dot(simplex[i]));
		}
		matrix[simplex.length] = this.extend(1, this.dot(this));
		double d = determinant(matrix);
		int result = (d < 0) ? -1 : ((d > 0) ? +1 : 0);
		if (content(simplex) < 0) {
			result = -result;
		}
		return result;
	}
}
