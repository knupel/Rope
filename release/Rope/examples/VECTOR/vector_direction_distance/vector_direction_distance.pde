import rope.vector.*;
vec2 a,b;
void setup() {
  size(400,400);
  generate(); 
}

void draw() {
  // calcul the direction and the distance
  vec2 dir = a.dir(b);
  float dist = a.mag(b);
  // float dist = a.dist(b);
  
  // sort a new point position around the path
  vec2 around = new vec2().rand(-5,5);
  float new_dist = random(0,dist);
  vec2 pts = dir.mult(new_dist).add(around).add(b);
  
  // display
  background(255);
  strokeWeight(1);
  stroke(0);
  line(a.x(),a.y(),b.x(),b.y());
  strokeWeight(5);
  stroke(255,0,0);
  point(pts.x(),pts.y());
}

void keyPressed() {
  if(key == 'n') generate();
}

void generate() {
  a = new vec2(random(width),random(height));
  b = new vec2(random(width),random(height));
}
