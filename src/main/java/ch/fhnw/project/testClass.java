package ch.fhnw.project;


import com.sun.org.apache.xerces.internal.xs.StringList;
import com.sun.tools.javac.util.*;
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
import java.util.List;


public final class testClass extends Application {

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



        /*final NumberAxis xAxis = new NumberAxis(getMinimumOfList(listTestx),getMaximumOfList(listTestx), 0.01);
        final NumberAxis yAxis = new NumberAxis(getMinimumOfList(listTesty),getMaximumOfList(listTesty), 0.01);


        final ScatterChart<Number,Number> sc = new ScatterChart<Number,Number>(xAxis,yAxis);
*/

        NumberAxis xAxis = new NumberAxis(-5,5, 0.1);
        NumberAxis yAxis = new NumberAxis(-5,5, 0.1);
        ScatterChart<Number,Number> sc = new ScatterChart<Number,Number>(xAxis,yAxis);




        //actions
        bt1.setOnAction(actionEvent ->
        {

            xAxis.setLabel(listTestx.get(0));
            yAxis.setLabel(listTesty.get(0));

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

/*    double getMaximumOfList(List<String> list)
    {
      //  List<String> listr =new ArrayList<>();
        List<Double> listd= new ArrayList<>();

        for (String element : list)
        {
            listd.add(Double.parseDouble(element));
        }



        Collections.sort(listd); // Sort the arraylist
       // String test=list.get(list.size() - 1); //gets the last item, largest for an ascending sort
       double test = listd.get(listd.size() - 1);
        System.out.print(test);
        return test;
    }

    double getMinimumOfList(List<String> list)
    {
        //  List<String> listr =new ArrayList<>();
        List<Double> listd= new ArrayList<>();

        for (String element : list)
        {
            listd.add(Double.parseDouble(element));
        }

        Collections.sort(listd); // Sort the arraylist
        // String test=list.get(list.size() - 1); //gets the last item, largest for an ascending sort
        double test = listd.get(listd.size());
        System.out.print(test);
        return test;
    }*/
}



