package com.github.alexandrenavarro.javafxsample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBuilder;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.tbee.javafx.scene.layout.MigPane;


/**
 * Created by anavarro on 25/12/16.
 */

public class JavaFxAppWithMigPane extends Application
{

    @Override
    public void start(final Stage primaryStage) {

        final MigPane migPane = new MigPane("", "[pref] [grow]");
        migPane.add(new Label("First Name"));
        migPane.add(new TextField(), "wrap");
        migPane.add(new Label("Last Name"));
        migPane.add(new TextField(), "wrap");
        migPane.add(new Button("Ok"));
        migPane.add(new Button("Cancel"));

        primaryStage.setScene(new Scene(migPane, 600, 400));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
