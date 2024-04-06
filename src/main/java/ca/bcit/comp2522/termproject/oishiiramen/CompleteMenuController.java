package ca.bcit.comp2522.termproject.oishiiramen;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class CompleteMenuController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchStoreHome(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("storeHome.fxml"));
        root = loader.load();

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        // display store name
        StoreHomeController storeHomeController = loader.getController();
        storeHomeController.displayStoreName(HelloApplication.yourStore.getName());

        // display store menu
        storeHomeController.displayStoreMenu(HelloApplication.yourStore);

    }
}
