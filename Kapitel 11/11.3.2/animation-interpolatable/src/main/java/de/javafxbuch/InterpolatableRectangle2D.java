package de.javafxbuch;

import javafx.animation.Interpolatable;
import javafx.geometry.Rectangle2D;

public class InterpolatableRectangle2D extends Rectangle2D implements Interpolatable<InterpolatableRectangle2D> {

    public InterpolatableRectangle2D(double minX, double minY,
            double width, double height) {
        super(minX, minY, width, height);
    }

    @Override
    public InterpolatableRectangle2D interpolate(InterpolatableRectangle2D endValue, double t) {
        return new InterpolatableRectangle2D(
                getMinX() + t * (endValue.getMinX() - getMinX()), getMinY() + t * (endValue.getMinY() - getMinY()), getWidth() + t * (endValue.getWidth() - getWidth()), getHeight() + t * (endValue.getHeight() - getHeight())
        );
    }
}
