package ca.bcit.comp2522.termproject.oishiiramen;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

import java.io.IOException;

public class RamenMenu2Controller {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    Label materialFeeLabel;

    public void displayMaterialPrice(Menu yourRamen) {
        String materialCostString = Double.toString(yourRamen.getMaterialCost());
        materialFeeLabel.setText(materialCostString);
    }


    public void switchRamenMenu3(ActionEvent event) throws IOException {

//        RadioButton selectedFlavourRadioButton = (RadioButton) flavour.getSelectedToggle();
//        String ramenFlavour = selectedFlavourRadioButton.getText();
//        System.out.println("Selected Option: " + ramenFlavour);
//
//        RadioButton selectedSizeRadioButton = (RadioButton) size.getSelectedToggle();
//        String ramenSize = selectedSizeRadioButton.getText();
//        System.out.println("Selected Option: " + ramenSize);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("ramenMenu3.fxml"));
        root = loader.load();

//
//        RamenMenu2Controller ramenMenu2Controller = loader.getController();
//        ramenMenu2Controller.displayMaterialPrice(yourRamen);

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}




