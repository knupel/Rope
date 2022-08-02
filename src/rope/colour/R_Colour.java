/**
* R_COLOUR LIST class
* v 0.5.0
* 2017-2022
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

	public R_Colour(PApplet pa, String palette_name) {
		this.pa = pa;
		this.list = new ArrayList<Palette>();
		Palette p = new Palette(palette_name);
		list.add(p);
	}

	public R_Colour(PApplet pa, String palette_name, int... list_colour) {
		this.pa = pa;
		this.list = new ArrayList<Palette>();
		Palette p = new Palette(palette_name, list_colour);
		list.add(p);
	}

		/**
	 * @deprecated instead public void add(String name, int... colour)
	 * */
	@Deprecated public void add(int group, int [] colour) {
		if(group >= 0) {
			if(group >= size_group()) {
				String s = "class R_Colour method add(int group, int [] colour) the group: " + group + " don't exist yet, add group before use this method";
				System.err.println(s);
			} else {
				list.get(group).add(colour);
			}
		}
	}

		/**
	 * @deprecated instead public void add(String name, int... colour)
	 * */
	@Deprecated public void add(int group, int colour) {
		if(group >= 0) {
			if(group >= size_group()) {
				String s = "class R_Colour method add(int group, int colour): the group " + group + " don't exist yet, add group before use this method";
				System.err.println(s);
			} else {
				list.get(group).add(colour);
			}   
		}
	}

	public void add(String name, int... colour) {
		String s = "class R_Colour method add(String name, int... colour) the palette: " + name + " don't exist yet, add palette before use this method";
		if(list.size() > 0) {
			for(Palette p : list) {
				if(p.name.equals(name)) {
					p.add(colour);
					return;
				}
			}
			Palette p = new Palette(name, colour);
			list.add(p);
		} else {
			Palette p = new Palette(name, colour);
			list.add(p);
		}
	}

	/**
	 * Add list of colour to the first palette
	 * @param colour
	 */
	public void add(int... colour) {
		if(this.size_palette() > 0) {
			list.get(0).add(colour);
		} else {
			Palette p = new Palette("palette", colour);
			list.add(p);
		}
	}

	public void add_palette(String name) {
		if(list.size() > 0) {
			for(Palette p : list) {
				if(p.name.equals(name)) {
					print_err("this palette", name , "still exist, try an other name to generate palette");
					// pa.exit();
					return;
				}
			}
		}
		Palette p = new Palette(name);
		list.add(p);
	}

	/**
	 * @deprecated instead public void add_palette(String name)
	 * */
	@Deprecated public void add_group() {
		Palette p = new Palette();
		list.add(p);
	}

		/**
	 * @deprecated instead public void add_palette(String name)
	 * */
	@Deprecated public void add_group(int num) {
		for(int i = 0 ; i < num ; i++) {
			Palette p = new Palette();
			list.add(p);
		}
	}

	public void set(int index, int colour) {
		set(0, index, colour);
	}

	/**
	 * @deprecated instead use public void set(String name, int index, int colour)
	 * @param group
	 * @param index
	 * @param colour
	 */
	@Deprecated public void set(int group, int index, int colour) {
		if(group >= 0 && group <= size_group() && index >= 0 && index < list.get(group).size()) {
			list.get(group).set(index,colour);
		}
	}

	public void set(String name, int index, int colour) {
		if(list.size() > 0) {
			for(Palette p : list) {
				if(p.name.equals(name)) {
					p.set(index,colour);
					return;
				}
			}
		}
	}



 
	// clear
	public void clear() {
		for(Palette p : list) {
			p.clear();
		}
	}

			/**
	 * @deprecated instead public void clear(String name)
	 * */
	@Deprecated public void clear(int group) {
		if(group >= 0 && group < size_group()) {
			list.get(group).clear();
		} else {
			print_err("class R_Colour method clear(",group,") this group don't match with any group");
		}
	}

	public void clear(String name) {
		if(list.size() > 0) {
			for(Palette p : list) {
				if(p.get_name().equals(name)) {
					p.clear();
				}
			}		
		} else {
			print_err("class R_Colour method clear(",name,") this palette don't match with any palette");
		}
	}

			/**
	 * @deprecated instead public void remove(String name, int index)
	 * */
	@Deprecated public void remove(int group, int index) {
		if(group >= 0 && group < size_group()) {
			list.get(group).remove(index);
		} else {
			print_err("class R_Colour method remove(",group,") this group don't match with any group");
		}
	}

	public void remove(String name, int index) {
		if(list.size() > 0) {
			for(Palette p : list) {
				if(p.get_name().equals(name)) {
					p.remove(index);
				}
			}		
		} else {
			print_err("class R_Colour method remove(",name,") this name don't match with any palette");
		}
	}
	

	// GET
	
	/**
	 * instead use public int size_palette()
	 * @return
	 */
	@Deprecated public int size_group() {
		return list.size();
	}

	/**
	 * 
	 * @return the num / quantity of palette vailable
	 */
	public int size_palette() {
		return list.size();
	}

	public void print_palette() {
		if(list != null && list.size() > 0) {
			for(Palette p : list) {
				print_out(p.get_name(), p.size());
				print_out(p.array());
			}
		}
	}

	public int size() {
		return size(0);
	}

	@Deprecated public int size(int group) {
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

	/**
	 * @deprecated instead use int [] get(String name)
	 * @param group
	 * @return
	 */
	@Deprecated public int [] get(int group) {
		if(group >= 0 && group < size_group()) {
			return list.get(group).array(); 
		} else {
			String s = "class R_Colour method get(int group) the group: " + group + " don't exist yet, add group before use this method";
			System.err.println(s);
			return null;
		}
	}

	public int [] get(String name) {
		String s = "class R_Colour method get(String name) the palette: " + name + " don't exist yet, add palette before use this method";
		if(list != null && list.size() > 0) {
			for(Palette p : list) {
				if(p.get_name().equals(name)) {
					return p.array();
				}
			}
			System.err.println(s);
			return null;
		} else {
			System.err.println(s);
			return null;
		}
	}


	// get colour

	/**
	 * 
	 * @return a random color from random palette
	 */
	public int rand() {
		int palette = floor(random(size_palette()));
		String name = list.get(palette).get_name();
		int target = floor(random(list.get(palette).array().length));	
		return get_colour(name,target);
	}

	/**
	 * @deprecated instead use public int rand(String name)
	 * @param group
	 * @return
	 */
	@Deprecated public int rand(int group) {
		int target = 0;
		if(group < list.size()) {
			target = floor(random(list.get(group).array().length));
		} else {
			group = 0;
			target = floor(random(list.get(group).array().length));
		}
		return get_colour(group,target);
	}

	public int rand(String name) {
		if(list.size() > 0) {
			for(Palette p : list) {
				if(p.get_name().equals(name)) {
					int target = floor(random(p.array().length));
					return get_colour(name,target);
				}
			}
		}
		print_err("class R_Colour method rand(String name) no target match with your demand, instead '0' is return");
		return 0;
	}




	/**
	 * 
	 * @param name of the colour palette
	 * @param target target colour rank in the selected palette
	 * @return
	 */
	public int get_colour(String name, int target) {
		String s = "class R_Colour method get_.../...(): no target match with your demand for String " + name + " or int " + target + " instead '0' is return";
		if(list.size() > 0) {
			for(Palette p : list) {
				if(p.get_name().equals(name) && target < p.array().length) {
					return p.array()[target];
				}
			}
			print_err_tempo(60, s);
			return 0;
		}
		print_err_tempo(60, s);
		return 0;
	}


	public float get_hue(String name, int target) {
		return this.pa.hue(get_colour(name, target));
	}


	public float get_saturation(String name, int target) {
		return this.pa.saturation(get_colour(name, target));
	}
	

	public float get_brightness(String name, int target) {
		return this.pa.brightness(get_colour(name, target));
	}

	public float get_red(String name, int target) {
		return this.pa.red(get_colour(name, target));
	}
	

	public float get_green(String name, int target) {
		return this.pa.green(get_colour(name, target));
	}

	public float get_blue(String name, int target) {
		return this.pa.blue(get_colour(name, target));
	}


	public float get_alpha(String name, int target) {
		return this.pa.alpha(get_colour(name, target));
	}


	public vec3 get_hsb(String name, int target) {
		int c = get_colour(name, target);
		return new vec3(this.pa.hue(c), this.pa.saturation(c), this.pa.brightness(c));
	}


	public vec4 get_hsba(String name, int target) {
		int c = get_colour(name, target);
		return new vec4(this.pa.hue(c), this.pa.saturation(c), this.pa.brightness(c), this.pa.alpha(c));
		
	}


	public vec3 get_rgb(String name, int target) {
		int c = get_colour(name, target);
		return new vec3(pa.red(c),pa.green(c),pa.blue(c));
	}
	
	public vec4 get_rgba(String name, int target) {
		int c = get_colour(name, target);
		return new vec4(pa.red(c),pa.green(c),pa.blue(c),pa.alpha(c));
	}


		/**
	 * @depreacated instead use void public get_colour(String name, int target) 
	 * @param group
	 * @param target
	 * @return
	 */
	@Deprecated public int get_colour(int group, int target) {
		if(target >= 0 && group >= 0 && group < size_group() && target < list.get(group).array().length) {
			return list.get(group).array()[target];
		} else {
			print_err("class R_Colour method get_colour() no target match with your demand, instead '0' is return");
			return 0;
		}
	}

		/**
	 * @depreacated instead use void public get_hue(String name, int target) 
	 * @param group
	 * @param target
	 * @return
	 */
	@Deprecated public float get_hue(int group, int target) {
		if(group >= 0 && group < size_group()) {
			return pa.hue(list.get(group).get(target));
		} else {
			print_err("class R_Color method get_hue(",group,") no group match with your demand, instead '0' is return");
			return 0;
		}
	}

		/**
	 * @depreacated instead use void public get_saturation(String name, int target) 
	 * @param group
	 * @param target
	 * @return
	 */
	@Deprecated public float get_saturation(int group, int target) {
		if(group >= 0 && group < size_group()) {
			return this.pa.saturation(list.get(group).get(target));
		} else {
			print_err("class R_Color method get_saturation(",group,") no group match with your demand, instead '0' is return");
			return 0;
		}
	}
	
		/**
	 * @depreacated instead use void public get_brightness(String name, int target) 
	 * @param group
	 * @param target
	 * @return
	 */
	@Deprecated public float get_brightness(int group, int target) {
		if(group >= 0 && group < size_group()) {
			return this.pa.brightness(list.get(group).get(target));
		} else {
			print_err("class R_Color method get_brightness(",group,") no group match with your demand, instead '0' is return");
			return 0;
		}
	}

			/**
	 * @depreacated instead use void public get_red(String name, int target) 
	 * @param group
	 * @param target
	 * @return
	 */
	@Deprecated public float get_red(int group, int target) {
		if(group >= 0 && group < size_group()) {
			return this.pa.red(list.get(group).get(target));
		} else {
			print_err("class R_Color method get_red(",group,") no group match with your demand, instead '0' is return");
			return 0;
		}
	}
	
		/**
	 * @depreacated instead use void public get_green(String name, int target) 
	 * @param group
	 * @param target
	 * @return
	 */
	@Deprecated public float get_green(int group, int target) {
		if(group >= 0 && group < size_group()) {
			return this.pa.green(list.get(group).get(target));
		} else {
			print_err("class R_Color method get_green(",group,") no group match with your demand, instead '0' is return");
			return 0;
		}
	}

			/**
	 * @depreacated instead use void public get_blue(String name, int target) 
	 * @param group
	 * @param target
	 * @return
	 */
	@Deprecated public float get_blue(int group, int target) {
		if(group >= 0 && group < size_group()) {
		 return this.pa.blue(list.get(group).get(target));
		} else {
			print_err("class R_Color method get_blue(",group,") no group match with your demand, instead '0' is return");
			return 0;
		}
	}

		/**
	 * @depreacated instead use void public get_alpha(String name, int target) 
	 * @param group
	 * @param target
	 * @return
	 */
	@Deprecated public float get_alpha(int group, int target) {
		if(group >= 0 && group < size_group()) {
			return this.pa.alpha(list.get(group).get(target));
		} else {
			print_err("class R_Color method get_alpha(",group,") no group match with your demand, instead '0' is return");
			return 0;
		}
	}

		/**
	 * @depreacated instead use void public get_hsb(String name, int target) 
	 * @param group
	 * @param target
	 * @return
	 */
	@Deprecated public vec3 get_hsb(int group, int target) {
		if(group >= 0 && group < size_group()) {
			int c = list.get(group).get(target);
			return new vec3(this.pa.hue(c),this.pa.saturation(c),this.pa.brightness(c));
		} else {
			print_err("class R_Color method get_hsb(",group,") no group match with your demand, instead 'null' is return");
			return null;
		}
	}

		/**
	 * @depreacated instead use void public get_hsba(String name, int target) 
	 * @param group
	 * @param target
	 * @return
	 */
	@Deprecated public vec4 get_hsba(int group, int target) {
		if(group >= 0 && group < size_group()) {
			int c = list.get(group).get(target);
			return new vec4(this.pa.hue(c),this.pa.saturation(c),this.pa.brightness(c),this.pa.alpha(c));
		} else {
			print_err("class R_Color method get_hsba(",group,") no group match with your demand, instead 'null' is return");
			return null;
		}
	}

		/**
	 * @depreacated instead use void public get_rgb(String name, int target) 
	 * @param group
	 * @param target
	 * @return
	 */
	@Deprecated public vec3 get_rgb(int group, int target) {
		if(group >= 0 && group < size_group()) {
			int c = list.get(group).get(target);
			return new vec3(pa.red(c),pa.green(c),pa.blue(c));
		} else {
			print_err("class R_Color method get_rgb(",group,") no group match with your demand, instead 'null' is return");
			return null;
		}
	}
	
		/**
	 * @depreacated instead use void public get_rgba(String name, int target) 
	 * @param group
	 * @param target
	 * @return
	 */
	@Deprecated public vec4 get_rgba(int group, int target) {
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

	public float [] hue(String name) {
		if(get(name) == null) {
			return null;
		}
		int [] arg = get(name);
		float[] component = new float[arg.length];
		for(int i = 0 ; i < component.length ; i++) {
			component[i] = this.pa.hue(arg[i]);
		}
		return component;
	}

	/**
	* @depreacated instead use void public hue(String name)
	 * @param group
	 * @return
	 */
	@Deprecated public float [] hue(int group) {
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

	public float [] saturation(String name) {
		if(get(name) == null) {
			return null;
		}
		int [] arg = get(name);
		float[] component = new float[arg.length];
		for(int i = 0 ; i < component.length ; i++) {
			component[i] = this.pa.saturation(arg[i]);
		}
		return component;
	}

		/**
	* @depreacated instead use void public saturation(String name)
	 * @param group
	 * @return
	 */
	@Deprecated public float [] saturation(int group) {
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
	
	public float [] brightness(String name) {
		if(get(name) == null) {
			return null;
		}
		int [] arg = get(name);
		float[] component = new float[arg.length];
		for(int i = 0 ; i < component.length ; i++) {
			component[i] = this.pa.brightness(arg[i]);
		}
		return component;
	}

	/**
	* @depreacated instead use void public brightness(String name)
	 * @param group
	 * @return
	 */
	@Deprecated public float [] brightness(int group) {
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

	public float [] red(String name) {
		if(get(name) == null) {
			return null;
		}
		int [] arg = get(name);
		float[] component = new float[arg.length];
		for(int i = 0 ; i < component.length ; i++) {
			component[i] = this.pa.red(arg[i]);
		}
		return component;
	}

		/**
	* @depreacated instead use void public red(String name)
	 * @param group
	 * @return
	 */
	@Deprecated public float [] red(int group) {
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

	public float [] green(String name) {
		if(get(name) == null) {
			return null;
		}
		int [] arg = get(name);
		float[] component = new float[arg.length];
		for(int i = 0 ; i < component.length ; i++) {
			component[i] = this.pa.green(arg[i]);
		}
		return component;
	}

	/**
	* @depreacated instead use void public green(String name)
	 * @param group
	 * @return
	 */
	@Deprecated public float [] green(int group) {
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

	public float [] blue(String name) {
		if(get(name) == null) {
			return null;
		}
		int [] arg = get(name);
		float[] component = new float[arg.length];
		for(int i = 0 ; i < component.length ; i++) {
			component[i] = this.pa.blue(arg[i]);
		}
		return component;
	}
	
	/**
	* @depreacated instead use void public blue(String name)
	 * @param group
	 * @return
	 */
	@Deprecated public float [] blue(int group) {
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

	public float [] alpha(String name) {
		if(get(name) == null) {
			return null;
		}
		int [] arg = get(name);
		float[] component = new float[arg.length];
		for(int i = 0 ; i < component.length ; i++) {
			component[i] = this.pa.alpha(arg[i]);
		}
		return component;
	}

		/**
	* @depreacated instead use void public alpha(String name)
	 * @param group
	 * @return
	 */
	@Deprecated public float [] alpha(int group) {
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

	public vec3 [] hsb(String name) {
		if(get(name) == null) {
			return null;
		}
		int [] arg = get(name);
		vec3[] component = new vec3[arg.length];
		for(int i = 0 ; i < component.length ; i++) {
			component[i] = new vec3(pa.hue(arg[i]),pa.saturation(arg[i]),pa.brightness(arg[i]));
		}
		return component;
	}

			/**
	* @depreacated instead use void public hsb(String name)
	 * @param group
	 * @return
	 */
	@Deprecated public vec3 [] hsb(int group) {
		if(group >= 0 && group < size_group()) {
			vec3[] component = new vec3[list.get(group).size()];
			for(int i = 0 ; i < component.length ; i++) {
				int c = list.get(group).get(i);
				component[i] = new vec3(pa.hue(c), pa.saturation(c), pa.brightness(c));
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

	public vec3 [] rgb(String name) {
		if(get(name) == null) {
			return null;
		}
		int [] arg = get(name);
		vec3[] component = new vec3[arg.length];
		for(int i = 0 ; i < component.length ; i++) {
			component[i] = new vec3(pa.red(arg[i]), pa.green(arg[i]), pa.blue(arg[i]));
		}
		return component;
	}

	@Deprecated public vec3 [] rgb(int group) {
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

	public vec4 [] hsba(String name) {
		if(get(name) == null) {
			return null;
		}
		int [] arg = get(name);
		vec4[] component = new vec4[arg.length];
		for(int i = 0 ; i < component.length ; i++) {
			component[i] = new vec4(pa.hue(arg[i]), pa.saturation(arg[i]), pa.brightness(arg[i]), pa.alpha(arg[i]));
		}
		return component;
	}

	@Deprecated public vec4 [] hsba(int group) {
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

	public vec4 [] rgba(String name) {
		if(get(name) == null) {
			return null;
		}
		int [] arg = get(name);
		vec4[] component = new vec4[arg.length];
		for(int i = 0 ; i < component.length ; i++) {
			component[i] = new vec4(pa.red(arg[i]), pa.green(arg[i]), pa.blue(arg[i]), pa.alpha(arg[i]));
		}
		return component;
	}

	@Deprecated public vec4 [] rgba(int group) {
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
	* v 0.3.0
	* 2019-2022
	*/
	private class Palette {
		private ArrayList<Integer> list;
		private String name = "";
		private int id = -1;
		// private int rank = 0;

		private Palette() {
			list = new ArrayList<Integer>();
			id = (int)random(0, Integer.MAX_VALUE);
		}

		private Palette(int... colour) {
			list = new ArrayList<Integer>();
			add(colour);
		}


		private Palette(String name) {
			list = new ArrayList<Integer>();
			id = (int)random(0, Integer.MAX_VALUE);
			this.name = name;
		}

		private Palette(String name, int... colour) {
			list = new ArrayList<Integer>();
			add(colour);
			this.name = name;
		}

		/**
		 * 
		 * @param colour list of color must be added
		 */
		private void add(int... colour) {
			for(int i = 0 ; i < colour.length ; i++) {
				list.add(colour[i]);
			}
		}

		/**
		 * 
		 * @param index position of the color in the palette from 0 to max
		 * @param colour the new colour that must use instead the oldest.
		 */
		private void set(int index, int colour) {
			if(index >= 0 && index < list.size()) {
				list.set(index,colour);
			}
		}

		private void clear() {
			list.clear();
		}

		/**
		 * 
		 * @param target remove target colour in the palette at a specific index
		 */
		private void remove(int target) {
			if(target >=0 && target < list.size()) {
				list.remove(target);
			}
		}

		/**
		 * 
		 * @return the quantity of colour in the palette
		 */
		private int size() {
			return list.size();
		}

		private String get_name() {
			return this.name;
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