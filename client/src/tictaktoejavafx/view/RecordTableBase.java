package tictaktoejavafx.view;

import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import tictaktoejavafx.utils.Config;

public abstract class RecordTableBase extends AnchorPane {

    protected final Button back_btn;
    protected final ScrollPane scrollPane;
    protected final TableView table_record_id;
    protected final TableColumn date_colum;
    protected final TableColumn x_name_colum;
    protected final TableColumn o_name_colum;
    protected final TableColumn type_colum;
    protected final ImageView imageView;

    public RecordTableBase() {

        back_btn = new Button();
        scrollPane = new ScrollPane();
        table_record_id = new TableView();
        date_colum = new TableColumn();
        x_name_colum = new TableColumn();
        o_name_colum = new TableColumn();
        type_colum = new TableColumn();
        imageView = new ImageView();

            setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(571.0);
        setPrefWidth(747.0);

        back_btn.setLayoutX(26.0);
        back_btn.setLayoutY(22.0);
        back_btn.setMnemonicParsing(false);
        back_btn.setOnAction(this::isBackbtn);
               //------------------------------------
        Image img = new Image("tictaktoejavafx/assets/images/back.png");
        ImageView view = new ImageView(img);
        view.setFitHeight(30);
        view.setFitWidth(30);
        view.setPreserveRatio(true);
        back_btn.setGraphic(view);
//-------------------------------------

          scrollPane.setLayoutX(172.0);
        scrollPane.setLayoutY(35.0);
        scrollPane.setPrefHeight(516.0);
        scrollPane.setPrefWidth(564.0);

        table_record_id.setPrefHeight(513.0);
        table_record_id.setPrefWidth(562.0);

        date_colum.setPrefWidth(175.0);
        date_colum.setText("Date");

        x_name_colum.setPrefWidth(94.0);
        x_name_colum.setText("XName");

        o_name_colum.setPrefWidth(95.0);
        o_name_colum.setText("OName");

        type_colum.setPrefWidth(102.0);
        type_colum.setText("Active");
        scrollPane.setContent(table_record_id);

        imageView.setFitHeight(118.0);
        imageView.setFitWidth(126.0);
        imageView.setLayoutX(26.0);
        imageView.setLayoutY(205.0);
        imageView.getStyleClass().add("logo");
      //  imageView.setImage(new Image(getClass().getResource("../assets/XOpicture.jpg").toExternalForm()));
imageView.setImage(new Image(Config.LOGO));
        getChildren().add(back_btn);
        table_record_id.getColumns().add(date_colum);
        table_record_id.getColumns().add(x_name_colum);
        table_record_id.getColumns().add(o_name_colum);
        table_record_id.getColumns().add(type_colum);
        getChildren().add(scrollPane);
        getChildren().add(imageView);

    }

    protected abstract void isBackbtn(javafx.event.ActionEvent actionEvent);

}
