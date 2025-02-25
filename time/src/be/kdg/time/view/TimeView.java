package be.kdg.time.view;

import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;

public class TimeView extends BorderPane {
    private Canvas canvas;
    private Slider slider;

    private static final double CANVAS_WIDTH = 800.0;
    private static final double CANVAS_HEIGHT = 600.0;

    private static final Image SUN_IMAGE = new Image("/sun.png");
    private static final double MIN_Y_SUN = 100.0; // Min. Y of the Sun is actually the highest point in the sky because screen coordinates are reversed.
    private static final double MAX_Y_SUN = CANVAS_HEIGHT; // Max. Y of the Sun is actually the lowest point in the sky because screen coordinates are reversed.
    private static final double MIN_X_SUN = 0.0;
    private static final double MAX_X_SUN = CANVAS_WIDTH - SUN_IMAGE.getWidth();

    private static final Color NOON_COLOR = Color.rgb(58, 192, 230);
    private static final Color NIGHT_COLOR = Color.rgb(0, 0, 32);

    public TimeView() {
        this.initialiseNodes();
        this.layoutNodes();
    }


    private static final Image BACKGROUND_IMAGE = new Image(
            TimeView.class.getResource("/mijnphoto.jpeg").toExternalForm());

    private void initialiseNodes() {

        this.canvas = new Canvas(CANVAS_WIDTH, CANVAS_HEIGHT);
        this.slider = new Slider(5.0, 20.0, 0.1);
        this.slider.setShowTickLabels(false);

    }

    private void layoutNodes() {
        this.setCenter(this.canvas);

        BorderPane.setMargin(this.slider, new Insets(10.0));
        this.slider.setMaxWidth(Double.MAX_VALUE);
        this.setBottom(this.slider);
    }

    Slider getSlider() {
        return this.slider;
    }

    void applyDaylightSun(double daylightPercentage, double sunHeight, double sunPositionX) {
        final GraphicsContext gc = this.canvas.getGraphicsContext2D();

        // Draw background image first
        gc.drawImage(BACKGROUND_IMAGE, 0, 0, CANVAS_WIDTH, CANVAS_HEIGHT);

        // Sun's position
        final double sunX = MIN_X_SUN + (MAX_X_SUN - MIN_X_SUN) / 2.0 - sunPositionX * (MAX_X_SUN - MIN_X_SUN) / 2.0;
        final double sunY = MAX_Y_SUN - (MAX_Y_SUN - MIN_Y_SUN) * sunHeight;

        // Draw the sun
        gc.drawImage(SUN_IMAGE, sunX, sunY);
    }



    private  Color getSkyColor(double daylightPercentage) {
        return Color.color(
          NIGHT_COLOR.getRed() +
            ((NOON_COLOR.getRed() - NIGHT_COLOR.getRed()) * daylightPercentage),
          NIGHT_COLOR.getGreen() +
            ((NOON_COLOR.getGreen() - NIGHT_COLOR.getGreen()) * daylightPercentage),
          NIGHT_COLOR.getBlue() +
            ((NOON_COLOR.getBlue() - NIGHT_COLOR.getBlue()) * daylightPercentage)
        );
    }
}
