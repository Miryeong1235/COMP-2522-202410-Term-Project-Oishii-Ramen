module ca.bcit.comp2522.termproject.oishiiramen {
    requires javafx.controls;
    requires javafx.fxml;


    opens ca.bcit.comp2522.termproject.oishiiramen to javafx.fxml;
    exports ca.bcit.comp2522.termproject.oishiiramen;
}