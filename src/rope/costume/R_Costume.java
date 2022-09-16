/**
* R_Costume
* v 0.2.2
* 2019-2021
* @author @stanlepunk
* @see https://github.com/StanLepunK/Rope
*/
package rope.costume;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PGraphics;
import processing.core.PImage;
import rope.mesh.R_Shape;
import rope.vector.ivec2;
import rope.vector.vec;
import rope.vector.vec2;
import rope.vector.vec3;
import rope.vector.vec4;

public class R_Costume extends R_Shape {
	private boolean fill_is = true;
	private boolean stroke_is = true;
	private boolean alpha_is = true;

	private float ratio_costume_size = 1.0f;

	// vec3 pos;
	// vec3 size;
	// vec3 angle;

	private int fill = BLANC;
	private int stroke = NOIR;
	private float thickness = 1.0f;

  private String name;
  private String costume_text;
	private int type;
	private int node;
	// private int summits;
	private int num;
	private int mutation;
  // float angle;
	private float [] ratio;
	private float [] strength;
	private vec2 [] pair;
	private boolean is_3D = false;
	private boolean is_vertex = true;
	private R_Primitive prim;
	private R_Polyhedron poly;
	private R_Virus virus;
	private R_House house;
	private R_Circle flower;
	private R_Star star;
	ArrayList <R_Costume_Pict> costume_pic_list = new ArrayList<R_Costume_Pict>() ;

	int align = LEFT;

	public R_Costume(PApplet pa) {
		super(pa);
		init();
	}

	public R_Costume(PApplet pa, int type) {
		super(pa);
		init();
		this.type = type;
	}

	public R_Costume(PApplet pa, String costume_text) {
		super(pa);
		init();
		this.type = TEXT;
		this.costume_text = costume_text;
	}


	private void init() {
		poly = new R_Polyhedron(pa);
	}

	/**
	 * load image for the costume, only SVG or PNG
	 * @param path
	 */
	public void load_pict(String path) {
		if(path.endsWith("png") || path.endsWith("PNG") || path.endsWith("svg") || path.endsWith("SVG")) {
			int new_ID = costume_pic_list.size() * (-1) ;
			new_ID -= 1 ;
			R_Costume_Pict c = new R_Costume_Pict(this.pa, path, new_ID) ;
			costume_pic_list.add(c);
			String mess = "ID pic: " +new_ID;
			System.err.println(mess);
		}
	}

	public void pass_graphic(PGraphics other) {
  	if(other != null) {
  		this.other = other;
  	}
  }
  
  // set
  public void set_text(String costume_text) {
		this.costume_text = costume_text;
	}

  public void set_name(String name) {
		this.name = name;
	}

  public void set_type(int type) {
		this.type = type;
	}

	public void set_node(int node) {
		this.node = node;
	}

	public void set_mutation(int mutation) {
		this.mutation = mutation;
	}

	public void set_summit(int summits) {
		this.summits = summits;
	}

	public void set_num(int num) {
		this.num = num;
	}

	public void set_align(int align) {
		this.align = align;
	} 


	public void set_ratio(float... ratio) {
		this.ratio = ratio;
	}

	public void set_strength(float... strength) {
		this.strength = strength;
	}

	public void set_pair(vec2... pair) {
		this.pair = pair;
	}

	public void is_3D(boolean is_3D) {
		this.is_3D = is_3D;
	}

	public void is_vertex(boolean is_vertex) {
		this.is_vertex = is_vertex;
	}


	// get
	public int get_fill() {
		return fill;
	}

	public int get_stroke() {
		return stroke;
	}

	public float get_thickness() {
		return thickness;
	}
  
  public String get_name() {
  	return name;
  }
  
	public int get_type() {
		return type;
	}

	public int get_node() {
		return node;
	}

	public int get_mutation() {
		return mutation;
	}

	public int get_summit() {
		return summits;
	}

	public int get_num() {
		return num;
	}

	public float[] get_ratio() {
		return ratio;
	}

	public float[] get_strength() {
		return strength;
	}

	public vec2[] get_pair() {
		return pair;
	}

