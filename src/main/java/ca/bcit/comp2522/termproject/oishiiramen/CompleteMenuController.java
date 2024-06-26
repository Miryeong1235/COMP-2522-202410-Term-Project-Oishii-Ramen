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


/**
 * Complete menu controller.
 *
 * @author Atsuko Uemura, Misuzu Taniguchi
 * @version 12-April-2024
 */
public class CompleteMenuController {
    @FXML
    private ToggleGroup addMenuToggle;

    /**
     * Moves to store home page on our JavaFX UI.
     *
     * @param event as ActionEvent
     * @throws IOException when I/O operation is failed.
     */
    public void switchStoreHome(final ActionEvent event) throws IOException {
        Stage stage;
        Scene scene;
        Parent root;

        RadioButton selectedAddMenuRadioButton = (RadioButton) addMenuToggle.getSelectedToggle();
        String userWantsToAdd = selectedAddMenuRadioButton.getText();

        if (userWantsToAdd.equals("Yes")) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ramenMenu1.fxml"));
            root = loader.load();
        } else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("storeHome.fxml"));
            root = loader.load();
        }

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
