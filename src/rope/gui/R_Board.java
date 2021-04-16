/**
* CLASS R_Board
* Processing 3.5.4
* @author @stanlepunk
* @see https://github.com/StanLepunK/Rope
* v 0.1.0
* 2021-2021
*/

package rope.gui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import rope.R_State.State;
import rope.tool.R_Rank;
import rope.vector.vec2;
import rope.gui.button.R_Button;
import rope.gui.slider.R_Slider;

public class R_Board extends Crope {
  private HashMap<Integer, String> list_key;
  private ArrayList<Crope> list;
  private R_Rank [] rank = new R_Rank[1];
  private boolean vert_is;
  private int marge = 12; // like in indesign default marge :)
  

  public R_Board (vec2 pos, vec2 size, boolean vert_is) {
    super("Board", pos, size);
    list = new ArrayList<Crope>();
    list_key = new HashMap<Integer, String>();
    rank[0] = new R_Rank();
    rank[0].set(0);
    set_fill(State.env().gui_board_fill_in);
    set_stroke(State.env().gui_board_fill_in);
    this.vert_is = vert_is;
  }

  private vec2 rank_pos(vec2 size_elem, float step) {
    vec2 buf = this.pos.copy();
    // vec2 buf = this.pos.copy().add(marge).add_y(100);
    vec2 offset = new vec2(marge).sub_y(size_elem.y());
    float temp_step = step;
    if(rank[0].size() == 1) {
      temp_step = 1;
    }
    if(!vert_is) {
      buf.x((size_elem.x() * temp_step) + rank[0].get());
      rank[0].add(buf.x());
    } else {
      buf.y((size_elem.y() * temp_step) + rank[0].get());
      rank[0].add(buf.y());
    }
    return buf.add(offset);
  }

  public void add_button(vec2 size_elem, float step, String... label) {
    for(int i = 0 ; i < label.length ; i++) {
      R_Button b = new R_Button(rank_pos(size_elem, step), size_elem);
      b.set_label(label[i]);
      list.add(b);
    }
    to_list_key();
  }

  public void add_slider(vec2 size_elem, float step, String... label) {
    for(int i = 0 ; i < label.length ; i++) {
      R_Slider s = new R_Slider(rank_pos(size_elem, step), size_elem);
      s.set_label(label[i]);
      list.add(s);
    }
    to_list_key();
  }



  public void print_pairs() {
    Iterator iter = list_key.keySet().iterator();
    while(iter.hasNext()) {
      int id = (int)iter.next();
      String name = list_key.get(id);
      print_out("key:", id, "| value:", name);
    }
  }

  public void update() {
    for(Crope c : list) {
      c.update();
      if(c instanceof R_Button) {
        ((R_Button)c).rollover(true);
      }
    }
  }

  public R_Board set_marge(int marge) {
    this.marge = marge;
    return this;
  }

  public void show_board() {
    render_solid_color();
    render_solid_stroke();
  }

  public void show_structure() {
    for(Crope c : list) {
      c.show_structure();
    }
  }

  public void show_molette() {
    for(Crope c : list) {
      if(c instanceof R_Slider) {
        ((R_Slider)c).show_molette();
      }
    }
  }

  public void show_label() {
    for(Crope c : list) {
      c.show_label();
    }
  }

   public void show_value() {
    for(Crope c : list) {
      c.show_value();
    }
  }


  private void to_list_key() {
    int index = 0;
    list_key.clear();
    for(Crope c : list) {
      list_key.put(index,c.get_name());
      index++;
    }
  }

  public String get_name(int id) {
    if(id >= 0 && id < list_key.size()) {
      return list_key.get(id);
    }
    return null;
  }

  /**
  * GET VALUES
  */

  public float get(int index_crope) {
    if(index_crope >= 0 && index_crope < list.size()) {
      return list.get(index_crope).get();
    }
    return Float.NaN;
  }

  public float get(String name) {
    return get(name, 0);
  }

  /**
  * returns the first occurrence that matches
  */
  public float get(String name, int index_value) {
    for(Crope c : list) {
      if(c.get_name() == name) {
        return c.get(index_value);
      }
    }
    return Float.NaN;
  }


  public float get(int index_crope, String name, int index_value) {
    if(all(index_crope >= 0, index_crope < list.size())) {
      if(list.get(index_crope).get_name() == name) {
        return list.get(index_crope).get(index_value);
      }
      return Float.NaN;
    }
    return Float.NaN;
  }

  public float get(int index_crope, String name) {
    return get(index_crope, name, 0);
  }

  public  float [] get_all(int index_crope) {
    if(index_crope >= 0 && index_crope < list.size()) {
      return list.get(index_crope).get_all();
    }
    return null;
  }

  public float [] get_all(int index, String name) {
    if(all(index >= 0, index < list.size())) {
      if(list.get(index).get_name() == name) {
        return list.get(index).get_all();
      }
      return null;
    }
    return null;
  }
} 
