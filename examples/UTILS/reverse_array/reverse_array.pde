/**
*
*/
import rope.utils.R_Utils.Ru;
import rope.core.Rope;

// Rope r = new Rope();

void setup() {
  int [] arr = {0,1,2,3};
  PVector [] p = new PVector[3];
  p[0] = new PVector(0,0);
  p[1] = new PVector(1,1);
  p[2] = new PVector(2,2);
  printArray(arr);
  printArray(p);
  printArray(Ru.reverse(arr)); // KO,  don't work but the code is the same
  // printArray(reverse(arr)); // ok, work
  printArray(Ru.reverse(p));
  // printArray(rope.utils.R_Utils.Ru.reverse(p));
}


<T> T [] reverse(T [] arr) {
  for(int i = 0 ; i < arr.length / 2; i++) {
    T buf = arr[i];
    arr[i] = arr[arr.length - i - 1];
    arr[arr.length - i - 1] = buf;
  }
  return arr;
}
