package ch.fhnw.project;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.function.Supplier;

public final class App extends Application {

    @Override
    public void start(Stage stage) {


        Pane pane = new Pane();
               Scene scence = new Scene(pane,300,200);


        stage.setTitle("App_Project");
        stage.setScene(scence);
        stage.show();

    }

}
