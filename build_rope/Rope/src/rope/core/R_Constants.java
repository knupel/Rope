
/**
	* ROPE - ROmanesco Processing Environment – 
	* Copyleft (c) 2014-2020
	* Variable shared throughout rope.core.
	* Rope constants
	* v 0.2.0.8
	* Processing 3.5.3
	* @author @stanlepunk
	* @see http://stanlepunk.xyz/
	* @see https://github.com/StanLepunK/Rope
	* @see https://en.wikipedia.org/wiki/Mathematical_constant
	*/

package rope.core;

public interface R_Constants {
	static final String VERSION = "0.8.7.33";
	/**
	 * 
	 * Processing CONSTANTS
	 */
  static final int OPEN = 1;
  static final int CLOSE = 2;


  // shape drawing modes
  static final int CORNER   = 0;
  static final int CORNERS  = 1;
  static final int RADIUS   = 2;
  static final int CENTER   = 3;
  static final int DIAMETER = 3;
  
  
  static final int RAND = 2456417;
	
  static final float MAX_FLOAT = Float.MAX_VALUE;
  static final float MIN_FLOAT = -Float.MAX_VALUE;
  static final int MAX_INT = Integer.MAX_VALUE;
  static final int MIN_INT = Integer.MIN_VALUE;
  
	static final float PI = (float) Math.PI;
	static final float TWO_PI = (float) (2.0 * Math.PI);
	static final float TAU = (float) (2.0 * Math.PI);
  
  /**
   * Rope CONSTANTS 
   */
	static final int  NOTHING = 0;
	static final int  NONE = 0;
	static final int  NULL = 0;
	
	static final float PHI = (1 + (float)Math.sqrt(5))/2; //a number of polys use the golden ratio... > 1.618....
	static final float GOLD_NUMBER = PHI;
	static final float GOLD_ANGLE = (float)(2*Math.PI) / (PHI*PHI); // > 137.500 in degree
	static final float ROOT2 = (float)Math.sqrt(2); //...and the square root of two, the famous first irrationnal number by Pythagore
	static final float EULER = (float)2.718281828459045235360287471352; // Euler number constant
	static final double G = 0.00000000006693; // last gravity constant
	
	
  //for the unicity value we note the angle between -PI to PI from atan2
	static final float NORTH = (float)(-(PI *0.5));
	static final float NORTH_EAST = (float)(-PI *0.25);
	static final float EAST = 0;
	static final float SOUTH_EAST = (float)(PI *0.25);
	static final float SOUTH = (float)(PI *0.5);
	static final float SOUTH_WEST = (float)((3*PI)*0.25);
	static final float WEST = PI;
	static final float NORTH_WEST = (float)(-(3*PI)*0.25);
	
	// classic angle notation
  // float north = HALF_PI;
  // float north_east = QUARTER_PI;
  // float east = PI;
  // float south_east = (7*PI)*0.25;
  // float south = (3*PI)*0.5;
  // float south_west = (5*PI)*0.25;
  // float west = 0;
  // float north_west = (3*PI)*0.25;

	

	static final int HUE = 50;
	static final int SATURATION = 51;
	static final int BRIGHTNESS = 52;

	static final int ALPHA = 100 ;

	static final int FLUID = 200;
	static final int GRAVITY = 201;
	static final int MAGNETIC = 202;

	static final int BLANK = 300;
	static final int PERLIN = 301;
	static final int CHAOS = 302;
	static final int ORDER = 303;
	static final int EQUATION = 304;

	static final int DRAW = 400;
	static final int FIT = 450;
	static final int SCALE = 451;

	static final int CARTESIAN = 500;
	static final int POLAR = 501 ;
	
  static final int HORIZONTAL = 550;
  static final int VERTICAL = 551;
  static final int DIAGONAL = 552;
  static final int CIRCULAR = 553;

	static final int MIX = 600 ;

	static final int STATIC = 1000;
	static final int DYNAMIC = 1001;


	/**
	GRAPHIC
	*/
	static final int PIXEL = 800;
	static final int STAR = 805;
	  
	




	static final String SIN = "SIN" ;
	static final String COS = "COS" ;
	static final String TAN = "TAN" ;
	static final String TRIG_0 = "SIN_TAN" ;
	static final String TRIG_1 = "SIN_TAN_COS" ;
	static final String TRIG_2 = "SIN_POW_SIN" ;
	static final String TRIG_3 = "POW_SIN_PI" ;
	static final String TRIG_4 = "SIN_TAN_POW_SIN" ;
}

