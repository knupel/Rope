/**
* R_Brick_SVG
* v 0.2.0
* 2019-2021
* @author @stanlepunk
* @see https://github.com/StanLepunK/Rope
*/

package rope.svg;

import processing.core.PApplet;
import processing.core.PFont;
import processing.data.XML;
import rope.core.R_Image;
import rope.vector.vec4;

public class R_Brick_SVG extends R_Image {
    private String file_name ;
    private String brick_name = "no name" ;
    private String family_name = "no name" ;
    private String kind = "" ;
    private int ID ;


    // attribut font
    /**
    may be not here but in the class Text with the build method ???
    */
    private PFont font = null  ;
    private float size_font = MAX_INT;
    private int alignment = MAX_INT ;
    // private String sentence = null ;

    private String font_str = null ;
    private String font_size_str = null ;
    private String alignment_str = null ;
    private String font_unit_str = null ;
    /**
    may be not here but in the class Text with the build method ???
    */

    // attribut colour
    private int fill, stroke;
    private float strokeMitterlimit;
    private float strokeWeight;
    private float opacity, opacity_group;
    private boolean noStroke, noFill;

    // str
    private String fill_str = null;        
    private String stroke_str = null ;
    private String stroke_mitterlimit_str = null ;
    private String strokeWeight_str = null ;
    private String opacity_str = null ;

    private String clip_rule_str = null ;
    private String fill_rule_str = null ;

    private int width;
    private int height;
    private XML xml_brick ;
    private boolean style ;
    private String built_svg_file = "" ;


    public R_Brick_SVG(PApplet pa) {
      super(pa);
    }
   
    public R_Brick_SVG(PApplet pa, String header, boolean style, XML brick, int ID, String ancestral_name, String str_opacity_group, String [] styles) {
      super(pa);
      this.style = style ;
      this.ID = ID ;
      built_svg_file = header + brick.toString() + "</svg>" ;
      xml_brick = this.pa.parseXML(built_svg_file) ;
  
      brick_name = get_name(brick) ;
      family_name = ancestral_name + "_" + get_name(xml_brick) ;
      this.kind = get_kind_SVG(xml_brick) ;
      if(str_opacity_group != "none" && str_opacity_group != null) opacity_group = Float.valueOf(str_opacity_group.trim()).floatValue();
      else opacity_group = 1.0f;
      set_aspect(brick, styles) ;
    }


    private String get_kind_SVG(XML target) {
      String kind = "" ;
      if(target.getChild("path") != null ) kind = "path" ;
      else if(target.getChild("line")!= null ) kind = "line" ;
      else if(target.getChild("polyline")!= null ) kind = "polyline" ;
      else if(target.getChild("polygon")!= null ) kind = "polygon" ;
      else if(target.getChild("circle")!= null )kind = "circle" ;
      else if(target.getChild("ellipse")!= null ) kind = "ellipse" ;
      else if(target.getChild("rect")!= null ) kind = "rect" ;
      else if(target.getChild("text")!= null ) kind = "text" ;
      else if(target.getChild("g")!= null ) kind = "g" ;
      else kind = "no kind detected" ;
      return kind ;
    }
  
    String get_name(XML target) {
      String name = "no name" ;
      if(target.getString("id") != null) name = target.getString("id") ;
      return name ;
    }

    int get_id() {
      return ID;
    }

    public String get_family_name() {
      return this.family_name;
    }

    public String get_brick_name() {
      return this.brick_name;
    }

    public String get_kind() {
      return this.kind;
    }

    public int height() {
      return this.height;
    }

    public int width() {
      return this.width;
    }

    public XML get_xml_brick() {
      return this.xml_brick;
    }

    public PFont get_font() {
      return this.font;
    }

    public float get_size_font() {
      return this.size_font;
    }

