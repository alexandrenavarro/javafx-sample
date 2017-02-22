package com.github.alexandrenavarro.javafxsample.visualgrid.javafx.gridpane;

import com.github.alexandrenavarro.javafxsample.visualgrid.*;
import com.github.alexandrenavarro.javafxsample.visualgrid.core.AbstractVisualGridBuilder;
import com.github.alexandrenavarro.javafxsample.visualgrid.javafx.migpane.MigPaneVisualGridBuilder;
import javafx.geometry.HPos;
import javafx.scene.Node;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import lombok.extern.slf4j.Slf4j;
import net.miginfocom.layout.Grid;
import org.tbee.javafx.scene.layout.MigPane;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by anavarro on 21/02/17.
 */
@Slf4j
public class GridPaneVisualGridBuilder extends AbstractVisualGridBuilder<GridPane> implements VisualGridBuilder<Node, GridPane> {

    private final Map<String, Node> nodeMap = new HashMap<>();

    public static AddVisualGridBuilder<Node, GridPane> create() {
        return new GridPaneVisualGridBuilder();
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
        for (int y = 0; y < this.ctrlRowList.size(); y++) {
            final String row = this.ctrlRowList.get(y);
            final String[] components = row.split(" +");
            for (int x = 0; x < components.length; x++) {
                final StringBuilder constraint = new StringBuilder();
                final Node node = this.nodeMap.get(components[x]);
                if (node != null) {
                    gridPane.add(node, x, y);
                } else {
                    log.warn("component:{} not found.", components[y]);
                }
            }
        }

        // TODO manage row / column [right,100:100:10000,50%,grow,fill] [fill]
        // TODO manange cell constraints

        ColumnConstraints column1 = new ColumnConstraints(100,100,Double.MAX_VALUE);
        column1.setHgrow(Priority.ALWAYS);
        column1.setFillWidth(false);


        ColumnConstraints column2 = new ColumnConstraints(100);
        gridPane.getColumnConstraints().addAll(column1, column2); // first column gets any extra width
        //gridPane.getRowConstraints().addAll(rc, rc, rc);
        return gridPane;
    }


}

