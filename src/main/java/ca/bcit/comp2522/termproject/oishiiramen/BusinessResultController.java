package ca.bcit.comp2522.termproject.oishiiramen;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;


public class BusinessResultController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label revenueLabel;

    @FXML
    private Label detailsLabel;

    @FXML
    private Button goHomeButton;

    public void displayResult(Store yourStore) {
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

    public void backToStoreHome(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("storeHome.fxml"));
        root = loader.load();

        // display store name
        StoreHomeController storeHomeController = loader.getController();
        storeHomeController.displayStoreName(HelloApplication.yourStore.getName());

        // display store menu
        storeHomeController.displayStoreMenu(HelloApplication.yourStore);

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
