package ca.bcit.comp2522.termproject.oishiiramen;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * Change setting controller.
 *
 * @author Atsuko Uemura, Misuzu Taniguchi
 * @version 12-April-2024
 */
public class ChangeSettingController {
    @FXML
    private ToggleGroup locationGroup;

    @FXML
    private TextField newNumberOfChairTextField;

    @FXML
    private Label numberOfChairLabel;
    @FXML
    private Label storeLocationLabel;

    /**
     * Displays store location and number of chairs.
     *
     * @param yourStore as Menu
     */
    public void displayStoreSetting(final Store yourStore) {
        storeLocationLabel.setText(GameApplication.getYourStore().getLocation().toString());
        numberOfChairLabel.setText(String.valueOf(GameApplication.getYourStore().getNumberOfChair()));
    }

    /**
     * Moves to store home page on our JavaFX UI.
     *
     * @param event as ActionEvent
     * @throws IOException when I/O operation is failed.
     */
    public void backToStoreHome(final ActionEvent event) throws IOException {
        Stage stage;
        Scene scene;
        Parent root;

        if (!newNumberOfChairTextField.getText().isEmpty()) {
            int newPrice = Integer.parseInt(newNumberOfChairTextField.getText());
            GameApplication.getYourStore().setNumberOfChair(newPrice);
        }

        RadioButton selectedSizeRadioButton = (RadioButton) locationGroup.getSelectedToggle();
        String newLocation = selectedSizeRadioButton.getText();

        if (newLocation != null && !newLocation.isEmpty()) {
            GameApplication.getYourStore().setLocation(Store.Location.valueOf(newLocation));
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource("storeHome.fxml"));
        root = loader.load();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
