package ca.bcit.comp2522.termproject.oishiiramen;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class HiringEmployeeController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    // hiringEmployee
    @FXML
    private Label ownerNameLabel;

    @FXML
    private TextField employeeNameTextField;

    public void displayName(String username) {
        ownerNameLabel.setText("Hello, " + username);
    }

    public void switchRamenMenu1(ActionEvent event) throws IOException {

        String employeeName = employeeNameTextField.getText();
        int employeeLevel = 1;
        Employee yourEmployee = new Employee(employeeName, employeeLevel);
//        yourStore.hireEmployee(yourEmployee);

        System.out.println(HelloApplication.yourStore.getName() +" "+ HelloApplication.yourStore.getOwnerName());

        FXMLLoader loader = new FXMLLoader(getClass().getResource("ramenMenu1.fxml"));
        root = loader.load();

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