    /**
    aspect original
    */
    private void set_aspect(XML target, String [] styles) {
      // catch attribut
      if(style) {
        // style tag from last Illustrator CC
        catch_attribut_by_style(target, styles) ;
      } else {
        // old data from illustrator CS
        catch_attribut(target) ;
      }
      


      // give attribut
      // font size
      if(font_size_str != null) {
        size_font = Float.parseFloat(font_size_str) ;
      }
      // font
      if(font_str != null) {
        String [] fontList = PFont.list() ;
        for(int i = 0 ; i < fontList.length ; i++) {
          if(font_str.equals(fontList[i])) {
            int size = 60 ;
            if(size_font != MAX_INT && size_font > size ) size = (int)size_font ;
            font = this.pa.createFont(fontList[i], size) ;
          }
        }
      }

      // fill
      if(fill_str == null) {
        fill = WHITE;
      } else if(fill_str.contains("none")) {
        noFill = true ;
      } else {
        String fill_temp = "" ;
        fill_temp = fill_str.substring(1) ;
        fill = unhex(fill_temp) ;
      }
      // stroke
      if(stroke_str == null) {
        stroke = MAX_INT ; 
      } else if(stroke_str.contains("none")) {
        noStroke = true;
      } else {
        String stroke_temp = "" ;
        stroke_temp = stroke_str.substring(1) ;
        stroke = unhex(stroke_temp) ;
      }
      // strokeWeight
      if(strokeWeight_str == null  || strokeWeight_str.contains("none")) strokeWeight = 1.0f; 
      else strokeWeight = Float.valueOf(strokeWeight_str.trim()).floatValue();
      // stroke mitter
      if(stroke_mitterlimit_str == null  || stroke_mitterlimit_str.contains("none")) strokeMitterlimit = 10; 
      else strokeMitterlimit = Float.valueOf(stroke_mitterlimit_str.trim()).floatValue();
      // opacity
      if(opacity_str == null || opacity_str.contains("none")) opacity = 1.0f; 
      else opacity = Float.valueOf(opacity_str.trim()).floatValue();
      if(opacity == 1.0f && opacity_group != 1.0f) opacity = opacity_group;
    }



    // super local method
    //
    // catch attribut classic SVG version 1
    private void catch_attribut(XML target) {
      fill_str =  target.getString("fill") ;        
      stroke_str =  target.getString("stroke") ;
      stroke_mitterlimit_str =  target.getString("stroke-mitterimit") ;
      strokeWeight_str =  target.getString("stroke-width") ;
      opacity_str =  target.getString("opacity") ;

      font_str = target.getString("font-family") ;
      font_size_str = target.getString("font-size") ;

      clip_rule_str = target.getString("clip-rule");
      // fill_rule_str = target.getString("fill-rule");
    }

