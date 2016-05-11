package ch.fhnw.project.test1withoutgui;/**
 * Created by FelixYeung on 05.05.16.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

public class testClass2FX extends Application {

    @Override
    public void start(Stage stage) throws FileNotFoundException {

        FlowPane pane = new FlowPane();
        FileChooser fileChooser = new FileChooser();

        HashMap <String,ArrayList> mapTest = new HashMap<>();

        testClass data = new testClass(fileChooser.showOpenDialog(stage));


        /*System.out.println("Anzahl Variabel: " + data.getVarNum());
        System.out.print("mapübergabegrösse: " + data.getMap().size());
*/
        data.testtest();

      /* for(String element : data.getMap().values().iterator())
        {
            System.out.print(element);
        }*/
       // System.out.print(data.getMap().get(0));  geht nicht

        //data.countVar();

        pane.getChildren().addAll();

        Scene scence = new Scene(pane, 800, 800);

        stage.setTitle("App_Project");
        stage.setScene(scence);
        stage.show();
    }


}
