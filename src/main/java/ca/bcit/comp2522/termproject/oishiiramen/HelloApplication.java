package ca.bcit.comp2522.termproject.oishiiramen;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    public static Store yourStore;
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("sample.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Oishii Ramen Yokoso!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public static Store initializeStore(String storename, String username, Store.Location storeLocation, int numberOfChair) {
        yourStore = new Store(storename, username, storeLocation, numberOfChair);
        return yourStore;
    }

}