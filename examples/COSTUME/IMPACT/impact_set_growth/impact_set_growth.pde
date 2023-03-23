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

	String str = "[ " + mouseX + " " + mouseY + " ]";
	text(str, mouseX, mouseY);
  text("press N for new sort", 20, 20);
  text("MOUSE CLICK for new sort", 20, 35);
  text("press J use jitter option", 20, 50);
  text("press M for new type of main distribution", 20, 65);
  text("press C for new type of circle distribution", 20, 80);

}

int distri_main = 0;
int distri_circle = 0;
boolean use_jitter_is = false;
void keyPressed() {
	if(key == 'n') {
    set_distribution();	
	}

  if(key == 'c') {
    distri_circle ++;
    if(distri_circle > 1) {
      distri_circle = -1;
    }
    set_distribution();	
	}

	if(key == 'm') {
    distri_main ++;
    if(distri_main > 1) {
      distri_main = -1;
    }
    set_distribution();	
	}

  if(key == 'j') {
    if(use_jitter_is) {
      use_jitter_is = false ; 
    } else { 
      use_jitter_is = true;
    }
    set_distribution();
  }
}

void mousePressed() {
  set_distribution();
}

void set_distribution() {
  println("new sort");
  float range_min = -0.5;
  float range_max = 0.5;
    // main setting
  float min = random(range_min, 0);
  float max = random(0, range_max);
  if(!use_jitter_is) {
    min = 0;
    max = 0;
  }
  imp.set_growth_main(distri_main,  min, max);

  // circle setting
  min = random(range_min, 0);
  max = random(0, range_max);
  if(!use_jitter_is) {
    min = 0;
    max = 0;
  }
  imp.set_growth_circle(distri_circle,  min, max);

  println("circle type", imp.get_growth_circle_distribution());
  println("circle ratio", imp.get_growth_circle_ratio());

  println("\nmain type", imp.get_growth_main_distribution());
  println("main ratio", imp.get_growth_main_ratio());

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