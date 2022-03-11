package com.example.calculator;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * @author Zehui Liu
 * @date March 11, 2022
 * A JavaFX program displays the calculator GUI without any function
 */

public class Calculator extends Application {
    @Override
    public void start(Stage primaryStage) {

        //Add button by calling the Button class
        Button num1 = new Button("1");
        Button num2 = new Button("2");
        Button num3 = new Button("3");
        Button num4 = new Button("4");
        Button num5 = new Button("5");
        Button num6 = new Button("6");
        Button num7 = new Button("7");
        Button num8 = new Button("8");
        Button num9 = new Button("9");
        Button num0 = new Button("0");
        Button DOT = new Button(".");
        Button DIV = new Button("/");
        Button MUL = new Button("*");
        Button SUB = new Button("-");
        Button ADD = new Button("+");
        Button EQU = new Button("=");
        Button SQT = new Button("SQT");
        Button SIN = new Button("SIN");
        Button COS = new Button("COS");
        Button C = new Button("C");

        //change the button size by invoking the setButtonSize method
        setButtonSize(num1);
        setButtonSize(num2);
        setButtonSize(num3);
        setButtonSize(num4);
        setButtonSize(num5);
        setButtonSize(num6);
        setButtonSize(num7);
        setButtonSize(num8);
        setButtonSize(num9);
        setButtonSize(num0);
        setButtonSize(DOT);
        setButtonSize(DIV);
        setButtonSize(MUL);
        setButtonSize(SUB);
        setButtonSize(ADD);
        setButtonSize(EQU);
        setButtonSize(SQT);
        setButtonSize(SIN);
        setButtonSize(COS);
        setButtonSize(C);


        //GridPane for button
        GridPane gp = new GridPane();
        gp.setHgap(1.0);
        gp.setVgap(1.0);

        // add buttons in their correct position
        // 1,2,3,+ are located at first row
        gp.add(num1, 0, 0);
        gp.add(num2, 1, 0);
        gp.add(num3, 2, 0);
        gp.add(ADD, 3, 0);

        //4,5,6,- are located at second row
        gp.add(num4, 0, 1);
        gp.add(num5, 1, 1);
        gp.add(num6, 2, 1);
        gp.add(SUB, 3, 1);

        //7,8,9,* are located at third row
        gp.add(num7, 0, 2);
        gp.add(num8, 1, 2);
        gp.add(num9, 2, 2);
        gp.add(MUL, 3, 2);

        // dot, 0, =, / are located at fourth row
        gp.add(DOT, 0, 3);
        gp.add(num0, 1, 3);
        gp.add(EQU, 2, 3);
        gp.add(DIV, 3, 3);

        //Square root, Sin, Cos and clear are located at fifth row
        gp.add(SQT, 0, 4);
        gp.add(SIN, 1, 4);
        gp.add(COS, 2, 4);
        gp.add(C, 3, 4);

        //Create the textfield for output the answer
        TextField tf = new TextField();
        BorderPane result = new BorderPane();
        //set the width and move it at top middle
        tf.setMaxWidth(180);
        result.setTop(tf);
        BorderPane.setAlignment(tf, Pos.CENTER);

        //Add Gridpane in the BorderPane so it can appear on the screen
        result.setCenter(gp);
        Scene scene = new Scene(result, 250, 154);

        // Create a scene and place it in the stage
        primaryStage.setTitle("Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * A method to change the button height and width
     **/
    public void setButtonSize(Button button) {
        button.setPrefHeight(15.0);
        button.setPrefWidth(80.0);
    }

}