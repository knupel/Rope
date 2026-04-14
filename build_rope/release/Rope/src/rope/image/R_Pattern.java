/**
* R_PAttern class
* v 0.2.0
* 2021-2021
* @author @stanlepunk
* @see https://github.com/StanLepunK/Rope
*/

package rope.image;

import processing.core.PApplet;
import processing.core.PGraphics;
import processing.core.PImage;
import rope.core.R_Graphic;
import rope.vector.ivec2;
import rope.vector.vec2;
import rope.vector.vec3;

public class R_Pattern extends R_Graphic {
  private ivec2 matrix_size;
  private vec2 matrix_range;
  private vec3 matrix_inc;
  private float [] mat_angle;
  private float [][] matrix;
  private vec3 [][] matrix_3;
  private vec2 period;
  private float turbulence;
  private float smooth;

  /**
   * 
   * @param pa
   */
  public R_Pattern(PApplet pa) {
  	super(pa);
    init();
  }
  
  /**
   * 
   */
  public void init() {
    this.matrix_size = new ivec2(32, 32);
    this.matrix_range = new vec2(0,1);
    this.matrix_inc = new vec3(0);
    this.period = new vec2(5.0f);
    this.mat_angle = null;
    this.turbulence = 5.0f;
    this.smooth = 1.0f;
  }

  /**
   * 
   * @param w
   * @param h
   */
  public void set_size(int w, int h) {
    this.matrix_size.set(w,h);
  }

  /**
   * 
   * @param min
   * @param max
   */
  public void set_range(float min, float max) {
    this.matrix_range.set(min,max);
  }

  /**
   * 
   * @param inc
   */
  public void set_increment(float inc) {
    this.matrix_inc.set(inc);
  }

  /**
   * 
   * @param x
   * @param y
   * @param z
   */
  public void set_increment(float x, float y, float z) {
    this.matrix_inc.set(x,y,z);
  }

  /**
   * 
   */
  public void set_no_increment() {
    this.matrix_inc.set(0);
  }

  /**
   * 
   * @param x
   * @param y
   */
  public void set_period(float x, float y) {
    period.set(x,y);
  }

  /**
   * 
   * @param turbulence
   */
  public void set_turbulence(float turbulence) {
    this.turbulence = turbulence;
  }

  /**
   * 
   * @param smooth
   */
  public void set_smooth(float smooth) {
    this.smooth = smooth;
  }

  /**
   * 
   */
  public void set_no_smooth() {
    this.smooth = 1.0f;
  }

  /**
   * 
   * @param a_x
   * @param a_y
   * @param a_z
   */
  public void set_angle(float a_x, float a_y, float a_z) {
    mat_angle = new float[3];
    mat_angle[0] = a_x;
    mat_angle[1] = a_y;
    mat_angle[2] = a_z;
  }

  /**
   * 
   */
  public void set_no_angle() {
    mat_angle = null;
  }




  /**
   * 
   */
  public void build_matrix_rand_mono() {
    matrix = new float[matrix_size.x()][matrix_size.y()];
    for (int x = 0; x < matrix_size.x() ; x++) {
      for (int y = 0; y < matrix_size.y() ; y++) {
        matrix[x][y] = random(matrix_range.min(), matrix_range.max());
      }
    }
  }

  /**
   * 
   */
  public void build_matrix_rand_xyz() {
    matrix_3 = new vec3[matrix_size.x()][matrix_size.y()];
    for (int x = 0; x < matrix_size.x() ; x++) {
      for (int y = 0; y < matrix_size.y() ; y++) {
        matrix_3[x][y] = new vec3().rand(matrix_range.min(), matrix_range.max());
      }
    }
  }

