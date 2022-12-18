package tictaktoejavafx.view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public abstract class SnakeScreenBase extends AnchorPane {

    protected final Label label;
    protected final Button back_btn;
    protected final ImageView imageView;
    protected final Pane snake_container;

    public SnakeScreenBase() {

        label = new Label();
        back_btn = new Button();
        imageView = new ImageView();
        snake_container = new Pane();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        label.setLayoutX(484.0);
        label.setLayoutY(148.0);
        label.setText("SnakeGame");

        back_btn.setLayoutX(23.0);
        back_btn.setLayoutY(27.0);
        back_btn.setMnemonicParsing(false);
        back_btn.setOnAction(this::isBack);
        back_btn.setText("back");

        imageView.setFitHeight(95.0);
        imageView.setFitWidth(112.0);
        imageView.setLayoutX(468.0);
        imageView.setLayoutY(43.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);

        snake_container.setLayoutX(23.0);
        snake_container.setLayoutY(75.0);
        snake_container.setPrefHeight(309.0);
        snake_container.setPrefWidth(446.0);

        getChildren().add(label);
        getChildren().add(back_btn);
        getChildren().add(imageView);
        getChildren().add(snake_container);

    }

    protected abstract void isBack(javafx.event.ActionEvent actionEvent);

}
