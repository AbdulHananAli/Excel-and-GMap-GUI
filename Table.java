package project_A;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class Table {

	TableView <Table_data> tabel;
	VBox tableBox;
	
	@SuppressWarnings("unchecked")
	public VBox getTable(){
		
	TableColumn<Table_data,String> num =
			new TableColumn<>("NO.");
	num.setPrefWidth(40);
	num.setCellValueFactory(new PropertyValueFactory<>("num"));	
	
	TableColumn<Table_data,String> site =
			new TableColumn<>("SITE");
	site.setMinWidth(140);
	site.setCellValueFactory(new PropertyValueFactory<>("site"));	
		
	TableColumn<Table_data,String> city =
			new TableColumn<>("CITY");
	city.setMinWidth(100);
	city.setCellValueFactory(new PropertyValueFactory<>("city"));	
		
	TableColumn<Table_data,String> zone =
			new TableColumn<>("ZONE");
	zone.setPrefWidth(80);
	zone.setCellValueFactory(new PropertyValueFactory<>("zone"));	
	
	TableColumn<Table_data,String> function =
			new TableColumn<>("FUNCTION");
	function.setMinWidth(80);
	function.setCellValueFactory(new PropertyValueFactory<>("function"));	
		
	tabel = new TableView<>();
	tabel.getColumns().addAll(num,site,city,zone,function);	
	
	tableBox = new VBox();
	tableBox.getChildren().add(tabel);
	VBox.setVgrow(tabel, Priority.ALWAYS);	
	return tableBox;
	}
	
}
