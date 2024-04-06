package ca.bcit.comp2522.termproject.oishiiramen;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class StoreHomeController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    Text storeNameText;

    @FXML
    Label menuListLabel;

    public void displayStoreName(String storename) {
        storeNameText.setText(storename);
    }
    public void displayStoreMenu(Store yourStore) {
        StringBuilder menuText = new StringBuilder();
        ArrayList<Menu> menu =  yourStore.getMenu();

        for (Menu yourmenu : menu) {
            String name = "Name: " + yourmenu.getName() + "\n";
            String size = "Size: " + yourmenu.getSize() + "\n";
            String price = "Price: " + yourmenu.getPrice() + "\n";
            String materialCost = "Material cost: " + yourmenu.getMaterialCost() + "\n\n";
            menuText.append(name);
            menuText.append(size);
            menuText.append(price);
            menuText.append(materialCost);
        }

        String result = menuText.toString();
        menuListLabel.setText(result);
    }

    public void switchRunBusiness(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("runBusiness.fxml"));
        root = loader.load();

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
