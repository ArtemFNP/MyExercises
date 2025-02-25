package be.kdg.cityhall.view;

import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.SepiaTone;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class CityHallPane extends VBox {
    private static final Image IMAGE = new Image("/cityhall.jpg");

    private ImageView imageView;
    private RadioButton normal;
    private RadioButton blackAndWhite;
    private RadioButton sepia;


public CityHallPane() {
    // Initialize the ImageView
    imageView = new ImageView(IMAGE);
        imageView.setPreserveRatio(true);
        imageView.setFitWidth(600); // Adjust size as needed

 normal = new RadioButton("Normal");
 blackAndWhite = new RadioButton("Black and White");
 sepia = new RadioButton("Sepia");

ToggleGroup group = new ToggleGroup();
    normal.setToggleGroup(group);
    blackAndWhite.setToggleGroup(group);
    sepia.setToggleGroup(group);

    normal.setSelected(true);

        this.getChildren().addAll(imageView, normal, blackAndWhite, sepia);
}
    void resetEffect() {
        this.imageView.setEffect(null);
    }

    void applyBlackAndWhiteEffect() {
        ColorAdjust blackAndWhite = new ColorAdjust();
        blackAndWhite.setSaturation(-1.0);
        this.imageView.setEffect(blackAndWhite);
    }

    public RadioButton getNormal() {
        return normal;
    }

    public RadioButton getBlackAndWhite() {
        return blackAndWhite;
    }

    public RadioButton getSepia() {
        return sepia;
    }

    void applySepiaEffect() {
        SepiaTone sepiaTone = new SepiaTone();
        sepiaTone.setLevel(0.8);
        this.imageView.setEffect(sepiaTone);




    }
}
