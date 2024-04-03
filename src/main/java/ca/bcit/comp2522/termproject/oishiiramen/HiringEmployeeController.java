package ca.bcit.comp2522.termproject.oishiiramen;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HiringEmployeeController {

    // hiringEmployee
    @FXML
    Label ownerNameLabel;

    public void displayName(String username) {
        ownerNameLabel.setText("Hello: " + username);
    }


}
