\* version 50

> Go to Java 17
> Go to Processing 4.2

> VECTOR
> remove jitter from all vec
> add function abs to vec2, vec3, vec3, ivec2, ivec3, ivec4

> R_Impact
> add polygon to show the peripheric polygon and display on all the window.
> add function to create gradient, for thickness, fill and stroke use_gradient_fill(), use_gradient_stroke(), use_gradient_thivkness()
> add function boolean build_is() to check is OBject is build or not
> add function heart_is(), heart_is(boolean is)
> remove set_heart(int level);
> add function to set approximativ diameter set_diam(int value)
> add function to get the diameter value diam()
> @Deprecated constructor without position and diameter


> R_Graphic
> add function stroke_is(), fill_is() to set if stroke(), strokeWeight() and fill() is active
> add function clear() from Processing



> R_SVG
> remove the calling function jitter(), instead use random_next_gaussian() function


> R_Shape
> add function length() thant return the num of summits like get_summits()

> R_Rope
> improve function in_polygon() for the marge detection, now the detection is divide on 3 results : out, border and in polygon


\* version 49

> add class R_FX and remove from the Rope frameWork

> R_Puppet2D new class to manipulater puppets point with two handles, it's an extands of R_Line2D

> R_Impact new class to creata a pseudo deisgn of glass impact network

> R_Voronoi
> add function get_polygon(int index) and get_poygons() to create a same spirit than R_Impact

> R_Pair new class to store quickly acouple of object

> bvec
> add function all(), any() and only() like glsl language

> ivec
> add function compare() to ivec2, ivec3, ivec4


> vec
> add function compare(vec arg, float arg)
> Deprecated jitter() function in vec2, vec3 and vec4

> vec2
> add function ortho() to create an an orthographic projection of the point on the vector line
> change function in_line() to in_segment()

> Rope
> add function boolean in_line who check all the point on the line not only in segment.
> add function boolean in_segment() who accept R_Line2D for the coord line
> add function boolean in_polygon() who accept R_Shape for the coord points
> add function compare for float, int, vec and ivec
> add function map with vec2, vec3 and vec3 as entry
> add function String get_renderer(PGragrichs pg) to return the type of Graphics Processing is used / to complete BigBang function
> add float [] getColorMode(PGraphics pg) and float [] getColorMode(PGraphics pg, boolean print_info_is) to complete BigBang function

> R_Shape
> add area function, only work with regular polygon / shape don't use a strange stuff with it.
> add set_point(int index, float x, float y, float z) to replace a specific point
> add fonction ArrayList<vec3> equals(vec... points) return the list of the common point
> add fonction boolean equals(int max, vec... points) return true if the num of commom point is equal or upper to max;
> add fonction ArrayList<vec3> compare(float marge, vec... points) return the list of the common point
> add fonction boolean compare(int max, float marge, vec... points) return true if the num of commom point is equal or upper to max;
>add function barycenter()
> add id ivec6 to store until to 6 id integer
> add function show() to show the points, not the ref_points one

> R_Line2D
> add function barycenter()
> add id ivec6 to store until to 6 id integer
> add function pointer(), pointer_a(), pointer_b() to use line with pointer coordinate in memory, like i "C"
> pass the vec, from vec2 to vec3 for the management and the bridge withe R_Shape
> add function normal() to catch the normal position in or on the line if this is on it.
> add ortho(vec2 p) to create a orthographic projection of the point on the line

> R_Node
> change int id to ivec6 id
> Deprecated get_id() and set_id()
> Deprecated set_destination()
> add ivec6 id(), id_a(int arg) to id_f(int arg) and id(int a ... int f) and id(ivec6 arg);

> R_Graphic
> add Processing function circle() basic, plus refactoring to accet vec parameter



\* version 48
> R_Colour
> class R_Colour add function add(String name, int... arg) to create palette by name
> class R_Colour add function current() to return a current colour
> class R_Colour add function select() to choose the current colour
> Deprecated all function who use a number to call palette replace the function with String name, all function like (int group, int colour) decome (String name, int colour).
> the function who return the array of the first palette, now return all the component of all palette
> class R_Colour add function to get the hsb and rgb of the current color in vec


