package Classes;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;


public class Navi_GUI extends StackPane{
	 MenuBar menuBar; 
	 Menu menuMain; 
	 Menu menuSaal; 
	 Menu menuVorstellung; 
	 VBox menuBox; 
	
	 public Navi_GUI(){
//		 this.menuBar = new MenuBar();
//		 this.menuMain = new Menu("Main");
//		 this.menuSaal = new Menu("Saal");
//		 this.menuVorstellung = new Menu("Vorstellung");
		 TextField test = new TextField();
		 this.menuBox = new VBox();
		 this.menuBox.getChildren().addAll(test);
		 
//		 this.menuBar.getMenus().addAll(menuMain, menuSaal, menuVorstellung);
//		 this.menuBox.getChildren().addAll(menuBar);
	 }//-Navi_GUI
	 
	 
}
