import rope.core.Rope;
Rope r = new Rope();
float y = 0;

void setup() {
  size(400,400, P2D);
  background(r.WHITE);
  int variance = 150;
  for(float x = 0 ; x < width ; x++) {
    // y = rand_distribution(height);
    //set((int)x,(int)y, r.PINK);
    
    // y = linear_distribution(x);  
    // set((int)x,(int)y, r.BLUE);
    
    // y = sin_distribution(x, height) * height;
    // set((int)x,(int)y, r.RED);
    
    y = cos_distribution(x, variance) ;
    // the curce
    set((int)x,int(y * height), r.BLUE);
    // use case
    float chance = random(1);
    if(chance < y) {
      set((int)x,height/2, r.BLUE);
    }
    
    
    
    // y = test_distribution(x, height) * height;
    // set((int)x,(int)y, r.MAGENTA);
  }
  
  //cos_line(variance);
}

void cos_line(int variance) {
  for(int x = 0 ; x < width ; x++) {
    float abs_x = cos_distribution(x, variance);
    // println(abs_x);
    if(random(1) < abs_x) {
      // println(abs_x *width);
      set(x,height/2, r.BLUE);
    }
    
  }
}


float rand_distribution(float x) {
  return random(1) * x; 
}

float linear_distribution(float x) {
  return x; 
}

float sin_distribution(float x, float range) {
  return map(sin(x / range * TAU), -1, 1, 0, 1); 
}

float cos_distribution(float x, float range) {
  return map(cos(x / range * TAU), -1, 1, 0, 1); 
}


float test_distribution(float x, float mean) {
  float std_deviation = 19;
  float variance = std_deviation * std_deviation; 
  return (float)Math.pow(Math.exp(-(((x - mean) * (x - mean)) / ((2 * variance)))), 1 / (std_deviation * Math.sqrt(2 * Math.PI)));
}
