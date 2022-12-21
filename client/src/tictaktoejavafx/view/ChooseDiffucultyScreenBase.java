package tictaktoejavafx.view;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import tictaktoejavafx.utils.Config;

public abstract class ChooseDiffucultyScreenBase extends AnchorPane {

    protected final ImageView imageView;
    protected final Button btn_easy_mode;
    protected final Button btn_hard_mode;
    protected final Button back_button;

    public ChooseDiffucultyScreenBase() {

        imageView = new ImageView();
        btn_easy_mode = new Button();
        btn_hard_mode = new Button();
        back_button = new Button();

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
        imageView.setImage(new Image(Config.LOGO));

        btn_easy_mode.setLayoutX(147.0);
        btn_easy_mode.setLayoutY(344.0);
        btn_easy_mode.setMnemonicParsing(false);
        btn_easy_mode.setOnAction(this::isEasyMode);
        btn_easy_mode.setPrefHeight(31.0);
        btn_easy_mode.setPrefWidth(150.0);
        btn_easy_mode.getStyleClass().add("main_button");
        btn_easy_mode.setText("Easy Mode");
        btn_easy_mode.setFont(new Font("System Bold Italic", 12.0));



        btn_hard_mode.setLayoutX(147.0);
        btn_hard_mode.setLayoutY(406.0);
        btn_hard_mode.setMnemonicParsing(false);
        btn_hard_mode.setOnAction(this::isHardMode);
        btn_hard_mode.setPrefHeight(31.0);
        btn_hard_mode.setPrefWidth(150.0);
        btn_hard_mode.getStyleClass().add("main_button");
        btn_hard_mode.setText("Hard Mode");
        btn_hard_mode.setFont(new Font("System Bold Italic", 12.0));

        back_button.setLayoutX(24.0);
        back_button.setLayoutY(32.0);
        back_button.setMnemonicParsing(false);
        back_button.setOnAction(this::isBack);
        back_button.setText("<");

        getChildren().add(imageView);
        getChildren().add(btn_easy_mode);
        getChildren().add(btn_hard_mode);
        getChildren().add(back_button);

    }

    protected abstract void isEasyMode(javafx.event.ActionEvent actionEvent);

    protected abstract void isHardMode(javafx.event.ActionEvent actionEvent);

    protected abstract void isBack(javafx.event.ActionEvent actionEvent);

}
