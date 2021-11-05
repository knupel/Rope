/**
* R_Slotch
* Control ROmanesco Processing Environment
* v 1.1.0
* Copyleft (c) 2018-2021

* dependencies
* Processing 3.5.4
* @author @stanlepunk
* @see https://github.com/StanLepunK/Rope
*/
package rope.gui.slider;

import rope.vector.vec2;
import rope.R_State.State;

public class R_Slotch extends R_Slider {
	protected float [] notches_pos;
	protected int colour_notch = (int)(State.env().cx());
	protected float thickness_notch = 1.0f;

	protected boolean notch_is;
	protected int notches_num;
	protected int notch;

	public R_Slotch() {
		super("Slotch");
		set_notch(2);
	}

	public R_Slotch(vec2 pos, vec2 size, int num) {
		super("Slotch", pos, size);
		set_notch(num);
	}

	public R_Slotch(String type, vec2 pos, vec2 size, int num) {
		super(type,pos, size);
		set_notch(num);
	}

	// SET
	public R_Slotch set_notch(int num) {
		notch_is = true;
		this.notches_num = num +1;
		notches_position();
		return this;
	}

	public R_Slotch set_aspect_notch(int c, float thickness) {
		this.colour_notch = c ;
		this.thickness_notch = thickness;
		return this;
	}

	public R_Slotch set_aspect_notch(int c) {
		this.colour_notch = c ;
		return this;
	}

	public R_Slotch set_value(int pos_molette) {
		float pos_norm = (float)(pos_molette +1) / this.notches_num;
		set_value_calc(true, pos_norm);
		return this;
	}


	// GET
	public int get_notch() {
		return notch;
	}

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

		value = round(value*(float)notches_num) -1;
		return value;
	}

	public float [] get_all() {
		int num = 1;
		if(molette != null) {
			num = molette.length;
		}
		float [] value = new float[num];
		for(int i = 0 ; i < value.length ; i++) {
			value[i] = get(i);
		}
		return value;
	}



	// MISC
	// public void update(float x, float y) {
	// cursor(x,y);
	// mol_update();
	public void update(float x, float y, boolean event) {
		cursor(x,y);
		mol_update(event);
		if (size.x() >= size.y()) { 
			if(notch_is) {
				for(int i = 0 ; i < molette.length ; i++) {
					molette[i].pos.x(floor(pos_notch(size.x(), molette[i].pos.x())));
					molette[i].set(molette[i].pos.x());
				}    
			}
		} else { 
			if(notch_is) {
				for(int i = 0 ; i < molette.length ; i++) {
					molette[i].pos.y((int)pos_notch(size.y(), molette[i].pos.y()));
					molette[i].set(molette[i].pos.y());
				}
			}
		}
	}



	private float pos_notch(float size, float pos_molette) {

		float step = size / (float)get_notches_num();
		float offset_slider_pos_x = pos().x() -step;
		float abs_pos = pos_molette -offset_slider_pos_x;
		
		for(int i = 1 ; i < notches_pos.length ; i++) {
			float min = notches_pos[i] - (step * 0.5f);
			float max = notches_pos[i] + (step * 0.5f);
			if(abs_pos > min && abs_pos < max) {
				abs_pos = notches_pos[i];
				break;
			} else if(abs_pos <= min ) {
				abs_pos = notches_pos[i];
				break;
			} else if(abs_pos >= notches_pos[notches_pos.length-1] + (step *.5) ) {
				abs_pos = notches_pos[notches_pos.length-1];
				break;
			}
		}
		
		// here it's buggy, need to find a good ratio for the diffente size of slotch
		// actully that's work well only when the step is equal to the mollete size in x and in y
		float offset = 0;
		float size_mol = molette[0].size.x();
		float ratio = (size_mol / step) * 0.5f;
		offset = step * 0.5f -(size_mol *ratio);
		return abs_pos - offset + offset_slider_pos_x;
	}




	public float [] notches_position() {
		notches_pos = new float[get_notches_num()];
		float step = size.x() / get_notches_num();
		for(int i = 0 ; i < get_notches_num(); i++) {
			notches_pos[i] = (i + 1) * step -(step * 0.5f);
		}
		return notches_pos;
	}
	
	public void show_notch() {
		show_notch(0,0);
	}

	public void show_notch(int start, int stop) {
		stroke(colour_notch);
		noFill();
		strokeWeight(thickness_notch);
		if (size.x >= size.y) {
			start += pos.y();
			stop += size.y();
			for(int i = 0 ; i < notches_pos.length ; i++) {
				float abs_pos = notches_pos[i];
				line(pos.x() +abs_pos,start,pos.x() + abs_pos,start +stop);
			}
		} else {
			start += pos.x();
			stop += size.x();
			for(int i = 0 ; i < notches_pos.length ; i++) {
				float abs_pos = notches_pos[i];
				line(start,pos.y() + abs_pos,start+stop,pos.y() +abs_pos);
			}
		} 
	}
}
