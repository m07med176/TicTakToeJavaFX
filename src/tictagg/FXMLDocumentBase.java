package tictagg;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public abstract class FXMLDocumentBase extends AnchorPane {

    protected final Button button;
    protected final Label label;
    protected final Button button1;

    public FXMLDocumentBase() {

        button = new Button();
        label = new Label();
        button1 = new Button();

        setId("AnchorPane");
        setPrefHeight(200);
        setPrefWidth(320);

        button.setLayoutX(150.0);
        button.setLayoutY(60.0);
        button.setOnAction(this::handleButtonAction);
        button.setText("Click Me!");

        label.setLayoutX(126);
        label.setLayoutY(120);
        label.setMinHeight(16);
        label.setMinWidth(69);

        button1.setLayoutX(144.0);
        button1.setLayoutY(125.0);
        button1.setOnAction(this::jdhskjfc);
        button1.setText("Click kllksdMe!");

        getChildren().add(button);
        getChildren().add(label);
        getChildren().add(button1);

    }

    protected abstract void handleButtonAction(javafx.event.ActionEvent actionEvent);

    protected abstract void jdhskjfc(javafx.event.ActionEvent actionEvent);

}
