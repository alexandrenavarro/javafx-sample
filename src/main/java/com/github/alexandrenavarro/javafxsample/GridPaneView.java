package com.github.alexandrenavarro.javafxsample;

import javafx.scene.Node;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.GridPaneBuilder;
import org.springframework.stereotype.Component;

/**
 * Created by anavarro on 19/02/17.
 */
@Component
public class GridPaneView  {

    private GridPane gridPane;

    public GridPaneView() {
        this.gridPane = new GridPane();

        final ColumnConstraints column1 = new ColumnConstraints(100,100,Double.MAX_VALUE);
        // rowConstraints
        // columnConstraints
        //final RowConstraints constraints = new RowConstraints();

        //[100:100:110,grow,fill,left|right|],
        //[100%]
        //(double minWidth, double prefWidth, double maxWidth, Priority hgrow, HPos halignment, boolean fillWidth) //


        // columnConstraints
        // addNodeRow

        // add
        // layoutCstr
        // rowCstr
        // columnCstr
        // addCtrlRow


        // all standart GridPane properties exect add
        // all non standart
        // add(Node)
        // columnCstr ("[] [] []")
        // addNodeRow ("xx xx xx"),("xx xx xx", "xxxxx"), ("xx xx xx", RowConstraints)



    }
}
