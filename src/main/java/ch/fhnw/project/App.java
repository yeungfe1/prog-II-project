package ch.fhnw.project;



import ch.fhnw.project.datenmodell.TabDelimited;
import javafx.application.Application;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;


public class App extends Application{


    @Override
    public void start(Stage stage)  {



        FileChooser filechooser = new FileChooser();
        File file = filechooser.showOpenDialog(stage);


        TabDelimited data = new TabDelimited(file);

        try {/*
            for (String s : data.getVarNameList()) {
                System.out.print(s);
            }*/
            System.out.print(Collections.max(data.getVarValue()));


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

}

