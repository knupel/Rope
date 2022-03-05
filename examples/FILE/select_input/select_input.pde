/**
* Rope framework
* Copyleft (c) 2014-2021
* @author @stanlepunk
* @see https://github.com/StanLepunK/Rope_framework
*
*/

/**
* INPUT
* V 0.2.0
* 2019-2021
* void select_input();
* void select_input(String type);
* R_Data_Input get_input(String type);
* R_Data_Input [] get_inputs();
* R_Data_Input get_input(int target);
* boolean input_use_is(); it's buggy or what ?
* boolean input_use_is(String type); it's buggy or what ?
* void input_use(boolean is);
* void input_use(String type, boolean is);
* String input_path();
* String input_path(String type);
* void reset_input();
* void reset_input(String type);
* File input_file();
* File input_file(String type);
* void set_filter_input(String type, String... extension);
*/
void setup() {
	size(200,200,P3D);
	print_extension_filter();
	// select_input(); // you can select all file, no sorting
  select_input("movie"); // give the possibility to select only file with a movie extension store in movie array
  
}


void draw() {
	println(input_path("media"));


	// input_use() to set witch type of file you can select after this setting, after that this is the default setting
	// but it's buggy or what ?
	input_use("image", true); 
	println(input_use_is("image"));
  // println(input_file("movie"));
  // println(input("movie"));
	exit();
}





