package project_A;
import java.io.IOException;
import java.net.URISyntaxException;

import com.lynden.gmapsfx.GoogleMapView;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TablePosition;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AppGUI extends Application {

	//containers for important elements/layout (structured by need of design)
	VBox left;//to hold all elements/layouts for the left section of GUI
	VBox right;//to hold all elements/layouts for the right section of GUI 
	HBox main;//to hold left and right layouts
	Scene MainScene;//to hold main layout 
	Stage window;//to hold the main scene
	
	//object and event handler classes
	GMap GM = new GMap();//map plain object
	Search search = new Search();//search box object
	Table table = new Table();//table (full) object
	Event event = new Event();//event handlers for buttons
    SiteScene SS = new SiteScene();// SiteScene object (if an option on the table is clicked)
    MessageBox MB = new MessageBox();//message box object (i.e. alert box if something goes wrong)
	
    //DONT KNOW
	@SuppressWarnings("rawtypes")
	public void start(Stage primaryStage) throws Exception {
		//change the name of the primaryStage to window for ease
		window = primaryStage;
		
		//initiate the left pane as a vertical box  
		left= new VBox(10);//add elements top to down with a distance of 10px
		left.getChildren().addAll(GM.getGMap(),search.getSearchBox());//add the GMap and SearchBox objects
		//initiate the right with the table to make the cover the Right box fully  
		right = table.getTable();
		
		//initiate the main pane as a horizontal box
		main = new HBox(10);//add elements left to right with a distance of 10px
		main.getChildren().addAll(left,right);//add the left and right panes
		main.setPadding(new Insets(10,10,10,10));//add distance(padding) of 10px on each side 
		MainScene = new Scene(main);//set the layout/pane on a scene
		
		//All button handler
		search.all.setOnAction(e->{
			try {
				table.tabel.setItems(event.eventAll());
			} catch (IOException | URISyntaxException e1) {
				//Display message if something goes wrong
				MB.display("Check Box Error","Something went wrong, Try Something diffrent");
			}
		});
		
		//clear button handler
		search.clear.setOnAction(e->{
			table.tabel.setItems(null);
		});
		
		//search button handler
		search.search.setOnAction(e->{
			try {
				String key = search.text.getValue();
				int x = 1;
				if(search.site.isSelected()){x=2;}
				if(search.city.isSelected()){x=3;}
				if(search.zone.isSelected()){x=4;}
				if(search.function.isSelected()){x=5;}
				if(x==1){
					//Display message if something goes wrong
					MB.display("Chech Box Error","Something went wrong, Try Something diffrent"); e.consume();}
				table.tabel.setItems(event.eventSearch(key, x));
			} catch (Exception e1) { 
					//Display message if something goes wrong
					MB.display("Search Error","Something went wrong, Try Something diffrent");
			}
		});
		
		//Table click handler
		table.tabel.setOnMouseClicked(e->{
			if(e.getClickCount()==2){
				TablePosition pos =table.tabel.getSelectionModel().getSelectedCells().get(0);
				int row =pos.getRow();
				String x = (String) table.tabel.getColumns().get(0).getCellData(row);
				try {
					//open the new scene display
					SS.build(x);
				} catch (Exception e1) {
					//Display message if something goes wrong
					MB.display("Table Error","Something went wrong, Try Something diffrent");
				}
			}
		});
		
		//click on map
		((GoogleMapView) GM.mapView).setOnMouseClicked(
				new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				table.tabel.setItems(GM.getMapIT());
				GM.ClearList();
			}
			});
		//link to the style(CSS)  
		MainScene.getStylesheets().add(this.getClass().getResource("design.css").toExternalForm());
		//set the mainScene to the stage
		window.setScene(MainScene);
		//fix size
		window.setResizable(false);
		//add title
		window.setTitle("excel sheet GUI");
		//Display window
		window.show();
	}
	public static void main(String[] args) {
		//go to start method
		launch(args);
	}
}
