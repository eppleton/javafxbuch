package de.javafxbuch;

import javafx.animation.Transition;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class ViewportTransition extends Transition {

    private final ImageView imageView;
    private final Rectangle2D start;
    private final Rectangle2D end;

    public ViewportTransition(
            ImageView imageView,
            Rectangle2D start,
            Rectangle2D end,
            Duration duration) {
        this.imageView = imageView;
        this.start = start;
        this.end = end;
        setCycleDuration(duration);
    }

    @Override
    protected void interpolate(double t) {
        final Rectangle2D viewport = new Rectangle2D(start.getMinX()
                + t * (end.getMinX() - start.getMinX()), start.getMinY()
                + t * (end.getMinY() - start.getMinY()), start.getWidth()
                + t * (end.getWidth() - start.getWidth()), start.getHeight()
                + t * (end.getHeight() - start.getHeight()));
        imageView.setViewport(viewport);
    }
}
