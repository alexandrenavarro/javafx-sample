package com.github.alexandrenavarro.javafxsample;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.scene.control.TreeItem;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by anavarro on 19/02/17.
 */
@Component
public class CustomTreeTableController {

    private CustomTreeTableView customTreeTableView;

    public CustomTreeTableController(CustomTreeTableView customTreeTableView) {
        this.customTreeTableView = customTreeTableView;
    }

    @PostConstruct
    public void initialize() {
        //Create an ObjectMapper instance
        ObjectMapper mapper = new ObjectMapper();
        final String jsonString = "{\"name\":\"Mahesh Kumar\", \"age\":21,\"verified\":false,\"marks\": [100,90,85], \"child\":{\"name\":\"Mahesh Kumar\", \"age\":21,\"verified\":false,\"marks\": [100,90,85]}}";

        //create tree from JSON
        try {
            final JsonNode jsonNade = mapper.readTree(jsonString);
            final TreeItem<NameValue> root = new TreeItem<>(new NameValue("Name", "Value"));

            addChildren(jsonNade, root);
            customTreeTableView.getView().setRoot(root);

            // name type value

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void addChildren(JsonNode jsonNode, TreeItem<NameValue> root) {
        Iterator<Map.Entry<String, JsonNode>> fields = jsonNode.fields();
        while (fields.hasNext()) {
            final Map.Entry<String, JsonNode> next = fields.next();
            if (!next.getValue().isContainerNode()) {
                root.getChildren().add(new TreeItem<>(new NameValue(next.getKey(), next.getValue().toString())));
            } else {
                final TreeItem<NameValue> child = new TreeItem<>(new NameValue(next.getKey(), ""));
                root.getChildren().add(child);
                addChildren(next.getValue(), child);
            }
        }
    }


}
