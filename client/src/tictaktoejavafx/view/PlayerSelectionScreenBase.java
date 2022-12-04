package tictaktoejavafx.view;

import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public abstract class PlayerSelectionScreenBase extends AnchorPane {

    protected final ImageView imageView;
    protected final Label label;
//    protected final View view;
    protected final AnchorPane anchorPane;
    protected final ListView list_view_user;
    protected final Label user_name;

    public PlayerSelectionScreenBase() {

        imageView = new ImageView();
        label = new Label();
//        view = new View();
        anchorPane = new AnchorPane();
        list_view_user = new ListView();
        user_name = new Label();

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
        imageView.setImage(new Image(getClass().getResource("../assets/XOpicture.jpg").toExternalForm()));

        label.setLayoutX(625.0);
        label.setLayoutY(255.0);
        label.setText("Tic Tac Toe");

//        view.setLayoutX(265.0);
//        view.setLayoutY(208.0);

        anchorPane.setLayoutX(30.0);
        anchorPane.setLayoutY(32.0);
        anchorPane.setPrefHeight(448.0);
        anchorPane.setPrefWidth(514.0);

        list_view_user.setLayoutX(34.0);
        list_view_user.setLayoutY(40.0);
        list_view_user.setPrefHeight(373.0);
        list_view_user.setPrefWidth(431.0);

        user_name.setLayoutX(636.0);
        user_name.setLayoutY(297.0);
        user_name.setText("user_name");

        getChildren().add(imageView);
        getChildren().add(label);
//        getChildren().add(view);
        anchorPane.getChildren().add(list_view_user);
        getChildren().add(anchorPane);
        getChildren().add(user_name);

    }
}
