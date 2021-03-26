package rope.pixo;


import rope.core.Rope;
import rope.vector.vec3;

public class R_Pix extends Rope {
  protected vec3 pos;
  protected int colour;
  protected int entry;

  public R_Pix() {
    this.pos = new vec3();
  }

  // entry
	/**
	 * Use to define the entry point of the pixel in the pixel array
	 * @param entry
	 */
	public void set_entry(int entry) {
		this.entry = entry;
	}

	public int get_entry() {
		return this.entry;
	}


  	// pos
	public void pos(float x, float y) {
		this.pos.set(x,y,0);
	}

	public void pos(float x, float y, float z) {
		this.pos.set(x,y,z);
	}

	public vec3 pos() {
		return this.pos;
	}


  //colour
	public void colour(int colour) {
		this.colour = colour;
	}

	public int colour() {
		return this.colour;
	}

}