package com.github.alexandrenavarro.javafxsample.visualgrid.javafx.gridpane;

import com.github.alexandrenavarro.javafxsample.visualgrid.*;
import com.github.alexandrenavarro.javafxsample.visualgrid.javafx.migpane.MigPaneVisualGridBuilder;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import lombok.extern.slf4j.Slf4j;
import org.tbee.javafx.scene.layout.MigPane;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by anavarro on 21/02/17.
 */
@Slf4j
public class GridPaneVisualGridBuilder implements VisualGridBuilder<Node, GridPane> {

    private final Map<String, Node> nodeMap = new HashMap<>();

    public static AddVisualGridBuilder<Node, GridPane> create() {
        return new GridPaneVisualGridBuilder();
    }


    protected final List<String> ctrlRowList = new ArrayList<String>();
    protected final List<String> specificRowCstrList = new ArrayList<>();
    protected String layoutCstr = "";
    protected String columnCstr = "";
    protected String rowCstr = "";

    public LayoutCstrVisualGridBuilder<GridPane> layoutCstr(final String aLayoutCstr) {
        if (aLayoutCstr != null) {
            this.layoutCstr = aLayoutCstr;
        }
        return this;
    }

    public RowCstrVisualGridBuilder<GridPane> rowCstr(final String aRowCstr) {
        if (aRowCstr != null) {
            this.rowCstr = aRowCstr;
        }
        return this;
    }

    public AddCtrlRowVisualGridBuilder<GridPane> columnCstr(final String aColumnCstr) {
        if (aColumnCstr != null) {
            this.columnCstr = aColumnCstr;
        }
        return this;
    }

    public AddCtrlRowVisualGridBuilder<GridPane> addCtrlRow(final String aCtrlRow) {
        return addCtrlRow(aCtrlRow, "");
    }

    public AddCtrlRowVisualGridBuilder<GridPane> addCtrlRow(final String aCtrlRow, final String specificRowCstr) {
        if (aCtrlRow != null) {
            ctrlRowList.add(aCtrlRow);
            if (specificRowCstr != null) {
                specificRowCstrList.add(specificRowCstr);
            } else {
                specificRowCstrList.add("");
            }
        } else {
            throw new IllegalArgumentException("ctrlRow must not be null");
        }
        return this;
    }


    @Override
    public AddVisualGridBuilder<Node, GridPane> add(final Node node) {
        if (node != null && node.getId() != null) {
            this.nodeMap.put(node.getId(), node);
        } else {
            throw new IllegalArgumentException("node and node.id must not be null, node:" + node);
        }
        return this;
    }

    @Override
    public GridPane build() {
        final GridPane gridPane = new GridPane();
        for (int i = 0; i < this.ctrlRowList.size(); i++) {
            final String row = this.ctrlRowList.get(i);
            final String[] components = row.split(" +");
            for (int j = 0; j < components.length; j++) {
                final StringBuilder constraint = new StringBuilder();

                final Node node = this.nodeMap.get(components[j]);
                if (node != null) {
                    gridPane.add(node, j, i);
                } else {
                    log.warn("component:{} not found.", components[i]);
                }
            }
        }
        return gridPane;
    }


}

