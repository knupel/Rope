/**
* R_Line2D class
* v 0.2.0
* 2019-2022
* @author @stanlepunk
* @see https://github.com/StanLepunK/Rope
*/
package rope.costume;

import rope.core.*;
import processing.core.PApplet;
import processing.core.PGraphics;
import rope.vector.vec2;





public class R_Line2D extends R_Graphic implements R_Constants {
  protected vec2 a;
  protected vec2 b;
  protected vec2 ref_a;
  protected vec2 ref_b;
  
  /**
   * 
   * @param pa
   */
  public R_Line2D(PApplet pa) {
  	super(pa);
    this.a = new vec2();
    this.b = new vec2();
    this.ref_a = new vec2();
    this.ref_b = new vec2();
  }

  /**
   * 
   * @param pa
   * @param a
   * @param b
   */
  public R_Line2D (PApplet pa, vec2 a, vec2 b) {
  	super(pa);
    this.a = new vec2(a.x(),a.y());
    this.b = new vec2(b.x(),b.y());
    this.ref_a = new vec2(a.x(),a.y());
    this.ref_b = new vec2(b.x(),b.y());
  }
  
  /**
   * 
   * @param pa
   * @param ax
   * @param ay
   * @param bx
   * @param by
   */
  public R_Line2D (PApplet pa, float ax, float ay, float bx, float by) {
  	super(pa);
    this.a = new vec2(ax,ay);
    this.b = new vec2(bx,by);
    this.ref_a = new vec2(ax,ay);
    this.ref_b = new vec2(bx,by);
  }
  

  /**
   * 
   * @param a
   * @param b
   */
  public void set(vec2 a, vec2 b) {
    set(a.x(),a.y(),b.x(),b.y());
  }
  
  /**
   * 
   * @param ax
   * @param ay
   * @param bx
   * @param by
   */
  public void set(float ax, float ay, float bx, float by) {
    this.a(ax,ay);
    this.b(bx,by);
    this.ref_a(ax,ay);
    this.ref_b(bx,by);
  }
  /**
   * 
   * @param a
   */
  public void a(vec2 a) {
    this.a(a.x(),a.y());
  }
  
  /**
   * 
   * @param x
   * @param y
   */
  public void a(float x, float y) {
    this.a.set(x,y);
  }
  
  /**
   * 
   * @param b
   */
  public void b(vec2 b) {
    this.b(b.x(),b.y());
  }
  
  
  /**
   * 
   * @param x
   * @param y
   */
  public void b(float x, float y) {
    this.b.set(x,y);
  }



  protected void ref_a(vec2 ref_a) {
    this.ref_a.set(ref_a.x(),ref_a.y());
  }
  
  protected void ref_a(float x, float y) {
    this.ref_a.set(x,y);
  }
  
  protected void ref_b(vec2 ref_b) {
    this.ref_b(ref_b.x(),ref_b.y());
  }
  
  protected void ref_b(float x, float y) {
    this.ref_b.set(x,y);
  }
  
  /**
   * 
   * @return the final value for a
   */
  public vec2 a() {
    return a;
  }
  
  /**
   * 
   * @return the final value for b
   */
  public vec2 b() {
    return b;
  }
  
  /**
   * make a displacement of the line
   * @param offset
   * @return
   */
  public R_Line2D offset(vec2 offset) {
    offset(offset.x(), offset.y());
    return this;
  }

  public R_Line2D offset(float offset_x, float offset_y) {
    this.a.add(offset_x, offset_y);
    this.b.add(offset_x, offset_y);
    return this;
  }

  /**
   * the idea is pass a normal value 0 to 1, where 1 is the size of your segment. The size is mult by the value
   * @param begin add the distance of the beginning of the segment.
   * @param end add the distance of the end of the segment.
   */
  public R_Line2D change(float begin, float end) {
    float ang = angle();
    float dist = dist_ref();
    // change begin
    vec2 proj_a = projection(ang,dist*begin);
    vec2 proj_b = projection(ang,dist*end);
    a(sub(ref_a,proj_a));
    b(add(ref_b,proj_b));
    return this;
  }
  
