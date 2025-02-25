package be.kdg.cityhall;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import be.kdg.cityhall.view.Presenter;
import be.kdg.cityhall.view.CityHallPane;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Create the CityHallPane (view)
        CityHallPane view = new CityHallPane();
        primaryStage.setTitle("City Hall");

        // Create an AnchorPane as the root container
        AnchorPane root = new AnchorPane();

        // Add the CityHallPane to the AnchorPane
        root.getChildren().add(view);

        // Position the CityHallPane (optional, if you want to control its position)
        AnchorPane.setTopAnchor(view, 10.0); // 10 pixels from the top
        AnchorPane.setLeftAnchor(view, 10.0); // 10 pixels from the left

        // Set up the scene and stage
        Scene scene = new Scene(root, 700, 500); // Set the scene size
        primaryStage.setScene(scene);
        primaryStage.show();

        // Initialize the Presenter (to handle logic)
        Presenter presenter = new Presenter(view);
    }

    public static void main(String[] args) {
        launch(args);
    }
}