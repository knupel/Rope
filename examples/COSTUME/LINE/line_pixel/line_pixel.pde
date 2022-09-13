/**
* Line2D pixel
*
* Copyleft(c) 2022-2022
* v 0.1.0
* @author @stanlepunk
* @see https://github.com/StanLepunK/Rope
* 
*/

import rope.costume.R_Line2D;
import rope.vector.vec2;
import rope.core.Rope;
import rope.core.R_Graphic;

// R_Line2D line;
Line line;
Rope r = new Rope();

void setup() {
  size(600,600);
  // line = new R_Line2D(this);
  line = new Line(this);
  line.set(width/2,height/2,random(width),random(height));
}

void draw() {
  background(0);
  stroke(255);
  line.show_pixel(0.3, r.MAGENTA, r.CYAN);
}

class Line extends R_Line2D {
  Line (PApplet pa) {
    super(pa);
  }
  void show_pixel(float density, int... colour) {
    int num_pixel = (int)(dist() * density);
    if(colour.length > 1) {
      for(int i = 0 ; i < num_pixel ; i++) {
        int which = floor(random(colour.length));
        // println(colour[which]);
        set(point(random(1)),colour[which]);
        // USE R_Pix avec le point d'entrée cela pourrait plus rapide pour l'affichage avec le mode pixel array
      }
    } else {
      for(int i = 0 ; i < num_pixel ; i++) {
        set(point(random(1)),colour[0]);
      }
    }
    
  }
}
