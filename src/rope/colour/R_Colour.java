/**
 *   ___      ___   ____   _______
 *  | -  \   /   \  |    \ |  ___/
 *  | |/  | |   \ | | |\ | |  |__
 *  |    /  | | | | | |  / |  __/
 *  | |  \  \ \   / |  |/  |  |____
 *  |_| \_\  \___/  |_ |   |______/
 * 
 * Copyleft(l) 2017-2023
* R_COLOUR LIST class
* v 0.6.0
* Processing 4.2
*
* @author @knupel
* @see https://github.com/knupel/Rope
*
*/

package rope.colour;

import java.util.ArrayList;
import java.lang.System;
import processing.core.PApplet;
import processing.core.PImage;
import rope.core.Rope;
import rope.vector.vec3;
import rope.vector.vec4;

public class R_Colour extends Rope {
	private ArrayList<Palette> list;
	private PApplet pa;
	private int current_colour = 0;
	String default_name = "palette";
	
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


	// CREATE PALETTE
	//////////////////
		/**
	 * create a new empty palette
	 * @param name
	 */
	public boolean create(String name) {
		if(list.size() > 0) {
			for(Palette p : list) {
				if(p.name.equals(name)) {
					print_err("this palette", name , "still exist, try an other name to generate palette");
					return false;
				}
			}
		}
		Palette p = new Palette(name);
		list.add(p);
		return true;
	}

	/**
	 * 
	 * @param name
	 * @param img
	 * @param num
	 * @return
	 */
	public boolean create(String name, PImage img, int num) {
		for(Palette p : list) {
			if(p.name.equals(name)) {
				p.clear();
			}
		}
		
		for(int i = 0 ; i < num ; i++) {
			int x = (int)random(img.width);
			int y = (int)random(img.height);
			int c = img.get(x,y);
			this.add(name,c);
		}
		return true;
	}

	
	
	// ADD COLOUR TO PALETTE
	////////////////////////
	public void add(int index, int... colour) {
		if(list.size() > 0 && index < list.size()) {
			Palette p = list.get(index);
			p.add(colour);
		} else {
			String name = default_name + "_" + System.currentTimeMillis();
			Palette p = new Palette(name, colour);
			list.add(p);
		}
	}

	/**
	 * 
	 * @param name name of the palette, if the palette don't exist a new one is created
	 * @param colour list of int colour must be add to the palette
	 */
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
	 * @param colour list of int colour added to first palette.
	 */
	public void add(int... colour) {
		if(this.size_palette() > 0) {
			list.get(0).add(colour);
		} else {
			String name = default_name + "_" + System.currentTimeMillis();
			Palette p = new Palette(name, colour);
			list.add(p);
		}
	}



	public void add(String name, int colour_ref, int num, int type, float range_x, float range_y, float range_z) {
		// store color environment to return it at the end of the process
		float [] env = getColorMode(pa.g);
		// HSB trhead
		if(type == HUE || type == SATURATION || type == BRIGHTNESS || type == HSB) {
			pa.g.colorMode(HSB, 1);
			for(int i = 0 ; i < num ; i++) {
				int c = create_colour_hsb(colour_ref, type, range_x, range_y, range_z);
				this.add(name, c);
			}
		// RGB trhead
		} else if(type == RED || type == GREEN || type == BLUE || type == RGB) {
			pa.g.colorMode(RGB, 1);
			for(int i = 0 ; i < num ; i++) {
				int c = create_colour_rgb(colour_ref, type, range_x, range_y, range_z);
				this.add(name, c);
			}
		}
		// back to original
		pa.g.colorMode((int)env[0], env[1], env[2], env[3], env[4]);
	}

	public void add(String name, int colour_ref, int num, int type, float range) {
		add(name, colour_ref, num, type, range, range, range);
	}


