package ca.bcit.comp2522.termproject.oishiiramen;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Ramen menu 2 controller.
 *
 * @author Atsuko Uemura, Misuzu Taniguchi
 * @version 12-April-2024
 */
public class RamenMenu2Controller {
    @FXML
    private Label materialFeeLabel;
    @FXML
    private CheckBox chashu;
    @FXML
    private CheckBox corn;
    @FXML
    private CheckBox tamago;
    @FXML
    private CheckBox seaweed;

    /**
     * Displays the material price.
     *
     * @param yourRamen as Menu
     */
    public void displayMaterialPrice(final Menu yourRamen) {
        String materialCostString = Double.toString(yourRamen.getMaterialCost());
        materialFeeLabel.setText(materialCostString);
    }

    /**
     * Moves to ramen menu 3 page on our JavaFX UI.
     *
     * @param event as ActionEvent
     * @throws IOException when I/O operation is failed.
     */
    public void switchRamenMenu3(final ActionEvent event) throws IOException {
        Stage stage;
        Scene scene;
        Parent root;

        ArrayList<Menu.Topping> toppingList = new ArrayList<>();
        if (chashu.isSelected()) {
            toppingList.add(Menu.Topping.chashu);
        }
        if (tamago.isSelected()) {
            toppingList.add(Menu.Topping.tamago);
        }
        if (corn.isSelected()) {
            toppingList.add(Menu.Topping.corn);
        }
        if (seaweed.isSelected()) {
            toppingList.add(Menu.Topping.seaweed);
        }

        int indexOfMenu = RamenMenu1Controller.getNumberOfMenu() - 1;
        GameApplication.getYourStore().getMenu().get(indexOfMenu).setToppings(toppingList); // change index depending
        System.out.println(GameApplication.getYourStore().getMenu().get(indexOfMenu).getToppings());

        FXMLLoader loader = new FXMLLoader(getClass().getResource("ramenMenu3.fxml"));
        root = loader.load();

        // display new material price in RamenMenu3 page
        RamenMenu3Controller ramenMenu3Controller = loader.getController();
        ramenMenu3Controller.displayMaterialPrice(GameApplication.getYourStore().getMenu().get(indexOfMenu));

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}