> Rope
> pass all function protected to public
> add in_polygon(vec [] points, vec pos, float marge) to use marge to increase the detection around the polygon


> CONSTANT
> add constant FIRST, LAST, NEXT, PREVIOUS, CHOICE

> R_Bloc
> add constructor with default canvas
> add vec2 get_coord();

> R_Shape, R_Primitive, R_Chose, R_Polygon, R_Icosahedron
> change system array to ArrayList to manage point

> R_Shape
> add function to add points, from float or list of vec points
> add int id, by default is 0;
> add function to get the ref point and point by argument x,y,z
> add function clear() to clear the pts and ref_point list
> move package from Costume to Mesh
> Deprecated function add() to add_vecs() because there is a problem with function add() from parent class Rope
> add function add_pointers()
> R_Voronoi
> add R_Voronoi, R_Delaunay_and_co adaptation from Toxiclib
> add remove_seed(int index)
> add z argument to seed to pass color information

> R_Graphic
> add function plot() close to set() from Processing
> add function plox_x2() doudouble the size of the pixel
> add function background like Processing execpt for PImage


> R_Line2D
> fix offset bug
> add offset(float x, float y) function
> add function update();
> add function change(float begin, float end) to change dynamicly the length of the line
> improve angle function to add a roatation around axe, where the axe is somewhere a the line
> add method to mute() and mute_is() the line
> deprecated function coord(), instead use point()
> deprecated function angle(), instead use rotation()
> add function set_pixels() and show_pixels() to general pixels a long the segment
> add function set_pixel_x2() to double the soze of the pixel
> move package from Costume to Mesh

> R_Pix
> add function to set the entry pixel from x, y coordinate
> add Constructor to set entruy and position



\*version 47
> Update to Processing 4

> GUI
> fixed function add_content() from R_Dropdown
> fixed outbound array for the slider molette for the function get(int index);
> added function set_curve(int type, float power) this function change the curve of the value result
> added funct set_range(float min ,float max) for class R_Slider, deprected set_min_max();
> added simple Constructor to K_Nnob
> fixed bug multimolette position for R_Knob
> added variable and function previous_angle to class R_Mol
> R_Mol make private vec2 pos and vec2 size
> added function get_guide() to R_Knob
> fixed default label position for R_Knob
> added overwrite method show_value() to R_Knob, to show all value of knob in case where there is few molettes
> added function get_start() and get_stop() to show the pie limit of the R_Knob
> changed all children Contructors where the type is used, from public to protected
> added function is_done() return true when the gui action is complete
> added function is_active() return true when a gui is active
> improved display separation for R_Slotch
> fixed bug for regular squaring display R_Slotch

> MESH
> fixed get_direction() from R_Segment
> deprecated get_end() to get_stop() from R_Segment
> added function to set start and stop value from R_Segment
> remove @Deprecated update(int x, int y, boolean event) function from Dropdown
> added more argument to function set() and offset()

> PIXO
> fixed bug R_Nubo when polygon start from another value than 0

> UTILS
> added class R_Fov

> TOOL > FILE
> added class to package toll R_Folder, R_Input and R_Data_Pinput to manage external file

> CORE
> added function to Rope to check extension file


\*version 46

> GUI
> add function get_content(it index) to R_Dropdown class
> add function set_value(int index) to R_Dropdown to set the which line is a current menu selection
> add function Long get_id(int index) to catch the id Image for the R_Image_Manager
> fix bug name in class R_Palette_Selector
> fix constructor bug for class gui.R_Slotch when this one is empty
> remove deprecated function R_Slider.update(float x, float y) in R_Dropdown class
> add Empty constructor for R_Dropdown
> change default value of the R_Dropdown to displey header text and selected content
> class R_Button add an empty Constructor
> add get() function to return get_selection() to make a correspondance with other class of Crope Gui
> add function get_value() to R_Dropdown, the function return the String content of the selection
> split String name and String label property for Crope element, now the both is independant.
> change Array content for R_Dropdown from ArrayList to HashMap. To give the opputinity to add key to content.
> add function get_current_color() and get_new_color() to class R_Palette_Selector
> add set_fill() set_stroke() to class R_Button to have setting more generic.
> change the content management for the R_Dropdown class fron a simple String array to ArrayList String

