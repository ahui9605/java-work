package com.example.project1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * @author Zehui Liu
 * @date March 23, 2022
 * A JavaFX program displays the calculator GUI that allows the users to enter numbers and operations using only the mouse
 */

public class Calculator extends Application {
    //initialize data and class
    private double memory = 0;
    private double memory1 = 0;
    private int operator = -1;
    private boolean dotted = false;
    private boolean secondInput = false;

    GridPane gp = new GridPane();
    TextField tf = new TextField();
    BorderPane result = new BorderPane();

    //Add button by invoking the Button class
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


    /**
     * A method to start the GUI program
     **/
    @Override
    public void start(Stage primaryStage) {
        //change the button size by invoking the setButtonSize method
        setALLButtonSize();
        //place those buttons in the right position
        gridPane();
        //Create the textfield for outputting the answer
        textField();

        //setting up each button's action
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

        trigonometry_sqrt(tf, SIN, "sin");
        trigonometry_sqrt(tf, COS, "cos");
        trigonometry_sqrt(tf, SQT, "sqrt");

        dotActionEvent();
        clearActionEvent();

        equal();

        // Create a scene and place it in the stage
        Scene scene = new Scene(result, 250, 154);
        primaryStage.setTitle("Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * A method to control the clear button action on the calculator
     **/
    private void clearActionEvent() {

        EventHandler<ActionEvent> clear = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                //when a clear button clicked, remove everything included all values and actions from previous calculation
                memory = 0;
                memory1 = 0;
                dotted = false;
                operator = -1;
                secondInput = false;

                //empty the display number
                tf.setText("");

                System.out.println("all clear from clear handler: " + memory + ", " + memory1 + ", " + dotted + ", " + operator);
            }
        };
        //clear button action set
        C.setOnAction(clear);
    }

    /**
     * A method to control the dot button action on the calculator
     **/
    private void dotActionEvent() throws NumberFormatException {

        EventHandler<ActionEvent> dot = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //no more than 1 dot appear on the textfield
                if (dotted) {
                    tf.setText("too much dots");
                } else {
                    //can only be appeared once, it can be appeared again by clicking equal, clear, operator buttons
                    tf.setText(tf.getText() + ".");
                    dotted = true;
                }
            }
        };
        //dot button action set
        DOT.setOnAction(dot);
    }

    private void trigonometry_sqrt(TextField tf, Button bt, String display) {
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    memory = Double.parseDouble(tf.getText());
                } catch (NumberFormatException empty_value) {
                    tf.setText("Error(empty value");
                }

                double number = 0;
                if (display.equals("sin")) {
                    number = Math.sin(memory);
                } else if (display.equals("cos")) {
                    number = Math.cos(memory);
                } else if (display.equals("sqrt")) {
                    number = Math.sqrt(memory);
                }


                if (memory % 1 == 0 && number % 1 == 0) {
                    int number1 = (int) number;
                    tf.setText(String.valueOf(number1));
                } else {
                    tf.setText(String.valueOf(number));
                }
            }

        };
        bt.setOnAction(event);
    }

    /**
     * A method to control the operators' action on the calculator
     **/
    private void operatorActionEvent(TextField tf, Button bt, String display) {

        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            @Override

            public void handle(ActionEvent actionEvent) {
                try {
                    secondInput = true;
                    memory = Double.parseDouble(tf.getText());
                    System.out.println("operator button clicked, memory from number Action record: " + memory);
                    if (display.equals("+")) {
                        operator = 1;
                        dotted = false;
                    } else if (display.equals("-")) {
                        operator = 2;
                        dotted = false;
                    } else if (display.equals("*")) {
                        operator = 3;
                        dotted = false;
                    } else if (display.equals("/")) {
                        operator = 4;
                        dotted = false;
                    }
                } catch (NumberFormatException empty_values) {
                    tf.setText("Error(empty value)");
                }
            }
        };

        bt.setOnAction(event);
    }

    /**
     * A method to control the numeric button's action on the calculator
     **/
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
     * A method to control the equal button action on the calculator
     **/
    private void equal() {
        EventHandler<ActionEvent> equal = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    //converting the second number to the double number entered by the user
                    memory1 = Double.parseDouble(tf.getText());
                    System.out.println("memory1 from operator action: " + memory1);

                    //check which operator did user clicked
                    switch (operator) {
                        case 1:
                            //check if the user did not enter any decimal number or dot
                            if ((memory + memory) % 1 == 0) {
                                //force to convert the result into integer with no decimal place
                                int addNumber = (int) memory + (int) memory1;
                                //add value and display it on the GUI textfield
                                tf.setText(String.valueOf(addNumber));
                            } else {
                                //display the decimal number on the GUI textfield
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
                        default:
                            tf.setText("Error");
                            System.out.println("Error");
                            break;
                    }
                    //stop the calculation when user inputs a number divide by zero
                } catch (ArithmeticException divide_by_zero) {
                    //inform the user why the program stops the calculation
                    tf.setText("Cannot divide by zero");
                    //stop the calculation when user clicks operator buttons without numeric value
                } catch (NumberFormatException empty_value) {
                    //inform the user why the program stops the calculation
                    tf.setText("Error(empty value)");
                }
            }
        };

        //equal button action set
        EQU.setOnAction(equal);
    }

    /**
     * A method to display the numbers and calculation on the window
     **/
    private void textField() {

        tf.setEditable(false);
        tf.setAlignment(Pos.BOTTOM_RIGHT);

        //set the width and move it at top middle
        tf.setMaxWidth(180);
        result.setTop(tf);
        BorderPane.setAlignment(tf, Pos.CENTER);

        //Add Gridpane in the BorderPane so it can appear on the screen
        result.setCenter(gp);

    }

    /**
     * A method to add buttons' location in the pane
     **/
    public void gridPane() {

        //GridPane for button
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

    }

    /**
     * A method to change all button size with their flexible size
     **/
    public void adjustButtonSize(Button button) {
        button.setPrefHeight(Integer.MAX_VALUE);
        button.setPrefWidth(Integer.MAX_VALUE);

    }

    /**
     * A method to change all button height and width
     **/
    public void setALLButtonSize() {
        adjustButtonSize(num1);
        adjustButtonSize(num2);
        adjustButtonSize(num3);
        adjustButtonSize(num4);
        adjustButtonSize(num5);
        adjustButtonSize(num6);
        adjustButtonSize(num7);
        adjustButtonSize(num8);
        adjustButtonSize(num9);
        adjustButtonSize(num0);
        adjustButtonSize(DOT);
        adjustButtonSize(ADD);
        adjustButtonSize(SUB);
        adjustButtonSize(MUL);
        adjustButtonSize(DIV);
        adjustButtonSize(EQU);
        adjustButtonSize(SQT);
        adjustButtonSize(SIN);
        adjustButtonSize(COS);
        adjustButtonSize(C);
    }
}