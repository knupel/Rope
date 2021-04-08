/**
* R_SLider
* Control ROmanesco Processing Environment
* v 1.2.0
* Copyleft (c) 2018-2021

* dependencies
* Processing 3.5.4
* @author @stanlepunk
* @see https://github.com/StanLepunK/Rope
*/
package rope.gui.slider;

import java.util.Arrays;

import rope.R_State.State;
import rope.gui.Crope;
import rope.gui.R_GUI;
import rope.gui.R_Mol;
import rope.vector.vec2;

public class R_Slider extends Crope implements R_GUI {
	protected R_Mol [] molette;
	
	protected vec2 pos_min;
	protected vec2 pos_max;

	protected int fill_molette_in = color(State.env().cx() * 0.4f);
	protected int fill_molette_out = color(State.env().cx() * 0.2f);
	protected int stroke_molette_in = fill_molette_in;
	protected int stroke_molette_out = fill_molette_out;
	protected float thickness_molette = 0;

	protected float min_norm = 0 ;
	protected float max_norm = 1 ;

	protected int molette_type = RECT;

	
	public R_Slider(vec2 pos, vec2 size) {
		super("Slider", pos, size);
	}

	public R_Slider(String type, vec2 pos, vec2 size) {
		super(type, pos, size);
	}

	// SET
	public R_Slider set_value(float... pos_norm) {
		set_value_calc(pos_norm);
		return this;
	}

	// public R_Slider opengl(boolean is) {
	// 	opengl(is, GRADIENT);
	// 	return this;
	// }

	protected void set_value_calc(float... pos_norm) {
		Arrays.sort(pos_norm);
		init_molette(pos_norm.length);

		for(int i = 0 ; i < molette.length ; i++) {
			molette[i].pos = new vec2();
			molette[i].id = i;
			// security to constrain the value in normalizing range.
			if(pos_norm[i] > 1.0f) pos_norm[i] = 1.0f;
			if(pos_norm[i] < 0.0f) pos_norm[i] = 0.0f;
			// check if it's horizontal or vertical slider      
			if(size.x() >= size.y()) {;
				float x = round(size.x() *pos_norm[i] +pos_min.x() -(molette[i].size.y() *pos_norm[i])); 
				float y = pos.y();
				molette[i].pos.set(x,y);
			} else {
				float x = pos.x();
				float y = round(size.y() *pos_norm[i] +pos_min.y() -(molette[i].size.x() *pos_norm[i]));
				molette[i].pos.set(x,y);
			}
			molette[i].set(pos_norm[i]);
		}
	}

	public R_Slider set_molette_num(int num) {
		init_molette(num);
		float [] pos_norm = new float[num];
		float step = 1.0f / (num+1) ;
		for(int i = 0 ; i < num ; i++) {
			pos_norm[i] = (i+1)*step;
		}
		set_value(pos_norm);
		return this;
	}

	private R_Slider set_molette_min_max_pos() {
		for(int i = 0 ; i < molette.length ; i++) {
			if(size.x() > size.y()) {
				pos_min = pos.copy();
				pos_max = new vec2(pos.x() +size.x() -molette[i].size.x(), pos.y()) ;
			} else {
				pos_min = pos.copy();
				pos_max = new vec2(pos.x(), pos.y() +size.y() -molette[i].size.y()) ;
			}
		}  
		return this;
	}

	public R_Slider set_molette(int type) {
		this.molette_type = type;
		if(molette == null) {
			init_molette(1);
		}
		return this;
	}


	// set size
	private void set_size_molette(int index) {
		if (size.x() >= size.y()) {
			molette[index].size = new vec2(size.y()); 
		} else {
			molette[index].size = new vec2(size.x());
		}
	}

	public R_Slider set_size_molette(vec2 size) {
		set_size_molette(size.x(), size.y());
		return this;
	}

