package be.kdg.calculator.view;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public class CalculatorPane extends GridPane {
    private TextField display;
    private Button button7, button8, button9, buttonPlus;
    private Button button4, button5, button6, buttonMultiply;
    private Button button1, button2, button3, buttonMinus;
    private Button button0, buttonDecimal, buttonDivide, buttonEquals;

    public CalculatorPane() {
        initialiseNodes();
        layoutNodes();
        applyStyling(); // Optional: Add basic styling
    }

    private void initialiseNodes() {
        // Initialize text field
        display = new TextField();
        display.setEditable(false);
        display.setAlignment(Pos.CENTER_RIGHT);

        // Initialize buttons
        button7 = new Button("7");
        button8 = new Button("8");
        button9 = new Button("9");
        buttonPlus = new Button("+");

        button4 = new Button("4");
        button5 = new Button("5");
        button6 = new Button("6");
        buttonMultiply = new Button("x");

        button1 = new Button("1");
        button2 = new Button("2");
        button3 = new Button("3");
        buttonMinus = new Button("-");
        buttonEquals = new Button("=");

        button0 = new Button("0");
        buttonDecimal = new Button(","); // Using comma for decimal (based on your OperandCharacter)
        buttonDivide = new Button("/");
    }

    private void layoutNodes() {
        // Set padding and gaps for a compact, clean layout
        this.setPadding(new Insets(10));
        this.setHgap(5);
        this.setVgap(5);

        // Add text field at the top (span 4 columns, fixed height)
        this.add(display, 0, 0, 4, 1);
        GridPane.setHalignment(display, HPos.CENTER);
        GridPane.setValignment(display, VPos.CENTER);
        GridPane.setHgrow(display, Priority.ALWAYS);
        GridPane.setVgrow(display, Priority.NEVER);

        // Row 1: 7, 8, 9, +
        this.add(button7, 0, 1);
        this.add(button8, 1, 1);
        this.add(button9, 2, 1);
        this.add(buttonPlus, 3, 1);

        // Row 2: 4, 5, 6, x
        this.add(button4, 0, 2);
        this.add(button5, 1, 2);
        this.add(button6, 2, 2);
        this.add(buttonMultiply, 3, 2);

        // Row 3: 1, 2, 3, -
        this.add(button1, 0, 3);
        this.add(button2, 1, 3);
        this.add(button3, 2, 3);
        this.add(buttonMinus, 3, 3);

        // Row 4: 0, ,, /, =
        this.add(button0, 0, 4);
        this.add(buttonDecimal, 1, 4);
        this.add(buttonDivide, 2, 4);
        this.add(buttonEquals, 3, 4);

        // Set button constraints (consistent size, controlled growth)
        for (Button button : new Button[]{
                button7, button8, button9, buttonPlus,
                button4, button5, button6, buttonMultiply,
                button1, button2, button3, buttonMinus,
                button0, buttonDecimal, buttonDivide, buttonEquals}) {
            GridPane.setConstraints(button, 0, 0, 1, 1, HPos.CENTER, VPos.CENTER, Priority.NEVER, Priority.NEVER);
            button.setMinSize(50, 50); // Slightly larger buttons for a polished look
            button.setMaxSize(100, 50); // Limit maximum size to prevent stretching
        }
    }

    private void applyStyling() {
        // Apply CSS for a modern look (use the provided calculator.css)
        this.getStyleClass().add("calculator");
        display.getStyleClass().add("text-field");
        for (Button button : new Button[]{
                button7, button8, button9, buttonPlus,
                button4, button5, button6, buttonMultiply,
                button1, button2, button3, buttonMinus,
                button0, buttonDecimal, buttonDivide, buttonEquals}) {
            button.getStyleClass().add("button");
        }
    }

    // Getters
    public TextField getDisplay() { return display; }
    public Button getButton0() { return button0; }
    public Button getButton1() { return button1; }
    public Button getButton2() { return button2; }
    public Button getButton3() { return button3; }
    public Button getButton4() { return button4; }
    public Button getButton5() { return button5; }
    public Button getButton6() { return button6; }
    public Button getButton7() { return button7; }
    public Button getButton8() { return button8; }
    public Button getButton9() { return button9; }
    public Button getButtonPlus() { return buttonPlus; }
    public Button getButtonMinus() { return buttonMinus; }
    public Button getButtonMultiply() { return buttonMultiply; }
    public Button getButtonDivide() { return buttonDivide; }
    public Button getButtonEquals() { return buttonEquals; }
    public Button getButtonDecimal() { return buttonDecimal; }
}