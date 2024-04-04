package ca.bcit.comp2522.termproject.oishiiramen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.io.IOException;

public class RamenMenu1Controller {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    ToggleGroup flavour;

    public void switchRamenMenu2(ActionEvent event) throws IOException {

        RadioButton selectedRadioButton = (RadioButton) flavour.getSelectedToggle();
        String ramenFlavour = selectedRadioButton.getText();
        System.out.println("Selected Option: " + ramenFlavour);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("ramenMenu2.fxml"));
        root = loader.load();


        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
