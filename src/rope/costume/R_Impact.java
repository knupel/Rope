/**
 *   ___      ___   ____   _______
 *  | -  \   /   \  |    \ |  ___/
 *  | |/  | |   \ | | |\ | |  |__
 *  |    /  | | | | | |  / |  __/
 *  | |  \  \ \   / |  |/  |  |____
 *  |_| \_\  \___/  |_ |   |______/
 * 
 * R_Impact
 * v 0.1.1
 * 2022-2022
 * @author @knupel
 * @see https://github.com/knupel/Rope
*/

package rope.costume;


import java.util.ArrayList;

import processing.core.PApplet;
import rope.core.R_Graphic;
import rope.mesh.R_Line2D;
import rope.mesh.R_Node;
import rope.mesh.R_Shape;
import rope.tool.R_Puppet2D;
import rope.utils.R_Pair;
import rope.vector.bvec2;
import rope.vector.bvec4;
import rope.vector.ivec2;
import rope.vector.vec2;
import rope.vector.vec3;
import rope.vector.vec5;

public class R_Impact extends R_Graphic {
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
	// POINT
	private ArrayList<R_Node> nodes = new ArrayList<R_Node>();
	// GLOBAL POSTION of the impact
	private vec3 pos;

	private float marge = 2; // use for in_line detection
	private int base = 5;

	private boolean use_mute_is = false;
	private int mode_pixel_x = 1;

	private float growth_fact_spiral = 1;

	private vec5 data_main = new vec5();
	private vec3 data_circle = new vec3();
	
	////////////////////////////
	// CONSTRUCTOR
	/////////////////////////////

	public R_Impact(PApplet pa) {
		super(pa);
		pos = new vec3(0);
		init();
	}

	public R_Impact(PApplet pa, int x, int y) {
		super(pa);
		pos = new vec3(x, y, 0);
		init();
	}


	private void init() {
		float diagonal = sqrt(pow(this.pa.width,2) + pow(this.pa.height,2));
		float growth = (diagonal/this.base) * 0.25f;
		// It's very small value for the result, there is something weird
		float main_growth_angle = PI * 0.02f;
		// main data
		set_num_main(this.base);
		set_iter_main(this.base);
		set_growth_main(growth);
		set_angle_main(main_growth_angle);

		set_heart(0);
		// circle data
		set_num_circle(this.base);
		set_iter_circle(this.base);
		set_growth_circle(growth);
	}






	////////////////////////////////
	// SETTING
	/////////////////////////////////

	// SET DATA MAIN
	///////////////////

	public R_Impact set_num_main(int num) {
		this.data_main.a(num);
		return this;
	}

	public R_Impact set_iter_main(int iter) {
		this.data_main.b(iter);
		return this;
	}

	public R_Impact set_growth_main(float growth) {
		this.data_main.c(growth);
		return this;
	}

	public R_Impact set_angle_main(float angle) {
		this.data_main.d(angle);
		return this;
	}

