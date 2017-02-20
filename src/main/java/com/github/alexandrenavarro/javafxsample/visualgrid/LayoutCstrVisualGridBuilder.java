package com.github.alexandrenavarro.javafxsample.visualgrid;

/**
 * Created by anavarro on 20/02/17.
 */
public interface LayoutCstrVisualGridBuilder<L> extends RowCstrVisualGridBuilder<L> {

    public RowCstrVisualGridBuilder<L> layoutCstr(final String alayoutCstr);
}
