
/**
* explore folder
* Copyleft (c) 2023-2023
* @author @knupel
* @see https://github.com/knupel/Rope 
* 
* V 0.2.1
* 2019-2021
*
* void explore_folder(String path, String... extension);
* void explore_folder(String path, boolean check_sub_folder, String... extension);
* String folder();
* ArrayList<File> get_files();
* void select_folder();
* void select_folder(String message);
* boolean folder_input_default_is() ;
*
*/
import rope.tool.file.R_Folder;
import rope.core.Rope;

Rope r = new Rope();
R_Folder folder;
String title = "Need function";
String callback = "callback_function";

void setup() {
	size(400,400,P2D);
	folder = new R_Folder(this);

	// the function is describe and write below
	folder.select_folder(title, callback);
}


void draw() {
	boolean explore_sub_folder = true;
	String [] ext = {"jpg", "jpeg"};
	String path = folder.get_folder_path();
	// println("path", path);
	folder.explore_folder(path,explore_sub_folder,ext); 

	if(folder.get_files() != null && folder.get_files().size() > 0) {
		println("size",folder.get_files().size());
		// for(File f : folder.get_files()) {
		// 	println(f);
		// }
		exit();
	}
}

void keyPressed() {
	if(key == 'o' || key == 'i') {
		folder.select_folder(title, callback);
	}

}


void callback_function(File selection) {
	if (selection == null) {
		println("Nothing, sorry");
	} else {
		println("Folder path is:" +selection.getAbsolutePath());
		folder.set_folder_path(selection.getAbsolutePath());
		folder.folder_is(true);
	}
}
