package com.github.alexandrenavarro.javafxsample;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.layout.VBox;
import org.springframework.stereotype.Component;

/**
 * Created by anavarro on 19/02/17.
 */
@Component
public class CustomTreeTableView implements View {

    private final TreeTableView<NameValue> treeTableView;

    public CustomTreeTableView() {
        this.treeTableView = new TreeTableView();
        final TreeTableColumn<NameValue, String> nameColumn =
                new TreeTableColumn<>("Name");
        nameColumn.setPrefWidth(150);
        nameColumn.setCellValueFactory(
                (TreeTableColumn.CellDataFeatures<NameValue, String> param) ->
                        new ReadOnlyStringWrapper(param.getValue().getValue().getName())
        );

        final TreeTableColumn<NameValue, String> valueColumn =
                new TreeTableColumn<>("Value");
        valueColumn.setPrefWidth(150);
        valueColumn.setCellValueFactory(
                (TreeTableColumn.CellDataFeatures<NameValue, String> param) ->
                        new ReadOnlyStringWrapper(param.getValue().getValue().getValue())
        );

        treeTableView.getColumns().setAll(nameColumn, valueColumn);
    }

    @Override
    public TreeTableView<NameValue> getView() {
        return treeTableView;
    }
}
