package ch.fhnw.project;



        import javafx.application.Application;

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
            System.out.println(element);
        }
        System.out.println(Collections.max(serie1));

    }


}




