package tictaktoejavafx.view;

import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import tictaktoejavafx.utils.Config;

public abstract class RegisterScreenBase extends AnchorPane {

    protected final ImageView imageView;
    protected final TextField user_name_register;
    protected final TextField email_register;
    protected final PasswordField password_register;
    protected final PasswordField repeat_password_register;
    protected final Button btn_register;
    protected final Hyperlink have_accout;
    protected final Button button;

    public RegisterScreenBase() {

        imageView = new ImageView();
        user_name_register = new TextField();
        email_register = new TextField();
        password_register = new PasswordField();
        repeat_password_register = new PasswordField();
        btn_register = new Button();
        have_accout = new Hyperlink();
        button = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(582.0);
        setPrefWidth(600.0);

        imageView.setFitHeight(185.0);
        imageView.setFitWidth(200.0);
        imageView.setLayoutX(200.0);
        imageView.setLayoutY(26.0);
        imageView.getStyleClass().add("logo");
        imageView.setImage(new Image(Config.LOGO));

        user_name_register.setLayoutX(197.0);
        user_name_register.setLayoutY(276.0);
        user_name_register.setPromptText("User Name");
        user_name_register.getStyleClass().add("main_input");

        email_register.setLayoutX(197.0);
        email_register.setLayoutY(325.0);
        email_register.setPromptText("Email");
        email_register.getStyleClass().add("main_input");

        password_register.setLayoutX(197.0);
        password_register.setLayoutY(374.0);
        password_register.setPromptText("Password");
        password_register.getStyleClass().add("main_input");

        repeat_password_register.setLayoutX(197.0);
        repeat_password_register.setLayoutY(425.0);
        repeat_password_register.setPromptText("Repeat Password");
        repeat_password_register.getStyleClass().add("main_input");

        btn_register.setLayoutX(231.0);
        btn_register.setLayoutY(477.0);
        btn_register.setMnemonicParsing(false);
        btn_register.setOnAction(this::register);
        btn_register.setPrefHeight(25.0);
        btn_register.setPrefWidth(81.0);
        btn_register.getStyleClass().add("main_button");
        btn_register.setText("Register");
        btn_register.setFont(new Font("System Bold Italic", 12.0));

        have_accout.setLayoutX(226.0);
        have_accout.setLayoutY(520.0);
        have_accout.setOnAction(this::haveAccount);
        have_accout.getStyleClass().add("link_button");
        have_accout.setText("I Have an account");

        button.setLayoutX(14.0);
        button.setLayoutY(13.0);
        button.setMnemonicParsing(false);
        button.setOnAction(this::onBackClicked);
        button.getStyleClass().add("back_button");
        button.setText("<");

        getChildren().add(imageView);
        getChildren().add(user_name_register);
        getChildren().add(email_register);
        getChildren().add(password_register);
        getChildren().add(repeat_password_register);
        getChildren().add(btn_register);
        getChildren().add(have_accout);
        getChildren().add(button);

    }

    protected abstract void register(javafx.event.ActionEvent actionEvent);

    protected abstract void haveAccount(javafx.event.ActionEvent actionEvent);

    protected abstract void onBackClicked(javafx.event.ActionEvent actionEvent);

}
