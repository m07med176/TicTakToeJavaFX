package tictaktoejavafx.controller;

import java.nio.file.Paths;
import javafx.event.ActionEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import tictaktoejavafx.data.model.PlayerName;
import tictaktoejavafx.utils.Config;
import tictaktoejavafx.utils.Navigator;
import tictaktoejavafx.view.WinnerAndlosserScreenBase;

public class WinnerAndLosserController extends WinnerAndlosserScreenBase {

    private final Stage stage;

    public WinnerAndLosserController(Stage stage) {
        this.stage = stage;
        String name = PlayerName.getPlayerName();
        if (name.equals("Player 1")) {
            String videoPath = Paths.get(Config.WINNER_VIDEO).toUri().toString();
            mediaVideo(videoPath);
        } else if (name.equals("Player 2")) {
            String videoPath = Paths.get(Config.LOSSER_VIDEO).toUri().toString();
            mediaVideo(videoPath);
        }
    }

    void mediaVideo(String videoPlayPath) {
        Media media = new Media(videoPlayPath);
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);
        mediaPlayer.play();

    }

    @Override
    protected void onHomeButtonClicked(ActionEvent actionEvent) {
        Navigator.navigate(Navigator.WELCOME, stage);
    }

    @Override
    protected void onPlayAgainClicked(ActionEvent actionEvent) {
        Navigator.navigate(Navigator.RECORD, stage);
    }

    @Override
    protected void onResultsClicked(ActionEvent actionEvent) {
        System.out.println("On Result Clicked");

    }
}
