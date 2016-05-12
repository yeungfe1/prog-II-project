package ch.fhnw.project;



import ch.fhnw.project.datenmodell.IdatenFuerDatenmodell;
import ch.fhnw.project.datenmodell.LineOriented;
import ch.fhnw.project.datenmodell.TabDelimited;
import javafx.application.Application;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


import java.io.File;
import java.io.FileNotFoundException;


public class App extends Application {


    private Stage stage;

    @Override
    public void start(Stage stage)  {

        FileChooser filechooser = new FileChooser();
        File file = filechooser.showOpenDialog(stage);

        IdatenFuerDatenmodell l = new LineOriented(file);
        IdatenFuerDatenmodell l1 = new TabDelimited(file);


        try {
            for (String s : l1.getVarNameList()) {
                System.out.print(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

        //IdatenFuerDatenmodell l = new TabDelimited(stage);


















}

