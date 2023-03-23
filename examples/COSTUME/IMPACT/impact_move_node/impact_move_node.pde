/**
 * 
 * Example to move node.
 * click on node circle and drag it where you want
 * v 0.1.0
 * 2023-2023
 * 
 * */
import rope.costume.R_Impact;
import rope.core.Rope;
import rope.vector.vec3;
import rope.mesh.R_Node;

R_Impact imp;
Rope r = new Rope();

void setup() {
	size(600,600);
	set_impact();
	imp.build();
}

void draw() {
	background(255);
	stroke(r.BLACK);
	fill(r.WHITE);

	// update node
	update_impact_node();
	// show 
	imp.show_lines();
	// info
	String str = "[ " + mouseX + " " + mouseY + " ]";
	text(str, mouseX, mouseY);
	text("press N for new sort", 20, 20);
}

void keyPressed() {
	println("nouveau tirage");
	if(key == 'n') {
		imp.build();
	}
}

boolean update_is = false;
void update_impact_node() {
	vec3 mouse = new vec3(mouseX,mouseY,0);
	int diam = 10;

	imp.update_preset();
	if(update_is) {
		imp.update();
		update_is = false;
	}


	// here we we use the pointer property of class R_Impact
	for(R_Node node : imp.get_nodes_main()) {
		if(node.pos().compare(mouse,diam)) {
			circle(node.pos().x(),node.pos().y(),diam *2);
			if(mousePressed) {
				update_is = true;
				node.pos(mouse);
			}
		} else {
			circle(node.pos().x(),node.pos().y(),diam);
		}
	}
}


void set_impact() {
	imp = new R_Impact(this, width/2, height/2, 500);
	imp.heart_is(true); // from 1 to max main iteration

	// SET THE MAIN BRANCHES
	//////////////////////////////////////////////
	int num = 12;
	imp.set_num_main(num); // num of main branch
	imp.set_iter_main(15); // num of node on each branch
	imp.set_angle_main(0.1); // max angle to change the direction of the main branch

	// SET THE LINES WHO CONNECT THE MAIN BRANCHES
	//////////////////////////////////////////////
	imp.set_num_circle(15); // num of branch circle start from the main branch
	imp.set_iter_circle(num); // num of node on the circle branch / where the max for normal mode is the num of main branches
}