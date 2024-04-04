package ca.bcit.comp2522.termproject.oishiiramen;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class RamenMenu2Controller {

    private Stage stage;
    private Scene scene;
    private Parent root;

//    @FXML
//    Label flavour;

    @FXML
    Label materialFeeLabel;

    public void displayMaterialPrice(Menu yourRamen) {
        String materialCostString = Double.toString(yourRamen.getMaterialCost());
        materialFeeLabel.setText(materialCostString);
    }
}




