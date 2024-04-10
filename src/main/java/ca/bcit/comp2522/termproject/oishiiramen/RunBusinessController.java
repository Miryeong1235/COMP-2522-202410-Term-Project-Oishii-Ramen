package ca.bcit.comp2522.termproject.oishiiramen;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

/**
 * Run business controller.
 *
 * @author Atsuko Uemura, Misuzu Taniguchi
 * @version 12-April-2024
 */
public class RunBusinessController {
    /**
     * Duration per single movement.
     */
    public static final double MOVE_DURATION_IN_SECOND = 0.5;

    /**
     * Duration per single movement.
     */
    public static final double MOVE_DISTANCE_IN_PIXEL = 30.0;

    /**
     * Duration per single movement.
     */
    public static final int NUMBER_OF_MOVEMENT = 6;


    @FXML
    private ImageView yugiri;

    /**
     * Initializes the page.
     */
    public void initialize() {
        // move an ImageView to the right and the left
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO, e -> yugiri.setTranslateX(0)), // initial position
                new KeyFrame(Duration.seconds(MOVE_DURATION_IN_SECOND),
                        e -> yugiri.setTranslateX(MOVE_DISTANCE_IN_PIXEL)) // move right
        );
        timeline.setAutoReverse(true); // go back to left
        timeline.setCycleCount(NUMBER_OF_MOVEMENT);

        // after finished the movement, load new fxml
        timeline.setOnFinished(event -> {
            System.out.println("Run Finished");
            loadNextFXML();
        });
        timeline.play();
    }

    /**
     * Moves to business result page on our JavaFX UI.
     */
    public void loadNextFXML() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("businessResult.fxml"));
            Parent root = loader.load();

            // display result
            BusinessResultController businessResultController = loader.getController();
            businessResultController.displayResult(GameApplication.yourStore);

            Scene scene = yugiri.getScene();
            Scene nextScene = new Scene(root);
            Stage stage = (Stage) scene.getWindow();

            stage.setScene(nextScene);
            stage.show();
        } catch (IOException e) {
            System.out.println("IOException is caught during loading next fxml page.");
        }
    }
}
