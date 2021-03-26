/**
* R_COLOUR LIST class
* v 0.5.0
* 2017-2021
*/

package rope.colour;

import java.util.ArrayList;

import processing.core.PApplet;
import rope.core.Rope;
import rope.vector.vec3;
import rope.vector.vec4;

public class R_Colour extends Rope {
	ArrayList<Palette> list;
	PApplet pa;
	
	public R_Colour(PApplet pa) {
		this.pa = pa;
		this.list = new ArrayList<Palette>();
		Palette p = new Palette();
		list.add(p);
	}

	public R_Colour(PApplet pa, int... list_colour) {
		this.pa = pa;
		this.list = new ArrayList<Palette>();
		Palette p = new Palette(list_colour);
		list.add(p);
	}

	public void add(int group, int [] colour) {
		if(group >= 0) {
			if(group >= size_group()) {
				String s = "class R_Colour method add(int group, int [] colour) the group: " + group + " don't exist yet, add group before use this method";
				System.err.println(s);
			} else {
				list.get(group).add(colour);
			}
		}
	}

	public void add(int group, int colour) {
		if(group >= 0) {
			if(group >= size_group()) {
				String s = "class R_Colour method add(int group, int colour): the group " + group + " don't exist yet, add group before use this method";
				System.err.println(s);
			} else {
				list.get(group).add(colour);
			}   
		}
	}

	public void add(int colour) {
		list.get(0).add(colour);
	}

	public void add_group() {
		Palette p = new Palette();
		list.add(p);
	}

	public void add_group(int num) {
		for(int i = 0 ; i < num ; i++) {
			Palette p = new Palette();
			list.add(p);
		}
	}

	public void set(int index, int colour) {
		set(0, index, colour);
	}

	public void set(int group, int index, int colour) {
		if(group >= 0 && group <= size_group() && index >= 0 && index < list.get(group).size()) {
			list.get(group).set(index,colour);
		}
	}



 
	// clear
	public void clear() {
		for(Palette p : list) {
			p.clear();
		}
	}

	public void clear(int group) {
		if(group >= 0 && group < size_group()) {
			list.get(group).clear();
		} else {
			print_err("class R_Colour method clear(",group,") this group don't match with any group");
		}
	}


	public void remove(int group, int index) {
		if(group >= 0 && group < size_group()) {
			list.get(group).remove(index);
		} else {
			print_err("class R_Colour method remove(",group,") this group don't match with any group");
		}
	}
	

	// GET
	// get size
	public int size_group() {
		return list.size();
	}

	public int size() {
		return size(0);
	}

	public int size(int group) {
		if(group >= 0 && group < size_group()) {
			return list.get(group).size();
		} else {
			String s = "class R_Colour method size(int group) the group: " + group + " don't exist yet, add group before use this method, instead '-1' is return";
			System.err.println(s);
			return -1;
		}
	}
	
	// get content
	public int [] get() {
		return get(0);
	}

	public int [] get(int group) {
		if(group >= 0 && group < size_group()) {
			return list.get(group).array(); 
		} else {
			String s = "class R_Colour method get(int group) the group: " + group + " don't exist yet, add group before use this method";
			System.err.println(s);
			return null;
		}
	}


	// get colour
	int rand() {
		int group = floor(random(size_group()));
		int target = floor(random(list.get(group).array().length));
		return get_colour(group,target);
	}

	int rand(int group) {
		int target = 0;
		if(group < list.size()) {
			target = floor(random(list.get(group).array().length));
		} else {
			group = 0;
			target = floor(random(list.get(group).array().length));
		}
		return get_colour(group,target);
	}


	public int get_colour(int group, int target) {
		if(target >= 0 && group >= 0 && group < size_group() && target < list.get(group).array().length) {
			return list.get(group).array()[target];
		} else {
			print_err("class R_Colour method get_colour() no target match with your demand, instead '0' is return");
			return 0;
		}
	}


	public float get_hue(int group, int target) {
		if(group >= 0 && group < size_group()) {
			return pa.hue(list.get(group).get(target));
		} else {
			print_err("class R_Color method get_hue(",group,") no group match with your demand, instead '0' is return");
			return 0;
		}
	}


	public float get_saturation(int group, int target) {
		if(group >= 0 && group < size_group()) {
			return this.pa.saturation(list.get(group).get(target));
		} else {
			print_err("class R_Color method get_saturation(",group,") no group match with your demand, instead '0' is return");
			return 0;
		}
	}
	

	public float get_brightness(int group, int target) {
		if(group >= 0 && group < size_group()) {
			return this.pa.brightness(list.get(group).get(target));
		} else {
			print_err("class R_Color method get_brightness(",group,") no group match with your demand, instead '0' is return");
			return 0;
		}
	}

