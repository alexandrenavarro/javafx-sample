package com.github.alexandrenavarro.javafxsample;

import javafx.scene.Node;
import javafx.scene.control.*;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPaneBuilder;
import javafx.scene.layout.VBoxBuilder;
import org.controlsfx.control.MaskerPane;
import org.controlsfx.tools.Borders;
import org.springframework.stereotype.Component;

/**
 * Created by anavarro on 18/02/17.
 */
@Component
public class CountryView implements View {

    private final TableView tableView;
    private final MaskerPane maskerPane;
    private final Button button;
    private final Node view;

    public CountryView() {

        maskerPane = new MaskerPane();
        maskerPane.setVisible(false);
        button = ButtonBuilder.create()
                .text("Search").build();


        TableView t = new TableView();
        tableView = TableViewBuilder.create()
                .columns(
                        TableColumnBuilder.create()
                                .text("name")
                                .cellValueFactory(new PropertyValueFactory<>("name")).build(),
                        TableColumnBuilder.create()
                                .text("alpha2Code")
                                .cellValueFactory(new PropertyValueFactory<>("alpha2Code")).build(),
                        TableColumnBuilder.create()
                                .text("alpha3Code")
                                .cellValueFactory(new PropertyValueFactory<>("alpha3Code")).build())
                //            .items(FXCollections.observableArrayList(countryList))

                .build();

        this.view = Borders.wrap(
                TitledPaneBuilder.create()
                        .text("Country")
                        .collapsible(false)
                        .content(VBoxBuilder.create()
                                .children(button,
                                        StackPaneBuilder.create()
                                                .children(tableView, maskerPane).build()

                                ).build())
                        .maxHeight(Double.MAX_VALUE)
                        .build()).emptyBorder().padding(10).build().build();

    }

    public Node getView() {
        return view;
    }

    public TableView getTableView() {
        return tableView;
    }

    public Button getButton() {
        return button;
    }

    public MaskerPane getMaskerPane() {
        return maskerPane;
    }
}
