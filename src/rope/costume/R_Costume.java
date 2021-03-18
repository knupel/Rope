/**
* R_Costume
* v 0.1.0
* 2019-2021
* @author @stanlepunk
* @see https://github.com/StanLepunK/Rope
*/
package rope.costume;

import processing.core.PApplet;
import processing.core.PGraphics;
import processing.core.PImage;
import rope.vector.ivec2;
import rope.vector.vec;
import rope.vector.vec2;
import rope.vector.vec3;
import rope.vector.vec4;

public class R_Costume extends R_Shape {
	private boolean fill_is = true;
	private boolean stroke_is = true;
	private boolean alpha_is = true;

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

	int align = LEFT;

	public R_Costume(PApplet pa) {
		super(pa);
	}

	public R_Costume(PApplet pa, int type) {
		super(pa);
		this.type = type;
	}

	public R_Costume(PApplet pa, String costume_text) {
		super(pa);
		this.type = TEXT;
		this.costume_text = costume_text;
	}


	public void pos(float x, float y, float z) {
		if(pos == null) {
			pos = new vec3(x,y,z);
		} else {
			pos.set(x,y,z);
		}
	}




	public void size(float x, float y, float z) {
		if(size == null) {
			size = new vec3(x,y,z);
		} else {
			size.set(x,y,z);
		}
	}

