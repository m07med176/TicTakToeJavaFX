package tictagg;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public abstract class ServerHomeScreenBase extends AnchorPane {

    protected final Label label;
    protected final VBox vBox;
    protected final Button home;
    protected final Button players;
    protected final Button charts;
    protected final AnchorPane server_status;
    protected final Label label0;
    protected final RadioButton on_radio_button;
    protected final RadioButton off_radio_btton;

    public ServerHomeScreenBase() {

        label = new Label();
        vBox = new VBox();
        home = new Button();
        players = new Button();
        charts = new Button();
        server_status = new AnchorPane();
        label0 = new Label();
        on_radio_button = new RadioButton();
        off_radio_btton = new RadioButton();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(490.0);
        setPrefWidth(785.0);

        label.setLayoutX(63.0);
        label.setLayoutY(67.0);
        label.setText("TIC TAC TOE Server");

        vBox.setLayoutX(37.0);
        vBox.setLayoutY(124.0);
        vBox.setPrefHeight(181.0);
        vBox.setPrefWidth(180.0);
        vBox.setStyle("-fx-background-color: D9D9D9;");

        home.setMnemonicParsing(false);
        home.setOnAction(this::isHome);
        home.setPrefHeight(53.0);
        home.setPrefWidth(177.0);
        home.setText("Home");

        players.setMnemonicParsing(false);
        players.setOnAction(this::isPlayers);
        players.setPrefHeight(60.0);
        players.setPrefWidth(177.0);
        players.setText("Players");

        charts.setMnemonicParsing(false);
        charts.setOnAction(this::isCharts);
        charts.setPrefHeight(65.0);
        charts.setPrefWidth(180.0);
        charts.setText("Charts");

        server_status.setLayoutX(264.0);
        server_status.setLayoutY(124.0);
        server_status.setPrefHeight(307.0);
        server_status.setPrefWidth(482.0);
        server_status.setStyle("-fx-background-color: D9D9D9;");

        label0.setLayoutX(582.0);
        label0.setLayoutY(67.0);
        label0.setText("Server Status");

        on_radio_button.setLayoutX(293.0);
        on_radio_button.setLayoutY(67.0);
        on_radio_button.setMnemonicParsing(false);
        on_radio_button.setOnAction(this::isOn);
        on_radio_button.setText("ON");

        off_radio_btton.setLayoutX(425.0);
        off_radio_btton.setLayoutY(67.0);
        off_radio_btton.setMnemonicParsing(false);
        off_radio_btton.setOnAction(this::isOff);
        off_radio_btton.setText("OFF");

        getChildren().add(label);
        vBox.getChildren().add(home);
        vBox.getChildren().add(players);
        vBox.getChildren().add(charts);
        getChildren().add(vBox);
        getChildren().add(server_status);
        getChildren().add(label0);
        getChildren().add(on_radio_button);
        getChildren().add(off_radio_btton);

    }

    protected abstract void isHome(javafx.event.ActionEvent actionEvent);

    protected abstract void isPlayers(javafx.event.ActionEvent actionEvent);

    protected abstract void isCharts(javafx.event.ActionEvent actionEvent);

    protected abstract void isOn(javafx.event.ActionEvent actionEvent);

    protected abstract void isOff(javafx.event.ActionEvent actionEvent);

}
