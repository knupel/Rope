*version 0.6.1.22




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

