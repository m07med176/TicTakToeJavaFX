package tictaktoejavafx.view;

import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

public abstract class RecordTableBase extends AnchorPane {

    protected final Button back_btn;
    protected final ScrollPane scrollPane;
    protected final TableView table_record_id;
    protected final TableColumn date_colum;
    protected final TableColumn x_name_colum;
    protected final TableColumn o_name_colum;
    protected final TableColumn type_colum;

    public RecordTableBase() {

        back_btn = new Button();
        scrollPane = new ScrollPane();
        table_record_id = new TableView();
        date_colum = new TableColumn();
        x_name_colum = new TableColumn();
        o_name_colum = new TableColumn();
        type_colum = new TableColumn();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(588.0);
        setPrefWidth(731.0);

        back_btn.setLayoutX(26.0);
        back_btn.setLayoutY(22.0);
        back_btn.setMnemonicParsing(false);
        back_btn.setOnAction(this::isBackbtn);
        back_btn.setText("<");

        scrollPane.setLayoutX(164.0);
        scrollPane.setLayoutY(38.0);
        scrollPane.setPrefHeight(507.0);
        scrollPane.setPrefWidth(523.0);

        table_record_id.setPrefHeight(686.0);
        table_record_id.setPrefWidth(582.0);

        date_colum.setPrefWidth(175.0);
        date_colum.setText("Date");

        x_name_colum.setPrefWidth(94.0);
        x_name_colum.setText("XName");

        o_name_colum.setPrefWidth(95.0);
        o_name_colum.setText("OName");

        type_colum.setPrefWidth(102.0);
        type_colum.setText("Active");
        scrollPane.setContent(table_record_id);

        getChildren().add(back_btn);
        table_record_id.getColumns().add(date_colum);
        table_record_id.getColumns().add(x_name_colum);
        table_record_id.getColumns().add(o_name_colum);
        table_record_id.getColumns().add(type_colum);
        getChildren().add(scrollPane);

    }

    protected abstract void isBackbtn(javafx.event.ActionEvent actionEvent);

}
