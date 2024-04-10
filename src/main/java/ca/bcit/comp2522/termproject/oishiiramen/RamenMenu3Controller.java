package ca.bcit.comp2522.termproject.oishiiramen;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Ramen menu 3 controller.
 *
 * @author Atsuko Uemura, Misuzu Taniguchi
 * @version 12-April-2024
 */
public class RamenMenu3Controller {
    @FXML
    private Label materialFeeWithToppingLabel;
    @FXML
    private TextField ramenPriceTextField;
    @FXML
    private TextField ramenNameTextField;

    /**
     * Displays material price for a Menu.
     *
     * @param yourRamen as Menu
     */
    public void displayMaterialPrice(final Menu yourRamen) {
        String materialCostString = Double.toString(yourRamen.getMaterialCost());
        materialFeeWithToppingLabel.setText(materialCostString);
    }

    /**
     * Moves to run complete menu page on our JavaFX UI.
     *
     * @param event as ActionEvent
     * @throws IOException when I/O operation is failed.
     */
    public void switchCompleteMenu(final ActionEvent event) throws IOException {
        Stage stage;
        Scene scene;
        Parent root;

        int price = Integer.parseInt(ramenPriceTextField.getText());

        int indexOfMenu = RamenMenu1Controller.getNumberOfMenu() - 1;
        GameApplication.yourStore.getMenu().get(indexOfMenu).setPrice(price);
        System.out.println("Ramen price was set as $"
                + GameApplication.yourStore.getMenu().get(indexOfMenu).getPrice());

        String menuName = ramenNameTextField.getText();
        GameApplication.yourStore.getMenu().get(indexOfMenu).setName(menuName);
        System.out.println("Ramen name was set as "
                + GameApplication.yourStore.getMenu().get(indexOfMenu).getName());

        FXMLLoader loader = new FXMLLoader(getClass().getResource("completeMenu.fxml"));
        root = loader.load();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
