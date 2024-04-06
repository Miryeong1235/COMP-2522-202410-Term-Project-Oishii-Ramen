package ca.bcit.comp2522.termproject.oishiiramen;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.io.IOException;


public class CompleteMenuController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ToggleGroup addMenuToggle;

    public void switchStoreHome(ActionEvent event) throws IOException {


        RadioButton selectedAddMenuRadioButton = (RadioButton) addMenuToggle.getSelectedToggle();
        String userWantsToAdd = selectedAddMenuRadioButton.getText();

        if (userWantsToAdd.equals("Yes")) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ramenMenu1.fxml"));
            root = loader.load();
        } else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("storeHome.fxml"));
            root = loader.load();

            // display store name
            StoreHomeController storeHomeController = loader.getController();
            storeHomeController.displayStoreName(HelloApplication.yourStore.getName());

            // display store menu
            storeHomeController.displayStoreMenu(HelloApplication.yourStore);
        }

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
