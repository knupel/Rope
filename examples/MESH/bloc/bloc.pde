/**
* R_Bloc example
* example : create bloc
* v 0.0.1
* 2019-2022
*/

/**
 *  Generate a Random Bloc
 *  detect if the cursor is in the bloc
 *  If it is, you can drag it and move it.
 * 
 * */

import rope.core.Rope;
import rope.mesh.R_Bloc;
import rope.vector.vec2;

Rope r = new Rope();

void setup() {
	size(400,400,P2D);
}

R_Bloc bloc;

void draw() {
	background(r.SANG);
	if(bloc == null) {
    vec2 a = new vec2(random(height),random(width));
    vec2 b = new vec2(random(height),random(width));
    vec2 c = new vec2(random(height),random(width));
    // etc
		bloc = create_bloc(true, a,b,c);
    bloc.thickness(4);
    bloc.stroke(r.BLACK);
    bloc.fill(r.WHITE);
	} else {
		bloc.show();
	}
  // update
  bloc.update(mouseX,mouseY);
  
  // detection
  bloc.select(mouseX,mouseY);
  if(bloc.select_is()) {
    bloc.fill(r.WHITE);
    // bloc.move_point(mouseX,mouseY, true);

    bloc.move(mouseX,mouseY,mousePressed);
    bloc.select_is(false);
  } else {
    bloc.fill(r.BLACK);
  }
}


R_Bloc create_bloc(boolean close_is, vec2... points) {
  R_Bloc bloc = new R_Bloc(this);
  for(vec2 v : points) {
    bloc.build(v.x(),v.y(),true);
  }
  if(close_is) {
    bloc.build(points[0].x(), points[0].y(), true);
  }
  return bloc;
}
