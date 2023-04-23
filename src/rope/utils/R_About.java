/**
 *   ___      ___   ____   _______
 *  | -  \   /   \  |    \ |  ___/
 *  | |/  | |   \ | | |\ | |  |__
 *  |    /  | | | | | |  / |  __/
 *  | |  \  \ \   / |  |/  |  |____
 *  |_| \_\  \___/  |_ |   |______/
 * 
 * collection of function can be use with out Processing.
 * 
 * 
 * WITHOUT PROCESSING ONLY JAVA
 * 
 * 
 * @author @knupel
 * @see https://github.com/knupel/Rope
 * 2023-2023
 * v 0.0.1
 * 
 * 
 * 
 * The class R_About have goal to provide function to set text information about your artwork
 * 
 * 
 */


package rope.utils;

import java.util.Date;
import java.time.LocalDate;

public class R_About {

  public R_About () {}

  public String signature(String separation, String author) {
    LocalDate ld = LocalDate.now();
    int year = ld.getYear();
    String signature = "" + author + separation + String.valueOf(year);
    return signature;
  }

  public String stamp() {
    Date d = new Date();
    long stamp = d.getTime();
    String str = "" + String.valueOf(stamp);
    return str;
  }

  public String title(String separation, String... words) {
    Date d = new Date();
    String signature = "";
    int len = words.length;
    for(int i = 0 ; i < len - 1 ; i++) {
      String elem = "" + words[i] + separation;
      signature += elem;
    }
    signature += words[len -1];
    return signature;
  }
}
