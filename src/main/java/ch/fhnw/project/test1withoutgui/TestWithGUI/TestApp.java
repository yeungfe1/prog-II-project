package ch.fhnw.project;


import ch.fhnw.project.test1withoutgui.DataRead;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;



import java.io.FileNotFoundException;
import java.util.*;
import java.util.List;


public class TestApp extends Application {


    @Override
    public void start(Stage stage) {



        //Init Buttons
        Button bt1 = new Button("button1");
        Button bt2 = new Button("Color");

        final ColorPicker colorPicker = new ColorPicker();
        colorPicker.setValue(Color.CORAL);


        Slider sl1 = new Slider(1, 10,0);




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

        });

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

            sl1.valueProperty().addListener((observableValue, oldValue, newValue) ->
            {
                circle.setRadius(sl1.getValue());
            });
        }


/*

        colorPicker.setOnAction(new EventHandler() {
            public void handle(Event t) {
                circle.setFill(colorPicker.getValue());
            }
        });
*/




        scatterSetting(series1, sc);

        pane.getChildren().addAll(bt1, /*la1,*/sc, sl1,colorPicker);

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

