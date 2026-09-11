package it.unibo.risiko.view.map;

import javafx.geometry.Point2D;

/**
 * Converts between the logic grid of the map file and the pixels of the panel, that change
 * when the window is resized. Drawing and clicking use the same one so they always agree.
 *
 * @param scale how much it is enlarged, the same horizontally and vertically
 * @param offsetX pixels of margin on the left, to center the map
 * @param offsetY pixels of margin on top, to center the map
 */
record ViewTransform(double scale, double offsetX, double offsetY) {

    /**
     * calculates the transformation that makes the whole grid fit in the available space,
     * without deforming it and keeping it in the middle.
     *
     * @param width available width in pixels
     * @param height available height in pixels
     * @return the corresponding transformation
     */
    static ViewTransform of(final double width, final double height) {
        final double scale = Math.min(width / MapLayout.LOGIC_WIDTH, height / MapLayout.LOGIC_HEIGHT);
        return new ViewTransform(
                scale,
                (width - MapLayout.LOGIC_WIDTH * scale) / 2,
                (height - MapLayout.LOGIC_HEIGHT * scale) / 2);
    }

    /**
     * Tells if there is something to draw: before the panel is laid out its size is zero.
     *
     * @return true if there is space to draw
     */
    boolean usable() {
        return this.scale > 0;
    }

    /**
     * converts a logic x into pixels.
     *
     * @param logic the x on the grid
     * @return the x in pixels
     */
    double screenX(final double logic) {
        return this.offsetX + logic * this.scale;
    }

    /**
     * converts a logic y into pixels.
     *
     * @param logic the y on the grid
     * @return the y in pixels
     */
    double screenY(final double logic) {
        return this.offsetY + logic * this.scale;
    }

    /**
     * converts a logic length into pixels.
     *
     * @param logic the length on the grid
     * @return the length in pixels
     */
    double length(final double logic) {
        return logic * this.scale;
    }

    /**
     * From pixels to logic coordinates, the opposite of drawing: it is used to understand
     * where the user clicked.
     *
     * @param x the x in pixels
     * @param y the y in pixels
     * @return the corresponding point on the logic grid
     */
    Point2D toLogic(final double x, final double y) {
        return new Point2D((x - this.offsetX) / this.scale, (y - this.offsetY) / this.scale);
    }
}
