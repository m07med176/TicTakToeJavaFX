package tictaktoejavafx.view;

import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public abstract class PlayerSelectionScreenBase extends AnchorPane {

    protected final ImageView imageView;
    protected final AnchorPane anchorPane;
    protected final ListView list_view_user;

    public PlayerSelectionScreenBase() {

        imageView = new ImageView();
        anchorPane = new AnchorPane();
        list_view_user = new ListView();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(530.0);
        setPrefWidth(785.0);

        imageView.setFitHeight(170.0);
        imageView.setFitWidth(183.0);
        imageView.setLayoutX(571.0);
        imageView.setLayoutY(74.0);
        imageView.getStyleClass().add("logo");
        imageView.setImage(new Image(getClass().getResource("../assets/XOpicture.jpg").toExternalForm()));

        anchorPane.setLayoutX(30.0);
        anchorPane.setLayoutY(32.0);
        anchorPane.setPrefHeight(448.0);
        anchorPane.setPrefWidth(514.0);

        list_view_user.setLayoutX(11.0);
        list_view_user.setLayoutY(12.0);
        list_view_user.setPrefHeight(417.0);
        list_view_user.setPrefWidth(476.0);

        getChildren().add(imageView);
        anchorPane.getChildren().add(list_view_user);
        getChildren().add(anchorPane);

    }
}