	public R_Slider set_size_molette(float x, float y) {
		if(molette == null) {
			init_molette(1);
		}
		for(int i = 0 ; i < molette.length ; i++) {
			molette[i].size.set(x,y);
		}
		set_molette_min_max_pos();
		return this;
	}

	// set pos
	public R_Slider set_pos_molette() {
		for(int i = 0 ; i < molette.length ; i++) {
			set_pos_molette(i);
		}   
		return this;
	}

	public R_Slider set_pos_molette(int index) {
		this.molette[index].pos.set(pos);
		return this;
	}

	public R_Slider set_pos_molette(vec2... pos_mol) {
		init_molette(pos_mol.length);
		for(int i = 0 ; i < molette.length ; i++) {
			if(i < pos_mol.length) {
				set_pos_molette(i,pos_mol[i].x(), pos_mol[i].y());
			} else {
				set_pos_molette(i,pos.x(),pos.y());
			}
		}
		return this;
	}

	public R_Slider set_pos_molette(int index, float x, float y) {
		if(index < molette.length) {
			if(molette[index].pos == null) {
				molette[index].pos = new vec2(x,y);
			} else {
				molette[index].pos.set(x,y);
			}
		} 
		return this;
	}



	// aspect
	public R_Slider set_fill_molette(int c) {
		set_fill_molette(c,c);
		return this;
	}

	public R_Slider set_fill_molette(int c_in, int c_out) {
		this.fill_molette_in = c_in;
		this.fill_molette_out = c_out;
		return this;
	}
	
	public R_Slider set_stroke_molette(int c) {
		set_stroke_molette(c,c);
		return this;
	}

	public R_Slider set_stroke_molette(int c_in, int c_out) {
		this.stroke_molette_in = c_in;
		this.stroke_molette_out = c_out;
		return this;
	}

	public R_Slider set_thickness_molette(float thickness) {
		this.thickness_molette = thickness;
		return this;
	}






	// GET
	public float [] get() {
		int num = 1;
		if(molette != null) {
			num = molette.length;
		}
		float [] value_array = new float[num];
		for(int i = 0 ; i < value_array.length ; i++) {
			value_array[i] = get(i);
		}
		return value_array;
	}

	public float get(int index) {
		float value = molette[index].get();
		if(molette != null && index < molette.length 
			&& pos_min.x() > 0 && pos_min.y() > 0 
			&& pos_max.x() > 0 && pos_max.y() > 0) {
				if (size.x() >= size.y()) {  
				value = map(value, pos_min.x(),pos_max.x(), min_norm,max_norm); 
			} else {
				value = map(value, pos_min.y(),pos_max.y(), min_norm,max_norm);
			}
		}
		if(value < 0 || value > 1) value = molette[index].get();
		return value;
	}

	private boolean wheel_is() {
		return wheel_is;
	}

	public float get_min_norm() {
		return min_norm ;
	}

	public float get_max_norm() {
		return max_norm ;
	}
	
	public vec2 get_min_pos() {
		return pos_min;
	}

	public vec2 get_max_pos() {
		return pos_max;
	}

	public vec2 [] get_molette_pos() {
		vec2 [] pos = new vec2[molette.length] ;
		for(int i = 0 ; i < molette.length ;i++) {
			pos[i] = molette[i].pos().copy();
		}
		return pos;
	}

	public vec2 get_molette_pos(int index) {
		if(index < molette.length && index >= 0) {
			return molette[index].pos();
		} else {
			print_err("method get_molette_pos(",index,") is out of the range");
			return null;
		}
	}

	public vec2 get_molette_size(int index) {
		return molette[index].size();
	}

	public boolean molette_used_is() {
		boolean state = false;
		for(int i = 0 ; i < molette.length; i++) {
			if(molette_used_is(i)){
				state = true;
				break;
			}
		}
		return state;
	}

