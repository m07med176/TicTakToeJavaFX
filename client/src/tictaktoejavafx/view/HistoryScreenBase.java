package tictaktoejavafx.view;

import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public abstract class HistoryScreenBase extends AnchorPane {

    protected final ImageView imageView;
    protected final Button back_button;
    protected final ScrollPane scrollPane;
    protected final TableView table_history_data;
    protected final TableColumn colum_date;
    protected final TableColumn colum_Xname;
    protected final TableColumn colum_Oname;
    protected final TableColumn colum_winner;
    protected final Button button;

    public HistoryScreenBase() {

        imageView = new ImageView();
        back_button = new Button();
        scrollPane = new ScrollPane();
        table_history_data = new TableView();
        colum_date = new TableColumn();
        colum_Xname = new TableColumn();
        colum_Oname = new TableColumn();
        colum_winner = new TableColumn();
        button = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(571.0);
        setPrefWidth(747.0);

        imageView.setFitHeight(150.0);
        imageView.setFitWidth(134.0);
        imageView.setLayoutX(14.0);
        imageView.setLayoutY(85.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);

        back_button.setLayoutX(25.0);
        back_button.setLayoutY(41.0);
        back_button.setMnemonicParsing(false);
        back_button.setOnAction(this::isBack);
        back_button.setText("<");
        scrollPane.setLayoutX(188.0);
        scrollPane.setLayoutY(47.0);
        scrollPane.setPrefHeight(432.0);
        scrollPane.setPrefWidth(528.0);

        table_history_data.setPrefHeight(429.0);
        table_history_data.setPrefWidth(527.0);

        colum_date.setPrefWidth(185.0);
        colum_date.setText("date");

        colum_Xname.setPrefWidth(86.0);
        colum_Xname.setText(" XName");

        colum_Oname.setPrefWidth(112.0);
        colum_Oname.setText("OName");

        colum_winner.setPrefWidth(131.0);
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

        button.setLayoutX(123.0);
        button.setLayoutY(160.0);
        button.setMnemonicParsing(false);
        button.getStyleClass().add("back_button");
        button.setText("<");

        getChildren().add(imageView);
        getChildren().add(back_button);
        table_history_data.getColumns().add(colum_date);
        table_history_data.getColumns().add(colum_Xname);
        table_history_data.getColumns().add(colum_Oname);
        table_history_data.getColumns().add(colum_winner);
        getChildren().add(scrollPane);
        getChildren().add(button);

    }

    protected abstract void isBack(javafx.event.ActionEvent actionEvent);

}