  /**
   * Show the result of all previous work on line
   */
  public void show() {
  	show(null);
  }
  
  /**
   * Show the result of all previous work on line
   * 
   * @param other is the PGraphics where the result will be showing
   */
  public void show(PGraphics other) {
  	this.other = other;
    line(a,b);
    reset();
    
  }

  /**
   * If you don't use show() function for any reason, and in parralelele you change point
   * with function offset(), function change() or any futur method yo must use
   * function reset() to come back to references points setting
   */
  public void reset() {
    a.set(ref_a);
    b.set(ref_b);
  }
  


  /**
   * Return the length of the line
   * @return
   */
  public float dist() {
    return abs(a.dist(b));
  }

  protected float dist_ref() {
    return abs(ref_a.dist(ref_b));
  }

  /**
   * Return the intersection point between this line and an other one.
   * @param target
   * @return
   */
  public vec2 intersection(R_Line2D target) {
    vec2 [] arr = null; 
    return intersection(target, arr);
  }

  /**
   * Return the intersection point between this line and an other one.
   * @param target
   * @param exception, list of vec2 point make an exception node, helpful when you don't want a specific node point
   * @return
   */
  public vec2 intersection(R_Line2D target, vec2... exception) {
    float x1 = this.a.x();
    float y1 = this.a.y();
    float x2 = this.b.x();
    float y2 = this.b.y();
    
    float x3 = target.a.x();
    float y3 = target.a.y();
    float x4 = target.b.x();
    float y4 = target.b.y();
    
    float bx = x2 - x1;
    float by = y2 - y1;
    float dx = x4 - x3;
    float dy = y4 - y3;
   
    float b_dot_d_perp = bx*dy - by*dx;
    if(b_dot_d_perp == 0) return null;
   
    float cx = x3 -x1;
    float cy = y3 -y1;
    
    // with dx and dy
    float t = (cx*dy - cy*dx) /b_dot_d_perp;
    if(t < 0 || t > 1) return null;
   
   // with bx and by
    float u = (cx*by - cy*bx) /b_dot_d_perp;
    if(u < 0 || u > 1) return null;

    vec2 result = new vec2(x1 +t *bx, y1 +t *by);

    if(exception != null) {
      for(int i = 0 ; i < exception.length ; i++) {
        if(exception[i].compare(result,new vec2(1))) {
          result = null;
        }
      }
    }
    return result;
  }


  /**
   * Return the angle of the line from "a" to "b"
   * @return
   */
  public float angle() {
    return a.angle(b);
  }
  
  /**
   * Change the angle from the starting point "a"
   * @param angle
   * @return
   */
  public R_Line2D angle(float angle) {
    float ax = (float)Math.cos(angle);
    float ay = (float)Math.sin(angle);
    this.b = new vec2(ax,ay).mult(dist()).add(a);
    this.ref_b.set(this.b);
    return this;
  }
  
  
  /**
   * return coordinate of the normal position on the line from the first point
   * the distance use is calculte with the length of the line.
   * @param normal_pos is the normal distance from the first point
   * @return
   */
  public vec2 coord(float normal_pos) {
  	if(normal_pos >= 0 && normal_pos <= 1) {
  		float dx = (float)Math.cos(angle());
			float dy = (float)Math.sin(angle());
			return new vec2(dx,dy).mult(normal_pos*dist()).add(this.a);
  	} else {
  		return null;
  	}
  }
  
  /**
   * return coordinate of distance from the first point of the line
   * @param len is the distance from the first point
   * @return
   */
  public vec2 coord(int len) {
  	if(len >= 0 && len <= dist()) {
  		float dx = (float)Math.cos(angle());
			float dy = (float)Math.sin(angle());
			return new vec2(dx,dy).mult(len).add(this.a);
  	} else {
  		return null;
  	}
  }


  /**
   * 
   * @return
   */
  public R_Line2D copy() {
    return new R_Line2D(this.pa,this.a,this.b);
  }
  
  @Override
	public String toString() {
		return "[ " + this.a.x() + ", " + this.a.y() + ", "+ this.b.x() + ", " + this.b.y() +" ]";
	}
}
