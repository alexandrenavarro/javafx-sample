package com.github.alexandrenavarro.javafxsample.builder;

import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import net.karneim.pojobuilder.GeneratePojoBuilder;

/**
 * Created by anavarro on 19/02/17.
 */
public class ControlFactory {

    @GeneratePojoBuilder(withSetterNamePattern="*", intoPackage="*.builder", withFactoryMethod="create")
    public static Button createButton() {
        return new Button();
    }

    @GeneratePojoBuilder(withSetterNamePattern="*", intoPackage="*.builder", withFactoryMethod="create", withGenerationGap=true)
    public static <S> TableView<S> createTableView() {
        return new TableView<S>();
    }

    @GeneratePojoBuilder(withSetterNamePattern="*", intoPackage="*.builder", withFactoryMethod="create")
    public static <S, T>  TableColumn<S, T>  createTableColumn() {
        return new TableColumn<S, T> ();
    }



}


