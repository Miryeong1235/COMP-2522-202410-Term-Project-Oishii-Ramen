package ca.bcit.comp2522.termproject.oishiiramen;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

import static ca.bcit.comp2522.termproject.oishiiramen.Menu.numberOfMenu;

public class StoreHomeController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Text storeNameText;

    @FXML
    private Label menuListLabel;

    @FXML
    private TextField businessDuration;

    @FXML
    private Button exitButton;

    public void finishGame(){
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    public void displayStoreName(String storeName) {
        storeNameText.setText(storeName);
    }
    public void displayStoreMenu(Store yourStore) {
        StringBuilder menuText = new StringBuilder();
        ArrayList<Menu> menu =  yourStore.getMenu();

        for (Menu yourmenu : menu) {
            String name = yourmenu.getName() + ": ";
            String size = yourmenu.getSize() + ", ";
            String price = "$" + yourmenu.getPrice() + "\n";
            menuText.append("- ");
            menuText.append(name);
            menuText.append(size);
            menuText.append(price);
        }

        String result = menuText.toString();
        menuListLabel.setText(result);
    }

    public void switchRunBusiness(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("runBusiness.fxml"));
        root = loader.load();

        int durationToRunBusiness = Integer.parseInt(businessDuration.getText());
        HelloApplication.yourStore.runBusiness(durationToRunBusiness);
        System.out.println(HelloApplication.yourStore.getOwnerName() + " has run business for "
                + durationToRunBusiness + " days");

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
