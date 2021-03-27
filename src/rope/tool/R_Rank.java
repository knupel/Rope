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

	public void add(float value) {
		float buf = (float)list.get(list.size() -1) + value;
		list.add(buf);
	}

	public void set(float rank) {
		list.add(rank);
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