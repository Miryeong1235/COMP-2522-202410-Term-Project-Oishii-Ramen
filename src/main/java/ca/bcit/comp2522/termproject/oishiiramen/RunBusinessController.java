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

public class RunBusinessController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private ImageView yugiri;

    public void initialize() {

        // ImageViewを左右に動かすアニメーションを作成
        double durationSeconds = 0.5;
        double distance = 30.0;
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO, e -> yugiri.setTranslateX(0)), // 初期位置
                new KeyFrame(Duration.seconds(durationSeconds), e -> yugiri.setTranslateX(distance)) // 右に移動
        );
        timeline.setAutoReverse(true); // 往復するように設定
        timeline.setCycleCount(6); // 往復を2回行う
        timeline.setOnFinished(event -> {
            // FXMLのロードと画面遷移
            System.out.println("Run Finished");
            loadNextFXML();
        });
        timeline.play(); // start animation
    }

    private void loadNextFXML() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("businessResult.fxml"));
            Parent root = loader.load(); // FXMLファイルのルート要素を取得

            Scene scene = yugiri.getScene();
            Scene nextScene = new Scene(root);
            Stage stage = (Stage) scene.getWindow();

            stage.setScene(nextScene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
