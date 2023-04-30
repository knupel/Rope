/**
 *   ___      ___   ____   _______
 *  | -  \   /   \  |    \ |  ___/
 *  | |/  | |   \ | | |\ | |  |__
 *  |    /  | | | | | |  / |  __/
 *  | |  \  \ \   / |  |/  |  |____
 *  |_| \_\  \___/  |_ |   |______/
 * 
* R_Pix
* v 0.4.0
* 2021-2023
* @author @knupel
* @see https://github.com/knupel/Rope
*/


package rope.pixo;


import rope.core.Rope;
import rope.vector.vec3;
import rope.vector.vec4;
import rope.vector.ivec6;

public class R_Pix extends Rope {
  protected vec4 pos;
  // private int fill;
  // private int entry;
	// private ivec6 id;
	private ivec6 id = new ivec6(Integer.MIN_VALUE);

  public R_Pix() {
    this.pos = new vec4();
		// this.fill = BLACK;
		id.f(BLACK);
  }

	public R_Pix(int x, int y, int width, int height) {
		set_entry_impl(x, y, width, height);
		this.pos = new vec4(x,y,0,0);
		// this.fill = BLACK;
		id.f(BLACK);
  }

  // entry
	/**
	 * Use to define the entry point of the pixel in the pixel array
	 * @param entry
	 */
	public void set_entry(int entry) {
		// this.entry = entry;
		id.e(entry);
	}

	/**
	 * Use to define the entry point of the pixel from x, y coordinate in the pixel array
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public void set_entry(int x, int y, int width, int height) {
		this.pos(x, y);
		set_entry_impl(x, y, width, height);
	}

	private void set_entry_impl(int x, int y, int width, int height) {
		if(lessThan(x,width) 
				&& lessThan(y,height) 
				&& greaterThanEqual(x,0) 
				&& greaterThanEqual(y, 0)) {
			// this.entry = index_pixel_array(x, y, width);
			id.e(index_pixel_array(x, y, width));
		} 
	}
	
	/**
	 * 
	 * @return
	 */
	public int get_entry() {
		// return this.entry;
		return this.id.e();
	}


	/**
	 * 
	 * @param x
	 * @param y
	 */
	public void pos(float x, float y) {
		this.pos.x(x);
		this.pos.y(y);
	}
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @param z
	 */
	public void pos(float x, float y, float z) {
		this.pos.x(x);
		this.pos.y(y);
		this.pos.z(z);
	}

	/**
	 * @return a copy of the position in x, y and z
	 */
	public vec3 pos() {
		return this.pos.xyz();
	}

	/**
	 * @return the reel allocation place of the position, use carefuly
	 */
	public vec4 pointer_pos() {
		return this.pos;
	}

	public float x() {
		return this.pos.x();
	}

	public float y() {
		return this.pos.y();
	}

	public float z() {
		return this.pos.z();
	}

	public float w() {
		return this.pos.w();
	}

	public void x(float x) {
		this.pos.x(x);
	}

	public void y(float y) {
		this.pos.y(y);
	}

	public void z(float z) {
		this.pos.z(z);
	}

	public void w(float w) {
		this.pos.w(w);
	}


  /**
   * 
   * @param fill set colour of the pixel
   */
	public void fill(int fill) {
		// this.fill = fill;
		this.id.f(fill);
	}
	
	/**
	 * 
	 * @return colour of the pixel
	 */
	public int fill() {
		// return this.fill;
		return this.id.f();
	}

	/**
   * 
   * @return copy of herself
   */
	public R_Pix copy() {
		R_Pix p = new R_Pix();
		p.pos = pos.copy();
		p.id = id.copy();
		// p.fill(this.fill);
		// p.set_entry(this.entry);
		return p;
	}

}