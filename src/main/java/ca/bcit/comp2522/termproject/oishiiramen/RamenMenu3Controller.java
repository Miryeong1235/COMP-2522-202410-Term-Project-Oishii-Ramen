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
import java.util.ArrayList;

import static ca.bcit.comp2522.termproject.oishiiramen.RamenMenu1Controller.numberOfMenu;

public class RamenMenu3Controller {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label materialFeeWithToppingLabel;

    @FXML
    private TextField ramenPriceTextField;
    @FXML
    private TextField ramenNameTextField;

    public void displayMaterialPrice(Menu yourRamen) {
        String materialCostString = Double.toString(yourRamen.getMaterialCost());
        materialFeeWithToppingLabel.setText(materialCostString);
    }

    public void switchCompleteMenu(ActionEvent event) throws IOException {
//        StringBuilder selectedItems = new StringBuilder();
        int price = Integer.parseInt(ramenPriceTextField.getText());
        HelloApplication.yourStore.getMenu().get(numberOfMenu - 1).setPrice(price);
        System.out.println("Ramen price was set as $" + HelloApplication.yourStore.getMenu().get(numberOfMenu - 1).getPrice());

        String menuName = ramenNameTextField.getText();
        HelloApplication.yourStore.getMenu().get(numberOfMenu - 1).setName(menuName);
        System.out.println("Ramen name was set as " + HelloApplication.yourStore.getMenu().get(numberOfMenu - 1).getName());


        FXMLLoader loader = new FXMLLoader(getClass().getResource("completeMenu.fxml"));
        root = loader.load();


        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
