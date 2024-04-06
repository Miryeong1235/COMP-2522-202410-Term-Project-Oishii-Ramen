package ca.bcit.comp2522.termproject.oishiiramen;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
public class RunBusinessController {

    @FXML
    private ImageView yugiri;

    public void initialize() {
        // 画像を右に移動するアニメーションを作成
        TranslateTransition transitionRight = new TranslateTransition(Duration.seconds(1), yugiri);
        transitionRight.setToX(30); // 右に100ピクセル移動

        // 画像を左に移動するアニメーションを作成
        TranslateTransition transitionLeft = new TranslateTransition(Duration.seconds(1), yugiri);
        transitionLeft.setToX(-30); // 左に100ピクセル移動

        // アニメーションを交互に実行
        transitionRight.setOnFinished(event -> transitionLeft.play());
        transitionLeft.setOnFinished(event -> transitionRight.play());

        // 最初に右に移動するアニメーションを開始
        transitionRight.play();
    }
}
