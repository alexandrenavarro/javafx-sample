package com.github.alexandrenavarro.javafxsample.visualgrid;

/**
 * Created by anavarro on 29/12/16.
 */
public interface RowCstrVisualGridBuilder<L> extends ColumnCstrVisualGridBuilder<L> {

    ColumnCstrVisualGridBuilder<L> rowCstr(final String aRowCstr);

}
