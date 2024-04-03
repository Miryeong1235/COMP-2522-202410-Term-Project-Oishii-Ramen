package ca.bcit.comp2522.termproject.oishiiramen;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("sample.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Oishii Ramen Yokoso!");
        stage.setScene(scene);
        stage.show();


//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
//        Group root = new Group();
//        stage.setTitle("Oishii Ramen");
//        stage.setWidth(420);
//        stage.setHeight(420);


//        stage.setScene(scene);

//        Image icon = new Image("filename.png");
//        stage.getIcons().add(icon);
//        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}