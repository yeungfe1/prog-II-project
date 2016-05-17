package javafxtuts;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author JavaFXtuts.com
 */
public class ScatterPlot extends Application {

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        //Create two axis for line Chart using NumberAxis constructor
        //Here we use an empty Constructor so it set auto ranging of axis line
        NumberAxis xAxis = new NumberAxis();
        xAxis.setLabel("x");
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("y");
        //Now Create an instance of the scatterChart using both of axis
        ScatterChart scatterChart=new ScatterChart(xAxis,yAxis);


        scatterChart.setLegendVisible(false);


        // Now Here we create a series of data using the XYChart.Series Class
        XYChart.Series data=new XYChart.Series();
        data.setName("CAR");

        // Now Creating data value using XYChart.Data Class

        data.getData().add(new XYChart.Data(1,12));
        data.getData().add(new XYChart.Data(2,10));
        data.getData().add(new XYChart.Data(3,9.2));
        data.getData().add(new XYChart.Data(4,8.6));
        data.getData().add(new XYChart.Data(5,8));
        data.getData().add(new XYChart.Data(6,7));
        data.getData().add(new XYChart.Data(7,6));
        data.getData().add(new XYChart.Data(8,5));


        scatterChart.getData().addAll(data);




        root.getChildren().add(scatterChart);
        Scene scene = new Scene(root, 450, 450);

        primaryStage.setTitle("javafxtuts.com");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}