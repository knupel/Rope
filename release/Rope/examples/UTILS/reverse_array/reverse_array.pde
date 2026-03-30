/**
* reverse function faster than Processing
* may be when I've the possibility I push this one on Processing
*/
import rope.utils.R_Utils.Ru;
import rope.core.Rope;

int num = 30_000_000;

void setup() {
  // Machin [] arr = new Machin[num];
  // long [] arr = new long[num];
  // float [] arr = new float[num];
  // Integer [] arr = new Integer[num];
  // boolean [] arr = new boolean[num];
  // char [] arr = new char[num];
  // int [] arr = new int[num];
  // double [] arr = new double[num];
  PVector [] arr = new PVector[num];
  // String [] arr = new String[num];
  
  // long Rope faster x100
  // double Rope faster x100
  // boolean Rope faster x1.5
  // char Rope faster x2.5
  // int Rope faster x3.5
  // float Rope faster x3.5
  // Integer Rope faster x9
  // PVector Rope faster x3.5
  // Machin Rope faster x9
  
  // ONLY CASE where processing is faster
  // String Processing faster x1.1
  for(int i = 0 ; i < arr.length ; i++) {
    // arr[i] = true;
    // arr[i] = i;
    // arr[i] = (char)i;
    // arr[i] = ""+i;
    arr[i] = new PVector(i,i);
    // arr[i] = new Machin();
  }

  float start = millis();
  reverse(arr);
  println("P5",millis() - start);
  
  start = millis();
  Ru.reverse(arr); 
  println("Rope",millis() - start);
}

class Machin {
  Machin(){}
}
