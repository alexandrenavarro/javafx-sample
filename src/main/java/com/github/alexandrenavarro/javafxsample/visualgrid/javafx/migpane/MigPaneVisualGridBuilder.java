package com.github.alexandrenavarro.javafxsample.visualgrid.javafx.migpane;

import com.github.alexandrenavarro.javafxsample.visualgrid.*;
import javafx.scene.Node;
import lombok.extern.slf4j.Slf4j;
import org.tbee.javafx.scene.layout.MigPane;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by anavarro on 20/02/17.
 */
@Slf4j
public class MigPaneVisualGridBuilder implements VisualGridBuilder<Node, MigPane> {

    private final Map<String, Node> nodeMap = new HashMap<>();

    public static AddVisualGridBuilder<Node, MigPane> create() {
        return new MigPaneVisualGridBuilder();
    }


    protected final List<String> ctrlRowList = new ArrayList<String>();
    protected final List<String> specificRowCstrList = new ArrayList<>();
    protected String layoutCstr = "";
    protected String columnCstr = "";
    protected String rowCstr = "";

    public LayoutCstrVisualGridBuilder<MigPane> layoutCstr(final String aLayoutCstr) {
        if (aLayoutCstr != null) {
            this.layoutCstr = aLayoutCstr;
        }
        return this;
    }

    public RowCstrVisualGridBuilder<MigPane> rowCstr(final String aRowCstr) {
        if (aRowCstr != null) {
            this.rowCstr = aRowCstr;
        }
        return this;
    }

    public AddCtrlRowVisualGridBuilder<MigPane> columnCstr(final String aColumnCstr) {
        if (aColumnCstr != null) {
            this.columnCstr = aColumnCstr;
        }
        return this;
    }

    public AddCtrlRowVisualGridBuilder<MigPane> addCtrlRow(final String aCtrlRow) {
        return addCtrlRow(aCtrlRow, "");
    }

    public AddCtrlRowVisualGridBuilder<MigPane> addCtrlRow(final String aCtrlRow, final String specificRowCstr) {
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
    public AddVisualGridBuilder<Node, MigPane> add(final Node node) {
        if (node != null && node.getId() != null) {
            this.nodeMap.put(node.getId(), node);
        } else {
            throw new IllegalArgumentException("node and node.id must not be null, node:" + node);
        }
        return this;
    }

    @Override
    public MigPane build() {
        final MigPane migPane = new MigPane(this.layoutCstr, this.columnCstr, this.rowCstr);
        for (final String row : this.ctrlRowList) {
            final String[] components = row.split(" +");
            for (int i = 0; i < components.length; i++) {
                final StringBuilder constraint = new StringBuilder();

                final Node node = this.nodeMap.get(components[i]);
                if (node != null) {
                    if ((i == components.length - 1)) {
                        constraint.append("wrap ");
                    }
                    migPane.add(node, constraint.toString());
                } else {
                    log.warn("component:{} not found.", components[i]);
                }
            }
        }
        return migPane;
    }


}
