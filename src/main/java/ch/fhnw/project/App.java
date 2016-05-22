package ch.fhnw.project;

import ch.fhnw.project.datenmodell.DataModel;
import ch.fhnw.project.io.*;
import com.sun.tools.internal.xjc.generator.util.WhitespaceNormalizer;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLClientInfoException;
import java.util.*;

import static com.sun.java.accessibility.util.AWTEventMonitor.addComponentListener;
import static java.lang.StrictMath.ceil;

public class App extends Application {

    NumberAxis scxAxis = new NumberAxis();
    NumberAxis scyAxis = new NumberAxis();

    NumberAxis linexAxis = new NumberAxis();
    NumberAxis lineyAxis = new NumberAxis();

    StackPane root = new StackPane();
    LineChart<Number, Number> lineChart ;
    @Override
    public void start(Stage stage) {
        StackPane pane = new StackPane();

        FileChooser filechooser = new FileChooser();
        File file = filechooser.showOpenDialog(stage);
        //File file = new File("bin/helvetia.txt");
        //	File file = new File("bin/temperatur-basel-all.txt");

        FileParser fp;
        try {

            fp = getData(file);
            fp.readData(file);
            Label label;

            if(file.exists()){
                label = new Label("Found");
            }
            else {
                label = new Label("NA");
            }



            CheckBox checkbox = new CheckBox("Line");
            checkbox.selectedProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                    lineChart.setVisible(newValue);

                    root.requestLayout();
                }
            });


            ChoiceBox cb = new ChoiceBox();
            cb.setItems(FXCollections.observableArrayList(
                    "1","2","3","4")
            );

            ChoiceBox cb2 = new ChoiceBox();
            cb2.setItems(FXCollections.observableArrayList(
                    "1", "2 ", "3", "4")
            );





            lineChart = new LineChart<>(linexAxis, lineyAxis);

            lineChart.setLegendVisible(false);
            lineChart.setAnimated(false);
            lineChart.setCreateSymbols(true);
            lineChart.setAlternativeRowFillVisible(false);
            lineChart.setAlternativeColumnFillVisible(false);
            //lineChart.setHorizontalGridLinesVisible(false);
            //lineChart.setVerticalGridLinesVisible(false);
            lineChart.getXAxis().setVisible(false);
            lineChart.getYAxis().setVisible(false);
            lineChart.setAxisSortingPolicy(LineChart.SortingPolicy.NONE);
//            lineChart.getStylesheets().addAll(getClass().getResource("chart.css").toExternalForm());

            lineChart.setVisible(checkbox.isSelected());


            ScatterChart<Number, Number> sc = getScatterChart(file, fp);




            lineChart.getData().addAll(createChartData(fp.getList()));




            CategoryAxis xAxis = new CategoryAxis();
            NumberAxis yAxis = new NumberAxis();
            BarChart barChart = new BarChart(xAxis, yAxis);
            barChart.setData(createBarChartData(fp.getList(),0));
            barChart.setLegendVisible(true);
            xAxis.setTickLabelsVisible(false);
            barChart.setBarGap(0);
            barChart.setCategoryGap(0);
            barChart.setCategoryGap(0);
            barChart.prefWidth(1000);






            CategoryAxis xAxis2 = new CategoryAxis();
            NumberAxis yAxis2 = new NumberAxis();
            BarChart barChart2 = new BarChart(xAxis2, yAxis2);
            barChart2.setData(createBarChartData(fp.getList(),1));
            barChart2.setLegendVisible(true);
            xAxis2.setTickLabelsVisible(false);
            barChart2.setBarGap(0);
            barChart2.setCategoryGap(0);
            barChart2.prefWidth(1000);

            HBox firstLine = new HBox();
            firstLine.getChildren().addAll(cb,cb2, label,checkbox);
            firstLine.setAlignment(Pos.CENTER);
            firstLine.setSpacing(10);
            firstLine.setPadding(new Insets(5, 5, 5, 5));


            HBox scatterChartLine = new HBox();
            scatterChartLine.getChildren().addAll(barChart, barChart2);
            scatterChartLine.setSpacing(1);
            scatterChartLine.setPadding(new Insets(5, 5, 5, 5));

