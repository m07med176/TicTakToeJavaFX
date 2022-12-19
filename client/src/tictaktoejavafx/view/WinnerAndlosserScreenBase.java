package tictaktoejavafx.view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.MediaView;

public abstract class WinnerAndlosserScreenBase extends AnchorPane {

    protected final Label label;
    protected final Label user_win;
    protected final MediaView mediaView;
    protected final Button button;
    protected final Button button0;
    protected final Button button1;

    public WinnerAndlosserScreenBase() {

        label = new Label();
        user_win = new Label();
        mediaView = new MediaView();
        button = new Button();
        button0 = new Button();
        button1 = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(512.0);
        setPrefWidth(845.0);

        label.setLayoutX(47.0);
        label.setLayoutY(14.0);
        label.setPrefHeight(43.0);
        label.setPrefWidth(158.0);
        label.getStyleClass().add("title");
        label.setText("Winner is ");

        user_win.setLayoutX(239.0);
        user_win.setLayoutY(27.0);
        user_win.getStyleClass().add("sub_title");
        user_win.setText("user_name");

        mediaView.setFitHeight(600.0);
        mediaView.setFitWidth(600.0);
        mediaView.setLayoutX(130.0);
        mediaView.setLayoutY(100.0);

        button.setLayoutX(214.0);
        button.setLayoutY(450.0);
        button.setMnemonicParsing(false);
        button.setOnAction(this::onHomeButtonClicked);
        button.getStyleClass().add("main_button");
        button.setText("Home");

        button0.setLayoutX(344.0);
        button0.setLayoutY(450.0);
        button0.setMnemonicParsing(false);
        button0.setOnAction(this::onPlayAgainClicked);
        button0.getStyleClass().add("main_button");
        button0.setText("Playe Again");

        button1.setLayoutX(503.0);
        button1.setLayoutY(450.0);
        button1.setMnemonicParsing(false);
        button1.setOnAction(this::onResultsClicked);
        button1.getStyleClass().add("main_button");
        button1.setText("Score Results");

        getChildren().add(label);
        getChildren().add(user_win);
        getChildren().add(mediaView);
        getChildren().add(button);
        getChildren().add(button0);
        getChildren().add(button1);

    }

    protected abstract void onHomeButtonClicked(javafx.event.ActionEvent actionEvent);

    protected abstract void onPlayAgainClicked(javafx.event.ActionEvent actionEvent);

    protected abstract void onResultsClicked(javafx.event.ActionEvent actionEvent);

}
