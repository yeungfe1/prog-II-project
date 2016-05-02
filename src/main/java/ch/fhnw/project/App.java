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


        FileChooser filefc = new FileChooser();

        List<String> toList = new ArrayList<>();
        List<String> serie1 = new ArrayList<>();
        List<String> serie2 = new ArrayList<>();
        List<Double> serie1Number = new ArrayList<>();
        List<Double> serie2Number = new ArrayList<>();

        List<Double> list = new ArrayList<>();


        File file = filefc.showOpenDialog(stage);


        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                scanner.useDelimiter("\t|\n");


                serie1.add(scanner.next());
                serie2.add(scanner.next());

            }

        } catch (FileNotFoundException e) {
            System.err.println("Reading file failed: " + e.getMessage());
        }

        serie1.remove(0);
        serie2.remove(0);

        for (String element : serie1){

            serie1Number.add(Double.parseDouble(element));
        }

        Collections.sort(serie1Number);

        for(Double element : serie1Number){
            //System.out.println(element);
        }
        //System.out.println(getMax(serie1Number));
       /* File file = fc.showOpenDialog(stage);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                listTest.add(scanner.next());
                //System.out.println(scanner.next());
            }
        } catch (FileNotFoundException e) {
            System.err.println("Reading file failed: " + e.getMessage());
        }*/






        //actions
        bt1.setOnAction(actionEvent ->
        {
            pane.setStyle("-fx-background-color: lightblue");
            //Test FileChooser!

            System.out.print(DataRead.getMax())


        });


        pane.getChildren().addAll(bt1, la1);


        Scene scence = new Scene(pane, 500, 500);


        stage.setTitle("App_Project");
        stage.setScene(scence);
        stage.show();

    }

}



