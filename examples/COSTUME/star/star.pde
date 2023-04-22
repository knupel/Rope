/**
* Rope Star is like a Rock Star !!!!
* @author Knupel
* https://github.com/knupel/Rope
* v 0.0.1
* 2022-2023
*/

import rope.costume.R_Star;
import rope.core.Rope;

R_Star star;
Rope r = new Rope();

void setup() {
  size(1200,1200);
  star = new R_Star(this); // basic star with 5 branches
  star.set_summits(47);
  star.pos(width/2, height/2);

}

void draw() {
  background(0);
  float ra = map(mouseX, 0,width, 0.1, 0.8);
  float rb = map(mouseY, 0,height, ra, 1);
  // you can add any ratio until to the num of branches, need to be pair
  star.set_ratio(ra,rb);
  // star.set_ratio(ra,rb, ra*0.5, rb);
  star.size(width);
  star.show();
}
