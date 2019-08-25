/**
* Rope Chose
* v 0.0.1
* 2019-2019
* @author @stanlepunk
* @see https://github.com/StanLepunK/Rope
*
*/
import rope.costume.R_Chose;
import rope.vector.*;
R_Chose chose;
float [] relief;
void setup() {
  background(125);
  size(300,300,P2D);
  generator_chose();
}

void draw() {
  background(125);
  update_chose();

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



void update_chose() {
  // update motion
  //println(chose.get_radius());
  for(int i = 0 ; i < chose.get_radius().length ; i++) {
    relief[i] = chose.get_radius(i) + random(-5,5);
  }
  chose.radius(relief);
  chose.reset_is(true);
}



void generator_chose() {
  chose = new R_Chose(this,(int)random(10,200));
  chose.is_pair(); // necessary for symetric render
  relief = new float[(int)random(2,chose.get_summits())];
  for(int i = 0 ; i < relief.length ; i++) {
    relief[i] = random(0,width/2);
  }
  chose.radius(relief); // create a radius for each summits, and if missing cycling is used symetric or not.
  chose.pos(width/2,height/2);
}