  /**
   * 
   */
  public void build_matrix_noise_mono() {
    matrix = new float[matrix_size.x()][matrix_size.y()];
    float offset_x = 0;
    float offset_y = 0;
    noiseSeed((int)random(MAX_INT));
    for(int x = 0 ; x < matrix_size.x() ; x++) {
      offset_y = 0;
      for(int y = 0 ; y < matrix_size.y() ; y++) {
        float component = noise(offset_x,offset_y);
        matrix[x][y] = component;
        offset_y += matrix_inc.x();
      }
      offset_x += matrix_inc.x();
    }
  }

  
  private float change_angle_component(float value, float angle) {
    float buf = value * TAU + angle;
    float temp = buf%TAU;
    if(temp < 0)
      temp = TAU - temp;
    return(map(temp, 0, TAU, 0, 1));
  }

  /**
   * 
   */
  public void build_matrix_noise_xyz() {
    matrix_3 = new vec3[matrix_size.x()][matrix_size.y()];
    vec3 offset_x = new vec3();
    vec3 offset_y = new vec3();
    noiseSeed((int)random(MAX_INT));

    float angle_x = 0;
    float angle_y = 0;
    float angle_z = 0;
    if(mat_angle != null) {
      angle_x = mat_angle[0];
      angle_y = mat_angle[1];
      angle_z = mat_angle[2];
    }
    for(int x = 0 ; x < matrix_size.x() ; x++) {
      offset_y.set(0);
      for(int y = 0 ; y < matrix_size.y() ; y++) {
        float cx, cy, cz = 0;
        if(mat_angle != null) {
          float ref = noise(offset_x.x(),offset_y.x());
          cx = change_angle_component(ref, angle_x);
          cy = change_angle_component(ref, angle_y);
          cz = change_angle_component(ref, angle_z);
        } else {
          cx = noise(offset_x.x(),offset_y.x());
          cy = noise(offset_x.y(),offset_y.y());
          cz = noise(offset_x.z(),offset_y.z());
        }
        matrix_3[x][y] = new vec3(cx,cy,cz);
        offset_y.add(matrix_inc);
      }
      offset_x.add(matrix_inc);
    }
  }

  /**
   * 
   * @param src
   * @param type
   */
  public void build_matrix(PImage src, int type) {
    if(type == HSB || type == RGB) {
      build_matrix_xyz(src, type);
    } else {
      build_matrix_mono(src, type);
    }
  }

  private void build_matrix_mono(PImage src, int type) {
    matrix = new float[src.width][src.height];
    for (int x = 0 ; x < src.width ; x++) {
      for (int y = 0 ; y < src.height ; y++) {
        if(type == RED) 
          matrix[x][y] = red(src.get(x,y)) / this.pa.g.colorModeX;
        else if(type == GREEN) 
          matrix[x][y] = green(src.get(x,y)) / this.pa.g.colorModeY;
        else if(type == BLUE)
          matrix[x][y] = blue(src.get(x,y)) / this.pa.g.colorModeZ;
        else if(type == HUE)
          matrix[x][y] = hue(src.get(x,y)) / this.pa.g.colorModeX;
        else if(type == SATURATION)
          matrix[x][y] = saturation(src.get(x,y)) / this.pa.g.colorModeY;
        else if(type == BRIGHTNESS)
          matrix[x][y] = brightness(src.get(x,y)) / this.pa.g.colorModeZ;
        else
          matrix[x][y] = brightness(src.get(x,y)) / this.pa.g.colorModeZ;
      }
    }
  }

  private void build_matrix_xyz(PImage src, int type) {
    matrix_3 = new vec3[src.width][src.height];
    for (int x = 0 ; x < src.width ; x++) {
      for (int y = 0 ; y < src.height ; y++) {
        matrix_3[x][y] = new vec3();
        if(type == RGB) {
          matrix_3[x][y].x(red(src.get(x,y)) / this.pa.g.colorModeX);
          matrix_3[x][y].y(green(src.get(x,y)) / this.pa.g.colorModeY);
          matrix_3[x][y].z(blue(src.get(x,y)) / this.pa.g.colorModeZ);
        } else if(type == HSB) {
          matrix_3[x][y].x(hue(src.get(x,y)) / this.pa.g.colorModeX);
          matrix_3[x][y].y(saturation(src.get(x,y)) / this.pa.g.colorModeY);
          matrix_3[x][y].z(brightness(src.get(x,y)) / this.pa.g.colorModeZ);
        }
      }
    }
  }
  
