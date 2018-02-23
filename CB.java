package project_Nestle;

import java.io.IOException;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class CB {

	public ComboBox<String> getComboBox() throws IOException{
		
		Hash set = new Hash();
    	ComboBox<String> cb = new ComboBox<String>();
        
        cb.setEditable(true);

        ObservableList<String> items = FXCollections.observableArrayList(set.getSet());

        FilteredList<String> filteredItems = new FilteredList<String>(items, p -> true);

        cb.getEditor().textProperty().addListener((obs, oldValue, newValue) -> {
        final TextField editor = cb.getEditor();
        final String selected = cb.getSelectionModel().getSelectedItem();

        Platform.runLater(() -> {
               
                if (selected == null || !selected.equals(editor.getText())) {
                    filteredItems.setPredicate(item -> {
                      
                        if (item.toUpperCase().startsWith(newValue.toUpperCase())) {
                            return true;
                        } else {
                            return false;
                        }
                    });
                }
            });
        });

        cb.setItems(filteredItems);
		return cb;
	}
}
