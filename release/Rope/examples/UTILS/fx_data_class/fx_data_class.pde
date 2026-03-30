/**
* R_FX is a class to store FX data, can be utils to gui, effect...
* the goal is for shader setting...
* @knupel
* v 0.0.1
* 2022-2022
*
*
* It's abeging example...
*/
import rope.utils.R_FX;
import rope.vector.ivec2;

R_FX fx;
void setup() {
  fx = new R_FX(this);
  println(fx.get_canvas());
  
}
