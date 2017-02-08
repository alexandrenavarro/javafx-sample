package com.github.alexandrenavarro.javafxsample.visualgrid;

import javafx.scene.Node;

/**
 * Created by anavarro on 29/12/16.
 */
public interface AddVisualMigPaneBuilder {
    AddVisualMigPaneBuilder add(Node node);
    RowCstrVisualMigPaneBuilder layoutCstr(String aLayoutCstr);
    ColumnCstrVisualMigPaneBuilder rowCstr(String aRowCstr);
    AddCtrlRowVisualMigPaneBuilder columnCstr(String aColCstr);
}
