/**
* R_Megabloc
* v 0.1.0
* 2019-2021
* @author @stanlepunk
* @see https://github.com/StanLepunK/Rope
*/
package rope.mesh;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PGraphics;
import rope.core.R_Graphic;

public class R_Megabloc extends R_Graphic {
	private ArrayList<R_Bloc> list;
	private int width;
	private int height;
	private int magnetism = 2;

	public R_Megabloc(PApplet pa) {
		super(pa);
		list = new ArrayList<R_Bloc>();
	}

	public void set(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public void set_magnetism(int magnetism) {
		this.magnetism = magnetism;
	}

	public void fill(int fill) {
		for(R_Bloc b : list) {
			b.fill(fill);
		}
	}

	public boolean fill(int index, int fill) {
		if(index >= 0 && index < list.size()) {
			list.get(index).fill(fill);
			return true;
		} else {
			return false;
		}
	}

	public void stroke(int stroke) {
		for(R_Bloc b : list) {
			b.stroke(stroke);
		}
	}

	public boolean stroke(int index, int stroke) {
		if(index >= 0 && index < list.size()) {
			list.get(index).stroke(stroke);
			return true;
		} else {
			return false;
		}
	}

		public void thickness(float thickness) {
		for(R_Bloc b : list) {
			b.thickness(thickness);
		}
	}

	public boolean thickness(int index, float thickness) {
		if(index >= 0 && index < list.size()) {
			list.get(index).thickness(thickness);
			return true;
		} else {
			return false;
		}
	}

	public void clear() {
		list.clear();
	}

	public int size() {
		return list.size();
	}

	public void add(R_Bloc bloc) {
		list.add(bloc);
	}

	public void add(R_Bloc [] blocs) {
		for(int i = 0 ; i < blocs.length ; i++) {
			list.add(blocs[i]);
		}
	}

	public int get_magnetism() {
		return this.magnetism;
	}

	public int get_width() {
		return width;
	}

	public int get_height() {
		return height;
	}

	public ArrayList<R_Bloc> get()  {
		return list;
	}

	public R_Bloc get(int index) {
		if(index >= 0 && index < list.size()) {
			return list.get(index);
		} else {
			return null;
		}
	}

  public boolean remove(int index) {
		if(index >= 0 && index < list.size()) {
			list.remove(index);
			return true;
		} else {
			return false;
		}
	}

	public void show() {
		show(this.pa.g);
	}

	public void show(PGraphics other) {
		for(R_Bloc b : list) {
			b.show(other);
		}
	}
}