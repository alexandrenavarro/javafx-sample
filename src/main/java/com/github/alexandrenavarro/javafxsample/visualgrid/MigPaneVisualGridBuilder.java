package com.github.alexandrenavarro.javafxsample.visualgrid;

import javafx.scene.Node;
import javafx.scene.control.ButtonBuilder;
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
    private String layoutCstr = "";
    private String columnCstr = "";
    private String rowCstr = "";
    private final List<String> ctrlRowList = new ArrayList<>();
    private final List<String> specificRowCstrList = new ArrayList<>();

    public static AddVisualGridBuilder<Node, MigPane> create() {
        return new MigPaneVisualGridBuilder();
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
    public LayoutCstrVisualGridBuilder layoutCstr(final String aLayoutCstr) {
        if (aLayoutCstr != null) {
            this.layoutCstr = aLayoutCstr;
        }
        return this;
    }

    @Override
    public RowCstrVisualGridBuilder rowCstr(final String aRowCstr) {
        if (aRowCstr != null) {
            this.rowCstr = aRowCstr;
        }
        return this;
    }


    @Override
    public AddCtrlRowVisualGridBuilder<MigPane> columnCstr(final String aColumnCstr) {
        if (aColumnCstr != null) {
            this.columnCstr = aColumnCstr;
        }
        return this;
    }

    @Override
    public AddCtrlRowVisualGridBuilder addCtrlRow(final String aCtrlRow) {
        return addCtrlRow(aCtrlRow, "");
    }

    @Override
    public AddCtrlRowVisualGridBuilder addCtrlRow(final String aCtrlRow, final String specificRowCstr) {
        ctrlRowList.add(aCtrlRow);
        specificRowCstrList.add(specificRowCstr);
        return this;
    }

    @Override
    public MigPane build() {
        final MigPane migPane = new MigPane(layoutCstr, columnCstr, rowCstr);
        for (final String row : ctrlRowList) {
            final String[] components = row.split(" +");
            for (int i = 0; i < components.length; i++) {
                final StringBuilder constraint = new StringBuilder();

                final Node node = nodeMap.get(components[i]);
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
