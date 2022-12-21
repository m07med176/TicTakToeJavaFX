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

    protected final ScrollPane scrollPane;
    protected final TableView table_record_id;
    protected final TableColumn date_colum;
    protected final TableColumn x_name_colum;
    protected final TableColumn o_name_colum;
    protected final TableColumn type_colum;
    protected final TableColumn date_colum0;
    protected final TableColumn x_name_colum0;
    protected final TableColumn o_name_colum0;
    protected final TableColumn type_colum0;
    protected final ImageView imageView;
    protected final Button back_button;

    public RecordTableBase() {

        scrollPane = new ScrollPane();
        table_record_id = new TableView();
        date_colum = new TableColumn();
        x_name_colum = new TableColumn();
        o_name_colum = new TableColumn();
        type_colum = new TableColumn();
        date_colum0 = new TableColumn();
        x_name_colum0 = new TableColumn();
        o_name_colum0 = new TableColumn();
        type_colum0 = new TableColumn();
        imageView = new ImageView();
        back_button = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(571.0);
        setPrefWidth(743.0);

        scrollPane.setLayoutX(200.0);
        scrollPane.setLayoutY(38.0);
        scrollPane.setPrefHeight(506.0);
        scrollPane.setPrefWidth(529.0);

        table_record_id.setPrefHeight(507.0);
        table_record_id.setPrefWidth(514.0);

        date_colum.setPrefWidth(169.0);
        date_colum.setText("Date");

        x_name_colum.setPrefWidth(109.0);
        x_name_colum.setText("XName");

        o_name_colum.setPrefWidth(117.0);
        o_name_colum.setText("OName");

        type_colum.setPrefWidth(121.0);
        type_colum.setText("Type");

        date_colum0.setPrefWidth(175.0);
        date_colum0.setText("Date");

        x_name_colum0.setPrefWidth(94.0);
        x_name_colum0.setText("XName");

        o_name_colum0.setPrefWidth(95.0);
        o_name_colum0.setText("OName");

        type_colum0.setPrefWidth(102.0);
        type_colum0.setText("Active");
        scrollPane.setContent(table_record_id);

        imageView.setFitHeight(118.0);
        imageView.setFitWidth(126.0);
        imageView.setLayoutX(26.0);
        imageView.setLayoutY(205.0);
        imageView.getStyleClass().add("logo");
       // imageView.setImage(new Image(getClass().getResource("../assets/XOpicture.jpg").toExternalForm()));
imageView.setImage(new Image(Config.LOGO));
        back_button.setLayoutX(24.0);
        back_button.setLayoutY(32.0);
        back_button.setMnemonicParsing(false);
        back_button.setOnAction(this::isBack);
        Image img = new Image("tictaktoejavafx/assets/images/back.png");
        ImageView view = new ImageView(img);
        view.setFitHeight(30);
        view.setFitWidth(30);
        view.setPreserveRatio(true);
        back_button.setGraphic(view);


        table_record_id.getColumns().add(date_colum);
        table_record_id.getColumns().add(x_name_colum);
        table_record_id.getColumns().add(o_name_colum);
        table_record_id.getColumns().add(type_colum);
        table_record_id.getColumns().add(date_colum0);
        table_record_id.getColumns().add(x_name_colum0);
        table_record_id.getColumns().add(o_name_colum0);
        table_record_id.getColumns().add(type_colum0);
        getChildren().add(scrollPane);
        getChildren().add(imageView);
      getChildren().add(back_button);

    }

    protected abstract void isBack(javafx.event.ActionEvent actionEvent);

}
