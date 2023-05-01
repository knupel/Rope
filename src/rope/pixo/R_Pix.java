/**
 *   ___      ___   ____   _______
 *  | -  \   /   \  |    \ |  ___/
 *  | |/  | |   \ | | |\ | |  |__
 *  |    /  | | | | | |  / |  __/
 *  | |  \  \ \   / |  |/  |  |____
 *  |_| \_\  \___/  |_ |   |______/
 * 
* R_Pix
* v 0.5.0
* 2021-2023
* @author @knupel
* @see https://github.com/knupel/Rope
*/


package rope.pixo;


import rope.core.Rope;
import rope.vector.vec3;
import rope.vector.vec6;

public class R_Pix extends Rope {
	protected vec6 body;
	protected int id = Integer.MIN_VALUE;
	// private vec6 id;
	// we lost 2 FPS with one million of particle

  public R_Pix() {
		this.body = new vec6(0,0,0,0,0,BLACK);
  }

	public R_Pix(int x, int y, int width, int height) {
		this.body = new vec6(x,y,0,0,0,BLACK);
		set_entry_impl(x, y, width, height);
  }

  // entry
	/**
	 * Use to define the entry point of the pixel in the pixel array
	 * @param entry
	 */
	public void set_entry(int entry) {
		body.e(entry);
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
			body.e(index_pixel_array(x, y, width));
		} 
	}
	
	/**
	 * 
	 * @return
	 */
	public int get_entry() {
		return (int)this.body.e();
	}


	/**
	 * 
	 * @param id
	 */
	public void id(int id) {
		this.id = id;
	}


	public int id() {
		return this.id;
	}


	/**
	 * 
	 * @param x
	 * @param y
	 */
	public void pos(float x, float y) {
		this.x(x);
		this.y(y);
	}
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @param z
	 */
	public void pos(float x, float y, float z) {
		this.x(x);
		this.y(y);
		this.z(z);
	}

	/**
	 * @return a copy of the position in x, y and z
	 */
	public vec3 pos() {
		return this.body.xyz();
	}

	public float x() {
		return this.body.x();
	}

	public float y() {
		return this.body.y();
	}

	public float z() {
		return this.body.z();
	}

	public float w() {
		return this.body.w();
	}

	/**
	 * 
	 * @param x
	 */
	public void x(float x) {
		this.body.a(x);
	}

	/**
	 * 
	 * @param y
	 */
	public void y(float y) {
		this.body.b(y);
	}

	/**
	 * 
	 * @param z
	 */
	public void z(float z) {
		this.body.c(z);
	}

	/**
	 * 
	 * @param w
	 */
	public void w(float w) {
		this.body.d(w);
	}


  /**
   * 
   * @param fill set colour of the pixel
   */
	public void fill(int fill) {
		this.body.f(fill);
	}
	
	/**
	 * 
	 * @return colour of the pixel
	 */
	public int fill() {
		return (int)this.body.f();
	}

	/**
   * 
   * @return copy of herself
   */
	public R_Pix copy() {
		R_Pix p = new R_Pix();
		p.body = body.copy();
		p.id = this.id;
		return p;
	}

}