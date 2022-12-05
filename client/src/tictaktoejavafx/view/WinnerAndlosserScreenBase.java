package tictaktoejavafx.view;

import java.nio.file.Paths;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import tictaktoejavafx.utils.PlayerName;

public abstract class WinnerAndlosserScreenBase extends AnchorPane {

    protected final Label label;
    protected final Label user_win;
    protected final MediaView mediaView;

    public WinnerAndlosserScreenBase() {

        label = new Label();
        user_win = new Label();
        mediaView = new MediaView();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(512.0);
        setPrefWidth(845.0);

        label.setLayoutX(342.0);
        label.setLayoutY(38.0);
        label.setPrefHeight(43.0);
        label.setPrefWidth(92.0);
        label.setText("Winner is ");

     

        user_win.setLayoutX(423.0);
        user_win.setLayoutY(49.0);
        user_win.setText(PlayerName.getPlayerName());

        mediaView.setFitHeight(400.0);
        mediaView.setFitWidth(400.0);
        mediaView.setLayoutX(295.0);
        mediaView.setLayoutY(143.0);

        getChildren().add(label);
        getChildren().add(user_win);
        getChildren().add(mediaView);

        //---------------------------------
        
       /* String VUrl="tictaktoejavafx/assets/winnerVideo.mp4";
  Media media = new Media(Paths.get(VUrl).toUri().toString());

        MediaPlayer mediaPlayer=new MediaPlayer(media);
        mediaView.setFitHeight(800);
        mediaView.setFitWidth(600);
        mediaView.setMediaPlayer(mediaPlayer);
        mediaPlayer.play();
        }catch(Exception e){
            e.printStackTrace();*/
       
        
        //---------------------------------
    }
}
