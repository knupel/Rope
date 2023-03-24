/**
* R_Image
* v 0.4.1
* 2019-2023
* @author @stanlepunk
* @see https://github.com/StanLepunK/Rope
*/

package rope.image;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PGraphics;
import rope.core.BigBang;

public class R_Image extends BigBang {
  private PImage img;
  private String name = "my name is nobody";
  private int id = -1;



  public R_Image(PApplet pa) {
    super(pa);
    generate_id();
  }

  /**
   * 
   * @param pa
   * @param path
   */
  public R_Image(PApplet pa, String path) {
  	super(pa);
    this.name = path.split("/")[path.split("/").length -1].split("\\.")[0];
    this.img = loadImage(path);
    generate_id();
  }

  /**
   * 
   * @param pa
   * @param img
   */
  public R_Image(PApplet pa, PImage img) {
  	super(pa);
    this.img = img;
    generate_id();
  }

  /**
   * 
   * @param pa
   * @param img
   * @param name
   */
  public R_Image(PApplet pa, PImage img, String name) {
  	super(pa);
    this.img = img;
    this.name = name;
    generate_id();
  }


  private void generate_id() {
    this.id = (int)random(MAX_INT);
  }

  /**
   * 
   * @param pa
   * @param img
   * @param name
   * @param id
   */
  public R_Image(PApplet pa, PImage img, String name, int id) {
  	super(pa);
    this.img = img;
    this.name = name;
    this.id = id;
  }

  public int width() {
    return this.img.width;
  }

  public int height() {
    return this.img.height;
  }
  

  // get
  public R_Image get() {
    return this;
  }

  @Deprecated
  public PImage get_pimage() {
    return img;
  }

  public PImage get_PImage() {
    return img;
  }

  // id
  public int get_id() {
    return id;
  }

  public R_Image set_id(int id) {
    this.id = id;
    return this;
  }

  // name
  public String get_name() {
    return name;
  }

  public R_Image set_name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Resize image to window size
   */
  public void resize() {
    resize(pa.g,true);
  }
  
  /**
   * Resize image around window sketch width, height or both depend of the boolean fullfit value.
   * @param fullfit
   */
  public void resize(boolean fullfit) {
    resize(pa.g, fullfit);
  }
  
  /**
   * Resize image around PGraphics window width, height or both depend of the boolean fullfit value.
   * @param fullfit
   */
  public void resize(PGraphics pg, boolean fullfit) {
    resize(pg.width, pg.height, fullfit);
  }

  /**
   * Resize image to target_width and target_height.
   */
  public void resize(int target_width, int target_height) {
    resize(target_width, target_height, true);
  }
  
  /**
   * Resize image with target_width, target_height value or both depend of the boolean fullfit value.
   * @param fullfit
   */
  public void resize(int target_width, int target_height, boolean fullfit) {
    if(target_width == this.img.width && target_height != this.img.height) {
      return;
    }

    float ratio_w = target_width / (float)this.img.width;
    float ratio_h = target_height / (float)this.img.height;
    if(!fullfit) {
      if(ratio_w > ratio_h) {
        this.img.resize(ceil(this.img.width *ratio_w), ceil(this.img.height *ratio_w));
      } else {
        this.img.resize(ceil(this.img.width *ratio_h), ceil(this.img.height *ratio_h));  
      }
    } else {
      this.img.resize(ceil(this.img.width *ratio_w), ceil(this.img.height *ratio_h));
    }
  }
}
