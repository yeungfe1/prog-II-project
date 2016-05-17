package ch.fhnw.project;



import ch.fhnw.project.datenmodell.IdatenFuerDatenmodell;
import ch.fhnw.project.datenmodell.LineOriented;
import ch.fhnw.project.datenmodell.TabDelimited;
import ch.fhnw.project.visualization.Idiagramm;
import ch.fhnw.project.visualization.ScatterPlot;
import javafx.application.Application;
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
        xAxis.setLabel("x");
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("y");
        //Now Create an instance of the scatterChart using both of axis
        ScatterChart scatterChart=new ScatterChart(xAxis,yAxis);
        scatterChart.setLegendVisible(false);


        XYChart.Series data=new XYChart.Series();
        data.setName("CAR");
        try {

            data.getData().add(new XYChart.Data(1,12));
            data.getData().add(new XYChart.Data(2,10));
            data.getData().add(new XYChart.Data(3,9.2));
            data.getData().add(new XYChart.Data(4,8.6));
            data.getData().add(new XYChart.Data(5,8));
            data.getData().add(new XYChart.Data(6,7));
            data.getData().add(new XYChart.Data(7,6));
            data.getData().add(new XYChart.Data(8,5));


            scatterChart.getData().addAll(data);





            // Now Here we create a series of data using the XYChart.Series Class


           // getListVonModell(file);

         /*   for (String s : getListVonModell(file)) {
                System.out.println(s);
            }
         */   Idiagramm test2 = new ScatterPlot(getListVonModell(file));

            for (  Double s : test2.getXAxis(1)) {
                System.out.println(s);
            }

           // System.out.print(test2.getXName());





        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        pane.getChildren().addAll(bt1, scatterChart);

        Scene scence = new Scene(pane, 800, 800);

        stage.setTitle("App_Project");
        stage.setScene(scence);
        stage.show();
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

        //IdatenFuerDatenmodell l = new TabDelimited(stage);


}

