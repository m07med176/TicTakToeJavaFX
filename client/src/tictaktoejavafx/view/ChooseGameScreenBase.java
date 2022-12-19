package tictaktoejavafx.view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public abstract class ChooseGameScreenBase extends AnchorPane {

    protected final ImageView imageView;
    protected final Label label;
    protected final Button TicTakToe_btn;
    protected final Button Snake_btn;

    public ChooseGameScreenBase() {

        imageView = new ImageView();
        label = new Label();
        TicTakToe_btn = new Button();
        Snake_btn = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(475.0);
        setPrefWidth(637.0);

        imageView.setFitHeight(150.0);
        imageView.setFitWidth(200.0);
        imageView.setLayoutX(211.0);
        imageView.setLayoutY(101.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);

        label.setLayoutX(161.0);
        label.setLayoutY(60.0);
        label.setText("Welcome plz choose game you want to play?");

        TicTakToe_btn.setLayoutX(286.0);
        TicTakToe_btn.setLayoutY(314.0);
        TicTakToe_btn.setMnemonicParsing(false);
        TicTakToe_btn.setOnAction(this::isTicTacToe);
        TicTakToe_btn.setText("TicTakToe");

        Snake_btn.setLayoutX(286.0);
        Snake_btn.setLayoutY(377.0);
        Snake_btn.setMnemonicParsing(false);
        Snake_btn.setOnAction(this::isSnake);
        Snake_btn.setPrefHeight(31.0);
        Snake_btn.setPrefWidth(86.0);
        Snake_btn.setText("Snake");

        getChildren().add(imageView);
        getChildren().add(label);
        getChildren().add(TicTakToe_btn);
        getChildren().add(Snake_btn);

    }

    protected abstract void isTicTacToe(javafx.event.ActionEvent actionEvent);

    protected abstract void isSnake(javafx.event.ActionEvent actionEvent);

}
