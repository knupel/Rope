package rope.pixo;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PGraphics;
import rope.core.BigBang;
import rope.vector.vec2;
import rope.vector.vec3;

public class R_Papo extends BigBang {
  /*
	// library
	R_Image_Manager lib_r_img;
	// R_Image_Manager lib_r_img = new R_Image_Manager();
	// main render
	PGraphics pg;
	// map alteration
	// lib_map = new ArrayList<PGraphics>();
	ArrayList<PGraphics> lib_map;
	PGraphics map_pattern;
	// PGraphics map_img;
	int index_map = 0;


	// float noise_z_offset = 0.0;
	// float noise_z_inc = 0.02; 

	int colour_bg = 0;

	public R_Papo(PApplet pa) {
		super(pa);
		lib_r_img = new R_Image_Manager();
		lib_map = new ArrayList<PGraphics>();
		this.pg = createGraphics(width, height, get_renderer());
	}


	// SRC LIBRARY
	public void lib_src_clear() {
		this.lib_r_img.clear();
	}

	public int lib_src_size() {
		return this.lib_r_img.size();
	}
	public void load_src(String path) {
		this.lib_r_img.load(path);
	}

	public PImage get_src() {
		return this.get_src(0);
	}

	public PImage get_src(int target) {
		if(lib_src_size() > 0 && lib_src_size() > target) {
			return this.lib_r_img.get(target);
		}
		return null;
	}


	// build
	public void build() {
		build_calc(0);
	}

	public void build(int target) {
		build_calc(target);
	}

	private void build_calc(int target) {
		if(get_src(target) != null 
				&& (get_src(target).width != this.pg.width
						|| get_src(target).height != this.pg.height)
				) {
			this.pg = createGraphics(get_src(target).width, get_src(target).height);
		} 
	}











	// map
	public void show_map() {
		if(index_map < lib_map.size() && index_map >= 0) {
			image(this.lib_map.get(index_map));
		}	
	}

	public int get_map(int x, int y) {
		if(index_map < lib_map.size() && index_map >= 0) {
			return this.lib_map.get(index_map).get(x,y);
		}
		return 0;
	}

	public float get_map_brightness(int x, int y) {
		if(index_map < lib_map.size() && index_map >= 0) {
			return brightness(this.lib_map.get(index_map).get(x,y)) / pg.colorModeZ;
					// println("ration map",ratio);
		}
		return 0;
	}

	// noise map
	public void build_noise_map(int color_mode) {
		if(color_mode == GRAY) {
			float inc = random(1) * 0.01;
			this.map_pattern = pattern_noise(this.width(), this.height(), inc);
		} else if(color_mode == RGB) {
			float inc_r = random(1) * 0.01;
			float inc_g = random(1) * 0.01;
			float inc_b = random(1) * 0.01;
			set_pattern_increment(inc_r,inc_g,inc_b);
			this.map_pattern = pattern_noise_xyz(this.width(), this.height());
		} else {
			float inc = random(1) * 0.01;
			set_pattern_increment(inc);
			this.map_pattern = pattern_noise(this.width(), this.height());
		}
		if(this.lib_map.size() > 0) {
			this.lib_map.set(0,this.map_pattern);
		} else {
			this.lib_map.add(this.map_pattern);
		}
	}

	public void build_marble_map(int color_mode) {
		set_pattern_period(4.9,3.4);
		set_pattern_turbulence(8.3);
		set_pattern_smooth(51);
		this.map_pattern = pattern_marble(this.width(), this.height());
		if(this.lib_map.size() > 0) {
			this.lib_map.set(0,this.map_pattern);
		} else {
			this.lib_map.add(this.map_pattern);
		}
	}











	// RENDERING
	public PGraphics render() {
		return this.pg;
	}

	public void background(int colour) {
		background(colour, g.colorModeA);
	}

	public void background(int colour, float alpha) {
		this.colour_bg = colour;
		pg.background(colour, alpha);
	}

	// draw
	void begin() {
		if(pg != null) {
			pg.beginDraw();
		}
	}

	public void end() {
		if(pg != null)
			pg.endDraw();
	}
	
	// pixel
	public void loadPixels() {
		if(pg != null) {
			pg.loadPixels();
		}
	}

	public void updatePixels() {
		if(pg != null) {
			pg.updatePixels();
		}
	}




	// plot
	public void plot_pixel(vec2 pos, int colour) {
		plot_pixel((int)pos.x(), (int)pos.y(), colour);
	}

	public void plot_pixel(vec3 pos, int colour) {
		plot_pixel((int)pos.x(), (int)pos.y(), colour);
	}

	public void plot_pixel(int x, int y, int colour) {
		if(pg != null) {
			plot(x,y, colour, pg);
		}
	}



	// point
	public void point(vec2 pos) {
		point(pos.x(), pos.y());
	}

	public void point(vec3 pos) {
		point(pos.x(), pos.y());
	}

	public void point(float x, float y) {
		if(pg != null) 
			pg.point(x,y);
	}






	// canvas
	public int width() {
		if(pg != null)
			return pg.width;
		return -1;
	}

	public int height() {
		if(pg != null)
			return pg.height;
		return -1;
	}

	// costume
	public void stroke(int colour) {
		if(pg != null)
			pg.stroke(colour);
	}

	public void fill(int colour) {
		if(pg != null)
			pg.fill(colour);
	}

	public void thickness(float thickness) {
		if(pg != null)
			pg.strokeWeight(thickness);
	}


  */
}
