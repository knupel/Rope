/**
 *   ___      ___   ____   _______
 *  | -  \   /   \  |    \ |  ___/
 *  | |/  | |   \ | | |\ | |  |__
 *  |    /  | | | | | |  / |  __/
 *  | |  \  \ \   / |  |/  |  |____
 *  |_| \_\  \___/  |_ |   |______/
 * 
 * Copyleft (c) 2021-2023
* class R_Input
* v 0.1.1
* @author Knupel / Stanislas Marçais
* @see https://github.com/knupel/Rope
*/

package rope.tool.file;

import rope.core.BigBang;
import processing.core.PApplet;

import java.awt.FileDialog;
import java.awt.Frame;

import java.io.File;
import java.io.FilenameFilter;



public class R_Input extends BigBang {
	private R_Data_Input [] input_rope;

	private String t_default = "default";
	private String t_image = "image";
	private String t_media = "media";
	private String t_movie = "movie";
	private String t_shape = "shape";
	private String t_sound = "sound";
	private String t_text = "text";
	private String t_load = "load";
	private String t_pref = "preference";
	private String t_setting ="setting";


	private String [] input_type = {  t_default,
																		t_image, t_media, t_movie, t_shape, t_sound, t_text,
																		t_load,
																		t_pref, t_setting
																	};
	// filter extension										
	private String[] ext_default;
	private String[] ext_image = { "png", "jpeg", "jpg", "tif", "tga", "gif"};
	private String[] ext_load;
	private String[] ext_media;
	private String[] ext_movie = { "mov", "avi", "mp4", "mpg", "mkv"};
	private String[] ext_pref;
	private String[] ext_setting = { "csv", "txt", "json"};
	private String[] ext_shape = { "svg", "obj"};
	private String[] ext_sound = { "mp3", "wav"};
	private String[] ext_text = { "txt", "md"};

	public R_Input(PApplet pa) {
		super(pa);
		init_input_group();
	}
	

	private void init_input_group() {
		if(input_rope == null) {
			input_rope = new R_Data_Input[input_type.length];
			for(int i = 0 ; i < input_rope.length ; i++) {
				input_rope[i] = new R_Data_Input();
				set_input(input_rope[i],input_type[i]);
			}
		}
	}

	private void set_input(R_Data_Input input, String type) { 
		input.set_type(type);
		input.set_prompt("select "+type);
		if(type.equals(t_default)) input.set_filter(ext_default);
		else if(type.equals(t_image)) input.set_filter(ext_image);
		else if(type.equals(t_load)) input.set_filter(ext_load);
		else if(type.equals(t_media)) input.set_filter(ext_media);
		else if(type.equals(t_movie)) input.set_filter(ext_movie);
		else if(type.equals(t_pref)) input.set_filter(ext_pref);
		else if(type.equals(t_setting)) input.set_filter(ext_setting);
		else if(type.equals(t_shape)) input.set_filter(ext_shape);
		else if(type.equals(t_sound)) input.set_filter(ext_sound);
		else if(type.equals(t_text)) input.set_filter(ext_text);
	}


	public void set_filter_input(String type, String... ext) {
		if(type.equals(t_default)) {
			ext_default = ext;
		} else if(type.equals(t_image)) {
			ext_image = ext;
		} else if(type.equals(t_load)) {
			ext_load = ext;
		} else if(type.equals(t_media)) {
			ext_media = ext;
		} else if(type.equals(t_movie)) {
			ext_movie = ext;
		} else if(type.equals(t_pref)) {
			ext_pref = ext;
		} else if(type.equals(t_setting)) {
			ext_setting = ext;
		} else if(type.equals(t_shape)) {
			ext_shape = ext;
		} else if(type.equals(t_sound)) {
			ext_sound = ext;
		} else if(type.equals(t_text)) {
			ext_text = ext;
		} else if(type.equals(t_default)) {
			ext_default = ext;
		}
		set_input(get_input(type),type);
	}

	// get input
	public String [] get_input_type() {
		return this.input_type;
	}

	public R_Data_Input get_input(String type) {
		R_Data_Input input = null;
		if(input_rope != null && input_rope.length > 0) {
			for(int i = 0 ; i < input_rope.length ; i++) {
				if(input_rope[i].get_type().equals(type)) {
					input = input_rope[i];
					break;
				}
			}
		}
		return input;
	}

	public R_Data_Input [] get_inputs() {
		return input_rope;
	}

