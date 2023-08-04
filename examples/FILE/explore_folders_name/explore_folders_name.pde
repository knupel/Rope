
/**
* explore folders by name
* Copyleft (c) 2023-2023
* @author @knupel
* @see https://github.com/knupel/Rope 
* 
* V 0.0.1
* 2023-2023

*/
import rope.tool.file.R_Folder;
import rope.utils.R_Pair;
import rope.core.Rope;
import java.util.Collections;

Rope r = new Rope();
R_Folder folder;
ArrayList<R_Pair<String, Integer>>list = new ArrayList<R_Pair<String, Integer>>();

void setup() {
	size(400,400,P2D);
	folder = new R_Folder(this);
	// we use the function here to open when the sketch run at the first time.
	folder.select_folder("Need function", "callback_function");
}


void draw() {
	boolean explore_sub_folder = true;
	String path = folder.get_folder_path();
  folder.explore_folder(path, explore_sub_folder);

	if(folder.get_files() != null) {
		println("Quantity of folders",folder.get_folders().size());
    println("FOLDERS:");
    // get all folders file
    for(File folder : folder.get_folders()) {
       // println(folder.getAbsolutePath());
       // println(folder.getName());
    }
    // create list name
    create_list_of_names();
    // sort list

    // https://stackoverflow.com/questions/23039744/how-to-sort-an-arraylist-of-objects
    Collections.sort(list, (o1,  o2) -> Integer.compare(o1.b(), o2.b()));
    Collections.reverse(list);
    // list.sort(Comparator.comparing(a -> a.b()));
    // print list
    for(R_Pair pair : list) {
      println(pair.a(), pair.b());
    }
		exit();
	}
}

void create_list_of_names() {
  for(File folder : folder.get_folders()) {
    String [] buf = folder.getName().split(" ");
    for(String str : buf) {
      boolean name_exist = false;
      for(R_Pair<String, Integer> pair : list) {
        if(str.equals(pair.a())) {
          int temp = pair.b();
          temp++;
          pair.b(temp);
          name_exist = true;
          break;
        }
      }
      if(name_exist == false) {
        R_Pair<String, Integer> pair = new R_Pair<String, Integer>(str,1);;
        list.add(pair);
      }
    }
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
