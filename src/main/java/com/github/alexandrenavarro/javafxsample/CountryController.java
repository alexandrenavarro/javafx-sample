package com.github.alexandrenavarro.javafxsample;

import com.google.common.collect.Lists;
import feign.FeignException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by anavarro on 08/02/17.
 */
@Component
@Slf4j
public class CountryController {

    private final CountryResource countryResource;
    private final TableView view;

    @Autowired
    public CountryController(CountryResource countryResource) {
        this.countryResource = countryResource;
        view = new TableView();

        final TableColumn nameCol = new TableColumn("name");
        final TableColumn alpha2CodeCol = new TableColumn("alpha2Code");
        final TableColumn alpha3CodeCol = new TableColumn("alpha3Code");


        nameCol.setCellValueFactory(
                new PropertyValueFactory<>("name"));
        alpha2CodeCol.setCellValueFactory(
                new PropertyValueFactory<>("alpha2Code"));
        alpha3CodeCol.setCellValueFactory(
                new PropertyValueFactory<>("alpha3Code"));


        view.getColumns().addAll(nameCol, alpha2CodeCol, alpha3CodeCol);
        List<Country> countryList = new ArrayList<>();
        try {
            countryList
                    =
//                Lists.newArrayList(
//                        Country.builder().name("Name").alpha2Code("alpha2code").alpha3Code("alpha3Code").build(),
//                        Country.builder().name("Name2").alpha2Code("alpha2code2").alpha3Code("alpha3Code2").build());


                    countryResource.findCountries();
        } catch (FeignException e) {
            log.warn("e:{}", e);
        }
        final ObservableList<Country> data =
                FXCollections.observableArrayList(countryList);

        view.setItems(data);

    }


    public TableView<String> getView() {
        return view;
    }
}
