/*

package tictaktoejavafx;

import ticktacktoejavafx.App;
import javafx.application.Platform;
import javafx.scene.control.Label;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import com.main.ticktacktoejavafx.Models.Player;
import java.io.IOException;

public class ResponseHandler {
   
    public static OnlineHomeController onlineController;
    public static void handleResponse(String responseString) {

        JSONObject requestObject = (JSONObject) JSONValue.parse(responseString);
        String response = (String) requestObject.get("response");
        JSONObject data = (JSONObject) requestObject.get("data");

        switch (response) {
            case "player not exists":
                handlePlayerNotExist();
                break;
            case "wrong password":
                handleWrongPassword();
                break;
            case "login success":
                handleLoginSuccess(data);
                break;
            case "player already online":
                handlePlayerAlreadyOnline(data);
                break;
            case "player exists":
                handlePlayerExist();
                break;
            case "reqister sucsess":
                handleRegisterSuccess();
                break;
            case "online players list":
                onlinePlayersList(data);
                break;
            case "all players list":
                handleAllPlayersList(data);
                break;
            case "add new player":
                handleAddNewPlayer(data);
                break;
            case "player left the game":
                handlePlayerLeftTheGame(data);
                break;
            case "player in game":
                handlePlayerInGame(data);
                break;
            case "player is offline":
                handlePlayerIsOffline(data);
                break;
            case "game invitation":
                handleGameInvitation(data);
                break;
            case "chat invitation":
                handleChatInvitation(data);
                break;
            case "invitationSended":
                handleInvitationSended(data);
                break;
            case "invitationRejected":
                handleInvitationRejected(data);
                break;
            case "choose x or o":
                handleChooseXOrO(data);
                break;
            case "start multi mode game":
                handleStartMultiModeGame(data);
                break;
            case "disaple all buttons":
                handleDisapleAllButtonsSingle();
                break;
            case "end multi mode game":
                handleEndMultiModeGame(data);
                break;
            case "update player data":
                handleUpdatePlayerData(data);
                break;
            case "updateAvilablePlayesList":
                handleUpdateAvilablePlayersList(data);
                break;
            case "draw multi moves":
                handleDrawSingleMoves(data);
                break;
            case "enable multi buttons":
                handleEnableSingleButtons();
                break;
            case "draw single moves":
                handleDrawSingleMoves(data);
                break;
            case "enable single buttons":
                handleEnableSingleButtons();
                break;
            case "player left multi game":
                handlePlayerLeftMultiGame(data);
                break;
            case "disaple all buttons single":
                handleDisapleAllButtonsSingle();
                break;
            case "start single mode game":
                handleStartSingleModeGame(data);
                break;
            case "end single mode game":
                handleEndSingleModeGame(data);
                break;
            case "ContinueGame":
                handleContinueGame(data);
            case "go to welcome view":
                break;
            case "player left chat":
                handlePlayerLeftChatRoom(data);
                break;
            case "add new message":
                handleAddNewMessage(data);
                break;
            case "open chat room":
                handleOpenChatRoom(data);
                break;
            case "player in chat":
                handlePlayerInChat(data);
                break;
            case "serverIsClosed":
                handleServerIsClosed();
                break;
            case "single mode game history":
                handelSingleModeGameHistory(data);
                break;
            case "multi mode game history":
                handelMultiModeGameHistory(data);
                break;
            default:
                break;
        }
    }
    
   private static void handlePlayerNotExist() {
        Platform.runLater(() -> {
            App.setRoot("PlayerNotExistView");
        });
    }
      private static void handleWrongPassword() {
        Platform.runLater(() -> {
            App.setRoot("WrongPasswordView");
        });
    }
          private static void handleLoginSuccess(JSONObject playerData) {
        Platform.runLater(() -> {
            Client.player = new Player(
                    (String) playerData.get("userName"),
                    ((Long) playerData.get("bonusPoints")).intValue(),
                    (String) playerData.get("playerRank"),
                    (String) playerData.get("registerDate"));
            App.setRoot("WelcomeView");
        });
    }
              private static void handlePlayerAlreadyOnline(JSONObject data) {
        Platform.runLater(() -> {
            App.setRoot("PlayerAlreadyOnlineView");
        });
    }
                private static void handlePlayerExist() {
        Platform.runLater(() -> {
            App.setRoot("PlayerExistView");
        });
    }
                private static void handleRegisterSuccess() {
        Platform.runLater(() -> {
            App.setRoot("RegisterSuccessView");
        });
    }
                
         private static void handlePlayerInGame(JSONObject data) {
              Platform.runLater(() -> {
            String invitedPlayer = (String) data.get("invitedPlayer");
            App.setRoot("PlayerIsCurrentlyInGameView");
            Label receiverName = (Label)App.scene.lookup("#playerName");
            receiverName.setText(invitedPlayer);
        });
    }
           private static void handlePlayerIsOffline(JSONObject data) {
             Platform.runLater(() -> {
                 String invitedPlayer = (String) data.get("invitedPlayer");
                 App.setRoot("PlayerIsOfflineView");
                 Label receiverName = (Label)App.scene.lookup("#playerName");
                 receiverName.setText(invitedPlayer);
                 System.out.println("can't set PlayerIsOfflineView");
        });
    }
               private static void handleInvitationRejected(JSONObject data) {
        Platform.runLater(() -> {
            String invitationReciever = (String) data.get("invitationReciever");
            App.setRoot("InvitationRejectedView");
            Label receiverName = (Label)App.scene.lookup("#playerName");
            receiverName.setText(invitationReciever);
        });
    }

    }
    
    
*/
