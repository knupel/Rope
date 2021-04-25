/**
* R_Bloc
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
import rope.vector.ivec2;
import rope.vector.vec2;
import rope.vector.vec3;

public class R_Bloc extends R_Graphic {
	private ArrayList<vec3> list;
	private int id;
	private String name;
	private boolean end;
	private boolean select_is;
	private boolean select_point_is;
	// private boolean action_available_is;
	private int index;
	private int magnetism = 1;
	private int colour_build;
	private int fill;
	private int stroke;
	private float thickness = 2.0f;
	private vec2 ref_coord;
	private vec2 coord;
	private ivec2 canvas;

	public R_Bloc(PApplet pa, int width, int height) {
    super(pa);
		list = new ArrayList<vec3>();
		id = (int)random(Integer.MAX_VALUE);
		coord = new vec2();
		ref_coord = new vec2();
		colour_build = CYAN;
		fill = BLANC;
		stroke = NOIR;
		this.canvas = new ivec2(width,height);
	}

	public void set_id(int id) {
		this.id = id;
	}

	public void set_magnetism(int magnetism) {
		this.magnetism = magnetism;
	}



	public void set_colour_build(int colour_build) {
		this.colour_build = colour_build;
	}

  public void fill(int fill) {
		this.fill = fill;
	}

	public void stroke(int stroke) {
		this.stroke = stroke;
	}

	public void thickness(float thickness) {
		this.thickness = thickness;
	}

	public void set_name(String name) {
		this.name = name;
	}

	// get
	public vec3 [] get() {
		return list.toArray(new vec3[list.size()]);
	}

	public int get_fill() {
		return this.fill;
	}

	public int get_stroke() {
		return this.stroke;
	}

	public float get_thickness() {
		return this.thickness;
	}

	public String get_name() {
		return this.name;
	}

	public int get_id() {
		return this.id;
	}

	public int get_magnetism() {
		return this.magnetism;
	}

	public String get_data() {
		String num = "" + list.size();
		String what = "bloc";
		String field_name = "name:"+name;
		String field_complexity = "complexity:"+num;
		String field_fill = "fill:"+fill;
		String field_stroke = "stroke:"+stroke;
		String field_thickness = "thickness:"+Float.toString(thickness);
		String setting = what + "," + field_name + "," + field_complexity + "," + field_fill + "," + field_stroke + "," + field_thickness;
		for(vec3 v : list) {
			String type = "type:0";
			String ax = "ax:" + Float.toString(v.x());
			String ay = "ay:" + Float.toString(v.y());
			// type 0 is a simple vertex
			// type 1 is for bezier vertex for the future version
			setting += "," + type + "<>" + ax + "<>" + ay;
		}
		setting += ",close:" + end;
		return setting;
	}

	public boolean in_bloc(float x, float y) {
		return in_polygon(get(),new vec2(x,y));
	}

	public boolean end_is() {
		return end;
	}

	private boolean intersection(vec2 point) {
		for(int i = 1 ; i < list.size() ; i++) {
			vec2 a = new vec2(list.get(i-1));
			vec2 b = new vec2(list.get(i));
			if(is_on_line(a,b,point,magnetism)) {
				index = i; 
				return true;
			}
		}
		return false;
	}

	private boolean end(vec2 point) {
		int max = list.size() - 1;
		if(dist(new vec2(list.get(0)), point) < magnetism) {
			index = 0;
			end = true;
			return true;
		}
		return false;
	}

	private boolean near_of(vec2 point) {
		for(int i = 1 ; i < list.size() ; i++) {
			if(dist(new vec2(list.get(i)), point) < magnetism) {
				index = i;
				return true;
			}

		}
		return false;
	}

	public boolean select_point_is() {
		return select_point_is;
	}

	public boolean select_is() {
		return select_is;
	}


	// update
	public void update(float x, float y) {
		coord.set(x,y);
	}

	/**
	* build
	*/
	public void build(float x, float y, boolean event_is) {
		build(x, y, event_is, true);
	}

	public void build(float x, float y, boolean event_is, boolean security_is) {
		update(x,y);
		if(event_is) {
			vec2 point = new vec2(x,y);
			if(list.size() > 1) {
				if(list.size() > 2 && end(point)) {
					add(new vec2(list.get(index)));
				} else if(security_is && near_of(point)) {
					list.remove(index);
				} else if(security_is && intersection(point)) {
					add(index, point);
				} else {
					add(point);
				}
			} else {
				if(list.size() == 1 && near_of(point)) {
					//
				} else {
					add(point);
				}
			}
		}
	}

	private void add(vec2 point) {
		vec3 temp = new vec3(point);
		mag_canvas(temp);
		list.add(temp);
	}

	private void add(int index, vec2 point) {
		vec3 temp = new vec3(point);
		mag_canvas(temp);
		list.add(index,temp);
	}

	/**
	* move
	*/
	public void move(float x, float y, boolean event_is) {
		if(event_is) {
			vec3 offset = new vec3(sub(ref_coord,coord));
			for(vec3 p : list) {
				p.sub(offset);
			}
			ref_coord.set(coord);
		} else {
			ref_coord.set(coord);
		}
	}
	
	public void move_point(float x, float y, boolean event_is) {
		if(event_is) {
			vec3 offset = new vec3(sub(ref_coord,coord));
			for(vec3 p : list) {
				if(p.z() == 1) {
					p.sub(offset);
					mag_canvas(p);
					p.z(1);
				}
			}
			ref_coord.set(coord);
		} else {
			ref_coord.set(coord);
		}
	}


	private void mag_canvas(vec3 p) {
		if(p.x() < 0 + magnetism) p.x(0);
		if(p.x() > canvas.x() - magnetism) p.x(canvas.x());
		if(p.y() < 0 + magnetism) p.y(0);
		if(p.y() > canvas.y() -magnetism) p.y(canvas.y());
	}


	/**
	* select
	*/
	public void reset_all_points() {
		for(vec3 v : list) {
			select_point_is(false);
			v.z(0);
		}	
	}

	public void select_all_points() {
		for(vec3 v : list) {
			select_point_is(true);
			v.z(1);
		}	
	}

	public void select_point(float x, float y) {
		for(int i = 0 ; i < list.size() ; i++) {
			vec3 v = list.get(i);
			if(dist_is(v, x, y)) {
				select_point_is(true);	
				if(end && (i == 0 || i == list.size() -1)) {
					list.get(0).z(1);
					list.get(list.size() -1).z(1);
				} else {
					v.z(1);
				}
				break;
			}
		}
	}

	public void select(float x, float y) {
		if(in_bloc(x,y)) {
			select_is(true);
		}
	}

	public void select_is(boolean is) {
		this.select_is = is;
	}

	public void select_point_is(boolean is) {
		this.select_point_is = is;
	}

	/**
	* misc
	*/
	private boolean dist_is(vec3 v, float x, float y) {
		return (dist(new vec2(v), new vec2(x,y)) < magnetism);
	}

	public void clear() {
		list.clear();
	}

	/**
	* show
	*/
	private void next(PGraphics other) {
		if(other != null)
			other.beginDraw();
		if(list.size() > 0) {
      vec3 buf = list.get(list.size()-1);
			other.line(buf.x(),buf.y(),coord.x(),coord.y());
		}
		if(other != null)
			other.endDraw();
	}

	public boolean show_available_point(float x, float y) {
		return calc_show_available_point(x, y, this.pa.g);
	}

	public boolean show_available_point(float x, float y, PGraphics other) {
		boolean is = false;
		if(other != null)
			other.beginDraw();
		is = calc_show_available_point(x, y, this.pa.g);
		if(other != null)
			other.endDraw();
		return is;
	}

	private boolean calc_show_available_point(float x, float y, PGraphics other) {
		update(x,y);
		other.fill(BLANC);
		float size = 5;
		if(list.size() > 0) {
			for(int index = 0 ; index < list.size() ; index++) {
				if(dist(coord, new vec2(list.get(index))) < magnetism) {
					vec2 pos = sub(new vec2(list.get(index)), new vec2(size).mult(0.5f));
					other.square(pos.x(), pos.y(),size);
          vec2 buf_a = pos.copy().add(0,size/2);
          vec2 buf_b = pos.copy().add(size,size/2);
					other.line(buf_a.x(),buf_a.y(),buf_b.x(),buf_b.y());
					// action_available_is = true;
					return true;
				}
				if(list.size() > 1 && index > 0) {
					vec2 a = new vec2(list.get(index-1));
					vec2 b = new vec2(list.get(index));
					if(is_on_line(a,b,coord,magnetism)) {
						vec2 pos = sub(coord, new vec2(size).mult(0.5f));
						other.square(pos.x(),pos.y(),size);
            vec2 buf_a = pos.copy().add(0,size/2);
            vec2 buf_b = pos.copy().add(size,size/2);
            other.line(buf_a.x(),buf_a.y(),buf_b.x(),buf_b.y());
						// other.line(pos.copy().add(0,size/2),pos.copy().add(size,size/2));
            buf_a = pos.copy().add(size/2,0);
            buf_b = pos.copy().add(size/2,size);
            other.line(buf_a.x(),buf_a.y(),buf_b.x(),buf_b.y());
						// other.line(pos.copy().add(size/2,0),pos.copy().add(size/2,size));
						// action_available_is = true;
						return true;
					}
				}
			}
		}
		return false;
	}


	public void show_anchor_point() {
		calc_show_anchor_point(this.pa.g);
	}

	public void show_anchor_point(PGraphics other) {
		if(other != null)
			other.beginDraw();
		calc_show_anchor_point(other);
		if(other != null)
			other.endDraw();
	}

	private void calc_show_anchor_point(PGraphics other) {
		float size = 5;
		// past selection
		other.fill(BLANC);
		other.stroke(colour_build);
		other.strokeWeight(1);
		int max = list.size() - 1;
		for(int index = 0 ; index < max; index++) {
      vec2 buf = sub(new vec2(list.get(index)), new vec2(size).mult(0.5f));
			if(index == 0 && !end) { 
				other.square(buf.x(), buf.y(),size * 1.5f);
			} else {
				other.square(buf.x(), buf.y(),size);
			}
		}
		// current selection
		other.fill(colour_build);
		if(max >= 0) {
      vec2 buf = sub(new vec2(list.get(max)), new vec2(size).mult(0.5f));
			other.square(buf.x(), buf.y(), size);
		}
	}

	public void show_struc() {
		calc_show_struc(false,this.pa.g);
	}

	public void show_struc(PGraphics other) {
		if(other != null) {
			other.beginDraw();
		}
		calc_show_struc(true,other);
		if(other != null) {
			other.endDraw();
		}
	}

	private void calc_show_struc(boolean draw_is, PGraphics other) {
		other.strokeWeight(1);
		other.noFill();
		other.stroke(colour_build);
		other.beginShape();
		for(int index = 0 ; index < list.size() ; index++) {
      other.vertex(list.get(index).x(),list.get(index).y());
		}
		other.endShape();
		if(!end) {
			if(draw_is) {
				other.beginDraw();
				next(other);
				other.endDraw();
			} else {
				next(other);
			}
		}
	}

	public void show() {
		calc_show(this.pa.g);
	}

	public void show(PGraphics other) {
		if(other != null) {
			other.beginDraw();
		}
		calc_show(other);
		if(other != null) {
			other.endDraw();
		}
	}

	private void calc_show(PGraphics other) {
		// fill(fill,other);
		// stroke(stroke,other);
		// strokeWeight(thickness,other);
		aspect(fill,stroke,thickness,other);
		if(list.size() == 2) {
      other.line(list.get(0).x(),list.get(0).y(),list.get(1).x(),list.get(1).y());
		} else if(list.size() > 2) {
			other.beginShape();
			for(int index = 0 ; index < list.size() ; index++) {
        other.vertex(list.get(index).x(),list.get(index).y());
			}
			other.endShape();
		}
	}
}
