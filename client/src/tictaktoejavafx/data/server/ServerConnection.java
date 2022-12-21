package tictaktoejavafx.data.server;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import tictaktoejavafx.controller.GameBoardControllerOnline;
import tictaktoejavafx.data.model.HistoryDataModel;
import tictaktoejavafx.data.model.Player;
import tictaktoejavafx.utils.Config;
import tictaktoejavafx.utils.ExceptionCallBack;
import tictaktoejavafx.utils.LocalMultiPlayer;
import tictaktoejavafx.utils.Navigator;
import tictaktoejavafx.utils.UserMessage;
import tictaktoejavafx.utils.CallBackAction;

public class ServerConnection {

    private static ServerConnection serverConnection;
    private static DataOutputStream dataOutputStream;
    private static DataInputStream dataInputStream;
    private String UID;
    private ServerCall serverCall;
    public static Socket socket;
    private static Thread thread;
    private static Stage stage;
    private static int index = 0;
    public static ArrayList<String> diagonals = new ArrayList<>();
    private static ExceptionCallBack exceptionCallBack;

    private ServerConnection(Stage stage, String ip, int port, ExceptionCallBack exceptionCallBack) throws IOException {
        this.exceptionCallBack = exceptionCallBack;
        this.stage = stage;
        socket = new Socket(ip, port);
        dataOutputStream = new DataOutputStream(socket.getOutputStream());
    }

    public static ServerConnection getInstance(Stage stage, String ip, int port, ExceptionCallBack exceptionCallBack) throws IOException {
        if (serverConnection == null) {
            serverConnection = new ServerConnection(stage, ip, port, exceptionCallBack);
        }
        return serverConnection;
    }

    public static void sendMessage(String message) throws IOException {
        dataOutputStream.writeUTF(message);
    }

    public synchronized static void readThread() throws IOException {
        if (thread == null) {
            thread = new Thread(() -> {
                while (true) {

                    try {
                        dataInputStream = new DataInputStream(socket.getInputStream());
                        String str = dataInputStream.readUTF();
                        System.out.println("we rec " + str);
                        if (str != null && !str.isEmpty()) {
                            System.out.println(str);
                            getMessage(str);
                        }
                    } catch (IOException ex) {
                        exceptionCallBack.serverException(ex);
                    }
                }
            });
            thread.start();

        } else {

        }

    }

    public static void diagFill() {
        if (diagonals == null) {

            diagonals = new ArrayList<>();

        }
        diagonals.add(GameBoardControllerOnline.arrlistButtons2.get(0).getText() + GameBoardControllerOnline.arrlistButtons2.get(1).getText()
                + GameBoardControllerOnline.arrlistButtons2.get(2).getText());
        diagonals.add(GameBoardControllerOnline.arrlistButtons2.get(3).getText() + GameBoardControllerOnline.arrlistButtons2.get(4).getText()
                + GameBoardControllerOnline.arrlistButtons2.get(5).getText());
        diagonals.add(GameBoardControllerOnline.arrlistButtons2.get(6).getText() + GameBoardControllerOnline.arrlistButtons2.get(7).getText()
                + GameBoardControllerOnline.arrlistButtons2.get(8).getText());
        diagonals.add(GameBoardControllerOnline.arrlistButtons2.get(0).getText() + GameBoardControllerOnline.arrlistButtons2.get(3).getText()
                + GameBoardControllerOnline.arrlistButtons2.get(6).getText());
        diagonals.add(GameBoardControllerOnline.arrlistButtons2.get(1).getText() + GameBoardControllerOnline.arrlistButtons2.get(4).getText()
                + GameBoardControllerOnline.arrlistButtons2.get(7).getText());
        diagonals.add(GameBoardControllerOnline.arrlistButtons2.get(2).getText() + GameBoardControllerOnline.arrlistButtons2.get(5).getText()
                + GameBoardControllerOnline.arrlistButtons2.get(8).getText());
        diagonals.add(GameBoardControllerOnline.arrlistButtons2.get(0).getText() + GameBoardControllerOnline.arrlistButtons2.get(4).getText()
                + GameBoardControllerOnline.arrlistButtons2.get(8).getText());
        diagonals.add(GameBoardControllerOnline.arrlistButtons2.get(2).getText() + GameBoardControllerOnline.arrlistButtons2.get(4).getText()
                + GameBoardControllerOnline.arrlistButtons2.get(6).getText());

    }

