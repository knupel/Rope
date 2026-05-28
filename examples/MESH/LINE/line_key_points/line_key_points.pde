/**
* Use key points on the line
* 2026-2026
* v 0.0.1
*/

import rope.mesh.R_Line2D;
import rope.vector.vec2;
import rope.core.R_Graphic;
import rope.core.Rope;

Rope r = new Rope();
R_Line2D a;
R_Line2D b;
R_Line2D c;
R_Graphic rg;
vec2 [] arr = new vec2[5];
float [] arr_norm = new float[arr.length];

void setup() {
  size(600,600);
  background(255);
  rg = new R_Graphic(this);
  create_keys();
  
}
  


void draw() {
  background(255);
  show_keys();
}

void keyPressed() {
  create_keys();

}

void show_keys() {
    rg.fill_is(true);
  // direct keys representation
  a.show();
  a.b(mouseX, mouseY);
  Float [] kp_a =  a.get_keys();
  
  for(int i = 0 ; i < kp_a.length ; i++) {
    rg.fill(r.ORANGE);
    rg.circle(a.get_point(kp_a[i]),5);
  }
  // keys from vec2 cloud,
  b.show();
  Float [] kp_b =  b.get_keys();

  for(int i = 0 ; i < arr.length ; i++) {
    vec2 v_a = arr[i];
    rg.fill(r.BLOOD);
    rg.circle(v_a,8);
    vec2 v_b = b.get_point(kp_b[i]);
    rg.fill(r.GOLD);
    rg.circle(v_b,8);
    rg.line(v_a, v_b);
  }
  // use copy of c to move the normal point
  c.show();
  c.b(mouseX, mouseY);
  Float [] kp_c = c.get_keys();
  rg.fill_is(true);
  for(int i = 0 ; i < arr.length ; i++) {
    vec2 v_a = arr[i];
    // rg.fill(r.BLOOD);
    // rg.circle(v_a,8);
    vec2 v_c = c.get_point(kp_c[i]);
    rg.fill(r.GREEN);
    rg.circle(v_c,8);
    rg.line(v_a, v_c);
  }
}


void create_keys() {
  // add normal float argument array
  a = new R_Line2D(this, new vec2().rand(0, width), new vec2().rand(0, height));
  a.add_keys(random(1),random(1),random(1),random(1),random(1),random(1),random(1));

  // add vec2 argument array
  b = new R_Line2D(this, new vec2().rand(0, width), new vec2().rand(0, height));
  for(int i = 0; i < arr.length ; i++) {
    arr[i] = new vec2(random(width), random(height));
  }
  b.add_keys(arr);
  c = b.copy();
}