	private int create_colour_rgb(int colour_ref, int type, float rx, float ry, float rz) {
		int c = 0;
		float r = 0;
		float g = 0;
		float b = 0;
		switch(type) {
			case RED :
				r = rand_red(colour_ref, rx);
				g = pa.g.green(colour_ref);
				b = pa.g.blue(colour_ref);
				break;
			case GREEN :
				r = pa.g.red(colour_ref);
				g = rand_gre(colour_ref, ry);
				b = pa.g.blue(colour_ref);
				break;
			case BLUE :
				r = pa.g.red(colour_ref);
				g = pa.g.green(colour_ref);
				b = rand_blu(colour_ref, rz);
				break;
			case RGB :
				r = rand_red(colour_ref, rx);
				g = rand_gre(colour_ref, ry);
				b = rand_blu(colour_ref, rz);
				break;
			default : break;
		}
		return pa.color(r,g,b);
	}

	private float rand_red(int colour_ref, float range) {
		float h = pa.g.red(colour_ref);
		return new_color_value(h, range);
	}

	private float rand_gre(int colour_ref, float range) {
		float h = pa.g.green(colour_ref);
		return new_color_value(h, range);
	}

	private float rand_blu(int colour_ref, float range) {
		float h = pa.g.blue(colour_ref);
		return new_color_value(h, range);
	}


	// private int create_colour_hsb(int colour_ref, int type, float range) {
	// 	return create_colour_hsb(colour_ref, type, range, range, range);
	// }

	private int create_colour_hsb(int colour_ref, int type, float rx, float ry, float rz) {
		int c = 0;
		float h = 0;
		float s = 0;
		float b = 0;
		switch(type) {
			case HUE :
				h = rand_hue(colour_ref, rx);
				s = pa.g.saturation(colour_ref);
				b = pa.g.brightness(colour_ref);
				break;
			case SATURATION :
				h = pa.g.hue(colour_ref);
				s = rand_sat(colour_ref, ry);
				b = pa.g.brightness(colour_ref);
				break;
			case BRIGHTNESS :
				h = pa.g.hue(colour_ref);
				s = pa.g.saturation(colour_ref);
				b = rand_bri(colour_ref, rz);
				break;
			case HSB :
				h = rand_hue(colour_ref, rx);
				s = rand_sat(colour_ref, ry);
				b = rand_bri(colour_ref, rz);
				break;
			default : break;
		}
		return pa.color(h,s,b);
	}

	private float rand_hue(int colour_ref, float range) {
		float h = pa.g.hue(colour_ref);
		return new_color_value(h, range);
	}

	private float rand_sat(int colour_ref, float range) {
		float h = pa.g.saturation(colour_ref);
		return new_color_value(h, range);
	}

	private float rand_bri(int colour_ref, float range) {
		float h = pa.g.brightness(colour_ref);
		return new_color_value(h, range);
	}



	private float new_color_value(float arg, float range) {
		float buf_range = range/2;
		float value = random(-buf_range, buf_range);
		arg += value;
		if(arg > 1) {
			float dif = arg - 1;
			arg = dif;
		}
		if(arg < 0) {
			arg = 1 + arg;
		}
		return arg;
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



	/**
	 * remove all palettes
	 */
	public void kill() {
		list.clear();
	}


	// clear
	public void clear() {
		for(Palette p : list) {
			p.clear();
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
				print_array(p.array());
			}
		} else if(list.size() == 0) {
			print_err("no palette available");
		}
	}

	public int size() {
		return size(0);
	}

	public int size(int group) {
		if(group >= 0 && group < size_palette()) {
			return list.get(group).size();
		} else {
			String s = "class R_Colour method size(int group) the group: " + group + " don't exist yet, add group before use this method, instead '-1' is return";
			print_err(s);
			return -1;
		}
	}


	





	
	/**
	 * 
	 * CHOOSE COLOUR
	 * 
	 */

	/**
	 * 
	 * @param name
	 * @param target
	 * @return the selected color and add this one like a current colour
	 */
	public int select(String name, int target) {
		current_colour = get_colour(name,target);
		return current_colour;
	}

	/**
	 * 
	 * @return a random color from random palette and select this one as a current colour
	 */
	public int rand() {
		int palette = floor(random(size_palette()));
		String name = list.get(palette).get_name();
		int target = floor(random(list.get(palette).array().length));
		current_colour = get_colour(name,target);
		return get_colour(name,target);
	}

