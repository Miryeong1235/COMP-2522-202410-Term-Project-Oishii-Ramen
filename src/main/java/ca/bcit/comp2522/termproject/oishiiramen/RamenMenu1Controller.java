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
 * Ramen menu 1 controller.
 *
 * @author Atsuko Uemura, Misuzu Taniguchi
 * @version 12-April-2024
 */
public class RamenMenu1Controller {
    private static int numberOfMenu = 0;
    @FXML
    private ToggleGroup flavour;
    @FXML
    private ToggleGroup size;

    private Menu instantiateMenu(final String newFlavour, final String newSize) {
        Menu yourRamen;

        switch (newFlavour) {
            case "Shio ramen" -> {
                yourRamen = new Shio(newSize);
                numberOfMenu++;
            }
            case "Shoyu ramen" -> {
                yourRamen = new Shoyu(newSize);
                numberOfMenu++;
            }
            case "Tonkotsu ramen" -> {
                yourRamen = new Tonkotsu(newSize);
                numberOfMenu++;
            }
            default -> {
                yourRamen = new Miso(newSize);
                numberOfMenu++;
            }
        }
        return yourRamen;
    }

    /**
     * Moves to ramen menu 2 page on our JavaFX UI.
     *
     * @param event as ActionEvent
     * @throws IOException when I/O operation is failed.
     */
    public void switchRamenMenu2(final ActionEvent event) throws IOException {
        Stage stage;
        Scene scene;
        Parent root;

        // Choose flavour
        RadioButton selectedFlavourRadioButton = (RadioButton) flavour.getSelectedToggle();
        String ramenFlavour = selectedFlavourRadioButton.getText();

        RadioButton selectedSizeRadioButton = (RadioButton) size.getSelectedToggle();
        String ramenSize = selectedSizeRadioButton.getText();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("ramenMenu2.fxml"));
        root = loader.load();

        Menu yourRamen = instantiateMenu(ramenFlavour, ramenSize);
        GameApplication.getYourStore().addMenu(yourRamen);

        RamenMenu2Controller ramenMenu2Controller = loader.getController();
        ramenMenu2Controller.displayMaterialPrice(yourRamen);

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Returns the number of menu as an int.
     *
     * @return numberOfMenu as an int
     */
    public static int getNumberOfMenu() {
        return numberOfMenu;
    }
}
