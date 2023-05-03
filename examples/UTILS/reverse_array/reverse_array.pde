/**
* reverse function faster than Processing
* may be when I've the possibility I push this one on Processing
*/
import rope.utils.R_Utils.Ru;
import rope.core.Rope;

int num = 30_000_000;

void setup() {
 // PVector [] arr = new PVector[num];
  String [] arr = new String[num]; 
  // int Rope faster x3.5
  // float Rope faster x3.5
  // Integer Rope faster x3.5
  // Rope Processing faster x1.1
  // PVector Rope faster x3.5
  for(int i = 0 ; i < arr.length ; i++) {
    // arr[i] = i;
    arr[i] = ""+i;
    // arr[i] = new PVector(i,i);
  }

  float start = millis();
  reverse(arr);
  println("P5",millis() - start);
  
  start = millis();
  Ru.reverse(arr); 
  println("Rope",millis() - start);
}
