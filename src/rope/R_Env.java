package rope;

import rope.vector.bvec2;
import rope.vector.vec2;
import rope.vector.vec3;

public class R_Env {
	
	R_Env() {}
	
	public float x;
	public float y;
	public float z;
	public float a;
	public int m;
	public int w;
	public int h;
	
	
	
	public vec2 scroll;
	public boolean mouse_pressed;
	public boolean key_pressed;
	public vec3 pointer;
	
	//Control Rope
	public boolean select;
	public boolean molette;
	public int dna_current_slider;
	public boolean auth_select_adj;
	public bvec2 auth_select_mol;
	public boolean auth_select_keep;

}
