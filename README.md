
## Rope Library
version 49
copyleft(c) 2018-2023
ROPE mean ROmanesco Processing Environment.

This library is a logic way of Rope framework used to [Romanesco software](https://github.com/StanLepunK/ROMANESCO-Processing)

[Download](https://github.com/StanLepunK/Rope/blob/master/build_rope/Rope.zip) library link > unzip > add in Processing library folder

[ROPE page](https://stanlepunk.github.io/Rope/)

[Rope sketches examples](https://github.com/StanLepunK/Rope/tree/master/examples)

[Romanesco software repository](https://github.com/StanLepunK/ROMANESCO-Processing) that use Rope library and Rope framework


## Available in the Library

### State
`R_State` is a static class to store differents environment variables from PApplet and events. It's inspired from `React` state.

### Core
Collection Constants set, and Processing clone and improve functions, and glsl function and more useful feature.

### Vector
A collection of vector class, inspired from `PVector` and `vec` function from `GLSL`
float precision:
`vec2` `vec3` and `vec4` with all operation from `PVector` and few more possibilities.
Plus `vec5` and `vec6` to store data.

note: class vec is note write with Uppercase RVec, or Vec for the first letter like is done usualy. The reason is due of the number of time where you must write this Classes, it's possible to accept is a type, like in GLSL!!!

integer precision:
`ivec2` `ivec3` `ivec4` with few operation
and `ivec5` and `ivec6` to store data.

boolean precision:
`bvec2` `bvec3` `bvec4` `bvec5` `bvec6`.

### Gui
you can find class do build `R_Slider`, `R_Knob`, `R_Dropdown`, `R_Button`, `R_Apple_Bar`, `R_Palette`, `R_Board`

### Mesh
you can find in this package différents classes to create triangle `R_Shape`, `R_Face`, `R_Line2D` ,`R_Node`, `R_Bloc` and Bloc manager `R_Megabloc`, also `R_Plane`, 

### Pixo
Work around the pixel to add it few useful functions and variables, to change, store colour, manage motion, manage pixel cloud. 

Can be help when you want create a particles world.
The main classes are `R_Pixo`, `R_Moxo`, `R_Nubo`

### Image
`R_Image` is an extends of `PImage` to store a little more infos, like name or path. You find also `R_Image_Manger` to use a list of `R_Image`. `R_Pattern` can help to create a differents random `PGraphics` with noise or marble pattern.

### Colour
classes to create and manage colour palettes
- store color
- sort color
- named your palette
- random sort colors from specific palette
- create camaieu from specific root color.
- etc

### Costume
`vertex()` and `vertexBezier()` method with direct acces via the `vec` type.
Collection of shape classes in the costume package : 
`R_Star`, `R_Polygon`, `R_Chose`, `R_Virus`, `R_Primitive`, `R_Circle`, `R_Bezier`, `R_Icosahedron`, `R_House`, `R_Impact`

### Svg
classes to create svg rendering like the last `Illustrator` protocol.







