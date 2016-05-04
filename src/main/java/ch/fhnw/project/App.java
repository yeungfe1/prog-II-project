package ch.fhnw.project;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBuilder;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.List;


public final class App extends Application {

    @Override
    public void start(Stage stage) {


        //Init Buttons
        Button bt1 = new Button("button1");


        //Init Labels
        Label la1 = new Label("label1");

        FlowPane pane = new FlowPane();

        FileChooser filefc = new FileChooser();

        List<String> serie1 = new ArrayList<>();
        List<String> serie2 = new ArrayList<>();
        List<Double> serie1Number = new ArrayList<>();
        List<Double> serie2Number = new ArrayList<>();

        XYChart.Series series1 = new XYChart.Series();

        String name1, name2;




        File file = filefc.showOpenDialog(stage);

        ChooseData(serie1, serie2, file);

        name1 = serie1.get(0);
        name2 = serie2.get(0);
        serie1.remove(0);
        serie2.remove(0);


        for (String element : serie1){

            serie1Number.add(Double.parseDouble(element));
        }

        for (String element : serie2){

            serie2Number.add(Double.parseDouble(element));
        }
        NumberAxis xAxis = new NumberAxis(getMin(serie1Number),getMax(serie1Number),0);
        NumberAxis yAxis = new NumberAxis(getMin(serie2Number),getMax(serie2Number),0);


        Double maxValue = Collections.max(serie1Number);
        final ScatterChart<Number,Number> sc =
                new ScatterChart<Number,Number>(xAxis,yAxis);



        //actions
        bt1.setOnAction(actionEvent ->
        {
            //pane.setStyle("-fx-background-color: lightblue");

          //  System.out.print(getMax(serie1Number));

            xAxis.setLabel(name1);
            yAxis.setLabel(name2);

            int count =0;
            while ( count < serie1Number.size()) {

                series1.getData().add(new ScatterChart.Data<Number, Number>(serie1Number.get(count), serie2Number.get(count)));
                count++;


            }
            for (Double element : serie1Number){

            }

        });

        sc.getData().addAll(series1);

        sc.setPrefSize(500, 500);




        pane.getChildren().addAll(bt1, /*la1,*/sc);

        Scene scence = new Scene(pane, 800, 800);

        stage.setTitle("App_Project");
        stage.setScene(scence);
        stage.show();
    }

    private void ChooseData(List<String> serie1, List<String> serie2, File file) {
        try (Scanner scanner = new Scanner(file)) {

            while (scanner.hasNext()) {
                scanner.useDelimiter("\t|\n");

                serie1.add(scanner.next());
                serie2.add(scanner.next());
            }

        } catch (FileNotFoundException e) {
           //System.err.println("Reading file failed: " + e.getMessage());

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Reading failed");
            alert.setHeaderText("Look, a Warning Dialog");
            alert.setContentText("Please try again!");

            alert.showAndWait();
        }
    }



    private  Double getMax(List<Double> test)
    {
        Double maxValue;

        maxValue=Collections.max(test);

        return maxValue;
    }

    private  Double getMin(List<Double> test)
    {
        Double maxValue;

        maxValue=Collections.min(test);

        return maxValue;
    }



}