	public boolean is_3D() {
		return is_3D;
	}

	public boolean is_vertex() {
		return is_vertex;
	}

	public boolean fill_is() {
		return this.fill_is;
	}

	public boolean stroke_is() {
		return this.stroke_is;
	}

	public boolean alpha_is() {
		return this.alpha_is;
	}






	// ASPECT
	public void fill_is(boolean fill_is) {
		this.fill_is = fill_is;
	}

	public void stroke_is(boolean stroke_is) {
		this.stroke_is = stroke_is;
	}

	public void alpha_is(boolean alpha_is) {
		this.alpha_is = alpha_is;
	}

	public void aspect_is(boolean fill_is, boolean stroke_is, boolean alpha_is) {
		this.fill_is = fill_is;
		this.stroke_is = stroke_is;
		this.alpha_is = alpha_is;
	}

	public void init_bool_aspect() {
		this.fill_is = true ;
	  this.stroke_is = true ;
	}

	public void aspect(int fill, int stroke, float thickness) {
	  //checkfill color
	  if(alpha(fill) <= 0 || !this.fill_is)  {
	    noFill(); 
	  } else {
	  	manage_fill(fill);
	  } 
	  //check stroke color
	  if(alpha(stroke) <=0 || thickness <= 0 || !this.stroke_is) {
	    noStroke();
	  } else {
	  	manage_stroke(stroke);
	    manage_thickness(thickness);
	  }
	  init_bool_aspect();
	}

	public void aspect(int fill, int stroke, float thickness, R_Costume costume) {
		aspect(fill,stroke,thickness,costume.get_type());
	}

	public void aspect(int fill, int stroke, float thickness, int costume) {
		if(costume == NULL) {
	    // 
		} else if(costume != NULL || costume != POINT) {
	    if(alpha(fill) <= 0 || !this.fill_is) {
	    	noFill(); 
	    } else {
	    	manage_fill(fill);
	    }

	    if(alpha(stroke) <= 0  || thickness <= 0 || !this.stroke_is) {
	    	noStroke(); 
	    } else {
	    	manage_stroke(stroke);
	      manage_thickness(thickness);
	    }   
	  } else {
	    if(alpha(fill) == 0) {
	    	noStroke(); 
	    } else {
	    	// case where the fill is use like a stroke, for point, pixel...
	    	manage_stroke(fill);
	    	manage_thickness(thickness);
	    }
	    noFill();   
	  }
	  init_bool_aspect();
	}



	public void aspect(vec fill, vec stroke, float thickness) {
	  //checkfill color
	  if(fill.w() <= 0 || !this.fill_is)  {
	    noFill() ; 
	  } else {
	    manage_fill(fill);
	  } 
	  //check stroke color
	  if(stroke.w() <=0 || thickness <= 0 || !this.stroke_is) {
	    noStroke();
	  } else {
	    manage_stroke(stroke);
	    manage_thickness(thickness);
	  }
	  init_bool_aspect();
	}

	public void aspect(vec fill, vec stroke, float thickness, R_Costume costume) {
		aspect(fill,stroke,thickness,costume.get_type());
	}


	public void aspect(vec fill, vec stroke, float thickness, int costume) {
	  if(costume == NULL) {
	    // 
		} else if(costume != NULL || costume != POINT) {
	    if(fill.w() <= 0 || !this.fill_is) {
	    	noFill() ; 
	    } else {
	    	manage_fill(fill);
	    } 
	    if(stroke.w() <= 0  || thickness <= 0 || !this.stroke_is) {
	    	noStroke(); 
	    } else {
	    	manage_stroke(stroke);
	    	manage_thickness(thickness);
	    }   
	  } else {
	    if(fill.w() <= 0 || !this.fill_is) {
	    	noStroke(); 
	    } else {
	    	// case where the fill is use like a stroke, for point, pixel...
	    	manage_stroke(fill); 
	    	manage_thickness(thickness);
	    }
	    noFill();   
	  }
	  init_bool_aspect();
	}


