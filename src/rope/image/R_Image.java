/**
* R_Image
* v 0.3.0
* 2019-2021
* @author @stanlepunk
* @see https://github.com/StanLepunK/Rope
*/

package rope.image;

import processing.core.PApplet;
import processing.core.PImage;
import rope.core.BigBang;

public class R_Image extends BigBang {
  private PImage img ;
  private String name = "my name is nobody";
  private int id = -1;

  /**
   * 
   * @param pa
   * @param path
   */
  public R_Image(PApplet pa, String path) {
  	super(pa);
    this.name = path.split("/")[path.split("/").length -1].split("\\.")[0];
    this.img = loadImage(path);
    this.id = (int)random(MAX_INT);
  }

  /**
   * 
   * @param pa
   * @param img
   */
  public R_Image(PApplet pa, PImage img) {
  	super(pa);
    this.img = img;
    this.id = (int)random(MAX_INT);
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
  

  // get
  public R_Image get() {
    return this;
  }

  @Deprecated
  public PImage get_pimage() {
    return img ;
  }

  public PImage get_PImage() {
    return img ;
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
    return name ;
  }

  public R_Image set_name(String name) {
    this.name = name;
    return this;
  }
}
