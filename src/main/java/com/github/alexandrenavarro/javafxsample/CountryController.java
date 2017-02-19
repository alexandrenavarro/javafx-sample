package com.github.alexandrenavarro.javafxsample;

import feign.FeignException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import lombok.extern.slf4j.Slf4j;
import org.controlsfx.tools.Borders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tbee.javafx.scene.layout.MigPane;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by anavarro on 08/02/17.
 */
@Component
@Slf4j
public class CountryController {

    private final CountryResource countryResource;
    private final CountryView view;
    private final BottomStatusBarView bottomStatusBarView;
    private final ExecutorService executorService;

    @Inject
    public CountryController(final CountryResource countryResource, final CountryView countryView, final BottomStatusBarView bottomStatusBarView, final ExecutorService executorService) {
        this.countryResource = countryResource;
        this.view = countryView;
        this.bottomStatusBarView = bottomStatusBarView;
        this.executorService = executorService;
    }

    @PostConstruct
    public void initialize() {
        this.view.getButton().setOnAction(e -> {
            search();
        });
    }

    public void search() {
        this.view.getMaskerPane().setVisible(true);
        final Task<List<Country>> task = new Task<List<Country>>() {

            @Override
            protected List<Country> call()  {
                List<Country> countryList;
                try {
                    updateProgress(1, 100);
                    updateMessage("Retrieving Countries ...");
                    Thread.sleep(1000);

                    countryList = (countryResource.findCountries());
                    updateMessage("Countries retrieved.");
                    updateProgress(100, 100);

                } catch (InterruptedException | FeignException e) {
                    log.warn("e:{}", e);
                    updateMessage("Error when retrieving countries.");
                    countryList =  Collections.emptyList();
                }
                return countryList;
            }
        };

        task.setOnSucceeded(e -> {
            CountryController.this.view.getTableView().setItems(FXCollections.observableArrayList(task.getValue()));
            this.view.getMaskerPane().setVisible(false);
        });

        this.bottomStatusBarView.getView().progressProperty().bind(task.progressProperty());
        this.bottomStatusBarView.getView().textProperty().bind(task.messageProperty());

        this.view.getMaskerPane().progressProperty().bind(task.progressProperty());
        this.view.getMaskerPane().textProperty().bind(task.messageProperty());

        executorService.submit(() -> task.run());
    }

    public void search2() {
        final ObservableList<Country> results = FXCollections.observableArrayList();
        this.view.getTableView().setItems(results);
        final Task<Void> task = new Task<Void>() {

            @Override
            protected Void call()  {
                try {
                    updateMessage("Retrieving Countries ...");
                    final List<Country> countryList = countryResource.findCountries();
                    for (int i = 0; i < countryList.size(); i++) {
                        results.add(countryList.get(i));
                        Thread.sleep(1);
                        updateProgress(i, countryList.size() - 1);
                    }
                    updateMessage("Countries retrieved.");
                } catch (InterruptedException | FeignException e) {
                    log.warn("e:{}", e);
                    updateMessage("Error when retrieving countries.");
                }
                return null;
            }
        };


        this.bottomStatusBarView.getView().progressProperty().bind(task.progressProperty());
        this.bottomStatusBarView.getView().textProperty().bind(task.messageProperty());

        executorService.submit(() -> task.run());
    }


}