	private void manage_fill(Object arg) {
		if(arg instanceof vec2) {
			vec2 c = (vec2)arg;
			if(alpha_is()) {
				this.fill = color(c.x(),c.x(),c.x(),c.y());
			} else { 
				this.fill = color(c.x(),c.x(),c.x(),this.pa.g.colorModeA);
			}
			fill(this.fill);
		} else if(arg instanceof vec3) {
			vec3 c = (vec3)arg;
			this.fill = color(c.x(),c.y(),c.z(),this.pa.g.colorModeA);
			fill(this.fill);
		} else if(arg instanceof vec4) {
			vec4 c = (vec4)arg;
			if(alpha_is()) {
				this.fill = color(c.x(),c.y(),c.z(),c.w());
			} else {
				this.fill = color(c.x(),c.y(),c.z(),this.pa.g.colorModeA);
			}
			fill(this.fill);
		} else if(arg instanceof Integer) {
			int c = (int)arg;
			if(alpha_is()) {
				fill(c);	
			} else {
				if(this.pa.g.colorMode == 3) {
					this.fill = color(hue(c),saturation(c),brightness(c),this.pa.g.colorModeA);
				} else {
					this.fill = color(red(c),green(c),blue(c),this.pa.g.colorModeA);
				}
				fill(this.fill);
			}
		}
	}

	private void manage_stroke(Object arg) {
		if(arg instanceof vec2) {
			vec2 c = (vec2)arg;
			if(alpha_is()) {
				this.stroke = color(c.x(),c.x(),c.x(),c.y());
			} else {
				this.stroke = color(c.x(),c.x(),c.x(),this.pa.g.colorModeA);
			}
			stroke(this.stroke);
		} else if(arg instanceof vec3) {
			vec3 c = (vec3)arg;
			this.stroke = color(c.x(),c.y(),c.z(),this.pa.g.colorModeA);
			stroke(this.stroke);
		} else if(arg instanceof vec4) {
			vec4 c = (vec4)arg;
			if(alpha_is()) {
				this.stroke = color(c.x(),c.y(),c.z(),c.w());
			} else {
				this.stroke = color(c.x(),c.y(),c.z(),this.pa.g.colorModeA);
			}			
			stroke(this.stroke);
		} else if(arg instanceof Integer) {
			int c = (int)arg;
			if(alpha_is()) {
				stroke(c);	
			} else {
				if(this.pa.g.colorMode == 3) {
					this.stroke = color(hue(c),saturation(c),brightness(c),this.pa.g.colorModeA);
				} else {
					this.stroke = color(red(c),green(c),blue(c),this.pa.g.colorModeA);
				}
				stroke(this.stroke);
			}
		}
	}


	private void manage_thickness(float thickness) {
		this.thickness = thickness;
		strokeWeight(this.thickness);
	}


	private boolean costume_rot_x;
	private boolean costume_rot_y;
	private boolean costume_rot_z;

	private void costume_rotate_x() {
		costume_rot_x = true;
	}

	private void costume_rotate_y() {
		costume_rot_y = true;
	}

	private void costume_rotate_z() {
		costume_rot_z = true;
	}

	private void costume_rotate(vec rotate) {
		if(get_renderer() == P3D) {
			if(costume_rot_x && rotate.x() != 0) {
				rotateX(rotate.x());
				costume_rot_x = false;
			}
			if(costume_rot_y && rotate.y() != 0) {
				rotateY(rotate.y());
				costume_rot_y = false;
			}
			if(costume_rot_z && rotate.z() != 0) {
				rotateZ(rotate.z());
				costume_rot_z = false;
			}
		} else {
			if(rotate.x() == 0 && rotate.y() == 0 && rotate.z() != 0 && costume_rot_x) {
				rotate(rotate.z());
				costume_rot_x = false;
			} 
			if(costume_rot_x && rotate.x() != 0) {
				rotateX(rotate.x());
				costume_rot_x = false;
			}
			if(costume_rot_y && rotate.y() != 0) {
				rotateY(rotate.y());
				costume_rot_y = false;
			}
		}
	}








