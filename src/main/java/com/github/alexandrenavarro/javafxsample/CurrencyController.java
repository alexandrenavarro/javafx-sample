package com.github.alexandrenavarro.javafxsample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.ListView;
import javafx.scene.control.ListViewBuilder;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import org.springframework.stereotype.Component;

/**
 * Created by anavarro on 08/02/17.
 */
@Component
public class CurrencyController {

    private final ListView<String> listView;

    public CurrencyController() {
        listView = new ListView<>();
        final ObservableList<String> data =
                FXCollections.observableArrayList(
                        "EUR",
                        "USD"
                );

        listView.setItems(data);
    }

    public Node getView() {
        return listView;
    }

}
