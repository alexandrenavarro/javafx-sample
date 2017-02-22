package com.github.alexandrenavarro.javafxsample.visualgrid.demo;

import com.github.alexandrenavarro.javafxsample.visualgrid.javafx.gridpane.GridPaneVisualGridBuilder;
import com.github.alexandrenavarro.javafxsample.visualgrid.javafx.migpane.MigPaneVisualGridBuilder;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ButtonBuilder;
import javafx.scene.control.LabelBuilder;
import javafx.scene.control.TextFieldBuilder;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.tbee.javafx.scene.layout.MigPane;


/**
 * Created by anavarro on 25/12/16.
 */

public class JavaFxAppWithGridPaneVisualGridBuilder extends Application {

    @Override
    public void start(final Stage primaryStage) {

        // GridPane
        final GridPane gridPane = GridPaneVisualGridBuilder.create()
                .add(LabelBuilder.create()
                        .id("firstNameLabel")
                        .text("First Name").build())
                .add(TextFieldBuilder.create()
                        .id("firstNameTextField")
                        .text("").build())
                .add(LabelBuilder.create()
                        .id("lastNameLabel")
                        .text("Last Name").build())
                .add(TextFieldBuilder.create()
                        .id("lastNameTextField")
                        .text("").build())
                .add(ButtonBuilder.create()
                        .id("okButton")
                        .text("Ok")
                        .maxWidth(Double.MAX_VALUE)
                        .onAction(e -> System.out.println("Ok action")).build())
                .add(ButtonBuilder.create()
                        .id("cancelButton")
                        .maxWidth(Double.MAX_VALUE)
                        .text("Cancel").build())
                .columnCstr("[right]        [fill]            ")
                .addCtrlRow("firstNameLabel firstNameTextField")
                .addCtrlRow("lastNameLabel  lastNameTextField ")
                .addCtrlRow("okButton       cancelButton      ")
                .build();

        primaryStage.setScene(new Scene(gridPane, 600, 400));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
