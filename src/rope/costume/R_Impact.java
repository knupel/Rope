/**
 *   ___      ___   ____   _______
 *  | -  \   /   \  |    \ |  ___/
 *  | |/  | |   \ | | |\ | |  |__
 *  |    /  | | | | | |  / |  __/
 *  | |  \  \ \   / |  |/  |  |____
 *  |_| \_\  \___/  |_ |   |______/
 * 
 * R_Impact
 * v 0.4.2
 * 2022-2023
 * @author @knupel
 * @see https://github.com/knupel/Rope
*/

package rope.costume;


import java.util.ArrayList;
import java.util.Arrays;

import processing.core.PApplet;
import rope.pixo.R_Pix;
import rope.core.R_Graphic;
import rope.mesh.R_Line2D;
import rope.mesh.R_Node;
import rope.mesh.R_Shape;
import rope.tool.R_Puppet2D;
import rope.utils.R_Pair;
import rope.vector.bvec2;
import rope.vector.bvec4;
import rope.vector.ivec2;
import rope.vector.vec;
import rope.vector.vec2;
import rope.vector.vec3;
import rope.vector.vec5;

import processing.core.PApplet;

public class R_Impact extends R_Graphic {
	// BUILD
	private boolean build_is = false;
	private boolean heart_is = false;
	// PUPPET MASTER
	private ArrayList<R_Puppet2D>[] main;
	private ArrayList<R_Puppet2D> heart;
	// LINE
	private ArrayList<R_Line2D>[] circle;
	// ID / MODE
	private int ID_MAIN = 0;
	private int ID_CIRCLE = 1;
	private int ID_HEART = 2;
	private int mode = LINE;
	// SHAPE
	
	private ArrayList<R_Shape> imp_shapes_center = new ArrayList<R_Shape>();
	private ArrayList<R_Shape> imp_shapes = new ArrayList<R_Shape>();
	private ArrayList<R_Shape> imp_shapes_external = new ArrayList<R_Shape>();
	// POINT
	private ArrayList<R_Node> nodes = new ArrayList<R_Node>();

	// GLOBAL POSTION of the impact
	private vec3 pos = new vec3();

	private float radius = 0;
	private float marge = 2; // use for in_line detection
	private int base = 5;
	// mute part of impact shape
	private boolean use_mute_is = false;
	// line mode
	private int line_mode = 0; // default is continuous line
	// update for refresh case
	private int next_frameCount = 0;
	// pixel parl
	private boolean update_pixels_is = false;
	private boolean set_gradient_pixels_is = false;
	// pixel growth evolution
	private int type_evo_pixel = NORMAL;
	private ivec2 level_evo_pixel = new ivec2();
	private ivec2 step_evo_pixel = new ivec2();
	// pixel rendering
	private ivec2 mode_abs_pixel = new ivec2(NORMAL, 1);
	private ivec2 mode_ord_pixel = new ivec2(NORMAL, 1);
	private R_Pair<Float, Float> pixel_xy = new R_Pair<Float, Float>();

	// density
	private boolean use_gradient_density_is = false;
	private vec2 density = new vec2(1);
	private boolean use_gradient_thickness_is = false;
	// thickness
	private vec2 thickness = new vec2(1);
	// stroke colour
	private boolean use_gradient_stroke_is = false;
	private ivec2 stroke = new ivec2(0);
	// fill color
	private boolean use_gradient_fill_is = false;
	private ivec2 fill = new ivec2(0);
	// mode
	// palette colour
	private int [] pix_colour;

	private float growth_fact_spiral = 1;

	// main data
	private int main_num;
	private int main_iter;
	private float main_angle;
	// x is minimum, y maximum and z the type of distribution
	private vec3 main_growth_ratio = new vec3(0);
	private int diam;

	// circle data
	// x is minimum, y maximum and z the type of distribution
	private vec3 data_circle = new vec3();
	private vec3 circle_growth_ratio = new vec3(0);
	
	////////////////////////////
	// CONSTRUCTOR
	/////////////////////////////
	public R_Impact(PApplet pa, int diameter) {
		super(pa);
		set_diam(diameter);
		init();
	}

	public R_Impact(PApplet pa, int x, int y, int diameter) {
		super(pa);
		pos(x,y);
		set_diam(diameter);
		init();
	}


	private void init() {
		// It's very small value for the result, there is something weird
		// main data
		set_num_main(this.base);
		set_iter_main(this.base);
		// circle data
		set_num_circle(this.base);
		set_iter_circle(this.base);
	}



	////////////////////////////////
	// SETTING
	/////////////////////////////////
	public R_Impact pos(float x, float y) {
		this.pos.set(x,y,0);
		return this;
	}

	public R_Impact pos(vec2 pos) {
		this.pos.set(pos.x(),pos.y(),0);
		return this;
	}


	// SET DATA MAIN
	///////////////////
	public R_Impact set_num_main(int num) {
		this.main_num = num;
		return this;
	}

	public R_Impact set_iter_main(int iter) {
		this.main_iter = iter;
		return this;
	}


	public R_Impact set_angle_main(float angle) {
		this.main_angle = angle;
		return this;
	}

	public R_Impact set_diam(int diameter) {
		this.diam = diameter;
		return this;
	}

		/**
	 * by default min and max is 0, the value is like normal value, must be set with small value, 
	 * is better like -2 to 2, after that's can give a strange result.
	 * with use this value to find a random value to multiblie the original main arg
	 * @param min it's good option to use negative value
	 * @param max it's good option to use positive value
	 * @param distribution it's a type of distrubution where 0 is lineare /  choice : -1, 0 or 1
	 * @return
	 */
	public R_Impact set_growth_main(int distribution, float min, float max) {
		main_growth_ratio.set(min, max, distribution);
		return this;
	}

	public R_Impact set_growth_main(int distribution) {
		main_growth_ratio.z(distribution);
		return this;
	}



	/**
	 * 
	 * @param is set if if the shape heart must be use on the first level of the main line
	 * @return
	 */
	public R_Impact heart_is(boolean is) {
		this.heart_is = is;
		return this;
	}

	// SET DATA CIRCLE
	///////////////////

	public R_Impact set_num_circle(int num) {
		this.data_circle.x(num);
		return this;
	}

	public R_Impact set_iter_circle(int iter) {
		this.data_circle.y(iter);
		return this;
	}



	public R_Impact set_growth_circle(int distribution) {
		circle_growth_ratio.z(distribution);
		return this;
	}

	/**
	 * by default min and max is 0, the value is like normal value, must be set with small value, 
	 * is better like -2 to 2, after that's can give a strange result.
	 * with use this value to find a random value to multiblie the original circle arg
	 * @param min it's good option to use negative value
	 * @param max it's good option to use positive value
	 * @param distribution it's a type of distrubution where 0 is lineare
	 * @return
	 */
	public R_Impact set_growth_circle(int distribution, float min, float max) {
		circle_growth_ratio.set(min, max, distribution);
		return this;
	}

	// OTHER SETTING
	///////////////////

	public R_Impact growth_factor_spiral(float growth) {
		this.growth_fact_spiral = abs(growth);
		return this;
	}

	public R_Impact spiral() {
		this.mode = SPIRAL;
		return this;
	}

	public R_Impact normal() {
		this.mode = LINE;
		return this;
	}














	/////////////////////////////
	// UPDATE
	//////////////////////////

	public void update_pixels_is(boolean is) {
		this.update_pixels_is = is;
	}

	protected boolean update_pixels_is() {
		return this.update_pixels_is;
	}


	/**
	 * Overwrite the R_Graphic function to set pixel density the line dynamicily 
	 */
	public void pixel_density_is(boolean is) {
		this.pixel_density_is = is;
		if(build_is()) {
			// main
			for(int i = 0 ; i < main.length ; i++) {
				for(R_Puppet2D line : main[i]) {
					line.pixel_density_is(is);
				}
			}
			// circle
			for(int i = 0 ; i < circle.length ; i++) {
				for(R_Line2D line : circle[i]) {
					line.pixel_density_is(is);
				}
			}
			// heart
			for(R_Puppet2D line : heart) {
				line.pixel_density_is(is);
			}
		}
	}

	// It's for the case where there are dynamic change on the net impact

	/**
	 * utils for the puppet case with node management.
	 * May be it's possible to refactor with the option build_is(boolean is) ???
	 */
	public void update() {
		// reset id circle, to give the opportuny to refresh the rank and id polygon
		for(int i = 0 ; i < circle.length ; i++) {
			for(R_Line2D line : circle[i]) {
				line.id_f(Integer.MIN_VALUE);
			}
		}

		for(int i = 0 ; i < main.length ; i++) {
			for(R_Puppet2D puppet_m : main[i]) {
				update_puppet(puppet_m);
			}
		}
		for(R_Puppet2D puppet_h : heart) {
			update_puppet(puppet_h);
		}
		build_polygon();
	}

