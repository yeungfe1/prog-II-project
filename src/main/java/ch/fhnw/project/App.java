package ch.fhnw.project;



import ch.fhnw.project.datenmodell.IdatenFuerDatenmodell;
import ch.fhnw.project.datenmodell.LineOriented;
import ch.fhnw.project.datenmodell.TabDelimited;
import javafx.application.Application;
import javafx.scene.chart.BarChart;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.spi.FileTypeDetector;
import java.util.ArrayList;
import java.util.List;


public class App extends Application {


    private Stage stage;

    @Override
    public void start(Stage stage)  {

        FileChooser filechooser = new FileChooser();
        File file = filechooser.showOpenDialog(stage);
        
        String fileNameFormat = file.getAbsolutePath();



        try {


            for (String s : ueberpruefungFormat(file, fileNameFormat)) {
                System.out.println(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

    private List<String> ueberpruefungFormat(File file, String fileNameFormat) throws FileNotFoundException {
        String filetest = file.getAbsolutePath();
        List<String> list = new ArrayList<>();

        if(fileNameFormat.endsWith(".txt"))
        {
            IdatenFuerDatenmodell datenTest = new TabDelimited(file);
            for (String s : datenTest.getListString()) {
                list.add(s);
            }
        }
        else if(fileNameFormat.endsWith(".lin"))
        {
            IdatenFuerDatenmodell datenTest = new LineOriented(file);
            for (String s : datenTest.getListString()) {
                list.add(s);
        }
    }
        return list;

}

        //IdatenFuerDatenmodell l = new TabDelimited(stage);


}

