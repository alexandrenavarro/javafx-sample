package com.github.alexandrenavarro.javafxsample;

import javafx.scene.Node;
import lombok.extern.slf4j.Slf4j;
import org.tbee.javafx.scene.layout.MigPane;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by anavarro on 29/12/16.
 */
@Slf4j
public class VisualMigPaneBuilder implements AddVisualMigPaneBuilder, LayoutCstrVisualMigPaneBuilder, RowCstrVisualMigPaneBuilder, ColumnCstrVisualMigPaneBuilder,  AddCtrlRowVisualMigPaneBuilder {

    //TODO add 3 interfaces,
    // - add, layoutCstr, rowCstr
    // - columnCstr
    // - addCtrlRow

    // - addCellCstr

    private final Map<String, Node> nodeMap = new HashMap<>();
    private String layoutConstraints = "";
    private String columnConstraints = "";
    private String rowConstraints = "";
    private final List<String> ctrlRowList = new ArrayList<>();
    private final List<String> specificRowConstraintList = new ArrayList<>();


    public static AddVisualMigPaneBuilder create() {
        return new VisualMigPaneBuilder();
    }

    @Override
    public AddVisualMigPaneBuilder add(final Node node) {
        if (node != null && node.getId() != null) {
            nodeMap.put(node.getId(), node);
        } else {
            throw new IllegalArgumentException("node and node.id must not be null");
        }
        return this;
    }

    @Override
    public RowCstrVisualMigPaneBuilder layoutCstr(final String aLayoutCstr) {
        this.layoutConstraints = aLayoutCstr;
        return this;
    }

    @Override
    public VisualMigPaneBuilder rowCstr(final String aRowCstr) {
        this.rowConstraints = aRowCstr;
        return this;
    }

    public VisualMigPaneBuilder columnCstr(final String aColCstr) {
        this.columnConstraints = aColCstr;
        return this;
    }



    @Override
    public VisualMigPaneBuilder addCtrlRow(final String aCtrlRow) {
        return addCtrlRow(aCtrlRow, "");
    }

    @Override
    public VisualMigPaneBuilder addCtrlRow(final String aCtrlRow, final String specificRowCstr) {
        ctrlRowList.add(aCtrlRow);
        specificRowConstraintList.add(specificRowCstr);
        return this;
    }


    @Override
    public MigPane build() {
        final MigPane migPane = new MigPane(layoutConstraints, columnConstraints, rowConstraints);
        for (final String row : ctrlRowList) {
            final String[] components = row.split(" +");
            for (int i = 0; i < components.length; i++) {
                final StringBuilder constraint = new StringBuilder();

                final Node node = nodeMap.get(components[i]);
                if (node != null) {
                    if ((i != components.length - 1)) {
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
