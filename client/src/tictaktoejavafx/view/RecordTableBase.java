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
    protected final TableView table_id;
    protected final TableColumn Date_colum;
    protected final TableColumn winner_colum;
    protected final TableColumn Oname_colum;
    protected final TableColumn Winner_colum;
    protected final ImageView imageView;
    protected final Label label;

    public RecordTableBase() {

        back_btn = new Button();
        scrollPane = new ScrollPane();
        table_id = new TableView();
        Date_colum = new TableColumn();
        winner_colum = new TableColumn();
        Oname_colum = new TableColumn();
        Winner_colum = new TableColumn();
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
        back_btn.setText("Back");

        scrollPane.setLayoutX(200.0);
        scrollPane.setLayoutY(38.0);
        scrollPane.setPrefHeight(346.0);
        scrollPane.setPrefWidth(384.0);

        table_id.setPrefHeight(338.0);
        table_id.setPrefWidth(372.0);

        Date_colum.setPrefWidth(128.0);
        Date_colum.setText("Date");

        winner_colum.setPrefWidth(65.0);
        winner_colum.setText("XName");

        Oname_colum.setPrefWidth(85.0);
        Oname_colum.setText("OName");

        Winner_colum.setPrefWidth(91.0);
        Winner_colum.setText("Winner");
        scrollPane.setContent(table_id);

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
        table_id.getColumns().add(Date_colum);
        table_id.getColumns().add(winner_colum);
        table_id.getColumns().add(Oname_colum);
        table_id.getColumns().add(Winner_colum);
        getChildren().add(scrollPane);
        getChildren().add(imageView);
        getChildren().add(label);

    }

    protected abstract void isBackbtn(javafx.event.ActionEvent actionEvent);

}