	/**
	 * It the main method, it's here where the choice 
	 * what must be shown among the various objects in the collection
	 */
	public void show() {
		show(pos,size,angle);
	}
	/**
	 * It the main method, it's here where the choice 
	 * what must be shown among the various objects in the collection
	 * @param pos
	 * @param size
	 * @param rot
	 */
	public void show(vec3 pos, vec3 size, vec rot) {
		if(rot.x() != 0) costume_rotate_x();
		if(rot.y() != 0) costume_rotate_y();
		if(rot.z() != 0) costume_rotate_z();

		if (this.get_type() == PIXEL) {
			set((int)pos.x(),(int)pos.y(),this.fill);
		} else if (this.get_type() == POINT) {
	    strokeWeight(size.x());
			point(pos);
		} else if (this.get_type() == ELLIPSE) {
			push();
			translate(pos);
			costume_rotate(rot);
			ellipse(new vec2(), new vec2(size));
			pop();

		} else if (this.get_type() == RECT) {
			push();
			translate(pos);
			costume_rotate(rot);
			rect(new vec2(-size.x(),-size.y()).div(2), new vec2(size.x(),size.y()));
			pop();

		} else if (this.get_type() == LINE) {
			if(prim == null) prim = new R_Primitive(this.pa,2);
			push();
			translate(pos);
			costume_rotate(rot);
			prim.pass_graphic(other);
			prim.size((int)size.x());
			prim.show();
			pop();
		}

		else if (this.get_type() == TRIANGLE) {
			if(prim == null || prim.get_summits() != 3) {
				prim = new R_Primitive(this.pa,3);
			}
			push();
			translate(pos);
			costume_rotate(rot);
			prim.pass_graphic(other);
			prim.size((int)size.x());
			prim.show();
			pop();
		}  else if (this.get_type() == SQUARE) {
			if(prim == null  || prim.get_summits() != 4) {
				prim = new R_Primitive(this.pa,4);
			}
			push();
			translate(pos);
			costume_rotate(rot);
			prim.pass_graphic(other);
			prim.size((int)size.x());
			prim.show();
			pop();
		} else if (this.get_type() == PENTAGON) {
			if(prim == null || prim.get_summits() != 5) {
				prim = new R_Primitive(this.pa,5);
			}
			push();
			translate(pos);
			costume_rotate(rot);
			prim.pass_graphic(other);
			prim.size((int)size.x());
			prim.show();
			pop();
		} else if (this.get_type() == HEXAGON) {
			if(prim == null || prim.get_summits() != 6) {
				prim = new R_Primitive(this.pa,6);
			}
			push();
			translate(pos);
			costume_rotate(rot);
			prim.pass_graphic(other);
			prim.size((int)size.x());
			prim.show();
			pop();
		} else if (this.get_type() == HEPTAGON) {
			if(prim == null || prim.get_summits() != 7) {
				prim = new R_Primitive(this.pa,7);
			}
			push();
			translate(pos);
			costume_rotate(rot);
			prim.pass_graphic(other);
			prim.size((int)size.x());
			prim.show();
			pop();
		} else if (this.get_type() == OCTOGON) {
			if(prim == null || prim.get_summits() != 8) {
				prim = new R_Primitive(this.pa,8);
			}
			push();
			translate(pos);
			costume_rotate(rot);
			prim.pass_graphic(other);
			prim.size((int)size.x());
			prim.show();
			pop();
		} else if (this.get_type() == NONAGON) {
			if(prim == null || prim.get_summits() != 9) {
				prim = new R_Primitive(this.pa,9);
			}
			push();
			translate(pos);
			costume_rotate(rot);
			prim.pass_graphic(other);
			prim.size((int)size.x());
			prim.show();
			pop();
		} else if (this.get_type() == DECAGON) {
			if(prim == null || prim.get_summits() != 10) {
				prim = new R_Primitive(this.pa,10);
			}
			push();
			translate(pos);
			costume_rotate(rot);
			prim.pass_graphic(other);
			prim.size((int)size.x());
			prim.show();
			pop();
		} else if (this.get_type() == HENDECAGON) {
			if(prim == null  || prim.get_summits() != 11) {
				prim = new R_Primitive(this.pa,11);
			}
			push();
			translate(pos);
			costume_rotate(rot);
			prim.pass_graphic(other);
			prim.size((int)size.x());
			prim.show();
			pop();
		} else if (this.get_type() == DODECAGON) {
			if(prim == null  || prim.get_summits() != 12) {
				prim = new R_Primitive(this.pa,12);
			}
			push();
			translate(pos);
			costume_rotate(rot);
			prim.pass_graphic(other);
			prim.size((int)size.x());
			prim.show();
			pop();
		}

		else if (this.get_type() == CROSS_RECT) {
			push();
			translate(pos);
			costume_rotate(rot);
			cross_rect_show(new ivec2(0),(int)size.y(),(int)size.x());
			pop();
		} else if (this.get_type() == CROSS_BOX_2) {
			push();
			translate(pos);
			costume_rotate(rot);
			cross_box_2_show(new vec2(size.x(), size.y()));
			pop();
		} else if (this.get_type() == CROSS_BOX_3) {
			push();
			translate(pos);
			costume_rotate(rot);
			cross_box_3_show(size);
			pop();
		}

	  else if(this.get_type() == TEXT) {
	  	push();
	  	translate(pos);
	  	costume_rotate(rot);
	  	textAlign(align);
	  	textSize(size.x());
	  	text(costume_text,0,0);
	  	pop();
	  }

		else if (this.get_type() == SPHERE_LOW) {
			push();
			translate(pos);
			costume_rotate(rot);
			sphereDetail(5);
			sphere(size.x());
			pop();
		} else if (this.get_type() == SPHERE_MEDIUM) {
			push();
			translate(pos);
			costume_rotate(rot);
			sphereDetail(12);
			sphere(size.x());
			pop();
		} else if (this.get_type() == SPHERE_HIGH || this.get_type() == SPHERE) {
			push();
			translate(pos);
			costume_rotate(rot);
			sphere(size.x());
			pop();
		} else if (this.get_type() == TETRAHEDRON) {
			push();
			translate(pos);
			costume_rotate(rot);
			poly.polyhedron("TETRAHEDRON",VERTEX,(int)size.x());
			pop();
		} else if (this.get_type() == BOX) {
			push();
			translate(pos);
			costume_rotate(rot);
			box(size);
			pop();
		}

		else if (this.get_type() == STAR) {
			if(this.get_ratio() == null) {
				star_ratio(0.38f);
			} else {
				star_ratio(this.ratio);
			}
			push();
			translate(pos);
			costume_rotate(rot);

			star_3D_is(false);
			if(get_summit() == 0 ) {
				set_summit(5);
			}
			star_summits(get_summit());
			star_show(new vec3(),size);
			pop();
		} else if (this.get_type() == STAR_3D) {
			if(this.get_ratio() == null) {
				star_ratio(0.38f);
			} else {
				star_ratio(this.ratio);
			}
			push();
			translate(pos);
			costume_rotate(rot);

			star_3D_is(true);
			if(get_summit() == 0 ) set_summit(5);
			star_summits(get_summit());
			star_show(new vec3(),size);
			pop();
		}


		else if (this.get_type() == FLOWER) {
			push();
			translate(pos);
			costume_rotate(rot);
			if(get_summit() == 0 ) set_summit(5);
			if(get_pair() == null || get_pair().length != get_summit()*2) {
				pair = new vec2[get_summit()*2];
			}
			if(get_strength() == null || get_strength().length != get_summit()*2) {
				strength = new float[get_summit()*2];
			}

			for(int i = 0 ; i < get_summit()*2 ; i++) {
				vec2 value = new vec2(0.1f,0.1f);
				if(pair[i] == null) {
					pair[i] = new vec2(value);
				} else {
					pair[i].set(value);
				}
				strength[i] = 1.0f;
			}

			set_flower((int)size.x(),get_summit());
			// flower_static() create the flower from the circle
			for(int i = 0 ; i < get_summit() ; i++) {
				flower_static(pair[i],strength[i],pair[i+get_summit()],strength[i+get_summit()]);
			}

			flower_show(new vec3(),(int)size.x(),get_summit());
			pop();
		}


		else if (this.get_type() == TETRAHEDRON_LINE) {
			push();
			translate(pos);
			costume_rotate(rot);
			poly.polyhedron("TETRAHEDRON",LINE,(int)size.x());
			pop();
		} else if (this.get_type() == CUBE_LINE) {
			push();
			translate(pos);
			costume_rotate(rot);
			poly.polyhedron("CUBE",LINE,(int)size.x());
			pop();
		} else if (this.get_type() == OCTOHEDRON_LINE) {
			push();
			translate(pos);
			costume_rotate(rot);
			poly.polyhedron("OCTOHEDRON",LINE,(int)size.x());
			pop();
		} else if (this.get_type() == RHOMBIC_COSI_DODECAHEDRON_SMALL_LINE) {
			push();
			translate(pos);
			costume_rotate(rot);
			poly.polyhedron("RHOMBIC COSI DODECAHEDRON SMALL",LINE,(int)size.x());
			pop();
		} else if (this.get_type() == ICOSI_DODECAHEDRON_LINE) {
			push();
			translate(pos);
			costume_rotate(rot);
			poly.polyhedron("ICOSI DODECAHEDRON",LINE,(int)size.x());
			pop();
		}

		else if(this.get_type() == HOUSE) {
			push();
			translate(pos);
			costume_rotate(rot);
			if(size.z() == 1) {
				house_show(size.xyy());
			} else {
				house_show(size.xyz());
			}
			pop();
		}


	  else if(this.get_type() == VIRUS) {
			push();
			translate(pos);
			costume_rotate(rot);
			if(get_summit() == 0 ) {
				set_summit(5);
			}
			virus_summits(get_summit());
			virus_node((get_summit() /2));
			virus_mutation((get_summit() /2));
			virus_show(new vec3(),size,0,-1);
			pop();
		}



		else if(this.get_type() < 0) {
			push() ;
			translate(pos);
			costume_rotate(rot) ;
			for(int i = 0 ; i < costume_pic_list.size() ; i++) {
				R_Costume_Pict p = costume_pic_list.get(i);
				if(p.get_id() == this.get_type()) {
					if(p.get_type() == 1) {
						PImage img_temp = p.get_img().copy();
						if(size.x == size.y ) {
							img_temp.resize((int)size.x, 0);
						} else if (size.x != size.y) {
							img_temp.resize((int)size.x, (int)size.y);
						}
						this.pa.image(img_temp,0,0);
						break ;
					} else if(p.get_type() == 2) {
						vec2 scale = new vec2(1) ;
						if(size.x == size.y) {
	            scale = new vec2(size.x() / p.get_svg().width(), size.x() / p.get_svg().width());
						} else {
							scale = new vec2(size.x() / p.get_svg().width(), size.y() / p.get_svg().height());
						}
						
						p.get_svg().scaling(scale);
						p.get_svg().draw();
						break;
					}		
				}
			}
			pop();
		}
	  // reset variable can be change the other costume, if the effect is don't use.
		ratio_costume_size = 1;
		
	}









