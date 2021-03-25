/**
* R_Face
* v 0.1.0
* 2019-2021
* @author @stanlepunk
* @see https://github.com/StanLepunK/Rope
*/
package rope.mesh;

import processing.core.PApplet;
import rope.core.R_Graphic;
import rope.vector.vec3;

public class R_Face extends R_Graphic {
	private vec3 [] pts = new vec3[3];
	private vec3 [] ref = new vec3[3];
	private int fill;
	private int stroke;
	private boolean transform_is;
	/**
	 * 
	 * @param pa is the Processing PAplet
	 */
	public R_Face(PApplet pa) {
		super(pa);
		for(int i = 0 ; i < 3 ; i++) {
			this.pts[i] = new vec3();
		}
	}

	/**
	 * 
	 * @param pa is the Processing PAplet
	 * @param a is summit vec3 point of the triangle face
	 * @param b is summit vec3 point of the triangle face
	 * @param c is summit vec3 point of the triangle face
	 */
	public R_Face(PApplet pa, vec3 a, vec3 b, vec3 c) {
		super(pa);
		pts = new vec3[3];
		this.pts[0] = new vec3(a);
		this.pts[1] = new vec3(b);
		this.pts[2] = new vec3(c);
	}

	/**
	 * 
	 * @param a is summit vec3 point of the triangle face
	 * @param b is summit vec3 point of the triangle face
	 * @param c is summit vec3 point of the triangle face
	 */
	public void set(vec3 a, vec3 b, vec3 c) {
		this.pts[0].set(a);
		this.pts[1].set(b);
		this.pts[2].set(c);
	}

	/**
	 * 
	 * @return the coordonnate of the face in vec3 array
	 */
	public vec3 [] get() {
		return pts;
	}

	/**
	 * 
	 * @return a copy of R_Face with a new reference.
	 */
	public R_Face copy() {
		return new R_Face(this.pa, this.pts[0],this.pts[1],this.pts[2]);
	}

	/**
	 * 
	 * @return the vec3 position of the barycenter of three points of the triangle face
	 */
	public vec3 barycenter() {
		vec3 sum = new vec3();
  	for(int i = 0 ; i < 3 ; i++) {
    	sum.add(pts[i]);
  	}
  	return sum.div(3) ;
	}

	/**
	 * 
	 * @param fill set the fill value
	 */
	public void fill(int fill) {
		this.fill = fill;
	}

	/**
	 * 
	 * @param stroke set the stroke value
	 */
	public void stroke(int stroke) {
		this.stroke = stroke;
	}

	/**
	 * 
	 * @return the int fill color
	 */
	public int get_fill() {
		return this.fill;
	}

	/**
	 * 
	 * @return the int stroke color
	 */
	public int get_stroke() {
		return this.stroke;
	}

	/**
	 * 
	 * @param index
	 */
	private void set_ref(int index) {
		if(ref[index] == null) {
			ref[index] = new vec3(pts[index]);
		} else {
			ref[index].set(pts[index]);
		}
	}

	/**
	 * 
	 * @param value is float type use to create the displacement
	 */
	public void offset(float value) {
		offset(new vec3(value));
	}

	/**
	 * @param value is vec3 type use to create the displacement
	 */
	public void offset(vec3 value) {
		transform_is = true;
		for(int i = 0 ; i < 3 ; i++) {
			set_ref(i);
    	pts[i].add(value);
  	}
	}

	/**
	 * Display the triangle face
	 */
	public void show() {
		beginShape();
		// here we don't use the shorcut vertex(vec3) to avoid the test for the render 3D
		vertex(pts[0].x(),pts[0].y(),pts[0].z());
		vertex(pts[1].x(),pts[1].y(),pts[1].z());
		vertex(pts[2].x(),pts[2].y(),pts[2].z());
		vertex(pts[0].x(),pts[0].y(),pts[0].z()); // close
		endShape();
		if(transform_is) {
			transform_is = false;
			for(int i = 0 ; i < pts.length ; i++) {
				pts[i].set(ref[i]);
			}
		}
	}
}
