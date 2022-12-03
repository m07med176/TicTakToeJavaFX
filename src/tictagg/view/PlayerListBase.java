package tictagg;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public abstract class PlayerListBase extends AnchorPane {

    protected final Label label;
    protected final VBox vBox;
    protected final Button btn_home;
    protected final Button btn_players;
    protected final Button btn_Charts;
    protected final ScrollPane scroll_pane;

    public PlayerListBase() {

        label = new Label();
        vBox = new VBox();
        btn_home = new Button();
        btn_players = new Button();
        btn_Charts = new Button();
        scroll_pane = new ScrollPane();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        label.setLayoutX(39.0);
        label.setLayoutY(31.0);
        label.setText("TIC TAC TOE Server");

        vBox.setLayoutX(29.0);
        vBox.setLayoutY(74.0);
        vBox.setPrefHeight(215.0);
        vBox.setPrefWidth(137.0);

        btn_home.setMnemonicParsing(false);
        btn_home.setOnAction(this::isHome);
        btn_home.setPrefHeight(63.0);
        btn_home.setPrefWidth(143.0);
        btn_home.setText("Home");

        btn_players.setMnemonicParsing(false);
        btn_players.setOnAction(this::isPlayers);
        btn_players.setPrefHeight(69.0);
        btn_players.setPrefWidth(142.0);
        btn_players.setText("Players");

        btn_Charts.setMnemonicParsing(false);
        btn_Charts.setOnAction(this::isCharts);
        btn_Charts.setPrefHeight(82.0);
        btn_Charts.setPrefWidth(143.0);
        btn_Charts.setText("Charts");

        scroll_pane.setLayoutX(188.0);
        scroll_pane.setLayoutY(65.0);
        scroll_pane.setPrefHeight(319.0);
        scroll_pane.setPrefWidth(390.0);
        scroll_pane.setStyle("-fx-background-color: D9D9D9;");

        getChildren().add(label);
        vBox.getChildren().add(btn_home);
        vBox.getChildren().add(btn_players);
        vBox.getChildren().add(btn_Charts);
        getChildren().add(vBox);
        getChildren().add(scroll_pane);

    }

    protected abstract void isHome(javafx.event.ActionEvent actionEvent);

    protected abstract void isPlayers(javafx.event.ActionEvent actionEvent);

    protected abstract void isCharts(javafx.event.ActionEvent actionEvent);

}
