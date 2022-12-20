package tictaktoejavafx.view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public abstract class RecordTableBase extends AnchorPane {

    protected final Button back_btn;
    protected final ScrollPane scrollPane;
    protected final TableView table_record_id;
    protected final TableColumn date_colum;
    protected final TableColumn x_name_colum;
    protected final TableColumn o_name_colum;
    protected final TableColumn type_colum;
    protected final ImageView imageView;
    protected final Label label;

    public RecordTableBase() {

        back_btn = new Button();
        scrollPane = new ScrollPane();
        table_record_id = new TableView();
        date_colum = new TableColumn();
        x_name_colum = new TableColumn();
        o_name_colum = new TableColumn();
        type_colum = new TableColumn();
        imageView = new ImageView();
        label = new Label();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        back_btn.setLayoutX(26.0);
        back_btn.setLayoutY(22.0);
        back_btn.setMnemonicParsing(false);
        back_btn.setOnAction(this::isBackbtn);
        back_btn.getStyleClass().add("back_button");
        back_btn.setText("<");

        scrollPane.setLayoutX(200.0);
        scrollPane.setLayoutY(38.0);
        scrollPane.setPrefHeight(346.0);
        scrollPane.setPrefWidth(384.0);

        table_record_id.setPrefHeight(338.0);
        table_record_id.setPrefWidth(372.0);

        date_colum.setPrefWidth(97.0);
        date_colum.setText("Date");

        x_name_colum.setPrefWidth(86.0);
        x_name_colum.setText("XName");

        o_name_colum.setPrefWidth(102.0);
        o_name_colum.setText("OName");

        type_colum.setPrefWidth(85.0);
        type_colum.setText("Type");
        scrollPane.setContent(table_record_id);

        imageView.setFitHeight(116.0);
        imageView.setFitWidth(147.0);
        imageView.setLayoutX(26.0);
        imageView.setLayoutY(76.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);

        label.setLayoutX(63.0);
        label.setLayoutY(211.0);
        label.setText("Tic Tac Toe");

        getChildren().add(back_btn);
        table_record_id.getColumns().add(date_colum);
        table_record_id.getColumns().add(x_name_colum);
        table_record_id.getColumns().add(o_name_colum);
        table_record_id.getColumns().add(type_colum);
        getChildren().add(scrollPane);
        getChildren().add(imageView);
        getChildren().add(label);

    }

    protected abstract void isBackbtn(javafx.event.ActionEvent actionEvent);

}
