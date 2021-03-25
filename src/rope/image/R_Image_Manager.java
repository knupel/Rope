/**
* R_Image_MAnager
* v 0.2.0
* 2019-2021
* @author @stanlepunk
* @see https://github.com/StanLepunK/Rope
*/

package rope.image;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;
import rope.core.BigBang;

public class R_Image_Manager extends BigBang {
  ArrayList<R_Image> library ;
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

  public void add(PImage img_src) {
    build();
    R_Image rop_img = new R_Image(this.pa, img_src, "unknow" ,library.size());
    library.add(rop_img);
  }

  public void add(PImage img_src, String name) {
    build();
    R_Image rop_img = new R_Image(this.pa, img_src, name, library.size());
    library.add(rop_img);
  }

  public void clear() {
    if(library != null) {
      library.clear();
    }
  }



  public void select(int which_one) {
    which_img = which_one ;
  }

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


  public int size() {
    if(library != null) {
      return library.size() ;
    } else return -1 ;  
  }

  public void set(PImage src_img, int target) {
    build();
    if(target < library.size()) {
      if(src_img.width == get(target).width && src_img.height == get(target).height){
        get(target).pixels = src_img.pixels ;
        get(target).updatePixels();
      } else {
        get(target).resize(src_img.width, src_img.height);
        get(target).pixels = src_img.pixels ;
        get(target).updatePixels();
      }
    } else {
      String mess = ANSI_RED+"Neither target image match with your request"+ANSI_WHITE+" target: "+target;
      System.err.println(mess);
    }
  }

  public void set(PImage src_img, String target_name) {
    build();
    if(library.size() > 0) {
      if(src_img.width == get(target_name).width && src_img.height == get(target_name).height){
        get(target_name).pixels = src_img.pixels ;
        get(target_name).updatePixels();
      } else {
        get(target_name).resize(src_img.width, src_img.height);
        get(target_name).pixels = src_img.pixels ;
        get(target_name).updatePixels();
      }
    } else {
      String mess = ANSI_RED+"Neither target name image match with your request"+ANSI_WHITE+" target name:"+target_name;
      System.err.println(mess);
    }
  }

  public String get_current_name() {
    return get_name(which_img);
  }

  public String get_name(int target) {
    if(library != null && library.size() > 0) {
      if(target < library.size()) {
        return library.get(target).get_name() ;
      } else return null ;
    } else return null ;
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
  

  public ArrayList<R_Image> list() {
    return library;
  }

  R_Image [] get() {
    if(library != null && library.size() > 0) {
      return library.toArray(new R_Image[library.size()]);
    } else return null;
  }

 
  public PImage get_current() {
    if(library != null && library.size() > 0 ) {
      if(which_img < library.size()) return library.get(which_img).get_pimage(); 
      else return library.get(0).get_pimage(); 
    } else return null ;
  }
  

  public PImage get(int target){
    if(library != null && target >= 0 && target < library.size()) {
      return library.get(target).get_pimage();
    } else return null;
  }

  public PImage get(String target_name){
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


  public R_Image rand() {
    if(library != null && library.size() > 0) {
      int target = floor(random(library.size()));
      return library.get(target);
    } else return null;
  }
}

