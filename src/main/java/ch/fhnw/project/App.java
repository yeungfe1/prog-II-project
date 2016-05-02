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

        FileChooser filefc = new FileChooser();

        List<String> serie1 = new ArrayList<>();
        List<String> serie2 = new ArrayList<>();
        List<Double> serie1Number = new ArrayList<>();
        List<Double> serie2Number = new ArrayList<>();

        String name1, name2;


        XYChart.Series series1 = new XYChart.Series();
        List<Double> list = new ArrayList<>();



        File file = filefc.showOpenDialog(stage);
        ChooseData(serie1, serie2, file);



        name1 = serie1.get(0);
        name2 = serie2.get(0);
        serie1.remove(0);
        serie2.remove(0);

        System.out.print(name1);

        for (String element : serie1){

            serie1Number.add(Double.parseDouble(element));
        }

        Collections.sort(serie1Number);
        Collections.sort(serie2Number);

        Double maxValue = Collections.max(serie1Number);


        //actions
        bt1.setOnAction(actionEvent ->
        {
            pane.setStyle("-fx-background-color: lightblue");

            System.out.print(getMax(serie1Number));


        });


        pane.getChildren().addAll(bt1, la1);


        Scene scence = new Scene(pane, 500, 500);


        stage.setTitle("App_Project");
        stage.setScene(scence);
        stage.show();

    }

    private void ChooseData(List<String> serie1, List<String> serie2, File file) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                scanner.useDelimiter("\t|\n");


                serie1.add(scanner.next());
                serie2.add(scanner.next());

            }

        } catch (FileNotFoundException e) {
            System.err.println("Reading file failed: " + e.getMessage());
        }
    }


    private  Double getMax(List<Double> test)
    {
        Double maxValue;

        maxValue=Collections.max(test);

        return maxValue;
    }

}

//

