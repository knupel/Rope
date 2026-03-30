/**
* FOV
* v 0.0.1
* 2021-2021
*/
package rope.tool;

public class R_Fov {
  private float start = 0.0f;
  private float stop = (float)Math.PI;
  private float fov = this.stop - this.start;

  public R_Fov() {}

  /**
   * 
   * @param start angle in radian, must be lower than stop
   * @param stop angle in radian, must be upper than start
   */
  public R_Fov(float start, float stop) {
    set(start, stop);
  }

  public void set(float start, float stop) {
    this.start = start;
    this.stop = stop;
    this.fov = calc_fov(this.start, this.stop);
  }

  /**
   * 
   * @param start angle in radian, must be lower than stop
   */
  public void set_start(float start) {
    this.start = start;
    this.fov = calc_fov(this.start, this.stop);
  }

  /**
   * 
   * @param stop angle in radian, must be upper than start
   */
  public void set_stop(float stop) {
    this.stop = stop;
    this.fov = this.stop - this.start;
  }

  public float get_start() {
    return this.start;
  }

  public float get_stop() {
    return this.stop;
  }

  public float get_fov() {
    return this.fov;
  }

  private float calc_fov(float min, float max) {
    if(min > max) {
      String mess = "WARNING: class R_Fov.calc_fov(" + min + ", " + max + ") \nthe value 'min' must be < to 'max' to avoid problem the values is reversed";
      System.out.println(mess);
      float buf = max;
      max = min;
      min = buf;
    }

    if(min < 0 && max >= 0) {
      return Math.abs(min) + Math.abs(max);
    }

    if(min < 0 && max < 0) {
      return Math.abs(min) - Math.abs(max);
    }
    return max - min;
  }
}