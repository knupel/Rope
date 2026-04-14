/**
* Rope Chose
* v 0.0.2
* 2019-2026
* @author @knupel
* @see https://github.com/knupel/Rope
*
*/
import rope.costume.R_Chose;
import rope.vector.*;
R_Chose chose;
void setup() {
  background(125);
  size(300,300,P2D);
  generator_chose();
}

void draw() {
  background(125);
  chose.pos(mouseX,mouseY);
  chose.show();

}

void keyPressed() {
  if(key == 'n') {
    generator_chose();
  }

  if(key == 'r') {
    if(chose.symmetric_is()) {
      chose.symmetric_is(false);
    } else {
      chose.symmetric_is(true);
    }
  }
}



void generator_chose() {
  chose = new R_Chose(this,(int)random(10,200));
  chose.is_pair(); // necessary for symetric render
  float [] relief = new float[(int)random(2,chose.get_summits())];
  for(int i = 0 ; i < relief.length ; i++) {
    relief[i] = random(0,width/2);
  }
  // chose.radius(60,40,100);
  chose.radius(relief); // create a radius for each summits, and if missing cycling is used symetric or not.
  chose.calc(); // to have the final point you need to calculated those.
  // printArray(chose.get_points());
  // printArray(chose.get_ref_points());
}
