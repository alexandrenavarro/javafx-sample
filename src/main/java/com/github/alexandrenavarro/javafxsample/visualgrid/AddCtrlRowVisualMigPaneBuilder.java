package com.github.alexandrenavarro.javafxsample.visualgrid;

import org.tbee.javafx.scene.layout.MigPane;

/**
 * Created by anavarro on 29/12/16.
 */
public interface AddCtrlRowVisualMigPaneBuilder {
    VisualMigPaneBuilder addCtrlRow(String aCtrlRow);
    VisualMigPaneBuilder addCtrlRow(String aCtrlRow, String specificRowConstraints);
    MigPane build();
}
