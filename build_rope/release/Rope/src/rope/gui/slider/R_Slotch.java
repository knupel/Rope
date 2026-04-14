/**
* R_Slotch
* Control ROmanesco Processing Environment
* v 2.0.0
* Copyleft (c) 2018-2021
* @author Knupel / Stanislas Marçais
* @see https://github.com/StanLepunK/Rope
*/
package rope.gui.slider;

import rope.utils.R_State.State;
import rope.vector.vec2;

public class R_Slotch extends R_Slider {
	protected float [] notches_pos;
	protected int colour_notch = (int)(State.env().cx());
	protected float thickness_notch = 1.0f;

	protected boolean notch_is;
	protected int notches_num;

	public R_Slotch() {
		super("Slotch");
		set_notch(2);
	}

	public R_Slotch(vec2 pos, vec2 size, int num) {
		super("Slotch", pos, size);
		set_notch(num);
	}

	protected R_Slotch(String type, vec2 pos, vec2 size, int num) {
		super(type,pos, size);
		set_notch(num);
	}

	// SET
	public R_Slotch set_notch(int num) {
		notch_is = true;
		this.notches_num = num;
		notches_position();
		return this;
	}

	public R_Slotch set_aspect_notch(int c, float thickness) {
		this.colour_notch = c;
		this.thickness_notch = thickness;
		return this;
	}

	public R_Slotch set_aspect_notch(int c) {
		this.colour_notch = c ;
		return this;
	}

	public R_Slotch set_value(int pos_molette) {
		float pos_norm = (float)(pos_molette) / this.notches_num;
		set_value_calc(true, pos_norm);
		return this;
	}


	// GET
	public int get_notches_num() {
		return notches_num;
	}

	public float get() {
		return get(0);
	}

	public float get(int index) {
		float value = 0;
		if(molette != null && index < molette.length 
			&& pos_min.x() > 0 && pos_min.y() > 0 
			&& pos_max.x() > 0 && pos_max.y() > 0) {
			if (size.x() >= size.y()) {  
				value = map(molette[index].get(),
										pos_min.x(),pos_max.x(),
										min_norm,max_norm); 
			} else {
				value = map(molette[index].get(),
										pos_min.y(),pos_max.y(),
										min_norm,max_norm);
			}
		}

		if(value == 1) {
			return notches_num -1;
		}
		return floor(value*notches_num);
	}

	public float [] get_all() {
		int num = 0;
		if(molette != null) {
			num = molette.length;
		}
		float [] value = new float[num];
		for(int i = 0 ; i < value.length ; i++) {
			value[i] = get(i);
		}
		return value;
	}

	/**
	 *  UPDATE
	 */

	 /**
		* This function overwrite the method from slider to call the private own function update(float x, float y)
	  */
	public void update() {
		update_state();
		update(State.env().pointer.x(),State.env().pointer.y());
	}

	private void update(float x, float y) {
		cursor(x,y);
		event_impl(true);
		mol_update();
		// horizontal
		if (size.x() >= size.y()) { 
			if(notch_is) {
				for(int i = 0 ; i < molette.length ; i++) {
					molette[i].pos().x(floor(pos_notch_impl(molette[i].pos().x(), true)));
					molette[i].set(molette[i].pos().x());
				}    
			}
		// vertical
		} else { 
			if(notch_is) {
				for(int i = 0 ; i < molette.length ; i++) {
					molette[i].pos().y((int)pos_notch_impl(molette[i].pos().y(), false));
					molette[i].set(molette[i].pos().y());
				}
			}
		}
	}

	private float pos_notch_impl(float pos_molette, boolean vert_is) {
		float size = this.size.x();
		float pos = this.pos.x();
		if(!vert_is) {
			size = this.size.y();
			pos = this.pos.y();
		}

		float step = size / get_notches_num();
		float abs_pos = pos_molette - pos;
		
		float max_notch = (notches_pos.length -1) * step;
		step /= 2;
		for(int i = 0 ; i < notches_pos.length ; i++) {
			float min = notches_pos[i] - step;
			float max = notches_pos[i] + step;
			if(abs_pos >= min && abs_pos <= max) {
				abs_pos = notches_pos[i];
				break;
			}
			if(abs_pos < 0) {
				abs_pos = 0;
				break;
			}
			if(abs_pos > max_notch) {
				abs_pos = max_notch;
				break;
			}
		}
		return abs_pos + pos;
	}

	private float [] notches_position() {
		notches_pos = new float[get_notches_num()];
		// horizontal
		float step = size.x() / get_notches_num();
		// vertical
		if (size.x() < size.y()) {
			step = size.y() / get_notches_num();
		}
		for(int i = 0 ; i < get_notches_num(); i++) {
			notches_pos[i] = i * step;
		}
		return notches_pos;
	}
	
	/**
	 * Show separation between value
	 */
	public void show_notch() {
		show_notch(0,0);
	}

	/**
	 * Show separation between value
	 * @param start set the top or left limit of the separation
	 * @param stop et the bottom or right limit of the separation
	 */
	public void show_notch(int start, int stop) {
		stroke(colour_notch);
		noFill();
		strokeWeight(thickness_notch);
		// horizontal
		if (size.x() >= size.y()) {
			start = (int)pos.y() - start;
			stop += (pos.y() + size.y());
			for(int i = 1 ; i < notches_pos.length ; i++) {
				float abs_pos = notches_pos[i];
				float x = pos.x() + abs_pos;
				line(x, start, x, stop);
			}
		// vertical
		} else {
			start = (int)pos.x() - start;
			stop += (pos.x() + size.x());
			for(int i = 1 ; i < notches_pos.length ; i++) {
				float abs_pos = notches_pos[i];
				float y = pos.y() + abs_pos;
				line(start, y , stop, y);
			}
		} 
	}
}
