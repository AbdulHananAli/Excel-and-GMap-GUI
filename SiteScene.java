package project_A;

import java.io.IOException;
import java.net.URISyntaxException;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SiteScene {

	Label[] label;
	Label[] label2;
	BorderPane pane;
	Edit edit = new Edit();
	SiteData SD = new SiteData();
	Stage window = new Stage();
	public void build(String code) throws Exception{
		
		pane = new BorderPane();
		String A[] = SD.getHeader();
		String B[] = SD.getData(code);
		
		VBox layout = new VBox(10);
		label = new Label[A.length];
		for(int x = 0; x<=A.length-1;x++){
			label[x] = new Label();
			label[x].setText(A[x]);
			label[x].setId("bold");
			layout.getChildren().add(label[x]);
		}
		VBox layout2 = new VBox(10);
		label2 = new Label[B.length];
		for(int x = 0; x<=B.length-1;x++){
			label2[x] = new Label();
			label2[x].setText("\t"+B[x]);
			layout2.getChildren().add(label2[x]);
		}
		layout.setAlignment(Pos.TOP_LEFT);
		layout2.setAlignment(Pos.TOP_LEFT);
		
		Button Edit = new Button("Edit");
		Edit.setOnAction(e->{ 
			try {
				edit.OpenWindow(code);
				window.hide();
				window.close();
			} catch (IOException | URISyntaxException e1) {
				MessageBox MB = new MessageBox();
				MB.display("Error! Can not update source", "If file is opened in another program please close it");
			}
		});
		
		VBox layout3 = new VBox();
		layout3.setPadding(new Insets(10,0,0,0));
		layout3.getChildren().add(Edit);
		layout3.setAlignment(Pos.BOTTOM_RIGHT);
		
		pane.setPadding(new Insets(10,10,10,10));
		pane.setLeft(layout);
		pane.setCenter(layout2);
		pane.setBottom(layout3);

		window.setTitle(B[1]);
		window.setMinWidth(20);
		pane.getStylesheets().add(this.getClass().getResource("design.css").toExternalForm());
		Scene scene = new Scene(pane);
		window.setScene(scene);
		window.setResizable(false);
		window.showAndWait();
	}
}
