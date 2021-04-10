/**
 * R_State is use to manage all the state of Rope like in React in lesser :)
 * v 0.1.0
 * 2021-2021
 * @author stanlepunk
 *
 */

package rope;

import processing.core.PApplet;
// import processing.core.PGraphics;
import processing.event.MouseEvent;
import rope.vector.vec3;
import rope.core.R_Constants;
import rope.core.Rope;
import rope.vector.bvec2;
import rope.vector.bvec6;
import rope.vector.ivec2;

public class R_State implements R_Constants {
	public static class State {
		private static PApplet pa;
		private static R_Env env;
		private static Rope r;
		
		public static void init(PApplet papplet) {
			pa = papplet;
			if(env == null) {
				version();
				env = new R_Env();
				r = new Rope();
			}
			update();
		}
		
		public static void update() {
			env.cx(pa.g.colorModeX);
			env.cy(pa.g.colorModeY);
			env.cz(pa.g.colorModeZ);
			env.ca(pa.g.colorModeA);
			env.cm(pa.g.colorMode);
			env.width(pa.g.width);
			env.height(pa.g.width);
			env.set_renderer(pa.g);
			
		}
		
		public static void version() {
			System.out.println(VERSION);
		}
		
		public static PApplet pa() {
			return pa;
		}
		
		public static R_Env env() {
			return env;
		}
		
		public static String get_renderer() {
			return env.get_renderer();
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
		
		
		public static void event(boolean... event) {
			if(env.event == null) {
				env.event = new bvec6(true);
				env.event_mut = new bvec6(true);
				env.event_ref = new bvec6(true);
			}
			
			if(event.length == 1) {
				env.event.a(event[0]);
			} else if(event.length == 2) {
				env.event.a(event[0]);
				env.event.b(event[1]);
			} else if(event.length == 3) {
				env.event.a(event[0]);
				env.event.b(event[1]);
				env.event.c(event[2]);
			} else if(event.length == 4) {
				env.event.a(event[0]);
				env.event.b(event[1]);
				env.event.c(event[2]);
				env.event.d(event[3]);
			} else if(event.length == 5) {
				env.event.a(event[0]);
				env.event.b(event[1]);
				env.event.c(event[2]);
				env.event.d(event[3]);
				env.event.e(event[4]);
			} else if(event.length == 6) {
				env.event.a(event[0]);
				env.event.b(event[1]);
				env.event.c(event[2]);
				env.event.d(event[3]);
				env.event.e(event[4]);
				env.event.f(event[5]);
			}

			for(int i = 0 ; i < event.length && i < 6 ; i++) {
				if(r.all(event)) {
					if(env.event_ref.array()[i] != event[i]) {
						env.event_mut.swap(i);
					}
					env.event_ref.set_to(i,true);
				} else {
					env.event_ref.set_to(i,false);
				}
			}
			
			
		}
		
		public static bvec6 event() {
			return env.event;
		}
		
		public static bvec6 event_mut() {
			return env.event_mut;
		}
		
	
		
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
		
		
		public static void scroll(MouseEvent e) {
			if(env.scroll == null) {
				env.scroll = new ivec2(e.getCount());
			} else {
				env.scroll.set(e.getCount());
			}
		}
		
		public static ivec2 scroll() {
			return env.scroll;
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