	/**
	 * THE METHOD COLLECTION for those are not a specific class
	 */

	/**
	 * 
	 * @param pos
	 * @param thickness
	 * @param radius
	 */
	private void cross_rect_show(ivec2 pos, int thickness, int radius) {
		float h = radius;
		float w = thickness/3;
		// verticale one
		vec2 size = new vec2(w,h);
		vec2 pos_temp = new vec2(pos.x, pos.y -floor(size.y/2) +(w/2));
		pos_temp.sub(w/2);
		rect(pos_temp,size);	
		// horizontal one
		size.set(h,w);
		pos_temp.set(pos.x-floor(size.x/2) +(w/2),pos.y);
		pos_temp.sub(w/2);
		rect(pos_temp,size);
	}

	/**
	 * 
	 * @param size
	 */
	private void cross_box_2_show(vec2 size) {
		float scale_cross = size.sum() *0.5f;
		float small_part = scale_cross *ratio_costume_size *0.3f;

		box(size.x,small_part,small_part);
		box(small_part,size.y,small_part);
	}
	/**
	 * 
	 * @param size
	 */
	private void cross_box_3_show(vec3 size) {
		float scale_cross = size.sum() *0.3f;
		float small_part = scale_cross *ratio_costume_size *0.3f;
		
		box(size.x,small_part,small_part);
		box(small_part,size.y,small_part);
		box(small_part,small_part,size.z);
	}



