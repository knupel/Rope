import rope.core.Rope;
import rope.core.R_Graphic;
import rope.vector.vec2;
Rope r = new Rope();
R_Graphic rg;
int num = 300;
vec2 [] arr = new vec2[num];
float start_angle = 0;
float fov = PI * 2;

void setup() {
  size(1000,1000);
  background(r.SANG);
  rg = new R_Graphic(this);
  init();
}

void draw() {
  if(mousePressed) {
    growth();
  }
}

void mousePressed() {
  background(r.SANG);
  init();
  start_angle = random(-PI,PI);
  // fov = random(TAU);
  println("start angle", start_angle);
  println("fov", fov);
}

void init() {
  int start_x = width/2 - (arr.length /2);
  for(int i = 0 ; i < arr.length ; i++) {
    arr[i] = new vec2(start_x+i, height/2);
  }
}


void growth() {
  float dist = 1;
  stroke(r.BLACK);
  for(vec2 p : arr) {
    // float ang = r.random(start_angle, start_angle + fov);
    float ang = random(fov) + start_angle;
    float dx = sin(ang);
    float dy = cos(ang);
    float x = dx * dist;
    float y = dy * dist;
    p.add_x(x);
    p.add_y(y);
    point(p.x(), p.y());
  }
  stroke(r.WHITE);
  rg.line(arr[0],arr[arr.length -1]);
}
