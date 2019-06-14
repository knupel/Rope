*version 0.8.3.28 in progress




*version 0.8.2.27

>clean code
>add javadoc

*version 0.8.1.26 

>R_Shape: remove pushMatrix() and popMatrix()
>R_Shape: add push() and pop() methods
>R_Shape: add endShape(int type);
>Bug fix the problem of Processing core version
>R_Shape: add ghost methods quadraticVertex()
>R_Shape: change method(int... arg) to method(float... arg)
>R_Shape: add method vertex, bezierVertex, quadraticVertex, curveVertex with arg PGraphics



*version 0.8.0.25

>R_Polygon and R_Chose: fix bug for void calc()
>R_Chose: add security for the where radius target is negative
>R_Chose: add waring for the case where the array radius is equal to zero.
>R_Constants: add RAND
>vec3: fix bug on method vec3 cross(vec3 v, vec3 target)
>R_Bezier: change get_pos() to pos()
>R_Bezier: change set_pos(arg) to pos(arg)
>R_Image: add method pass_graphic(PGraphics other);
>R_Shape: remove float angle to vec3 angle
>R_Shape: change get_angle() to angle() angle_x(), angle_y(), angle_z()
>R_Shape: change set_angle(arg) to angle(float x, float y, float z), angle(vec angle) angle_x(float value), angle_y(float value), angle_z(float value)

*version 0.7.0.24

> create Interface for Constants Colour

*version 0.6.2.23

>mod: class R_Shape: method get_final_points(int target) > get_final_point(int target)
>add: class R_Chose method calc() to compute without use method show();
>add: class R_Polygon method calc() to compute without use method show();
>add: class R_Shape method angle(float val) and float get_angle();
>remove: angle from R_Virus and R_Polygon
>clean: R_Star
>clean: R_Virus




*version 0.6.1.22

>change constant GRAY_1 to GRAY_9 by array constant from 0 to 19






*version 0.6.0.21

*Package Costume

> class C_Circle: method void set_summit() > void set_summits();
> class R_Virus: method void set_num()     > void set_summits();
> class R_Virus: method int get_num()      > int set_summits();
> add class R_Polygon
> add class R_Chose
> fix R_Primitive bug

*class R_Shape

> move the common method and variable to the class R_Shape: 
> move get_points(), get_point(int target) 
> add get_final_points(), get_final_point(int target);
> add void reset_is(boolean state);
> add boolean reset_is()
> add use_pos_is(boolean state);
> add boolean use_pos_is();

*Add examples

>R_Primitive
>R_Polygon
>R_Chose

