package com.github.alexandrenavarro.javafxsample.visualgrid;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.tbee.javafx.scene.layout.MigPane;


/**
 * Created by anavarro on 25/12/16.
 */

public class JavaFxAppWithVisualMigPaneBuilder extends Application {

    @Override
    public void start(final Stage primaryStage) {

        // VisualGridPane
        final MigPane migPane = VisualMigPaneBuilder.create()
                .add(LabelBuilder.create().id("firstNameLabel").text("First Name").build())
                .add(TextFieldBuilder.create().id("firstNameTextField").text("").build())
                .add(LabelBuilder.create().id("lastNameLabel").text("Last Name").build())
                .add(TextFieldBuilder.create().id("lastNameTextField").text("").build())
                .add(ButtonBuilder.create().id("okButton").text("Ok").onAction(e -> System.out.println("Ok action")).build())
                .add(ButtonBuilder.create().id("cancelButton").text("Cancel").build())
                .columnCstr("[right]        [grow]            ")
                .addCtrlRow("firstNameLabel firstNameTextField")
                .addCtrlRow("lastNameLabel  lastNameTextField ")
                .addCtrlRow("okButton       cancelButton      ")
                .build();



        primaryStage.setScene(new Scene(migPane, 600, 400));

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
