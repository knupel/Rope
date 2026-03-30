/**
 *   ___      ___   ____   _______
 *  | -  \   /   \  |    \ |  ___/
 *  | |/  | |   \ | | |\ | |  |__
 *  |    /  | | | | | |  / |  __/
 *  | |  \  \ \   / |  |/  |  |____
 *  |_| \_\  \___/  |_ |   |______/
 * 
 * R_Pixies class
 * v 0.0.1
 * 2023-2023
 * @author @knupel
 * @see https://github.com/knupel/Rope
 * 
 * class manager for R_Pix
 * 
*/


package rope.pixo;

import java.util.ArrayList;

import rope.core.Rope;
import rope.pixo.R_Pix;

public class R_Pixies extends Rope {
  private ArrayList<R_Pix> list;

  public R_Pixies() {
    list = new ArrayList<R_Pix>();
  }


  public void add(R_Pix pix) {
    list.add(pix);
  }

  public  ArrayList<R_Pix> get() {
    return list;
  }

  public R_Pix get(int index) {
    if(index >= 0 && index < list.size()) {
      return list.get(index);
    }
    print_err(this, "index is out of the range", index);
    return null;
  }


  public int size() {
    return list.size();
  }

  public void clear() {
    list.clear();
  }

  public R_Pix [] array() {
    return list.toArray(R_Pix[]::new);
  }

  public void remove(int index) {
    if(index >= 0 && index < list.size()) {
      list.remove(index);
    }
    print_err(this, "index is out of the range", index);
    return;
  }
}
