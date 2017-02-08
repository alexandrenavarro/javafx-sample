package com.github.alexandrenavarro.javafxsample;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import org.springframework.stereotype.Component;

/**
 * Created by anavarro on 08/02/17.
 */
@Component
public class CurrencyController {

    private final TableView view;

    public CurrencyController() {
        view = new TableView();
        final TableColumn firstNameCol = new TableColumn("Currency");
        final ObservableList<String> data =
                FXCollections.observableArrayList(
                        "EUR",
                        "USD"
                );

        view.getColumns().addAll(firstNameCol);
        view.setItems(data);
    }

    public TableView<String> getView() {
        return view;
    }


}
