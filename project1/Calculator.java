package com.example.project1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author Zehui Liu
 * @date March 11, 2022
 * A JavaFX program displays the calculator GUI without any function
 */

public class Calculator extends Application {
    float memory = 0;
    float memory1 = 0;
    int operator = -1;
    boolean dotted = false;
    boolean secondInput = false;

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
        tf.setEditable(false);
        tf.setAlignment(Pos.BOTTOM_RIGHT);
        BorderPane result = new BorderPane();
        //set the width and move it at top middle
        tf.setMaxWidth(180);
        result.setTop(tf);
        BorderPane.setAlignment(tf, Pos.CENTER);

        //Add Gridpane in the BorderPane so it can appear on the screen
        result.setCenter(gp);

        numberActionEvent(tf, num1, "1");
        numberActionEvent(tf, num2, "2");
        numberActionEvent(tf, num3, "3");
        numberActionEvent(tf, num4, "4");
        numberActionEvent(tf, num5, "5");
        numberActionEvent(tf, num6, "6");
        numberActionEvent(tf, num7, "7");
        numberActionEvent(tf, num8, "8");
        numberActionEvent(tf, num9, "9");
        numberActionEvent(tf, num0, "0");

        operatorActionEvent(tf, ADD, "+");
        operatorActionEvent(tf, DIV, "/");
        operatorActionEvent(tf, SUB, "-");
        operatorActionEvent(tf, MUL, "*");
        operatorActionEvent(tf, SQT, "sqt");
        operatorActionEvent(tf, SIN, "sin");
        operatorActionEvent(tf, COS, "cos");

        EventHandler<ActionEvent> sqrtRoot = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                memory = Float.parseFloat(tf.getText());
                if (memory % 1 == 0 && Math.sqrt(memory) % 1 == 0) {
                    int int_sqrt = (int) Math.sqrt(memory);
                    tf.setText(String.valueOf(int_sqrt));
                } else {
                    tf.setText(String.valueOf(Math.sqrt(memory)));
                }
            }
        };
        SQT.setOnAction(sqrtRoot);
//------------------------------------------------------------------------------------------------------------------
        EventHandler<ActionEvent> sin = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                memory = Float.parseFloat(tf.getText());
                if (memory % 1 == 0 && Math.sin(memory) % 1 == 0) {
                    int int_sin = (int) Math.sin(memory);
                    tf.setText(String.valueOf(int_sin));
                } else {
                    tf.setText(String.valueOf(Math.sin(memory)));
                }
            }
        };
        SIN.setOnAction(sin);

        EventHandler<ActionEvent> cos = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                memory = Float.parseFloat(tf.getText());
                if (memory % 1 == 0 && Math.cos(memory) % 1 == 0) {
                    int int_cos = (int) Math.cos(memory);
                    tf.setText(String.valueOf(int_cos));
                } else {
                    tf.setText(String.valueOf(Math.cos(memory)));
                }
            }
        };
        COS.setOnAction(cos);

        EventHandler<ActionEvent> dot = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                dotted = true;
                tf.setText(tf.getText() + ".");
            }
        };
        DOT.setOnAction(dot);


        EventHandler<ActionEvent> clear = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                memory = 0;
                memory1 = 0;
                dotted = false;
                operator = -1;
                secondInput = false;

                tf.setText("");
                System.out.println("all clear from clear handler: " + memory + " " + memory1 + " " + dotted + " " + operator);
            }
        };

        C.setOnAction(clear);
//------------------------------------------------------------------------------------------------------------------
        EventHandler<ActionEvent> equal = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    memory1 = Float.parseFloat(tf.getText());
                    System.out.println("memory1 from operator action" + memory1);

                    switch (operator) {
                        case 1:
                            if ((memory + memory) % 1 == 0) {
                                int addNumber = (int) memory + (int) memory1;
                                tf.setText(String.valueOf(addNumber));
                            } else {
                                tf.setText(String.valueOf(memory + memory1));
                            }
                            break;
                        case 2:
                            if ((memory - memory1) % 1 == 0) {
                                int minusNumber = (int) memory - (int) memory1;
                                tf.setText(String.valueOf(minusNumber));
                            } else {
                                tf.setText(String.valueOf(memory - memory1));
                            }
                            break;
                        case 3:
                            if ((memory * memory1) % 1 == 0) {
                                int multiplyNumber = (int) memory * (int) memory1;
                                tf.setText(String.valueOf(multiplyNumber));
                            } else {
                                tf.setText(String.valueOf(memory * memory1));
                            }
                            break;
                        case 4:
                            if ((memory / memory1) % 1 == 0) {
                                int divideNumber = (int) memory / (int) memory1;
                                tf.setText(String.valueOf(divideNumber));
                            } else {
                                tf.setText(String.valueOf(memory / memory1));
                            }
                            break;
                    }

                } catch (ArithmeticException divide_by_zero) {
                    tf.setText("Cannot divide by zero");
                } catch (NumberFormatException empty_value) {
                    tf.setText("Error(Empty values)");
                }
            }
        };
        EQU.setOnAction(equal);

        // Create a scene and place it in the stage
        Scene scene = new Scene(result, 250, 154);
        primaryStage.setTitle("Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

//    private void trigonometry_sqrt(TextField tf, Button bt, String display) {
//
//    }

    private void operatorActionEvent(TextField tf, Button bt, String display) {

        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                secondInput = true;
                memory = Float.parseFloat(tf.getText());
                System.out.println("operator button clicked, memory from number Action record" + memory);
                if (display.equals("+")) {
                    operator = 1;
                } else if (display.equals("-")) {
                    operator = 2;
                } else if (display.equals("*")) {
                    operator = 3;
                } else if (display.equals("/")) {
                    operator = 4;
                }
            }
        };

        bt.setOnAction(event);
    }

    private void numberActionEvent(TextField tf, Button bt, String display) {
        EventHandler<ActionEvent> numberEvent = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (secondInput) {
                    tf.setText("");
                    secondInput = false;
                }
                tf.setText(tf.getText() + display);
            }
        };
        bt.setOnAction(numberEvent);
    }

    /**
     * A method to change the button height and width
     **/
    public void setButtonSize(Button button) {
        button.setPrefHeight(15.0);
        button.setPrefWidth(80.0);
    }
}