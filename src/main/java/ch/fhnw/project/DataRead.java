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


public final class DataRead extends Application {

    @Override
    public void start(Stage stage) {


        FileChooser filefc = new FileChooser();

        List<String> toList = new ArrayList<>();
        List<String> serie1 = new ArrayList<>();
        List<String> serie2 = new ArrayList<>();

        List<Double> list = new ArrayList<>();


        File file = filefc.showOpenDialog(stage);


        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                scanner.useDelimiter("\t|\n");


                serie1.add(scanner.next());
                serie2.add(scanner.next());


         //  System.out.print(scanner.next());
            }


        } catch (FileNotFoundException e) {
            System.err.println("Reading file failed: " + e.getMessage());
        }


        for (String element: toList){
            System.out.print(element);
        }





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




