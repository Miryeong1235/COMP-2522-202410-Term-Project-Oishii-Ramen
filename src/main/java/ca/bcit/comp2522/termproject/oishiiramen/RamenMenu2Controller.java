package ca.bcit.comp2522.termproject.oishiiramen;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class RamenMenu2Controller {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    Label materialFeeLabel;

    @FXML
    private CheckBox chashu;
    @FXML
    private CheckBox corn;
    @FXML
    private CheckBox tamago;
    @FXML
    private CheckBox seaweed;

    public void displayMaterialPrice(Menu yourRamen) {
        String materialCostString = Double.toString(yourRamen.getMaterialCost());
        materialFeeLabel.setText(materialCostString);
    }


    public void switchRamenMenu3(ActionEvent event) throws IOException {
        StringBuilder selectedItems = new StringBuilder();
        ArrayList<Menu.Topping> toppingList = new ArrayList<>();
        if (chashu.isSelected()) {
            toppingList.add(Menu.Topping.chashu);
            System.out.println("Selected Items: chashu");
        }
        if (tamago.isSelected()) {
            toppingList.add(Menu.Topping.tamago);
            System.out.println("Selected Items: tamago");
        }
        if (corn.isSelected()) {
            toppingList.add(Menu.Topping.corn);
            System.out.println("Selected Items: corn");
        }
        if (seaweed.isSelected()) {
            toppingList.add(Menu.Topping.seaweed);
            System.out.println("Selected Items: seaweed");
        }

        RamenMenu1Controller.yourRamen.setToppings(toppingList);
        System.out.println(RamenMenu1Controller.yourRamen.getToppings());

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




