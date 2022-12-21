package tictaktoejavafx.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import tictaktoejavafx.utils.Config;

public abstract class SplashScreenBase extends AnchorPane {

    protected final ImageView imageView;

    public SplashScreenBase() {

        imageView = new ImageView();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(575.0);
        setPrefWidth(466.0);

        imageView.setFitHeight(136.0);
        imageView.setFitWidth(168.0);
        imageView.setLayoutX(149.0);
        imageView.setLayoutY(197.0);
        imageView.getStyleClass().add("logo");
        //imageView.setImage(new Image(getClass().getResource("../assets/XOpicture.jpg").toExternalForm()));
imageView.setImage(new Image(Config.LOGO));
        getChildren().add(imageView);

    }
}
