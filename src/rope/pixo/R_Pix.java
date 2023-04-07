/**
 *   ___      ___   ____   _______
 *  | -  \   /   \  |    \ |  ___/
 *  | |/  | |   \ | | |\ | |  |__
 *  |    /  | | | | | |  / |  __/
 *  | |  \  \ \   / |  |/  |  |____
 *  |_| \_\  \___/  |_ |   |______/
 * 
* R_Pix
* v 0.2.3
* 2021-2023
* @author @knupel
* @see https://github.com/knupel/Rope
*/


package rope.pixo;


import rope.core.Rope;
import rope.vector.vec3;

public class R_Pix extends Rope {
  protected vec3 pos;
  protected int fill;
  protected int entry;

  public R_Pix() {
    this.pos = new vec3();
		this.fill = BLACK;
  }

	public R_Pix(int x, int y, int width, int height) {
		set_entry_impl(x, y, width, height);
		this.pos = new vec3(x,y,0);
		this.fill = BLACK;
  }

  // entry
	/**
	 * Use to define the entry point of the pixel in the pixel array
	 * @param entry
	 */
	public void set_entry(int entry) {
		this.entry = entry;
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
			this.entry = index_pixel_array(x, y, width);
		} 
	}
	
	/**
	 * 
	 * @return
	 */
	public int get_entry() {
		return this.entry;
	}


	/**
	 * 
	 * @param x
	 * @param y
	 */
	public void pos(float x, float y) {
		this.pos.set(x,y,0);
	}
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @param z
	 */
	public void pos(float x, float y, float z) {
		this.pos.set(x,y,z);
	}

	public vec3 pos() {
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


  /**
   * 
   * @param fill set colour of the pixel
   */
	public void fill(int fill) {
		this.fill = fill;
	}
	
	/**
	 * 
	 * @return colour of the pixel
	 */
	public int fill() {
		return this.fill;
	}

}