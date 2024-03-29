/**
* R_Image_MAnager
* v 0.3.0
* 2019-2022
* @author @stanlepunk
* @see https://github.com/StanLepunK/Rope
*/

package rope.image;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;
import rope.core.BigBang;

public class R_Image_Manager extends BigBang {
  ArrayList<R_Image> library;
  int which_img;

  public R_Image_Manager(PApplet pa) {
  	super(pa);
  }

  private void build() {
    if(library == null) {
      library = new ArrayList<R_Image>();
    }
  }

  public void load(String... path_img) {
    build();
    for(int i = 0 ; i <path_img.length ; i++) {
      String [] temp = path_img[i].split("/");
      PImage img = loadImage(path_img[i]);
      R_Image rop_img = new R_Image(this.pa, img,temp[temp.length-1],i);
      library.add(rop_img);
    }  
  }

  // ADD
  public void add(R_Image r_img) {
    build();
    library.add(r_img);
  }

  public void add(PImage img_src) {
    build();
    R_Image rop_img = new R_Image(this.pa, img_src, "unknow");
    library.add(rop_img);
  }

  public void add(PImage img_src, int index) {
    R_Image rop_img = new R_Image(this.pa, img_src, "unknow");
    library.add(index, rop_img);
  }

  public void add(PImage img_src, String name) {
    build();
    R_Image rop_img = new R_Image(this.pa, img_src, name);
    library.add(rop_img);
  }

  public void add(PImage img_src, String name, int index) {
    build();
    R_Image rop_img = new R_Image(this.pa, img_src, name);
    library.add(index, rop_img);
  }





  /**
   * clear the list to start a new collection or not !
   */
  public void clear() {
    if(library != null) {
      library.clear();
    }
  }


  /**
   * 
   * @param which_one
   * choice the current image for the future !
   */
  public void select(int which_one) {
    which_img = which_one ;
  }

  /**
   * 
   * @param target_name
  * choice the current image for the future !
   */
  public void select(String target_name) {
    if(library.size() > 0) {
      for(int i = 0 ; i < library.size() ; i++) {
        if(target_name.equals(library.get(i).get_name())) {
          which_img = i ;
          break ;
        }
      }
    } else {
      String mess = ANSI_RED+"The String target name don't match with any name of image library"+ANSI_WHITE+" target name:"+target_name;
      System.err.println(mess) ;
    }
  }

  /**
   * 
   * @param index
   * remove image from the collection if this one is available.
   */
  public void remove(int index) {
    if(library != null) {
      library.remove(index);
    }
  }

  /**
   * 
   * @return the size of the image collection
   */
  public int size() {
    if(library != null) {
      return library.size() ;
    } else return -1 ;  
  }

  // SET
  public void set(R_Image r_img, int index) {
    if(index < library.size() && index >= 0) {
      set(r_img.get_PImage(), index);
      library.get(index).set_name(r_img.get_name());
      library.get(index).set_id(r_img.get_id());
    }
  }

  public void set(PImage src_img, int index) {
    build();
    if(index < library.size() && index >= 0) {
      if(src_img.width == get(index).width() && src_img.height == get(index).height()){
        get_PImage(index).pixels = src_img.pixels ;
        get_PImage(index).updatePixels();
      } else {
        get(index).resize(src_img.width, src_img.height);
        get_PImage(index).pixels = src_img.pixels ;
        get_PImage(index).updatePixels();
      }
    } else {
      String mess = ANSI_RED+"Neither target image match with your request"+ANSI_WHITE+" target: "+index;
      System.err.println(mess);
    }
  }

  public void set(PImage src_img, String target_name) {
    build();
    if(library.size() > 0) {
      if(src_img.width == get(target_name).width() && src_img.height == get(target_name).height()){
        get_PImage(target_name).pixels = src_img.pixels ;
        get_PImage(target_name).updatePixels();
      } else {
        get_PImage(target_name).resize(src_img.width, src_img.height);
        get_PImage(target_name).pixels = src_img.pixels ;
        get_PImage(target_name).updatePixels();
      }
    } else {
      String mess = ANSI_RED+"Neither target name image match with your request"+ANSI_WHITE+" target name:"+target_name;
      System.err.println(mess);
    }
  }

  // LIST
  public ArrayList<R_Image> list() {
    return library;
  }

  /**
   * 
   * @return a random R_Image from the list
   */
  public R_Image rand() {
    if(library != null && library.size() > 0) {
      int target = floor(random(library.size()));
      return library.get(target);
    } else return null;
  }


  // GET
  public String get_current_name() {
    return get_name(which_img);
  }

  public String get_name(int index) {
    if(library != null && library.size() > 0) {
      if(index < library.size()) {
        return library.get(index).get_name() ;
      } else return null ;
    } else return null ;
  }

  public Long get_id(int index) {
    if(library != null && library.size() > 0) {
      if(index < library.size()) {
        return Long.valueOf(library.get(index).get_id());
      } else return null;
    } else return null;
  }

  public int get_rank(String target_name) {
    if(library != null && library.size() > 0) {
      int rank = 0 ;
      for(int i = 0 ; i < library.size() ; i++) {
        String final_name = target_name.split("/")[target_name.split("/").length -1].split("\\.")[0] ;
        if(final_name.equals(library.get(i).get_name()) ) {
          rank = i ;
          break;
        } 
      }
      return rank;
    } else return -1;
  }

  /**
   * 
   * @return an array of RImage available
   */
  R_Image [] get() {
    if(library != null && library.size() > 0) {
      return library.toArray(new R_Image[library.size()]);
    } else return null;
  }

    /**
   * 
   * @return the current R_Image
   */
  public R_Image get_current() {
    if(library != null && library.size() > 0 ) {
      if(which_img < library.size()) return library.get(which_img); 
      else return library.get(0); 
    } else return null ;
  }
  

  /**
   * 
   * @param target
   * @return return a specific R_Image from the list is this one exist
   */
  public R_Image get(int target){
    if(library != null && target >= 0 && target < library.size()) {
      return library.get(target);
    } else return null;
  }

  /**
   * 
   * @param target_name
   * @return return a specific R_Image from the list is this one exist
   */
  public R_Image get(String target_name){
    if(library.size() > 0) {
      int target = 0 ;
      for(int i = 0 ; i < library.size() ; i++) {
        String final_name = target_name.split("/")[target_name.split("/").length -1].split("\\.")[0] ;
        if(final_name.equals(library.get(i).get_name()) ) {
          target = i ;
          break;
        } 
      }
      return get(target);
    } else return null;
  }

  // get PImage

  /**
   * 
   * @return the current PImage
   */
  public PImage get_current_PImage() {
    if(library != null && library.size() > 0 ) {
      if(which_img < library.size()) return library.get(which_img).get_PImage(); 
      else return library.get(0).get_PImage(); 
    } else return null ;
  }
  
  /**
   * 
   * @param target
   * @return return a specific PImage from the list is this one exist
   */
  public PImage get_PImage(int target){
    if(library != null && target >= 0 && target < library.size()) {
      return library.get(target).get_PImage();
    } else return null;
  }

  /**
   * 
   * @param target_name
   * @return return a specific PImage from the list is this one exist
   */
  public PImage get_PImage(String target_name){
    if(library.size() > 0) {
      int target = 0 ;
      for(int i = 0 ; i < library.size() ; i++) {
        String final_name = target_name.split("/")[target_name.split("/").length -1].split("\\.")[0] ;
        if(final_name.equals(library.get(i).get_name()) ) {
          target = i ;
          break;
        } 
      }
      return get_PImage(target);
    } else return null;
  }
}

