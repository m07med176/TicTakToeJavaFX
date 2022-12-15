package server.view;

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

    public PlayerOnServerBase() {

        imageView = new ImageView();
        btnOnOff = new ToggleButton();
        table = new TableView();
        columName = new TableColumn();
        columEmail = new TableColumn();
        columActive = new TableColumn();
        label = new Label();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(617.0);
        setPrefWidth(751.0);

        imageView.setFitHeight(150.0);
        imageView.setFitWidth(200.0);
        imageView.setLayoutX(35.0);
        imageView.setLayoutY(29.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
       // imageView.setImage(new Image(getClass().getResource("../../../../client/src/tictaktoejavafx/assets/images/imageTicTacToe.png").toExternalForm()));

        btnOnOff.setLayoutX(91.0);
        btnOnOff.setLayoutY(207.0);
        btnOnOff.setMnemonicParsing(false);
        btnOnOff.setOnAction(this::runServer);
        btnOnOff.setPrefHeight(52.0);
        btnOnOff.setPrefWidth(57.0);
        btnOnOff.setText("OFF");

        table.setLayoutX(213.0);
        table.setLayoutY(46.0);
        table.setPrefHeight(502.0);
        table.setPrefWidth(518.0);

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
        label.setText("Server");

        getChildren().add(imageView);
        getChildren().add(btnOnOff);
        table.getColumns().add(columName);
        table.getColumns().add(columEmail);
        table.getColumns().add(columActive);
        getChildren().add(table);
        getChildren().add(label);

    }

    protected abstract void runServer(javafx.event.ActionEvent actionEvent);

}
