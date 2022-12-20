package tictaktoejavafx.view;

import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public abstract class RecordTableBase extends AnchorPane {

    protected final ScrollPane scrollPane;
    protected final TableView table_record_id;
    protected final TableColumn date_colum;
    protected final TableColumn x_name_colum;
    protected final TableColumn o_name_colum;
    protected final TableColumn type_colum;
    protected final ImageView imageView;
    protected final Button button;

    public RecordTableBase() {

        scrollPane = new ScrollPane();
        table_record_id = new TableView();
        date_colum = new TableColumn();
        x_name_colum = new TableColumn();
        o_name_colum = new TableColumn();
        type_colum = new TableColumn();
        imageView = new ImageView();
        button = new Button();

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
        scrollPane.setContent(table_record_id);

        imageView.setFitHeight(116.0);
        imageView.setFitWidth(147.0);
        imageView.setLayoutX(26.0);
        imageView.setLayoutY(76.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);

        button.setLayoutX(34.0);
        button.setLayoutY(34.0);
        button.setMnemonicParsing(false);
        button.setOnAction(this::onBackClicked);
        button.getStyleClass().add("back_button");
        button.setText("<");

        table_record_id.getColumns().add(date_colum);
        table_record_id.getColumns().add(x_name_colum);
        table_record_id.getColumns().add(o_name_colum);
        table_record_id.getColumns().add(type_colum);
        getChildren().add(scrollPane);
        getChildren().add(imageView);
        getChildren().add(button);

    }

    protected abstract void onBackClicked(javafx.event.ActionEvent actionEvent);

}
