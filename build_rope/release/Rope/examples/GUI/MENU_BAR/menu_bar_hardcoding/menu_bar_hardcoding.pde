/**
* R_APPLE_BAR
* Processing 4.0a3
* Rope Library 0.12.2.42
* 2019-2021
* v 1.0.0
* 
* Make and set your Apple menu bar
* 
* pass all menus in differents String to method set(JSONObject)");
*
* MENU must have 'menu bar' for name");
* MENU must have a content separate by ','(coma)");
* for the separor use '|'(vertical bar) between two ','(coma)\n");
*
* MENU ITEM finishing by '?'(interrogation) has a check box added");
* MENU ITEM finishing by '!?'(exclamation)(interrogation) the check box is selected");
*
* MENU ITEM can be key responding\n to use syntax like that\nname>key>action_event, the word must be separate by '>'\nthe first term after the menu item name is the key, after you pass your action event");
* key available:\na,b,c...x,y,z\n0,1,2...\nf1,f2,...f25\n',',';','@','#','/','+','=','_','-'");
* action event available:\nshift,cmd,meta,ctrl and alt");
*
* ELEMENT of MENU finishing by '+'(plus) can hava a submenu, to set create JSONObject where the name finish by'_'(underscore)");
*
*/
import rope.gui.bar.R_Apple_Bar;
import rope.gui.bar.R_Happen;
import java.awt.event.ActionEvent;
import rope.R_State.State;

R_Apple_Bar cb;

void setup() {
	size(100,100);
	menu_bar_write();
	cb.help(); // same message than above
}

void draw() {
}

void keyPressed() {
	// to update menu, you need to catch the JSONObject of your Menu and update the content of this one.
	cb.get_menu().getJSONObject("file").setString("load recent","new_path/item.psd,other_path/with_a new super file.jpg,un fichier de patate.jpg");
	build_menu_bar(cb.get_menu());
}

void menu_bar_write() {
	JSONObject menu_bar = new JSONObject();
	write_menu(menu_bar);
	build_menu_bar(menu_bar);
	saveJSONObject(cb.get_menu(), "data/menu_bar_tree.json");
}

void write_menu(JSONObject menu_bar) {
		// WARNING keep "menu bar" it's the key to build the Crope_Bar, is waiting
	menu_bar.setString("menu bar", "about,file,import,help"); // set the title of the menu

	JSONObject about_ = new JSONObject();
	about_.setString("menu", "information,version");

	JSONObject file_ = new JSONObject();
	file_.setString("menu", "load>o>cmd,load recent+,|,save>s>cmd,save as>s>cmd>shift,save as a copy>s>cmd>shift>alt");
  // here there is "+" a the end of recent that indicate there is a submenu
  file_.setString("load recent", "blaubird.rope,youngtimer.rope"); // set the submenu and dynamic menu
 
 	JSONObject import_ = new JSONObject();
	import_.setString("menu", "import media>i>cmd,import image,import video,import sound,import text,import shape,|,import folder");

	JSONObject help_ = new JSONObject();
	help_.setString("menu", "controler!?,prescene?,scene?");
  
  // pass each JSONObject, must be the same than "menu bar" setting
	menu_bar.setJSONObject("about", about_);
	menu_bar.setJSONObject("file", file_);
	menu_bar.setJSONObject("import", import_);
	menu_bar.setJSONObject("help", help_);

}
 

void build_menu_bar(JSONObject content) {
	cb = new R_Apple_Bar(this);
	cb.set(content,happen);
	cb.show();
}


Child happen = new Child();
public class Child extends R_Happen {
	// here we overide the method what()  of the class Mother R_Happen
	// and we can define a behavior for each element of the menu bar
	public void what(String what, ActionEvent ae) {
		if(what.equals("information")) {
			println("bon appétit");
		}

		if(what.equals("version")) {
			println("this is a last version, cool or what????");
		}

		// etc for each element
	}
}
