
/**
* explore folder
* Copyleft (c) 2023-2023
* @author @knupel
* @see https://github.com/knupel/Rope 
* 
* V 0.2.2
* 2019-2023
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

void setup() {
	size(400,400,P2D);
	folder = new R_Folder(this);
	// we use the function here to open when the sketch run at the first time.
	folder.select_folder("Need function", "callback_function");
}


void draw() {
	boolean explore_sub_folder = true;
  boolean print_file_is = true;
	String [] ext = {"jpg", "jpeg", "webp"};
	String path = folder.get_folder_path();
  folder.explore_folder(path, explore_sub_folder); // if you don't add extension only folders is added to list folder.
	// folder.explore_folder(path, explore_sub_folder, ext);
  // folder.explore_folder(path, explore_sub_folder, print_file_is, ext);

	if(folder.get_files() != null) {
		println("size",folder.get_files().size());

    println("FILES:");
		for(File file : folder.get_files()) {
		 	println(file);
		}

    println("FOLDERS:");
    for(File folder : folder.get_folders()) {
       println(folder.getAbsolutePath());
       println(folder.getName());
    }
		exit();
	}
}

/////////////////
// CALLBACK
/////////////////////
void callback_function(File selection) {
	if (selection == null) {
		println("Nothing, sorry");
	} else {
		println("Folder path is:" +selection.getAbsolutePath());
		folder.set_folder_path(selection.getAbsolutePath());
		folder.folder_is(true);
	}
}
