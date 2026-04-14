/**
 *   ___      ___   ____   _______
 *  | -  \   /   \  |    \ |  ___/
 *  | |/  | |   \ | | |\ | |  |__
 *  |    /  | | | | | |  / |  __/
 *  | |  \  \ \   / |  |/  |  |____
 *  |_| \_\  \___/  |_ |   |______/
 * 
 * R_State is use to manage all the state of Rope like in React in lesser :)
 * v 0.1.1
 * 2021-2023
 * 
* @author @knupel
* @see https://github.com/knupel/Rope
 *
 */

package rope.utils;

import processing.core.PApplet;
import processing.event.MouseEvent;
import rope.vector.vec3;
import rope.vector.vec4;
import rope.core.R_Constants;
import rope.core.Rope;
import rope.vector.bvec2;
import rope.vector.bvec6;
import rope.vector.ivec2;

public class R_State implements R_Constants {
	public static class State {
		private static PApplet pa;
		private static R_Env env;
		public static Rope r;
		
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
			if(r.all(pa.g.width == env.width(), pa.g.height == env.height())) {
				env.size_change(false);
			} else {
				env.size_change(true);
			}
			env.width(pa.g.width);
			env.height(pa.g.height);
			env.set_renderer(pa.g);		
		}
		
		public static void version() {
			System.out.println(VERSION);
		}
		
		public static PApplet pa() {
			return pa;
		}
		
		/**
		 * 
		 * 
		 * ENVIRONMENT
		 */

		public static R_Env env() {
			return env;
		}
		
		public static String get_renderer() {
			return env.get_renderer();
		}

		/**
		 * 
		 * @return the type of colorMode
		 */
		public static int cm() {
			return env.cm();
		}

		/**
		 * 
		 * @return the curent data value of the color environment x, y, z and alpha of your sketch
		 */
		public static vec4 cxyza() {
			return env.cxyza();
		}

		/**
		 * 
		 * @return the curent data value of the color environment x, y, z of your sketch
		 */
		public static vec3 cxyz() {
			return env.cxyz();
		}

		public static boolean size_change() {
			return env.size_change();
		}
		


		/**
		 * 
		 * STATE EVENT
		 */

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

		public static void mouse_pressed_is(boolean is) {
			env.mouse_pressed = is;
		}
		
		public static boolean mouse_pressed_is() {
			return env.mouse_pressed;
		}


		public static void key_pressed_is(boolean is) {
			env.key_pressed = is;
		}
		
		public static boolean key_pressed_is() {
			return env.key_pressed;
		}
		


		public static void event(boolean... event) {
			if(env.event == null) {
				init_event();
			}
			dispatch_event(event);
			set_event(event);
		}

		private static void dispatch_event(boolean... event) {
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
		}

		private static void init_event() {
			env.event_ref = new bvec6(true);
			env.event = new bvec6(true);
			env.bang = new bvec6(false);
			env.bangbang = new bvec6(false);
			env.event_mut = new bvec6(true);

			for(int i = 0 ; i < env.bangbang_arr.length ; i++) {
				env.bangbang_arr[i] = new bvec2(false);
			}
		}

		private static void set_event(boolean... event) {
			for(int i = 0 ; i < event.length && i < 6 ; i++) {
				set_event_bang(i, event);
				set_event_bangbang(i, event);
				set_event_mut(i, event);
				set_event_ref(i, event);
			}
		}

		private static void set_event_bang(int i, boolean... event) {
			if(env.event_ref.array()[i] != event[i]) {
				env.bang.set_to(i,true);
			}
		}

		private static void set_event_bangbang(int i, boolean... event) {
			if(r.all(env.bangbang_arr[i].x(),!env.bangbang_arr[i].y(),!env.bang.get(i))) {
				env.bangbang_arr[i].y(true);
			}

			if(r.all(!env.bangbang_arr[i].x(),event[i], env.bang.get(i))) {
				env.bangbang_arr[i].x(env.bang.get(i));
			}

			if(r.all(env.bangbang_arr[i])) {
				env.bangbang.set_to(i,true);
			} else {
				env.bangbang.set_to(i,false);
			}
		}

		private static void set_event_mut(int i, boolean... event) {
			if(env.bangbang.get(i)) {
				env.event_mut.swap(i);
			}
		}


		private static void set_event_ref(int i, boolean... event) {
			if(env.event_ref.array()[i] != event[i]) {
				env.event_ref.set_to(i,event[i]);
			}
		}

		public static void reset_event() {
			env.bang.set(false);
			for(int i = 0 ; i < env.bangbang.size() ; i++) {
				if(env.bangbang.get(i)) {
					env.bangbang.set_to(i, false);
					if(r.all(env.bangbang_arr[i])) {
						env.bangbang_arr[i].set(false);
					}
				}
			}
		}

		public static bvec6 bang() {
			return env.bang;
		}

		public static bvec6 bangbang() {
			return env.bangbang;
		}
		
		public static bvec6 event() {
			return env.event;
		}
		
		public static bvec6 event_mut() {
			return env.event_mut;
		}




		 		/**
		 * 
		 * STATE GUI, CONTROL
		 */

		public static void mol_is(boolean is) {
			env.molette = is;
		}
		
		public static boolean mol_is() {
			return env.molette;
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
		
		// dna current slider
		public static void set_dna_current_crope(int dna) {
			env.dna_current_slider = dna;
		}
		
		public static int get_dna_current_crope() {
			return env.dna_current_slider;
		}

		
	}
	
}
