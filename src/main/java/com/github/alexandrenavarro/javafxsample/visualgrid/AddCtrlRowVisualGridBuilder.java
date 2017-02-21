package com.github.alexandrenavarro.javafxsample.visualgrid;

import org.tbee.javafx.scene.layout.MigPane;

/**
 * Created by anavarro on 29/12/16.
 */
public interface AddCtrlRowVisualGridBuilder<L> extends BuildVisualGridBuilder<L> {

    AddCtrlRowVisualGridBuilder<L> addCtrlRow(final String aCtrlRow);
    AddCtrlRowVisualGridBuilder<L> addCtrlRow(final String aCtrlRow, final String specificRowCstr);

}
