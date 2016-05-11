package ch.fhnw.project;/**
 * Created by FelixYeung on 05.05.16.
 */

import javafx.scene.control.Alert;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestDataRead {

    private final File file;

    public TestDataRead(File file) {
        this.file = file;
    }


    public File getFile(){
        return file;
    }

    public List<String> getList(){


        List<String> serie = new ArrayList<>();

        try (Scanner scanner = new Scanner(getFile())) {

            while (scanner.hasNext()) {
                scanner.useDelimiter("\t|\n");

                serie.add(scanner.next());
            }

            //have to implement into JAVAFX!!!!!!!!!!!!!
        } catch (FileNotFoundException e) {
            //System.err.println("Reading file failed: " + e.getMessage());

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Reading failed");
            alert.setHeaderText("Look, a Warning Dialog");
            alert.setContentText("Please try again!");

            alert.showAndWait();
        }
        return serie;
    }






}
