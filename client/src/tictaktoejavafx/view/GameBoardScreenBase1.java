package tictaktoejavafx.view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

public abstract class GameBoardScreenBase1 extends AnchorPane {

    protected final ImageView imageView;
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
    protected final Button video_btn;

    public GameBoardScreenBase1() {

        imageView = new ImageView();
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
        video_btn = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(470.0);
        setPrefWidth(795.0);

        imageView.setFitHeight(155.0);
        imageView.setFitWidth(143.0);
        imageView.setLayoutX(591.0);
        imageView.setLayoutY(44.0);
        imageView.getStyleClass().add("logo");
        imageView.setImage(new Image(getClass().getResource("../assets/XOpicture.jpg").toExternalForm()));

        label.setId("vs");
        label.setLayoutX(678.0);
        label.setLayoutY(309.0);
        label.setText("VS");
        label.setFont(new Font("System Bold Italic", 12.0));

        anchorPane.setLayoutX(37.0);
        anchorPane.setLayoutY(44.0);
        anchorPane.setPrefHeight(398.0);
        anchorPane.setPrefWidth(530.0);

        btn_Game_one.setLayoutX(45.0);
        btn_Game_one.setLayoutY(45.0);
        btn_Game_one.setMnemonicParsing(false);
        btn_Game_one.setOnAction(this::isGameOne);
        btn_Game_one.setPrefHeight(92.0);
        btn_Game_one.setPrefWidth(125.0);
        btn_Game_one.getStyleClass().add("game_button");

        btn_Game_four.setLayoutX(45.0);
        btn_Game_four.setLayoutY(153.0);
        btn_Game_four.setMnemonicParsing(false);
        btn_Game_four.setOnAction(this::isGameFour);
        btn_Game_four.setPrefHeight(92.0);
        btn_Game_four.setPrefWidth(125.0);
        btn_Game_four.getStyleClass().add("game_button");

        btn_Game_seven.setLayoutX(45.0);
        btn_Game_seven.setLayoutY(259.0);
        btn_Game_seven.setMnemonicParsing(false);
        btn_Game_seven.setOnAction(this::isGameSeven);
        btn_Game_seven.setPrefHeight(92.0);
        btn_Game_seven.setPrefWidth(125.0);
        btn_Game_seven.getStyleClass().add("game_button");

        btn_Game_two.setLayoutX(203.0);
        btn_Game_two.setLayoutY(45.0);
        btn_Game_two.setMnemonicParsing(false);
        btn_Game_two.setOnAction(this::isGameTwo);
        btn_Game_two.setPrefHeight(92.0);
        btn_Game_two.setPrefWidth(125.0);
        btn_Game_two.getStyleClass().add("game_button");

        btn_Game_three.setLayoutX(357.0);
        btn_Game_three.setLayoutY(45.0);
        btn_Game_three.setMnemonicParsing(false);
        btn_Game_three.setOnAction(this::isGameThree);
        btn_Game_three.setPrefHeight(92.0);
        btn_Game_three.setPrefWidth(125.0);
        btn_Game_three.getStyleClass().add("game_button");

        btn_Game_five.setLayoutX(203.0);
        btn_Game_five.setLayoutY(153.0);
        btn_Game_five.setMnemonicParsing(false);
        btn_Game_five.setOnAction(this::isGameFive);
        btn_Game_five.setPrefHeight(92.0);
        btn_Game_five.setPrefWidth(125.0);
        btn_Game_five.getStyleClass().add("game_button");

        btn_Game_six.setLayoutX(357.0);
        btn_Game_six.setLayoutY(153.0);
        btn_Game_six.setMnemonicParsing(false);
        btn_Game_six.setOnAction(this::isGameSix);
        btn_Game_six.setPrefHeight(92.0);
        btn_Game_six.setPrefWidth(125.0);
        btn_Game_six.getStyleClass().add("game_button");

        btn_Game_eight.setLayoutX(203.0);
        btn_Game_eight.setLayoutY(259.0);
        btn_Game_eight.setMnemonicParsing(false);
        btn_Game_eight.setOnAction(this::isGameEight);
        btn_Game_eight.setPrefHeight(92.0);
        btn_Game_eight.setPrefWidth(125.0);
        btn_Game_eight.getStyleClass().add("game_button");

        btn_Game_nine.setLayoutX(357.0);
        btn_Game_nine.setLayoutY(259.0);
        btn_Game_nine.setMnemonicParsing(false);
        btn_Game_nine.setOnAction(this::isGameNine);
        btn_Game_nine.setPrefHeight(92.0);
        btn_Game_nine.setPrefWidth(125.0);
        btn_Game_nine.getStyleClass().add("game_button");

        button.setLayoutX(-25.0);
        button.setLayoutY(-34.0);
        button.setMnemonicParsing(false);
        button.setOnAction(this::onBackClicked);
        button.getStyleClass().add("back_button");
        button.setText("<");

        label_player1.setLayoutX(660.0);
        label_player1.setLayoutY(260.0);
        label_player1.setPrefHeight(31.0);
        label_player1.setPrefWidth(74.0);
        label_player1.getStyleClass().add("sub_title");
        label_player1.setText("player1");
        label_player1.setTextAlignment(javafx.scene.text.TextAlignment.RIGHT);

        label_player2.setLayoutX(660.0);
        label_player2.setLayoutY(337.0);
        label_player2.setPrefHeight(31.0);
        label_player2.setPrefWidth(68.0);
        label_player2.getStyleClass().add("sub_title");
        label_player2.setText("player2");

        video_btn.setLayoutX(652.0);
        video_btn.setLayoutY(404.0);
        video_btn.setMnemonicParsing(false);
        video_btn.setOnAction(this::isVideo);
        video_btn.setPrefHeight(38.0);
        video_btn.setPrefWidth(81.0);
        video_btn.setStyle("-fx-background-radius: 100;");

        getChildren().add(imageView);
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
        getChildren().add(video_btn);

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

    protected abstract void isVideo(javafx.event.ActionEvent actionEvent);

}
