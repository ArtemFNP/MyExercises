package be.kdg.time.view;

import be.kdg.time.model.TimeModel;

import java.time.LocalTime;

public class Presenter {
    private final TimeModel model;
    private final TimeView view;

    public Presenter(TimeModel model, TimeView view) {
        this.model = model;
        this.view = view;
        addEventHandlers();
        updateView();
    }

    private void addEventHandlers() {
        view.getSlider().setOnMouseDragged(event -> {
            double sliderValue = view.getSlider().getValue();
            int hours = (int) sliderValue;
            int minutes = (int) ((sliderValue - hours) * 60);

            model.setCurrentTime(LocalTime.of(hours, minutes));
            updateView();
        });
    }

    private void updateView() {
        view.applyDaylightSun(
                model.getDaylightPercentage(),
                model.getSunHeight(),
                model.getSunPositionX()
        );

        LocalTime currentTime = model.getCurrentTime();
        double sliderValue = currentTime.getHour() + (currentTime.getMinute() / 60.0);
        view.getSlider().setValue(sliderValue);
    }



}
