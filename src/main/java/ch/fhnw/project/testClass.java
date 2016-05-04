package ch.fhnw.project;/**
 * Created by FelixYeung on 05.05.16.
 */

import javafx.scene.control.Alert;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class testClass extends testClass2FX{
    private final File file;

    public testClass(File file) {
        this.file = file;
    }

    public File getFile(){
        return file;
    }

    public List<String> getSerie(int number){


        List<String> serie1 = new ArrayList<>();
        List<String> serie2 = new ArrayList<>();
        try (Scanner scanner = new Scanner(getFile())) {

            while (scanner.hasNext()) {
                scanner.useDelimiter("\t|\n");

                serie1.add(scanner.next());
                serie2.add(scanner.next());
            }

        } catch (FileNotFoundException e) {
            //System.err.println("Reading file failed: " + e.getMessage());

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Reading failed");
            alert.setHeaderText("Look, a Warning Dialog");
            alert.setContentText("Please try again!");

            alert.showAndWait();
        }
        return (number==1?serie1 :serie2);
    }


}
