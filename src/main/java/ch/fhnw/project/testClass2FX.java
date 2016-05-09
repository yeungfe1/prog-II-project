package ch.fhnw.project;/**
 * Created by FelixYeung on 05.05.16.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class testClass2FX extends Application {

    @Override
    public void start(Stage stage) throws FileNotFoundException {

        FlowPane pane = new FlowPane();
        FileChooser fileChooser = new FileChooser();

        HashMap <String,ArrayList> mapTest = new HashMap<>();


        testClass data = new testClass(fileChooser.showOpenDialog(stage));

        System.out.print(data.getVarnum());
      /* for(String element : data.getMap().values().iterator())
        {
            System.out.print(element);
        }*/
       // System.out.print(data.getMap().get(0));  geht nicht





        //data.countVar();



        pane.getChildren().addAll();

        Scene scence = new Scene(pane, 800, 800);

        stage.setTitle("App_Project");
        stage.setScene(scence);
        stage.show();
    }


}
