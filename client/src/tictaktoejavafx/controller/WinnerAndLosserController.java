package tictaktoejavafx.controller;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import tictaktoejavafx.data.model.PlayerName;
import tictaktoejavafx.data.server.ServerConnection;
import tictaktoejavafx.utils.AlertAction;
import tictaktoejavafx.utils.Config;
import tictaktoejavafx.utils.Navigator;
import tictaktoejavafx.utils.UserMessage;
import tictaktoejavafx.view.WinnerAndlosserScreenBase;

public class WinnerAndLosserController extends WinnerAndlosserScreenBase {

    private final Stage stage;

    public WinnerAndLosserController(Stage stage) {
        this.stage = stage;
        user_win.setText(PlayerName.getPlayerName());
        String name = PlayerName.getPlayerName();
        if (name.equals("Player 1")) {
            String videoPath = Paths.get(Config.WINNER_VIDEO).toUri().toString();
            mediaVideo(videoPath);
        } else if (name.equals("Player 2")) {
            String videoPath = Paths.get(Config.LOSSER_VIDEO).toUri().toString();
            mediaVideo(videoPath);
            
        }
        this.stage.setOnCloseRequest((WindowEvent event) -> {
            try {
                ServerConnection.closeThread();
            } catch (IOException ex) {
                new UserMessage().display(ex.getMessage(), new AlertAction(){
                    @Override
                    public void sendOk() {
                        Navigator.navigate(Navigator.WELCOME, stage);
                    }
                    
                    @Override
                    public void sendCancel() {
                        // Do Nothing
                    }
                },Alert.AlertType.ERROR);
            }
        });
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
        Navigator.back(stage);
    }

    @Override
    protected void onResultsClicked(ActionEvent actionEvent) {
        System.out.println("On Result Clicked");

    }
}
