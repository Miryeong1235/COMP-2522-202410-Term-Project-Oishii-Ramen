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

/**
 * Hiring employee controller.
 *
 * @author Atsuko Uemura, Misuzu Taniguchi
 * @version 12-April-2024
 */
public class HiringEmployeeController {
        // hiringEmployee
    @FXML
    private Label ownerNameLabel;

    @FXML
    private TextField employeeNameTextField;

    /**
     * Displays the username.
     *
     * @param username the owner name of the Store that will be displayed
     */
    public void displayName(final String username) {
        ownerNameLabel.setText("Hello, " + username);
    }

    /**
     * Moves to ramen manu 1 page on our JavaFX UI.
     *
     * @param event as ActionEvent
     * @throws IOException when I/O operation is failed.
     */
    public void switchRamenMenu1(final ActionEvent event) throws IOException {
        Stage stage;
        Scene scene;
        Parent root;

        String employeeName = employeeNameTextField.getText();
        int employeeLevel = 1;
        Employee yourEmployee = new Employee(employeeName, employeeLevel);
        GameApplication.getYourStore().hireEmployee(yourEmployee);

        System.out.println(GameApplication.getYourStore().getName()
                + " " + GameApplication.getYourStore().getOwnerName());

        FXMLLoader loader = new FXMLLoader(getClass().getResource("ramenMenu1.fxml"));
        root = loader.load();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
