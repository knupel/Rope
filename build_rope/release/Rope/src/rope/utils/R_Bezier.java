/**
* R_Bezier class
* v 0.0.3
* 2019-2019
* @author @stanlepunk
* @see https://github.com/StanLepunK/Rope
*/

package rope.utils;

import rope.vector.*;

public class R_Bezier {
	private vec3 pos;
  private vec3 fore_handle;
  private vec3 rear_handle;

  public R_Bezier() {
    pos = new vec3();
    fore_handle = new vec3();
    rear_handle = new vec3();
  }

  // set
  /**
   * 
   * @param pos
   */
  public void pos(vec pos) {
    this.pos.set(pos);
  }
  
  /**
   * 
   * @param fore
   */
  public void set_a(vec fore) {
    this.fore_handle.set(fore);
  }
  
  /**
   * 
   * @param rear
   */
  public void set_b(vec rear) {
    this.rear_handle.set(rear);
  }

  // engine
  /**
   * 
   * @param angle
   * @param handle_mag
   */
  public void from_angle(float angle, float handle_mag) {
    float cos_angle = (float)Math.cos(angle);
    float sin_angle = (float)Math.sin(angle);
    
    vec2 pos = new vec2(cos_angle,sin_angle);
    pos(pos);
    set_a(new vec2(pos.x -sin_angle *handle_mag, pos.y +cos_angle *handle_mag)); 
    set_b(new vec2(pos.x +sin_angle *handle_mag, pos.y -cos_angle *handle_mag));
  }
  
  // get
  /**
   * 
   * @return
   */
  public vec3 pos() {
    return pos;
  }
  
  /**
   * 
   * @return
   */
  public vec3 get_a() {
    return fore_handle;
  }
  
  /**
   * 
   * @return
   */
  public vec3 get_b() {
    return rear_handle;
  }

}
