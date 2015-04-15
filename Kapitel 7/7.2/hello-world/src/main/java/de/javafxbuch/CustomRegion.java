
package de.javafxbuch;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.BooleanPropertyBase;
import javafx.css.PseudoClass;
import javafx.scene.layout.Region;

public class CustomRegion extends Region {

    private static final PseudoClass ACTIVE
            = PseudoClass.getPseudoClass("active");

    private BooleanProperty active;

    public final boolean isActive() {
        return null == active ? false : active.get();
    }

    public final void setActive(final boolean active) {
        activeProperty().set(active);
    }

    public final BooleanProperty activeProperty() {
        if (null == active) {
            active = new BooleanPropertyBase() {
                @Override
                protected void invalidated() {
                    pseudoClassStateChanged(ACTIVE, get());
                }

                @Override
                public Object getBean() {
                    return this;
                }

                @Override
                public String getName() {
                    return "active";
                }
            };
        }
        return active;
    }
}