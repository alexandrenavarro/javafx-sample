package com.github.alexandrenavarro.javafxsample;

import javafx.scene.Node;
import org.controlsfx.control.StatusBar;
import org.springframework.stereotype.Component;

/**
 * Created by anavarro on 19/02/17.
 */
@Component
public class BottomStatusBarView implements View {

    private final StatusBar statusBar = new StatusBar();

    @Override
    public StatusBar getView() {
        return this.statusBar;
    }
}
