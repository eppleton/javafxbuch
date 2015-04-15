package de.javafxbuch;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.Region;

/**
 *
 * @author antonepple
 */
class CardStackLayout extends Region {

    @Override
    public ObservableList<Node> getChildren() {
        return super.getChildren();
    }

    @Override
    protected void layoutChildren() {
        super.layoutChildren();
        ObservableList<Node> children = getChildren();
        int i = 0;
        for (Node child : children) {
            if (child.isManaged()) {
                child.relocate(i, 0);
                i += 10;
            }
            else {
                
            }
        }
    }
}
