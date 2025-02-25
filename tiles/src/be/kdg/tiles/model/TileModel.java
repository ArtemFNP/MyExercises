package be.kdg.tiles.model;

public class TileModel {
    public static final int COLUMNS = 4;
    public static final int ROWS = 3;

    private int selectedTileColumn;
    private int selectedTileRow;

    // 🔹 Add these two new variables:
    private int currentHoverColumn;
    private int currentHoverRow;

    public TileModel() {
        this.selectedTileColumn = -1;
        this.selectedTileRow = -1;
    }

    public void setSelectedTile(int column, int row) {
        if (this.selectedTileColumn == column && this.selectedTileRow == row) {
            this.selectedTileColumn = -1; // Deselect
            this.selectedTileRow = -1;
        } else {
            this.selectedTileColumn = column;
            this.selectedTileRow = row;
        }
    }


    public int getSelectedTileColumn() {
        return this.selectedTileColumn;
    }

    public int getSelectedTileRow() {
        return this.selectedTileRow;
    }

    // 🔹 New Methods for Hovered Tile:
    public void setCurrentHoverColumn(int column) {
        this.currentHoverColumn = column;
    }

    public void setCurrentHoverRow(int row) {
        this.currentHoverRow = row;
    }

    public int getCurrentHoverColumn() {
        return this.currentHoverColumn;
    }

    public int getCurrentHoverRow() {
        return this.currentHoverRow;
    }

}
