package server.view;

import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public abstract class PlayerOnServerBase extends Pane {

    protected final ImageView imageView;
    protected final ToggleButton btnOnOff;
    protected final TableView table;
    protected final TableColumn columName;
    protected final TableColumn columEmail;
    protected final TableColumn columActive;
    protected final Label label;
    protected final PieChart chart;

    public PlayerOnServerBase() {

        imageView = new ImageView();
        btnOnOff = new ToggleButton();
        table = new TableView();
        columName = new TableColumn();
        columEmail = new TableColumn();
        columActive = new TableColumn();
        label = new Label();
        chart = new PieChart();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(617.0);
        setPrefWidth(751.0);

        imageView.setFitHeight(150.0);
        imageView.setFitWidth(200.0);
        imageView.setLayoutX(84.0);
        imageView.setLayoutY(22.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
//        imageView.setImage(new Image(getClass().getResource("../../../../client/src/tictaktoejavafx/assets/images/imageTicTacToe.png").toExternalForm()));

        btnOnOff.setLayoutX(91.0);
        btnOnOff.setLayoutY(207.0);
        btnOnOff.setMnemonicParsing(false);
        btnOnOff.setOnAction(this::runServer);
        btnOnOff.setPrefHeight(52.0);
        btnOnOff.setPrefWidth(57.0);
        btnOnOff.setText("OFF");

        table.setLayoutX(319.0);
        table.setLayoutY(45.0);
        table.setPrefHeight(503.0);
        table.setPrefWidth(412.0);

        columName.setPrefWidth(134.0);
        columName.setText("User Name");

        columEmail.setMinWidth(0.0);
        columEmail.setPrefWidth(210.0);
        columEmail.setText("Email");

        columActive.setPrefWidth(173.0);
        columActive.setText("Active");
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        label.setLayoutX(21.0);
        label.setLayoutY(207.0);
        label.setPrefHeight(52.0);
        label.setPrefWidth(78.0);
        label.getStyleClass().add("sub_title");
        label.setText("Server");

        chart.setLayoutX(33.0);
        chart.setLayoutY(309.0);
        chart.setPrefHeight(197.0);
        chart.setPrefWidth(254.0);

        getChildren().add(imageView);
        getChildren().add(btnOnOff);
        table.getColumns().add(columName);
        table.getColumns().add(columEmail);
        table.getColumns().add(columActive);
        getChildren().add(table);
        getChildren().add(label);
        getChildren().add(chart);

    }

    protected abstract void runServer(javafx.event.ActionEvent actionEvent);

}
