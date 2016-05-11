package ch.fhnw.project;

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

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * Created by RicK on 05.05.2016.
 */

public class readIn_linData extends Application {

    @Override
    public void start(Stage stage) {

        //Init Buttons

        Button bt1 = new Button("button1");


        //Init Labels

        Label la1 = new Label("label1");

        FlowPane pane = new FlowPane();

        FileChooser filefc = new FileChooser();

        List<Integer> list = new ArrayList<>();
        List<String> variable1 = new ArrayList<>();
        List<String> variable2 = new ArrayList<>();
        List<Double> line1Number = new ArrayList<>();
        List<Double> line2Number = new ArrayList<>();

        XYChart.Series<Number, Number> series1 = new XYChart.Series<>();

        File file = filefc.showOpenDialog(stage);

        ChooseData(variable1, variable2, file);

        String name1, name2;

        name1 = variable1.get(2);
        name2 = variable2.get(3);
        line1Number.remove(String element:);
        line2Number.remove(0);

        for (String element : variable1) {

            line1Number.add(Double.parseDouble(element));
        }

        for (String element : variable2) {

            line2Number.add(Double.parseDouble(element));
        }
        NumberAxis xAxis = new NumberAxis(/*getMin(serie1Number),getMax(serie1Number),0*/);
        NumberAxis yAxis = new NumberAxis(/*getMin(serie2Number),getMax(serie2Number),0*/);

        xAxis.setForceZeroInRange(false);


        Double maxValue = Collections.max(line1Number);
        final ScatterChart<Number, Number> sc = new ScatterChart<>(xAxis, yAxis);

        //actions

        bt1.setOnAction(actionEvent ->
        {
            //pane.setStyle("-fx-background-color: lightblue");

            //  System.out.print(getMax(serie1Number));

            xAxis.setLabel(name1);
            yAxis.setLabel(name2);

            int count = 0;
            while (count < line1Number.size()) {

                XYChart.Data<Number, Number> point = new ScatterChart.Data<>(line1Number.get(count), line2Number.get(count));

                Circle circle = new Circle();
                circle.setFill(Color.BLUE);
                circle.setRadius(15);
                point.setNode(circle);
                series1.getData().add(point);
                count++;
            }

        });
        sc.setLegendVisible(false);

        sc.getData().add(series1);

        sc.setPrefSize(500, 500);


        pane.getChildren().addAll(bt1, /*la1,*/sc);

        Scene scence = new Scene(pane, 800, 800);

        stage.setTitle("App_Project");
        stage.setScene(scence);
        stage.show();
    }

    //how to choose data

    private void ChooseData(File file) {

        /*try (Stream<String> stream = Files.lines(Paths.get(String.valueOf(file)))) {
            // 1. filter line 0 : 3
            // 2. convert all content to upper case
            // 3. convert it into a List

            list = stream
                    .filter(0);
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        List<String> list = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(get.file());

        }




    }

    private String prependNumberToSingleLine(int lineNumber, String line) {

        StringBuilder prefixedOutput = new StringBuilder();

        return prefixedOutput.append(String.format("/* %d */ ", lineNumber)).append(line).toString();
    }

    private String prependNumbersToAllLines(File file) throws IOException {

        Scanner inputscanner = new Scanner(file);
        StringBuilder prefixedOutput = new StringBuilder();

        int lineNumber = 0;

        while (inputscanner.hasNextLine()) {
            lineNumber++;
            String prefixedLine = prependNumberToSingleLine(lineNumber, inputscanner.nextLine());
            prefixedOutput.append(prefixedLine).append("\n");
        }
        return prefixedOutput.toString();
    }

}