	public boolean molette_used_is(int index) {
		boolean inside = false ;
		if(molette_type == ELLIPSE) {
			inside = inside_molette_ellipse(index);
		} else {
			inside = inside_molette_rect(index);
		}

		if (inside && event) {
			return true ; 
		} else {
			return false ;
		}
	}

	public boolean molette_inside_is() {
		boolean is = false; 
		for(int i = 0 ; i < molette.length ; i++) {
			if(molette[i].inside_is()) {
				is = true ;
				break;
			}
		}
		return is;
	}

	public boolean molette_inside_is(int index) {
		boolean is = false; 
		if(index >= 0 && index < molette.length) {
			is = molette[index].inside_is();
		}
		return is;
	}

	public boolean select_is() {
		boolean is = false; 
		for(int i = 0 ; i < molette.length ; i++) {
			if(molette[i].select_is()) {
				is = true ;
				break;
			}
		}
		return is;
	}

	public boolean select_is(int index) {
		boolean is = false; 
		if(index >= 0 && index < molette.length) {
			is = molette[index].select_is();
		}
		return is;
	}

	public boolean used_is() {
		boolean is = false; 
		for(int i = 0 ; i < molette.length ; i++) {
			if(molette[i].used_is()) {
				is = true ;
				break;
			}
		}
		return is;
	}

	public boolean used_is(int index) {
		boolean is = false; 
		if(index >= 0 && index < molette.length) {
			is = molette[index].used_is();
		}
		return is;
	}


















	// SHOW
	public void show_structure() {
		if(!opengl_is) {
			if(this.mode == -1) {
				render_solid_color();
			} else if(any(this.mode == 10)) {
				gradient_spectrum(this.pos, this.size, false);
			} else if(any(this.mode == GRADIENT)) {
				gradient_hue(get(0), this.pos, this.size);
			} else {
				render_solid_color();
			}
		} else {
			render_gradient_color_opengl();
		}
	}

	private void render_gradient_color_opengl() {
		shader.set("value",this.root);
		// gradient case
		if(any(this.mode == GRADIENT, this.mode == GRADIENT_SATURATION, this.mode == GRADIENT_BRIGHTNESS)) {
			shader.set("mode",20);
			if(this.mode == GRADIENT_SATURATION) {
				shader.set("start_bri",0.0f); 
				shader.set("start_sat",0.0f); 
			} else if(this.mode == GRADIENT_BRIGHTNESS) {
				shader.set("start_sat",1.0f);
			}
		} else if(any(this.mode == SPECTRUM, this.mode == RAINBOW)) {
			shader.set("mode",19);
			shader.set("start_sat",this.sat);
			shader.set("start_bri",this.bri);
		} else {
			shader.set("mode",this.mode);
		}
		

		int sx = round(this.size.x());
		int sy = round(this.size.y());
	  this.pg.shader(shader);
	  this.pg.beginDraw();
	  this.pg.rect(0,0,sx,sy,this.rounded);
	  this.pg.endDraw();
	  image(this.pg,this.pos);
		render_solid_stroke();
		noFill();
		rect(pos,size,rounded);
	}

	private void render_solid_stroke() {
		if(all(thickness > 0,alpha(stroke_in) > 0, alpha(stroke_out) > 0)) {
			strokeWeight(thickness);
			if(inside(RECT)) {
				stroke(stroke_in);
			} else {
				stroke(stroke_out);
			}
		} else {
			noStroke();
		}
	}

	private void render_solid_color() {
		render_solid_stroke();
			if(inside(RECT)) {
			fill(fill_in);
		} else {
			fill(fill_out);
		}
		rect(pos,size,rounded);
	}









	public void show_molette() {
		for(int i = 0 ; i < molette.length ; i++) {
			if(molette[i].inside_is()) {
				aspect(fill_molette_in,stroke_molette_in,thickness_molette);
				molette_shape(i);
			} else {
				aspect(fill_molette_out,stroke_molette_out,thickness_molette);
				molette_shape(i);
			}   
		}
	}
	

