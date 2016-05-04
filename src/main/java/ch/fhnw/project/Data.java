package ch.fhnw.project;

import javafx.scene.control.Alert;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by FelixYeung on 04.05.16.
 */
public class Data extends App{

    try (Scanner scanner = new Scanner(file)) {

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
}
