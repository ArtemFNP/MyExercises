package be.kdg.tiles.view;

import be.kdg.tiles.model.TileModel;

public class Presenter {
    private final TileModel model;
    private final TileView view;

    public Presenter(TileModel model, TileView view) {
        this.model = model;
        this.view = view;
        addEventHandlers();
        updateView();
    }

    private void addEventHandlers() {
        view.getCanvas().setOnMouseMoved(event -> {
            int column = view.translateXToColumn(event.getX());
            int row = view.translateYToRow(event.getY());

            model.setCurrentHoverColumn(column);
            model.setCurrentHoverRow(row);

            updateView();
        });

        view.getCanvas().setOnMouseClicked(event -> {
            int column = view.translateXToColumn(event.getX());
            int row = view.translateYToRow(event.getY());

            if (model.getSelectedTileColumn() == column && model.getSelectedTileRow() == row) {
                model.setSelectedTile(-1, -1); // 🔹 Correct deselection
            } else {
                model.setSelectedTile(column, row); // 🔹 Correct selection
            }

            updateView();
        });

        view.getCanvas().setOnMouseExited(event -> {
            model.setCurrentHoverColumn(-1);
            model.setCurrentHoverRow(-1);
            updateView();
        });
    }

    private void updateView() {
        view.displayCurrentTiles(
                model.getCurrentHoverColumn(),
                model.getCurrentHoverRow(),
                model.getSelectedTileColumn(),
                model.getSelectedTileRow()
        );
    }

}
