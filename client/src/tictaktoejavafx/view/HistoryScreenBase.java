package tictaktoejavafx.view;

import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import tictaktoejavafx.utils.Config;

public abstract class HistoryScreenBase extends AnchorPane {

    protected final Button back_button;
    protected final ScrollPane scrollPane;
    protected final TableView table_history_data;
    protected final TableColumn colum_date;
    protected final TableColumn colum_Xname;
    protected final TableColumn colum_Oname;
    protected final TableColumn colum_winner;
    protected final ImageView imageView;

    public HistoryScreenBase() {

        back_button = new Button();
        scrollPane = new ScrollPane();
        table_history_data = new TableView();
        colum_date = new TableColumn();
        colum_Xname = new TableColumn();
        colum_Oname = new TableColumn();
        colum_winner = new TableColumn();
        imageView = new ImageView();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(571.0);
        setPrefWidth(747.0);

        back_button.setLayoutX(14.0);
        back_button.setLayoutY(22.0);
        back_button.setMnemonicParsing(false);
        back_button.setOnAction(this::isBack);
                //------------------------------------
        Image img = new Image("tictaktoejavafx/assets/images/back.png");
        ImageView view = new ImageView(img);
        view.setFitHeight(30);
        view.setFitWidth(30);
        view.setPreserveRatio(true);
        back_button.setGraphic(view);
//-------------------------------------

        scrollPane.setLayoutX(172.0);
        scrollPane.setLayoutY(35.0);
        scrollPane.setPrefHeight(516.0);
        scrollPane.setPrefWidth(564.0);

        table_history_data.setPrefHeight(513.0);
        table_history_data.setPrefWidth(562.0);

        colum_date.setPrefWidth(183.0);
        colum_date.setText("date");

        colum_Xname.setPrefWidth(120.0);
        colum_Xname.setText(" XName");

        colum_Oname.setPrefWidth(129.0);
        colum_Oname.setText("OName");

        colum_winner.setPrefWidth(129.0);
        colum_winner.setText("Winner");
        scrollPane.setContent(table_history_data);

        imageView.setFitHeight(118.0);
        imageView.setFitWidth(126.0);
        imageView.setLayoutX(27.0);
        imageView.setLayoutY(195.0);
        imageView.getStyleClass().add("logo");
        //imageView.setImage(new Image(getClass().getResource("../assets/XOpicture.jpg").toExternalForm()));
imageView.setImage(new Image(Config.LOGO));
        getChildren().add(back_button);
        table_history_data.getColumns().add(colum_date);
        table_history_data.getColumns().add(colum_Xname);
        table_history_data.getColumns().add(colum_Oname);
        table_history_data.getColumns().add(colum_winner);
        getChildren().add(scrollPane);
        getChildren().add(imageView);

    }

    protected abstract void isBack(javafx.event.ActionEvent actionEvent);

}
