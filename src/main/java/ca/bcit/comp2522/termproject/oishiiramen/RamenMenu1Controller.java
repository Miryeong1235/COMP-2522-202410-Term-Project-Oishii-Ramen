package ca.bcit.comp2522.termproject.oishiiramen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.io.IOException;

public class RamenMenu1Controller {

    private Stage stage;
    private Scene scene;
    private Parent root;

    public static Menu yourRamen;

    @FXML
    ToggleGroup flavour;
    @FXML
    ToggleGroup size;

    public void switchRamenMenu2(ActionEvent event) throws IOException {

//        Choose flavour
        RadioButton selectedFlavourRadioButton = (RadioButton) flavour.getSelectedToggle();
        String ramenFlavour = selectedFlavourRadioButton.getText();
        System.out.println("Selected Option: " + ramenFlavour);

        RadioButton selectedSizeRadioButton = (RadioButton) size.getSelectedToggle();
        String ramenSize = selectedSizeRadioButton.getText();
        System.out.println("Selected Option: " + ramenSize);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("ramenMenu2.fxml"));
        root = loader.load();

        yourRamen = initialize(ramenFlavour, ramenSize);
//        Menu yourRamen;
//        switch (ramenFlavour) {
//            case "Shio ramen" -> {
//                yourRamen = new Shio(ramenSize);
//                System.out.println(yourRamen.getName() + "w as instantiated");
//            }
//            case "Shoyu ramen" -> {
//                yourRamen = new Shoyu(ramenSize);
//                System.out.println(yourRamen.getName() + " was instantiated");
//            }
//            case "Tonkotsu ramen" -> {
//                yourRamen = new Tonkotsu(ramenSize);
//                System.out.println(yourRamen.getName() + " was instantiated");
//            }
//            default -> {
//                yourRamen = new Miso(ramenSize);
//                System.out.println(yourRamen.getName() + " was instantiated");
//            }
//        }

        RamenMenu2Controller ramenMenu2Controller = loader.getController();
        ramenMenu2Controller.displayMaterialPrice(yourRamen);

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public Menu initialize(String ramenFlavour, String ramenSize) {
        Menu yourRamen;
        switch (ramenFlavour) {
            case "Shio ramen" -> {
                yourRamen = new Shio(ramenSize);
                System.out.println(yourRamen.getName() + "w as instantiated");
            }
            case "Shoyu ramen" -> {
                yourRamen = new Shoyu(ramenSize);
                System.out.println(yourRamen.getName() + " was instantiated");
            }
            case "Tonkotsu ramen" -> {
                yourRamen = new Tonkotsu(ramenSize);
                System.out.println(yourRamen.getName() + " was instantiated");
            }
            default -> {
                yourRamen = new Miso(ramenSize);
                System.out.println(yourRamen.getName() + " was instantiated");
            }
        }
        return yourRamen;
    }
}
