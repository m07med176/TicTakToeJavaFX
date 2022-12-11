package tictaktoejavafx.controller;

import java.nio.file.Paths;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import tictaktoejavafx.utils.AssetsRepository;
import tictaktoejavafx.utils.PathManager;
import tictaktoejavafx.utils.PlayerName;
import tictaktoejavafx.view.WinnerAndlosserScreenBase;

public class WinnerAndLosserController extends WinnerAndlosserScreenBase{
    private final Stage stage;

    public WinnerAndLosserController(Stage stage) {
        this.stage = stage;
        String name=PlayerName.getPlayerName();
        if(name.equals("Player 1")){
                    playVideoWinner();
        }else if(name.equals("Player 2")){
                    playVideoLoser();
        }
    }
    
    public void playVideoWinner(){
        // TODO Video Player Fix Error Should Fix
        new Thread(() -> {
            try{
            
                String videoPath = Paths.get(AssetsRepository.WINNER_VIDEO).toUri().toString();
                Media media = new Media(videoPath);
                MediaPlayer mediaPlayer=new MediaPlayer(media);
                mediaView.setMediaPlayer(mediaPlayer);
                mediaPlayer.play();
            }catch(Exception e){
                e.printStackTrace();
            }
        }).start();
        
    }
        public void playVideoLoser(){
        // TODO Video Player Fix Error Should Fix
        new Thread(() -> {
            try{
            
                String videoPath = Paths.get(AssetsRepository.LOSSER_VIDEO).toUri().toString();
                Media media = new Media(videoPath);
                MediaPlayer mediaPlayer=new MediaPlayer(media);
                mediaView.setMediaPlayer(mediaPlayer);
                mediaPlayer.play();
            }catch(Exception e){
                e.printStackTrace();
            }
        }).start();
        
    }
}
