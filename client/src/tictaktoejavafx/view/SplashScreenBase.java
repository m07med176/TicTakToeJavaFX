package tictaktoejavafx.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import tictaktoejavafx.utils.AssetsRepository;

public abstract class SplashScreenBase extends AnchorPane {

    protected final ImageView imageView;

    public SplashScreenBase() {

        imageView = new ImageView();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        imageView.setImage(new Image(AssetsRepository.ENVLOP));

        imageView.setFitHeight(150.0);
        imageView.setFitWidth(200.0);
        imageView.setLayoutX(200.0);
        imageView.setLayoutY(103.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);

        getChildren().add(imageView);

    }
}
