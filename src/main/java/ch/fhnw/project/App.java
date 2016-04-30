package ch.fhnw.project;


import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Light;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public final class App extends Application {






    @Override
    public void start(Stage stage) {


        //Init Buttons
        Button bt1 = new Button("button1");


        //Init Labels
        Label la1 = new Label("label1");

        FlowPane pane = new FlowPane();

        FileChooser fc = new FileChooser();

        List<String> listTest =new ArrayList<>();
        List<String> listTestx =new ArrayList<>();
        List<String> listTesty =new ArrayList<>();

        XYChart.Series series1 = new XYChart.Series();
        //series1.setName("series");
       /* series1.getData().add(new XYChart.Data(4.2, 193.2));
        series1.getData().add(new XYChart.Data(2.8, 33.6));
        series1.getData().add(new XYChart.Data(6.2, 24.8));
        series1.getData().add(new XYChart.Data(1, 14));
        series1.getData().add(new XYChart.Data(1.2, 26.4));
        series1.getData().add(new XYChart.Data(4.4, 114.4));
        series1.getData().add(new XYChart.Data(8.5, 323));
        series1.getData().add(new XYChart.Data(6.9, 289.8));
        series1.getData().add(new XYChart.Data(9.9, 287.1));
        series1.getData().add(new XYChart.Data(0.9, -9));
        series1.getData().add(new XYChart.Data(3.2, 150.8));
        series1.getData().add(new XYChart.Data(4.8, 20.8));
        series1.getData().add(new XYChart.Data(7.3, -42.3));
        series1.getData().add(new XYChart.Data(1.8, 81.4));
        series1.getData().add(new XYChart.Data(7.3, 110.3));
        series1.getData().add(new XYChart.Data(2.7, 41.2));*/


        /*final NumberAxis xAxis = new NumberAxis(listTestx.indexOf(Collections.min(listTestx)), listTestx.indexOf(Collections.max(listTestx)), 0.1);
        final NumberAxis yAxis = new NumberAxis(listTestx.indexOf(Collections.min(listTesty)), listTestx.indexOf(Collections.max(listTesty)), 0.1);
        final ScatterChart<Number,Number> sc = new ScatterChart<Number,Number>(xAxis,yAxis);*/

        NumberAxis xAxis = new NumberAxis(-5,5, 0.1);
        NumberAxis yAxis = new NumberAxis(-5,5, 0.1);
        ScatterChart<Number,Number> sc = new ScatterChart<Number,Number>(xAxis,yAxis);




        //actions
        bt1.setOnAction(actionEvent ->
        {
            pane.setStyle("-fx-background-color: lightblue");
            //Test FileChooser!
            File file = fc.showOpenDialog(stage);

            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNext()) {
                    listTest.add(scanner.next());
                    //System.out.println(scanner.next());
                }
            } catch (FileNotFoundException e) {
                System.err.println("Reading file failed: " + e.getMessage());
            }

            int n=0;

            for (String element : listTest) {

                if(n%2 == 0 ) {
                    listTestx.add(listTest.get(n));
                }else {
                    listTesty.add(listTest.get(n));
                }
                n++;
          }


            xAxis.setLabel(listTestx.get(0));
            yAxis.setLabel(listTesty.get(0));
            //sc.setTitle("title");

            int count=1;    //without name
            while (count <listTestx.size()){
                series1.getData().add(new XYChart.Data(Double.parseDouble(listTestx.get(count)), Double.parseDouble(listTesty.get(count))));
                count++;
            }


        });

        sc.getData().addAll(series1);
        //get all features
        pane.getChildren().addAll(bt1, la1,sc);


        Scene scence = new Scene(pane, 500, 500);


        stage.setTitle("App_Project");
        stage.setScene(scence);
        stage.show();

    }
}



