package be.kdg.calculator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import be.kdg.calculator.model.Calculator;
import be.kdg.calculator.view.CalculatorPane;
import be.kdg.calculator.presenter.Presenter;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create the View (CalculatorPane)
        CalculatorPane calculatorPane = new CalculatorPane();

        // Create the Model (Calculator)
        Calculator calculator = new Calculator();

        // Create the Presenter and connect it to the View and Model
        Presenter presenter = new Presenter(calculatorPane, calculator);

        // Set up the Scene and Stage
        Scene scene = new Scene(calculatorPane, 300, 400); // Adjust size as needed
        primaryStage.setTitle("Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}