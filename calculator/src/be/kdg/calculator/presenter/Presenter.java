package be.kdg.calculator.presenter;

import be.kdg.calculator.model.Calculator;
import be.kdg.calculator.model.CalculatorException;
import be.kdg.calculator.model.OperandCharacter;
import be.kdg.calculator.model.Operator;
import be.kdg.calculator.view.CalculatorPane;

public class Presenter {
    private CalculatorPane view;
    private Calculator model;

    public Presenter(CalculatorPane view, Calculator model) {
        this.view = view;
        this.model = model;
        addEventHandlers();
    }

    private void addEventHandlers() {
        // Number buttons
        view.getButton0().setOnAction(event -> handleInput("0"));
        view.getButton1().setOnAction(event -> handleInput("1"));
        view.getButton2().setOnAction(event -> handleInput("2"));
        view.getButton3().setOnAction(event -> handleInput("3"));
        view.getButton4().setOnAction(event -> handleInput("4"));
        view.getButton5().setOnAction(event -> handleInput("5"));
        view.getButton6().setOnAction(event -> handleInput("6"));
        view.getButton7().setOnAction(event -> handleInput("7"));
        view.getButton8().setOnAction(event -> handleInput("8"));
        view.getButton9().setOnAction(event -> handleInput("9"));

        // Operator buttons
        view.getButtonPlus().setOnAction(event -> handleOperatorInput("+"));
        view.getButtonMinus().setOnAction(event -> handleOperatorInput("-"));
        view.getButtonMultiply().setOnAction(event -> handleOperatorInput("x"));
        view.getButtonDivide().setOnAction(event -> handleOperatorInput("/"));

        // Decimal button
        view.getButtonDecimal().setOnAction(event -> handleInput("."));

        // Equals button
        view.getButtonEquals().setOnAction(event -> {
            try {
                model.calculate();
                updateView();
            } catch (CalculatorException e) {
                view.getDisplay().setText("Error: " + e.getMessage());
            }
        });

        // Initial update
        updateView();
    }

    private void handleInput(String input) {
        try {
            OperandCharacter operand;
            switch (input) {
                case "0": operand = OperandCharacter.ZERO; break;
                case "1": operand = OperandCharacter.ONE; break;
                case "2": operand = OperandCharacter.TWO; break;
                case "3": operand = OperandCharacter.THREE; break;
                case "4": operand = OperandCharacter.FOUR; break;
                case "5": operand = OperandCharacter.FIVE; break;
                case "6": operand = OperandCharacter.SIX; break;
                case "7": operand = OperandCharacter.SEVEN; break;
                case "8": operand = OperandCharacter.EIGHT; break;
                case "9": operand = OperandCharacter.NINE; break;
                case ".": operand = OperandCharacter.DECIMAL_SEPARATOR; break; // Assuming period for decimal
                default: throw new CalculatorException("Invalid number input: " + input);
            }
            model.handleInput(operand);
            updateView();
        } catch (CalculatorException e) {
            view.getDisplay().setText("Error: " + e.getMessage());
        }
    }

    private void handleOperatorInput(String input) {
        try {
            Operator operator;
            switch (input) {
                case "+": operator = Operator.PLUS; break;
                case "-": operator = Operator.MINUS; break;
                case "x": operator = Operator.MULTIPLY; break;
                case "/": operator = Operator.DIVIDE; break;
                default: throw new CalculatorException("Invalid operator input: " + input);
            }
            model.handleInput(operator);
            updateView();
        } catch (CalculatorException e) {
            view.getDisplay().setText("Error: " + e.getMessage());
        }
    }

    private void updateView() {
        view.getDisplay().setText(model.getDisplay().isEmpty() ? "0" : model.getDisplay());
    }
}