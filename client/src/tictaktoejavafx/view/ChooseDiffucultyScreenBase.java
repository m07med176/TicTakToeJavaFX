package tictaktoejavafx.view;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import tictaktoejavafx.utils.Config;

public abstract class ChooseDiffucultyScreenBase extends AnchorPane {

    protected final ImageView imageView;
    protected final Button btn_easy_mode;
    protected final Button btn_middle_mode;
    protected final Button btn_hard_mode;
    protected final Button button;

    public ChooseDiffucultyScreenBase() {

        imageView = new ImageView();
        btn_easy_mode = new Button();
        btn_middle_mode = new Button();
        btn_hard_mode = new Button();
        button = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(622.0);
        setPrefWidth(430.0);

        imageView.setFitHeight(185.0);
        imageView.setFitWidth(200.0);
        imageView.setLayoutX(122.0);
        imageView.setLayoutY(42.0);
        imageView.getStyleClass().add("logo");
        //imageView.setImage(new Image(getClass().getResource("../assets/XOpicture.jpg").toExternalForm()));
        imageView.setImage(new Image(Config.LOGO));

        btn_easy_mode.setLayoutX(147.0);
        btn_easy_mode.setLayoutY(318.0);
        btn_easy_mode.setMnemonicParsing(false);
        btn_easy_mode.setOnAction(this::isEasyMode);
        btn_easy_mode.setPrefHeight(31.0);
        btn_easy_mode.setPrefWidth(150.0);
        btn_easy_mode.getStyleClass().add("main_button");
        btn_easy_mode.setText("Easy Mode");

        btn_middle_mode.setLayoutX(147.0);
        btn_middle_mode.setLayoutY(381.0);
        btn_middle_mode.setMnemonicParsing(false);
        btn_middle_mode.setOnAction(this::isMiddleMode);
        btn_middle_mode.setPrefHeight(31.0);
        btn_middle_mode.setPrefWidth(150.0);
        btn_middle_mode.getStyleClass().add("main_button");
        btn_middle_mode.setText("Middle Mode");

        btn_hard_mode.setLayoutX(147.0);
        btn_hard_mode.setLayoutY(440.0);
        btn_hard_mode.setMnemonicParsing(false);
        btn_hard_mode.setOnAction(this::isHardMode);
        btn_hard_mode.setPrefHeight(31.0);
        btn_hard_mode.setPrefWidth(150.0);
        btn_hard_mode.getStyleClass().add("main_button");
        btn_hard_mode.setText("Hard Mode");

        button.setLayoutX(14.0);
        button.setLayoutY(14.0);
        button.setMnemonicParsing(false);
        button.setOnAction(this::onBackClicked);
        button.getStyleClass().add("back_button");
        button.setText("<");

        getChildren().add(imageView);
        getChildren().add(btn_easy_mode);
        getChildren().add(btn_middle_mode);
        getChildren().add(btn_hard_mode);
        getChildren().add(button);

    }

    protected abstract void isEasyMode(javafx.event.ActionEvent actionEvent);

    protected abstract void isMiddleMode(javafx.event.ActionEvent actionEvent);

    protected abstract void isHardMode(javafx.event.ActionEvent actionEvent);

    protected abstract void onBackClicked(javafx.event.ActionEvent actionEvent);

}
