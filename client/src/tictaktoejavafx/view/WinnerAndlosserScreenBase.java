package tictaktoejavafx.view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.MediaView;
import tictaktoejavafx.utils.Navigator;

public abstract class WinnerAndlosserScreenBase extends AnchorPane {

    protected final Label label;
    protected final Label user_win;
    protected final MediaView mediaView;
    protected final Button button;

    public WinnerAndlosserScreenBase() {

        label = new Label();
        user_win = new Label();
        mediaView = new MediaView();
        button = new Button();
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
        user_win.setText(Navigator.getPlayerWinner());

        mediaView.setFitHeight(600.0);
        mediaView.setFitWidth(600.0);
        mediaView.setLayoutX(130.0);
        mediaView.setLayoutY(100.0);

        button.setLayoutX(344.0);
        button.setLayoutY(450.0);
        button.setMnemonicParsing(false);
        button.setOnAction(this::onHomeButtonClicked);
        button.getStyleClass().add("main_button");
        button.setText("Home");

 

        getChildren().add(label);
        getChildren().add(user_win);
        getChildren().add(mediaView);
        getChildren().add(button);
    }

    protected abstract void onHomeButtonClicked(javafx.event.ActionEvent actionEvent);


}
