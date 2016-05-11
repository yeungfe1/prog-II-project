package ch.fhnw.project;



import ch.fhnw.project.datenmodell.TabDelimitedFormat;
import javafx.application.Application;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


import java.io.File;
import java.io.FileNotFoundException;


public class App extends Application {


    @Override
    public void start(Stage stage)  {

        FileChooser filechooser = new FileChooser();
        File file = filechooser.showOpenDialog(stage);


        TabDelimitedFormat data = new TabDelimitedFormat(file);

        try {
            for (String s : data.getVarNameList()) {
                System.out.print(s);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

}