	public float get_red(int group, int target) {
		if(group >= 0 && group < size_group()) {
			return this.pa.red(list.get(group).get(target));
		} else {
			print_err("class R_Color method get_red(",group,") no group match with your demand, instead '0' is return");
			return 0;
		}
	}
	

	public float get_green(int group, int target) {
		if(group >= 0 && group < size_group()) {
			return this.pa.green(list.get(group).get(target));
		} else {
			print_err("class R_Color method get_green(",group,") no group match with your demand, instead '0' is return");
			return 0;
		}
	}

	public float get_blue(int group, int target) {
		if(group >= 0 && group < size_group()) {
		 return this.pa.blue(list.get(group).get(target));
		} else {
			print_err("class R_Color method get_blue(",group,") no group match with your demand, instead '0' is return");
			return 0;
		}
	}


	public float get_alpha(int group, int target) {
		if(group >= 0 && group < size_group()) {
			return this.pa.alpha(list.get(group).get(target));
		} else {
			print_err("class R_Color method get_alpha(",group,") no group match with your demand, instead '0' is return");
			return 0;
		}
	}


	public vec3 get_hsb(int group, int target) {
		if(group >= 0 && group < size_group()) {
			int c = list.get(group).get(target);
			return new vec3(this.pa.hue(c),this.pa.saturation(c),this.pa.brightness(c));
		} else {
			print_err("class R_Color method get_hsb(",group,") no group match with your demand, instead 'null' is return");
			return null;
		}
	}


	public vec4 get_hsba(int group, int target) {
		if(group >= 0 && group < size_group()) {
			int c = list.get(group).get(target);
			return new vec4(this.pa.hue(c),this.pa.saturation(c),this.pa.brightness(c),this.pa.alpha(c));
		} else {
			print_err("class R_Color method get_hsba(",group,") no group match with your demand, instead 'null' is return");
			return null;
		}
	}


	public vec3 get_rgb(int group, int target) {
		if(group >= 0 && group < size_group()) {
			int c = list.get(group).get(target);
			return new vec3(pa.red(c),pa.green(c),pa.blue(c));
		} else {
			print_err("class R_Color method get_rgb(",group,") no group match with your demand, instead 'null' is return");
			return null;
		}
	}
	

	public vec4 get_rgba(int group, int target) {
		if(group >= 0 && group < size_group()) {
			int c = list.get(group).get(target);
			return new vec4(pa.red(c),pa.green(c),pa.blue(c),pa.alpha(c));
		} else {
			print_err("class R_Color method get_rgba(",group,") no group match with your demand, instead 'null' is return");
			return null;
		}
	}
	

	public float [] hue() {
		return hue(0);
	}

	public float [] hue(int group) {
		if(group >= 0 && group < size_group()) {
			float[] component = new float[list.get(group).size()];
			for(int i = 0 ; i < component.length ; i++) {
				int c = list.get(group).get(i);
				component[i] = this.pa.hue(c);
			}
			return component;
		} else {
			print_err("class R_Color method hue(",group,") no group match with your demand, instead 'null' is return");
			return null; 
		}
	}


	
	public float [] saturation() {
		return saturation(0);
	}

	public float [] saturation(int group) {
		if(group >= 0 && group < size_group()) {
			float[] component = new float[list.get(group).size()];
			for(int i = 0 ; i < component.length ; i++) {
				int c = list.get(group).get(i);
				component[i] = this.pa.saturation(c);
			}
			return component;
		} else {
			print_err("class R_Color method saturation(",group,") no group match with your demand, instead 'null' is return");
			return null; 
		}
	}



	public float [] brightness() {
		return brightness(0);
	}
	
	public float [] brightness(int group) {
		if(group >= 0 && group < size_group()) {
			float[] component = new float[list.get(group).size()];
			for(int i = 0 ; i < component.length ; i++) {
				int c = list.get(group).get(i);
				component[i] = this.pa.brightness(c);
			}
			return component;
		} else {
			print_err("class R_Color method brightness(",group,") no group match with your demand, instead 'null' is return");
			return null; 
		}
	}


	public float [] red() {
		return red(0);
	}

	public float [] red(int group) {
		if(group >= 0 && group < size_group()) {
			float[] component = new float[list.get(group).size()];
			for(int i = 0 ; i < component.length ; i++) {
				int c = list.get(group).get(i);
				component[i] = this.pa.red(c);
			}
			return component;
		} else {
			print_err("class R_Color method red(",group,") no group match with your demand, instead 'null' is return");
			return null; 
		}
	}

	
	public float [] green() {
		return green(0);
	}

