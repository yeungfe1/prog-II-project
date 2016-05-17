package ch.fhnw.project.test1withoutgui.TestWithGUI;/**
 * Created by FelixYeung on 17.05.16.
 */

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TestBarChart extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        BarChart barChart = new BarChart(xAxis, yAxis);
        barChart.setData(getChartData());
        barChart.setTitle("A");
        primaryStage.setTitle("BarChart example");

        barChart.setBarGap(0);
        barChart.setCategoryGap(0);
        barChart.setLegendVisible(false);
        barChart.setHorizontalZeroLineVisible(false);
        barChart.setVerticalZeroLineVisible(false);
        barChart.getYAxis().setTickLabelsVisible(false);
        barChart.getYAxis().setOpacity(0);
        barChart.getXAxis().setTickLabelsVisible(false);
        barChart.getXAxis().setOpacity(0);

        StackPane root = new StackPane();
        root.getChildren().add(barChart);
        primaryStage.setScene(new Scene(root, 400, 250));
        primaryStage.show();
    }

    private ObservableList<XYChart.Series<String, Double>> getChartData() {
        double aValue = 17.56;
        ObservableList<XYChart.Series<String, Double>> answer = FXCollections.observableArrayList();
        XYChart.Series<String, Double> aSeries = new XYChart.Series<String, Double>();

        aSeries.setName("here name of Axis");


        for (int i = 0; i < 10; i++) {
            aSeries.getData().add(new XYChart.Data(Integer.toString(i), aValue));
            aValue = aValue + Math.random() - .5;
        }
        answer.addAll(aSeries);
        return answer;
    }
}