> MISC
> improve and fix bug for R_Primitive, when we try to catch normal and real points list, and add equal conversion with the mother class for getting points too.
> fix bug size in R_Primitive and increase the fps rendering by the way :)
> clean R_Primitive constructor, by remove the summits lines, by passing arg to super Constructor
> add funtion remove(int index) and add(T... int index) to class R_Image_Manager to make mirror with ArrayList method.
> add function add_content(String... content) to add element in the content
> improve class R_Image, add method set_name(String name), set_id(int id), set(R_Image, int index) and add random id generator
> add function float get_final() and float get_final(int index) return value from min to max
> add function set_min_max(), get_min(), get_max() to set the range of the slider, that can be useful when you lizzy to use the normal value from function get()
> add function detection in_line() and in_polygon() to detect if the vec2 is on a line or in area polygon
> fix bug iteration in class R_Line2D for function interesction()

> PIXO
> add variable float angle to class R_Pixo
> add class R_Nubo to create pixel cloud

\*version 45

> function boolean is() to R_Board
> fix bug R_Board for vertical position
> add to R_Button a float value, not just a boolean is, that's can be boog for the future to modulate by a conitunues click on it.
> add to R_Board, function add_slotch(), add_knob()
> add to R_Knob a pie display
> add multi molette for knob
> change all methods name show_structure() to show_stru()
> change all methods contain molette() to mol()
> add guide to knob to move all molette in a same time
> add guide value this value return the barycenter of all molette
> add method only to glsl method
> create statuic class Ru, because in french the Ru is the origin of all rivers ans because Romanesco is Utils to all my stuff :)
> remove the fom vec, ivec, bvec the link with the class Rope instead use static class Ru
> add method inverse to vec, ivec and bvec for bvec is like swap
> add function copy to bvec
> add constant HALF_PI or HPI, QUARTER_PI or QPI
> add equals function to bvec

\*version 44

> add function to manage the opengl Crope rendering to make palette and gradient slider.
> add other function to manage rounded rect with vec parameter.
> improve placement for label and return value
> improve Crope gradient and change the glsl file
> add example to use sliders to set hsb color
> add to R_Face: Overide toString
> change R_Face: accept all vec and translate to vec3
> change R_Face: fill(), stroke() becme set_fill(), set_stroke()
> change R_Button.update() to add exit in case the event or pointer is null.
> add Constructor to Crope, R_Button and R_Slider to accept a single argument int for size and pos.
> add triple auth event for R_Slider, R_Button, R_Button... by default the three event are true, the first three are considerated in State.event(boolean... arg);
> improve R_Slider, R_Button behavior for the time where the event is selected outside the molette and given the possibility to select it... and that's not good. Now it's fix.
> improve R_Kob for the event detection
> add function boolean size_change() to return if there is any changment of size of window
> add function constrain who can receive vec arg and with zero min by default
> fix bug of the R_Button behavior
> improve class R_Rank
> add get function for vector
> remove component stsq and uv, now the acces of this value pass by function
> add to vector function size and deprecated get_size()
> add function size() to class R_Rank
> add class R_Board to gui package

\*version 41

> add pack gui
> add class R_Slider, R_Palette, R_Dropdown, R_Button...
> add function to core Rope, like hex(), binary()
> add function to core BigBang : like colorMode(), ellipseMode()...

\*version 40

> remove waring build
> add class R_Moxo to split method from R_Pixo, Moxo name is a contraxion of Pixo and Motion

\*version 39 < 30
A lot of work between those version, too much to describe it with precision

