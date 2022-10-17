/**
 *   ___      ___   ____   _______
 *  | -  \   /   \  |    \ |  ___/
 *  | |/  | |   \ | | |\ | |  |__
 *  |    /  | | | | | |  / |  __/
 *  | |  \  \ \   / |  |/  |  |____
 *  |_| \_\  \___/  |_ |   |______/
 * 
* Rope framework
* Copyleft (c) 2014-2022
* @author @stanlepunk
* @see https://github.com/StanLepunK/Rope_framework
* @see https://github.com/StanLepunK/Rope/tree/master/Guide
*
*
* Example adapted from Toxilibs
* 2022-2022
* version 0.0.3
*
*/

import rope.mesh.R_Voronoi;
import rope.mesh.R_Shape;
import rope.vector.vec2;
import rope.vector.vec3;

R_Voronoi voronoi;

// switches
boolean show_seeds_is = true;
boolean show_delaunay_triangle_is = false;
boolean show_diagram_is = true;
boolean show_info_is = false;
boolean show_stroke_is = true;
int thickness = 4;

void setup() {
  size(600, 600);
	voronoi = new R_Voronoi(this);
	add_seeds(3);
  textFont(createFont("SansSerif", 14));
}

void draw() {
  background(255);
	voronoi.update();
  show_areas();
	show_triangles();
	show_seeds();
	gui_instruction();
	print_info();
}



void keyPressed() {
  switch(key) {
		case 't':
			show_delaunay_triangle_is = !show_delaunay_triangle_is;
			break;
		case 'x':
			voronoi = new R_Voronoi(this);
			break;
		case 'p':
			show_seeds_is = !show_seeds_is;
			break;
		case 'c':
			show_diagram_is = !show_diagram_is;
			break;
		case 'r':
			add_seeds(50);
			break;
		case 'i':
			show_info_is = !show_info_is;
			break;
		case 'k':
			show_stroke_is = !show_stroke_is;
			break;
		case 'e':
			remove_seed();
			break;
  }
}

void mousePressed() {
	int c = color(random(255),random(255),random(255));
  voronoi.add_seed(mouseX, mouseY, c);
	print_info_voronoi();	
}


// ANNEXE
void remove_seed() {
	int index = floor(random(voronoi.size()));
	voronoi.remove_seed(index);
}

void print_info() {
	if(show_info_is) {
		println("size:",voronoi.size(), "fps:",(int)frameRate, "frameCount", frameCount);
	}
}

void print_info_voronoi() {
	for(int i = 0 ; i < voronoi.size() ; i++) {
		println("\nvoronoi:", i);
		vec3 seed = voronoi.get_seed(i);
		println("seed:", seed.x(), seed.y(), (int)seed.z());
		if(i < voronoi.get_areas().size()) {
			println("area", i, "id", voronoi.get_area(i).id().a());
			printArray(voronoi.get_area(i).get_points());
			println("triangle");
			printArray(voronoi.get_triangle(i).get_points());
		}
	}
}


void add_seeds(int num) {
	for (int i = 0; i < num; i++) {
		float x = random(width);
		float y = random(height);
		int c = color(random(255),random(255),random(255));
		voronoi.add_seed(new vec2(x,y), c);
	}
	print_info_voronoi();
}


void show_triangles() {
	apparence(color(255, 0, 0));
  if(show_delaunay_triangle_is && voronoi.get_triangles() != null) {
    for (R_Shape triangle : voronoi.get_triangles()) {
      vec3 [] arr = triangle.get_points();
			beginShape();
			for(vec3 v : arr) {
				vertex(v.x(), v.y());
			}
			endShape(CLOSE);
		}
  }
}

void show_areas() {
	apparence(0);
	if(show_diagram_is && voronoi.get_areas() != null) {
		int index = 0;
		for (R_Shape poly : voronoi.get_areas()) {
			vec3 [] arr = poly.get_points();
			if(voronoi.get_seed(index) != null) {
				int target = poly.id().a();
				int c = (int)voronoi.get_seed(target).z();
				fill(c);
			}
			beginShape();
			for(vec3 v : arr) {
				vertex(v.x(), v.y());
			}
			endShape(CLOSE);
			index++;
		}
	}
}




void show_seeds() {
	fill(255);
	apparence(0);
  if(show_seeds_is) {
    for (vec3 point : voronoi.get_seeds()) {
      circle(point.x(), point.y(), 10);
    }
  }
}


void gui_instruction() {
	int line = 20;
	int step = 20;
	fill(0);
	text("p: toggle seeds", 20, line);
	text("t: toggle triangles", 20, line+=step);
	text("x: clear all", 20, line+=step);
	text("r: add random seeds", 20, line+=step);
	text("c: toggle voronoi diagram", 20, line+=step);
	text("i: print info", 20, line+=step);
	text("e: remove random seed", 20, line+=step);
	text("k: show stroke", 20, line+=step);
}

void apparence(int c) {
	if(show_stroke_is) {
		stroke(c);
		strokeWeight(thickness); 
	} else {
		stroke(0,0);
		noStroke();
	}
}