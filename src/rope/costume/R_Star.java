/**
* R_Star class
* v 0.0.3
* 2019-2019
* @author @stanlepunk
* @see https://github.com/StanLepunK/Rope
* Class RPrimitive store the utilities to draw shape and costume
*/
package rope.costume;

import processing.core.PApplet;
import rope.core.R_Constants;
import rope.vector.*;

public class R_Star extends R_Shape implements R_Constants {
	boolean is_3D = false;
	int summits;
	float angle;
	float [] ratio;
	
	/**
	 * 
	 * @param pa
	 */
	public R_Star(PApplet pa) {
		super(pa);
		pos(0);
		size(1);
		summits = 5;
		ratio = new float[1]; 
		ratio[0] = (float).38;
		angle = 0;
	}
	
	/**
	 * 
	 * @param pa
	 * @param summits
	 * @param angle
	 * @param ratio
	 */
	public R_Star(PApplet pa, int summits, float angle, float... ratio) {
		super(pa);
		pos(0);
		size(1);
		set_summits(summits);
		angle(angle);
		set_ratio(ratio);
	}
	
	/**
	 * 
	 * @param is_3D
	 */
	public void is_3D(boolean is_3D) {
		this.is_3D = is_3D;
	}
	
	/**
	 * 
	 * @param summits
	 */
	public void set_summits(int summits) {
		if(summits > 3) this.summits = summits;
	}
	
	
	/**
	 * 
	 * @param ratio
	 */
	public void set_ratio(float... ratio) {
		this.ratio = ratio;
	}
	
	


	/**
	 * 
	 * @param position x,y,z-coordinate of the Star
	 * @param size_raw width,height,depth of the Star
	 */
	public void show() {
		if(pos.z != 0) {
			pushMatrix();
			translate(0,0,pos.z);
		}

		vec3 [] p = new R_Primitive(pa).polygon_2D(summits*2,angle);
    
    if(is_3D) {
    	star_3D(pos,size,p,ratio);
    } else {
    	star_2D(pos,size,p,ratio);
    }

		if(pos.z != 0) {
			popMatrix();
		}
	}
	
	/**
	 * 
	 * @param pos
	 * @param size
	 * @param p
	 * @param ratio
	 */
	private void star_3D(vec3 pos, vec3 size, vec3 [] p, float[] ratio) {
		vec3 radius = size.xyz().mult((float).5);
		int count_ratio = 0;
		for(int i = 0 ; i < p.length ; i++) {
			// make a star, change the interior radius
			if(ratio.length <= 1 ) {
				if(i%2 != 0) p[i].mult(ratio[0]);
			} else {
				if(i%(ratio.length) == 0) {
					count_ratio = 0;

				}
				p[i].mult(ratio[count_ratio]) ;
				count_ratio++;
			}
			p[i].mult(radius);
			p[i].add(pos);
		}
	  
	  float top = radius.z;
	  float bottom = -radius.z;
	  vec3 center = barycenter(p);
	  vec3 center_top = new vec3(center.x,center.y,top);
	  vec3 center_bottom = new vec3(center.x,center.y,bottom);

		for(int i = 0 ; i < p.length ; i++) {
			// face top
			beginShape() ;
			vertex(p[i]);
	    vertex(center_top);
			if(i+1 < p.length)  {
				vertex(p[i+1]);
			} else {
				vertex(p[0]);
			}
			vertex(p[i]); // close
			endShape();
			// face bottom
			beginShape() ;
			vertex(p[i]);
	    vertex(center_bottom);
			if(i+1 < p.length)  {
				vertex(p[i+1]);
			} else {
				vertex(p[0]);
			}
			vertex(p[i]); // close
			endShape();
		}
	}


	/**
	 * 
	 * @param pos
	 * @param size
	 * @param p
	 * @param ratio
	 */
	private void star_2D(vec3 pos, vec3 size, vec3 [] p, float[] ratio) {
		vec3 radius = size.xyz().mult((float).5);
		int count_ratio = 0;
		for(int i = 0 ; i < p.length ; i++) {
			// make a star, change the interior radius
			if(ratio.length <= 1 ) {
				if(i%2 != 0) p[i].mult(ratio[0]);
			} else {
				if(i%(ratio.length) == 0) {
					count_ratio = 0;

				}
				p[i].mult(ratio[count_ratio]) ;
				count_ratio++;
			}
			p[i].mult(radius);
			p[i].add(pos);
		}
		// draww star
		beginShape() ;
		for(int i = 0 ; i < p.length ; i++) {
			vertex(p[i]);
		}
		vertex(p[0]); // close
		endShape();
	}

}
