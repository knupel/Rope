
## Rope Library
v 0.12.1.41
copyleft(c) 2018-2021
ROPE mean ROmanesco Processing Environment.
This library is a logic way of Rope framework used to [Romanesco software](https://github.com/StanLepunK/ROMANESCO-Processing)

[Download library link > unzip > add in Processing library folder](https://github.com/StanLepunK/Rope/blob/master/build_rope/Rope.zip)

[ROPE page](https://stanlepunk.github.io/Rope/)

[Rope sketch exemple](https://github.com/StanLepunK/Rope/tree/master/examples)

[Rope framework source repository](https://github.com/StanLepunK/Rope_framework)

[Romanesco software source repository](https://github.com/StanLepunK/ROMANESCO-Processing)




## Available in the Library

### R_State class
a static class to store differents environment variables from PApplet and events.

### CORE package core
Collection Constants set, and Processing clone and improve functions, and glsl function and more useful feature.

### VECTOR package
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



### COSTUME package costume
`vertex()` and `vertexBezier()` method with direct acces via the `vec` type.
Collection of shape classes in the costume package : 
`R_STAR`, `R_Polygon`, `R_Chose`, `R_Virus`, `R_Primitive`, `R_Circle`, `R_Bezier`, `R_Icosahedron`, `R_House`

### GUI package gui
you can find class do build `R_Slider`, `R_Knob`, `R_Dropdown`, `R_Button`, `R_Apple_Bar`

### MESH package rope
you can find in this package différents classes to create triangle `R_Face`, `R_Node`, `R_Bloc` and Bloc manager `R_Megabloc`, also `R_Plane`...

### PIXO package rope
Little work around the pixel to add it few usefull functions and variables, to change, store colour and manage motion. Can be help when you want create a particles world.

### R_Image package rope
`R_Image` is an extends of `PImage` to store a little more infos, like name or path. You find also `R_Image_Manger` to use a list of `R_Image`. `R_Pattern` can help to create a differents random `PGraphics` with noise or marble pattern.

### R_SVG
classes to create svg rendering like the last `Illustrator` protocol.

### R_Colour
classes to create and manage colour palette.







