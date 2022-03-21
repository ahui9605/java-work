package com.example.lab7;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Lab7 extends Application {
    private TextField firstName = new TextField();
    private TextField lastName = new TextField();
    private TextField title = new TextField();
    private TextField result = new TextField();
    private Button message = new Button("Message");

    @Override
    public void start(Stage stage) {
        firstName.setMaxWidth(150);
        lastName.setMaxWidth(150);
        title.setMaxWidth(150);
        result.setPrefWidth(300);

        GridPane gridPane = new GridPane();
        gridPane.setHgap(5);
        gridPane.setVgap(5);

        gridPane.add(new Label("First Name"), 0, 0);
        gridPane.add(firstName, 1, 0);
        gridPane.add(new Label("Last Name"), 0, 1);
        gridPane.add(lastName, 1, 1);
        gridPane.add(new Label("Title"), 0, 2);
        gridPane.add(title, 1, 2);
        gridPane.add(message, 0, 3);
        gridPane.add(result, 1, 3);
        gridPane.setAlignment(Pos.CENTER);

        result.setEditable(false);

        message.setOnAction(new printResult());

        Scene scene = new Scene(gridPane, 500, 150);
        stage.setTitle("Greetings");
        stage.setScene(scene);
        stage.show();
    }

    class printResult implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent actionEvent) {
            printResult();
        }
    }

    private void printResult() {
        String greetingMessage = "Good afternoon " + title.getText() + " " + firstName.getText() + " " + lastName.getText();
        result.setText(greetingMessage);
    }

    public static void main(String[] args) {
        launch();
    }
}

