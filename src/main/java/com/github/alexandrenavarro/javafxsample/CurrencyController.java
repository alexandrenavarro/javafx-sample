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


import javax.annotation.PostConstruct;
import javax.inject.Inject;

import static java.awt.Color.*;

/**
 * Created by anavarro on 08/02/17.
 */
@Component
public class CurrencyController {

    private final CurrencyView currencyView;

    @Inject
    public CurrencyController(final CurrencyView currencyView) {
        this.currencyView = currencyView;
    }

    @PostConstruct
    public void initialize() {
        this.currencyView.getListView().setItems(FXCollections.observableArrayList("EUR", "USD", "YEN"));
    }


}