	/**
	 * 
	 * @param list_name array of pallete name
	 * @return a random color from the named palette and select this one as a current colour, 
	 * if nothing match the value 0 is returned
	 */
	public int rand(String... list_name) {
		String name = this.default_name;
		if(list.size() > 0) {
			int which = floor(random(1.0f)*list_name.length);
			name = list_name[which];
			for(int i = 0 ; i < get_names().length ; i++) {
				if(get_names()[i].equals(name)) {
					int target = floor(random(get(name).length));
					current_colour = get_colour(name,target);
					return current_colour;
				}
			}
		}

		print_err("class R_Colour method rand(String name) no target match with your demand, instead '0' is return");
		return 0;
	}



	public int [] gradient(int colour_a, int colour_b, int num) {
		int [] arr = new int[num];
		float step = 1.0f / num;
		for(int i = 0 ; i < num ; i++) {
			arr[i] = pa.lerpColor(colour_a, colour_b, step *i, RGB);
		}
		return arr;
	}



  /**
	 * 
	 * GET
	 * 
	 */

	 	// get current selected colour
	public int get_current() {
		return current_colour;
	}

	/**
	 * 
	 * @return the list name of palette
	 */
	public String [] get_names() {
		String [] res = new String[this.list.size()];
		for(int i = 0 ; i < res.length ; i++) {
			res[i] = list.get(i).get_name();
		}
		return res;
	}





