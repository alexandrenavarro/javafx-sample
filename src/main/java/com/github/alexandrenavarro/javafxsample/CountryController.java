package com.github.alexandrenavarro.javafxsample;

import feign.FeignException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import lombok.extern.slf4j.Slf4j;
import org.controlsfx.tools.Borders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tbee.javafx.scene.layout.MigPane;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anavarro on 08/02/17.
 */
@Component
@Slf4j
public class CountryController {

    private final CountryResource countryResource;

    private final TableView tableView;
    private final Node view;

    @Autowired
    public CountryController(final CountryResource countryResource) {
        this.countryResource = countryResource;

        List<Country> countryList = new ArrayList<>();
        try {
            countryList = countryResource.findCountries();
        } catch (FeignException e) {
            log.warn("e:{}", e);
        }

        this.tableView = TableViewBuilder.create()
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
                .items(FXCollections.observableArrayList(countryList))
                .build();

        this.view = Borders.wrap(
                TitledPaneBuilder.create()
                        .text("Country")
                        .collapsible(false)
                        .content(this.tableView)
                        .maxHeight(Double.MAX_VALUE)
                        .build()).emptyBorder().padding(10).build().build();
    }

    public Node getView() {
        return view;
    }

}
