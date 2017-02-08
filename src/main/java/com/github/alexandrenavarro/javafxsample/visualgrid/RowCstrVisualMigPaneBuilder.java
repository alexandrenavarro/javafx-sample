package com.github.alexandrenavarro.javafxsample.visualgrid;

/**
 * Created by anavarro on 29/12/16.
 */
public interface RowCstrVisualMigPaneBuilder {
    VisualMigPaneBuilder columnCstr(final String aColumnCstr);
    VisualMigPaneBuilder addCtrlRow(String aCtrlRow);
    VisualMigPaneBuilder addCtrlRow(String aCtrlRow, String specificRowCstr);

}
