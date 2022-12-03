package tictagg;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public abstract class ServerChartBase extends AnchorPane {

    protected final Label label;
    protected final VBox vBox;
    protected final Button home_btn;
    protected final Button players_btn;
    protected final Button charts_btn;
    protected final AnchorPane pie_chart;
    protected final Label label0;

    public ServerChartBase() {

        label = new Label();
        vBox = new VBox();
        home_btn = new Button();
        players_btn = new Button();
        charts_btn = new Button();
        pie_chart = new AnchorPane();
        label0 = new Label();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(482.0);
        setPrefWidth(694.0);

        label.setLayoutX(28.0);
        label.setLayoutY(41.0);
        label.setText("TIC TAC TOE Server");

        vBox.setLayoutX(32.0);
        vBox.setLayoutY(107.0);
        vBox.setPrefHeight(262.0);
        vBox.setPrefWidth(171.0);

        home_btn.setMnemonicParsing(false);
        home_btn.setOnAction(this::isHome);
        home_btn.setPrefHeight(79.0);
        home_btn.setPrefWidth(174.0);
        home_btn.setText("Home");

        players_btn.setMnemonicParsing(false);
        players_btn.setOnAction(this::isPlayers);
        players_btn.setPrefHeight(88.0);
        players_btn.setPrefWidth(175.0);
        players_btn.setText("players");

        charts_btn.setMnemonicParsing(false);
        charts_btn.setOnAction(this::isCharts);
        charts_btn.setPrefHeight(92.0);
        charts_btn.setPrefWidth(185.0);
        charts_btn.setText("Charts");

        pie_chart.setLayoutX(241.0);
        pie_chart.setLayoutY(89.0);
        pie_chart.setPrefHeight(341.0);
        pie_chart.setPrefWidth(429.0);
        pie_chart.setStyle("-fx-background-color: D9D9D9;");

        label0.setLayoutX(409.0);
        label0.setLayoutY(41.0);
        label0.setText("Server Activity");

        getChildren().add(label);
        vBox.getChildren().add(home_btn);
        vBox.getChildren().add(players_btn);
        vBox.getChildren().add(charts_btn);
        getChildren().add(vBox);
        getChildren().add(pie_chart);
        getChildren().add(label0);

    }

    protected abstract void isHome(javafx.event.ActionEvent actionEvent);

    protected abstract void isPlayers(javafx.event.ActionEvent actionEvent);

    protected abstract void isCharts(javafx.event.ActionEvent actionEvent);

}
