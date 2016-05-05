package ch.fhnw.project;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;



import java.io.FileNotFoundException;
import java.util.*;
import java.util.List;


public class App extends Application {


    @Override
    public void start(Stage stage) {



        //Init Buttons
        Button bt1 = new Button("button1");


        //Init Labels

        FlowPane pane = new FlowPane();

        List<String> serie1 = new ArrayList<>();
        List<String> serie2 = new ArrayList<>();

        List<Double> serie1Number = new ArrayList<>();
        List<Double> serie2Number = new ArrayList<>();

        FileChooser filefc = new FileChooser();

        DataRead data = new DataRead(filefc.showOpenDialog(stage));     // Data as object


        XYChart.Series<Number, Number> series1 = new XYChart.Series<>();

        String name1, name2;

        getAxis(serie1, serie2, data);

        name1 = serie1.get(0);
        name2 = serie2.get(0);
        serie1.remove(0);
        serie2.remove(0);

        for(String element: data.getList())
        {
            System.out.print(element);
        }


        for (String element : serie1){

            serie1Number.add(Double.parseDouble(element));
        }

        for (String element : serie2){

            serie2Number.add(Double.parseDouble(element));
        }
        NumberAxis xAxis = new NumberAxis();        //autoscale
        NumberAxis yAxis = new NumberAxis();        //autoscale

        xAxis.setForceZeroInRange(false);

        final ScatterChart<Number,Number> sc = new ScatterChart<>(xAxis, yAxis);



        //actions
        bt1.setOnAction(actionEvent ->
        {
            //pane.setStyle("-fx-background-color: lightblue");

            //  System.out.print(getMax(serie1Number));

            xAxis.setLabel(name1);
            yAxis.setLabel(name2);

            int count =0;
            while ( count < serie1Number.size()) {

                XYChart.Data<Number, Number> point = new ScatterChart.Data<>(serie1Number.get(count), serie2Number.get(count));

                Circle circle = new Circle();
                circle.setFill(Color.BLUE);
                circle.setRadius(4);
                point.setNode(circle);
                series1.getData().add(point);
                count++;
            }



        });


        scatterSetting(series1, sc);

        pane.getChildren().addAll(bt1, /*la1,*/sc);

        Scene scence = new Scene(pane, 800, 800);

        stage.setTitle("App_Project");
        stage.setScene(scence);
        stage.show();
    }

    private void getAxis(List<String> serie1, List<String> serie2, DataRead data) {
        try (Scanner scanner = new Scanner(data.getFile())) {

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


    private void scatterSetting(XYChart.Series<Number, Number> series1, ScatterChart<Number, Number> sc) {
        sc.setLegendVisible(false);
        sc.getData().add(series1);
        sc.setPrefSize(500, 500);
    }

}

