package tictaktoejavafx.data.server;

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
import tictaktoejavafx.utils.AlertAction;
import tictaktoejavafx.utils.Config;
import tictaktoejavafx.utils.ExceptionCallBack;
import tictaktoejavafx.utils.LocalMultiPlayer;
import tictaktoejavafx.utils.Navigator;
import tictaktoejavafx.utils.UserMessage;

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
        System.out.println("IP is: "+ip+" and port is: "+port);
        socket = new Socket(ip, port);
        dataOutputStream = new DataOutputStream(socket.getOutputStream());
    }

    public static ServerConnection getInstance(Stage stage, String ip, int port, ExceptionCallBack exceptionCallBack) throws IOException {
        if (serverConnection == null) {
            serverConnection = new ServerConnection(stage, ip, port, exceptionCallBack);
        }
        return serverConnection;
    }

    public static void sendMessage(String message) throws  IOException{
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
        System.out.println("we got " + msg);
        if (msg != null && !msg.isEmpty()) {
            String[] data = msg.split(",");
            switch (data[0]) {
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
                    //Navigator.setTurnEnded(true);
                    //GameBoardControllerOnline.button.setText(Navigator.boardMove);
                    //GameBoardControllerOnline.button.setDisable(true);
                    if (data[3].equals("X")) {
                        Navigator.setSetX(false);
                    } else {
                        Navigator.setSetX(true);
                    }
                    Platform.runLater(() -> {

                        GameBoardControllerOnline.arrlistButtons2.get(Integer.parseInt(data[2]) - 1).setText(data[3]);
                        GameBoardControllerOnline.arrlistButtons2.get(Integer.parseInt(data[2]) - 1).setDisable(true);
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
                    System.out.println("we set " + Navigator.getBoardMove() + " " + Navigator.getButtonNumber());
                    break;
                    
                case ServerCall.RREGISTER_RECEIVE:
                    Platform.runLater(() -> {
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
            });
                       
                default:
                    break;

            }
        }

    }

    public static void closeThread() throws IOException {
        dataInputStream.close();
        socket.close();
        thread.stop();
        serverConnection = null;

    }

    public static void displayAlert(String Playerx) throws IOException{
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
            sendMessage(ServerCall.CONFIRMATION_SEND + "," + Playerx);
            Navigator.setPlayerOne(Playerx);
            Navigator.setPlayerTwo("Hussin");
            Platform.runLater(() -> {
                Navigator.navigate(Navigator.GAMEBOARDONLINE, stage);
            });

        } else {
            System.out.println("Player O Cancle");
        }
    }
/*
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
          System.out.println("we got " + msg);
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
                         if (data[3].equals("X")) {
                              Navigator.setSetX(false);
                         } else {
                              Navigator.setSetX(true);
                         }
                         Platform.runLater(() -> {

                              GameBoardControllerOnline.arrlistButtons2.get(Integer.parseInt(data[2]) - 1).setText(data[3]);
                              GameBoardControllerOnline.arrlistButtons2.get(Integer.parseInt(data[2]) - 1).setDisable(true);
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
                         System.out.println("we set " + Navigator.getBoardMove() + " " + Navigator.getButtonNumber());
                         break;
                    default:
                         break;

               }
          }

     }

     public static void closeThread() throws IOException {
          if(dataInputStream!=null){
          
              dataInputStream.close();
              dataInputStream=null;
          }
          if(socket!=null){
              if(!socket.isClosed()){
                  socket.close();
                  socket=null;
              }
              
          }
          if(thread!=null){
              if(thread.isAlive()){
                  thread.stop();
              }
              
          }
          
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
               sendMessage(ServerCall.CONFIRMATION_SEND + "," + Playerx, stage);
               Navigator.setPlayerOne(Playerx);
               Navigator.setPlayerTwo("Hussin");
               Platform.runLater(() -> {

                    Navigator.navigate(Navigator.GAMEBOARDONLINE, stage);
               });

          } else {
               System.out.println("Player O Cancle");
          }

     }
*/
}
