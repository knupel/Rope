import rope.core.Rope;
Rope r = new Rope();
float res = 0;
float chance = 0;

void setup() {
  size(400,400, P2D);
  background(r.WHITE);
  int variance = 150;
  for(float x = 0 ; x < width ; x++) {
    // res = rand_distribution();
    // chance = random(1);
    // if(chance < res) {
    //   set((int)x,height/2, r.PINK);
    // }

    // res = rand_gaussian_distribution(height);
    // chance = random(1);
    // if(chance < res) {
    //   set((int)x,height/2, r.BLACK);
    // }
    
    // res = linear_distribution(x);  
    // set((int)x,(int)res, r.BLUE);
    
    // res = sin_distribution(x, height) * height;
    // set((int)x,(int)res, r.RED);


    // the curve
    float mx = map(x, 0, width, -1, 1);
    res = normal_distribution(mx);
    // res = normal_distribution(x);
    set((int)x,int(res * height), r.BLUE);
    
    // use case
    chance = random(1);
    if(chance < res) {
      set((int)x,height/2, r.BLUE);
    }


    // // the curve  
    // res = cos_distribution(x, variance) ;
    // set((int)x,int(res * height), r.BLUE);
    // // use case
    // chance = random(1);
    // if(chance < res) {
    //   set((int)x,height/2, r.BLUE);
    // }
    
    
    // // the curve 
    // res = test_distribution(x, height);
    // set((int)x,int(res  * height), r.MAGENTA);
    // // use case
    // chance = random(1);
    // if(chance < res) {
    //   set((int)x,height/2, r.MAGENTA);
    // }
  }
}

// https://fr.wikipedia.org/wiki/Loi_normale
// https://en.wikipedia.org/wiki/Normal_distribution
// https://stackoverflow.com/questions/10138085/how-to-plot-normal-distribution
float normal_distribution(float x) {
  float res = 0;
  // float sigma = sqrt(0.2); // variance
  // float sigma = sqrt(5.0); // variance
  float sigma = 0.2; // variance
  float mu = -0.2;
  float a = 1 / (sigma*(sqrt(2*PI)));
  float exp = (-1 *pow((x - mu),2)) / (2 * pow(sigma,2));
  // float exp = -(1.0f/2.0f)* pow(((x-mu)/sigma),2);
  // float exp = (pow(x-mu,2)/ 2*(pow(sigma,2))) * -1;
  // float exp = (pow(x-mu,2)/ 2*(pow(sigma,2)));
  println("a", a);
  println("exp", exp);
  // return res = pow(a, exp);
  res = a * (float)Math.exp(exp);
  // res = pow(exp, a);
  println("res:::::::::::::::::::", res);
  return res;
}





float rand_distribution() {
  return random(1); 
}

float rand_gaussian_distribution(float x) {
  return randomGaussian() * x; 
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
