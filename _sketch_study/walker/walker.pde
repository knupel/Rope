ArrayList<PVector> listP;
int marge = 0;
int num = 200000;

void setup() {
  size(400,400);
  background(255);
  marge = width / 3;
  listP = new ArrayList();
  
  for( int i = 0 ; i < num ; i++) {
    float x = random(marge, width -marge) ;
    float y = random (marge, height -marge ) ;
    listP.add(new PVector(x,y)) ;
  }
}


void draw() {
  if(mousePressed) {
    background(255);
  }
  jitter(listP, 1.5);
  for (PVector p : listP) {
    color c = color (0, 10);
    set(int(p.x), int(p.y), c);
  }
}

void jitter(ArrayList<PVector>points, float radius) {
  float rad;
  float angle;
  for(PVector p : points) {
    // rad = prng.random() * radius;
    //angle = prng.random() * ( 2 * PI );
    rad = random(-1,1) * radius;
    // angle = random(-1,1) * (2 * PI);
    angle = random(-PI,PI);
    p.x += rad * cos(angle);
    p.y += rad * sin(angle);
  }
}
