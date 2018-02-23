package project_Nestle;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MessageBox {

	public void display(String title, String message ) {
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);		
		window.setTitle(title);
		window.setMinWidth(20);
		
		Label label = new Label(message);
		Button button = new Button("close");
		button.setOnAction(e-> window.close());
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(label,button);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout,300,200);
		window.setScene(scene);
		window.setResizable(false);
		window.showAndWait();
	}
}
