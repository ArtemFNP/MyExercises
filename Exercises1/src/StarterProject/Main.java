package StarterProject;

import StarterProject.model.Multiwindow;
import StarterProject.presenter.MultiwindowPresenter;
import StarterProject.view.MultiwindowView;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        Multiwindow model = new Multiwindow();
        MultiwindowView view = new MultiwindowView(primaryStage);
        new MultiwindowPresenter(model, view);
    }

    public static void main(String[] args) {
        launch(args);
    }
}