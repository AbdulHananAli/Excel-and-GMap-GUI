package project_Nestle;

import java.io.IOException;
import java.net.URISyntaxException;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Edit {

	TextField[] feild;
	TextField[] feild2;
	BorderPane pane;
	
	Stage window = new Stage();
	
	 public void OpenWindow(String code) throws IOException, URISyntaxException{
		ScrollPane SP = new ScrollPane();
		Scene scene = new Scene(SP);
		Update UD = new Update();
		SiteData SD = new SiteData();
		pane = new BorderPane();
		
		String A[] = SD.getHeader();
		String B[] = SD.getData(code);
		
		VBox layout = new VBox(10);
		feild = new TextField[A.length];
		for(int x = 0; x<=A.length-1;x++){
			feild[x] = new TextField();
			feild[x].setText(A[x]);
			feild[x].setPrefWidth(200);
			feild[x].setEditable(false);
			feild[x].setStyle("-fx-background-color: transparent;");
			feild[x].setId("bold");
			layout.getChildren().add(feild[x]);
		}
		VBox layout2 = new VBox(10);
		layout2.setPadding(new Insets(0,0,0,10));
		feild2 = new TextField[B.length];
		for(int x = 0; x<=B.length-1;x++){
			feild2[x] = new TextField();
			feild2[x].setText(B[x]);
			feild2[x].setPrefWidth(450);
			layout2.getChildren().add(feild2[x]);
		}
		layout.setAlignment(Pos.TOP_LEFT);
		layout2.setAlignment(Pos.TOP_LEFT);
		
		Button Done = new Button("Done");
		Done.setOnAction(e->{
			String[] NV = new String[B.length];
			for(int x = 0; x<=B.length-1;x++){
				NV[x]=feild2[x].getText();
			}
			try {
				UD.Send(NV, code);
				window.hide();
				window.close();
			} catch (IOException e1) {
				MessageBox MB = new MessageBox();
				MB.display("Error! Can not update source", "If file is opened in another program, please close it");
			} catch (URISyntaxException e1) {
				MessageBox MB = new MessageBox();
				MB.display("Error! Can not update source", "If file is opened in another program, please close it");
				e1.printStackTrace();
			}
			
		});
		VBox layout3 = new VBox();
		layout3.setPadding(new Insets(10,0,0,0));
		layout3.getChildren().add(Done);
		layout3.setAlignment(Pos.BOTTOM_RIGHT);
		
		pane.setPadding(new Insets(10,10,10,10));
		pane.setLeft(layout);
		pane.setCenter(layout2);
		pane.setBottom(layout3);
       
		window.setTitle(B[1]);
		window.setMinWidth(20);
		pane.setStyle("-fx-background-color: linear-gradient(to bottom right,#FFFFFF  ,#34495E );");
		SP.setContent(pane);
		window.setScene(scene);
		window.setTitle("Edit");
		window.setResizable(false);
		window.showAndWait();
	}
}
