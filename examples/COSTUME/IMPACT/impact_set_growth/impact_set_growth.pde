/**
 * 
 * impact set growth parameter
 * v 0.2.0
 * 2022-2023
 * 

 * */
import rope.costume.R_Impact;

R_Impact imp;

void setup() {
	size(600,600);
	set_impact();
	imp.build();
}

void draw() {
	background(255);
	fill(0);
	imp.show_lines();
	// imp.show_lines_main();
	// imp.show_lines_circle();
	// imp.show_lines_heart();

	String str = "[ " + mouseX + " " + mouseY + " ]";
	text(str, mouseX, mouseY);
  text("press N for new type of distribution and new sort", 20, 20);
  text("MOUSE CLICK for new sort", 20, 35);
}

int distribution = 0;
void keyPressed() {
	if(key == 'n') {
    distribution ++;
    if(distribution > 1) {
      distribution = -1;
    }
    set_distribution();	
	}
}

void mousePressed() {
  set_distribution();
}

void set_distribution() {
  println("new sort");
    // main setting
  float min = random(1);
  float max = min + random(1);
  imp.set_growth_main(min, max);

  // circle setting
  min = random(1);
  max = min + random(1);
  // with this setting that's create something regular
  if(distribution != 0) {
    min = 1;
    max = 1;
  }
  imp.set_growth_circle(min, max, distribution);
  println("type of distribution", imp.get_growth_circle_distribution());
  imp.build();

}


void set_impact() {
	imp = new R_Impact(this, width/2, height/2, 500);

	imp.heart_is(true); // from 1 to max main iteration

	// SET THE MAIN BRANCHES
	int num = 12;
	imp.set_num_main(num); // num of main branch
	imp.set_iter_main(10); // num of node on each branch
	imp.set_angle_main(0.1); // max angle to change the direction of the main branch

	// SET THE LINES WHO CONNECT THE MAIN BRANCHES
	imp.set_num_circle(num * 4); // num of branch circle start from the main branch
	imp.set_iter_circle(num); // num of node on the circle branch / where the max for normal mode is the num of main branches
}