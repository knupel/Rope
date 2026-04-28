
import rope.core.Rope;
Rope r = new Rope();
int [] proportion;
int sum;
float normal_ratio;
float final_ratio;
int num_rect_by_bands = 50;
int num_bands = 20;


void setup() {
  size(900,600);
  colorMode(HSB,360,100,100);
  proportion = new int[] {50,5,100,5,5,1,1,1,1,5,20,30,50};
  motif();
}


void draw() {
}

void keyPressed() {
  motif();
}

void motif() {
  int hauteur = height / num_bands;
  for(int i = 0 ; i < num_bands ; i++) {
    colour_band(i *hauteur, hauteur, num_rect_by_bands);
  }
}

void colour_band(int pos_y, int hauteur, int max) {
  int largeur = width/max;
  for(int i = 0 ; i < max ; i++) {
    int value = (int)r.random_ratio(g.colorModeX, proportion);
    int c = color(value, 100,100);
    noStroke();
    fill(c);
    rect(i*largeur, pos_y, largeur, hauteur);
  }
}