    // catch attribut style SVG version 2
    private void catch_attribut_by_style(XML target, String [] styles) {
      String style_id = target.getString("class") ;
      // catch the style in the style list
      String [] id = split(style_id, "st") ;
      // clean white space in the String array, because for the class text there is few style, and there is white space between each one.
      if(id.length > 1) {
        for(int i = 0 ; i < id.length ;i++) {
          if(id[i].contains(" ")) id[i] = id[i].replaceAll(" ", "") ;
          if(i != 0) { 
            int which_style = Integer.parseInt(id[i]) ;
            String my_style = styles[which_style];
            if(my_style.contains("}") ) {
              my_style = my_style.replaceAll("}","") ;
            }
            if(my_style.contains("{")) {
              my_style = my_style.substring(1) ;
            }

            String [] attribut = split(my_style,";") ;
            // loop to check all component of style
            for(int k = 0 ; k < attribut.length ; k++) {
              if(attribut[k].contains("fill:")) {
                String [] final_data = attribut[k].split(":") ;
                fill_str = final_data[1] ;
              }
              if(attribut[k].contains("stroke:")) {
                String [] final_data = attribut[k].split(":") ;
                stroke_str = final_data[1] ;
              }
              if(attribut[k].contains("stroke-mitterlimit:")) {
                String [] final_data = attribut[k].split(":") ;
                stroke_mitterlimit_str = final_data[1] ;
              }
              if(attribut[k].contains("stroke-width:")) {
                String [] final_data = attribut[k].split(":") ;
                strokeWeight_str = final_data[1] ;
              }
              if(attribut[k].contains("opacity:")) {
                String [] final_data = attribut[k].split(":") ;
                opacity_str = final_data[1] ;
              }
              if(attribut[k].contains("font-family:")) {
                String [] final_data = attribut[k].split(":") ;
                font_str = final_data[1] ;
              }
              if(attribut[k].contains("font-size:")) {
                String [] final_data = attribut[k].split(":") ;
                font_size_str = final_data[1] ;
              }
              if(attribut[k].contains("clip-rule:")) {
                String [] final_data = attribut[k].split(":") ;
                clip_rule_str = final_data[1] ;
              }
              if(attribut[k].contains("fill-rule:")) {
                String [] final_data = attribut[k].split(":") ;
                fill_rule_str = final_data[1] ;
              }
            }
          }
        }
      }
      // clear
      if(font_str != null) {
        if(font_str.contains("'")) {
          font_str = font_str.replaceAll("'","") ;
        }
      } 
      
      // split size and unit type for font
      if(font_size_str != null) {
        if(font_size_str.endsWith("pt")) {
          font_unit_str = "pt" ;
          font_size_str = font_size_str.replaceAll("pt","") ; // * 1.25f;
        } else if (font_size_str.endsWith("pc")) {
          font_unit_str = "pc" ;
          font_size_str = font_size_str.replaceAll("pc","") ; // * 15;
        } else if (font_size_str.endsWith("mm")) {
          font_unit_str = "mm" ;
          font_size_str = font_size_str.replaceAll("mm","") ; // * 3.543307f;
        } else if (font_size_str.endsWith("cm")) {
          font_unit_str = "cm" ;
          font_size_str = font_size_str.replaceAll("cm","") ; // * 35.43307f;
        } else if (font_size_str.endsWith("in")) {
          font_unit_str = "in" ;
          font_size_str = font_size_str.replaceAll("in","") ; // * 90;
        } else if (font_size_str.endsWith("px")) {
          font_unit_str = "px" ;
          font_size_str = font_size_str.replaceAll("px","") ;
        } else if (font_size_str.endsWith("%")) {
          font_unit_str = "%" ;
          font_size_str = font_size_str.replaceAll("%","") ;
        }
      }
    }

    
    
    
    public void aspect_fill(vec4 factor) {
      // HSB mmode
      if(noFill) {
        noFill() ;
      } else {
        if(this.pa.g.colorMode == 3) {
          fill(hue(fill) *factor.x(), saturation(fill) *factor.y(), brightness(fill) *factor.z(), opacity *this.pa.g.colorModeA *factor.w()) ;
        // RGB mmode
        } else if(this.pa.g.colorMode == 1) {
          float red_col = red(fill) *factor.x();
          float alpha_col = opacity *this.pa.g.colorModeA *factor.w();
          alpha_col = opacity *this.pa.g.colorModeA *factor.w();
          fill(red_col, green(fill) *factor.y(), blue(fill) *factor.z(), alpha_col) ;
        }
      }
    }

    public void aspect_stroke(float scale, vec4 factor) {
      if(noStroke) {
        noStroke() ;
      } else {
        float thickness = strokeWeight ;
        if(scale != 1 ) thickness *= scale ;
        // HSB mmode
        if(this.pa.g.colorMode == 3) {
          if(strokeWeight <= 0 || stroke == MAX_INT )  {
            noStroke() ;
          } else {
            strokeWeight(thickness) ;
            stroke(hue(stroke) *factor.x(), saturation(stroke) *factor.y(), brightness(stroke) *factor.z(), opacity *this.pa.g.colorModeA *factor.w()) ; 
          }
        // RGB mmode
        } else if(this.pa.g.colorMode == 1 ) {
          if(strokeWeight <= 0 || stroke == MAX_INT)  {
            noStroke();
          } else {
            strokeWeight(thickness) ;
            stroke(red(stroke) *factor.x(), green(stroke) *factor.y(), blue(stroke) *factor.z(), opacity *this.pa.g.colorModeA *factor.w()) ; 
          }
        }
      }
    }
  }