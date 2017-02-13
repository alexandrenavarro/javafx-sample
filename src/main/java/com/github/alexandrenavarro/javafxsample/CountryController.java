package com.github.alexandrenavarro.javafxsample;

import feign.FeignException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

    @Autowired
    public CountryController(final CountryResource countryResource) {
        this.countryResource = countryResource;
        this.tableView = new TableView();


        // Init
        final TableColumn nameCol = new TableColumn("name");
        final TableColumn alpha2CodeCol = new TableColumn("alpha2Code");
        final TableColumn alpha3CodeCol = new TableColumn("alpha3Code");


        nameCol.setCellValueFactory(
                new PropertyValueFactory<>("name"));
        alpha2CodeCol.setCellValueFactory(
                new PropertyValueFactory<>("alpha2Code"));
        alpha3CodeCol.setCellValueFactory(
                new PropertyValueFactory<>("alpha3Code"));


        tableView.getColumns().addAll(nameCol, alpha2CodeCol, alpha3CodeCol);
        List<Country> countryList = new ArrayList<>();
        try {
            countryList = countryResource.findCountries();
        } catch (FeignException e) {
            log.warn("e:{}", e);
        }
        final ObservableList<Country> data =
                FXCollections.observableArrayList(countryList);

        tableView.setItems(data);
        tableView.autosize();

    }

    public Node getView() {
        return tableView;
    }

}