	private void update_puppet(R_Puppet2D puppet) {
		puppet.update();
		puppet.update_puppets();
	}

	/**
	 * Must be use all the time not only where there a changement
	 */
	public void update_preset() {
		for(int i = 0 ; i < main.length ; i++) {
			for(R_Puppet2D puppet_m : main[i]) {
				update_pair(puppet_m);
			}
		}
		for(R_Puppet2D puppet_h : heart) {
			update_pair(puppet_h);
		}
	}

	private void update_pair(R_Puppet2D puppet) {
		for(int k = 0 ; k < puppet.size() ; k++) {
			R_Pair<vec3,vec5> pair = puppet.get_puppet(k);
			pair.a().set(puppet.get_puppet_online(k));
		}
	}


















	//////////////////////////////
	// GETING
	//////////////////////////////

	/**
	 * 
	 * @return the line mode 0 is normal, 1 is for pixel x1, 2 pixel x2
	 */
	public int get_line_mode() {
		return line_mode;
	}

	/**
	 * 
	 * @return the calculated value of the real farest point of the center
	 */
	public float radius() {
		return this.radius;
	}

	/**
	 * 
	 * @return the value pass to set_diam() or constructor
	 */
	public int diam() {
		return this.diam;
	}

	public vec2 pos() {
		return this.pos.xy();
	}

	public int get_mode() {
		return this.mode;
	}

	public float get_growth_spiral() {
		return this.growth_fact_spiral;
	}





	// GET DATA MAIN
	///////////////////

	public float get_growth_main() {
		return this.diam() / get_iter_main() * 0.5f;
	}

	public vec2 get_growth_main_ratio() {
		return this.main_growth_ratio.xy();
	}

	public int get_growth_main_distribution() {
		return (int)this.main_growth_ratio.z();
	}

	public int get_num_main() {
		return this.main_num;
	}

	public int get_iter_main() {
		return this.main_iter;
	}

	public float get_angle_main() {
		return this.main_angle;
	}

	public boolean heart_is() {
		return this.heart_is;
	}

	// GET ASPECT
	/////////////////
	public vec2 get_thickness() {
		return this.thickness;
	}

	public vec2 get_density() {
		return this.density;
	}

	public ivec2 get_stroke() {
		return this.stroke;
	}

	public ivec2 get_fill() {
		return this.fill;
	}

	public int [] get_pixels_colour() {
		return this.pix_colour;
	}


	// GET DATA CIRCLE
	///////////////////

	public vec2 get_growth_circle_ratio() {
		return this.circle_growth_ratio.xy();
	}

	public int get_growth_circle_distribution() {
		return (int)this.circle_growth_ratio.z();
	}

	public float get_growth_circle() {
		return this.diam() / get_num_circle() * 0.5f;
	}


	public int get_num_circle() {
		return (int)this.data_circle.x();
	}

	public int get_iter_circle() {
		return (int)this.data_circle.y();
	}


	// GET SIZE
	////////////////////////

	public int [] get_size_main() {
		return get_size_impl(main, get_num_main());
	}

	public int [] get_size_circle() {
		return get_size_impl(circle, get_num_circle());
	}

	private int [] get_size_impl(ArrayList[] list, int len) {
		int [] size = new int[len];
		for(int i = 0 ; i < len ; i++) {
			if(list != null && i < list.length) {
				size[i] = list[i].size();
			}	else {
				size[i] = 0;
			}
		}
		return size;
	}

	// GET LIST
	/////////////////////

	public ArrayList<R_Line2D> get_lines() {
		ArrayList<R_Line2D> buf = new ArrayList<R_Line2D>();
		for(int i = 0 ; i <  main.length ; i++) {
			buf.addAll(main[i]);
		}
		for(int i = 0 ; i <  circle.length ; i++) {
			buf.addAll(circle[i]);
		}
		buf.addAll(heart);
		return buf;
	}

	public ArrayList<R_Puppet2D> get_lines_main(int index) {
		if(index >= 0 && index < main.length) {
			return main[index];
		}
		return null;
	}

	/**
	* return circle
	 */
	public ArrayList<R_Line2D> get_lines_circle(int index) {
		if(index >= 0 && index < circle.length) {
			return circle[index];
		}
		return null;
	}


	public ArrayList<R_Line2D> get_lines_circle_branch(int index) {
		return get_lines_circle_branch(index,true);
	}

	/**
	 * 
	 * @param index select wich main branch you want add
	 * @param only_visible_is if it's true add only the visible line
	 * @return
	 */
	public ArrayList<R_Line2D> get_lines_circle_branch(int index, boolean only_visible_is) {
		ArrayList<R_Line2D> list = new ArrayList<R_Line2D>();
		for(int i = 0 ; i < circle.length ; i++) {
			for(int k = 0 ; k < circle[i].size() ; k++) {
				R_Line2D line = circle[i].get(k);
				if(line_branch_is(index, line)) {
					if(only_visible_is) {
						if(!line.mute_is()) {
							list.add(line);
						}
					} else {
						list.add(line);
					}
				}
			}
		}
		return list;
	}

	public ArrayList<R_Puppet2D> get_lines_heart() {
		return heart;
	}

	public ArrayList<R_Node> get_nodes() {
		return nodes;
	}

	public ArrayList<R_Node> get_nodes_main() {
		ArrayList<R_Node> buf = new ArrayList<R_Node>();
		for(R_Node n : nodes) {
			if(n.id().a() == ID_MAIN) {
				buf.add(n);
			}
		}
		return buf;
	}

	// get polygon
	////////////////////////////

	public ArrayList<R_Shape> get_all_polygons() {
		ArrayList<R_Shape> buf = new ArrayList<R_Shape>();
		buf.addAll(imp_shapes_external);
		buf.addAll(imp_shapes_center);
		buf.addAll(imp_shapes);
		return buf;
	}


	public ArrayList<R_Shape> get_polygon_external() {
		return imp_shapes_external;
	}

	public ArrayList<R_Shape> get_polygon_heart() {
		return imp_shapes_center;
	}

	public ArrayList<R_Shape> get_polygons() {
		return imp_shapes;
	}

	// may be need to be refactoring to arrayList or R_Shape
	public vec2 [] get_polygon_array_heart() {
		if(heart.size() == 0) {
			return null;
		}
		vec2 [] polygon = new vec2[get_num_main()];
		for(int i = 0 ; i < polygon.length ; i++) {
			polygon[i] = heart.get(i).a().copy();
		}
		return polygon;
	}

	// get line heart from lc
	//////////////////////////

	private R_Line2D get_line_heart(R_Line2D lc) {
		if(heart.size() > 0 ) {
			if(lc.id().a() < 0 && lc.id().a() > Integer.MIN_VALUE) {
				return heart.get(get_abs_id(lc.id().a()));
			} else if (lc.id().b() < 0 && lc.id().b() > Integer.MIN_VALUE) {
				return heart.get(get_abs_id(lc.id().b()));
			} else {
				return heart.get(lc.id().a());
			}
		}
		return null;
	}

	// ID
	/////////////////

	private int get_abs_id(int raw_id) {
		int id = raw_id;
		// for line heart case
		if(id < 0) {
			id = abs(id + 1);
		}
		return id;
	}





























	///////////////////////////
	// BUILD GLOBAL
	///////////////////////////

	/**
	 * Build the structure network with the default paramater is there is no specific setting
	 */
	public void build() {
		build_main();
		build_heart();
		build_circle();
		add_nodes();
		build_is(true);
	}


	public boolean build_is() {
		return this.build_is;
	}

	private void build_is(boolean is) {
		this.build_is = is;
	}

	////////////////////////
	// BUILD STRUCTURE
	/////////////////////////

	private float growth_main_impl(int index) {
		float buf = get_growth_main();
		int type = get_growth_main_distribution();
		float ratio = 1;
		float power = 2;
		switch(type) {
			case -1 -> {
				ratio = map(index,  0, get_iter_main(), 0.1f, power);
				buf *= ratio;
			}
			case 0 -> { }
			case 1 -> {
				ratio = map(index,  0, get_iter_main(), power, 0.1f);
				buf *= ratio;
			}
			default -> { }
		}

		if(!get_growth_main_ratio().equals(0)) {
			float jitter = random(get_growth_main() * get_growth_main_ratio().x(), 
														get_growth_main() * get_growth_main_ratio().y());
			if(jitter > 0) {
				buf+= jitter;
			}
		}
		return buf;
	}


