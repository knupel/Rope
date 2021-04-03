/**
* R_Env
* Control ROmanesco Processing Environment
* v 0.0.2
* Copyleft (c) 2021-2021

* dependencies
* Processing 3.5.4
* @author @stanlepunk
* @see https://github.com/StanLepunK/Rope
*/
package rope;

import processing.core.PGraphics;
import rope.vector.bvec2;
import rope.vector.bvec6;
import rope.vector.ivec2;
import rope.vector.vec3;
import rope.vector.vec4;

public class R_Env {
	
	R_Env() {}
	
	private float x;
	private float y;
	private float z;
	private float a;
	private int m;
	private int w;
	private int h;
	private String renderer = null;
	// private boolean renderer_is = false;
	
	
	public boolean mouse_pressed;
	public boolean key_pressed;
	
	public ivec2 scroll;
	public bvec6 event;
	public bvec6 event_mut;
	public bvec6 event_ref;
	public vec3 pointer;
	
	//Control Rope
	public boolean select;
	public boolean molette;
	public int dna_current_slider;
	public boolean auth_select_adj;
	public bvec2 auth_select_mol;
	public boolean auth_select_keep;
	
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
	
	
	
	


}
