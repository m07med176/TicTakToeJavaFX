package tictaktoejavafx.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import tictaktoejavafx.utils.Config;

public abstract class SplashScreenBase extends AnchorPane {

    protected final ImageView imageView;
    protected final Text text;

    public SplashScreenBase() {

        imageView = new ImageView();
        text = new Text();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        imageView.setFitHeight(150.0);
        imageView.setFitWidth(200.0);
        imageView.setLayoutX(200.0);
        imageView.setLayoutY(103.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.getStyleClass().add("logo");
        imageView.setImage(new Image(Config.LOGO));
        
        text.setLayoutX(280.0);
        text.setLayoutY(282.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.getStyleClass().add("title");
        text.setText("Tic Tac Toe");

        getChildren().add(imageView);
        getChildren().add(text);

    }
}
