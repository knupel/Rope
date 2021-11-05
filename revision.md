\*version 46

> fix constructor bug for class gui.R_Slotch when this one is empty
> remove deprecated function R_Slider.update(float x, float y) in R_Dropdown class
> add Empty constructor for R_Dropdown
> change default value of the R_Dropdown to displey header text and selected content

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

\*version 0.12.0.41

> add pack gui
> add class R_Slider, R_Palette, R_Dropdown, R_Button...
> add function to core Rope, like hex(), binary()
> add function to core BigBang : like colorMode(), ellipseMode()...

\*version 0.11.1.40

> remove waring build
> add class R_Moxo to split method from R_Pixo, Moxo name is a contraxion of Pixo and Motion

\*version 0.11.0.39 < 0.8.5.30
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

\*version 0.8.5.30

> R_Line2D : fix toString() bug
> R_Line2D: add method to catch coordinate from a normal position or distance on the line
> R_Constants: add constants VERTICAL, HORIZONTAL, DIAGONAL, CIRCULAR
> vec2, vec3, vec4: add method to add, multiply, subtract and divide simple argument x,y,z and w
> R_COnstants: add const for the cardinal and sub cardinal points
> R_Chose: add method to return the radius list and a specific radius too.

\*version 0.8.4.29

> vec2, vec3, vec4, ivec2, ivec3, ivec4 : add method constrain(arg min arg max)
> vec2 : fix bug for method angle(vec2 dst);
> vec2 : angle() remove the offset HALF_PI addition
> vec2, vec3, vec4 : add method compare vector this with vector target in vector area
> R_Line2D: add new class R_Line2D to manage line, node between 2D line and few more helpful stuff
> R_Shape and R_Image : mode a lot of method from R_Shape to R_Image, now R_Image manage the drawing system inherited from Processing and R_Shape manage only the shapes.

\*version 0.8.3.28

> change : method dir() and tan() now the behavior is get not a setting behavior, change for vec2, vec3 and vec4
> vec2: add method angle(vec2 target);
> clean class R_Shape
> fix checking P3D mode by add a boolean to save and store the last check to avoid new checking who cause a big big system slowdown when there is a lot particles.

\*version 0.8.2.27

> clean code
> add javadoc

\*version 0.8.1.26

> R_Shape: remove pushMatrix() and popMatrix()
> R_Shape: add push() and pop() methods
> R_Shape: add endShape(int type);
> Bug fix the problem of Processing core version
> R_Shape: add ghost methods quadraticVertex()
> R_Shape: change method(int... arg) to method(float... arg)
> R_Shape: add method vertex, bezierVertex, quadraticVertex, curveVertex with arg PGraphics

\*version 0.8.0.25

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

\*version 0.7.0.24

> create Interface for Constants Colour

\*version 0.6.2.23

> mod: class R_Shape: method get_final_points(int target) > get_final_point(int target)
> add: class R_Chose method calc() to compute without use method show();
> add: class R_Polygon method calc() to compute without use method show();
> add: class R_Shape method angle(float val) and float get_angle();
> remove: angle from R_Virus and R_Polygon
> clean: R_Star
> clean: R_Virus

\*version 0.6.1.22

> change constant GRAY_1 to GRAY_9 by array constant from 0 to 19

\*version 0.6.0.21

\*Package Costume

> class C_Circle: method void set_summit() > void set_summits();
> class R_Virus: method void set_num() > void set_summits();
> class R_Virus: method int get_num() > int set_summits();
> add class R_Polygon
> add class R_Chose
> fix R_Primitive bug

\*class R_Shape

> move the common method and variable to the class R_Shape:
> move get_points(), get_point(int target)
> add get_final_points(), get_final_point(int target);
> add void reset_is(boolean state);
> add boolean reset_is()
> add use_pos_is(boolean state);
> add boolean use_pos_is();

\*Add examples

> R_Primitive
> R_Polygon
> R_Chose
