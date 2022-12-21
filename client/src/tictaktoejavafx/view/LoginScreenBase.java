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

public abstract class LoginScreenBase extends AnchorPane {

    protected final ImageView imageView;
    protected final Button btn_login;
    protected final Label label;
    protected final PasswordField password;
    protected final TextField user_name;
    protected final Hyperlink create_account;
    protected final Button button;

    public LoginScreenBase() {

        imageView = new ImageView();
        btn_login = new Button();
        label = new Label();
        password = new PasswordField();
        user_name = new TextField();
        create_account = new Hyperlink();
        button = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(518.0);
        setPrefWidth(600.0);

        imageView.setFitHeight(136.0);
        imageView.setFitWidth(168.0);
        imageView.setLayoutX(225.0);
        imageView.setLayoutY(55.0);
        imageView.getStyleClass().add("logo");
        imageView.setImage(new Image(Config.LOGO));

        btn_login.setLayoutX(274.0);
        btn_login.setLayoutY(375.0);
        btn_login.setMnemonicParsing(false);
        btn_login.setOnAction(this::isLogin);
        btn_login.getStyleClass().add("main_button");
        btn_login.setText("Login");

        label.setLayoutX(273.0);
        label.setLayoutY(203.0);
        label.getStyleClass().add("title");
        label.setText("Tic Tac Toe");

        password.setLayoutX(200.0);
        password.setLayoutY(317.0);
        password.setPrefHeight(39.0);
        password.setPrefWidth(204.0);
        password.setPromptText("password");
        password.getStyleClass().add("main_input");

        user_name.setLayoutX(200.0);
        user_name.setLayoutY(259.0);
        user_name.setPrefHeight(39.0);
        user_name.setPrefWidth(204.0);
        user_name.setPromptText("User Name");
        user_name.getStyleClass().add("main_input");

        create_account.setLayoutX(244.0);
        create_account.setLayoutY(411.0);
        create_account.setOnAction(this::CreateAccount);
        create_account.setPrefHeight(23.0);
        create_account.setPrefWidth(117.0);
        create_account.getStyleClass().add("link_button");
        create_account.setText("Create an Account");

        button.setLayoutX(26.0);
        button.setLayoutY(23.0);
        button.setMnemonicParsing(false);
        button.getStyleClass().add("back_button");
        button.setText("<");
        button.setOnAction(this::isBack);

        getChildren().add(imageView);
        getChildren().add(btn_login);
        getChildren().add(label);
        getChildren().add(password);
        getChildren().add(user_name);
        getChildren().add(create_account);
        getChildren().add(button);

    }

    protected abstract void isLogin(javafx.event.ActionEvent actionEvent);

    protected abstract void CreateAccount(javafx.event.ActionEvent actionEvent);
    protected abstract void isBack(javafx.event.ActionEvent actionEvent);


}
