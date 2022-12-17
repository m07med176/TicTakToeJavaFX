package tictaktoejavafx.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import tictaktoejavafx.data.model.PlayerModel;
import tictaktoejavafx.utils.AlertAction;
import tictaktoejavafx.utils.Config;
import tictaktoejavafx.utils.LocalMultiPlayer;
import tictaktoejavafx.utils.Navigator;
import static tictaktoejavafx.utils.Navigator.RECORD;
import tictaktoejavafx.utils.RecordClass;
import tictaktoejavafx.utils.UserMessage;
import tictaktoejavafx.view.GameBoardScreenBase;

public class GameBoardMultiController extends GameBoardScreenBase {

    private Stage stage;
    ArrayList<String> diagonals = new ArrayList<>();
    public static char turn = 'X';
    Gson gson = new Gson();
    RecordClass recordClass = new RecordClass();
    PlayerModel model;

    public GameBoardMultiController(Stage stage) {
        this.stage = stage;

        label_player1.setText(Navigator.getPlayerOne());
        label_player2.setText(Navigator.getPlayerTwo());
    }

    @Override
    protected void isGameOne(ActionEvent actionEvent) {
        gameTurns(btn_Game_one);
        recordClass.add("1" + btn_Game_one.getText());
        pars(model);
    }

    @Override
    protected void isGameFour(ActionEvent actionEvent) {
        gameTurns(btn_Game_four);
        recordClass.add("4" + btn_Game_four.getText());
        pars(model);

    }

    @Override
    protected void isGameSeven(ActionEvent actionEvent) {
        gameTurns(btn_Game_seven);
        recordClass.add("7" + btn_Game_seven.getText());
        pars(model);

    }

    @Override
    protected void isGameTwo(ActionEvent actionEvent) {
        gameTurns(btn_Game_two);
        recordClass.add("2" + btn_Game_two.getText());
        pars(model);

    }

    @Override
    protected void isGameThree(ActionEvent actionEvent) {
        gameTurns(btn_Game_three);
        recordClass.add("3" + btn_Game_three.getText());
        pars(model);

    }

    @Override
    protected void isGameFive(ActionEvent actionEvent) {
        gameTurns(btn_Game_five);
        recordClass.add("5" + btn_Game_five.getText());
        pars(model);

    }

    @Override
    protected void isGameSix(ActionEvent actionEvent) {
        gameTurns(btn_Game_six);
        recordClass.add("6" + btn_Game_six.getText());
        pars(model);

    }

    @Override
    protected void isGameEight(ActionEvent actionEvent) {
        gameTurns(btn_Game_eight);
        recordClass.add("8" + btn_Game_eight.getText());
        pars(model);

    }

    @Override
    protected void isGameNine(ActionEvent actionEvent) {
        gameTurns(btn_Game_nine);
        recordClass.add("9" + btn_Game_nine.getText());
        pars(model);

    }

    public void gameTurns(Button button) {

        if (turn == 'X') {

            button.setText("X");
            turn = 'O';
            button.setDisable(true);
            diagonalFiller();
            LocalMultiPlayer.localMulti(diagonals, stage);
            LocalMultiPlayer.drawChecker(stage);

        } else {

            button.setText("O");
            turn = 'X';
            button.setDisable(true);
            diagonalFiller();
            LocalMultiPlayer.localMulti(diagonals, stage);
            LocalMultiPlayer.drawChecker(stage);

        }

    }

    public void diagonalFiller() {
        diagonals.add(btn_Game_one.getText() + btn_Game_two.getText() + btn_Game_three.getText());
        diagonals.add(btn_Game_four.getText() + btn_Game_five.getText() + btn_Game_six.getText());
        diagonals.add(btn_Game_seven.getText() + btn_Game_eight.getText() + btn_Game_nine.getText());
        diagonals.add(btn_Game_one.getText() + btn_Game_four.getText() + btn_Game_seven.getText());
        diagonals.add(btn_Game_two.getText() + btn_Game_five.getText() + btn_Game_eight.getText());
        diagonals.add(btn_Game_three.getText() + btn_Game_six.getText() + btn_Game_nine.getText());
        diagonals.add(btn_Game_one.getText() + btn_Game_five.getText() + btn_Game_nine.getText());
        diagonals.add(btn_Game_three.getText() + btn_Game_five.getText() + btn_Game_seven.getText());

    }

    public void pars(PlayerModel model) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("src/tictaktoejavafx/data/db/Record.json")))) {
            Gson gson = new Gson();
            List<PlayerModel> player;
            java.lang.reflect.Type listType = new TypeToken<ArrayList<PlayerModel>>() {
            }.getType();
            try {
                player = gson.fromJson(bufferedReader, listType);
            } catch (Exception ex) {
                player = new ArrayList();
            }
            player.add(model);
            FileWriter fileWriter = new FileWriter(new File("src/tictaktoejavafx/data/db/Record.json"));
            new Gson().toJson(player, fileWriter);
            fileWriter.close();
            bufferedReader.close();
        } catch (IOException ex) {
            ex.printStackTrace();

        }
    }
//            if(LocalMultiPlayer.getGameEnded()){
//            try {
//                Writer writer=Files.newBufferedWriter(Paths.get("src/tictaktoejavafx/data/db/rec.json"));
//                gson.toJson(recordClass,writer);
//                writer.close();
//                System.out.println("done");
//            } catch (IOException ex) {
//                Logger.getLogger(GameBoardMultiController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        
//        }
//    
    //}

    @Override
    protected void onBackClicked(ActionEvent actionEvent) {
        new UserMessage().display(Config.EXIT_MSG, new AlertAction() {
            @Override
            public void sendOk() {
                Navigator.navigate(Navigator.WELCOME, stage);
            }

            @Override
            public void sendCancel() {
                // Do Nothing
            }
        }, Alert.AlertType.CONFIRMATION);

    }

    @Override
    protected void isVideo(ActionEvent actionEvent) {
        Navigator.navigate(Navigator.RECORD, stage);

    }

}
