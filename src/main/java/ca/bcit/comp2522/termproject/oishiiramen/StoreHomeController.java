package ca.bcit.comp2522.termproject.oishiiramen;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class StoreHomeController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    Text storeNameText;

    public void displayStoreName(String storename) {
        storeNameText.setText(storename);
    }
}
