package server.data.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;

public class SocketSession extends Thread {

    public DataInputStream dataInputStream;
    public DataOutputStream dataOutputStream;
    public String UID;
    String playerO;
    String ownerSocket;
    public boolean runningFlag = true;
    boolean isOnline = false;

    private final NetworkAccessLayer networkOperations;
    private ServerCallBack serverCallBack;

    public SocketSession(Socket socket, NetworkAccessLayer networkOperations, ServerCallBack serverCallBack) throws IOException {
        this.serverCallBack = serverCallBack;
        this.networkOperations = networkOperations;
        dataInputStream = new DataInputStream(socket.getInputStream());
        dataOutputStream = new DataOutputStream(socket.getOutputStream());
        start();

    }

    @Override
    public void run() {

        while (runningFlag) {
            try {
                String response = dataInputStream.readUTF();
                System.out.println("Index  " + response);

                requestNavigator(response);
            } catch (IOException ex) {
                runningFlag = false;
                Platform.runLater(() -> {
                    serverCallBack.serverException(ex);
                    ex.printStackTrace();

                });
            } catch (SQLException ex) {
                serverCallBack.databaseException(ex);
            }
        }
    }

    private synchronized void requestNavigator(String response) throws SQLException, IOException {
        if (response != null && !response.isEmpty()) {
            System.out.println(response);
            String[] data = response.split(ServerCall.DELIMETER);
            String onlineData = "non";
            switch (data[0]) {
                case ServerCall.LOGIN_SEND:
                    UID = networkOperations.login(data, dataOutputStream);
                    onlineData = networkOperations.getOnlineUsers();
                    for (int i = 0; i < ServerManager.sessionHolder.size(); i++) {
                        System.out.println(ServerCall.PLAYER_LIST_RESEND + ServerCall.DELIMETER + onlineData);
                        ServerManager.sessionHolder.get(i).dataOutputStream.writeUTF(ServerCall.PLAYER_LIST_RESEND + ServerCall.DELIMETER + onlineData);

                    }
                    Platform.runLater(() -> {
                        serverCallBack.requestUpdateDatabase();
                    });
                    break;

                case ServerCall.RREGISTER_SEND:
                    UID = networkOperations.register(data, dataOutputStream);
                    onlineData = networkOperations.getOnlineUsers();
                    for (int i = 0; i < ServerManager.sessionHolder.size(); i++) {
                        System.out.println(ServerCall.PLAYER_LIST_RESEND + ServerCall.DELIMETER + onlineData);
                        ServerManager.sessionHolder.get(i).dataOutputStream.writeUTF(ServerCall.PLAYER_LIST_RESEND + ServerCall.DELIMETER + onlineData);

                    }
                    Platform.runLater(() -> {
                        serverCallBack.requestUpdateDatabase();
                    });
                    break;

                case ServerCall.PLAYER_LIST_SEND:
                    networkOperations.onlinePlayers(data, dataOutputStream);
                    break;

                case ServerCall.MOVEMENT_SEND:
                    networkOperations.move(data, UID);
                    break;

                case ServerCall.IVETATION_SEND:
                     
                        networkOperations.invetation(data, UID);
                    

                    break;

                case ServerCall.CONFIRMATION_SEND:
                    isOnline = true;
                    networkOperations.confirm(data, UID);
                    break;

                case ServerCall.GAME_ENDED:
                    isOnline = false;
                    break;
                case ServerCall.CLOSE_SEND:

                    onlineData = networkOperations.updateState(data);
                    for (int i = 0; i < ServerManager.sessionHolder.size(); i++) {

                        ServerManager.sessionHolder.get(i).dataOutputStream.writeUTF(ServerCall.PLAYER_LIST_RESEND + ServerCall.DELIMETER + onlineData);

                    }
                    dataInputStream.close();
                    dataOutputStream.close();
                    Platform.runLater(() -> {
                        serverCallBack.requestUpdateDatabase();
                    });
                    ServerManager.sessionHolder.remove(this);

                    stop();

                    break;
            }
        }
    }
}