package com.github.alexandrenavarro.javafxsample.visualgrid.javafx.migpane;

import com.github.alexandrenavarro.javafxsample.visualgrid.*;
import com.github.alexandrenavarro.javafxsample.visualgrid.core.AbstractVisualGridBuilder;
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
public class MigPaneVisualGridBuilder extends AbstractVisualGridBuilder<MigPane> implements VisualGridBuilder<Node, MigPane> {

    private final Map<String, Node> nodeMap = new HashMap<>();

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
