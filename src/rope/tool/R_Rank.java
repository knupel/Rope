/**
* R_Rank
* Processing 3.5.4
* @author @stanlepunk
* @see https://github.com/StanLepunK/Rope
* v 0.2.0
* 2021-2021
*/

package rope.tool;

import java.util.ArrayList;

public class R_Rank {
	private ArrayList<Float> list;
	public R_Rank() {
		list = new ArrayList<Float>();
		list.add(0.0f);
		
	}
  public R_Rank(float rank) {
  	list = new ArrayList<Float>();
  	list.add(rank);
  }

	public void inc(float value) {
		float buf = (float)list.get(list.size() -1) + value;
		list.add(buf);
	}

	public void add(float value) {
		list.add(value);
	}

	public void add(int index, float value) {
		if(index < 0 ) {
			list.add(0, value);
		} else if(index >= list.size()) {
			list.add(value);
		} else {
			list.add(index, value);
		}
	}

	public void set(float rank) {
		list.set(list.size() -1, rank);
	}

	public boolean set(int index, float rank) {
		if(list.size() >= 0 && list.size() < index) {
			list.set(index, rank);
			return true;
		}
		return false;	
	}

	public float get() {
		return (float)list.get(list.size() -1);
	}
	
	public float get(int index) {
		if(index >= 0 && index < list.size()) {
			return (float)list.get(index);
		}
		return (float)list.get(0);
	}
	
	public ArrayList<Float> all() {
		return list;
	}
}