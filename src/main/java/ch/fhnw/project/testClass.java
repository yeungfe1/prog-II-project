package ch.fhnw.project;

import javafx.application.Application;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by FelixYeung on 30.04.16.
 */
public final class testClass extends Application {
    @Override
    public void start(Stage stage) {

        FileChooser fc = new FileChooser();
        List<String> listTest =new ArrayList<>();
        List<String> listTestx =new ArrayList<>();
        List<String> listTesty =new ArrayList<>();

        List<Double> listd = new ArrayList<>();

        File file = fc.showOpenDialog(stage);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                listTest.add(scanner.next());
                //System.out.println(scanner.next());
            }
        } catch (FileNotFoundException e) {
            System.err.println("Reading file failed: " + e.getMessage());
        }

        int n = 0;
        for (String element : listTest) {

            if (n % 2 == 0) {
                listTestx.add(listTest.get(n));
                listd.add(Double.parseDouble(listTest.get(n)));
            } else {
                listTesty.add(listTest.get(n));
            }
            n++;
        }


        //  List<String> listr =new ArrayList<>();


      /*  for (String element : listTestx) {

        }*/

      /*  Collections.sort(listd); // Sort the arraylist
        // String test=list.get(list.size() - 1); //gets the last item, largest for an ascending sort
        double test = listd.get(listd.size());
        System.out.print(test);*/

    }
}
