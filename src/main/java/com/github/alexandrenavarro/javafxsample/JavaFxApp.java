package com.github.alexandrenavarro.javafxsample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.SceneBuilder;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;
import org.controlsfx.control.StatusBar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;


/**
 * Created by anavarro on 25/12/16.
 */

@SpringBootApplication
@EnableFeignClients(basePackageClasses = {CountryResource.class})
@Slf4j
public class JavaFxApp extends Application {

    private ConfigurableApplicationContext applicationContext;
    private static String[] args;

    @Autowired
    private CountryController countryController;

    @Autowired
    private CurrencyController currencyController;

    @Override
    public void init() throws Exception {
        this.applicationContext = SpringApplication.run(getClass(), args);
        this.applicationContext.getAutowireCapableBeanFactory().autowireBean(this);
    }

    @Override
    public void start(final Stage stage) {
        setUserAgentStylesheet(STYLESHEET_MODENA);
        final StatusBar statusBar = new StatusBar();
        statusBar.setText("Nothing in progress");
        statusBar.setProgress(1);
        stage.setScene(SceneBuilder.create()
                .root(BorderPaneBuilder.create()
                        .top(HBoxBuilder.create()
                                .children(
                                        LabelBuilder.create()
                                                .text("Sales").build(),
                                        TextFieldBuilder.create().build(),
                                        LabelBuilder.create()
                                                .text("Trader").build(),
                                        TextFieldBuilder.create().build())
                                .alignment(Pos.BASELINE_RIGHT).build())
                        .left(AccordionBuilder.create()
                                .panes(
                                        TitledPaneBuilder.create()
                                                .text("Referential")
                                                .content(VBoxBuilder.create()
                                                        .children(
                                                                LabelBuilder.create()
                                                                        .text("Currency")
                                                                        .onMouseClicked(e -> {
                                                                            ((BorderPane) stage.getScene().getRoot()).setCenter(currencyController.getView());
                                                                        }).build(),
                                                                LabelBuilder.create()
                                                                        .text("Country")
                                                                        .onMouseClicked(e -> {
                                                                            ((BorderPane) stage.getScene().getRoot()).setCenter(countryController.getView());
                                                                        }).build()
                                                        ).build()).build(),
                                        TitledPaneBuilder.create()
                                                .text("Referential2")
                                                .onMouseClicked(e -> {
                                                    ((BorderPane) stage.getScene().getRoot()).setCenter(countryController.getView());
                                                }).build()).build())
                        .bottom(statusBar)
                        .build())
                .width(800)
                .height(600).build());
        stage.show();


        // menu like web
        // skins
    }


    @Override
    public void stop() throws Exception {
        this.applicationContext.close();
    }

    public static void main(String[] anArgs) {
        args = anArgs;
        launch(args);
    }

}
