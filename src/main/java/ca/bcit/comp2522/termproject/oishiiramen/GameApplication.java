package ca.bcit.comp2522.termproject.oishiiramen;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Application to control game flow.
 *
 * @author Atsuko Uemura, Misuzu Taniguchi
 * @version 12-April-2024
 */
public class GameApplication extends Application {

    private static Store yourStore;

    /**
     * Starts the application by loading the welcome screen.
     *
     * @param stage the primary stage of the application
     * @throws IOException if an error occurs while loading the FXML file
     */
    @Override
    public void start(final Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(GameApplication.class.getResource("welcome.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Oishii Ramen Yokoso!");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Drive the program.
     * @param args unused
     */
    public static void main(final String[] args) {
        launch();
    }

    /**
     * Initializes a new store with the provided details.
     *
     * @param storeName      the name of the Store
     * @param username       the owner name
     * @param storeLocation  the location of the Store (Downtown, Richmond, or Metrotown)
     * @param numberOfChair  the number of chairs in the Store
     * @return the initialized Store
     * @throws IllegalArgumentException if the location is invalid
     */
    public static Store initializeStore(final String storeName, final String username,
                                        final Store.Location storeLocation, final int numberOfChair) {
        yourStore = new Store(storeName, username, storeLocation, numberOfChair);
        return yourStore;
    }

    /**
     * Returns yourStore.
     *
     * @return a static variable yourStore as a Store object
     */
    public static Store getYourStore() {
        return yourStore;
    }
}
