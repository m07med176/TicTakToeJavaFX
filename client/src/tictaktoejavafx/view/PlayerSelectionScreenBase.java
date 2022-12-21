package tictaktoejavafx.view;

import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import tictaktoejavafx.utils.Config;

public abstract class PlayerSelectionScreenBase extends AnchorPane {

    protected final ImageView imageView;
    protected final AnchorPane anchorPane;
    protected final TableView table_player_selection;
    protected final TableColumn columName;
    protected final TableColumn columEmail;
    protected final TableColumn columActive;

    public PlayerSelectionScreenBase() {

        imageView = new ImageView();
        anchorPane = new AnchorPane();
        table_player_selection = new TableView();
        columName = new TableColumn();
        columEmail = new TableColumn();
        columActive = new TableColumn();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(530.0);
        setPrefWidth(785.0);

        imageView.setFitHeight(170.0);
        imageView.setFitWidth(183.0);
        imageView.setLayoutX(571.0);
        imageView.setLayoutY(74.0);
        imageView.getStyleClass().add("logo");
        imageView.setImage(new Image(Config.LOGO));

        anchorPane.setLayoutX(30.0);
        anchorPane.setLayoutY(32.0);
        anchorPane.setPrefHeight(448.0);
        anchorPane.setPrefWidth(514.0);

        table_player_selection.setLayoutX(1.0);
        table_player_selection.setLayoutY(-5.0);
        table_player_selection.setPrefHeight(457.0);
        table_player_selection.setPrefWidth(514.0);

        columName.setPrefWidth(158.0);
        columName.setText("Player Name");

        columEmail.setPrefWidth(248.0);
        columEmail.setText("Email");

        columActive.setMinWidth(1.0);
        columActive.setPrefWidth(107.0);
        columActive.setText("Active");

        getChildren().add(imageView);

        table_player_selection.getColumns().add(columName);
        table_player_selection.getColumns().add(columEmail);
        table_player_selection.getColumns().add(columActive);
        anchorPane.getChildren().add(table_player_selection);
        getChildren().add(anchorPane);

    }
}