    public static void getMessage(String msg) {
        System.out.println(msg); // log
        
        if (msg != null && !msg.isEmpty()) {
            String[] data = msg.split(ServerCall.DELIMETER);
            switch (data[0]) {
                case ServerCall.LOGIN_RECEIVER:
                    Platform.runLater(() -> {
                        if (data[1].equals("0")) {
                            UserMessage.showError("You Must register plz");
                        } else {
                            ArrayList<Player> playerList = new ArrayList();
                            Gson gson = new Gson();
                            java.lang.reflect.Type listType = new TypeToken<ArrayList<Player>>() {
                            }.getType();
                            playerList = gson.fromJson(data[1], listType);
                            Navigator.navigate(Navigator.PLAYER_SELECTION, stage,playerList);
                        }
                    });
                    break;

                case ServerCall.IVETATION_RECEIVE:
                    Platform.runLater(() -> {
                        try {
                            displayAlert(data[1]);
                        } catch (IOException ex) {
                            Logger.getLogger(ServerConnection.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    });
                    break;
                case ServerCall.CONFIRMATION_RECEIVE:

                    Platform.runLater(() -> {
                        System.out.println("I recived");
                        Navigator.navigate(Navigator.GAMEBOARDONLINE, stage);
                    });
                    break;
                case ServerCall.MOVEMENT_RECEIVE:
                    System.out.println("we got a move");
                    Navigator.setButtonNumber(data[2]);
                    Navigator.setBoardMove(data[3]);
                    if (data[3].equals("X")) {
                        Navigator.setSetX(false);
                    } else {
                        Navigator.setSetX(true);
                    }
                    Platform.runLater(() -> {
                        GameBoardControllerOnline.arrlistButtons2.get(Integer.parseInt(data[2]) - 1).setText(data[3]);
                        GameBoardControllerOnline.arrlistButtons2.get(Integer.parseInt(data[2]) - 1).setDisable(true);
                        enableAll();
                        diagFill();
                        if (!LocalMultiPlayer.getGameEnded()) {
                            LocalMultiPlayer.localMulti(diagonals, GameBoardControllerOnline.getStage());
                            LocalMultiPlayer.drawChecker(GameBoardControllerOnline.getStage());
                            if (LocalMultiPlayer.getGameEnded()) {
                                GameBoardControllerOnline.arrlistButtons2 = null;
                                LocalMultiPlayer.setGameEnded(false);
                                diagonals = null;
                            }
                        }
                    });
                    break;

                case ServerCall.RREGISTER_RECEIVE:
                    Platform.runLater(() -> {
                        if (data[1].equals("0")) {
                            UserMessage.showError("There are an Error During Register");
                        } else {
                            ArrayList<Player> playerList = new ArrayList();
                            Gson gson = new Gson();
                            java.lang.reflect.Type listType = new TypeToken<ArrayList<Player>>() {
                            }.getType();
                            playerList = gson.fromJson(data[1], listType);
                            Navigator.navigate(Navigator.PLAYER_SELECTION, stage,playerList);
                        }
                    });

                default:
                    break;

            }
        }

    }

    public static void closeThread() throws IOException {
        if(dataInputStream!=null){
            dataInputStream.close();
            
        }
        if(socket!=null){
            if(socket.isClosed()){
                socket.close();
            }
            
        }
        if(thread!=null){
            if(thread.isAlive()){
                thread.stop();
            }
        }
        
        serverConnection = null;

    }

    public static void displayAlert(String Playerx) throws IOException {
        Alert alert = new Alert(Alert.AlertType.WARNING);

        alert.setTitle("Invitation");
        alert.setHeaderText(Playerx + " Invite you to Play Game");
        alert.setContentText("Do you want to Accept Invitation");

        ButtonType acceptButton = new ButtonType("Accept");
        ButtonType cancelButton = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(acceptButton, cancelButton);
        if (alert.showAndWait().get() == acceptButton) {
            //-------------------------------------
            System.out.println("Player O Accept Your Invetation");
            Navigator.setStartGame(false);
            sendMessage(ServerCall.CONFIRMATION_SEND + ServerCall.DELIMETER + Playerx);
            Navigator.setPlayerOne(Playerx);
            Navigator.setPlayerTwo("Hussin");
            Platform.runLater(() -> {
                Navigator.navigate(Navigator.GAMEBOARDONLINE, stage);
            });

        } else {
            System.out.println("Player O Cancle");
        }
    }
    
    public static void enableAll(){
        for(int i=0;i<GameBoardControllerOnline.arrlistButtons.size();i++){
            if(GameBoardControllerOnline.arrlistButtons.get(i).getText().isEmpty()){
                GameBoardControllerOnline.arrlistButtons.get(i).setDisable(false);
            }
        }
    }

}