> add package colour, begin of class to manage colour and palette.
> add package pixo, begin of classes to manage pixel like particles.
> add package image, contain R_Image, R_Pattern and R_Image_Manager class
> add package svg, make something in the illustraotr spirit.
> add package costume to manage and attach item shape to différent position, size and rotation.
> split class Rope and BigBang, now BigBang is child of Pixo.
> Modify BigBang class, now there is only the Processing function and method
> Modify and rich Rope class with all the proper function who dont need dependencies.
> add item icosahedron to class Costume

\*version 30

> R_Line2D : fix toString() bug
> R_Line2D: add method to catch coordinate from a normal position or distance on the line
> R_Constants: add constants VERTICAL, HORIZONTAL, DIAGONAL, CIRCULAR
> vec2, vec3, vec4: add method to add, multiply, subtract and divide simple argument x,y,z and w
> R_COnstants: add const for the cardinal and sub cardinal points
> R_Chose: add method to return the radius list and a specific radius too.

\*version 29

> vec2, vec3, vec4, ivec2, ivec3, ivec4 : add method constrain(arg min arg max)
> vec2 : fix bug for method angle(vec2 dst);
> vec2 : angle() remove the offset HALF_PI addition
> vec2, vec3, vec4 : add method compare vector this with vector target in vector area
> R_Line2D: add new class R_Line2D to manage line, node between 2D line and few more helpful stuff
> R_Shape and R_Image : mode a lot of method from R_Shape to R_Image, now R_Image manage the drawing system inherited from Processing and R_Shape manage only the shapes.

\*version 28

> change : method dir() and tan() now the behavior is get not a setting behavior, change for vec2, vec3 and vec4
> vec2: add method angle(vec2 target);
> clean class R_Shape
> fix checking P3D mode by add a boolean to save and store the last check to avoid new checking who cause a big big system slowdown when there is a lot particles.

\*version 27

> clean code
> add javadoc

\*version 26

> R_Shape: remove pushMatrix() and popMatrix()
> R_Shape: add push() and pop() methods
> R_Shape: add endShape(int type);
> Bug fix the problem of Processing core version
> R_Shape: add ghost methods quadraticVertex()
> R_Shape: change method(int... arg) to method(float... arg)
> R_Shape: add method vertex, bezierVertex, quadraticVertex, curveVertex with arg PGraphics

\*version 25

> R_Polygon and R_Chose: fix bug for void calc()
> R_Chose: add security for the where radius target is negative
> R_Chose: add waring for the case where the array radius is equal to zero.
> R_Constants: add RAND
> vec3: fix bug on method vec3 cross(vec3 v, vec3 target)
> R_Bezier: change get_pos() to pos()
> R_Bezier: change set_pos(arg) to pos(arg)
> R_Image: add method pass_graphic(PGraphics other);
> R_Shape: remove float angle to vec3 angle
> R_Shape: change get_angle() to angle() angle_x(), angle_y(), angle_z()
> R_Shape: change set_angle(arg) to angle(float x, float y, float z), angle(vec angle) angle_x(float value), angle_y(float value), angle_z(float value)

\*version 24

> create Interface for Constants Colour

\*version 23

> mod: class R_Shape: method get_final_points(int target) > get_final_point(int target)
> add: class R_Chose method calc() to compute without use method show();
> add: class R_Polygon method calc() to compute without use method show();
> add: class R_Shape method angle(float val) and float get_angle();
> remove: angle from R_Virus and R_Polygon
> clean: R_Star
> clean: R_Virus

\*version 22

> change constant GRAY_1 to GRAY_9 by array constant from 0 to 19

\*version 21

> COSTUME
> class C_Circle: method void set_summit() > void set_summits();
> class R_Virus: method void set_num() > void set_summits();
> class R_Virus: method int get_num() > int set_summits();
> add class R_Polygon
> add class R_Chose
> fix R_Primitive bug

> R_Shape
> move the common method and variable to the class R_Shape:
> move get_points(), get_point(int target)
> add get_final_points(), get_final_point(int target);
> add void reset_is(boolean state);
> add boolean reset_is()
> add use_pos_is(boolean state);
> add boolean use_pos_is();

> EXAMPLES
> R_Primitive
> R_Polygon
> R_Chose
