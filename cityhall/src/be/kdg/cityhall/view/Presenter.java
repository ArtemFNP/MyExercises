package be.kdg.cityhall.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Presenter {
    private final CityHallPane view;

    public Presenter(CityHallPane view) {
        this.view = view;
        this.addEventHandlers();
    }


    private void addEventHandlers() {
       view.getNormal().setOnAction(event -> view.resetEffect());
       view.getBlackAndWhite().setOnAction(event -> view.applyBlackAndWhiteEffect());
       view.getSepia().setOnAction(event -> view.applySepiaEffect());
    }

    private void attachEventHandlers() {
        view.getNormal().setOnAction(event -> view.resetEffect());
        view.getBlackAndWhite().setOnAction(event -> view.applyBlackAndWhiteEffect());
        view.getSepia().setOnAction(event -> view.applySepiaEffect());
    }



    private void initialiseNodes() {
        ImageView imageView = new ImageView(new Image("/cityhall.jpg"));



    }


}
