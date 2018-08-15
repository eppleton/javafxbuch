package de.javafxbuch;


import java.net.URL;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class CalculatorController implements Initializable {

    public enum Operator {

        ADD, SUBTRACT, MULTIPLY, DIVIDE, NONE;
    }
    @FXML
    private Button add;
    @FXML
    private Label display;
    @FXML
    private Button subtract;
    @FXML
    private Button clear;
    @FXML
    private Button negate;
    @FXML
    private Button equals;
    @FXML
    private Button divide;
    @FXML
    private Button multiply;
    private Double operand1;
    private Operator operator;
    private Double operand2;
    private StringProperty displayedtext = new SimpleStringProperty("0");
    private boolean reset = false;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        display.textProperty().bind(displayedtext);
        equals.getStyleClass().add("equals");
    }

    public void handleButtonAction(ActionEvent e) {
        Button source = (Button) e.getSource();
        if (source == add) {
            setOperator(Operator.ADD);
        } else if (source == subtract) {
            setOperator(Operator.SUBTRACT);
        } else if (source == multiply) {
            setOperator(Operator.MULTIPLY);
        } else if (source == divide) {
            setOperator(Operator.DIVIDE);
        } else if (source == equals) {
            setOperator(Operator.NONE);
        } else if (source == clear) {
            clear();
        } else if (source == negate) {
            try {
                Number parse = NumberFormat.getInstance(Locale.US).parse(displayedtext.get());
                double res = parse.doubleValue() * -1;
                displayedtext.set(NumberFormat.getInstance(Locale.US).format(res));
            } catch (ParseException ex) {
                Logger.getLogger(CalculatorController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (reset) {
                displayedtext.set("0");
                reset = false;
            }
            String num = display.getText() + source.getText();
            num = num.replaceAll("^0+(?!$)", "");
            displayedtext.set(num);
        }
    }

    private void doCalculation() {
        if (operator == null) {
            return;
        }
        try {
            Number parse = NumberFormat.getInstance(Locale.US).parse(displayedtext.get());
            double val = parse.doubleValue();
            System.out.println("value " + val);
            if (operand1 == null) {
                operand1 = val;
            } else {
                operand2 = val;
            }
            if (operand2 != null) {
                operand1 = calc(operand1, operand2);
                displayedtext.set(NumberFormat.getInstance(Locale.US).format(operand1));
                operand2 = null;
            } else {
                displayedtext.set("0");
            }
            operator = null;

        } catch (ParseException ex) {
            Logger.getLogger(CalculatorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private double calc(double currentValue, Double operand) {
        double result = currentValue;
        switch (operator) {
            case ADD:
                result = currentValue + operand;
                break;
            case SUBTRACT:
                result = currentValue - operand;
                break;
            case MULTIPLY:
                result = currentValue * operand;
                break;
            case DIVIDE:
                result = currentValue / operand;
                break;
        }
        return result;

    }

    private void setOperator(Operator operator) {
        if (operator != null) {
            doCalculation();
        }
        setOperand1();
        this.operator = operator;
    }

    private void setOperand1() {
        try {
            Number parse = NumberFormat.getInstance(Locale.US).parse(displayedtext.get());
            operand1 = parse.doubleValue();
            reset = true;
        } catch (ParseException ex) {
            Logger.getLogger(CalculatorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void clear() {
        operand1 = null;
        operand2 = null;
        operator = null;
        displayedtext.set("0");
    }
}
