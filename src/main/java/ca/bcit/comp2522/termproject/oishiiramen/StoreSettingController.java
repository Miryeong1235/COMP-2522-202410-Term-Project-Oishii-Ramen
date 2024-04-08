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

/**
 * Store setting controller.
 *
 * @author Atsuko Uemura, Misuzu Taniguchi
 * @version 12-April-2024
 */
public class StoreSettingController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField ownerNameTextField;

    @FXML
    private TextField storeNameTextField;

    @FXML
    private ToggleGroup locationToggle;

    @FXML
    private TextField numberOfChairTextField;


    public void switchToHiringEmployee(ActionEvent event) throws IOException {
//        root = FXMLLoader.load(getClass().getResource("hiringEmployee.fxml"));

        String username = ownerNameTextField.getText();
        String storename = storeNameTextField.getText();

        int numberOfChair = 0;
        try {
            numberOfChair = Integer.parseInt(numberOfChairTextField.getText());
        } catch (NumberFormatException e) {
            System.out.println("We could not convert to integer" + e.getMessage());
        }

        RadioButton selectedRadioButton = (RadioButton) locationToggle.getSelectedToggle();
        Store.Location storeLocation = Store.Location.valueOf(selectedRadioButton.getText());
        System.out.println("Selected Option: " + storeLocation);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("hiringEmployee.fxml"));
        root = loader.load();

        HiringEmployeeController hiringEmployeeController = loader.getController();
        hiringEmployeeController.displayName(username);

        GameApplication.initializeStore(storename, username, storeLocation, numberOfChair);
//        System.out.println(yourStore.getName());

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
