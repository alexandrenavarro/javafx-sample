package com.github.alexandrenavarro.javafxsample.visualgrid;

import javafx.scene.Node;

/**
 * Created by anavarro on 20/02/17.
 */
public interface AddVisualGridBuilder<C, L> extends LayoutCstrVisualGridBuilder<L> {

    public AddVisualGridBuilder<C, L> add(final C component);
}
