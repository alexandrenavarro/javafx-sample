package com.github.alexandrenavarro.javafxsample;

import javafx.scene.Node;
import org.tbee.javafx.scene.layout.MigPane;

/**
 * Created by anavarro on 29/12/16.
 */
public interface AddVisualMigPaneBuilder {
    AddVisualMigPaneBuilder add(Node node);
    RowCstrVisualMigPaneBuilder layoutCstr(String aLayoutCstr);
    ColumnCstrVisualMigPaneBuilder rowCstr(String aRowCstr);
    AddCtrlRowVisualMigPaneBuilder columnCstr(String aColCstr);
}