	public R_Data_Input get_input(int target) {
		if(input_rope != null && target < input_rope.length && target >= 0) {
			return input_rope[target];
		} else {
			return null;
		}
	}

	public void select_input() {
		select_input(t_default);
	}

	public void select_input(String type) {
		String context = get_renderer();
		boolean apply_filter_is = true;
		// if(context.equals(P3D) || context.equals(P2D) || context.equals(FX2D)) {
		// 	apply_filter_is = false;
		// 	print_out(ANSI_RED+"WARNING:"+ANSI_WHITE+" method select_input(String type) cannot apply filter extension"+ANSI_RED,type,ANSI_WHITE+"\nin this renderer context"+ANSI_RED, context,ANSI_WHITE+"instead classic method selectInput() is used");
		// }

		if(!apply_filter_is) {
			type = t_default;
			for(int i = 0 ; i < input_rope.length ; i++) {
				if (type.toLowerCase().equals(input_rope[i].get_type())) {  
					this.pa.selectInput(input_rope[i].get_prompt(),"select_single_file");
					break;
				}
			}
		} else if(apply_filter_is) {
			int check_for_existing_method = 0 ;
			for(int i = 0 ; i < input_rope.length ; i++) {
				check_for_existing_method++;
				if(type.toLowerCase().equals(input_rope[i].get_type())){  
					select_single_file_filtering(input_rope[i]);
					break;
				}
			}

			if(check_for_existing_method == input_rope.length) {
				print_err("void select_input(String type) don't find callback method who's match with type: "+type);
				print_err("type available:");
				this.pa.printArray(input_type);
			}
		}
	}

	// private int max_filter_input;
	private String [] temp_filter_list;
	private void select_single_file_filtering(R_Data_Input input) {
		Frame frame = null;
		FileDialog dialog = new FileDialog(frame, input.get_prompt(), FileDialog.LOAD);
		if(input.get_filter() != null && input.get_filter().length > 0) {
			temp_filter_list = input.get_filter();
			dialog.setFilenameFilter(new FilenameFilter() {
				@Override
				public boolean accept(File dir, String name) {
					name = name.toLowerCase();
					for (int i = 0; i < temp_filter_list.length ; i++) {
						if (name.endsWith(temp_filter_list[i]))  {
							return true;
						}
					}
					return false;
				}}
			);
		}  
		dialog.setVisible(true);
		String directory = dialog.getDirectory();
		String filename = dialog.getFile();

		if (filename != null) {
			input.set_file(new File(directory, filename));
		}
		if(input.get_file() != null) {
			print_out("method select_single_file_filtering(",input.get_type(),"):",input.get_file().getPath());
		}
	}

	// boolean accept_input(String path, String [] ext) {
	// 	boolean accepted = false;
	// 	for (int i = ext.length; i-- != 0;) {
	// 		if (path.endsWith(ext[i]))  {
	// 			accepted = true;
	// 			break;
	// 		}
	// 	}
	// 	return accepted;
	// }

	public void reset_input(String type) {
		for (int i = input_type.length; i-- != 0;) {
			if(input_type[i].equals(type)) {
				input_rope[i].set_is(false);
				break;
			}
		}
	}

	public boolean input_use_is(String type) {
		boolean result = false;
		for (int i = input_type.length; i-- != 0;) {
			if(input_type[i].equals(type)) {
				if(input_rope != null && input_rope[i] != null) {
					result = input_rope[i].get_is();
					break;
				}
			}
		}
		return result;
	}

	public void input_use(String type, boolean is) {
		for (int i = input_type.length; i-- != 0;) {
			if(input_type[i].equals(type)) {
				input_rope[i].set_is(is);
				break;
			}
		}
	}

	public String input_path(String type) {
		String path = null;
		for (int i = input_type.length; i-- != 0;) {
			if(input_type[i].equals(type)) {
				if(input_rope != null) {
					path = input_rope[i].get_path();
					break;
				}
			}
		}
		return path;
	}

	public File input_file(String type) {
		File file = null;
		for (int i = input_type.length; i-- != 0;) {
			if(input_type[i].equals(type)) {
				file = input_rope[i].get_file();
				break;
			}
		}
		return file;
	}

	// private void set_input(String type, File file) {
	// 	for(int i = 0 ; i < input_rope.length ; i++) {
	// 		if(type.equals(input_rope[i].get_type())) {
	// 			input_rope[i].set_file(file);
	// 			input_rope[i].set_path(file.getAbsolutePath());
	// 			input_rope[i].set_is(true);
	// 		}
	// 	}
	// }
}