	private boolean make_virus = true ;
	private void virus_show(vec pos, vec size, float angle, int close) {
		if(make_virus) {
			virus = new R_Virus(this.pa);
			make_virus = false ;
		}

		if(virus.get_mutation() > 0 && this.pa.frameCount%virus.get_mutation() == 0) {
			virus.reset() ;
		}
		virus.angle_x(angle) ;
		virus.pos(pos) ;
		virus.size(size) ;
		virus.show() ;	
	}

	private void virus_mutation(int mutation) {
		if(virus != null && mutation != 0 && mutation != virus.get_mutation()) {
			virus.set_mutation(abs(mutation));
		}
	}

	private void virus_summits(int num) {
		if(virus != null && num != 0 && num != virus.get_summits()) {
			virus.set_summits(abs(num));
		}
	}

	private void virus_node(int node) {
		if(virus != null && node != 0 && node != virus.get_node()) {
			virus.set_node(abs(node));
		}
	}


	
	/**
	 * 
	 * @param size
	 */
	private void house_show(vec3 size) {
		if(house != null) {
			house.size(size);
			house.pass_graphic(other);
			// house_costume_rope.show(g);
			house.show();
		} else {
			//house_costume_rope = new House();
			house = new R_House(this.pa);
		}
	}



	/**
	 * 
	 * @param pos
	 * @param diam
	 * @param petals_num
	 */

