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

  // entry
	/**
	 * Use to define the entry point of the pixel in the pixel array
	 * @param entry
	 */
	public void set_entry(int entry) {
		this.entry = entry;
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


  /**
   * 
   * @param fill
   */
	public void fill(int fill) {
		this.fill = fill;
	}
	
	/**
	 * 
	 * @return
	 */
	public int fill() {
		return this.fill;
	}

}