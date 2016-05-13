package ch.fhnw.project;



import ch.fhnw.project.datenmodell.IdatenFuerDatenmodell;
import ch.fhnw.project.datenmodell.LineOriented;
import ch.fhnw.project.datenmodell.TabDelimited;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;


public class App extends Application {


    private Stage stage;



    @Override
    public void start(Stage stage)  {

        FileChooser filechooser = new FileChooser();
        File file = filechooser.showOpenDialog(stage);
        String fileNameFormat = file.getAbsolutePath();

        List<String> listGesamt = new ArrayList<>();
        List<String> listXAxisValue = new ArrayList<>();
        List<String> listYAxisValue = new ArrayList<>();

        Button bt1 = new Button("ButtonTest");


        FlowPane pane = new FlowPane();


        try {

           // getListVonModell(file);
            for (String s : getListVonModell(file)) {
                System.out.println(s);
            }



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        pane.getChildren().addAll(bt1);

        Scene scence = new Scene(pane, 800, 800);

        stage.setTitle("App_Project");
        stage.setScene(scence);
        stage.show();
        }





    private List<String> getListVonModell(File file) throws FileNotFoundException {
        String fileNameFormat= file.getAbsolutePath();
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