	private float growth_circle_impl(int index, float inc) {
		float buf = get_growth_circle();

		float ratio = 1;
		float factor = 1;
		int type = get_growth_circle_distribution();
		switch(type) {
			case -1 -> {
				// more density in the center
				float start = 0;
				// because the density is higher in the center
				// we need to create an offset for the case where the heart is active
				// because the heart can hide a lot of lines
				if(heart_is()) {
					start = 1.0f / get_iter_main();
				}
				ratio = map(index,  0, get_num_circle(), start, 1);
				factor = pow(ratio,4);
				buf = radius() * factor;
			}
			case 0 -> buf *= (index + inc);
			case 1 -> {
				// more density on the outside
				ratio = map(index,  0, get_num_circle(), 1, 0);
				factor = 1- pow(ratio,3);
				buf = radius() * factor;
			}
			default -> buf *= (index + inc);
		}

		// jitter / randomize part when the position is good
		if(!get_growth_circle_ratio().equals(0)) {
			float jitter = random(get_growth_circle() * get_growth_circle_ratio().x(), 
														get_growth_circle() * get_growth_circle_ratio().y());
			buf += jitter;
		}
		return buf;
	}


	// BUILD MAIN BRANCH
	/////////////////////
	@SuppressWarnings("unchecked")private void build_main() {
		main = new ArrayList[get_num_main()];
		float angle_step = TAU / get_num_main();
		float angle = 0f;
		radius = 0;

		for(int i = 0 ; i < get_num_main() ; i++) {
			main[i] = new ArrayList<R_Puppet2D>();
			main_impl(i, angle);
			angle += angle_step;
			R_Line2D line = main[i].get(main[i].size() -1);
			float dist = dist(line.b(), pos());
			if(dist > radius) {
				radius = dist;
			}
		}
	}

	private void main_impl(int index, float angle) {
		float range_jit = TAU / get_num_main() * 0.1f;
		vec3 a = pos.copy();
		float dist = 0f;
		boolean start_is = true;

		for(int i = 0 ; i < get_iter_main() ; i++) {
			// distance
			vec3 b = new vec3();
			float buf_dist = growth_main_impl(i);
			dist += buf_dist;
			// direction
			float range = get_angle_main();
			float dir = random(-range, range);
			float final_angle = angle + dir;
			float x = sin(final_angle) * dist;
			float y = cos(final_angle) * dist;
			b.x(x + this.pos.x());
			b.y(y + this.pos.y());
			
			R_Puppet2D line = new R_Puppet2D(this.pa);
			// set staticly the pixel density
			line.pixel_density_is(this.pixel_density_is());
			if(start_is) {
				line.pointer_a(a);
				line.pointer_b(b);
			} else {
				line.pointer_a(main[index].get(i-1).pointer_b());
				line.pointer_b(b);
			}

			main[index].add(line);
			if(start_is) {
				a = b;
			}
			start_is = false;
		}
	}


	// BUILD HEART
	/////////////////////
	private void build_heart() {
		heart = new ArrayList<R_Puppet2D>();
		if(heart_is()) {
			int start = 1;
			for(int i = 1 ; i < main.length ; i++) {
				vec3 a = main[i -1].get(start).pointer_a();
				vec3 b = main[i].get(start).pointer_a();
				add_puppet_line_to_heart(a, b);
			}
			vec3 a = main[main.length -1].get(start).pointer_a();
			vec3 b = main[0].get(start).pointer_a();
			add_puppet_line_to_heart(a, b);
		}
	}

	private void add_puppet_line_to_heart(vec3 a, vec3 b) {
		R_Puppet2D line = new R_Puppet2D(this.pa);
		// set staticly the pixel density
		line.pixel_density_is(this.pixel_density_is());
		line.pointer_a(a);
		line.pointer_b(b);
		heart.add(line);
	}





	// BUILD CIRCLE
	//////////////////////////
	private void build_circle() {
  	if(mode == SPIRAL) {
			build_circle_spiral();
			return;
  	}
  	build_circle_impl(0);
		set_id_circle();
	}

	@SuppressWarnings("unchecked")private void build_circle_impl(int start_value) {
	  circle = new ArrayList[get_num_circle()];
		for(int i = 0 ; i < get_num_circle() ; i++) {
			circle[i] = new ArrayList<R_Line2D>();
			float dist = growth_circle_impl(i, start_value);
			circle_impl(i, dist);
			sort_circle(i); // clean for the heart heart case ?
		}
	}

	private void circle_impl(int index_circle, float dist) {
		float start_angle = 0;
		float step_angle = TAU / get_num_main();
		vec2 ang_set = new vec2(start_angle, step_angle);
		vec2 buf_meet = new vec2(-1);
		float buf_dist = dist;

	  for(int iter = 0 ; iter < get_iter_circle();  iter++){
			R_Line2D line = draw_string_web(ang_set, buf_dist);
			// here we catch the meeting point with the main branches
			vec2 [] tuple = meeting_point_main_and_circle(line);
			if(tuple[0] != null && tuple[1] != null) {
				if((iter)%get_num_main() == 0 && mode == SPIRAL) {
					vec2 swap = tuple[0];
					tuple[0] = tuple[1];
					tuple[1] = swap;
				}
				adjust_string_web(index_circle, iter, line, buf_meet, tuple);
			} else {
				// to make a fresh restart when there is losting connexion
				buf_meet.set(-1);
			}
			// check to connect the line at the end of round
			if(mode == SPIRAL) {
				buf_dist = dist(line.b(),this.pos.xy());
			} 
	  }
	}

	private void build_circle_spiral() {
		int start_value = 0;
		boolean spiral_is_good = false;
		vec2 area = new vec2(2);
		int threshold_critic = get_num_main() * 2;
		while(!spiral_is_good) {
			int threshold = 0;
			build_circle_impl(start_value);
			for(int i = 0 ; i < get_num_circle() ; i++) {
				for(R_Line2D line : circle[i]) {
					if(line.a().compare(this.pos.xy(),area)) {
						threshold++;
					}
				}
			}
			if(threshold < threshold_critic) {
				spiral_is_good = true;
			}
			start_value += 0.05;
		}
	}
	
	// ALGO CIRCLE BRANCH
	/////////////////////////

	private R_Line2D draw_string_web(vec2 ang_set, float dist) {
		float final_angle = ang_set.x();
		float ax = sin(final_angle) * dist + this.pos.x();
		float ay = cos(final_angle) * dist + this.pos.y();
		ang_set.x(ang_set.x() + ang_set.y());
		final_angle = ang_set.x();
		if(mode == SPIRAL) {
			dist += get_growth_spiral();
		}
		float bx = sin(final_angle) * dist + this.pos.x();
		float by = cos(final_angle) * dist + this.pos.y();
		R_Line2D line = new R_Line2D(this.pa, ax, ay, bx, by);
		// increase the size of line to meet the main branches and find the meeting point to next step
		line.change(0.5f, 0.5f);
		line.set(line.a(),line.b());
		return line;
	}

	private void adjust_string_web(int index, int iter, R_Line2D line, vec2 buf_meet, vec2 [] tuple) {
		if(buf_meet.equals(-1)) {
			// the first line
			line.set(tuple[0],tuple[1]);
			buf_meet.set(tuple[1]);
		} else if(iter == get_num_main() -1) {
			// when the end must be the start
			R_Line2D first = circle[index].get(0);
			if(first.id().a() == 0) {
				line.set(first.a(),tuple[1]);
			} else {
				line.set(tuple[0],tuple[1]);
				buf_meet.set(tuple[1]);
			}
		} else {
			// the common line
			line.set(buf_meet,tuple[1]);
			buf_meet.set(tuple[1]);
		}

		// give id
		line.id_a((int)tuple[2].x());
		line.id_b((int)tuple[2].y());
		// to close at the end of the race!!!
		if(iter == get_num_main() -1 && circle[index].size() > 0) {		
			R_Line2D last = circle[index].get(circle[index].size() -1);
			boolean is = last.id().b() == line.id().b();
			if(is) {
				line.set_b(last.b());
			}
		}
		circle[index].add(line);
	}

	private vec2 [] meeting_point_main_and_circle(R_Line2D line) {
		// the temporary list to work
		ArrayList<ArrayList<R_Line2D>> buf_list_main = new ArrayList<ArrayList<R_Line2D>>();
		for(int i = 0 ; i < main.length ; i++) {
			ArrayList<R_Line2D> temp = new ArrayList<R_Line2D>();
			R_Line2D temp_line_first = main[i].get(0);
			temp_line_first.a(main[i].get(0).a());
			temp.add(temp_line_first.copy());
			for(int k = 1 ; k < main[i].size(); k++) {
				R_Line2D temp_line_next = main[i].get(k).copy();
				temp.add(temp_line_next);
			}
			buf_list_main.add(temp);
		}
		return clean_meeting(line, buf_list_main);
	}

