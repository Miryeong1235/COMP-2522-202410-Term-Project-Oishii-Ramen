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

/**
 * Store home controller.
 *
 * @author Atsuko Uemura, Misuzu Taniguchi
 * @version 12-April-2024
 */
public class StoreHomeController {
    @FXML
    private Text storeNameText;

    @FXML
    private Label menuListLabel;

    @FXML
    private TextField businessDuration;

    @FXML
    private Button exitButton;

    /**
     * Closes the application window to finish the game.
     */
    public void finishGame() {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    /**
     * Displays the name of the store in the user interface.
     *
     * @param storeName the name of the store to be displayed
     */
    public void displayStoreName(final String storeName) {
        storeNameText.setText(storeName);
    }

    /**
     * Displays the menu of the store in the user interface.
     *
     * @param yourStore the store whose menu is to be displayed
     */
    public void displayStoreMenu(final Store yourStore) {
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

    /**
     * Moves to run business page on our JavaFX UI.
     *
     * @param event as ActionEvent
     * @throws IOException when I/O operation is failed.
     */
    public void switchRunBusiness(final ActionEvent event) throws IOException {
        Stage stage;
        Scene scene;
        Parent root;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("runBusiness.fxml"));
        root = loader.load();

        int durationToRunBusiness = Integer.parseInt(businessDuration.getText());
        double revenueThisTime = GameApplication.getYourStore().runBusiness(durationToRunBusiness);
        System.out.println(GameApplication.getYourStore().getOwnerName() + " has run business for "
                + durationToRunBusiness + " days.\nRevenue this time is " + revenueThisTime);

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Moves to change setting page on our JavaFX UI.
     *
     * @param event as ActionEvent
     * @throws IOException when I/O operation is failed.
     */
    public void switchChangeSetting(final ActionEvent event) throws  IOException {
        Stage stage;
        Scene scene;
        Parent root;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("changeSetting.fxml"));
        root = loader.load();

        ChangeSettingController changeSettingController = loader.getController();
        changeSettingController.displayStoreSetting(GameApplication.getYourStore());

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
