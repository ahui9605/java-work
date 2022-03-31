package com.example.lab08;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.scene.layout.HBox;

public class lab08 extends Application {

    private TextField originalNum = new TextField();
    private TextField convertedNum = new TextField();
    private String currentSelection;
    BorderPane pane = new BorderPane();
    HBox hbox = new HBox(15);
    HBox hbox2 = new HBox(15);


    @Override
    public void start(Stage stage) throws Exception {
        String selection[] = {"Binary", "Octal", "Hexadecimal"};
        ComboBox combo_box = new ComboBox(FXCollections.observableArrayList(selection));

        hbox.setPadding(new Insets(15, 15, 15, 15));
        hbox.getChildren().add(originalNum);
        hbox.getChildren().add(convertedNum);
        hbox.setAlignment(Pos.CENTER);

        hbox2.setPadding(new Insets(15, 15, 15, 15));
        hbox2.setAlignment(Pos.BOTTOM_CENTER);
        hbox2.getChildren().add(combo_box);

        combo_box.valueProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object o, Object t1) {
                currentSelection = combo_box.getValue().toString();
                System.out.println(combo_box.getValue());
                checkComboBox();
            }
        });

        originalNum.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                checkComboBox();
            }
        });

        pane.setTop(hbox);
        pane.setCenter(hbox2);

        Scene scene = new Scene(pane, 450, 150);
        stage.setTitle("Lab 08");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

    private void checkComboBox() {
        try {
            if (currentSelection.equals("Binary")) {
                int binaryInt = Integer.parseInt(originalNum.getText());
                convertedNum.setText(binaryConvert(binaryInt));
            } else if (currentSelection.equals("Hexadecimal")) {
                int hexadecimalInt = Integer.parseInt(originalNum.getText());
                convertedNum.setText(hexadecimalConvert(hexadecimalInt));
            } else if (currentSelection.equals("Octal")) {
                int octalInt = Integer.parseInt(originalNum.getText());
                convertedNum.setText(octalConvert(octalInt));
            }
        } catch (NumberFormatException e) {
            convertedNum.setText("empty value");
        } catch (NullPointerException e) {
            convertedNum.setText("Pick one from ComboBox");
        }
    }

    private String binaryConvert(int originalNum) {
        ArrayList<Integer> array = new ArrayList<>();
        int count = 0;
        while (originalNum > 0) {
            int number = originalNum % 2;
            array.add((array.size() - count), number);
            originalNum = originalNum / 2;
            count++;
        }
        System.out.println("binary array: " + array);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.size(); i++) {
            int num = array.get(i);
            sb.append(num);
        }
        return sb.toString();
    }

    private String hexadecimalConvert(int originalNum) {
        int number;
        String result = "";
        char[] hexDecimalList = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        while (originalNum > 0) {
            number = originalNum % 16;
            result = hexDecimalList[number] + result;
            originalNum = originalNum / 16;
        }
        System.out.println("hexadecimal: " + result);
        return result;
    }

    private String octalConvert(int originalNum) {
        int number = 0;
        String result = "";
        char[] octalList = {'0', '1', '2', '3', '4', '5', '6', '7', '8'};

        while (originalNum > 0) {
            number = originalNum % 8;
            result = octalList[number] + result;
            originalNum = originalNum / 8;
        }
        System.out.println("octal: " + result);
        return result;
    }
}

