/**
* R_Env
* Control ROmanesco Processing Environment
* v 0.1.0
* Copyleft (c) 2021-2021

* dependencies
* Processing 3.5.4
* @author @stanlepunk
* @see https://github.com/StanLepunK/Rope
*/
package rope;

import processing.core.PGraphics;
import rope.core.R_Constants_Colour;
import rope.vector.bvec2;
import rope.vector.bvec6;
import rope.vector.ivec2;
import rope.vector.ivec4;
import rope.vector.vec3;
import rope.vector.vec4;

public class R_Env implements R_Constants_Colour {
	private float x;
	private float y;
	private float z;
	private float a;
	private int m;
	private int w;
	private int h;
	private String renderer = null;
	private boolean size_change = false;
	
	
	public boolean mouse_pressed;
	public boolean key_pressed;
	
	//Control Rope GUI
	public boolean select;
	public boolean molette;
	public int dna_current_slider;
	public boolean auth_select_adj;
	public bvec2 auth_select_mol;
	public boolean auth_select_keep;
	
	public ivec2 scroll;
	public vec3 pointer;

	public bvec6 event;
	public bvec6 bang;
	public bvec2 [] bangbang_arr;
	public bvec6 bangbang;
	public bvec6 event_mut;
	public bvec6 event_ref;

	// crope
	public int gui_fill_in = GRAY[9];
	public int gui_fill_out = GRAY[12];
	public int gui_stroke_in = GRAY[9];
	public int gui_stroke_out = GRAY[12];
	public float gui_thickness = 0;
	public ivec4 gui_rounded = new ivec4();
	// label
	public int gui_color_label_in = GRAY[6];
  public int gui_color_label_out = GRAY[9];

	// molette
	public int gui_mol_fill_in = GRAY[3];
	public int gui_mol_fill_out = GRAY[6];
	public int gui_mol_stroke_in = GRAY[3];
	public int gui_mol_stroke_out = GRAY[6];
	public float gui_mol_thickness = 0;
	// public ivec4 gui_mol_rounded = new ivec4();

	//button
	public int gui_but_fill_in_on = GREEN;
	public int gui_but_fill_out_on = SAPIN;
	public int gui_but_fill_in_off = RED;
	public int gui_but_fill_out_off = BLOOD;

	public int gui_but_stroke_in_on = GREEN;
	public int gui_but_stroke_out_on = SAPIN;
	public int gui_but_stroke_in_off = RED;
	public int gui_but_stroke_out_off = BLOOD;
	public float gui_but_thickness = 0;
	// public ivec4 gui_but_rounded = new ivec4();

	// dropdonw
	public int gui_db_fill_struct = GRAY[4];
  public int gui_db_fill_box_in = GRAY[12];
  public int gui_db_fill_box_out = GRAY[18];
  public int gui_db_fill_header_in = GRAY[12];
  public int gui_db_fill_header_out = GRAY[18]; 
  public int gui_db_fill_header_text_in = GRAY[4];
  public int gui_db_fill_header_text_out = GRAY[8];
  public int gui_db_fill_box_text_in = GRAY[4];
  public int gui_db_fill_box_text_out = GRAY[8];

		// board
	public int gui_board_fill_in = GRAY[2];
	public int gui_board_fill_out = GRAY[4];
	public int gui_board_stroke_in = GRAY[2];
	public int gui_board_stroke_out = GRAY[4];
	public float gui_board_thickness = 0;
	public ivec4 gui_board_rounded = new ivec4();






	R_Env() {
		bangbang_arr = new bvec2[6];
	}
	

	


	// MISC
	public String get_renderer() {
		return this.renderer;
	}
	
	public void set_renderer(final PGraphics pg) {
		if(renderer == null) {
			this.renderer = get_renderer_impl(pg);
		}
	}
	
	// clone of method from R_Graphic
	private String get_renderer_impl(final PGraphics pg) {
	  try {
	    if (Class.forName(processing.core.PConstants.JAVA2D).isInstance(pg)) return processing.core.PConstants.JAVA2D;
	    if (Class.forName(processing.core.PConstants.P2D).isInstance(pg)) return processing.core.PConstants.P2D;
	    if (Class.forName(processing.core.PConstants.P3D).isInstance(pg)) return processing.core.PConstants.P3D;
	    if (Class.forName(processing.core.PConstants.PDF).isInstance(pg)) return processing.core.PConstants.PDF;
	  }
	  catch (ClassNotFoundException ex) {
	  }
	  return "Unknown";
	}
	
	public vec4 cxyza() {
		return new vec4(this.x,this.y,this.z,this.a);
	}
	
	public vec3 cxyz() {
		return new vec3(this.x,this.y,this.z);
	}
	
	public float cx() {
		return this.x;
	}
	
	public void cx(float x) {
		this.x = x;
	}
	
	public float cy() {
		return this.y;
	}
	
	public void cy(float y) {
		this.y = y;
	}
	
	public float cz() {
		return this.z;
	}
	
	public void cz(float z) {
		this.z = z;
	}
	
	public float ca() {
		return this.a;
	}
	
	public void ca(float a) {
		this.a = a;
	}
	
	public int cm() {
		return this.m;
	}
	
	public void cm(int m) {
		this.m = m;
	}
	
	public int width() {
		return this.w;
	}
	
	public void width(int w) {
		this.w = w;
	}
	
	public int height() {
		return this.h;
	}
	
	public void height(int h) {
		this.h = h;
	}

	public void size_change(boolean is) {
		this.size_change = is;
	}

	public boolean size_change() {
		return this.size_change;
	}
	
	
	
	


}