	public void angle(float x, float y, float z) {
		if(angle == null) {
			angle = new vec3(x,y,z);
		} else {
			angle.set(x,y,z);
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

	/**
	public void set_angle(float angle) {
		this.angle = angle;
	}
	*/

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
	public vec3 pos() {
		return pos;
	}

	public vec3 size() {
		return size;
	}

	public vec3 angle() {
		return angle;
	}


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

	public void aspect(vec fill, vec stroke, float thickness, Costume costume) {
		aspect(fill,stroke,thickness,costume.get_type());
	}


	public void aspect(vec fill, vec stroke, float thickness, int costume) {
	  if(costume == NULL) {
	    // 
		} else if(costume != r.NULL || costume != POINT) {
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
				this.fill = color(c.x(),c.x(),c.x(),pa.g.colorModeA);
			}
			fill(this.fill);
		} else if(arg instanceof vec3) {
			vec3 c = (vec3)arg;
			this.fill = color(c.x(),c.y(),c.z(),pa.g.colorModeA);
			fill(this.fill);
		} else if(arg instanceof vec4) {
			vec4 c = (vec4)arg;
			if(alpha_is()) {
				this.fill = color(c.x(),c.y(),c.z(),c.w());
			} else {
				this.fill = color(c.x(),c.y(),c.z(),pa.g.colorModeA);
			}
			fill(this.fill);
		} else if(arg instanceof Integer) {
			int c = (int)arg;
			if(alpha_is()) {
				fill(c);	
			} else {
				if(g.colorMode == 3) {
					this.fill = color(hue(c),saturation(c),brightness(c),pa.g.colorModeA);
				} else {
					this.fill = color(red(c),green(c),blue(c),pa.g.colorModeA);
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
				this.stroke = color(c.x(),c.x(),c.x(),pa.g.colorModeA);
			}
			stroke(this.stroke,other);
		} else if(arg instanceof vec3) {
			vec3 c = (vec3)arg;
			this.stroke = color(c.x(),c.y(),c.z(),pa.g.colorModeA);
			stroke(this.stroke,other);
		} else if(arg instanceof vec4) {
			vec4 c = (vec4)arg;
			if(alpha_is()) {
				this.stroke = color(c.x(),c.y(),c.z(),c.w());
			} else {
				this.stroke = color(c.x(),c.y(),c.z(),pa.g.colorModeA);
			}			
			stroke(this.stroke);
		} else if(arg instanceof Integer) {
			int c = (int)arg;
			if(alpha_is()) {
				stroke(c,other);	
			} else {
				if(g.colorMode == 3) {
					this.stroke = color(hue(c),saturation(c),brightness(c),pa.g.colorModeA);
				} else {
					this.stroke = color(red(c),green(c),blue(c),pa.g.colorModeA);
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


	public void show() {
		show(pos,size,angle);
	}

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
			cross_rect(new ivec2(0),(int)size.y(),(int)size.x());
			pop();
		} else if (this.get_type() == CROSS_BOX_2) {
			push();
			translate(pos);
			costume_rotate(rot);
			cross_box_2(new vec2(size.x(), size.y()));
			pop();
		} else if (this.get_type() == CROSS_BOX_3) {
			push();
			translate(pos);
			costume_rotate(rot);
			cross_box_3(size);
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
			polyhedron("TETRAHEDRON","VERTEX",(int)size.x(),other);
			pop();
		} else if (this.get_type() == BOX) {
			push();
			translate(pos);
			costume_rotate(rot);
			box(size);
			pop();
		}

		else if (this.get_type() == STAR) {
			float [] ratio = {0.38f};
			push();
			translate(pos);
			costume_rotate(rot);

			star_3D_is(false);
			if(get_summit() == 0 ) set_summit(5);
			star_summits(get_summit());
			star(new vec3(),size,other);
			pop();
		} else if (this.get_type() == STAR_3D) {
			float [] ratio = {0.38f};
			push();
			translate(pos);
			costume_rotate(rot);

			star_3D_is(true);
			if(get_summit() == 0 ) set_summit(5);
			star_summits(get_summit());
			star(new vec3(),size,other);
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

			for(int i = 0 ; i < get_summit() ; i++) {
				flower_static(pair[i],strength[i],pair[i+get_summit()],strength[i+get_summit()]);
			}
			flower(new vec3(),(int)size.x,get_summit(),other);
			pop();
		}


		else if (this.get_type() == TETRAHEDRON_LINE) {
			push();
			translate(pos);
			costume_rotate(rot);
			polyhedron("TETRAHEDRON","LINE",(int)size.x(),other);
			pop();
		} else if (this.get_type() == CUBE_LINE) {
			push();
			translate(pos);
			costume_rotate(rot);
			polyhedron("CUBE","LINE",(int)size.x(),other);
			pop();
		} else if (this.get_type() == OCTOHEDRON_LINE) {
			push();
			translate(pos);
			costume_rotate(rot);
			polyhedron("OCTOHEDRON","LINE",(int)size.x(),other);
			pop();
		} else if (this.get_type() == RHOMBIC_COSI_DODECAHEDRON_SMALL_LINE) {
			push();
			translate(pos);
			costume_rotate(rot);
			polyhedron("RHOMBIC COSI DODECAHEDRON SMALL","LINE",(int)size.x(),other);
			pop();
		} else if (this.get_type() == ICOSI_DODECAHEDRON_LINE) {
			push();
			translate(pos);
			costume_rotate(rot);
			polyhedron("ICOSI DODECAHEDRON","LINE",(int)size.x(),other);
			pop();
		}

		else if(this.get_type() == HOUSE) {
			push();
			translate(pos);
			costume_rotate(rot);
			if(size.z() == 1) {
				house(size.xyy(),other);
			} else {
				house(size.xyz(),other);
			}
			pop();
		}


	  else if(this.get_type() == VIRUS) {
			push();
			translate(pos);
			costume_rotate(rot);
			virus(new vec3(),size,0,-1);
			pop();
		}



		else if(this.get_type() < 0) {
			push() ;
			translate(pos);
			costume_rotate(rot) ;
			for(int i = 0 ; i < costume_pic_list.size() ; i++) {
				Costume_pic p = costume_pic_list.get(i);
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
	            scale = vec2(size.x / p.get_svg().width(), size.x / p.get_svg().width());
						} else {
							scale = vec2(size.x / p.get_svg().width(), size.y / p.get_svg().height());
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
}