	public float [] green(int group) {
		if(group >= 0 && group < size_group()) {
			float[] component = new float[list.get(group).size()];
			for(int i = 0 ; i < component.length ; i++) {
				int c = list.get(group).get(i);
				component[i] = pa.green(c);
			}
			return component;
		} else {
			print_err("class R_Color method green(",group,") no group match with your demand, instead 'null' is return");
			return null; 
		}
	}


	public float [] blue() {
		return blue(0);
	}
	
	public float [] blue(int group) {
		if(group >= 0 && group < size_group()) {
			float[] component = new float[list.get(group).size()];
			for(int i = 0 ; i < component.length ; i++) {
				int c = list.get(group).get(i);
				component[i] = pa.blue(c);
			}
			return component;
		} else {
			print_err("class R_Color method blue(",group,") no group match with your demand, instead 'null' is return");
			return null;
		}
	}


	public float [] alpha() {
		return alpha(0);
	}

	public float [] alpha(int group) {
		if(group >= 0 && group < size_group()) {
			float[] component = new float[list.get(0).size()];
			for(int i = 0 ; i < component.length ; i++) {
				int c = list.get(group).get(i);
				component[i] = pa.blue(c);
			}
			return component;
		} else {
			print_err("class R_Color method alpha(",group,") no group match with your demand, instead 'null' is return");
			return null;
		}
	}

	

	public vec3 [] hsb() {
		return hsb(0);
	}

	public vec3 [] hsb(int group) {
		if(group >= 0 && group < size_group()) {
			vec3[] component = new vec3[list.get(group).size()];
			for(int i = 0 ; i < component.length ; i++) {
				int c = list.get(group).get(i);
				component[i] = new vec3(pa.hue(c),pa.saturation(c),pa.brightness(c));
			}
			return component;
		} else {
			print_err("class R_Color method hsb(",group,") no group match with your demand, instead 'null' is return");
			return null;
		}
	}


	public vec3 [] rgb() {
		return rgb(0);
	}

	public vec3 [] rgb(int group) {
		if(group >= 0 && group < size_group()) {
			vec3[] component = new vec3[list.get(group).size()];
			for(int i = 0 ; i < component.length ; i++) {
				int c = list.get(group).get(i);
				component[i] = new vec3(pa.red(c),pa.green(c),pa.blue(c));
			}
			return component;
		} else {
			print_err("class R_Color method rgb(",group,") no group match with your demand, instead 'null' is return");
			return null;
		}
	}


	public vec4 [] hsba() {
		return hsba(0);
	}

	public vec4 [] hsba(int group) {
		if(group >= 0 && group < size_group()) {
			vec4[] component = new vec4[list.get(0).size()];
			for(int i = 0 ; i < component.length ; i++) {
				int c = list.get(0).get(i);
				component[i] = new vec4(pa.hue(c),pa.saturation(c),pa.brightness(c),pa.alpha(c));
			}
			return component;
		} else {
			print_err("class R_Color method hsba(",group,") no group match with your demand, instead 'null' is return");
			return null;
		}
	}


	public vec4 [] rgba() {
		return rgba(0);
	}

	public vec4 [] rgba(int group) {
		if(group >= 0 && group < size_group()) {
			vec4[] component = new vec4[list.get(group).size()];
			for(int i = 0 ; i < component.length ; i++) {
				int c = list.get(group).get(i);
				component[i] = new vec4(pa.red(c),pa.green(c),pa.blue(c),pa.alpha(c));
			}
			return component;
		} else {
			print_err("class R_Color method rgba(",group,") no group match with your demand, instead 'null' is return");
			return null;
		}
	}


	


	/**
	* Palette
	* v 0.2.1
	* 2019-2019
	*/
	private class Palette {
		private ArrayList<Integer> list;
		private Palette() {
			list = new ArrayList<Integer>();
		}

		private Palette(int... colour) {
			list = new ArrayList<Integer>();
			add(colour);
		}

		private void add(int... colour) {
			for(int i = 0 ; i < colour.length ; i++) {
				list.add(colour[i]);
			}
		}

		private void set(int index, int colour) {
			if(index >= 0 && index < list.size()) {
				list.set(index,colour);
			}
		}

		private void clear() {
			list.clear();
		}

		private void remove(int target) {
			if(target >=0 && target < list.size()) {
				list.remove(target);
			}
		}

		private int size() {
			return list.size();
		}

		private int get(int target) {
			if(target >= 0 && target < list.size()) {
				return list.get(target);
			} else {
				print_err("class R_Colour > private class Palette > method get(",target,") don't match with any element of list instead '0 is return");
				return 0;
			}

		}

		private int [] array() {
			// May be in the next Processing version when Lambda expression can be use
			int[] array = new int[list.size()];
			for(int i = 0 ; i < array.length ; i++) {
				array[i] = list.get(i);
			}
			return array;
		}
	}
}