	private vec2 [] clean_meeting(R_Line2D line, ArrayList<ArrayList<R_Line2D>> buf_list_main) {
		vec2 [] meet = new vec2[3];
		int len = buf_list_main.size();
		int i_0 = 0;
		int i_1 = 0;
		for(; i_0 < len ; i_0++) {
			for(int k = 0 ; k < buf_list_main.get(i_0).size() ; k++) {
				R_Line2D lm_a = buf_list_main.get(i_0).get(k);
				meet[0] = lm_a.intersection(line);
				if(meet[0] != null) break;
			}
			if(meet[0] != null) break;
		}
		if(i_0 >= len) i_0 = len - 1;

		// search on next main branch
		i_1 = i_0 + 1;
		if(i_1 >= len) i_1 = 0;
		for(int k = 0 ; k < buf_list_main.get(i_1).size() ; k++) {
			R_Line2D lm_a = buf_list_main.get(i_1).get(k);
			meet[1] = lm_a.intersection(line);
			if(meet[1] != null) break;
		}
		// search on previous main branch, if nothing match on the next one
		if(meet[1] == null) {
			i_1 = i_0 -1;
			if(i_1 < 0) i_1 = len - 1;
			for(int k = 0 ; k < buf_list_main.get(i_1).size() ; k++) {
				R_Line2D lm_a = buf_list_main.get(i_1).get(k);
				meet[1] = lm_a.intersection(line);
				if(meet[1] != null) break;
			}
		}

		// this line is not an obligation
		if(meet[0] == null ||  meet[1] == null) {
			meet[0] = null;
			meet[1] = null;
		}
		meet[2] = new vec2(i_0, i_1);
		return meet;
	}


	private void set_id_circle() {
		for(int index_circle = 0 ; index_circle < circle.length ; index_circle++) {
			for(int k = 0 ; k < main.length ; k++) {
				for(R_Line2D lc : circle[index_circle]) {
					lc.id_e(index_circle);
					int id_segment = 0;
					for(R_Puppet2D line_main : main[k]) {
						if(in_segment(line_main,lc.a(),marge)) {
							lc.id_c(id_segment);
							line_main.add_puppets(lc.pointer_a());
						}
						if(in_segment(line_main,lc.b(),marge)) {
							lc.id_d(id_segment);
							line_main.add_puppets(lc.pointer_b());
						}

						// last check to avoid the lost id on the main branch
						if(lc.id().a() == Integer.MIN_VALUE && in_segment(line_main,lc.a(),marge)) {
							lc.id_a(k);
						}
						if(lc.id().b() == Integer.MIN_VALUE && in_segment(line_main,lc.b(),marge)) {
							lc.id_b(k);
						}

						// check the last branch, to swap the id
						if(lc.id().a() == 0 && lc.id().b() == this.get_num_main() -1) {
							lc.id_a(lc.id().b());
							lc.id_b(0);
						}
						id_segment++;
					}
					// id from heart, we minus by one to avoid a conflict with the 0 ID
					for(int m = 0 ; m < heart.size() ; m++) {
						R_Puppet2D lh = heart.get(m);
						if(lc.id().a() == Integer.MIN_VALUE && in_segment(lh,lc.a(),marge)) {
							lc.id_a(-m-1);
							lc.id_c(0);
							lh.add_puppets(lc.pointer_a());
						}
						if(lc.id().b() == Integer.MIN_VALUE && in_segment(lh,lc.b(),marge)) {
							lc.id_b(-m-1);
							lc.id_d(0);
							lh.add_puppets(lc.pointer_b());
						}
					}
				}
			}
		}
	}






	// FINAL SORT
	//////////////////////
	
	private void sort_circle(int index) {
		if(heart_is()) {
			ArrayList<R_Line2D> selected_list = new ArrayList<R_Line2D>();
			ArrayList<R_Line2D> working_list = new ArrayList<R_Line2D>();
			// list of vec2 point of the heart
			vec2 [] heart_polygon = get_polygon_array_heart();
			// check all the lines web string point
			for(R_Line2D line : circle[index]) {
				bvec2 is = new bvec2(in_polygon(heart_polygon, line.a()), in_polygon(heart_polygon, line.b()));
				if(is.only(1)) {
					working_list.add(line);
				} else if(is.only(0)) {
					working_list.add(line);
				} else if(!is.all()) {
					selected_list.add(line);
				}
			}

			// clear and add the good one
			circle[index].clear();
			for(R_Line2D line : selected_list) {
				circle[index].add(line);
			}
			// cut the line if necessary
			for(R_Line2D line : working_list) {
				boolean a_is = in_polygon(heart_polygon, line.a());
				vec2 inter = null;
				for(R_Line2D line_heart : heart) {
					inter = line_heart.intersection(line);
					if(inter != null) {
						R_Line2D new_line = new R_Line2D(this.pa);
						if(a_is) {
							new_line.set(inter, line.b());
						} else {
							new_line.set(line.a(), inter);
						}
						circle[index].add(new_line);
						break;
					}
				}
			}
			selected_list.clear();
			for(R_Line2D line : circle[index]) {
				// here 2.05 is the threshold to remove smaller line
				if(line.dist() > 2.05) {
					selected_list.add(line);
				}
			}
			circle[index].clear();
			for(R_Line2D line : selected_list) {
				// set staticly the pixel density
				line.pixel_density_is(this.pixel_density_is());
				circle[index].add(line);
			}
		}
	}
























	/////////////////////////////
	// BUILD POLYGON
	///////////////////////////

	public void build_polygon() {
		// clear polygon
		imp_shapes_center.clear();
		imp_shapes.clear();
		imp_shapes_external.clear();
		int max_main = this.get_num_main();
		// main branch by main branch
		for(int m_index = 0 ; m_index < max_main ; m_index++) {
			int im_1 = m_index+1;
			if(im_1 == max_main) {
				im_1 = 0;
			}
		}
		build_polygon_heart();
		for(int i = 0 ; i < get_num_main() ; i++) {
			build_polygons(i);
		}
		// clear polygon
		for(R_Shape poly : get_polygons()) {
			R_Shape buf = new R_Shape(pa);
			for(vec3 p : poly.get_points()) {
				if(!in_heart(p, 1)) {
					buf.add_points(p);
				}
			}
			poly.clear();
			poly.add_points(buf.get_points());
		}
	}


	// BUILD POLYGON HEART
	//////////////////
	private void build_polygon_heart() {
		R_Shape shape = new R_Shape(this.pa);
		shape.id_a(GRIS[1]);
		shape.id_b(-1);
		for(R_Line2D lh : this.get_lines_heart()) {
			shape.add_points(lh.a());
		}
		imp_shapes_center.add(shape);
	}




	// BUILD POLYGON NETWORK
	////////////////////////
	private void build_polygons(int id_branch) {
		int len = get_lines_circle_branch(id_branch, true).size();
		R_Line2D [] arr_branch = new R_Line2D[len];
		arr_branch = get_lines_circle_branch(id_branch, true).toArray(arr_branch);
		create_polygons_first(len, arr_branch);
		int last_index = create_polygons_current(len, arr_branch);
		create_polygons_last(id_branch, last_index, arr_branch);
		create_polygon_external();
	}



	// FIRST POLYGON
	////////////////////////
	private void create_polygons_first(int len, R_Line2D [] arr_branch) {
		for(int i = 0 ; i < len -1 ; i++) {
			R_Line2D line =  arr_branch[i];
			if(line.id().f() == Integer.MIN_VALUE || line.id().f() == Integer.MAX_VALUE) {
				create_polygon_first(line);
				break;
			}
		}
	}

	private void create_polygon_first(R_Line2D lc) {
		R_Shape shape = new R_Shape(this.pa);
		shape.id_a(GRIS[7]);
		shape.id_b(get_abs_id(lc.id().a()));
		R_Line2D lh = null;
		ArrayList<R_Puppet2D> [] main = tuple_main(lc.id().a(), lc.id().b());
		boolean swap_is = lc.id().a() == get_num_main() -1;
		if(heart.size() > 0) {
			if(any(lc.id().a() < 0, lc.id().b() < 0)) {
				lh = get_line_heart(lc);
				vec2 point = get_point_line_heart(lh, lc, main[0], main[1]);
				shape.id_a(GRIS[6]);
				add_point_first_level_polygon(shape, lh, lc, point);
			} else {
				lh = get_line_heart(lc);
				shape.add_points(lh.a(), lh.b());
			}
			if(swap_is) {
				vec3 v_a = shape.get_point(0).copy();
				vec3 v_b = shape.get_point(1).copy();
				shape.set_point(0,v_b);
				shape.set_point(1,v_a);
			}
		} else {
			shape.add_points(pos, pos);
		}
		shape.add_points(pos, pos);
		// not in first to keep the same order thant current polygon
		shape.add_points(lc.b(), lc.a());
		add_go_and_return(swap_is, main, shape);
		// need to check if the polygon is in the heart if not add
		if(in_heart(shape.barycenter(),1)) {
			return;
		}
		imp_shapes.add(shape);
	}



