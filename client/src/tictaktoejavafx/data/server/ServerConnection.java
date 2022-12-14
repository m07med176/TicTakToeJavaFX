package tictaktoejavafx.data.server;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.DataInputStream;
import java.io.DataOutputStream;
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
import tictaktoejavafx.data.model.Player;
import tictaktoejavafx.utils.ExceptionCallBack;
import tictaktoejavafx.utils.LocalMultiPlayer;
import tictaktoejavafx.utils.Navigator;
import tictaktoejavafx.utils.UserMessage;

public class ServerConnection {

    private static ServerConnection serverConnection;
    private static DataOutputStream dataOutputStream;
    private static DataInputStream dataInputStream;
    public static String UID;
    private ServerCall serverCall;
    public static Socket socket;
    private static Thread thread;
    private static Stage stage;
    private static int index = 0;
    public static ArrayList<String> diagonals = new ArrayList<>();
    private static ExceptionCallBack exceptionCallBack;
    public static boolean inGame=false;
    public static LocalMultiPlayer local;

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
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                exceptionCallBack.serverException(ex);
                            }
                        });
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
                            Navigator.setSetPlayerData(playerList);
                            Navigator.setIsValid(true);
                            Navigator.setPlayerStage(Navigator.PLAYER_SELECTION);
                            Navigator.navigate(Navigator.PLAYER_SELECTION, stage,playerList);
                        }
                    });
                    break;

                case ServerCall.IVETATION_RECEIVE:
                    Platform.runLater(() -> {
                        try {
                            if(data[1].equals("NOT_AVA")){
                                UserMessage.showError("User is in a game");
                            }else{
                                displayAlert(data[1]);
                            }
                            
                        } catch (IOException ex) {
                            Logger.getLogger(ServerConnection.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    });
                    break;
                case ServerCall.CONFIRMATION_RECEIVE:

                    Platform.runLater(() -> {
                        System.out.println("I recived");
                        inGame=true;
                        Navigator.setPlayerOne(UID);
                        Navigator.setPlayerTwo(data[1]);
                        Navigator.setStartGame(true);
                        Navigator.setSetX(true);
                        Navigator.setPlayerStage(Navigator.GAMEBOARDONLINE);
                        Navigator.navigate(Navigator.GAMEBOARDONLINE, stage);
                    });
                    break;
                case ServerCall.MOVEMENT_RECEIVE:
                    System.out.println("we got a move");
                    executeMove(data[2], data[3]);
                    break;

                case ServerCall.RREGISTER_RECEIVE:
                    Platform.runLater(() -> {
                        if (data[1].equals("0")) {
                            UserMessage.showError("There are an Error During Register You may Signed");
                        } else {
                            ArrayList<Player> playerList = new ArrayList();
                            Gson gson = new Gson();
                            java.lang.reflect.Type listType = new TypeToken<ArrayList<Player>>() {
                            }.getType();
                            playerList = gson.fromJson(data[1], listType);
                            Navigator.setSetPlayerData(playerList);
                            Navigator.setPlayerStage(Navigator.PLAYER_SELECTION);
                            
                            Navigator.navigate(Navigator.PLAYER_SELECTION, stage,playerList);
                        }
                    });
                case ServerCall.PLAYER_LIST_RESEND:
                    if(inGame){}else{
                    Platform.runLater(() -> {
                        System.out.println(data[1]);
                        ArrayList<Player> playerList = new ArrayList();
                        Gson gson = new Gson();
                        java.lang.reflect.Type listType = new TypeToken<ArrayList<Player>>() {
                        }.getType();
                        playerList = gson.fromJson(data[1], listType);
                        Navigator.setSetPlayerData(playerList);
                        if(Navigator.getPlayerStage()==Navigator.PLAYER_SELECTION){
                            Navigator.navigate(Navigator.PLAYER_SELECTION, stage,playerList);
                        }
                        //Navigator.navigate(Navigator.PLAYER_SELECTION, stage);
                    });
                    
                    }
                    

                default:
                    break;

            }
        }

    }

    public static void closeThread() throws IOException {
        if (dataOutputStream != null) {
            dataOutputStream.writeUTF(ServerCall.CLOSE_SEND + ServerCall.DELIMETER + UID);
            dataOutputStream.close();
        }
        if (dataInputStream != null) {
            dataInputStream.close();
        }
        if (socket != null) {
            if (socket.isClosed()) {
                socket.close();
            }
        }
        if (thread != null) {
            if (thread.isAlive()) {
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
            Navigator.setPlayerTwo(UID);
            inGame=true;
            Platform.runLater(() -> {
                Navigator.setPlayerStage(Navigator.GAMEBOARDONLINE);
                Navigator.navigate(Navigator.GAMEBOARDONLINE, stage);
            });

        } else {
            System.out.println("Player O Cancle");
        }
    }

    public static void enableAll() {
        for (int i = 0; i < GameBoardControllerOnline.arrlistButtons.size(); i++) {
            if (GameBoardControllerOnline.arrlistButtons.get(i).getText().isEmpty()) {
                GameBoardControllerOnline.arrlistButtons.get(i).setDisable(false);
            }
        }
    }

    public static void executeMove(String index, String data) {
        if(local==null){
            local=new LocalMultiPlayer();
        }
        System.out.println("we got a move");
        //Navigator.setButtonNumber(data[2]);
        //Navigator.setBoardMove(data[3]);
        if (data.equals("X")) {
            Navigator.setSetX(false);
        } else {
            Navigator.setSetX(true);
        }
        Platform.runLater(() -> {
            GameBoardControllerOnline.arrlistButtons2.get(Integer.parseInt(index) - 1).setText(data);
            GameBoardControllerOnline.arrlistButtons2.get(Integer.parseInt(index) - 1).setDisable(true);

            enableAll();
            diagFill();
            if (!local.getGameEnded()) {
                try {
                    
                    local.localMulti(diagonals, GameBoardControllerOnline.stage);
                    System.out.println("helllllllllllooooooooooooooo");
                    local.drawChecker(GameBoardControllerOnline.stage);
                    if (local.getGameEnded()) {
                        inGame=false;
                        
                        GameBoardControllerOnline.arrlistButtons2 = null;
                        local.setGameEnded(false);
                        
                        //sendMessage(ServerCall.GAME_ENDED+ServerCall.DELIMETER+UID);
                        diagonals = null;
                        local=null;
                    }
                } catch (IOException ex) {
                    UserMessage.showError(ex.getMessage());
                }
            }
        });

    }

}