	public void show_value() {
		show_value(get());
	}
	
	public void show_value(float... value) {
		String message = "[ ";
		for(int i = 0 ; i < value.length ; i++) {
			float f = truncate(value[i],2);
			message += f;
			if(i < value.length -1) message += ",";
		}
		message += " ]";
		show_value_impl(message);
	}






	/**
	 * UPDATE
	 */
	

	public void update() {
		if(State.select_mol_is() != null) {
			select(State.select_mol_is().x(), State.select_mol_is().y());
		}

		if(State.env().pointer == null) {
			print_err("Static State.env().pointer is null, maybe you forget to use: State.pointer(float x, float y)");
			System.exit(0);
		}
		update(State.env().pointer.x(),State.env().pointer.y());
	}
	
	/**
	 * 
	 * @param x
	 * @param y
	 */
	public void update(float x, float y) {
		if(!crope_build_is) {
			molette_builder(1);
		}
		cursor(x,y);
		molette_update();
	}
	
	
	/**
	 * It's the main method to move the molette the slider.
	 */
	protected void molette_update() {
		if(State.env().event == null) {
			print_err("Static State.env().event is null, maybe you forget to use: State.event(boolean... arg)");
			System.exit(0);
		} 
		this.event = State.env().event.a();
		if(!event) {
			State.set_dna_current_crope(0); 
		}
		if(molette == null) {
			init_molette(1);
		}
		molette_update_calc();
		molette_update_wheel();
	}
	
	
	private void molette_update_calc() {
		for(int i = 0 ; i < molette.length ; i++) {
			if(!molette[i].select_is()) {
				if(molette_used_is(i) && any(State.get_dna_current_crope() == 0, State.keep_selection_is())) {
					State.set_dna_current_crope(get_dna());
				}
				
				boolean auth_is = false;
				if(State.keep_selection_is()) {
					if(any(molette[i].used_is(), State.get_dna_current_crope() == get_dna())) {
						auth_is = true;
					}
				} else {
					if(State.get_dna_current_crope() == get_dna()) {
						auth_is = true;
					}
				}
				
				boolean is = select(i, molette_used_is(i), molette[i].used_is(), auth_is);
				molette[i].used(is);
				
				if(molette[i].used_is()) {
					mol_update_pos(i, temp_min(i), temp_max(i));
					mol_update_used_by_cursor(i, temp_min(i), temp_max(i));
					break;
				}   
			}
		}
	}
	