/*
			HBox histogramLine = new HBox();
			histogramLine.getChildren().addAll();
			histogramLine.setAlignment(Pos.CENTER);
			histogramLine.setSpacing(10);
			histogramLine.setPadding(new Insets(5, 5, 5, 5));
*/

            root = new StackPane();


            root.getChildren().addAll(sc, lineChart);



            System.out.println(sc.getData().get(0).getData());
            System.out.println(lineChart.getData().get(0).getData());
            VBox vBox = new VBox();
            //vBox.getChildren().addAll(firstLine,scatterChartLine,histogramLine);
            vBox.getChildren().addAll(firstLine,root,scatterChartLine);
            vBox.setAlignment(Pos.CENTER);
            vBox.setSpacing(10);
            vBox.setPadding(new Insets(5, 5, 5, 5));



            pane.getChildren().add(vBox);

            Scene scene = new Scene(pane, 800, 800);

            stage.setScene(scene);
            stage.setTitle("Hello JavaFX!");
            stage.show();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

    private ScatterChart<Number, Number> getScatterChart(File file, FileParser fp) {
        ScatterChart<Number,Number> sc = new ScatterChart<>(scxAxis,scyAxis);

        /*sc.setTitle(file.getName());
        lineChart.setTitle(file.getName());*/
        sc.setPrefSize(1000,600);
        sc.setLegendVisible(false);
        sc.getData().addAll(createChartData(fp.getList()));
        return sc;
    }

    public FileParser getData(File file) throws FileNotFoundException {
        String fileNameFormat = file.getAbsolutePath();
        FileParser fp;
        if (fileNameFormat.endsWith(".txt")) {

            return new TabDelimited();

        } else if (fileNameFormat.endsWith(".lin")) {

            return new LineOriented();
        }

        return null;
    }

    private Series<Number, Number> createChartData(List<DataModel> lst) {
        XYChart.Series<Number, Number> series1 =  new XYChart.Series<>();
        series1 = new XYChart.Series<>();

        if(lst.size() == 2){
            DataModel dm1 = lst.get(0);
            DataModel dm2 = lst.get(1);
            if(!(dm1.getValues().size() == dm2.getValues().size())){
                System.out.println("ERROR");
            }
            else{
                System.out.println("OK");
                scxAxis.setLabel(dm1.getName());
                scyAxis.setLabel(dm2.getName());
                linexAxis.setLabel(dm1.getName());
                lineyAxis.setLabel(dm2.getName());

                for (int i = 0 ; i < dm1.getValues().size(); i++){
                    series1.getData().add(new XYChart.Data<Number, Number> (dm1.getValue(i), dm2.getValue(i)));

                }
                return series1;
            }

        }
        else {
            //TODO for more Var.
        }
        System.out.println("ERROR");
        return null;
    }

    private ObservableList<Series<String, Double>> createBarChartData(List<DataModel> lst, int select) {

        ObservableList<Series<String, Double>> answer = FXCollections.observableArrayList();
        Series<String, Double> aSeries = new Series<String, Double>();

        DataModel dm1 = lst.get(select);

        aSeries.setName(dm1.getName());

        Double max = Collections.max(dm1.getValues());
        Double min = Collections.min((dm1.getValues()));
        double range = ceil(Math.sqrt(dm1.getValues().size()));
        double width = Math.abs((max-min)/range);
        int n=0;
        int count = 0;
        int testCount =0;
        for (int i = 0; i < range; i++) {
            for (int m = 0 ; m < dm1.getValues().size(); m++){

                if(min+width*i<=dm1.getValue(m) && min+width*(i+1)>=dm1.getValue(m)){
                    count++;
                }
            }
            n++;

            System.out.println(count);
            aSeries.getData().add(new XYChart.Data(Integer.toString(i), count));
            testCount+=count;
            count=0;
        }
        System.out.println(dm1.getValues().size());
        System.out.println("range:" +range);
        System.out.println("count:" +testCount);
        answer.addAll(aSeries);

        return answer;
    }




    public static void main(String[] args){
        launch(args);
    }


}