  private float smooth_mono(float x, float y) {
    //get fractional part of x and y
    int w = this.matrix.length;
    int h = this.matrix[0].length;
    float fract_x = fract(x);
    float fract_y = fract(y);
    //wrap around
    int x1 = ((int)x + w) % w;
    int y1 = ((int)y + h) % h;
    //neighbor values
    int x2 = (x1 + w - 1) % w;
    int y2 = (y1 + h - 1) % h;
    //smooth the noise with bilinear interpolation
    float value = 0;
    value += fract_x * fract_y * this.matrix[x1][y1];
    value += (1 - fract_x) * fract_y * this.matrix[x2][y1];
    value += fract_x * (1 - fract_y) * this.matrix[x1][y2];
    value += (1 - fract_x) * (1 - fract_y) * this.matrix[x2][y2];
    return value;
  }
  
  private vec3 smooth_xyz(float x, float y) {
    //get fractional part of x and y
    int w = matrix_3.length;
    int h = matrix_3[0].length;
    float fract_x = fract(x);
    float fract_y = fract(y);
    //wrap around
    int x1 = ((int)x + w) % w;
    int y1 = ((int)y + h) % h;
    //neighbor values
    int x2 = (x1 + w - 1) % w;
    int y2 = (y1 + h - 1) % h;
    //smooth the noise with bilinear interpolation
    float vx = 0;
    float vy = 0;
    float vz = 0;
    vx += fract_x * fract_y * matrix_3[x1][y1].x();
    vx += (1 - fract_x) * fract_y * matrix_3[x2][y1].x();
    vx += fract_x * (1 - fract_y) * matrix_3[x1][y2].x();
    vx += (1 - fract_x) * (1 - fract_y) * matrix_3[x2][y2].x();

    vy += fract_x * fract_y * matrix_3[x1][y1].y();
    vy += (1 - fract_x) * fract_y * matrix_3[x2][y1].y();
    vy += fract_x * (1 - fract_y) * matrix_3[x1][y2].y();
    vy += (1 - fract_x) * (1 - fract_y) * matrix_3[x2][y2].y();

    vz += fract_x * fract_y * matrix_3[x1][y1].z();
    vz += (1 - fract_x) * fract_y * matrix_3[x2][y1].z();
    vz += fract_x * (1 - fract_y) * matrix_3[x1][y2].z();
    vz += (1 - fract_x) * (1 - fract_y) * matrix_3[x2][y2].z();
    return new vec3(vx,vy,vz);
  }

  private float turbulence(float x, float y) {
    float value = 0;
    float buf_smooth = this.smooth;
    while(this.smooth >= 1) {
      value += this.smooth_mono(x / this.smooth, y / this.smooth) * this.smooth;
      this.smooth /= 2.0f;
    }
    this.smooth = buf_smooth;
    return(128.0f * value / buf_smooth);
  }

  private vec3 turbulence_xyz(float x, float y) {
    vec3 value = new vec3();
    float buf_smooth = this.smooth;
    while(this.smooth >= 1) {
      value.add(smooth_xyz(x / this.smooth, y / this.smooth).mult(this.smooth));
      this.smooth /= 2.0;
    }
    this.smooth = buf_smooth;
    return value.mult(128.0f).div(buf_smooth);
  }


  // RENDERING
  /**
   * 
   * @param w
   * @param h
   * @return
   */
  public PGraphics map_mono(int w, int h) {
    if(w <= 0 || h <= 0)
      return null;
    PGraphics dst;
    this.pa.colorMode(RGB,255,255,255,255);
    float range_colour = this.pa.g.colorModeX;
    dst = this.pa.createGraphics(w,h);
    dst.beginDraw();
    dst.loadPixels();
    for (int x = 0; x < w; x++) {
      for (int y = 0; y < h; y++) {
        float buf_col = this.smooth_mono(x / this.smooth ,y / this.smooth);
        int c = color(buf_col * range_colour);
        int index = index_pixel_array(x, y, w);
        dst.pixels[index] = c;
      }
    }
    dst.updatePixels();
    dst.endDraw();
    return dst;
  }

