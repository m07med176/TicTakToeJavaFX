package tictaktoejavafx.data.server;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import tictaktoejavafx.controller.GameBoardControllerOnline;
import tictaktoejavafx.utils.AlertAction;
import tictaktoejavafx.utils.LocalMultiPlayer;
import tictaktoejavafx.utils.Navigator;
import tictaktoejavafx.utils.UserMessage;

public class ServerConnection {

    private static PrintStream printStream;
    private String UID;
    private ServerCall serverCall;

    public static Socket socket;
    private static ServerConnection serverConnection = null;
    private static Thread thread = null;
    private static DataInputStream dataInputStream;
    private static Stage stage;
    private static int i=0;
    public static ArrayList<String> diagonals=new ArrayList<>();
    private ServerConnection() throws IOException {

        startSocket();
    }

    public static ServerConnection createInstance(Stage s) throws IOException {
        if (serverConnection == null) {
            serverConnection = new ServerConnection();
        }
        stage = s;
        return serverConnection;
    }

    private static void startSocket() throws IOException {
        socket = new Socket("127.0.0.1", 5005);

    }

    public static void sendMessage(String message,Stage s) {
        stage=s;
        DataOutputStream printStream = null;
        try {
            System.out.println("we sent "+message);
            printStream = new DataOutputStream(socket.getOutputStream());
            printStream.writeUTF(message);
        } catch (IOException e) {
            System.out.println("Server cant send");
        }
    }

    public synchronized static void readThread() {
        System.out.println("byeeeeeeeeeeee");
        if(thread ==null){
            thread = new Thread(() -> {
            while (true) {
                
                try {
                    dataInputStream = new DataInputStream(socket.getInputStream());
                    String str = dataInputStream.readUTF();
                    //BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    //String str = bufferedReader.readLine();
                    System.out.println("we rec "+str);
                    if (str != null && !str.isEmpty()) {
                        System.out.println(str);
                        getMessage(str);
                    }
                } catch (IOException e) {
                    System.out.println("Server cant get" + e);
                }
            }
        });
        thread.start();
        
        }else{
        
        }
        
    }
    public static void diagFill(){
    
        diagonals.add(GameBoardControllerOnline.arrlistButtons2.get(0).getText()+GameBoardControllerOnline.arrlistButtons2.get(1).getText()
                +GameBoardControllerOnline.arrlistButtons2.get(2).getText());
        diagonals.add(GameBoardControllerOnline.arrlistButtons2.get(3).getText()+GameBoardControllerOnline.arrlistButtons2.get(4).getText()
                +GameBoardControllerOnline.arrlistButtons2.get(5).getText());
        diagonals.add(GameBoardControllerOnline.arrlistButtons2.get(6).getText()+GameBoardControllerOnline.arrlistButtons2.get(7).getText()
                +GameBoardControllerOnline.arrlistButtons2.get(8).getText());
        diagonals.add(GameBoardControllerOnline.arrlistButtons2.get(0).getText()+GameBoardControllerOnline.arrlistButtons2.get(3).getText()
                +GameBoardControllerOnline.arrlistButtons2.get(6).getText());
        diagonals.add(GameBoardControllerOnline.arrlistButtons2.get(1).getText()+GameBoardControllerOnline.arrlistButtons2.get(4).getText()
                +GameBoardControllerOnline.arrlistButtons2.get(7).getText());
        diagonals.add(GameBoardControllerOnline.arrlistButtons2.get(2).getText()+GameBoardControllerOnline.arrlistButtons2.get(5).getText()
                +GameBoardControllerOnline.arrlistButtons2.get(8).getText());
        diagonals.add(GameBoardControllerOnline.arrlistButtons2.get(0).getText()+GameBoardControllerOnline.arrlistButtons2.get(4).getText()
                +GameBoardControllerOnline.arrlistButtons2.get(8).getText());
        diagonals.add(GameBoardControllerOnline.arrlistButtons2.get(2).getText()+GameBoardControllerOnline.arrlistButtons2.get(4).getText()
                +GameBoardControllerOnline.arrlistButtons2.get(6).getText());
    
    }
    public static void getMessage(String msg) {
        System.out.println("we got "+msg);
        if (msg != null && !msg.isEmpty()) {
            String[] data = msg.split(",");
            switch (data[0]) {
                case ServerCall.IVETATION_RECEIVE:
                    Platform.runLater(() -> {
                        displayAlert(data[1]);
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
                    //Navigator.setTurnEnded(true);
                    //GameBoardControllerOnline.button.setText(Navigator.boardMove);
                    //GameBoardControllerOnline.button.setDisable(true);
                    if(data[3].equals("X")){
                        Navigator.setSetX(false);
                    }else{
                        Navigator.setSetX(true);
                    }
                    Platform.runLater(() -> {
                        
                        GameBoardControllerOnline.arrlistButtons2.get(Integer.parseInt(data[2])-1).setText(data[3]);
                        GameBoardControllerOnline.arrlistButtons2.get(Integer.parseInt(data[2])-1).setDisable(true);
                        diagFill();
                        LocalMultiPlayer.localMulti(diagonals, GameBoardControllerOnline.getStage());
            });
                    System.out.println("we set "+Navigator.getBoardMove()+" "+Navigator.getButtonNumber());
                    break;
                default:
                    break;

            }
        }

        /*   if (!msg.isEmpty()) {
            switch (msg) {
                case "ACCEPT":
                    System.out.println("Your Friend Accepted Invetation");
                    Navigator.navigate(Navigator.GAMEBOARD, stage);
                    break;
                case "CANCLE":
                    System.out.println("Your Friend Cancled Invetation");
                    break;
                default:
                    System.out.println("Invalide Choice");
                    break;

            }
        }*/
    }

    public static void closeThread() throws IOException {
        dataInputStream.close();
        socket.close();
        thread.stop();
        serverConnection = null;

    }

    public static void displayAlert(String Playerx) {
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
            sendMessage(ServerCall.CONFIRMATION_SEND +","+ Playerx,stage);
            Navigator.setPlayerOne(Playerx);
            Navigator.setPlayerTwo("Hussin");
            Platform.runLater(() -> {
                
                Navigator.navigate(Navigator.GAMEBOARDONLINE, stage);
            });

        } else {
            System.out.println("Player O Cancle");
        }
    }
}
