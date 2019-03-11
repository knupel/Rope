/**
* RBezier class
* v 0.0.1
* 2019-2019
* @author @stanlepunk
* @see https://github.com/StanLepunK/Rope
* Class RShape store the utilities to draw shape and costume
*/

package costume;

// import processing.core.*;
import rope.vector.*;

public class RBezier {
	private vec3 pos;
  private vec3 fore_handle;
  private vec3 rear_handle;

  public RBezier() {
    pos = new vec3();
    fore_handle = new vec3();
    rear_handle = new vec3();
  }

  // set 
  public void set_pos(vec pos) {
    this.pos.set(pos);
  }

  public void set_a(vec fore) {
    this.fore_handle.set(fore);
  }

  public void set_b(vec rear) {
    this.rear_handle.set(rear);
  }

  // engine
  public void from_angle(float angle, float handle_mag) {
    float cos_angle = (float)Math.cos(angle);
    float sin_angle = (float)Math.sin(angle);
    
    vec2 pos = new vec2(cos_angle,sin_angle);
    set_pos(pos);
    set_a(new vec2(pos.x -sin_angle *handle_mag, pos.y +cos_angle *handle_mag)); 
    set_b(new vec2(pos.x +sin_angle *handle_mag, pos.y -cos_angle *handle_mag));
  }
  
  // get
  public vec3 get_pos() {
    return pos;
  }

  public vec3 get_a() {
    return fore_handle;
  }

  public vec3 get_b() {
    return rear_handle;
  }

}
