package com.github.alexandrenavarro.javafxsample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.SceneBuilder;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.layout.VBoxBuilder;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.tbee.javafx.scene.layout.MigPane;


/**
 * Created by anavarro on 25/12/16.
 */

@SpringBootApplication
@EnableFeignClients(basePackageClasses = {CountryResource.class})
public class JavaFxApp extends Application {

    private ConfigurableApplicationContext applicationContext;


    @Override
    public void init() throws Exception {
        applicationContext = SpringApplication.run(getClass());
        applicationContext.getAutowireCapableBeanFactory().autowireBean(this);
    }

    @Override
    public void start(final Stage stage) {
        final CountryController countryController = applicationContext.getBean(CountryController.class);
        final CurrencyController currencyController = applicationContext.getBean(CurrencyController.class);
        final MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(
                MenuBuilder.create().text("Referential").items(
                        MenuItemBuilder.create().text("Country").onAction(actionEvent -> {
                            ((VBox) stage.getScene().getRoot()).getChildren().clear();
                            ((VBox) stage.getScene().getRoot()).getChildren().addAll(menuBar, countryController.getView());
                        }).build(),
                        MenuItemBuilder.create().text("Currency").onAction(actionEvent -> {
                            ((VBox) stage.getScene().getRoot()).getChildren().clear();
                            ((VBox) stage.getScene().getRoot()).getChildren().addAll(menuBar, currencyController.getView());
                        }).build()
                ).build()
        );


        stage.setScene(SceneBuilder.create()
                .root(VBoxBuilder.create().children(menuBar).build()).width(600).height(400).build());
        stage.show();

    }


    @Override
    public void stop() throws Exception {
        applicationContext.close();
    }

    public static void main(String[] args) {
        launch(args);
    }

}