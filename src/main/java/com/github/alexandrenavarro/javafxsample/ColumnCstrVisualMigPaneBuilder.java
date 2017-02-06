package com.github.alexandrenavarro.javafxsample;

/**
 * Created by anavarro on 29/12/16.
 */
public interface ColumnCstrVisualMigPaneBuilder {
    VisualMigPaneBuilder addCtrlRow(String aCtrlRow);
    VisualMigPaneBuilder addCtrlRow(String aCtrlRow, String specificRowConstraints);
}