	/**
	 * 
	 * @param name of the colour palette
	 * @return the int array colours of this palette
	 */
	public int [] get(String name) {
		String s = "class R_Colour method get(String name) the palette: " + name + " don't exist yet, add palette before use this method";
		if(list != null && size_palette() > 0) {
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


	/**
	 * 
	 * @param group of the colour palette
	 * @return the int array colours of this palette group
	 */
	public int [] get(int group) {
		if(group >= 0 && group < size_palette()) {
			return list.get(group).array(); 
		} else {
			String s = "class R_Colour method get(int group) the group: " + group + " don't exist yet, add group before use this method";
			System.err.println(s);
			return null;
		}
	}

	/**
	 * 
	 * @param name of the colour palette
	 * @param target target colour rank in the selected palette
	 * @return
	 */
	public int get(String name, int target) {
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

	/**
	 * 
	 * @param name of the colour palette
	 * @param target target colour rank in the selected palette
	 * @return
	 * @deprecated instread use int get(String name, int target);
	 */
	@Deprecated public int get_colour(String name, int target) {
		return this.get(name, target);
	}

	public int get_master(String name) {
		int c = 0;
		float x = 0;
		float y = 0;
		float z = 0;
		int [] arr = get(name);
		for(int colour : arr) {
			x += this.pa.red(colour);
			y += this.pa.green(colour);
			z += this.pa.blue(colour);
		}
		float [] env = getColorMode(pa.g);
		pa.g.colorMode(RGB, env[1], env[2], env[3], env[4]);
		x /= arr.length;
		y /= arr.length;
		z /= arr.length;
		c = pa.color(x,y,z);
		pa.g.colorMode((int)env[0], env[1], env[2], env[3], env[4]);
		return c;
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

	// HSB

	public vec3 get_current_hsb() {
		return get_hsb_impl(get_current());
	}

	public vec3 get_hsb(String name, int target) {
		return get_hsb_impl(get_colour(name, target));
	}

	public vec3 get_hsb_impl(int c) {
		return new vec3(this.pa.hue(c), this.pa.saturation(c), this.pa.brightness(c));
	}


	public vec4 get_current_hsba() {
		return get_hsba_impl(get_current());
	}

	public vec4 get_hsba(String name, int target) {
		return get_hsba_impl(get_colour(name, target));
	}

	public vec4 get_hsba_impl(int c) {
		return new vec4(this.pa.hue(c), this.pa.saturation(c), this.pa.brightness(c), this.pa.alpha(c));	
	}

	// RGB

	public vec3 get_current_rgb() {
		return get_rgb_impl(get_current());
	}

	public vec3 get_rgb(String name, int target) {
		return get_rgb_impl(get_colour(name, target));
	}

	public vec3 get_rgb_impl(int c) {
		return new vec3(this.pa.red(c), this.pa.green(c), this.pa.blue(c));
	}
	
	public vec4 get_current_rgba() {
		return get_current_rgba_impl(get_current());
	}

	public vec4 get_current_rgba(String name, int target) {
		return get_current_rgba_impl(get_colour(name, target));
	}

	public vec4 get_current_rgba_impl(int c) {
		return new vec4(this.pa.red(c), this.pa.green(c), this.pa.blue(c), this.pa.alpha(c));	
	}


	// get all colour

	/**
	 * 
	 * @return all argument color of all the lists
	 */
	public int [] get() {
		int len = 0;
		for(Palette p : list) {
			len += p.size();
		}
		int [] arr = new int[len];
		int index = 0;
		for(Palette p : list) {
			for(int i = 0 ; i < p.size() ; i++) {
				arr[index++] = p.get(i);
			}
		}
		return arr;
	}

	public float [] hue() {
		int [] arg = this.get();
		float [] val = new float[arg.length];
		for(int i = 0 ; i < arg.length ; i++) {
			val[i] = pa.hue(arg[i]);
		}
		return val;
	}

	public float [] saturation() {
		int [] arg = this.get();
		float [] val = new float[arg.length];
		for(int i = 0 ; i < arg.length ; i++) {
			val[i] = pa.saturation(arg[i]);
		}
		return val;
	}

	public float [] brightness() {
		int [] arg = this.get();
		float [] val = new float[arg.length];
		for(int i = 0 ; i < arg.length ; i++) {
			val[i] = pa.brightness(arg[i]);
		}
		return val;
	}

	public float [] red() {
		int [] arg = this.get();
		float [] val = new float[arg.length];
		for(int i = 0 ; i < arg.length ; i++) {
			val[i] = pa.red(arg[i]);
		}
		return val;
	}

	public float [] green() {
		int [] arg = this.get();
		float [] val = new float[arg.length];
		for(int i = 0 ; i < arg.length ; i++) {
			val[i] = pa.green(arg[i]);
		}
		return val;
	}

	public float [] blue() {
		int [] arg = this.get();
		float [] val = new float[arg.length];
		for(int i = 0 ; i < arg.length ; i++) {
			val[i] = pa.blue(arg[i]);
		}
		return val;
	}

	public float [] alpha() {
		int [] arg = this.get();
		float [] val = new float[arg.length];
		for(int i = 0 ; i < arg.length ; i++) {
			val[i] = pa.alpha(arg[i]);
		}
		return val;
	}

	public vec3 [] hsb() {
		int [] arg = this.get();
		vec3 [] val = new vec3[arg.length];
		for(int i = 0 ; i < arg.length ; i++) {
			val[i] = new vec3(pa.hue(arg[i]), pa.saturation(arg[i]), pa.brightness(arg[i]));
		}
		return val;
	}

	public vec4 [] hsba() {
		int [] arg = this.get();
		vec4 [] val = new vec4[arg.length];
		for(int i = 0 ; i < arg.length ; i++) {
			val[i] = new vec4(pa.hue(arg[i]), pa.saturation(arg[i]), pa.brightness(arg[i]), pa.alpha(arg[i]));
		}
		return val;
	}

	public vec3 [] rgb() {
		int [] arg = this.get();
		vec3 [] val = new vec3[arg.length];
		for(int i = 0 ; i < arg.length ; i++) {
			val[i] = new vec3(pa.red(arg[i]), pa.green(arg[i]), pa.blue(arg[i]));
		}
		return val;
	}

	public vec4 [] rgba() {
		int [] arg = this.get();
		vec4 [] val = new vec4[arg.length];
		for(int i = 0 ; i < arg.length ; i++) {
			val[i] = new vec4(pa.red(arg[i]), pa.green(arg[i]), pa.blue(arg[i]), pa.alpha(arg[i]));
		}
		return val;
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



	


	/**
	* Palette
	* v 0.3.0
	* 2019-2022
	*/
	private class Palette {
		private ArrayList<Integer> list;
		private String name = "palette";
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