	 private void set_flower(int diam, int petals_num) {
		 if(flower == null || flower.get_summits() != petals_num) {
			if(petals_num < 3) petals_num = 3;
			flower = new R_Circle(this.pa, petals_num);
		} 
	}

	private void flower_show(vec pos, int diam, int petals_num) {
		flower.pos(pos);
		flower.size(diam);
		flower.pass_graphic(other);
		flower.show();
	}

	private void flower_wind(vec2 petal_left, float strength_left, vec2 petal_right, float strength_right) {
		if(flower != null) {
			for(R_Bezier b : flower.get_bezier()) {
				vec2 trouble = new vec2().sin_wave(this.pa.frameCount,petal_left.x(),petal_left.y()).mult(strength_left);
				b.set_a(trouble);
				trouble = new vec2().cos_wave(this.pa.frameCount,petal_right.x(),petal_right.y()).mult(strength_right);
				b.set_b(trouble);
			}
		}
	}


	private void flower_static(vec2 petal_left, float strength_left, vec2 petal_right, float strength_right) {
		if(flower != null) {
			for(R_Bezier b : flower.get_bezier()) {
				vec2 petal_show = new vec2(petal_left.x(),petal_left.y()).mult(strength_left);
				b.set_a(petal_show);
				petal_show = new vec2(petal_right.x(),petal_right.y()).mult(strength_right);
				b.set_b(petal_show);
			}
		}
	}











	private void star_show(vec position, vec size) {
		if(star != null) {
			star.pos(position);
			star.size(size);
			star.pass_graphic(this.other);
			star.show();
		} else {
			star = new R_Star(this.pa);
		}
	}

	private void star_3D_is(boolean is_3D) {
		if(star != null) {
			star.is_3D(is_3D);
		} else {
			star = new R_Star(this.pa);
			star.is_3D(is_3D);
		}
	}

	private void star_summits(int summits) {
		if(star != null) {
			star.set_summits(summits);
		} else {
			star = new R_Star(this.pa);
			star.set_summits(summits);
		}
	}

	private void star_ratio(float... ratio) {
		if(star != null) {
			star.set_ratio(ratio);
		} else {
			star = new R_Star(this.pa);
			star.set_ratio(ratio);
		}
	}
}
