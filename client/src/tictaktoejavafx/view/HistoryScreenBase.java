package tictaktoejavafx.view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public abstract class HistoryScreenBase extends AnchorPane {

    protected final ImageView imageView;
    protected final Button back_button;
    protected final Label label;
    protected final ScrollPane scrollPane;
    protected final TableView table_history_data;
    protected final TableColumn colum_date;
    protected final TableColumn colum_Xname;
    protected final TableColumn colum_Oname;
    protected final TableColumn colum_winner;

    public HistoryScreenBase() {

        imageView = new ImageView();
        back_button = new Button();
        label = new Label();
        scrollPane = new ScrollPane();
        table_history_data = new TableView();
        colum_date = new TableColumn();
        colum_Xname = new TableColumn();
        colum_Oname = new TableColumn();
        colum_winner = new TableColumn();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(429.0);
        setPrefWidth(623.0);

        imageView.setFitHeight(150.0);
        imageView.setFitWidth(200.0);
        imageView.setLayoutX(14.0);
        imageView.setLayoutY(85.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);

        back_button.setLayoutX(14.0);
        back_button.setLayoutY(22.0);
        back_button.setMnemonicParsing(false);
        back_button.setOnAction(this::isBack);
        //back_button.setText("Button");
        back_button.getStyleClass().add("back_button");
        back_button.setText("<");

        label.setLayoutX(87.0);
        label.setLayoutY(250.0);
        label.setText("Label");

        scrollPane.setLayoutX(172.0);
        scrollPane.setLayoutY(35.0);
        scrollPane.setPrefHeight(359.0);
        scrollPane.setPrefWidth(431.0);

        
        table_history_data.setPrefHeight(354.0);
        table_history_data.setPrefWidth(429.0);

        colum_date.setPrefWidth(163.0);
        colum_date.setText("date");

        colum_Xname.setText(" XName");

        colum_Oname.setPrefWidth(88.0);
        colum_Oname.setText("OName");

        colum_winner.setPrefWidth(96.0);
        colum_winner.setText("Winner");
        scrollPane.setContent(table_history_data);

        getChildren().add(imageView);
        getChildren().add(back_button);
        getChildren().add(label);
        table_history_data.getColumns().add(colum_date);
        table_history_data.getColumns().add(colum_Xname);
        table_history_data.getColumns().add(colum_Oname);
        table_history_data.getColumns().add(colum_winner);
        getChildren().add(scrollPane);

    }

    protected abstract void isBack(javafx.event.ActionEvent actionEvent);


}
