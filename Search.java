package project_A;

import java.io.IOException;
import java.net.URISyntaxException;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class Search {

	ComboBox<String> text;//search bar: dynamically updates as you type
	VBox Alpha;//contains the search bar and the beta container
	
	//radio buttons to filter search by with column to look into
	RadioButton site;
	RadioButton city;
	RadioButton zone;
	RadioButton function;
	
	//buttons to manipulate the table (from the main class) handlers are added in the main class
	Button search;//search the word in the field in the relative column chosen
	Button clear;//to remove all items from the table view
	Button all;//to show all items in the table view 
	
	//contains all the radio buttons and buttons
	BorderPane Beta;
	
	public VBox getSearchBox() throws IOException, URISyntaxException{
		
		CB CB = new CB();//class to build the search comboBox with relevant String options
		
		text = CB.getComboBox();//gets the ComboBox and stores it in "text"
		//Specks for the text field/box
		text.setMinWidth(180);
		text.setPrefWidth(180);
		text.setMaxWidth(180);
		
		//runs the setBeta method which sets up the beta container
		setBeta();
		
		Alpha = new VBox(10); //Initialise the Alpha container 
		Alpha.setAlignment(Pos.CENTER);//set location
		Alpha.getChildren().addAll(text,Beta);//add the search bar and the beta container
		
		return Alpha;//returns the alpha container
	}
	
	public BorderPane setBeta(){
		
		//initialise the toggle group
		ToggleGroup TG =new ToggleGroup();
		
		//initialise the radio buttons and label them
		site= new RadioButton("SITE");
		city= new RadioButton("CITY");
		zone= new RadioButton("ZONE");
		function= new RadioButton("FUNCTION");
		
		//add to toggle group to bind the RadioButtons
		site.setToggleGroup(TG);
		city.setToggleGroup(TG);
		zone.setToggleGroup(TG);
		function.setToggleGroup(TG);
		
		site.setSelected(true);//set the site option checked by default 
		
		//add the radio buttons to a container
		VBox choiceBox = new VBox(5);//create a VBox with a distance of 5pxs between objects
		choiceBox.setAlignment(Pos.CENTER_LEFT);//position the box
		
		choiceBox.getChildren().addAll(site,city,zone,function);//add all the radio button to the VBox
		
		//initialise the buttons and label them
		search = new Button("SEARCH");
		clear = new Button ("CLEAR");
		all = new Button   (" ALL ");
		
		//add Specs (size)
		search.setMinWidth(60);
		clear.setMinWidth(60);
		all.setMinWidth(60);
		
		//add the buttons to a container
		VBox buttonBox = new VBox(10);//create a VBox with a distance of 10pxs between objects
		buttonBox.setAlignment(Pos.CENTER);//position the box
		
		buttonBox.getChildren().addAll(search,clear,all);//add all the radio button to the VBox
		
		Beta= new BorderPane();//initialise the beta container
		Beta.setLeft(choiceBox);//set the radio button container to the left
		Beta.setRight(buttonBox);//set the button container to the right
		return Beta;//returns beta (its not needed but if the method was to be used in a different program, would be helpful)
	}
}
