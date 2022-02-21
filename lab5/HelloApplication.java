package com.example.firstfx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
        Button button = new Button("Weather looks nice out there");
        Scene scene = new Scene(button, 250, 250);
        stage.setTitle("Zehui Liu");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}