	// CURRENT POLYGONS
	//////////////////////
	private int create_polygons_current(int len, R_Line2D [] arr_branch) {
		int index = 0;
		// the problem it's before that we start at zero !!!! 
		for(int i = 0 ; i < len -1 ; i++) {
			R_Line2D line =  arr_branch[i];
			for(int k = i + 1 ; k < len ; k++) {
				R_Line2D next_line = arr_branch[k];
				if(all(	!line.mute_is(), 
								!next_line.mute_is(), 
								any(line.id().f() == Integer.MIN_VALUE, line.id().f() == Integer.MAX_VALUE))) {
					create_polygon_current(line, next_line);
					index = k;
					break;
				} 
			}	
		}
		return index;
	}


	private void create_polygon_current(R_Line2D lc, R_Line2D next_lc) {
		R_Shape shape = new R_Shape(this.pa);
		set_use_for_polygon(lc);
		shape.id_a(GRIS[10]);
		shape.id_b(get_abs_id(lc.id().a()));
		shape.add_points(next_lc.a(), next_lc.b(), lc.b(), lc.a());
		R_Line2D lh = null;
		junction_heart_circle(shape, lh, lc, next_lc);

		ArrayList<R_Puppet2D>[] main = tuple_main(lc.id().a(), lc.id().b());
		boolean swap_is = lc.id().a() == get_num_main() -1;
		add_go_and_return(swap_is, main, shape);

		imp_shapes.add(shape);
	}





		// LAST POLYGON
	///////////////////
	private void create_polygons_last(int id, int last_index, R_Line2D [] arr_branch) {
		if(arr_branch.length > 0) {
			R_Line2D last_line = null;
			
			if(last_index > 0) {
				last_line = arr_branch[last_index];
			} else if (last_index == 0 && heart.size() > 0) {
				last_line = heart.get(id);
			} else {
				// here we make a line like a point to keep the structure shape with 4 points, for the go and return function
				last_line = new R_Line2D(this.pa, pos.xy(), pos.xy());
				last_line.id_a(id);
			}
			if(last_line != null) {
				create_polygon_last(last_line, id);
			}
		}
	}


	private void create_polygon_last(R_Line2D lc, int id_branch) {
		R_Shape shape = new R_Shape(this.pa);
		shape.id_a(GRIS[15]);
		shape.id_b(id_branch);
		int next_id_branch = id_branch + 1;
		if(next_id_branch >= get_num_main()) {
			next_id_branch = 0;
		}
		ArrayList<R_Puppet2D>[] main = tuple_main(id_branch, next_id_branch);
		R_Puppet2D next_lc;
		// it's a reverse hack to avoid the inverse bug, because I don't find the reason
		boolean swap_is = lc.id().a() == get_num_main() -1;
		if(swap_is) {
			next_lc = new R_Puppet2D(this.pa, main[1].get(main[1].size() -1).b(), main[0].get(main[0].size() -1).b());
		} else {
			next_lc = new R_Puppet2D(this.pa, main[0].get(main[0].size() -1).b(), main[1].get(main[1].size() -1).b());
		}
		if(all(main[0] != null, main[1] != null)) {
			shape.add_points(next_lc.a(), next_lc.b(), lc.b(),lc.a());
		}
		R_Line2D lh = null;
		junction_heart_circle(shape, lh, lc, next_lc);
		add_go_and_return(swap_is, main, shape);

		imp_shapes.add(shape);
	}


	// EXTERNAL POLYGON
	////////////////////////
	private void create_polygon_external() {
		R_Shape shape = new R_Shape(this.pa);
		shape.id_a(GRIS[18]);
		shape.id_b(-2); // polygon with hole
		shape.id_c(0);
		// frame part
		shape.add_point(0,0);
		shape.add_point(pa.width, 0);
		shape.add_point(pa.width, pa.height);
		shape.add_point(0, pa.height);
		// interior part
		for(int i = 0 ; i < main.length ; i++) {
			vec2 p = main[i].get(main[i].size() -1).a();
			shape.add_points(p);
		}
		imp_shapes_external.add(shape);
	}




	// UTILS POLYGON
	//////////////////
	private boolean in_heart(vec pos, int marge) {
		if(heart_is() && imp_shapes_center.size() > 0) {
			R_Shape heart = imp_shapes_center.get(0);
			// the result 1 indicate the point is in the shape + in the border.
			if(in_polygon(heart, pos, marge) == 1) {
				return true;
			}
		}
		return false;
	}

	private boolean add_go_and_return(boolean swap_is, ArrayList<R_Puppet2D>[] main, R_Shape shape) {
		if(main[0] != null && main[1] != null) {
			if(swap_is) {
				add_points_go(main[0], shape);
				add_points_return(main[1], shape);
			} else {
				// common case reverse that current
				add_points_go(main[1], shape);
				add_points_return(main[0], shape);
			}
			return true;
		}
		return false;
	}



	// ADD GO IMPLEMENTATION
	////////////////////////
	private void add_points_go(ArrayList<R_Puppet2D> list_main_b, R_Shape shape) {
		int index = 1;
		int index_next = shape.get_summits() -2;
		if(shape.get_summits() == 5) {
			index_next = shape.get_summits() -3;
		}
		add_points_go_impl(list_main_b, shape, index, index_next);
	}

	private void add_points_go_impl(ArrayList<R_Puppet2D> list_main_b, R_Shape shape, int index, int index_next) {
		int first = 0;
		int last = 0;
		vec3 a = shape.get_point(index);
		vec3 b = shape.get_point(index_next);

		for(int i = 0 ; i < list_main_b.size() ; i++) {
			R_Line2D line = list_main_b.get(i);
			if(in_segment(line, a.xy(), marge)) first = i;
			if(in_segment(line, b.xy(), marge)) last = i;
		}

		// add point
		if(first < last) {
			for(int i = first ; i < last ; i++) {
				vec2 buf = list_main_b.get(i).b();
				index = add_point_go_and_return_impl(shape, index, buf);
			}
		} else if(first > last) {
			// it's for the center, because the order is reverse
			int count = first;
			for(int i = last ; i < first ; i++) {
				// reverse the order to put the point where this nust be
				count--;
				vec2 buf = list_main_b.get(count).b();
				index = add_point_go_and_return_impl(shape, index, buf);
			}
		}
	}

	// ADD RETURN IMPLEMENTATION
	////////////////////////
	private void add_points_return(ArrayList<R_Puppet2D> list_main_a, R_Shape shape) {
		int index = shape.get_summits() -1;
		int index_next = 0;
		add_points_return_impl(list_main_a, shape, index, index_next);
	}

	private void add_points_return_impl(ArrayList<R_Puppet2D> list_main_a, R_Shape shape, int index, int index_next) {
		int first = 0;
		int last = 0;
		vec3 a = shape.get_point(index);
		vec3 b = shape.get_point(index_next);
		
		for(int i = 0 ; i < list_main_a.size() ; i++) {
			R_Line2D line = list_main_a.get(i);
			if(in_segment(line, a.xy(), marge)) first = i;
			if(in_segment(line, b.xy(), marge)) last = i;
		}

		// the most of cases
		if(first > last) {
			for(int i = first ; i > last ; i--) {
				index = add_point_go_and_return_impl(shape, index, list_main_a.get(i).a());
			}
		} else if(first < last) {
			// it's for the center, because the order is reverse
			int count = first;
			for(int i = last ; i > first ; i--) {
				// reverse the order to put the point where this nust be
				count++;
				index = add_point_go_and_return_impl(shape, index, list_main_a.get(count).a());
			}
		} 
	}


	private int add_point_go_and_return_impl(R_Shape shape, int index, vec point) {
		if(!in_heart(point,1)) {
			index++;
			shape.add_point(index, point.x(), point.y());
		}
		return index;
	}




