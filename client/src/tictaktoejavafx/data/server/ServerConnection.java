package tictaktoejavafx.data.server;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import tictaktoejavafx.utils.AlertAction;
import tictaktoejavafx.utils.Navigator;
import tictaktoejavafx.utils.UserMessage;

public class ServerConnection {

    private PrintStream printStream;
    private String UID;
    private ServerCall serverCall;

    public static Socket socket;
    private static ServerConnection serverConnection = null;
    Thread thread = null;
    DataInputStream dataInputStream;
    private static Stage stage;

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

    public void sendMessage(String message) {
        PrintStream printStream = null;
        try {
            printStream = new PrintStream(socket.getOutputStream());
            printStream.println(message);
        } catch (IOException e) {
            System.out.println("Server cant send");
        }
    }

    public void readThread() {

        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {

                    try {
                        dataInputStream = new DataInputStream(socket.getInputStream());
                        String str = dataInputStream.readLine();
                        if (str != null && !str.isEmpty()) {
                            System.out.println(str);
                            getMessage(str);
                        }
                    } catch (IOException e) {
                        System.out.println("Server cant get" + e);
                    }
                }
            }
        });
        thread.start();
    }

    public void getMessage(String msg) {

        if (msg != null && !msg.isEmpty()) {
            String[] data = msg.split(",");
            switch (data[0]) {
                case ServerCall.IVETATION_RECEIVE:
                    Platform.runLater(() -> {
                        displayAlert(data[1]);
            });
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

    public void closeThread() throws IOException {
        dataInputStream.close();
        socket.close();
        thread.stop();
        serverConnection = null;

    }
    void displayAlert(String Playerx){
               Alert alert=new Alert(Alert.AlertType.WARNING);

                   alert.setTitle("Invitation");
                  alert.setHeaderText(Playerx+"Invite you to Play Game");
                  alert.setContentText("Do you want to Accept Invitation");
                  

            ButtonType acceptButton = new ButtonType("Accept");
            ButtonType cancelButton = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
            alert.getButtonTypes().setAll(acceptButton, cancelButton);
             if(alert.showAndWait().get() == acceptButton){
                //-------------------------------------
                 System.out.println("Player O Accept Your Invetation");

            }else{
                 System.out.println("Player O Cancle");
            }
    }
}
