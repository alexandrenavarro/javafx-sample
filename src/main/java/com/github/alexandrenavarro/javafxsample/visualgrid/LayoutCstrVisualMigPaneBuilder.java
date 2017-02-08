package com.github.alexandrenavarro.javafxsample.visualgrid;

/**
 * Created by anavarro on 29/12/16.
 */
public interface LayoutCstrVisualMigPaneBuilder {
    VisualMigPaneBuilder rowCstr(String aRowConstraints);
    VisualMigPaneBuilder columnCstr(final String aColumnConstraints);
    VisualMigPaneBuilder addCtrlRow(String aCtrlRow);
    VisualMigPaneBuilder addCtrlRow(String aCtrlRow, String specificRowConstraints);
}
