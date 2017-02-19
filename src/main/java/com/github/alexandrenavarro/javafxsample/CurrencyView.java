package com.github.alexandrenavarro.javafxsample;

import javafx.collections.FXCollections;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.control.ListViewBuilder;
import javafx.scene.control.TitledPaneBuilder;
import org.controlsfx.tools.Borders;
import org.springframework.stereotype.Component;

/**
 * Created by anavarro on 18/02/17.
 */
@Component
public class CurrencyView implements View {

    private final Node view;
    private final ListView listView;


    public CurrencyView() {
        this.listView = ListViewBuilder.create().build();
        this.view = Borders.wrap(
                TitledPaneBuilder.create()
                        .text("Currency")
                        .content(this.listView)
                        .maxHeight(Integer.MAX_VALUE)
                        .collapsible(false)
                        .build())
                .emptyBorder()
                .padding(10).build().build();
    }

    public Node getView() {
        return view;
    }

    public ListView getListView() {
        return listView;

    }

}
