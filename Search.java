package project_Nestle;

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

	
	VBox Alpha;
	ComboBox<String> text;
	BorderPane Beta;
	RadioButton site;
	RadioButton city;
	RadioButton zone;
	RadioButton function;
	Button search;
	Button clear;
	Button all;
	
	public VBox getSearchBox() throws IOException, URISyntaxException{
		CB CB = new CB();
		text = CB.getComboBox();
		text.setMinWidth(180);
		text.setPrefWidth(180);
		text.setMaxWidth(180);
		
		setBeta();
		
		Alpha = new VBox(10);
		Alpha.setAlignment(Pos.CENTER);
		Alpha.getChildren().addAll(text,Beta);
		
		return Alpha;
	}
	
	public BorderPane setBeta(){
		
		ToggleGroup TG =new ToggleGroup();
		
		site= new RadioButton("SITE");
		city= new RadioButton("CITY");
		zone= new RadioButton("ZONE");
		function= new RadioButton("FUNCTION");
		
		site.setToggleGroup(TG);
		city.setToggleGroup(TG);
		zone.setToggleGroup(TG);
		function.setToggleGroup(TG);
		site.setSelected(true);
		
		VBox choiceBox = new VBox(5);
		choiceBox.setAlignment(Pos.CENTER_LEFT);
		choiceBox.getChildren().addAll(site,city,zone,function);
		
		search = new Button("SEARCH");
		clear = new Button ("CLEAR");
		all = new Button   (" ALL ");
		
		search.setMinWidth(60);
		clear.setMinWidth(60);
		all.setMinWidth(60);
		
		VBox buttonBox = new VBox(10);
		buttonBox.setAlignment(Pos.CENTER);
		buttonBox.getChildren().addAll(search,clear,all);
		
		Beta= new BorderPane();
		buttonBox.setAlignment(Pos.CENTER);
		Beta.setLeft(choiceBox);
		Beta.setRight(buttonBox);
		return Beta;
		
	}
}
