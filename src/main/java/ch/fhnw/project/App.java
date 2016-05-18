package ch.fhnw.project;



import ch.fhnw.project.datenmodell.IdatenFuerDatenmodell;
import ch.fhnw.project.datenmodell.LineOriented;
import ch.fhnw.project.datenmodell.TabDelimited;
import ch.fhnw.project.visualization.Idiagramm;
import ch.fhnw.project.visualization.ScatterPlot;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;


public class App extends Application {


    private Stage stage;
    public static final int X = 0;
    public static final int Y = 1;

    @Override
    public void start(Stage stage)  {

        FileChooser filechooser = new FileChooser();
        File file = filechooser.showOpenDialog(stage);
        String fileNameFormat = file.getAbsolutePath();




        List<String> listGesamt = new ArrayList<>();
        List<String> listXAxisValue = new ArrayList<>();
        List<String> listYAxisValue = new ArrayList<>();

        Button bt1 = new Button("ButtonTest");


        FlowPane pane = new FlowPane();
        NumberAxis xAxis = new NumberAxis();

        NumberAxis yAxis = new NumberAxis();

        //Now Create an instance of the scatterChart using both of axis
        ScatterChart scatterChart=new ScatterChart(xAxis,yAxis);
        scatterChart.setLegendVisible(false);

        XYChart.Series data=new XYChart.Series();



        try {
            Idiagramm scatterPlot = new ScatterPlot(getListVonModell(file));
            xAxis.setLabel(scatterPlot.getXName(X));
            xAxis.setForceZeroInRange(false);
            yAxis.setLabel(scatterPlot.getYName(Y));

            scatterChart.setData(getChartData(file,X,Y));


            for (  Double s : scatterPlot.getXAxis(X)) {
                System.out.println(s);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        pane.getChildren().addAll(bt1, scatterChart);

        Scene scence = new Scene(pane, 800, 800);

        stage.setTitle("App_Project");
        stage.setScene(scence);
        stage.show();
        }


    private ObservableList<XYChart.Series<Double, Double>> getChartData(File file, int xValue, int yValue) throws FileNotFoundException {

        Idiagramm scatterPlot = new ScatterPlot(getListVonModell(file));

        List<Double> listXValue = new ArrayList<>();
        List<Double> listYValue = new ArrayList<>();


        for (Double aDouble : scatterPlot.getXAxis(xValue)) {
            listXValue.add(aDouble);
        }
        for (Double aDouble : scatterPlot.getYAxis(yValue)) {
            listYValue.add(aDouble);
        }



        ObservableList<XYChart.Series<Double, Double>> answer = FXCollections.observableArrayList();
        XYChart.Series<Double, Double> aSeries = new XYChart.Series<Double, Double>();

        aSeries.setName("here name of Axis");

        for (int i = 0; i < scatterPlot.getXAxis(0).size(); i++) {
            aSeries.getData().add(new XYChart.Data(listXValue.get(i),listYValue.get(i)));
        }
        answer.addAll(aSeries);
        return answer;
    }



    public List<String> getListVonModell(File file) throws FileNotFoundException {
        String fileNameFormat= file.getAbsolutePath();
        List<String> list = new ArrayList<>();
        if(fileNameFormat.endsWith(".txt"))
        {
            IdatenFuerDatenmodell datenTest = new TabDelimited(file);
            for (String s : datenTest.getListString()) {
                list.add(s);
            }
        }
        else if(fileNameFormat.endsWith(".lin"))
        {
            IdatenFuerDatenmodell datenTest = new LineOriented(file);
            for (String s : datenTest.getListString()) {
                list.add(s);
        }

        }

        return list;
    }




}

