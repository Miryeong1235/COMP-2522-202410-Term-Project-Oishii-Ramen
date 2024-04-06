//package ca.bcit.comp2522.termproject.oishiiramen;
//
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.*;
//
//import javafx.application.Application;
//import javafx.scene.Scene;
//import javafx.scene.control.*;
//import javafx.stage.Stage;
//
//import java.io.IOException;
//import java.util.ArrayList;
//
//public class GameController {
//    private Stage stage;
//    private Scene scene;
//    private Parent root;
//
//
//    @FXML
//    TextField ownerNameTextField;
//
//    @FXML
//    TextField storeNameTextField;
//
//    @FXML
//    ToggleGroup locationToggle;
//
//    @FXML
//    TextField numberOfChairTextField;
//
//    // hiringEmployee
//    @FXML
//    Label ownerNameLabel;
//
//    // ramen menu 1
//    @FXML
//    ToggleGroup flavour;
//    @FXML
//    ToggleGroup size;
//
//    public static Store yourStore;
//
//    // hiring emp
//    @FXML
//    TextField employeeNameTextField;
//
//    // ramen menu 1
//    public static Menu yourRamen;
//
//    // ramen menu 2
//    @FXML
//    Label materialFeeLabel;
//
//    @FXML
//    private CheckBox chashu;
//    @FXML
//    private CheckBox corn;
//    @FXML
//    private CheckBox tamago;
//    @FXML
//    private CheckBox seaweed;
//
//
//
//    public void switchToStoreSettingTest(ActionEvent event) throws IOException {
//        root = FXMLLoader.load(getClass().getResource("storeSetting.fxml"));
//    //        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("sample.fxml"));
//        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//    }
//
//    public void displayName(String username) {
//        ownerNameLabel.setText("Hello, " + username);
//    }
//
//    public void switchRamenMenu1Test(ActionEvent event) throws IOException {
//
//        String employeeName = employeeNameTextField.getText();
//        int employeeLevel = 1;
//        Employee yourEmployee = new Employee(employeeName, employeeLevel);
////        yourStore.hireEmployee(yourEmployee);
//
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("ramenMenu1.fxml"));
//        root = loader.load();
//
//        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//    }
//    public void switchToHiringEmployeeTest(ActionEvent event) throws IOException {
//
//        String username = ownerNameTextField.getText();
//        String storename = storeNameTextField.getText();
//        int numberOfChair = Integer.parseInt(numberOfChairTextField.getText());
//
//        RadioButton selectedRadioButton = (RadioButton) locationToggle.getSelectedToggle();
//        Store.Location storeLocation = Store.Location.valueOf(selectedRadioButton.getText());
//        System.out.println("Selected Option: " + storeLocation);
//
////        displayName(username);
//
//        initializeStore(storename, username, storeLocation, numberOfChair);
////        yourStore = new Store(storename, username, storeLocation, numberOfChair);
//        System.out.println(yourStore.getName());
//
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("hiringEmployee.fxml"));
//        root = loader.load();
//
//        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//        displayName(yourStore.getOwnerName());
//
//    }
//
//    public void switchRamenMenu2Test(ActionEvent event) throws IOException {
//
////        Choose flavour
//        RadioButton selectedFlavourRadioButton = (RadioButton) flavour.getSelectedToggle();
//        String ramenFlavour = selectedFlavourRadioButton.getText();
//        System.out.println("Selected Option: " + ramenFlavour);
//
//        RadioButton selectedSizeRadioButton = (RadioButton) size.getSelectedToggle();
//        String ramenSize = selectedSizeRadioButton.getText();
//        System.out.println("Selected Option: " + ramenSize);
//
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("ramenMenu2.fxml"));
//        root = loader.load();
//
//        yourRamen = initializeMenu(ramenFlavour, ramenSize);
//        displayMaterialPrice(yourRamen);
//
//        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//    }
//
//    public void displayMaterialPrice(Menu yourRamen) {
//        String materialCostString = Double.toString(yourRamen.getMaterialCost());
//        materialFeeLabel.setText(materialCostString);
//    }
//
//    public void switchRamenMenu3Test(ActionEvent event) throws IOException {
//        StringBuilder selectedItems = new StringBuilder();
//        ArrayList<Menu.Topping> toppingList = new ArrayList<>();
//        if (chashu.isSelected()) {
//            toppingList.add(Menu.Topping.chashu);
//            System.out.println("Selected Items: chashu");
//        }
//        if (tamago.isSelected()) {
//            toppingList.add(Menu.Topping.tamago);
//            System.out.println("Selected Items: tamago");
//        }
//        if (corn.isSelected()) {
//            toppingList.add(Menu.Topping.corn);
//            System.out.println("Selected Items: corn");
//        }
//        if (seaweed.isSelected()) {
//            toppingList.add(Menu.Topping.seaweed);
//            System.out.println("Selected Items: seaweed");
//        }
//
//        RamenMenu1Controller.yourRamen.setToppings(toppingList);
//        System.out.println(RamenMenu1Controller.yourRamen.getToppings());
//
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("ramenMenu3.fxml"));
//        root = loader.load();
//
//        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//    }
//
//    public  Store initializeStore(String storename, String username, Store.Location storeLocation, int numberOfChair) {
//        yourStore = new Store(storename, username, storeLocation, numberOfChair);
//        return yourStore;
//    }
//
//    public Menu initializeMenu(String ramenFlavour, String ramenSize) {
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
//        return yourRamen;
//    }
//}
