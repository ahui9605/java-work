package com.example.homework4;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;

import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;

import java.util.ArrayList;

/**
 * @author Zehui Liu
 * @date April 4, 2022
 * A JavaFX program that allow users to add their movies from an add list to the watchlist
 **/
public class Homework extends Application {
    //just some variables in global field
    BorderPane borderPane = new BorderPane();
    Button login = new Button("Login");
    TextField tf = new TextField();

    /**
     * start the program and calling methods, creating scene
     **/
    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(borderPane, 700, 500);

        loginPage(scene);

        stage.setTitle("NetflixWatcher");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * A method to validate the login password and two radiobutton for changing the background color
     **/
    public void loginPage(Scene scene) {
        //hbox for login button and textfield
        HBox hbox = new HBox(15);

        hbox.setAlignment(Pos.TOP_CENTER);
        hbox.getChildren().add(login);
        hbox.setPadding(new Insets(10, 10, 10, 10));
        hbox.getChildren().add(tf);

        //vbox for radiobuttons, light mode and dark mode
        VBox radioButtons = new VBox(20);
        RadioButton lightMode = new RadioButton("Light Mode");
        RadioButton darkMode = new RadioButton("Dark Mode");
        radioButtons.setPadding(new Insets(10, 10, 10, 10));
        radioButtons.setAlignment(Pos.CENTER_LEFT);
        radioButtons.getChildren().addAll(lightMode, darkMode);
        lightMode.setSelected(true);
        //a group of the radio button
        ToggleGroup TG = new ToggleGroup();
        lightMode.setToggleGroup(TG);
        darkMode.setToggleGroup(TG);

        // change the window background color to white
        EventHandler<ActionEvent> lightModeActionEvent = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (lightMode.isSelected()) {
                    scene.getRoot().setStyle("-fx-base:white");
                }
            }
        };
        lightMode.setOnAction(lightModeActionEvent);

        //change the window background color to grey
        EventHandler<ActionEvent> darkModeActionEvent = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (darkMode.isSelected()) {
                    scene.getRoot().setStyle("-fx-base:grey");
                    radioButtons.setStyle("-fx-base:white");
                    tf.setStyle("-fx-base:white");
                    login.setStyle("-fx-base:white");
                }
            }
        };
        darkMode.setOnAction(darkModeActionEvent);

        //validate the password
        EventHandler<ActionEvent> passwordValidate = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if ((tf.getText().equals("123456"))) {
                    tf.setVisible(false);
                    login.setVisible(false);
                    addWatchlist();
                } else {
                    tf.setText("Wrong Password");
                }
            }
        };
        login.setOnAction(passwordValidate);

        //move password textfield to the top of the window
        borderPane.setTop(hbox);
        //move background color buttons to the left of the window
        borderPane.setLeft(radioButtons);

    }


    /**
     * A method to generate the movies add list and watchlist, allow the users to select their movies they'd like to watch
     **/
    public void addWatchlist() {
        Button button = new Button("Add to Watch List");
        Button button2 = new Button("Watch");

        //movies added in the list
        String[] movies = {"The Shawshank Redemption", "The Godfather", "The Godfather: Part II", "12 Angry Men", "Schindler's List,", "The Lord of the Rings: The FellowShip of the Ring", "Pulp Fiction", "The Lord of the Rings: The Return of the Kind", "The Good, the Bad and the Ugly", "Forrest Gump", "Fight Club", "Inception", "The Lord of the Rings: The Two Towers", "Star Wars: Episode V - The Empire Strikes Back", "Goodfellas"};
        ArrayList<String> addedMovies = new ArrayList<>();
        ListView<String> lv = new ListView<>(FXCollections.observableArrayList(movies));
        ListView<String> lv2 = new ListView<>(FXCollections.observableArrayList(addedMovies));

        //alignment for left movies list and button

        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(lv, button);
        lv.setMaxSize(500, 200);
        borderPane.setCenter(vbox);


        //alignment for right watch list and button
        VBox vbox2 = new VBox();
        vbox2.setSpacing(5);
        vbox2.setPadding(new Insets(10, 10, 10, 10));
        vbox2.setAlignment(Pos.CENTER);
        vbox2.getChildren().addAll(lv2, button2);
        lv2.setMaxSize(200, 200);
        borderPane.setRight(vbox2);


        //button for logout
        HBox logoutBox = new HBox();
        Button logout = new Button("Logout");
        logoutBox.getChildren().add(logout);
        logoutBox.setAlignment(Pos.BOTTOM_CENTER);
        logoutBox.setPadding(new Insets(10, 10, 10, 10));
        borderPane.setBottom(logoutBox);

        //add to move a selected movie to the watch list
        EventHandler<ActionEvent> addButton = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String abc = lv.getSelectionModel().getSelectedItem();
                try {
                    //check if there is a duplicated movie in the watchlist from selected movie
                    for (int i = 0; i < lv2.getItems().size(); i++) {
                        String cba = lv2.getItems().get(i);
                        if (abc.equals(cba)) {
                            lv2.getItems().remove(cba);
                            System.out.println("duplicated movies");
                        }
                    }
                    //add a selected movie to the watchlist after clicking the "Add to Watch List" button
                    lv2.getItems().add(lv.getSelectionModel().getSelectedItem());

                    //catch the exception because of empty input from add movies list
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Empty lv2 list, need to add a movie");
                } catch (NullPointerException e) {
                    System.out.println("Empty movies list, need to add a movie");
                }
            }
        };
        button.setOnAction(addButton);


        //watch button actionevent
        EventHandler<ActionEvent> watchButton = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    //delete the first movie after clicking the watch button
                    lv2.getItems().remove(0);
                    //catch the exception because there is no more movie that can watch in the watch list
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Empty Movies List");
                }
            }
        };
        button2.setOnAction(watchButton);

        //logout button action event
        EventHandler<ActionEvent> logoutButton = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //remove the vbox and vbox2, these are for displaying the movies watchlist and movies add-list
                vbox.getChildren().clear();
                vbox2.getChildren().clear();
                //set logout button invisible
                logout.setVisible(false);
                //set visible for login button and remove the password from previous input
                login.setVisible(true);
                tf.setText("");
                tf.setVisible(true);
            }
        };
        logout.setOnAction(logoutButton);

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}