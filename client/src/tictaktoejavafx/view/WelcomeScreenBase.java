package tictaktoejavafx.view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

import tictaktoejavafx.utils.Navigator;
import tictaktoejavafx.utils.Config;

public abstract class WelcomeScreenBase extends AnchorPane {

    protected final Label label;
    protected final Button btn_single;
    protected final Button btn_two;
    protected final Button btn_online_mode;
    protected final ImageView imageView;
    protected final Button btn_History_Mode;
    protected final Button btn_History_Mode1;
    protected final Button btn_two1;
    protected final Button btn_two2;

    public WelcomeScreenBase() {

        label = new Label();
        btn_single = new Button();
        btn_two = new Button();
        btn_online_mode = new Button();
        imageView = new ImageView();
        btn_History_Mode = new Button();
        btn_History_Mode1 = new Button();
        btn_two1 = new Button();
        btn_two2 = new Button();

        setId("AnchorPane");
        setPrefHeight(575.0);
        setPrefWidth(466.0);

        label.setLayoutX(58.0);
        label.setLayoutY(34.0);
        label.setPrefHeight(45.0);
        label.setPrefWidth(350.0);
        label.getStyleClass().add("title");
        label.setText("Welcome in Tic Tac Toe");
        label.setFont(new Font("System Bold", 30.0));

        btn_single.setLayoutX(126.0);
        btn_single.setLayoutY(270.0);
        btn_single.setMnemonicParsing(false);
        btn_single.setOnAction(this::isSingle);
        btn_single.setPrefHeight(45.0);
        btn_single.setPrefWidth(214.0);
        btn_single.getStyleClass().add("main_button");
        btn_single.setText("Single Player");
        btn_single.setTextFill(javafx.scene.paint.Color.valueOf("#0a3257"));
        btn_single.setFont(new Font(22.0));

        Image img = new Image("tictaktoejavafx/assets/images/pc.png");
        ImageView view = new ImageView(img);
        view.setFitHeight(30);
        view.setFitWidth(30);
        view.setPreserveRatio(true);
        btn_single.setGraphic(view);
//------------------------------------
        Image img2 = new Image("tictaktoejavafx/assets/images/multi.png");
        ImageView view2 = new ImageView(img2);
        view2.setFitHeight(30);
        view2.setFitWidth(30);
        view2.setPreserveRatio(true);
        btn_two.setGraphic(view2);
//-------------------------------------

        Image img3 = new Image("tictaktoejavafx/assets/images/online.png");
        ImageView view3 = new ImageView(img3);
        view3.setFitHeight(30);
        view3.setFitWidth(30);
        view3.setPreserveRatio(true);
        btn_online_mode.setGraphic(view3);
//-------------------------------------

        Image img4 = new Image("tictaktoejavafx/assets/images/history.png");
        ImageView view4 = new ImageView(img4);
        view4.setFitHeight(30);
        view4.setFitWidth(30);
        view4.setPreserveRatio(true);
        btn_History_Mode.setGraphic(view4);
//-------------------------------------

        Image img5 = new Image("tictaktoejavafx/assets/images/record2.png");
        ImageView view5 = new ImageView(img5);
        view5.setFitHeight(30);
        view5.setFitWidth(30);
        view5.setPreserveRatio(true);
        isRecord.setGraphic(view5);
//-------------------------------------
        btn_two.setLayoutX(188.0);

        btn_two.setLayoutX(126.0);
        btn_two.setLayoutY(328.0);
        btn_two.setMnemonicParsing(false);
        btn_two.setOnAction(this::isTwo);
        btn_two.setPrefHeight(45.0);
        btn_two.setPrefWidth(214.0);
        btn_two.getStyleClass().add("main_button");
        btn_two.setText("Two Player");
        btn_two.setTextFill(javafx.scene.paint.Color.valueOf("#0a3257"));
        btn_two.setFont(new Font(22.0));

        btn_online_mode.setLayoutX(126.0);
        btn_online_mode.setLayoutY(388.0);
        btn_online_mode.setMnemonicParsing(false);
        btn_online_mode.setOnAction(this::isOnlineMode);
        btn_online_mode.setPrefHeight(45.0);
        btn_online_mode.setPrefWidth(214.0);
        btn_online_mode.getStyleClass().add("main_button");
        btn_online_mode.setText("Online Mode");
        btn_online_mode.setTextFill(javafx.scene.paint.Color.valueOf("#0a3257"));
        btn_online_mode.setFont(new Font(22.0));

        imageView.setFitHeight(165.0);
        imageView.setFitWidth(176.0);
        imageView.setLayoutX(145.0);
        imageView.setLayoutY(79.0);
        imageView.getStyleClass().add("logo");

        //imageView.setImage(new Image(getClass().getResource("../assets/XOpicture.jpg").toExternalForm()));
 imageView.setImage(new Image(Config.LOGO));

        imageView.setId("imageView");

        imageView.setImage(new Image(Config.LOGO));


        btn_History_Mode.setLayoutX(7.0);
        btn_History_Mode.setLayoutY(144.0);
        btn_History_Mode.setMnemonicParsing(false);
        btn_History_Mode.setOnAction(this::isHistoryMode);
        btn_History_Mode.setPrefHeight(45.0);
        btn_History_Mode.setPrefWidth(214.0);
        btn_History_Mode.setText("History Mode");
        btn_History_Mode.setTextFill(javafx.scene.paint.Color.valueOf("#0a3257"));
        btn_History_Mode.setFont(new Font(22.0));

        btn_History_Mode1.setLayoutX(14.0);
        btn_History_Mode1.setLayoutY(202.0);
        btn_History_Mode1.setMnemonicParsing(false);
        btn_History_Mode1.setOnAction(this::isHistoryMode);
        btn_History_Mode1.setPrefHeight(45.0);
        btn_History_Mode1.setPrefWidth(214.0);
        btn_History_Mode1.setText("Record Mode");
        btn_History_Mode1.setTextFill(javafx.scene.paint.Color.valueOf("#0a3257"));
        btn_History_Mode1.setFont(new Font(22.0));

        btn_two1.setLayoutX(126.0);
        btn_two1.setLayoutY(446.0);
        btn_two1.setMnemonicParsing(false);
        btn_two1.setOnAction(this::isTwo);
        btn_two1.setPrefHeight(45.0);
        btn_two1.setPrefWidth(214.0);
        btn_two1.getStyleClass().add("main_button");
        btn_two1.setText("History Mode");
        btn_two1.setTextFill(javafx.scene.paint.Color.valueOf("#0a3257"));
        btn_two1.setFont(new Font(22.0));

        btn_two2.setLayoutX(126.0);
        btn_two2.setLayoutY(502.0);
        btn_two2.setMnemonicParsing(false);
        btn_two2.setOnAction(this::isTwo);
        btn_two2.setPrefHeight(45.0);
        btn_two2.setPrefWidth(214.0);
        btn_two2.getStyleClass().add("main_button");
        btn_two2.setText("Record Mode");
        btn_two2.setTextFill(javafx.scene.paint.Color.valueOf("#0a3257"));
        btn_two2.setFont(new Font(22.0));

        getChildren().add(label);
        getChildren().add(btn_single);
        getChildren().add(btn_two);
        getChildren().add(btn_online_mode);
        getChildren().add(imageView);
        getChildren().add(btn_History_Mode);
        getChildren().add(btn_History_Mode1);
        getChildren().add(btn_two1);
        getChildren().add(btn_two2);

    }

    protected abstract void isSingle(javafx.event.ActionEvent actionEvent);

    protected abstract void isTwo(javafx.event.ActionEvent actionEvent);

    protected abstract void isOnlineMode(javafx.event.ActionEvent actionEvent);

    protected abstract void isHistoryMode(javafx.event.ActionEvent actionEvent);




}
