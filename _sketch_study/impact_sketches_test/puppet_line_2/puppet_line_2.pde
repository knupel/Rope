import rope.mesh.R_Line2D;
import rope.vector.vec2;
import rope.vector.vec3;
import rope.vector.vec5;
import rope.core.Rope;
import rope.tool.R_Puppet2D;
import rope.utils.R_Pair;

Rope r = new Rope();
R_Puppet2D puppet;

void setup() {
	size(500,500);
	puppet = new R_Puppet2D(this);
	puppet.set(width/2, height - (height/3), width/2,height/3);
	vec3 child_a = new vec3().rand(new vec3(), new vec3(width, height,0));
	vec3 child_b = new vec3().rand(new vec3(), new vec3(width, height,0));
	puppet.add_puppets(child_a, child_b); // BUG for this time
}

void draw() {
	background(r.MAGENTA);
	vec2 mouse = new vec2(mouseX,mouseY);
	float radius = 10;
	puppet.show();
	fill(r.YELLOW);
	circle(puppet.a().x(), puppet.a().y(), radius *2);
	fill(r.BLACK);
	textSize(24);
	textAlign(CENTER, CENTER);
	text("A",puppet.a().x(), puppet.a().y() - 12);
	fill(r.CYAN);	
	circle(puppet.b().x(), puppet.b().y(), radius *2);
	fill(r.BLACK);
	textSize(24);
	textAlign(CENTER, CENTER);
	text("B",puppet.b().x(), puppet.b().y() - 12);

	// UPDATE
	///////////////
	boolean update_is = false;

	if(puppet.a().compare(mouse, radius *2) && mousePressed) {
		puppet.a(mouse);
		update_is = true;
	}

	if(puppet.b().compare(mouse, radius *2) && mousePressed) {
		puppet.b(mouse);
		update_is = true;
	}

	if(update_is) {
		puppet.update();
		puppet.update_puppets();
	}


	// display
	for(int i = 0 ; i < puppet.size() ; i++) {
		R_Pair<vec3,vec5> pair = puppet.get_puppet(i);

		fill(r.WHITE);
		vec2 origin = puppet.get_puppet_origin(i);
		circle(origin.x(),origin.y(), 50);

		fill(r.BLOOD);
		vec2 on_line = puppet.get_puppet_online(i);
		circle(on_line.x(),on_line.y(),10);

		fill(r.BLACK);
		vec2 proj = puppet.get_puppet_projection(i);
		circle(proj.x(),proj.y(),20);
	}
}

void keyPressed() {
	if(key == 'n' || key == 'N') {
		new_distribution();
	}
}

void new_distribution() {
	puppet.set(new vec2().rand(0,width), new vec2().rand(0,width));
	puppet.clear();
	vec3 child_a = new vec3().rand(new vec3(), new vec3(width, height,0));
	vec3 child_b = new vec3().rand(new vec3(), new vec3(width, height,0));
	puppet.add_puppets(child_a, child_b);
}


