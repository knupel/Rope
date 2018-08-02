package rope.vector;

import rope.core.BigBangRope;

public abstract class bVec extends BigBangRope {
	private int num ;
	public boolean x,y,z,w;
	public boolean a,b,c,d,e,f;
	public bVec(int num) {
		this.num = num;
	}
	
	public int get_num() {
		return this.num;
	}

}
