package tictaktoejavafx.view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import tictaktoejavafx.utils.Config;

public abstract class GameBoardRecordScreenBase extends AnchorPane {

    protected final ImageView imageView;
    protected final Label date_id;
    protected final Label label;
    protected final AnchorPane anchorPane;
    protected final Button btn_Game_one;
    protected final Button btn_Game_four;
    protected final Button btn_Game_seven;
    protected final Button btn_Game_two;
    protected final Button btn_Game_three;
    protected final Button btn_Game_five;
    protected final Button btn_Game_six;
    protected final Button btn_Game_eight;
    protected final Button btn_Game_nine;
    protected final Button button;
    protected final Label label_player1;
    protected final Label label_player2;
    protected final Label label0;
    protected final Label type_id;

    public GameBoardRecordScreenBase() {

        imageView = new ImageView();
        date_id = new Label();
        label = new Label();
        anchorPane = new AnchorPane();
        btn_Game_one = new Button();
        btn_Game_four = new Button();
        btn_Game_seven = new Button();
        btn_Game_two = new Button();
        btn_Game_three = new Button();
        btn_Game_five = new Button();
        btn_Game_six = new Button();
        btn_Game_eight = new Button();
        btn_Game_nine = new Button();
        button = new Button();
        label_player1 = new Label();
        label_player2 = new Label();
        label0 = new Label();
        type_id = new Label();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(470.0);
        setPrefWidth(795.0);

        imageView.setFitHeight(155.0);
        imageView.setFitWidth(143.0);
        imageView.setLayoutX(624.0);
        imageView.setLayoutY(42.0);
        imageView.getStyleClass().add("logo");
        imageView.setImage(new Image(Config.LOGO));
        date_id.setLayoutX(320.0);
        date_id.setLayoutY(21.0);
        date_id.getStyleClass().add("title");
        date_id.setText("Date");

        label.setId("vs");
        label.setLayoutX(678.0);
        label.setLayoutY(330.0);
        label.setText("VS");

        anchorPane.setLayoutX(37.0);
        anchorPane.setLayoutY(44.0);
        anchorPane.setPrefHeight(398.0);
        anchorPane.setPrefWidth(530.0);

        btn_Game_one.setLayoutX(45.0);
        btn_Game_one.setLayoutY(38.0);
        btn_Game_one.setMnemonicParsing(false);
        btn_Game_one.setOnAction(this::isGameOne);
        btn_Game_one.setPrefHeight(99.0);
        btn_Game_one.setPrefWidth(125.0);
        btn_Game_one.getStyleClass().add("game_button");

        btn_Game_four.setLayoutX(42.0);
        btn_Game_four.setLayoutY(164.0);
        btn_Game_four.setMnemonicParsing(false);
        btn_Game_four.setOnAction(this::isGameFour);
        btn_Game_four.setPrefHeight(85.0);
        btn_Game_four.setPrefWidth(125.0);
        btn_Game_four.getStyleClass().add("game_button");

        btn_Game_seven.setLayoutX(45.0);
        btn_Game_seven.setLayoutY(268.0);
        btn_Game_seven.setMnemonicParsing(false);
        btn_Game_seven.setOnAction(this::isGameSeven);
        btn_Game_seven.setPrefHeight(85.0);
        btn_Game_seven.setPrefWidth(125.0);
        btn_Game_seven.getStyleClass().add("game_button");

        btn_Game_two.setLayoutX(192.0);
        btn_Game_two.setLayoutY(42.0);
        btn_Game_two.setMnemonicParsing(false);
        btn_Game_two.setOnAction(this::isGameTwo);
        btn_Game_two.setPrefHeight(92.0);
        btn_Game_two.setPrefWidth(125.0);
        btn_Game_two.getStyleClass().add("game_button");

        btn_Game_three.setLayoutX(349.0);
        btn_Game_three.setLayoutY(44.0);
        btn_Game_three.setMnemonicParsing(false);
        btn_Game_three.setOnAction(this::isGameThree);
        btn_Game_three.setPrefHeight(92.0);
        btn_Game_three.setPrefWidth(151.0);
        btn_Game_three.getStyleClass().add("game_button");

        btn_Game_five.setLayoutX(192.0);
        btn_Game_five.setLayoutY(164.0);
        btn_Game_five.setMnemonicParsing(false);
        btn_Game_five.setOnAction(this::isGameFive);
        btn_Game_five.setPrefHeight(85.0);
        btn_Game_five.setPrefWidth(133.0);
        btn_Game_five.getStyleClass().add("game_button");

        btn_Game_six.setLayoutX(357.0);
        btn_Game_six.setLayoutY(164.0);
        btn_Game_six.setMnemonicParsing(false);
        btn_Game_six.setOnAction(this::isGameSix);
        btn_Game_six.setPrefHeight(85.0);
        btn_Game_six.setPrefWidth(143.0);
        btn_Game_six.getStyleClass().add("game_button");

        btn_Game_eight.setLayoutX(183.0);
        btn_Game_eight.setLayoutY(272.0);
        btn_Game_eight.setMnemonicParsing(false);
        btn_Game_eight.setOnAction(this::isGameEight);
        btn_Game_eight.setPrefHeight(78.0);
        btn_Game_eight.setPrefWidth(151.0);
        btn_Game_eight.getStyleClass().add("game_button");

        btn_Game_nine.setLayoutX(357.0);
        btn_Game_nine.setLayoutY(272.0);
        btn_Game_nine.setMnemonicParsing(false);
        btn_Game_nine.setOnAction(this::isGameNine);
        btn_Game_nine.setPrefHeight(78.0);
        btn_Game_nine.setPrefWidth(143.0);
        btn_Game_nine.getStyleClass().add("game_button");

        button.setLayoutX(-25.0);
        button.setLayoutY(-34.0);
        button.setMnemonicParsing(false);
        button.setOnAction(this::onBackClicked);
        button.getStyleClass().add("back_button");
        button.setText("<");

        label_player1.setLayoutX(659.0);
        label_player1.setLayoutY(299.0);
        label_player1.setPrefHeight(31.0);
        label_player1.setPrefWidth(74.0);
        label_player1.getStyleClass().add("sub_title");
        label_player1.setText("player1");
        label_player1.setTextAlignment(javafx.scene.text.TextAlignment.RIGHT);

        label_player2.setLayoutX(662.0);
        label_player2.setLayoutY(351.0);
        label_player2.setPrefHeight(31.0);
        label_player2.setPrefWidth(68.0);
        label_player2.getStyleClass().add("sub_title");
        label_player2.setText("player2");

        label0.setLayoutX(657.0);
        label0.setLayoutY(207.0);
        label0.getStyleClass().add("title");
        label0.setText("Tic Tac Toe");

        type_id.setLayoutX(671.0);
        type_id.setLayoutY(243.0);
        type_id.getStyleClass().add("title");
        type_id.setText("Type");

        getChildren().add(imageView);
        getChildren().add(date_id);
        getChildren().add(label);
        anchorPane.getChildren().add(btn_Game_one);
        anchorPane.getChildren().add(btn_Game_four);
        anchorPane.getChildren().add(btn_Game_seven);
        anchorPane.getChildren().add(btn_Game_two);
        anchorPane.getChildren().add(btn_Game_three);
        anchorPane.getChildren().add(btn_Game_five);
        anchorPane.getChildren().add(btn_Game_six);
        anchorPane.getChildren().add(btn_Game_eight);
        anchorPane.getChildren().add(btn_Game_nine);
        anchorPane.getChildren().add(button);
        getChildren().add(anchorPane);
        getChildren().add(label_player1);
        getChildren().add(label_player2);
        getChildren().add(label0);
        getChildren().add(type_id);

    }

    protected abstract void isGameOne(javafx.event.ActionEvent actionEvent);

    protected abstract void isGameFour(javafx.event.ActionEvent actionEvent);

    protected abstract void isGameSeven(javafx.event.ActionEvent actionEvent);

    protected abstract void isGameTwo(javafx.event.ActionEvent actionEvent);

    protected abstract void isGameThree(javafx.event.ActionEvent actionEvent);

    protected abstract void isGameFive(javafx.event.ActionEvent actionEvent);

    protected abstract void isGameSix(javafx.event.ActionEvent actionEvent);

    protected abstract void isGameEight(javafx.event.ActionEvent actionEvent);

    protected abstract void isGameNine(javafx.event.ActionEvent actionEvent);

    protected abstract void onBackClicked(javafx.event.ActionEvent actionEvent);

}