	/**
	 * 
	 * @param level from 0 to max main iteration
	 * @return
	 */
	public R_Impact set_heart(int level) {
		data_main.e(abs(level));
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

	public R_Impact set_growth_circle(float growth) {
		this.data_circle.z(growth);
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
	// It's for the case where there are dynamic change on the net impact

	/**
	 * Can be use only where there is change on the puppet master from main or heart
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
	 * Must be use all the time not only whre there a changement
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

	public vec5 get_data_main() {
		return this.data_main;
	}

	public int get_num_main() {
		return (int)this.data_main.a();
	}

	public int get_iter_main() {
		return (int)this.data_main.b();
	}

	public float get_growth_main() {
		return this.data_main.c();
	}

	public float get_angle_main() {
		return this.data_main.d();
	}

	public int get_heart_level() {
		return (int)this.data_main.e();
	}


	// GET DATA CIRCLE
	///////////////////

	public vec3 get_data_circle() {
		return this.data_circle;
	}

	public int get_num_circle() {
		return (int)this.data_circle.x();
	}

	public int get_iter_circle() {
		return (int)this.data_circle.y();
	}

	public float get_growth_circle() {
		return this.data_circle.z();
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

	public ArrayList<R_Puppet2D> get_main_lines(int index) {
		if(index >= 0 && index < main.length) {
			return main[index];
		}
		return null;
	}

	/**
	* return circle
	 */
	public ArrayList<R_Line2D> get_circle_lines(int index) {
		if(index >= 0 && index < circle.length) {
			return circle[index];
		}
		return null;
	}


	public ArrayList<R_Line2D> get_branch_lines(int index) {
		return get_branch_lines(index,true);
	}

	/**
	 * 
	 * @param index select wich main branch you want add
	 * @param only_visible_is if it's true add only the visible line
	 * @return
	 */
	public ArrayList<R_Line2D> get_branch_lines(int index, boolean only_visible_is) {
		ArrayList<R_Line2D> list = new ArrayList<R_Line2D>();
		for(int i = 0 ; i < circle.length ; i++) {
			for(int k = 0 ; k < circle[i].size() ; k++) {
				int buf_id = get_abs_id(circle[i].get(k).id().a());
				if(index == buf_id) {
					R_Line2D line = circle[i].get(k);
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

	public ArrayList<R_Puppet2D> get_heart_lines() {
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
		buf.addAll(imp_shapes_center);
		buf.addAll(imp_shapes);
		return buf;
	}


	public ArrayList<R_Shape> get_heart_polygons() {
		return imp_shapes_center;
	}

	public ArrayList<R_Shape> get_polygons() {
		return imp_shapes;
	}

	// may be need to be refactoring to arrayList or R_Shape
	public vec2 [] get_heart_polygon() {
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
		if(heart.size() > 0) {
			if(lc.id().a() < 0) {
				return heart.get(get_abs_id(lc.id().a()));
			} else if (lc.id().b() < 0) {
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
	}

	////////////////////////
	// BUILD STRUCTURE
	/////////////////////////

	// BUILD MAIN BRANCH
	/////////////////////
	private void build_main() {
		main = new ArrayList[get_num_main()];
		float angle_step = TAU / get_num_main();
		float angle = 0f;

		for(int i = 0 ; i < get_num_main() ; i++) {
			main[i] = new ArrayList<R_Puppet2D>();
			main_impl(i, angle);
			angle += angle_step;
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
			float buf_dist = random(get_growth_main() * 0.1f,get_growth_main() * 2.5f);
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
		if(get_heart_level() > 0 ) {
			// remove the unnecessary line
			for(int i = 0 ; i < get_heart_level() -1 ; i++) {
				for(int k = 0 ; k < main.length ; k++) {
					main[k].remove(0);
				}
			}
			// build the heart polygon
			for(int i = 1 ; i < main.length ; i++) {
				vec3 a = main[i -1].get(0).pointer_a();
				vec3 b = main[i].get(0).pointer_a();
				add_puppet_line_to_heart(a, b);
			}
			vec3 a = main[main.length -1].get(0).pointer_a();
			vec3 b = main[0].get(0).pointer_a();
			add_puppet_line_to_heart(a, b);
		}
	}



	private void add_puppet_line_to_heart(vec3 a, vec3 b) {
		R_Puppet2D line = new R_Puppet2D(this.pa);
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
		float start_value = 0;
  	build_circle(start_value);
		set_id_circle();
	}

	private void build_circle(float start_value) {
	  circle = new ArrayList[get_num_circle()];
		for(int i = 0 ; i < get_num_circle() ; i++) {
			circle[i] = new ArrayList<R_Line2D>();
			float dist = get_growth_circle() * (i + start_value);
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
			// check to cennect the line at the end of round
			if(mode == SPIRAL) {
				buf_dist = dist(line.b(),this.pos.xy());
			} 
	  }
	}

	private void build_circle_spiral() {
		float start_value = 0;
		boolean spiral_is_good = false;
		vec2 area = new vec2(2);
		int threshold_critic = get_num_main() * 2;
		while(!spiral_is_good) {
			int threshold = 0;
			build_circle(start_value);
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
			// put the first point to center of the impact
			// temp_line_first.a(this.pos.x(), this.pos.y()); // why in the center
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
						// check the last branch, to swap the id
						if(lc.id().a()== 0 && lc.id().b() == this.get_num_main() -1) {
							lc.id_a(lc.id().b());
							lc.id_b(0);
						}
						id_segment++;
					}
					// id from heart, we minus by one to avoid a conflict with the 0 ID
					for(int m = 0 ; m <  heart.size() ; m++) {
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
		if(get_heart_level() > 0) {
			ArrayList<R_Line2D> selected_list = new ArrayList<R_Line2D>();
			ArrayList<R_Line2D> working_list = new ArrayList<R_Line2D>();
			// list of vec2 point of the heart
			vec2 [] heart_polygon = get_heart_polygon();
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
	}



	// BUILD POLYGON HEART
	//////////////////
	private void build_polygon_heart() {
		R_Shape shape = new R_Shape(this.pa);
		shape.id_a(GRIS[1]);
		shape.id_b(-1);
		for(R_Line2D lh : this.get_heart_lines()) {
			shape.add_points(lh.a());
		}
		imp_shapes_center.add(shape);
	}




	// BUILD POLYGON NETWORK
	////////////////////////
	private void build_polygons(int id_branch) {
		int len = get_branch_lines(id_branch, true).size();
		R_Line2D [] arr_branch = new R_Line2D[len];
		arr_branch = get_branch_lines(id_branch, true).toArray(arr_branch);
		// first element
		for(int i = 0 ; i < len -1 ; i++) {
			R_Line2D line =  arr_branch[i];
			if(all(line.id().f() == Integer.MIN_VALUE)) {
				create_polygon_first(line);
				break;
			}
		}

		// curent element
		int last_index = 0;
		for(int i = 0 ; i < len -1 ; i++) {
			R_Line2D line =  arr_branch[i];
			for(int k = i + 1 ; k < len ; k++) {
				R_Line2D next_line =  arr_branch[k];
				if(all(!line.mute_is(), !next_line.mute_is(), line.id().f() == Integer.MIN_VALUE)) {
					create_polygon_current(line, next_line);
					last_index = k;
					break;
				} 
			}	
		}

		// last element
		if(arr_branch.length > 0) {
			R_Line2D last_line = null;
			
			if(last_index > 0) {
				last_line = arr_branch[last_index];
			} else if (last_index == 0 && heart.size() > 0) {
				last_line = heart.get(id_branch);
			} else {
				// here we make a line like a point to keep the structure shape with 4 points, for the go and return function
				last_line = new R_Line2D(this.pa, pos.xy(), pos.xy());
				last_line.id_a(id_branch);
			}
			if(last_line != null) {
				create_polygon_last(last_line, id_branch);
			}
		}
	}

	// LAST POLYGON
	///////////////////

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
		if(main[0] != null && main[1] != null) {
			if(swap_is) {
				add_points_go(main[0], shape, lh);
				add_points_return(main[1], shape, lh);
			} else {
				// common case reverse that current
				add_points_go(main[1], shape, lh);
				add_points_return(main[0], shape, lh);
			}
		}
		imp_shapes.add(shape);
	}

	// CURRENT POLYGONS
	//////////////////////

	private void create_polygon_current(R_Line2D lc, R_Line2D next_lc) {
		R_Shape shape = new R_Shape(this.pa);
		set_use_for_polygon(lc);
		shape.id_a(GRIS[10]);
		shape.id_b(get_abs_id(lc.id().a()));
		shape.add_points(next_lc.a(), next_lc.b(), lc.b(), lc.a());
		R_Line2D lh = null;
		junction_heart_circle(shape, lh, lc, next_lc);

		ArrayList<R_Puppet2D>[] main = tuple_main(lc.id().a(), lc.id().b());
		if(main[0] != null && main[1] != null) {
			boolean swap_is = lc.id().a() == get_num_main() -1;
			if(swap_is) {
				add_points_go(main[0], shape, lh);
				add_points_return(main[1], shape, lh);
			} else {
				// common case
				add_points_go(main[1], shape, lh);
				add_points_return(main[0], shape, lh);
			}
		}
		imp_shapes.add(shape);
	}

	// FIRST POLYGON
	////////////////////////

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
		// not in first to keep the same order thant current polygon
		shape.add_points(lc.b(), lc.a());
		if(main[0] != null && main[1] != null) {
			if(swap_is) {
				add_points_go(main[0], shape, lh);
				add_points_return(main[1], shape, lh);
			} else {
				// common case reverse that current
				add_points_go(main[1], shape, lh);
				add_points_return(main[0], shape, lh);
			}
		}
		imp_shapes.add(shape);
	}



	// ADD GO and RETURN
	/////////////////////

	private void add_points_go(ArrayList<R_Puppet2D> list_main_b, R_Shape shape, R_Line2D lh) {
		int index = 1;
		int index_next = shape.get_summits() -2;
		if(shape.get_summits() == 5) {
			index_next = shape.get_summits() -3;
		}
		add_points_go_impl(list_main_b, shape, lh, index, index_next);
	}

	private void add_points_return(ArrayList<R_Puppet2D> list_main_a, R_Shape shape, R_Line2D lh) {
		int index = shape.get_summits() -1;
		int index_next = 0;
		add_points_return_impl(list_main_a, shape, lh, index, index_next);
	}




	// ADD GO IMPLEMENTATION
	////////////////////////

	private void add_points_go_impl(ArrayList<R_Puppet2D> list_main_b, R_Shape shape, R_Line2D lh, int index, int index_next) {
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
				index++;
				shape.add_point(index, buf.x(), buf.y());
			}
		} else if(first > last) {
			// it's for the center, because the order is reverse
			int count = first;
			for(int i = last ; i < first ; i++) {
				// reverse the order to put the point where this nust be
				count--;
				vec2 buf = list_main_b.get(count).b();
				index++;
				shape.add_point(index, buf.x(), buf.y());
			}
		}
	}

	// ADD RETURN IMPLEMENTATION
	////////////////////////

	private void add_points_return_impl(ArrayList<R_Puppet2D> list_main_a, R_Shape shape, R_Line2D lh, int index, int index_next) {
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
				vec2 buf = list_main_a.get(i).a();
				index++;
				shape.add_point(index, buf.x(), buf.y());
			}
		}
		else if(first < last) {
			// it's for the center, because the order is reverse
			int count = first;
			for(int i = last ; i > first ; i--) {
				// reverse the order to put the point where this nust be
				count++;
				vec2 buf = list_main_a.get(count).a();
				index++;
				shape.add_point(index, buf.x(), buf.y());
			}
		} 
	}






	


				














	// UTILS POLYGON
	//////////////////

	private void junction_heart_circle(R_Shape shape, R_Line2D lh, R_Line2D lc, R_Line2D next_lc) {
		int id_heart = get_abs_id(lc.id().a());
		if(heart.size() > 0 && id_heart < get_num_main()) {
			lh = heart.get(id_heart);
			
			bvec2 lc_is = new bvec2(in_segment(lh, lc.a(), marge), 
															in_segment(lh, lc.b(), marge));
			bvec2 next_lc_is = new bvec2(	in_segment(lh, next_lc.a(), marge), 
																		in_segment(lh, next_lc.b(), marge));

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
	

	private ArrayList<R_Puppet2D>[] tuple_main(int id_a, int id_b) {
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

		arr[0] = this.get_main_lines(im_0);
		arr[1] = this.get_main_lines(im_1);
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
		if(line.id().f() == Integer.MIN_VALUE) {
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
				add_nodes_impl(this.get_main_lines(i), this, ID_MAIN, true);
			} else {
				add_nodes_impl(this.get_main_lines(i), this, ID_MAIN, false);
			}
			
		}
		// circle point
		for(int i = 0 ; i < this.get_num_circle() ; i++) {
			add_nodes_impl(this.get_circle_lines(i), this, ID_CIRCLE, false);
		}
		// // heart
		add_nodes_impl(this.get_heart_lines(), this, ID_HEART, false);
		if(this.get_heart_polygon() == null) {
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

	


























	///////////////////////////
	// PIXELS
	///////////////////////////

	public void pixel_mode(int mode) {
		this.mode_pixel_x = mode;
	}

	private int get_pixel_mode() {
		return this.mode_pixel_x;
	}

	// SET PIXELS
	///////////////////////////

	public void set_pixels(float normal_value, int... colour) {
		set_pixels_main(normal_value, colour);
		set_pixels_circle(normal_value, colour);
		set_pixels_heart(normal_value, colour);
	}

	public void set_pixels_main(float normal_value, int... colour) {
		set_pixels_list_impl(main, normal_value, colour);
	}

	public void set_pixels_circle(float normal_value, int... colour) {
		set_pixels_list_impl(circle, normal_value, colour);
	}

	public void set_pixels_heart(float normal_value, int... colour) {
		set_pixels_lines_impl(heart, normal_value, colour);
	}

	private void set_pixels_list_impl(ArrayList[] list, float normal_value, int... colour) {
		for(int i = 0 ; i < list.length ; i++) {
			set_pixels_lines_impl(list[i], normal_value, colour);
		}
	}
	
	private void set_pixels_lines_impl(ArrayList lines, float normal_value, int... colour) {
		for(Object obj : lines) {
			R_Line2D line = (R_Line2D)obj;
			line.set_pixels(normal_value, colour);
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

	public void use_mute(boolean is) {
		this.use_mute_is = is;
	}

	public boolean use_mute_is() {
		return this.use_mute_is;
	}


	

































	/////////////////////////////
	// SHOW
	////////////////////////////

	// SHOW PIXELS STATIC
	///////////////////////////

	public void show_pixels() {
		show_pixels_main();
		show_pixels_circle();
		show_pixels_heart();
	}

	public void show_pixels_main() {
		show_pixels_list_impl(main);
	}

	public void show_pixels_circle() {
		show_pixels_list_impl(circle);
	}

	public void show_pixels_heart() {
		show_pixels_lines_impl(heart);
	}

	private void show_pixels_list_impl(ArrayList[] list) {
		for(int i = 0 ; i < list.length ; i++) {
			show_pixels_lines_impl(list[i]);
		}
	}

	private void show_pixels_lines_impl(ArrayList lines) {
		for(Object obj : lines) {
			R_Line2D line = (R_Line2D)obj;
			if(use_mute_is()) {
				if(!line.mute_is()) {
					line.show_pixels();
				}
			} else {
				line.show_pixels();
			}	
		}
	}


	// SHOW PIXELS DYNAMIC
	///////////////////////////

	public void show_pixels(float normal_value, int... colour) {
		show_pixels_main(normal_value, colour);
		show_pixels_circle(normal_value, colour);
		show_pixels_heart(normal_value, colour);
	}

	public void show_pixels_main(float normal_value, int... colour) {
		show_pixels_list_impl(main, normal_value, colour);
	}

	public void show_pixels_circle(float normal_value, int... colour) {
		show_pixels_list_impl(circle, normal_value, colour);
	}

	public void show_pixels_heart(float normal_value, int... colour) {
		show_pixels_lines_impl(heart, normal_value, colour);
	}

	private void show_pixels_list_impl(ArrayList[] list, float normal_value, int... colour) {
		for(int i = 0 ; i < list.length ; i++) {
			show_pixels_lines_impl(list[i], normal_value, colour);
		}
	}

	private void show_pixels_lines_impl(ArrayList lines, float normal_value, int... colour) {
		switch(get_pixel_mode()) {
			case 1: show_pixels_lines_impl_x1(lines, normal_value, colour); break;
			case 2: show_pixels_lines_impl_x2(lines, normal_value, colour); break;
			default: show_pixels_lines_impl_x1(lines, normal_value, colour); break;
		}
	}

	private void show_pixels_lines_impl_x1(ArrayList lines, float normal_value, int... colour) {
		for(Object obj : lines) {
				R_Line2D line = (R_Line2D)obj;
				if(use_mute_is()) {
				if(!line.mute_is()) {
					line.show_pixels(normal_value, colour);
				}
			} else {
				line.show_pixels(normal_value, colour);
			}
		}
	}

	private void show_pixels_lines_impl_x2(ArrayList lines, float normal_value, int... colour) {
		for(Object obj : lines) {
			R_Line2D line = (R_Line2D)obj;
			if(use_mute_is()) {
				if(!line.mute_is()) {
					line.show_pixels_x2(normal_value, colour);
				}
			} else {
				line.show_pixels_x2(normal_value, colour);
			}
		}
	}








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
		show_list_impl(main);
		for(int i = 0 ; i < main.length ; i++) {
			int last = main[i].size() -1;
			float x = main[i].get(last).b().x();
			float y = main[i].get(last).b().y();
			text("je suis "+ i, x,y);
		}
	}
	

	public void show_lines_main(int start, int end) {
		show_list_impl(main, start, end);
	}

	public void show_lines_main(int index) {
		if(index >= 0 && index < main.length) {
			show_lines_impl(main[index]);	
		}
	}

	public void show_lines_main(int index, int start, int end) {
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

	/**
	* an other way to show circle, not like circle but by branch from main pie slide
	 */
	public void show_lines_branch(int index) {
		for(int i = 0 ; i < circle.length ; i++) {
			for(int k = 0 ; k < circle[i].size() ; k++) {
				if(index == get_abs_id(circle[i].get(k).id().a())) {
					show_single_line_impl(circle[i].get(k));
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
		if(start < 0) start = 0;
		if(start >= lines.size()) start = lines.size();
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
		if(use_mute_is()) {	
			if(!line.mute_is()) {
				line.show();
			}
		} else {
			line.show();
		}
	}





	// SHOW POLYGON
	////////////////////////
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

	public void show_polygon_heart(int mode) {
		show_polygons_from(imp_shapes_center,mode);
	}

	public void show_polygon_heart() {
		show_polygons_from(imp_shapes_center, Integer.MIN_VALUE);
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

	private void show_polygon(R_Shape shape) {
		beginShape();
		for(int i = 0 ; i < shape.get_summits() ; i++) {
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
				case 0:
					stroke(CYAN);
					circle(node.x(), node.y(), node.id().b());
					break;
				case 1:
					stroke(MAGENTA);
					circle(node.x(), node.y(), node.id().b());
					break;
				case 2:
					stroke(YELLOW);
					circle(node.x(), node.y(), node.id().b());
					break;
				default:
					stroke(WHITE);
					circle(node.x(), node.y(), node.id().b());
					break;
			}
		}
	}
}