  /**
   * 
   * @param w
   * @param h
   * @return
   */
  public PGraphics map_xyz(int w, int h) {
    if(w <= 0 || h <= 0)
      return null;
    PGraphics dst;
    this.pa.colorMode(RGB,255,255,255,255);
    float range_colour = this.pa.g.colorModeX;
    dst = this.pa.createGraphics(w,h);
    dst.beginDraw();
    dst.loadPixels();
    for (int x = 0; x < w; x++) {
      for (int y = 0; y < h; y++) {
        float [] buf_col = this.smooth_xyz(x / this.smooth ,y / this.smooth).array();
        float [] rgb = new float[3];
        for(int i = 0 ; i < 3 ; i++) {
          rgb[i] = buf_col[i] *range_colour;
        }
        int index = index_pixel_array(x, y, w);
        int c = color(rgb[0],rgb[1],rgb[2]);
        dst.pixels[index] = c;
      }
    }
    dst.updatePixels();
    dst.endDraw();
    return dst;
  }

  /**
   * 
   * @param w
   * @param h
   * @return
   */
  public PGraphics marble_mono(int w, int h) {
    if(w <= 0 || h <= 0)
      return null;
    PGraphics dst;
    float [] cm = getColorMode(false);
    this.pa.colorMode(RGB,255,255,255,255);
    float range_colour = this.pa.g.colorModeX;
    int w_mat = matrix.length;
    int h_mat = matrix[0].length;
    dst = this.pa.createGraphics(w,h);
    dst.beginDraw();
    dst.loadPixels();
    for (int x = 0; x < w; x++) {
      for (int y = 0; y < h; y++) {
        float buf_turb = this.turbulence(x, y);
        float buf_xy = x * this.period.x() / w_mat + y * this.period.y() / h_mat + this.turbulence * buf_turb / range_colour;
        float sin_buf = range_colour * abs(sin(buf_xy));
        int colour = (int)sin_buf;
        int index = index_pixel_array(x, y, w);
        int c = color(colour);
        dst.pixels[index] = c;
      }
    }
    dst.updatePixels();
    dst.endDraw();
    this.pa.colorMode((int)cm[0],cm[1],cm[2],cm[3],cm[4]);
    return dst;
  }

  /**
   * 
   * @param w
   * @param h
   * @return
   */
  public PGraphics marble_xyz(int w, int h) {
    if(w <= 0 || h<= 0)
      return null;
    PGraphics dst;
    float [] cm = getColorMode(false);
    this.pa.colorMode(RGB,255,255,255,255);
    float range_colour = this.pa.g.colorModeX;
    int w_mat = matrix.length;
    int h_mat = matrix[0].length;
    dst = this.pa.createGraphics(w,h);
    dst.beginDraw();
    dst.loadPixels();
    for (int x = 0; x < w; x++) {
      for (int y = 0; y < h; y++) {
        float [] buf_turb = this.turbulence_xyz(x, y).array();
        int [] rgb = new int[3];
        for(int i = 0 ; i < 3 ; i++) {
          float buf_xy = x * this.period.x() / w_mat + y * this.period.y() / h_mat + this.turbulence * buf_turb[i] / range_colour;
          float sin_buf = range_colour * abs(sin(buf_xy));
          rgb[i] = (int)sin_buf;
        }
        int index = index_pixel_array(x, y, w);
        int c = color(rgb[0],rgb[1],rgb[2]);
        dst.pixels[index] = c;
      }
    }
    dst.updatePixels();
    dst.endDraw();
    this.pa.colorMode((int)cm[0],cm[1],cm[2],cm[3],cm[4]);
    return dst;
  }
}