	private void molette_update_wheel() {
		if(wheel_is()) {
			if(State.env().scroll == null) {
				print_err_tempo(500,"Static State.env().scroll is null, maybe you forget to use: State.scroll(MouseEvent e) in the function void mouseWheel(MouseEvent e) {}");
			} else {
				float val = 0;
				if(size.x() >= size.y()) {
					float temp = molette[0].pos.x();
					temp += State.env().scroll.x();
					molette[0].pos.x(temp);
					val = molette[0].pos.x();
				} else {
					float temp = molette[0].pos.y();
					temp += State.env().scroll.y();
					molette[0].pos.y(temp);
					val = molette[0].pos.y();
				}
				mol_update_pos(0,temp_min(0),temp_max(0));
				if(size.x() >= size.y()) {
					val = round(constrain(val, temp_min(0).x(), temp_max(0).x()));
				} else { 
					val = round(constrain(val, temp_min(0).y(), temp_max(0).y()));
				}
				molette[0].set(val);
			}   
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// MISC
	private boolean wheel_is;
	public void wheel(boolean wheel_is) {
		if(molette == null) {
			init_molette(1);
		}
		if(molette.length == 1) {
			this.wheel_is = wheel_is; 
		} else {
			print_err_tempo(100, "method wheel(boolean wheel_is): Work only on mode single slider");
			this.wheel_is = false;
		} 
	}

	


	protected void init_molette(int len) {
		if(molette == null || len != molette.length) {
			molette_builder(len);
		}
	}

	private void molette_builder(int num) {
		molette = new R_Mol[num];
		for(int i = 0 ; i < num ; i++) {
			molette[i] = new R_Mol();
			this.set_pos_molette(i);
			set_size_molette(i);
			molette[i].id = 0;
			molette[i].used_is = false;
			molette[i].inside_is = false;
		}
		set_molette_min_max_pos();
		crope_build_is = true;
	} 

	private void molette_shape(int index) {
		if(molette_type == ELLIPSE) {
			vec2 temp = new vec2(round(mult(molette[index].size,0.5f)));
			vec2 pos = add(new vec2(molette[index].pos),temp);
			ellipse(pos, new vec2(molette[index].size));
		} else if(molette_type == RECT) {
			molette_rect(index);
		} else {
			molette_rect(index);
		}
	}
	
	private void molette_rect(int index) {
		if(size.x() > size.y()) {
			vec2 pos = new vec2(molette[index].pos);
			pos.y = pos.y -((molette[index].size.y() -size.y())/2);
			rect(pos, new vec2(molette[index].size));
		} else {
			vec2 pos = new vec2(molette[index].pos);
			pos.x = pos.x() -((molette[index].size.x() -size.x())/2);
			rect(pos, new vec2(molette[index].size));
		}
	}


	
	private void mol_update_used_by_cursor(int index, vec2 min, vec2 max) {
		if (molette[index].used_is) {
			float val = 0;
			if (size.x() >= size.y()) {
				val = round(constrain(cursor.x() -(molette[index].size.x() * 0.5f), min.x(), max.x()));
				molette[index].pos.x(val);
			} else { 
				val = round(constrain(cursor.y() -(molette[index].size.y() * 0.5f), min.y(), max.y()));
				molette[index].pos.y(val);
			}
			molette[index].set(val);
		}
	}
	

	private void mol_update_pos(int index, vec2 min, vec2 max) {
		// check for horizontal or vertical slider
		if(size.x() >= size.y()) {
			if (molette[index].pos.x() < min.x()) {
				molette[index].pos.x(min.x());
			}
			if (molette[index].pos.x() > max.x()) {
				molette[index].pos.x(max.x());
			}
		} else {
			if (molette[index].pos.y() < min.y()) {
				molette[index].pos.y(min.y());
			}
			if (molette[index].pos.y() > max.y()) {
				molette[index].pos.y(max.y());
			}
		}
	}


	private vec2 temp_min(int index) {
		vec2 min = pos_min.copy();
		if(molette.length > 1 && index > 0) {
			min.set(molette[index-1].pos);
			if(molette_type == ELLIPSE) {
			 if(size.x() >= size.y()) {
					min.add_x(size.y() /2);
				} else {
					min.add_y(size.x()/2);
				}
			} else {
				if(size.x() >= size.y()) {
					min.add_x(size.y());
				} else {
					min.add_y(size.x());
				}  
			}
		}
		return min;
	}

	private vec2 temp_max(int index) {
		vec2 max = pos_max.copy();
		 if(molette.length > 1 && index < molette.length -1) {
			max.set(molette[index+1].pos) ;
			if(molette_type == ELLIPSE) {
			 if(size.x() >= size.y()) {
					max.sub_x(size.y());
				} else {
					max.sub_y(size.x());
				}
			} else {
				if(size.x() >= size.y()) {
					max.sub_x(size.y());
				} else {
					max.sub_y(size.x());
				}  
			}
		}
		return max;
	}


	


	public boolean inside_molette_is(int index) {
		return molette[index].inside_is();
	}

	public boolean inside_molette_rect() {
		boolean state = false;
		for(int i = 0 ; i < molette.length; i++) {
			if(inside_molette_rect(i)) {
				state = true;
				break;
			}
		}
		return state;
	}

	public boolean inside_molette_rect(int index) {
		if(inside(molette[index].pos,molette[index].size,RECT)) {
			molette[index].inside_is(true); 
		} else {
			molette[index].inside_is(false);
		}
		return molette[index].inside_is();
	}
	
	public boolean inside_molette_ellipse() {
		boolean state = false;
		for(int i = 0 ; i < molette.length; i++) {
			state = true;
			break;
		}
		return state;
	}

	public boolean inside_molette_ellipse(int index) {
		if(cursor == null) {
			cursor = new vec2();
		}
		float radius = molette[index].size.x();
		int pos_x = (int)(radius * 0.5f + molette[index].pos.x()); 
		int pos_y = (int)(size.y() * 0.5f + molette[index].pos.y());
		if(pow((pos_x -cursor.x()),2) + pow((pos_y -cursor.y()),2) < pow(radius,sqrt(3))) {
			molette[index].inside_is = true ; 
		} else {
			molette[index].inside_is = false ;
		}
		return molette[index].inside_is;
	}





	// update position from midi controller
	public void update_midi(int... value) {
		if(value.length > molette.length) {
			print_err("method_midi(): there is too much midi value for the quantity of molette available.\nmethod apply only when is possible");
		}
		for(int i = 0 ; i < molette.length ; i++) {
			if(i < value.length) {
				update_midi(i, value[i]);
			} 
		}
	}

	public void update_midi(int index, int value) {
		//update the Midi position only if the Midi Button move
		if (midi_value != value) { 
			if(size.x() >= size.y()) {
				float temp = map(value, 1, 127, pos_min.x(), pos_max.x());
				molette[index].pos.x(temp);
				molette[index].set(temp); 
				
			} else {
				float temp = map(value, 1, 127, pos_min.y(), pos_max.y());
				molette[index].pos.y(temp);
				molette[index].set(temp);

			}
		}
	}


	
	
	
	
	
	
	
	/**
	 *  SELECTION
	 *  
	 *  
	 */
	
	
	boolean keep_selection = true;
	public void keep_selection(boolean is) {
		if(is) {
			this.keep_selection = false;
			} else {
			this.keep_selection = true;
		}
		
	}

	// select
	public void select(boolean auth) {
		for(int i = 0 ; i < molette.length ; i++) {
			select(i,auth);
		}
	}
	
	private void select(int index, boolean auth) {
		molette[index].select(keep_selection);
		event = State.env().event.a();
		molette[index].used_is = select(index, molette_used_is(index), molette[index].used_is, auth);
	}
	
	
	public  void select(boolean auth_1, boolean auth_2) {
		for(int i = 0 ; i < molette.length ; i++) {
			select(i,auth_1,auth_2);
		}
	}

	private void select(int index, boolean auth_1, boolean auth_2) {
		molette[index].select(keep_selection);
		event = auth_1;
		molette[index].used_is = select(index,molette_used_is(index),molette[index].used_is,auth_2);
	}
	

	// this method is used to switch false all select_is molette
	protected boolean select(boolean locked_method, boolean result, boolean auth) {
		return select(-1, locked_method,result,auth);
	}


	/**
	 * Here we call the static class R_State.State, to check the molette state, to be prevent multiple selection.
	 * @param index
	 * @param locked_method
	 * @param result
	 * @param authorization
	 * @return
	 */
	protected boolean select(int index, boolean locked_method, boolean result, boolean auth) {
		if(auth) {
			if(!State.molette_is()) {
				if (locked_method) {
					State.molette_is(true);
					result = true;
				}
			} else if(locked_method) {
				if(index == -1) {
					for(int i = 0 ; i < molette.length ;i++) {
						molette[i].select(false);
					}
				} else if(index >= 0 && index < molette.length) {
					molette[index].select(false);
				}
				result = true ;
			}

			if(!event) { 
				result = false ; 
				State.molette_is(false);
			}
			return result;
		} else {
			return false;   
		}
	}
	//
}
