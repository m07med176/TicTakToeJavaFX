package tictaktoejavafx.view;

import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import tictaktoejavafx.utils.AssetsRepository;

public abstract class LoginScreenBase extends AnchorPane {

    protected final ImageView imageView;
    protected final Button btn_login;
    protected final Label label;
    protected final PasswordField password;
    protected final TextField user_name;
    protected final Hyperlink create_account;

    public LoginScreenBase() {

        imageView = new ImageView();
        btn_login = new Button();
        label = new Label();
        password = new PasswordField();
        user_name = new TextField();
        create_account = new Hyperlink();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(518.0);
        setPrefWidth(600.0);

        imageView.setFitHeight(136.0);
        imageView.setFitWidth(168.0);
        imageView.setLayoutX(203.0);
        imageView.setLayoutY(56.0);
        imageView.getStyleClass().add("logo");
        imageView.setImage(new Image(AssetsRepository.LOGO)); 

        btn_login.setLayoutX(274.0);
        btn_login.setLayoutY(375.0);
        btn_login.setMnemonicParsing(false);
        btn_login.setOnAction(this::isLogin);
        btn_login.setText("Login");

        label.setLayoutX(250.0);
        label.setLayoutY(203.0);
        label.getStyleClass().add("title");
        label.setText("Tic Tac Toe");

        password.setLayoutX(200.0);
        password.setLayoutY(317.0);
        password.setPrefHeight(39.0);
        password.setPrefWidth(204.0);
        password.setPromptText("password");

        user_name.setLayoutX(196.0);
        user_name.setLayoutY(259.0);
        user_name.setPrefHeight(39.0);
        user_name.setPrefWidth(204.0);
        user_name.setPromptText("User Name");

        create_account.setLayoutX(231.0);
        create_account.setLayoutY(414.0);
        create_account.setOnAction(this::CreateAccount);
        create_account.setPrefHeight(21.0);
        create_account.setPrefWidth(168.0);
        create_account.getStyleClass().add("link_button");
        create_account.setText("Create an Account?");

        getChildren().add(imageView);
        getChildren().add(btn_login);
        getChildren().add(label);
        getChildren().add(password);
        getChildren().add(user_name);
        getChildren().add(create_account);

    }

    protected abstract void isLogin(javafx.event.ActionEvent actionEvent);

    protected abstract void CreateAccount(javafx.event.ActionEvent actionEvent);

}