	private int prev_line_rank = -1;
	private boolean line_branch_is(int index, R_Line2D line) {
		int index_sub_1 = index  - 1;
		int index_plus_1 = index + 1;
		if(index_plus_1 >= get_num_main()) index_plus_1 = 0;
		if(index_sub_1 < 0) index_sub_1 = get_num_main() - 1;
		int id_a = get_abs_id(line.id().a());
		int id_b = get_abs_id(line.id().b());
		// perfect fit
		if(index == id_a  && index_plus_1 == id_b && prev_line_rank != line.id().e()) {
			line.id_f(Integer.MAX_VALUE);
			prev_line_rank = line.id().e();
			return true;
		}
		// case where the line is on the main line and the other if line heart prologation of this one
		if(index == id_a && index == id_b && prev_line_rank != line.id().e()) {
			line.id_f(Integer.MAX_VALUE);
			prev_line_rank = line.id().e();
			return true;
		}

		// test for the last branch, because it's reversed
		if(index == id_b  && index_plus_1 == id_a && prev_line_rank != line.id().e()) {
			line.id_f(Integer.MAX_VALUE);
			prev_line_rank = line.id().e();
			return true;
		}

		// last test for the case where one point is on the junction / summit beween two line heart line
		if(line.id().a() < 0 && id_a == index_sub_1 && id_b == index_plus_1) {
			line.id_f(Integer.MAX_VALUE);
			prev_line_rank = line.id().e();
			return true;
		}

		// reverse for the last rank of round
		if(line.id().b() < 0 && id_b == index_sub_1 && id_a == index_plus_1) {
			line.id_f(Integer.MAX_VALUE);
			prev_line_rank = line.id().e();
			return true;
		}
		return false;
	}




	private void junction_heart_circle(R_Shape shape, R_Line2D lh, R_Line2D lc, R_Line2D next_lc) {
		int id_heart = get_abs_id(lc.id().a());
		if(heart.size() > 0 && id_heart < get_num_main()) {
			lh = heart.get(id_heart);
			
			bvec2 lc_is = new bvec2(in_segment(lh, lc.a(), marge), 
															in_segment(lh, lc.b(), marge));
			bvec2 next_lc_is = new bvec2(true);
			if(next_lc != null) {
				next_lc_is.set(in_segment(lh, next_lc.a(), marge), 
											in_segment(lh, next_lc.b(), marge));
			}

			bvec4 point_is = new bvec4(	lc.b().compare(lh.a(),marge),
																	lc.b().compare(lh.b(),marge),
																	lc.a().compare(lh.a(),marge),
																	lc.a().compare(lh.b(),marge));

			if(!next_lc_is.all()) {
				boolean done_is = false;
				if(lc_is.only(0)) {
					done_is = true;
					shape.add_points(lh.a());
				} else if(lc_is.only(1)) {
					done_is = true;
					shape.add_points(2,lh.b());
				} else if(lc_is.all()) {
					float dist_a = dist(lc.barycenter(), lh.a());
					float dist_b = dist(lc.barycenter(), lh.b());
					if(dist_a > dist_b) {
						done_is = true;
						shape.add_points(lh.a());
					} else {
						done_is = true;
						shape.add_points(2,lh.b());
					}
				}
				if(!done_is) {
					if(point_is.only(0,2)) {
						shape.add_points(2,lh.b());
					} 
				}
			}
		}
	}
	

	@SuppressWarnings("unchecked")private ArrayList<R_Puppet2D>[] tuple_main(int id_a, int id_b) {
		ArrayList<R_Puppet2D> [] arr = new ArrayList[2];
		int im_0 = id_a;
		int im_1 = im_0 + 1;
		if(id_a < 0) {
			im_1 = id_b;
			im_0 = im_1 -1;
		}

		if(im_1 >= get_num_main()) {
			im_1 = 0;
		}
		if(im_0 < 0) {
			im_0 = get_num_main() -1;
		}

		arr[0] = this.get_lines_main(im_0);
		arr[1] = this.get_lines_main(im_1);
		return arr;
	}

	private vec2 get_point_line_heart(R_Line2D lh, R_Line2D lc, ArrayList<R_Puppet2D> main_a, ArrayList<R_Puppet2D> main_b) {
		float dist_a = dist(pos.xy(), lh.a());
		float dist_b = dist(pos.xy(), lh.b());
		if(dist_a < dist_b) {
			return lh.a();
		}
		return lh.b();
	}

	private void add_point_first_level_polygon(R_Shape shape, R_Line2D lh, R_Line2D lc, vec2 lh_point) {
		boolean a_is = in_segment(lh, lc.a(), marge);
		boolean b_is = in_segment(lh, lc.b(), marge);
		if(all(!a_is, !b_is)) {
			shape.add_points(lh.b(),lh.a());
		} else {
			shape.add_points(lh_point, lh_point); // to avoid access problem list when there is only 3 points
		}
	}

	private void set_use_for_polygon(R_Line2D line) {
		if(line.id().f() == Integer.MIN_VALUE || line.id().f() == Integer.MAX_VALUE) {
			line.id_f(1);
		} else {
			line.id_f(line.id().f() + 1);
		}
	}







	



	////////////////////////////////
	// ADD POINT TO CLOUD
	////////////////////////////////

	// BUILD CLOUD POINT
	//////////////////////////////////

	private void add_nodes() {
		nodes.clear();
		// main point
		for(int i = 0 ; i < this.get_num_main() ; i++) {
			// family = 0;
			if(i == this.get_num_main() -1) {
				add_nodes_impl(this.get_lines_main(i), this, ID_MAIN, true);
			} else {
				add_nodes_impl(this.get_lines_main(i), this, ID_MAIN, false);
			}
			
		}
		// circle point
		for(int i = 0 ; i < this.get_num_circle() ; i++) {
			add_nodes_impl(this.get_lines_circle(i), this, ID_CIRCLE, false);
		}
		// // heart
		add_nodes_impl(this.get_lines_heart(), this, ID_HEART, false);
		if(this.get_polygon_heart() == null) {
			R_Node node = new R_Node();
			node.pointer(this.pos);
			node.id(ID_HEART, 15,0,0,0,0);
			nodes.add(node);
		}
	}

	private void add_nodes_impl(ArrayList list, R_Impact imp, int id_family, boolean add_last_is) {
		for(Object obj : list) {
			R_Line2D line = (R_Line2D)obj;
			boolean a_is = this.pos().compare(line.a(), new vec2(marge));
			boolean b_is = this.pos().compare(line.b(), new vec2(marge));
			if(all((any(all(!a_is, !b_is, !line.mute_is()),!this.use_mute_is())),!a_is,!b_is)) {
				R_Node node_a = new R_Node();
				node_a.pointer(line.pointer_a());
				node_a.id(id_family, 15,0,0,0,0);
				nodes.add(node_a);
				if(add_last_is) {
					R_Node node_b = new R_Node();
					node_b.pointer(line.pointer_b());
					node_b.id(id_family, 15,0,0,0,0);
					nodes.add(node_b);
				}
			}	
		}
	}

	














	/////////////////////////////////
	// ANNEXE
	//////////////////////////////////



	// MUTE
	///////////////////

	public void set_mute_main(int main_index, int line_index, boolean state) {
		if(main_index >= 0 && line_index >= 0 && main_index < main.length && line_index < main[main_index].size()) {
			main[main_index].get(line_index).mute(state);
		} else {
			print_err("class R_Impact set_mute_main(int main_index, int line_index, boolean state): There is no list matching with main_index:",main_index, "or line_index:", line_index);
			this.pa.exit();
		}
	}

	public void set_mute_circle(int circle_index, int line_index, boolean state) {
		if(circle_index >= 0 && line_index >= 0 && circle_index < circle.length && line_index < circle[circle_index].size()) {
			circle[circle_index].get(line_index).mute(state);
		} else {
			print_err("class R_Impact set_mute_circle(int circle_index, int line_index, boolean state): There is no list matching with circle_index:",circle_index, "or line_index:", line_index);
			this.pa.exit();
		}
	}

	public void use_mute_is(boolean is) {
		this.use_mute_is = is;
	}

	public boolean use_mute_is() {
		return this.use_mute_is;
	}








	// ASPECT
	/////////////
	/**
	 * 
	 * @param stroke to set the stroke color, of line, pixel and polygon
	 * @return
	 */
	public R_Impact set_stroke(int stroke) {
		this.stroke.set(stroke);
		stroke(this.stroke.x());
		return this;
	}

	/**
	 * 
	 * @param fill to set the fill color polygone
	 * @return
	 */
	public R_Impact set_fill(int fill) {
		this.fill.set(fill);
		fill(this.fill.x());
		return this;
	}

	/**
	 * 
	 * @param thickness to set strokeWeight
	 * @return
	 */
	public R_Impact set_thickness(float thickness) {
		this.thickness.x(thickness);
		strokeWeight(this.thickness.x());
		return this;
	}

	/**
	 * 
	 * @param density to set pixel lin density
	 * @return
	 */
	public R_Impact set_density(float density) {
		this.density.set(density);
		return this;
	}


	public R_Impact set_pixels_colour(int... colour) {
		this.stroke.set(colour[0]); // for the pixel case
		this.pix_colour = Arrays.copyOf(colour, colour.length);
		return this;
	}
	
	

