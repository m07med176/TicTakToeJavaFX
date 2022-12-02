package tictagg;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public abstract class winner_losserScreenBase extends AnchorPane {

    protected final Label label;
    protected final ImageView video_screen;
    protected final Label user_win;

    public winner_losserScreenBase() {

        label = new Label();
        video_screen = new ImageView();
        user_win = new Label();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(512.0);
        setPrefWidth(845.0);

        label.setLayoutX(342.0);
        label.setLayoutY(38.0);
        label.setPrefHeight(43.0);
        label.setPrefWidth(92.0);
        label.setText("Winner is ");

        video_screen.setFitHeight(321.0);
        video_screen.setFitWidth(569.0);
        video_screen.setLayoutX(125.0);
        video_screen.setLayoutY(120.0);
        video_screen.setPickOnBounds(true);
        video_screen.setPreserveRatio(true);

        user_win.setLayoutX(423.0);
        user_win.setLayoutY(49.0);
        user_win.setText("user_name");

        getChildren().add(label);
        getChildren().add(video_screen);
        getChildren().add(user_win);

    }
}
