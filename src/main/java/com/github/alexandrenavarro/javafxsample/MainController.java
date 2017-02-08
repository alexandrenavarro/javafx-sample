package com.github.alexandrenavarro.javafxsample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tbee.javafx.scene.layout.MigPane;

import javax.annotation.PostConstruct;

/**
 * Created by anavarro on 08/02/17.
 */
@Component
@Slf4j
public class MainController {

    private final MenuBar menuBar;

    @Autowired
    public MainController(final CountryController countryController) {
        menuBar = new MenuBar();
        final Menu referentialMenu = new Menu("Referential");
        final MenuItem countryMenuItem = new MenuItem("Country");
        countryMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                log.info("click on country");

            }
        });
        referentialMenu.getItems().add(countryMenuItem);
        menuBar.getMenus().addAll(referentialMenu);

    }

    public MenuBar getView() {
        return menuBar;
    }


}
