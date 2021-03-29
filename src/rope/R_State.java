/**
 * R_state is use to manage all the state of Rope like in React in lesser :)
 * v 0.0.1
 * 2021-2021
 * @author stanlepunk
 *
 */

package rope;

import processing.core.PApplet;
import rope.vector.vec3;
import rope.vector.bvec2;

public class R_State {
	public static class State {
		private static PApplet pa;
		private static R_Env env;
		
		public static void papplet(PApplet papplet) {
			pa = papplet;
			if(env == null) {
				env = new R_Env();
			}
			env.x = pa.g.colorModeX;
			env.y = pa.g.colorModeY;
			env.z = pa.g.colorModeZ;
			env.a = pa.g.colorModeA;
			env.m = pa.g.colorMode;
			env.w = pa.g.width;
			env.h = pa.g.width;
			
			
		}
		
		public static PApplet pa() {
			return pa;
		}
		
		public static R_Env env() {
			return env;
		}
		
		public static void molette_is(boolean is) {
			env.molette = is;
		}
		
		public static boolean molette_is() {
			return env.molette;
		}
		
		public static void key_pressed_is(boolean is) {
			env.key_pressed = is;
		}
		
		public static boolean key_pressed_is() {
			return env.key_pressed;
		}
		
		public static void mouse_pressed_is(boolean is) {
			env.mouse_pressed = is;
		}
		
		public static boolean mouse_pressed_is() {
			return env.mouse_pressed;
		}
		
		
		
		/**
		 * Control ROPE
		 * 
		 */
		
		// selector adjustable molette
		public static void select_adj_is(boolean is) {
			env.auth_select_adj = is;
		}
		
		public static boolean select_adj_is() {
			return env.auth_select_adj;
		}
		// keep selection
		public static void keep_selection_is(boolean is) {
			env.auth_select_keep = is;
		}
		
		public static boolean keep_selection_is() {
			return env.auth_select_keep;
		}
		
		
		// selector molette
		public static void select_mol_is(boolean is_1, boolean is_2) {
			if(env.auth_select_mol == null) {
				env.auth_select_mol = new bvec2(false,false);
			}
			env.auth_select_mol.set(is_1,is_2);
		}
		
		public static void select_mol_is(boolean is_1) {
			select_mol_is(is_1, true);
		}
		
		public static bvec2 select_mol_is() {
			return env.auth_select_mol;
		}
		
		// pointer
		public static void pointer(float x, float y) {
			if(env.pointer == null) {
				env.pointer = new vec3();
			}
			env.pointer.x(x);
			env.pointer.y(y);
		}
		
		public static void pointer(float x, float y, float z) {
			if(env.pointer == null) {
				env.pointer = new vec3();
			}
			env.pointer.x(x);
			env.pointer.y(y);
			env.pointer.z(z);
		}
		
		public static vec3 pointer() {
			return env.pointer;
		}
		
		// dna current slider
		public static void set_dna_current_crope(int dna) {
			env.dna_current_slider = dna;
		}
		
		public static int get_dna_current_crope() {
			return env.dna_current_slider;
		}

		
	}
	
}
