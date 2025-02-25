package be.kdg.calculator.presenter;

import be.kdg.calculator.model.Calculator;
import be.kdg.calculator.model.CalculatorException;
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
        // Attach event handlers to buttons
        view.getButton0().setOnAction(event -> handleInput("0"));
        view.getButton1().setOnAction(event -> handleInput("1"));
        // Repeat for other number buttons...

        view.getButtonPlus().setOnAction(event -> handleInput("+"));
        view.getButtonMinus().setOnAction(event -> handleInput("-"));
        view.getButtonMultiply().setOnAction(event -> handleInput("x"));
        view.getButtonDivide().setOnAction(event -> handleInput("/"));

        view.getButtonClear().setOnAction(event -> model.clear());
        view.getButtonEquals().setOnAction(event -> {
            try {
                model.calculate();
            } catch (CalculatorException e) {
                view.getDisplay().setText("Error");
            }
        });

        // Update view after each button press
        updateView();
    }

    private void handleInput(String input) {
        try {
            model.handleInput(input);
        } catch (CalculatorException e) {
            view.getDisplay().setText("Error");
        }
        updateView();
    }

    private void updateView() {
        view.getDisplay().setText(model.getDisplayText());
    }
}