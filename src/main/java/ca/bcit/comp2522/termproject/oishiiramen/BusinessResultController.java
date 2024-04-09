package ca.bcit.comp2522.termproject.oishiiramen;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;


/**
 * Business result controller.
 *
 * @author Atsuko Uemura, Misuzu Taniguchi
 * @version 12-April-2024
 */
public class BusinessResultController {
    @FXML
    private Label revenueLabel;

    @FXML
    private Label detailsLabel;

    /**
     * Displays the financial result of the store, including accumulated revenue, cost, and sales.
     *
     * @param yourStore the Store object for which the financial result will be displayed
     */
    public void displayResult(final Store yourStore) {
        double revenue = yourStore.getAccumulatedRevenue();
        double cost = yourStore.getAccumulatedCost();
        double sales = yourStore.getAccumulatedSales();

        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.CANADA);
        currencyFormat.setMaximumFractionDigits(2);

        String revenueCAD = currencyFormat.format(revenue);
        revenueLabel.setText(revenueCAD);

        String costCAD = currencyFormat.format(cost);
        String salesCAD = currencyFormat.format(sales);
        detailsLabel.setText("Cost: " + costCAD + ", Sales: " + salesCAD);

    }

    /**
     * Moves to store home page on our JavaFX UI.
     *
     * @param event as ActionEvent
     * @throws IOException when I/O operation is failed.
     */
    public void backToStoreHome(final ActionEvent event) throws IOException {
        Stage stage;
        Scene scene;
        Parent root;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("storeHome.fxml"));
        root = loader.load();

        // display store name
        StoreHomeController storeHomeController = loader.getController();
        storeHomeController.displayStoreName(GameApplication.yourStore.getName());

        // display store menu
        storeHomeController.displayStoreMenu(GameApplication.yourStore);

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
