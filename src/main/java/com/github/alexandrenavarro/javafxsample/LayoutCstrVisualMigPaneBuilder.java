package com.github.alexandrenavarro.javafxsample;

import javafx.scene.Node;
import org.tbee.javafx.scene.layout.MigPane;

/**
 * Created by anavarro on 29/12/16.
 */
public interface LayoutCstrVisualMigPaneBuilder {
    VisualMigPaneBuilder rowCstr(String aRowConstraints);
    VisualMigPaneBuilder columnCstr(final String aColumnConstraints);
    VisualMigPaneBuilder addCtrlRow(String aCtrlRow);
    VisualMigPaneBuilder addCtrlRow(String aCtrlRow, String specificRowConstraints);
}
