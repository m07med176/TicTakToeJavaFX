package tictaktoejavafx.view;

import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import tictaktoejavafx.utils.Config;

public abstract class RegisterScreenBase extends AnchorPane {

    protected final ImageView imageView;
    protected final Label label;
    protected final TextField user_name_register;
    protected final TextField email_register;
    protected final PasswordField password_register;
    protected final PasswordField repeat_password_register;
    protected final Button btn_register;
    protected final Hyperlink have_accout;

    public RegisterScreenBase() {

        imageView = new ImageView();
        label = new Label();
        user_name_register = new TextField();
        email_register = new TextField();
        password_register = new PasswordField();
        repeat_password_register = new PasswordField();
        btn_register = new Button();
        have_accout = new Hyperlink();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(582.0);
        setPrefWidth(600.0);

        imageView.setFitHeight(185.0);
        imageView.setFitWidth(200.0);
        imageView.setLayoutX(184.0);
        imageView.setLayoutY(25.0);
        imageView.setImage(new Image(Config.LOGO));
        
        label.setLayoutX(247.0);
        label.setLayoutY(222.0);
        label.setText("Tic Tac Toe");

        user_name_register.setLayoutX(197.0);
        user_name_register.setLayoutY(276.0);
        user_name_register.setPromptText("User Name");

        email_register.setLayoutX(197.0);
        email_register.setLayoutY(325.0);
        email_register.setPromptText("Email");

        password_register.setLayoutX(197.0);
        password_register.setLayoutY(374.0);
        password_register.setPromptText("Password");

        repeat_password_register.setLayoutX(197.0);
        repeat_password_register.setLayoutY(425.0);
        repeat_password_register.setPromptText("Repeat Password");

        btn_register.setLayoutX(252.0);
        btn_register.setLayoutY(477.0);
        btn_register.setMnemonicParsing(false);
        btn_register.setOnAction(this::register);
        btn_register.setText("Register");

        have_accout.setLayoutX(226.0);
        have_accout.setLayoutY(520.0);
        have_accout.setOnAction(this::haveAccount);
        have_accout.setText("I Have an account");

        getChildren().add(imageView);
        getChildren().add(label);
        getChildren().add(user_name_register);
        getChildren().add(email_register);
        getChildren().add(password_register);
        getChildren().add(repeat_password_register);
        getChildren().add(btn_register);
        getChildren().add(have_accout);

    }

    protected abstract void register(javafx.event.ActionEvent actionEvent);

    protected abstract void haveAccount(javafx.event.ActionEvent actionEvent);

}
