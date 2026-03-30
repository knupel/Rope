/**
* FOCUS
* v 0.0.1
* 2021-2021
*/

package rope.tool;

public class R_Focus {
  private float angle = 0;
  private float distance = 1;

  public R_Focus() {}

  public R_Focus(float angle, float distance) {
    set_dist(distance);
    set_angle(angle);
  }

  public void set_dist(float distance) {
    this.distance = distance;
  }

  public float get_dist() {
    return this.distance;
  }

  public void set_angle(float angle) {
    this.angle = angle;
  }

  public float get_angle() {
    return this.angle;
  }
}