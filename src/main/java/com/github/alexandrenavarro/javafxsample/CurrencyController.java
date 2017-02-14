package com.github.alexandrenavarro.javafxsample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.paint.Color;
import org.controlsfx.tools.Borders;
import org.springframework.stereotype.Component;


import static java.awt.Color.*;

/**
 * Created by anavarro on 08/02/17.
 */
@Component
public class CurrencyController {

    private final Node view;

    public CurrencyController() {
        view = Borders.wrap(
                TitledPaneBuilder.create()
                        .text("Currency")
                        .content(ListViewBuilder.create()
                                .items(
                                        FXCollections.observableArrayList(
                                                "EUR",
                                                "USD")).build())
                        .maxHeight(Integer.MAX_VALUE)
                        .collapsible(false)
                        .build())
                .emptyBorder()
                .padding(10).build().build();
    }

    public Node getView() {
        return view;
    }

}
