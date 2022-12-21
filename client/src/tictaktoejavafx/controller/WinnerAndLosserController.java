package tictaktoejavafx.controller;

import java.io.IOException;
import java.nio.file.Paths;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import tictaktoejavafx.data.model.WinnerName;
import tictaktoejavafx.data.server.ServerConnection;
import tictaktoejavafx.utils.Config;
import tictaktoejavafx.utils.Navigator;
import tictaktoejavafx.utils.UserMessage;
import tictaktoejavafx.view.WinnerAndlosserScreenBase;
import tictaktoejavafx.utils.CallBackAction;

public class WinnerAndLosserController extends WinnerAndlosserScreenBase {

    private final Stage stage;
    MediaPlayer mediaPlayer;
    
    public WinnerAndLosserController(Stage stage) {
        this.stage = stage;
       // user_win.setText(WinnerName.getWinnerName());
        String name = WinnerName.getWinnerName();
        if (name.equals(Config.PLAYER_X)) {
            
            String videoPath = Paths.get(Config.WINNER_VIDEO).toUri().toString();
            
            mediaVideo(videoPath);
        } else if (name.equals(Config.PLAYER_O)) {
            String videoPath = Paths.get(Config.LOSSER_VIDEO).toUri().toString();
            mediaVideo(videoPath);
            
        }else{
          String videoPath = Paths.get(Config.DRAW_VIDEO).toUri().toString();
            mediaVideo(videoPath);
        }
        this.stage.setOnCloseRequest((WindowEvent event) -> {
            try {
                ServerConnection.closeThread();
            } catch (IOException ex) {
                new UserMessage().display(ex.getMessage(), new CallBackAction(){
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
         mediaPlayer = new MediaPlayer(media);
         mediaView.setMediaPlayer(mediaPlayer);
         mediaPlayer.play(); 
    }

    @Override
    protected void onHomeButtonClicked(ActionEvent actionEvent) {
  mediaPlayer.stop();
 
        Navigator.navigate(Navigator.WELCOME, stage);
    }

    @Override
    protected void onPlayAgainClicked(ActionEvent actionEvent) {
          mediaPlayer.stop();

        Navigator.navigate(Navigator.RECORD, stage);
    }

    @Override
    protected void onResultsClicked(ActionEvent actionEvent) {
          mediaPlayer.stop();
    }
}
