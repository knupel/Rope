/**
 *   ___      ___   ____   _______
 *  | -  \   /   \  |    \ |  ___/
 *  | |/  | |   \ | | |\ | |  |__
 *  |    /  | | | | | |  / |  __/
 *  | |  \  \ \   / |  |/  |  |____
 *  |_| \_\  \___/  |_ |   |______/
 * 
 * Copyleft (c) 2018-2023
* class R_Folder
* v 2.0.2
* @author Knupel / Stanislas Marçais
* @see https://github.com/knupel/Rope
*/
package rope.tool.file;

// import processing.core.PApplet;
import rope.core.BigBang;
import rope.utils.R_State.State;
import processing.core.PApplet;

import java.util.Arrays;
import java.util.ArrayList;
// import java.awt.FileDialog;
// import java.awt.Frame;
// import java.io.FilenameFilter;
// import java.io.FileNotFoundException;
// import java.io.FileOutputStream;
import java.io.File;




public class R_Folder extends BigBang {
	private String selected_path_folder = null;
	private boolean folder_selected_is;
	private boolean explore_subfolder_is = false;
	private ArrayList <File> files;
	// private PApplet pa;
	private R_Input input;
	private String input_type = "default";

	public R_Folder(PApplet pa) {
		super(pa);
		input = new R_Input(pa);
		selected_path_folder = null;
		folder_selected_is = false;
		explore_subfolder_is = false;
	}



	private void explore_subfolder_is(boolean is) {
		explore_subfolder_is = is;
	}

	private boolean explore_subfolder_is() {
		return explore_subfolder_is;
	}

	public void select_folder(String callback_function) {
		select_folder("default message:", callback_function);
	}

	public void select_folder(String message, String callback_function) {
		this.pa.selectFolder(message, callback_function);
	}

	public void reset_folder() {
		folder_selected_is = false;
	}

	public boolean folder_is() {
		return folder_selected_is;
	}

	public void folder_is(boolean is) {
		this.folder_selected_is = is;
	}

	public String get_folder_path() {
		return selected_path_folder;
	}

	public void set_folder_path(String path) {
		this.selected_path_folder = path;
	}


	private void set_media_list() {
		if(files == null) {
			files = new ArrayList<File>(); 
		} else {
			files.clear();
		}
	}

	public ArrayList<File> get_files() {
		return files ;
	}

	/**
	 * clear list of files
	 */
	public void clear() {
		files.clear();
	}

	public String [] get_files_sort() {
		if(files != null) {
			String [] list = new String [files.size()];
			for(int i = 0 ; i < get_files().size() ; i++) {
				File f = get_files().get(i);
				list[i] = f.getAbsolutePath();
			}
			Arrays.sort(list);
			return list;

		} else return null ;

	}

	public void explore_folder(String path, boolean check_sub_folder, String... extension) {
		if((folder_input_default_is() || input.input_use_is(this.input_type)) && path != ("")) {

			set_media_list();
	
			ArrayList allFiles = list_files(path, check_sub_folder);
		
			String file_name = "";
			int count_pertinent_file = 0;
			for(int k = 0 ; k < extension.length ; k++) {
				String ext = extension[k].toLowerCase();
				count_pertinent_file = 0;
				for (int i = 0; i < allFiles.size(); i++) {
					File f = (File) allFiles.get(i);   
					file_name = f.getName(); 
					// Add it to the list if it's not a directory
					if (f.isDirectory() == false) {
						if(extension(file_name) != null && extension(file_name).equals(ext)) {
							count_pertinent_file++;
							print_out(count_pertinent_file, "/", i, f.getName());
							files.add(f);
						}
					}
					
				}
				print_err("there is",count_pertinent_file,"file(s) pertinent for", ext);
			}
			// to don't loop with this void
			reset_folder_input_default();
			input.reset_input(this.input_type);
		}
	}

	public boolean folder_input_default_is() {
		return folder_selected_is;
	}

	private void reset_folder_input_default() {
		folder_selected_is = false ;
	}

	// Method to get a list of all files in a directory and all subdirectories
	private ArrayList<File> list_files(String dir, boolean check_sub_folder) {
		ArrayList<File> fileList = new ArrayList<File>(); 
		if(check_sub_folder) { 
			explore_directory(fileList, dir);
		} else {
			if(folder_selected_is) {
				File file = new File(dir);
				File[] subfiles = file.listFiles();
				for(int i = 0 ; i < subfiles.length ; i++) {
					fileList.add(subfiles[i]);
				}
			} else if(input.input_use_is(this.input_type)) {
				File file = new File(dir);
				fileList.add(file);
			}
		}
		return fileList;
	}

	// Recursive function to traverse subdirectories
	private void explore_directory(ArrayList<File> list_file, String dir) {
		File file = new File(dir);
		if (file.isDirectory()) {
			list_file.add(file);  // include directories in the list

			File[] subfiles = file.listFiles();
			for (int i = 0; i < subfiles.length; i++) {
				// Call this function on all files in this directory
				explore_directory(list_file, subfiles[i].getAbsolutePath());
			}
		} else {
			list_file.add(file);
		}
	}
}