	private void set_pix_colours_from_stroke() {
		if(pix_colour == null || pix_colour.length == 1) {
			pix_colour = new int[2];
			pix_colour[0] = stroke.x();
			pix_colour[1] = stroke.y();
		} else {
			pix_colour[0] = stroke.x();
			pix_colour[1] = stroke.y();
		}
		// print_err("set_pix_colours_from_stroke()", pix_colour[0], pix_colour[1]);
	}
	/**
	 * 
	 * @param x use for minimum and to set stroke()
	 * @param y only for the second parameter in case the gradient is used
	 * @return this
	 */
	public R_Impact set_stroke(int x, int y) {
		this.stroke.set(x,y);
		stroke(this.stroke.x());
		set_pix_colours_from_stroke();
		return this;
	}

		/**
	 * 
	 * @param x use for minimum and to set fill()
	 * @param y only for the second parameter in case the gradient is used
	 * @return this
	 */
	public R_Impact set_fill(int x, int y) {
		this.fill.set(x,y);
		fill(this.fill.x());
		return this;
	}

	/**
	 * 
	 * @param x use for minimum and to set strokeWeight()
	 * @param y only for the second parameter in case the gradient is used
	 * @return this
	 */
	public R_Impact set_thickness(float x, float y) {
		this.thickness.set(x,y);
		strokeWeight(this.thickness.x());
		return this;
	}

	/**
	 * 
	 * @param x use for minimum and to set density pixel line()
	 * @param y only for the second parameter in case the gradient is used
	 * @return this
	 */
	public R_Impact set_density(float x, float y) {
		this.density.set(x,y);
		return this;
	}


	private void apply_stroke() {
		if(stroke_is()) {
			stroke(stroke.x()); 
			strokeWeight(thickness.x());
		}
	}

	private void apply_fill() {
		if(fill_is()) {
			fill(fill.x()); 
		}
	}

	public R_Impact set_line_mode(int mode) {
		this.line_mode = mode;
		return this;
	}



	// PIXEL SETTING
	/////////////////////
			/**
	 * 
	 * @param level num of pixel after the pixel root
	 * @param step space between the pixel
	 */
	public void set_pixel_evolution(int type, int level, int step) {
		type_evo_pixel = type;
		level_evo_pixel.set(level);
		step_evo_pixel.set(step);
	}

	/**
	 * 
	 * @param level_min num min of pixel after the pixel root
	 * @param level_max num max of pixel after the pixel root
	 * @param step_min space min between the pixel
	 * @param step_max space max between the pixel
	 */
	public void set_pixel_evolution(int type, int level_min, int level_max, int step_min, int step_max) {
		type_evo_pixel = type;
		level_evo_pixel.set(level_min, level_max);
		step_evo_pixel.set(step_min, step_max);
	}


	public void set_pixel_mode_abscissa(int type, int level) {
		mode_abs_pixel.set(type, level);
	}


	public void set_pixel_mode_ordinate(int type, int level) {
		mode_ord_pixel.set(type, level);
	}








	// GRADIENT
	////////////

	public void use_gradient(boolean is) {
		use_gradient_density(is);
		use_gradient_thickness(is);
		use_gradient_fill(is);
		use_gradient_stroke(is);
	}


	public void use_gradient_density(boolean is, float start, float end) {
		if(!this.density.equals(start, end)) {
			build_is(false);
			this.density.set(start,end);
		}
		use_gradient_density(is);
	}

	public void use_gradient_density(boolean is) {
		stroke_is(is);
		this.use_gradient_density_is = is;
	}

	private boolean use_gradient_density_is() {
		return this.use_gradient_density_is;
	}

	private float get_gradient_density(float dist) {
		float ratio = dist / radius();
		float res = map(ratio, 0, 1, density.x(), density.y());
		return res;
	}




	/**
	 * Apply a thickness gradient on all strokeweight from the center to the exterior shape
	 * @param is set if the gradient must be apply
	 * @param start thickness minimum for the strokeWeight
	 * @param end thickness maximum for the strokeWeight
	 */
	public void use_gradient_thickness(boolean is, float start, float end) {
		if(!this.thickness.equals(start, end)) {
			// build_is(false);
			this.thickness.set(start,end);
		}
		use_gradient_thickness(is);

	}

	public void use_gradient_thickness(boolean is) {
		stroke_is(is);
		this.use_gradient_thickness_is = is;
	}


	private boolean use_gradient_thickness_is() {
		return this.use_gradient_thickness_is;
	}

	private float apply_gradient_thickness(float dist) {
		float value = thickness.x();
		if(use_gradient_thickness_is() && stroke_is()) {
			value = get_gradient_thickness(dist);
			stroke(stroke.x()); 
			strokeWeight(value);	
		}
		return value;
	}

	private float get_gradient_thickness(float dist) {
		float ratio = dist / radius();
		float res = map(ratio, 0, 1, thickness.x(), thickness.y());
		return res;
	}

		/**
	 * Apply a stroke gradient on all strokeweight from the center to the exterior shape
	 * @param is set if the gradient must be apply
	 * @param start stroke for color
	 * @param end stroke for color
	 */
	public void use_gradient_stroke(boolean is, int start, int end) {
		if(!this.stroke.equals(start, end)) {
			// don't active this function, to give the opportunity to just refresh color without rebuild
			// build_is(false); 
			this.stroke.set(start,end);
			next_frameCount = pa.frameCount + 1;
			set_gradient_pixels_is(false);
		}
		use_gradient_stroke(is);
	}

	public void use_gradient_stroke(boolean is) {
		stroke_is(is);
		this.use_gradient_stroke_is = is;
	}

	private boolean use_gradient_stroke_is() {
		return this.use_gradient_stroke_is;
	}

	private int apply_gradient_stroke(float dist) {
		int value = stroke.x();
		if(use_gradient_stroke_is() && stroke_is()) {
			float ratio = dist / radius();
			value = lerpColor(stroke.x(), stroke.y(), ratio, RGB);
			stroke(value);
		}
		return value;
	}


	private void set_gradient_pixels_is(boolean is) {
		this.set_gradient_pixels_is = is;
	}

	private boolean set_gradient_pixels_is() {
		return this.set_gradient_pixels_is;
	}



		/**
	 * Apply a fill gradient on all strokeweight from the center to the exterior shape
	 * @param is set if the gradient must be apply
	 * @param start fill for color
	 * @param end fill for color
	 */
	public void use_gradient_fill(boolean is, int start, int end) {
		fill.set(start,end);
		use_gradient_fill(is);
	}

	public void use_gradient_fill(boolean is) {
		fill_is(is);
		this.use_gradient_fill_is = is;
	}

	private boolean use_gradient_fill_is() {
		return this.use_gradient_fill_is;
	}


	private int apply_gradient_fill(float dist) {
		int value = fill.x();
		if(use_gradient_fill_is() && fill_is()) {
			float ratio = dist / radius();
			value = lerpColor(fill.x(), fill.y(), ratio, RGB);
			// that can give a problem for the case where there is gradient for color ???
			fill(value); 
		}
		return value;
	}


	

































	/////////////////////////////
	// SHOW
	////////////////////////////



	// SHOW LINE
	////////////////////////////

	public void show_lines() {
		show_lines_main();
		show_lines_circle();
		show_lines_heart();
	}

	// SHOW MAIN
	/////////////////

	public void show_lines_main() {
		show_lines_main(0, get_iter_main());
	}
	
	/**
	 * 
	 * @param start
	 * @param end
	 */
	public void show_lines_main(int start, int end) {;
		if(heart_is()) {
			start++;
		}
		show_list_impl(main, start, end);
	}

	/**
	 * 
	 * @param index
	 */
	public void show_lines_main(int index) {
		show_lines_main(index, 0, get_iter_main()); 
	}

	/**
	 * 
	 * @param index
	 * @param start
	 * @param end
	 */
	public void show_lines_main(int index, int start, int end) {
		if(heart_is()) {
			start++;
		}
		if(index >= 0 && index < main.length) {
			show_lines_impl(main[index], start, end);	
		}
	}

	// SHOW CIRCLE
	//////////////////

	public void show_lines_circle() {
		show_list_impl(circle);
	}

	public void show_lines_circle(int index, int start, int end) {
		if(index >= 0 && index < circle.length) {
			show_lines_impl(circle[index], start, end);	
		}
	}

	public void show_lines_circle(int index) {
		if(index >= 0 && index < circle.length) {
			show_lines_impl(circle[index]);	
		}
	}

	// SHOW OTHER
	//////////////////
	/**
	* an other way to show circle, not like circle but by branch from main pie slide
	 */
	public void show_lines_branch(int index) {
		for(int i = 0 ; i < circle.length ; i++) {
			for(int k = 0 ; k < circle[i].size() ; k++) {
				R_Line2D line = circle[i].get(k);
				if(line_branch_is(index, line)) {
					show_single_line_impl(line);
				}
			}
		}
	}

	public void show_lines_heart() {
		show_lines_impl(heart, 0, heart.size());
	}

