/**
* R_Data_Input
* 2017-2021
* v 0.3.0
*/
package rope.tool.file;

import java.io.File;



public class R_Data_Input {
	private File file = null;
	private String type = null;
	private String callback = null;
	private String path = null;
	private String prompt = null;
	private String [] filter = null;
	private boolean is;


	public R_Data_Input() { }
	
	// file
	public void set_file(File file) {
		this.file = file;
		this.path = file.getPath();
	}

	public File get_file() {
		return file;
	}

	// is
	public void set_is(boolean is) {
		this.is = is;
	}

	public boolean get_is() {
		return is;
	}

	// path
	public void set_path(String path) {
		this.path = path;
	}

	public String get_path() {
		return path;
	}

	// type
	public void set_type(String type) {
		this.type = type;
	}

	public String get_type() {
		return type;
	}

	// prompt
	public void set_prompt(String prompt) {
		this.prompt = prompt;
	}

	public String get_prompt() {
		return prompt;
	}

	// callback
	public void set_callback(String callback) {
		this.callback = callback;
	}

	public String get_callback() {
		return callback;
	}

	// filter
	public void set_filter(String [] filter) {
		this.filter = filter;
	}
	
	public String [] get_filter() {
		return filter;
	}
}














