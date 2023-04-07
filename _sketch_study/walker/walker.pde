ArrayList<PVector> listP;
int marge = 250;
int num = 200000;

void setup(){
  size(800,800);
  background(255);
  marge = width / 8;
  listP = new ArrayList();
  
  for( int i = 0 ; i < num ; i++) {
    float x = random(marge, width -marge) ;
    float y = random (marge, height -marge ) ;
    listP.add( new PVector(x,y)) ;
  }
}


void draw (){
  // background(255,10) ;
  jitter(listP, 1.5 );
  for ( PVector p :  listP ) {
    color c = color (0,10 );
    set(int(p.x), int(p.y), c);
  }
  println(listP.size()); 
}

void jitter( ArrayList<PVector>points, float radius ){
  float rad;
  float angle;
  for( PVector p : points) {
    // rad = prng.random() * radius;
    //angle = prng.random() * ( 2 * PI );
    rad = random(-1,1) * radius;
    angle = random(-1,1) * ( 2 * PI );
    p.x += rad * cos(angle);
    p.y += rad * sin(angle);
  }
}
