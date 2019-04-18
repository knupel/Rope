*version 0.7.1.25 in progress



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

