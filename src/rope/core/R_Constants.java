
/**
 * * R_Constants
	* ROPE - ROmanesco Processing Environment – 
	* Copyleft (c) 2014-2021
	* Variable shared throughout rope.core.
	* *
	* Rope constants
	* v 1.0.0
	* Processing 3.5.4
	* @author @stanlepunk
	* @see https://github.com/StanLepunK/Rope
	* @see https://en.wikipedia.org/wiki/Mathematical_constant
	*/

package rope.core;
import java.awt.event.KeyEvent;

public interface R_Constants {
	static final String VERSION = "0.12.2.42";

	static final String P2D = "processing.opengl.PGraphics2D";
	static final String P3D = "processing.opengl.PGraphics3D";
	static final String JAVA2D = "processing.awt.PGraphicsJava2D";
	static final String FX2D = "processing.javafx.PGraphicsFX2D";
	static final String PDF = "processing.pdf.PGraphicsPDF";
	static final String SVG = "processing.svg.PGraphicsSVG";
	static final String DXF = "processing.dxf.RawDXF";

	static final int BEZIER_VERTEX = 1; // processing value
	static final int QUADRATIC_VERTEX = 2; // processing value
	static final int CURVE_VERTEX = 3; // processing value
	static final int BREAK = 4; // processing value

	static final int VERTEX = 0; // processing value

  static final int POINT = 2; // processing value

  static final int LINE = 4; // processing value

  static final int TRIANGLE = 8; // processing value
  static final int SQUARE = 14;
  static final int PENTAGON = 15;
  static final int HEXAGON = 16;
  static final int HEPTAGON = 17;
  static final int OCTOGON = 18;
  static final int NONAGON = 19;
  static final int DECAGON = 20;
  static final int HENDECAGON = 21;
  static final int DODECAGON = 22;

	static final int TEXT = 26;

  static final int RECT = 30; // processing value
  static final int ELLIPSE = 31; // processing value
  static final int ARC = 32;  // processing value

  static final int SPHERE = 40; // processing value
  static final int BOX = 41; // processing value

  static final int CROSS_RECT = 52;
  static final int CROSS_BOX_2 = 53;
  static final int CROSS_BOX_3 = 54;

  static final int SPHERE_LOW = 100;
  static final int SPHERE_MEDIUM = 101;
  static final int SPHERE_HIGH = 102;
  static final int TETRAHEDRON = 103;

  static final int PIXEL = 800;

  static final int STAR = 805;
  static final int STAR_3D = 806;

  static final int FLOWER = 900;

  static final int TETRAHEDRON_LINE = 1001;
  static final int CUBE_LINE = 1002;
  static final int OCTOHEDRON_LINE = 1003;
  static final int RHOMBIC_COSI_DODECAHEDRON_SMALL_LINE = 1004;
  static final int ICOSI_DODECAHEDRON_LINE = 1005;

  static final int HOUSE = 2000;

  static final int VIRUS = 88_888_888;
	/**
	 * 
	 * Processing CONSTANTS
	 */
  static final int OPEN = 1; // processing value
  static final int CLOSE = 2; // processing value



  
  
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
	

	  // shape drawing modes
  static final int CORNER   = 0; // processing value
  static final int CORNERS  = 1; // processing value
  static final int RADIUS   = 2; // processing value
  static final int DIAMETER = 3; // processing value

	static final int CENTER   = 3; // processing value

  static final int TOP = 101;
  static final int BOTTOM = 102;

	/**
	 * KeyEvent.VK
	 * shift:     16
	 * control:   17
	 * alt:       18
	 * meta:      157
	 * enter:     10
	 * backspace: 8
	 * escape:    27
	 * left:      37
	 * up:        38
	 * right:     39
	 * down:      40
	 * pg_down:   34
	 * pg_up:     33
	 * a:         65
	 * >>>
	 * z:         90
	 * space:     32
	 * tab:       9
	 */
  static final int UP	= KeyEvent.VK_UP; // 38
  static final int DOWN	= KeyEvent.VK_DOWN; // 40
  static final int LEFT	= KeyEvent.VK_LEFT; // 37
  static final int RIGHT = KeyEvent.VK_RIGHT; // 39


	


	static final int RGB   = 1;  // image & color // processing value
	static final int ARGB  = 2;  // image // processing value
	static final int RGBA  = 2;  // image // processing value
	static final int HSB   = 3;  // color // processing value
	static final int ALPHA = 4;  // image // processing value

	static final int HUE = 50;
	static final int SATURATION = 51;
	static final int BRIGHTNESS = 52;


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


	




	static final String SIN = "SIN" ;
	static final String COS = "COS" ;
	static final String TAN = "TAN" ;
	static final String TRIG_0 = "SIN_TAN" ;
	static final String TRIG_1 = "SIN_TAN_COS" ;
	static final String TRIG_2 = "SIN_POW_SIN" ;
	static final String TRIG_3 = "POW_SIN_PI" ;
	static final String TRIG_4 = "SIN_TAN_POW_SIN" ;
}