	////////////////////////////////
	// IMPLEMENTATION
	//////////////////////////////////

	private void show_list_impl(ArrayList[] list) {
		for(int i = 0 ; i < list.length ; i++) {
			show_lines_impl(list[i]);
		}
	}

	private void show_list_impl(ArrayList[] list, int start, int end) {
		for(int i = 0 ; i < list.length ; i++) {
			show_lines_impl(list[i], start, end);
		}
	}

	private void show_lines_impl(ArrayList lines, int start, int end) {
		if(start < 0) {
			start = 0;
		}
		if(start >= lines.size()) {
			start = lines.size();
		}
	
		end = constrain(end, start, lines.size());
		for(int i = start ; i < end ; i++) {	
			R_Line2D line = (R_Line2D)lines.get(i);
			show_single_line_impl(line);
		}
	}

	private void show_lines_impl(ArrayList lines) {
		for(Object line : lines) {	
			show_single_line_impl((R_Line2D)line);
		}
	}

	private void show_single_line_impl(R_Line2D line) {
		float dist_from_center = dist(line.a(), pos());
		// a hack when the density change !
		if(!build_is()) {
			build();
		}
		apply_stroke();
		apply_gradient_stroke(dist_from_center);
		apply_gradient_thickness(dist_from_center);
		// maybe need pass graphics other in the future ?
		if(other != null) {
			line.pass_graphic(other);
		}
		if(use_mute_is()) {	
			if(!line.mute_is()) {
				mode_line_show(line);
			}
		} else {
			mode_line_show(line);
		}
	}



	private void set_line_pixel_final(R_Line2D line, float dist, float x, float y) {
		if(use_gradient_density_is()) {
			x = get_gradient_density(dist);
		}
		if(use_gradient_thickness_is()) {
			y = get_gradient_thickness(dist);
		}
		// update position and color pixel
		if(!line.pixels_is()) {
			// distri_absord_pixel
			line.mode_abscissa(mode_abs_pixel.x(), mode_abs_pixel.y());
			line.mode_ordinate(mode_ord_pixel.x(), mode_ord_pixel.y());
			line.set_palette(pix_colour);
			line.set_pixels(x, y);
			// line.set_pixels(x, y, pix_colour);
			evolution_impl(line);
		}
		// update color pixel
		if(line.pixels_is() && line.get_pixies()[0].fill() != pix_colour[0]) {
			for(R_Pix pix : line.get_pixies()) {
				pix.fill(pix_colour[0]);
			}
			if(line.get_pixies_growth() != null) {
				for(R_Pix pix : line.get_pixies_growth()) {
					pix.fill(pix_colour[0]);
				}
			}
			
		}

		if(use_gradient_stroke_is()) {
			if(!set_gradient_pixels_is()) {
				for(R_Pix pix : line.get_pixies()) {
					pix.fill(pix_colour[0]);
				}
			}
		}

		if(pa.frameCount == next_frameCount) {
			set_gradient_pixels_is(true);
	  }
		pixel_xy.set(x, y);
	}


	private void evolution_impl(R_Line2D line) {
		int level = 0;
		int step = 0;
		if(level_evo_pixel.equals()) {
			level = level_evo_pixel.x();
		} else {
			level = round(random(level_evo_pixel.x(),level_evo_pixel.y()));
		}

		if(step_evo_pixel.equals()) {
			step = step_evo_pixel.x();
		} else {
			step = round(random(step_evo_pixel.x(),step_evo_pixel.y()));
		}
		if(all(level != 0, step != 0)) {
			line.growth_option(false, type_evo_pixel);
			line.growth(level, step);
			return;
		}
	}

	private void set_line_pixels_colour(float dist) {
		set_pix_colours_from_stroke();
		if(use_gradient_stroke_is()) {
			int c = apply_gradient_stroke(dist);
			int [] buf = new int[1];
			buf[0] = c;
			pix_colour = buf;
		}
	}


	// FINAL RENDERING
	///////////////////

	private void mode_line_show(R_Line2D line) {
		float dist_from_center = dist(line.a(), pos());
		int mode = get_line_mode();
		if(update_pixels_is() && mode > 0) {
			mode += 10;
		}
		set_line_pixels_colour(dist_from_center);
		float normal_x = density.x();
		float normal_y = thickness.x();
		set_line_pixel_final(line, dist_from_center, normal_x, normal_y);
		normal_x = pixel_xy.a();
		normal_y = pixel_xy.b();
		switch(mode) {
			// default mode line
			case 0 -> line.show();
			// static
			case 1 -> line.show_pixels();
			case 2 -> line.show_pixels_x2();
			// dynamic
			case 11 -> line.show_pixels(normal_x, normal_y);
				// line.show_pixels(normal_x, normal_y, pix_colour);
			case 12 -> line.show_pixels_x2(normal_x, normal_y);		
				// line.show_pixels_x2(normal_x, normal_y, pix_colour);		
			default -> line.show();
		}
	}































	// SHOW POLYGON
	////////////////////////
	public void show_all_polygons() {
		show_polygon_heart();
		show_polygons();
		show_polygon_external();
	}

	public void show_all_polygons(int mode) {
		show_polygon_heart(mode);
		show_polygons(mode);
		show_polygon_external(mode);
	}

	public void show_polygon_heart(int mode) {
		show_polygons_from(imp_shapes_center,mode);
	}

	public void show_polygon_heart() {
		show_polygons_from(imp_shapes_center, Integer.MIN_VALUE);
	}

	public void show_polygons() {
		show_polygons(Integer.MIN_VALUE);
	}

	public void show_polygons(int mode) {
		if(mode == -1) {
			noStroke();
			strokeWeight(0);
		} else if(mode == 0) {
			strokeWeight(1);
			stroke(GRIS[13]);
		} else if(mode == 1) {
			stroke(YELLOW);
		}
		show_polygons_from(imp_shapes, mode);
	}

	public void show_polygon_external(int mode) {
		show_polygons_from(imp_shapes_external,mode);
	}

	public void show_polygon_external() {
		show_polygons_from(imp_shapes_external, Integer.MIN_VALUE);
	}



	// show polygons implementation
	////////////////////////////////////////

	public void show_polygons_from(ArrayList<R_Shape> list, int mode) {
		boolean display_all = true;
		if(mode != Integer.MIN_VALUE) {
			for(R_Shape shape : list) {
				show_polygon_mode(shape, display_all);
			}
		} else {
			for(R_Shape shape : list) {
				show_polygon(shape);
			}
		}
	}

	private void show_polygon_mode(R_Shape shape, boolean display_all) {
		if(any(shape.id().a() == GRIS[4], 
							shape.id().a() == MAGENTA, 
							shape.id().a() == RED,
							shape.id().a() == GREEN, 
							shape.id().a() == CYAN,
							display_all)) {
			if(shape.id().a() != 0) {
				fill(shape.id().a());
			} else {
				fill(MAGENTA);
			}
			show_polygon(shape);
		}
	}

	/**
	 * 
	 * @param shape
	 */
	public void show_polygon(R_Shape shape) {
		float dist_from_center = dist(shape.get_point(shape.get_summits()-1).xy(), pos());
		// float dist_from_center = dist(shape.barycenter().xy(), pos());
		apply_stroke();
		apply_fill();
		apply_gradient_fill(dist_from_center);
		apply_gradient_stroke(dist_from_center);
		if(shape.id().c() != 0) {
			apply_gradient_thickness(dist_from_center);
		} else {
			strokeWeight(1);
			if(this.fill.y() < 0) stroke(this.fill.y());
			if(this.fill.y() < 0) fill(this.fill.y());
		}
		
		beginShape();
		int i = 0;
		// create the exterior if necessary, for the external polygon
		if(shape.id().b() == -2) {
			beginContour();
			for( ; i < 4 ; i++) {
				vertex(shape.get_x(i), shape.get_y(i));
			}
			endContour();
		}
		// classic draw or internal draw depend of the case.
		for( ; i < shape.get_summits() ; i++) {
			vertex(shape.get_x(i), shape.get_y(i));
		}
		endShape(CLOSE);
	}



	// SHOW POINT
	//////////////////

	public void show_nodes() {
		noFill();
		stroke(WHITE);
		for(R_Node node : nodes) {
			switch(node.id().a()) {
				case 0 -> {
					stroke(CYAN);
					circle(node.x(), node.y(), node.id().b());
				}
				case 1 -> {
					stroke(MAGENTA);
					circle(node.x(), node.y(), node.id().b());
				}
				case 2 -> {
					stroke(YELLOW);
					circle(node.x(), node.y(), node.id().b());
				}
				default -> {
					stroke(WHITE);
					circle(node.x(), node.y(), node.id().b());
				}
			}
		}
	}
}


