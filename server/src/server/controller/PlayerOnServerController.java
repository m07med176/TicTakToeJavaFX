package server.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.chart.PieChart;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import server.data.db.DataBaseConnection;
import server.data.db.DatabaseAccessLayer;
import server.data.model.Player;
import server.data.server.ServerManager;
import server.utils.UserMessage;
import server.view.PlayerOnServerBase;
import server.data.server.ServerCallBack;

public class PlayerOnServerController extends PlayerOnServerBase {

    private DatabaseAccessLayer db;
    private Stage stage;
    private Boolean flag = false;
    private boolean serverStarter = false;
    private ArrayList<Player> arrayListPlayer = new ArrayList();
    private ObservableList<PieChart.Data> pieChartData;
    private ServerManager server;
    

    public PlayerOnServerController(Stage stage) {
        this.stage = stage;

        btnOnOff.setStyle("-fx-text-fill: Green;");
        try {
            db = new DatabaseAccessLayer();

            server = ServerManager.getInstance(new ServerCallBack() {
                @Override
                public void serverException(IOException ex) {
                    UserMessage.showError(ex.getMessage());
                }

                @Override
                public void databaseException(SQLException ex) {
                    UserMessage.showError(ex.getMessage());
                }

                @Override
                public void requestUpdateDatabase() {
                    try {

                        pieChartData.clear();
                        pieChartData.add(new PieChart.Data("Online Players", db.getCountPlayers(true)));
                        pieChartData.add(new PieChart.Data("Offline Players", db.getCountPlayers(false)));
                        displayPlayerInTable();

                    } catch (SQLException ex) {
                        UserMessage.showError(ex.getMessage());
                    }
                }
            });

            stage.setOnCloseRequest((WindowEvent event) -> {
                try {
                    DataBaseConnection.closeConnection();
                    if(server!=null){
                        server.close();
                    }
                    
                } catch (IOException | SQLException ex) {
                    UserMessage.showError(ex.getMessage());
                }
            });

            db.updateAllPlayersStatus(false);
            pieChartData = FXCollections.observableArrayList(
                    new PieChart.Data("Online Players", db.getCountPlayers(true)),
                    new PieChart.Data("Offline Players", db.getCountPlayers(false)));

            chart.setData(pieChartData);
        } catch (SQLException ex) {
            UserMessage.showError(ex.getMessage());
        } catch (IOException ex) {
            UserMessage.showError(ex.getMessage());
        }
        displayPlayerInTable();

    }

    @Override
    protected void runServer(ActionEvent actionEvent) {
        if (flag == false) {

            flag = true;
            btnOnOff.setText("ON");
            btnOnOff.setStyle("-fx-text-fill: Red;");
            if (serverStarter) {
                try {
                    server = ServerManager.getInstance(new ServerCallBack() {
                        @Override
                        public void serverException(IOException ex) {
                            UserMessage.showError(ex.getMessage());
                        }

                        @Override
                        public void databaseException(SQLException ex) {
                            UserMessage.showError(ex.getMessage());
                        }

                        @Override
                        public void requestUpdateDatabase() {
                            try {

                                pieChartData.clear();
                                pieChartData.add(new PieChart.Data("Online Players", db.getCountPlayers(true)));
                                pieChartData.add(new PieChart.Data("Offline Players", db.getCountPlayers(false)));
                                displayPlayerInTable();

                            } catch (SQLException ex) {
                                UserMessage.showError(ex.getMessage());
                            }
                        }
                    });
                    server.start();
                } catch (IOException ex) {
                    UserMessage.showError(ex.getMessage());
                } catch (SQLException ex) {
                    UserMessage.showError(ex.getMessage());
                }
            }else{
            
                server.start();
                serverStarter=true;
            }

        } else {
            try {
                flag = false;
                btnOnOff.setText("OFF");
                db.updateAllPlayersStatus(false);
                displayPlayerInTable();
                btnOnOff.setStyle("-fx-text-fill: Green;");
                server.close();
                server = null;
                //server.stop();
            } catch (IOException | SQLException ex) {
                UserMessage.showError(ex.getMessage());
                ex.printStackTrace();
            }
        }

    }

    public void displayPlayerInTable() {
        try {

            arrayListPlayer = db.getAllPlayers();
            columName.setCellValueFactory(new PropertyValueFactory<Player, String>("username"));
            columEmail.setCellValueFactory(new PropertyValueFactory<Player, String>("email"));
            columActive.setCellValueFactory(new PropertyValueFactory<Player, Boolean>("status"));
            ObservableList<Player> observableList = FXCollections.observableArrayList(arrayListPlayer);
            table.setItems(observableList);

        } catch (SQLException ex) {
            UserMessage.showError(ex.getMessage());
        }

    }

}